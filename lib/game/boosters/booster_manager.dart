import 'package:flutter/material.dart';
import '../../core/constants/game_enums.dart';

class BoosterManager extends ChangeNotifier {
  double matrixTimeRemaining = 0.0;
  double invisibilityTimeRemaining = 0.0;
  bool forceSafeGroundSpawn = false;

  bool get isMatrixActive => matrixTimeRemaining > 0;
  bool get isInvisibilityActive => invisibilityTimeRemaining > 0;

  double get timeDilationFactor => isMatrixActive ? 0.45 : 1.0;

  void activateBooster(BoosterType type) {
    switch (type) {
      case BoosterType.matrixSlowMo:
        matrixTimeRemaining = 6.0;
        break;
      case BoosterType.invisibility:
        invisibilityTimeRemaining = 8.0;
        break;
      case BoosterType.safeGround:
        forceSafeGroundSpawn = true;
        break;
      case BoosterType.killEyes:
        // Screen-wide clear
        break;
    }
    notifyListeners();
  }

  void update(double dt) {
    bool changed = false;
    if (matrixTimeRemaining > 0) {
      matrixTimeRemaining = (matrixTimeRemaining - dt).clamp(0.0, 100.0);
      changed = true;
    }
    if (invisibilityTimeRemaining > 0) {
      invisibilityTimeRemaining = (invisibilityTimeRemaining - dt).clamp(
        0.0,
        100.0,
      );
      changed = true;
    }
    if (changed) notifyListeners();
  }

  void reset() {
    matrixTimeRemaining = 0.0;
    invisibilityTimeRemaining = 0.0;
    forceSafeGroundSpawn = false;
    notifyListeners();
  }
}
