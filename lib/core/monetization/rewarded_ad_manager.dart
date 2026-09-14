import 'dart:async';
import 'package:flutter/foundation.dart';
import 'frequency_manager.dart';
import 'monetization_analytics.dart';
import 'monetization_config.dart';
import 'monetization_events.dart';
import 'monetization_platform.dart';
import 'reward_validator.dart';

/// Manages rewarded video advertising lifecycle, preloading, presentation, and reward granting.
class RewardedAdManager {
  static final RewardedAdManager _instance = RewardedAdManager._internal();
  factory RewardedAdManager() => _instance;
  RewardedAdManager._internal() {
    _initPlatformCallbacks();
  }

  final MonetizationPlatform _platform = MonetizationPlatform();
  final RewardValidator _validator = RewardValidator();
  final FrequencyManager _frequency = FrequencyManager();

  bool _isLoading = false;
  bool _isAdReady = false;
  Completer<bool>? _rewardCompleter;
  String? _activeTransactionId;
  RewardType? _activeRewardType;

  bool get isReady => _isAdReady;
  bool get isLoading => _isLoading;

  void _initPlatformCallbacks() {
    _platform.onRewardedLoaded = (placementId) {
      _isLoading = false;
      _isAdReady = true;
      MonetizationAnalytics.trackEvent(AdEventType.rewardedLoaded, {
        'placement_id': placementId,
      });
    };

    _platform.onRewardedLoadFailed = (placementId, error) {
      _isLoading = false;
      _isAdReady = false;
      MonetizationAnalytics.trackEvent(AdEventType.rewardedLoadFailed, {
        'placement_id': placementId,
        'error': error,
      });
    };

    _platform.onRewardedPlayStart = (placementId) {
      MonetizationAnalytics.trackEvent(AdEventType.rewardedShown, {
        'placement_id': placementId,
      });
    };

    _platform
        .onRewardedRewardGranted = (placementId, transactionId, {rewardContext}) {
      debugPrint(
        '[RewardedAdManager] onRewardedRewardGranted callback received for tx: $transactionId, context: $rewardContext',
      );
      if (_activeTransactionId == transactionId &&
          _rewardCompleter != null &&
          !_rewardCompleter!.isCompleted) {
        final isValid = _validator.validateAndGrant(transactionId);
        if (isValid) {
          // Only general rewarded ads consume the general cap
          if (_activeRewardType != RewardType.cpBoost) {
            _frequency.recordRewardedShown();
          }
          _rewardCompleter!.complete(true);
        } else {
          _rewardCompleter!.complete(false);
        }
      }
    };

    _platform.onRewardedClosed = (placementId, {rewardContext}) {
      debugPrint(
        '[RewardedAdManager] Ad closed ($placementId, context: $rewardContext)',
      );
      // If closed before reward was granted, complete as false
      if (_rewardCompleter != null && !_rewardCompleter!.isCompleted) {
        _rewardCompleter!.complete(false);
      }
      _isAdReady = false;
      _activeTransactionId = null;
      _activeRewardType = null;
      _rewardCompleter = null;

      // Automatically preload next rewarded ad
      loadRewarded();
    };
  }

  /// Requests preloading of a rewarded video ad.
  Future<void> loadRewarded() async {
    if (_isLoading) return;
    _isLoading = true;

    MonetizationAnalytics.trackEvent(AdEventType.rewardedLoadStarted, {
      'placement_id': MonetizationConfig.rewardedPlacementId,
    });

    await _platform.loadRewarded(MonetizationConfig.rewardedPlacementId);
  }

  /// Refreshes and returns whether an ad is ready to show right now.
  Future<bool> checkReadiness() async {
    final ready = await _platform.isRewardedReady(
      MonetizationConfig.rewardedPlacementId,
    );
    _isAdReady = ready;
    return ready;
  }

  /// Primary API: Presents a rewarded video ad to the user.
  ///
  /// Returns `true` ONLY after the SDK's valid reward callback has fired and
  /// been validated via [RewardValidator].
  /// Returns `false` if ad was unavailable, user closed early, or duplicate was detected.
  Future<bool> showRewarded({
    required RewardType rewardType,
    String? rewardContext,
  }) async {
    // 1. Check frequency/daily cap for general gameplay ads.
    // CP Boost manages its own dedicated daily limit and cooldown.
    if (rewardType != RewardType.cpBoost && !_frequency.canShowRewarded()) {
      debugPrint('[RewardedAdManager] Daily rewarded cap reached.');
      return false;
    }

    // 2. Check if ad is cached
    final ready = await checkReadiness();
    if (!ready) {
      debugPrint(
        '[RewardedAdManager] Rewarded ad not ready in cache for ${rewardType.name}. Attempting load.',
      );
      loadRewarded();
      return false;
    }

    // 3. Create unique transaction for idempotency
    final tx = _validator.createTransaction(rewardType);
    _activeTransactionId = tx.transactionId;
    _activeRewardType = rewardType;
    _rewardCompleter = Completer<bool>();

    // 4. Present via native TopOn bridge
    final contextStr = rewardContext ?? rewardType.name;
    final shown = await _platform.showRewarded(
      MonetizationConfig.rewardedPlacementId,
      tx.transactionId,
      rewardContext: contextStr,
    );

    if (!shown) {
      _validator.markFailed(tx.transactionId);
      _rewardCompleter = null;
      _activeTransactionId = null;
      _activeRewardType = null;
      return false;
    }

    // 5. Await validated reward callback (with 45s safety timeout)
    return _rewardCompleter!.future.timeout(
      const Duration(seconds: 45),
      onTimeout: () {
        debugPrint('[RewardedAdManager] Ad playback timed out after 45s.');
        _validator.markFailed(tx.transactionId);
        return false;
      },
    );
  }
}
