import 'package:flutter_test/flutter_test.dart';
import 'package:cyber_ninja_runner/core/security/safe_types.dart';
import 'package:cyber_ninja_runner/core/storage/save_models.dart';

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
}
