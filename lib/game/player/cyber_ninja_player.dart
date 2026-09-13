import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import 'runner_player.dart';

/// 3D Volumetric Cyber Ninja (Shadow Shinobi) Player Component.
/// Scaled to imposing 92x112 proportions with broad armor,
/// long back-mounted plasma katana, flowing multi-segment cyber scarf with cloth physics,
/// high-speed phantom ghosting trails, ground shockwaves, and aerial blade slash arcs.
class CyberNinjaPlayer extends RunnerPlayer {
  // Animation & Kinematics timers
  double runCycle = 0.0;
  double scarfTimer = 0.0;
  double visorScanTimer = 0.0;
  double corePulseTimer = 0.0;
  double flipRotation = 0.0;

  // Slide spark particle offsets
  final List<Offset> slideSparks = [];
  final Random _rng = Random();

  CyberNinjaPlayer({
    required super.position,
    super.skin = PlayerSkin.classicWhite,
  }) : super(size: Vector2(AppConstants.ninjaWidth, AppConstants.ninjaHeight));

  @override
  Color getGhostNeonColor() {
    if (isInvisibilityActive) return const Color(0xFF9D4EDD);
    if (isSafeGroundActive) return const Color(0xFF00E5FF);
    try {
      if (game.boosterManager.isMatrixActive) return AppConstants.matrixGreen;
    } catch (_) {}
    return getNeonAccentColor();
  }

  @override
  void jump() {
    super.jump();
    if (!isGrounded) {
      flipRotation = 0.0;
    }
  }

  @override
  void onDoubleJump() {
    super.onDoubleJump();
    // Restart dynamic flip rotation for mid-air double jump!
    flipRotation = 0.0;
  }

  @override
  void update(double dt) {
    // If Matrix Slow-Mo is active, compensate dt so ninja maintains full 1.0x unhurried speed!
    double playerDt = dt;
    try {
      if (game.boosterManager.isMatrixActive &&
          game.boosterManager.timeDilationFactor > 0) {
        playerDt = dt / game.boosterManager.timeDilationFactor;
      }
    } catch (_) {}

    super.update(playerDt);
    if (isDead) return;

    // Running gait & wave physics
    final strideFreq = isSliding ? 7.0 : (isGrounded ? 13.0 : 5.0);
    runCycle += playerDt * strideFreq;
    scarfTimer += playerDt * (isGrounded ? 11.0 : 7.0);
    corePulseTimer += playerDt * 4.0;
    visorScanTimer += playerDt * 3.0;

    // Aerial ninja flip logic
    if (!isGrounded) {
      flipRotation += playerDt * 8.5;
      if (flipRotation > 2 * pi) flipRotation = 2 * pi;
    } else {
      flipRotation = 0.0;
    }

    // Generate slide friction sparks
    if (isSliding) {
      if (slideSparks.length > 12) slideSparks.removeAt(0);
      slideSparks.add(
        Offset(
          -12.0 - _rng.nextDouble() * 35.0,
          size.y - 2.0 - _rng.nextDouble() * 10.0,
        ),
      );
    } else {
      slideSparks.clear();
    }
  }

  Color getPrimaryArmorColor() {
    switch (skin) {
      case PlayerSkin.classicWhite:
        return const Color(0xFF161A23); // Obsidian Carbon
      case PlayerSkin.stealthBlack:
        return const Color(0xFF0D0F14); // Ultra-Matte Dark
      case PlayerSkin.cyberNeon:
        return const Color(0xFF1E1032); // Synthwave Violet
      case PlayerSkin.crimsonShadow:
        return const Color(0xFF2A0D12); // Deep Crimson Obsidian
      case PlayerSkin.goldenAura:
        return const Color(0xFF1A1810); // Titanium Gold
    }
  }

  Color getNeonAccentColor() {
    switch (skin) {
      case PlayerSkin.classicWhite:
        return AppConstants.stealthBlue; // Electric Cyan
      case PlayerSkin.stealthBlack:
        return const Color(0xFF00E5FF); // Stealth Teal
      case PlayerSkin.cyberNeon:
        return const Color(0xFFFF007F); // Neon Magenta
      case PlayerSkin.crimsonShadow:
        return AppConstants.hazardRed; // Crimson Plasma
      case PlayerSkin.goldenAura:
        return AppConstants.coinGold; // Brilliant Gold
    }
  }

  Color getSecondaryPlateColor() {
    switch (skin) {
      case PlayerSkin.classicWhite:
        return const Color(0xFF2B3345);
      case PlayerSkin.stealthBlack:
        return const Color(0xFF1C202B);
      case PlayerSkin.cyberNeon:
        return const Color(0xFF381D5C);
      case PlayerSkin.crimsonShadow:
        return const Color(0xFF4A1822);
      case PlayerSkin.goldenAura:
        return const Color(0xFF3A321A);
    }
  }

