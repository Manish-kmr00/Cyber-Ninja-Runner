import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/sqube_player.dart';
import '../sqube_game.dart';
import 'base_hazard.dart';

/// Plasma projectile fired by the ground Cyber Patrol Robot.
class DroidBullet {
  Vector2 position; // Local position relative to DarkBox bottomCenter
  Vector2 velocity;
  final double radius;
  final List<Vector2> trail = [];
  bool isDead = false;

  DroidBullet({
    required this.position,
    required this.velocity,
    this.radius = 5.0,
  });
}

/// Dynamic ground impact spark from shattered droid plasma rounds.
class DroidImpactSpark {
  Vector2 position;
  Vector2 vel;
  double alpha;
  final Color color;

  DroidImpactSpark({
    required this.position,
    required this.vel,
    this.alpha = 1.0,
    required this.color,
  });
}

/// Cyber Patrol Droid (replaces static cube obstacle):
/// An articulated, patrolling mecha sentinel with walking hydraulic legs,
/// sweeping optical sensor visor, armored chest chassis, and arm blasters that fire lethal plasma rounds!
class DarkBox extends BaseHazard with HasGameReference<SqubeGame> {
  final double patrolDistance;
  final double patrolSpeed;
  final double fireInterval;
  final double bulletSpeed;
  final double detectionRange;
  final double? minX;
  final double? maxX;

  double startX = 0;
  bool movingRight = true;
  double walkTimer = 0.0;
  double eyeScanTimer = 0.0;
  double fireTimer = 0.0;
  double muzzleFlash = 0.0;
  double armRecoil = 0.0;
  bool isAiming = false;

  final List<DroidBullet> activeBullets = [];
  final List<DroidImpactSpark> impactSparks = [];
  final Random _rng = Random();

  DarkBox({
    required super.position,
    this.patrolDistance = 140.0,
    this.patrolSpeed = 85.0,
    this.fireInterval = 1.8,
    this.bulletSpeed = 340.0,
    this.detectionRange = 580.0,
    this.minX,
    this.maxX,
  }) : super(
         size: Vector2(50, 64),
         obstacleType: ObstacleType.darkBox,
         deathType: DeathType.hitByDarkBox,
         anchor: Anchor.bottomCenter,
       ) {
    startX = position.x;
  }

  @override
  void update(double dt) {
    super.update(dt);
    walkTimer += dt * 8.5; // Leg stride frequency
    eyeScanTimer += dt * 5.0; // Optic sweep frequency

    // Decay recoil and muzzle flash
    if (armRecoil > 0.0) {
      armRecoil = max(0.0, armRecoil - dt * 18.0);
    }
    if (muzzleFlash > 0.0) {
      muzzleFlash = max(0.0, muzzleFlash - dt * 6.5);
    }

    // AI Targeting & Firing Logic
    if (isMounted) {
      final player = game.player;
      final pPos = player.position;
      final myWorld = worldPosition;
      final dx =
          pPos.x - myWorld.x; // negative when player is to the left of robot

      // Player approaching from the front (left side) within detection range
      if (dx < -30 && dx > -detectionRange) {
        movingRight = false; // Turn to face incoming runner!

        final timeUntilFire = fireInterval - fireTimer;
        isAiming =
            timeUntilFire <=
            0.40; // Telegraph charging for 0.40s before firing!

        fireTimer += dt;
        if (fireTimer >= fireInterval) {
          fireTimer = 0.0;
          _fireBullet(towardsLeft: true);
        }
      } else {
        isAiming = false;
        // Keep fire timer partially primed so first shot comes quickly upon entry
        if (fireTimer > fireInterval * 0.4) {
          fireTimer = fireInterval * 0.4;
        }
      }
    }

    // Patrol movement (slows down when locked onto target to aim steadily)
    final effectiveMinX = minX ?? (startX - patrolDistance);
    final effectiveMaxX = maxX ?? (startX + patrolDistance);
    final currentSpeed = isAiming ? (patrolSpeed * 0.25) : patrolSpeed;

    if (movingRight) {
      position.x += currentSpeed * dt;
      if (position.x >= effectiveMaxX) {
        position.x = effectiveMaxX;
        movingRight = false;
      }
    } else {
      position.x -= currentSpeed * dt;
      if (position.x <= effectiveMinX) {
        position.x = effectiveMinX;
        movingRight = true;
      }
    }

    // Update active bullets & trajectory
    for (final bullet in activeBullets) {
      bullet.trail.add(bullet.position.clone());
      if (bullet.trail.length > 5) {
        bullet.trail.removeAt(0);
      }
      bullet.position += bullet.velocity * dt;

      // Despawn bullet if traveled too far
      if (bullet.position.x < -850 || bullet.position.x > 850) {
        bullet.isDead = true;
      }
    }
    activeBullets.removeWhere((b) => b.isDead);

    // Update impact sparks
    for (final spark in impactSparks) {
      spark.position += spark.vel * dt;
      spark.alpha -= dt * 3.0;
    }
    impactSparks.removeWhere((s) => s.alpha <= 0.0);
  }

