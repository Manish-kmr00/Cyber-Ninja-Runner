import 'package:flutter/material.dart';

/// Represents an individual reward tier in the CP Boost feature.
class CpBoostTier {
  final String id;
  final String title;
  final String subtitle;
  final int rewardCp;
  final IconData icon;

  const CpBoostTier({
    required this.id,
    required this.title,
    required this.subtitle,
    required this.rewardCp,
    required this.icon,
  });
}

/// Central configuration for the CP Boost / CP Vault feature.
///
/// Modifying values here dynamically updates the entire UI, limits,
/// cooldown timers, and reward calculations across the game.
class CpBoostConfig {
  /// Maximum number of rewarded video ads a player can watch for CP Boost per calendar day.
  static const int maxDailyAds = 10;

  /// Mandatory cooldown duration (in seconds) required between consecutive CP Boost reward claims.
  static const int cooldownSeconds = 60;

  /// Central definition of CP Boost reward tiers.
  static const List<CpBoostTier> tiers = [
    CpBoostTier(
      id: 'tier_1',
      title: 'RECON DATA PACK',
      subtitle: 'Fast Neural Uplink',
      rewardCp: 500,
      icon: Icons.electric_bolt_rounded,
    ),
    CpBoostTier(
      id: 'tier_2',
      title: 'MATRIX OVERDRIVE',
      subtitle: 'High-Bandwidth Frequency Tap',
      rewardCp: 750,
      icon: Icons.flash_on_rounded,
    ),
    CpBoostTier(
      id: 'tier_3',
      title: 'CYBER VAULT INJECTION',
      subtitle: 'Maximum Encrypted Transfer',
      rewardCp: 1000,
      icon: Icons.diamond_rounded,
    ),
  ];
}