  @override
  void render(Canvas canvas) {
    // 1. Render World Particles (Shockwaves, Afterimages, Dust)
    renderWorldFX(canvas);

    super.render(canvas);

    final isStealth = isStealthActive;
    final isInv = isInvisibilityActive;
    final primaryArmor = isInv
        ? const Color(0xFF040608) // Ultra-Dark Shadow Stealth
        : (isStealth ? const Color(0xFF0A0C10) : getPrimaryArmorColor());
    final secondaryPlate = isInv
        ? const Color(0xFF0A0E16) // Deep Carbon Stealth
        : (isStealth ? const Color(0xFF121620) : getSecondaryPlateColor());
    final neonAccent = isInv
        ? const Color(0xFF9D4EDD).withValues(
            alpha: 0.40,
          ) // Phantom Stealth Purple
        : (isStealth
              ? getNeonAccentColor().withValues(alpha: 0.3)
              : getNeonAccentColor());

    canvas.save();

    if (isInv) {
      // 55% Opacity stealth phantom layer - turns ninja dark & semi-transparent
      canvas.saveLayer(null, Paint()..color = const Color(0x95FFFFFF));
    }

    // 2. Dynamic Squash & Stretch Transform
    final pivotX = size.x / 2;
    final pivotY = size.y;
    canvas.translate(pivotX, pivotY);
    canvas.scale(squashFactorX, squashFactorY);
    canvas.translate(-pivotX, -pivotY);

    // 3. 3D Perspective Ground Shadow
    final shadowAlpha = isGrounded
        ? 0.50
        : (0.15 +
              0.30 *
                  max(
                    0.0,
                    1.0 - (AppConstants.virtualHeight - position.y) / 250.0,
                  ));
    final shadowWidth = isSliding ? 82.0 : (isGrounded ? 62.0 : 44.0);
    final shadowPaint = Paint()
      ..color = Colors.black.withValues(alpha: shadowAlpha)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawOval(
      Rect.fromCenter(
        center: Offset(size.x / 2 + 2, size.y),
        width: shadowWidth,
        height: 14.0,
      ),
      shadowPaint,
    );

    // 4. Aerial Somersault / Lean Transform
    if (!isGrounded && flipRotation > 0.0) {
      canvas.translate(size.x / 2, size.y / 2);
      canvas.rotate(flipRotation);
      canvas.translate(-size.x / 2, -size.y / 2);

      // Katana Blade Slash Arc cutting through air during flip
      final slashPaint = Paint()
        ..color = neonAccent.withValues(alpha: 0.75)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 4.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
      canvas.drawArc(
        Rect.fromCircle(
          center: Offset(size.x / 2, size.y / 2),
          radius: size.y * 0.55,
        ),
        -pi / 4,
        pi * 1.2,
        false,
        slashPaint,
      );
    } else if (isGrounded && !isSliding) {
      // Aerodynamic forward ninja sprint lean (16 degrees)
      canvas.translate(size.x / 2, size.y);
      canvas.rotate(0.24);
      canvas.translate(-size.x / 2, -size.y);
    } else if (isSliding) {
      if (isSlashing) {
        // Sci-Fi Sonic Dash Strike Lunge:
        // Explosive low-crouch aerodynamic forward tilt (like Genji / Raiden / Sandevistan dash)
        final slashProg = (1.0 - (slashTimer / 0.65)).clamp(0.0, 1.0);
        final dynamicLunge = 0.42 - sin(slashProg * pi) * 0.16;
        canvas.translate(size.x / 2, size.y);
        canvas.rotate(dynamicLunge);
        canvas.translate(-size.x / 2, -size.y);
      } else {
        // Low slide backward tilt
        canvas.translate(size.x / 2, size.y);
        canvas.rotate(-0.16);
        canvas.translate(-size.x / 2, -size.y);
      }
    }

    // 5. Render Slide Sparks
    if (isSliding && slideSparks.isNotEmpty) {
      final sparkPaint = Paint()
        ..color = neonAccent.withValues(alpha: 0.90)
        ..strokeWidth = 2.8
        ..strokeCap = StrokeCap.round;
      for (final spk in slideSparks) {
        canvas.drawCircle(spk, 2.5, sparkPaint);
      }
    }

    // 6. Layer 1: Background Limbs with Left Plasma Katana (Z = -15)
    _renderBackgroundLimbs(
      canvas,
      primaryArmor,
      secondaryPlate,
      neonAccent,
      isStealth,
    );

    // 7. Layer 2: Peeth Par Mounted 3D Twin Crossed Cyber Scabbards
    _renderTwinBackScabbards(canvas, primaryArmor, neonAccent, isStealth);

    // 8. Layer 3: Flowing Cyber Scarf with Multi-Segment Cloth Physics
    _renderCyberScarf(canvas, neonAccent, isStealth);

    // 9. Layer 4: Shinobi Torso & Armor Chassis
    _renderTorso(canvas, primaryArmor, secondaryPlate, neonAccent);

    // 10. Layer 5: 3D Faceted Shinobi Mask & Cyber Visor
    _renderHeadAndVisor(canvas, primaryArmor, secondaryPlate, neonAccent);

    // 11. Layer 6: Foreground Limbs with Right Plasma Katana (Z = +15)
    _renderForegroundLimbs(
      canvas,
      primaryArmor,
      secondaryPlate,
      neonAccent,
      isStealth,
    );

    // 12. Layer 7: Dual Katana Blazing Cross-Slash Shockwaves
    if (isSlashing) {
      _renderCrossSlashShockwave(canvas, neonAccent);
    }

    if (isInv) {
      // Draw pulsing ethereal shadow cloak aura around the ninja
      final auraPulse = (sin(runCycle * 4.0) * 0.5 + 0.5);
      final auraPaint = Paint()
        ..color = const Color(
          0xFF9D4EDD,
        ).withValues(alpha: 0.35 + auraPulse * 0.25)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.5
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
      canvas.drawRRect(
        RRect.fromRectAndRadius(
          Rect.fromCenter(
            center: Offset(size.x / 2, size.y * 0.52),
            width: size.x * 0.88,
            height: size.y * 0.90,
          ),
          const Radius.circular(16),
        ),
        auraPaint,
      );
      canvas.restore(); // Restore stealth saveLayer
    }

    if (isSafeGroundActive) {
      final shieldPulse = (sin(runCycle * 6.0) * 0.5 + 0.5);
      final shieldCenter = Offset(size.x / 2, size.y * 0.52);
      final shieldRadius = size.y * 0.58;

      // Outer cyan kinetic glow
      final shieldGlowPaint = Paint()
        ..color = const Color(
          0xFF00E5FF,
        ).withValues(alpha: 0.30 + shieldPulse * 0.20)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 3.5
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
      canvas.drawCircle(shieldCenter, shieldRadius, shieldGlowPaint);

      // Inner crisp cyan energy barrier
      final shieldLinePaint = Paint()
        ..color = const Color(
          0xFFE0F7FA,
        ).withValues(alpha: 0.80 + shieldPulse * 0.20)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.8;
      canvas.drawCircle(shieldCenter, shieldRadius, shieldLinePaint);

      // Kinetic shield orbital ellipse ring
      final ringPaint = Paint()
        ..color = const Color(0xFF00E5FF).withValues(alpha: 0.45)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.4;
      canvas.drawOval(
        Rect.fromCenter(
          center: shieldCenter,
          width: shieldRadius * 2.1,
          height: shieldRadius * 0.85,
        ),
        ringPaint,
      );
    }

    canvas.restore();
  }

