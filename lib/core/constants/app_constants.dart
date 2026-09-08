import 'package:flutter/material.dart';

class AppConstants {
  // Theme & Atmosphere Colors
  static const Color backgroundDark = Color(0xFF0F1218);
  static const Color surfaceDark = Color(0xFF171B24);
  static const Color cardDark = Color(0xFF1F2430);
  static const Color groundColor = Color(0xFF08090C);
  static const Color ninjaWhite = Color(0xFFFFFFFF);
  static const Color cyberNinjaRunnerWhite = ninjaWhite;
  static const Color eyeIrisBlack = Color(0xFF111111);
  static const Color eyeGlintWhite = Color(0xFFFFFFFF);

  // Accent & Hazard Colors
  static const Color hazardRed = Color(0xFFFF334B);
  static const Color lightConeYellow = Color(0x66FFF59D);
  static const Color stealthBlue = Color(0xFF00E5FF);
  static const Color coinGold = Color(0xFFFFD700);
  static const Color boosterPurple = Color(0xFFD500F9);
  static const Color matrixGreen = Color(0xFF00E676);

  // Physics Constants (in virtual pixels)
  static const double gravity = 1800.0;
  static const double playerBaseSpeed = 250.0;
  static const double jumpForce = -720.0;
  static const double doubleJumpForce = -660.0;
  static const double slideSpeedMultiplier = 1.35;
  static const double playerSize = 78.0;
  static const double ninjaWidth = 92.0;
  static const double ninjaHeight = 112.0;
  static const double playerWidth = ninjaWidth;
  static const double playerHeight = ninjaHeight;
  static const double trackDepth = 26.0;
  static const double eyeRadius = 6.0;
  static const double groundHeight = 120.0;
  static const double roofHeight = 480.0;

  // Virtual Game Canvas Resolution
  static const double virtualWidth = 1280.0;
  static const double virtualHeight = 720.0;

  // Chunk Generation Parameters
  static const double chunkLength = 1000.0;
  static const int activeChunkCount = 4;

  // Developer / Testing Configuration
  // When true: Player is immortal (cannot die from any hazard, cannon bullet, or pit).
  static const bool testGodMode = true;
}
