import 'package:flutter/foundation.dart';
import 'monetization_events.dart';

/// Pluggable interface for telemetry and analytics backends (Firebase, ThinkingData, etc.).
abstract class MonetizationAnalyticsHandler {
  void onEvent(String eventName, Map<String, dynamic> parameters);
}

/// Central analytics hub for monetization metrics.
class MonetizationAnalytics {
  static final List<MonetizationAnalyticsHandler> _handlers = [];

  /// Registers an analytics backend.
  static void registerHandler(MonetizationAnalyticsHandler handler) {
    if (!_handlers.contains(handler)) {
      _handlers.add(handler);
    }
  }

  /// Removes an analytics backend.
  static void unregisterHandler(MonetizationAnalyticsHandler handler) {
    _handlers.remove(handler);
  }

  /// Dispatches a structured monetization event to all registered backends.
  static void trackEvent(
    AdEventType eventType, [
    Map<String, dynamic>? parameters,
  ]) {
    final eventName = _toEventName(eventType);
    final enrichedParams = <String, dynamic>{
      'timestamp': DateTime.now().toIso8601String(),
      ...?parameters,
    };

    // Diagnostic logging in debug/test builds
    debugPrint(
      '[MonetizationAnalytics] $eventName: ${enrichedParams.entries.map((e) => '${e.key}=${e.value}').join(', ')}',
    );

    for (final handler in _handlers) {
      try {
        handler.onEvent(eventName, enrichedParams);
      } catch (e) {
        debugPrint('[MonetizationAnalytics] Handler error for $eventName: $e');
      }
    }
  }

  static String _toEventName(AdEventType eventType) {
    switch (eventType) {
      case AdEventType.adInitStarted:
        return 'ad_init_started';
      case AdEventType.adInitCompleted:
        return 'ad_init_completed';
      case AdEventType.adInitFailed:
        return 'ad_init_failed';
      case AdEventType.rewardedLoadStarted:
        return 'rewarded_load_started';
      case AdEventType.rewardedLoaded:
        return 'rewarded_loaded';
      case AdEventType.rewardedLoadFailed:
        return 'rewarded_load_failed';
      case AdEventType.rewardedShown:
        return 'rewarded_shown';
      case AdEventType.rewardedCompleted:
        return 'rewarded_completed';
      case AdEventType.rewardGranted:
        return 'reward_granted';
      case AdEventType.rewardGrantDuplicateBlocked:
        return 'reward_grant_duplicate_blocked';
      case AdEventType.interstitialLoadStarted:
        return 'interstitial_load_started';
      case AdEventType.interstitialLoaded:
        return 'interstitial_loaded';
      case AdEventType.interstitialShown:
        return 'interstitial_shown';
      case AdEventType.interstitialFailed:
        return 'interstitial_failed';
      case AdEventType.adNetworkSelected:
        return 'ad_network_selected';
      case AdEventType.adImpression:
        return 'ad_impression';
      case AdEventType.adClick:
        return 'ad_click';
      case AdEventType.reviveAdRequested:
        return 'revive_ad_requested';
      case AdEventType.reviveAdCompleted:
        return 'revive_ad_completed';
      case AdEventType.reviveAdFailed:
        return 'revive_ad_failed';
      case AdEventType.doubleCpRequested:
        return 'double_cp_requested';
      case AdEventType.doubleCpCompleted:
        return 'double_cp_completed';
      case AdEventType.dailyCrateAdRequested:
        return 'daily_crate_ad_requested';
      case AdEventType.dailyCrateAdCompleted:
        return 'daily_crate_ad_completed';
      case AdEventType.iapPurchaseStarted:
        return 'iap_purchase_started';
      case AdEventType.iapPurchaseCompleted:
        return 'iap_purchase_completed';
      case AdEventType.cpBoostOpened:
        return 'cp_boost_opened';
      case AdEventType.cpBoostAdRequested:
        return 'cp_boost_ad_requested';
      case AdEventType.cpBoostAdLoaded:
        return 'cp_boost_ad_loaded';
      case AdEventType.cpBoostAdFailed:
        return 'cp_boost_ad_failed';
      case AdEventType.cpBoostAdCompleted:
        return 'cp_boost_ad_completed';
      case AdEventType.cpBoostRewardGranted:
        return 'cp_boost_reward_granted';
      case AdEventType.cpBoostRewardDuplicateBlocked:
        return 'cp_boost_reward_duplicate_blocked';
      case AdEventType.cpBoostDailyLimitReached:
        return 'cp_boost_daily_limit_reached';
    }
  }
}