  void _fireBullet({required bool towardsLeft}) {
    // Barrel position relative to robot bottomCenter
    final barrelX = towardsLeft ? -22.0 : 22.0;
    const barrelY = -34.0;
    final spawnPos = Vector2(barrelX, barrelY);
    final bulletVel = Vector2(towardsLeft ? -bulletSpeed : bulletSpeed, 0.0);

    activeBullets.add(DroidBullet(position: spawnPos, velocity: bulletVel));

    armRecoil = 5.5;
    muzzleFlash = 1.0;
    AudioService().playSfx('laser');
  }

  void _spawnImpactSparks(Vector2 localPos) {
    for (int i = 0; i < 6; i++) {
      final angle = -pi * 0.2 - (_rng.nextDouble() * pi * 0.6);
      final spd = 60.0 + _rng.nextDouble() * 80.0;
      impactSparks.add(
        DroidImpactSpark(
          position: localPos.clone(),
          vel: Vector2(cos(angle) * spd, sin(angle) * spd),
          color: _rng.nextBool()
              ? AppConstants.hazardRed
              : const Color(0xFFFF9100),
        ),
      );
    }
  }

  @override
  bool checkCollision(SqubePlayer player) {
    // Camouflage / invisibility bypass
    if (player.hideController.isStealthActive) {
      return false;
    }

    final pPos = player.position;
    final isSliding = player.isSliding;
    final isSlashing = player.isSlashing;
    final myWorld = worldPosition;

    // 1. Check bullet collisions
    for (final bullet in activeBullets) {
      if (bullet.isDead) continue;
      final bWorld = myWorld + bullet.position;

      // Clean slide dodge under chest-height bullets (bullet at y ~ 566, player sliding height is low)
      if (isSliding && bWorld.y < pPos.y - player.size.y * 0.32) {
        continue;
      }

      final bRect = Rect.fromCircle(
        center: Offset(bWorld.x, bWorld.y),
        radius: bullet.radius + 2.0,
      );

      // Katana Slash Mechanic: Ninja cuts bullets in half!
      if (isSlashing) {
        final slashZone = Rect.fromCenter(
          center: Offset(pPos.x + 20, pPos.y - player.size.y * 0.45),
          width: 85,
          height: 65,
        );
        if (slashZone.overlaps(bRect)) {
          bullet.isDead = true;
          _spawnImpactSparks(bullet.position);
          AudioService().playClick();
          continue;
        }
      }

      // Precise Player Hitbox
      final boxHeight = isSliding ? player.size.y * 0.35 : player.size.y * 0.85;
      final pRect = Rect.fromLTWH(
        pPos.x - player.size.x * 0.30,
        pPos.y - boxHeight,
        player.size.x * 0.60,
        boxHeight,
      );

      if (pRect.overlaps(bRect)) {
        bullet.isDead = true;
        _spawnImpactSparks(bullet.position);
        return true; // Hit by bullet!
      }
    }

    // 2. Direct body collision with the patrol robot
    final pBodyRect = Rect.fromLTWH(
      pPos.x - player.size.x / 2,
      pPos.y - player.size.y,
      player.size.x,
      player.size.y,
    );
    final bBodyRect = Rect.fromLTWH(
      myWorld.x - size.x * 0.4,
      myWorld.y - size.y * 0.95,
      size.x * 0.8,
      size.y * 0.95,
    );
    return pBodyRect.overlaps(bBodyRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    canvas.save();
    // Translate to bottom-center pivot so robot feet contact ground surface exactly
    canvas.translate(size.x / 2, size.y);

    // Face direction of travel around center axis
    if (!movingRight) {
      canvas.scale(-1, 1);
    }

    // 1. Soft Runway Shadow on Track
    final shadowPaint = Paint()
      ..color = Colors.black.withValues(alpha: 0.55)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawOval(
      Rect.fromCenter(center: const Offset(0, -1), width: 44, height: 10),
      shadowPaint,
    );

    // 2. Animated Articulated Mecha Legs with Walking Stride & Lift
    final legSwing1 = sin(walkTimer) * 7.0;
    final legSwing2 = -sin(walkTimer) * 7.0;
    final legLift1 = max(0.0, sin(walkTimer)) * 2.5;
    final legLift2 = max(0.0, -sin(walkTimer)) * 2.5;

    // Back Leg (Background layer)
    _renderMechaLeg(canvas, -8, legSwing2, legLift2, isForeground: false);
    // Front Leg (Foreground layer)
    _renderMechaLeg(canvas, 8, legSwing1, legLift1, isForeground: true);

    // 3. Armored Robotic Torso
    final torsoPath = Path()
      ..moveTo(-16, -42)
      ..lineTo(16, -42)
      ..lineTo(12, -22)
      ..lineTo(-12, -22)
      ..close();

    final torsoPaint = Paint()
      ..color = const Color(0xFF141924)
      ..style = PaintingStyle.fill;
    canvas.drawPath(torsoPath, torsoPaint);

    final torsoTrim = Paint()
      ..color = AppConstants.hazardRed.withValues(alpha: 0.85)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.8;
    canvas.drawPath(torsoPath, torsoTrim);

    // Hazard Caution Chest Chevron
    final chevronPaint = Paint()
      ..color = const Color(0xFFFF9100).withValues(alpha: 0.8)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0;
    canvas.drawLine(const Offset(-7, -34), const Offset(0, -28), chevronPaint);
    canvas.drawLine(const Offset(0, -28), const Offset(7, -34), chevronPaint);

    // 4. Glowing Arc Reactor Core
    final coreGlow = Paint()
      ..color = AppConstants.hazardRed.withValues(alpha: 0.6)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 7);
    canvas.drawCircle(const Offset(0, -32), 6.0, coreGlow);

    final coreCenter = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.fill;
    canvas.drawCircle(const Offset(0, -32), 2.5, coreCenter);

    // 5. Arm-Mounted Plasma Cannons
    final armPaint = Paint()
      ..color = const Color(0xFF1F2636)
      ..style = PaintingStyle.fill;

    // Front Arm & Blaster Barrel (with kick recoil)
    final recoilOffset = armRecoil * 2.5;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromLTWH(8 - recoilOffset, -38, 14, 8),
        const Radius.circular(2),
      ),
      armPaint,
    );

    // Charging Muzzle Glow & Flash
    final isTelegraphing = isAiming;
    final muzzleGlowColor = isTelegraphing
        ? const Color(0xFFFF9100)
        : AppConstants.hazardRed;
    final muzzleGlow = Paint()
      ..color = muzzleGlowColor.withValues(
        alpha: isTelegraphing
            ? (0.85 + sin(walkTimer * 3.0) * 0.15)
            : (muzzleFlash > 0.1 ? 1.0 : 0.6),
      )
      ..maskFilter = MaskFilter.blur(
        BlurStyle.normal,
        (muzzleFlash > 0.1 || isTelegraphing) ? 6 : 3,
      );
    canvas.drawCircle(
      Offset(22 - recoilOffset, -34),
      (muzzleFlash > 0.1 || isTelegraphing) ? 4.0 : 2.5,
      muzzleGlow,
    );

    if (muzzleFlash > 0.05) {
      canvas.drawCircle(
        Offset(24 - recoilOffset, -34),
        3.0 * muzzleFlash,
        Paint()..color = Colors.white,
      );
    }

    // 6. Angular Mecha Helmet & Head
    final headRect = RRect.fromRectAndRadius(
      const Rect.fromLTWH(-12, -58, 24, 16),
      const Radius.circular(4),
    );
    final headPaint = Paint()
      ..color = const Color(0xFF0F131C)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(headRect, headPaint);

    final headEdge = Paint()
      ..color = const Color(0xFF38435C)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawRRect(headRect, headEdge);

    // Antenna Mast
    canvas.drawLine(
      const Offset(-8, -58),
      const Offset(-8, -63),
      Paint()
        ..color = const Color(0xFF556688)
        ..strokeWidth = 1.5,
    );

    // 7. Sweeping Cyclops Laser Visor (locks forward when aiming at runner!)
    final eyeSweep = isAiming ? 4.0 : sin(eyeScanTimer) * 5.0;
    final visorRect = RRect.fromRectAndRadius(
      Rect.fromLTWH(-8, -52, 16, 5),
      const Radius.circular(2),
    );
    final visorBg = Paint()..color = Colors.black;
    canvas.drawRRect(visorRect, visorBg);

    // Glowing Laser Eye Point
    final eyeGlow = Paint()
      ..color = AppConstants.hazardRed
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
    canvas.drawCircle(Offset(eyeSweep, -49.5), 3.0, eyeGlow);

    final eyeCenter = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(eyeSweep, -49.5), 1.4, eyeCenter);

    canvas.restore();

    // 8. Render Projectile Bullets & Impact Sparks in Local Hazard Space
    canvas.save();
    canvas.translate(size.x / 2, size.y);
    for (final bullet in activeBullets) {
      _renderBullet(canvas, bullet);
    }
    _renderImpactSparks(canvas);
    canvas.restore();
  }

  void _renderBullet(Canvas canvas, DroidBullet bullet) {
    // 1. Energetic Pulse Trail
    if (bullet.trail.isNotEmpty) {
      for (int i = 0; i < bullet.trail.length; i++) {
        final tPos = bullet.trail[i];
        final progress = i / bullet.trail.length;
        final trailAlpha = progress * 0.55;
        final tPaint = Paint()
          ..color = AppConstants.hazardRed.withValues(alpha: trailAlpha)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
        canvas.drawCircle(Offset(tPos.x, tPos.y), 2.0 + progress * 3.0, tPaint);
      }
    }

    canvas.save();
    canvas.translate(bullet.position.x, bullet.position.y);
    final angle = atan2(bullet.velocity.y, bullet.velocity.x);
    canvas.rotate(angle);

    // 2. Trailing Incendiary Glow Field
    final glowPaint = Paint()
      ..color = const Color(0xFFFF3D00).withValues(alpha: 0.8)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawOval(
      Rect.fromCenter(center: const Offset(-3, 0), width: 16.0, height: 7.0),
      glowPaint,
    );

    // 3. Cyber Armor-Piercing Slug Core
    final slugRect = RRect.fromRectAndRadius(
      Rect.fromCenter(center: const Offset(-2, 0), width: 14.0, height: 6.0),
      const Radius.circular(2.0),
    );
    final slugPaint = Paint()
      ..color = const Color(0xFF1F2430)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(slugRect, slugPaint);

    // 4. Glowing Red Plasma Trim
    final trimPaint = Paint()
      ..color = AppConstants.hazardRed
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;
    canvas.drawRRect(slugRect, trimPaint);

    // 5. Blinding Laser Warhead Tip
    final tipPaint = Paint()
      ..color = const Color(0xFFFF1744)
      ..style = PaintingStyle.fill;
    final tipPath = Path()
      ..moveTo(4.0, -3.0)
      ..lineTo(8.5, 0)
      ..lineTo(4.0, 3.0)
      ..close();
    canvas.drawPath(tipPath, tipPaint);

    // White-Hot Laser Point
    canvas.drawCircle(const Offset(6.5, 0), 1.6, Paint()..color = Colors.white);

    canvas.restore();
  }

  void _renderImpactSparks(Canvas canvas) {
    for (final spark in impactSparks) {
      final sparkPaint = Paint()
        ..color = spark.color.withValues(alpha: spark.alpha.clamp(0.0, 1.0))
        ..style = PaintingStyle.fill
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      canvas.drawCircle(
        Offset(spark.position.x, spark.position.y),
        2.2,
        sparkPaint,
      );
    }
  }

  void _renderMechaLeg(
    Canvas canvas,
    double baseX,
    double swing,
    double lift, {
    required bool isForeground,
  }) {
    final kneeX = baseX + swing * 0.4;
    final kneeY = -12.0 - lift * 0.4;
    final footX = baseX + swing;
    final footY = -lift;

    final strutColor = isForeground
        ? const Color(0xFF38435C)
        : const Color(0xFF1E2433);
    final accentColor = isForeground
        ? AppConstants.hazardRed
        : AppConstants.hazardRed.withValues(alpha: 0.6);

    // 1. Thigh (Upper Armored Hydraulic Piston)
    canvas.drawLine(
      Offset(baseX, -22),
      Offset(kneeX, kneeY),
      Paint()
        ..color = strutColor
        ..strokeWidth = 5.0
        ..strokeCap = StrokeCap.round,
    );
    // Chrome Hydraulic Cylinder
    canvas.drawLine(
      Offset(baseX, -20),
      Offset(kneeX, kneeY - 2),
      Paint()
        ..color = Colors.white70
        ..strokeWidth = 1.6,
    );

    // 2. Knee Servo Joint
    canvas.drawCircle(
      Offset(kneeX, kneeY),
      4.2,
      Paint()..color = const Color(0xFF141924),
    );
    canvas.drawCircle(Offset(kneeX, kneeY), 2.2, Paint()..color = accentColor);

    // 3. Shin (Lower Robotic Strut)
    canvas.drawLine(
      Offset(kneeX, kneeY),
      Offset(footX, footY - 2),
      Paint()
        ..color = strutColor
        ..strokeWidth = 4.2
        ..strokeCap = StrokeCap.round,
    );
    // Glowing Neon Shin Seam
    canvas.drawLine(
      Offset(kneeX, kneeY + 2),
      Offset(footX, footY - 3),
      Paint()
        ..color = accentColor
        ..strokeWidth = 1.8,
    );

    // 4. Heavy Armored Mecha Footpad (Firmly grounded on track)
    // Sole Tread (Resting squarely on track surface)
    final soleRect = RRect.fromRectAndRadius(
      Rect.fromLTWH(footX - 5, footY - 3, 16, 5),
      const Radius.circular(1.8),
    );
    canvas.drawRRect(soleRect, Paint()..color = accentColor);

    // Upper Metallic Armor Foot Cover
    final armorRect = RRect.fromRectAndRadius(
      Rect.fromLTWH(footX - 4, footY - 6, 12, 4),
      const Radius.circular(1.2),
    );
    canvas.drawRRect(armorRect, Paint()..color = const Color(0xFF252D3D));

    // Glowing Toe Cap Flare
    canvas.drawCircle(
      Offset(footX + 9, footY - 1),
      1.5,
      Paint()..color = Colors.white,
    );
  }
}

/// CyberEnforcerDroid alias for character branding
typedef CyberEnforcerDroid = DarkBox;
