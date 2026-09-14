import 'dart:convert';
import 'package:flutter/foundation.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../audio/audio_service.dart';
import '../constants/game_enums.dart';
import '../security/safe_types.dart';
import 'save_models.dart';

class SaveService extends ChangeNotifier {
  static const String _keyPlayer = 'cyber_ninja_runner_player_save_v1';
  static const String _legacyKeyPlayer = 'sqube_player_save_v1';
  static const String _keyStats = 'cyber_ninja_runner_stats_save_v1';
  static const String _legacyKeyStats = 'sqube_stats_save_v1';
  static const String _keySettings = 'cyber_ninja_runner_settings_save_v1';
  static const String _legacyKeySettings = 'sqube_settings_save_v1';

  final PlayerData player = PlayerData();
  final StatsData stats = StatsData();
  final SettingsData settings = SettingsData();

  bool _isLoaded = false;
  bool get isLoaded => _isLoaded;

  Future<void> init() async {
    final prefs = await SharedPreferences.getInstance();

    final playerRaw =
        prefs.getString(_keyPlayer) ?? prefs.getString(_legacyKeyPlayer);
    if (playerRaw != null) {
      try {
        player.loadJson(jsonDecode(playerRaw));
      } catch (e) {
        debugPrint('Error loading player data: $e');
      }
    }

    final statsRaw =
        prefs.getString(_keyStats) ?? prefs.getString(_legacyKeyStats);
    if (statsRaw != null) {
      try {
        stats.loadJson(jsonDecode(statsRaw));
      } catch (e) {
        debugPrint('Error loading stats data: $e');
      }
    }

    final settingsRaw =
        prefs.getString(_keySettings) ?? prefs.getString(_legacyKeySettings);
    if (settingsRaw != null) {
      try {
        settings.loadJson(jsonDecode(settingsRaw));
      } catch (e) {
        debugPrint('Error loading settings data: $e');
      }
    }

    // Sync audio and haptics preferences on launch
    AudioService().updateVolumes(
      master: settings.masterVolume,
      music: settings.musicVolume,
      sfx: settings.sfxVolume,
      muted: settings.isMuted,
    );
    AudioService().hapticsEnabled = settings.hapticsEnabled;

    _isLoaded = true;
    if (settings.godModeEnabled) {
      unlockAllContent();
    }
    notifyListeners();
  }

  bool get isTenXUnlocked => settings.godModeEnabled || player.isTenXUnlocked;
  bool get isFlightUnlocked =>
      settings.godModeEnabled || player.isFlightUnlocked;
  bool isSkinUnlocked(PlayerSkin skin) =>
      settings.godModeEnabled || player.unlockedSkins.contains(skin);

  int getBoosterCount(BoosterType type) => settings.godModeEnabled
      ? (player.boosters[type]?.value ?? 0).clamp(99, 999999)
      : (player.boosters[type]?.value ?? 0);

  /// Unlocks all locked content across the game (skins, maps, boosters, cyber points)
  void unlockAllContent() {
    player.unlockedSkins.addAll(PlayerSkin.values);
    player.isTenXUnlocked = true;
    player.isFlightUnlocked = true;
    for (final b in BoosterType.values) {
      if ((player.boosters[b]?.value ?? 0) < 99) {
        player.boosters[b] = SafeInt(99);
      }
    }
    if (player.cyberPoints.value < 99999) {
      player.cyberPoints.value = 99999;
    }
  }

  /// Toggles immortal mode. If enabled, immediately unlocks all game content.
  void setGodMode(bool enabled) {
    settings.godModeEnabled = enabled;
    if (enabled) {
      unlockAllContent();
    }
    saveAll();
  }

  Future<void> saveAll() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString(_keyPlayer, jsonEncode(player.toJson()));
    await prefs.setString(_keyStats, jsonEncode(stats.toJson()));
    await prefs.setString(_keySettings, jsonEncode(settings.toJson()));
    notifyListeners();
  }

  void resetStatsOnly() {
    stats.bestDistanceRun = 0;
    stats.bestDistance10x = 0;
    stats.bestDistanceFlight = 0;
    stats.totalRuns = 0;
    stats.totalJumps = 0;
    stats.totalShadowHides = 0;
    stats.totalDeaths = 0;
    saveAll();
  }

  void resetAllProgress() {
    player.cyberPoints.value = 0;
    player.equippedSkin = PlayerSkin.classicWhite;
    player.unlockedSkins.clear();
    player.unlockedSkins.add(PlayerSkin.classicWhite);
    player.isTenXUnlocked = false;
    player.isFlightUnlocked = false;
    player.boosters.forEach((_, count) => count.value = 3);
    resetStatsOnly();
  }

  void addCyberPoints(int amount) => addCyberNinjaPoints(amount);
  void addCyberNinjaPoints(int amount) {
    player.cyberPoints.add(amount);
    saveAll();
  }

  void addCubePoints(int amount) => addCyberNinjaPoints(amount);

  bool spendCyberPoints(int amount) => spendCyberNinjaPoints(amount);
  bool spendCyberNinjaPoints(int amount) {
    if (player.cyberPoints.value >= amount) {
      player.cyberPoints.subtract(amount);
      saveAll();
      return true;
    }
    return false;
  }

  bool spendCubePoints(int amount) => spendCyberNinjaPoints(amount);

  void unlockSkin(PlayerSkin skin) {
    player.unlockedSkins.add(skin);
    player.equippedSkin = skin;
    saveAll();
  }

  void equipSkin(PlayerSkin skin) {
    if (isSkinUnlocked(skin)) {
      player.unlockedSkins.add(skin);
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

  bool unlockTenXMode() {
    const cost = 50000;
    if (player.cyberPoints.value >= cost) {
      player.cyberPoints.subtract(cost);
      player.isTenXUnlocked = true;
      saveAll();
      return true;
    }
    return false;
  }

  bool unlockFlightMode() {
    const cost = 100000;
    if (player.cyberPoints.value >= cost) {
      player.cyberPoints.subtract(cost);
      player.isFlightUnlocked = true;
      saveAll();
      return true;
    }
    return false;
  }

  bool useBooster(BoosterType type) {
    if (settings.godModeEnabled) {
      return true;
    }
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
      player.cyberPoints.add(earnedCP);
    }

    saveAll();
  }
}
