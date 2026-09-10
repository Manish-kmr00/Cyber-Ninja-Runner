import 'dart:math';
import 'package:flame/components.dart';
import 'package:flame/events.dart';
import 'package:flame/game.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../core/audio/audio_service.dart';
import '../core/constants/app_constants.dart';
import '../core/constants/game_enums.dart';
import '../core/storage/save_service.dart';
import 'boosters/booster_manager.dart';
import 'hazards/base_hazard.dart';
import 'hazards/cyber_titan.dart';
import 'hazards/dark_box.dart';
import 'player/cyber_ninja_player.dart';
import 'player/runner_player.dart';
import 'world/parallax_background.dart';
import 'world/procedural_generator.dart';

class CyberNinjaRunnerGame extends FlameGame with KeyboardEvents, TapCallbacks {
  final GameMode mode;
  final SaveService saveService;
  final BoosterManager boosterManager = BoosterManager();

  late final RunnerPlayer player;
  late final ProceduralGenerator worldGen;

  int currentDistance = 0;
  int collectedCP = 0;
  bool isGameOver = false;
  bool isGamePaused = false;

  // Screen-shake camera trauma
  double screenShakeIntensity = 0.0;
  final Random _shakeRng = Random();

  // 0.2s Slow-Motion effect on death
  double deathSlowMoTimer = 0.0;
  double deathTimeScale = 1.0;

  void shakeCamera(double intensity) {
    screenShakeIntensity = max(screenShakeIntensity, intensity);
  }

  // Callbacks for Flutter UI Overlays
  VoidCallback? onPlayerDied;
  VoidCallback? onDistanceChanged;
  void Function(SectorBiome newSector)? onSectorChanged;

  // Dynamic Sector Biome Tracker
  SectorBiome currentSector = SectorBiome.neonMetropolis;

  // Developer Test Mode (Player Immortality / God Mode)
  bool get godMode => saveService.settings.godModeEnabled;

  CyberNinjaRunnerGame({required this.mode, required this.saveService})
    : super(
        camera: CameraComponent.withFixedResolution(
          width: AppConstants.virtualWidth,
          height: AppConstants.virtualHeight,
        ),
      );

  @override
  Color backgroundColor() => AppConstants.backgroundDark;

