import 'dart:math';
import 'package:flame/components.dart';
import 'package:flame/particles.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../sqube_game.dart';
import 'attack_hitbox.dart';
import 'corner_hide_controller.dart';


/// A recorded ghost silhouette for high-speed phantom afterimage trails.
class GhostFrame {
  final Vector2 position;
  final double angle;
  final double scaleX;
  final double scaleY;
  final Color color;
  double lifeTime;
  final double maxLifeTime;

  GhostFrame({
    required this.position,
    required this.angle,
    required this.scaleX,
    required this.scaleY,
    required this.color,
    this.lifeTime = 0.22,
    this.maxLifeTime = 0.22,
  });
}

/// Expanding ground impact shockwave ring.
class ShockwaveRing {
  Vector2 position;
  double radius;
  double maxRadius;
  double alpha;
  Color color;

  ShockwaveRing({
    required this.position,
    this.radius = 4.0,
    this.maxRadius = 54.0,
    this.alpha = 0.85,
    required this.color,
  });
}

/// Running footstep dust puff.
class FootstepDust {
  Vector2 position;
  Vector2 vel;
  double radius;
  double alpha;
  Color color;

  FootstepDust({
    required this.position,
    required this.vel,
    required this.radius,
    this.alpha = 0.6,
    required this.color,
  });
}

