import 'dart:math';
import 'package:flame/components.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../hazards/bug_crawler.dart';
import '../hazards/cyber_cannon.dart';
import '../hazards/dark_box.dart';
import '../hazards/death_column.dart';
import '../hazards/stakes.dart';
import 'chunk_models.dart';

class ProceduralGenerator {
  final Random random;
  final List<WorldChunk> activeChunks = [];
  double currentEndCoordinateX = 0.0;

  ProceduralGenerator([int? seed])
    : random = Random(seed ?? DateTime.now().millisecondsSinceEpoch);

  void reset() {
    activeChunks.clear();
    currentEndCoordinateX = 0.0;
  }

  /// Calculates which dynamic sector biome should be rendered at the given distance (changes every 1000m).
  static SectorBiome getBiomeForDistance(int distanceMeters) {
    // 0 - 999m: Sector 1 (Neon Metropolis)
    // 1000 - 1999m: Sector 2 (Toxic Foundry)
    // 2000 - 2999m: Sector 3 (Maglev Tunnel)
    // 3000 - 3999m: Sector 4 (Orbital Skyway)
    // 4000 - 4999m: Sector 5 (Quantum Nexus)
    // 5000m+: Cycles every 1000m through the sectors
    final cycle = (distanceMeters ~/ 1000) % 5;
    switch (cycle) {
      case 0:
        return SectorBiome.neonMetropolis;
      case 1:
        return SectorBiome.toxicFoundry;
      case 2:
        return SectorBiome.maglevTunnel;
      case 3:
        return SectorBiome.orbitalSkyway;
      case 4:
        return SectorBiome.quantumNexus;
      default:
        return SectorBiome.neonMetropolis;
    }
  }

  /// Initial spawn of starting chunks (creates a safe haven at the start).
  List<WorldChunk> generateInitialChunks() {
    reset();
    // 1. Initial safe chunk
    final chunk0 = _createChunk(
      startX: 0,
      length: AppConstants.chunkLength,
      difficultyTier: 0,
      isSafeHaven: true,
    );
    activeChunks.add(chunk0);
    currentEndCoordinateX = AppConstants.chunkLength;

    // 2. Subsequent initial chunks
    for (int i = 1; i < AppConstants.activeChunkCount; i++) {
      final chunk = _createChunk(
        startX: currentEndCoordinateX,
        length: AppConstants.chunkLength,
        difficultyTier: 1,
      );
      activeChunks.add(chunk);
      currentEndCoordinateX += AppConstants.chunkLength;
    }

    return List.from(activeChunks);
  }

  /// Updates chunks relative to player position: recycles passed chunks and spawns new ones ahead.
  void updateChunks({
    required double playerX,
    required Component parentComponent,
    bool forceSafeGround = false,
  }) {
    // 1. Recycle chunks that are behind the player
    activeChunks.removeWhere((chunk) {
      if (chunk.startX + chunk.length < playerX - 600) {
        chunk.removeFromParent();
        return true;
      }
      return false;
    });

    // 2. Spawn new chunks ahead
    while (currentEndCoordinateX < playerX + (AppConstants.chunkLength * 2.5)) {
      final distanceMeters = (currentEndCoordinateX / 10).round();
      final tier = _calculateDifficultyTier(distanceMeters);

      final newChunk = _createChunk(
        startX: currentEndCoordinateX,
        length: AppConstants.chunkLength,
        difficultyTier: tier,
        isSafeHaven: forceSafeGround,
      );

      activeChunks.add(newChunk);
      parentComponent.add(newChunk);
      currentEndCoordinateX += AppConstants.chunkLength;
    }
  }

  int _calculateDifficultyTier(int distanceMeters) {
    if (distanceMeters < 300) {
      return 0; // Gentle intro (Sector 1 start)
    }
    if (distanceMeters < 1000) {
      return 1; // Basic sentries, stakes, & single Droid (Sector 1)
    }
    if (distanceMeters < 2000) {
      return 2; // Sector 2: Industrial Foundry (1000 - 2000m)
    }
    if (distanceMeters < 3000) {
      return 3; // Sector 3: Maglev Tunnel (2000 - 3000m)
    }
    if (distanceMeters < 4000) {
      return 4; // Sector 4: Orbital Skyway (3000 - 4000m)
    }
    return 5; // Sector 5: Quantum Nexus (4000m+)
  }

