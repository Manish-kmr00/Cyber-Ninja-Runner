import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/sqube_player.dart';
import 'base_hazard.dart';

/// Static and retracting ground spikes.
class Stakes extends BaseHazard {
  final int spikeCount;
  final bool isRetracting;
  double timer = 0.0;
  bool isExtended = true;

  Stakes({
    required super.position,
    this.spikeCount = 3,
    this.isRetracting = false,
  }) : super(
         size: Vector2(spikeCount * 18.0, 24.0),
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
      if (timer > 1.4) {
        isExtended = !isExtended;
        timer = 0.0;
      }
    }
  }

  @override
  bool checkCollision(SqubePlayer player) {
    if (isRetracting && !isExtended) return false;

    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2,
      player.position.y - player.size.y,
      player.size.x,
      player.size.y,
    );
    final pos = worldPosition;
    final stakeRect = Rect.fromLTWH(pos.x, pos.y - size.y, size.x, size.y);
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

    const spikeWidth = 20.0;
    for (int i = 0; i < spikeCount; i++) {
      final startX = i * spikeWidth;
      final midX = startX + spikeWidth / 2;
      final tip = Offset(midX - 2, -size.y);

      // Face 1: 3D Lit Front Facet
      final frontFace = Path()
        ..moveTo(startX, 0)
        ..lineTo(tip.dx, tip.dy)
        ..lineTo(midX + 2, -2)
        ..close();
      final frontPaint = Paint()
        ..color = const Color(0xFFFF4D63)
        ..style = PaintingStyle.fill;
      canvas.drawPath(frontFace, frontPaint);

      // Face 2: 3D Shadowed Side Facet (giving 3D perspective depth)
      final sideFace = Path()
        ..moveTo(midX + 2, -2)
        ..lineTo(tip.dx, tip.dy)
        ..lineTo(startX + spikeWidth, 0)
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
      canvas.drawLine(Offset(startX, 0), tip, ridgePaint);
      canvas.drawLine(tip, Offset(startX + spikeWidth, 0), ridgePaint);

      // Glowing Spike Tip
      final tipGlow = Paint()
        ..color = AppConstants.hazardRed
        ..style = PaintingStyle.fill;
      canvas.drawCircle(tip, 1.5, tipGlow);
    }
  }
}
