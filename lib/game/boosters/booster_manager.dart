import 'package:flutter/material.dart';
import '../../core/constants/game_enums.dart';

class BoosterManager extends ChangeNotifier {
  double matrixTimeRemaining = 0.0;
  double invisibilityTimeRemaining = 0.0;
  double safeGroundTimeRemaining = 0.0;
  double empShockwaveTimer = 0.0;
  bool forceSafeGroundSpawn = false;

  bool get isMatrixActive => matrixTimeRemaining > 0;
  bool get isInvisibilityActive => invisibilityTimeRemaining > 0;
  bool get isSafeGroundActive => safeGroundTimeRemaining > 0;
  bool get isEmpShockwaveActive => empShockwaveTimer > 0;

  double get timeDilationFactor => isMatrixActive ? 0.45 : 1.0;

  double getTimeRemaining(BoosterType type) {
    switch (type) {
      case BoosterType.safeGround:
        return safeGroundTimeRemaining;
      case BoosterType.matrixSlowMo:
        return matrixTimeRemaining;
      case BoosterType.invisibility:
        return invisibilityTimeRemaining;
      case BoosterType.killEyes:
        return empShockwaveTimer;
    }
  }

  void activateBooster(BoosterType type) {
    switch (type) {
      case BoosterType.matrixSlowMo:
        matrixTimeRemaining = 8.0;
        break;
      case BoosterType.invisibility:
        invisibilityTimeRemaining = 8.0;
        break;
      case BoosterType.safeGround:
        safeGroundTimeRemaining = 8.0;
        forceSafeGroundSpawn = true;
        break;
      case BoosterType.killEyes:
        empShockwaveTimer = 1.2;
        break;
    }
    notifyListeners();
  }

  void update(double dt) {
    if (dt <= 0) return;
    // Defensive clamping to prevent huge dt spikes after ad display or app resume
    final safeDt = dt.clamp(0.0, 0.1);
    bool changed = false;
    if (matrixTimeRemaining > 0) {
      matrixTimeRemaining = (matrixTimeRemaining - safeDt).clamp(0.0, 100.0);
      changed = true;
    }
    if (invisibilityTimeRemaining > 0) {
      invisibilityTimeRemaining = (invisibilityTimeRemaining - safeDt).clamp(
        0.0,
        100.0,
      );
      changed = true;
    }
    if (safeGroundTimeRemaining > 0) {
      safeGroundTimeRemaining = (safeGroundTimeRemaining - safeDt).clamp(
        0.0,
        100.0,
      );
      changed = true;
    }
    if (empShockwaveTimer > 0) {
      empShockwaveTimer = (empShockwaveTimer - safeDt).clamp(0.0, 100.0);
      changed = true;
    }
    if (changed) notifyListeners();
  }

  void reset() {
    matrixTimeRemaining = 0.0;
    invisibilityTimeRemaining = 0.0;
    safeGroundTimeRemaining = 0.0;
    empShockwaveTimer = 0.0;
    forceSafeGroundSpawn = false;
    notifyListeners();
  }
}
