import 'dart:math';
import '../constants/game_enums.dart';
import '../storage/save_service.dart';

enum CrateRarity { common, rare, epic, mythic }

class CrateDropItem {
  final String title;
  final String description;
  final String iconType; // 'cp', 'booster', 'skin', 'jackpot'
  final int count;
  final CrateRarity rarity;
  final BoosterType? boosterType;
  final PlayerSkin? skin;

  const CrateDropItem({
    required this.title,
    required this.description,
    required this.iconType,
    required this.count,
    required this.rarity,
    this.boosterType,
    this.skin,
  });
}

class DailyCrateReward {
  final int dayNumber;
  final List<CrateDropItem> items;
  final bool isJackpot;
  final int totalCP;

  const DailyCrateReward({
    required this.dayNumber,
    required this.items,
    required this.isJackpot,
    required this.totalCP,
  });
}

class DailyCrateService {
  static const int cooldownMs = 20 * 60 * 60 * 1000; // 20 hours
  static const int streakTimeoutMs =
      48 * 60 * 60 * 1000; // 48 hours to preserve streak
  static const int streakSaverCostCP = 2500;

  final Random _random = Random();

  /// Checks whether crate is currently available to claim.
  bool isCrateReady(SaveService saveService) {
    final now = DateTime.now().millisecondsSinceEpoch;
    final lastClaim = saveService.player.lastDailyClaimEpoch;
    if (lastClaim == 0) return true;
    return (now - lastClaim) >= cooldownMs;
  }

  /// Returns remaining milliseconds until crate becomes available.
  int getRemainingCooldownMs(SaveService saveService) {
    final now = DateTime.now().millisecondsSinceEpoch;
    final lastClaim = saveService.player.lastDailyClaimEpoch;
    if (lastClaim == 0) return 0;
    final elapsed = now - lastClaim;
    final diff = cooldownMs - elapsed;
    return diff > 0 ? diff : 0;
  }

  /// Checks if the player's streak has expired (missed consecutive day).
  bool isStreakBroken(SaveService saveService) {
    final now = DateTime.now().millisecondsSinceEpoch;
    final lastClaim = saveService.player.lastDailyClaimEpoch;
    if (lastClaim == 0) return false;
    final elapsed = now - lastClaim;
    return elapsed > streakTimeoutMs;
  }

  /// Restores broken streak by paying CP.
  bool restoreStreakWithCP(SaveService saveService) {
    if (saveService.player.cyberPoints.value >= streakSaverCostCP) {
      saveService.spendCyberPoints(streakSaverCostCP);
      // Soften last claim epoch so streak is preserved
      final now = DateTime.now().millisecondsSinceEpoch;
      saveService.player.lastDailyClaimEpoch = now - cooldownMs;
      saveService.saveAll();
      return true;
    }
    return false;
  }

  /// Resets streak to Day 1 if player chooses not to restore.
  void resetStreak(SaveService saveService) {
    saveService.player.dailyStreak = 1;
    saveService.saveAll();
  }

