import 'package:flame/components.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/constants/app_constants.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/game/cyber_ninja_game.dart';
import 'package:cyber_ninja_runner/game/world/chunk_models.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    SharedPreferences.setMockInitialValues({});
  });

  group('Pit Falling & Fatal Abyss Tests', () {
    test(
      'Player walking into an unshielded pit falls and dies from DeathType.fallInPit',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        // Clear world chunks and add a custom chunk with a pit
        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final pitChunk = WorldChunk(
          startX: 0,
          length: 500,
          groundY: groundY,
          roofY: 0,
          hasPit: true,
          pitStartX: 100,
          pitWidth: 150,
        );
        game.world.add(pitChunk);
        game.worldGen.activeChunks.add(pitChunk);

        // Place player right at the entrance of the pit
        final targetGroundY = pitChunk.getSurfaceY(100) - 8.0;
        game.player.position = Vector2(110, targetGroundY);
        game.player.velocity = Vector2(250, 0);
        game.player.isGrounded = true;

        expect(game.isGameOver, isFalse);

        // Simulate physics frames stepping into the pit
        for (int i = 0; i < 30; i++) {
          game.update(0.016);
          if (game.isGameOver) break;
        }

        // Player must have fallen into the pit and died!
        expect(game.isGameOver, isTrue);
        expect(game.player.isDead, isTrue);
        expect(game.lastDeathCause, DeathType.fallInPit);
      },
    );

    test(
      'Safe Ground booster protects player over pit and prevents falling death',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final pitChunk = WorldChunk(
          startX: 0,
          length: 500,
          groundY: groundY,
          roofY: 0,
          hasPit: true,
          pitStartX: 100,
          pitWidth: 150,
        );
        game.world.add(pitChunk);
        game.worldGen.activeChunks.add(pitChunk);

        // Activate Safe Ground booster
        game.boosterManager.activateBooster(BoosterType.safeGround);
        expect(game.boosterManager.isSafeGroundActive, isTrue);

        // Place player entering the pit
        final targetGroundY = pitChunk.getSurfaceY(100) - 8.0;
        game.player.position = Vector2(110, targetGroundY);
        game.player.velocity = Vector2(250, 0);
        game.player.isGrounded = true;

        // Simulate running across the hard-light bridge
        for (int i = 0; i < 40; i++) {
          game.update(0.016);
        }

        // Player must remain alive and grounded
        expect(game.isGameOver, isFalse);
        expect(game.player.isDead, isFalse);
        expect(game.player.position.x, greaterThan(250));
      },
    );

    test(
      'Jumping cleanly over a pit lands safely on the other side without dying',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final pitChunk = WorldChunk(
          startX: 0,
          length: 600,
          groundY: groundY,
          roofY: 0,
          hasPit: true,
          pitStartX: 100,
          pitWidth: 120, // 100 to 220
        );
        game.world.add(pitChunk);
        game.worldGen.activeChunks.add(pitChunk);

        final targetGroundY = pitChunk.getSurfaceY(90) - 8.0;
        game.player.position = Vector2(90, targetGroundY);
        game.player.isGrounded = true;
        game.player.jump(); // Jump before pit

        // Simulate airborne jump trajectory across the 120px pit until landing
        for (int i = 0; i < 60; i++) {
          game.update(0.016);
          if (game.player.isGrounded && game.player.position.x > 220) break;
        }

        // Player cleared the pit and landed on the solid ground past 220
        expect(game.isGameOver, isFalse);
        expect(game.player.isDead, isFalse);
        expect(game.player.position.x, greaterThan(220));
        expect(game.player.isGrounded, isTrue);
      },
    );

    test(
      'Underground player cannot phase forward through right pit wall or teleport to surface',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final pitChunk = WorldChunk(
          startX: 0,
          length: 600,
          groundY: groundY,
          roofY: 0,
          hasPit: true,
          pitStartX: 100,
          pitWidth: 140, // pit is 100..240
        );
        game.world.add(pitChunk);
        game.worldGen.activeChunks.add(pitChunk);

        final targetGroundY = pitChunk.getSurfaceY(230) - 8.0;
        // Position player underground inside the pit near the right wall
        game.player.position = Vector2(230, targetGroundY + 30.0);
        game.player.velocity = Vector2(250, 200);
        game.player.isGrounded = false;

        game.update(0.016);

        // Player's horizontal position should be bounded by the wall (pitRight)
        // and NOT snap up to targetGroundY
        final pitRight = 100 + 140;
        expect(game.player.position.x, lessThanOrEqualTo(pitRight.toDouble()));
        expect(game.player.position.y, greaterThan(targetGroundY));
      },
    );

    test(
      'Reviving after falling in pit places player past the pit onto solid ground',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final pitChunk = WorldChunk(
          startX: 0,
          length: 600,
          groundY: groundY,
          roofY: 0,
          hasPit: true,
          pitStartX: 100,
          pitWidth: 150, // pit is 100..250
        );
        game.world.add(pitChunk);
        game.worldGen.activeChunks.add(pitChunk);

        // Kill player in pit
        game.player.position = Vector2(150, groundY + 70.0);
        game.triggerGameOver(DeathType.fallInPit);
        expect(game.isGameOver, isTrue);

        // Revive
        game.revivePlayer();

        expect(game.isGameOver, isFalse);
        expect(game.player.isDead, isFalse);
        // Revives at exact death position (150) with Safe Ground pack protecting against pit fall
        expect(game.player.position.x, closeTo(150.0, 0.001));
        expect(game.player.isGrounded, isTrue);
        expect(game.boosterManager.isSafeGroundActive, isTrue);
      },
    );
  });
}
