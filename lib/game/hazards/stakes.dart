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
      // Draw ground slit
      final slitPaint = Paint()
        ..color = const Color(0xFF222222)
        ..style = PaintingStyle.fill;
      canvas.drawRect(Rect.fromLTWH(0, -4, size.x, 4), slitPaint);
      return;
    }

    // 1. Industrial Hazard Base Plate (Anchors spikes firmly onto track)
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

      // Face 2: 3D Shadowed Side Facet (giving 3D perspective depth)
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
