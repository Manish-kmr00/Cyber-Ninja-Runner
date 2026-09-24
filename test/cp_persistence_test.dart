import 'package:flutter_test/flutter_test.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/storage/save_models.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/game/cyber_ninja_game.dart';
import 'package:flame/components.dart';

void main() {
  setUp(() {
    TestWidgetsFlutterBinding.ensureInitialized();
    SharedPreferences.setMockInitialValues({});
  });

  test('New install starts at exactly 0 CP and saves/loads 0 CP', () async {
    final player = PlayerData();
    expect(player.cyberPoints.value, 0);

    final saveService = SaveService();
    await saveService.init();
    expect(saveService.player.cyberPoints.value, 0);
  });

  test(
    'CP persistence across collection, death, restart, and simulated app reload',
    () async {
      final saveService = SaveService();
      await saveService.init();
      expect(saveService.player.cyberPoints.value, 0);

      final game = CyberNinjaRunnerGame(
        mode: GameMode.run,
        saveService: saveService,
      );
      game.onGameResize(Vector2(1280, 720));
      await game.onLoad();

      // 1. Initial balance is 0
      expect(saveService.player.cyberPoints.value, 0);
      expect(game.collectedCP, 0);

      // 2. Collect +1 CP pickup
      saveService.addCyberPoints(1);
      game.collectedCP += 1;
      expect(saveService.player.cyberPoints.value, 1);
      expect(game.collectedCP, 1);

      // 3. Collect +5 CP pickup
      saveService.addCyberPoints(5);
      game.collectedCP += 5;
      expect(saveService.player.cyberPoints.value, 6);
      expect(game.collectedCP, 6);

      // 4. Run 1200 meters without pickups — CP must NOT increase
      game.currentDistance = 1200;
      saveService.recordRunResult(
        mode: GameMode.run,
        distance: 1200,
        jumps: 10,
        shadowHides: 2,
      );
      expect(
        saveService.player.cyberPoints.value,
        6,
        reason: 'Distance travelled must not add CP',
      );

      // 5. Ninja dies (triggerGameOver)
      game.triggerGameOver(DeathType.fallInPit);
      expect(game.isGameOver, isTrue);
      expect(
        saveService.player.cyberPoints.value,
        6,
        reason: 'Death must NOT reset or alter persistent CP',
      );

      // 6. Revive player
      game.revivePlayer();
      expect(game.isGameOver, isFalse);
      expect(
        saveService.player.cyberPoints.value,
        6,
        reason: 'Revive must NOT reset or alter persistent CP',
      );

      // 7. Collect +2 CP after revive
      saveService.addCyberPoints(2);
      game.collectedCP += 2;
      expect(saveService.player.cyberPoints.value, 8);

      // 8. Die again and restart mission
      game.triggerGameOver(DeathType.hitByBarrier);
      expect(saveService.player.cyberPoints.value, 8);

      game.restartMission();
      expect(
        game.collectedCP,
        0,
        reason: 'Temporary per-run counter resets on restart',
      );
      expect(
        saveService.player.cyberPoints.value,
        8,
        reason: 'Persistent CP MUST remain 8 after restart',
      );

      // 9. Simulate app kill and reopen by initializing a new SaveService instance
      final reloadedSaveService = SaveService();
      await reloadedSaveService.init();
      expect(
        reloadedSaveService.player.cyberPoints.value,
        8,
        reason: 'Persistent CP MUST survive app kill and relaunch',
      );

      // 10. Multiple collection sequence test: +1 -> 9, +2 -> 11, +5 -> 16, +10 -> 26
      reloadedSaveService.addCyberPoints(1);
      expect(reloadedSaveService.player.cyberPoints.value, 9);
      reloadedSaveService.addCyberPoints(2);
      expect(reloadedSaveService.player.cyberPoints.value, 11);
      reloadedSaveService.addCyberPoints(5);
      expect(reloadedSaveService.player.cyberPoints.value, 16);
      reloadedSaveService.addCyberPoints(10);
      expect(reloadedSaveService.player.cyberPoints.value, 26);

      // IAP purchase simulation: +5000 CP
      reloadedSaveService.addCyberPoints(5000);
      expect(reloadedSaveService.player.cyberPoints.value, 5026);

      // Another app reload check
      final appReload2 = SaveService();
      await appReload2.init();
      expect(appReload2.player.cyberPoints.value, 5026);
    },
  );
}
