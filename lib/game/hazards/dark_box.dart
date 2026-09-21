import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import '../cyber_ninja_game.dart';
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

/// Cyber Patrol Droid:
/// An articulated, patrolling mecha sentinel with walking hydraulic legs,
/// sweeping optical sensor visor, armored chest chassis, and arm blasters that fire lethal plasma rounds!
class DarkBox extends BaseHazard with HasGameReference<CyberNinjaRunnerGame> {
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
  bool isSliced = false;
  double sliceTimer = 0.0;
  final List<Offset> scrapOffsets = [];
  final List<Offset> scrapVelocities = [];

  final List<DroidBullet> activeBullets = [];
  final List<DroidImpactSpark> impactSparks = [];
  final Random _rng = Random();

  void sliceAndDestroy() {
    if (isSliced) return;
    isSliced = true;
    sliceTimer = 0.50; // 0.5s death slice & explosion duration

    // Spawn 14 flying mechanical scrap chunks
    for (int i = 0; i < 14; i++) {
      final angle = -pi * 0.05 - (_rng.nextDouble() * pi * 0.9);
      final spd = 120.0 + _rng.nextDouble() * 200.0;
      scrapOffsets.add(const Offset(0, -32));
      scrapVelocities.add(Offset(cos(angle) * spd, sin(angle) * spd));
    }

    // Spawn 20 hot slicing spark embers
    for (int i = 0; i < 20; i++) {
      _spawnImpactSparks(Vector2(0, -32));
    }
  }

