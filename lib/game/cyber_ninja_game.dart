import 'dart:math';
import 'package:flame/camera.dart';
import 'package:flame/components.dart';
import 'package:flame/events.dart';
import 'package:flame/game.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../core/audio/audio_service.dart';
import '../core/constants/app_constants.dart';
import '../core/constants/game_enums.dart';
import '../core/storage/save_service.dart';
import '../core/gameplay/difficulty/difficulty_config.dart';
import '../core/gameplay/difficulty/difficulty_manager.dart';
import 'boosters/booster_manager.dart';
import 'hazards/base_hazard.dart';
import 'hazards/cyber_titan.dart';
import 'hazards/dark_box.dart';
import 'hazards/hover_drone_hazard.dart';
import 'hazards/traffic_barrier_hazard.dart';
import 'player/cyber_ninja_player.dart';
import 'player/runner_player.dart';
import 'world/chunk_models.dart';
import 'world/parallax_background.dart';
import 'world/procedural_generator.dart';

/// Immutable snapshot of the exact player, track, and camera state captured at the instant of death.
class DeathSnapshot {
  final Vector2 worldPosition;
  final int distance;
  final SectorBiome currentSector;
  final DeathType deathCause;
  final Vector2 cameraPosition;
  final DateTime timestamp;

  const DeathSnapshot({
    required this.worldPosition,
    required this.distance,
    required this.currentSector,
    required this.deathCause,
    required this.cameraPosition,
    required this.timestamp,
  });
}

class CyberNinjaRunnerGame extends FlameGame with KeyboardEvents, TapCallbacks {
  final GameMode mode;
  final SaveService saveService;
  final BoosterManager boosterManager = BoosterManager();
  final DifficultyManager difficultyManager = DifficultyManager();
  final Set<BaseHazard> _nearMissedHazards = {};

  late final RunnerPlayer player;
  late final ProceduralGenerator worldGen;

  int currentDistance = 0;
  int collectedCP = 0;
  bool isGameOver = false;
  bool isGamePaused = false;
  DeathType? lastDeathCause;

  // Screen-shake camera trauma
  double screenShakeIntensity = 0.0;
  final Random _shakeRng = Random();

  // 0.2s Slow-Motion effect on death
  double deathSlowMoTimer = 0.0;
  double deathTimeScale = 1.0;
  DeathSnapshot? _deathSnapshot;
  DeathSnapshot? get deathSnapshot => _deathSnapshot;
  double? _reviveSpotX;
  double? get reviveSpotX => _deathSnapshot?.worldPosition.x ?? _reviveSpotX;

  void shakeCamera(double intensity) {
    screenShakeIntensity = max(screenShakeIntensity, intensity);
  }

  // Callbacks for Flutter UI Overlays
  VoidCallback? onPlayerDied;
  VoidCallback? onDistanceChanged;
  void Function(SectorBiome newSector)? onSectorChanged;

  // Dynamic Sector Biome Tracker
  late SectorBiome currentSector;

  CyberNinjaRunnerGame({required this.mode, required this.saveService})
    : currentSector = ProceduralGenerator.getBiomeForDistance(0, mode: mode),
      super(camera: CameraComponent(viewport: MaxViewport()));

  @override
  Color backgroundColor() => AppConstants.backgroundDark;

  @override
  void onGameResize(Vector2 size) {
    super.onGameResize(size);
    if (isLoaded) {
      camera.viewfinder.visibleGameSize = Vector2(
        0,
        AppConstants.virtualHeight,
      );
    }
  }

