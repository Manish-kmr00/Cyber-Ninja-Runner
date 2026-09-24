import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../hazards/base_hazard.dart';
import '../cyber_ninja_game.dart';
import 'track_segment_models.dart';

/// 3D Volumetric Shadow Haven: An extruded stealth sanctuary with perspective canopy.
class ShadowHaven extends PositionComponent {
  final SectorBiome biome;
  double pulseTimer = 0.0;

  ShadowHaven({
    required super.position,
    required super.size,
    this.biome = SectorBiome.neonMetropolis,
  }) : super(anchor: Anchor.bottomLeft);

  @override
  void update(double dt) {
    super.update(dt);
    pulseTimer += dt * 3.0;
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    const depthY = 16.0;
    final havenAccent = biome == SectorBiome.cyberShinto
        ? const Color(0xFFFF003C)
        : (biome == SectorBiome.neoNebula
              ? const Color(0xFF00F5FF)
              : AppConstants.stealthBlue);

    // 1. 3D Slanted Roof Canopy (Perspective Top Face)
    final roofPath = Path()
      ..moveTo(0, -size.y)
      ..lineTo(depthY, -size.y - depthY)
      ..lineTo(size.x + depthY, -size.y - depthY)
      ..lineTo(size.x, -size.y)
      ..close();

    final roofColor = biome == SectorBiome.cyberShinto
        ? const Color(0xE62A0814)
        : (biome == SectorBiome.neoNebula
              ? const Color(0xE60A1424)
              : const Color(0xE610192A));
    final roofPaint = Paint()
      ..color = roofColor
      ..style = PaintingStyle.fill;
    canvas.drawPath(roofPath, roofPaint);

    final roofEdgePaint = Paint()
      ..color = havenAccent.withValues(alpha: 0.65)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawPath(roofPath, roofEdgePaint);

    // 2. 3D Front Holographic Stealth Shield Wall
    final wallRect = Rect.fromLTWH(0, -size.y, size.x, size.y);
    final wallColor = biome == SectorBiome.cyberShinto
        ? const Color(0xCC18040B)
        : (biome == SectorBiome.neoNebula
              ? const Color(0xCC060E1A)
              : const Color(0xCC09101C));
    final wallPaint = Paint()
      ..color = wallColor
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(wallRect, const Radius.circular(6.0)),
      wallPaint,
    );

    // Pulsing Neon Stealth Perimeter
    final pulseAlpha = 0.4 + 0.3 * (0.5 + 0.5 * (pulseTimer % 3.14));
    final edgePaint = Paint()
      ..color = havenAccent.withValues(alpha: pulseAlpha.clamp(0.2, 0.9))
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0;
    canvas.drawRRect(
      RRect.fromRectAndRadius(wallRect, const Radius.circular(6.0)),
      edgePaint,
    );

    // Top Glowing Neon Lintel / Shinto Torii Beam / Smelter Vent
    final lintelPaint = Paint()
      ..color = havenAccent
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
        Rect.fromLTWH(0, -size.y, size.x, 4.5),
        const Radius.circular(2.0),
      ),
      lintelPaint,
    );

    // Extra Shinto Talisman Accents on Pavilion
    if (biome == SectorBiome.cyberShinto) {
      final talismanPaint = Paint()..color = const Color(0xFFFFD700);
      for (double tx = 20; tx < size.x - 10; tx += 35) {
        canvas.drawRect(Rect.fromLTWH(tx, -size.y + 6, 8, 14), talismanPaint);
      }
    }
  }
}

/// 3D Collectible Cyber Point (CP): Floating rotating 3D octahedron crystal / Magatama / Magma Core.
class CollectibleCP extends PositionComponent {
  final SectorBiome biome;
  double bobTimer = 0.0;
  bool isCollected = false;

  /// The CP reward granted when the Ninja collects this pickup.
  /// This is the EXACT amount added — no multipliers, no distance scaling.
  final int value;

  CollectibleCP({
    required super.position,
    this.biome = SectorBiome.neonMetropolis,
    this.value = 1,
  }) : super(size: Vector2(24, 24), anchor: Anchor.center);

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

    final auraColor = biome == SectorBiome.cyberShinto
        ? const Color(0xFFFF003C)
        : (biome == SectorBiome.neoNebula
              ? const Color(0xFF00F5FF)
              : AppConstants.coinGold);

