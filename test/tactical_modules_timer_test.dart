import 'package:flutter_test/flutter_test.dart';
import 'package:flame/components.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/game/boosters/booster_manager.dart';
import 'package:cyber_ninja_runner/game/cyber_ninja_game.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    SharedPreferences.setMockInitialValues({});
  });

  group('Tactical Modules Timer & Countdown Tests', () {
    test('BoosterManager.update decrements all active module timers', () {
      final bm = BoosterManager();

      // Activate all 4 boosters
      bm.activateBooster(BoosterType.safeGround);
      bm.activateBooster(BoosterType.matrixSlowMo);
      bm.activateBooster(BoosterType.invisibility);
      bm.activateBooster(BoosterType.killEyes);

      expect(bm.safeGroundTimeRemaining, 8.0);
      expect(bm.matrixTimeRemaining, 8.0);
      expect(bm.invisibilityTimeRemaining, 8.0);
      expect(bm.empShockwaveTimer, 1.2);
      expect(bm.isSafeGroundActive, isTrue);
      expect(bm.isMatrixActive, isTrue);
      expect(bm.isInvisibilityActive, isTrue);
      expect(bm.isEmpShockwaveActive, isTrue);

      // Advance by 1 second (10 frames of 0.1s)
      for (int i = 0; i < 10; i++) {
        bm.update(0.1);
      }

      expect(bm.safeGroundTimeRemaining, closeTo(7.0, 0.01));
      expect(bm.matrixTimeRemaining, closeTo(7.0, 0.01));
      expect(bm.invisibilityTimeRemaining, closeTo(7.0, 0.01));
      expect(bm.empShockwaveTimer, closeTo(0.2, 0.01));

      // Advance another 0.5 seconds -> EMP shockwave expires
      for (int i = 0; i < 5; i++) {
        bm.update(0.1);
      }
      expect(bm.empShockwaveTimer, 0.0);
      expect(bm.isEmpShockwaveActive, isFalse);
      expect(bm.safeGroundTimeRemaining, closeTo(6.5, 0.01));

      // Advance 7 more seconds -> all boosters expire
      for (int i = 0; i < 70; i++) {
        bm.update(0.1);
      }
      expect(bm.safeGroundTimeRemaining, 0.0);
      expect(bm.matrixTimeRemaining, 0.0);
      expect(bm.invisibilityTimeRemaining, 0.0);
      expect(bm.isSafeGroundActive, isFalse);
      expect(bm.isMatrixActive, isFalse);
      expect(bm.isInvisibilityActive, isFalse);
    });

    test(
      'CyberNinjaGame.update advances booster timers during active running',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        // Activate matrix slow mo
        game.boosterManager.activateBooster(BoosterType.matrixSlowMo);
        expect(game.boosterManager.matrixTimeRemaining, 8.0);

        // Run game loop updates while alive
        game.update(0.05);
        game.update(0.05);

        expect(game.boosterManager.matrixTimeRemaining, closeTo(7.9, 0.01));

        // Reset mission (Deploy Again / restart) resets active booster timers
        game.restartMission();
        expect(game.boosterManager.matrixTimeRemaining, 0.0);
        expect(game.boosterManager.isMatrixActive, isFalse);
      },
    );

    test('Revive activates I-Frames and timers count down on track', () async {
      final saveService = SaveService();
      final game = CyberNinjaRunnerGame(
        mode: GameMode.run,
        saveService: saveService,
      );
      game.onGameResize(Vector2(1280, 720));
      await game.onLoad();

      // Simulate player death
      game.triggerGameOver(DeathType.hitByBug);
      expect(game.isGameOver, isTrue);

      // Revive player (Ad or CP Deploy Again)
      game.revivePlayer();
      expect(game.player.isDead, isFalse);
      expect(game.boosterManager.isInvisibilityActive, isTrue);
      expect(game.boosterManager.isSafeGroundActive, isTrue);
      expect(game.boosterManager.invisibilityTimeRemaining, 8.0);
      expect(game.boosterManager.safeGroundTimeRemaining, 8.0);

      // Running on track advances timers
      for (int i = 0; i < 20; i++) {
        game.update(0.1);
      }

      expect(game.boosterManager.invisibilityTimeRemaining, closeTo(6.0, 0.01));
      expect(game.boosterManager.safeGroundTimeRemaining, closeTo(6.0, 0.01));
    });
  });
}