  /// 6. Background Limbs with Left Plasma Katana (Z = -15)
  void _renderBackgroundLimbs(
    Canvas canvas,
    Color primary,
    Color secondary,
    Color neon,
    bool isStealth,
  ) {
    final bgDarken = primary.withValues(alpha: 0.65);
    final bgPlate = secondary.withValues(alpha: 0.65);

    final legCycle = isSliding ? 0.0 : (isGrounded ? sin(runCycle + pi) : 0.4);
    final armCycle = isSliding ? 0.0 : (isGrounded ? sin(runCycle) : -0.3);

    // Background Leg (Thigh & Shin)
    final hipX = size.x * 0.44;
    final hipY = size.y * 0.58;

    final kneeX = hipX - 8 + legCycle * 20.0;
    final kneeY = hipY + 22 - (legCycle > 0 ? legCycle * 12 : 0);

    final footX = kneeX - 12 + legCycle * 26.0;
    final footY = size.y - 8;

    final bgLimbPaint = Paint()
      ..color = bgDarken
      ..style = PaintingStyle.stroke
      ..strokeWidth = 9.0
      ..strokeCap = StrokeCap.round;

    final limbPath = Path()
      ..moveTo(hipX, hipY)
      ..lineTo(kneeX, kneeY)
      ..lineTo(footX, footY);
    canvas.drawPath(limbPath, bgLimbPaint);

    // Background Cyber Shin Guard
    final shinPaint = Paint()
      ..color = bgPlate
      ..style = PaintingStyle.stroke
      ..strokeWidth = 6.0
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(Offset(kneeX, kneeY), Offset(footX, footY), shinPaint);

    // Background Arm (Left Hand Weapon Arm)
    final shoulderX = size.x * 0.48;
    final shoulderY = size.y * 0.38;

    double elbowX, elbowY, handX, handY, leftBladeAngle;
    bool isReverseGrip = !isSlashing;

    if (isSlashing) {
      final slashProg = (1.0 - (slashTimer / 0.65)).clamp(0.0, 1.0);
      if (slashProg < 0.32) {
        // Phase 1: Chambered low in tactical reverse grip, drawing raw cyber plasma charge
        final p = slashProg / 0.32;
        elbowX = shoulderX - 18.0 - p * 4.0;
        elbowY = shoulderY + 16.0 + p * 4.0;
        handX = elbowX - 14.0 - p * 6.0;
        handY = elbowY + 8.0 + p * 4.0;
        leftBladeAngle = 2.45 + p * 0.20;
        isReverseGrip = true;
      } else if (slashProg < 0.68) {
        // Phase 2: Explosive Rising Dragon Cross-Cut! (Upward lethal slash arc)
        final p = (slashProg - 0.32) / 0.36;
        final smoothP = sin(p * pi * 0.5);
        elbowX = shoulderX - 22.0 + smoothP * 38.0;
        elbowY = shoulderY + 20.0 - smoothP * 28.0;
        handX = elbowX + 10.0 + smoothP * 28.0;
        handY = elbowY - 6.0 - smoothP * 18.0;
        // Blade snaps violently upward from 2.65 rad to -1.15 rad!
        leftBladeAngle = 2.65 - smoothP * 3.8;
        isReverseGrip = false;
      } else {
        // Phase 3: Blade-Lock Follow-Through & Kinetic Deceleration Recovery
        final p = (slashProg - 0.68) / 0.32;
        elbowX = shoulderX + 16.0 - p * 24.0;
        elbowY = shoulderY - 8.0 + p * 18.0;
        handX = elbowX + 38.0 - p * 42.0;
        handY = elbowY - 24.0 + p * 20.0;
        leftBladeAngle = -1.15 + p * 3.1;
        isReverseGrip = p > 0.6;
      }
    } else {
      elbowX = shoulderX - 16.0 - armCycle * 14.0;
      elbowY = shoulderY + 14.0 + armCycle * 6.0;
      handX = elbowX - (14.0 + armCycle * 12.0);
      handY = elbowY - (3.0 - armCycle * 6.0);
      leftBladeAngle = isGrounded ? (2.1 + sin(runCycle) * 0.25) : 1.9;
    }

    final bgArmPaint = Paint()
      ..color = bgDarken
      ..style = PaintingStyle.stroke
      ..strokeWidth = 7.0
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(shoulderX, shoulderY),
      Offset(elbowX, elbowY),
      bgArmPaint,
    );
    canvas.drawLine(Offset(elbowX, elbowY), Offset(handX, handY), bgArmPaint);

