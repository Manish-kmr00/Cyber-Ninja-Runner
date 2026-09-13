import '../../audio/audio_manager.dart';

export '../../audio/audio_manager.dart';

/// Central Audio Service facade for Cyber-Ninja-Runner.
///
/// Decouples gameplay callers from low-level audio mechanics by dispatching
/// clean [GameAudioEvent]s to [AudioManager].
class AudioService {
  static final AudioService _instance = AudioService._internal();
  factory AudioService() => _instance;
  AudioService._internal();

  final AudioManager _mgr = AudioManager();

  // Volume getters
  double get masterVolume => _mgr.masterVolume;
  double get musicVolume => _mgr.musicVolume;
  double get sfxVolume => _mgr.sfxVolume;
  double get ambienceVolume => _mgr.ambienceVolume;
  bool get isMuted => _mgr.isMuted;
  bool get hapticsEnabled => _mgr.hapticsEnabled;
  set hapticsEnabled(bool val) => _mgr.hapticsEnabled = val;

  /// Initializes the centralized audio engine.
  Future<void> init() => _mgr.init();

  /// Primary event trigger dispatch.
  void trigger(
    GameAudioEvent event, {
    double volumeMultiplier = 1.0,
    bool heavyHaptic = false,
    bool rumbleHaptic = false,
  }) {
    _mgr.trigger(
      event,
      volumeMultiplier: volumeMultiplier,
      heavyHaptic: heavyHaptic,
      rumbleHaptic: rumbleHaptic,
    );
  }

  // --- Volume Controls ---
  Future<void> setMasterVolume(double volume) => _mgr.setMasterVolume(volume);
  Future<void> setMusicVolume(double volume) => _mgr.setMusicVolume(volume);
  void setSfxVolume(double volume) => _mgr.setSfxVolume(volume);
  Future<void> setAmbienceVolume(double volume) =>
      _mgr.setAmbienceVolume(volume);
  Future<void> setMuted(bool muted) => _mgr.setMuted(muted);

  void updateVolumes({
    double? master,
    required double music,
    required double sfx,
    double? ambience,
    bool? muted,
  }) {
    _mgr.updateVolumes(
      master: master,
      music: music,
      sfx: sfx,
      ambience: ambience,
      muted: muted,
    );
  }

  // --- Music Engine ---
  Future<void> setMusicState(MusicState state) => _mgr.setMusicState(state);
  Future<void> startMenuMusic() => _mgr.setMusicState(MusicState.menu);
  Future<void> startGameplayMusic() => _mgr.setMusicState(MusicState.gameplay);
  Future<void> pauseMusic() => _mgr.pauseMusic();
  Future<void> resumeMusic() => _mgr.resumeMusic();
  Future<void> stopMusic() => _mgr.stopMusic();
  Future<Map<String, dynamic>> runRealDeviceAudioQASuite() =>
      _mgr.runRealDeviceAudioQASuite();

  // --- Player Actions ---
  void playJump() => trigger(GameAudioEvent.playerJump, heavyHaptic: true);
  void playFlip() => trigger(GameAudioEvent.playerJump, heavyHaptic: true);
  void playSlide() => trigger(GameAudioEvent.playerSlide);
  void playWallJump() =>
      trigger(GameAudioEvent.playerWallJump, heavyHaptic: true);
  void playLand() => trigger(GameAudioEvent.playerLand);
  void playDamage() => trigger(GameAudioEvent.playerDamage, heavyHaptic: true);
  void playDeath() => trigger(GameAudioEvent.playerDeath, rumbleHaptic: true);

  // --- Combat & Hazards ---
  void playSlash() => trigger(GameAudioEvent.attack);
  void playHit() => trigger(GameAudioEvent.hit);
  void playEnemyDestroy() =>
      trigger(GameAudioEvent.enemyDeath, rumbleHaptic: true);
  void playCannonFire() =>
      trigger(GameAudioEvent.weaponFire, rumbleHaptic: true);
  void playLaser() => trigger(GameAudioEvent.projectile);

  // --- Environment & Collectibles ---
  void playCollect() => trigger(GameAudioEvent.collect);
  void playBooster() => trigger(GameAudioEvent.booster);
  void playShield() => trigger(GameAudioEvent.shield);
  void playCheckpoint() =>
      trigger(GameAudioEvent.checkpoint, heavyHaptic: true);

  // --- UI & Screens ---
  void playClick() => trigger(GameAudioEvent.buttonClick);
  void playPurchase() => trigger(GameAudioEvent.purchase, heavyHaptic: true);
  void playAlert() => trigger(GameAudioEvent.notification);
  void playError() => trigger(GameAudioEvent.error);
  void playCrateOpen() => trigger(GameAudioEvent.menuOpen, rumbleHaptic: true);

  // --- Fallbacks & Direct Controls ---
  void triggerHaptic({bool heavy = false, bool rumble = false}) =>
      _mgr.triggerHaptic(heavy: heavy, rumble: rumble);

  /// String-based compatibility mapping for legacy calls.
  Future<void> playSfx(String sfxName) async {
    switch (sfxName.toLowerCase()) {
      case 'jump':
        playJump();
        break;
      case 'flip':
        playFlip();
        break;
      case 'slide':
        playSlide();
        break;
      case 'wall_jump':
        playWallJump();
        break;
      case 'slash':
        playSlash();
        break;
      case 'laser':
        playLaser();
        break;
      case 'cannon_fire':
        playCannonFire();
        break;
      case 'enemy_destroy':
        playEnemyDestroy();
        break;
      case 'collect':
        playCollect();
        break;
      case 'checkpoint':
        playCheckpoint();
        break;
      case 'booster':
        playBooster();
        break;
      case 'shield':
        playShield();
        break;
      case 'crate_open':
        playCrateOpen();
        break;
      case 'death':
        playDeath();
        break;
      case 'click':
        playClick();
        break;
      case 'purchase':
        playPurchase();
        break;
      case 'alert':
        playAlert();
        break;
      default:
        trigger(GameAudioEvent.buttonClick);
        break;
    }
  }

  // --- FMOD Adaptive Parameters & Snapshots ---
  void setPlayerSpeed(double speed) => _mgr.setPlayerSpeed(speed);
  void setDangerIntensity(double intensity) =>
      _mgr.setDangerIntensity(intensity);
  void setIntensity(double intensity) => _mgr.setIntensity(intensity);
  void setDanger(double danger) => _mgr.setDanger(danger);
  void setCombo(int combo) => _mgr.setCombo(combo);
  void setPausedSnapshot(bool active) => _mgr.setPausedSnapshot(active);
  void resetCombo() => _mgr.setCombo(0);
}
