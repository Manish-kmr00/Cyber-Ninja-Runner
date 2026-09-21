import 'package:flutter/foundation.dart';

/// Represents difficulty level tier
enum DifficultyTier {
  initiate, // 0 - 500m
  runner, // 500 - 1500m
  hunter, // 1500 - 3000m
  assassin, // 3000 - 5000m
  cyberMaster, // 5000m+
}

/// Immutable snapshot representing the instantaneous difficulty state of a run.
@immutable
class DifficultyState {
  final int currentDistance; // In meters
  final double elapsedRunTime; // In seconds
  final double currentForwardSpeed; // In virtual pixels / second
  final double speedMultiplier;
  final DifficultyTier difficultyTier;
  final int difficultyLevel; // 0 to 4
  final double obstacleDensity; // 0.0 (low) to 1.0 (max)
  final double hazardIntensity; // Frequency scaling factor
  final double enemyIntensity; // Enemy speed/aggression factor
  final int nearMissCount;
  final int currentRunStreak;
  final double minReactionTime; // In seconds
  final String activePatternName;

  const DifficultyState({
    required this.currentDistance,
    required this.elapsedRunTime,
    required this.currentForwardSpeed,
    required this.speedMultiplier,
    required this.difficultyTier,
    required this.difficultyLevel,
    required this.obstacleDensity,
    required this.hazardIntensity,
    required this.enemyIntensity,
    required this.nearMissCount,
    required this.currentRunStreak,
    required this.minReactionTime,
    required this.activePatternName,
  });

  /// Factory for initial run state at 0 meters
  factory DifficultyState.initial({double baseSpeed = 250.0}) {
    return DifficultyState(
      currentDistance: 0,
      elapsedRunTime: 0.0,
      currentForwardSpeed: baseSpeed,
      speedMultiplier: 1.0,
      difficultyTier: DifficultyTier.initiate,
      difficultyLevel: 0,
      obstacleDensity: 0.20,
      hazardIntensity: 0.20,
      enemyIntensity: 0.20,
      nearMissCount: 0,
      currentRunStreak: 0,
      minReactionTime: 1.50,
      activePatternName: 'initial_safe_haven',
    );
  }

  DifficultyState copyWith({
    int? currentDistance,
    double? elapsedRunTime,
    double? currentForwardSpeed,
    double? speedMultiplier,
    DifficultyTier? difficultyTier,
    int? difficultyLevel,
    double? obstacleDensity,
    double? hazardIntensity,
    double? enemyIntensity,
    int? nearMissCount,
    int? currentRunStreak,
    double? minReactionTime,
    String? activePatternName,
  }) {
    return DifficultyState(
      currentDistance: currentDistance ?? this.currentDistance,
      elapsedRunTime: elapsedRunTime ?? this.elapsedRunTime,
      currentForwardSpeed: currentForwardSpeed ?? this.currentForwardSpeed,
      speedMultiplier: speedMultiplier ?? this.speedMultiplier,
      difficultyTier: difficultyTier ?? this.difficultyTier,
      difficultyLevel: difficultyLevel ?? this.difficultyLevel,
      obstacleDensity: obstacleDensity ?? this.obstacleDensity,
      hazardIntensity: hazardIntensity ?? this.hazardIntensity,
      enemyIntensity: enemyIntensity ?? this.enemyIntensity,
      nearMissCount: nearMissCount ?? this.nearMissCount,
      currentRunStreak: currentRunStreak ?? this.currentRunStreak,
      minReactionTime: minReactionTime ?? this.minReactionTime,
      activePatternName: activePatternName ?? this.activePatternName,
    );
  }

  @override
  String toString() =>
      'DifficultyState(dist: ${currentDistance}m, speed: ${currentForwardSpeed.toStringAsFixed(1)}px/s '
      '(${speedMultiplier.toStringAsFixed(2)}x), tier: ${difficultyTier.name}, density: ${obstacleDensity.toStringAsFixed(2)})';
}
