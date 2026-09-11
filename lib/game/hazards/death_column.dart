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
    super.biome,
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

    if (biome == SectorBiome.cyberShinto) {
      // --- MAP 2: 3D SACRED SHINTO TORII PILLAR CRUSHER ---
      final colRect = Rect.fromLTWH(-size.x / 2, 0, size.x, currentHeight);

      // 3D Cylindrical Shadow Base
      canvas.drawRect(colRect, Paint()..color = const Color(0xFF140209));
      // Cylindrical light highlight on left edge
      canvas.drawLine(
        Offset(-size.x / 2 + 5, 0),
        Offset(-size.x / 2 + 5, currentHeight),
        Paint()
          ..color = const Color(0xFF4A0A1C)
          ..strokeWidth = 4.0,
      );
      // Vermilion Lacquer Borders
      final toriiBorder = Paint()
        ..color = const Color(0xFFFF003C)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.5;
      canvas.drawRect(colRect, toriiBorder);

      // Gold Dragon Relief coiled around the column
      final goldDragon = Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 2.5;
      for (double ry = 25; ry < currentHeight - 15; ry += 36) {
        canvas.drawLine(
          Offset(-size.x / 2 + 4, ry),
          Offset(size.x / 2 - 4, ry + 12),
          goldDragon,
        );
        canvas.drawCircle(
          Offset(0, ry + 6),
          3.0,
          Paint()..color = const Color(0xFFFF003C),
        );
      }

      // 3D Golden Demonic Fang Base with Crimson Hazard Glow
      final basePaint = Paint()
        ..color = const Color(0xFFFF003C)
        ..style = PaintingStyle.fill
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
      final path = Path()
        ..moveTo(-size.x / 2 - 2, currentHeight)
        ..lineTo(-size.x / 4, currentHeight + 16)
        ..lineTo(0, currentHeight + 3)
        ..lineTo(size.x / 4, currentHeight + 16)
        ..lineTo(size.x / 2 + 2, currentHeight)
        ..close();
      canvas.drawPath(path, basePaint);
      canvas.drawPath(path, Paint()..color = const Color(0xFFFFD700));
      return;
    }

    if (biome == SectorBiome.neoNebula) {
      // --- MAP 3: 3D PNEUMATIC CYBER BLAST GATE ---
      final colRect = Rect.fromLTWH(-size.x / 2, 0, size.x, currentHeight);
      canvas.drawRect(colRect, Paint()..color = const Color(0xFF0A101C));

      // 3D Chrome Telescopic Hydraulic Piston Shaft
      canvas.drawLine(
        const Offset(0, 0),
        Offset(0, currentHeight),
        Paint()
          ..color = const Color(0xFFCFD8DC)
          ..strokeWidth = 10.0,
      );
      canvas.drawLine(
        const Offset(-2, 0),
        Offset(-2, currentHeight),
        Paint()
          ..color = Colors.white
          ..strokeWidth = 2.5,
      );

      // Glowing Neon Cyan Edges
      final cyanEdge = Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0;
      canvas.drawRect(colRect, cyanEdge);

      // Flange collars & Animated Chevrons
      for (double fy = 20; fy < currentHeight - 15; fy += 35) {
        canvas.drawRect(
          Rect.fromLTWH(-size.x / 2 - 2, fy, size.x + 4, 6),
          Paint()..color = const Color(0xFF16243A),
        );
        canvas.drawCircle(
          Offset(-size.x / 2 + 3, fy + 3),
          1.8,
          Paint()..color = const Color(0xFF00F5FF),
        );
        canvas.drawCircle(
          Offset(size.x / 2 - 3, fy + 3),
          1.8,
          Paint()..color = const Color(0xFFFF007F),
        );
      }

      // Magnetic Clamp Compactor Head with Cyan Energy Spikes
      final spikeGlow = Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.fill
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
      final path = Path()
        ..moveTo(-size.x / 2 - 4, currentHeight)
        ..lineTo(-size.x / 4, currentHeight + 16)
        ..lineTo(0, currentHeight + 3)
        ..lineTo(size.x / 4, currentHeight + 16)
        ..lineTo(size.x / 2 + 4, currentHeight)
        ..close();
      canvas.drawPath(path, spikeGlow);
      canvas.drawPath(path, Paint()..color = Colors.white);
      return;
    }

    // Default Campaign Column
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
