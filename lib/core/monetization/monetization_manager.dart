import 'dart:async';
import 'package:flutter/material.dart';
import 'frequency_manager.dart';
import 'interstitial_ad_manager.dart';
import 'monetization_analytics.dart';
import 'monetization_config.dart';
import 'monetization_events.dart';
import 'monetization_platform.dart';
import 'reward_animation_service.dart';
import 'rewarded_ad_manager.dart';
import 'shared_counter_service.dart';

export 'monetization_config.dart';
export 'monetization_events.dart';
export 'monetization_platform.dart' show ConsentResult;
export 'reward_animation_service.dart';

/// Central Monetization Facade for Cyber Ninja Runner.
///
/// Decouples all game screens, overlays, and economy systems from native ad mediation.
class MonetizationManager {
  static final MonetizationManager _instance = MonetizationManager._internal();
  factory MonetizationManager() => _instance;
  MonetizationManager._internal();

  final SharedCounterService _counter = SharedCounterService();
  final MonetizationPlatform _platform = MonetizationPlatform();
  final RewardedAdManager _rewarded = RewardedAdManager();
  final InterstitialAdManager _interstitial = InterstitialAdManager();
  final FrequencyManager _frequency = FrequencyManager();
  final RewardAnimationService _animations = RewardAnimationService();

  bool _isInitialized = false;
  bool get isInitialized => _isInitialized;

  ConsentResult? _consentResult;
  ConsentResult? get consentResult => _consentResult;
  bool get canRequestAds => _consentResult?.canRequestAds ?? true;
  bool get isPrivacyOptionsRequired =>
      _consentResult?.isPrivacyOptionsRequired ?? false;

  /// Re-opens the official Google UMP privacy options form.
  Future<bool> showPrivacyOptionsForm() => _platform.showPrivacyOptionsForm();

  /// Refreshes whether a privacy options entry point is required.
  Future<bool> checkPrivacyOptionsRequired() async {
    final required = await _platform.isPrivacyOptionsRequired();
    if (_consentResult != null) {
      _consentResult = ConsentResult(
        canRequestAds: _consentResult!.canRequestAds,
        consentStatus: _consentResult!.consentStatus,
        isPrivacyOptionsRequired: required,
        error: _consentResult!.error,
      );
    }
    return required;
  }

  /// Initializes the complete monetization subsystem asynchronously.
  ///
  /// Safe to call during app startup: will NOT block splash screen or game loading.
  Future<void> init() async {
    if (_isInitialized) return;

    // Fail immediately if environment IDs are misconfigured or cross-contaminated.
    MonetizationConfig.validateConfiguration();

    MonetizationAnalytics.trackEvent(AdEventType.adInitStarted);
    debugPrint(
      '[MonetizationManager] Initializing monetization pipeline (Env: ${MonetizationConfig.environment.name})...',
    );

    try {
      // 1. Google UMP Consent evaluation (must run BEFORE requesting ads)
      _consentResult = await _platform.requestConsent(
        isTestMode: MonetizationConfig.isTestMode,
      );
      debugPrint(
        '[MonetizationManager] UMP Consent completed: status=${_consentResult?.consentStatus}, '
        'canRequestAds=${_consentResult?.canRequestAds}, '
        'privacyOptionsRequired=${_consentResult?.isPrivacyOptionsRequired}',
      );

      // 2. Initialize MMKV key-value store for monetization
      await _counter.init();

      // If user/regulations explicitly restrict ads, do not proceed with ad requests
      if (!(_consentResult?.canRequestAds ?? true)) {
        debugPrint(
          '[MonetizationManager] Ads restricted by UMP consent. Halting ad initialization.',
        );
        _isInitialized = true;
        return;
      }

      // 3. Initialize native TopOn mediation on Android
      final initSuccess = await _platform.initMonetization(
        appId: MonetizationConfig.topOnAppId,
        appKey: MonetizationConfig.topOnAppKey,
        isTestMode: MonetizationConfig.isTestMode,
      );

      _isInitialized = true;

      if (initSuccess) {
        debugPrint(
          '[MonetizationManager] Native TopOn mediation initialized successfully.',
        );
        MonetizationAnalytics.trackEvent(AdEventType.adInitCompleted);

        // 3. Kick off background preloading of rewarded and interstitial ads
        unawaited(_rewarded.loadRewarded());
        unawaited(_interstitial.loadInterstitial());
      } else {
        debugPrint(
          '[MonetizationManager] Native mediation reported init false or simulator mode active.',
        );
        MonetizationAnalytics.trackEvent(AdEventType.adInitCompleted, {
          'mode': 'simulation_fallback',
        });
        // Preload in simulation/fallback mode
        unawaited(_rewarded.loadRewarded());
      }
    } catch (e) {
      debugPrint('[MonetizationManager] Initialization warning: $e');
      MonetizationAnalytics.trackEvent(AdEventType.adInitFailed, {
        'error': e.toString(),
      });
      _isInitialized = true; // Never crash or lock up the game
    }
  }