    // Outer Ambient Glow
    final glowPaint = Paint()
      ..color = auraColor.withValues(alpha: 0.38)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 8);
    canvas.drawCircle(center, 14, glowPaint);

    canvas.save();
    canvas.translate(center.dx, center.dy);

    // 3D Isometric Crystal Projection (Rotating Octahedron with 3D faces)
    final rot = bobTimer;
    final w = 11.0;
    final h = 14.0;
    final depthOffset = sin(rot) * 5.0;

    final Color f1Color;
    final Color f2Color;
    final Color f3Color;
    final Color f4Color;

    if (biome == SectorBiome.cyberShinto) {
      // Sacred Crimson Magatama Jewels
      f1Color = const Color(0xFFFF3366);
      f2Color = const Color(0xFFFF003C);
      f3Color = const Color(0xFFD00030);
      f4Color = const Color(0xFFFFD700);
    } else if (biome == SectorBiome.neoNebula) {
      // Cyber Matrix Data Octahedron Crystals
      f1Color = const Color(0xFF80F9FF); // Brilliant Cyan
      f2Color = const Color(0xFF00F5FF); // Electric Cyan
      f3Color = const Color(0xFF00B0FF); // Laser Blue
      f4Color = const Color(0xFFFF007F); // Magenta Matrix Core
    } else {
      // Classic Gold Cyberpunk CP
      f1Color = const Color(0xFFFFE066);
      f2Color = const Color(0xFFFFB300);
      f3Color = const Color(0xFFFF8F00);
      f4Color = const Color(0xFFFF6F00);
    }

    // Face 1: Left Facet (Lit)
    final face1 = Path()
      ..moveTo(0, -h)
      ..lineTo(-w, 0)
      ..lineTo(depthOffset, 4)
      ..close();
    canvas.drawPath(
      face1,
      Paint()
        ..color = f1Color
        ..style = PaintingStyle.fill,
    );

    // Face 2: Right Facet (Shaded)
    final face2 = Path()
      ..moveTo(0, -h)
      ..lineTo(w, 0)
      ..lineTo(depthOffset, 4)
      ..close();
    canvas.drawPath(
      face2,
      Paint()
        ..color = f2Color
        ..style = PaintingStyle.fill,
    );

    // Face 3: Bottom Left Facet
    final face3 = Path()
      ..moveTo(-w, 0)
      ..lineTo(0, h)
      ..lineTo(depthOffset, 4)
      ..close();
    canvas.drawPath(
      face3,
      Paint()
        ..color = f3Color
        ..style = PaintingStyle.fill,
    );

    // Face 4: Bottom Right Facet
    final face4 = Path()
      ..moveTo(w, 0)
      ..lineTo(0, h)
      ..lineTo(depthOffset, 4)
      ..close();
    canvas.drawPath(
      face4,
      Paint()
        ..color = f4Color
        ..style = PaintingStyle.fill,
    );

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

    if (biome == SectorBiome.cyberShinto) {
      // --- MAP 2: LACQUERED SHINTO TORII BRIDGE PLATFORM ---
      // 1. Vermilion Curved Lacquer Railing with Golden Finial Posts
      final railPostPaint = Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 2.5;
      final railBarPaint = Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 2.5;
      canvas.drawLine(const Offset(0, -16), Offset(size.x, -16), railBarPaint);
      canvas.drawLine(const Offset(0, -7), Offset(size.x, -7), railBarPaint);
      for (double rx = 10; rx < size.x; rx += 35) {
        canvas.drawLine(Offset(rx, 0), Offset(rx, -16), railPostPaint);
        canvas.drawCircle(
          Offset(rx, -17),
          2.5,
          Paint()..color = const Color(0xFFFFD700),
        );
      }

      // 2. Walkway Deck (Obsidian Lacquer Wood with Gold Trim)
      final deckPath = Path()
        ..moveTo(0, 0)
        ..lineTo(size.x, 0)
        ..lineTo(size.x, depthY)
        ..lineTo(0, depthY)
        ..close();
      canvas.drawPath(deckPath, Paint()..color = const Color(0xFF160610));

      // Golden diamond paving
      final goldDiamond = Paint()
        ..color = const Color(0xFFFFD700).withValues(alpha: 0.5)
        ..strokeWidth = 1.2;
      for (double tx = 15; tx < size.x; tx += 30) {
        canvas.drawLine(Offset(tx, 2), Offset(tx + 6, depthY - 2), goldDiamond);
        canvas.drawLine(Offset(tx + 6, 2), Offset(tx, depthY - 2), goldDiamond);
      }

      // Glowing Crimson Curb Edge
      canvas.drawLine(
        const Offset(0, depthY),
        Offset(size.x, depthY),
        Paint()
          ..color = const Color(0xFFFF003C)
          ..strokeWidth = 3.5
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );

      // 3. Platform Underside with Sacred Hanging Amber Lanterns
      final underRect = Rect.fromLTWH(0, depthY, size.x, size.y - depthY);
      canvas.drawRect(underRect, Paint()..color = const Color(0xFF22040E));

      final lanternPaint = Paint()
        ..color = const Color(0xFFFFD700).withValues(alpha: 0.85)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
      for (double lx = 25; lx < size.x; lx += 60) {
        canvas.drawLine(
          Offset(lx, size.y),
          Offset(lx, size.y + 12),
          Paint()
            ..color = const Color(0xFFFF003C)
            ..strokeWidth = 1.5,
        );
        canvas.drawCircle(Offset(lx, size.y + 16), 4.0, lanternPaint);
      }

      // 4. Torii Support Posts
      for (double px = 25; px < size.x; px += 120) {
        canvas.drawRect(
          Rect.fromLTWH(px - 6, size.y, 12, 180),
          Paint()..color = const Color(0xFF140208),
        );
        canvas.drawLine(
          Offset(px, size.y),
          Offset(px, size.y + 180),
          Paint()
            ..color = const Color(0xFFFF003C)
            ..strokeWidth = 3.0,
        );
      }
      return;
    }

    if (biome == SectorBiome.neoNebula) {
      // --- MAP 3: HIGH-ALTITUDE MAGLEV SKY-PLATFORM ---
      // 1. Hexagonal Forcefield Safety Guardrail
      final forcefieldBeam = Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.8)
        ..strokeWidth = 2.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      canvas.drawLine(
        const Offset(0, -20),
        Offset(size.x, -20),
        forcefieldBeam,
      );
      canvas.drawLine(
        const Offset(0, -10),
        Offset(size.x, -10),
        forcefieldBeam,
      );

      // Hexagonal Forcefield Lattice Pattern
      final hexPaint = Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.3)
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.0;
      for (double rx = 10; rx < size.x; rx += 24) {
        final hexPath = Path()
          ..moveTo(rx, -20)
          ..lineTo(rx + 6, -15)
          ..lineTo(rx + 6, -10)
          ..lineTo(rx, -5)
          ..lineTo(rx - 6, -10)
          ..lineTo(rx - 6, -15)
          ..close();
        canvas.drawPath(hexPath, hexPaint);
      }

      // 2. Walkway Deck (Carbon-Nanotube & Titanium Frame)
      final deckPath = Path()
        ..moveTo(0, 0)
        ..lineTo(size.x, 0)
        ..lineTo(size.x, depthY)
        ..lineTo(0, depthY)
        ..close();
      canvas.drawPath(deckPath, Paint()..color = const Color(0xFF0A101C));
      canvas.drawPath(
        deckPath,
        Paint()
          ..color = const Color(0xFF16243A)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.2,
      );

      // Central Pulsing Maglev Induction Rail
      final maglevRail = Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.75)
        ..strokeWidth = 3.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      canvas.drawLine(
        Offset(0, depthY * 0.5),
        Offset(size.x, depthY * 0.5),
        maglevRail,
      );
      canvas.drawLine(
        Offset(0, depthY * 0.5),
        Offset(size.x, depthY * 0.5),
        Paint()
          ..color = Colors.white
          ..strokeWidth = 1.0,
      );

      // Glowing Holographic Speed Chevrons (>>>)
      final chevronPaint = Paint()
        ..color = const Color(0xFFFF007F).withValues(alpha: 0.7)
        ..strokeWidth = 1.8
        ..strokeCap = StrokeCap.round;
      for (double cx = 20; cx < size.x; cx += 45) {
        canvas.drawLine(
          Offset(cx - 5, 2),
          Offset(cx, depthY * 0.5),
          chevronPaint,
        );
        canvas.drawLine(
          Offset(cx, depthY * 0.5),
          Offset(cx - 5, depthY - 2),
          chevronPaint,
        );
      }

      // Glowing Cyan Curb Edge
      canvas.drawLine(
        const Offset(0, depthY),
        Offset(size.x, depthY),
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..strokeWidth = 3.5
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );

      // 3. Platform Underside with High-Speed Optical Data Conduits
      final underRect = Rect.fromLTWH(0, depthY, size.x, size.y - depthY);
      canvas.drawRect(underRect, Paint()..color = const Color(0xFF060B14));

      // Dual Fiber-Optic Telemetry Lines
      canvas.drawLine(
        Offset(0, (depthY + size.y) / 2 - 2),
        Offset(size.x, (depthY + size.y) / 2 - 2),
        Paint()
          ..color = const Color(0xFF00F5FF)
          ..strokeWidth = 2.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 1),
      );
      canvas.drawLine(
        Offset(0, (depthY + size.y) / 2 + 2),
        Offset(size.x, (depthY + size.y) / 2 + 2),
        Paint()
          ..color = const Color(0xFFFF007F)
          ..strokeWidth = 1.5,
      );

      // 4. Sleek Aerodynamic Support Pylons with Hydraulic Dampers
      for (double px = 30; px < size.x; px += 130) {
        final pRect = Rect.fromLTWH(px - 8, size.y, 16, 180);
        canvas.drawRect(pRect, Paint()..color = const Color(0xFF080F1C));
        canvas.drawLine(
          Offset(px, size.y),
          Offset(px, size.y + 180),
          Paint()
            ..color = const Color(0xFF00F5FF)
            ..strokeWidth = 1.8,
        );
        // Blinking Sensor Node
        canvas.drawCircle(
          Offset(px, size.y + 20),
          3.0,
          Paint()
            ..color = const Color(0xFF00F5FF)
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
        );
      }
      return;
    }

    // 1. Steel Safety Railings along the back of the platform (Default Campaign)
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
  final TrackSegmentType segmentType;
  final CyberEnvironmentTheme environmentTheme;
  final SegmentGameplayEvent gameplayEvent;
  final double entryElevation;
  final double exitElevation;

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
    this.segmentType = TrackSegmentType.straightNeonBoulevard,
    this.environmentTheme = CyberEnvironmentTheme.cyberAlley,
    this.gameplayEvent = SegmentGameplayEvent.runPacing,
    this.entryElevation = 0.0,
    this.exitElevation = 0.0,
  }) : super(
         position: Vector2(startX, 0),
         size: Vector2(length, AppConstants.virtualHeight),
         priority: 10,
       );

  /// Returns the top surface Y coordinate of the running track at the given world X coordinate.
  double getSurfaceY(double worldX) {
    final relX = (worldX - startX).clamp(0.0, length);
    final t = length > 0 ? relX / length : 0.0;
    final elev = entryElevation + (exitElevation - entryElevation) * t;
    return groundY + elev;
  }

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
    final entryGroundY = groundY + entryElevation;
    final exitGroundY = groundY + exitElevation;
    final entryTopY = entryGroundY - trackDepth;
    final exitTopY = exitGroundY - trackDepth;

    // 1. Distant 3D Cyber Grid Pillars (creates parallax depth)
    final gridPaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.035)
      ..strokeWidth = 1.0;
    for (double x = 0; x < length; x += 140) {
      final t = length > 0 ? x / length : 0.0;
      final curTopY = entryTopY + (exitTopY - entryTopY) * t;
      canvas.drawLine(Offset(x, roofY + 16), Offset(x, curTopY), gridPaint);
    }

    // 2. Render 2.5D Extruded 3D Running Track
    if (!hasPit) {
      _renderSolid3DTrack(
        canvas,
        0,
        length,
        entryTopY,
        exitTopY,
        entryGroundY,
        exitGroundY,
        trackDepth,
      );
    } else {
      final t1 = length > 0 ? (pitStartX / length).clamp(0.0, 1.0) : 0.0;
      final pitEntryGroundY = entryGroundY + (exitGroundY - entryGroundY) * t1;
      final pitEntryTopY = pitEntryGroundY - trackDepth;

      // Segment 1: Left 3D Track before pit
      _renderSolid3DTrack(
        canvas,
        0,
        pitStartX,
        entryTopY,
        pitEntryTopY,
        entryGroundY,
        pitEntryGroundY,
        trackDepth,
      );

      final afterPitX = pitStartX + pitWidth;
      final t2 = length > 0 ? (afterPitX / length).clamp(0.0, 1.0) : 1.0;
      final pitExitGroundY = entryGroundY + (exitGroundY - entryGroundY) * t2;
      final pitExitTopY = pitExitGroundY - trackDepth;

      // 3D Chasm Walls in the Pit
      final tMid = length > 0
          ? ((pitStartX + afterPitX) * 0.5 / length).clamp(0.0, 1.0)
          : 0.0;
      final pitMidTop = entryTopY + (exitTopY - entryTopY) * tMid;
      final pitMidGround = entryGroundY + (exitGroundY - entryGroundY) * tMid;

      _render3DChasm(
        canvas,
        pitStartX,
        afterPitX,
        pitMidTop,
        pitMidGround,
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
          afterPitX,
          pitMidTop,
          pitMidGround,
          trackDepth,
        );
      }

      // Segment 2: Right 3D Track after pit
      _renderSolid3DTrack(
        canvas,
        afterPitX,
        length - afterPitX,
        pitExitTopY,
        exitTopY,
        pitExitGroundY,
        exitGroundY,
        trackDepth,
      );
    }

    // 3. Render 50m Modular Segment-Specific Architecture (Pylons, Trusses, Cables, Billboards, Pipes, Gantries)
    _renderSegmentArchitecture(
      canvas,
      length,
      entryTopY,
      exitTopY,
      entryGroundY,
      exitGroundY,
      trackDepth,
    );

    // 4. Render 9 Environment Theme Props (Alley, Rooftop, Tunnel, Hologram, Sky Bridge, Dark Sector, Industrial, Market, Highway)
    _renderEnvironmentThemeProps(
      canvas,
      length,
      entryTopY,
      exitTopY,
      entryGroundY,
      exitGroundY,
      trackDepth,
    );

    // 5. 3D Overhead Industrial Roof Girder
    _render3DRoof(canvas, length, roofY);
  }

  /// Draws a continuous 3D track block: Slanted 3D top roadway + Front drop face
  void _renderSolid3DTrack(
    Canvas canvas,
    double startX,
    double trackLength,
    double topRoadwayY1,
    double topRoadwayY2,
    double frontCurbY1,
    double frontCurbY2,
    double depth,
  ) {
    if (trackLength <= 0) return;

    final avgTop = (topRoadwayY1 + topRoadwayY2) * 0.5;
    final avgFront = (frontCurbY1 + frontCurbY2) * 0.5;

    // Completely distinct custom 3D tracks for Map 2 and Map 3:
    if (biome == SectorBiome.cyberShinto) {
      _renderCyberShinto3DTrack(
        canvas,
        startX,
        trackLength,
        avgTop,
        avgFront,
        depth,
      );
      return;
    }
    if (biome == SectorBiome.neoNebula) {
      _renderNeoNebula3DTrack(
        canvas,
        startX,
        trackLength,
        avgTop,
        avgFront,
        depth,
      );
      return;
    }

    // A. 3D Top Roadway (Walkable Depth Plane)
    final topRoadwayPath = Path()
      ..moveTo(startX, topRoadwayY1)
      ..lineTo(startX + trackLength, topRoadwayY2)
      ..lineTo(startX + trackLength, frontCurbY2)
      ..lineTo(startX, frontCurbY1)
      ..close();

    final roadwayPaint = Paint()
      ..color = biome.roadColor
      ..style = PaintingStyle.fill;
    canvas.drawPath(topRoadwayPath, roadwayPaint);

    // Biome-Specific Roadway Patterns & Decals
    _renderRoadwayDecals(canvas, startX, trackLength, avgTop, avgFront);

    // Back Curb Line (Distant Z-Plane)
    final backCurbPaint = Paint()
      ..color = biome.primaryAccent.withValues(alpha: 0.35)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawLine(
      Offset(startX, topRoadwayY1),
      Offset(startX + trackLength, topRoadwayY2),
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
      Offset(startX, frontCurbY1),
      Offset(startX + trackLength, frontCurbY2),
      frontGlow,
    );
    canvas.drawLine(
      Offset(startX, frontCurbY1),
      Offset(startX + trackLength, frontCurbY2),
      frontEdge,
    );

    // B. 3D Front Wall (Vertical Drop Face - Realistic Industrial Girder & Hazard Fascia)
    final frontWallPath = Path()
      ..moveTo(startX, frontCurbY1)
      ..lineTo(startX + trackLength, frontCurbY2)
      ..lineTo(startX + trackLength, AppConstants.virtualHeight)
      ..lineTo(startX, AppConstants.virtualHeight)
      ..close();
    final frontWallPaint = Paint()
      ..color = const Color(0xFF0C1017)
      ..style = PaintingStyle.fill;
    canvas.drawPath(frontWallPath, frontWallPaint);

    // Continuous Upper Fascia Beam (Steel Girder Plate)
    const girderFasciaH = 26.0;
    final girderPath = Path()
      ..moveTo(startX, frontCurbY1)
      ..lineTo(startX + trackLength, frontCurbY2)
      ..lineTo(startX + trackLength, frontCurbY2 + girderFasciaH)
      ..lineTo(startX, frontCurbY1 + girderFasciaH)
      ..close();
    canvas.drawPath(girderPath, Paint()..color = const Color(0xFF161C26));

    final frontCurbY = avgFront;

    // Sector 2 (Toxic Foundry): Exact Yellow/Black Diagonal Hazard ChevrN & CAUTION Stencil
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

      case SectorBiome.cyberShinto:
        // Map 2: Vermilion Lacquered Torii Foundation Pillars & Cursed Rune Seals
        final toriiPillarPaint = Paint()..color = const Color(0xFF160209);
        final vermilionTrim = Paint()
          ..color = const Color(0xFFFF003C).withValues(alpha: 0.8)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 2.0;
        final goldSeal = Paint()..color = const Color(0xFFFFD700);
        for (double x = startX + 60; x < startX + trackLength; x += 160) {
          final pRect = Rect.fromLTWH(
            x,
            frontCurbY + girderFasciaH + 4,
            38,
            AppConstants.virtualHeight,
          );
          canvas.drawRect(pRect, toriiPillarPaint);
          canvas.drawRect(pRect, vermilionTrim);
          canvas.drawCircle(
            Offset(x + 19, frontCurbY + girderFasciaH + 24),
            4.5,
            goldSeal,
          );
        }
        break;

      case SectorBiome.neoNebula:
        // Map 3: Monolithic Cyber Pylon Towers & Server Blade Arrays
        final pylonPaint = Paint()..color = const Color(0xFF080D18);
        final pylonEdge = Paint()
          ..color = const Color(0xFF162540)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.6;
        final dataLedCyan = Paint()
          ..color = const Color(0xFF00F5FF)
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
        final dataLedAmber = Paint()..color = const Color(0xFFFFD700);

        for (double x = startX + 80; x < startX + trackLength; x += 190) {
          final bRect = Rect.fromLTWH(
            x,
            frontCurbY + girderFasciaH + 4,
            50,
            AppConstants.virtualHeight,
          );
          canvas.drawRect(bRect, pylonPaint);
          canvas.drawRect(bRect, pylonEdge);

          // Central Hydraulic Piston Conduit
          canvas.drawLine(
            Offset(x + 25, frontCurbY + girderFasciaH + 4),
            Offset(x + 25, AppConstants.virtualHeight),
            Paint()
              ..color = const Color(0xFF00F5FF).withValues(alpha: 0.7)
              ..strokeWidth = 2.0,
          );

          // Embedded Server Blade Array LEDs
          for (
            double sy = frontCurbY + girderFasciaH + 15;
            sy < frontCurbY + girderFasciaH + 120;
            sy += 16
          ) {
            canvas.drawCircle(Offset(x + 12, sy), 2.0, dataLedCyan);
            canvas.drawCircle(Offset(x + 38, sy), 1.6, dataLedAmber);
          }
        }
        break;
    }
  }

  void _renderCyberShinto3DTrack(
    Canvas canvas,
    double startX,
    double trackLength,
    double topRoadwayY,
    double frontCurbY,
    double depth,
  ) {
    final trackH = frontCurbY - topRoadwayY;

    // 1. Walkway Deck: 3D Beveled Vermilion & Obsidian Timber Bridge
    const plankW = 28.0;
    for (double x = startX; x < startX + trackLength; x += plankW) {
      final curW = min(plankW, startX + trackLength - x);
      final plankRect = Rect.fromLTWH(x, topRoadwayY, curW, trackH);

      // Base wood tone: deep rich vermilion
      canvas.drawRect(plankRect, Paint()..color = const Color(0xFF280710));

      // Top bevel highlight
      canvas.drawLine(
        Offset(x, topRoadwayY + 1),
        Offset(x + curW, topRoadwayY + 1),
        Paint()
          ..color = const Color(0xFF6B1A2C)
          ..strokeWidth = 1.8,
      );

      // Bottom bevel shadow
      canvas.drawLine(
        Offset(x, frontCurbY - 1),
        Offset(x + curW, frontCurbY - 1),
        Paint()
          ..color = const Color(0xFF120207)
          ..strokeWidth = 2.0,
      );

      // Plank dividing seam with gold reflection
      canvas.drawLine(
        Offset(x, topRoadwayY),
        Offset(x, frontCurbY),
        Paint()
          ..color = const Color(0xFF0F0105)
          ..strokeWidth = 1.8,
      );
      canvas.drawLine(
        Offset(x + 1.2, topRoadwayY),
        Offset(x + 1.2, frontCurbY),
        Paint()
          ..color = const Color(0xFFFFD700).withValues(alpha: 0.28)
          ..strokeWidth = 1.0,
      );

      // Golden brass rivets/caps on plank tips
      canvas.drawCircle(
        Offset(x + curW * 0.5, topRoadwayY + 4),
        1.8,
        Paint()..color = const Color(0xFFFFD700),
      );
      canvas.drawCircle(
        Offset(x + curW * 0.5, frontCurbY - 4),
        1.8,
        Paint()..color = const Color(0xFFFFD700),
      );
    }

    // Sacred Central Dragon Runway Conduit with Glowing Crimson Aura & Gold Inlays
    final midY = (topRoadwayY + frontCurbY) / 2;
    final dragonConduit = Paint()
      ..color = const Color(0xFFFF003C).withValues(alpha: 0.85)
      ..strokeWidth = 3.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
    canvas.drawLine(
      Offset(startX, midY),
      Offset(startX + trackLength, midY),
      dragonConduit,
    );
    canvas.drawLine(
      Offset(startX, midY),
      Offset(startX + trackLength, midY),
      Paint()
        ..color = const Color(0xFFFFD700)
        ..strokeWidth = 1.2,
    );

    // Glowing Magatama / Diamond Gold Jewels along center
    final goldJewelPaint = Paint()..color = const Color(0xFFFFD700);
    final redJewelCore = Paint()..color = const Color(0xFFFF003C);
    for (double x = startX + 35; x < startX + trackLength; x += 70) {
      final rPath = Path()
        ..moveTo(x, midY - 6)
        ..lineTo(x + 6, midY)
        ..lineTo(x, midY + 6)
        ..lineTo(x - 6, midY)
        ..close();
      canvas.drawPath(rPath, goldJewelPaint);
      canvas.drawCircle(Offset(x, midY), 2.2, redJewelCore);
    }

    // 2. 3D Raised Curbs: Back Curb and Front Curb with Golden Balustrade Posts
    canvas.drawLine(
      Offset(startX, topRoadwayY),
      Offset(startX + trackLength, topRoadwayY),
      Paint()
        ..color = const Color(0xFFFF003C).withValues(alpha: 0.6)
        ..strokeWidth = 3.5,
    );
    canvas.drawLine(
      Offset(startX, frontCurbY - 2),
      Offset(startX + trackLength, frontCurbY - 2),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 4.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
    );
    canvas.drawLine(
      Offset(startX, frontCurbY),
      Offset(startX + trackLength, frontCurbY),
      Paint()
        ..color = const Color(0xFFFFE082)
        ..strokeWidth = 2.5,
    );

    // Golden Lotus Balustrade Finial Posts along the front curb
    for (double x = startX + 20; x < startX + trackLength; x += 65) {
      canvas.drawRRect(
        RRect.fromRectAndRadius(
          Rect.fromCenter(center: Offset(x, frontCurbY), width: 7, height: 6),
          const Radius.circular(2),
        ),
        Paint()..color = const Color(0xFFFFD700),
      );
      final budPath = Path()
        ..moveTo(x - 3, frontCurbY - 2)
        ..quadraticBezierTo(x, frontCurbY - 8, x + 3, frontCurbY - 2)
        ..close();
      canvas.drawPath(budPath, Paint()..color = const Color(0xFFFF003C));
      canvas.drawCircle(
        Offset(x, frontCurbY - 7),
        1.5,
        Paint()..color = const Color(0xFFFFD700),
      );
    }

    // 3. 3D Front Wall: Traditional Japanese Dougong (斗拱) Multi-tier Bracket Architecture
    final wallHeight = AppConstants.virtualHeight - frontCurbY;
    final wallRect = Rect.fromLTWH(startX, frontCurbY, trackLength, wallHeight);
    canvas.drawRect(wallRect, Paint()..color = const Color(0xFF0F0105));

    // Continuous Upper Vermilion Fascia Eave Beam
    const eaveH = 28.0;
    canvas.drawRect(
      Rect.fromLTWH(startX, frontCurbY, trackLength, eaveH),
      Paint()..color = const Color(0xFF1E040C),
    );
    canvas.drawLine(
      Offset(startX, frontCurbY + eaveH),
      Offset(startX + trackLength, frontCurbY + eaveH),
      Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 3.0,
    );

    // Multi-tier Dougong Wood Brackets (Tokyō 斗拱) clusters every 60px
    final bracketPaint = Paint()..color = const Color(0xFF330615);
    final bracketGold = Paint()..color = const Color(0xFFFFD700);
    for (double bx = startX + 30; bx < startX + trackLength; bx += 60) {
      canvas.drawRect(
        Rect.fromLTWH(bx - 12, frontCurbY + 3, 24, 7),
        bracketPaint,
      );
      canvas.drawRect(Rect.fromLTWH(bx - 3, frontCurbY + 3, 6, 7), bracketGold);

      canvas.drawRect(
        Rect.fromLTWH(bx - 18, frontCurbY + 12, 36, 6),
        bracketPaint,
      );
      canvas.drawCircle(Offset(bx - 16, frontCurbY + 15), 2.0, bracketGold);
      canvas.drawCircle(Offset(bx + 16, frontCurbY + 15), 2.0, bracketGold);

      final bellY = frontCurbY + eaveH + 4;
      canvas.drawLine(
        Offset(bx, frontCurbY + eaveH),
        Offset(bx, bellY),
        Paint()
          ..color = const Color(0xFFFFD700)
          ..strokeWidth = 1.2,
      );
      final bPath = Path()
        ..moveTo(bx - 4, bellY + 5)
        ..lineTo(bx + 4, bellY + 5)
        ..lineTo(bx + 3, bellY)
        ..lineTo(bx - 3, bellY)
        ..close();
      canvas.drawPath(bPath, bracketGold);

      final shidePath = Path()
        ..moveTo(bx, bellY + 5)
        ..lineTo(bx - 3, bellY + 9)
        ..lineTo(bx + 3, bellY + 13)
        ..lineTo(bx, bellY + 17);
      canvas.drawPath(
        shidePath,
        Paint()
          ..color = Colors.white.withValues(alpha: 0.9)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.6,
      );
    }

    // 4. Massive Torii Gate Columns (Extruded Cylinders with 3D Lighting & Inscriptions)
    for (double x = startX + 50; x < startX + trackLength; x += 170) {
      const colW = 42.0;
      final colTop = frontCurbY + eaveH + 6;
      final colH = AppConstants.virtualHeight - colTop;

      final pRect = Rect.fromLTWH(x, colTop, colW, colH);
      canvas.drawRect(pRect, Paint()..color = const Color(0xFF1C030D));
      canvas.drawLine(
        Offset(x + 7, colTop),
        Offset(x + 7, AppConstants.virtualHeight),
        Paint()
          ..color = const Color(0xFF5A0E23)
          ..strokeWidth = 4.0,
      );
      canvas.drawLine(
        Offset(x, colTop),
        Offset(x, AppConstants.virtualHeight),
        Paint()
          ..color = const Color(0xFFFF003C)
          ..strokeWidth = 2.0,
      );
      canvas.drawLine(
        Offset(x + colW, colTop),
        Offset(x + colW, AppConstants.virtualHeight),
        Paint()
          ..color = const Color(0xFFFF003C)
          ..strokeWidth = 2.0,
      );

      final ringY = colTop + 24;
      canvas.drawRect(
        Rect.fromLTWH(x - 3, ringY, colW + 6, 12),
        Paint()..color = const Color(0xFFFFD700),
      );
      canvas.drawCircle(
        Offset(x + colW * 0.5, ringY + 6),
        3.5,
        Paint()..color = const Color(0xFFFF003C),
      );

      final kanjiPaint = Paint()
        ..color = const Color(0xFFFFD700).withValues(alpha: 0.85)
        ..strokeWidth = 2.0;
      for (double ky = ringY + 22; ky < ringY + 70; ky += 16) {
        canvas.drawLine(
          Offset(x + 12, ky),
          Offset(x + colW - 12, ky),
          kanjiPaint,
        );
        canvas.drawLine(
          Offset(x + colW * 0.5, ky - 5),
          Offset(x + colW * 0.5, ky + 5),
          kanjiPaint,
        );
      }
    }
  }

  void _renderNeoNebula3DTrack(
    Canvas canvas,
    double startX,
    double trackLength,
    double topRoadwayY,
    double frontCurbY,
    double depth,
  ) {
    final trackH = frontCurbY - topRoadwayY;
    final midY = (topRoadwayY + frontCurbY) / 2;

    // 1. UNDER-TRACK: Pure Void Pitch-Black with Deep Digital Wireframe Grid
    final voidRect = Rect.fromLTWH(startX, topRoadwayY, trackLength, trackH);
    canvas.drawRect(voidRect, Paint()..color = const Color(0xFF000206));

    // Digital Grid Lines beneath the glass track
    final gridPaint = Paint()
      ..color = const Color(0xFF00F5FF).withValues(alpha: 0.18)
      ..strokeWidth = 1.0;
    for (double gy = topRoadwayY + 3; gy < frontCurbY; gy += 5) {
      canvas.drawLine(
        Offset(startX, gy),
        Offset(startX + trackLength, gy),
        gridPaint,
      );
    }
    for (double gx = startX; gx < startX + trackLength; gx += 28) {
      canvas.drawLine(
        Offset(gx, topRoadwayY),
        Offset(gx, frontCurbY),
        gridPaint,
      );
    }

    // 2. Translucent Crystalline Glass Panels (Tron / Ghostrunner Aesthetic)
    const panelWidth = 56.0;
    for (double px = startX; px < startX + trackLength; px += panelWidth) {
      final curW = min(panelWidth, startX + trackLength - px);
      final pRect = Rect.fromLTWH(px, topRoadwayY, curW, trackH);

      // Glass surface: deep translucent cyber cyan
      canvas.drawRect(pRect, Paint()..color = const Color(0x3300F5FF));
      // Panel Bevel Edges (White & Cyan reflections)
      canvas.drawRect(
        pRect,
        Paint()
          ..color = const Color(0xFF00F5FF).withValues(alpha: 0.55)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.2,
      );

      // Top Glass Highlight Beam
      canvas.drawLine(
        Offset(px + 2, topRoadwayY + 1.5),
        Offset(px + curW - 2, topRoadwayY + 1.5),
        Paint()
          ..color = Colors.white.withValues(alpha: 0.7)
          ..strokeWidth = 1.0,
      );

      // Internal Diagonal Light Refraction
      canvas.drawLine(
        Offset(px + 4, frontCurbY - 3),
        Offset(px + curW - 4, topRoadwayY + 3),
        Paint()
          ..color = const Color(0xFF00F5FF).withValues(alpha: 0.2)
          ..strokeWidth = 1.0,
      );

      // Glowing Hexagonal Data Node at Panel Seams
      canvas.drawCircle(
        Offset(px, midY),
        2.2,
        Paint()..color = const Color(0xFF00F5FF),
      );
      canvas.drawCircle(Offset(px, midY), 1.0, Paint()..color = Colors.white);
    }

    // 3. High-Voltage Running Edge Light-Ribbons
    final ribbonGlowCyan = Paint()
      ..color = const Color(0xFF00F5FF)
      ..strokeWidth = 4.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2.5);
    final ribbonCoreWhite = Paint()
      ..color = Colors.white
      ..strokeWidth = 1.5;

    // Top Boundary Light Ribbon
    canvas.drawLine(
      Offset(startX, topRoadwayY),
      Offset(startX + trackLength, topRoadwayY),
      ribbonGlowCyan,
    );
    canvas.drawLine(
      Offset(startX, topRoadwayY),
      Offset(startX + trackLength, topRoadwayY),
      ribbonCoreWhite,
    );

    // Bottom Boundary Light Ribbon
    canvas.drawLine(
      Offset(startX, frontCurbY),
      Offset(startX + trackLength, frontCurbY),
      ribbonGlowCyan,
    );
    canvas.drawLine(
      Offset(startX, frontCurbY),
      Offset(startX + trackLength, frontCurbY),
      ribbonCoreWhite,
    );

    // 4. Central High-Speed Quantum Light Stream & Speed Chevrons (>>>)
    final centralStream = Paint()
      ..color = const Color(0xFFFF007F).withValues(alpha: 0.8)
      ..strokeWidth = 3.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
    canvas.drawLine(
      Offset(startX, midY),
      Offset(startX + trackLength, midY),
      centralStream,
    );
    canvas.drawLine(
      Offset(startX, midY),
      Offset(startX + trackLength, midY),
      Paint()
        ..color = Colors.white
        ..strokeWidth = 1.0,
    );

    // Glowing Neon Magenta Chevrons & Spark Nodes along Center
    final chevronPaint = Paint()
      ..color = const Color(0xFFFF007F)
      ..strokeWidth = 2.2
      ..strokeCap = StrokeCap.round;
    for (double cx = startX + 30; cx < startX + trackLength; cx += 50) {
      canvas.drawLine(Offset(cx - 7, midY - 6), Offset(cx, midY), chevronPaint);
      canvas.drawLine(Offset(cx, midY), Offset(cx - 7, midY + 6), chevronPaint);
      // Kinetic Particle Spark
      canvas.drawCircle(
        Offset(cx + 12, midY),
        1.5,
        Paint()..color = Colors.white,
      );
    }

    // 5. Holographic Overhead Speed Arches (TRON Speed Gates every 220px)
    final archPaintCyan = Paint()
      ..color = const Color(0xFF00F5FF)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
    final archPaintWhite = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;

    for (double ax = startX + 90; ax < startX + trackLength; ax += 220) {
      // Upright Pillar Left
      canvas.drawLine(
        Offset(ax - 12, frontCurbY),
        Offset(ax - 12, topRoadwayY - 45),
        archPaintCyan,
      );
      canvas.drawLine(
        Offset(ax - 12, frontCurbY),
        Offset(ax - 12, topRoadwayY - 45),
        archPaintWhite,
      );
      // Angled Top Header Bar
      canvas.drawLine(
        Offset(ax - 12, topRoadwayY - 45),
        Offset(ax + 24, topRoadwayY - 45),
        archPaintCyan,
      );
      canvas.drawLine(
        Offset(ax - 12, topRoadwayY - 45),
        Offset(ax + 24, topRoadwayY - 45),
        archPaintWhite,
      );
      // Glowing Speed Tag
      canvas.drawCircle(
        Offset(ax - 12, topRoadwayY - 45),
        3.0,
        Paint()..color = const Color(0xFFFF007F),
      );
      canvas.drawCircle(
        Offset(ax + 24, topRoadwayY - 45),
        3.0,
        Paint()..color = const Color(0xFF00F5FF),
      );
    }

    // 6. 3D Front Drop Face: Digital Void Abyss with Laser Grid & Floating Vector Blocks
    final wallHeight = AppConstants.virtualHeight - frontCurbY;
    final wallRect = Rect.fromLTWH(startX, frontCurbY, trackLength, wallHeight);
    canvas.drawRect(wallRect, Paint()..color = const Color(0xFF000206));

    // Vertical Cyan Laser Grid Dropping into the Void
    final laserDropPaint = Paint()
      ..color = const Color(0xFF00F5FF).withValues(alpha: 0.35)
      ..strokeWidth = 1.2;
    for (double lx = startX; lx < startX + trackLength; lx += 32) {
      canvas.drawLine(
        Offset(lx, frontCurbY),
        Offset(lx, AppConstants.virtualHeight),
        laserDropPaint,
      );
    }
    // Horizontal Scanlines
    final dropScanPaint = Paint()
      ..color = const Color(0xFF00F5FF).withValues(alpha: 0.15)
      ..strokeWidth = 1.0;
    for (
      double ly = frontCurbY + 12;
      ly < AppConstants.virtualHeight;
      ly += 16
    ) {
      canvas.drawLine(
        Offset(startX, ly),
        Offset(startX + trackLength, ly),
        dropScanPaint,
      );
    }

    // Floating 3D Wireframe Data Cubes in the abyss (every 140px)
    for (double bx = startX + 45; bx < startX + trackLength; bx += 140) {
      final cubeY = frontCurbY + 35.0;
      final cubeRect = Rect.fromCenter(
        center: Offset(bx, cubeY),
        width: 22,
        height: 22,
      );
      canvas.drawRect(
        cubeRect,
        Paint()
          ..color = const Color(0xFFFF007F).withValues(alpha: 0.12)
          ..style = PaintingStyle.fill,
      );
      canvas.drawRect(
        cubeRect,
        Paint()
          ..color = const Color(0xFFFF007F).withValues(alpha: 0.75)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1.4,
      );
      canvas.drawLine(
        cubeRect.topLeft,
        cubeRect.bottomRight,
        Paint()..color = const Color(0xFFFF007F).withValues(alpha: 0.5),
      );
      canvas.drawLine(
        cubeRect.topRight,
        cubeRect.bottomLeft,
        Paint()..color = const Color(0xFFFF007F).withValues(alpha: 0.5),
      );
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

      case SectorBiome.cyberShinto:
        // Map 2: Sacred Lacquered Bridge Floor, Inscribed Talismans & Crimson Blood Seals
        final plankPaint = Paint()
          ..color = const Color(0xFF2A030E)
          ..strokeWidth = 1.4;
        for (double x = startX + 16; x < startX + trackLength; x += 32) {
          canvas.drawLine(
            Offset(x, topRoadwayY),
            Offset(x, frontCurbY),
            plankPaint,
          );
        }
        // Glowing Blood Red Central Conduit & Sacred Gold Magatama Seals
        final bloodConduit = Paint()
          ..color = const Color(0xFFFF003C).withValues(alpha: 0.8)
          ..strokeWidth = 2.0
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
        final midYShinto = (topRoadwayY + frontCurbY) / 2;
        canvas.drawLine(
          Offset(startX, midYShinto),
          Offset(startX + trackLength, midYShinto),
          bloodConduit,
        );
        final goldSealPaint = Paint()..color = const Color(0xFFFFD700);
        for (double x = startX + 48; x < startX + trackLength; x += 96) {
          canvas.drawCircle(Offset(x, midYShinto), 3.2, goldSealPaint);
        }
        break;

      case SectorBiome.neoNebula:
        // Map 3: Maglev Linear Induction Guidance Strip & Speed Boost Chevrons
        final maglevStrip = Paint()
          ..color = const Color(0xFF00F5FF).withValues(alpha: 0.8)
          ..strokeWidth = 2.5
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
        final midYNeo = (topRoadwayY + frontCurbY) / 2;
        canvas.drawLine(
          Offset(startX, midYNeo),
          Offset(startX + trackLength, midYNeo),
          maglevStrip,
        );
        canvas.drawLine(
          Offset(startX, midYNeo),
          Offset(startX + trackLength, midYNeo),
          Paint()
            ..color = Colors.white
            ..strokeWidth = 1.0,
        );

        // Glowing Velocity Chevrons (>>>)
        final chevronP = Paint()
          ..color = const Color(0xFFFF007F).withValues(alpha: 0.75)
          ..strokeWidth = 2.0
          ..strokeCap = StrokeCap.round;
        for (double x = startX + 30; x < startX + trackLength; x += 55) {
          canvas.drawLine(
            Offset(x - 6, midYNeo - 5),
            Offset(x, midYNeo),
            chevronP,
          );
          canvas.drawLine(
            Offset(x, midYNeo),
            Offset(x - 6, midYNeo + 5),
            chevronP,
          );
        }
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
    final Color chasmWallColor;
    final Color chasmEdgeColor;
    if (biome == SectorBiome.cyberShinto) {
      chasmWallColor = const Color(0xFF160209);
      chasmEdgeColor = const Color(0xFFFF003C);
    } else if (biome == SectorBiome.neoNebula) {
      chasmWallColor = const Color(0xFF040710);
      chasmEdgeColor = const Color(0xFF00F5FF);
    } else {
      chasmWallColor = const Color(0xFF04060A);
      chasmEdgeColor = const Color(0xFF1E2838);
    }

    final chasmPaint = Paint()
      ..color = chasmWallColor
      ..style = PaintingStyle.fill;
    canvas.drawPath(leftWall, chasmPaint);

    // Left chasm edge lighting
    canvas.drawLine(
      Offset(pitStart, topRoadwayY),
      Offset(pitStart, AppConstants.virtualHeight),
      Paint()
        ..color = chasmEdgeColor.withValues(alpha: 0.8)
        ..strokeWidth = 2.5,
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
        ..color = chasmEdgeColor.withValues(alpha: 0.8)
        ..strokeWidth = 2.5,
    );

    // Chasm internal details
    if (biome == SectorBiome.cyberShinto) {
      // Broken lacquered timber bridge ends and severed sacred ropes
      final timberBreak = Paint()..color = const Color(0xFFFFD700);
      canvas.drawCircle(Offset(pitStart + 4, frontCurbY + 4), 2.5, timberBreak);
      canvas.drawCircle(Offset(pitEnd - 4, frontCurbY + 4), 2.5, timberBreak);
      // Severed sacred braided ropes hanging down into abyss
      final ropeP = Paint()
        ..color = const Color(0xFFFF003C)
        ..strokeWidth = 2.0;
      canvas.drawLine(
        Offset(pitStart + 3, frontCurbY + 5),
        Offset(pitStart + 7, frontCurbY + 28),
        ropeP,
      );
      canvas.drawLine(
        Offset(pitEnd - 3, frontCurbY + 5),
        Offset(pitEnd - 7, frontCurbY + 28),
        ropeP,
      );
    } else if (biome == SectorBiome.neoNebula) {
      // High-voltage laser drop guides on vertical abyss walls
      final laserDrop = Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.8)
        ..strokeWidth = 2.0
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2);
      canvas.drawLine(
        Offset(pitStart + 6, topRoadwayY + 10),
        Offset(pitStart + 6, AppConstants.virtualHeight),
        laserDrop,
      );
      canvas.drawLine(
        Offset(pitEnd - 6, topRoadwayY + 10),
        Offset(pitEnd - 6, AppConstants.virtualHeight),
        laserDrop,
      );
      // High-speed optical data cable across the chasm span
      final cablePaint = Paint()
        ..color = const Color(0xFFFF007F).withValues(alpha: 0.7)
        ..strokeWidth = 2.0;
      final cableSagY = frontCurbY + 30.0;
      final cablePath = Path()
        ..moveTo(pitStart, frontCurbY + 8)
        ..quadraticBezierTo(
          (pitStart + pitEnd) / 2,
          cableSagY,
          pitEnd,
          frontCurbY + 8,
        );
      canvas.drawPath(cablePath, cablePaint);
    }

    // Bottom Chasm Hazards
    if (biome == SectorBiome.neoNebula) {
      // --- MAP 3: HIGH-VOLTAGE LASER GRID ABYSS ---
      final gridRect = Rect.fromLTWH(
        pitStart,
        AppConstants.virtualHeight - 32,
        pitEnd - pitStart,
        32,
      );
      final gridGlow = Paint()
        ..color = const Color(0xFF00F5FF).withValues(alpha: 0.75)
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 14);
      canvas.drawRect(gridRect, gridGlow);

      final gridCore = Paint()
        ..color = const Color(0xFF07152B)
        ..style = PaintingStyle.fill;
      canvas.drawRect(gridRect, gridCore);

      final laserBeam = Paint()
        ..color = const Color(0xFF00F5FF)
        ..strokeWidth = 3.0;
      canvas.drawLine(
        Offset(pitStart, AppConstants.virtualHeight - 16),
        Offset(pitEnd, AppConstants.virtualHeight - 16),
        laserBeam,
      );
      canvas.drawLine(
        Offset(pitStart, AppConstants.virtualHeight - 16),
        Offset(pitEnd, AppConstants.virtualHeight - 16),
        Paint()
          ..color = Colors.white
          ..strokeWidth = 1.0,
      );

      // Warning nodes
      final warnPaint = Paint()..color = const Color(0xFFFF007F);
      for (double bx = pitStart + 18; bx < pitEnd - 10; bx += 32) {
        canvas.drawCircle(
          Offset(bx, AppConstants.virtualHeight - 22),
          2.5,
          warnPaint,
        );
      }
    } else if (biome == SectorBiome.cyberShinto) {
      // --- MAP 2: GLITCHED BLOOD VOID ABYSS ---
      final abyssRect = Rect.fromLTWH(
        pitStart,
        AppConstants.virtualHeight - 35,
        pitEnd - pitStart,
        35,
      );
      canvas.drawRect(abyssRect, Paint()..color = const Color(0xFF100206));

      // Crimson data laser grid lines in abyss
      final gridPaint = Paint()
        ..color = const Color(0xFFFF003C).withValues(alpha: 0.8)
        ..strokeWidth = 2.0;
      canvas.drawLine(
        Offset(pitStart, AppConstants.virtualHeight - 16),
        Offset(pitEnd, AppConstants.virtualHeight - 16),
        gridPaint,
      );
      canvas.drawLine(
        Offset(pitStart, AppConstants.virtualHeight - 8),
        Offset(pitEnd, AppConstants.virtualHeight - 8),
        gridPaint,
      );
      // Floating golden spirit runes
      final runePaint = Paint()..color = const Color(0xFFFFD700);
      for (double rx = pitStart + 20; rx < pitEnd - 10; rx += 45) {
        canvas.drawCircle(
          Offset(rx, AppConstants.virtualHeight - 22),
          2.2,
          runePaint,
        );
      }
    } else if (biome == SectorBiome.toxicFoundry) {
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

  /// Draws 50m modular segment-specific architectural elements, side props, and pylons
  void _renderSegmentArchitecture(
    Canvas canvas,
    double length,
    double topRoadwayY1,
    double topRoadwayY2,
    double frontCurbY1,
    double frontCurbY2,
    double depth,
  ) {
    final accent = biome.primaryAccent;

    switch (segmentType) {
      case TrackSegmentType.straightNeonBoulevard:
        // Elegant curved Cyberpunk streetlamp posts at x = 120 and x = 380
        for (final lx in [120.0, 380.0]) {
          if (lx > length - 20) continue;
          final t = lx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          final mastPath = Path()
            ..moveTo(lx, curbY)
            ..lineTo(lx, curbY - 120.0)
            ..quadraticBezierTo(lx, curbY - 150.0, lx + 30.0, curbY - 150.0);
          canvas.drawPath(
            mastPath,
            Paint()
              ..color = const Color(0xFF263238)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 3.5,
          );
          canvas.drawCircle(
            Offset(lx + 30.0, curbY - 150.0),
            4.0,
            Paint()..color = accent,
          );
          final conePath = Path()
            ..moveTo(lx + 30.0, curbY - 150.0)
            ..lineTo(lx + 5.0, curbY)
            ..lineTo(lx + 55.0, curbY)
            ..close();
          canvas.drawPath(
            conePath,
            Paint()
              ..color = accent.withValues(alpha: 0.07)
              ..style = PaintingStyle.fill,
          );
        }
        break;

      case TrackSegmentType.gradualSlopeUp:
      case TrackSegmentType.steppedTerraceAscent:
        // Luminous upward incline arrows on roadway + hydraulic pistons on fascia
        final arrowPaint = Paint()
          ..color = accent.withValues(alpha: 0.6)
          ..strokeWidth = 2.5
          ..style = PaintingStyle.stroke;
        for (double ax = 80.0; ax < length - 60.0; ax += 100.0) {
          final t = ax / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          final arrow = Path()
            ..moveTo(ax, roadY + 6.0)
            ..lineTo(ax + 16.0, roadY)
            ..lineTo(ax, roadY - 6.0);
          canvas.drawPath(arrow, arrowPaint);
        }
        for (double px = 100.0; px < length - 80.0; px += 160.0) {
          final t = px / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawRect(
            Rect.fromLTWH(px, curbY + 28.0, 14.0, 60.0),
            Paint()..color = const Color(0xFF37474F),
          );
          canvas.drawRect(
            Rect.fromLTWH(px + 3.0, curbY + 50.0, 8.0, 50.0),
            Paint()..color = const Color(0xFF78909C),
          );
        }
        break;

      case TrackSegmentType.gradualSlopeDown:
      case TrackSegmentType.steppedTerraceDescent:
        // Amber caution descent chevrons on roadway + sway braces
        final descPaint = Paint()
          ..color = const Color(0xFFFFB300).withValues(alpha: 0.65)
          ..strokeWidth = 2.5
          ..style = PaintingStyle.stroke;
        for (double ax = 80.0; ax < length - 60.0; ax += 100.0) {
          final t = ax / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          final arrow = Path()
            ..moveTo(ax + 16.0, roadY - 6.0)
            ..lineTo(ax, roadY)
            ..lineTo(ax + 16.0, roadY + 6.0);
          canvas.drawPath(arrow, descPaint);
        }
        final bracePaint = Paint()
          ..color = const Color(0xFF212733)
          ..strokeWidth = 4.0;
        for (double bx = 60.0; bx < length - 100.0; bx += 140.0) {
          final t = bx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawLine(
            Offset(bx, curbY + 26),
            Offset(bx + 70, curbY + 96),
            bracePaint,
          );
          canvas.drawLine(
            Offset(bx + 70, curbY + 26),
            Offset(bx, curbY + 96),
            bracePaint,
          );
        }
        break;

      case TrackSegmentType.elevatedViaduct:
        // Giant cylindrical highway viaduct pillars with inspection lights
        for (final px in [110.0, 360.0]) {
          if (px > length - 40) continue;
          final t = px / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          final colRect = Rect.fromLTWH(
            px,
            curbY + 26.0,
            48.0,
            AppConstants.virtualHeight - (curbY + 26.0),
          );
          canvas.drawRect(colRect, Paint()..color = const Color(0xFF131822));
          canvas.drawRect(
            colRect,
            Paint()
              ..color = const Color(0xFF263238)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 2.0,
          );
          canvas.drawRect(
            Rect.fromLTWH(px - 10.0, curbY + 26.0, 68.0, 12.0),
            Paint()..color = const Color(0xFF37474F),
          );
          canvas.drawCircle(
            Offset(px + 24.0, curbY + 44.0),
            3.0,
            Paint()..color = const Color(0xFFFF1744),
          );
        }
        final railPaint = Paint()
          ..color = accent.withValues(alpha: 0.4)
          ..strokeWidth = 2.0;
        canvas.drawLine(
          Offset(0, topRoadwayY1 - 14),
          Offset(length, topRoadwayY2 - 14),
          railPaint,
        );
        for (double rx = 20.0; rx < length; rx += 40.0) {
          final t = rx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          canvas.drawLine(Offset(rx, ty), Offset(rx, ty - 14), railPaint);
        }
        break;

      case TrackSegmentType.sunkenExpressway:
        // Towering blast retaining walls along top edge with floodlights
        const wallH = 45.0;
        final wallPath = Path()
          ..moveTo(0, topRoadwayY1)
          ..lineTo(0, topRoadwayY1 - wallH)
          ..lineTo(length, topRoadwayY2 - wallH)
          ..lineTo(length, topRoadwayY2)
          ..close();
        canvas.drawPath(wallPath, Paint()..color = const Color(0xFF141923));
        canvas.drawPath(
          wallPath,
          Paint()
            ..color = const Color(0xFF2C384A)
            ..style = PaintingStyle.stroke
            ..strokeWidth = 1.5,
        );
        for (double wx = 80.0; wx < length; wx += 120.0) {
          final t = wx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          canvas.drawLine(
            Offset(wx, ty),
            Offset(wx, ty - wallH),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 2.0,
          );
          canvas.drawCircle(
            Offset(wx, ty - wallH + 8),
            3.5,
            Paint()..color = const Color(0xFFFFD54F),
          );
        }
        break;

      case TrackSegmentType.splitChasmOverpass:
        // Under-slung emergency steel bridge suspension framework
        final trussPaint = Paint()
          ..color = const Color(0xFF2A364F)
          ..strokeWidth = 2.5;
        for (double tx = 40.0; tx < length - 40.0; tx += 60.0) {
          final t1 = tx / length;
          final t2 = (tx + 30.0) / length;
          final cy1 = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t1 + 26.0;
          final cy2 = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t2 + 26.0;
          canvas.drawLine(
            Offset(tx, cy1),
            Offset(tx + 30.0, cy2 + 40.0),
            trussPaint,
          );
          canvas.drawLine(
            Offset(tx + 30.0, cy2 + 40.0),
            Offset(tx + 60.0, cy1),
            trussPaint,
          );
        }
        break;

      case TrackSegmentType.dualTierCatwalk:
      case TrackSegmentType.doubleDeckSkyway:
        // Continuous overhead service deck spanning the entire segment
        final deckY1 = topRoadwayY1 - 115.0;
        final deckY2 = topRoadwayY2 - 115.0;
        final skyDeckPath = Path()
          ..moveTo(0, deckY1)
          ..lineTo(length, deckY2)
          ..lineTo(length, deckY2 + 12.0)
          ..lineTo(0, deckY1 + 12.0)
          ..close();
        canvas.drawPath(skyDeckPath, Paint()..color = const Color(0xFF1E2838));
        canvas.drawPath(
          skyDeckPath,
          Paint()
            ..color = accent.withValues(alpha: 0.7)
            ..style = PaintingStyle.stroke
            ..strokeWidth = 1.8,
        );
        for (double ix = 60.0; ix < length; ix += 130.0) {
          final t = ix / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final uy = deckY1 + (deckY2 - deckY1) * t;
          canvas.drawLine(
            Offset(ix, ty),
            Offset(ix, uy + 12.0),
            Paint()
              ..color = const Color(0xFF263238)
              ..strokeWidth = 6.0,
          );
          canvas.drawCircle(
            Offset(ix, uy + 12.0),
            3.5,
            Paint()..color = accent,
          );
        }
        break;

      case TrackSegmentType.industrialTrussArchway:
        // 2 Massive Triangular Overhead Industrial Steel Trusses
        for (final ax in [110.0, 360.0]) {
          if (ax > length - 50) continue;
          final t = ax / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          const archH = 140.0;
          const archSpan = 70.0;
          canvas.drawLine(
            Offset(ax - archSpan / 2, ty),
            Offset(ax, ty - archH),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 4.0,
          );
          canvas.drawLine(
            Offset(ax + archSpan / 2, ty),
            Offset(ax, ty - archH),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 4.0,
          );
          canvas.drawLine(
            Offset(ax - archSpan / 3, ty - archH * 0.45),
            Offset(ax + archSpan / 3, ty - archH * 0.45),
            Paint()
              ..color = const Color(0xFF455A64)
              ..strokeWidth = 2.5,
          );
          canvas.drawCircle(
            Offset(ax, ty - archH),
            4.5,
            Paint()..color = const Color(0xFFFFB300),
          );
        }
        break;

      case TrackSegmentType.cantileveredSuspensionBridge:
        // Giant A-Frame Suspension Tower at mid length with radiating stay cables
        final midX = length * 0.5;
        const tMid = 0.5;
        final midRoadY = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * tMid;
        final towerApexY = midRoadY - 180.0;
        final towerPaint = Paint()
          ..color = const Color(0xFF1E2838)
          ..strokeWidth = 7.0;
        canvas.drawLine(
          Offset(midX - 35.0, midRoadY),
          Offset(midX, towerApexY),
          towerPaint,
        );
        canvas.drawLine(
          Offset(midX + 35.0, midRoadY),
          Offset(midX, towerApexY),
          towerPaint,
        );
        canvas.drawCircle(
          Offset(midX, towerApexY),
          5.0,
          Paint()..color = const Color(0xFFFF1744),
        );
        final cablePaint = Paint()
          ..color = accent.withValues(alpha: 0.55)
          ..strokeWidth = 1.5;
        for (final cx in [40.0, 110.0, 180.0, 320.0, 390.0, 460.0]) {
          final tc = cx / length;
          final cy = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * tc;
          canvas.drawLine(
            Offset(midX, towerApexY + 15.0),
            Offset(cx, cy),
            cablePaint,
          );
        }
        break;

      case TrackSegmentType.maglevConduitRun:
        // Maglev linear induction levitation rails flanking roadway with pulsing coil rings
        final railP = Paint()
          ..color = const Color(0xFF7C4DFF).withValues(alpha: 0.8)
          ..strokeWidth = 3.0;
        canvas.drawLine(
          Offset(0, topRoadwayY1 - 6),
          Offset(length, topRoadwayY2 - 6),
          railP,
        );
        canvas.drawLine(
          Offset(0, frontCurbY1 + 6),
          Offset(length, frontCurbY2 + 6),
          railP,
        );
        final coilP = Paint()..color = const Color(0xFF00E5FF);
        for (double mx = 16.0; mx < length; mx += 32.0) {
          final t = mx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t - 6;
          final fy = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t + 6;
          canvas.drawCircle(Offset(mx, ty), 2.5, coilP);
          canvas.drawCircle(Offset(mx, fy), 2.5, coilP);
        }
        break;

      case TrackSegmentType.laserGateCorridor:
        // Security Scanner Portals with vertical scanning laser ribbons
        for (final gx in [140.0, 360.0]) {
          if (gx > length - 40) continue;
          final t = gx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final fy = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawLine(
            Offset(gx, ty),
            Offset(gx, ty - 130.0),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 4.0,
          );
          canvas.drawLine(
            Offset(gx, ty - 130.0),
            Offset(gx + 40.0, ty - 130.0),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 4.0,
          );
          final laserP = Paint()
            ..color = const Color(0xFFFF1744).withValues(alpha: 0.35)
            ..strokeWidth = 2.0;
          canvas.drawLine(
            Offset(gx + 20.0, ty - 130.0),
            Offset(gx + 20.0, fy),
            laserP,
          );
          canvas.drawCircle(
            Offset(gx + 20.0, ty - 130.0),
            3.0,
            Paint()..color = const Color(0xFFFF1744),
          );
        }
        break;

      case TrackSegmentType.cyberShrineColonnade:
        // Torii Gate Inspired Cyber Colonnade Columns
        for (final cx in [120.0, 370.0]) {
          if (cx > length - 50) continue;
          final t = cx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final pCol = Paint()
            ..color = const Color(0xFFFF003C)
            ..strokeWidth = 5.0;
          canvas.drawLine(Offset(cx - 20, ty), Offset(cx - 20, ty - 120), pCol);
          canvas.drawLine(Offset(cx + 20, ty), Offset(cx + 20, ty - 120), pCol);
          canvas.drawLine(
            Offset(cx - 32, ty - 110),
            Offset(cx + 32, ty - 110),
            Paint()
              ..color = const Color(0xFFFFD700)
              ..strokeWidth = 3.5,
          );
          canvas.drawCircle(
            Offset(cx, ty - 110),
            4.0,
            Paint()..color = const Color(0xFFFFD700),
          );
        }
        break;

      case TrackSegmentType.toxicPipeAqueduct:
      case TrackSegmentType.cyberSewerCulvert:
        // Giant Industrial Chemical Delivery Pipes running along fascia
        const pipe1Y = 35.0;
        const pipe2Y = 62.0;
        for (double x = 0; x < length; x += 30.0) {
          final t = x / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawCircle(
            Offset(x, curbY + pipe1Y),
            6.0,
            Paint()..color = const Color(0xFF76FF03),
          );
          canvas.drawCircle(
            Offset(x, curbY + pipe1Y),
            3.5,
            Paint()..color = const Color(0xFF33691E),
          );
          canvas.drawCircle(
            Offset(x, curbY + pipe2Y),
            8.0,
            Paint()..color = const Color(0xFF455A64),
          );
          canvas.drawCircle(
            Offset(x, curbY + pipe2Y),
            5.0,
            Paint()..color = const Color(0xFF263238),
          );
        }
        for (final vx in [160.0, 340.0]) {
          final t = vx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawCircle(
            Offset(vx, curbY + pipe1Y),
            10.0,
            Paint()
              ..color = const Color(0xFFFFB300)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 2.0,
          );
          canvas.drawLine(
            Offset(vx - 10, curbY + pipe1Y),
            Offset(vx + 10, curbY + pipe1Y),
            Paint()
              ..color = const Color(0xFFFFB300)
              ..strokeWidth = 1.5,
          );
        }
        break;

      case TrackSegmentType.wideHighSpeedHighway:
      case TrackSegmentType.speedBoosterRunway:
        // Triple Luminous Speed Chevrons Embedded into Roadway Surface
        final chevPaint = Paint()
          ..color = accent.withValues(alpha: 0.8)
          ..strokeWidth = 3.5
          ..style = PaintingStyle.stroke;
        for (double cx = 100.0; cx < length - 80.0; cx += 110.0) {
          final t = cx / length;
          final my =
              (topRoadwayY1 +
                  (topRoadwayY2 - topRoadwayY1) * t +
                  frontCurbY1 +
                  (frontCurbY2 - frontCurbY1) * t) *
              0.5;
          for (int k = 0; k < 3; k++) {
            final ox = cx + (k * 14.0);
            final chev = Path()
              ..moveTo(ox, my - 9.0)
              ..lineTo(ox + 10.0, my)
              ..lineTo(ox, my + 9.0);
            canvas.drawPath(chev, chevPaint);
          }
        }
        break;

      case TrackSegmentType.narrowPrecisionPass:
        // High-contrast hazardous safety barrier rails on both sides
        final barrierPaint = Paint()
          ..color = const Color(0xFFFF1744).withValues(alpha: 0.75)
          ..strokeWidth = 3.0;
        canvas.drawLine(
          Offset(0, topRoadwayY1 - 8),
          Offset(length, topRoadwayY2 - 8),
          barrierPaint,
        );
        canvas.drawLine(
          Offset(0, frontCurbY1 - 2),
          Offset(length, frontCurbY2 - 2),
          barrierPaint,
        );
        for (double bx = 30.0; bx < length; bx += 60.0) {
          final t = bx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t - 8;
          canvas.drawCircle(
            Offset(bx, ty),
            3.0,
            Paint()..color = const Color(0xFFFFD700),
          );
        }
        break;

      case TrackSegmentType.bunkerCheckpoint:
        // Massive Military Bulkhead Blast Gate Framing
        final bx = length * 0.5;
        final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * 0.5;
        final bunkerP = Paint()
          ..color = const Color(0xFF212121)
          ..strokeWidth = 8.0;
        canvas.drawLine(
          Offset(bx - 30, ty),
          Offset(bx - 30, ty - 150),
          bunkerP,
        );
        canvas.drawLine(
          Offset(bx + 30, ty),
          Offset(bx + 30, ty - 150),
          bunkerP,
        );
        canvas.drawLine(
          Offset(bx - 40, ty - 145),
          Offset(bx + 40, ty - 145),
          Paint()
            ..color = const Color(0xFF37474F)
            ..strokeWidth = 12.0,
        );
        canvas.drawRect(
          Rect.fromLTWH(bx - 36, ty - 142, 72, 6),
          Paint()..color = const Color(0xFFFFB300),
        );
        break;

      case TrackSegmentType.substationPylonGrid:
        // Electrical Transformer Pylons with High-Voltage Discs
        for (final px in [140.0, 360.0]) {
          if (px > length - 40) continue;
          final t = px / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final pylonP = Paint()
            ..color = const Color(0xFF455A64)
            ..strokeWidth = 4.0;
          canvas.drawLine(Offset(px, ty), Offset(px, ty - 135), pylonP);
          canvas.drawLine(
            Offset(px - 25, ty - 110),
            Offset(px + 25, ty - 110),
            pylonP,
          );
          for (final ix in [px - 20, px + 20]) {
            canvas.drawCircle(
              Offset(ix, ty - 100),
              4.0,
              Paint()..color = const Color(0xFF00E5FF),
            );
          }
        }
        break;

      case TrackSegmentType.droneGantryPlatform:
      case TrackSegmentType.monorailTrackCrossing:
        // Overhead Monorail / Drone Transit Tube crossing overhead diagonally
        final railPath = Path()
          ..moveTo(0, roofY + 30.0)
          ..lineTo(length, roofY + 60.0);
        canvas.drawPath(
          railPath,
          Paint()
            ..color = const Color(0xFF00E5FF).withValues(alpha: 0.6)
            ..style = PaintingStyle.stroke
            ..strokeWidth = 5.0,
        );
        canvas.drawPath(
          railPath,
          Paint()
            ..color = Colors.white
            ..style = PaintingStyle.stroke
            ..strokeWidth = 1.5,
        );
        break;

      case TrackSegmentType.holographicBillboardRow:
        // 2 Floating 3D Holographic Neon Advertisements
        for (final bx in [130.0, 360.0]) {
          if (bx > length - 70) continue;
          final t = bx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final boardRect = Rect.fromLTWH(bx - 40, ty - 130, 80, 42);
          canvas.drawRect(
            boardRect,
            Paint()..color = accent.withValues(alpha: 0.15),
          );
          canvas.drawRect(
            boardRect,
            Paint()
              ..color = accent.withValues(alpha: 0.8)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 1.8,
          );
          canvas.drawLine(
            Offset(bx, ty),
            Offset(bx, ty - 88),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 2.5,
          );
          canvas.drawCircle(Offset(bx, ty - 88), 3.0, Paint()..color = accent);
        }
        break;

      case TrackSegmentType.curvedOverpassSlightLeft:
      case TrackSegmentType.curvedOverpassSlightRight:
        // Banked Perspective Curve Guide Lines
        final curveSign =
            segmentType == TrackSegmentType.curvedOverpassSlightLeft
            ? -1.0
            : 1.0;
        final curvePaint = Paint()
          ..color = accent.withValues(alpha: 0.3)
          ..strokeWidth = 1.5;
        for (double cx = 30.0; cx < length; cx += 50.0) {
          final t = cx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final fy = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawLine(
            Offset(cx, ty),
            Offset(cx + curveSign * 18.0, fy),
            curvePaint,
          );
        }
        break;

      case TrackSegmentType.meshGrateWalkway:
        // Diamond Perforated Steel Grate Texture along the track
        final grateP = Paint()
          ..color = Colors.white.withValues(alpha: 0.10)
          ..strokeWidth = 1.0;
        for (double gx = 10.0; gx < length; gx += 20.0) {
          final t = gx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final fy = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawLine(Offset(gx, ty), Offset(gx + 12.0, fy), grateP);
          canvas.drawLine(Offset(gx + 12.0, ty), Offset(gx, fy), grateP);
        }
        break;

      case TrackSegmentType.rooftopTurbineExhaust:
        // 2 Massive Spinning Ventilation Exhaust Fans in Drop Wall
        for (final fx in [140.0, 360.0]) {
          if (fx > length - 40) continue;
          final t = fx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          final fanCenter = Offset(fx, curbY + 54.0);
          canvas.drawCircle(
            fanCenter,
            20.0,
            Paint()..color = const Color(0xFF10151E),
          );
          canvas.drawCircle(
            fanCenter,
            20.0,
            Paint()
              ..color = const Color(0xFF37474F)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 2.0,
          );
          final bladeP = Paint()
            ..color = const Color(0xFF78909C)
            ..strokeWidth = 2.0;
          canvas.drawLine(
            Offset(fx - 15, curbY + 54),
            Offset(fx + 15, curbY + 54),
            bladeP,
          );
          canvas.drawLine(
            Offset(fx, curbY + 39),
            Offset(fx, curbY + 69),
            bladeP,
          );
          canvas.drawCircle(
            fanCenter,
            4.0,
            Paint()..color = const Color(0xFFFFB300),
          );
        }
        break;

      case TrackSegmentType.quantumRiftSplit:
        // Glowing Quantum Energy Fissures on Asphalt
        final riftPaint = Paint()
          ..color = const Color(0xFFFF007F).withValues(alpha: 0.75)
          ..strokeWidth = 2.0;
        for (double rx = 80.0; rx < length - 60.0; rx += 120.0) {
          final t = rx / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          final fy = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          final my = (ty + fy) * 0.5;
          final riftPath = Path()
            ..moveTo(rx, my)
            ..lineTo(rx + 15, my - 6)
            ..lineTo(rx + 30, my + 4)
            ..lineTo(rx + 45, my - 2);
          canvas.drawPath(riftPath, riftPaint);
        }
        break;

      case TrackSegmentType.reinforcedBarricadeSector:
        // Concrete Jersey Barriers with Reflective Hazard Tape
        for (final bx in [80.0, 240.0, 400.0]) {
          if (bx > length - 50) continue;
          final t = bx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          final barRect = Rect.fromLTWH(bx, curbY - 14.0, 36.0, 14.0);
          canvas.drawRect(barRect, Paint()..color = const Color(0xFF37474F));
          canvas.drawRect(
            Rect.fromLTWH(bx + 6.0, curbY - 10.0, 24.0, 6.0),
            Paint()..color = const Color(0xFFFFB300),
          );
        }
        break;

      case TrackSegmentType.titanArenaPlateau:
        // Milestone Cyber Titan Arena: Heavy Floodlight Arena Beacons
        for (final ax in [20.0, length - 20.0]) {
          final t = ax / length;
          final ty = topRoadwayY1 + (topRoadwayY2 - topRoadwayY1) * t;
          canvas.drawLine(
            Offset(ax, ty),
            Offset(ax, ty - 160.0),
            Paint()
              ..color = const Color(0xFF263238)
              ..strokeWidth = 5.0,
          );
          canvas.drawRect(
            Rect.fromLTWH(ax - 10, ty - 165, 20, 10),
            Paint()..color = const Color(0xFF37474F),
          );
          canvas.drawCircle(
            Offset(ax, ty - 160),
            4.0,
            Paint()..color = const Color(0xFFFFD54F),
          );
        }
        break;
    }
  }

  /// Draws Distinctive Cyberpunk Environment Theme Props and Architecture
  void _renderEnvironmentThemeProps(
    Canvas canvas,
    double length,
    double topRoadwayY1,
    double topRoadwayY2,
    double frontCurbY1,
    double frontCurbY2,
    double depth,
  ) {
    final accent = biome.primaryAccent;

    switch (environmentTheme) {
      case CyberEnvironmentTheme.cyberAlley:
        // 1. Cyber Vending Machine at x = 85
        if (length > 130) {
          const vx = 85.0;
          final t = vx / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          const vWidth = 26.0;
          const vHeight = 44.0;
          final vendRect = Rect.fromLTWH(
            vx - vWidth / 2,
            roadY - vHeight,
            vWidth,
            vHeight,
          );
          canvas.drawRRect(
            RRect.fromRectAndRadius(vendRect, const Radius.circular(3.0)),
            Paint()..color = const Color(0xFF101720),
          );
          // Neon display panels & buttons
          final buttonPaint = Paint()
            ..color = const Color(0xFF00E5FF).withValues(alpha: 0.8);
          for (double by = roadY - vHeight + 6; by < roadY - 14; by += 8) {
            canvas.drawRect(Rect.fromLTWH(vx - 9, by, 18, 4), buttonPaint);
          }
          // Dispensing slot with neon glow
          canvas.drawRect(
            Rect.fromLTWH(vx - 8, roadY - 8, 16, 5),
            Paint()..color = const Color(0xFFFF007F),
          );
        }

        // 2. Hanging Draped Power Cables
        final cablePath = Path()
          ..moveTo(10, roofY + 12)
          ..quadraticBezierTo(
            length * 0.5,
            roofY + 55,
            length - 10,
            roofY + 16,
          );
        canvas.drawPath(
          cablePath,
          Paint()
            ..color = const Color(0xFF1C2430)
            ..style = PaintingStyle.stroke
            ..strokeWidth = 2.2,
        );

        // 3. Vertical Neon Shop Sign "ネオ BAR" at x = 360
        if (length > 400) {
          const sx = 360.0;
          final t = sx / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          final signRect = Rect.fromLTWH(sx - 12, roadY - 110, 24, 60);
          canvas.drawRRect(
            RRect.fromRectAndRadius(signRect, const Radius.circular(4.0)),
            Paint()..color = const Color(0xFF160A1C),
          );
          canvas.drawRRect(
            RRect.fromRectAndRadius(signRect, const Radius.circular(4.0)),
            Paint()
              ..color = const Color(0xFFFF007F).withValues(alpha: 0.75)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 1.5,
          );
          // Vertical neon bar glyphs
          final neonPaint = Paint()..color = const Color(0xFFFF007F);
          canvas.drawLine(
            Offset(sx, roadY - 100),
            Offset(sx, roadY - 90),
            neonPaint,
          );
          canvas.drawCircle(Offset(sx, roadY - 82), 3, neonPaint);
          canvas.drawLine(
            Offset(sx, roadY - 74),
            Offset(sx, roadY - 60),
            neonPaint,
          );
        }
        break;

      case CyberEnvironmentTheme.rooftop:
        // 1. Industrial HVAC Air Conditioner with 4-Blade Fan at x = 80
        if (length > 120) {
          const acX = 80.0;
          final t = acX / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          final acRect = Rect.fromLTWH(acX - 18, roadY - 32, 36, 32);
          canvas.drawRect(acRect, Paint()..color = const Color(0xFF263238));
          canvas.drawCircle(
            Offset(acX, roadY - 16),
            11,
            Paint()..color = const Color(0xFF10171D),
          );
          final bladeP = Paint()
            ..color = const Color(0xFF78909C)
            ..strokeWidth = 2.0;
          canvas.drawLine(
            Offset(acX - 9, roadY - 16),
            Offset(acX + 9, roadY - 16),
            bladeP,
          );
          canvas.drawLine(
            Offset(acX, roadY - 25),
            Offset(acX, roadY - 7),
            bladeP,
          );
        }

        // 2. Parabolic Satellite Communication Dish at x = 270
        if (length > 310) {
          const satX = 270.0;
          final t = satX / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          // Mast pole
          canvas.drawLine(
            Offset(satX, roadY),
            Offset(satX, roadY - 50),
            Paint()
              ..color = const Color(0xFF37474F)
              ..strokeWidth = 3.0,
          );
          // Dish arc
          final dishPath = Path()
            ..moveTo(satX - 18, roadY - 62)
            ..quadraticBezierTo(satX, roadY - 46, satX + 18, roadY - 62);
          canvas.drawPath(
            dishPath,
            Paint()
              ..color = const Color(0xFFCFD8DC)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 3.5,
          );
          // Pulsing transmitter node
          canvas.drawCircle(
            Offset(satX, roadY - 60),
            3.5,
            Paint()..color = const Color(0xFFFF1744),
          );
        }

        // 3. Rooftop Water Reservoir Tank on Stilts at x = 410
        if (length > 440) {
          const wx = 410.0;
          final t = wx / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          // Stilt legs
          final legP = Paint()
            ..color = const Color(0xFF263238)
            ..strokeWidth = 2.2;
          canvas.drawLine(
            Offset(wx - 14, roadY),
            Offset(wx - 10, roadY - 35),
            legP,
          );
          canvas.drawLine(
            Offset(wx + 14, roadY),
            Offset(wx + 10, roadY - 35),
            legP,
          );
          // Wood/metal tank cylinder
          final tankRect = Rect.fromLTWH(wx - 16, roadY - 75, 32, 40);
          canvas.drawRect(tankRect, Paint()..color = const Color(0xFF3E2723));
          // Conical roof
          final roofP = Path()
            ..moveTo(wx - 18, roadY - 75)
            ..lineTo(wx, roadY - 90)
            ..lineTo(wx + 18, roadY - 75)
            ..close();
          canvas.drawPath(roofP, Paint()..color = const Color(0xFF212121));
        }
        break;

      case CyberEnvironmentTheme.undergroundTunnel:
        // 1. Heavy Dual Conduit Pipe Bundles Under Roof
        final pipe1Y = roofY + 6.0;
        final pipe2Y = roofY + 14.0;
        canvas.drawLine(
          Offset(0, pipe1Y),
          Offset(length, pipe1Y),
          Paint()
            ..color = const Color(0xFF37474F)
            ..strokeWidth = 4.5,
        );
        canvas.drawLine(
          Offset(0, pipe2Y),
          Offset(length, pipe2Y),
          Paint()
            ..color = const Color(0xFF263238)
            ..strokeWidth = 3.5,
        );

        // 2. Yellow Industrial Tunnel Bulkhead Light Fixtures
        for (double lx = 60.0; lx < length; lx += 140.0) {
          canvas.drawRRect(
            RRect.fromRectAndRadius(
              Rect.fromLTWH(lx - 8, roofY + 16, 16, 8),
              const Radius.circular(2),
            ),
            Paint()..color = const Color(0xFFFFB300),
          );
          // Downward ambient light cone
          final cone = Path()
            ..moveTo(lx - 6, roofY + 24)
            ..lineTo(lx - 35, roofY + 110)
            ..lineTo(lx + 35, roofY + 110)
            ..lineTo(lx + 6, roofY + 24)
            ..close();
          canvas.drawPath(
            cone,
            Paint()
              ..color = const Color(0xFFFFB300).withValues(alpha: 0.05)
              ..style = PaintingStyle.fill,
          );
        }

        // 3. Steam vent grating along curb
        for (double vx = 160.0; vx < length; vx += 240.0) {
          final t = vx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawRect(
            Rect.fromLTWH(vx - 12, curbY + 4, 24, 6),
            Paint()..color = const Color(0xFF10171D),
          );
          canvas.drawCircle(
            Offset(vx, curbY - 10),
            8.0,
            Paint()
              ..color = Colors.white.withValues(alpha: 0.12)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6),
          );
        }
        break;

      case CyberEnvironmentTheme.hologramDistrict:
        // 1. Giant Floating Holographic Billboard Cube at x = 230
        if (length > 280) {
          const hx = 230.0;
          final t = hx / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          final hRect = Rect.fromCenter(
            center: Offset(hx, roadY - 120),
            width: 90,
            height: 50,
          );
          // Hologram translucent glow
          canvas.drawRect(
            hRect,
            Paint()..color = accent.withValues(alpha: 0.12),
          );
          canvas.drawRect(
            hRect,
            Paint()
              ..color = accent.withValues(alpha: 0.7)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 1.5,
          );
          // Wireframe diamond inside
          final dia = Path()
            ..moveTo(hx, roadY - 140)
            ..lineTo(hx + 28, roadY - 120)
            ..lineTo(hx, roadY - 100)
            ..lineTo(hx - 28, roadY - 120)
            ..close();
          canvas.drawPath(
            dia,
            Paint()
              ..color = Colors.white.withValues(alpha: 0.65)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 1.2,
          );
        }

        // 2. Floating Matrix Data Glyphs / Digital Particles
        final dotPaint = Paint()..color = accent.withValues(alpha: 0.4);
        for (double dx = 40.0; dx < length; dx += 70.0) {
          final t = dx / length;
          final roadY =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          canvas.drawCircle(Offset(dx, roadY - 65), 2.2, dotPaint);
          canvas.drawCircle(Offset(dx + 20, roadY - 85), 1.6, dotPaint);
          canvas.drawCircle(Offset(dx - 15, roadY - 105), 2.0, dotPaint);
        }
        break;

      case CyberEnvironmentTheme.skyBridge:
        // 1. Towering Suspension Bridge Pylon at Mid-Span
        final midX = length * 0.5;
        const tMid = 0.5;
        final midRoadY =
            (frontCurbY1 + (frontCurbY2 - frontCurbY1) * tMid) - depth * 0.5;
        final mastApexY = roofY - 20;
        final mastP = Paint()
          ..color = const Color(0xFF1A2332)
          ..strokeWidth = 8.0;
        canvas.drawLine(Offset(midX, midRoadY), Offset(midX, mastApexY), mastP);

        // Radiant Stay Cables
        final cableP = Paint()
          ..color = accent.withValues(alpha: 0.45)
          ..strokeWidth = 1.5;
        for (double cx = 30.0; cx < length; cx += 50.0) {
          final t = cx / length;
          final ry =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          canvas.drawLine(Offset(midX, mastApexY + 25), Offset(cx, ry), cableP);
        }

        // Distant city traffic far below
        final trafficP = Paint()
          ..color = const Color(0xFFFFD54F).withValues(alpha: 0.35);
        for (double tx = 20.0; tx < length; tx += 65.0) {
          canvas.drawCircle(
            Offset(tx, AppConstants.virtualHeight - 12),
            2.0,
            trafficP,
          );
        }
        break;

      case CyberEnvironmentTheme.darkSector:
        // 1. Atmospheric Deep Shadow Vignette
        final darkVignette = Rect.fromLTWH(
          0,
          roofY,
          length,
          AppConstants.virtualHeight - roofY,
        );
        canvas.drawRect(darkVignette, Paint()..color = const Color(0x66020408));

        // 2. Flashing Red/Blue Emergency Beacons atop Junction Boxes
        for (final bx in [110.0, 350.0]) {
          if (bx > length - 40) continue;
          final t = bx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawRect(
            Rect.fromLTWH(bx - 8, curbY + 6, 16, 22),
            Paint()..color = const Color(0xFF1A212B),
          );
          canvas.drawCircle(
            Offset(bx, curbY + 2),
            5.0,
            Paint()
              ..color = const Color(0xFFFF003C)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5),
          );
        }

        // 3. Electric Sparks on Broken Signs
        if (length > 250) {
          const sx = 240.0;
          final t = sx / length;
          final ry =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          final sparkP = Paint()
            ..color = const Color(0xFFFFD600)
            ..strokeWidth = 1.5;
          canvas.drawLine(
            Offset(sx - 4, ry - 60),
            Offset(sx + 2, ry - 66),
            sparkP,
          );
          canvas.drawLine(
            Offset(sx + 2, ry - 66),
            Offset(sx - 1, ry - 72),
            sparkP,
          );
        }
        break;

      case CyberEnvironmentTheme.industrialDistrict:
        // 1. Stacked Shipping Cargo Containers at x = 75 and x = 390
        for (final cx in [75.0, 390.0]) {
          if (cx > length - 45) continue;
          final t = cx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          final boxRect = Rect.fromLTWH(cx - 24, curbY + 8, 48, 32);
          canvas.drawRRect(
            RRect.fromRectAndRadius(boxRect, const Radius.circular(2)),
            Paint()..color = const Color(0xFF263238),
          );
          // Yellow stencil stripes
          final sP = Paint()
            ..color = const Color(0xFFFFB300)
            ..strokeWidth = 2.0;
          canvas.drawLine(
            Offset(cx - 18, curbY + 12),
            Offset(cx - 18, curbY + 36),
            sP,
          );
          canvas.drawLine(
            Offset(cx + 18, curbY + 12),
            Offset(cx + 18, curbY + 36),
            sP,
          );
        }

        // 2. Heavy Factory Exhaust Chimney at x = 220
        if (length > 260) {
          const fx = 220.0;
          final t = fx / length;
          final curbY = frontCurbY1 + (frontCurbY2 - frontCurbY1) * t;
          canvas.drawRect(
            Rect.fromLTWH(fx - 10, curbY + 28, 20, 80),
            Paint()..color = const Color(0xFF1E2832),
          );
          // Rungs
          final rungP = Paint()
            ..color = const Color(0xFF546E7A)
            ..strokeWidth = 1.8;
          for (double ry = curbY + 35; ry < curbY + 95; ry += 12) {
            canvas.drawLine(Offset(fx - 8, ry), Offset(fx + 8, ry), rungP);
          }
        }
        break;

      case CyberEnvironmentTheme.neonMarket:
        // 1. Hanging Cyber Lanterns with Glowing Vermilion/Magenta Cores
        for (final lx in [80.0, 240.0, 400.0]) {
          if (lx > length - 25) continue;
          final lanternP = Paint()..color = const Color(0xFFFF0055);
          canvas.drawLine(
            Offset(lx, roofY),
            Offset(lx, roofY + 35),
            Paint()
              ..color = const Color(0xFF263238)
              ..strokeWidth = 1.5,
          );
          canvas.drawRRect(
            RRect.fromRectAndRadius(
              Rect.fromCenter(
                center: Offset(lx, roofY + 44),
                width: 14,
                height: 18,
              ),
              const Radius.circular(4),
            ),
            lanternP,
          );
          canvas.drawCircle(
            Offset(lx, roofY + 44),
            9.0,
            Paint()
              ..color = const Color(0xFFFF0055).withValues(alpha: 0.35)
              ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5),
          );
        }

        // 2. Street Food Stall Counter at x = 160
        if (length > 200) {
          const fx = 160.0;
          final t = fx / length;
          final ry =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          // Counter base
          canvas.drawRect(
            Rect.fromLTWH(fx - 18, ry - 24, 36, 24),
            Paint()..color = const Color(0xFF1C1322),
          );
          // Awning tarp
          final tarp = Path()
            ..moveTo(fx - 22, ry - 34)
            ..lineTo(fx + 22, ry - 34)
            ..lineTo(fx + 18, ry - 24)
            ..lineTo(fx - 18, ry - 24)
            ..close();
          canvas.drawPath(tarp, Paint()..color = const Color(0xFFFF3D00));
        }
        break;

      case CyberEnvironmentTheme.futuristicHighway:
        // 1. Triple Glowing Neon Expressway Lane Markings
        final lane1P = Paint()
          ..color = accent.withValues(alpha: 0.4)
          ..strokeWidth = 2.0;
        final lane2P = Paint()
          ..color = Colors.white.withValues(alpha: 0.25)
          ..strokeWidth = 1.5;
        for (double lx = 20.0; lx < length; lx += 55.0) {
          final t = lx / length;
          final ry =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          canvas.drawLine(Offset(lx, ry - 4), Offset(lx + 24, ry - 4), lane1P);
          canvas.drawLine(
            Offset(lx + 10, ry + 4),
            Offset(lx + 34, ry + 4),
            lane2P,
          );
        }

        // 2. Overhead Cantilevered Electronic Highway Sign Gantry at x = 250
        if (length > 300) {
          const gx = 250.0;
          final t = gx / length;
          final ry =
              (frontCurbY1 + (frontCurbY2 - frontCurbY1) * t) - depth * 0.5;
          // Vertical mast
          canvas.drawLine(
            Offset(gx, ry),
            Offset(gx, ry - 145),
            Paint()
              ..color = const Color(0xFF263238)
              ..strokeWidth = 4.5,
          );
          // Overhead sign box
          final signRect = Rect.fromLTWH(gx - 45, ry - 140, 90, 26);
          canvas.drawRRect(
            RRect.fromRectAndRadius(signRect, const Radius.circular(3)),
            Paint()..color = const Color(0xFF0F1722),
          );
          canvas.drawRRect(
            RRect.fromRectAndRadius(signRect, const Radius.circular(3)),
            Paint()
              ..color = const Color(0xFF00E5FF).withValues(alpha: 0.7)
              ..style = PaintingStyle.stroke
              ..strokeWidth = 1.5,
          );
        }
        break;
    }
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
