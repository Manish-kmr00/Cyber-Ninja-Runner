import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../sqube_game.dart';
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
    final biome = ProceduralGenerator.getBiomeForDistance(distanceMeters);

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

    // 2. Far Layer: Dynamic Biome Landmarks (Skyscrapers, Foundries, Tunnel Ribs, Orbital Skyway, Quantum Monoliths)
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
}