    // Left Plasma Katana (Held in Left Hand - Dual Wield 1)
    _renderPlasmaKatana(
      canvas: canvas,
      handPos: Offset(handX, handY),
      angle: leftBladeAngle,
      bladeLength: 42.0,
      neon: neon,
      isStealth: isStealth,
      reverseGrip: isReverseGrip,
      isOvercharged: isSlashing,
    );
  }

  /// 7. Peeth Par Mounted 3D Twin Crossed Cyber Scabbards (Empty sheaths when katanas are drawn)
  void _renderTwinBackScabbards(
    Canvas canvas,
    Color primary,
    Color neon,
    bool isStealth,
  ) {
    // Scabbard 1: Top-Right to Bottom-Left
    final s1Start = Offset(size.x * 0.62, size.y * 0.22);
    final s1End = Offset(size.x * 0.22, size.y * 0.68);

    // Scabbard 2: Top-Left to Bottom-Right (Crossed X-Harness)
    final s2Start = Offset(size.x * 0.28, size.y * 0.22);
    final s2End = Offset(size.x * 0.58, size.y * 0.68);

    final scabbardPaint = Paint()
      ..color = const Color(0xFF0D1017)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 6.2
      ..strokeCap = StrokeCap.square;
    final edgePaint = Paint()
      ..color = neon.withValues(alpha: isStealth ? 0.2 : 0.75)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.8;

    // Draw Scabbard 1
    canvas.drawLine(s1Start, s1End, scabbardPaint);
    canvas.drawLine(
      Offset(s1Start.dx - 1.2, s1Start.dy + 1.2),
      Offset(s1End.dx - 1.2, s1End.dy + 1.2),
      edgePaint,
    );
    // Glowing Open Mouth Collar 1
    canvas.drawCircle(s1Start, 3.2, Paint()..color = neon);

    // Draw Scabbard 2
    canvas.drawLine(s2Start, s2End, scabbardPaint);
    canvas.drawLine(
      Offset(s2Start.dx + 1.2, s2Start.dy + 1.2),
      Offset(s2End.dx + 1.2, s2End.dy + 1.2),
      edgePaint,
    );
    // Glowing Open Mouth Collar 2
    canvas.drawCircle(s2Start, 3.2, Paint()..color = neon);
  }

  /// 8. Flowing Cyber Scarf with Multi-Segment Cloth Physics
  void _renderCyberScarf(Canvas canvas, Color neon, bool isStealth) {
    final neck = Offset(size.x * 0.46, size.y * 0.32);

    // 5 undulating nodes trailing into wind
    final p0 = neck;
    final p1 = Offset(p0.dx - 16, p0.dy - 3 + sin(scarfTimer) * 5);
    final p2 = Offset(p1.dx - 20, p1.dy + sin(scarfTimer + 1.2) * 8);
    final p3 = Offset(p2.dx - 22, p2.dy - 2 + sin(scarfTimer + 2.4) * 11);
    final p4 = Offset(p3.dx - 24, p3.dy + sin(scarfTimer + 3.6) * 14);

    // Ambient Scarf Neon Glow
    if (!isStealth) {
      final glowPaint = Paint()
        ..color = neon.withValues(alpha: 0.35)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 9.0
        ..strokeCap = StrokeCap.round;
      final glowPath = Path()
        ..moveTo(p0.dx, p0.dy)
        ..cubicTo(p1.dx, p1.dy, p2.dx, p2.dy, p3.dx, p3.dy)
        ..lineTo(p4.dx, p4.dy);
      canvas.drawPath(glowPath, glowPaint);
    }

    // Main Silk Scarf Body
    final scarfBodyPaint = Paint()
      ..color = neon.withValues(alpha: isStealth ? 0.25 : 0.90)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 7.0
      ..strokeCap = StrokeCap.round;

    final scarfPath = Path()
      ..moveTo(p0.dx, p0.dy)
      ..cubicTo(p1.dx, p1.dy, p2.dx, p2.dy, p3.dx, p3.dy)
      ..lineTo(p4.dx, p4.dy);
    canvas.drawPath(scarfPath, scarfBodyPaint);

    // White Core Laser Thread
    final coreThread = Paint()
      ..color = Colors.white.withValues(alpha: isStealth ? 0.3 : 0.85)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.8;
    canvas.drawPath(scarfPath, coreThread);
  }

  /// 9. Shinobi Torso & Armor Chassis
  void _renderTorso(Canvas canvas, Color primary, Color secondary, Color neon) {
    final torsoWidth = size.x * 0.38;
    final torsoHeight = size.y * 0.36;
    final torsoStartX = size.x * 0.32;

    final torsoRect = RRect.fromRectAndRadius(
      Rect.fromLTWH(torsoStartX, size.y * 0.30, torsoWidth, torsoHeight),
      const Radius.circular(7.0),
    );

    // 1. Base Carbon Fiber Chest Underlayer
    final basePaint = Paint()
      ..color = primary
      ..style = PaintingStyle.fill;
    canvas.drawRRect(torsoRect, basePaint);

    // 2. 3D Bevel Facet on Chest
    final chestPlates = Path()
      ..moveTo(torsoStartX, size.y * 0.30)
      ..lineTo(torsoStartX + torsoWidth, size.y * 0.30)
      ..lineTo(torsoStartX + torsoWidth * 0.75, size.y * 0.44)
      ..lineTo(torsoStartX, size.y * 0.42)
      ..close();
    final chestPaint = Paint()
      ..color = secondary
      ..style = PaintingStyle.fill;
    canvas.drawPath(chestPlates, chestPaint);

    // 3. Glowing Shinobi Clan Crest / Core
    final crestCenter = Offset(torsoStartX + torsoWidth * 0.50, size.y * 0.41);
    final pulseScale = 1.0 + 0.15 * sin(corePulseTimer);

    final crestPaint = Paint()
      ..color = neon
      ..style = PaintingStyle.fill;

    // Diamond Crest
    final crest = Path()
      ..moveTo(crestCenter.dx, crestCenter.dy - 6.0 * pulseScale)
      ..lineTo(crestCenter.dx + 4.8 * pulseScale, crestCenter.dy)
      ..lineTo(crestCenter.dx, crestCenter.dy + 6.0 * pulseScale)
      ..lineTo(crestCenter.dx - 4.8 * pulseScale, crestCenter.dy)
      ..close();
    canvas.drawPath(crest, crestPaint);

    // 4. Combat Utility Belt
    final beltPaint = Paint()
      ..color = const Color(0xFF0F1218)
      ..style = PaintingStyle.fill;
    canvas.drawRect(
      Rect.fromLTWH(torsoStartX - 1, size.y * 0.54, torsoWidth + 2, 5.5),
      beltPaint,
    );

    // Buckle
    final bucklePaint = Paint()
      ..color = neon
      ..style = PaintingStyle.fill;
    canvas.drawRect(
      Rect.fromLTWH(crestCenter.dx - 2.8, size.y * 0.53, 5.6, 7.5),
      bucklePaint,
    );
  }

  /// 10. 3D Faceted Shinobi Mask & Cyber Visor
  void _renderHeadAndVisor(
    Canvas canvas,
    Color primary,
    Color secondary,
    Color neon,
  ) {
    final headCenter = Offset(size.x * 0.50, size.y * 0.20);

    // 1. Angular Shinobi Cowl
    final cowlPath = Path()
      ..moveTo(headCenter.dx - 10, headCenter.dy - 13)
      ..lineTo(headCenter.dx + 10, headCenter.dy - 13)
      ..lineTo(headCenter.dx + 15, headCenter.dy)
      ..lineTo(headCenter.dx + 11, headCenter.dy + 13)
      ..lineTo(headCenter.dx - 4, headCenter.dy + 13)
      ..lineTo(headCenter.dx - 13, headCenter.dy + 2)
      ..close();

    final cowlPaint = Paint()
      ..color = primary
      ..style = PaintingStyle.fill;
    canvas.drawPath(cowlPath, cowlPaint);

    // 2. Metallic Shinobi Forehead Plate (Hitai-ate)
    final platePaint = Paint()
      ..color = secondary
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromLTWH(headCenter.dx - 4, headCenter.dy - 12, 16.0, 7.0),
        const Radius.circular(2.0),
      ),
      platePaint,
    );

    // 3. Glowing Cyber Ocular Visor Slit
    final visorRect = Rect.fromLTWH(
      headCenter.dx + 3,
      headCenter.dy - 2.0,
      13.0,
      4.5,
    );

    // Visor Backing
    final visorBack = Paint()
      ..color = const Color(0xFF07090E)
      ..style = PaintingStyle.fill;
    canvas.drawRect(visorRect, visorBack);

    // Visor Laser Glow
    final visorPaint = Paint()
      ..color = neon
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(visorRect, const Radius.circular(1.5)),
      visorPaint,
    );

    // Dynamic Ocular Scan Flare
    final scanX = headCenter.dx + 4.0 + (sin(visorScanTimer) + 1.0) * 4.5;
    final scanFlare = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(scanX, headCenter.dy), 1.4, scanFlare);
  }

  /// 11. Foreground Limbs with Right Plasma Katana (Z = +15, Specular Highlights & Weapon)
  void _renderForegroundLimbs(
    Canvas canvas,
    Color primary,
    Color secondary,
    Color neon,
    bool isStealth,
  ) {
    final legCycle = isSliding ? 0.0 : (isGrounded ? sin(runCycle) : -0.4);
    final armCycle = isSliding ? 0.0 : (isGrounded ? sin(runCycle + pi) : 0.3);

    // 1. Foreground Leg
    final hipX = size.x * 0.48;
    final hipY = size.y * 0.58;

    final kneeX = hipX - 3 + legCycle * 22.0;
    final kneeY = hipY + 22 - (legCycle > 0 ? legCycle * 14 : 0);

    final footX = kneeX + 3 + legCycle * 26.0;
    final footY = size.y - 7;

    final legPaint = Paint()
      ..color = primary
      ..style = PaintingStyle.stroke
      ..strokeWidth = 10.0
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(Offset(hipX, hipY), Offset(kneeX, kneeY), legPaint);
    canvas.drawLine(Offset(kneeX, kneeY), Offset(footX, footY), legPaint);

    // Metallic Knee Guard
    final kneeGuardPaint = Paint()
      ..color = secondary
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(kneeX, kneeY), 5.8, kneeGuardPaint);

    // Glowing Shin Neon Seam
    final shinSeam = Paint()
      ..color = neon
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.2;
    canvas.drawLine(
      Offset(kneeX, kneeY + 3),
      Offset(footX, footY - 3),
      shinSeam,
    );

    // Split-Toe Cyber Tabi Boot
    final bootPaint = Paint()
      ..color = const Color(0xFF0A0C11)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromLTWH(footX - 5, footY - 4, 16.0, 7.0),
        const Radius.circular(2.5),
      ),
      bootPaint,
    );

    // 2. Foreground Arm (Right Hand Weapon Arm)
    final shoulderX = size.x * 0.52;
    final shoulderY = size.y * 0.38;

    double elbowX, elbowY, handX, handY, rightBladeAngle;

    if (isSlashing) {
      final slashProg = (1.0 - (slashTimer / 0.65)).clamp(0.0, 1.0);
      if (slashProg < 0.40) {
        // Phase 1: High-Speed Sonic Descending Cross-Cut! (Downward lethal slash arc)
        final p = slashProg / 0.40;
        final smoothP = sin(p * pi * 0.5);
        elbowX = shoulderX + 8.0 + smoothP * 22.0;
        elbowY = shoulderY - 8.0 + smoothP * 18.0;
        handX = elbowX + 6.0 + smoothP * 26.0;
        handY = elbowY - 14.0 + smoothP * 28.0;
        // Blade starts drawn back high (-2.35 rad) and slices fiercely down to +0.95 rad!
        rightBladeAngle = -2.35 + smoothP * 3.3;
      } else if (slashProg < 0.72) {
        // Phase 2: Follow-Through Extension holding the Cross-Lock
        final p = (slashProg - 0.40) / 0.32;
        elbowX = shoulderX + 30.0 + sin(p * pi) * 4.0;
        elbowY = shoulderY + 10.0 + sin(p * pi) * 2.0;
        handX = elbowX + 32.0 + sin(p * pi) * 5.0;
        handY = elbowY + 14.0 - sin(p * pi) * 4.0;
        rightBladeAngle = 0.95 - p * 0.45;
      } else {
        // Phase 3: Energy Flick Snap & Smooth Recovery to Stride
        final p = (slashProg - 0.72) / 0.28;
        elbowX = shoulderX + 30.0 - p * 19.0;
        elbowY = shoulderY + 10.0 + p * 4.0;
        handX = elbowX + 32.0 - p * 18.0;
        handY = elbowY + 14.0 - p * 18.0;
        rightBladeAngle = 0.50 - p * 0.85;
      }
    } else {
      elbowX = shoulderX + 11.0 + armCycle * 16.0;
      elbowY = shoulderY + 14.0 - armCycle * 5.0;
      handX = elbowX + 14.0 + armCycle * 14.0;
      handY = elbowY - 4.0 - armCycle * 5.0;
      rightBladeAngle = isGrounded ? (-0.35 + sin(runCycle + pi) * 0.22) : -0.2;
    }

    final armPaint = Paint()
      ..color = primary
      ..style = PaintingStyle.stroke
      ..strokeWidth = 8.5
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(shoulderX, shoulderY),
      Offset(elbowX, elbowY),
      armPaint,
    );
    canvas.drawLine(Offset(elbowX, elbowY), Offset(handX, handY), armPaint);

    // Forearm Cyber Gauntlet
    final gauntletPaint = Paint()
      ..color = secondary
      ..style = PaintingStyle.stroke
      ..strokeWidth = 6.0
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(elbowX, elbowY),
      Offset(handX, handY),
      gauntletPaint,
    );

    // Knuckle Energy Clench
    final knucklePaint = Paint()
      ..color = neon
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(handX, handY), 3.5, knucklePaint);

    // Right Plasma Katana (Held in Right Hand - Dual Wield 2)
    _renderPlasmaKatana(
      canvas: canvas,
      handPos: Offset(handX, handY),
      angle: rightBladeAngle,
      bladeLength: 48.0,
      neon: neon,
      isStealth: isStealth,
      reverseGrip: false,
      isOvercharged: isSlashing,
    );
  }

  /// High-Frequency Plasma Katana Weapon Renderer
  void _renderPlasmaKatana({
    required Canvas canvas,
    required Offset handPos,
    required double angle,
    required double bladeLength,
    required Color neon,
    required bool isStealth,
    bool reverseGrip = false,
    bool isOvercharged = false,
  }) {
    canvas.save();
    canvas.translate(handPos.dx, handPos.dy);
    canvas.rotate(angle);

    final dir = reverseGrip ? -1.0 : 1.0;

    // 1. Tsuka (Katana Hilt Grip)
    const hiltLength = 13.0;
    final hiltPaint = Paint()
      ..color = const Color(0xFF131722)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 4.8
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(Offset.zero, Offset(-dir * hiltLength, 0), hiltPaint);

    // Diamond Ito Wrap on Tsuka Hilt
    final wrapPaint = Paint()
      ..color = neon.withValues(alpha: 0.7)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    for (double i = 2; i < hiltLength - 1; i += 3) {
      canvas.drawLine(
        Offset(-dir * i, -1.8),
        Offset(-dir * (i + 1.5), 1.8),
        wrapPaint,
      );
    }

    // Pommel (Kashira) Accent
    canvas.drawCircle(Offset(-dir * hiltLength, 0), 2.5, Paint()..color = neon);

    // 2. Tsuba (Sword Guard)
    final tsubaPaint = Paint()
      ..color = const Color(0xFF2C3549)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromCenter(center: Offset(dir * 1.0, 0), width: 3.5, height: 11.0),
        const Radius.circular(1.5),
      ),
      tsubaPaint,
    );
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromCenter(center: Offset(dir * 1.0, 0), width: 3.5, height: 11.0),
        const Radius.circular(1.5),
      ),
      Paint()
        ..color = neon
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.2,
    );

    // 3. High-Frequency Plasma Katana Blade
    final effLength = isOvercharged ? (bladeLength + 6.0) : bladeLength;
    final bladeStart = Offset(dir * 2.5, 0);
    final bladeEnd = Offset(dir * (effLength + 2.5), -2.2);

    final bladePath = Path()
      ..moveTo(bladeStart.dx, -1.8)
      ..quadraticBezierTo(
        dir * (effLength * 0.6),
        -3.5,
        bladeEnd.dx,
        bladeEnd.dy,
      )
      ..lineTo(bladeEnd.dx - dir * 3.0, bladeEnd.dy + 3.0)
      ..quadraticBezierTo(dir * (effLength * 0.4), 1.5, bladeStart.dx, 1.5)
      ..close();

    // A. Outer Plasma Glow Field
    if (!isStealth) {
      final glowPaint = Paint()
        ..color = neon.withValues(alpha: isOvercharged ? 0.85 : 0.55)
        ..maskFilter = MaskFilter.blur(
          BlurStyle.normal,
          isOvercharged ? 9.0 : 5.0,
        )
        ..style = PaintingStyle.fill;
      canvas.drawPath(bladePath, glowPaint);
    }

    // B. Main Energetic Blade Body
    final bladeBodyPaint = Paint()
      ..color = neon.withValues(
        alpha: isStealth ? 0.35 : (isOvercharged ? 1.0 : 0.95),
      )
      ..style = PaintingStyle.fill;
    canvas.drawPath(bladePath, bladeBodyPaint);

    // C. Razor-Sharp White Laser Cutting Core
    final coreLine = Path()
      ..moveTo(bladeStart.dx + dir * 1.0, -0.5)
      ..quadraticBezierTo(
        dir * (effLength * 0.6),
        -1.8,
        bladeEnd.dx - dir * 2.0,
        bladeEnd.dy,
      );
    final corePaint = Paint()
      ..color = Colors.white.withValues(
        alpha: isStealth ? 0.5 : (isOvercharged ? 1.0 : 0.95),
      )
      ..style = PaintingStyle.stroke
      ..strokeWidth = isOvercharged ? 2.4 : 1.8
      ..strokeCap = StrokeCap.round;
    canvas.drawPath(coreLine, corePaint);

    // D. Overcharged Lightning Sparks & Tip Gleam Flare
    if (isOvercharged) {
      // Lightning arc crackle along the cutting edge
      final sparkPath = Path()
        ..moveTo(bladeStart.dx + dir * 6.0, -0.5)
        ..lineTo(dir * (effLength * 0.3), -2.8)
        ..lineTo(dir * (effLength * 0.5), -1.2)
        ..lineTo(dir * (effLength * 0.75), -3.0)
        ..lineTo(bladeEnd.dx - dir * 1.5, bladeEnd.dy);
      canvas.drawPath(
        sparkPath,
        Paint()
          ..color = Colors.white
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.3,
      );

      // Blinding Tip Gleam Point
      canvas.drawCircle(
        bladeEnd,
        4.0,
        Paint()
          ..color = neon
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
      );
      canvas.drawCircle(bladeEnd, 2.0, Paint()..color = Colors.white);
    }

    canvas.restore();
  }

  /// 12. Ultra-Cinematic Sci-Fi Dual Katana Cross-Slash Visual FX
  void _renderCrossSlashShockwave(Canvas canvas, Color neon) {
    final slashProg = (1.0 - (slashTimer / 0.65)).clamp(0.0, 1.0);
    final slashAlpha = sin(slashProg * pi);
    if (slashAlpha <= 0.03) return;

    final focalX = size.x + 36.0;
    final focalY = size.y * 0.44;

    // A. High-Speed Cyber Kinetic Speedlines (Breaking Sound Barrier)
    final speedlinePaint = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.55).clamp(0.0, 1.0))
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    for (int i = 0; i < 6; i++) {
      final lineY =
          size.y * (0.22 + i * 0.11) + sin(slashTimer * 20.0 + i) * 3.0;
      final startX = size.x * 0.1 + (i % 3) * 15.0;
      final endX = focalX + 55.0 + (i * 12.0);
      canvas.drawLine(
        Offset(startX, lineY),
        Offset(endX, lineY),
        speedlinePaint,
      );
    }

    // B. Volumetric Curved Energy Sweep Meshes (Holographic Blade Fans)
    // 1. Descending Blade Fan (Right Katana Swing Trail)
    final arc1Fan = Path()
      ..moveTo(focalX - 45.0, focalY - 55.0)
      ..quadraticBezierTo(
        focalX + 38.0,
        focalY - 15.0,
        focalX - 35.0,
        focalY + 45.0,
      )
      ..lineTo(focalX - 52.0, focalY + 38.0)
      ..quadraticBezierTo(
        focalX + 18.0,
        focalY - 12.0,
        focalX - 60.0,
        focalY - 48.0,
      )
      ..close();

    // 2. Rising Blade Fan (Left Katana Swing Trail)
    final arc2Fan = Path()
      ..moveTo(focalX - 45.0, focalY + 55.0)
      ..quadraticBezierTo(
        focalX + 42.0,
        focalY + 12.0,
        focalX - 35.0,
        focalY - 45.0,
      )
      ..lineTo(focalX - 52.0, focalY - 38.0)
      ..quadraticBezierTo(
        focalX + 22.0,
        focalY + 10.0,
        focalX - 60.0,
        focalY + 48.0,
      )
      ..close();

    // Ambient Volumetric Glow for Fans
    final fanGlow = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.45).clamp(0.0, 1.0))
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 10.0)
      ..style = PaintingStyle.fill;
    canvas.drawPath(arc1Fan, fanGlow);
    canvas.drawPath(arc2Fan, fanGlow);

    // Energetic Plasma Core for Fans
    final fanCore = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.85).clamp(0.0, 1.0))
      ..style = PaintingStyle.fill;
    canvas.drawPath(arc1Fan, fanCore);
    canvas.drawPath(arc2Fan, fanCore);

    // C. Dimensional Spatial Fracture Laser Beams (Chromatic Aberration)
    // Beam 1: Downward Diagonal Rift (-36 deg)
    final b1Start = Offset(focalX - 65.0, focalY - 58.0);
    final b1End = Offset(focalX + 68.0, focalY + 58.0);
    // Beam 2: Upward Diagonal Rift (+36 deg)
    final b2Start = Offset(focalX - 65.0, focalY + 58.0);
    final b2End = Offset(focalX + 68.0, focalY - 58.0);

    // Chromatic Aberration: Cyan / Magenta edge fringe
    final cyanFringe = Paint()
      ..color = const Color(
        0xFF00E5FF,
      ).withValues(alpha: (slashAlpha * 0.70).clamp(0.0, 1.0))
      ..strokeWidth = 2.0
      ..style = PaintingStyle.stroke;
    final magentaFringe = Paint()
      ..color = const Color(
        0xFFFF0055,
      ).withValues(alpha: (slashAlpha * 0.70).clamp(0.0, 1.0))
      ..strokeWidth = 2.0
      ..style = PaintingStyle.stroke;

    // Offset chromatic beams
    canvas.drawLine(
      Offset(b1Start.dx - 1.8, b1Start.dy + 1.8),
      Offset(b1End.dx - 1.8, b1End.dy + 1.8),
      cyanFringe,
    );
    canvas.drawLine(
      Offset(b1Start.dx + 1.8, b1Start.dy - 1.8),
      Offset(b1End.dx + 1.8, b1End.dy - 1.8),
      magentaFringe,
    );
    canvas.drawLine(
      Offset(b2Start.dx - 1.8, b2Start.dy - 1.8),
      Offset(b2End.dx - 1.8, b2End.dy - 1.8),
      cyanFringe,
    );
    canvas.drawLine(
      Offset(b2Start.dx + 1.8, b2Start.dy + 1.8),
      Offset(b2End.dx + 1.8, b2End.dy + 1.8),
      magentaFringe,
    );

    // Main Neon Blazing Cutlines
    final mainCut = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.90).clamp(0.0, 1.0))
      ..strokeWidth = 4.5
      ..style = PaintingStyle.stroke
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3.5);
    canvas.drawLine(b1Start, b1End, mainCut);
    canvas.drawLine(b2Start, b2End, mainCut);

    // Blinding White Cutting Core
    final whiteCut = Paint()
      ..color = Colors.white.withValues(
        alpha: (slashAlpha * 0.98).clamp(0.0, 1.0),
      )
      ..strokeWidth = 2.0
      ..strokeCap = StrokeCap.round
      ..style = PaintingStyle.stroke;
    canvas.drawLine(b1Start, b1End, whiteCut);
    canvas.drawLine(b2Start, b2End, whiteCut);

    // D. Electric Plasma Crackles (Zig-Zag Lightning Bolts along cut lines)
    final boltPaint = Paint()
      ..color = Colors.white.withValues(
        alpha: (slashAlpha * 0.90).clamp(0.0, 1.0),
      )
      ..strokeWidth = 1.6
      ..style = PaintingStyle.stroke;
    final boltGlow = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.75).clamp(0.0, 1.0))
      ..strokeWidth = 4.2
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3)
      ..style = PaintingStyle.stroke;

    final bolt1 = Path()
      ..moveTo(b1Start.dx + 10, b1Start.dy + 8)
      ..lineTo(focalX - 15, focalY - 18 + sin(slashTimer * 40.0) * 8)
      ..lineTo(focalX + 5, focalY - 2)
      ..lineTo(focalX + 22, focalY + 16 + cos(slashTimer * 35.0) * 9)
      ..lineTo(b1End.dx - 8, b1End.dy - 6);

    final bolt2 = Path()
      ..moveTo(b2Start.dx + 12, b2Start.dy - 10)
      ..lineTo(focalX - 12, focalY + 16 + cos(slashTimer * 45.0) * 8)
      ..lineTo(focalX + 4, focalY + 2)
      ..lineTo(focalX + 24, focalY - 18 + sin(slashTimer * 38.0) * 9)
      ..lineTo(b2End.dx - 10, b2End.dy + 8);

    canvas.drawPath(bolt1, boltGlow);
    canvas.drawPath(bolt1, boltPaint);
    canvas.drawPath(bolt2, boltGlow);
    canvas.drawPath(bolt2, boltPaint);

    // E. Central Expanding Kinetic Shockwave Ring
    final shockRadius = 8.0 + slashProg * 42.0;
    final shockPaint = Paint()
      ..color = neon.withValues(
        alpha: ((1.0 - slashProg) * 0.70).clamp(0.0, 1.0),
      )
      ..strokeWidth = 2.4
      ..style = PaintingStyle.stroke
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
    canvas.drawCircle(Offset(focalX, focalY), shockRadius, shockPaint);

    // F. Sci-Fi Tactical Cross-Reticle [ < + > ]
    final reticleSize = 18.0 * slashAlpha;
    final reticlePaint = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.65).clamp(0.0, 1.0))
      ..strokeWidth = 1.5
      ..style = PaintingStyle.stroke;
    // Corner brackets
    canvas.drawLine(
      Offset(focalX - reticleSize, focalY - reticleSize * 0.5),
      Offset(focalX - reticleSize, focalY - reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX - reticleSize, focalY - reticleSize),
      Offset(focalX - reticleSize * 0.5, focalY - reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX + reticleSize, focalY - reticleSize * 0.5),
      Offset(focalX + reticleSize, focalY - reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX + reticleSize, focalY - reticleSize),
      Offset(focalX + reticleSize * 0.5, focalY - reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX - reticleSize, focalY + reticleSize * 0.5),
      Offset(focalX - reticleSize, focalY + reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX - reticleSize, focalY + reticleSize),
      Offset(focalX - reticleSize * 0.5, focalY + reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX + reticleSize, focalY + reticleSize * 0.5),
      Offset(focalX + reticleSize, focalY + reticleSize),
      reticlePaint,
    );
    canvas.drawLine(
      Offset(focalX + reticleSize, focalY + reticleSize),
      Offset(focalX + reticleSize * 0.5, focalY + reticleSize),
      reticlePaint,
    );

    // G. 4-Point Diamond Lens Flare Starburst
    final starburst = Path()
      ..moveTo(focalX, focalY - 38.0 * slashAlpha)
      ..quadraticBezierTo(
        focalX + 1.2,
        focalY,
        focalX + 54.0 * slashAlpha,
        focalY,
      )
      ..quadraticBezierTo(
        focalX,
        focalY + 1.2,
        focalX,
        focalY + 38.0 * slashAlpha,
      )
      ..quadraticBezierTo(
        focalX - 1.2,
        focalY,
        focalX - 54.0 * slashAlpha,
        focalY,
      )
      ..close();

    final flareGlow = Paint()
      ..color = neon.withValues(alpha: (slashAlpha * 0.70).clamp(0.0, 1.0))
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8)
      ..style = PaintingStyle.fill;
    canvas.drawPath(starburst, flareGlow);

    final flareWhite = Paint()
      ..color = Colors.white.withValues(
        alpha: (slashAlpha * 0.95).clamp(0.0, 1.0),
      )
      ..style = PaintingStyle.fill;
    canvas.drawPath(starburst, flareWhite);

    // Blinding focal center point
    canvas.drawCircle(
      Offset(focalX, focalY),
      4.2 * slashAlpha,
      Paint()..color = Colors.white,
    );
  }

  @override
  void onSlashAttack() {
    super.onSlashAttack();
    // Spawn forward slicing sparks & kinetic plasma embers
    for (int i = 0; i < 18; i++) {
      slideSparks.add(
        Offset(
          size.x * 0.75 + _rng.nextDouble() * 55.0,
          size.y * 0.44 + (_rng.nextDouble() - 0.5) * 45.0,
        ),
      );
    }
  }
}
