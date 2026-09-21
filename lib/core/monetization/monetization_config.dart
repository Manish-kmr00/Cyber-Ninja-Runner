import 'package:flutter/foundation.dart';
import 'monetization_events.dart';

/// Configuration and safety policy for Cyber Ninja Runner monetization.
class MonetizationConfig {
  /// Active environment. Defaults strictly to [MonetizationEnvironment.test].
  static MonetizationEnvironment _environment = MonetizationEnvironment.test;

  @visibleForTesting
  static MonetizationEnvironment? forceEnvironmentForTesting;

  /// Returns active environment with an unbreakable safety guard:
  /// Debug and profile builds CANNOT run in production mode under any circumstance.
  static MonetizationEnvironment get environment {
    if (forceEnvironmentForTesting != null) {
      return forceEnvironmentForTesting!;
    }
    if (kDebugMode || kProfileMode) {
      return MonetizationEnvironment.test;
    }
    return _environment;
  }

  /// Explicitly sets production environment. Rejects if running in debug/profile.
  static void setProductionEnvironment({
    String? productionTopOnAppId,
    String? productionTopOnAppKey,
    String? productionRewardedPlacementId,
    String? productionInterstitialPlacementId,
  }) {
    if (kDebugMode || kProfileMode) {
      debugPrint(
        '[MonetizationConfig] SAFETY GUARD: Production mode rejected in debug/profile build!',
      );
      _environment = MonetizationEnvironment.test;
      return;
    }

    _environment = MonetizationEnvironment.production;
    debugPrint(
      '[MonetizationConfig] PRODUCTION environment activated explicitly.',
    );
  }

  // --- TopOn Dashboard Configuration (Verified) ---
  static const String topOnAppId = 'h6aa91bb8dc11b';
  static const String topOnAppKey = 'ac9da0a61c59ab2bdf3cdc28e66c92b27';
  static const String rewardedPlacementId = 'n6aa91d84caf8e';
  static const String interstitialPlacementId = 'n6aa925b616e0b';

  // TopOn Scenario IDs
  static const String scenarioRevive = 'f6aa93d000c34b';
  static const String scenarioDoubleCp = 'f6aa93d2b791fc';
  static const String scenarioCrate = 'f6aa93d397ef4c';

  // --- Official Google Test AdMob IDs ---
  static const String testAdMobAppId = 'ca-app-pub-3940256099942544~3347511713';
  static const String testRewardedAdUnitId =
      'ca-app-pub-3940256099942544/5224354917';
  static const String testInterstitialAdUnitId =
      'ca-app-pub-3940256099942544/1033173712';

  // Backward-compatibility aliases
  static const String testTopOnAppId = topOnAppId;
  static const String testTopOnAppKey = topOnAppKey;
  static const String testRewardedPlacementId = rewardedPlacementId;
  static const String testInterstitialPlacementId = interstitialPlacementId;
  static const String testGoogleRewardedUnitId = testRewardedAdUnitId;
  static const String testGoogleInterstitialUnitId = testInterstitialAdUnitId;

  // --- Verified Production AdMob IDs ---
  static const String productionAdMobAppId =
      'ca-app-pub-5727644626056713~7098346023';
  static const String productionRewardedAdUnitId =
      'ca-app-pub-5727644626056713/8136929678';
  static const String productionInterstitialAdUnitId =
      'ca-app-pub-5727644626056713/7318672020';

  // Resolved AdMob IDs based on active environment
  static String get adMobAppId =>
      environment == MonetizationEnvironment.production
      ? productionAdMobAppId
      : testAdMobAppId;

  static String get adMobRewardedUnitId =>
      environment == MonetizationEnvironment.production
      ? productionRewardedAdUnitId
      : testRewardedAdUnitId;

  static String get adMobInterstitialUnitId =>
      environment == MonetizationEnvironment.production
      ? productionInterstitialAdUnitId
      : testInterstitialAdUnitId;

  static bool get isTestMode => environment == MonetizationEnvironment.test;
  static bool get enableNetworkLogDebug => isTestMode;

  /// Strict validation ensuring zero cross-environment contamination.
  /// Throws [StateError] if any mismatch or mixing is detected.
  static void validateConfiguration() {
    validateIdsForEnvironment(
      environment,
      appId: adMobAppId,
      rewardedUnitId: adMobRewardedUnitId,
      interstitialUnitId: adMobInterstitialUnitId,
    );
  }

  /// Validates specific IDs against the target environment.
  static void validateIdsForEnvironment(
    MonetizationEnvironment env, {
    required String appId,
    required String rewardedUnitId,
    required String interstitialUnitId,
  }) {
    if (env == MonetizationEnvironment.test) {
      if (appId != testAdMobAppId ||
          rewardedUnitId != testRewardedAdUnitId ||
          interstitialUnitId != testInterstitialAdUnitId) {
        throw StateError(
          '[MonetizationConfig] VALIDATION FAILED: TEST environment resolved non-test AdMob IDs! '
          'appId=$appId, rewarded=$rewardedUnitId, interstitial=$interstitialUnitId',
        );
      }
      if (appId == productionAdMobAppId ||
          rewardedUnitId == productionRewardedAdUnitId ||
          interstitialUnitId == productionInterstitialAdUnitId) {
        throw StateError(
          '[MonetizationConfig] CRITICAL ERROR: Production AdMob ID detected in TEST environment!',
        );
      }
    } else if (env == MonetizationEnvironment.production) {
      if (appId != productionAdMobAppId ||
          rewardedUnitId != productionRewardedAdUnitId ||
          interstitialUnitId != productionInterstitialAdUnitId) {
        throw StateError(
          '[MonetizationConfig] VALIDATION FAILED: PRODUCTION environment resolved non-production AdMob IDs! '
          'appId=$appId, rewarded=$rewardedUnitId, interstitial=$interstitialUnitId',
        );
      }
      if (appId.contains('3940256099942544') ||
          rewardedUnitId.contains('3940256099942544') ||
          interstitialUnitId.contains('3940256099942544')) {
        throw StateError(
          '[MonetizationConfig] CRITICAL ERROR: Google sample/test AdMob ID detected in PRODUCTION environment!',
        );
      }
    }
  }

  // --- Frequency & Pacing Constraints ---
  /// Minimum cooldown between consecutive interstitials (in seconds).
  static int interstitialCooldownSeconds = 60;

  /// Number of completed runs before showing the very first interstitial.
  static int minimumRunsBeforeFirstInterstitial = 3;

  /// Maximum interstitials per game session.
  static int sessionInterstitialCap = 4;

  /// Maximum interstitials per 24-hour day.
  static int dailyInterstitialCap = 10;

  /// Maximum rewarded video impressions per day.
  static int dailyRewardedCap = 25;

  /// Cooldown after watching a rewarded video before any interstitial can appear (seconds).
  static int postRewardedInterstitialCooldownSeconds = 90;
}
