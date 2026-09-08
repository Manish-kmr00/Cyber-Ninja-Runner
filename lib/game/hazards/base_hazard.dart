import 'package:flame/components.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';

abstract class BaseHazard extends PositionComponent {
  final ObstacleType obstacleType;
  final DeathType deathType;

  BaseHazard({
    required Vector2 position,
    required Vector2 size,
    required this.obstacleType,
    required this.deathType,
    Anchor anchor = Anchor.topLeft,
  }) : super(position: position, size: size, anchor: anchor, priority: 20);

  /// Returns the world position accounting for parent chunk offset.
  Vector2 get worldPosition {
    if (parent is PositionComponent) {
      return (parent as PositionComponent).position + position;
    }
    return position;
  }

  /// Checks if player collides or is caught by this hazard. Returns true if lethal.
  bool checkCollision(RunnerPlayer player);
}