  DarkBox({
    required super.position,
    super.biome = SectorBiome.neonMetropolis,
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

    // If sliced by ninja's katana, update death physics and scraps
    if (isSliced) {
      sliceTimer -= dt;
      for (int i = 0; i < scrapOffsets.length; i++) {
        scrapOffsets[i] += scrapVelocities[i] * dt;
        scrapVelocities[i] = Offset(
          scrapVelocities[i].dx * 0.98,
          scrapVelocities[i].dy + 750.0 * dt, // gravity
        );
      }
      if (sliceTimer <= 0.0) {
        removeFromParent();
      }
      return; // Sliced droid ceases fire and movement
    }

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
      if (dx < -30 && dx > -detectionRange && !player.isStealthActive) {
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
      final Color sparkColor;
      if (biome == SectorBiome.cyberShinto) {
        sparkColor = _rng.nextBool()
            ? const Color(0xFFFF003C)
            : const Color(0xFFFFD700);
      } else if (biome == SectorBiome.neoNebula) {
        sparkColor = _rng.nextBool()
            ? const Color(0xFF00F5FF)
            : const Color(0xFFFF007F);
      } else {
        sparkColor = _rng.nextBool()
            ? AppConstants.hazardRed
            : const Color(0xFFFF9100);
      }
      impactSparks.add(
        DroidImpactSpark(
          position: localPos.clone(),
          vel: Vector2(cos(angle) * spd, sin(angle) * spd),
          color: sparkColor,
        ),
      );
    }
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (isSliced) return false; // Sliced droid is dead and non-hazardous

    // Camouflage / invisibility bypass
    if (player.isStealthActive) {
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

      // Bullets cannot be sliced or deflected by sword - ninja must jump or slide dodge!
      // Clean slide dodge under chest-height bullets (bullet at y ~ 566, player sliding height is low)
      if (isSliding && bWorld.y < pPos.y - player.size.y * 0.32) {
        continue;
      }

      final bRect = Rect.fromCircle(
        center: Offset(bWorld.x, bWorld.y),
        radius: bullet.radius + 2.0,
      );

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

    if (pBodyRect.overlaps(bBodyRect)) {
      if (isSlashing) {
        // Ninja slices robot in two on contact!
        sliceAndDestroy();
        return false;
      }
      return true;
    }
    return false;
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    // If sliced, render dramatic bisected robot death animation with sparks
    if (isSliced) {
      final t = (0.50 - sliceTimer) / 0.50; // 0.0 to 1.0
      final fadeAlpha = (1.0 - t).clamp(0.0, 1.0);

      canvas.save();
      canvas.translate(size.x / 2, size.y);

      // 1. Top-Right Bisected Half (Sliding up and away)
      canvas.save();
      canvas.translate(t * 38.0, -t * 26.0);
      canvas.rotate(t * 0.45);
      final topPath = Path()
        ..moveTo(-16, -58)
        ..lineTo(16, -58)
        ..lineTo(16, -42)
        ..lineTo(12, -32)
        ..lineTo(-12, -45)
        ..close();
      canvas.drawPath(
        topPath,
        Paint()
          ..color = const Color(0xFF141924).withValues(alpha: fadeAlpha)
          ..style = PaintingStyle.fill,
      );
      // Glowing Neon Cutline on top piece
      canvas.drawLine(
        const Offset(-12, -45),
        const Offset(12, -32),
        Paint()
          ..color = AppConstants.stealthBlue.withValues(alpha: fadeAlpha)
          ..strokeWidth = 3.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
      );
      canvas.restore();

      // 2. Bottom-Left Bisected Half (Dropping down and backward)
      canvas.save();
      canvas.translate(-t * 22.0, t * 14.0);
      canvas.rotate(-t * 0.35);
      final bottomPath = Path()
        ..moveTo(-12, -45)
        ..lineTo(12, -32)
        ..lineTo(12, -22)
        ..lineTo(-12, -22)
        ..close();
      canvas.drawPath(
        bottomPath,
        Paint()
          ..color = const Color(0xFF0F131C).withValues(alpha: fadeAlpha)
          ..style = PaintingStyle.fill,
      );
      // Glowing Neon Cutline on bottom piece
      canvas.drawLine(
        const Offset(-12, -45),
        const Offset(12, -32),
        Paint()
          ..color = AppConstants.stealthBlue.withValues(alpha: fadeAlpha)
          ..strokeWidth = 3.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
      );
      canvas.restore();

      // 3. Flying Metal Debris Scraps
      for (int i = 0; i < scrapOffsets.length; i++) {
        final pos = scrapOffsets[i];
        final scrapPaint = Paint()
          ..color =
              (i % 2 == 0 ? const Color(0xFF38435C) : AppConstants.hazardRed)
                  .withValues(alpha: fadeAlpha);
        canvas.drawCircle(pos, 2.5, scrapPaint);
      }

      // 4. Expanding Plasma Flash & Slicing Sparks
      if (t < 0.35) {
        final flashRadius = 14.0 + t * 45.0;
        final flashPaint = Paint()
          ..color = Colors.white.withValues(alpha: (1.0 - t / 0.35))
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
        canvas.drawCircle(const Offset(0, -32), flashRadius, flashPaint);
      }

      canvas.restore();
      return;
    }

    canvas.save();
    // Translate to bottom-center pivot so robot feet contact ground surface exactly
    canvas.translate(size.x / 2, size.y);

    // Face direction of travel around center axis
    if (!movingRight) {
      canvas.scale(-1, 1);
    }

    if (biome == SectorBiome.cyberShinto) {
      _renderCyberShintoShinobi(canvas);
    } else if (biome == SectorBiome.neoNebula) {
      _renderTacticalCombatAndroid(canvas);
    } else {
      _renderDefaultDroid(canvas);
    }

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

  void _renderDefaultDroid(Canvas canvas) {
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
  }

  void _renderCyberShintoShinobi(Canvas canvas) {
    // 1. Cursed Blood Shadow on Floor
    final shadowPaint = Paint()
      ..color = const Color(0xFFFF003C).withValues(alpha: 0.35)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
    canvas.drawOval(
      Rect.fromCenter(center: const Offset(0, -1), width: 48, height: 12),
      shadowPaint,
    );

    final legSwing = sin(walkTimer * 1.5) * 6.0;
    final robeFlap = sin(walkTimer * 2.0) * 4.0;
    final breathe = sin(walkTimer * 0.8) * 1.5;

    // 2. 3D Floating Shadow Hakama Pants (Pleated & Beveled)
    // Back leg
    final legL = Path()
      ..moveTo(-10, -28)
      ..lineTo(-6, -28)
      ..lineTo(-8 - legSwing, -3)
      ..lineTo(-14 - legSwing, -3)
      ..close();
    canvas.drawPath(legL, Paint()..color = const Color(0xFF0C0106));

    // Front leg
    final legR = Path()
      ..moveTo(4, -28)
      ..lineTo(10, -28)
      ..lineTo(12 + legSwing, -4)
      ..lineTo(6 + legSwing, -4)
      ..close();
    canvas.drawPath(legR, Paint()..color = const Color(0xFF1F030E));
    canvas.drawPath(
      legR,
      Paint()
        ..color = const Color(0xFFFF003C).withValues(alpha: 0.6)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.2,
    );

    // Flowing pleated Hakama skirt over legs
    final hakama = Path()
      ..moveTo(-15, -32)
      ..lineTo(15, -32)
      ..lineTo(18 + legSwing * 0.6, -10)
      ..lineTo(0 + robeFlap, -8)
      ..lineTo(-18 - legSwing * 0.6, -10)
      ..close();
    canvas.drawPath(hakama, Paint()..color = const Color(0xFF17020A));
    canvas.drawLine(
      const Offset(-6, -32),
      Offset(-8 + robeFlap * 0.4, -9),
      Paint()
        ..color = const Color(0xFF330617)
        ..strokeWidth = 2.0,
    );
    canvas.drawLine(
      const Offset(6, -32),
      Offset(8 + robeFlap * 0.4, -9),
      Paint()
        ..color = const Color(0xFF330617)
        ..strokeWidth = 2.0,
    );
    // Gold embroidery hem
    canvas.drawLine(
      Offset(-18 - legSwing * 0.6, -10),
      Offset(0 + robeFlap, -8),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 1.6,
    );
    canvas.drawLine(
      Offset(0 + robeFlap, -8),
      Offset(18 + legSwing * 0.6, -10),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 1.6,
    );

    // 3. 3D Kimono Torso & Golden Obi Sash with 3D Tied Knot
    final torsoPath = Path()
      ..moveTo(-16, -48 + breathe)
      ..lineTo(16, -48 + breathe)
      ..lineTo(14, -30)
      ..lineTo(-14, -30)
      ..close();
    canvas.drawPath(torsoPath, Paint()..color = const Color(0xFF1E030D));
    canvas.drawLine(
      Offset(-14, -48 + breathe),
      const Offset(4, -34),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 2.0,
    );
    canvas.drawLine(
      Offset(14, -48 + breathe),
      const Offset(-4, -34),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 1.8,
    );

    // 3D Golden Obi Sash
    final obiRect = Rect.fromLTWH(-13, -34, 26, 6);
    canvas.drawRect(obiRect, Paint()..color = const Color(0xFFFFD700));
    canvas.drawRect(
      Rect.fromLTWH(-13, -31, 26, 2),
      Paint()..color = const Color(0xFFFF003C),
    );
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromCenter(center: const Offset(0, -31), width: 8, height: 8),
        const Radius.circular(2),
      ),
      Paint()..color = const Color(0xFFFFC107),
    );
    // Hanging Ofuda paper talisman from obi
    final ofudaX = -4.0 + robeFlap * 0.4;
    canvas.drawRect(
      Rect.fromLTWH(ofudaX, -27, 7, 13),
      Paint()..color = const Color(0xFFFFF9C4),
    );
    canvas.drawRect(
      Rect.fromLTWH(ofudaX, -27, 7, 13),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.0,
    );
    canvas.drawLine(
      Offset(ofudaX + 3.5, -25),
      Offset(ofudaX + 3.5, -16),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 1.5,
    );

    // 4. 3D Floating Lacquered Shoulder Pauldrons (Sode)
    void drawSode(double x, bool isRight) {
      final sodeX = isRight ? x : x - 10;
      final sPath = Path()
        ..moveTo(sodeX, -50 + breathe)
        ..lineTo(sodeX + 10, -50 + breathe)
        ..lineTo(sodeX + 11, -38 + breathe)
        ..lineTo(sodeX - 1, -38 + breathe)
        ..close();
      canvas.drawPath(sPath, Paint()..color = const Color(0xFF280312));
      canvas.drawPath(
        sPath,
        Paint()
          ..color = const Color(0xFFFF003C)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.5,
      );
      canvas.drawLine(
        Offset(sodeX, -42 + breathe),
        Offset(sodeX + 10, -42 + breathe),
        Paint()
          ..color = const Color(0xFFFFD700)
          ..strokeWidth = 1.5,
      );
    }

    drawSode(-14, false);
    drawSode(14, true);

    // 5. 3D Cursed Ninjato Katana Arm
    final recoilOffset = armRecoil * 3.5;
    final aimAngle = isAiming ? -0.25 : 0.0;
    canvas.save();
    canvas.translate(10, -42 + breathe);
    canvas.rotate(aimAngle);

    canvas.drawLine(
      Offset.zero,
      Offset(12 - recoilOffset, 6),
      Paint()
        ..color = const Color(0xFF1E030D)
        ..strokeWidth = 6.0
        ..strokeCap = StrokeCap.round,
    );
    final hiltPos = Offset(13 - recoilOffset, 6);
    canvas.drawRect(
      Rect.fromCenter(center: hiltPos, width: 4, height: 10),
      Paint()..color = const Color(0xFFFFD700),
    );
    canvas.drawLine(
      Offset(hiltPos.dx - 8, hiltPos.dy),
      hiltPos,
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 3.5,
    );
    final tipPos = Offset(hiltPos.dx + 26, hiltPos.dy - 1);
    canvas.drawLine(
      hiltPos,
      tipPos,
      Paint()
        ..color = const Color(0xFFEEEEEE)
        ..strokeWidth = 2.6,
    );
    canvas.drawLine(
      hiltPos,
      tipPos,
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 1.4
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
    );

    if (isAiming || muzzleFlash > 0.05) {
      final chargeP = Paint()
        ..color = const Color(
          0xFFFF003C,
        ).withValues(alpha: muzzleFlash > 0.1 ? 1.0 : 0.85)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 10);
      canvas.drawCircle(tipPos, 7.0 + muzzleFlash * 7.0, chargeP);
      canvas.drawCircle(tipPos, 3.0, Paint()..color = const Color(0xFFFFD700));
      canvas.drawCircle(
        tipPos,
        12.0,
        Paint()
          ..color = const Color(0xFFFF003C)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.2,
      );
    }
    canvas.restore();

    // 6. Volumetric 3D Cursed Tengu / Oni Battle Mask & Horns (Head)
    final headY = -54.0 + breathe;
    canvas.drawRect(
      Rect.fromCenter(center: Offset(0, headY + 8), width: 10, height: 6),
      Paint()..color = const Color(0xFF0F0106),
    );

    final maskPath = Path()
      ..moveTo(-12, headY - 10)
      ..lineTo(12, headY - 10)
      ..lineTo(14, headY)
      ..lineTo(4, headY + 10)
      ..lineTo(-4, headY + 10)
      ..lineTo(-14, headY)
      ..close();
    canvas.drawPath(maskPath, Paint()..color = const Color(0xFF22030E));
    canvas.drawPath(
      maskPath,
      Paint()
        ..color = const Color(0xFFFF003C)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0,
    );

    final beakPath = Path()
      ..moveTo(0, headY - 4)
      ..lineTo(5, headY + 4)
      ..lineTo(0, headY + 8)
      ..lineTo(-5, headY + 4)
      ..close();
    canvas.drawPath(beakPath, Paint()..color = const Color(0xFFFFD700));
    canvas.drawLine(
      Offset(0, headY - 4),
      Offset(0, headY + 8),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 1.5,
    );

    final hornL = Path()
      ..moveTo(-8, headY - 10)
      ..quadraticBezierTo(-20, headY - 22, -14, headY - 28)
      ..quadraticBezierTo(-10, headY - 18, -4, headY - 10)
      ..close();
    final hornR = Path()
      ..moveTo(8, headY - 10)
      ..quadraticBezierTo(20, headY - 22, 14, headY - 28)
      ..quadraticBezierTo(10, headY - 18, 4, headY - 10)
      ..close();
    canvas.drawPath(hornL, Paint()..color = const Color(0xFFFF003C));
    canvas.drawPath(hornR, Paint()..color = const Color(0xFFFF003C));
    canvas.drawCircle(
      Offset(-14, headY - 28),
      2.2,
      Paint()..color = const Color(0xFFFFD700),
    );
    canvas.drawCircle(
      Offset(14, headY - 28),
      2.2,
      Paint()..color = const Color(0xFFFFD700),
    );

    final eyeSweep = isAiming ? 3.0 : sin(eyeScanTimer) * 4.0;
    canvas.drawOval(
      Rect.fromCenter(
        center: Offset(-6 + eyeSweep * 0.3, headY - 1),
        width: 6,
        height: 3.5,
      ),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
    );
    canvas.drawOval(
      Rect.fromCenter(
        center: Offset(6 + eyeSweep * 0.3, headY - 1),
        width: 6,
        height: 3.5,
      ),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
    );
    canvas.drawCircle(
      Offset(-6 + eyeSweep * 0.3, headY - 1),
      1.2,
      Paint()..color = Colors.white,
    );
    canvas.drawCircle(
      Offset(6 + eyeSweep * 0.3, headY - 1),
      1.2,
      Paint()..color = Colors.white,
    );
  }

