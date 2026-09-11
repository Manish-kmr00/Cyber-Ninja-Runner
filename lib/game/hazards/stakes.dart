import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Static and retracting ground spikes.
class Stakes extends BaseHazard {
  static const double spikeWidth = 20.0;
  static const double spikeHeight = 24.0;

  final int spikeCount;
  final bool isRetracting;
  double timer = 0.0;
  bool isExtended = true;

  Stakes({
    required super.position,
    this.spikeCount = 3,
    this.isRetracting = false,
    super.biome,
  }) : super(
         size: Vector2(spikeCount * spikeWidth, spikeHeight),
         obstacleType: isRetracting
             ? ObstacleType.stakesAutoHide
             : ObstacleType.stakesStatic,
         deathType: DeathType.hitBySpikes,
         anchor: Anchor.bottomLeft,
       );

  @override
  void update(double dt) {
    super.update(dt);
    if (isRetracting) {
      timer += dt;
      if (timer > 2.5) {
        isExtended = !isExtended;
        timer = 0.0;
      }
    }
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isInvisibilityActive || player.isSafeGroundActive) return false;
    if (isRetracting && !isExtended) return false;

    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x * 0.35,
      player.position.y - player.size.y * 0.9,
      player.size.x * 0.7,
      player.size.y * 0.9,
    );
    final pos = worldPosition;
    final stakeRect = Rect.fromLTWH(
      pos.x + 2.0,
      pos.y - size.y + 3.0,
      size.x - 4.0,
      size.y - 3.0,
    );
    return pRect.overlaps(stakeRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    if (isRetracting && !isExtended) {
      final slitPaint = Paint()
        ..color = const Color(0xFF222222)
        ..style = PaintingStyle.fill;
      canvas.drawRect(Rect.fromLTWH(0, -4, size.x, 4), slitPaint);
      return;
    }

    if (biome == SectorBiome.cyberShinto) {
      // --- MAP 2: 3D CURSED SAMURAI KATANAS EMBEDDED IN DECK ---
      // 1. Lacquered Wood Base with Gold Trim
      canvas.drawRect(
        Rect.fromLTWH(0, -5.0, size.x, 5.0),
        Paint()..color = const Color(0xFF140208),
      );
      canvas.drawLine(
        const Offset(0, -5.0),
        Offset(size.x, -5.0),
        Paint()
          ..color = const Color(0xFFFFD700)
          ..strokeWidth = 2.0,
      );

      // 2. 3D Upright Cursed Katanas
      for (int i = 0; i < spikeCount; i++) {
        final startX = i * spikeWidth;
        final midX = startX + spikeWidth / 2;
        final tip = Offset(midX, -spikeHeight - 3);

        // Blade Left Bevel (Shadowed steel)
        final bladeL = Path()
          ..moveTo(midX - 3.0, -5.0)
          ..lineTo(tip.dx, tip.dy)
          ..lineTo(midX, -5.0)
          ..close();
        canvas.drawPath(bladeL, Paint()..color = const Color(0xFF9E9E9E));

        // Blade Right Bevel (Polished gleaming steel)
        final bladeR = Path()
          ..moveTo(midX, -5.0)
          ..lineTo(tip.dx, tip.dy)
          ..lineTo(midX + 3.0, -5.0)
          ..close();
        canvas.drawPath(bladeR, Paint()..color = Colors.white);

        // Blood Edge Aura
        canvas.drawLine(
          Offset(midX, -5.0),
          tip,
          Paint()
            ..color = const Color(0xFFFF003C)
            ..strokeWidth = 2.0
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3),
        );

        // Golden Square Tsuba (Sword Guard)
        canvas.drawRect(
          Rect.fromCenter(center: Offset(midX, -6.0), width: 16, height: 3.5),
          Paint()..color = const Color(0xFFFFD700),
        );
        canvas.drawCircle(
          Offset(midX, -6.0),
          1.5,
          Paint()..color = const Color(0xFFFF003C),
        );

        // Fluttering White & Crimson Paper Ofuda Talisman
        final ofudaRect = Rect.fromLTWH(midX + 3, -16, 6, 12);
        canvas.drawRect(ofudaRect, Paint()..color = const Color(0xFFFFFDE7));
        canvas.drawRect(
          ofudaRect,
          Paint()
            ..color = const Color(0xFFFF003C)
            ..style = PaintingStyle.stroke
            ..strokeWidth = 1.0,
        );
        canvas.drawLine(
          Offset(midX + 6, -15),
          Offset(midX + 6, -6),
          Paint()
            ..color = const Color(0xFFFF003C)
            ..strokeWidth = 1.2,
        );

        // Gleaming Tip Point
        canvas.drawCircle(tip, 2.0, Paint()..color = const Color(0xFFFFD700));
      }
      return;
    }

    if (biome == SectorBiome.neoNebula) {
      // --- MAP 3: 3D DIGITAL WIREFRAME LASER GATES ---
      // 1. Digital Vector Floor Anchor
      canvas.drawRect(
        Rect.fromLTWH(0, -5.0, size.x, 5.0),
        Paint()..color = const Color(0xDD000206),
      );
      canvas.drawLine(
        const Offset(0, -5.0),
        Offset(size.x, -5.0),
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..strokeWidth = 2.0,
      );

      // 2. Wireframe Vector Emitters & Quantum Laser Fence
      for (int i = 0; i < spikeCount; i++) {
        final startX = i * spikeWidth;
        final midX = startX + spikeWidth / 2;
        final colW = spikeWidth * 0.65;

        // Wireframe Pillar
        final pRect = Rect.fromLTWH(
          midX - colW / 2,
          -spikeHeight - 2,
          colW,
          spikeHeight + 2,
        );
        canvas.drawRect(pRect, Paint()..color = const Color(0xEE02050E));
        canvas.drawRect(
          pRect,
          Paint()
            ..color = const Color(0xFF00F5FF)
            ..style = PaintingStyle.stroke
            ..strokeWidth = 1.4,
        );
        // Pillar Center Energy Line
        canvas.drawLine(
          Offset(midX, -spikeHeight - 2),
          Offset(midX, 0),
          Paint()
            ..color = const Color(0xFFFF007F)
            ..strokeWidth = 1.2,
        );

        // 3 Triple Horizontal Cyan/Pink Laser Fence Tripwires
        for (int b = 0; b < 3; b++) {
          final beamY = -spikeHeight * (0.25 + b * 0.35);

          // Horizontal Laser Fence Beam
          final laserGlow = Paint()
            ..color =
                (b % 2 == 0 ? const Color(0xFF00F5FF) : const Color(0xFFFF007F))
                    .withValues(alpha: 0.9)
            ..strokeWidth = 3.5
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3.5);
          canvas.drawLine(
            Offset(startX - 10, beamY),
            Offset(startX + spikeWidth + 10, beamY),
            laserGlow,
          );
          canvas.drawLine(
            Offset(startX - 10, beamY),
            Offset(startX + spikeWidth + 10, beamY),
            Paint()
              ..color = Colors.white
              ..strokeWidth = 1.2,
          );

          // Emitter Node Spark
          canvas.drawCircle(
            Offset(midX, beamY),
            2.5,
            Paint()..color = Colors.white,
          );
        }

        // Top Pulsing Quantum Vertex Beacon
        canvas.drawCircle(
          Offset(midX, -spikeHeight - 4),
          3.5,
          Paint()
            ..color = const Color(0xFFFF007F)
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3),
        );
        canvas.drawCircle(
          Offset(midX, -spikeHeight - 4),
          1.5,
          Paint()..color = Colors.white,
        );
      }
      return;
    }

    // 1. Industrial Hazard Base Plate (Default Campaign)
    final basePlate = Rect.fromLTWH(0, -4.0, size.x, 4.0);
    final basePaint = Paint()
      ..color = const Color(0xFF141824)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(basePlate, const Radius.circular(2.0)),
      basePaint,
    );

    // Hazard Base Caution Trim line
    final baseTrimPaint = Paint()
      ..color = const Color(0xFFFF2E4C).withValues(alpha: 0.85)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.0;
    canvas.drawLine(const Offset(0, -4.0), Offset(size.x, -4.0), baseTrimPaint);

    // 2. 3D Neon Spikes
    for (int i = 0; i < spikeCount; i++) {
      final startX = i * spikeWidth;
      final midX = startX + spikeWidth / 2;
      final tip = Offset(midX, -spikeHeight);

      // Face 1: 3D Lit Front Facet
      final frontFace = Path()
        ..moveTo(startX + 1.0, -3.0)
        ..lineTo(tip.dx, tip.dy)
        ..lineTo(midX + 2.0, -3.0)
        ..close();
      final frontPaint = Paint()
        ..color = const Color(0xFFFF4D63)
        ..style = PaintingStyle.fill;
      canvas.drawPath(frontFace, frontPaint);

      // Face 2: 3D Shadowed Side Facet
      final sideFace = Path()
        ..moveTo(midX + 2.0, -3.0)
        ..lineTo(tip.dx, tip.dy)
        ..lineTo(startX + spikeWidth - 1.0, -3.0)
        ..close();
      final sidePaint = Paint()
        ..color = const Color(0xFFB3142B)
        ..style = PaintingStyle.fill;
      canvas.drawPath(sideFace, sidePaint);

      // 3D Neon Ridge Lines
      final ridgePaint = Paint()
        ..color = Colors.white.withValues(alpha: 0.85)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4;
      canvas.drawLine(Offset(startX + 1.0, -3.0), tip, ridgePaint);
      canvas.drawLine(tip, Offset(startX + spikeWidth - 1.0, -3.0), ridgePaint);

      // Glowing Spike Tip
      final tipGlow = Paint()
        ..color = AppConstants.hazardRed
        ..style = PaintingStyle.fill;
      canvas.drawCircle(tip, 1.8, tipGlow);
    }
  }
}
