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
  final List<void Function(bool success)> _loadWaiters = [];

  bool _isLoading = false;
  bool _isAdReady = false;
  bool _rewardEarnedForCurrentAd = false;
  Completer<bool>? _rewardCompleter;
  String? _activeTransactionId;
  RewardType? _activeRewardType;
  VoidCallback? _activeOnRewardGranted;

  bool get isReady => _isAdReady;
  bool get isLoading => _isLoading;

  void _initPlatformCallbacks() {
    _platform.onRewardedLoaded = (placementId) {
      _isLoading = false;
      _isAdReady = true;
      debugPrint('REVIVE_DEBUG: AD_LOAD_SUCCESS placement=$placementId');
      MonetizationAnalytics.trackEvent(AdEventType.rewardedLoaded, {
        'placement_id': placementId,
      });
      for (final waiter in List.of(_loadWaiters)) {
        waiter(true);
      }
      _loadWaiters.clear();
    };

    _platform.onRewardedLoadFailed = (placementId, error) {
      _isLoading = false;
      _isAdReady = false;
      _rewardEarnedForCurrentAd = false;
      debugPrint(
        'REVIVE_DEBUG: AD_LOAD_FAILED placement=$placementId error=$error',
      );
      MonetizationAnalytics.trackEvent(AdEventType.rewardedLoadFailed, {
        'placement_id': placementId,
        'error': error,
      });
      if (_rewardCompleter != null && !_rewardCompleter!.isCompleted) {
        _rewardCompleter!.complete(false);
      }
      for (final waiter in List.of(_loadWaiters)) {
        waiter(false);
      }
      _loadWaiters.clear();
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
      if (_activeTransactionId == transactionId) {
        final isValid = _validator.validateAndGrant(transactionId);
        if (isValid) {
          // Only general rewarded ads consume the general cap
          if (_activeRewardType != RewardType.cpBoost) {
            _frequency.recordRewardedShown();
          }
          _rewardEarnedForCurrentAd = true;
          debugPrint(
            '[RewardedAdManager] Reward validated and secured for tx: $transactionId',
          );

          // Trigger onRewardGranted immediately upon legitimate onReward callback
          try {
            _activeOnRewardGranted?.call();
          } catch (e) {
            debugPrint(
              '[RewardedAdManager] Error in onRewardGranted callback: $e',
            );
          }
        } else {
          _rewardEarnedForCurrentAd = false;
        }
      }
    };

    _platform.onRewardedClosed = (placementId, {rewardContext}) {
      final wasEarned = _rewardEarnedForCurrentAd;
      _rewardEarnedForCurrentAd = false;
      debugPrint(
        '[RewardedAdManager] Ad closed ($placementId, context: $rewardContext, wasEarned: $wasEarned)',
      );
      if (_rewardCompleter != null && !_rewardCompleter!.isCompleted) {
        _rewardCompleter!.complete(wasEarned);
      }
      _isAdReady = false;
      _activeTransactionId = null;
      _activeRewardType = null;
      _activeOnRewardGranted = null;
      _rewardCompleter = null;

      // Automatically preload next rewarded ad
      loadRewarded();
    };
  }

  /// Requests preloading of a rewarded video ad with optional scenario ID.
  Future<void> loadRewarded({String? scenarioId}) async {
    if (_isLoading) return;
    _isLoading = true;

    MonetizationAnalytics.trackEvent(AdEventType.rewardedLoadStarted, {
      'placement_id': MonetizationConfig.rewardedPlacementId,
      'scenario_id': scenarioId ?? 'none',
    });

    await _platform.loadRewarded(
      MonetizationConfig.rewardedPlacementId,
      scenarioId: scenarioId,
    );
  }

  /// Helper to map RewardType to TopOn scenario IDs.
  String? scenarioIdForReward(RewardType rewardType) {
    switch (rewardType) {
      case RewardType.revive:
        return 'f6aa93d000c34b';
      case RewardType.doubleCyberPoints:
        return 'f6aa93d2b791fc';
      case RewardType.dailyCrateBonus:
        return 'f6aa93d397ef4c';
      default:
        return null; // Default unused.
    }
  }

  /// Refreshes and returns whether an ad is ready to show right now.
  Future<bool> checkReadiness({String? scenarioId}) async {
    final ready = await _platform.isRewardedReady(
      MonetizationConfig.rewardedPlacementId,
      scenarioId: scenarioId,
    );
    _isAdReady = ready;
    return ready;
  }

  /// Awaits native ad cache readiness with safe timeout and load dispatching.
  Future<bool> waitForAdReady({
    String? scenarioId,
    Duration timeout = const Duration(seconds: 15),
  }) async {
    final isRevive = scenarioId == 'f6aa93d000c34b';
    if (isRevive) {
      debugPrint('REVIVE_DEBUG: CHECKING_AD_READY');
    }

    final ready = await checkReadiness(scenarioId: scenarioId);
    if (isRevive) {
      debugPrint('REVIVE_DEBUG: isAdReady=$ready');
    }

    if (ready) {
      return true;
    }

    if (isRevive) {
      debugPrint('REVIVE_DEBUG: AD_NOT_READY');
      debugPrint('REVIVE_DEBUG: REQUESTING_LOAD');
    }

    final completer = Completer<bool>();
    void listener(bool success) {
      if (!completer.isCompleted) completer.complete(success);
    }

    _loadWaiters.add(listener);

    if (!_isLoading) {
      await loadRewarded(scenarioId: scenarioId);
    }

    try {
      final success = await completer.future.timeout(
        timeout,
        onTimeout: () {
          _loadWaiters.remove(listener);
          return false;
        },
      );
      _loadWaiters.remove(listener);
      if (success) {
        return await checkReadiness(scenarioId: scenarioId);
      }
      return false;
    } catch (_) {
      _loadWaiters.remove(listener);
      return false;
    }
  }

  /// Primary API: Presents a rewarded video ad to the user.
  ///
  /// Returns `true` ONLY after the SDK's valid reward callback has fired and
  /// been validated via [RewardValidator].
  /// Returns `false` if ad was unavailable, user closed early, or duplicate was detected.
  Future<bool> showRewarded({
    required RewardType rewardType,
    String? rewardContext,
    VoidCallback? onRewardGranted,
  }) async {
    final isRevive = rewardType == RewardType.revive;
    if (isRevive) {
      debugPrint('REVIVE_DEBUG: SHOW_REQUESTED');
    }

    // 1. Check frequency/daily cap for general gameplay ads.
    // CP Boost and special rewarded sessions manage their own limits.
    final isExemptFromGeneralCap =
        rewardType == RewardType.cpBoost ||
        rewardType == RewardType.revive ||
        rewardType == RewardType.dailyCrateBonus;
    if (!isExemptFromGeneralCap && !_frequency.canShowRewarded()) {
      debugPrint('[RewardedAdManager] Daily rewarded cap reached.');
      return false;
    }

    // 2. Determine scenario ID.
    final scenarioId = scenarioIdForReward(rewardType);

    // 3. Check if ad is cached. If not ready, DO NOT immediately fail: wait for load!
    bool ready = await checkReadiness(scenarioId: scenarioId);
    if (isRevive) {
      debugPrint('REVIVE_DEBUG: CHECKING_AD_READY (showRewarded)');
      debugPrint('REVIVE_DEBUG: isAdReady=$ready');
    }

    if (!ready) {
      debugPrint(
        '[RewardedAdManager] Rewarded ad not ready in cache for ${rewardType.name}. Waiting for ad load...',
      );
      if (isRevive) {
        debugPrint('REVIVE_DEBUG: AD_NOT_READY');
        debugPrint('REVIVE_DEBUG: REQUESTING_LOAD');
      }
      ready = await waitForAdReady(
        scenarioId: scenarioId,
        timeout: const Duration(seconds: 15),
      );
      if (isRevive) {
        if (ready) {
          debugPrint('REVIVE_DEBUG: AD_LOAD_SUCCESS');
        } else {
          debugPrint('REVIVE_DEBUG: AD_LOAD_FAILED');
          debugPrint('REVIVE_DEBUG: SHOW_FAILED');
          debugPrint('REVIVE_CANCEL_REASON = LOAD_FAILED');
        }
      }
      if (!ready) {
        return false;
      }
    }

    // 4. Create unique transaction for idempotency
    final tx = _validator.createTransaction(rewardType);
    _activeTransactionId = tx.transactionId;
    _activeRewardType = rewardType;
    _activeOnRewardGranted = onRewardGranted;
    _rewardEarnedForCurrentAd = false;
    _rewardCompleter = Completer<bool>();

    // 5. Present via native TopOn bridge
    final contextStr = rewardContext ?? rewardType.name;
    final shown = await _platform.showRewarded(
      MonetizationConfig.rewardedPlacementId,
      tx.transactionId,
      rewardContext: contextStr,
      scenarioId: scenarioId,
    );

    if (!shown) {
      debugPrint(
        '[RewardedAdManager] Platform showRewarded returned false for ${rewardType.name}.',
      );
      if (isRevive) {
        debugPrint('REVIVE_DEBUG: SHOW_FAILED Native bridge returned false');
        debugPrint('REVIVE_CANCEL_REASON = NATIVE_SHOW_RETURNED_FALSE');
      }
      _validator.markFailed(tx.transactionId);
      _rewardCompleter = null;
      _activeTransactionId = null;
      _activeRewardType = null;
      return false;
    }

    if (isRevive) {
      debugPrint('REVIVE_AD_STARTED');
    }

    // 6. Await validated reward callback (with 45s safety timeout)
    return _rewardCompleter!.future.timeout(
      const Duration(seconds: 45),
      onTimeout: () {
        debugPrint('[RewardedAdManager] Ad playback timed out after 45s.');
        if (isRevive) {
          debugPrint(
            'REVIVE_DEBUG: SHOW_FAILED Ad playback timed out after 45s',
          );
          debugPrint('REVIVE_CANCEL_REASON = TIMEOUT');
        }
        _validator.markFailed(tx.transactionId);
        return false;
      },
    );
  }
}
