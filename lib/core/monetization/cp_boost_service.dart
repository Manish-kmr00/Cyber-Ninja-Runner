import 'dart:async';
import 'package:flutter/material.dart';
import '../audio/audio_service.dart';
import '../storage/save_service.dart';
import 'cp_boost_config.dart';
import 'monetization_analytics.dart';
import 'monetization_manager.dart';
import 'shared_counter_service.dart';

/// Button display states for CP Boost cards.
enum CpBoostButtonState { watchAd, cooldown, limitReached, adNotReady, loading }

/// Service managing the CP Boost / CP Vault feature lifecycle, daily limits,
/// cooldown timers, reward distribution, and persistence.
class CpBoostService extends ChangeNotifier {
  static final CpBoostService _instance = CpBoostService._internal();
  factory CpBoostService() => _instance;
  CpBoostService._internal();

  final SharedCounterService _counter = SharedCounterService();

  static const String _keyDailyCount = 'monetization.cp_boost.daily_count';
  static const String _keyDailyEarnedCp =
      'monetization.cp_boost.daily_earned_cp';
  static const String _keyLastRewardEpoch =
      'monetization.cp_boost.last_reward_epoch';
  static const String _keyLastRecordedDay =
      'monetization.cp_boost.last_recorded_day';

  bool _isClaiming = false;
  String? _activeClaimTierId;

  bool get isClaiming => _isClaiming;
  String? get activeClaimTierId => _activeClaimTierId;

  /// Ensures date rollover and returns current calendar day string (YYYY-MM-DD).
  String _checkAndSyncDay() {
    final now = DateTime.now();
    final todayKey =
        '${now.year}-${now.month.toString().padLeft(2, '0')}-${now.day.toString().padLeft(2, '0')}';
    final savedDay = _counter.getString(_keyLastRecordedDay);

    if (savedDay != todayKey) {
      debugPrint(
        '[CpBoostService] Calendar day changed ($savedDay -> $todayKey). Resetting CP Boost counters.',
      );
      _counter.set(_keyDailyCount, 0);
      _counter.set(_keyDailyEarnedCp, 0);
      _counter.setString(_keyLastRecordedDay, todayKey);
      notifyListeners();
    }
    return todayKey;
  }

  /// Number of CP Boost rewarded ads watched today.
  int get adsWatchedToday {
    _checkAndSyncDay();
    return _counter.get(_keyDailyCount);
  }

  /// Number of CP Boost rewarded ads remaining for today.
  int get remainingAdsToday {
    final watched = adsWatchedToday;
    final remaining = CpBoostConfig.maxDailyAds - watched;
    return remaining < 0 ? 0 : remaining;
  }

  /// Total CP earned specifically from CP Boost today.
  int get totalCpEarnedToday {
    _checkAndSyncDay();
    return _counter.get(_keyDailyEarnedCp);
  }

  /// Whether the daily cap for CP Boost has been exhausted.
  bool get isDailyLimitReached => remainingAdsToday <= 0;

  /// Seconds remaining on the CP Boost cooldown timer (0 if ready).
  int get cooldownRemainingSeconds {
    final lastEpochStr = _counter.getString(_keyLastRewardEpoch);
    if (lastEpochStr == null || lastEpochStr.isEmpty) return 0;

    final lastEpoch = int.tryParse(lastEpochStr) ?? 0;
    if (lastEpoch <= 0) return 0;

    final nowMs = DateTime.now().millisecondsSinceEpoch;
    final elapsedSec = (nowMs - lastEpoch) ~/ 1000;
    if (elapsedSec < CpBoostConfig.cooldownSeconds) {
      return CpBoostConfig.cooldownSeconds - elapsedSec;
    }
    return 0;
  }

  /// Whether the cooldown period is currently active.
  bool get isCooldownActive => cooldownRemainingSeconds > 0;

  /// Determines the appropriate button state for a reward card.
  CpBoostButtonState getButtonState({
    required String tierId,
    required bool isAdReady,
  }) {
    if (_isClaiming && _activeClaimTierId == tierId) {
      return CpBoostButtonState.loading;
    }
    if (isDailyLimitReached) {
      return CpBoostButtonState.limitReached;
    }
    if (isCooldownActive) {
      return CpBoostButtonState.cooldown;
    }
    if (!isAdReady) {
      return CpBoostButtonState.adNotReady;
    }
    return CpBoostButtonState.watchAd;
  }

