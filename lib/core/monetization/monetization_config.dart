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

  // --- Real Cyber Ninja Runner TopOn Credentials ---
  // App ID and Placement IDs generated from the Cyber Ninja Runner TopOn dashboard.
  // DO NOT log the App Key. Use CONFIGURED/MATCHED in any report.
  static const String testTopOnAppId = 'h6aa91bb8dc11b';
  static const String testTopOnAppKey = 'ac9da0a61c59ab2bdf3cdc28e66c92b27';
  static const String testRewardedPlacementId = 'n6aa91d84caf8e';
  static const String testInterstitialPlacementId = 'n6aa925b616e0b';

  // Google AdMob official test units for demand validation
  // These are the Google-published universal test ad units — safe for all test devices.
  static const String testGoogleRewardedUnitId =
      'ca-app-pub-3940256099942544/5224354917';
  static const String testGoogleInterstitialUnitId =
      'ca-app-pub-3940256099942544/1033173712';

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
