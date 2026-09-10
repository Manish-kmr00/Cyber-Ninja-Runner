import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../hazards/base_hazard.dart';
import '../sqube_game.dart';

/// 3D Volumetric Shadow Haven: An extruded stealth sanctuary with perspective canopy.
class ShadowHaven extends PositionComponent {
  double pulseTimer = 0.0;

  ShadowHaven({required super.position, required super.size})
    : super(anchor: Anchor.bottomLeft);

  @override
  void update(double dt) {
    super.update(dt);
    pulseTimer += dt * 3.0;
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    const depthY = 16.0;

    // 1. 3D Slanted Roof Canopy (Perspective Top Face)
    final roofPath = Path()
      ..moveTo(0, -size.y)
      ..lineTo(depthY, -size.y - depthY)
      ..lineTo(size.x + depthY, -size.y - depthY)
      ..lineTo(size.x, -size.y)
      ..close();

    final roofPaint = Paint()
      ..color = const Color(0xE610192A)
      ..style = PaintingStyle.fill;
    canvas.drawPath(roofPath, roofPaint);

    final roofEdgePaint = Paint()
      ..color = AppConstants.stealthBlue.withValues(alpha: 0.65)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawPath(roofPath, roofEdgePaint);

    // 2. 3D Front Holographic Stealth Shield Wall
    final wallRect = Rect.fromLTWH(0, -size.y, size.x, size.y);
    final wallPaint = Paint()
      ..color = const Color(0xCC09101C)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(wallRect, const Radius.circular(6.0)),
      wallPaint,
    );

    // Pulsing Neon Stealth Perimeter
    final pulseAlpha = 0.4 + 0.3 * (0.5 + 0.5 * (pulseTimer % 3.14));
    final edgePaint = Paint()
      ..color = AppConstants.stealthBlue.withValues(
        alpha: pulseAlpha.clamp(0.2, 0.9),
      )
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0;
    canvas.drawRRect(
      RRect.fromRectAndRadius(wallRect, const Radius.circular(6.0)),
      edgePaint,
    );

    // Top Glowing Neon Lintel
    final lintelPaint = Paint()
      ..color = AppConstants.stealthBlue
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromLTWH(0, -size.y, size.x, 4.5),
        const Radius.circular(2.0),
      ),
      lintelPaint,
    );
  }
}

/// 3D Collectible Cyber Point (CP): Floating rotating 3D octahedron crystal.
class CollectibleCP extends PositionComponent {
  double bobTimer = 0.0;
  bool isCollected = false;

  CollectibleCP({required super.position})
    : super(size: Vector2(24, 24), anchor: Anchor.center);

  @override
  void update(double dt) {
    super.update(dt);
    bobTimer += dt * 3.5;
  }

  @override
  void render(Canvas canvas) {
    if (isCollected) return;
    super.render(canvas);

    final center = Offset(size.x / 2, size.y / 2);

    // Outer Ambient Glow
    final glowPaint = Paint()
      ..color = AppConstants.coinGold.withValues(alpha: 0.35)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
    canvas.drawCircle(center, 14, glowPaint);

    canvas.save();
    canvas.translate(center.dx, center.dy);

    // 3D Isometric Crystal Projection (Rotating Octahedron with 3D faces)
    final rot = bobTimer;
    final w = 11.0;
    final h = 14.0;
    final depthOffset = sin(rot) * 5.0;

    // Face 1: Left Facet (Lit)
    final face1 = Path()
      ..moveTo(0, -h)
      ..lineTo(-w, 0)
      ..lineTo(depthOffset, 4)
      ..close();
    final face1Paint = Paint()
      ..color = const Color(0xFFFFE066)
      ..style = PaintingStyle.fill;
    canvas.drawPath(face1, face1Paint);

    // Face 2: Right Facet (Shaded)
    final face2 = Path()
      ..moveTo(0, -h)
      ..lineTo(w, 0)
      ..lineTo(depthOffset, 4)
      ..close();
    final face2Paint = Paint()
      ..color = const Color(0xFFFFB300)
      ..style = PaintingStyle.fill;
    canvas.drawPath(face2, face2Paint);

    // Face 3: Bottom Left Facet
    final face3 = Path()
      ..moveTo(-w, 0)
      ..lineTo(0, h)
      ..lineTo(depthOffset, 4)
      ..close();
    final face3Paint = Paint()
      ..color = const Color(0xFFFF8F00)
      ..style = PaintingStyle.fill;
    canvas.drawPath(face3, face3Paint);

    // Face 4: Bottom Right Facet
    final face4 = Path()
      ..moveTo(w, 0)
      ..lineTo(0, h)
      ..lineTo(depthOffset, 4)
      ..close();
    final face4Paint = Paint()
      ..color = const Color(0xFFFF6F00)
      ..style = PaintingStyle.fill;
    canvas.drawPath(face4, face4Paint);

    // Crystal Neon Edges
    final edgePaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.9)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;
    canvas.drawPath(face1, edgePaint);
    canvas.drawPath(face2, edgePaint);
    canvas.drawPath(face3, edgePaint);
    canvas.drawPath(face4, edgePaint);

