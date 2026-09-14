import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Aerial Security Surveillance Drone.
/// Hovers or patrols above the roadway.
/// Can be slashed out of the air by the Ninja's Katana,
/// or ducked under with a slide if hovering high enough!
class HoverDroneHazard extends BaseHazard {
  final double patrolDistance;
  final double patrolSpeed;
  final double minX;
  final double maxX;

  double hoverTimer = 0.0;
  double rotorTimer = 0.0;
  int direction = 1;
  bool isSliced = false;
  double sliceTimer = 0.0;

  HoverDroneHazard({
    required super.position,
    this.patrolDistance = 80.0,
    this.patrolSpeed = 70.0,
    double? minX,
    double? maxX,
    super.biome,
  }) : minX = minX ?? (position.x - patrolDistance),
       maxX = maxX ?? (position.x + patrolDistance),
       super(
         size: Vector2(38.0, 22.0),
         obstacleType: ObstacleType.hoverDrone,
         deathType: DeathType.hitByBug,
         anchor: Anchor.center,
       );

  @override
  void update(double dt) {
    super.update(dt);
    hoverTimer += dt * 3.5;
    rotorTimer += dt * 25.0;

    if (isSliced) {
      sliceTimer -= dt;
      if (sliceTimer <= 0) {
        removeFromParent();
      }
      return;
    }

    // Horizontal patrol logic
    if (patrolDistance > 10.0) {
      position.x += direction * patrolSpeed * dt;
      if (position.x >= maxX) {
        position.x = maxX;
        direction = -1;
      } else if (position.x <= minX) {
        position.x = minX;
        direction = 1;
      }
    }
  }

  void sliceAndDestroy() {
    isSliced = true;
    sliceTimer = 0.35;
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isStealthActive || isSliced) return false;

    final pos = worldPosition;
    final hoverOffsetY = sin(hoverTimer) * 6.0;
    final currentY = pos.y + hoverOffsetY;

    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2 + 10,
      player.position.y - player.size.y + 10,
      player.size.x - 20,
      player.size.y - 10,
    );

    final dRect = Rect.fromLTWH(
      pos.x - size.x / 2,
      currentY - size.y / 2,
      size.x,
      size.y,
    );

    return pRect.overlaps(dRect);
  }

  @override
  void render(Canvas canvas) {
    if (isSliced) {
      // Destruction debris sparks
      final p = Paint()..color = const Color(0xFFFF0055);
      final alpha = (sliceTimer / 0.35).clamp(0.0, 1.0);
      p.color = p.color.withValues(alpha: alpha);
      final spread = (0.35 - sliceTimer) * 60.0;
      canvas.drawCircle(Offset(-spread, -spread * 0.4), 4, p);
      canvas.drawCircle(Offset(spread, -spread * 0.6), 5, p);
      canvas.drawCircle(Offset(0, spread * 0.8), 6, p);
      return;
    }

    super.render(canvas);

    final hoverOffsetY = sin(hoverTimer) * 6.0;
    canvas.save();
    canvas.translate(0, hoverOffsetY);

    final accent = biome.primaryAccent;

    // 1. Searchlight scanner cone cast towards the ground
    final conePath = Path()
      ..moveTo(0, 8)
      ..lineTo(-24, 70)
      ..lineTo(24, 70)
      ..close();
    canvas.drawPath(
      conePath,
      Paint()
        ..color = const Color(0xFFFF0055).withValues(alpha: 0.10)
        ..style = PaintingStyle.fill,
    );

    // 2. Drone Carbon-Fiber Chassis
    final bodyRect = Rect.fromCenter(
      center: Offset.zero,
      width: size.x * 0.65,
      height: size.y * 0.75,
    );
    canvas.drawRRect(
      RRect.fromRectAndRadius(bodyRect, const Radius.circular(5)),
      Paint()..color = const Color(0xFF1E2632),
    );

    // 3. Quad Rotor Arms & Spinning Propellers
    final armPaint = Paint()
      ..color = const Color(0xFF37474F)
      ..strokeWidth = 2.5;
    // Left and right motor arms
    canvas.drawLine(const Offset(-10, -4), const Offset(-18, -8), armPaint);
    canvas.drawLine(const Offset(10, -4), const Offset(18, -8), armPaint);

    // Spinning rotor blurs
    final rotorWidth = 14.0 * cos(rotorTimer).abs() + 2.0;
    final rotorPaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.7)
      ..strokeWidth = 1.8;
    canvas.drawLine(
      Offset(-18 - rotorWidth / 2, -9),
      Offset(-18 + rotorWidth / 2, -9),
      rotorPaint,
    );
    canvas.drawLine(
      Offset(18 - rotorWidth / 2, -9),
      Offset(18 + rotorWidth / 2, -9),
      rotorPaint,
    );

    // 4. Glowing Red Surveillance Camera Lens / Visor
    final lensGlow = Paint()
      ..color = const Color(0xFFFF0055).withValues(alpha: 0.85)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
    canvas.drawCircle(const Offset(0, 2), 4, lensGlow);
    canvas.drawCircle(const Offset(0, 2), 2.5, Paint()..color = Colors.white);

    // Accent strip
    canvas.drawRect(
      const Rect.fromLTWH(-8, -5, 16, 2),
      Paint()..color = accent,
    );

    canvas.restore();
  }
}