  @override
  Future<void> onLoad() async {
    await super.onLoad();

    // Responsive full-screen edge-to-edge camera: fixed height (720 game units), responsive width
    if (hasLayout) {
      camera.viewfinder.visibleGameSize = Vector2(
        0,
        AppConstants.virtualHeight,
      );
    }

    // 1. Initialize Player (Cyber Ninja / Shadow Shinobi)
    final spawnPosition = Vector2(
      120,
      AppConstants.virtualHeight - AppConstants.groundHeight - 8.0,
    );
    player = CyberNinjaPlayer(
      position: spawnPosition,
      skin: saveService.player.equippedSkin,
    );
    player.onHeavyImpact = (intensity) => shakeCamera(intensity);

    // 2. Add Cyberpunk Parallax Megacity Background
    world.add(ParallaxBackground());

    // 3. Initialize World & Procedural Generator
    worldGen = ProceduralGenerator(
      gameMode: mode,
      difficultyManager: difficultyManager,
    );
    final initialChunks = worldGen.generateInitialChunks();
    for (final chunk in initialChunks) {
      world.add(chunk);
    }

    // 4. Add Player to World
    world.add(player);

    // 5. Configure Camera to track Player smoothly (horizontal follow, centered vertically)
    camera.viewfinder.anchor = const Anchor(0.25, 0.5);
    camera.viewfinder.position = Vector2(
      player.position.x,
      AppConstants.virtualHeight / 2,
    );

    // 6. Start gameplay background music
    AudioService().startGameplayMusic();
  }

  @override
  void onRemove() {
    AudioService().stopMusic();
    super.onRemove();
  }

  @override
  void update(double dt) {
    // If game is over and slow-mo has elapsed, pause further updates
    if (isGameOver && deathSlowMoTimer <= 0) return;
    if (isGamePaused) return;

    // Handle 0.2s death slow-motion timer (calculated using real unscaled dt)
    if (deathSlowMoTimer > 0) {
      deathSlowMoTimer -= dt;
      if (deathSlowMoTimer <= 0) {
        try {
          overlays.add('DeathOverlay');
        } catch (_) {}
        onPlayerDied?.call();
      }
    } else if (!player.isDead) {
      // Update active tactical module booster countdowns while ninja is actively running on track
      boosterManager.update(dt);
      difficultyManager.update(dt, currentDistance);
    }

    // Apply time dilation from death slow-mo and Matrix Slow-Mo booster
    final effectiveDt = dt * deathTimeScale * boosterManager.timeDilationFactor;
    super.update(effectiveDt);

    // Smooth camera tracking with trauma screen shake
    double shakeX = 0.0;
    double shakeY = 0.0;
    if (screenShakeIntensity > 0) {
      final currentShake = screenShakeIntensity * 16.0;
      shakeX = (_shakeRng.nextDouble() * 2 - 1) * currentShake;
      shakeY = (_shakeRng.nextDouble() * 2 - 1) * currentShake;
      screenShakeIntensity = max(0.0, screenShakeIntensity - dt * 4.0);
    }

    camera.viewfinder.position = Vector2(
      player.position.x + shakeX,
      AppConstants.virtualHeight / 2 + shakeY,
    );

    // Update Distance & Dynamic Sector Biomes
    final newDist = (player.position.x / 10).round();
    if (newDist != currentDistance) {
      currentDistance = newDist;
      onDistanceChanged?.call();

      final newSector = ProceduralGenerator.getBiomeForDistance(
        currentDistance,
        mode: mode,
      );
      if (newSector != currentSector) {
        currentSector = newSector;
        AudioService().playCheckpoint();
        onSectorChanged?.call(currentSector);
      }
    }

    // Update Procedural Chunks ahead into world
    worldGen.updateChunks(
      playerX: player.position.x,
      parentComponent: world,
      forceSafeGround:
          boosterManager.forceSafeGroundSpawn ||
          boosterManager.isSafeGroundActive,
    );
    if (boosterManager.forceSafeGroundSpawn) {
      boosterManager.forceSafeGroundSpawn = false;
    }

    // Check World Collisions
    _resolveCollisions();
  }

