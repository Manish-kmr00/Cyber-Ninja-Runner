import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Vertical crushing pillar that moves down and up rhythmically.
class DeathColumn extends BaseHazard {
  final double maxHeight;
  final double cycleSpeed;

  double startY = 0;
  double timer = 0.0;
  double currentHeight = 0.0;

  DeathColumn({
    required Vector2 position,
    this.maxHeight = 220.0,
    this.cycleSpeed = 2.0,
  }) : super(
         position: position,
         size: Vector2(60, maxHeight),
         obstacleType: ObstacleType.deathColumn,
         deathType: DeathType.crushedByColumn,
         anchor: Anchor.topCenter,
       ) {
    startY = position.y;
  }

  @override
  void update(double dt) {
    super.update(dt);
    timer += dt * cycleSpeed;
    // Oscillate height between 40px and maxHeight
    currentHeight = 40.0 + (sin(timer) * 0.5 + 0.5) * (maxHeight - 40.0);
  }

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
    final colRect = Rect.fromLTWH(
      pos.x - size.x / 2,
      pos.y,
      size.x,
      currentHeight,
    );
    return pRect.overlaps(colRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    final columnPaint = Paint()
      ..color = const Color(0xFF232731)
      ..style = PaintingStyle.fill;

    final rrect = RRect.fromRectAndRadius(
      Rect.fromLTWH(-size.x / 2, 0, size.x, currentHeight),
      const Radius.circular(4.0),
    );
    canvas.drawRRect(rrect, columnPaint);

    // Hazard spikes at the bottom of the column
    final spikePaint = Paint()
      ..color = AppConstants.hazardRed
      ..style = PaintingStyle.fill;
    final path = Path()
      ..moveTo(-size.x / 2, currentHeight)
      ..lineTo(-size.x / 4, currentHeight + 12)
      ..lineTo(0, currentHeight)
      ..lineTo(size.x / 4, currentHeight + 12)
      ..lineTo(size.x / 2, currentHeight)
      ..close();
    canvas.drawPath(path, spikePaint);
  }
}
