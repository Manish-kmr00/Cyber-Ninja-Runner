import '../../constants/app_constants.dart';

/// Speed curve waypoint for distance-based forward speed interpolation.
class SpeedWaypoint {
  final double distanceMeters;
  final double speedMultiplier;

  const SpeedWaypoint({
    required this.distanceMeters,
    required this.speedMultiplier,
  });
}

/// Milestone threshold configuration for UI announcements.
class MilestoneThreshold {
  final int distanceMeters;
  final String title;
  final String subtitle;

  const MilestoneThreshold({
    required this.distanceMeters,
    required this.title,
    required this.subtitle,
  });
}

/// Centralized configuration for the Cyber Ninja Runner difficulty system.
/// Contains all tuning parameters for speed curves, obstacle density,
/// reaction time limits, solvability clearance, pattern variety, and risk/reward.
class DifficultyConfig {
  // Base Physics
  static const double baseForwardSpeed =
      AppConstants.playerBaseSpeed; // 250.0 px/s
  static const double absoluteMaxSpeed = 387.5; // 155% of base speed
  static const double maxSpeedMultiplier = 1.55;

  // Progressive Speed Curve (Smooth Interpolation Anchors)
  // 0–500m: 100% base speed (250 px/s)
  // 500–1000m: 108% (270 px/s)
  // 1000–2000m: 116% (290 px/s)
  // 2000–3000m: 125% (312.5 px/s)
  // 3000–5000m: 135% (337.5 px/s)
  // 5000m+: 145–155% (362.5 - 387.5 px/s)
  static const List<SpeedWaypoint> speedCurve = [
    SpeedWaypoint(distanceMeters: 0.0, speedMultiplier: 1.00),
    SpeedWaypoint(distanceMeters: 500.0, speedMultiplier: 1.00),
    SpeedWaypoint(distanceMeters: 1000.0, speedMultiplier: 1.08),
    SpeedWaypoint(distanceMeters: 2000.0, speedMultiplier: 1.16),
    SpeedWaypoint(distanceMeters: 3000.0, speedMultiplier: 1.25),
    SpeedWaypoint(distanceMeters: 5000.0, speedMultiplier: 1.35),
    SpeedWaypoint(distanceMeters: 7500.0, speedMultiplier: 1.45),
    SpeedWaypoint(distanceMeters: 10000.0, speedMultiplier: 1.55),
  ];

  // Solvability & Minimum Reaction Times (Seconds before an obstacle enters lethal range)
  static const double reactionTimeEasy = 1.50; // < 500m
  static const double reactionTimeNormal = 1.20; // 500m - 1500m
  static const double reactionTimeHard = 0.95; // 1500m - 3000m
  static const double reactionTimeExpert = 0.75; // 3000m+

  // Kinematic Clearance Constants (Virtual Pixels & Seconds)
  // Jump: v0 = -720, g = 1800 -> t_peak = 0.40s, t_air = 0.80s, apex height = 144px
  // Slide: duration = 0.65s, speed boost = 1.35x
  static const double minSlideRecoveryTime =
      0.22; // Seconds after slide before next mandatory jump
  static const double minJumpLandingRecoveryTime =
      0.20; // Seconds on solid ground before next obstacle
  static const double maxJumpGapDistance =
      210.0; // Maximum pit chasm width for standard jump

  // Pattern Spacing & Obstacle Density
  static const double defaultPatternCooldownMeters = 35.0;
  static const double minObstaclePhysicalGap =
      160.0; // Absolute minimum gap between consecutive obstacles

  // Risk / Reward Route Economy
  static const int safeRouteCPReward = 1;
  static const int riskyRouteCPReward = 4;
  static const int extremeRiskCPReward = 6;

  // Near-Miss Tuning
  static const double nearMissProximityPixels =
      18.0; // Distance between player and hazard bounds
  static const int nearMissCPBonus =
      2; // Subtle reward for skill without breaking CP economy

  // Milestone Announcements
  static const List<MilestoneThreshold> milestones = [
    MilestoneThreshold(
      distanceMeters: 500,
      title: 'RUNNER',
      subtitle: 'TRAINING COMPLETE // SURVEILLANCE ACTIVE',
    ),
    MilestoneThreshold(
      distanceMeters: 1500,
      title: 'HUNTER',
      subtitle: 'SPEED ACCELERATING // COMBAT DRONES EN ROUTE',
    ),
    MilestoneThreshold(
      distanceMeters: 3000,
      title: 'ASSASSIN',
      subtitle: 'HIGH THREAT SECTOR // LETHAL LASER GAUNTLETS',
    ),
    MilestoneThreshold(
      distanceMeters: 5000,
      title: 'CYBER MASTER',
      subtitle: 'MAXIMUM OVERDRIVE // PEAK REFLEXES REQUIRED',
    ),
  ];
}
