import 'dart:math';
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
  double rollAngle = 0.0;

  BugCrawler({required super.position, this.speed = 220.0, super.biome})
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
      rollAngle -= (speed / (size.y * 0.5)) * dt;
    } else {
      rollAngle -= 2.0 * dt;
    }
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isStealthActive) return false;

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

    if (biome == SectorBiome.cyberShinto) {
      // --- MAP 2: 3D CURSED WANYUDO FLAMING DEMON WHEEL ---
      final center = Offset(0, -size.y / 2);
      final radius = size.y * 0.5;

      // Outer Spectral Flame Corona
      final spiritPaint = Paint()
        ..color = const Color(0xFFFF003C).withValues(alpha: 0.6)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
      canvas.drawCircle(center, radius + 5, spiritPaint);

      // 3D Heavy Wooden Wagon Wheel Rim
      final rimPaint = Paint()
        ..color = const Color(0xFF24040F)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 5.0;
      canvas.drawCircle(center, radius - 2.5, rimPaint);

      final rimTrim = Paint()
        ..color = const Color(0xFFFFD700)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4;
      canvas.drawCircle(center, radius, rimTrim);

      // Rotating Wheel Spokes
      for (int i = 0; i < 6; i++) {
        final spAngle = rollAngle + i * (pi / 3);
        canvas.drawLine(
          center,
          center + Offset(cos(spAngle) * radius, sin(spAngle) * radius),
          Paint()
            ..color = const Color(0xFF16020A)
            ..strokeWidth = 2.4,
        );
      }

      // Central 3D Demonic Oni Skull
      canvas.drawCircle(
        center,
        radius * 0.58,
        Paint()..color = const Color(0xFF140209),
      );
      canvas.drawCircle(
        center,
        radius * 0.58,
        Paint()
          ..color = const Color(0xFFFF003C)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 2.0,
      );

      // Twin Curved Demon Horns
      final hornP = Paint()..color = const Color(0xFFFFD700);
      canvas.drawLine(
        center + const Offset(-6, -6),
        center + const Offset(-12, -14),
        hornP..strokeWidth = 2.2,
      );
      canvas.drawLine(
        center + const Offset(6, -6),
        center + const Offset(12, -14),
        hornP..strokeWidth = 2.2,
      );

      // Glowing Demonic Oni Eyes
      final eyeOffset = Offset(isAwake ? -3.0 : 0.0, 0.0);
      canvas.drawOval(
        Rect.fromCenter(
          center: center + const Offset(-4, -2) + eyeOffset,
          width: 4,
          height: 6,
        ),
        Paint()
          ..color = const Color(0xFFFFD700)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );
      canvas.drawOval(
        Rect.fromCenter(
          center: center + const Offset(4, -2) + eyeOffset,
          width: 4,
          height: 6,
        ),
        Paint()
          ..color = const Color(0xFFFFD700)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );
      canvas.drawCircle(
        center + const Offset(-4, -2) + eyeOffset,
        1.0,
        Paint()..color = Colors.black,
      );
      canvas.drawCircle(
        center + const Offset(4, -2) + eyeOffset,
        1.0,
        Paint()..color = Colors.black,
      );

      // 4 Paper Talismans attached to rim
      for (int i = 0; i < 4; i++) {
        final tAngle = rollAngle + i * (pi / 2);
        final tPos =
            center +
            Offset(cos(tAngle) * (radius + 2), sin(tAngle) * (radius + 2));
        canvas.drawRect(
          Rect.fromCenter(center: tPos, width: 5, height: 8),
          Paint()..color = const Color(0xFFFFF9C4),
        );
        canvas.drawCircle(tPos, 1.0, Paint()..color = const Color(0xFFFF003C));
      }

      canvas.restore();
      return;
    }

    if (biome == SectorBiome.neoNebula) {
      // --- MAP 3: 3D QUANTUM BIT ORB / WIREFRAME GLITCH SPHERE ---
      final center = Offset(0, -size.y / 2);
      final radius = size.y * 0.54;

      // Cyan & Magenta Quantum Glow Halo
      canvas.drawCircle(
        center,
        radius + 6,
        Paint()
          ..color = const Color(0xFF00F5FF).withValues(alpha: 0.55)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8),
      );

      // Rotating Wireframe Equatorial Rings
      canvas.save();
      canvas.translate(center.dx, center.dy);
      canvas.rotate(rollAngle * 3.0);

      // Ring 1: Cyan Axis
      final ringPaintCyan = Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0;
      canvas.drawOval(
        Rect.fromCenter(
          center: Offset.zero,
          width: radius * 2.2,
          height: radius * 0.7,
        ),
        ringPaintCyan,
      );

      // Ring 2: Magenta Diagonal Axis
      canvas.rotate(pi / 3);
      final ringPaintMagenta = Paint()
        ..color = const Color(0xFFFF007F)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8;
      canvas.drawOval(
        Rect.fromCenter(
          center: Offset.zero,
          width: radius * 2.2,
          height: radius * 0.7,
        ),
        ringPaintMagenta,
      );

      // Vertex Node Sparks
      canvas.drawCircle(
        Offset(radius * 1.1, 0),
        2.2,
        Paint()..color = Colors.white,
      );
      canvas.drawCircle(
        Offset(-radius * 1.1, 0),
        2.2,
        Paint()..color = Colors.white,
      );

      canvas.restore();

      // Translucent Obsidian Core
      canvas.drawCircle(
        center,
        radius * 0.55,
        Paint()..color = const Color(0xEE030712),
      );
      canvas.drawCircle(
        center,
        radius * 0.55,
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.5,
      );

      // Pulsing White Quantum Core
      canvas.drawCircle(
        center,
        radius * 0.28,
        Paint()
          ..color = Colors.white
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3),
      );
      canvas.drawCircle(
        center,
        radius * 0.16,
        Paint()..color = const Color(0xFFFF007F),
      );

      canvas.restore();
      return;
    }

    // Default Campaign Carapace
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
