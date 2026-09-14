import 'package:flutter/foundation.dart';
import 'monetization_events.dart';

/// Configuration and safety policy for Cyber Ninja Runner monetization.
class MonetizationConfig {
  /// Active environment. Defaults strictly to [MonetizationEnvironment.test].
  static MonetizationEnvironment _environment = MonetizationEnvironment.test;

  /// Returns active environment with an unbreakable safety guard:
  /// Debug and profile builds CANNOT run in production mode under any circumstance.
  static MonetizationEnvironment get environment {
    if (kDebugMode || kProfileMode) {
      return MonetizationEnvironment.test;
    }
    return _environment;
  }

  /// Explicitly sets production environment. Rejects if running in debug/profile.
  static void setProductionEnvironment({
    required String productionTopOnAppId,
    required String productionTopOnAppKey,
    required String productionRewardedPlacementId,
    required String productionInterstitialPlacementId,
  }) {
    if (kDebugMode || kProfileMode) {
      debugPrint(
        '[MonetizationConfig] SAFETY GUARD: Production mode rejected in debug/profile build!',
      );
      _environment = MonetizationEnvironment.test;
      return;
    }

    _prodTopOnAppId = productionTopOnAppId;
    _prodTopOnAppKey = productionTopOnAppKey;
    _prodRewardedPlacementId = productionRewardedPlacementId;
    _prodInterstitialPlacementId = productionInterstitialPlacementId;
    _environment = MonetizationEnvironment.production;
    debugPrint(
      '[MonetizationConfig] PRODUCTION environment activated explicitly.',
    );
  }

  // --- Official Test Identifiers (TopOn, Mintegral, Google AdMob) ---
  // Official TopOn test App ID and Placement IDs (Global test mode)
  static const String testTopOnAppId = 'a5b0e8549d3911';
  static const String testTopOnAppKey = '9f63b16be457319c3606dc3137931b1b';
  static const String testRewardedPlacementId = 'b5b0e8573fc523';
  static const String testInterstitialPlacementId = 'b5b0e8568e6e58';

  // Google AdMob official test units for demand validation
  static const String testGoogleRewardedUnitId =
      'ca-app-pub-3940256099942544/5224354917';
  static const String testGoogleInterstitialUnitId =
      'ca-app-pub-3940256099942544/1033173712';

  // Mintegral official test configuration
  static const String testMintegralAppId = '118690';
  static const String testMintegralAppKey = '7c22942b749fe6a6e361b675714b3ff8';
  static const String testMintegralRewardedUnitId = '293224';

  // --- Production placeholders (Supplied only at runtime via setProductionEnvironment) ---
  static String? _prodTopOnAppId;
  static String? _prodTopOnAppKey;
  static String? _prodRewardedPlacementId;
  static String? _prodInterstitialPlacementId;

  // Resolved IDs based on active environment
  static String get topOnAppId =>
      environment == MonetizationEnvironment.production
      ? (_prodTopOnAppId ?? testTopOnAppId)
      : testTopOnAppId;

  static String get topOnAppKey =>
      environment == MonetizationEnvironment.production
      ? (_prodTopOnAppKey ?? testTopOnAppKey)
      : testTopOnAppKey;

  static String get rewardedPlacementId =>
      environment == MonetizationEnvironment.production
      ? (_prodRewardedPlacementId ?? testRewardedPlacementId)
      : testRewardedPlacementId;

  static String get interstitialPlacementId =>
      environment == MonetizationEnvironment.production
      ? (_prodInterstitialPlacementId ?? testInterstitialPlacementId)
      : testInterstitialPlacementId;

  static bool get isTestMode => environment == MonetizationEnvironment.test;

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