  WorldChunk _createChunk({
    required double startX,
    required double length,
    required int difficultyTier,
    bool isSafeHaven = false,
  }) {
    final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
    const roofY = 60.0;

    final hasPit =
        !isSafeHaven && difficultyTier > 0 && random.nextDouble() < 0.38;
    final pitWidth = hasPit ? 130.0 + random.nextDouble() * 90.0 : 0.0;
    final pitStartX = hasPit
        ? 320.0 + random.nextDouble() * (length - 320 - pitWidth)
        : 0.0;

    final distanceMeters = (startX / 10).round();
    final biome = getBiomeForDistance(distanceMeters);

    final chunk = WorldChunk(
      startX: startX,
      length: length,
      groundY: groundY,
      roofY: roofY,
      hasPit: hasPit,
      pitStartX: pitStartX,
      pitWidth: pitWidth,
      biome: biome,
    );

    // 1. Dynamic Multi-Tier Layout Architectures (Prevents repetitive linear boring layouts!)
    if (!isSafeHaven && difficultyTier >= 1) {
      final layoutType = random.nextInt(
        4,
      ); // 4 distinct structural chunk archetypes!

      if (layoutType == 0) {
        // Archetype A: Cascading Stepped Dual Catwalks (Low step -> High step)
        final plat1X = 180.0 + random.nextDouble() * 80.0;
        final plat1W = 180.0 + random.nextDouble() * 60.0;
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(plat1X, groundY - 75.0),
            size: Vector2(plat1W, 18.0),
            biome: biome,
          ),
        );
        final plat2X = plat1X + plat1W + 40.0;
        final plat2W = 200.0 + random.nextDouble() * 80.0;
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(plat2X, groundY - 145.0),
            size: Vector2(plat2W, 18.0),
            biome: biome,
          ),
        );
        chunk.collectibles.add(
          CollectibleCP(position: Vector2(plat2X + plat2W / 2, groundY - 180)),
        );
      } else if (layoutType == 1) {
        // Archetype B: Long High Skyway Bridge (Allows player to sprint above ground hazards)
        final bridgeX = 140.0;
        final bridgeW = length - 280.0;
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(bridgeX, groundY - 110.0),
            size: Vector2(bridgeW, 18.0),
            biome: biome,
          ),
        );
        // Aerial collectible arc over the high bridge
        for (int c = 0; c < 3; c++) {
          chunk.collectibles.add(
            CollectibleCP(
              position: Vector2(bridgeX + 80.0 + c * 120.0, groundY - 145.0),
            ),
          );
        }
      } else if (layoutType == 2) {
        // Archetype C: Split Chasm Overpass (Catwalk suspended directly across a deep chasm)
        if (hasPit) {
          final bridgeX = pitStartX - 60.0;
          final bridgeW = pitWidth + 120.0;
          chunk.elevatedPlatforms.add(
            ElevatedPlatform(
              position: Vector2(bridgeX, groundY - 95.0),
              size: Vector2(bridgeW, 18.0),
              biome: biome,
            ),
          );
          chunk.collectibles.add(
            CollectibleCP(
              position: Vector2(pitStartX + pitWidth / 2, groundY - 130),
            ),
          );
        }
      } else {
        // Archetype D: Mid-Air High Platform Island with Floating Crystal Cache
        final platX = 350.0 + random.nextDouble() * 200.0;
        final platW = 240.0 + random.nextDouble() * 100.0;
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(platX, groundY - 120.0),
            size: Vector2(platW, 18.0),
            biome: biome,
          ),
        );
        chunk.collectibles.add(
          CollectibleCP(position: Vector2(platX + platW / 2, groundY - 155)),
        );
      }
    }

    // 2. Spawn Safe Shadow Havens
    if (isSafeHaven || random.nextDouble() < 0.55) {
      final havenX = isSafeHaven ? 450.0 : 250.0 + random.nextDouble() * 350.0;
      chunk.shadowHavens.add(
        ShadowHaven(position: Vector2(havenX, groundY), size: Vector2(160, 80)),
      );
    }

    // 3. Spawn Collectible Cube Points (CP) along ground
    for (int i = 0; i < 3; i++) {
      final cpX = 150.0 + (i * 250.0) + random.nextDouble() * 50.0;
      if (!hasPit || (cpX < pitStartX || cpX > pitStartX + pitWidth)) {
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(cpX, groundY - 45 - (i % 2 == 0 ? 0 : 40)),
          ),
        );
      }
    }

    // If safe haven requested, don't inject hazards
    if (isSafeHaven) return chunk;

    // 4. Inject Hazards based on Difficulty Tier & Sector
    _injectHazards(chunk, difficultyTier, groundY, roofY);

    return chunk;
  }

  DarkBox _createTrackDroid(
    WorldChunk chunk,
    double preferredX,
    double groundY, {
    double patrolDist = 140.0,
    double speed = 85.0,
  }) {
    // Droid feet walk squarely on the front track curb line
    final trackDeckY = groundY;

    // 30% chance to put patrol droid on elevated catwalk if platform is spacious
    if (chunk.elevatedPlatforms.isNotEmpty && random.nextDouble() < 0.35) {
      for (final plat in chunk.elevatedPlatforms) {
        if (plat.size.x >= 140.0) {
          final platMin = plat.position.x + 30.0;
          final platMax = plat.position.x + plat.size.x - 30.0;
          final platMid = (platMin + platMax) / 2;
          return DarkBox(
            position: Vector2(platMid, plat.position.y),
            patrolDistance: (platMax - platMin) / 2,
            patrolSpeed: speed,
            minX: platMin,
            maxX: platMax,
          );
        }
      }
    }

    // Ground patrol: safely place on solid track deck away from any chasm pits
    double targetX = preferredX;
    double safeMinX = 50.0;
    double safeMaxX = chunk.length - 50.0;

    if (chunk.hasPit) {
      final pitLeft = chunk.pitStartX;
      final pitRight = chunk.pitStartX + chunk.pitWidth;

      final zone1Len = (pitLeft - 40.0) - 50.0;
      final zone2Len = (chunk.length - 50.0) - (pitRight + 40.0);

      if (preferredX < pitLeft - 20 && zone1Len >= 120.0) {
        safeMinX = 50.0;
        safeMaxX = pitLeft - 40.0;
        targetX = preferredX.clamp(safeMinX + 25.0, safeMaxX - 25.0);
      } else if (zone2Len >= 120.0) {
        safeMinX = pitRight + 40.0;
        safeMaxX = chunk.length - 50.0;
        targetX = preferredX.clamp(safeMinX + 25.0, safeMaxX - 25.0);
      } else {
        safeMinX = 50.0;
        safeMaxX = (pitLeft - 40.0).clamp(50.0, chunk.length);
        targetX = (safeMinX + safeMaxX) / 2;
      }
    } else {
      targetX = preferredX.clamp(safeMinX + 30.0, safeMaxX - 30.0);
    }

    final effectiveDist = min(patrolDist, (safeMaxX - safeMinX) / 2);
    return DarkBox(
      position: Vector2(targetX, trackDeckY),
      patrolDistance: effectiveDist,
      patrolSpeed: speed,
      minX: max(safeMinX, targetX - effectiveDist),
      maxX: min(safeMaxX, targetX + effectiveDist),
    );
  }

  void _injectHazards(
    WorldChunk chunk,
    int tier,
    double groundY,
    double roofY,
  ) {
    if (tier == 0) {
      // Tier 0: Cyber Cannon introduction
      chunk.hazards.add(CyberCannon(position: Vector2(550, roofY + 45)));
      return;
    }

    if (tier == 1) {
      // Tier 1: Cyber Cannon + Patrol Droid
      chunk.hazards.add(CyberCannon(position: Vector2(450, roofY + 45)));
      chunk.hazards.add(
        _createTrackDroid(chunk, 760, groundY, patrolDist: 110.0, speed: 75.0),
      );
      return;
    }

    if (tier == 2) {
      // Tier 2: Cyber Patrol Droid + Cyber Cannon turret combo
      chunk.hazards.add(CyberCannon(position: Vector2(350, roofY + 45)));
      chunk.hazards.add(
        _createTrackDroid(chunk, 700, groundY, patrolDist: 150.0, speed: 90.0),
      );
      return;
    }

    if (tier == 3) {
      // Tier 3: Death Column smasher + Cyber Patrol Droid
      chunk.hazards.add(
        DeathColumn(position: Vector2(280, roofY), maxHeight: 220),
      );
      chunk.hazards.add(
        _createTrackDroid(chunk, 620, groundY, patrolDist: 170.0, speed: 100.0),
      );
      chunk.hazards.add(Stakes(position: Vector2(880, groundY), spikeCount: 3));
      return;
    }

    if (tier == 4) {
      // Tier 4: Fast Patrol Droid + Bug Crawler + Cyber Cannon
      chunk.hazards.add(CyberCannon(position: Vector2(340, roofY + 45)));
      chunk.hazards.add(
        _createTrackDroid(chunk, 600, groundY, patrolDist: 180.0, speed: 115.0),
      );
      chunk.hazards.add(BugCrawler(position: Vector2(840, groundY)));
      return;
    }

    // Tier 5: Extreme Gauntlet (Dual Droids + Death Column + Cyber Cannon + Retracting Spikes)
    chunk.hazards.add(
      DeathColumn(position: Vector2(260, roofY), maxHeight: 230),
    );
    chunk.hazards.add(
      _createTrackDroid(chunk, 520, groundY, patrolDist: 160.0, speed: 125.0),
    );
    chunk.hazards.add(CyberCannon(position: Vector2(740, roofY + 45)));
    chunk.hazards.add(
      Stakes(
        position: Vector2(890, groundY),
        spikeCount: 4,
        isRetracting: true,
      ),
    );
  }
}
