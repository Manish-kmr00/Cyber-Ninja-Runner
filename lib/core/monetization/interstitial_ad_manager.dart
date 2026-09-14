import 'dart:async';
import 'package:flutter/foundation.dart';
import 'frequency_manager.dart';
import 'monetization_analytics.dart';
import 'monetization_config.dart';
import 'monetization_events.dart';
import 'monetization_platform.dart';

/// Manages interstitial ad preloading, frequency gating, and presentation.
class InterstitialAdManager {
  static final InterstitialAdManager _instance =
      InterstitialAdManager._internal();
  factory InterstitialAdManager() => _instance;
  InterstitialAdManager._internal() {
    _initPlatformCallbacks();
  }

  final MonetizationPlatform _platform = MonetizationPlatform();
  final FrequencyManager _frequency = FrequencyManager();

  bool _isLoading = false;
  bool _isAdReady = false;

  bool get isReady => _isAdReady;
  bool get isLoading => _isLoading;

  void _initPlatformCallbacks() {
    _platform.onInterstitialLoaded = (placementId) {
      _isLoading = false;
      _isAdReady = true;
      MonetizationAnalytics.trackEvent(AdEventType.interstitialLoaded, {
        'placement_id': placementId,
      });
    };

    _platform.onInterstitialLoadFailed = (placementId, error) {
      _isLoading = false;
      _isAdReady = false;
      MonetizationAnalytics.trackEvent(AdEventType.interstitialFailed, {
        'placement_id': placementId,
        'error': error,
      });
    };

    _platform.onInterstitialShown = (placementId) {
      MonetizationAnalytics.trackEvent(AdEventType.interstitialShown, {
        'placement_id': placementId,
      });
    };

    _platform.onInterstitialClosed = (placementId) {
      debugPrint('[InterstitialAdManager] Interstitial closed ($placementId)');
      _isAdReady = false;
      // Preload next interstitial
      loadInterstitial();
    };
  }

  /// Requests preloading of an interstitial ad.
  Future<void> loadInterstitial() async {
    if (_isLoading) return;
    _isLoading = true;

    MonetizationAnalytics.trackEvent(AdEventType.interstitialLoadStarted, {
      'placement_id': MonetizationConfig.interstitialPlacementId,
    });

    await _platform.loadInterstitial(
      MonetizationConfig.interstitialPlacementId,
    );
  }

  /// Refreshes and returns readiness state.
  Future<bool> checkReadiness() async {
    final ready = await _platform.isInterstitialReady(
      MonetizationConfig.interstitialPlacementId,
    );
    _isAdReady = ready;
    return ready;
  }

  /// Attempts to display an interstitial ad if all frequency and cooldown rules pass.
  ///
  /// Returns `true` if an ad was displayed, `false` if gated or unavailable.
  Future<bool> showInterstitialIfEligible() async {
    // 1. Check frequency gating
    final check = _frequency.canShowInterstitial();
    if (!check.allowed) {
      debugPrint(
        '[InterstitialAdManager] Interstitial suppressed: ${check.reason}',
      );
      return false;
    }

    // 2. Check readiness in cache
    final ready = await checkReadiness();
    if (!ready) {
      debugPrint('[InterstitialAdManager] Interstitial not ready in cache.');
      loadInterstitial();
      return false;
    }

    // 3. Show ad
    final shown = await _platform.showInterstitial(
      MonetizationConfig.interstitialPlacementId,
    );

    if (shown) {
      _frequency.recordInterstitialShown();
      return true;
    }

    return false;
  }
}
