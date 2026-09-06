import 'package:flutter/material.dart';

/// State Machine coordinating shadow stealth and corner hiding mechanics.
class CornerHideController {
  bool isNearShadowZone = false;
  bool isStealthActive = false;
  double stealthTransition =
      0.0; // 0.0 (Visible) to 1.0 (Completely Camouflaged)

  void update(double dt, {required bool isDuckingOrHidden}) {
    final target = (isNearShadowZone || isDuckingOrHidden) ? 1.0 : 0.0;
    if (stealthTransition < target) {
      stealthTransition = (stealthTransition + dt * 6.0).clamp(0.0, 1.0);
    } else if (stealthTransition > target) {
      stealthTransition = (stealthTransition - dt * 6.0).clamp(0.0, 1.0);
    }
    isStealthActive = stealthTransition > 0.75;
  }

  Color getPlayerRenderColor(Color baseColor) {
    if (stealthTransition <= 0.0) return baseColor;
    // Blend from baseColor to dark shadow tint
    return Color.lerp(baseColor, const Color(0xFF1E222D), stealthTransition) ??
        baseColor;
  }
}