  // --- Rewarded Video ---

  /// Checks if a rewarded video ad is loaded and ready.
  Future<bool> isRewardedReady() => _rewarded.checkReadiness();

  /// Presents a rewarded ad and awaits verified completion.
  ///
  /// Strictly single-ad execution:
  /// - [RewardType.revive]: 1 rewarded ad -> triggers [onReviveReward] upon reward grant.
  /// - [RewardType.dailyCrateBonus]: 1 rewarded ad -> 2X crate loot bonus.
  /// - [RewardType.doubleCyberPoints]: 1 rewarded ad -> 2X run CP multiplier.
  /// - [RewardType.cpBoost]: 1 rewarded ad -> CP Boost reward.
  Future<bool> showRewarded({
    required RewardType rewardType,
    String? rewardContext,
    VoidCallback? onReviveReward,
    void Function(int completed, int total, String statusText)? onProgress,
  }) async {
    switch (rewardType) {
      case RewardType.revive:
        MonetizationAnalytics.trackEvent(AdEventType.reviveAdRequested);
        break;
      case RewardType.dailyCrateBonus:
        MonetizationAnalytics.trackEvent(AdEventType.dailyCrateAdRequested);
        break;
      case RewardType.doubleCyberPoints:
        MonetizationAnalytics.trackEvent(AdEventType.doubleCpRequested);
        break;
      case RewardType.cpBoost:
        MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdRequested, {
          'reward_context': ?rewardContext,
        });
        break;
      case RewardType.bonusReward:
        break;
    }

    final success = await _rewarded.showRewarded(
      rewardType: rewardType,
      rewardContext: rewardContext,
      onRewardGranted: () {
        if (rewardType == RewardType.revive) {
          debugPrint(
            '[MonetizationManager] onRewardGranted for revive -> invoking onReviveReward callback',
          );
          try {
            onReviveReward?.call();
          } catch (e) {
            debugPrint(
              '[MonetizationManager] Error invoking onReviveReward: $e',
            );
          }
        }
      },
    );

    if (success) {
      switch (rewardType) {
        case RewardType.revive:
          MonetizationAnalytics.trackEvent(AdEventType.reviveAdCompleted);
          break;
        case RewardType.dailyCrateBonus:
          MonetizationAnalytics.trackEvent(AdEventType.dailyCrateAdCompleted);
          break;
        case RewardType.doubleCyberPoints:
          MonetizationAnalytics.trackEvent(AdEventType.doubleCpCompleted);
          break;
        case RewardType.cpBoost:
          MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdCompleted);
          break;
        case RewardType.bonusReward:
          break;
      }
    } else {
      if (rewardType == RewardType.revive) {
        MonetizationAnalytics.trackEvent(AdEventType.reviveAdFailed);
      }
    }

    return success;
  }

  // --- Interstitials ---

  /// Attempts to display an interstitial ad if all frequency and pacing rules pass.
  Future<bool> showInterstitialIfEligible() =>
      _interstitial.showInterstitialIfEligible();

  /// Records that a game run was finished (updates frequency pacing).
  void recordRunCompleted() {
    _frequency.recordRunCompleted();
  }

  // --- Reward Celebrations ---

  /// Displays the cyber-themed reward celebration animation overlay.
  void playRewardCelebration(
    BuildContext context,
    RewardAnimationType type, {
    String? customTitle,
    String? customSubtitle,
    int? count,
  }) {
    _animations.play(
      context,
      type,
      customTitle: customTitle,
      customSubtitle: customSubtitle,
      count: count,
    );
  }

  // --- Diagnostics ---

  /// Returns diagnostic telemetry across all subsystems.
  Future<Map<String, dynamic>> getDiagnostics() async {
    final nativeDiag = await _platform.getDiagnostics();
    return {
      'initialized': _isInitialized,
      'environment': MonetizationConfig.environment.name,
      'isTestMode': MonetizationConfig.isTestMode,
      'rewardedReady': _rewarded.isReady,
      'interstitialReady': _interstitial.isReady,
      'dailyRewardedCount': _frequency.getDailyRewardedCount(),
      'dailyInterstitialCount': _frequency.getDailyInterstitialCount(),
      'sessionInterstitialCount': _frequency.getSessionInterstitialCount(),
      'completedRunsInSession': _frequency.getCompletedRunsInSession(),
      'native': nativeDiag,
    };
  }
}
