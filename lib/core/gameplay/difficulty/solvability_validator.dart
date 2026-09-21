import 'dart:math';
import 'difficulty_config.dart';

/// Obstacle action type required by the ninja to survive.
enum ObstacleRequiredAction {
  jump, // Over ground barrier or stakes
  slide, // Under low pipe or high laser gate
  slash, // Katana strike on enemy / drone
  gapJump, // Chasm pit jump
  elevatedPath, // Optional elevated catwalk
  stealthHide, // Shadow haven concealment
  none, // Safe passage / empty runway
}

/// A prospective obstacle placement in virtual chunk coordinates.
class ProspectiveHazardPlacement {
  final double xOffset;
  final double width;
  final ObstacleRequiredAction requiredAction;
  final bool isAirborne;
  final bool isLethal;

  const ProspectiveHazardPlacement({
    required this.xOffset,
    required this.width,
    required this.requiredAction,
    this.isAirborne = false,
    this.isLethal = true,
  });

  double get rightEdge => xOffset + width;
}

/// Solvability and fairness validation engine.
/// Enforces kinematic rules, minimum reaction windows, and anti-overlap constraints
/// to guarantee that every generated track chunk is 100% beatable through player skill.
class SolvabilityValidator {
  /// Calculates minimum safe travel distance in virtual pixels for a given forward speed
  /// and target reaction time in seconds.
  static double calculateSafeDistance({
    required double currentSpeed,
    required double reactionTimeSeconds,
  }) {
    return max(
      DifficultyConfig.minObstaclePhysicalGap,
      currentSpeed * reactionTimeSeconds,
    );
  }

  /// Validates whether a prospective hazard placement is physically solvable
  /// given the previous hazard and the player's current kinematics.
  static bool validateSequence({
    required ProspectiveHazardPlacement? previousHazard,
    required ProspectiveHazardPlacement currentHazard,
    required double currentSpeed,
    required double minReactionTime,
    required bool hasPit,
    required double pitStartX,
    required double pitWidth,
  }) {
    // 1. Boundary & Overlap Check: Hazards cannot physically overlap
    if (previousHazard != null) {
      if (currentHazard.xOffset < previousHazard.rightEdge + 20.0) {
        return false; // Physical bounding box collision
      }

      final physicalGap = currentHazard.xOffset - previousHazard.rightEdge;
      final requiredGap = calculateSafeDistance(
        currentSpeed: currentSpeed,
        reactionTimeSeconds: minReactionTime,
      );

      // Enforce reaction distance for consecutive lethal obstacles
      if (previousHazard.isLethal && currentHazard.isLethal) {
        if (physicalGap < requiredGap * 0.75) {
          // Insufficient physical distance for human reaction window
          return false;
        }
      }

      // 2. Kinematic Constraint: Jump -> Slide
      // Ninja requires landing and touch-down time before beginning slide
      if (previousHazard.requiredAction == ObstacleRequiredAction.jump &&
          currentHazard.requiredAction == ObstacleRequiredAction.slide) {
        // Ninja jump duration ~0.70s - 0.80s. At speed 250px/s, travels ~180-200px.
        final minJumpToSlideDistance = max(
          180.0,
          currentSpeed * DifficultyConfig.minJumpLandingRecoveryTime + 130.0,
        );
        if (physicalGap < minJumpToSlideDistance) {
          return false; // Low pipe would clip player mid-air during jump descent!
        }
      }

      // 3. Kinematic Constraint: Slide -> Jump
      // Ninja requires slide stand-up buffer before initiating full vertical jump
      if (previousHazard.requiredAction == ObstacleRequiredAction.slide &&
          (currentHazard.requiredAction == ObstacleRequiredAction.jump ||
              currentHazard.requiredAction == ObstacleRequiredAction.gapJump)) {
        final minSlideToJumpDistance = max(
          140.0,
          currentSpeed * DifficultyConfig.minSlideRecoveryTime + 80.0,
        );
        if (physicalGap < minSlideToJumpDistance) {
          return false; // Player cannot jump while still locked in slide animation!
        }
      }
    }

    // 4. Pit / Chasm Constraints
    if (hasPit) {
      final pitEnd = pitStartX + pitWidth;
      // No ground-anchored lethal obstacles inside an unshielded pit
      if (!currentHazard.isAirborne &&
          currentHazard.requiredAction != ObstacleRequiredAction.elevatedPath) {
        if (currentHazard.xOffset >= pitStartX - 25.0 &&
            currentHazard.xOffset <= pitEnd + 25.0) {
          return false; // Ground obstacle inside fatal pit chasm is impossible!
        }
      }

      // Pit take-off zone must have clean runway
      if (currentHazard.requiredAction == ObstacleRequiredAction.gapJump) {
        if (pitWidth > DifficultyConfig.maxJumpGapDistance) {
          return false; // Chasm wider than ninja jump arc
        }
      }
    }

    return true;
  }
}
