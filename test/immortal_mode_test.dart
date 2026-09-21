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

  group('Standard Player Mortality Verification Tests', () {
    late SaveService saveService;

    setUp(() {
      saveService = SaveService();
    });

    test(
      '1. triggerGameOver correctly sets gameOver and records death cause',
      () async {
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        expect(game.isGameOver, isFalse);
        expect(game.lastDeathCause, isNull);

        game.triggerGameOver(DeathType.hitByBarrier);
        expect(game.isGameOver, isTrue);
        expect(game.lastDeathCause, DeathType.hitByBarrier);
      },
    );

    test('2. triggerGameOver records pit death correctly', () async {
      final game = CyberNinjaRunnerGame(
        mode: GameMode.run,
        saveService: saveService,
      );
      game.onGameResize(Vector2(1280, 720));
      await game.onLoad();

      game.triggerGameOver(DeathType.fallInPit);
      expect(game.isGameOver, isTrue);
      expect(game.lastDeathCause, DeathType.fallInPit);
    });

    test(
      '3. Walking over an unshielded pit causes player to fall and die',
      () async {
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

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
        game.worldGen.activeChunks.clear();
        game.worldGen.activeChunks.add(pitChunk);

        // Position player falling into the pit below ground
        game.player.position = Vector2(150, groundY + 30);
        game.player.velocity = Vector2(250, 300);

        game.update(0.016);

        // Verify that the player does not magically float back up and falls fatally
        expect(game.player.isFallingInPit, isTrue);
      },
    );
  });
}
