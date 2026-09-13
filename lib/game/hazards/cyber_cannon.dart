import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import '../cyber_ninja_game.dart';
import 'base_hazard.dart';

/// Plasma projectile fired by the ceiling-mounted Cyber Cannon.
class CannonBullet {
  Vector2 position; // Local position relative to the cannon
  Vector2 velocity;
  final double radius;
  final List<Vector2> trail = [];
  bool isDead = false;

  CannonBullet({
    required this.position,
    required this.velocity,
    this.radius = 6.5,
  });
}

/// Dynamic ground impact spark from shattered plasma shells.
class CannonImpactSpark {
  Vector2 position;
  Vector2 vel;
  double alpha;
  final Color color;

  CannonImpactSpark({
    required this.position,
    required this.vel,
    this.alpha = 1.0,
    required this.color,
  });
}

/// Heavy Industrial Roof Cannon Turret:
/// Mounted directly on the overhead roof girders.
/// Dynamically tracks oncoming runner and shoots lethal plasma projectiles/bullets!
/// Features telegraphed aiming lock, predictable timing, and generous dodge windows (slide under / jump over).
class CyberCannon extends BaseHazard
    with HasGameReference<CyberNinjaRunnerGame> {
  final double fireInterval;
  final double bulletSpeed;
  final double targetingRange;
  static const double lockInDuration =
      0.50; // Time where aim freezes before shot

  double fireTimer = 0.0;
  double barrelAngle =
      2.3; // Default angle pointing down-left toward approaching runner
  double targetAngle = 2.3;
  double recoil = 0.0;
  double muzzleFlash = 0.0;
  bool isLockingOn = false;
  bool hasPlayedLockSound = false;

  final List<CannonBullet> activeBullets = [];
  final List<CannonImpactSpark> impactSparks = [];
  final Random _rng = Random();

  CyberCannon({
    required super.position,
    double? visionRange,
    this.fireInterval = 1.6,
    this.bulletSpeed = 320.0,
    this.targetingRange = 750.0,
    super.biome,
  }) : super(
         size: Vector2(54, 64),
         obstacleType: ObstacleType.cyberCannon,
         deathType: DeathType.hitByCannon,
         anchor: Anchor.topCenter,
       );

  @override
  void update(double dt) {
    super.update(dt);

    // 1. Recoil recovery & muzzle flash decay
    if (recoil > 0.0) {
      recoil = max(0.0, recoil - dt * 26.0);
    }
    if (muzzleFlash > 0.0) {
      muzzleFlash = max(0.0, muzzleFlash - dt * 7.5);
    }

    // 2. Dynamic Player Tracking & Telegraphing System
    final player = game.player;
    final pPos = player.position;
    final myWorld = worldPosition;

    final dx = pPos.x - myWorld.x;

    // Check if player is approaching within targeting range
    if (dx < 60 && dx > -targetingRange && !player.isStealthActive) {
      if (!isLockingOn) {
        // Prime cannon on detection so first shot fires promptly after 0.70s!
        fireTimer = fireInterval - 0.70;
      }
      isLockingOn = true;
      final timeUntilFire = fireInterval - fireTimer;
      final isAimLocked = timeUntilFire <= lockInDuration;

      // TRACKING PHASE: Continuously track player
      if (!isAimLocked) {
        hasPlayedLockSound = false;
        final leadX = pPos.x + player.velocity.x * 0.26;
        final leadDx = leadX - myWorld.x;
        final leadDy = (pPos.y - player.size.y * 0.35) - myWorld.y;

        targetAngle = atan2(leadDy, leadDx);
        // Clamp to lower-left quadrant
        targetAngle = targetAngle.clamp(1.68, 2.82);

        // Smooth hydraulic swivel
        barrelAngle += (targetAngle - barrelAngle) * min(1.0, dt * 5.0);
      } else {
        // LOCKED-IN PHASE: Aim is frozen! Barrel stops turning so player can dodge!
        if (!hasPlayedLockSound) {
          hasPlayedLockSound = true;
          AudioService().playSfx('click');
        }
      }

      // Advance firing cycle
      fireTimer += dt;
      if (fireTimer >= fireInterval) {
        fireTimer = 0.0;
        hasPlayedLockSound = false;
        _firePlasmaShell();
      }
    } else {
      isLockingOn = false;
      hasPlayedLockSound = false;
      fireTimer = min(fireTimer, fireInterval * 0.35);
      // Return gently to resting patrol angle
      barrelAngle += (2.3 - barrelAngle) * min(1.0, dt * 2.5);
    }

    // 3. Update active bullets & trajectory physics
    final groundSurfaceLocalY =
        (AppConstants.virtualHeight - AppConstants.groundHeight - 8.0) -
        myWorld.y;

    for (final bullet in activeBullets) {
      bullet.trail.add(bullet.position.clone());
      if (bullet.trail.length > 5) {
        bullet.trail.removeAt(0);
      }
      bullet.position += bullet.velocity * dt;

      // Ground strike detection
      if (bullet.position.y >= groundSurfaceLocalY) {
        bullet.isDead = true;
        _spawnImpactSparks(bullet.position);
      } else if (bullet.position.x < -850 || bullet.position.y > 650) {
        bullet.isDead = true;
      }
    }
    activeBullets.removeWhere((b) => b.isDead);

    // 4. Update impact sparks
    for (final spark in impactSparks) {
      spark.position += spark.vel * dt;
      spark.alpha -= dt * 2.8;
    }
    impactSparks.removeWhere((s) => s.alpha <= 0.0);
  }

  void _firePlasmaShell() {
    // Muzzle position relative to turret rotation center (0, 22)
    const barrelLength = 34.0;
    final muzzleOffset = Vector2(
      cos(barrelAngle) * barrelLength,
      sin(barrelAngle) * barrelLength,
    );
    final spawnPos = Vector2(0, 22) + muzzleOffset;

    final bulletVel = Vector2(cos(barrelAngle), sin(barrelAngle)) * bulletSpeed;

    activeBullets.add(CannonBullet(position: spawnPos, velocity: bulletVel));

    recoil = 8.5;
    muzzleFlash = 1.0;
    AudioService().playCannonFire();
  }

  void _spawnImpactSparks(Vector2 localPos) {
    for (int i = 0; i < 6; i++) {
      final angle = -pi * 0.15 - (_rng.nextDouble() * pi * 0.7);
      final spd = 60.0 + _rng.nextDouble() * 90.0;
      impactSparks.add(
        CannonImpactSpark(
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
  bool checkCollision(RunnerPlayer player) {
    // Shadow camouflage allows the player to evade targeting
    if (player.isStealthActive) {
      return false;
    }

    final pPos = player.position;

    // 1. Sliding Ducking Mechanic:
    // When sliding, ninja drops low to the ground (box height is only 35% of ninja height)
    final isSliding = player.isSliding;
    final boxHeight = isSliding ? player.size.y * 0.35 : player.size.y * 0.85;
    final pRect = Rect.fromLTWH(
      pPos.x - player.size.x * 0.30,
      pPos.y - boxHeight,
      player.size.x * 0.60,
      boxHeight,
    );

    final myWorld = worldPosition;

    // 2. Collision with active plasma bullets (with clean dodging windows)
    for (final bullet in activeBullets) {
      final bWorld = myWorld + bullet.position;

      // If player is sliding and bullet is above slide height, it sails harmlessly overhead!
      if (isSliding && bWorld.y < pPos.y - player.size.y * 0.35) {
        continue; // Clean slide dodge!
      }

      // Fair, precise bullet hitbox
      final bRect = Rect.fromCircle(
        center: Offset(bWorld.x, bWorld.y),
        radius: bullet.radius,
      );
      if (pRect.overlaps(bRect)) {
        return true;
      }
    }

    // 3. Direct high-jump collision with the turret body itself
    final turretRect = Rect.fromCenter(
      center: Offset(myWorld.x, myWorld.y + 20),
      width: 40,
      height: 40,
    );
    if (pRect.overlaps(turretRect)) {
      return true;
    }

    return false;
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    if (biome == SectorBiome.cyberShinto) {
      _renderCyberShintoTempleBell(canvas);
    } else if (biome == SectorBiome.neoNebula) {
      _renderPlasmaSentryTurret(canvas);
    } else {
      // 1. Ceiling Mount Bracket & Hydraulic Piston (Attached to roof girder at Y=0)
      final mountPaint = Paint()
        ..color = const Color(0xFF141924)
        ..style = PaintingStyle.fill;
      final mountEdge = Paint()
        ..color = const Color(0xFF2C384F)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0;

      // Roof anchor plate
      final plateRect = RRect.fromRectAndRadius(
        Rect.fromCenter(center: const Offset(0, 4), width: 44, height: 9),
        const Radius.circular(2.5),
      );
      canvas.drawRRect(plateRect, mountPaint);
      canvas.drawRRect(plateRect, mountEdge);

      // Mount Bolts
      final boltPaint = Paint()
        ..color = const Color(0xFF7A8B9E)
        ..style = PaintingStyle.fill;
      canvas.drawCircle(const Offset(-14, 4), 2.2, boltPaint);
      canvas.drawCircle(const Offset(14, 4), 2.2, boltPaint);

      // Hydraulic suspension stem
      final stemPaint = Paint()
        ..color = const Color(0xFF1F2636)
        ..style = PaintingStyle.fill;
      canvas.drawRect(
        Rect.fromCenter(center: const Offset(0, 13), width: 14, height: 12),
        stemPaint,
      );

      // 3. Articulated Plasma Cannon Barrel (Rotated around swivel hub at 0, 22)
      canvas.save();
      canvas.translate(0, 22);
      canvas.rotate(barrelAngle);

      // Apply hydraulic kickback recoil along barrel axis
      final recoilX = -recoil;

      // Barrel Base Breech Block
      final breechRect = RRect.fromRectAndRadius(
        Rect.fromLTWH(recoilX - 4, -9, 14, 18),
        const Radius.circular(3),
      );
      canvas.drawRRect(breechRect, Paint()..color = const Color(0xFF1B2230));
      canvas.drawRRect(breechRect, mountEdge);

      // Twin Reinforced Heavy Plasma Barrels
      final barrelPaint = Paint()
        ..color = const Color(0xFF0F131C)
        ..style = PaintingStyle.fill;
      final barrelRim = Paint()
        ..color = const Color(0xFF384660)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4;

      // Upper Barrel
      canvas.drawRect(Rect.fromLTWH(recoilX + 8, -8, 26, 6), barrelPaint);
      canvas.drawRect(Rect.fromLTWH(recoilX + 8, -8, 26, 6), barrelRim);
      // Lower Barrel
      canvas.drawRect(Rect.fromLTWH(recoilX + 8, 2, 26, 6), barrelPaint);
      canvas.drawRect(Rect.fromLTWH(recoilX + 8, 2, 26, 6), barrelRim);

      // Plasma Accelerator Conduit Coil (Neon Accent)
      final isAimLocked =
          isLockingOn && (fireInterval - fireTimer) <= lockInDuration;
      final coilPaint = Paint()
        ..color = isAimLocked
            ? AppConstants.hazardRed
            : AppConstants.stealthBlue
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0;
      canvas.drawLine(
        Offset(recoilX + 13, -10),
        Offset(recoilX + 13, 10),
        coilPaint,
      );
      canvas.drawLine(
        Offset(recoilX + 22, -10),
        Offset(recoilX + 22, 10),
        coilPaint,
      );

      // Dual Muzzle Brakes
      final muzzleBrakePaint = Paint()..color = const Color(0xFF283347);
      canvas.drawRRect(
        RRect.fromRectAndRadius(
          Rect.fromLTWH(recoilX + 32, -9, 4, 8),
          const Radius.circular(1.5),
        ),
        muzzleBrakePaint,
      );
      canvas.drawRRect(
        RRect.fromRectAndRadius(
          Rect.fromLTWH(recoilX + 32, 1, 4, 8),
          const Radius.circular(1.5),
        ),
        muzzleBrakePaint,
      );

      // Laser beam completely removed - Pure physical ballistic cannon (sirf goli chalegi)

      // Pre-fire barrel heat buildup
      if (isAimLocked) {
        final heatPulse = (0.5 + 0.5 * sin(fireTimer * 30.0)).clamp(0.0, 1.0);
        final heatPaint = Paint()
          ..color = const Color(
            0xFFFF3D00,
          ).withValues(alpha: 0.6 + heatPulse * 0.4)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
        canvas.drawCircle(Offset(recoilX + 34, -5), 3.5, heatPaint);
        canvas.drawCircle(Offset(recoilX + 34, 5), 3.5, heatPaint);
      }

      // Muzzle Flash Burst
      if (muzzleFlash > 0.0) {
        final flashRadius = 14.0 * muzzleFlash;
        final flashGlow = Paint()
          ..color = AppConstants.hazardRed.withValues(alpha: 0.85 * muzzleFlash)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
        canvas.drawCircle(Offset(recoilX + 36, 0), flashRadius, flashGlow);

        final flashCore = Paint()
          ..color = Colors.white.withValues(alpha: muzzleFlash)
          ..style = PaintingStyle.fill;
        canvas.drawCircle(
          Offset(recoilX + 36, 0),
          flashRadius * 0.45,
          flashCore,
        );

        // Spiky plasma flares
        final flarePaint = Paint()
          ..color = const Color(0xFFFFD54F).withValues(alpha: 0.9 * muzzleFlash)
          ..strokeWidth = 2.2;
        canvas.drawLine(
          Offset(recoilX + 36, 0),
          Offset(recoilX + 36 + flashRadius * 1.5, -flashRadius * 0.6),
          flarePaint,
        );
        canvas.drawLine(
          Offset(recoilX + 36, 0),
          Offset(recoilX + 36 + flashRadius * 1.5, flashRadius * 0.6),
          flarePaint,
        );
      }

      canvas.restore();

      // 4. Armored Swivel Turret Dome & Gimbal Chassis
      final domePaint = Paint()
        ..color = const Color(0xFF171E2B)
        ..style = PaintingStyle.fill;
      final domeRim = Paint()
        ..color = const Color(0xFF384660)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.2;

      canvas.drawCircle(const Offset(0, 22), 17.0, domePaint);
      canvas.drawCircle(const Offset(0, 22), 17.0, domeRim);

      // Hazard Caution Ring
      final cautionPaint = Paint()
        ..color = const Color(0xFFFF9100).withValues(alpha: 0.75)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0;
      canvas.drawArc(
        Rect.fromCircle(center: const Offset(0, 22), radius: 13.0),
        -pi * 0.8,
        pi * 0.6,
        false,
        cautionPaint,
      );

      // 5. Pulsing Fusion Core Eye
      final coreGlowColor = isAimLocked
          ? AppConstants.hazardRed
          : AppConstants.stealthBlue;
      final coreGlow = Paint()
        ..color = coreGlowColor.withValues(alpha: 0.85)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 7);
      canvas.drawCircle(const Offset(0, 22), 7.0, coreGlow);

      final coreCenter = Paint()
        ..color = Colors.white
        ..style = PaintingStyle.fill;
      canvas.drawCircle(const Offset(0, 22), 2.8, coreCenter);
    }

    // 6. Render Active In-Flight Projectiles (Goli / Spirit Blades / Magma Fireballs)
    for (final bullet in activeBullets) {
      if (biome == SectorBiome.cyberShinto) {
        // --- MAP 2: CURSED SPECTRAL SPIRIT BLADE / SHURIKEN ---
        // Crimson spirit smoke trail
        if (bullet.trail.isNotEmpty) {
          for (int i = 0; i < bullet.trail.length; i++) {
            final tPos = bullet.trail[i];
            final progress = i / bullet.trail.length;
            final tPaint = Paint()
              ..color = const Color(
                0xFFFF003C,
              ).withValues(alpha: progress * 0.55)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
            canvas.drawCircle(
              Offset(tPos.x, tPos.y),
              2.0 + progress * 3.0,
              tPaint,
            );
          }
        }

        canvas.save();
        canvas.translate(bullet.position.x, bullet.position.y);
        canvas.rotate(fireTimer * 12.0); // Spinning spirit shuriken

        final bladeGlow = Paint()
          ..color = const Color(0xFFFF003C)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
        canvas.drawCircle(Offset.zero, 8.0, bladeGlow);

        // 4-Pointed Cursed Shuriken
        final sPath = Path()
          ..moveTo(0, -9)
          ..lineTo(2.5, -2.5)
          ..lineTo(9, 0)
          ..lineTo(2.5, 2.5)
          ..lineTo(0, 9)
          ..lineTo(-2.5, 2.5)
          ..lineTo(-9, 0)
          ..lineTo(-2.5, -2.5)
          ..close();
        canvas.drawPath(sPath, Paint()..color = Colors.white);
        canvas.drawCircle(
          Offset.zero,
          3.0,
          Paint()..color = const Color(0xFFFFD700),
        );

        canvas.restore();
        continue;
      }

      if (biome == SectorBiome.neoNebula) {
        // --- MAP 3: DUAL RAPID PLASMA SENTRY BOLTS ---
        if (bullet.trail.isNotEmpty) {
          for (int i = 0; i < bullet.trail.length; i++) {
            final tPos = bullet.trail[i];
            final progress = i / bullet.trail.length;
            final tPaint = Paint()
              ..color = const Color(
                0xFF00F5FF,
              ).withValues(alpha: progress * 0.7)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
            canvas.drawCircle(
              Offset(tPos.x, tPos.y),
              2.5 + progress * 4.0,
              tPaint,
            );
          }
        }

        canvas.save();
        canvas.translate(bullet.position.x, bullet.position.y);

        // Cyan Plasma Energy Capsule
        final plasmaGlow = Paint()
          ..color = const Color(0xFF00F5FF)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
        canvas.drawCircle(Offset.zero, 9.0, plasmaGlow);
        canvas.drawCircle(
          Offset.zero,
          6.0,
          Paint()..color = const Color(0xFF00B0FF),
        );
        canvas.drawCircle(Offset.zero, 2.5, Paint()..color = Colors.white);

        canvas.restore();
        continue;
      }

      // Default Campaign Cannon Bullet
      // Bullet Combustion Smoke & Ember Trail
      if (bullet.trail.isNotEmpty) {
        for (int i = 0; i < bullet.trail.length; i++) {
          final tPos = bullet.trail[i];
          final progress = i / bullet.trail.length;
          final trailAlpha = progress * 0.50;
          final trailRadius = 2.5 + progress * 3.5;
          final tPaint = Paint()
            ..color = const Color(0xFFFF6D00).withValues(alpha: trailAlpha)
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2.5);
          canvas.drawCircle(Offset(tPos.x, tPos.y), trailRadius, tPaint);
        }
      }

      // Draw Physical Bullet Projectile Shell (Goli)
      canvas.save();
      canvas.translate(bullet.position.x, bullet.position.y);
      final bulletAngle = atan2(bullet.velocity.y, bullet.velocity.x);
      canvas.rotate(bulletAngle);

      // Trailing Incendiary Flame Glow
      final flameGlow = Paint()
        ..color = const Color(0xFFFF3D00).withValues(alpha: 0.75)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
      canvas.drawOval(
        Rect.fromCenter(center: const Offset(-4, 0), width: 14.0, height: 8.0),
        flameGlow,
      );

      // Metallic Cannon Bullet Body (Cylindrical Heavy Shell)
      final shellBody = RRect.fromRectAndRadius(
        Rect.fromCenter(center: const Offset(-1, 0), width: 13.0, height: 7.0),
        const Radius.circular(2.0),
      );
      final shellPaint = Paint()
        ..color = const Color(0xFF2C3440)
        ..style = PaintingStyle.fill;
      canvas.drawRRect(shellBody, shellPaint);

      // Brass / Tungsten Armor Ring on Bullet
      final ringPaint = Paint()
        ..color = const Color(0xFFFFB300)
        ..style = PaintingStyle.fill;
      canvas.drawRect(
        Rect.fromCenter(center: const Offset(-2, 0), width: 3.5, height: 6.8),
        ringPaint,
      );

      // Glowing Incendiary Bullet Warhead Tip
      final tipPath = Path()
        ..moveTo(4.5, -3.5)
        ..lineTo(8.5, 0)
        ..lineTo(4.5, 3.5)
        ..close();
      final tipPaint = Paint()
        ..color = const Color(0xFFFF1744)
        ..style = PaintingStyle.fill;
      canvas.drawPath(tipPath, tipPaint);

      final tipCore = Paint()
        ..color = Colors.white
        ..style = PaintingStyle.fill;
      canvas.drawCircle(const Offset(6.5, 0), 1.8, tipCore);

      canvas.restore();
    }

    // 7. Render Impact Sparks
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

  void _renderCyberShintoTempleBell(Canvas canvas) {
    // 1. Carved Lacquered Wood Ceiling Rafter Mount
    final beamRect = RRect.fromRectAndRadius(
      Rect.fromCenter(center: const Offset(0, 4), width: 48, height: 9),
      const Radius.circular(2.5),
    );
    canvas.drawRRect(beamRect, Paint()..color = const Color(0xFF1E030D));
    canvas.drawRRect(
      beamRect,
      Paint()
        ..color = const Color(0xFFFF003C)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8,
    );
    // Gold dragon ornament studs
    canvas.drawCircle(
      const Offset(-16, 4),
      2.2,
      Paint()..color = const Color(0xFFFFD700),
    );
    canvas.drawCircle(
      const Offset(16, 4),
      2.2,
      Paint()..color = const Color(0xFFFFD700),
    );

    // Braided crimson hanging suspension cords
    canvas.drawLine(
      const Offset(-4, 8),
      const Offset(-2, 18),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 2.5,
    );
    canvas.drawLine(
      const Offset(4, 8),
      const Offset(2, 18),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 2.5,
    );

    // 2. Swivel Bronze Bell (Bonsho) Pivot (0, 22)
    canvas.save();
    canvas.translate(0, 22);
    canvas.rotate(barrelAngle);

    final recoilX = -recoil;

    // 3D Ancient Bronze Temple Bell Body
    final bellPath = Path()
      ..moveTo(recoilX + 2, -10)
      ..lineTo(recoilX + 28, -14)
      ..lineTo(recoilX + 32, -16)
      ..lineTo(recoilX + 32, 16)
      ..lineTo(recoilX + 28, 14)
      ..lineTo(recoilX + 2, 10)
      ..close();
    canvas.drawPath(bellPath, Paint()..color = const Color(0xFF160E08));
    canvas.drawPath(
      bellPath,
      Paint()
        ..color = const Color(0xFFFF003C)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8,
    );

    // Relief bands & Inscribed Sutras on Bell
    canvas.drawLine(
      Offset(recoilX + 10, -11),
      Offset(recoilX + 10, 11),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 2.0,
    );
    canvas.drawLine(
      Offset(recoilX + 20, -13),
      Offset(recoilX + 20, 13),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 2.0,
    );
    // Golden Bell Lip
    canvas.drawLine(
      Offset(recoilX + 32, -16),
      Offset(recoilX + 32, 16),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 2.5,
    );

    final isAimLocked =
        isLockingOn && (fireInterval - fireTimer) <= lockInDuration;

    // Charging cursed spirit flame inside the bell
    if (isAimLocked) {
      final chargeGlow = Paint()
        ..color = const Color(0xFFFF003C).withValues(alpha: 0.85)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
      canvas.drawCircle(Offset(recoilX + 30, 0), 6.0, chargeGlow);
      canvas.drawCircle(
        Offset(recoilX + 30, 0),
        2.5,
        Paint()..color = const Color(0xFFFFD700),
      );
    }

    // Muzzle Flash
    if (muzzleFlash > 0.0) {
      canvas.drawCircle(
        Offset(recoilX + 36, 0),
        16.0 * muzzleFlash,
        Paint()
          ..color = const Color(0xFFFF003C)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 10),
      );
      canvas.drawCircle(
        Offset(recoilX + 36, 0),
        6.0 * muzzleFlash,
        Paint()..color = const Color(0xFFFFD700),
      );
    }

    canvas.restore();

    // 3. Central Dragon Swivel Hub Clasp
    canvas.drawCircle(
      const Offset(0, 22),
      15.0,
      Paint()..color = const Color(0xFF1F030E),
    );
    canvas.drawCircle(
      const Offset(0, 22),
      15.0,
      Paint()
        ..color = const Color(0xFFFFD700)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0,
    );
    canvas.drawCircle(
      const Offset(0, 22),
      6.0,
      Paint()
        ..color = const Color(0xFFFF003C)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
    );
    canvas.drawCircle(const Offset(0, 22), 2.5, Paint()..color = Colors.white);
  }

  void _renderPlasmaSentryTurret(Canvas canvas) {
    // 1. Heavy High-Tech Swivel Ceiling Mount
    final mountRect = RRect.fromRectAndRadius(
      Rect.fromCenter(center: const Offset(0, 4), width: 48, height: 9),
      const Radius.circular(2.5),
    );
    canvas.drawRRect(mountRect, Paint()..color = const Color(0xFF0C121E));
    canvas.drawRRect(
      mountRect,
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8,
    );
    // Hex bolts
    canvas.drawCircle(
      const Offset(-15, 4),
      2.0,
      Paint()..color = const Color(0xFF00F5FF),
    );
    canvas.drawCircle(
      const Offset(15, 4),
      2.0,
      Paint()..color = const Color(0xFF00F5FF),
    );

    // Power Conduit Stem
    canvas.drawRect(
      Rect.fromCenter(center: const Offset(0, 13), width: 14, height: 12),
      Paint()..color = const Color(0xFF141D2C),
    );
    canvas.drawLine(
      const Offset(0, 8),
      const Offset(0, 18),
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..strokeWidth = 3.5,
    );

    // 2. Articulated Twin Plasma Energy Barrels (0, 22)
    canvas.save();
    canvas.translate(0, 22);
    canvas.rotate(barrelAngle);

    final recoilX = -recoil;

    // Turret Breech Block with Amber Cooling Coils
    final breechRect = RRect.fromRectAndRadius(
      Rect.fromLTWH(recoilX - 4, -10, 18, 20),
      const Radius.circular(3),
    );
    canvas.drawRRect(breechRect, Paint()..color = const Color(0xFF101726));
    canvas.drawRRect(
      breechRect,
      Paint()
        ..color = const Color(0xFF1E2B45)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0,
    );

    // Amber Thermal Coils on Breech
    final coilPaint = Paint()
      ..color = const Color(0xFFFF9100)
      ..strokeWidth = 2.0;
    for (double cx = recoilX + 1; cx < recoilX + 14; cx += 4) {
      canvas.drawLine(Offset(cx, -8), Offset(cx, 8), coilPaint);
    }

    // Twin Plasma Energy Barrels
    const barrelLength = 18.0;
    final bTipX = recoilX + 14 + barrelLength;

    // Top Barrel
    canvas.drawLine(
      Offset(recoilX + 14, -4),
      Offset(bTipX, -4),
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..strokeWidth = 3.0
        ..strokeCap = StrokeCap.round,
    );
    canvas.drawCircle(Offset(bTipX, -4), 1.8, Paint()..color = Colors.white);

    // Bottom Barrel
    canvas.drawLine(
      Offset(recoilX + 14, 4),
      Offset(bTipX, 4),
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..strokeWidth = 3.0
        ..strokeCap = StrokeCap.round,
    );
    canvas.drawCircle(Offset(bTipX, 4), 1.8, Paint()..color = Colors.white);

    final isAimLocked =
        isLockingOn && (fireInterval - fireTimer) <= lockInDuration;

    // Red Tracking Targeting Laser Beam
    if (isAimLocked) {
      canvas.drawLine(
        Offset(bTipX, 0),
        Offset(bTipX + 500, 0),
        Paint()
          ..color = const Color(0xFFFF003C).withValues(alpha: 0.8)
          ..strokeWidth = 2.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );
    }

    // Cyan Plasma Muzzle Flare
    if (muzzleFlash > 0.0) {
      canvas.drawCircle(
        Offset(bTipX + 4, 0),
        16.0 * muzzleFlash,
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 10),
      );
      canvas.drawCircle(
        Offset(bTipX + 4, 0),
        6.0 * muzzleFlash,
        Paint()..color = Colors.white,
      );
    }

    canvas.restore();

    // 3. Gimbal Turret Chassis & Telemetry Sensor Ring
    canvas.drawCircle(
      const Offset(0, 22),
      15.0,
      Paint()..color = const Color(0xFF0B101A),
    );
    canvas.drawCircle(
      const Offset(0, 22),
      15.0,
      Paint()
        ..color = const Color(0xFF00F5FF)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0,
    );
    canvas.drawCircle(
      const Offset(0, 22),
      6.0,
      Paint()
        ..color = const Color(0xFFFF007F)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
    );
    canvas.drawCircle(const Offset(0, 22), 2.5, Paint()..color = Colors.white);
  }
}
