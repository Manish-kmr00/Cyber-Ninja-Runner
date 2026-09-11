import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../cyber_ninja_game.dart';
import 'procedural_generator.dart';

/// Flying aerocar in the cyberpunk skyline.
class Aerocar {
  double x;
  double y;
  double speed;
  Color lightColor;

  Aerocar({
    required this.x,
    required this.y,
    required this.speed,
    required this.lightColor,
  });
}

/// Dynamic speed streak particle.
class SpeedStreak {
  double x;
  double y;
  double length;
  double speed;
  double alpha;

  SpeedStreak({
    required this.x,
    required this.y,
    required this.length,
    required this.speed,
    required this.alpha,
  });
}

/// Multi-layered procedural Parallax Cyberpunk Megacity Skyline.
/// Adds immense visual depth, glowing skyscraper grids, sky bridges,
/// flying aerocars, and dynamic speed wind streaks.
class ParallaxBackground extends PositionComponent
    with HasGameReference<CyberNinjaRunnerGame> {
  final List<Aerocar> aerocars = [];
  final List<SpeedStreak> speedStreaks = [];
  double beaconTimer = 0.0;
  final Random _rng = Random(42);

  ParallaxBackground() : super(priority: -100);

  @override
  Future<void> onLoad() async {
    await super.onLoad();

    // Spawn initial flying aerocars across mid-sky lanes
    for (int i = 0; i < 7; i++) {
      aerocars.add(
        Aerocar(
          x: _rng.nextDouble() * 2000.0,
          y: 120.0 + _rng.nextDouble() * 240.0,
          speed: (i % 2 == 0 ? 1 : -1) * (90.0 + _rng.nextDouble() * 120.0),
          lightColor: i % 2 == 0
              ? AppConstants.stealthBlue
              : AppConstants.hazardRed,
        ),
      );
    }

    // Spawn wind speed streaks
    for (int i = 0; i < 18; i++) {
      speedStreaks.add(
        SpeedStreak(
          x: _rng.nextDouble() * AppConstants.virtualWidth,
          y: _rng.nextDouble() * (AppConstants.virtualHeight - 120),
          length: 40.0 + _rng.nextDouble() * 80.0,
          speed: 700.0 + _rng.nextDouble() * 500.0,
          alpha: 0.15 + _rng.nextDouble() * 0.35,
        ),
      );
    }
  }

  @override
  void update(double dt) {
    super.update(dt);
    beaconTimer += dt * 3.0;

    final camX = game.camera.viewfinder.position.x;

    // Update flying traffic
    for (final car in aerocars) {
      car.x += car.speed * dt;
      if (car.speed > 0 && car.x > camX + 1000) {
        car.x = camX - 800;
        car.y = 120.0 + _rng.nextDouble() * 240.0;
      } else if (car.speed < 0 && car.x < camX - 800) {
        car.x = camX + 1000;
        car.y = 120.0 + _rng.nextDouble() * 240.0;
      }
    }

    // Update speed streaks
    final isFast = game.player.isSliding || game.player.velocity.x > 400;
    final streakMultiplier = isFast ? 1.8 : 1.0;

    for (final s in speedStreaks) {
      s.x -= s.speed * streakMultiplier * dt;
      if (s.x < camX - 700) {
        s.x = camX + 700 + _rng.nextDouble() * 300;
        s.y = _rng.nextDouble() * (AppConstants.virtualHeight - 140);
      }
    }
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    final camX = game.camera.viewfinder.position.x;
    final viewWidth = AppConstants.virtualWidth;
    final viewHeight = AppConstants.virtualHeight;
    final leftX = camX - viewWidth / 2 - 200;
    final rightX = camX + viewWidth / 2 + 200;

    final distanceMeters = game.currentDistance;
    final biome = ProceduralGenerator.getBiomeForDistance(
      distanceMeters,
      mode: game.mode,
    );

    // 1. Deep Atmospheric Gradient Sky (Dynamically tinted per Sector Biome)
    final skyPaint = Paint()
      ..shader = LinearGradient(
        begin: Alignment.topCenter,
        end: Alignment.bottomCenter,
        colors: biome.skyGradient,
      ).createShader(Rect.fromLTWH(leftX, 0, viewWidth + 400, viewHeight));
    canvas.drawRect(
      Rect.fromLTWH(leftX, 0, viewWidth + 400, viewHeight),
      skyPaint,
    );

    // 2. Far Layer: Dynamic Biome Landmarks (Skyscrapers, Foundries, Tunnel Ribs, Orbital Skyway, Quantum Monoliths, Shinto Temples, Magma Furnaces)
    _renderFarArchitecture(canvas, camX, leftX, rightX, biome);

    // 3. Mid Layer: Sky Bridges & Billboards (Parallax 0.22x)
    _renderMidLayer(canvas, camX, leftX, rightX, biome);

    // 4. Flying Aerocars Traffic
    _renderAerocars(canvas, biome);

    // 5. High-Speed Wind Streaks (Foreground)
    _renderSpeedStreaks(canvas, biome);
  }

  void _renderFarArchitecture(
    Canvas canvas,
    double camX,
    double leftX,
    double rightX,
    SectorBiome biome,
  ) {
    const parallaxFactor = 0.08;
    final offsetX = camX * parallaxFactor;

    switch (biome) {
      case SectorBiome.neonMetropolis:
        _renderMetropolisSkyscrapers(canvas, offsetX, leftX, rightX);
        break;
      case SectorBiome.toxicFoundry:
        _renderIndustrialFoundry(canvas, offsetX, leftX, rightX);
        break;
      case SectorBiome.maglevTunnel:
        _renderSubterraneanTunnel(canvas, offsetX, leftX, rightX);
        break;
      case SectorBiome.orbitalSkyway:
        _renderOrbitalSkyway(canvas, offsetX, leftX, rightX);
        break;
      case SectorBiome.quantumNexus:
        _renderQuantumNexus(canvas, offsetX, leftX, rightX);
        break;
      case SectorBiome.cyberShinto:
        _renderCyberShintoSkyline(canvas, offsetX, leftX, rightX);
        break;
      case SectorBiome.neoNebula:
        _renderNeoNebulaSkyline(canvas, offsetX, leftX, rightX);
        break;
    }
  }

  void _renderMetropolisSkyscrapers(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    const buildingWidth = 120.0;
    final startIdx = ((leftX - offsetX) / buildingWidth).floor() - 1;
    final endIdx = ((rightX - offsetX) / buildingWidth).ceil() + 1;

    final buildingPaint = Paint()..color = const Color(0xFF0B0E15);
    final edgePaint = Paint()
      ..color = const Color(0xFF141924)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;

    final windowPaintCyan = Paint()..color = const Color(0x3300E5FF);
    final windowPaintAmber = Paint()..color = const Color(0x33FFD700);
    final windowPaintPink = Paint()..color = const Color(0x33FF007F);

    final beaconAlpha = (sin(beaconTimer) + 1.0) / 2.0;
    final beaconPaint = Paint()
      ..color = AppConstants.hazardRed.withValues(
        alpha: 0.2 + 0.8 * beaconAlpha,
      )
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);

    for (int i = startIdx; i <= endIdx; i++) {
      final h = 320.0 + ((i * 137) % 240);
      final bX = i * buildingWidth + offsetX;
      final bY = AppConstants.virtualHeight - AppConstants.groundHeight - h;

      final bRect = Rect.fromLTWH(bX, bY, buildingWidth - 6, h);
      canvas.drawRect(bRect, buildingPaint);
      canvas.drawRect(bRect, edgePaint);

      final spireX = bX + (buildingWidth - 6) / 2;
      canvas.drawLine(Offset(spireX, bY), Offset(spireX, bY - 26), edgePaint);
      canvas.drawCircle(Offset(spireX, bY - 26), 3.0, beaconPaint);

      const cols = 5;
      final rows = (h / 24.0).floor();
      for (int r = 1; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          final winHash = (i * 31 + r * 17 + c * 7) % 10;
          if (winHash < 4) {
            final winPaint = winHash == 0
                ? windowPaintPink
                : (winHash == 1 ? windowPaintAmber : windowPaintCyan);
            canvas.drawRect(
              Rect.fromLTWH(bX + 12 + c * 18, bY + r * 22, 9, 11),
              winPaint,
            );
          }
        }
      }
    }
  }

  void _renderIndustrialFoundry(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    const facilityWidth = 200.0;
    final startIdx = ((leftX - offsetX) / facilityWidth).floor() - 1;
    final endIdx = ((rightX - offsetX) / facilityWidth).ceil() + 1;

    final siloPaint = Paint()..color = const Color(0xFF0A0707);
    final pipePaint = Paint()
      ..color = const Color(0xFFFF5722).withValues(alpha: 0.45)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.8;
    final furnaceGlowPaint = Paint()
      ..color = const Color(0xFFFF1744).withValues(alpha: 0.40)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 14);

    final textStyle = const TextStyle(
      color: Color(0xFF00E676),
      fontSize: 12,
      fontWeight: FontWeight.w900,
      letterSpacing: 1.5,
      fontFamily: 'monospace',
    );
    final textPainter = TextPainter(textDirection: TextDirection.ltr);

    for (int i = startIdx; i <= endIdx; i++) {
      final h = 280.0 + ((i * 101) % 220);
      final fX = i * facilityWidth + offsetX;
      final fY = AppConstants.virtualHeight - AppConstants.groundHeight - h;

      // Heavy industrial plant silhouette
      final fRect = Rect.fromLTWH(fX, fY, facilityWidth - 14, h);
      canvas.drawRect(fRect, siloPaint);

      // Multiple Industrial Chimneys / Smokestacks
      final stackX1 = fX + 24;
      final stackX2 = fX + 70;
      canvas.drawRect(Rect.fromLTWH(stackX1, fY - 70, 20, 70), siloPaint);
      canvas.drawRect(Rect.fromLTWH(stackX2, fY - 45, 16, 45), siloPaint);

      // Billowing Red / Orange Smoke Clouds from Chimneys
      final smokeGlow = Paint()
        ..color = const Color(0xFFFF3D00).withValues(alpha: 0.22)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 22);
      canvas.drawCircle(Offset(stackX1 + 10, fY - 80), 24, smokeGlow);
      canvas.drawCircle(Offset(stackX1 + 16, fY - 100), 32, smokeGlow);
      canvas.drawCircle(Offset(stackX2 + 8, fY - 55), 20, smokeGlow);

      // Molten furnace slit windows & glowing thermal cores
      canvas.drawRect(
        Rect.fromLTWH(fX + 30, fY + h * 0.35, 50, 16),
        furnaceGlowPaint,
      );
      canvas.drawRect(
        Rect.fromLTWH(fX + 110, fY + h * 0.55, 40, 12),
        furnaceGlowPaint,
      );

      // Industrial High-Pressure Chemical Pipes
      canvas.drawLine(
        Offset(fX, fY + 60),
        Offset(fX + facilityWidth - 14, fY + 60),
        pipePaint,
      );
      canvas.drawLine(
        Offset(fX + 100, fY),
        Offset(fX + 100, fY + h),
        pipePaint,
      );

      // Sector & Toxic Signage on Building Facades (Exact Screenshot Graphic)
      if (i % 2 == 0) {
        textPainter.text = TextSpan(text: 'TOXIC\nFLOW ☠', style: textStyle);
        textPainter.layout();
        textPainter.paint(canvas, Offset(fX + 115, fY + 80));
      } else {
        textPainter.text = TextSpan(
          text: 'SECTOR\n02 CORE',
          style: textStyle.copyWith(
            color: const Color(0xFFFF9100).withValues(alpha: 0.6),
          ),
        );
        textPainter.layout();
        textPainter.paint(canvas, Offset(fX + 25, fY + 120));
      }
    }
  }

  void _renderSubterraneanTunnel(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    const archInterval = 140.0;
    final startIdx = ((leftX - offsetX) / archInterval).floor() - 1;
    final endIdx = ((rightX - offsetX) / archInterval).ceil() + 1;

    final tunnelPaint = Paint()..color = const Color(0xFF080410);
    final ribPaint = Paint()
      ..color = const Color(0xFFD500F9).withValues(alpha: 0.35)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 3.0;

    for (int i = startIdx; i <= endIdx; i++) {
      final aX = i * archInterval + offsetX;
      final topY = 60.0;
      final botY = AppConstants.virtualHeight - AppConstants.groundHeight;

      // Dark tunnel pillar
      canvas.drawRect(Rect.fromLTWH(aX, topY, 32, botY - topY), tunnelPaint);
      // Glowing purple tunnel rib ring
      canvas.drawLine(Offset(aX + 16, topY), Offset(aX + 16, botY), ribPaint);
      // High-voltage warning node
      canvas.drawCircle(
        Offset(aX + 16, topY + 40),
        4.0,
        Paint()..color = const Color(0xFF7C4DFF).withValues(alpha: 0.8),
      );
    }
  }

  void _renderOrbitalSkyway(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    // 1. High-altitude clouds below
    final cloudPaint = Paint()
      ..color = const Color(0xFF00E676).withValues(alpha: 0.08)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 20);
    canvas.drawCircle(Offset(leftX + 200, 320), 120, cloudPaint);
    canvas.drawCircle(Offset(rightX - 300, 360), 160, cloudPaint);

    // 2. Distant orbital elevator spires
    const spireInterval = 280.0;
    final startIdx = ((leftX - offsetX) / spireInterval).floor() - 1;
    final endIdx = ((rightX - offsetX) / spireInterval).ceil() + 1;

    final spirePaint = Paint()
      ..color = const Color(0xFF071C17)
      ..style = PaintingStyle.fill;
    final laserGrid = Paint()
      ..color = const Color(0xFF00E676).withValues(alpha: 0.4)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;

    for (int i = startIdx; i <= endIdx; i++) {
      final sX = i * spireInterval + offsetX;
      canvas.drawRect(
        Rect.fromLTWH(sX, 0, 18, AppConstants.virtualHeight - 120),
        spirePaint,
      );
      canvas.drawLine(
        Offset(sX + 9, 0),
        Offset(sX + 9, AppConstants.virtualHeight - 120),
        laserGrid,
      );
    }
  }

  void _renderQuantumNexus(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    // 1. Distant cosmic nebula glow
    final nebulaPaint = Paint()
      ..color = const Color(0xFFE040FB).withValues(alpha: 0.10)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 45);
    canvas.drawCircle(Offset(leftX + 400, 200), 220, nebulaPaint);

    // 2. Floating tilted quantum monoliths
    const monolithInterval = 220.0;
    final startIdx = ((leftX - offsetX) / monolithInterval).floor() - 1;
    final endIdx = ((rightX - offsetX) / monolithInterval).ceil() + 1;

    final monolithPaint = Paint()..color = const Color(0xFF0A031A);
    final auraEdge = Paint()
      ..color = const Color(0xFFFFD700).withValues(alpha: 0.5)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.8;

    for (int i = startIdx; i <= endIdx; i++) {
      final mX = i * monolithInterval + offsetX;
      final mY = 140.0 + ((i * 67) % 160);

      canvas.save();
      canvas.translate(mX, mY);
      canvas.rotate((i % 4 - 2) * 0.08);

      final r = Rect.fromLTWH(-30, -50, 60, 100);
      canvas.drawRect(r, monolithPaint);
      canvas.drawRect(r, auraEdge);

      canvas.restore();
    }
  }

  void _renderMidLayer(
    Canvas canvas,
    double camX,
    double leftX,
    double rightX,
    SectorBiome biome,
  ) {
    const parallaxFactor = 0.22;
    final offsetX = camX * parallaxFactor;

    const billboardInterval = 420.0;
    final startIdx = ((leftX - offsetX) / billboardInterval).floor() - 1;
    final endIdx = ((rightX - offsetX) / billboardInterval).ceil() + 1;

    for (int i = startIdx; i <= endIdx; i++) {
      final bbX = i * billboardInterval + offsetX;
      final bbY = 220.0 + ((i * 73) % 140);
      final isPrimary = i % 2 == 0;
      final neonColor = isPrimary ? biome.primaryAccent : biome.secondaryAccent;

      // Neon Billboard Frame
      final framePaint = Paint()
        ..color = neonColor.withValues(alpha: 0.35)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      final fillPaint = Paint()
        ..color = const Color(0xFF0E121A)
        ..style = PaintingStyle.fill;

      final bbRect = Rect.fromLTWH(bbX, bbY, 110.0, 52.0);
      canvas.drawRect(bbRect, fillPaint);
      canvas.drawRect(bbRect, framePaint);

      // Inner Glowing Kanji / Logo Line
      final logoPaint = Paint()
        ..color = neonColor.withValues(alpha: 0.75)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.5;
      canvas.drawLine(
        Offset(bbX + 20, bbY + 26),
        Offset(bbX + 90, bbY + 26),
        logoPaint,
      );
      canvas.drawLine(
        Offset(bbX + 35, bbY + 16),
        Offset(bbX + 75, bbY + 36),
        logoPaint,
      );

      // Connecting Sky Bridge Truss
      final bridgePaint = Paint()
        ..color = biome.wallColor
        ..style = PaintingStyle.stroke
        ..strokeWidth = 3.5;
      canvas.drawLine(
        Offset(bbX - 100, bbY + 50),
        Offset(bbX + 210, bbY + 50),
        bridgePaint,
      );
    }
  }

  void _renderAerocars(Canvas canvas, SectorBiome biome) {
    for (final car in aerocars) {
      final isHeadingRight = car.speed > 0;
      final headColor = car.speed.abs() > 150
          ? biome.primaryAccent
          : biome.secondaryAccent;
      final tailColor = const Color(0xFFFF1744);

      // Aerocar Body
      final bodyPaint = Paint()
        ..color = const Color(0xFF1B202D)
        ..style = PaintingStyle.fill;
      canvas.drawRRect(
        RRect.fromRectAndRadius(
          Rect.fromCenter(
            center: Offset(car.x, car.y),
            width: 28.0,
            height: 9.0,
          ),
          const Radius.circular(3.0),
        ),
        bodyPaint,
      );

      // Headlight Beam
      final headPaint = Paint()
        ..color = headColor
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
      final headX = isHeadingRight ? car.x + 14.0 : car.x - 14.0;
      canvas.drawCircle(Offset(headX, car.y), 2.5, headPaint);

      // Taillight Beam
      final tailPaint = Paint()
        ..color = tailColor
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      final tailX = isHeadingRight ? car.x - 14.0 : car.x + 14.0;
      canvas.drawCircle(Offset(tailX, car.y), 2.0, tailPaint);
    }
  }

  void _renderSpeedStreaks(Canvas canvas, SectorBiome biome) {
    final streakPaint = Paint()
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.8;

    for (final s in speedStreaks) {
      streakPaint.color = biome.primaryAccent.withValues(alpha: s.alpha);
      canvas.drawLine(
        Offset(s.x, s.y),
        Offset(s.x + s.length, s.y),
        streakPaint,
      );
    }
  }

  void _renderCyberShintoSkyline(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    const templeInterval = 280.0;
    final startIdx = ((leftX - offsetX) / templeInterval).floor() - 1;
    final endIdx = ((rightX - offsetX) / templeInterval).ceil() + 1;

    // 1. Giant Glitched Crimson Blood Moon in the background
    final moonCenter = Offset(offsetX * 0.3 + 450, 140);
    final moonPaint = Paint()
      ..color = const Color(0xFFFF003C).withValues(alpha: 0.25)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 28);
    canvas.drawCircle(moonCenter, 72, moonPaint);
    canvas.drawCircle(moonCenter, 60, Paint()..color = const Color(0xFF4A0413));
    // Moon glitch horizontal scanlines
    final scanPaint = Paint()
      ..color = const Color(0xFF0F0106)
      ..strokeWidth = 2.0;
    for (double sy = moonCenter.dy - 50; sy <= moonCenter.dy + 50; sy += 8) {
      canvas.drawLine(
        Offset(moonCenter.dx - 55, sy),
        Offset(moonCenter.dx + 55, sy),
        scanPaint,
      );
    }

    // 2. Towering Cyber-Shinto Torii Gates & Multi-Tier Pagodas
    final templePaint = Paint()..color = const Color(0xFF0A0206);
    final toriiGlowPaint = Paint()
      ..color = const Color(0xFFFF003C).withValues(alpha: 0.65)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.5;

    for (int i = startIdx; i <= endIdx; i++) {
      final tX = i * templeInterval + offsetX;
      final isPagoda = i % 2 == 0;

      if (isPagoda) {
        // Multi-tier Cyber Pagoda
        final pagodaH = 340.0;
        final pY =
            AppConstants.virtualHeight - AppConstants.groundHeight - pagodaH;
        // Base tower body
        canvas.drawRect(
          Rect.fromLTWH(tX + 40, pY + 80, 70, pagodaH - 80),
          templePaint,
        );
        // 3 Overhanging Pagoda Eaves
        for (int tier = 0; tier < 3; tier++) {
          final tierY = pY + 80 + tier * 75;
          final tierW = 120.0 - tier * 16.0;
          final eavePath = Path()
            ..moveTo(tX + 75 - tierW / 2, tierY)
            ..lineTo(tX + 75 + tierW / 2, tierY)
            ..lineTo(tX + 75 + tierW / 2 - 12, tierY - 16)
            ..lineTo(tX + 75 - tierW / 2 + 12, tierY - 16)
            ..close();
          canvas.drawPath(eavePath, templePaint);
          canvas.drawPath(eavePath, toriiGlowPaint);

          // Hanging glowing amber lanterns at eave tips
          canvas.drawCircle(
            Offset(tX + 75 - tierW / 2 + 4, tierY + 6),
            3.5,
            Paint()
              ..color = const Color(0xFFFFD700)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3),
          );
          canvas.drawCircle(
            Offset(tX + 75 + tierW / 2 - 4, tierY + 6),
            3.5,
            Paint()
              ..color = const Color(0xFFFFD700)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3),
          );
        }
        // Pagoda Spire / Sorin
        canvas.drawLine(
          Offset(tX + 75, pY + 64),
          Offset(tX + 75, pY),
          Paint()
            ..color = const Color(0xFFFFD700)
            ..strokeWidth = 2.0,
        );
      } else {
        // Colossal Neon Torii Gate in Background
        final toriiH = 260.0;
        final tY =
            AppConstants.virtualHeight - AppConstants.groundHeight - toriiH;
        // Two massive Pillars
        canvas.drawRect(
          Rect.fromLTWH(tX + 25, tY + 30, 20, toriiH - 30),
          templePaint,
        );
        canvas.drawRect(
          Rect.fromLTWH(tX + 115, tY + 30, 20, toriiH - 30),
          templePaint,
        );
        // Upper Kasagi Crossbar (Curved laser lintel)
        final lintelPath = Path()
          ..moveTo(tX + 10, tY + 20)
          ..quadraticBezierTo(tX + 80, tY + 12, tX + 150, tY + 20)
          ..lineTo(tX + 146, tY + 32)
          ..quadraticBezierTo(tX + 80, tY + 24, tX + 14, tY + 32)
          ..close();
        canvas.drawPath(lintelPath, templePaint);
        canvas.drawPath(lintelPath, toriiGlowPaint);
        // Middle Nuki Crossbar
        canvas.drawRect(Rect.fromLTWH(tX + 25, tY + 55, 110, 14), templePaint);
        canvas.drawLine(
          Offset(tX + 25, tY + 62),
          Offset(tX + 135, tY + 62),
          toriiGlowPaint,
        );
      }
    }
  }

  void _renderNeoNebulaSkyline(
    Canvas canvas,
    double offsetX,
    double leftX,
    double rightX,
  ) {
    // 1. Giant Quantum Core / Vector Sun on Horizon
    final sunCenter = Offset(offsetX * 0.15 + 480, 150);
    final sunGlowPaint = Paint()
      ..color = const Color(0xFF00F5FF).withValues(alpha: 0.18)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 40);
    canvas.drawCircle(sunCenter, 85, sunGlowPaint);

    // Sun Concentric Wireframe Rings
    final ringPaintCyan = Paint()
      ..color = const Color(0xFF00F5FF).withValues(alpha: 0.7)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    final ringPaintPink = Paint()
      ..color = const Color(0xFFFF007F).withValues(alpha: 0.7)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;

    canvas.drawCircle(sunCenter, 72, ringPaintCyan);
    canvas.drawCircle(sunCenter, 56, ringPaintPink);
    canvas.drawCircle(sunCenter, 38, ringPaintCyan);
    canvas.drawCircle(sunCenter, 20, ringPaintPink);

    // Quantum Sun Horizontal Slice Scanlines (Synthwave / TRON style)
    final slicePaint = Paint()
      ..color = const Color(0xFF000206)
      ..strokeWidth = 2.5;
    for (double sy = sunCenter.dy - 60; sy <= sunCenter.dy + 60; sy += 9) {
      canvas.drawLine(
        Offset(sunCenter.dx - 80, sy),
        Offset(sunCenter.dx + 80, sy),
        slicePaint,
      );
    }

    // 2. Cascading Digital Rain Streams (Hex / Binary matrix)
    final rainPaint = Paint()
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;
    for (int col = 0; col < 12; col++) {
      final rx =
          (leftX + col * 90 + (offsetX * 0.25)) % (rightX - leftX) + leftX;
      final seed = (col * 47) % 300;
      final ry =
          (seed + (beaconTimer * 80)) % (AppConstants.virtualHeight - 120);
      rainPaint.color = col % 2 == 0
          ? const Color(0xFF00F5FF).withValues(alpha: 0.45)
          : const Color(0xFFFF007F).withValues(alpha: 0.4);
      canvas.drawLine(Offset(rx, ry), Offset(rx, ry + 28), rainPaint);
      canvas.drawCircle(
        Offset(rx, ry + 28),
        1.8,
        Paint()..color = Colors.white,
      );
    }

    // 3. Floating 3D Polyhedral Quantum Data Nodes (Tesseracts / Octahedrons)
    const nodeInterval = 260.0;
    final nodeStart = ((leftX - offsetX * 0.4) / nodeInterval).floor() - 1;
    final nodeEnd = ((rightX - offsetX * 0.4) / nodeInterval).ceil() + 1;
    for (int n = nodeStart; n <= nodeEnd; n++) {
      final nX = n * nodeInterval + offsetX * 0.4;
      final bobY = 110.0 + sin(beaconTimer * 2.0 + n) * 16.0;
      final isCyan = n % 2 == 0;
      final nodeColor = isCyan
          ? const Color(0xFF00F5FF)
          : const Color(0xFFFF007F);

      // Draw Wireframe Diamond / Octahedron
      final octaPath = Path()
        ..moveTo(nX, bobY - 22)
        ..lineTo(nX + 16, bobY)
        ..lineTo(nX, bobY + 22)
        ..lineTo(nX - 16, bobY)
        ..close();
      canvas.drawPath(
        octaPath,
        Paint()
          ..color = nodeColor.withValues(alpha: 0.12)
          ..style = PaintingStyle.fill,
      );
      canvas.drawPath(
        octaPath,
        Paint()
          ..color = nodeColor
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.5,
      );
      // Internal Cross Axis
      canvas.drawLine(
        Offset(nX, bobY - 22),
        Offset(nX, bobY + 22),
        Paint()
          ..color = Colors.white
          ..strokeWidth = 1.0,
      );
      canvas.drawLine(
        Offset(nX - 16, bobY),
        Offset(nX + 16, bobY),
        Paint()
          ..color = nodeColor
          ..strokeWidth = 1.0,
      );

      // Node Halo
      canvas.drawCircle(
        Offset(nX, bobY),
        4.0,
        Paint()
          ..color = Colors.white
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
      );
    }

    // 4. Infinite 3D Isometric Wireframe Hyper-Towers
    const buildingWidth = 135.0;
    final startIdx = ((leftX - offsetX) / buildingWidth).floor() - 1;
    final endIdx = ((rightX - offsetX) / buildingWidth).ceil() + 1;

    final textPainter = TextPainter(textDirection: TextDirection.ltr);

    for (int i = startIdx; i <= endIdx; i++) {
      final bX = i * buildingWidth + offsetX;
      final h = 320.0 + ((i * 137) % 280);
      final bY = AppConstants.virtualHeight - AppConstants.groundHeight - h;
      final w = buildingWidth - 14;
      final isPinkScheme = i % 3 == 1;
      final wireColor = isPinkScheme
          ? const Color(0xFFFF007F)
          : const Color(0xFF00F5FF);
      final accentColor = isPinkScheme
          ? const Color(0xFFFFD700)
          : const Color(0xFF00F5FF);

      // Dark Translucent Vector Body
      final bRect = Rect.fromLTWH(bX, bY, w, h);
      canvas.drawRect(bRect, Paint()..color = const Color(0xEE030712));
      canvas.drawRect(
        bRect,
        Paint()
          ..color = wireColor.withValues(alpha: 0.85)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.8,
      );

      // Rooftop Spire with Pulsing Vector Beacon
      final spireX = bX + w / 2;
      canvas.drawLine(
        Offset(spireX, bY),
        Offset(spireX, bY - 42),
        Paint()
          ..color = wireColor
          ..strokeWidth = 1.8,
      );
      final beaconPulsar = (sin(beaconTimer * 4.0 + i) + 1.0) / 2.0;
      canvas.drawCircle(
        Offset(spireX, bY - 42),
        3.5 + beaconPulsar * 2.5,
        Paint()
          ..color = accentColor
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4),
      );

      // 3D Isometric Wireframe Grid Cells & Cross-Braces (TRON Style)
      final gridStroke = Paint()
        ..color = wireColor.withValues(alpha: 0.35)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.0;

      final cellHeight = 36.0;
      final rows = (h / cellHeight).floor();
      for (int r = 0; r < rows; r++) {
        final cy = bY + r * cellHeight;
        // Horizontal Grid Bar
        canvas.drawLine(Offset(bX, cy), Offset(bX + w, cy), gridStroke);

        // Diagonal X-Braces on alternate blocks
        if ((r + i) % 2 == 0) {
          canvas.drawLine(
            Offset(bX, cy),
            Offset(bX + w, cy + cellHeight),
            gridStroke,
          );
          canvas.drawLine(
            Offset(bX + w, cy),
            Offset(bX, cy + cellHeight),
            gridStroke,
          );
        }

        // Glowing Vertex Nodes at Edges
        canvas.drawCircle(Offset(bX, cy), 1.6, Paint()..color = Colors.white);
        canvas.drawCircle(
          Offset(bX + w, cy),
          1.6,
          Paint()..color = Colors.white,
        );
      }

      // Vertical Center Laser Data Bus
      canvas.drawLine(
        Offset(spireX, bY),
        Offset(spireX, bY + h),
        Paint()
          ..color = wireColor.withValues(alpha: 0.6)
          ..strokeWidth = 1.5,
      );

      // Floating Holographic Vector Billboards (Every 2nd Tower)
      if (i % 2 == 0) {
        final bbY = bY + 85.0;
        final bbRect = Rect.fromLTWH(bX + 8, bbY, w - 16, 48.0);

        canvas.drawRRect(
          RRect.fromRectAndRadius(bbRect, const Radius.circular(3.0)),
          Paint()..color = const Color(0xF0010308),
        );
        canvas.drawRRect(
          RRect.fromRectAndRadius(bbRect, const Radius.circular(3.0)),
          Paint()
            ..color = wireColor
            ..style = PaintingStyle.stroke
            ..strokeWidth = 1.6
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2.5),
        );

        // Vector Corner Reticles
        final reticlePaint = Paint()
          ..color = Colors.white
          ..strokeWidth = 1.8;
        canvas.drawLine(
          Offset(bbRect.left, bbRect.top),
          Offset(bbRect.left + 8, bbRect.top),
          reticlePaint,
        );
        canvas.drawLine(
          Offset(bbRect.left, bbRect.top),
          Offset(bbRect.left, bbRect.top + 8),
          reticlePaint,
        );
        canvas.drawLine(
          Offset(bbRect.right, bbRect.top),
          Offset(bbRect.right - 8, bbRect.top),
          reticlePaint,
        );
        canvas.drawLine(
          Offset(bbRect.right, bbRect.top),
          Offset(bbRect.right, bbRect.top + 8),
          reticlePaint,
        );

        // Holographic Glitch Text
        final label = i % 4 == 0 ? 'QUANTUM\n0xCORE' : 'TRON //\nOVERDRIVE';
        textPainter.text = TextSpan(
          text: label,
          style: TextStyle(
            color: wireColor,
            fontSize: 10.5,
            fontWeight: FontWeight.w900,
            letterSpacing: 2.0,
            fontFamily: 'monospace',
          ),
        );
        textPainter.layout();
        textPainter.paint(canvas, Offset(bX + 16, bbY + 8));
      }

      // Connecting High-Altitude Laser Transit Beams
      if (i % 3 == 0) {
        final beamY = bY + 160.0;
        canvas.drawLine(
          Offset(bX + w, beamY),
          Offset(bX + w + 35, beamY),
          Paint()
            ..color = const Color(0xFF00F5FF)
            ..strokeWidth = 2.2
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3),
        );
        canvas.drawLine(
          Offset(bX + w, beamY),
          Offset(bX + w + 35, beamY),
          Paint()
            ..color = Colors.white
            ..strokeWidth = 1.0,
        );
      }
    }
  }
}
