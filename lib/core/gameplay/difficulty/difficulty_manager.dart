import 'dart:math';
import 'package:flutter/foundation.dart';
import 'difficulty_config.dart';
import 'difficulty_state.dart';
import 'obstacle_pattern_system.dart';

/// Central Director managing the deterministic skill-based difficulty progression.
/// Computes continuous forward speed, obstacle density, reaction time windows,
/// tracks near-misses, coordinates obstacle patterns, and triggers milestone events.
class DifficultyManager extends ChangeNotifier {
  final ObstaclePatternSystem patternSystem;

  DifficultyState _state;
  DifficultyState get state => _state;

  // Milestone triggers (ensures each milestone fires exactly once per run)
  final Set<int> _triggeredMilestones = {};
  void Function(MilestoneThreshold milestone)? onMilestoneReached;
  void Function(int cpBonus)? onNearMiss;

  DifficultyManager({Random? random})
    : patternSystem = ObstaclePatternSystem(random: random),
      _state = DifficultyState.initial(
        baseSpeed: DifficultyConfig.baseForwardSpeed,
      );

  /// Resets difficulty state completely for a new run
  void reset() {
    _state = DifficultyState.initial(
      baseSpeed: DifficultyConfig.baseForwardSpeed,
    );
    _triggeredMilestones.clear();
    patternSystem.reset();
    notifyListeners();
  }

  /// Updates difficulty progression based on real-time delta time and player distance
  void update(double dt, int distanceMeters) {
    final newElapsedTime = _state.elapsedRunTime + dt;
    final newSpeedMultiplier = calculateSpeedMultiplier(distanceMeters);
    final newForwardSpeed = min(
      DifficultyConfig.absoluteMaxSpeed,
      DifficultyConfig.baseForwardSpeed * newSpeedMultiplier,
    );

    // Compute tier and level
    final DifficultyTier tier;
    final int level;
    final double density;
    final double minReact;

    if (distanceMeters < 500) {
      tier = DifficultyTier.initiate;
      level = 0;
      density = 0.20 + (distanceMeters / 500.0) * 0.15; // 0.20 -> 0.35
      minReact = DifficultyConfig.reactionTimeEasy;
    } else if (distanceMeters < 1500) {
      tier = DifficultyTier.runner;
      level = 1;
      final t = (distanceMeters - 500) / 1000.0;
      density = 0.35 + t * 0.20; // 0.35 -> 0.55
      minReact = DifficultyConfig.reactionTimeNormal;
    } else if (distanceMeters < 3000) {
      tier = DifficultyTier.hunter;
      level = 2;
      final t = (distanceMeters - 1500) / 1500.0;
      density = 0.55 + t * 0.20; // 0.55 -> 0.75
      minReact = DifficultyConfig.reactionTimeHard;
    } else if (distanceMeters < 5000) {
      tier = DifficultyTier.assassin;
      level = 3;
      final t = (distanceMeters - 3000) / 2000.0;
      density = 0.75 + t * 0.15; // 0.75 -> 0.90
      minReact = DifficultyConfig.reactionTimeExpert;
    } else {
      tier = DifficultyTier.cyberMaster;
      level = 4;
      density = 0.95;
      minReact = DifficultyConfig.reactionTimeExpert;
    }

    final hazardIntensity = (density * 1.05).clamp(0.20, 1.0);
    final enemyIntensity = (0.25 + (level * 0.18)).clamp(0.25, 1.0);

    _state = _state.copyWith(
      currentDistance: distanceMeters,
      elapsedRunTime: newElapsedTime,
      currentForwardSpeed: newForwardSpeed,
      speedMultiplier: newSpeedMultiplier,
      difficultyTier: tier,
      difficultyLevel: level,
      obstacleDensity: density,
      hazardIntensity: hazardIntensity,
      enemyIntensity: enemyIntensity,
      minReactionTime: minReact,
    );

    // Check Milestones
    for (final milestone in DifficultyConfig.milestones) {
      if (distanceMeters >= milestone.distanceMeters &&
          !_triggeredMilestones.contains(milestone.distanceMeters)) {
        _triggeredMilestones.add(milestone.distanceMeters);
        onMilestoneReached?.call(milestone);
      }
    }
  }

  /// Calculates smooth forward speed multiplier using piecewise linear interpolation
  /// between DifficultyConfig.speedCurve waypoints.
  static double calculateSpeedMultiplier(int distanceMeters) {
    final curve = DifficultyConfig.speedCurve;
    final dist = distanceMeters.toDouble();

    if (dist <= curve.first.distanceMeters) {
      return curve.first.speedMultiplier;
    }
    if (dist >= curve.last.distanceMeters) {
      return curve.last.speedMultiplier;
    }

    for (int i = 0; i < curve.length - 1; i++) {
      final pA = curve[i];
      final pB = curve[i + 1];

      if (dist >= pA.distanceMeters && dist <= pB.distanceMeters) {
        final segmentLength = pB.distanceMeters - pA.distanceMeters;
        if (segmentLength <= 0) return pB.speedMultiplier;
        final t = (dist - pA.distanceMeters) / segmentLength;
        // Smoothstep interpolation to eliminate velocity derivative discontinuities:
        final smoothT = t * t * (3.0 - 2.0 * t);
        final mult =
            pA.speedMultiplier +
            smoothT * (pB.speedMultiplier - pA.speedMultiplier);
        return min(DifficultyConfig.maxSpeedMultiplier, mult);
      }
    }

    return 1.0;
  }

  /// Convenience query for player physics speed
  double getCurrentSpeed(int distanceMeters) {
    final mult = calculateSpeedMultiplier(distanceMeters);
    return min(
      DifficultyConfig.absoluteMaxSpeed,
      DifficultyConfig.baseForwardSpeed * mult,
    );
  }

  /// Records a successful near-miss event without collision
  void recordNearMiss() {
    _state = _state.copyWith(
      nearMissCount: _state.nearMissCount + 1,
      currentRunStreak: _state.currentRunStreak + 1,
    );
    onNearMiss?.call(DifficultyConfig.nearMissCPBonus);
    notifyListeners();
  }

  /// Updates active pattern name for debug telemetry
  void setActivePatternName(String name) {
    _state = _state.copyWith(activePatternName: name);
  }
}
