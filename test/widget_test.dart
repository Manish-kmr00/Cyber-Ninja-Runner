import 'package:flutter_test/flutter_test.dart';
import 'package:cyber_ninja_runner/core/security/safe_types.dart';
import 'package:cyber_ninja_runner/core/storage/save_models.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/services/daily_crate_service.dart';

void main() {
  test('SafeInt XOR memory obfuscation integrity test', () {
    final safeInt = SafeInt(1500);
    expect(safeInt.value, 1500);

    safeInt.add(500);
    expect(safeInt.value, 2000);

    safeInt.subtract(300);
    expect(safeInt.value, 1700);
  });

  test('PlayerData initialization & serialization test', () {
    final player = PlayerData();
    expect(player.cyberPoints.value, 500);
    expect(player.cubePoints.value, 500);
    expect(player.unlockedSkins.length, 1);

    final json = player.toJson();
    expect(json['cyberPoints'], 500);
    expect(json['cubePoints'], 500);
  });

  test('Immortal Mode (God Mode) Auto-Unlocks All Content across the Game', () {
    TestWidgetsFlutterBinding.ensureInitialized();
    final saveService = SaveService();

    // Verify initial locked state
    expect(saveService.isTenXUnlocked, isFalse);
    expect(saveService.isFlightUnlocked, isFalse);
    expect(saveService.isSkinUnlocked(PlayerSkin.stealthBlack), isFalse);
    expect(saveService.isSkinUnlocked(PlayerSkin.goldenAura), isFalse);

    // Turn ON Immortal Mode / God Mode
    saveService.setGodMode(true);

    // 1. All maps must be unlocked
    expect(saveService.isTenXUnlocked, isTrue);
    expect(saveService.isFlightUnlocked, isTrue);
    expect(saveService.player.isTenXUnlocked, isTrue);
    expect(saveService.player.isFlightUnlocked, isTrue);

    // 2. All skins must be unlocked
    for (final skin in PlayerSkin.values) {
      expect(saveService.isSkinUnlocked(skin), isTrue);
      expect(saveService.player.unlockedSkins.contains(skin), isTrue);
    }

    // 3. Player can equip any skin without restriction
    saveService.equipSkin(PlayerSkin.goldenAura);
    expect(saveService.player.equippedSkin, PlayerSkin.goldenAura);

    // 4. Boosters must be at least 99 each and not consumed
    for (final booster in BoosterType.values) {
      expect(saveService.getBoosterCount(booster), greaterThanOrEqualTo(99));
      final canUse = saveService.useBooster(booster);
      expect(canUse, isTrue);
      expect(saveService.getBoosterCount(booster), greaterThanOrEqualTo(99));
    }

    // 5. Daily Crate is immediately ready with zero cooldown
    final crateService = DailyCrateService();
    expect(crateService.isCrateReady(saveService), isTrue);
    expect(crateService.getRemainingCooldownMs(saveService), 0);
  });
}
