import 'package:flutter_test/flutter_test.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    SharedPreferences.setMockInitialValues({});
  });

  group('Standard Progression & Unlock Tests', () {
    test(
      'Standard progression enforces locked modes, skins, and booster limits',
      () {
        final save = SaveService();
        save.resetAllProgress();

        // Modes locked initially
        expect(save.isTenXUnlocked, isFalse);
        expect(save.isFlightUnlocked, isFalse);

        // Default skin classicWhite is unlocked, others locked initially
        expect(save.isSkinUnlocked(PlayerSkin.classicWhite), isTrue);
        expect(save.isSkinUnlocked(PlayerSkin.cyberNeon), isFalse);
        expect(save.isSkinUnlocked(PlayerSkin.crimsonShadow), isFalse);
        expect(save.isSkinUnlocked(PlayerSkin.goldenAura), isFalse);

        // Spending without sufficient CP returns false
        expect(save.player.cyberPoints.value, equals(0));
        expect(save.spendCyberNinjaPoints(100), isFalse);

        // Boosters have standard initial counts and are consumed on use
        final initialCount = save.getBoosterCount(BoosterType.matrixSlowMo);
        expect(initialCount, greaterThan(0));
        final used = save.useBooster(BoosterType.matrixSlowMo);
        expect(used, isTrue);
        expect(
          save.getBoosterCount(BoosterType.matrixSlowMo),
          equals(initialCount - 1),
        );
      },
    );
  });
}
