import 'dart:math';
import 'package:flame/components.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../hazards/bug_crawler.dart';
import '../hazards/cyber_cannon.dart';
import '../hazards/cyber_titan.dart';
import '../hazards/dark_box.dart';
import '../hazards/hover_drone_hazard.dart';
import '../hazards/laser_gate_hazard.dart';
import '../hazards/low_pipe_hazard.dart';
import '../hazards/stakes.dart';
import '../hazards/traffic_barrier_hazard.dart';
import 'chunk_models.dart';
import 'track_segment_models.dart';

class ProceduralGenerator {
  final Random random;
  final GameMode gameMode;
  final List<WorldChunk> activeChunks = [];
  double currentEndCoordinateX = 0.0;
  double currentElevation = 0.0;
  final List<TrackSegmentType> recentSegmentTypes = [];

  CyberEnvironmentTheme currentTheme = CyberEnvironmentTheme.cyberAlley;
  int currentThemeSegmentCount = 0;
  int maxThemeSegments = 3;
  final List<CyberEnvironmentTheme> recentThemes = [];

  ProceduralGenerator({this.gameMode = GameMode.run, int? seed})
    : random = Random(seed ?? DateTime.now().millisecondsSinceEpoch);

  void reset() {
    activeChunks.clear();
    currentEndCoordinateX = 0.0;
    currentElevation = 0.0;
    recentSegmentTypes.clear();
    currentTheme = CyberEnvironmentTheme.cyberAlley;
    currentThemeSegmentCount = 0;
    maxThemeSegments = 3;
    recentThemes.clear();
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
    while (currentEndCoordinateX < playerX + (AppConstants.chunkLength * 5.0)) {
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
      return 0; // Gentle intro (Sector 1 start, tutorial single obstacles)
    }
    if (distanceMeters < 1000) {
      return 1; // Sector 1: Basic obstacles (single droid, stakes, traffic barrier)
    }
    if (distanceMeters < 3000) {
      return 2; // Sector 2-3: 2-step sequences (e.g. Ramp Jump -> Low Pipe Slide)
    }
    if (distanceMeters < 5000) {
      return 3; // Sector 3-5: Moving drones, laser gates, elevated catwalks
    }
    if (distanceMeters < 10000) {
      return 4; // Multi-stage obstacle sequences (Jump -> Slide -> Slash)
    }
    if (distanceMeters < 20000) {
      return 5; // Reaction speed gauntlets
    }
    if (distanceMeters < 30000) {
      return 6; // High-intensity combinations
    }
    return 7; // 30,000m - 50,000m: Master cyberpunk agility challenges
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
        random.nextDouble() < 0.35;
    final pitWidth = hasPit ? 110.0 + random.nextDouble() * 40.0 : 0.0;
    final pitStartX = hasPit ? 170.0 + random.nextDouble() * 80.0 : 0.0;

    final distanceMeters = (startX / 10).round();
    final biome = getBiomeForDistance(distanceMeters, mode: gameMode);

    // Select Environment Theme & Mini Gameplay Event
    final theme = _selectEnvironmentTheme(chunkStartM);

    // Procedural Modular Track Segment Selection (Every 50m / 500px):
    final segmentType = _selectSegmentType(
      chunkStartM: chunkStartM,
      isSafeHaven: isSafeHaven,
      isTitanArena: isTitanArena,
      hasPit: hasPit,
      biome: biome,
    );

    final event = _selectGameplayEvent(
      theme: theme,
      segmentType: segmentType,
      hasPit: hasPit,
      difficultyTier: difficultyTier,
    );

    final entryElevation = currentElevation;
    double exitElevation = entryElevation;

    if (segmentType == TrackSegmentType.gradualSlopeUp) {
      exitElevation = (entryElevation - 30.0).clamp(-80.0, 25.0);
    } else if (segmentType == TrackSegmentType.steppedTerraceAscent) {
      exitElevation = (entryElevation - 40.0).clamp(-80.0, 25.0);
    } else if (segmentType == TrackSegmentType.gradualSlopeDown) {
      exitElevation = (entryElevation + 30.0).clamp(-80.0, 25.0);
    } else if (segmentType == TrackSegmentType.steppedTerraceDescent) {
      exitElevation = (entryElevation + 40.0).clamp(-80.0, 25.0);
    } else {
      exitElevation = entryElevation;
    }

    currentElevation = exitElevation;

    final chunk = WorldChunk(
      startX: startX,
      length: length,
      groundY: groundY,
      roofY: roofY,
      hasPit: hasPit,
      pitStartX: pitStartX,
      pitWidth: pitWidth,
      biome: biome,
      segmentType: segmentType,
      environmentTheme: theme,
      gameplayEvent: event,
      entryElevation: entryElevation,
      exitElevation: exitElevation,
    );

    // 1. Dynamic Multi-Tier Layout Catwalks
    if (!isSafeHaven && !isTitanArena && difficultyTier >= 1) {
      final layoutType = random.nextInt(4);

      if (layoutType == 0) {
        final plat1X = 140.0 + random.nextDouble() * 40.0;
        final plat1W = 160.0 + random.nextDouble() * 40.0;
        final platSurfaceY = chunk.getSurfaceY(startX + plat1X + plat1W / 2);
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(plat1X, platSurfaceY - 80.0),
            size: Vector2(plat1W, 18.0),
            biome: biome,
          ),
        );
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(plat1X + plat1W / 2, platSurfaceY - 115.0),
            biome: biome,
          ),
        );
      } else if (layoutType == 1) {
        final bridgeX = 120.0;
        final bridgeW = length - 240.0;
        final bridgeSurfaceY = chunk.getSurfaceY(startX + length / 2);
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(bridgeX, bridgeSurfaceY - 90.0),
            size: Vector2(bridgeW, 18.0),
            biome: biome,
          ),
        );
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(bridgeX + bridgeW / 2, bridgeSurfaceY - 125.0),
            biome: biome,
          ),
        );
      } else if (layoutType == 2 && hasPit) {
        final bridgeX = pitStartX - 30.0;
        final bridgeW = pitWidth + 60.0;
        final chasmSurfaceY = chunk.getSurfaceY(
          startX + pitStartX + pitWidth / 2,
        );
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(bridgeX, chasmSurfaceY - 80.0),
            size: Vector2(bridgeW, 18.0),
            biome: biome,
          ),
        );
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(pitStartX + pitWidth / 2, chasmSurfaceY - 115.0),
            biome: biome,
          ),
        );
      } else if (layoutType == 3) {
        final platX = 180.0 + random.nextDouble() * 80.0;
        const platW = 160.0;
        final islandSurfaceY = chunk.getSurfaceY(startX + platX + platW / 2);
        chunk.elevatedPlatforms.add(
          ElevatedPlatform(
            position: Vector2(platX, islandSurfaceY - 85.0),
            size: Vector2(platW, 18.0),
            biome: biome,
          ),
        );
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(platX + platW / 2, islandSurfaceY - 120.0),
            biome: biome,
          ),
        );
      }
    }

    // 2. Spawn Safe Shadow Havens
    if (isSafeHaven || random.nextDouble() < 0.45) {
      final havenX = isSafeHaven ? 220.0 : 160.0 + random.nextDouble() * 160.0;
      final havenY = chunk.getSurfaceY(startX + havenX);
      chunk.shadowHavens.add(
        ShadowHaven(
          position: Vector2(havenX, havenY),
          size: Vector2(120, 70),
          biome: biome,
        ),
      );
    }

    // 3. Spawn Collectible Cyber Ninja Points (CP) along ground
    for (int i = 0; i < 2; i++) {
      final cpX = 120.0 + (i * 220.0) + random.nextDouble() * 40.0;
      if (!hasPit || (cpX < pitStartX || cpX > pitStartX + pitWidth)) {
        final surfaceY = chunk.getSurfaceY(startX + cpX);
        chunk.collectibles.add(
          CollectibleCP(
            position: Vector2(cpX, surfaceY - 45 - (i % 2 == 0 ? 0 : 35)),
            biome: biome,
          ),
        );
      }
    }

    // If safe haven requested, don't inject hazards
    if (isSafeHaven) return chunk;

    // Titan Encounter Arena: Cyber Titan Mech
    if (isTitanArena) {
      final titanX = length * 0.5;
      final titanGroundY = chunk.getSurfaceY(startX + titanX);
      chunk.hazards.add(
        _createTrackTitan(
          chunk,
          titanX,
          titanGroundY,
          patrolDist: 150.0,
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

  TrackSegmentType _selectSegmentType({
    required int chunkStartM,
    required bool isSafeHaven,
    required bool isTitanArena,
    required bool hasPit,
    required SectorBiome biome,
  }) {
    if (chunkStartM == 0 || isSafeHaven) {
      return TrackSegmentType.straightNeonBoulevard;
    }
    if (isTitanArena) {
      return TrackSegmentType.titanArenaPlateau;
    }

    final candidatePool = TrackSegmentType.values.where((t) {
      if (t == TrackSegmentType.titanArenaPlateau) return false;
      if (recentSegmentTypes.contains(t)) return false;

      // Incline / Decline balancing
      if (currentElevation <= -60.0) {
        if (t == TrackSegmentType.gradualSlopeUp ||
            t == TrackSegmentType.steppedTerraceAscent) {
          return false;
        }
      }
      if (currentElevation >= 20.0) {
        if (t == TrackSegmentType.gradualSlopeDown ||
            t == TrackSegmentType.steppedTerraceDescent) {
          return false;
        }
      }

      if (hasPit) {
        if (t == TrackSegmentType.speedBoosterRunway ||
            t == TrackSegmentType.reinforcedBarricadeSector ||
            t == TrackSegmentType.cyberSewerCulvert) {
          return false;
        }
      }

      return true;
    }).toList();

    final chosen = candidatePool.isNotEmpty
        ? candidatePool[random.nextInt(candidatePool.length)]
        : TrackSegmentType.straightNeonBoulevard;

    recentSegmentTypes.add(chosen);
    if (recentSegmentTypes.length > 5) {
      recentSegmentTypes.removeAt(0);
    }
    return chosen;
  }

  CyberEnvironmentTheme _selectEnvironmentTheme(int chunkStartM) {
    if (chunkStartM == 0) {
      currentTheme = CyberEnvironmentTheme.cyberAlley;
      currentThemeSegmentCount = 0;
      maxThemeSegments = 3;
      return currentTheme;
    }

    currentThemeSegmentCount++;
    if (currentThemeSegmentCount < maxThemeSegments) {
      return currentTheme;
    }

    // Coherent transition logic based on current theme
    List<CyberEnvironmentTheme> candidates;
    switch (currentTheme) {
      case CyberEnvironmentTheme.cyberAlley:
        candidates = [
          CyberEnvironmentTheme.neonMarket,
          CyberEnvironmentTheme.industrialDistrict,
          CyberEnvironmentTheme.undergroundTunnel,
        ];
        break;
      case CyberEnvironmentTheme.neonMarket:
        candidates = [
          CyberEnvironmentTheme.cyberAlley,
          CyberEnvironmentTheme.hologramDistrict,
          CyberEnvironmentTheme.futuristicHighway,
        ];
        break;
      case CyberEnvironmentTheme.hologramDistrict:
        candidates = [
          CyberEnvironmentTheme.futuristicHighway,
          CyberEnvironmentTheme.skyBridge,
          CyberEnvironmentTheme.neonMarket,
        ];
        break;
      case CyberEnvironmentTheme.futuristicHighway:
        candidates = [
          CyberEnvironmentTheme.skyBridge,
          CyberEnvironmentTheme.cyberAlley,
          CyberEnvironmentTheme.industrialDistrict,
        ];
        break;
      case CyberEnvironmentTheme.skyBridge:
        candidates = [
          CyberEnvironmentTheme.rooftop,
          CyberEnvironmentTheme.futuristicHighway,
          CyberEnvironmentTheme.hologramDistrict,
        ];
        break;
      case CyberEnvironmentTheme.rooftop:
        candidates = [
          CyberEnvironmentTheme.skyBridge,
          CyberEnvironmentTheme.cyberAlley,
          CyberEnvironmentTheme.darkSector,
        ];
        break;
      case CyberEnvironmentTheme.undergroundTunnel:
        candidates = [
          CyberEnvironmentTheme.darkSector,
          CyberEnvironmentTheme.industrialDistrict,
          CyberEnvironmentTheme.cyberAlley,
        ];
        break;
      case CyberEnvironmentTheme.darkSector:
        candidates = [
          CyberEnvironmentTheme.industrialDistrict,
          CyberEnvironmentTheme.undergroundTunnel,
          CyberEnvironmentTheme.hologramDistrict,
        ];
        break;
      case CyberEnvironmentTheme.industrialDistrict:
        candidates = [
          CyberEnvironmentTheme.undergroundTunnel,
          CyberEnvironmentTheme.darkSector,
          CyberEnvironmentTheme.futuristicHighway,
        ];
        break;
    }

    // Filter out recently visited themes
    final validCandidates = candidates
        .where((c) => !recentThemes.contains(c))
        .toList();
    final chosen = validCandidates.isNotEmpty
        ? validCandidates[random.nextInt(validCandidates.length)]
        : candidates[random.nextInt(candidates.length)];

    recentThemes.add(currentTheme);
    if (recentThemes.length > 4) {
      recentThemes.removeAt(0);
    }

    currentTheme = chosen;
    currentThemeSegmentCount = 0;
    maxThemeSegments = 2 + random.nextInt(3); // 2 to 4 segments (100m to 200m)
    return currentTheme;
  }

  SegmentGameplayEvent _selectGameplayEvent({
    required CyberEnvironmentTheme theme,
    required TrackSegmentType segmentType,
    required bool hasPit,
    required int difficultyTier,
  }) {
    if (hasPit) {
      if (theme == CyberEnvironmentTheme.rooftop) {
        return SegmentGameplayEvent.rooftopGapJump;
      }
      if (theme == CyberEnvironmentTheme.skyBridge) {
        return SegmentGameplayEvent.skyBridgeGapJump;
      }
    }

    if (segmentType == TrackSegmentType.gradualSlopeUp ||
        segmentType == TrackSegmentType.steppedTerraceAscent) {
      return SegmentGameplayEvent.rampJump;
    }

    if (segmentType == TrackSegmentType.dualTierCatwalk ||
        segmentType == TrackSegmentType.doubleDeckSkyway) {
      return SegmentGameplayEvent.catwalkMultiJumpChain;
    }

    switch (theme) {
      case CyberEnvironmentTheme.undergroundTunnel:
        return SegmentGameplayEvent.tunnelLowSlide;
      case CyberEnvironmentTheme.cyberAlley:
        return SegmentGameplayEvent.alleyDroneEncounter;
      case CyberEnvironmentTheme.industrialDistrict:
        return SegmentGameplayEvent.industrialContainerVault;
      case CyberEnvironmentTheme.hologramDistrict:
        return SegmentGameplayEvent.hologramLaserGateTiming;
      case CyberEnvironmentTheme.darkSector:
        return SegmentGameplayEvent.darkReactionGauntlet;
      case CyberEnvironmentTheme.rooftop:
        return SegmentGameplayEvent.rooftopGapJump;
      case CyberEnvironmentTheme.skyBridge:
        return SegmentGameplayEvent.skyBridgeGapJump;
      case CyberEnvironmentTheme.neonMarket:
        return SegmentGameplayEvent.runPacing;
      case CyberEnvironmentTheme.futuristicHighway:
        return SegmentGameplayEvent.rampJump;
    }
  }

  DarkBox _createTrackDroid(
    WorldChunk chunk,
    double preferredX,
    double groundY, {
    double patrolDist = 120.0,
    double speed = 85.0,
  }) {
    // 30% chance to put patrol droid on elevated catwalk if platform is spacious
    if (chunk.elevatedPlatforms.isNotEmpty && random.nextDouble() < 0.35) {
      for (final plat in chunk.elevatedPlatforms) {
        if (plat.size.x >= 120.0) {
          final platMin = plat.position.x + 25.0;
          final platMax = plat.position.x + plat.size.x - 25.0;
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

    double targetX = preferredX;
    const safeMinX = 40.0;
    final safeMaxX = chunk.length - 40.0;

    if (chunk.hasPit) {
      final pitLeft = chunk.pitStartX;
      final pitRight = chunk.pitStartX + chunk.pitWidth;

      final zone1Len = (pitLeft - 30.0) - 40.0;
      final zone2Len = (chunk.length - 40.0) - (pitRight + 30.0);

      if (preferredX < pitLeft - 20 && zone1Len >= 80.0) {
        targetX = preferredX.clamp(safeMinX + 15.0, pitLeft - 30.0);
      } else if (zone2Len >= 80.0) {
        targetX = preferredX.clamp(pitRight + 30.0, safeMaxX - 15.0);
      } else {
        targetX = preferredX.clamp(safeMinX + 15.0, safeMaxX - 15.0);
      }
    } else {
      targetX = preferredX.clamp(safeMinX + 20.0, safeMaxX - 20.0);
    }

    final surfaceY = chunk.getSurfaceY(chunk.startX + targetX);
    final effectiveDist = min(patrolDist, (safeMaxX - safeMinX) / 2);
    return DarkBox(
      position: Vector2(targetX, surfaceY),
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
    double patrolDist = 150.0,
    double speed = 65.0,
    bool isBoss = true,
    int maxHp = 1,
  }) {
    const safeMinX = 50.0;
    final safeMaxX = chunk.length - 50.0;
    final targetX = preferredX.clamp(safeMinX + 30.0, safeMaxX - 30.0);
    final surfaceY = chunk.getSurfaceY(chunk.startX + targetX);

    final effectiveDist = min(patrolDist, (safeMaxX - safeMinX) / 2);
    final worldDistMeters = ((chunk.startX + targetX) / 10).round();
    return CyberTitan(
      position: Vector2(targetX, surfaceY),
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
    final spikeTotalWidth = spikeCount * Stakes.spikeWidth;

    double targetX = preferredX;
    const safeMinX = 40.0;
    final safeMaxX = chunk.length - spikeTotalWidth - 40.0;

    if (chunk.hasPit) {
      final pitLeft = chunk.pitStartX;
      final pitRight = chunk.pitStartX + chunk.pitWidth;

      final zone1Max = pitLeft - 60.0 - spikeTotalWidth;
      final zone2Min = pitRight + 60.0;

      final zone1Valid = zone1Max >= safeMinX;
      final zone2Valid =
          (chunk.length - safeMinX) >= (zone2Min + spikeTotalWidth);

      if (preferredX < pitLeft && zone1Valid) {
        targetX = preferredX.clamp(safeMinX, zone1Max);
      } else if (zone2Valid) {
        targetX = preferredX.clamp(zone2Min, safeMaxX);
      } else {
        targetX = preferredX.clamp(safeMinX, safeMaxX);
      }
    } else {
      targetX = preferredX.clamp(safeMinX, safeMaxX);
    }

    final trackDeckY = chunk.getSurfaceY(chunk.startX + targetX) - 8.0;

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
    double baseGroundY,
    double roofY,
  ) {
    final b = chunk.biome;
    final sx = chunk.startX;
    final length = chunk.length;
    final hasPit = chunk.hasPit;
    final pitLeft = chunk.pitStartX;
    final pitRight = chunk.pitStartX + chunk.pitWidth;

    bool isInPit(double x, double margin) {
      return hasPit && x >= (pitLeft - margin) && x <= (pitRight + margin);
    }

    switch (chunk.gameplayEvent) {
      case SegmentGameplayEvent.tunnelLowSlide:
        // 1. Low overhead pipe requiring ninja to SLIDE
        const x1 = 200.0;
        if (!isInPit(x1, 35.0)) {
          final y1 = chunk.getSurfaceY(sx + x1) - 58.0;
          chunk.hazards.add(LowPipeHazard(position: Vector2(x1, y1), biome: b));
        }
        // If tier >= 2: follow-up obstacle with 180px gap: Traffic barrier to jump over!
        if (tier >= 2) {
          const x2 = 380.0;
          if (!isInPit(x2, 35.0)) {
            chunk.hazards.add(
              TrafficBarrierHazard(
                position: Vector2(x2, chunk.getSurfaceY(sx + x2)),
                biome: b,
              ),
            );
          }
        }
        break;

      case SegmentGameplayEvent.rampJump:
        // Road barrier or stakes positioned along/after the ramp
        const x1 = 280.0;
        if (!isInPit(x1, 35.0)) {
          chunk.hazards.add(
            TrafficBarrierHazard(
              position: Vector2(x1, chunk.getSurfaceY(sx + x1)),
              barrierWidth: 44.0,
              barrierHeight: 38.0,
              biome: b,
            ),
          );
        }
        // If high tier (>= 3): add a flying security drone overhead
        if (tier >= 3) {
          const x2 = 110.0;
          if (!isInPit(x2, 35.0)) {
            chunk.hazards.add(
              HoverDroneHazard(
                position: Vector2(x2, chunk.getSurfaceY(sx + x2) - 75.0),
                biome: b,
                patrolDistance: 35.0,
                patrolSpeed: 70.0 + tier * 5.0,
              ),
            );
          }
        }
        break;

      case SegmentGameplayEvent.alleyDroneEncounter:
        // Security drone patrolling in the alley
        const x1 = 250.0;
        if (!isInPit(x1, 35.0)) {
          chunk.hazards.add(
            HoverDroneHazard(
              position: Vector2(x1, chunk.getSurfaceY(sx + x1) - 72.0),
              biome: b,
              patrolDistance: 65.0,
              patrolSpeed: 75.0 + tier * 6.0,
            ),
          );
        }
        // If tier >= 3: ground bug crawler
        if (tier >= 3) {
          const x2 = 410.0;
          if (!isInPit(x2, 35.0)) {
            chunk.hazards.add(
              BugCrawler(
                position: Vector2(x2, chunk.getSurfaceY(sx + x2)),
                speed: 170.0 + tier * 8.0,
                biome: b,
              ),
            );
          }
        }
        break;

      case SegmentGameplayEvent.industrialContainerVault:
        // Cargo container requiring JUMP or slash
        const x1 = 220.0;
        if (!isInPit(x1, 35.0)) {
          chunk.hazards.add(
            TrafficBarrierHazard(
              position: Vector2(x1, chunk.getSurfaceY(sx + x1)),
              barrierWidth: 50.0,
              barrierHeight: 42.0,
              isCargoContainer: true,
              biome: b,
            ),
          );
        }
        if (tier >= 3) {
          const x2 = 390.0;
          if (!isInPit(x2, 35.0)) {
            final y2 = chunk.getSurfaceY(sx + x2) - 58.0;
            chunk.hazards.add(
              LowPipeHazard(position: Vector2(x2, y2), biome: b),
            );
          }
        }
        break;

      case SegmentGameplayEvent.hologramLaserGateTiming:
        // Pulsing security laser gate (high beam: slide under)
        const x1 = 240.0;
        if (!isInPit(x1, 35.0)) {
          chunk.hazards.add(
            LaserGateHazard(
              position: Vector2(x1, chunk.getSurfaceY(sx + x1)),
              isHighBeam: true,
              biome: b,
            ),
          );
        }
        if (tier >= 4) {
          // Additional ground laser gate or droid with safe 180px separation
          const x2 = 420.0;
          if (!isInPit(x2, 35.0)) {
            chunk.hazards.add(
              LaserGateHazard(
                position: Vector2(x2, chunk.getSurfaceY(sx + x2)),
                isHighBeam: false,
                biome: b,
              ),
            );
          }
        }
        break;

      case SegmentGameplayEvent.darkReactionGauntlet:
        // Fast reaction: Spikes at x = 160 followed by BugCrawler at x = 360
        const x1 = 160.0;
        if (!isInPit(x1, 35.0)) {
          chunk.hazards.add(
            _createTrackStakes(
              chunk,
              x1,
              chunk.getSurfaceY(sx + x1),
              spikeCount: 3,
            ),
          );
        }
        if (tier >= 2) {
          const x2 = 360.0;
          if (!isInPit(x2, 35.0)) {
            chunk.hazards.add(
              BugCrawler(
                position: Vector2(x2, chunk.getSurfaceY(sx + x2)),
                speed: 180.0 + tier * 8.0,
                biome: b,
              ),
            );
          }
        }
        break;

      case SegmentGameplayEvent.rooftopGapJump:
      case SegmentGameplayEvent.skyBridgeGapJump:
        // Gap jump across rooftop or bridge
        if (!hasPit) {
          const x1 = 250.0;
          chunk.hazards.add(
            _createTrackStakes(
              chunk,
              x1,
              chunk.getSurfaceY(sx + x1),
              spikeCount: 3,
            ),
          );
        } else if (tier >= 3) {
          // Overhead roof cannon guarding the chasm
          chunk.hazards.add(
            CyberCannon(position: Vector2(length * 0.5, roofY + 45), biome: b),
          );
        }
        break;

      case SegmentGameplayEvent.catwalkMultiJumpChain:
        // Elevated platform already spawned. Ground hazard underneath
        const x1 = 280.0;
        if (!isInPit(x1, 35.0)) {
          chunk.hazards.add(
            _createTrackDroid(
              chunk,
              x1,
              chunk.getSurfaceY(sx + x1),
              patrolDist: 60.0,
              speed: 80.0 + tier * 7.0,
            ),
          );
        }
        break;

      case SegmentGameplayEvent.runPacing:
        // Clean high-speed runway. Add single hazard if tier >= 1
        if (tier >= 1) {
          const x1 = 260.0;
          if (!isInPit(x1, 35.0)) {
            if (tier % 2 == 0) {
              chunk.hazards.add(
                _createTrackDroid(
                  chunk,
                  x1,
                  chunk.getSurfaceY(sx + x1),
                  patrolDist: 60.0,
                  speed: 85.0 + tier * 5.0,
                ),
              );
            } else {
              chunk.hazards.add(
                _createTrackStakes(
                  chunk,
                  x1,
                  chunk.getSurfaceY(sx + x1),
                  spikeCount: 3,
                ),
              );
            }
          }
        }
        break;
    }
  }
}
