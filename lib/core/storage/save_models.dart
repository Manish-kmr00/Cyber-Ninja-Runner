import '../constants/game_enums.dart';
import '../security/safe_types.dart';

class PlayerData {
  final SafeInt cyberPoints = SafeInt(500);
  SafeInt get cubePoints => cyberPoints;
  SafeInt get cyberNinjaPoints => cyberPoints;

  CharacterHero selectedHero = CharacterHero.cyberNinja;
  PlayerSkin equippedSkin = PlayerSkin.classicWhite;
  final Set<PlayerSkin> unlockedSkins = {PlayerSkin.classicWhite};

  // Booster inventory
  final Map<BoosterType, SafeInt> boosters = {
    BoosterType.safeGround: SafeInt(3),
    BoosterType.matrixSlowMo: SafeInt(2),
    BoosterType.invisibility: SafeInt(2),
    BoosterType.killEyes: SafeInt(1),
  };

  bool isTenXUnlocked = false;
  bool isFlightUnlocked = false;
  int dailyStreak = 1;
  int lastDailyClaimEpoch = 0;

  Map<String, dynamic> toJson() => {
    'cyberPoints': cyberPoints.value,
    'cubePoints': cyberPoints.value,
    'selectedHero': selectedHero.name,
    'equippedSkin': equippedSkin.name,
    'unlockedSkins': unlockedSkins.map((s) => s.name).toList(),
    'boosters': boosters.map((k, v) => MapEntry(k.name, v.value)),
    'isTenXUnlocked': isTenXUnlocked,
    'isFlightUnlocked': isFlightUnlocked,
    'dailyStreak': dailyStreak,
    'lastDailyClaimEpoch': lastDailyClaimEpoch,
  };

  void loadJson(Map<String, dynamic> json) {
    cyberPoints.value = json['cyberPoints'] ?? json['cubePoints'] ?? 500;
    selectedHero = CharacterHero.values.firstWhere(
      (h) => h.name == json['selectedHero'],
      orElse: () => CharacterHero.cyberNinja,
    );
    equippedSkin = PlayerSkin.values.firstWhere(
      (s) => s.name == json['equippedSkin'],
      orElse: () => PlayerSkin.classicWhite,
    );
    if (json['unlockedSkins'] != null) {
      unlockedSkins.clear();
      for (final s in json['unlockedSkins']) {
        unlockedSkins.add(
          PlayerSkin.values.firstWhere(
            (e) => e.name == s,
            orElse: () => PlayerSkin.classicWhite,
          ),
        );
      }
    }
    unlockedSkins.add(PlayerSkin.classicWhite);
    if (json['boosters'] != null) {
      final bMap = json['boosters'] as Map<String, dynamic>;
      bMap.forEach((k, v) {
        final type = BoosterType.values.firstWhere(
          (t) => t.name == k,
          orElse: () => BoosterType.safeGround,
        );
        boosters[type] = SafeInt(v as int);
      });
    }
    isTenXUnlocked = json['isTenXUnlocked'] ?? false;
    isFlightUnlocked = json['isFlightUnlocked'] ?? false;
    dailyStreak = json['dailyStreak'] ?? 1;
    lastDailyClaimEpoch = json['lastDailyClaimEpoch'] ?? 0;
  }
}

class StatsData {
  int bestDistanceRun = 0;
  int bestDistance10x = 0;
  int bestDistanceFlight = 0;
  int get bestDistanceRunner => bestDistanceFlight;
  set bestDistanceRunner(int val) => bestDistanceFlight = val;
  int get bestDistanceSqubeBird => bestDistanceFlight;
  set bestDistanceSqubeBird(int val) => bestDistanceFlight = val;

  int totalRuns = 0;
  int totalJumps = 0;
  int totalShadowHides = 0;
  int totalDeaths = 0;

