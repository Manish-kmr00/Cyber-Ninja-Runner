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

  Future<CyberNinjaRunnerGame> createTestGame() async {
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
    return game;
  }

  group('Track Ground Collision & Anti-Tunneling Verification Tests', () {
    test(
      'TEST 1: High speed descent (tunneling test) lands cleanly on normal track without falling through or dying',
      () async {
        final game = await createTestGame();
        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;

        final flatChunk = WorldChunk(
          startX: 0,
          length: 1200,
          groundY: groundY,
          roofY: 0,
          hasPit: false,
        );
        game.world.add(flatChunk);
        game.worldGen.activeChunks.add(flatChunk);

        final targetGroundY = flatChunk.getSurfaceY(300) - 8.0;

        // Position player 30px above ground with high downward velocity of 950 px/s (descending fast)
        game.player.position = Vector2(300, targetGroundY - 30.0);
        game.player.velocity = Vector2(280, 950.0);
        game.player.isGrounded = false;

        expect(game.isGameOver, isFalse);

        // Run one frame with large dt (0.04s) to simulate a frame stutter/drop
        // Without continuous collision detection, position would overshoot ground by 38+ pixels
        game.update(0.04);

        // Ground must have cleanly caught the player
        expect(game.isGameOver, isFalse);
        expect(game.player.isDead, isFalse);
        expect(game.player.isGrounded, isTrue);
        expect(game.player.position.y, closeTo(targetGroundY, 0.001));
        expect(game.player.velocity.y, 0.0);
      },
    );

    test(
      'TEST 2: Running continuously on normal flat track for 200 frames results in NO falls and NO deaths',
      () async {
        final game = await createTestGame();
        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;

        final longChunk = WorldChunk(
          startX: 0,
          length: 4000,
          groundY: groundY,
          roofY: 0,
          hasPit: false,
        );
        game.world.add(longChunk);
        game.worldGen.activeChunks.add(longChunk);

        final startGroundY = longChunk.getSurfaceY(100) - 8.0;
        game.player.position = Vector2(100, startGroundY);
        game.player.velocity = Vector2(300, 0);
        game.player.isGrounded = true;

        // Run 200 frames of normal running
        for (int i = 0; i < 200; i++) {
          game.update(0.016);
          expect(game.isGameOver, isFalse, reason: 'Died at frame $i');
          expect(game.player.isDead, isFalse);
          expect(game.player.isGrounded, isTrue);
        }

        expect(game.player.position.x, greaterThan(800));
        expect(game.isGameOver, isFalse);
      },
    );

    test(
      'TEST 3: Stepping off elevated catwalk platform lands cleanly on ground below without falling through world',
      () async {
        final game = await createTestGame();
        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;

        final chunk = WorldChunk(
          startX: 0,
          length: 1500,
          groundY: groundY,
          roofY: 0,
          hasPit: false,
        );

        final platSurfaceY = chunk.getSurfaceY(200);
        final platform = ElevatedPlatform(
          position: Vector2(100, platSurfaceY - 80.0),
          size: Vector2(150.0, 18.0), // spans X=100 to X=250
        );
        chunk.elevatedPlatforms.add(platform);
        game.world.add(chunk);
        game.worldGen.activeChunks.add(chunk);

        // Player is running on top of elevated catwalk
        final platTopY = platform.position.y;
        game.player.position = Vector2(230, platTopY);
        game.player.velocity = Vector2(300, 0);
        game.player.isGrounded = true;

        // Player runs off the edge of catwalk at X=250 into air
        // Run frames until player falls 80px and lands on solid ground
        for (int i = 0; i < 50; i++) {
          game.update(0.016);
          if (game.player.isGrounded && game.player.position.x > 270) break;
        }

        final targetGroundY = chunk.getSurfaceY(game.player.position.x) - 8.0;

        // Player must land safely on solid ground below without falling through into abyss
        expect(game.isGameOver, isFalse);
        expect(game.player.isDead, isFalse);
        expect(game.player.isGrounded, isTrue);
        expect(game.player.position.y, closeTo(targetGroundY, 0.001));
      },
    );

    test(
      'TEST 4: Running down steep slope descent maintains solid grounding and does not fall through',
      () async {
        final game = await createTestGame();
        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;

        // Chunk with 40px downward elevation slope
        final slopeChunk = WorldChunk(
          startX: 0,
          length: 1200,
          groundY: groundY,
          roofY: 0,
          hasPit: false,
          entryElevation: 0.0,
          exitElevation: 40.0, // Slopes down by 40px
        );
        game.world.add(slopeChunk);
        game.worldGen.activeChunks.add(slopeChunk);

        final startGroundY = slopeChunk.getSurfaceY(100) - 8.0;
        game.player.position = Vector2(100, startGroundY);
        game.player.velocity = Vector2(350, 0);
        game.player.isGrounded = true;

        for (int i = 0; i < 100; i++) {
          game.update(0.016);
          expect(
            game.isGameOver,
            isFalse,
            reason: 'Failed on slope at frame $i',
          );
          expect(game.player.isGrounded, isTrue);
        }

        expect(game.player.position.x, greaterThan(450));
        final expectedGroundY =
            slopeChunk.getSurfaceY(game.player.position.x) - 8.0;
        expect(game.player.position.y, closeTo(expectedGroundY, 0.001));
      },
    );

    test(
      'TEST 5: Real pit chasm still legitimately triggers DeathType.fallInPit when unshielded',
      () async {
        final game = await createTestGame();
        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;

        final pitChunk = WorldChunk(
          startX: 0,
          length: 800,
          groundY: groundY,
          roofY: 0,
          hasPit: true,
          pitStartX: 150,
          pitWidth: 200,
        );
        game.world.add(pitChunk);
        game.worldGen.activeChunks.add(pitChunk);

        final startGroundY = pitChunk.getSurfaceY(140) - 8.0;
        game.player.position = Vector2(140, startGroundY);
        game.player.velocity = Vector2(250, 0);
        game.player.isGrounded = true;

        // Run frames walking into the pit
        for (int i = 0; i < 40; i++) {
          game.update(0.016);
          if (game.isGameOver) break;
        }

        // Must die from real pit fall
        expect(game.isGameOver, isTrue);
        expect(game.player.isDead, isTrue);
        expect(game.lastDeathCause, DeathType.fallInPit);
      },
    );
  });
}