/// Abstract base class for playable runner character (Cyber Ninja / Shadow Shinobi)
abstract class RunnerPlayer extends PositionComponent
    with HasGameReference<SqubeGame> {
  final PlayerSkin skin;
  final CornerHideController hideController = CornerHideController();

  Vector2 velocity = Vector2.zero();
  bool isGrounded = false;
  bool isSliding = false;
  bool isSlashing = false;
  bool isDead = false;
  bool canDoubleJump = false;

  double squashFactorX = 1.0;
  double squashFactorY = 1.0;
  double slideTimer = 0.0;
  double slashTimer = 0.0;
  int jumpCount = 0;

  void onSlashAttack() {}

  // Melee Attack State
  bool isAttacking = false;
  double attackCooldown = 0.0;

  /// Initiates a sword attack if not on cooldown.
  void startAttack() {
    if (isAttacking || attackCooldown > 0) return;
    // Begin attack
    isAttacking = true;
    attackCooldown = 0.5; // 0.5s cooldown after attack
    isSlashing = true;
    slashTimer = 0.35; // duration of attack animation/effect
    // Play attack sound / animation hook
    AudioService().playSfx('laser');
    // Spawn temporary hitbox
    game.add(AttackHitbox(position.clone(), size.clone()));
    onSlashAttack();
  }

  // Visual Effects & Particle Queues
  final List<GhostFrame> ghostTrails = [];
  final List<ShockwaveRing> shockwaves = [];
  final List<FootstepDust> dustPuffs = [];
  double ghostTimer = 0.0;
  double dustTimer = 0.0;
  double particleTrailTimer = 0.0;

  // Impact Callback for Screen Trauma / Camera Shake
  void Function(double intensity)? onHeavyImpact;

  RunnerPlayer({
    required super.position,
    required super.size,
    this.skin = PlayerSkin.classicWhite,
  }) : super(anchor: Anchor.bottomCenter, priority: 100);

  Color getGhostNeonColor();

  /// Dynamic base running speed scaling with distance traversed.
  /// Smoothly accelerates from 250 px/s at start to 330+ px/s over 1500m.
  double get currentBaseSpeed {
    final distanceMeters = (position.x / 10).clamp(0.0, 3000.0);
    final progress = (distanceMeters / 1500.0).clamp(0.0, 1.0);
    return AppConstants.playerBaseSpeed + (progress * 80.0);
  }

  void jump() {
    if (isDead) return;

    if (isGrounded) {
      velocity.y = AppConstants.jumpForce;
      isGrounded = false;
      canDoubleJump = true;
      jumpCount++;
      squashFactorX = 0.82;
      squashFactorY = 1.30;
      _spawnJumpPuff();
    } else if (canDoubleJump) {
      // High-octane mid-air double jump!
      velocity.y = AppConstants.doubleJumpForce;
      canDoubleJump = false;
      jumpCount++;
      squashFactorX = 0.78;
      squashFactorY = 1.38;
      onDoubleJump();
    }
  }

  void onDoubleJump() {
    // Spawn double-jump aerial shockwave
    shockwaves.add(
      ShockwaveRing(
        position: position.clone() - Vector2(0, 10),
        radius: 6.0,
        maxRadius: 48.0,
        color: getGhostNeonColor(),
      ),
    );
    onHeavyImpact?.call(0.4);
  }

  void startSlide() {
    if (isDead) return;
    isSliding = true;
    isSlashing = true;
    slideTimer = 0.65;
    slashTimer = 0.65;
    squashFactorX = 1.40;
    squashFactorY = 0.55;
    onHeavyImpact?.call(0.30);
    onSlashAttack();
  }

  void stopSlide() {
    isSliding = false;
    slideTimer = 0.0;
    isSlashing = false;
    slashTimer = 0.0;
  }

  void onLand(double groundY) {
    if (!isGrounded) {
      final impactSpeed = velocity.y;
      squashFactorX = 1.32;
      squashFactorY = 0.68;

      // Heavy ground shockwave ring
      shockwaves.add(
        ShockwaveRing(
          position: Vector2(position.x, groundY),
          radius: 8.0,
          maxRadius: impactSpeed > 500 ? 68.0 : 45.0,
          color: getGhostNeonColor(),
        ),
      );

      // Camera shake trauma
      if (impactSpeed > 400) {
        onHeavyImpact?.call(min(1.0, impactSpeed / 800.0));
      }
    }
    isGrounded = true;
    canDoubleJump = false;
    velocity.y = 0;
    position.y = groundY;
  }

  void _spawnJumpPuff() {
    for (int i = 0; i < 4; i++) {
      dustPuffs.add(
        FootstepDust(
          position: Vector2(position.x - 10 + (i * 6), position.y),
          vel: Vector2(
            -30.0 - Random().nextDouble() * 40.0,
            -10.0 - Random().nextDouble() * 20.0,
          ),
          radius: 4.0 + Random().nextDouble() * 3.0,
          color: Colors.white70,
        ),
      );
    }
  }

  @override
  void update(double dt) {
    if (isDead) return;

    final speedMultiplier = isSliding ? AppConstants.slideSpeedMultiplier : 1.0;
    velocity.x = currentBaseSpeed * speedMultiplier;
    velocity.y += AppConstants.gravity * dt;
    position += velocity * dt;

    if (isSliding) {
      slideTimer -= dt;
      if (slideTimer <= 0) {
        stopSlide();
      }
    }
    if (isSlashing) {
      slashTimer -= dt;
      if (slashTimer <= 0) {
        isSlashing = false;
        isAttacking = false; // Reset attack state when slash ends
      }
    }
    // Decay attack cooldown
    if (attackCooldown > 0) attackCooldown = (attackCooldown - dt).clamp(0.0, 2.0);


    squashFactorX += (1.0 - squashFactorX) * min(1.0, dt * 12.0);
    squashFactorY += (1.0 - squashFactorY) * min(1.0, dt * 12.0);

    hideController.update(dt, isDuckingOrHidden: isSliding);

    // 1. Glowing Cyan Streak Trail (Flame's ParticleSystemComponent)
    if (velocity.x > 0 && !isDead) {
      particleTrailTimer += dt;
      if (particleTrailTimer >= 0.032) {
        particleTrailTimer = 0.0;
        final cyanStreak = ParticleSystemComponent(
          particle: Particle.generate(
            count: 2,
            lifespan: 0.22,
            generator: (i) => AcceleratedParticle(
              acceleration: Vector2(
                -50.0,
                (Random().nextDouble() - 0.5) * 20.0,
              ),
              speed: Vector2(
                -80.0 - Random().nextDouble() * 30.0,
                (Random().nextDouble() - 0.5) * 15.0,
              ),
              position: Vector2(
                -size.x / 2 + (Random().nextDouble() * 4.0),
                -size.y * (0.35 + Random().nextDouble() * 0.3),
              ),
              child: CircleParticle(
                radius: 2.2 + Random().nextDouble() * 2.0,
                paint: Paint()
                  ..color = const Color(0xFF00E5FF).withValues(alpha: 0.85)
                  ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2.5),
              ),
            ),
          ),
          position: position.clone(),
        );
        parent?.add(cyanStreak);
      }
    }

    // 2. Phantom Ghosting Trail (High-Speed Afterimage Silhouette)
    ghostTimer += dt;
    if (ghostTimer >= 0.045 && (isSliding || !isGrounded || velocity.x > 350)) {
      ghostTimer = 0.0;
      if (ghostTrails.length > 5) ghostTrails.removeAt(0);
      ghostTrails.add(
        GhostFrame(
          position: position.clone(),
          angle: angle,
          scaleX: squashFactorX,
          scaleY: squashFactorY,
          color: getGhostNeonColor(),
        ),
      );
    }

    for (int i = ghostTrails.length - 1; i >= 0; i--) {
      ghostTrails[i].lifeTime -= dt;
      if (ghostTrails[i].lifeTime <= 0) {
        ghostTrails.removeAt(i);
      }
    }

    // 2. Shockwaves Update
    for (int i = shockwaves.length - 1; i >= 0; i--) {
      final s = shockwaves[i];
      s.radius += dt * 140.0;
      s.alpha = max(0.0, 1.0 - (s.radius / s.maxRadius));
      if (s.radius >= s.maxRadius) {
        shockwaves.removeAt(i);
      }
    }

    // 3. Footstep Dust Update
    dustTimer += dt;
    if (isGrounded && !isSliding && dustTimer >= 0.12) {
      dustTimer = 0.0;
      dustPuffs.add(
        FootstepDust(
          position: Vector2(position.x - size.x * 0.3, position.y),
          vel: Vector2(-60.0, -15.0 - Random().nextDouble() * 20.0),
          radius: 3.5 + Random().nextDouble() * 3.0,
          color: Colors.white38,
        ),
      );
    }

    for (int i = dustPuffs.length - 1; i >= 0; i--) {
      final d = dustPuffs[i];
      d.position += d.vel * dt;
      d.radius += dt * 6.0;
      d.alpha -= dt * 1.8;
      if (d.alpha <= 0) {
        dustPuffs.removeAt(i);
      }
    }

    super.update(dt);
  }

  /// Render global particles (Shockwaves, Ghost Trails, Dust Puffs) relative to world coordinates
  void renderWorldFX(Canvas canvas) {
    // 1. Shockwaves
    for (final s in shockwaves) {
      final relOffset = s.position - position;
      final shockPaint = Paint()
        ..color = s.color.withValues(alpha: s.alpha * 0.8)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 3.2
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
      canvas.drawOval(
        Rect.fromCenter(
          center: Offset(relOffset.x, relOffset.y),
          width: s.radius * 2.0,
          height: s.radius * 0.65, // 3D perspective ellipse
        ),
        shockPaint,
      );
    }

    // 2. Footstep Dust Puffs
    for (final d in dustPuffs) {
      final relOffset = d.position - position;
      final dustPaint = Paint()
        ..color = d.color.withValues(alpha: max(0.0, d.alpha))
        ..style = PaintingStyle.fill
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      canvas.drawCircle(Offset(relOffset.x, relOffset.y), d.radius, dustPaint);
    }

    // 3. Phantom Speed Streaks (Sleek aerodynamic trails, zero rectangular boxes)
    for (final g in ghostTrails) {
      final relOffset = g.position - position;
      final progress = g.lifeTime / g.maxLifeTime;
      final streakPaint = Paint()
        ..color = g.color.withValues(alpha: progress * 0.35)
        ..strokeWidth = 2.2
        ..strokeCap = StrokeCap.round
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);

      canvas.drawLine(
        Offset(relOffset.x - 8, relOffset.y - size.y * 0.35),
        Offset(relOffset.x - 36, relOffset.y - size.y * 0.35),
        streakPaint,
      );
      canvas.drawLine(
        Offset(relOffset.x - 4, relOffset.y - size.y * 0.65),
        Offset(relOffset.x - 28, relOffset.y - size.y * 0.65),
        streakPaint,
      );
    }
  }
}