  void _renderTacticalCombatAndroid(Canvas canvas) {
    // 1. Digital Vector Targeting Reticle (Floor Projection)
    final reticleCenter = const Offset(0, -1);
    canvas.drawCircle(
      reticleCenter,
      18.0,
      Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.25)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.2,
    );
    canvas.drawCircle(
      reticleCenter,
      10.0,
      Paint()
        ..color = const Color(0xFFFF007F).withValues(alpha: 0.35)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.0,
    );
    // Reticle Crosshairs
    final crossHairPaint = Paint()
      ..color = const Color(0xFF00F5FF)
      ..strokeWidth = 1.0;
    canvas.drawLine(
      const Offset(-22, -1),
      const Offset(-12, -1),
      crossHairPaint,
    );
    canvas.drawLine(const Offset(12, -1), const Offset(22, -1), crossHairPaint);

    // 2. Wireframe Vector Legs
    final legSwing1 = sin(walkTimer) * 7.0;
    final legSwing2 = -sin(walkTimer) * 7.0;
    final legLift = max(0.0, sin(walkTimer)) * 4.0;

    void drawWireframeLeg(
      double x,
      double swing,
      double lift,
      bool isForeground,
    ) {
      final hipY = -24.0 - lift;
      final kneeY = -12.0 - lift * 0.5;
      final footY = -1.0;
      final hipX = x;
      final kneeX = x + swing * 0.7;
      final footX = x + swing;

      final wireColor = isForeground
          ? const Color(0xFF00F5FF)
          : const Color(0xFFFF007F);

      // Thigh Vector Line
      canvas.drawLine(
        Offset(hipX, hipY),
        Offset(kneeX, kneeY),
        Paint()
          ..color = wireColor
          ..strokeWidth = 2.4,
      );
      // Shin Vector Line
      canvas.drawLine(
        Offset(kneeX, kneeY),
        Offset(footX, footY),
        Paint()
          ..color = wireColor
          ..strokeWidth = 2.0,
      );
      // Joint Vertex Nodes
      canvas.drawCircle(Offset(hipX, hipY), 2.2, Paint()..color = Colors.white);
      canvas.drawCircle(
        Offset(kneeX, kneeY),
        2.5,
        Paint()..color = Colors.white,
      );
      canvas.drawCircle(Offset(footX, footY), 2.2, Paint()..color = wireColor);

      // Digital Energy Skate / Foot Thruster
      canvas.drawLine(
        Offset(footX - 6, footY),
        Offset(footX + 6, footY),
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..strokeWidth = 2.5
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );
    }

