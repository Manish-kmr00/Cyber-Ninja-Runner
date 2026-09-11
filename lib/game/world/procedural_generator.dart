import 'dart:math';
import 'package:flame/components.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../hazards/bug_crawler.dart';
import '../hazards/cyber_cannon.dart';
import '../hazards/cyber_titan.dart';
import '../hazards/dark_box.dart';
import '../hazards/death_column.dart';
import '../hazards/stakes.dart';
import 'chunk_models.dart';

class ProceduralGenerator {
  final Random random;
  final GameMode gameMode;
  final List<WorldChunk> activeChunks = [];
  double currentEndCoordinateX = 0.0;

  ProceduralGenerator({this.gameMode = GameMode.run, int? seed})
    : random = Random(seed ?? DateTime.now().millisecondsSinceEpoch);

  void reset() {
    activeChunks.clear();
    currentEndCoordinateX = 0.0;
  }

  /// Calculates which dynamic sector biome should be rendered at the given distance.
  /// If in Map 2 (TenX Challenge), always renders SectorBiome.cyberShinto.
  /// If in Map 3 (Flight Runner), always renders SectorBiome.neoNebula.
  /// For Endless Run (Map 1), cycles through the 5 sectors every 1000m.
  static SectorBiome getBiomeForDistance(int distanceMeters, {GameMode? mode}) {
    if (mode == GameMode.tenXChallenge) {
      return SectorBiome.cyberShinto;
    }
    if (mode == GameMode.flightRunner) {
      return SectorBiome.neoNebula;
    }

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
      final tier = _calculateDifficultyTier(
        (currentEndCoordinateX / 10).round(),
      );
      final chunk = _createChunk(
        startX: currentEndCoordinateX,
        length: AppConstants.chunkLength,
        difficultyTier: tier,
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

    final chunkStartM = (startX / 10).round();

    // Check if a Cyber Titan Milestone begins this chunk:
    // In Map 3 (Flight Runner) and Map 2 (TenX Challenge), Titans patrol every 100m!
    // In Map 1 (Endless Run), Titans appear every 200m!
    final isTitanArena =
        ((chunkStartM % 200 == 0) ||
            ((gameMode == GameMode.flightRunner ||
                    gameMode == GameMode.tenXChallenge) &&
                chunkStartM % 100 == 0)) &&
        chunkStartM > 0;
    final isBossArena = (chunkStartM % 800 == 0) && chunkStartM > 0;

    final hasPit =
        !isSafeHaven &&
        !isTitanArena &&
        difficultyTier > 0 &&
        random.nextDouble() < 0.38;
    final pitWidth = hasPit ? 130.0 + random.nextDouble() * 90.0 : 0.0;
    final pitStartX = hasPit
        ? 320.0 + random.nextDouble() * (length - 320 - pitWidth)
        : 0.0;

    final distanceMeters = (startX / 10).round();
    final biome = getBiomeForDistance(distanceMeters, mode: gameMode);

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
    if (!isSafeHaven && !isTitanArena && difficultyTier >= 1) {
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
          CollectibleCP(
            position: Vector2(plat2X + plat2W / 2, groundY - 180),
            biome: biome,
          ),
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
              biome: biome,
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
              biome: biome,
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
          CollectibleCP(
            position: Vector2(platX + platW / 2, groundY - 155),
            biome: biome,
          ),
        );
      }
    }

    // 2. Spawn Safe Shadow Havens
    if (isSafeHaven || random.nextDouble() < 0.55) {
      final havenX = isSafeHaven ? 450.0 : 250.0 + random.nextDouble() * 350.0;
      chunk.shadowHavens.add(
        ShadowHaven(
          position: Vector2(havenX, groundY),
          size: Vector2(160, 80),
          biome: biome,
        ),
      );
    }

