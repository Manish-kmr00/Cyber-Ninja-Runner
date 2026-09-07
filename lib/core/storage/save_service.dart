import 'dart:convert';
import 'package:flutter/foundation.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../constants/game_enums.dart';
import 'save_models.dart';

class SaveService extends ChangeNotifier {
  static const String _keyPlayer = 'sqube_player_save_v1';
  static const String _keyStats = 'sqube_stats_save_v1';
  static const String _keySettings = 'sqube_settings_save_v1';

  final PlayerData player = PlayerData();
  final StatsData stats = StatsData();
  final SettingsData settings = SettingsData();

  bool _isLoaded = false;
  bool get isLoaded => _isLoaded;

  Future<void> init() async {
    final prefs = await SharedPreferences.getInstance();

    final playerRaw = prefs.getString(_keyPlayer);
    if (playerRaw != null) {
      try {
        player.loadJson(jsonDecode(playerRaw));
      } catch (e) {
        debugPrint('Error loading player data: $e');
      }
    }

    final statsRaw = prefs.getString(_keyStats);
    if (statsRaw != null) {
      try {
        stats.loadJson(jsonDecode(statsRaw));
      } catch (e) {
        debugPrint('Error loading stats data: $e');
      }
    }

    final settingsRaw = prefs.getString(_keySettings);
    if (settingsRaw != null) {
      try {
        settings.loadJson(jsonDecode(settingsRaw));
      } catch (e) {
        debugPrint('Error loading settings data: $e');
      }
    }

    _isLoaded = true;
    notifyListeners();
  }

  Future<void> saveAll() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString(_keyPlayer, jsonEncode(player.toJson()));
    await prefs.setString(_keyStats, jsonEncode(stats.toJson()));
    await prefs.setString(_keySettings, jsonEncode(settings.toJson()));
    notifyListeners();
  }

  void addCubePoints(int amount) {
    player.cubePoints.add(amount);
    saveAll();
  }

  bool spendCubePoints(int amount) {
    if (player.cubePoints.value >= amount) {
      player.cubePoints.subtract(amount);
      saveAll();
      return true;
    }
    return false;
  }

  void unlockSkin(PlayerSkin skin) {
    player.unlockedSkins.add(skin);
    player.equippedSkin = skin;
    saveAll();
  }

  void equipSkin(PlayerSkin skin) {
    if (player.unlockedSkins.contains(skin)) {
      player.equippedSkin = skin;
      saveAll();
    }
  }

  void selectHero(CharacterHero hero) {
    player.selectedHero = hero;
    saveAll();
  }

  void addBooster(BoosterType type, int count) {
    player.boosters[type]?.add(count);
    saveAll();
  }

  void setRemoveAds(bool val) {
    player.removeAdsPurchased = val;
    saveAll();
  }

  bool unlockTenXMode() {
    const cost = 50000;
    if (player.cubePoints.value >= cost) {
      player.cubePoints.subtract(cost);
      player.isTenXUnlocked = true;
      saveAll();
      return true;
    }
    return false;
  }

  bool unlockFlightMode() {
    const cost = 100000;
    if (player.cubePoints.value >= cost) {
      player.cubePoints.subtract(cost);
      player.isFlightUnlocked = true;
      saveAll();
      return true;
    }
    return false;
  }

  bool useBooster(BoosterType type) {
    final current = player.boosters[type]?.value ?? 0;
    if (current > 0) {
      player.boosters[type]?.subtract(1);
      saveAll();
      return true;
    }
    return false;
  }

  void recordRunResult({
    required GameMode mode,
    required int distance,
    required int jumps,
    required int shadowHides,
  }) {
    stats.totalRuns++;
    stats.totalJumps += jumps;
    stats.totalShadowHides += shadowHides;
    stats.totalDeaths++;
    stats.updateBestForMode(mode, distance);

    // Reward 1 CP per 10m traveled (multiplied if 10x mode)
    final multiplier = mode == GameMode.tenXChallenge ? 10 : 1;
    final earnedCP = (distance ~/ 10) * multiplier;
    if (earnedCP > 0) {
      player.cubePoints.add(earnedCP);
    }

    saveAll();
  }
}
