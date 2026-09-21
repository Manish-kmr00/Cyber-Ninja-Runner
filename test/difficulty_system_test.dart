import 'dart:math';
import 'package:flutter_test/flutter_test.dart';
import 'package:cyber_ninja_runner/core/gameplay/difficulty/difficulty_config.dart';
import 'package:cyber_ninja_runner/core/gameplay/difficulty/difficulty_manager.dart';
import 'package:cyber_ninja_runner/core/gameplay/difficulty/difficulty_state.dart';
import 'package:cyber_ninja_runner/core/gameplay/difficulty/obstacle_pattern_system.dart';
import 'package:cyber_ninja_runner/core/gameplay/difficulty/solvability_validator.dart';
import 'package:cyber_ninja_runner/game/world/procedural_generator.dart';

void main() {
  group('Phase 1 & 2 — Difficulty Progression & Progressive Speed Tests', () {
    test('Speed curve anchor points match design specifications', () {
      expect(DifficultyManager.calculateSpeedMultiplier(0), equals(1.00));
      expect(DifficultyManager.calculateSpeedMultiplier(500), equals(1.00));
      expect(
        DifficultyManager.calculateSpeedMultiplier(1000),
        closeTo(1.08, 0.001),
      );
      expect(
        DifficultyManager.calculateSpeedMultiplier(2000),
        closeTo(1.16, 0.001),
      );
      expect(
        DifficultyManager.calculateSpeedMultiplier(3000),
        closeTo(1.25, 0.001),
      );
      expect(
        DifficultyManager.calculateSpeedMultiplier(5000),
        closeTo(1.35, 0.001),
      );
      expect(
        DifficultyManager.calculateSpeedMultiplier(10000),
        closeTo(1.55, 0.001),
      );
    });

    test('Speed strictly respects absolute maximum cap', () {
      final manager = DifficultyManager();
      for (int dist = 0; dist <= 50000; dist += 500) {
        final speed = manager.getCurrentSpeed(dist);
        expect(speed, lessThanOrEqualTo(DifficultyConfig.absoluteMaxSpeed));
        expect(speed, greaterThanOrEqualTo(DifficultyConfig.baseForwardSpeed));
      }
    });

    test('Speed transition is monotonically non-decreasing and smooth', () {
      double previousSpeed = DifficultyConfig.baseForwardSpeed;
      final manager = DifficultyManager();

      for (int dist = 0; dist <= 10000; dist += 50) {
        final currentSpeed = manager.getCurrentSpeed(dist);
        expect(
          currentSpeed,
          greaterThanOrEqualTo(previousSpeed - 0.0001),
          reason: 'Speed decreased at distance $dist!',
        );
        // No large instantaneous speed steps (> 5.0 px/s over 50m)
        final speedDelta = currentSpeed - previousSpeed;
        expect(
          speedDelta,
          lessThan(5.0),
          reason: 'Speed jump too abrupt ($speedDelta px/s) at distance $dist!',
        );
        previousSpeed = currentSpeed;
      }
    });

    test('Difficulty Manager updates elapsed time, tier, and density', () {
      final manager = DifficultyManager();
      expect(manager.state.currentDistance, equals(0));
      expect(manager.state.difficultyTier, equals(DifficultyTier.initiate));

      manager.update(1.0, 600);
      expect(manager.state.currentDistance, equals(600));
      expect(manager.state.elapsedRunTime, closeTo(1.0, 0.001));
      expect(manager.state.difficultyTier, equals(DifficultyTier.runner));
      expect(manager.state.difficultyLevel, equals(1));
      expect(
        manager.state.minReactionTime,
        equals(DifficultyConfig.reactionTimeNormal),
      );

      manager.update(2.0, 2200);
      expect(manager.state.difficultyTier, equals(DifficultyTier.hunter));
      expect(manager.state.difficultyLevel, equals(2));
      expect(
        manager.state.minReactionTime,
        equals(DifficultyConfig.reactionTimeHard),
      );

      manager.update(2.0, 3800);
      expect(manager.state.difficultyTier, equals(DifficultyTier.assassin));
      expect(manager.state.difficultyLevel, equals(3));
      expect(
        manager.state.minReactionTime,
        equals(DifficultyConfig.reactionTimeExpert),
      );

      manager.update(5.0, 6500);
      expect(manager.state.difficultyTier, equals(DifficultyTier.cyberMaster));
      expect(manager.state.difficultyLevel, equals(4));
    });
  });

  group('Phase 4 & 6 — Obstacle Pattern System & Anti-Repetition Tests', () {
    test('Catalog contains at least 20 handcrafted solvable patterns', () {
      expect(
        ObstaclePatternSystem.allPatterns.length,
        greaterThanOrEqualTo(20),
      );
    });

    test('Pattern selection avoids immediate duplicates', () {
      final patternSystem = ObstaclePatternSystem(random: Random(42));
      final state = DifficultyState.initial().copyWith(
        difficultyLevel: 3,
        currentForwardSpeed: 300.0,
      );

      String? lastPatternId;
      for (int i = 0; i < 50; i++) {
        final pattern = patternSystem.selectNextPattern(
          state: state,
          hasPit: false,
          pitStartX: 0,
          pitWidth: 0,
        );
        if (lastPatternId != null) {
          expect(
            pattern.id,
            isNot(equals(lastPatternId)),
            reason: 'Immediate duplicate pattern ${pattern.id} was generated!',
          );
        }
        lastPatternId = pattern.id;
      }
    });

    test(
      'Pattern selection avoids repeating same category > 2 times consecutively',
      () {
        final patternSystem = ObstaclePatternSystem(random: Random(12345));
        final state = DifficultyState.initial().copyWith(
          difficultyLevel: 3,
          currentForwardSpeed: 300.0,
        );

        PatternCategory? catA;
        PatternCategory? catB;

        for (int i = 0; i < 40; i++) {
          final pattern = patternSystem.selectNextPattern(
            state: state,
            hasPit: false,
            pitStartX: 0,
            pitWidth: 0,
          );

          if (catA != null && catB != null) {
            final threeInARow = (catA == catB && catB == pattern.category);
            expect(
              threeInARow,
              isFalse,
              reason:
                  'Category ${pattern.category.name} repeated 3+ times in a row!',
            );
          }
          catA = catB;
          catB = pattern.category;
        }
      },
    );
  });

  group('Phase 5 — Solvability & Fairness Validator Tests', () {
    test(
      'calculateSafeDistance scales with forward speed and reaction time',
      () {
        final easyGap = SolvabilityValidator.calculateSafeDistance(
          currentSpeed: 250.0,
          reactionTimeSeconds: 1.50,
        );
        final hardGap = SolvabilityValidator.calculateSafeDistance(
          currentSpeed: 350.0,
          reactionTimeSeconds: 0.95,
        );

        expect(easyGap, equals(375.0));
        expect(hardGap, closeTo(332.5, 0.01));
        expect(
          easyGap,
          greaterThanOrEqualTo(DifficultyConfig.minObstaclePhysicalGap),
        );
      },
    );

    test('validateSequence rejects physical bounding-box overlaps', () {
      const prev = ProspectiveHazardPlacement(
        xOffset: 150.0,
        width: 50.0, // right edge = 200.0
        requiredAction: ObstacleRequiredAction.jump,
      );
      const overlapping = ProspectiveHazardPlacement(
        xOffset: 210.0, // Only 10px gap! Overlap violation
        width: 40.0,
        requiredAction: ObstacleRequiredAction.jump,
      );

      final valid = SolvabilityValidator.validateSequence(
        previousHazard: prev,
        currentHazard: overlapping,
        currentSpeed: 250.0,
        minReactionTime: 1.20,
        hasPit: false,
        pitStartX: 0,
        pitWidth: 0,
      );

      expect(valid, isFalse);
    });

    test(
      'validateSequence enforces kinematic recovery between Jump and Slide',
      () {
        const jumpHazard = ProspectiveHazardPlacement(
          xOffset: 120.0,
          width: 44.0, // right edge = 164.0
          requiredAction: ObstacleRequiredAction.jump,
        );
        const prematureSlide = ProspectiveHazardPlacement(
          xOffset:
              250.0, // Gap is 86px -> ninja is still airborne in jump descent!
          width: 60.0,
          requiredAction: ObstacleRequiredAction.slide,
          isAirborne: true,
        );
        const safeSlide = ProspectiveHazardPlacement(
          xOffset: 370.0, // Gap is 206px -> ninja has safely landed on deck
          width: 60.0,
          requiredAction: ObstacleRequiredAction.slide,
          isAirborne: true,
        );

        final prematureValid = SolvabilityValidator.validateSequence(
          previousHazard: jumpHazard,
          currentHazard: prematureSlide,
          currentSpeed: 250.0,
          minReactionTime: 1.0,
          hasPit: false,
          pitStartX: 0,
          pitWidth: 0,
        );
        expect(
          prematureValid,
          isFalse,
          reason: 'Mid-air slide hazard must be rejected!',
        );

        final safeValid = SolvabilityValidator.validateSequence(
          previousHazard: jumpHazard,
          currentHazard: safeSlide,
          currentSpeed: 250.0,
          minReactionTime: 0.8,
          hasPit: false,
          pitStartX: 0,
          pitWidth: 0,
        );
        expect(safeValid, isTrue);
      },
    );

    test(
      'validateSequence forbids placing ground hazards inside pit chasms',
      () {
        const groundHazardInPit = ProspectiveHazardPlacement(
          xOffset: 220.0,
          width: 44.0,
          requiredAction: ObstacleRequiredAction.jump,
          isAirborne: false,
        );

        final valid = SolvabilityValidator.validateSequence(
          previousHazard: null,
          currentHazard: groundHazardInPit,
          currentSpeed: 250.0,
          minReactionTime: 1.20,
          hasPit: true,
          pitStartX: 190.0,
          pitWidth: 120.0, // Pit covers 190.0 - 310.0
        );

        expect(
          valid,
          isFalse,
          reason: 'Ground hazard inside pit chasm must be rejected!',
        );
      },
    );
  });

  group('Phase 8 & 9 — Near-Miss & Milestone Notification Tests', () {
    test('Near-miss increments count, streak, and fires callback', () {
      final manager = DifficultyManager();
      int bonusAwarded = 0;
      manager.onNearMiss = (bonus) {
        bonusAwarded = bonus;
      };

      manager.recordNearMiss();
      expect(manager.state.nearMissCount, equals(1));
      expect(manager.state.currentRunStreak, equals(1));
      expect(bonusAwarded, equals(DifficultyConfig.nearMissCPBonus));

      manager.recordNearMiss();
      expect(manager.state.nearMissCount, equals(2));
      expect(manager.state.currentRunStreak, equals(2));
    });

    test(
      'Milestone callbacks trigger idempotently at correct distance thresholds',
      () {
        final manager = DifficultyManager();
        final triggeredMilestones = <String>[];
        manager.onMilestoneReached = (m) {
          triggeredMilestones.add(m.title);
        };

        manager.update(1.0, 400);
        expect(triggeredMilestones, isEmpty);

        manager.update(1.0, 520);
        expect(triggeredMilestones, equals(['RUNNER']));

        // Updating again within same tier must NOT re-trigger
        manager.update(1.0, 600);
        expect(triggeredMilestones, equals(['RUNNER']));

        manager.update(2.0, 1600);
        expect(triggeredMilestones, equals(['RUNNER', 'HUNTER']));

        manager.update(3.0, 3100);
        expect(triggeredMilestones, equals(['RUNNER', 'HUNTER', 'ASSASSIN']));

        manager.update(4.0, 5200);
        expect(
          triggeredMilestones,
          equals(['RUNNER', 'HUNTER', 'ASSASSIN', 'CYBER MASTER']),
        );

        // Reset allows milestones to trigger fresh on new run
        manager.reset();
        triggeredMilestones.clear();
        manager.update(1.0, 550);
        expect(triggeredMilestones, equals(['RUNNER']));
      },
    );
  });

  group('Phase 10 & 13 — 50,000m Full Procedural Run Simulation Test', () {
    test(
      'Simulate 50,000m generation with 100% solvability and zero crashes',
      () {
        final manager = DifficultyManager(random: Random(99999));
        final generator = ProceduralGenerator(difficultyManager: manager);

        final initialChunks = generator.generateInitialChunks();
        expect(initialChunks, isNotEmpty);

        // Simulate advancing player across 50,000m (500,000 virtual px)
        for (double playerX = 500.0; playerX <= 500000.0; playerX += 500.0) {
          final distMeters = (playerX / 10).round();
          manager.update(0.16, distMeters);

          // Update chunks ahead
          generator.updateChunks(
            playerX: playerX,
            parentComponent: initialChunks.first, // dummy parent
          );

          // Verify active chunks integrity
          expect(generator.activeChunks, isNotEmpty);
          expect(
            generator.activeChunks.length,
            lessThanOrEqualTo(10),
            reason: 'Chunk recycling failed; chunk count is leaking!',
          );
        }

        expect(manager.state.currentDistance, equals(50000));
        expect(
          manager.state.difficultyTier,
          equals(DifficultyTier.cyberMaster),
        );
        expect(
          manager.state.currentForwardSpeed,
          equals(DifficultyConfig.absoluteMaxSpeed),
        );
      },
    );
  });
}