  /// Generates the reward for the current streak day with weighted RNG loot.
  DailyCrateReward generateReward(SaveService saveService) {
    int streak = saveService.player.dailyStreak;
    if (streak < 1 || streak > 7) {
      streak = 1;
    }

    final items = <CrateDropItem>[];
    int baseCP = 200;
    bool isJackpot = false;

    // 0.5% Jackpot Roll
    final jackpotRoll = _random.nextDouble();
    if (jackpotRoll < 0.005) {
      isJackpot = true;
      baseCP = 10000;
      items.add(
        const CrateDropItem(
          title: 'NEURAL MEGA JACKPOT',
          description: '10,000 Cyber Points Grand Prize!',
          iconType: 'jackpot',
          count: 10000,
          rarity: CrateRarity.mythic,
        ),
      );
    } else {
      // Slot 1: Escalating Daily CP by Streak
      switch (streak) {
        case 1:
          baseCP = 200 + _random.nextInt(100);
          break;
        case 2:
          baseCP = 350 + _random.nextInt(150);
          break;
        case 3:
          baseCP = 500 + _random.nextInt(200);
          break;
        case 4:
          baseCP = 750 + _random.nextInt(250);
          break;
        case 5:
          baseCP = 1200 + _random.nextInt(300);
          break;
        case 6:
          baseCP = 1800 + _random.nextInt(400);
          break;
        case 7:
          baseCP = 5000;
          break;
      }

      final cpRarity = streak >= 6
          ? CrateRarity.epic
          : (streak >= 4 ? CrateRarity.rare : CrateRarity.common);

      items.add(
        CrateDropItem(
          title: 'CYBER POINTS',
          description: streak == 7
              ? 'Quantum Vault Core'
              : 'Supply Protocol Credit',
          iconType: 'cp',
          count: baseCP,
          rarity: cpRarity,
        ),
      );
    }

    // Slot 2: Tactical Boosters
    final boosterRoll = _random.nextInt(4);
    BoosterType selectedBooster;
    String boosterName;
    switch (boosterRoll) {
      case 0:
        selectedBooster = BoosterType.safeGround;
        boosterName = 'Energy Shield';
        break;
      case 1:
        selectedBooster = BoosterType.invisibility;
        boosterName = 'Stealth Camo';
        break;
      case 2:
        selectedBooster = BoosterType.matrixSlowMo;
        boosterName = 'Matrix Slow-Mo';
        break;
      default:
        selectedBooster = BoosterType.killEyes;
        boosterName = 'Cyber EMP Drone';
        break;
    }

    final boosterCount = streak >= 6 ? 2 : 1;
    items.add(
      CrateDropItem(
        title: boosterName,
        description: 'Tactical Combat Booster',
        iconType: 'booster',
        count: boosterCount,
        rarity: streak >= 5 ? CrateRarity.rare : CrateRarity.common,
        boosterType: selectedBooster,
      ),
    );

    // Slot 3: Quantum Surprise / Shard / Bonus
    if (streak == 7) {
      // Day 7: Quantum Vault guarantees a 2nd bundle of all boosters!
      items.add(
        const CrateDropItem(
          title: 'FULL ARSENAL PACK',
          description: '+1 to All 4 Boosters',
          iconType: 'booster',
          count: 4,
          rarity: CrateRarity.mythic,
        ),
      );
    } else {
      // Random bonus roll: Extra CP or Extra Booster
      final surpriseRoll = _random.nextDouble();
      if (surpriseRoll < 0.40) {
        final bonusCP = 150 * streak;
        items.add(
          CrateDropItem(
            title: 'BONUS CP DATA',
            description: 'Overclocked Protocol Drop',
            iconType: 'cp',
            count: bonusCP,
            rarity: CrateRarity.rare,
          ),
        );
        baseCP += bonusCP;
      } else {
        items.add(
          const CrateDropItem(
            title: 'ENERGY SHIELD CORE',
            description: 'Emergency Hazard Protection',
            iconType: 'booster',
            count: 1,
            rarity: CrateRarity.rare,
            boosterType: BoosterType.safeGround,
          ),
        );
      }
    }

    return DailyCrateReward(
      dayNumber: streak,
      items: items,
      isJackpot: isJackpot,
      totalCP: baseCP,
    );
  }

  /// Claims the reward, credits all items to saveService, and advances streak.
  void claimReward(SaveService saveService, DailyCrateReward reward) {
    final now = DateTime.now().millisecondsSinceEpoch;
    saveService.player.lastDailyClaimEpoch = now;

    // Credit CP
    saveService.addCyberPoints(reward.totalCP);

    // Credit Boosters
    for (final item in reward.items) {
      if (item.iconType == 'booster') {
        if (item.title == 'FULL ARSENAL PACK') {
          saveService.addBooster(BoosterType.safeGround, 1);
          saveService.addBooster(BoosterType.invisibility, 1);
          saveService.addBooster(BoosterType.matrixSlowMo, 1);
          saveService.addBooster(BoosterType.killEyes, 1);
        } else if (item.boosterType != null) {
          saveService.addBooster(item.boosterType!, item.count);
        }
      }
    }

    // Advance Streak (cycles 1 -> 7, then loops back to 1)
    if (saveService.player.dailyStreak >= 7) {
      saveService.player.dailyStreak = 1;
    } else {
      saveService.player.dailyStreak += 1;
    }

    saveService.saveAll();
  }
}
