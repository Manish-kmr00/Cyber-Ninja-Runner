import 'dart:async';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

/// MethodChannel communication layer with native Android TopOn / AnyThink / Mintegral SDKs.
class MonetizationPlatform {
  static const MethodChannel _channel = MethodChannel(
    'com.moonedgestudio.cyberninjarunner/monetization',
  );

  static final MonetizationPlatform _instance =
      MonetizationPlatform._internal();
  factory MonetizationPlatform() => _instance;
  MonetizationPlatform._internal() {
    _channel.setMethodCallHandler(_handleNativeMethodCall);
  }

  // Callbacks for Rewarded Video
  void Function(String placementId)? onRewardedLoaded;
  void Function(String placementId, String error)? onRewardedLoadFailed;
  void Function(String placementId)? onRewardedPlayStart;
  void Function(
    String placementId,
    String transactionId, {
    String? rewardContext,
  })?
  onRewardedRewardGranted;
  void Function(String placementId, {String? rewardContext})? onRewardedClosed;

  // Callbacks for Interstitial
  void Function(String placementId)? onInterstitialLoaded;
  void Function(String placementId, String error)? onInterstitialLoadFailed;
  void Function(String placementId)? onInterstitialShown;
  void Function(String placementId)? onInterstitialClosed;

  Future<dynamic> _handleNativeMethodCall(MethodCall call) async {
    final args = call.arguments as Map<dynamic, dynamic>? ?? {};
    final placementId = args['placementId'] as String? ?? '';

    switch (call.method) {
      case 'onRewardedLoaded':
        debugPrint(
          '[MonetizationPlatform] Native callback: onRewardedLoaded ($placementId)',
        );
        onRewardedLoaded?.call(placementId);
        break;

      case 'onRewardedLoadFailed':
        final error = args['error'] as String? ?? 'Unknown error';
        debugPrint(
          '[MonetizationPlatform] Native callback: onRewardedLoadFailed ($placementId, $error)',
        );
        onRewardedLoadFailed?.call(placementId, error);
        break;

      case 'onRewardedPlayStart':
        debugPrint(
          '[MonetizationPlatform] Native callback: onRewardedPlayStart ($placementId)',
        );
        onRewardedPlayStart?.call(placementId);
        break;

      case 'onRewardedRewardGranted':
        final transactionId = args['transactionId'] as String? ?? '';
        final rewardContext = args['rewardContext'] as String? ?? '';
        debugPrint(
          '[MonetizationPlatform] Native callback: onRewardedRewardGranted (tx=$transactionId, context=$rewardContext)',
        );
        onRewardedRewardGranted?.call(
          placementId,
          transactionId,
          rewardContext: rewardContext,
        );
        break;

      case 'onRewardedClosed':
        final rewardContext = args['rewardContext'] as String? ?? '';
        debugPrint(
          '[MonetizationPlatform] Native callback: onRewardedClosed ($placementId, context=$rewardContext)',
        );
        onRewardedClosed?.call(placementId, rewardContext: rewardContext);
        break;

      case 'onInterstitialLoaded':
        debugPrint(
          '[MonetizationPlatform] Native callback: onInterstitialLoaded ($placementId)',
        );
        onInterstitialLoaded?.call(placementId);
        break;

      case 'onInterstitialLoadFailed':
        final error = args['error'] as String? ?? 'Unknown error';
        debugPrint(
          '[MonetizationPlatform] Native callback: onInterstitialLoadFailed ($placementId, $error)',
        );
        onInterstitialLoadFailed?.call(placementId, error);
        break;

      case 'onInterstitialShown':
        debugPrint(
          '[MonetizationPlatform] Native callback: onInterstitialShown ($placementId)',
        );
        onInterstitialShown?.call(placementId);
        break;

      case 'onInterstitialClosed':
        debugPrint(
          '[MonetizationPlatform] Native callback: onInterstitialClosed ($placementId)',
        );
        onInterstitialClosed?.call(placementId);
        break;

      default:
        debugPrint(
          '[MonetizationPlatform] Unhandled native call: ${call.method}',
        );
    }
  }

  /// Initializes native TopOn mediation SDK.
  Future<bool> initMonetization({
    required String appId,
    required String appKey,
    required bool isTestMode,
  }) async {
    try {
      final res = await _channel.invokeMethod<bool>('initMonetization', {
        'appId': appId,
        'appKey': appKey,
        'isTestMode': isTestMode,
      });
      return res ?? false;
    } on MissingPluginException {
      debugPrint(
        '[MonetizationPlatform] Running in non-Android environment or plugin missing.',
      );
      return false;
    } catch (e) {
      debugPrint('[MonetizationPlatform] initMonetization failed: $e');
      return false;
    }
  }

  /// Queries whether a rewarded video ad is ready in native cache.
  Future<bool> isRewardedReady(String placementId) async {
    try {
      final res = await _channel.invokeMethod<bool>('isRewardedReady', {
        'placementId': placementId,
      });
      return res ?? false;
    } catch (e) {
      return false;
    }
  }

  /// Requests preloading of a rewarded video ad.
  Future<void> loadRewarded(String placementId, {String? scenarioId}) async {
    try {
      await _channel.invokeMethod('loadRewarded', {
        'placementId': placementId,
        if (scenarioId != null) 'scenarioId': scenarioId,
      });
    } catch (e) {
      debugPrint('[MonetizationPlatform] loadRewarded error: $e');
    }
  }

  /// Presents a rewarded video ad associated with [transactionId] and [rewardContext].
  Future<bool> showRewarded(
    String placementId,
    String transactionId, {
    String rewardContext = 'reward',
    String? scenarioId,
  }) async {
    try {
      final res = await _channel.invokeMethod<bool>('showRewarded', {
        'placementId': placementId,
        'transactionId': transactionId,
        'rewardContext': rewardContext,
        if (scenarioId != null) 'scenarioId': scenarioId,
      });
      return res ?? false;
    } catch (e) {
      debugPrint('[MonetizationPlatform] showRewarded error: $e');
      return false;
    }
  }

  /// Queries whether an interstitial ad is ready in native cache.
  Future<bool> isInterstitialReady(String placementId) async {
    try {
      final res = await _channel.invokeMethod<bool>('isInterstitialReady', {
        'placementId': placementId,
      });
      return res ?? false;
    } catch (e) {
      return false;
    }
  }

  /// Requests preloading of an interstitial ad.
  Future<void> loadInterstitial(String placementId) async {
    try {
      await _channel.invokeMethod('loadInterstitial', {
        'placementId': placementId,
      });
    } catch (e) {
      debugPrint('[MonetizationPlatform] loadInterstitial error: $e');
    }
  }

  /// Presents an interstitial ad.
  Future<bool> showInterstitial(String placementId) async {
    try {
      final res = await _channel.invokeMethod<bool>('showInterstitial', {
        'placementId': placementId,
      });
      return res ?? false;
    } catch (e) {
      debugPrint('[MonetizationPlatform] showInterstitial error: $e');
      return false;
    }
  }

  /// Queries native SDK diagnostics (adapter versions, OMID status, test mode).
  Future<Map<String, dynamic>> getDiagnostics() async {
    try {
      final res = await _channel.invokeMapMethod<String, dynamic>(
        'getDiagnostics',
      );
      return res ?? {};
    } catch (e) {
      return {'error': e.toString()};
    }
  }
}
