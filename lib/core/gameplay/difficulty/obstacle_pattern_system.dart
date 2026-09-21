import 'dart:math';
import 'difficulty_state.dart';
import 'solvability_validator.dart';

/// Pattern archetype categories for variety tracking
enum PatternCategory {
  jump,
  slide,
  gap,
  enemy,
  projectile,
  movingHazard,
  combo,
  riskReward,
}

/// A specific hazard spawn instruction inside an obstacle pattern.
class PatternHazardDef {
  final double relX; // Position relative to chunk start (0 to 500)
  final ObstacleRequiredAction action;
  final String
  hazardType; // 'barrier', 'pipe', 'stakes', 'laser_high', 'laser_low', 'drone', 'bug', 'droid', 'cannon', 'platform'
  final double width;
  final double height;
  final double yOffset; // Relative to ground level
  final bool isAirborne;
  final int cpReward; // For risk/reward routes

  const PatternHazardDef({
    required this.relX,
    required this.action,
    required this.hazardType,
    this.width = 44.0,
    this.height = 40.0,
    this.yOffset = 0.0,
    this.isAirborne = false,
    this.cpReward = 0,
  });
}

/// Definition of an obstacle pattern containing 1 to 4 synchronized, solvable hazard placements.
class ObstaclePattern {
  final String id;
  final String name;
  final PatternCategory category;
  final int
  minTier; // 0 = initiate, 1 = runner, 2 = hunter, 3 = assassin, 4 = cyberMaster
  final List<PatternHazardDef> hazards;
  final bool requiresPit;
  final bool forbidsPit;
  final bool hasRiskRewardRoute;

  const ObstaclePattern({
    required this.id,
    required this.name,
    required this.category,
    required this.minTier,
    required this.hazards,
    this.requiresPit = false,
    this.forbidsPit = false,
    this.hasRiskRewardRoute = false,
  });
}

