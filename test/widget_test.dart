import 'package:flutter_test/flutter_test.dart';
import 'package:cyber_ninja_runner/core/security/safe_types.dart';
import 'package:cyber_ninja_runner/core/storage/save_models.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';

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

  test('Standard Progression and Content Lock Mechanics', () {
    TestWidgetsFlutterBinding.ensureInitialized();
    final saveService = SaveService();

    // Verify initial locked state
    expect(saveService.isTenXUnlocked, isFalse);
    expect(saveService.isFlightUnlocked, isFalse);
    expect(saveService.isSkinUnlocked(PlayerSkin.stealthBlack), isFalse);
    expect(saveService.isSkinUnlocked(PlayerSkin.goldenAura), isFalse);

    // Initial starter boosters can be used and decrement properly
    expect(saveService.getBoosterCount(BoosterType.safeGround), 3);
    expect(saveService.useBooster(BoosterType.safeGround), isTrue);
    expect(saveService.getBoosterCount(BoosterType.safeGround), 2);
  });
}
