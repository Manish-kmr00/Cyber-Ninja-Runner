import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import '../sqube_game.dart';
import 'base_hazard.dart';

/// Plasma projectile fired by the heavy Cyber Titan Boss Mech.
class TitanPlasmaRound {
  Vector2 position; // Local position relative to CyberTitan bottomCenter
  Vector2 velocity;
  final double radius;
  final List<Vector2> trail = [];
  bool isDead = false;
  final bool isHighShot; // true = slide dodgeable, false = jump dodgeable
  double spinAngle = 0.0;

  TitanPlasmaRound({
    required this.position,
    required this.velocity,
    this.radius = 9.0,
    required this.isHighShot,
  });
}

/// Expanding shockwave spark/debris particle from Titan destruction & impacts.
class TitanScrapParticle {
  Offset position;
  Offset velocity;
  double alpha;
  final double size;
  final Color color;
  double rotation = 0.0;
  double rotSpeed = 0.0;

  TitanScrapParticle({
    required this.position,
    required this.velocity,
    this.alpha = 1.0,
    required this.size,
    required this.color,
    this.rotSpeed = 5.0,
  });
}

/// Floating exhaust steam/energy exhaust vent puff
class TitanVentSmoke {
  Offset position;
  Offset vel;
  double alpha = 0.8;
  double radius;
  final Color color;

  TitanVentSmoke({
    required this.position,
    required this.vel,
    required this.radius,
    required this.color,
  });
}

/// Design & Color Themes for Cyber Titan Mech, evolving every 200m!
class TitanTheme {
  final String name;
  final Color armorBase;
  final Color armorTrim;
  final Color neonCircuits;
  final Color coreEnergy;
  final Color coreAura;
  final Color visorGlow;
  final Color antennaFin;
  final Color footTrim;
  final Color plasmaCorona;
  final Color plasmaCore;
  final int
  headShapeStyle; // 0: V-Fin Gundam, 1: Spiked Oni Horns, 2: Cyber Ronin Crown, 3: Heavy Stealth Crest, 4: Golden Halo

  const TitanTheme({
    required this.name,
    required this.armorBase,
    required this.armorTrim,
    required this.neonCircuits,
    required this.coreEnergy,
    required this.coreAura,
    required this.visorGlow,
    required this.antennaFin,
    required this.footTrim,
    required this.plasmaCorona,
    required this.plasmaCore,
    required this.headShapeStyle,
  });

  /// Every 200 meters, cycles to a completely unique futuristic design & color palette!
  static TitanTheme fromDistanceMeters(int distanceMeters) {
    final cycle = (distanceMeters ~/ 200) % 5;
    switch (cycle) {
      case 0:
        // 0 - 199m: Crimson Apex (Classic Evangelion/Gundam Red-Cyan)
        return const TitanTheme(
          name: 'CRIMSON APEX',
          armorBase: Color(0xFF090D15),
          armorTrim: Color(0xFF263238),
          neonCircuits: Color(0xFF00E5FF),
          coreEnergy: Color(0xFFFF0055),
          coreAura: Color(0xFFFF2A6D),
          visorGlow: Color(0xFF00E5FF),
          antennaFin: Color(0xFFFF9100),
          footTrim: Color(0xFFFF2A6D),
          plasmaCorona: Color(0xFFFF0055),
          plasmaCore: Color(0xFFFF5252),
          headShapeStyle: 0, // V-Fin
        );
      case 1:
        // 200 - 399m: Toxic Venom Mech (Acid Matrix Green & Deep Violet Cyberpunk)
        return const TitanTheme(
          name: 'TOXIC VENOM',
          armorBase: Color(0xFF0A120D),
          armorTrim: Color(0xFF1B382B),
          neonCircuits: Color(0xFF00FF66),
          coreEnergy: Color(0xFF76FF03),
          coreAura: Color(0xFF00E676),
          visorGlow: Color(0xFFCCFF00),
          antennaFin: Color(0xFF00FF66),
          footTrim: Color(0xFF00E676),
          plasmaCorona: Color(0xFF00FF66),
          plasmaCore: Color(0xFFB2FF59),
          headShapeStyle: 1, // Spiked Oni Horns
        );
      case 2:
        // 400 - 599m: Quantum Frost Titan (Cryo Ice Blue, Glacial White & Silver)
        return const TitanTheme(
          name: 'QUANTUM FROST',
          armorBase: Color(0xFF0A1424),
          armorTrim: Color(0xFF1E3A5F),
          neonCircuits: Color(0xFF40C4FF),
          coreEnergy: Color(0xFF00B0FF),
          coreAura: Color(0xFF80D8FF),
          visorGlow: Color(0xFFE0F7FA),
          antennaFin: Color(0xFF00E5FF),
          footTrim: Color(0xFF0091EA),
          plasmaCorona: Color(0xFF00B0FF),
          plasmaCore: Color(0xFF80D8FF),
          headShapeStyle: 2, // Cyber Ronin Crown
        );
      case 3:
        // 600 - 799m: Solar Flare Berserker (Molten Magma Gold, Fiery Orange & Obsidian)
        return const TitanTheme(
          name: 'SOLAR FLARE',
          armorBase: Color(0xFF140D05),
          armorTrim: Color(0xFF3E2723),
          neonCircuits: Color(0xFFFFD600),
          coreEnergy: Color(0xFFFF6D00),
          coreAura: Color(0xFFFFAB00),
          visorGlow: Color(0xFFFF3D00),
          antennaFin: Color(0xFFFFD600),
          footTrim: Color(0xFFFF6D00),
          plasmaCorona: Color(0xFFFF3D00),
          plasmaCore: Color(0xFFFFD600),
          headShapeStyle: 3, // Heavy Stealth Crest
        );
      case 4:
      default:
        // 800 - 999m+: Dark Void Phantom (Dark Matter Purple, Ultra Neon Violet & Neon Pink)
        return const TitanTheme(
          name: 'DARK VOID PHANTOM',
          armorBase: Color(0xFF0E071A),
          armorTrim: Color(0xFF28113E),
          neonCircuits: Color(0xFFE040FB),
          coreEnergy: Color(0xFFD500F9),
          coreAura: Color(0xFFAA00FF),
          visorGlow: Color(0xFFFF00E5),
          antennaFin: Color(0xFFE040FB),
          footTrim: Color(0xFFD500F9),
          plasmaCorona: Color(0xFFAA00FF),
          plasmaCore: Color(0xFFEA80FC),
          headShapeStyle: 4, // Golden Halo
        );
    }
  }
}

