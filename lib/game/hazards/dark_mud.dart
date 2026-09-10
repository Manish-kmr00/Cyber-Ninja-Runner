import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Hazard pit that traps and sinks the player.
class DarkMud extends BaseHazard {
  DarkMud({required super.position, required double width})
    : super(
        size: Vector2(width, 24),
        obstacleType: ObstacleType.darkMud,
        deathType: DeathType.sunkInDarkMud,
        anchor: Anchor.bottomLeft,
      );

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isInvisibilityActive || player.isSafeGroundActive) return false;

    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2,
      player.position.y - player.size.y,
      player.size.x,
      player.size.y,
    );
    final pos = worldPosition;
    final mudRect = Rect.fromLTWH(pos.x, pos.y - size.y, size.x, size.y);
    return pRect.overlaps(mudRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    final mudPaint = Paint()
      ..color = const Color(0xFF140707)
      ..style = PaintingStyle.fill;
    canvas.drawRect(Rect.fromLTWH(0, -size.y, size.x, size.y), mudPaint);

    // Red bubbling warning indicators
    final bubblePaint = Paint()
      ..color = AppConstants.hazardRed.withValues(alpha: 0.7)
      ..style = PaintingStyle.fill;
    for (double x = 10; x < size.x; x += 30) {
      canvas.drawCircle(Offset(x, -size.y / 2), 3.0, bubblePaint);
    }
  }
}