/// Catalog of 22+ handcrafted, kinematics-verified, solvable obstacle patterns.
class ObstaclePatternSystem {
  static final List<ObstaclePattern> allPatterns = [
    // Pattern 01: Single jump obstacle
    const ObstaclePattern(
      id: 'P01_SINGLE_JUMP',
      name: 'Single Road Barrier',
      category: PatternCategory.jump,
      minTier: 0,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 240.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 44.0,
        ),
      ],
    ),

    // Pattern 02: Two separated jump obstacles
    const ObstaclePattern(
      id: 'P02_DOUBLE_JUMP_SEPARATED',
      name: 'Dual Ground Stakes',
      category: PatternCategory.jump,
      minTier: 1,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 160.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'stakes',
          width: 48.0,
        ),
        PatternHazardDef(
          relX: 370.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 44.0,
        ),
      ],
    ),

    // Pattern 03: Low obstacle requiring slide
    const ObstaclePattern(
      id: 'P03_LOW_SLIDE',
      name: 'Overhead Steam Pipe',
      category: PatternCategory.slide,
      minTier: 0,
      hazards: [
        PatternHazardDef(
          relX: 230.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 60.0,
          height: 24.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 04: Jump -> Slide
    const ObstaclePattern(
      id: 'P04_JUMP_THEN_SLIDE',
      name: 'Barrier into Low Pipe',
      category: PatternCategory.combo,
      minTier: 1,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 140.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 44.0,
        ),
        PatternHazardDef(
          relX: 360.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 60.0,
          height: 24.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 05: Slide -> Jump
    const ObstaclePattern(
      id: 'P05_SLIDE_THEN_JUMP',
      name: 'High Laser into Stakes',
      category: PatternCategory.combo,
      minTier: 1,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 150.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'laser_high',
          width: 46.0,
          height: 90.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 350.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'stakes',
          width: 48.0,
        ),
      ],
    ),

    // Pattern 06: Short gap
    const ObstaclePattern(
      id: 'P06_SHORT_GAP',
      name: 'Rooftop Chasm Gap',
      category: PatternCategory.gap,
      minTier: 1,
      requiresPit: true,
      hazards: [
        PatternHazardDef(
          relX: 250.0,
          action: ObstacleRequiredAction.gapJump,
          hazardType: 'chasm_pit',
          width: 140.0,
        ),
      ],
    ),

    // Pattern 07: Double obstacle (low pipe overhead + high laser)
    const ObstaclePattern(
      id: 'P07_DOUBLE_OBSTACLE',
      name: 'Laser Barrier Synchronized',
      category: PatternCategory.combo,
      minTier: 2,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 160.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 60.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 370.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'laser_low',
          width: 46.0,
          height: 90.0,
        ),
      ],
    ),

    // Pattern 08: Obstacle + Enemy
    const ObstaclePattern(
      id: 'P08_OBSTACLE_AND_ENEMY',
      name: 'Cargo Vault into Bug Crawler',
      category: PatternCategory.enemy,
      minTier: 2,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 160.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 50.0,
        ),
        PatternHazardDef(
          relX: 380.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'bug',
          width: 42.0,
        ),
      ],
    ),

    // Pattern 09: Enemy + Jump Obstacle
    const ObstaclePattern(
      id: 'P09_ENEMY_THEN_JUMP',
      name: 'Bug Crawler into Spikes',
      category: PatternCategory.enemy,
      minTier: 2,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 170.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'bug',
          width: 42.0,
        ),
        PatternHazardDef(
          relX: 360.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'stakes',
          width: 48.0,
        ),
      ],
    ),

    // Pattern 10: Enemy Projectile + Obstacle
    const ObstaclePattern(
      id: 'P10_PROJECTILE_AND_BARRIER',
      name: 'Cyber Cannon Artillery Barrier',
      category: PatternCategory.projectile,
      minTier: 2,
      hazards: [
        PatternHazardDef(
          relX: 250.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'cannon',
          width: 50.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 370.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 44.0,
        ),
      ],
    ),

    // Pattern 11: Two hazards with timing separation
    const ObstaclePattern(
      id: 'P11_TIMED_SEPARATION',
      name: 'Hover Drone over Ground Stakes',
      category: PatternCategory.movingHazard,
      minTier: 2,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 170.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'drone',
          width: 40.0,
          height: 32.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 370.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'stakes',
          width: 48.0,
        ),
      ],
    ),

    // Pattern 12: Safe route + CP reward route
    const ObstaclePattern(
      id: 'P12_RISK_REWARD_CATWALK',
      name: 'High Skyway CP Route',
      category: PatternCategory.riskReward,
      minTier: 1,
      hasRiskRewardRoute: true,
      hazards: [
        PatternHazardDef(
          relX: 160.0,
          action: ObstacleRequiredAction.elevatedPath,
          hazardType: 'platform',
          width: 180.0,
          isAirborne: true,
          cpReward: 4,
        ),
        PatternHazardDef(
          relX: 250.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 44.0,
        ),
      ],
    ),

    // Pattern 13: Moving hazard
    const ObstaclePattern(
      id: 'P13_MOVING_DROID',
      name: 'Patrol Sentry Droid',
      category: PatternCategory.movingHazard,
      minTier: 1,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 250.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'droid',
          width: 48.0,
        ),
      ],
    ),

    // Pattern 14: Jump -> Enemy -> Landing hazard
    const ObstaclePattern(
      id: 'P14_JUMP_ENEMY_LANDING',
      name: 'Ramp Drop over Bug into Barrier',
      category: PatternCategory.combo,
      minTier: 3,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 130.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 40.0,
        ),
        PatternHazardDef(
          relX: 270.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'bug',
          width: 42.0,
        ),
        PatternHazardDef(
          relX: 410.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 55.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 15: Slide -> Projectile
    const ObstaclePattern(
      id: 'P15_SLIDE_THEN_PROJECTILE',
      name: 'Low Pipe under Artillery Cannon',
      category: PatternCategory.projectile,
      minTier: 2,
      hazards: [
        PatternHazardDef(
          relX: 160.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 60.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 330.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'cannon',
          width: 50.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 16: Alternating hazard timing
    const ObstaclePattern(
      id: 'P16_ALTERNATING_TIMING',
      name: 'Slide -> Jump -> Slide Gauntlet',
      category: PatternCategory.combo,
      minTier: 3,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 120.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 55.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 270.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 40.0,
        ),
        PatternHazardDef(
          relX: 420.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'laser_high',
          width: 44.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 17: Short reaction sequence
    const ObstaclePattern(
      id: 'P17_SHORT_REACTION',
      name: 'Drone Intercept into Pipe',
      category: PatternCategory.combo,
      minTier: 2,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 180.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'drone',
          width: 40.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 360.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 55.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 18: Longer combo sequence
    const ObstaclePattern(
      id: 'P18_LONGER_COMBO',
      name: 'Vault -> Slide -> Aerial Slash',
      category: PatternCategory.combo,
      minTier: 3,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 110.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 40.0,
        ),
        PatternHazardDef(
          relX: 260.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'pipe',
          width: 55.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 410.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'drone',
          width: 40.0,
          isAirborne: true,
        ),
      ],
    ),

    // Pattern 19: High-risk CP route
    const ObstaclePattern(
      id: 'P19_HIGH_RISK_CP',
      name: 'Chasm Bridge Triple CP Vault',
      category: PatternCategory.riskReward,
      minTier: 2,
      requiresPit: true,
      hasRiskRewardRoute: true,
      hazards: [
        PatternHazardDef(
          relX: 180.0,
          action: ObstacleRequiredAction.elevatedPath,
          hazardType: 'platform',
          width: 140.0,
          isAirborne: true,
          cpReward: 6,
        ),
      ],
    ),

    // Pattern 20: Expert combo
    const ObstaclePattern(
      id: 'P20_EXPERT_COMBO',
      name: 'Master Reflex Gauntlet',
      category: PatternCategory.combo,
      minTier: 3,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 100.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'stakes',
          width: 45.0,
        ),
        PatternHazardDef(
          relX: 250.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'laser_high',
          width: 45.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 400.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'droid',
          width: 46.0,
        ),
      ],
    ),

    // Pattern 21: Dual laser gauntlet
    const ObstaclePattern(
      id: 'P21_DUAL_LASER_GAUNTLET',
      name: 'High-Low Laser Security Grid',
      category: PatternCategory.combo,
      minTier: 3,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 160.0,
          action: ObstacleRequiredAction.slide,
          hazardType: 'laser_high',
          width: 46.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 360.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'laser_low',
          width: 46.0,
        ),
      ],
    ),

    // Pattern 22: Cyber Titan Vanguard
    const ObstaclePattern(
      id: 'P22_TITAN_VANGUARD',
      name: 'Sentry Drone Escort with Stakes',
      category: PatternCategory.movingHazard,
      minTier: 3,
      forbidsPit: true,
      hazards: [
        PatternHazardDef(
          relX: 170.0,
          action: ObstacleRequiredAction.slash,
          hazardType: 'drone',
          width: 40.0,
          isAirborne: true,
        ),
        PatternHazardDef(
          relX: 370.0,
          action: ObstacleRequiredAction.jump,
          hazardType: 'barrier',
          width: 44.0,
        ),
      ],
    ),
  ];

  // Anti-Repetition Tracking (FIFO queues)
  final List<String> _recentPatternIds = [];
  final List<PatternCategory> _recentCategories = [];
  final Random _rng;

  ObstaclePatternSystem({Random? random}) : _rng = random ?? Random();

  void reset() {
    _recentPatternIds.clear();
    _recentCategories.clear();
  }

  /// Selects the next viable pattern adhering to difficulty tier, solvability rules,
  /// pit availability, and anti-repetition variety constraints.
  ObstaclePattern selectNextPattern({
    required DifficultyState state,
    required bool hasPit,
    required double pitStartX,
    required double pitWidth,
  }) {
    // 1. Filter by Difficulty Tier and Pit constraints
    final candidates = allPatterns.where((p) {
      if (p.minTier > state.difficultyLevel) return false;
      if (hasPit && p.forbidsPit) return false;
      if (!hasPit && p.requiresPit) return false;

      // Anti-Repetition Rule 1: Never repeat the immediate previous pattern
      if (_recentPatternIds.isNotEmpty && _recentPatternIds.last == p.id) {
        return false;
      }

      // Anti-Repetition Rule 2: Avoid repeating within the last 3 patterns if alternatives exist
      if (_recentPatternIds.length >= 2 && _recentPatternIds.contains(p.id)) {
        return false;
      }

      // Anti-Repetition Rule 3: Avoid repeating same category more than 2 times consecutively
      if (_recentCategories.length >= 2 &&
          _recentCategories[_recentCategories.length - 1] == p.category &&
          _recentCategories[_recentCategories.length - 2] == p.category) {
        return false;
      }

      return true;
    }).toList();

    // Fallback if strict anti-repetition eliminates all candidates
    final pool = candidates.isNotEmpty
        ? candidates
        : allPatterns.where((p) {
            if (p.minTier > state.difficultyLevel) return false;
            if (hasPit && p.forbidsPit) return false;
            if (!hasPit && p.requiresPit) return false;
            return true;
          }).toList();

    final chosen = pool.isNotEmpty
        ? pool[_rng.nextInt(pool.length)]
        : allPatterns.first;

    // Record in history queues (capped to last 5)
    _recentPatternIds.add(chosen.id);
    if (_recentPatternIds.length > 5) {
      _recentPatternIds.removeAt(0);
    }

    _recentCategories.add(chosen.category);
    if (_recentCategories.length > 5) {
      _recentCategories.removeAt(0);
    }

    return chosen;
  }

  List<String> get recentPatternHistory => List.unmodifiable(_recentPatternIds);
}
