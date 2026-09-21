import 'package:flame/components.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/game/cyber_ninja_game.dart';

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
    return game;
  }

  group('Exact Revive Position & Snapshot Lifecycle Tests', () {
    test(
      'TEST 1: Death at position X -> revive -> final position == X',
      () async {
        final game = await createTestGame();
        const deathX = 540.0;
        game.player.position.x = deathX;
        game.currentDistance = (deathX / 10).round();

        // Trigger death
        game.triggerGameOver(DeathType.hitByBug);
        expect(game.isGameOver, isTrue);
        expect(game.deathSnapshot, isNotNull);
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathX, 0.001));
        expect(game.deathSnapshot!.distance, 54);

        // Perform revive
        game.revivePlayer();
        expect(game.isGameOver, isFalse);
        expect(game.player.isDead, isFalse);
        expect(game.player.position.x, closeTo(deathX, 0.001));
        expect(game.currentDistance, 54);
        expect(game.camera.viewfinder.position.x, closeTo(deathX, 0.001));
        expect(game.boosterManager.isInvisibilityActive, isTrue);
        expect(game.boosterManager.isSafeGroundActive, isTrue);
      },
    );

    test(
      'TEST 2: Death at position Y -> revive -> final position == Y',
      () async {
        final game = await createTestGame();
        const deathX = 1875.5;
        game.player.position.x = deathX;
        game.currentDistance = (deathX / 10).round();

        // Trigger death
        game.triggerGameOver(DeathType.hitByBarrier);
        expect(game.isGameOver, isTrue);
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathX, 0.001));
        expect(game.deathSnapshot!.distance, 188);

        // Perform revive
        game.revivePlayer();
        expect(game.isGameOver, isFalse);
        expect(game.player.position.x, closeTo(deathX, 0.001));
        expect(game.currentDistance, 188);
        expect(game.camera.viewfinder.position.x, closeTo(deathX, 0.001));
      },
    );

    test(
      'TEST 3: Death at position X -> wait several seconds -> revive -> final position still == X',
      () async {
        final game = await createTestGame();
        const deathX = 820.0;
        game.player.position.x = deathX;
        game.currentDistance = (deathX / 10).round();

        game.triggerGameOver(DeathType.hitByDarkBox);

        // Simulate time elapsing during ad display (e.g. 5 seconds of update ticks while dead)
        for (int i = 0; i < 300; i++) {
          game.update(0.016);
        }

        // Player must not have moved during game over state
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathX, 0.001));

        // Perform revive
        game.revivePlayer();
        expect(game.player.position.x, closeTo(deathX, 0.001));
        expect(game.currentDistance, (deathX / 10).round());
        expect(game.camera.viewfinder.position.x, closeTo(deathX, 0.001));
      },
    );

    test(
      'TEST 4: Death #1 at X -> revive -> die again at Y -> revive -> final position == Y, NOT X',
      () async {
        final game = await createTestGame();

        // Death 1 at X = 350.0
        const deathX = 350.0;
        game.player.position.x = deathX;
        game.currentDistance = 35;
        game.triggerGameOver(DeathType.hitByCannon);
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathX, 0.001));

        game.revivePlayer();
        expect(game.player.position.x, closeTo(deathX, 0.001));
        expect(game.deathSnapshot, isNull); // Snapshot invalidated

        // Reset boosters so player can die again
        game.boosterManager.invisibilityTimeRemaining = 0.0;
        game.boosterManager.safeGroundTimeRemaining = 0.0;

        // Run forward to Y = 1200.0
        const deathY = 1200.0;
        game.player.position.x = deathY;
        game.currentDistance = 120;
        game.triggerGameOver(DeathType.hitByTitan);
        expect(game.deathSnapshot, isNotNull);
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathY, 0.001));
        expect(game.deathSnapshot!.distance, 120);

        // Revive 2 must restore to Y, never stale X
        game.revivePlayer();
        expect(game.player.position.x, closeTo(deathY, 0.001));
        expect(game.currentDistance, 120);
        expect(game.camera.viewfinder.position.x, closeTo(deathY, 0.001));
        expect(game.deathSnapshot, isNull);
      },
    );

    test(
      'TEST 5: Death -> close ad before reward -> no revive -> death state remains correct',
      () async {
        final game = await createTestGame();
        const deathX = 640.0;
        game.player.position.x = deathX;
        game.currentDistance = 64;

        game.triggerGameOver(DeathType.hitByBug);
        expect(game.isGameOver, isTrue);
        expect(game.player.isDead, isTrue);
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathX, 0.001));

        // User closed ad before reward callback (no revivePlayer called)
        // Game state remains game over, player dead, snapshot preserved
        expect(game.isGameOver, isTrue);
        expect(game.player.isDead, isTrue);
        expect(game.deathSnapshot!.worldPosition.x, closeTo(deathX, 0.001));
        expect(game.deathSnapshot!.distance, 64);
      },
    );

    test(
      'TEST 6: Double reward callback -> exactly one revive (idempotent)',
      () async {
        final game = await createTestGame();
        const deathX = 990.0;
        game.player.position.x = deathX;
        game.currentDistance = 99;

        game.triggerGameOver(DeathType.hitByBarrier);

        // First revive invocation
        game.revivePlayer();
        expect(game.isGameOver, isFalse);
        expect(game.player.position.x, closeTo(deathX, 0.001));
        expect(game.deathSnapshot, isNull);

        // Advance player slightly in normal gameplay
        game.player.position.x = 1010.0;

        // Accidental second revive invocation without new death
        game.revivePlayer();
        // Second invocation must be ignored because snapshot is already consumed
        expect(game.player.position.x, closeTo(1010.0, 0.001));
        expect(game.isGameOver, isFalse);
      },
    );
  });
}