/// Cyber Titan Boss Mech (Ultra Sci-Fi Heavy Combat Mech):
/// Inspired by Pacific Rim / Armored Core / Cyberpunk anime mechs:
/// - Changes colors & mechanical head designs every 200m!
/// - Hexagonal stealth armor plating & chiseled angular carapace
/// - Glowing neon circuitry runes running along chassis and limbs
/// - Dual Gatling-Plasma shoulder cannons with rotating laser telegraph array
/// - Chest Overcharged Quantum Arc Reactor with pulsing energy shield
/// - Dynamic steam vents releasing smoke particles from exhaust ports
/// - Heavy hydraulics with piston shafts & magnetic stabilizer foot pads
class CyberTitan extends BaseHazard
    with HasGameReference<CyberNinjaRunnerGame> {
  final double patrolDistance;
  final double patrolSpeed;
  final double fireInterval;
  final double bulletSpeed;
  final double detectionRange;
  final double? minX;
  final double? maxX;
  final int spawnDistanceMeters;
  late final TitanTheme theme;

  double startX = 0;
  bool movingRight = true;
  double walkCycle = 0.0;
  double reactorPulse = 0.0;
  double circuitGlow = 0.0;
  double fireTimer = 0.0;
  double telegraphTimer = 0.0;
  double muzzleFlash = 0.0;
  double cannonRecoil = 0.0;
  double ventTimer = 0.0;
  bool isTargeting = false;
  bool nextShotIsHigh = true;

  // Boss state and Combat
  final bool isBoss;
  final int maxHp;
  int currentHp;
  double hitFlashTimer = 0.0;

  // Destruction state when sliced by Ninja
  bool isSliced = false;
  double sliceTimer = 0.0;
  final List<TitanScrapParticle> scrapParticles = [];
  final List<TitanPlasmaRound> activeRounds = [];
  final List<TitanVentSmoke> exhaustVents = [];
  final Random _rng = Random();

  CyberTitan({
    required super.position,
    this.patrolDistance = 160.0,
    this.patrolSpeed = 120.0,
    this.fireInterval = 1.0,
    this.bulletSpeed = 460.0,
    this.detectionRange = 750.0,
    this.spawnDistanceMeters = 0,
    this.minX,
    this.maxX,
    this.isBoss = true,
    this.maxHp = 1,
  }) : currentHp = maxHp,
       super(
         size: Vector2(98, 120),
         obstacleType: ObstacleType.cyberTitan,
         deathType: DeathType.hitByTitan,
         anchor: Anchor.bottomCenter,
       ) {
    startX = position.x;
    final dist = spawnDistanceMeters > 0
        ? spawnDistanceMeters
        : (position.x / 10).round();
    theme = TitanTheme.fromDistanceMeters(dist);
  }

  void takeDamage({int amount = 1}) {
    if (isSliced) return;
    currentHp = max(0, currentHp - amount);
    hitFlashTimer = 0.25;
    AudioService().playClick();
    AudioService().playSfx('laser');
    if (currentHp <= 0) {
      sliceAndDestroy();
    }
  }

  void sliceAndDestroy() {
    if (isSliced) return;
    isSliced = true;
    sliceTimer = 0.75; // 750ms ultra cinematic blast

    try {
      game.shakeCamera(0.85);
      final cpBonus = isBoss
          ? (game.mode == GameMode.tenXChallenge ? 1000 : 500)
          : (game.mode == GameMode.tenXChallenge ? 250 : 100);
      game.collectedCP += cpBonus;
      game.saveService.addCyberPoints(cpBonus);
    } catch (_) {}

    // Spawn 36 heavy flying mechanical scrap, armor shards & circuit sparks
    for (int i = 0; i < 36; i++) {
      final angle = -pi * 0.02 - (_rng.nextDouble() * pi * 0.96);
      final spd = 150.0 + _rng.nextDouble() * 280.0;
      scrapParticles.add(
        TitanScrapParticle(
          position: const Offset(0, -60),
          velocity: Offset(cos(angle) * spd, sin(angle) * spd),
          size: 3.5 + _rng.nextDouble() * 6.0,
          color: _rng.nextBool()
              ? const Color(0xFF1E2838)
              : (_rng.nextBool()
                    ? const Color(0xFFFF0055)
                    : const Color(0xFF00E5FF)),
          rotSpeed: (_rng.nextDouble() - 0.5) * 14.0,
        ),
      );
    }
  }

  @override
  void update(double dt) {
    super.update(dt);

    if (isSliced) {
      sliceTimer -= dt;
      for (final p in scrapParticles) {
        p.position += p.velocity * dt;
        p.rotation += p.rotSpeed * dt;
        p.velocity = Offset(
          p.velocity.dx * 0.98,
          p.velocity.dy + 850.0 * dt, // heavy gravity
        );
        p.alpha = (sliceTimer / 0.75).clamp(0.0, 1.0);
      }
      if (sliceTimer <= 0.0) {
        removeFromParent();
      }
      return;
    }

    walkCycle += dt * 8.5; // fast aggressive strides
    reactorPulse += dt * 8.5;
    circuitGlow += dt * 6.0;

    // Decay recoil and muzzle flash
    if (cannonRecoil > 0.0) {
      cannonRecoil = max(0.0, cannonRecoil - dt * 20.0);
    }
    if (muzzleFlash > 0.0) {
      muzzleFlash = max(0.0, muzzleFlash - dt * 7.0);
    }
    if (hitFlashTimer > 0.0) {
      hitFlashTimer = max(0.0, hitFlashTimer - dt);
    }

    // Exhaust Vent Smoke Emitter (Sci-Fi Steam Venting)
    ventTimer += dt;
    if (ventTimer >= 0.07) {
      ventTimer = 0.0;
      final ventSide = _rng.nextBool() ? -34.0 : 34.0;
      exhaustVents.add(
        TitanVentSmoke(
          position: Offset(ventSide, -88),
          vel: Offset(
            (_rng.nextDouble() - 0.5) * 20.0,
            -35.0 - _rng.nextDouble() * 35.0,
          ),
          radius: 3.0 + _rng.nextDouble() * 3.5,
          color: _rng.nextBool()
              ? const Color(0xFF00E5FF).withValues(alpha: 0.7)
              : const Color(0xFFFF2A6D).withValues(alpha: 0.7),
        ),
      );
    }

    // Update Vent Smoke
    for (final s in exhaustVents) {
      s.position += s.vel * dt;
      s.radius += dt * 10.0;
      s.alpha -= dt * 1.8;
    }
    exhaustVents.removeWhere((s) => s.alpha <= 0.0);

    // AI Targeting & Rapid Regular Firing Mechanism
    if (isMounted) {
      final player = game.player;
      final myWorldX = worldPosition.x;
      final playerWorldX = player.position.x;
      // dx is negative when player is approaching from front (left side of Titan)
      final dx = playerWorldX - myWorldX;

      // Only target and fire when ninja is in front of the Titan (approaching from left)
      // Once ninja crosses/passes the Titan (dx >= -20), Titan immediately stops firing from behind!
      if (dx < -30 && dx > -detectionRange) {
        movingRight = false; // face approaching ninja
        isTargeting = true;
        fireTimer += dt;

        // Snappy laser telegraph beam (0.28s warning before each rapid shot)
        if (fireTimer >= fireInterval - 0.28) {
          telegraphTimer = (telegraphTimer + dt * 16.0).clamp(0.0, 1.0);
        } else {
          telegraphTimer = 0.0;
        }

        if (fireTimer >= fireInterval) {
          fireTimer = 0.0;
          telegraphTimer = 0.0;
          _firePlasmaVolley(
            towardsLeft: true,
          ); // fire forward towards incoming ninja
          nextShotIsHigh = !nextShotIsHigh;
        }
      } else {
        // Ninja has passed the Titan or is out of range: completely cease fire and shut off laser!
        isTargeting = false;
        telegraphTimer = 0.0;
        fireTimer = 0.0;
      }
    }

    // Patrol movement (maintains strong chase speed)
    final effectiveMinX = minX ?? (startX - patrolDistance);
    final effectiveMaxX = maxX ?? (startX + patrolDistance);
    final currentSpeed = isTargeting ? (patrolSpeed * 0.75) : patrolSpeed;

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

    // Update active plasma projectiles
    for (final round in activeRounds) {
      round.spinAngle += dt * 18.0;
      round.trail.add(round.position.clone());
      if (round.trail.length > 7) {
        round.trail.removeAt(0);
      }
      round.position += round.velocity * dt;

      if (round.position.x < -1000 || round.position.x > 1000) {
        round.isDead = true;
      }
    }
    activeRounds.removeWhere((r) => r.isDead);
  }

  void _firePlasmaVolley({required bool towardsLeft}) {
    final barrelX = towardsLeft ? -42.0 : 42.0;
    final barrelY = nextShotIsHigh ? -82.0 : -45.0;

    final spawnPos = Vector2(barrelX, barrelY);
    final speedX = towardsLeft ? -bulletSpeed : bulletSpeed;
    final bulletVel = Vector2(speedX, 0.0);

    activeRounds.add(
      TitanPlasmaRound(
        position: spawnPos,
        velocity: bulletVel,
        radius: 10.0,
        isHighShot: nextShotIsHigh,
      ),
    );

    cannonRecoil = 10.0;
    muzzleFlash = 1.0;
    AudioService().playSfx('laser');
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (isSliced) return false;

    if (player.isStealthActive) {
      return false;
    }

    final pPos = player.position;
    final isSliding = player.isSliding;
    final isSlashing = player.isSlashing;
    final myWorld = worldPosition;

    // 1. Check incoming plasma rounds
    for (final round in activeRounds) {
      if (round.isDead) continue;
      final rWorld = myWorld + round.position;

      // Katana cuts plasma in mid-air
      if (isSlashing) {
        if (rWorld.x <= pPos.x + player.size.x + 160.0 &&
            rWorld.x >= pPos.x - 40.0 &&
            (rWorld.y - (pPos.y - player.size.y * 0.50)).abs() < 85.0) {
          round.isDead = true;
          AudioService().playClick();
          continue;
        }
      }

      // High shot: slide underneath
      if (round.isHighShot &&
          isSliding &&
          rWorld.y < pPos.y - player.size.y * 0.35) {
        continue;
      }

      // If ninja is already to the right of this bullet (ninja successfully passed it), bullet cannot harm ninja from behind!
      if (rWorld.x < pPos.x - player.size.x * 0.40) {
        continue;
      }

      final rRect = Rect.fromCircle(
        center: Offset(rWorld.x, rWorld.y),
        radius: round.radius + 3.0,
      );

      final boxHeight = isSliding ? player.size.y * 0.35 : player.size.y * 0.85;
      final pRect = Rect.fromLTWH(
        pPos.x - player.size.x * 0.30,
        pPos.y - boxHeight,
        player.size.x * 0.60,
        boxHeight,
      );

      if (pRect.overlaps(rRect)) {
        round.isDead = true;
        return true;
      }
    }

    // 2. Direct body collision
    final pBodyRect = Rect.fromLTWH(
      pPos.x - player.size.x / 2,
      pPos.y - player.size.y,
      player.size.x,
      player.size.y,
    );

    final titanBodyRect = Rect.fromLTWH(
      myWorld.x - size.x * 0.44,
      myWorld.y - size.y * 0.96,
      size.x * 0.88,
      size.y * 0.96,
    );

    // Jump Stomp attack from above (acrobatic head bounce)
    if (player.velocity.y > 60.0 &&
        pPos.y < (myWorld.y - size.y * 0.70) &&
        (pPos.x - myWorld.x).abs() < size.x * 0.55) {
      player.velocity.y = -640.0; // high acrobatic bounce
      takeDamage(amount: 1);
      return false; // player lands hit safely
    }

    if (pBodyRect.overlaps(titanBodyRect)) {
      if (isSlashing) {
        takeDamage(amount: 1);
        return false;
      }
      return true;
    }
    return false;
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    // Death explosion & debris if sliced
    if (isSliced) {
      final t = (0.75 - sliceTimer) / 0.75;
      final fade = (1.0 - t).clamp(0.0, 1.0);

      canvas.save();
      canvas.translate(size.x / 2, size.y);

      // Expanding dual shockwave
      final blastRadius = 24.0 + t * 110.0;
      final blastPaint = Paint()
        ..color = const Color(0xFFFF0055).withValues(alpha: (1.0 - t) * 0.8)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 4.5
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 10);
      canvas.drawCircle(const Offset(0, -60), blastRadius, blastPaint);

      final innerBlast = Paint()
        ..color = const Color(0xFF00E5FF).withValues(alpha: (1.0 - t) * 0.7)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 3.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
      canvas.drawCircle(const Offset(0, -60), blastRadius * 0.65, innerBlast);

      // Flying debris shards
      for (final p in scrapParticles) {
        canvas.save();
        canvas.translate(p.position.dx, p.position.dy);
        canvas.rotate(p.rotation);
        final shardPaint = Paint()
          ..color = p.color.withValues(alpha: p.alpha * fade)
          ..style = PaintingStyle.fill;
        canvas.drawRect(
          Rect.fromCenter(
            center: Offset.zero,
            width: p.size,
            height: p.size * 1.6,
          ),
          shardPaint,
        );
        canvas.restore();
      }

      // Neon Katana Bisecting Slash Flash
      canvas.drawLine(
        const Offset(-38, -85),
        const Offset(38, -35),
        Paint()
          ..color = Colors.white.withValues(alpha: fade)
          ..strokeWidth = 6.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5),
      );
      canvas.drawLine(
        const Offset(-38, -85),
        const Offset(38, -35),
        Paint()
          ..color = const Color(0xFF00E5FF).withValues(alpha: fade)
          ..strokeWidth = 10.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 12),
      );

      canvas.restore();
      return;
    }

    canvas.save();
    canvas.translate(size.x / 2, size.y);

    if (!movingRight) {
      canvas.scale(-1, 1);
    }

    // 1. Sci-Fi Vent Steam Particles
    for (final v in exhaustVents) {
      final ventPaint = Paint()
        ..color = v.color.withValues(alpha: v.alpha.clamp(0.0, 1.0))
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
      canvas.drawCircle(v.position, v.radius, ventPaint);
    }

    // 2. High-Tech Hex Ground Shadow
    final shadowPaint = Paint()
      ..color = Colors.black.withValues(alpha: 0.70)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
    canvas.drawOval(
      Rect.fromCenter(center: const Offset(0, -2), width: 90, height: 18),
      shadowPaint,
    );

    // 3. Heavy Sci-Fi Articulated Bipedal Legs
    final legA = sin(walkCycle) * 0.38;
    final legB = -sin(walkCycle) * 0.38;

    _drawSciFiLeg(canvas, isLeft: true, angle: legA);
    _drawSciFiLeg(canvas, isLeft: false, angle: legB);

    // 4. Armored Pelvis Core & Power Conduit
    final pelvisPath = Path()
      ..moveTo(-26, -44)
      ..lineTo(-30, -32)
      ..lineTo(30, -32)
      ..lineTo(26, -44)
      ..close();
    canvas.drawPath(pelvisPath, Paint()..color = theme.armorBase);
    canvas.drawPath(
      pelvisPath,
      Paint()
        ..color = theme.armorTrim
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.2,
    );

    // 5. Heavy Sci-Fi Chiseled Torso with Carbon-Fiber Plating
    final torsoPath = Path()
      ..moveTo(-34, -44)
      ..lineTo(-44, -82)
      ..lineTo(-32, -98)
      ..lineTo(32, -98)
      ..lineTo(44, -82)
      ..lineTo(34, -44)
      ..close();

    // Dark titanium armor base
    canvas.drawPath(torsoPath, Paint()..color = theme.armorBase);

    // Carbon fiber armor trims
    canvas.drawPath(
      torsoPath,
      Paint()
        ..color = theme.armorTrim
        ..style = PaintingStyle.stroke
        ..strokeWidth = 3.0,
    );

    // Glowing Neon Circuit Traces (Sci-Fi Cyberspace lines)
    final circuitAlpha = 0.55 + 0.35 * sin(circuitGlow);
    final circuitPaint = Paint()
      ..color = theme.neonCircuits.withValues(alpha: circuitAlpha)
      ..strokeWidth = 1.6
      ..style = PaintingStyle.stroke;

    // Left circuit trace
    final cPathL = Path()
      ..moveTo(-32, -82)
      ..lineTo(-22, -82)
      ..lineTo(-18, -60)
      ..lineTo(-24, -46);
    canvas.drawPath(cPathL, circuitPaint);

    // Right circuit trace
    final cPathR = Path()
      ..moveTo(32, -82)
      ..lineTo(22, -82)
      ..lineTo(18, -60)
      ..lineTo(24, -46);
    canvas.drawPath(cPathR, circuitPaint);

    // 6. Overcharged Quantum Arc Reactor (Central glowing sphere + rotating arcs)
    final pulseA = 0.70 + 0.30 * sin(reactorPulse);
    final coreGlow = Paint()
      ..color = theme.coreEnergy.withValues(alpha: pulseA)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 10);
    canvas.drawCircle(const Offset(0, -68), 14.0, coreGlow);

    final coreOuter = Paint()..color = theme.coreAura;
    canvas.drawCircle(const Offset(0, -68), 10.0, coreOuter);

    // Rotating reactor containment rings
    canvas.save();
    canvas.translate(0, -68);
    canvas.rotate(reactorPulse * 1.5);
    final ringPaint = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawArc(
      const Rect.fromLTWH(-12, -12, 24, 24),
      0,
      pi * 0.7,
      false,
      ringPaint,
    );
    canvas.drawArc(
      const Rect.fromLTWH(-12, -12, 24, 24),
      pi,
      pi * 0.7,
      false,
      ringPaint,
    );
    canvas.drawCircle(Offset.zero, 4.5, Paint()..color = Colors.white);
    canvas.restore();

    // 7. Dual Heavy Gatling-Plasma Shoulder Cannons
    final recoil = cannonRecoil;
    _drawHeavyCannon(canvas, posX: -38, posY: -94, recoil: recoil);
    _drawHeavyCannon(canvas, posX: 30, posY: -94, recoil: recoil);

    // 8. Holographic Laser Telegraph Beam
    if (telegraphTimer > 0.0) {
      final beamY = nextShotIsHigh ? -82.0 : -45.0;
      final beamPaint = Paint()
        ..color = theme.coreEnergy.withValues(alpha: telegraphTimer * 0.85)
        ..strokeWidth = 2.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
      canvas.drawLine(Offset(42, beamY), Offset(600, beamY), beamPaint);

      // Sci-Fi Reticle / Crosshair at lock distance
      final reticleX = 140.0;
      final retPaint = Paint()
        ..color = Colors.white.withValues(alpha: telegraphTimer)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4;
      canvas.drawCircle(Offset(reticleX, beamY), 8.0, retPaint);
      canvas.drawLine(
        Offset(reticleX - 11, beamY),
        Offset(reticleX + 11, beamY),
        retPaint,
      );
      canvas.drawLine(
        Offset(reticleX, beamY - 11),
        Offset(reticleX, beamY + 11),
        retPaint,
      );
    }

    // 9. Muzzle Flash Shock
    if (muzzleFlash > 0.05) {
      final flashY = nextShotIsHigh ? -82.0 : -45.0;
      final flashGlow = Paint()
        ..color = theme.plasmaCorona.withValues(alpha: muzzleFlash)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 14);
      canvas.drawCircle(
        Offset(46 - recoil, flashY),
        18.0 * muzzleFlash,
        flashGlow,
      );
      canvas.drawCircle(
        Offset(46 - recoil, flashY),
        7.0 * muzzleFlash,
        Paint()..color = Colors.white,
      );
    }

    // 10. Sci-Fi Mecha Helmet & Cyber Visor (Dynamic Head Design by Theme)
    final headPath = Path()
      ..moveTo(-18, -120)
      ..lineTo(-24, -106)
      ..lineTo(-14, -98)
      ..lineTo(14, -98)
      ..lineTo(24, -106)
      ..lineTo(18, -120)
      ..close();
    canvas.drawPath(headPath, Paint()..color = theme.armorBase);
    canvas.drawPath(
      headPath,
      Paint()
        ..color = theme.armorTrim
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0,
    );

    // Dynamic Mecha Head Crest & Antenna Variations:
    _drawHeadCrest(canvas);

    // Glowing Optical Sensor Visor
    final visorRect = RRect.fromRectAndRadius(
      const Rect.fromLTWH(-13, -112, 26, 7),
      const Radius.circular(3),
    );
    canvas.drawRRect(visorRect, Paint()..color = Colors.black);
    final visorGlow = Paint()
      ..color = theme.visorGlow
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawCircle(const Offset(4, -108.5), 4.0, visorGlow);
    canvas.drawCircle(
      const Offset(4, -108.5),
      2.0,
      Paint()..color = Colors.white,
    );

    canvas.restore();

    // 11. Render active plasma rounds in local coordinate space
    canvas.save();
    canvas.translate(size.x / 2, size.y);
    for (final round in activeRounds) {
      _renderPlasmaRound(canvas, round);
    }
    canvas.restore();

    // 12. Floating Boss HUD & Health Bar (rendered in unflipped, upright world space)
    if (isBoss && !isSliced) {
      canvas.save();
      canvas.translate(size.x / 2, size.y);

      const hudWidth = 112.0;
      const hudHeight = 8.0;
      const hudTop = -145.0;
      const hudLeft = -hudWidth / 2;

      // Boss Indicator Tag
      final tp = TextPainter(
        text: TextSpan(
          text: '⚠️ BOSS // ${theme.name}',
          style: TextStyle(
            fontSize: 8.5,
            fontWeight: FontWeight.w900,
            color: theme.coreEnergy,
            letterSpacing: 1.2,
            shadows: [Shadow(color: theme.coreAura, blurRadius: 6.0)],
          ),
        ),
        textDirection: TextDirection.ltr,
      )..layout();
      tp.paint(canvas, Offset(-tp.width / 2, hudTop - 14));

      // Health Bar Container
      final bgRect = Rect.fromLTWH(hudLeft, hudTop, hudWidth, hudHeight);
      canvas.drawRRect(
        RRect.fromRectAndRadius(bgRect, const Radius.circular(3)),
        Paint()..color = const Color(0xDD0C101A),
      );
      canvas.drawRRect(
        RRect.fromRectAndRadius(bgRect, const Radius.circular(3)),
        Paint()
          ..color = theme.coreAura.withValues(alpha: 0.7)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.2,
      );

      // Health Fill Segment
      final hpFraction = (currentHp / maxHp).clamp(0.0, 1.0);
      if (hpFraction > 0) {
        final fillRect = Rect.fromLTWH(
          hudLeft + 1.5,
          hudTop + 1.5,
          (hudWidth - 3.0) * hpFraction,
          hudHeight - 3.0,
        );
        canvas.drawRRect(
          RRect.fromRectAndRadius(fillRect, const Radius.circular(2)),
          Paint()
            ..color = hpFraction > 0.5
                ? const Color(0xFF00FF66)
                : (hpFraction > 0.25
                      ? AppConstants.coinGold
                      : AppConstants.hazardRed),
        );
      }

      // Hit Flash Overlay when taking damage
      if (hitFlashTimer > 0.0) {
        final flashPaint = Paint()
          ..color = Colors.white.withValues(
            alpha: (hitFlashTimer / 0.25).clamp(0.0, 0.75),
          )
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 12);
        canvas.drawRRect(
          RRect.fromRectAndRadius(
            Rect.fromLTWH(-48, -120, 96, 120),
            const Radius.circular(12),
          ),
          flashPaint,
        );
      }

      canvas.restore();
    }
  }

  void _drawHeadCrest(Canvas canvas) {
    final finPaint = Paint()
      ..color = theme.antennaFin
      ..style = PaintingStyle.fill;

    switch (theme.headShapeStyle) {
      case 0:
        // 0: Classic Dual V-Fin Antennas (Gundam style)
        final finL = Path()
          ..moveTo(-16, -118)
          ..lineTo(-28, -134)
          ..lineTo(-18, -126)
          ..close();
        canvas.drawPath(finL, finPaint);

        final finR = Path()
          ..moveTo(16, -118)
          ..lineTo(28, -134)
          ..lineTo(18, -126)
          ..close();
        canvas.drawPath(finR, finPaint);
        break;

      case 1:
        // 1: Spiked Cyber Oni Curved Horns (Demon Mech style)
        final hornL = Path()
          ..moveTo(-14, -114)
          ..quadraticBezierTo(-34, -124, -30, -142)
          ..quadraticBezierTo(-22, -130, -10, -122)
          ..close();
        canvas.drawPath(hornL, finPaint);

        final hornR = Path()
          ..moveTo(14, -114)
          ..quadraticBezierTo(34, -124, 30, -142)
          ..quadraticBezierTo(22, -130, 10, -122)
          ..close();
        canvas.drawPath(hornR, finPaint);
        break;

      case 2:
        // 2: Cyber Ronin Crown (Angular Samurai kabuto side crests)
        final crownL = Path()
          ..moveTo(-18, -108)
          ..lineTo(-32, -116)
          ..lineTo(-26, -128)
          ..lineTo(-14, -122)
          ..close();
        canvas.drawPath(crownL, finPaint);

        final crownR = Path()
          ..moveTo(18, -108)
          ..lineTo(32, -116)
          ..lineTo(26, -128)
          ..lineTo(14, -122)
          ..close();
        canvas.drawPath(crownR, finPaint);

        // Center Crest Gem
        canvas.drawCircle(
          const Offset(0, -124),
          4.5,
          Paint()..color = theme.neonCircuits,
        );
        break;

      case 3:
        // 3: Heavy Stealth Crest (Forward-swept aerodynamic fin)
        final crest = Path()
          ..moveTo(-6, -120)
          ..lineTo(0, -140)
          ..lineTo(6, -120)
          ..close();
        canvas.drawPath(crest, finPaint);

        // Dual side sensor vanes
        canvas.drawLine(
          const Offset(-22, -108),
          const Offset(-32, -118),
          finPaint..strokeWidth = 3.0,
        );
        canvas.drawLine(
          const Offset(22, -108),
          const Offset(32, -118),
          finPaint..strokeWidth = 3.0,
        );
        break;

      case 4:
      default:
        // 4: Halo Quantum Ring (Futuristic Archangel/Deity Mech Halo)
        final haloPaint = Paint()
          ..color = theme.antennaFin
          ..style = PaintingStyle.stroke
          ..strokeWidth = 2.5
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
        canvas.drawOval(
          Rect.fromCenter(center: const Offset(0, -132), width: 38, height: 14),
          haloPaint,
        );
        canvas.drawCircle(
          const Offset(0, -132),
          3.0,
          Paint()..color = Colors.white,
        );
        break;
    }
  }

  void _drawSciFiLeg(
    Canvas canvas, {
    required bool isLeft,
    required double angle,
  }) {
    canvas.save();
    final hipX = isLeft ? -18.0 : 18.0;
    const hipY = -36.0;
    canvas.translate(hipX, hipY);
    canvas.rotate(angle);

    // Thigh Heavy Plating
    final thighPath = Path()
      ..moveTo(-7, 0)
      ..lineTo(-9, 18)
      ..lineTo(9, 18)
      ..lineTo(7, 0)
      ..close();
    canvas.drawPath(thighPath, Paint()..color = theme.armorBase);
    canvas.drawPath(
      thighPath,
      Paint()
        ..color = theme.armorTrim
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.6,
    );

    // Knee Piston Sphere
    canvas.drawCircle(
      const Offset(0, 18),
      6.0,
      Paint()..color = const Color(0xFF263238),
    );
    canvas.drawCircle(
      const Offset(0, 18),
      3.0,
      Paint()..color = theme.neonCircuits.withValues(alpha: 0.8),
    );

    // Dual Hydraulic Chrome Cylinders
    final pistonPaint = Paint()
      ..color = const Color(0xFFB0BEC5)
      ..strokeWidth = 3.0;
    canvas.drawLine(const Offset(-3, 18), const Offset(-3, 34), pistonPaint);
    canvas.drawLine(const Offset(3, 18), const Offset(3, 34), pistonPaint);

    // Heavy Ankle Armor & Foot Pad
    final footPath = Path()
      ..moveTo(-12, 32)
      ..lineTo(14, 32)
      ..lineTo(16, 36)
      ..lineTo(-14, 36)
      ..close();
    canvas.drawPath(footPath, Paint()..color = theme.armorBase);
    canvas.drawPath(
      footPath,
      Paint()
        ..color = theme.footTrim
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.6,
    );

    canvas.restore();
  }

  void _drawHeavyCannon(
    Canvas canvas, {
    required double posX,
    required double posY,
    required double recoil,
  }) {
    canvas.save();
    canvas.translate(posX - recoil, posY);

    // Armored Cannon Housing
    final cannonPath = Path()
      ..moveTo(0, 0)
      ..lineTo(28, 0)
      ..lineTo(26, 12)
      ..lineTo(0, 12)
      ..close();
    canvas.drawPath(cannonPath, Paint()..color = theme.armorBase);
    canvas.drawPath(
      cannonPath,
      Paint()
        ..color = theme.armorTrim
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8,
    );

    // Triple Gatling Barrel Tips
    final barrelPaint = Paint()
      ..color = const Color(0xFF78909C)
      ..strokeWidth = 2.4;
    canvas.drawLine(const Offset(28, 2), const Offset(36, 2), barrelPaint);
    canvas.drawLine(const Offset(28, 6), const Offset(38, 6), barrelPaint);
    canvas.drawLine(const Offset(28, 10), const Offset(36, 10), barrelPaint);

    // Neon Energy Cooling Fin
    canvas.drawLine(
      const Offset(6, -2),
      const Offset(22, -2),
      Paint()
        ..color = theme.neonCircuits
        ..strokeWidth = 2.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
    );

    canvas.restore();
  }

  void _renderPlasmaRound(Canvas canvas, TitanPlasmaRound round) {
    // 1. Double Helix Energy Trail
    if (round.trail.isNotEmpty) {
      for (int i = 0; i < round.trail.length; i++) {
        final tPos = round.trail[i];
        final progress = (i + 1) / round.trail.length;
        final tPaint = Paint()
          ..color = theme.plasmaCorona.withValues(alpha: progress * 0.7)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
        canvas.drawCircle(Offset(tPos.x, tPos.y), 3.0 + progress * 6.0, tPaint);

        // Core cyan bead
        final innerBead = Paint()
          ..color = theme.neonCircuits.withValues(alpha: progress * 0.6)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
        canvas.drawCircle(
          Offset(tPos.x, tPos.y),
          1.5 + progress * 2.5,
          innerBead,
        );
      }
    }

    canvas.save();
    canvas.translate(round.position.x, round.position.y);
    canvas.rotate(round.spinAngle);

    // 2. High-Tech Hexagonal Plasma Orb
    final corona = Paint()
      ..color = theme.plasmaCorona.withValues(alpha: 0.90)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
    canvas.drawCircle(Offset.zero, round.radius * 1.6, corona);

    final core = Paint()..color = theme.plasmaCore;
    canvas.drawCircle(Offset.zero, round.radius, core);

    // Orbiting Plasma Spark Pins
    final pinPaint = Paint()
      ..color = theme.neonCircuits
      ..strokeWidth = 2.0;
    for (int i = 0; i < 4; i++) {
      final a = i * (pi / 2);
      canvas.drawLine(
        Offset(cos(a) * 7.0, sin(a) * 7.0),
        Offset(cos(a) * 14.0, sin(a) * 14.0),
        pinPaint,
      );
    }

    // White Quantum Center
    canvas.drawCircle(
      Offset.zero,
      round.radius * 0.45,
      Paint()..color = Colors.white,
    );

    canvas.restore();
  }
}
