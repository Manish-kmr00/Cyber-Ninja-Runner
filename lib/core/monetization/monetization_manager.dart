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

  /// Initializes the complete monetization subsystem asynchronously.
  ///
  /// Safe to call during app startup: will NOT block splash screen or game loading.
  Future<void> init() async {
    if (_isInitialized) return;

    MonetizationAnalytics.trackEvent(AdEventType.adInitStarted);
    debugPrint(
      '[MonetizationManager] Initializing monetization pipeline (Env: ${MonetizationConfig.environment.name})...',
    );

    try {
      // 1. Initialize MMKV key-value store for monetization
      await _counter.init();

      // 2. Initialize native TopOn mediation on Android
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
  /// Returns `true` ONLY if the user watched the entire ad and the reward
  /// callback was validated. Returns `false` on failure/cancellation.
  Future<bool> showRewarded({
    required RewardType rewardType,
    String? rewardContext,
  }) {
    switch (rewardType) {
      case RewardType.revive:
        MonetizationAnalytics.trackEvent(AdEventType.reviveAdRequested);
        break;
      case RewardType.doubleCyberPoints:
        MonetizationAnalytics.trackEvent(AdEventType.doubleCpRequested);
        break;
      case RewardType.dailyCrateBonus:
        MonetizationAnalytics.trackEvent(AdEventType.dailyCrateAdRequested);
        break;
      case RewardType.cpBoost:
        MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdRequested, {
          'reward_context': ?rewardContext,
        });
        break;
      case RewardType.bonusReward:
        break;
    }

    return _rewarded.showRewarded(
      rewardType: rewardType,
      rewardContext: rewardContext,
    );
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
