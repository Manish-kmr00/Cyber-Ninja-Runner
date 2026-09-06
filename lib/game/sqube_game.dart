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
import 'player/sqube_player.dart';
import 'world/parallax_background.dart';
import 'world/procedural_generator.dart';

class SqubeGame extends FlameGame with KeyboardEvents, TapCallbacks {
  final GameMode mode;
  final SaveService saveService;
  final BoosterManager boosterManager = BoosterManager();

  late final SqubePlayer player;
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
  bool godMode = AppConstants.testGodMode;

  SqubeGame({required this.mode, required this.saveService})
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
    boosterManager.update(effectiveDt);

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
      forceSafeGround: boosterManager.forceSafeGroundSpawn,
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
          if (godMode) {
            // Developer Test Mode: Safe invisible bridge over pit so player never falls or gets trapped
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
            saveService.addCubePoints(cpMultiplier);
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
          if ((hazard.obstacleType == ObstacleType.darkEye ||
                  hazard.obstacleType == ObstacleType.cyberCannon) &&
              boosterManager.isInvisibilityActive) {
            continue;
          }
          if (hazard.checkCollision(player)) {
            // Dual Katana Slash destroys patrol robots & bug crawlers!
            if (player.isSlashing &&
                (hazard.obstacleType == ObstacleType.darkBox ||
                    hazard.obstacleType == ObstacleType.bugCrawler)) {
              hazardsToDestroy.add(hazard);
              shakeCamera(0.40);
              AudioService().playClick();
              final cpBonus = mode == GameMode.tenXChallenge ? 50 : 15;
              collectedCP += cpBonus;
              saveService.addCubePoints(cpBonus);
              continue;
            }
            if (!godMode) {
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

    // Safety ground check during test mode
    if (godMode && player.position.y > groundLevelY) {
      player.onLand(groundLevelY);
    }

    player.hideController.isNearShadowZone = inShadow;
  }

  void triggerGameOver(DeathType cause) {
    if (godMode) {
      return; // IMMORTAL: Player cannot die while game testing is active!
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

  // Touch and Gesture Controls
  @override
  void onTapDown(TapDownEvent event) {
    if (isGameOver || isGamePaused) return;
    if (player.isGrounded || player.canDoubleJump) {
      player.jump();
      AudioService().playJump();
    }
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

/// CyberNinjaGame alias for modern branding
typedef CyberNinjaGame = SqubeGame;
