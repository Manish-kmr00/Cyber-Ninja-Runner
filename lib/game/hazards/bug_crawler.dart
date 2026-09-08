import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Fast ground crawler triggered by proximity tripwires.
class BugCrawler extends BaseHazard {
  final double speed;
  bool isAwake = false;

  BugCrawler({required super.position, this.speed = 220.0})
    : super(
        size: Vector2(28, 16),
        obstacleType: ObstacleType.bugCrawler,
        deathType: DeathType.hitByBug,
        anchor: Anchor.bottomCenter,
      );

  @override
  void update(double dt) {
    super.update(dt);
    if (isAwake) {
      position.x -= speed * dt;
    }
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    final pos = worldPosition;
    // Proximity trigger (awakes bug when player gets within 350px)
    if (!isAwake && (player.position.x - pos.x).abs() < 350) {
      isAwake = true;
    }

    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2,
      player.position.y - player.size.y,
      player.size.x,
      player.size.y,
    );
    final bRect = Rect.fromLTWH(
      pos.x - size.x / 2,
      pos.y - size.y,
      size.x,
      size.y,
    );
    return pRect.overlaps(bRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    canvas.save();
    canvas.translate(size.x / 2, size.y);

    final bugPaint = Paint()
      ..color = AppConstants.hazardRed
      ..style = PaintingStyle.fill;

    // Dome carapace
    canvas.drawOval(
      Rect.fromLTWH(-size.x / 2, -size.y, size.x, size.y),
      bugPaint,
    );

    // Glowing red eyes
    final eyePaint = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(-size.x / 4, -size.y * 0.6), 2.5, eyePaint);

    canvas.restore();
  }
}