  @override
  Future<void> onLoad() async {
    await super.onLoad();

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
    worldGen = ProceduralGenerator();
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
        deathTimeScale = 1.0;
        overlays.add('DeathOverlay');
        onPlayerDied?.call();
      }
    }

    // Apply time dilation from death slow-mo and Matrix Slow-Mo booster
    final effectiveDt = dt * deathTimeScale * boosterManager.timeDilationFactor;
    boosterManager.update(dt * deathTimeScale);

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
      );
      if (newSector != currentSector) {
        currentSector = newSector;
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
    final groundLevelY =
        AppConstants.virtualHeight - AppConstants.groundHeight - 8.0;
    bool inShadow = false;

    // Iterate through active chunks near the player
    for (final chunk in worldGen.activeChunks) {
      if (player.position.x < chunk.startX ||
          player.position.x > chunk.startX + chunk.length) {
        continue;
      }

      // 1. Elevated Catwalk Platforms Landing Check
      bool landedOnPlatform = false;
      for (final platform in chunk.elevatedPlatforms) {
        final platWorldX = chunk.startX + platform.position.x;
        final platTopY = platform.position.y;
        if (player.position.x >= platWorldX - 14 &&
            player.position.x <= platWorldX + platform.size.x + 14) {
          // If player is falling downwards near platform surface
          if (player.velocity.y >= 0 &&
              player.position.y >= platTopY - 12 &&
              player.position.y <= platTopY + 28) {
            player.onLand(platTopY);
            landedOnPlatform = true;
            break;
          }
        }
      }

      // 2. Pit / Ground Collision Check (if not landed on an elevated catwalk)
      if (!landedOnPlatform) {
        if (chunk.hasPit &&
            player.position.x >= chunk.startX + chunk.pitStartX &&
            player.position.x <=
                chunk.startX + chunk.pitStartX + chunk.pitWidth) {
          if (godMode || boosterManager.isSafeGroundActive) {
            // Safe Ground Pack / GodMode: Hard-light safe bridge over pit so player never falls
            if (player.position.y >= groundLevelY) {
              player.onLand(groundLevelY);
            }
          } else {
            // Over a pit! Player falls
            player.isGrounded = false;
            if (player.position.y > AppConstants.virtualHeight + 80) {
              triggerGameOver(DeathType.fallInPit);
              return;
            }
          }
        } else {
          // Solid ground check
          if (player.position.y >= groundLevelY) {
            player.onLand(groundLevelY);
          }
        }
      }

      // 2. Shadow Havens Collision
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

      // 3. Collectible CP Items
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
              (hazard.obstacleType == ObstacleType.darkEye ||
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

          // Dual Katana Slash extended strike zone check (sword blade reach in front of ninja)
          if (player.isSlashing &&
              (hazard.obstacleType == ObstacleType.darkBox ||
                  hazard.obstacleType == ObstacleType.cyberTitan ||
                  hazard.obstacleType == ObstacleType.bugCrawler)) {
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
                  AudioService().playClick();
                  AudioService().playSfx('laser');
                  final cpBonus = mode == GameMode.tenXChallenge ? 50 : 25;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else if (hazard is CyberTitan) {
                if (!hazard.isSliced) {
                  hazard.takeDamage(amount: 1);
                  shakeCamera(0.80); // massive boss explosion shake
                  AudioService().playClick();
                  AudioService().playSfx('laser');
                  if (hazard.isSliced) {
                    final cpBonus = mode == GameMode.tenXChallenge ? 500 : 200;
                    collectedCP += cpBonus;
                    saveService.addCyberPoints(cpBonus);
                  }
                }
              } else {
                hazardsToDestroy.add(hazard);
                shakeCamera(0.45);
                AudioService().playClick();
                final cpBonus = mode == GameMode.tenXChallenge ? 50 : 15;
                collectedCP += cpBonus;
                saveService.addCyberPoints(cpBonus);
              }
              continue;
            }
          }

          if (hazard.checkCollision(player)) {
            // Dual Katana Slash destroys patrol robots, cyber titans & bug crawlers on contact!
            if (player.isSlashing &&
                (hazard.obstacleType == ObstacleType.darkBox ||
                    hazard.obstacleType == ObstacleType.cyberTitan ||
                    hazard.obstacleType == ObstacleType.bugCrawler)) {
              if (hazard is DarkBox) {
                if (!hazard.isSliced) {
                  hazard.sliceAndDestroy();
                  shakeCamera(0.60);
                  AudioService().playClick();
                  AudioService().playSfx('laser');
                  final cpBonus = mode == GameMode.tenXChallenge ? 50 : 25;
                  collectedCP += cpBonus;
                  saveService.addCyberPoints(cpBonus);
                }
              } else if (hazard is CyberTitan) {
                if (!hazard.isSliced) {
                  hazard.takeDamage(amount: 1);
                  shakeCamera(0.80);
                  AudioService().playClick();
                  AudioService().playSfx('laser');
                  if (hazard.isSliced) {
                    final cpBonus = mode == GameMode.tenXChallenge ? 500 : 200;
                    collectedCP += cpBonus;
                    saveService.addCyberPoints(cpBonus);
                  }
                }
              } else {
                hazardsToDestroy.add(hazard);
                shakeCamera(0.40);
                AudioService().playClick();
                final cpBonus = mode == GameMode.tenXChallenge ? 50 : 15;
                collectedCP += cpBonus;
                saveService.addCyberPoints(cpBonus);
              }
              continue;
            }
            if (!godMode &&
                !boosterManager.isInvisibilityActive &&
                !boosterManager.isSafeGroundActive) {
              triggerGameOver(hazard.deathType);
              return;
            }
          }
        }
        for (final h in hazardsToDestroy) {
          h.removeFromParent();
          chunk.hazards.remove(h);
        }
      }
    }

    // Safety ground check during test mode or active Safe Ground booster
    if ((godMode || boosterManager.isSafeGroundActive) &&
        player.position.y > groundLevelY) {
      player.onLand(groundLevelY);
      player.position.y = groundLevelY;
      player.velocity.y = 0;
      player.isGrounded = true;
    }

    player.hideController.isNearShadowZone = inShadow;
  }

  void triggerGameOver(DeathType cause) {
    if (godMode) {
      return; // IMMORTAL: Player cannot die while game testing is active!
    }
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
    player.isDead = true;
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
    isGameOver = false;
    player.isDead = false;
    deathSlowMoTimer = 0.0;
    deathTimeScale = 1.0;
    player.position.y =
        AppConstants.virtualHeight - AppConstants.groundHeight - 8.0;
    player.velocity = Vector2.zero();
    boosterManager.activateBooster(
      BoosterType.invisibility,
    ); // Give temporary invulnerability on revive
    overlays.remove('DeathOverlay');
  }

  void pauseGame() {
    isGamePaused = true;
    overlays.add('PauseOverlay');
  }

  void resumeGame() {
    isGamePaused = false;
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
        AudioService().playJump();
        return KeyEventResult.handled;
      }

      if (event.logicalKey == LogicalKeyboardKey.arrowDown ||
          event.logicalKey == LogicalKeyboardKey.keyS ||
          event.logicalKey == LogicalKeyboardKey.shiftLeft) {
        player.startSlide();
        AudioService().playSlide();
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
