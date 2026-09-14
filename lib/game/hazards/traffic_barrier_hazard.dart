import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Reinforced Cyberpunk Road Barrier / Cargo Container.
/// Must be JUMPED over by the Ninja, or shattered with a Katana Slash!
class TrafficBarrierHazard extends BaseHazard {
  double strobeTimer = 0.0;
  bool isShattered = false;
  double shatterTimer = 0.0;
  final bool isCargoContainer;

  TrafficBarrierHazard({
    required super.position,
    double barrierWidth = 44.0,
    double barrierHeight = 40.0,
    this.isCargoContainer = false,
    super.biome,
  }) : super(
         size: Vector2(barrierWidth, barrierHeight),
         obstacleType: ObstacleType.trafficBarrier,
         deathType: DeathType.hitByBarrier,
         anchor: Anchor.bottomCenter,
       );

  @override
  void update(double dt) {
    super.update(dt);
    strobeTimer += dt * 8.0;
    if (isShattered) {
      shatterTimer -= dt;
      if (shatterTimer <= 0) {
        removeFromParent();
      }
    }
  }

  void shatter() {
    isShattered = true;
    shatterTimer = 0.35;
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isStealthActive || isShattered) return false;

    final pos = worldPosition;
    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2 + 12,
      player.position.y - player.size.y + 10,
      player.size.x - 24,
      player.size.y - 10,
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
    if (isShattered) {
      // Shattered debris explosion effect
      final debrisPaint = Paint()..color = const Color(0xFFFFB300);
      final alpha = (shatterTimer / 0.35).clamp(0.0, 1.0);
      debrisPaint.color = debrisPaint.color.withValues(alpha: alpha);
      final spread = (0.35 - shatterTimer) * 70.0;
      canvas.drawCircle(
        Offset(-spread, -size.y * 0.5 - spread * 0.3),
        5,
        debrisPaint,
      );
      canvas.drawCircle(
        Offset(spread, -size.y * 0.5 - spread * 0.5),
        6,
        debrisPaint,
      );
      canvas.drawCircle(Offset(0, -size.y - spread * 0.6), 7, debrisPaint);
      return;
    }

    super.render(canvas);

    final accent = biome.primaryAccent;

    if (isCargoContainer) {
      // 1. Cargo Shipping Container Design
      final cRect = Rect.fromLTWH(-size.x / 2, -size.y, size.x, size.y);
      canvas.drawRRect(
        RRect.fromRectAndRadius(cRect, const Radius.circular(3.0)),
        Paint()..color = const Color(0xFF1E2632),
      );
      // Vertical corrugated ribs
      final ribPaint = Paint()
        ..color = const Color(0xFF2E3B4E)
        ..strokeWidth = 2.0;
      for (double x = -size.x / 2 + 6; x < size.x / 2 - 4; x += 8) {
        canvas.drawLine(Offset(x, -size.y + 3), Offset(x, -3), ribPaint);
      }
      // Corner corner-casting locks
      final lockPaint = Paint()..color = const Color(0xFF546E7A);
      canvas.drawRect(Rect.fromLTWH(-size.x / 2, -size.y, 6, 6), lockPaint);
      canvas.drawRect(Rect.fromLTWH(size.x / 2 - 6, -size.y, 6, 6), lockPaint);
      canvas.drawRect(Rect.fromLTWH(-size.x / 2, -6, 6, 6), lockPaint);
      canvas.drawRect(Rect.fromLTWH(size.x / 2 - 6, -6, 6, 6), lockPaint);
      // Neon logo / barcode
      canvas.drawRect(
        Rect.fromLTWH(-size.x / 4, -size.y * 0.6, size.x / 2, 8),
        Paint()..color = accent.withValues(alpha: 0.6),
      );
    } else {
      // 2. Angled Concrete / Titanium Jersey Road Barrier
      final barrierPath = Path()
        ..moveTo(-size.x / 2 - 4, 0)
        ..lineTo(-size.x / 2 + 6, -size.y * 0.6)
        ..lineTo(-size.x / 4, -size.y)
        ..lineTo(size.x / 4, -size.y)
        ..lineTo(size.x / 2 - 6, -size.y * 0.6)
        ..lineTo(size.x / 2 + 4, 0)
        ..close();

      canvas.drawPath(barrierPath, Paint()..color = const Color(0xFF263238));

      // Warning hazard stripes across center
      final stripePaint = Paint()
        ..color = const Color(0xFFFFB300).withValues(alpha: 0.8)
        ..strokeWidth = 3.5;
      for (double x = -size.x / 2 + 4; x < size.x / 2 - 4; x += 11) {
        canvas.drawLine(
          Offset(x + 5, -size.y * 0.7),
          Offset(x, -size.y * 0.2),
          stripePaint,
        );
      }

      // Base mounting feet
      canvas.drawRect(
        Rect.fromLTWH(-size.x / 2 - 6, -5, size.x + 12, 5),
        Paint()..color = const Color(0xFF10171D),
      );
    }

    // Flashing Strobe Hazard Beacon on top
    final strobeOn = sin(strobeTimer) > 0;
    final beaconColor = strobeOn
        ? const Color(0xFFFF3D00)
        : const Color(0xFF5D1000);
    canvas.drawCircle(
      Offset(0, -size.y - 4),
      4.5,
      Paint()..color = beaconColor,
    );
    if (strobeOn) {
      canvas.drawCircle(
        Offset(0, -size.y - 4),
        10,
        Paint()
          ..color = const Color(0xFFFF3D00).withValues(alpha: 0.4)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5),
      );
    }
  }
}