    canvas.restore();
  }
}

/// 3D Elevated Catwalk Platform: Allows the player to jump onto upper levels,
/// bypass ground obstacles, and collect aerial CP caches.
class ElevatedPlatform extends PositionComponent {
  final SectorBiome biome;

  ElevatedPlatform({
    required super.position,
    required super.size,
    this.biome = SectorBiome.neonMetropolis,
  }) : super(anchor: Anchor.topLeft, priority: 12);

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    const depthY = 16.0;

    // 1. Steel Safety Railings along the back of the platform (Exact Industrial Look)
    final railPostPaint = Paint()
      ..color = const Color(0xFF384354)
      ..strokeWidth = 2.5;
    final railBarPaint = Paint()
      ..color = const Color(0xFFB0BEC5)
      ..strokeWidth = 1.8;
    // Top horizontal bar & middle bar
    canvas.drawLine(const Offset(0, -18), Offset(size.x, -18), railBarPaint);
    canvas.drawLine(const Offset(0, -8), Offset(size.x, -8), railBarPaint);
    // Vertical Posts
    for (double rx = 10; rx < size.x; rx += 45) {
      canvas.drawLine(Offset(rx, 0), Offset(rx, -18), railPostPaint);
    }

    // 2. 3D Top Walkway Deck (Walkable Runway Surface)
    final deckPath = Path()
      ..moveTo(0, 0)
      ..lineTo(size.x, 0)
      ..lineTo(size.x, depthY)
      ..lineTo(0, depthY)
      ..close();

    final deckPaint = Paint()
      ..color = const Color(0xFF131822)
      ..style = PaintingStyle.fill;
    canvas.drawPath(deckPath, deckPaint);

    // Tread-plate cross hatch pattern on platform surface
    final treadPaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.08)
      ..strokeWidth = 1.2;
    for (double tx = 12; tx < size.x; tx += 20) {
      canvas.drawLine(Offset(tx, 0), Offset(tx + 8, depthY), treadPaint);
    }

    // Glowing Platform Curb Edge
    final curbGlow = Paint()
      ..color = biome.primaryAccent.withValues(alpha: 0.8)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 4.0;
    final curbWhite = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;

    canvas.drawLine(const Offset(0, depthY), Offset(size.x, depthY), curbGlow);
    canvas.drawLine(const Offset(0, depthY), Offset(size.x, depthY), curbWhite);

    // 3. Heavy Industrial Girder Plate (Platform Underside)
    final underRect = Rect.fromLTWH(0, depthY, size.x, size.y - depthY);
    canvas.drawRect(underRect, Paint()..color = const Color(0xFF0A0D14));

    // Yellow-Black Caution Hazard Chevron along platform face (in Toxic Foundry)
    if (biome == SectorBiome.toxicFoundry) {
      final chevronPaint = Paint()
        ..color = const Color(0xFFFFB300).withValues(alpha: 0.85)
        ..strokeWidth = 4.0;
      for (double cx = 5; cx < size.x; cx += 18) {
        canvas.drawLine(
          Offset(cx + 8, depthY + 2),
          Offset(cx, size.y - 2),
          chevronPaint,
        );
      }
    }

    // 4. Heavy Hydraulic Support Columns Dropping into the Ground
    final pillarPaint = Paint()..color = const Color(0xFF07090E);
    final pillarEdge = Paint()
      ..color = const Color(0xFF222B38)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    final hydraulicRod = Paint()
      ..color = const Color(0xFF90A4AE)
      ..strokeWidth = 3.0;

    for (double px = 30; px < size.x; px += 140) {
      // Main pillar body
      final pRect = Rect.fromLTWH(px - 10, size.y, 20, 180);
      canvas.drawRect(pRect, pillarPaint);
      canvas.drawRect(pRect, pillarEdge);
      // Silver hydraulic actuator rod inside
      canvas.drawLine(
        Offset(px, size.y),
        Offset(px, size.y + 160),
        hydraulicRod,
      );

      // Angled Under-truss beam
      final trussPaint = Paint()
        ..color = const Color(0xFF1E2838)
        ..strokeWidth = 2.5;
      canvas.drawLine(
        Offset(px - 10, size.y),
        Offset(px - 28, size.y + 35),
        trussPaint,
      );
      canvas.drawLine(
        Offset(px + 10, size.y),
        Offset(px + 28, size.y + 35),
        trussPaint,
      );
    }
  }
}