    // 3. Spawn Collectible Cyber Ninja Points (CP) along ground
    for (int i = 0; i < 3; i++) {
      final cpX = 150.0 + (i * 250.0) + random.nextDouble() * 50.0;
      if (!hasPit || (cpX < pitStartX || cpX > pitStartX + pitWidth)) {
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(cpX, groundY - 45 - (i % 2 == 0 ? 0 : 40)),
            biome: biome,
          ),
        );
      }
    }

    // If safe haven requested, don't inject hazards
    if (isSafeHaven) return chunk;

    // Titan Encounter Arena: Cyber Titan Mech every 200m! (Every 800m is the Grand Boss)
    if (isTitanArena) {
      final titanX = length * 0.52;
      chunk.hazards.add(
        _createTrackTitan(
          chunk,
          titanX,
          groundY,
          patrolDist: 210.0,
          speed: isBossArena
              ? (95.0 + min(50.0, (chunkStartM / 800) * 12.0))
              : (75.0 + min(40.0, (chunkStartM / 200) * 6.0)),
          isBoss: isBossArena,
          maxHp: 1,
        ),
      );
      return chunk;
    }

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
            biome: chunk.biome,
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
      biome: chunk.biome,
      minX: max(safeMinX, targetX - effectiveDist),
      maxX: min(safeMaxX, targetX + effectiveDist),
    );
  }

  CyberTitan _createTrackTitan(
    WorldChunk chunk,
    double preferredX,
    double trackDeckY, {
    double patrolDist = 180.0,
    double speed = 65.0,
    bool isBoss = true,
    int maxHp = 1,
  }) {
    double targetX = preferredX;
    double safeMinX = 60.0;
    double safeMaxX = chunk.length - 60.0;

    if (chunk.hasPit) {
      final pitLeft = chunk.pitStartX;
      final pitRight = chunk.pitStartX + chunk.pitWidth;

      final zone1Len = (pitLeft - 60.0) - 60.0;
      final zone2Len = (chunk.length - 60.0) - (pitRight + 60.0);

      if (preferredX < pitLeft - 30 && zone1Len >= 160.0) {
        safeMinX = 60.0;
        safeMaxX = pitLeft - 50.0;
        targetX = preferredX.clamp(safeMinX + 45.0, safeMaxX - 45.0);
      } else if (zone2Len >= 160.0) {
        safeMinX = pitRight + 50.0;
        safeMaxX = chunk.length - 60.0;
        targetX = preferredX.clamp(safeMinX + 45.0, safeMaxX - 45.0);
      } else {
        safeMinX = 60.0;
        safeMaxX = (pitLeft - 50.0).clamp(60.0, chunk.length);
        targetX = (safeMinX + safeMaxX) / 2;
      }
    } else {
      targetX = preferredX.clamp(safeMinX + 45.0, safeMaxX - 45.0);
    }

    final effectiveDist = min(patrolDist, (safeMaxX - safeMinX) / 2);
    final worldDistMeters = ((chunk.startX + targetX) / 10).round();
    return CyberTitan(
      position: Vector2(targetX, trackDeckY),
      patrolDistance: effectiveDist,
      patrolSpeed: speed,
      biome: chunk.biome,
      spawnDistanceMeters: worldDistMeters,
      isBoss: isBoss,
      maxHp: maxHp,
      bulletSpeed: 480.0,
      fireInterval: 0.95,
      minX: max(safeMinX, targetX - effectiveDist),
      maxX: min(safeMaxX, targetX + effectiveDist),
    );
  }

  Stakes _createTrackStakes(
    WorldChunk chunk,
    double preferredX,
    double groundY, {
    int spikeCount = 3,
  }) {
    final trackDeckY = groundY - 8.0;
    final spikeTotalWidth = spikeCount * Stakes.spikeWidth;

    double targetX = preferredX;
    double safeMinX = 50.0;
    double safeMaxX = chunk.length - spikeTotalWidth - 50.0;

    if (chunk.hasPit) {
      final pitLeft = chunk.pitStartX;
      final pitRight = chunk.pitStartX + chunk.pitWidth;

      // Safe buffer of 80px from pit edge so jump trajectory clears smoothly
      final zone1Max = pitLeft - 80.0 - spikeTotalWidth;
      final zone2Min = pitRight + 80.0;

      final zone1Valid = zone1Max >= safeMinX;
      final zone2Valid =
          (chunk.length - safeMinX) >= (zone2Min + spikeTotalWidth);

      if (preferredX < pitLeft && zone1Valid) {
        targetX = preferredX.clamp(safeMinX, zone1Max);
      } else if (zone2Valid) {
        targetX = preferredX.clamp(zone2Min, safeMaxX);
      } else if (zone1Valid) {
        targetX = (safeMinX + zone1Max) / 2;
      } else {
        targetX = preferredX.clamp(safeMinX, safeMaxX);
      }
    } else {
      targetX = preferredX.clamp(safeMinX, safeMaxX);
    }

    return Stakes(
      position: Vector2(targetX, trackDeckY),
      spikeCount: spikeCount,
      biome: chunk.biome,
      isRetracting: false,
    );
  }

  void _injectHazards(
    WorldChunk chunk,
    int tier,
    double groundY,
    double roofY,
  ) {
    final b = chunk.biome;
    if (tier == 0) {
      // Tier 0 (Game Start: 0-300m): Spikes + Cannon + Patrol Droid
      chunk.hazards.add(_createTrackStakes(chunk, 220, groundY, spikeCount: 3));
      chunk.hazards.add(
        CyberCannon(position: Vector2(460, roofY + 45), biome: b),
      );
      chunk.hazards.add(
        _createTrackDroid(chunk, 720, groundY, patrolDist: 140.0, speed: 85.0),
      );
      return;
    }

    if (tier == 1) {
      // Tier 1 (Early Run: 300-1000m): Spikes + Cannon + Patrol Droid + Spikes + Bug Crawler
      chunk.hazards.add(_createTrackStakes(chunk, 200, groundY, spikeCount: 3));
      chunk.hazards.add(
        CyberCannon(position: Vector2(400, roofY + 45), biome: b),
      );
      chunk.hazards.add(
        _createTrackDroid(chunk, 620, groundY, patrolDist: 140.0, speed: 95.0),
      );
      chunk.hazards.add(_createTrackStakes(chunk, 800, groundY, spikeCount: 3));
      chunk.hazards.add(BugCrawler(position: Vector2(920, groundY), biome: b));
      return;
    }

    if (tier == 2) {
      // Tier 2 (1000-2000m): Spikes + Dual Droids + Cannon + Spikes
      chunk.hazards.add(_createTrackStakes(chunk, 180, groundY, spikeCount: 4));
      chunk.hazards.add(
        _createTrackDroid(chunk, 450, groundY, patrolDist: 130.0, speed: 100.0),
      );
      chunk.hazards.add(
        CyberCannon(position: Vector2(340, roofY + 45), biome: b),
      );
      chunk.hazards.add(
        _createTrackDroid(chunk, 720, groundY, patrolDist: 130.0, speed: 105.0),
      );
      chunk.hazards.add(_createTrackStakes(chunk, 880, groundY, spikeCount: 3));
      return;
    }

    if (tier == 3) {
      // Tier 3 (2000-3000m): Death Column + Spikes + Patrol Droid + Bug Crawler
      chunk.hazards.add(
        DeathColumn(position: Vector2(260, roofY), maxHeight: 220, biome: b),
      );
      chunk.hazards.add(_createTrackStakes(chunk, 460, groundY, spikeCount: 4));
      chunk.hazards.add(
        _createTrackDroid(chunk, 660, groundY, patrolDist: 150.0, speed: 110.0),
      );
      chunk.hazards.add(BugCrawler(position: Vector2(850, groundY), biome: b));
      return;
    }

    if (tier == 4) {
      // Tier 4 (3000-4000m): Spikes + Cannon + Fast Patrol Droid + Spikes + Bug Crawler
      chunk.hazards.add(_createTrackStakes(chunk, 180, groundY, spikeCount: 4));
      chunk.hazards.add(
        CyberCannon(position: Vector2(320, roofY + 45), biome: b),
      );
      chunk.hazards.add(
        _createTrackDroid(chunk, 580, groundY, patrolDist: 160.0, speed: 120.0),
      );
      chunk.hazards.add(_createTrackStakes(chunk, 780, groundY, spikeCount: 4));
      chunk.hazards.add(BugCrawler(position: Vector2(920, groundY), biome: b));
      return;
    }

    // Tier 5: Extreme Gauntlet (Death Column + Spikes + Patrol Droid + Cannon + Spikes)
    chunk.hazards.add(
      DeathColumn(position: Vector2(240, roofY), maxHeight: 230, biome: b),
    );
    chunk.hazards.add(_createTrackStakes(chunk, 420, groundY, spikeCount: 4));
    chunk.hazards.add(
      _createTrackDroid(chunk, 620, groundY, patrolDist: 160.0, speed: 125.0),
    );
    chunk.hazards.add(
      CyberCannon(position: Vector2(760, roofY + 45), biome: b),
    );
    chunk.hazards.add(_createTrackStakes(chunk, 900, groundY, spikeCount: 5));
  }
}