  void _resolveCollisions() {
    final defaultGroundY =
        AppConstants.virtualHeight - AppConstants.groundHeight - 8.0;
    bool inShadow = false;

    // 1. Locate containing active chunk for player's current horizontal position
    WorldChunk? currentChunk;
    for (final chunk in worldGen.activeChunks) {
      if (player.position.x >= chunk.startX &&
          player.position.x <= chunk.startX + chunk.length) {
        currentChunk = chunk;
        break;
      }
    }
    // Fallback to nearest active chunk if exactly on float boundary
    if (currentChunk == null && worldGen.activeChunks.isNotEmpty) {
      currentChunk = worldGen.activeChunks.reduce((a, b) {
        final distA = (player.position.x - (a.startX + a.length / 2)).abs();
        final distB = (player.position.x - (b.startX + b.length / 2)).abs();
        return distA < distB ? a : b;
      });
    }

    final targetGroundY = currentChunk != null
        ? currentChunk.getSurfaceY(player.position.x) - 8.0
        : defaultGroundY;

    // 2. Elevated Catwalk Platforms Landing & Support Check
    bool landedOnPlatform = false;
    for (final chunk in worldGen.activeChunks) {
      if (player.position.x < chunk.startX - 50 ||
          player.position.x > chunk.startX + chunk.length + 50) {
        continue;
      }
      for (final platform in chunk.elevatedPlatforms) {
        final platWorldX = chunk.startX + platform.position.x;
        final platTopY = platform.position.y;
        final platRight = platWorldX + platform.size.x;

        if (player.position.x >= platWorldX - 14 &&
            player.position.x <= platRight + 14) {
          // Continuous sweep & landing window for elevated platforms:
          // Player lands if descending/crossing platform from above, or already grounded on it
          final crossedPlatform =
              player.previousY <= platTopY + 8.0 &&
              player.position.y >= platTopY - 12.0 &&
              player.position.y <= platTopY + 36.0;
          final alreadyGroundedOnPlat =
              player.isGrounded && (player.position.y - platTopY).abs() <= 16.0;

          if ((player.velocity.y >= 0 && crossedPlatform) ||
              alreadyGroundedOnPlat) {
            player.onLand(platTopY);
            landedOnPlatform = true;
            break;
          }
        }
      }
      if (landedOnPlatform) break;
    }

    // When player was on an elevated platform and steps/jumps off into mid-air:
    if (!landedOnPlatform && player.position.y < targetGroundY - 25.0) {
      player.isGrounded = false;
    }

    // 3. Pit / Ground Collision Check (if not supported by an elevated catwalk)
    if (!landedOnPlatform && currentChunk != null) {
      final pitLeft = currentChunk.startX + currentChunk.pitStartX;
      final pitRight = pitLeft + currentChunk.pitWidth;
      final isOverPit =
          currentChunk.hasPit &&
          player.position.x >= pitLeft &&
          player.position.x <= pitRight;

      if (isOverPit && !boosterManager.isSafeGroundActive) {
        // --- REAL PIT CHASM (UNSHIELDED) ---
        // Player has no ground underneath in a real gap:
        player.isGrounded = false;
        if (player.isSliding) {
          player.stopSlide();
        }

        // When feet drop below track level into the pit opening:
        if (player.position.y > targetGroundY + 12.0) {
          player.isFallingInPit = true;

          // Right pit boundary is a solid rock wall; underground player cannot phase forward
          final rightWallLimit = pitRight - player.size.x * 0.25;
          if (player.position.x >= rightWallLimit) {
            player.position.x = rightWallLimit;
            player.velocity.x = 0;
          }

          // Fatal pit plunge: trigger game over once player has fallen visibly into the chasm
          if (player.position.y >= targetGroundY + 55.0 ||
              player.position.y >= AppConstants.virtualHeight - 20.0) {
            triggerGameOver(DeathType.fallInPit);
            return;
          }
        }
      } else {
        // --- NORMAL SOLID TRACK (OR SAFE GROUND HARD-LIGHT BRIDGE) ---
        // Ground is solid! No pit exists here.
        // As long as the player did not legitimately fall into a real pit opening:
        if (!player.isFallingInPit) {
          // A) Running along track: smoothly stick to surface along slopes and terraces
          if (player.isGrounded &&
              (player.position.y - targetGroundY).abs() <= 35.0) {
            player.onLand(targetGroundY);
          }
          // B) Descending/landing onto solid ground (continuous collision sweep):
          // Catches normal falls, jumps, double jumps, catwalk drops, and frame drops
          else if (player.velocity.y >= 0 &&
              player.position.y >= targetGroundY) {
            player.onLand(targetGroundY);
          }
        }
      }
    }

    // 4. Universal Pit / Abyss Fall Safeguard (Evaluated AFTER solid ground resolution)
    // Only fires if player has truly plunged below the track into the abyss (e.g. through a real pit)
    if (player.position.y >= AppConstants.virtualHeight - 15.0 ||
        player.position.y >= targetGroundY + 75.0) {
      if (!boosterManager.isSafeGroundActive) {
        triggerGameOver(DeathType.fallInPit);
        return;
      }
    }

    // 5. Shadow Havens & Collectibles Collisions
    for (final chunk in worldGen.activeChunks) {
      if (player.position.x < chunk.startX - 50 ||
          player.position.x > chunk.startX + chunk.length + 50) {
        continue;
      }

      // Shadow Havens Collision
      for (final haven in chunk.shadowHavens) {
        final havenWorldX = chunk.startX + haven.position.x;
        final havenWorldY = haven.position.y;
        final havenRect = Rect.fromLTWH(
          havenWorldX,
          havenWorldY - haven.size.y,
          haven.size.x,
          haven.size.y,
        );
        final playerRect = Rect.fromLTWH(
          player.position.x - player.size.x / 2,
          player.position.y - player.size.y,
          player.size.x,
          player.size.y,
        );
        if (playerRect.overlaps(havenRect)) {
          inShadow = true;
          break;
        }
      }

      // Collectible CP Items
      for (final cp in chunk.collectibles) {
        if (!cp.isCollected) {
          final cpWorldX = chunk.startX + cp.position.x;
          final cpWorldY = cp.position.y;
          final cpDist =
              (Vector2(cpWorldX, cpWorldY) -
                      (player.position - Vector2(0, player.size.y / 2)))
                  .length;
          if (cpDist < 30.0) {
            cp.isCollected = true;
            final cpMultiplier = mode == GameMode.tenXChallenge ? 10 : 1;
            collectedCP += cpMultiplier;
            saveService.addCyberPoints(cpMultiplier);
            AudioService().playCollect();
          }
        }
      }
    }

    // 4. Hazard Collisions & Dual Katana Sword Slicing
    for (final chunk in worldGen.activeChunks) {
      if (player.position.x >= chunk.startX - 650 &&
          player.position.x <= chunk.startX + chunk.length + 100) {
        final hazardsToDestroy = <BaseHazard>[];
        for (final hazard in chunk.hazards) {
          if (boosterManager.isInvisibilityActive &&
              (hazard.obstacleType == ObstacleType.roofCannon ||
                  hazard.obstacleType == ObstacleType.cyberCannon ||
                  hazard.obstacleType == ObstacleType.darkBox ||
                  hazard.obstacleType == ObstacleType.cyberTitan ||
                  hazard.obstacleType == ObstacleType.bugCrawler)) {
            continue;
          }
          if (hazard is DarkBox &&
              hazard.isSliced &&
              hazard.sliceTimer <= 0.0) {
            hazardsToDestroy.add(hazard);
            continue;
          }
          if (hazard is CyberTitan &&
              hazard.isSliced &&
              hazard.sliceTimer <= 0.0) {
            hazardsToDestroy.add(hazard);
            continue;
          }
          if (hazard is HoverDroneHazard &&
              hazard.isSliced &&
              hazard.sliceTimer <= 0.0) {
            hazardsToDestroy.add(hazard);
            continue;
          }
          if (hazard is TrafficBarrierHazard &&
              hazard.isShattered &&
              hazard.shatterTimer <= 0.0) {
            hazardsToDestroy.add(hazard);
            continue;
          }

          // Dual Katana Slash extended strike zone check (sword blade reach in front of ninja)
          if (player.isSlashing &&
              (hazard.obstacleType == ObstacleType.darkBox ||
                  hazard.obstacleType == ObstacleType.cyberTitan ||
                  hazard.obstacleType == ObstacleType.bugCrawler ||
                  hazard.obstacleType == ObstacleType.hoverDrone ||
                  hazard.obstacleType == ObstacleType.trafficBarrier)) {
            final hPos = hazard.worldPosition;
            final inStrikeX =
                (hPos.x - player.position.x) > -45.0 &&
                (hPos.x - player.position.x) < (player.size.x + 160.0);
            final inStrikeY = (hPos.y - player.position.y).abs() < 120.0;

            if (inStrikeX && inStrikeY) {
              if (hazard is DarkBox) {
                if (!hazard.isSliced) {
                  hazard.sliceAndDestroy();
                  shakeCamera(0.60);
                  AudioService().playSlash();
                  AudioService().playEnemyDestroy();
                  final cpBonus = mode == GameMode.tenXChallenge ? 50 : 25;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else if (hazard is CyberTitan) {
                if (!hazard.isSliced) {
                  hazard.takeDamage(amount: 1);
                  shakeCamera(0.80); // massive boss explosion shake
                  AudioService().playSlash();
                  if (hazard.isSliced) {
                    AudioService().playEnemyDestroy();
                    final cpBonus = mode == GameMode.tenXChallenge ? 500 : 200;
                    collectedCP += cpBonus;
                    saveService.addCyberPoints(cpBonus);
                  }
                }
              } else if (hazard is HoverDroneHazard) {
                if (!hazard.isSliced) {
                  hazard.sliceAndDestroy();
                  shakeCamera(0.55);
                  AudioService().playSlash();
                  AudioService().playEnemyDestroy();
                  final cpBonus = mode == GameMode.tenXChallenge ? 60 : 30;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else if (hazard is TrafficBarrierHazard) {
                if (!hazard.isShattered) {
                  hazard.shatter();
                  shakeCamera(0.50);
                  AudioService().playSlash();
                  AudioService().playEnemyDestroy();
                  final cpBonus = mode == GameMode.tenXChallenge ? 40 : 20;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else {
                hazardsToDestroy.add(hazard);
                shakeCamera(0.45);
                AudioService().playSlash();
                AudioService().playEnemyDestroy();
                final cpBonus = mode == GameMode.tenXChallenge ? 50 : 15;
                collectedCP += cpBonus;
                saveService.addCyberPoints(cpBonus);
              }
              continue;
            }
          }

          if (hazard.checkCollision(player)) {
            // Dual Katana Slash destroys sliceable melee hazards on contact!
            // Note: Projectiles/bullets from CyberTitan and DarkBox are lethal and cannot be destroyed on contact
            if (player.isSlashing &&
                (hazard.obstacleType == ObstacleType.bugCrawler ||
                    hazard.obstacleType == ObstacleType.hoverDrone ||
                    hazard.obstacleType == ObstacleType.trafficBarrier)) {
              if (hazard is HoverDroneHazard) {
                if (!hazard.isSliced) {
                  hazard.sliceAndDestroy();
                  shakeCamera(0.55);
                  AudioService().playSlash();
                  AudioService().playEnemyDestroy();
                  final cpBonus = mode == GameMode.tenXChallenge ? 60 : 30;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else if (hazard is TrafficBarrierHazard) {
                if (!hazard.isShattered) {
                  hazard.shatter();
                  shakeCamera(0.50);
                  AudioService().playSlash();
                  AudioService().playEnemyDestroy();
                  final cpBonus = mode == GameMode.tenXChallenge ? 40 : 20;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else {
                hazardsToDestroy.add(hazard);
                shakeCamera(0.40);
                AudioService().playSlash();
                AudioService().playEnemyDestroy();
                final cpBonus = mode == GameMode.tenXChallenge ? 50 : 15;
                collectedCP += cpBonus;
                saveService.addCyberPoints(cpBonus);
              }
              continue;
            }

            if (!boosterManager.isInvisibilityActive &&
                !boosterManager.isSafeGroundActive) {
              triggerGameOver(hazard.deathType);
              return;
            }
          } else if (!_nearMissedHazards.contains(hazard) &&
              !player.isStealthActive &&
              !boosterManager.isInvisibilityActive) {
            final hPos = hazard.worldPosition;
            final pRect = Rect.fromLTWH(
              player.position.x - player.size.x / 2 + 10,
              player.position.y - player.size.y + 10,
              player.size.x - 20,
              player.size.y - 10,
            );
            final hRect = Rect.fromLTWH(
              hPos.x - hazard.size.x / 2,
              hPos.y - hazard.size.y,
              hazard.size.x,
              hazard.size.y,
            );
            final dx = max(
              0.0,
              max(pRect.left - hRect.right, hRect.left - pRect.right),
            );
            final dy = max(
              0.0,
              max(pRect.top - hRect.bottom, hRect.top - pRect.bottom),
            );
            final clearance = sqrt(dx * dx + dy * dy);
            if (clearance > 0.0 &&
                clearance <= DifficultyConfig.nearMissProximityPixels) {
              _nearMissedHazards.add(hazard);
              difficultyManager.recordNearMiss();
              const bonus = DifficultyConfig.nearMissCPBonus;
              collectedCP += bonus;
              saveService.addCyberPoints(bonus);
              AudioService().triggerHaptic();
            }
          }
        }
        for (final h in hazardsToDestroy) {
          h.removeFromParent();
          chunk.hazards.remove(h);
        }
        _nearMissedHazards.removeWhere((h) => h.isRemoved || h.parent == null);
      }
    }

    // Safety ground check during active Safe Ground booster
    if (boosterManager.isSafeGroundActive &&
        player.position.y > targetGroundY) {
      player.onLand(targetGroundY);
      player.position.y = targetGroundY;
      player.velocity.y = 0;
      player.isGrounded = true;
    }

    player.hideController.isNearShadowZone = inShadow;
  }

  void triggerGameOver(DeathType cause) {
    // Safe Ground Protection: Kinetic shield prevents any fatal damage or falling death!
    if (boosterManager.isSafeGroundActive) {
      return;
    }
    // Invisibility Protection: Ninja ONLY dies by falling into a pit!
    if (boosterManager.isInvisibilityActive && cause != DeathType.fallInPit) {
      return;
    }
    if (isGameOver) return;
    isGameOver = true;

    // Capture exact, immutable death snapshot ONCE at the instant of death
    final exactWorldPos = player.position.clone();
    final exactCamPos = camera.viewfinder.position.clone();
    _deathSnapshot = DeathSnapshot(
      worldPosition: exactWorldPos,
      distance: currentDistance,
      currentSector: currentSector,
      deathCause: cause,
      cameraPosition: exactCamPos,
      timestamp: DateTime.now(),
    );
    _reviveSpotX = exactWorldPos.x;
    debugPrint(
      'REVIVE_DEBUG: SNAPSHOT_CAPTURED worldX=${exactWorldPos.x} '
      'worldY=${exactWorldPos.y} dist=$currentDistance cause=$cause',
    );

    lastDeathCause = cause;
    AudioService().resetCombo();
    player.isDead = true;
    AudioService().stopMusic();
    AudioService().playDeath();

    // 1. Camera screen-shake effect (using camera controller)
    shakeCamera(2.2);

    // 2. 0.2s slow-motion effect when player dies
    deathSlowMoTimer = 0.2; // 0.2s real-world slow-motion window
    deathTimeScale = 0.18; // Slows down game time during impact

    // Persist run results to local storage
    saveService.recordRunResult(
      mode: mode,
      distance: currentDistance,
      jumps: player.jumpCount,
      shadowHides: player.hideController.isStealthActive ? 1 : 0,
    );
  }

  void revivePlayer() {
    // Guard against multiple or invalid revive invocations
    if (_deathSnapshot == null && _reviveSpotX == null) {
      debugPrint('REVIVE_DEBUG: No active death snapshot found to revive.');
      return;
    }

    final deathPos =
        _deathSnapshot?.worldPosition ??
        Vector2(_reviveSpotX!, player.position.y);
    final deathDist = _deathSnapshot?.distance ?? (deathPos.x / 10).round();

    isGameOver = false;
    player.isDead = false;
    deathSlowMoTimer = 0.0;
    deathTimeScale = 1.0;

    // 1. Restore exact horizontal death position (NO artificial offsets!)
    player.position.x = deathPos.x;

    // 2. Determine surface ground elevation at restored death coordinate
    double targetGroundY =
        AppConstants.virtualHeight - AppConstants.groundHeight - 8.0;
    for (final chunk in worldGen.activeChunks) {
      if (player.position.x >= chunk.startX &&
          player.position.x <= chunk.startX + chunk.length) {
        targetGroundY = chunk.getSurfaceY(player.position.x) - 8.0;
        break;
      }
    }
    player.position.y = targetGroundY;
    player.velocity = Vector2.zero();
    player.isGrounded = true;
    player.isFallingInPit = false;
    player.isSliding = false;
    player.isSlashing = false;

    // 3. Synchronize distance with exact revived position
    currentDistance = deathDist;
    onDistanceChanged?.call();

    // 4. Synchronize camera immediately to eliminate visual displacement
    screenShakeIntensity = 0.0;
    camera.viewfinder.position = Vector2(
      player.position.x,
      AppConstants.virtualHeight / 2,
    );

    debugPrint(
      'REVIVE_DEBUG: RESTORED_EXACT_POSITION worldX=${player.position.x} '
      'worldY=${player.position.y} dist=$currentDistance cameraX=${camera.viewfinder.position.x}',
    );

    // 5. Invalidate snapshot to prevent stale reuse
    _deathSnapshot = null;
    _reviveSpotX = null;

    // 6. Clear any overlapping hazards directly in contact with the player at spawn
    for (final chunk in worldGen.activeChunks) {
      chunk.hazards.removeWhere((hazard) {
        final hPos = hazard.worldPosition;
        if ((hPos.x - player.position.x).abs() < 60.0 &&
            (hPos.y - player.position.y).abs() < 90.0) {
          hazard.removeFromParent();
          return true;
        }
        return false;
      });
    }

    // 7. 100% Respawn Invulnerability (I-Frames):
    // Invisibility gives hazard & enemy immunity + purple phantom visuals
    // Safe Ground creates hard-light bridge over any pits so player never falls into a chasm
    boosterManager.activateBooster(BoosterType.invisibility);
    boosterManager.activateBooster(BoosterType.safeGround);
    _nearMissedHazards.clear();

    try {
      overlays.remove('DeathOverlay');
    } catch (_) {}
    AudioService().startGameplayMusic();
  }

  /// Restarts the mission completely from 0 meters
  void restartMission() {
    isGameOver = false;
    isGamePaused = false;
    lastDeathCause = null;
    _deathSnapshot = null;
    _reviveSpotX = null;
    deathSlowMoTimer = 0.0;
    deathTimeScale = 1.0;
    currentDistance = 0;
    collectedCP = 0;
    AudioService().resetCombo();
    screenShakeIntensity = 0.0;
    currentSector = ProceduralGenerator.getBiomeForDistance(0, mode: mode);
    _nearMissedHazards.clear();
    difficultyManager.reset();

    // Reset player position & state to launch coordinates
    final spawnPosition = Vector2(
      120,
      AppConstants.virtualHeight - AppConstants.groundHeight - 8.0,
    );
    player.isDead = false;
    player.position = spawnPosition;
    player.velocity = Vector2.zero();
    player.isGrounded = true;
    player.isFallingInPit = false;
    player.isSliding = false;
    player.isSlashing = false;
    player.jumpCount = 0;
    player.hideController.isStealthActive = false;

    // Reset active Boosters
    boosterManager.reset();

    // Clear world chunks and re-generate initial sector
    for (final chunk in worldGen.activeChunks) {
      chunk.removeFromParent();
    }
    final initialChunks = worldGen.generateInitialChunks();
    for (final chunk in initialChunks) {
      world.add(chunk);
    }

    // Reset camera viewfinder to origin
    camera.viewfinder.position = Vector2(
      player.position.x,
      AppConstants.virtualHeight / 2,
    );

    overlays.remove('DeathOverlay');
    overlays.remove('PauseOverlay');
    AudioService().startGameplayMusic();
    onDistanceChanged?.call();
    onSectorChanged?.call(currentSector);
  }

  void pauseGame() {
    isGamePaused = true;
    AudioService().pauseMusic();
    overlays.add('PauseOverlay');
  }

  void resumeGame() {
    isGamePaused = false;
    AudioService().resumeMusic();
    overlays.remove('PauseOverlay');
  }

  /// Triggers full-screen EMP Shockwave that destroys all active sentries, obstacles & enemies
  void triggerEmpShockwave() {
    boosterManager.activateBooster(BoosterType.killEyes);
    AudioService().playSfx('laser');
    AudioService().playBooster();

    // Heavy screen shake impact
    shakeCamera(2.2);

    // Multi-layered visual EMP blast shockwaves centered at player position
    final centerPos = player.position.clone() - Vector2(0, player.size.y / 2);
    player.shockwaves.add(
      ShockwaveRing(
        position: centerPos,
        radius: 14.0,
        maxRadius: 850.0,
        alpha: 1.0,
        color: const Color(0xFFFF3366), // Crimson EMP Wave
      ),
    );
    player.shockwaves.add(
      ShockwaveRing(
        position: centerPos,
        radius: 10.0,
        maxRadius: 720.0,
        alpha: 0.9,
        color: const Color(0xFF00E5FF), // Electric Blue Ion Ring
      ),
    );
    player.shockwaves.add(
      ShockwaveRing(
        position: centerPos,
        radius: 6.0,
        maxRadius: 600.0,
        alpha: 0.8,
        color: Colors.white, // Core plasma flash
      ),
    );

    // Destroy all active on-screen hazards & enemies
    int neutralizedCount = 0;
    for (final chunk in worldGen.activeChunks) {
      final hazardsToDestroy = <BaseHazard>[];
      for (final hazard in chunk.hazards) {
        final hPos = hazard.worldPosition;
        if (hPos.x >= player.position.x - 180.0 &&
            hPos.x <= player.position.x + 950.0) {
          if (hazard is DarkBox) {
            if (!hazard.isSliced) {
              hazard.sliceAndDestroy();
              neutralizedCount++;
            }
          } else if (hazard is CyberTitan) {
            if (!hazard.isSliced) {
              hazard.takeDamage(amount: 3);
              neutralizedCount += 2;
            }
          } else {
            hazardsToDestroy.add(hazard);
            neutralizedCount++;
          }
        }
      }
      for (final h in hazardsToDestroy) {
        h.removeFromParent();
        chunk.hazards.remove(h);
      }
    }

    if (neutralizedCount > 0) {
      final cpBonus =
          neutralizedCount * (mode == GameMode.tenXChallenge ? 60 : 30);
      collectedCP += cpBonus;
      saveService.addCyberPoints(cpBonus);
    }
  }

  // Touch and Gesture Controls - Jump only triggers via on-screen Jump Button
  @override
  void onTapDown(TapDownEvent event) {
    // Screen tap jump disabled: Jump triggers strictly via Jump button.
  }

  // Keyboard controls for PC / Web / Emulator testing
  @override
  KeyEventResult onKeyEvent(
    KeyEvent event,
    Set<LogicalKeyboardKey> keysPressed,
  ) {
    if (isGameOver || isGamePaused) return KeyEventResult.ignored;

    if (event is KeyDownEvent) {
      if (event.logicalKey == LogicalKeyboardKey.space ||
          event.logicalKey == LogicalKeyboardKey.arrowUp ||
          event.logicalKey == LogicalKeyboardKey.keyW) {
        player.jump();
        return KeyEventResult.handled;
      }

      if (event.logicalKey == LogicalKeyboardKey.arrowDown ||
          event.logicalKey == LogicalKeyboardKey.keyS ||
          event.logicalKey == LogicalKeyboardKey.shiftLeft) {
        player.startSlide();
        return KeyEventResult.handled;
      }

      // Boosters activation shortcut
      if (event.logicalKey == LogicalKeyboardKey.digit1) {
        if (saveService.useBooster(BoosterType.safeGround)) {
          boosterManager.activateBooster(BoosterType.safeGround);
          AudioService().playBooster();
        }
        return KeyEventResult.handled;
      }
      if (event.logicalKey == LogicalKeyboardKey.digit2) {
        if (saveService.useBooster(BoosterType.matrixSlowMo)) {
          boosterManager.activateBooster(BoosterType.matrixSlowMo);
          AudioService().playBooster();
        }
        return KeyEventResult.handled;
      }
      if (event.logicalKey == LogicalKeyboardKey.digit3) {
        if (saveService.useBooster(BoosterType.invisibility)) {
          boosterManager.activateBooster(BoosterType.invisibility);
          AudioService().playBooster();
        }
        return KeyEventResult.handled;
      }
      if (event.logicalKey == LogicalKeyboardKey.digit4) {
        if (saveService.useBooster(BoosterType.killEyes)) {
          triggerEmpShockwave();
        }
        return KeyEventResult.handled;
      }
    } else if (event is KeyUpEvent) {
      if (event.logicalKey == LogicalKeyboardKey.arrowDown ||
          event.logicalKey == LogicalKeyboardKey.keyS ||
          event.logicalKey == LogicalKeyboardKey.shiftLeft) {
        player.stopSlide();
        return KeyEventResult.handled;
      }
    }

    return KeyEventResult.ignored;
  }
}

/// Compatibility aliases for game class
typedef SqubeGame = CyberNinjaRunnerGame;
typedef CyberNinjaGame = CyberNinjaRunnerGame;