/// 2.5D Extruded Running Track: Features an extruded 3D top roadway (depth plane),
/// vertical drop front wall, 3D chasm walls in pits, and industrial overhead girders.
class WorldChunk extends PositionComponent
    with HasGameReference<CyberNinjaRunnerGame> {
  final double startX;
  final double length;
  final double groundY;
  final double roofY;
  final bool hasPit;
  final double pitStartX;
  final double pitWidth;
  final SectorBiome biome;

  final List<BaseHazard> hazards = [];
  final List<ShadowHaven> shadowHavens = [];
  final List<CollectibleCP> collectibles = [];
  final List<ElevatedPlatform> elevatedPlatforms = [];

  WorldChunk({
    required this.startX,
    required this.length,
    required this.groundY,
    required this.roofY,
    this.hasPit = false,
    this.pitStartX = 0,
    this.pitWidth = 0,
    this.biome = SectorBiome.neonMetropolis,
  }) : super(
         position: Vector2(startX, 0),
         size: Vector2(length, AppConstants.virtualHeight),
         priority: 10,
       );

  @override
  Future<void> onLoad() async {
    await super.onLoad();
    for (final h in hazards) {
      add(h);
    }
    for (final s in shadowHavens) {
      add(s);
    }
    for (final c in collectibles) {
      add(c);
    }
    for (final p in elevatedPlatforms) {
      add(p);
    }
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    const trackDepth = AppConstants.trackDepth;
    final topRoadwayY = groundY - trackDepth;

    // 1. Distant 3D Cyber Grid Pillars (creates parallax depth)
    final gridPaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.035)
      ..strokeWidth = 1.0;
    for (double x = 0; x < length; x += 140) {
      canvas.drawLine(Offset(x, roofY + 16), Offset(x, topRoadwayY), gridPaint);
    }

    // 2. Render 2.5D Extruded 3D Running Track
    if (!hasPit) {
      _renderSolid3DTrack(canvas, 0, length, topRoadwayY, groundY, trackDepth);
    } else {
      // Segment 1: Left 3D Track before pit
      _renderSolid3DTrack(
        canvas,
        0,
        pitStartX,
        topRoadwayY,
        groundY,
        trackDepth,
      );

      // 3D Chasm Walls in the Pit
      _render3DChasm(
        canvas,
        pitStartX,
        pitStartX + pitWidth,
        topRoadwayY,
        groundY,
        trackDepth,
      );

      // Holographic Hard-Light Energy Bridge when Safe Ground Pack is Active!
      bool isSafeGround = false;
      try {
        isSafeGround = game.boosterManager.isSafeGroundActive;
      } catch (_) {}

      if (isSafeGround) {
        _renderHardLightBridge(
          canvas,
          pitStartX,
          pitStartX + pitWidth,
          topRoadwayY,
          groundY,
          trackDepth,
        );
      }

      // Segment 2: Right 3D Track after pit
      final afterPitX = pitStartX + pitWidth;
      _renderSolid3DTrack(
        canvas,
        afterPitX,
        length - afterPitX,
        topRoadwayY,
        groundY,
        trackDepth,
      );
    }

    // 3. 3D Overhead Industrial Roof Girder
    _render3DRoof(canvas, length, roofY);
  }

  /// Draws a continuous 3D track block: Slanted 3D top roadway + Front drop face
  void _renderSolid3DTrack(
    Canvas canvas,
    double startX,
    double trackLength,
    double topRoadwayY,
    double frontCurbY,
    double depth,
  ) {
    if (trackLength <= 0) return;

    // A. 3D Top Roadway (Walkable Depth Plane)
    final topRoadwayPath = Path()
      ..moveTo(startX, topRoadwayY)
      ..lineTo(startX + trackLength, topRoadwayY)
      ..lineTo(startX + trackLength, frontCurbY)
      ..lineTo(startX, frontCurbY)
      ..close();

    final roadwayPaint = Paint()
      ..color = biome.roadColor
      ..style = PaintingStyle.fill;
    canvas.drawPath(topRoadwayPath, roadwayPaint);

    // Biome-Specific Roadway Patterns & Decals
    _renderRoadwayDecals(canvas, startX, trackLength, topRoadwayY, frontCurbY);

    // Back Curb Line (Distant Z-Plane)
    final backCurbPaint = Paint()
      ..color = biome.primaryAccent.withValues(alpha: 0.35)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawLine(
      Offset(startX, topRoadwayY),
      Offset(startX + trackLength, topRoadwayY),
      backCurbPaint,
    );

    // Front Curb Line (Nearest Z-Plane: High-Contrast White + Glowing Biome Accent)
    final frontGlow = Paint()
      ..color = biome.primaryAccent.withValues(alpha: 0.55)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 7.0;
    final frontEdge = Paint()
      ..color = Colors.white.withValues(alpha: 0.95)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 3.0;

    canvas.drawLine(
      Offset(startX, frontCurbY),
      Offset(startX + trackLength, frontCurbY),
      frontGlow,
    );
    canvas.drawLine(
      Offset(startX, frontCurbY),
      Offset(startX + trackLength, frontCurbY),
      frontEdge,
    );

    // B. 3D Front Wall (Vertical Drop Face - Realistic Industrial Girder & Hazard Fascia)
    final frontWallRect = Rect.fromLTWH(
      startX,
      frontCurbY,
      trackLength,
      AppConstants.virtualHeight - frontCurbY,
    );
    final frontWallPaint = Paint()
      ..color = const Color(0xFF0C1017)
      ..style = PaintingStyle.fill;
    canvas.drawRect(frontWallRect, frontWallPaint);

    // Continuous Upper Fascia Beam (Steel Girder Plate)
    final girderFasciaH = 26.0;
    final girderRect = Rect.fromLTWH(
      startX,
      frontCurbY,
      trackLength,
      girderFasciaH,
    );
    canvas.drawRect(girderRect, Paint()..color = const Color(0xFF161C26));

    // Sector 2 (Toxic Foundry): Exact Yellow/Black Diagonal Hazard Chevrons & CAUTION Stencil
    if (biome == SectorBiome.toxicFoundry) {
      // Hazard Strip Along Fascia
      final chevronPaint = Paint()
        ..color = const Color(0xFFFFB300).withValues(alpha: 0.85)
        ..strokeWidth = 7.0;
      for (double x = startX - 10; x < startX + trackLength + 20; x += 22) {
        canvas.drawLine(
          Offset(x + 12, frontCurbY + 2),
          Offset(x, frontCurbY + girderFasciaH - 2),
          chevronPaint,
        );
      }

      // Stenciled CAUTION Text & Skull Icon on Steel Plates
      final textStyle = const TextStyle(
        color: Color(0xFFFFB300),
        fontSize: 10,
        fontWeight: FontWeight.w900,
        letterSpacing: 2.0,
        fontFamily: 'monospace',
      );
      final textPainter = TextPainter(textDirection: TextDirection.ltr);
      for (double x = startX + 100; x < startX + trackLength; x += 320) {
        textPainter.text = TextSpan(text: 'CAUTION ☠', style: textStyle);
        textPainter.layout();
        textPainter.paint(canvas, Offset(x, frontCurbY + 6));
      }
    }

    // Steel Rivets / Bolts along girder plate
    final rivetPaint = Paint()..color = const Color(0xFF384358);
    final rivetLight = Paint()..color = Colors.white.withValues(alpha: 0.5);
    for (double x = startX + 12; x < startX + trackLength; x += 36) {
      canvas.drawCircle(
        Offset(x, frontCurbY + girderFasciaH + 8),
        2.2,
        rivetPaint,
      );
      canvas.drawCircle(
        Offset(x - 0.5, frontCurbY + girderFasciaH + 7.5),
        1.0,
        rivetLight,
      );
    }

    // Biome-Specific Front Wall Architecture (Completely unique visual structure in every 1000m sector)
    switch (biome) {
      case SectorBiome.neonMetropolis:
        // Sector 1: Sleek Cyber Skyscraper Foundation with Vertical Cyan Glass Fins & Blue Neon Underglow
        final finPaint = Paint()
          ..color = const Color(0xFF00E5FF).withValues(alpha: 0.35)
          ..strokeWidth = 2.0;
        final glassPaint = Paint()
          ..color = const Color(0xFF0D1826)
          ..style = PaintingStyle.fill;
        for (double x = startX + 40; x < startX + trackLength; x += 110) {
          final fRect = Rect.fromLTWH(
            x,
            frontCurbY + girderFasciaH + 4,
            45,
            AppConstants.virtualHeight - frontCurbY,
          );
          canvas.drawRect(fRect, glassPaint);
          canvas.drawLine(
            Offset(x, frontCurbY + girderFasciaH),
            Offset(x, AppConstants.virtualHeight),
            finPaint,
          );
          canvas.drawLine(
            Offset(x + 45, frontCurbY + girderFasciaH),
            Offset(x + 45, AppConstants.virtualHeight),
            finPaint,
          );
        }
        break;

      case SectorBiome.toxicFoundry:
        // Sector 2: Industrial Foundry (Already painted yellow/black hazard chevrons above)
        // Add Heavy Vertical Support Columns & X-Truss Cross Braces
        final colPaint = Paint()..color = const Color(0xFF070A0F);
        final colEdge = Paint()
          ..color = const Color(0xFF222B3A)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.8;
        for (double x = startX + 120; x < startX + trackLength; x += 220) {
          final colRect = Rect.fromLTWH(
            x,
            frontCurbY + girderFasciaH,
            38,
            AppConstants.virtualHeight - (frontCurbY + girderFasciaH),
          );
          canvas.drawRect(colRect, colPaint);
          canvas.drawRect(colRect, colEdge);

          // Industrial X-Truss cross braces
          final trussPaint = Paint()
            ..color = const Color(0xFF1A212E)
            ..strokeWidth = 2.0;
          canvas.drawLine(
            Offset(x, frontCurbY + girderFasciaH + 10),
            Offset(x + 38, frontCurbY + girderFasciaH + 60),
            trussPaint,
          );
          canvas.drawLine(
            Offset(x + 38, frontCurbY + girderFasciaH + 10),
            Offset(x, frontCurbY + girderFasciaH + 60),
            trussPaint,
          );
        }
        break;

      case SectorBiome.maglevTunnel:
        // Sector 3: Subterranean High-Voltage Hyperloop Arches with Purple Coil Ribs
        final archPaint = Paint()
          ..color = const Color(0xFFD500F9).withValues(alpha: 0.40)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 3.0;
        final corePaint = Paint()
          ..color = const Color(0xFF7C4DFF).withValues(alpha: 0.6)
          ..style = PaintingStyle.fill;
        for (double x = startX + 50; x < startX + trackLength; x += 130) {
          canvas.drawArc(
            Rect.fromLTWH(x, frontCurbY + girderFasciaH + 5, 60, 70),
            pi,
            pi,
            false,
            archPaint,
          );
          canvas.drawCircle(
            Offset(x + 30, frontCurbY + girderFasciaH + 30),
            6.0,
            corePaint,
          );
        }
        break;

      case SectorBiome.orbitalSkyway:
        // Sector 4: Stratospheric Glassway with Floating Hexagonal Pillars & Green Circuit Energy Lines
        final hexPaint = Paint()
          ..color = const Color(0xFF00E676).withValues(alpha: 0.30)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 2.0;
        for (double x = startX + 60; x < startX + trackLength; x += 150) {
          final hexY = frontCurbY + girderFasciaH + 25;
          final path = Path()
            ..moveTo(x, hexY - 14)
            ..lineTo(x + 14, hexY - 7)
            ..lineTo(x + 14, hexY + 7)
            ..lineTo(x, hexY + 14)
            ..lineTo(x - 14, hexY + 7)
            ..lineTo(x - 14, hexY - 7)
            ..close();
          canvas.drawPath(path, hexPaint);
          canvas.drawLine(
            Offset(x, hexY + 14),
            Offset(x, AppConstants.virtualHeight),
            hexPaint,
          );
        }
        break;

      case SectorBiome.quantumNexus:
        // Sector 5: Cosmic Obsidian Monolith Pillars with Golden Quantum Glyphs
        final monoPaint = Paint()..color = const Color(0xFF0A0518);
        final goldEdge = Paint()
          ..color = const Color(0xFFFFD700).withValues(alpha: 0.6)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 2.0;
        for (double x = startX + 70; x < startX + trackLength; x += 180) {
          final mRect = Rect.fromLTWH(
            x,
            frontCurbY + girderFasciaH + 5,
            50,
            AppConstants.virtualHeight,
          );
          canvas.drawRect(mRect, monoPaint);
          canvas.drawRect(mRect, goldEdge);
        }
        break;
    }
  }

  void _renderRoadwayDecals(
    Canvas canvas,
    double startX,
    double trackLength,
    double topRoadwayY,
    double frontCurbY,
  ) {
    final trackH = frontCurbY - topRoadwayY;
    switch (biome) {
      case SectorBiome.neonMetropolis:
        // Sector 1 (0-1000m): Sleek High-Tech Cyber Highway
        // Dual speed runway lane dashes with glowing cyan edge ticks
        final lanePaint = Paint()
          ..color = biome.primaryAccent.withValues(alpha: 0.35)
          ..strokeWidth = 2.0;
        final midY = topRoadwayY + trackH * 0.5;
        for (double x = startX + 15; x < startX + trackLength; x += 60) {
          canvas.drawLine(Offset(x, midY), Offset(x + 28, midY), lanePaint);
        }
        // Slanted perspective speed stripes
        final stripePaint = Paint()
          ..color = Colors.white.withValues(alpha: 0.12)
          ..strokeWidth = 1.8;
        for (double x = startX + 40; x < startX + trackLength; x += 120) {
          canvas.drawLine(
            Offset(x + 16, topRoadwayY),
            Offset(x, frontCurbY),
            stripePaint,
          );
        }
        break;

      case SectorBiome.toxicFoundry:
        // Sector 2 (1000-2000m): Heavy Industrial Smelter & Hazard Zone
        // Industrial diamond plate metal grating and bold amber caution hazard stripes
        final gratePaint = Paint()
          ..color = const Color(0xFF332014).withValues(alpha: 0.7)
          ..strokeWidth = 1.2;
        for (double x = startX + 10; x < startX + trackLength; x += 24) {
          canvas.drawLine(
            Offset(x, topRoadwayY),
            Offset(x, frontCurbY),
            gratePaint,
          );
        }
        // Heavy Caution Chevrons (Yellow/Orange // // //)
        final hazardPaint = Paint()
          ..color = const Color(0xFFFF9100).withValues(alpha: 0.40)
          ..strokeWidth = 4.5;
        for (double x = startX + 30; x < startX + trackLength; x += 55) {
          canvas.drawLine(
            Offset(x + 22, topRoadwayY),
            Offset(x, frontCurbY),
            hazardPaint,
          );
        }
        // Molten lava conduits running along the road depth
        final lavaLinePaint = Paint()
          ..color = const Color(0xFFFF3D00).withValues(alpha: 0.55)
          ..strokeWidth = 2.0;
        canvas.drawLine(
          Offset(startX, topRoadwayY + trackH * 0.75),
          Offset(startX + trackLength, topRoadwayY + trackH * 0.75),
          lavaLinePaint,
        );
        break;

      case SectorBiome.maglevTunnel:
        // Sector 3 (2000-3000m): Subterranean High-Voltage Hyperloop
        // Magnetic induction plates + Dual high-voltage violet maglev rails
        final platePaint = Paint()
          ..color = const Color(0xFF2C194D).withValues(alpha: 0.45)
          ..style = PaintingStyle.fill;
        for (double x = startX + 20; x < startX + trackLength; x += 90) {
          canvas.drawRRect(
            RRect.fromRectAndRadius(
              Rect.fromLTWH(x, topRoadwayY + 3, 40, trackH - 6),
              const Radius.circular(3),
            ),
            platePaint,
          );
        }
        // Dual Glowing Center Maglev Rails
        final midY3 = (topRoadwayY + frontCurbY) / 2;
        final railPaint1 = Paint()
          ..color = const Color(0xFFD500F9).withValues(alpha: 0.75)
          ..strokeWidth = 2.5;
        final railPaint2 = Paint()
          ..color = const Color(0xFF7C4DFF).withValues(alpha: 0.75)
          ..strokeWidth = 2.5;
        canvas.drawLine(
          Offset(startX, midY3 - 4),
          Offset(startX + trackLength, midY3 - 4),
          railPaint1,
        );
        canvas.drawLine(
          Offset(startX, midY3 + 4),
          Offset(startX + trackLength, midY3 + 4),
          railPaint2,
        );
        // Maglev cross couplers
        final couplerPaint = Paint()
          ..color = Colors.white.withValues(alpha: 0.4)
          ..strokeWidth = 2.0;
        for (double x = startX + 25; x < startX + trackLength; x += 45) {
          canvas.drawLine(
            Offset(x, midY3 - 6),
            Offset(x, midY3 + 6),
            couplerPaint,
          );
        }
        break;

      case SectorBiome.orbitalSkyway:
        // Sector 4 (3000-4000m): Stratospheric Glassway & Hexagonal Matrix
        // Translucent cyber glass panels with glowing emerald circuit traces
        final panelBorderPaint = Paint()
          ..color = const Color(0xFF00E676).withValues(alpha: 0.35)
          ..strokeWidth = 1.5;
        for (double x = startX + 20; x < startX + trackLength; x += 80) {
          canvas.drawLine(
            Offset(x, topRoadwayY),
            Offset(x, frontCurbY),
            panelBorderPaint,
          );
        }
        // Hexagonal digital nodes
        final nodePaint = Paint()
          ..color = const Color(0xFF00B0FF).withValues(alpha: 0.5)
          ..style = PaintingStyle.fill;
        final nodeGlow = Paint()
          ..color = const Color(0xFF00E676).withValues(alpha: 0.6)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.2;
        final midY4 = topRoadwayY + trackH * 0.5;
        for (double x = startX + 60; x < startX + trackLength; x += 80) {
          canvas.drawCircle(Offset(x, midY4), 3.5, nodePaint);
          canvas.drawCircle(Offset(x, midY4), 5.5, nodeGlow);
        }
        // Continuous green fiber-optic telemetry stream
        final fiberPaint = Paint()
          ..color = const Color(0xFF00E676).withValues(alpha: 0.6)
          ..strokeWidth = 1.8;
        canvas.drawLine(
          Offset(startX, topRoadwayY + trackH * 0.25),
          Offset(startX + trackLength, topRoadwayY + trackH * 0.25),
          fiberPaint,
        );
        break;

      case SectorBiome.quantumNexus:
        // Sector 5 (4000m+): Cosmic Void Monolith Runway
        // Crystalline obsidian roadway with golden quantum diamond glyphs and stellar runes
        final midY5 = (topRoadwayY + frontCurbY) / 2;
        final constellationPaint = Paint()
          ..color = const Color(0xFFFFD700).withValues(alpha: 0.25)
          ..strokeWidth = 1.2;
        canvas.drawLine(
          Offset(startX, midY5),
          Offset(startX + trackLength, midY5),
          constellationPaint,
        );
        // Floating 24K Quantum Gold Diamond Runes
        final quantumRunePaint = Paint()
          ..color = const Color(0xFFFFD700).withValues(alpha: 0.65)
          ..style = PaintingStyle.fill;
        final quantumRuneStroke = Paint()
          ..color = const Color(0xFFFFFFFF).withValues(alpha: 0.8)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.2;
        for (double x = startX + 50; x < startX + trackLength; x += 90) {
          final runePath = Path()
            ..moveTo(x, midY5 - 7)
            ..lineTo(x + 7, midY5)
            ..lineTo(x, midY5 + 7)
            ..lineTo(x - 7, midY5)
            ..close();
          canvas.drawPath(runePath, quantumRunePaint);
          canvas.drawPath(runePath, quantumRuneStroke);
        }
        // Cosmic Violet Energy Beams along edges
        final cosmicEnergy = Paint()
          ..color = const Color(0xFFE040FB).withValues(alpha: 0.5)
          ..strokeWidth = 2.0;
        canvas.drawLine(
          Offset(startX, topRoadwayY + 2),
          Offset(startX + trackLength, topRoadwayY + 2),
          cosmicEnergy,
        );
        break;
    }
  }

  /// Draws 3D Chasm Walls when there is a pit
  void _render3DChasm(
    Canvas canvas,
    double pitStart,
    double pitEnd,
    double topRoadwayY,
    double frontCurbY,
    double depth,
  ) {
    // Left 3D Chasm Wall (Facing inside the pit)
    final leftWall = Path()
      ..moveTo(pitStart, topRoadwayY)
      ..lineTo(pitStart, frontCurbY)
      ..lineTo(pitStart, AppConstants.virtualHeight)
      ..lineTo(pitStart + 22, AppConstants.virtualHeight)
      ..lineTo(pitStart + 22, topRoadwayY)
      ..close();
    final chasmPaint = Paint()
      ..color = const Color(0xFF04060A)
      ..style = PaintingStyle.fill;
    canvas.drawPath(leftWall, chasmPaint);

    // Chasm edge lighting
    canvas.drawLine(
      Offset(pitStart, topRoadwayY),
      Offset(pitStart, AppConstants.virtualHeight),
      Paint()
        ..color = const Color(0xFF1E2838)
        ..strokeWidth = 2.0,
    );

    // Right 3D Chasm Wall
    final rightWall = Path()
      ..moveTo(pitEnd, topRoadwayY)
      ..lineTo(pitEnd, frontCurbY)
      ..lineTo(pitEnd, AppConstants.virtualHeight)
      ..lineTo(pitEnd - 22, AppConstants.virtualHeight)
      ..lineTo(pitEnd - 22, topRoadwayY)
      ..close();
    canvas.drawPath(rightWall, chasmPaint);
    canvas.drawLine(
      Offset(pitEnd, topRoadwayY),
      Offset(pitEnd, AppConstants.virtualHeight),
      Paint()
        ..color = const Color(0xFF1E2838)
        ..strokeWidth = 2.0,
    );

    // Bottom Molten Lava River in Chasm (Exact Screenshot Style)
    if (biome == SectorBiome.toxicFoundry) {
      final lavaRect = Rect.fromLTWH(
        pitStart,
        AppConstants.virtualHeight - 26,
        pitEnd - pitStart,
        26,
      );
      final lavaGlow = Paint()
        ..color = const Color(0xFFFF3D00).withValues(alpha: 0.6)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 12);
      canvas.drawRect(lavaRect, lavaGlow);

      final lavaCore = Paint()
        ..color = const Color(0xFFFF9100)
        ..style = PaintingStyle.fill;
      canvas.drawRect(lavaRect, lavaCore);

      final moltenVein = Paint()
        ..color = const Color(0xFFFFF176)
        ..strokeWidth = 2.5;
      canvas.drawLine(
        Offset(pitStart, AppConstants.virtualHeight - 14),
        Offset(pitEnd, AppConstants.virtualHeight - 14),
        moltenVein,
      );
    } else {
      // Bottom Abyss Hazard Lasers (Tinted to sector accent)
      final abyssLaser = Paint()
        ..color = biome.primaryAccent.withValues(alpha: 0.7)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2.5;
      canvas.drawLine(
        Offset(pitStart, AppConstants.virtualHeight - 12),
        Offset(pitEnd, AppConstants.virtualHeight - 12),
        abyssLaser,
      );
    }
  }

  /// Draws a glowing cyan holographic hard-light bridge deck spanning across the chasm pit
  void _renderHardLightBridge(
    Canvas canvas,
    double pitStart,
    double pitEnd,
    double topRoadwayY,
    double frontCurbY,
    double depth,
  ) {
    final bridgeWidth = pitEnd - pitStart;
    if (bridgeWidth <= 0) return;

    // 1. Holographic Bridge Roadway Surface (Translucent Glowing Cyan)
    final bridgePath = Path()
      ..moveTo(pitStart, topRoadwayY)
      ..lineTo(pitEnd, topRoadwayY)
      ..lineTo(pitEnd, frontCurbY)
      ..lineTo(pitStart, frontCurbY)
      ..close();

    final bridgeGlow = Paint()
      ..color = const Color(0xFF00E5FF).withValues(alpha: 0.45)
      ..style = PaintingStyle.fill;
    canvas.drawPath(bridgePath, bridgeGlow);

    // 2. High-Tech Hexagonal Grid / Lattice Trusses across the bridge
    final latticePaint = Paint()
      ..color = const Color(0xFFE0F7FA).withValues(alpha: 0.70)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;

    const step = 26.0;
    for (double x = pitStart; x <= pitEnd; x += step) {
      canvas.drawLine(
        Offset(x, topRoadwayY),
        Offset(min(pitEnd, x + step * 0.5), frontCurbY),
        latticePaint,
      );
      canvas.drawLine(
        Offset(x, frontCurbY),
        Offset(min(pitEnd, x + step * 0.5), topRoadwayY),
        latticePaint,
      );
    }

    // 3. Glowing Barrier Railings (Top and Bottom Front Edges)
    final railGlow = Paint()
      ..color = const Color(0xFF00E5FF)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 5.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
    final railLine = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0;

    canvas.drawLine(
      Offset(pitStart, frontCurbY),
      Offset(pitEnd, frontCurbY),
      railGlow,
    );
    canvas.drawLine(
      Offset(pitStart, frontCurbY),
      Offset(pitEnd, frontCurbY),
      railLine,
    );

    canvas.drawLine(
      Offset(pitStart, topRoadwayY),
      Offset(pitEnd, topRoadwayY),
      railGlow,
    );
    canvas.drawLine(
      Offset(pitStart, topRoadwayY),
      Offset(pitEnd, topRoadwayY),
      railLine,
    );

    // 4. Subtle vertical laser safety curtain underneath
    final curtainRect = Rect.fromLTWH(pitStart, frontCurbY, bridgeWidth, 24.0);
    final curtainPaint = Paint()
      ..shader = LinearGradient(
        begin: Alignment.topCenter,
        end: Alignment.bottomCenter,
        colors: [
          const Color(0xFF00E5FF).withValues(alpha: 0.35),
          Colors.transparent,
        ],
      ).createShader(curtainRect);
    canvas.drawRect(curtainRect, curtainPaint);
  }

  /// Draws Realistic 3D Industrial Overhead Roof Girder with Cross-Trusses & Dangling Chains
  void _render3DRoof(Canvas canvas, double chunkLength, double roofY) {
    // 1. Heavy Steel Box Girder
    final roofRect = Rect.fromLTWH(0, 0, chunkLength, roofY);
    canvas.drawRect(roofRect, Paint()..color = const Color(0xFF070A0F));

    // Steel Beam Flange
    final flangeRect = Rect.fromLTWH(0, roofY - 14, chunkLength, 14);
    canvas.drawRect(flangeRect, Paint()..color = const Color(0xFF131822));

    // Overhead Industrial Lattice / X-Trusses (Exact Screenshot Girder)
    final trussPaint = Paint()
      ..color = const Color(0xFF263244)
      ..strokeWidth = 2.2;
    for (double x = 0; x < chunkLength; x += 48) {
      canvas.drawLine(Offset(x, 10), Offset(x + 48, roofY - 14), trussPaint);
      canvas.drawLine(Offset(x + 48, 10), Offset(x, roofY - 14), trussPaint);
      canvas.drawLine(Offset(x, 10), Offset(x, roofY - 14), trussPaint);
    }

    // Lower Beam Accent Strip
    final accentStrip = Paint()
      ..color = biome.secondaryAccent.withValues(alpha: 0.75)
      ..strokeWidth = 2.2;
    canvas.drawLine(Offset(0, roofY), Offset(chunkLength, roofY), accentStrip);

    // Dangling Heavy Industrial Chains
    final chainPaint = Paint()
      ..color = const Color(0xFF384354)
      ..strokeWidth = 1.6;
    for (double x = 110; x < chunkLength; x += 280) {
      for (double cy = roofY; cy < roofY + 34; cy += 6) {
        canvas.drawOval(
          Rect.fromCenter(center: Offset(x, cy), width: 3.5, height: 6.0),
          chainPaint,
        );
      }
    }
  }
}
