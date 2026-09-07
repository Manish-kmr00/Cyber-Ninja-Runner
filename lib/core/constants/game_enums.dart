import 'package:flutter/material.dart';

/// Core Game Modes matching architecture specification
enum GameMode { run, tenXChallenge, squbeBird, multiplayer }

/// Consumable Boosters
enum BoosterType { safeGround, matrixSlowMo, invisibility, killEyes }

/// Hazard and Obstacle Types
enum ObstacleType {
  darkEye,
  cyberCannon,
  bugCrawler,
  darkBox,
  cyberTitan,
  deathColumn,
  darkMud,
  stakesStatic,
  stakesAutoHide,
  roofStake,
  movingPlatform,
}

/// Death & Damage Types
enum DeathType {
  caughtByLight,
  hitByCannon,
  crushedByColumn,
  hitBySpikes,
  sunkInDarkMud,
  hitByDarkBox,
  hitByTitan,
  hitByBug,
  fallInPit,
}

/// Control Scheme options
enum ControlScheme { buttons, swipe, splitScreen }

/// Playable Character Heroes
enum CharacterHero { cyberNinja }

/// Custom Character Skins
enum PlayerSkin {
  classicWhite,
  stealthBlack,
  cyberNeon,
  crimsonShadow,
  goldenAura,
}

/// Dynamic Map Sector Biomes evolving every 1000m
enum SectorBiome {
  neonMetropolis, // 0 - 1000m: High-tech skyscrapers, cyan & magenta neon
  toxicFoundry, // 1000 - 2000m: Industrial steel factory, amber furnace glow & pipes
  maglevTunnel, // 2000 - 3000m: Subterranean hyperloop, electric purple rails & arches
  orbitalSkyway, // 3000 - 4000m: High-altitude stratospheric glassway & emerald matrix
  quantumNexus, // 4000 - 5000m+: Cosmic void, shifting golden aura & crystalline monoliths
}

extension SectorBiomeExtension on SectorBiome {
  String get sectorTag {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return 'SECTOR 01 [0-1000M]';
      case SectorBiome.toxicFoundry:
        return 'SECTOR 02 [1000-2000M]';
      case SectorBiome.maglevTunnel:
        return 'SECTOR 03 [2000-3000M]';
      case SectorBiome.orbitalSkyway:
        return 'SECTOR 04 [3000-4000M]';
      case SectorBiome.quantumNexus:
        return 'SECTOR 05 [4000M+]';
    }
  }

  String get displayName {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return 'NEON METROPOLIS';
      case SectorBiome.toxicFoundry:
        return 'TOXIC FOUNDRY & CORE';
      case SectorBiome.maglevTunnel:
        return 'MAGLEV SUB-TUNNEL';
      case SectorBiome.orbitalSkyway:
        return 'ORBITAL SKYWAY';
      case SectorBiome.quantumNexus:
        return 'QUANTUM NEXUS';
    }
  }

  String get subtitle {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return 'DOWNTOWN CYBER HIGHWAY';
      case SectorBiome.toxicFoundry:
        return 'HIGH HEAT INDUSTRIAL ZONE';
      case SectorBiome.maglevTunnel:
        return 'HYPER-VELOCITY UNDERGRID';
      case SectorBiome.orbitalSkyway:
        return 'STRATOSPHERIC DATA GLASSWAY';
      case SectorBiome.quantumNexus:
        return 'ZERO-G COSMIC VOID';
    }
  }

  Color get primaryAccent {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return const Color(0xFF00E5FF); // Electric Cyan
      case SectorBiome.toxicFoundry:
        return const Color(0xFFFF9100); // Molten Amber
      case SectorBiome.maglevTunnel:
        return const Color(0xFFD500F9); // Synthwave Violet
      case SectorBiome.orbitalSkyway:
        return const Color(0xFF00E676); // Matrix Emerald
      case SectorBiome.quantumNexus:
        return const Color(0xFFFFD700); // Quantum Gold
    }
  }

  Color get secondaryAccent {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return const Color(0xFFFF007F); // Hot Magenta
      case SectorBiome.toxicFoundry:
        return const Color(0xFFFF3D00); // Furnace Crimson
      case SectorBiome.maglevTunnel:
        return const Color(0xFF7C4DFF); // Deep Indigo
      case SectorBiome.orbitalSkyway:
        return const Color(0xFF00B0FF); // Sky Blue
      case SectorBiome.quantumNexus:
        return const Color(0xFFE040FB); // Cosmic Violet
    }
  }

  Color get roadColor {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return const Color(0xFF131722);
      case SectorBiome.toxicFoundry:
        return const Color(0xFF1F1610);
      case SectorBiome.maglevTunnel:
        return const Color(0xFF171026);
      case SectorBiome.orbitalSkyway:
        return const Color(0xFF0E201B);
      case SectorBiome.quantumNexus:
        return const Color(0xFF160E2A);
    }
  }

  Color get wallColor {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return const Color(0xFF07090D);
      case SectorBiome.toxicFoundry:
        return const Color(0xFF0F0A07);
      case SectorBiome.maglevTunnel:
        return const Color(0xFF0B0614);
      case SectorBiome.orbitalSkyway:
        return const Color(0xFF050E0C);
      case SectorBiome.quantumNexus:
        return const Color(0xFF080414);
    }
  }

  List<Color> get skyGradient {
    switch (this) {
      case SectorBiome.neonMetropolis:
        return const [Color(0xFF07080D), Color(0xFF0F131C), Color(0xFF161B28)];
      case SectorBiome.toxicFoundry:
        return const [Color(0xFF100703), Color(0xFF1F0D06), Color(0xFF2E1408)];
      case SectorBiome.maglevTunnel:
        return const [Color(0xFF080312), Color(0xFF130824), Color(0xFF200E38)];
      case SectorBiome.orbitalSkyway:
        return const [Color(0xFF030D0A), Color(0xFF071C17), Color(0xFF0D2E26)];
      case SectorBiome.quantumNexus:
        return const [Color(0xFF04000D), Color(0xFF0B0320), Color(0xFF19063D)];
    }
  }
}
