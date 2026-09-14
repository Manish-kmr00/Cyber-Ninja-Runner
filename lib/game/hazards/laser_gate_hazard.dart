import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Pulsating Cyberpunk Security Laser Gate.
/// Can be configured as a high-beam (requiring ninja SLIDE under)
/// or ground-beam (requiring ninja JUMP over).
class LaserGateHazard extends BaseHazard {
  final bool isHighBeam;
  double beamPulseTimer = 0.0;
  final List<Offset> electricSparks = [];
  final Random _rng = Random();

  LaserGateHazard({
    required super.position,
    this.isHighBeam = true,
    double gateWidth = 46.0,
    double gateHeight = 90.0,
    super.biome,
  }) : super(
         size: Vector2(gateWidth, gateHeight),
         obstacleType: ObstacleType.laserGate,
         deathType: DeathType.hitByLaser,
         anchor: Anchor.bottomCenter,
       );

  @override
  void update(double dt) {
    super.update(dt);
    beamPulseTimer += dt * 6.0;

    // Random electrical spark arcs
    if (electricSparks.length > 5) electricSparks.removeAt(0);
    if (_rng.nextDouble() < 0.4) {
      final sparkY = isHighBeam
          ? -size.y * 0.65 + (_rng.nextDouble() - 0.5) * 16.0
          : -size.y * 0.20 + (_rng.nextDouble() - 0.5) * 16.0;
      electricSparks.add(
        Offset((_rng.nextDouble() - 0.5) * (size.x - 10), sparkY),
      );
    }
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isStealthActive) return false;

    // High beam: player can safely slide under!
    if (isHighBeam && player.isSliding) return false;

    final pos = worldPosition;
    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2 + 10,
      player.position.y - player.size.y + 10,
      player.size.x - 20,
      player.size.y - 10,
    );

    // Hitbox for the laser beam specifically
    final beamRect = isHighBeam
        ? Rect.fromLTWH(pos.x - size.x / 2, pos.y - size.y * 0.78, size.x, 24.0)
        : Rect.fromLTWH(
            pos.x - size.x / 2,
            pos.y - size.y * 0.35,
            size.x,
            30.0,
          );

    return pRect.overlaps(beamRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    final beamColor = isHighBeam
        ? const Color(0xFFFF0055)
        : const Color(0xFF00F0FF);

    // 1. Dual Vertical Emitter Pylons (Left and Right)
    final pylonPaint = Paint()..color = const Color(0xFF1B222C);
    final pylonGlow = Paint()
      ..color = beamColor.withValues(alpha: 0.7)
      ..strokeWidth = 2.0;

    // Left pylon
    final lRect = Rect.fromLTWH(-size.x / 2, -size.y, 8, size.y);
    canvas.drawRRect(
      RRect.fromRectAndRadius(lRect, const Radius.circular(3)),
      pylonPaint,
    );
    canvas.drawLine(
      Offset(-size.x / 2 + 4, -size.y + 4),
      Offset(-size.x / 2 + 4, -4),
      pylonGlow,
    );

    // Right pylon
    final rRect = Rect.fromLTWH(size.x / 2 - 8, -size.y, 8, size.y);
    canvas.drawRRect(
      RRect.fromRectAndRadius(rRect, const Radius.circular(3)),
      pylonPaint,
    );
    canvas.drawLine(
      Offset(size.x / 2 - 4, -size.y + 4),
      Offset(size.x / 2 - 4, -4),
      pylonGlow,
    );

    // 2. Active Pulsing Laser Beam
    final beamY = isHighBeam ? -size.y * 0.66 : -size.y * 0.22;
    final pulseAlpha = 0.55 + 0.45 * sin(beamPulseTimer).abs();

    // Outer plasma glow
    final glowPaint = Paint()
      ..color = beamColor.withValues(alpha: pulseAlpha * 0.45)
      ..strokeWidth = 14.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
    canvas.drawLine(
      Offset(-size.x / 2 + 6, beamY),
      Offset(size.x / 2 - 6, beamY),
      glowPaint,
    );

    // Core laser beam
    final corePaint = Paint()
      ..color = Colors.white
      ..strokeWidth = 3.5;
    canvas.drawLine(
      Offset(-size.x / 2 + 6, beamY),
      Offset(size.x / 2 - 6, beamY),
      corePaint,
    );

    // Secondary colored beam
    final beamPaint = Paint()
      ..color = beamColor.withValues(alpha: pulseAlpha)
      ..strokeWidth = 6.0;
    canvas.drawLine(
      Offset(-size.x / 2 + 6, beamY),
      Offset(size.x / 2 - 6, beamY),
      beamPaint,
    );

    // 3. Electric spark arcs
    final sparkPaint = Paint()
      ..color = Colors.white
      ..strokeWidth = 1.5;
    for (final sp in electricSparks) {
      canvas.drawCircle(sp, 2.0, sparkPaint);
    }
  }
}
