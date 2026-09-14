import 'package:flutter/foundation.dart';
import 'monetization_config.dart';
import 'shared_counter_service.dart';

/// Manages ad frequency pacing, caps, and cooldowns.
class FrequencyManager {
  static final FrequencyManager _instance = FrequencyManager._internal();
  factory FrequencyManager() => _instance;
  FrequencyManager._internal();

  final SharedCounterService _counter = SharedCounterService();

  int _sessionInterstitialCount = 0;
  int _completedRunsInSession = 0;
  DateTime? _lastInterstitialTime;
  DateTime? _lastRewardedTime;

  // Persistent counter keys in MMKV
  static const String _keyLifetimeRuns = 'monetization.lifetime_runs';
  static const String _keyDailyInterstitial =
      'monetization.daily_interstitial_count';
  static const String _keyDailyRewarded = 'monetization.daily_rewarded_count';

  /// Call this when a mission/run is completed.
  void recordRunCompleted() {
    _completedRunsInSession++;
    final total = _counter.increment(_keyLifetimeRuns);
    debugPrint(
      '[FrequencyManager] Run completed: session=$_completedRunsInSession, lifetime=$total',
    );
  }

  /// Call this when an interstitial ad is presented to the user.
  void recordInterstitialShown() {
    _sessionInterstitialCount++;
    _lastInterstitialTime = DateTime.now();
    _counter.increment(_keyDailyInterstitial);
    debugPrint(
      '[FrequencyManager] Interstitial recorded: session=$_sessionInterstitialCount, daily=${getDailyInterstitialCount()}',
    );
  }

  /// Call this when a rewarded video ad is presented to the user.
  void recordRewardedShown() {
    _lastRewardedTime = DateTime.now();
    _counter.increment(_keyDailyRewarded);
    debugPrint(
      '[FrequencyManager] Rewarded recorded: daily=${getDailyRewardedCount()}',
    );
  }

  /// Determines whether an interstitial ad is currently allowed to be displayed.
  ///
  /// Returns a record with `allowed` flag and explanatory `reason`.
  ({bool allowed, String reason}) canShowInterstitial() {
    // 1. Minimum runs threshold
    if (_completedRunsInSession <
        MonetizationConfig.minimumRunsBeforeFirstInterstitial) {
      return (
        allowed: false,
        reason:
            'Need at least ${MonetizationConfig.minimumRunsBeforeFirstInterstitial} completed runs in session (current: $_completedRunsInSession)',
      );
    }

    // 2. Session cap
    if (_sessionInterstitialCount >=
        MonetizationConfig.sessionInterstitialCap) {
      return (
        allowed: false,
        reason:
            'Session cap of ${MonetizationConfig.sessionInterstitialCap} interstitials reached',
      );
    }

    // 3. Daily cap
    final dailyCount = getDailyInterstitialCount();
    if (dailyCount >= MonetizationConfig.dailyInterstitialCap) {
      return (
        allowed: false,
        reason:
            'Daily cap of ${MonetizationConfig.dailyInterstitialCap} interstitials reached (current: $dailyCount)',
      );
    }

    final now = DateTime.now();

    // 4. Interstitial-to-interstitial cooldown
    if (_lastInterstitialTime != null) {
      final elapsed = now.difference(_lastInterstitialTime!).inSeconds;
      if (elapsed < MonetizationConfig.interstitialCooldownSeconds) {
        return (
          allowed: false,
          reason:
              'Interstitial cooldown active (${MonetizationConfig.interstitialCooldownSeconds - elapsed}s remaining)',
        );
      }
    }

    // 5. Post-rewarded protection cooldown
    if (_lastRewardedTime != null) {
      final elapsed = now.difference(_lastRewardedTime!).inSeconds;
      if (elapsed <
          MonetizationConfig.postRewardedInterstitialCooldownSeconds) {
        return (
          allowed: false,
          reason:
              'Post-rewarded buffer active (${MonetizationConfig.postRewardedInterstitialCooldownSeconds - elapsed}s remaining)',
        );
      }
    }

    return (allowed: true, reason: 'OK');
  }

  /// Determines whether a rewarded ad is allowed (e.g. daily cap check).
  bool canShowRewarded() {
    final dailyRewarded = getDailyRewardedCount();
    return dailyRewarded < MonetizationConfig.dailyRewardedCap;
  }

  int getDailyInterstitialCount() => _counter.get(_keyDailyInterstitial);
  int getDailyRewardedCount() => _counter.get(_keyDailyRewarded);
  int getSessionInterstitialCount() => _sessionInterstitialCount;
  int getCompletedRunsInSession() => _completedRunsInSession;
}