  /// Initiates the rewarded ad sequence for the selected [tier].
  ///
  /// Returns `true` ONLY if the player watched the real rewarded ad to completion,
  /// the native reward callback was verified, and CP was successfully granted.
  /// Returns `false` on cancellation, ad failure, or duplicate attempt.
  Future<bool> watchAndClaimReward({
    required BuildContext context,
    required CpBoostTier tier,
    required SaveService saveService,
  }) async {
    if (_isClaiming) {
      debugPrint(
        '[CpBoostService] Claim already in progress. Ignoring duplicate tap.',
      );
      return false;
    }

    _checkAndSyncDay();

    // 1. Check daily limit
    if (isDailyLimitReached) {
      debugPrint(
        '[CpBoostService] Cannot watch: Daily limit reached ($adsWatchedToday/${CpBoostConfig.maxDailyAds})',
      );
      MonetizationAnalytics.trackEvent(AdEventType.cpBoostDailyLimitReached, {
        'watched_today': adsWatchedToday,
      });
      return false;
    }

    // 2. Check cooldown
    if (isCooldownActive) {
      debugPrint(
        '[CpBoostService] Cannot watch: Cooldown active ($cooldownRemainingSeconds s remaining)',
      );
      return false;
    }

    _isClaiming = true;
    _activeClaimTierId = tier.id;
    notifyListeners();

    MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdRequested, {
      'tier_id': tier.id,
      'reward_cp': tier.rewardCp,
      'ads_watched_today': adsWatchedToday,
    });

    try {
      // 3. Verify ad readiness in native cache
      final isReady = await MonetizationManager().isRewardedReady();
      if (!isReady) {
        debugPrint(
          '[CpBoostService] Rewarded ad not ready in cache for ${tier.id}. Requesting preload.',
        );
        MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdFailed, {
          'tier_id': tier.id,
          'reason': 'ad_not_ready',
        });
        // Kick off preload for subsequent tap
        unawaited(MonetizationManager().init());
        _isClaiming = false;
        _activeClaimTierId = null;
        notifyListeners();
        return false;
      }

      // 4. Present real TopOn rewarded ad with cp_boost context
      final success = await MonetizationManager().showRewarded(
        rewardType: RewardType.cpBoost,
        rewardContext: 'cp_boost_${tier.id}',
      );

      if (!success) {
        debugPrint(
          '[CpBoostService] Rewarded ad did not complete or was cancelled. Granting 0 CP.',
        );
        MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdFailed, {
          'tier_id': tier.id,
          'reason': 'cancelled_or_failed',
        });
        _isClaiming = false;
        _activeClaimTierId = null;
        notifyListeners();
        return false;
      }

      // 5. LEGITIMATE REWARD VERIFIED
      // Update persistent daily counters
      final newCount = _counter.increment(_keyDailyCount);
      final currentEarned = _counter.get(_keyDailyEarnedCp);
      _counter.set(_keyDailyEarnedCp, currentEarned + tier.rewardCp);
      _counter.setString(
        _keyLastRewardEpoch,
        DateTime.now().millisecondsSinceEpoch.toString(),
      );

      // Persist CP to official player save
      saveService.addCyberPoints(tier.rewardCp);
      debugPrint(
        '[CpBoostService] SUCCESS! Awarded +${tier.rewardCp} CP. Total balance: ${saveService.player.cyberPoints.value} (Today: $newCount/${CpBoostConfig.maxDailyAds})',
      );

      MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdCompleted, {
        'tier_id': tier.id,
        'reward_cp': tier.rewardCp,
      });

      MonetizationAnalytics.trackEvent(AdEventType.cpBoostRewardGranted, {
        'tier_id': tier.id,
        'reward_cp': tier.rewardCp,
        'new_balance': saveService.player.cyberPoints.value,
      });

      // Play purchase sound via existing audio pipeline
      AudioService().playPurchase();

      // Show reward celebration animation if context is still mounted
      if (context.mounted) {
        MonetizationManager().playRewardCelebration(
          context,
          RewardAnimationType.coinReward,
          customTitle: '+${tier.rewardCp} CP',
          customSubtitle: 'CP BOOST // ${tier.title}',
          count: tier.rewardCp,
        );
      }

      _isClaiming = false;
      _activeClaimTierId = null;
      notifyListeners();
      return true;
    } catch (e) {
      debugPrint('[CpBoostService] Error during reward flow: $e');
      MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdFailed, {
        'tier_id': tier.id,
        'error': e.toString(),
      });
      _isClaiming = false;
      _activeClaimTierId = null;
      notifyListeners();
      return false;
    }
  }

  /// For testing/debug: Resets cooldown or daily counts.
  @visibleForTesting
  void resetForTesting() {
    _counter.set(_keyDailyCount, 0);
    _counter.set(_keyDailyEarnedCp, 0);
    _counter.setString(_keyLastRewardEpoch, '0');
    _isClaiming = false;
    _activeClaimTierId = null;
    notifyListeners();
  }
}