    drawWireframeLeg(-8, legSwing2, 0, false);
    drawWireframeLeg(8, legSwing1, legLift, true);

    // 3. Translucent Obsidian Torso with Wireframe Vectors
    final torsoPath = Path()
      ..moveTo(-16, -50)
      ..lineTo(16, -50)
      ..lineTo(11, -24)
      ..lineTo(-11, -24)
      ..close();
    canvas.drawPath(torsoPath, Paint()..color = const Color(0xEE02050E));
    canvas.drawPath(
      torsoPath,
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8,
    );

    // Torso Internal Wireframe Matrix Diagonals
    final diagPaint = Paint()
      ..color = const Color(0xFFFF007F).withValues(alpha: 0.6)
      ..strokeWidth = 1.2;
    canvas.drawLine(const Offset(-16, -50), const Offset(11, -24), diagPaint);
    canvas.drawLine(const Offset(16, -50), const Offset(-11, -24), diagPaint);

    // 4. Central Floating Quantum Power Core
    final corePos = const Offset(0, -37);
    canvas.drawCircle(
      corePos,
      8.0,
      Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.8)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6),
    );
    canvas.drawCircle(corePos, 5.0, Paint()..color = const Color(0xFFFF007F));
    canvas.drawCircle(corePos, 2.5, Paint()..color = Colors.white);

    // 5. Back Shoulder Vector Fin Wings (Flowing Data Streamers)
    final finLeft = Path()
      ..moveTo(-16, -48)
      ..lineTo(-26, -64)
      ..lineTo(-18, -42)
      ..close();
    canvas.drawPath(
      finLeft,
      Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.7)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4,
    );
    final finRight = Path()
      ..moveTo(16, -48)
      ..lineTo(26, -64)
      ..lineTo(18, -42)
      ..close();
    canvas.drawPath(
      finRight,
      Paint()
        ..color = const Color(0xFFFF007F).withValues(alpha: 0.7)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4,
    );

    // 6. Arm & Digital Lightning Cannon
    final recoilOffset = armRecoil * 3.5;
    final cannonX = 12.0 - recoilOffset;
    const cannonY = -37.0;

    // Cannon Rail Emitter
    canvas.drawLine(
      Offset(cannonX, cannonY - 3),
      Offset(cannonX + 22, cannonY - 3),
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..strokeWidth = 2.2,
    );
    canvas.drawLine(
      Offset(cannonX, cannonY + 3),
      Offset(cannonX + 22, cannonY + 3),
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..strokeWidth = 2.2,
    );
    // Floating Magnetic Ring on Cannon
    canvas.drawOval(
      Rect.fromCenter(
        center: Offset(cannonX + 14, cannonY),
        width: 6,
        height: 14,
      ),
      Paint()
        ..color = const Color(0xFFFF007F)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4,
    );

    // Muzzle Plasma Flash / Targeting Guide
    if (isAiming || muzzleFlash > 0.05) {
      canvas.drawCircle(
        Offset(cannonX + 24, cannonY),
        8.0 + muzzleFlash * 8.0,
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6),
      );
      canvas.drawCircle(
        Offset(cannonX + 24, cannonY),
        3.0,
        Paint()..color = Colors.white,
      );
      // Targeting Laser
      canvas.drawLine(
        Offset(cannonX + 24, cannonY),
        Offset(cannonX + 180, cannonY),
        Paint()
          ..color = const Color(0xFF00F5FF).withValues(alpha: 0.5)
          ..strokeWidth = 1.2,
      );
    }

    // 7. Digital Sentinel Helmet with Triple-Optic Sensor Matrix
    final headCenter = const Offset(0, -58);
    final headRect = RRect.fromRectAndRadius(
      Rect.fromCenter(center: headCenter, width: 18, height: 16),
      const Radius.circular(3),
    );
    canvas.drawRRect(headRect, Paint()..color = const Color(0xFF030712));
    canvas.drawRRect(
      headRect,
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.5,
    );

    // Triple Glowing Optic Sensor Eyes (Like in Concept Art!)
    final eyePaint = Paint()
      ..color = const Color(0xFFFF1744)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
    canvas.drawCircle(const Offset(0, -61), 2.2, eyePaint);
    canvas.drawCircle(const Offset(-4.5, -56), 2.0, eyePaint);
    canvas.drawCircle(const Offset(4.5, -56), 2.0, eyePaint);
    canvas.drawCircle(const Offset(0, -61), 1.0, Paint()..color = Colors.white);
    canvas.drawCircle(
      const Offset(-4.5, -56),
      0.9,
      Paint()..color = Colors.white,
    );
    canvas.drawCircle(
      const Offset(4.5, -56),
      0.9,
      Paint()..color = Colors.white,
    );
  }

  void _renderBullet(Canvas canvas, DroidBullet bullet) {
    if (biome == SectorBiome.cyberShinto) {
      // --- MAP 2: 3D CURSED OFUDA TALISMAN / FLYING SPIRIT SEAL ---
      if (bullet.trail.isNotEmpty) {
        for (int i = 0; i < bullet.trail.length; i++) {
          final tPos = bullet.trail[i];
          final progress = i / bullet.trail.length;
          final tPaint = Paint()
            ..color = const Color(0xFFFF003C).withValues(alpha: progress * 0.7)
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4.0);
          canvas.drawCircle(
            Offset(tPos.x, tPos.y),
            2.0 + progress * 5.0,
            tPaint,
          );
        }
      }

      canvas.save();
      canvas.translate(bullet.position.x, bullet.position.y);
      final angle = atan2(bullet.velocity.y, bullet.velocity.x);
      canvas.rotate(angle);

      // 3D Folding paper talisman with shadow and gold seal
      final paperRect = Rect.fromCenter(
        center: Offset.zero,
        width: 18,
        height: 10,
      );
      canvas.drawRect(
        paperRect,
        Paint()
          ..color = const Color(0xFFFF003C).withValues(alpha: 0.6)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6),
      );
      // Main parchment
      canvas.drawRect(paperRect, Paint()..color = const Color(0xFFFFFDE7));
      // Folding crease depth
      canvas.drawLine(
        const Offset(-9, 0),
        const Offset(9, 0),
        Paint()
          ..color = const Color(0xFFFFCDD2)
          ..strokeWidth = 1.5,
      );
      // Red borders
      canvas.drawRect(
        paperRect,
        Paint()
          ..color = const Color(0xFFFF003C)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.4,
      );
      // Cursed Kanji glyphs
      final glyphP = Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 1.8;
      canvas.drawLine(const Offset(-4, -2), const Offset(4, -2), glyphP);
      canvas.drawLine(const Offset(0, -4), const Offset(0, 4), glyphP);
      canvas.drawLine(const Offset(-3, 2), const Offset(3, 2), glyphP);
      // Glowing gold talisman eye
      canvas.drawCircle(
        const Offset(6, 0),
        2.0,
        Paint()..color = const Color(0xFFFFD700),
      );

      canvas.restore();
      return;
    }

    if (biome == SectorBiome.neoNebula) {
      // --- MAP 3: HIGH-VELOCITY PLASMA PARTICLE BOLT ---
      if (bullet.trail.isNotEmpty) {
        for (int i = 0; i < bullet.trail.length; i++) {
          final tPos = bullet.trail[i];
          final progress = i / bullet.trail.length;
          final tPaint = Paint()
            ..color = const Color(0xFF00F5FF).withValues(alpha: progress * 0.75)
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
          canvas.drawCircle(
            Offset(tPos.x, tPos.y),
            2.0 + progress * 4.0,
            tPaint,
          );
        }
      }

      canvas.save();
      canvas.translate(bullet.position.x, bullet.position.y);
      final angle = atan2(bullet.velocity.y, bullet.velocity.x);
      canvas.rotate(angle);

      // Cyan Plasma Halo
      canvas.drawOval(
        Rect.fromCenter(center: Offset.zero, width: 22, height: 8),
        Paint()
          ..color = const Color(0xFF00F5FF).withValues(alpha: 0.8)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6),
      );
      // Incandescent Core Spike
      canvas.drawOval(
        Rect.fromCenter(center: Offset.zero, width: 16, height: 4),
        Paint()..color = Colors.white,
      );
      // Trailing Magenta Ion Sparks
      canvas.drawCircle(
        const Offset(-8, 0),
        2.0,
        Paint()..color = const Color(0xFFFF007F),
      );

      canvas.restore();
      return;
    }

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