  Map<String, dynamic> toJson() => {
    'bestDistanceRun': bestDistanceRun,
    'bestDistance10x': bestDistance10x,
    'bestDistanceFlight': bestDistanceFlight,
    'bestDistanceRunner': bestDistanceFlight,
    'bestDistanceSqubeBird': bestDistanceFlight,
    'totalRuns': totalRuns,
    'totalJumps': totalJumps,
    'totalShadowHides': totalShadowHides,
    'totalDeaths': totalDeaths,
  };

  void loadJson(Map<String, dynamic> json) {
    bestDistanceRun = json['bestDistanceRun'] ?? 0;
    bestDistance10x = json['bestDistance10x'] ?? 0;
    bestDistanceFlight =
        json['bestDistanceFlight'] ??
        json['bestDistanceRunner'] ??
        json['bestDistanceSqubeBird'] ??
        0;
    totalRuns = json['totalRuns'] ?? 0;
    totalJumps = json['totalJumps'] ?? 0;
    totalShadowHides = json['totalShadowHides'] ?? 0;
    totalDeaths = json['totalDeaths'] ?? 0;
  }

  int getBestForMode(GameMode mode) {
    switch (mode) {
      case GameMode.run:
        return bestDistanceRun;
      case GameMode.tenXChallenge:
        return bestDistance10x;
      case GameMode.flightRunner:
        return bestDistanceFlight;
      case GameMode.multiplayer:
        return bestDistanceRun;
    }
  }

  void updateBestForMode(GameMode mode, int distance) {
    switch (mode) {
      case GameMode.run:
        if (distance > bestDistanceRun) bestDistanceRun = distance;
        break;
      case GameMode.tenXChallenge:
        if (distance > bestDistance10x) bestDistance10x = distance;
        break;
      case GameMode.flightRunner:
        if (distance > bestDistanceFlight) bestDistanceFlight = distance;
        break;
      case GameMode.multiplayer:
        if (distance > bestDistanceRun) bestDistanceRun = distance;
        break;
    }
  }
}

class SettingsData {
  double musicVolume = 0.8;
  double sfxVolume = 1.0;
  bool isMuted = false;
  bool hapticsEnabled = true;
  bool godModeEnabled = false;
  bool invertedControls = false;
  double buttonOpacity = 1.0;
  bool highQualityEffects = true;
  ControlScheme controlScheme = ControlScheme.buttons;
  double swipeSensitivity = 1.0;
  String languageCode = 'en';

  Map<String, dynamic> toJson() => {
    'musicVolume': musicVolume,
    'sfxVolume': sfxVolume,
    'isMuted': isMuted,
    'hapticsEnabled': hapticsEnabled,
    'godModeEnabled': godModeEnabled,
    'invertedControls': invertedControls,
    'buttonOpacity': buttonOpacity,
    'highQualityEffects': highQualityEffects,
    'controlScheme': controlScheme.name,
    'swipeSensitivity': swipeSensitivity,
    'languageCode': languageCode,
  };

  void loadJson(Map<String, dynamic> json) {
    musicVolume = (json['musicVolume'] as num?)?.toDouble() ?? 0.8;
    sfxVolume = (json['sfxVolume'] as num?)?.toDouble() ?? 1.0;
    isMuted = json['isMuted'] ?? false;
    hapticsEnabled = json['hapticsEnabled'] ?? true;
    godModeEnabled = json['godModeEnabled'] ?? false;
    invertedControls = json['invertedControls'] ?? false;
    buttonOpacity = (json['buttonOpacity'] as num?)?.toDouble() ?? 1.0;
    highQualityEffects = json['highQualityEffects'] ?? true;
    controlScheme = ControlScheme.values.firstWhere(
      (c) => c.name == json['controlScheme'],
      orElse: () => ControlScheme.buttons,
    );
    swipeSensitivity = (json['swipeSensitivity'] as num?)?.toDouble() ?? 1.0;
    languageCode = json['languageCode'] ?? 'en';
  }
}
