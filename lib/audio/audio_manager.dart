import 'dart:async';
import 'package:flutter/services.dart';
import 'package:flutter/widgets.dart';

import 'audio_event.dart';
import 'fmod/fmod_bridge.dart';

export 'audio_event.dart';

/// Supported background music states for the FMOD adaptive soundtrack.
enum MusicState { menu, gameplay, danger, victory, gameOver }

/// Production-grade AAA FMOD Audio Manager for Cyber-Ninja-Runner.
///
/// Features:
/// - FMOD Native Engine integration via low-latency C FFI.
/// - Bank loading: Master, Strings, Music, and SFX banks loaded into native memory.
/// - Event-driven: [GameAudioEvent] maps cleanly to FMOD event paths.
/// - Adaptive parameter control: Real-time 'Intensity', 'Danger', and 'Combo' modulation.
/// - Native Mixer Buses: 'bus:/', 'bus:/Music', 'bus:/SFX', 'bus:/Ambience'.
/// - Audio Snapshots: 'snapshot:/Pause' smoothly applies studio-grade LPF during pause.
/// - Mobile lifecycle observer: Automatic native bus pausing on background/minimize.
/// - Zero-crash graceful fallback when running in tests or unsupported hosts.
class AudioManager with WidgetsBindingObserver {
  static final AudioManager _instance = AudioManager._internal();
  factory AudioManager() => _instance;
  AudioManager._internal();

  final FmodBridge _fmod = FmodBridge();

  // =========================================================================
  // 1. VOLUME SETTINGS & MIXER BUS STATE
  // =========================================================================
  double _masterVolume = 1.0;
  double _musicVolume = 0.8;
  double _sfxVolume = 0.8;
  double _ambienceVolume = 0.3;
  bool _isMuted = false;
  bool hapticsEnabled = true;

  double get masterVolume => _masterVolume;
  double get musicVolume => _musicVolume;
  double get sfxVolume => _sfxVolume;
  double get ambienceVolume => _ambienceVolume;
  bool get isMuted => _isMuted;

  double get effectiveMusicVolume =>
      _isMuted ? 0.0 : (_masterVolume * _musicVolume).clamp(0.0, 1.0);
  double get effectiveSfxVolume =>
      _isMuted ? 0.0 : (_masterVolume * _sfxVolume).clamp(0.0, 1.0);
  double get effectiveAmbienceVolume =>
      _isMuted ? 0.0 : (_masterVolume * _ambienceVolume).clamp(0.0, 1.0);

  // =========================================================================
  // 2. COOLDOWN & THROTTLING (Prevents acoustic distortion on multi-collisions)
  // =========================================================================
  final Map<GameAudioEvent, int> _cooldowns = {
    GameAudioEvent.collect: 40,
    GameAudioEvent.buttonClick: 50,
    GameAudioEvent.buttonHover: 50,
    GameAudioEvent.attack: 60,
    GameAudioEvent.hit: 50,
    GameAudioEvent.playerJump: 70,
    GameAudioEvent.playerSlide: 100,
    GameAudioEvent.playerWallJump: 70,
    GameAudioEvent.projectile: 70,
    GameAudioEvent.weaponFire: 80,
    GameAudioEvent.explosion: 80,
  };

  final Map<GameAudioEvent, int> _lastTriggerTimestamps = {};

  // =========================================================================
  // 3. FMOD EVENT REGISTRY MAPPING (Dedicated Cyber Ninja Production Events)
  // =========================================================================
  static const Map<GameAudioEvent, String> fmodEventMap = {
    // Player
    GameAudioEvent.playerJump: 'event:/Player/Jump',
    GameAudioEvent.playerLand: 'event:/Player/Land',
    GameAudioEvent.playerWallJump: 'event:/Player/WallJump',
    GameAudioEvent.playerSlide: 'event:/Player/Slide',
    GameAudioEvent.playerDamage: 'event:/Player/Damage',
    GameAudioEvent.playerDeath: 'event:/Player/Death',

    // Combat
    GameAudioEvent.attack: 'event:/Combat/Attack',
    GameAudioEvent.hit: 'event:/Combat/Hit',
    GameAudioEvent.criticalHit: 'event:/Combat/CriticalHit',
    GameAudioEvent.explosion: 'event:/Combat/Explosion',
    GameAudioEvent.projectile: 'event:/Combat/Laser',
    GameAudioEvent.weaponFire: 'event:/Combat/CannonFire',

    // Enemies
    GameAudioEvent.enemySpawn: 'event:/Enemies/Spawn',
    GameAudioEvent.enemyAttack: 'event:/Enemies/Attack',
    GameAudioEvent.enemyHit: 'event:/Enemies/Hit',
    GameAudioEvent.enemyDeath: 'event:/Enemies/Destroy',

    // Environment & Rewards
    GameAudioEvent.checkpoint: 'event:/Gameplay/Checkpoint',
    GameAudioEvent.collect: 'event:/Gameplay/Collect',
    GameAudioEvent.powerup: 'event:/Gameplay/Powerup',
    GameAudioEvent.shield: 'event:/Gameplay/Shield',
    GameAudioEvent.booster: 'event:/Gameplay/Booster',

    // UI
    GameAudioEvent.buttonClick: 'event:/UI/Click',
    GameAudioEvent.buttonHover: 'event:/UI/Hover',
    GameAudioEvent.menuOpen: 'event:/UI/MenuOpen',
    GameAudioEvent.menuClose: 'event:/UI/MenuClose',
    GameAudioEvent.purchase: 'event:/UI/Purchase',
    GameAudioEvent.notification: 'event:/UI/Notification',
    GameAudioEvent.error: 'event:/UI/Error',

    // Game State
    GameAudioEvent.gameStart: 'event:/UI/MenuOpen',
    GameAudioEvent.gameOver: 'event:/Music/GameOver',
    GameAudioEvent.levelComplete: 'event:/Music/Victory',
    GameAudioEvent.pause: 'event:/UI/MenuClose',
    GameAudioEvent.resume: 'event:/UI/MenuOpen',
  };

  // Production Music & Ambience Event Paths
  static const String musicMenuEvent = 'event:/Music/Menu';
  static const String musicGameplayEvent = 'event:/Music/Gameplay';
  static const String musicDangerEvent = 'event:/Music/Danger';
  static const String musicVictoryEvent = 'event:/Music/Victory';
  static const String musicGameOverEvent = 'event:/Music/GameOver';
  static const String ambienceEvent = 'event:/Environment/CyberCity';

  // Production Snapshot Paths
  static const String snapshotPause = 'snapshot:/Pause';
  static const String snapshotDanger = 'snapshot:/Danger';

  MusicState? _currentMusicState;
  MusicState? get currentMusicState => _currentMusicState;
  bool _isInitialized = false;

  // =========================================================================
  // 4. INITIALIZATION & LIFECYCLE
  // =========================================================================

  Future<void> init() async {
    if (_isInitialized) return;

    try {
      WidgetsBinding.instance.addObserver(this);

      final ok = await _fmod.init();
      if (ok) {
        // 1. Strings bank MUST be loaded first to populate event paths
        await _fmod.loadBankFromAsset('assets/banks/Master.strings.bank');
        await _fmod.loadBankFromAsset('assets/banks/Master.bank');
        await _fmod.loadBankFromAsset('assets/banks/Music.bank');
        await _fmod.loadBankFromAsset('assets/banks/SFX.bank');
        await _fmod.loadBankFromAsset('assets/banks/UI.bank');
        await _fmod.loadBankFromAsset('assets/banks/Ambience.bank');

        // Apply saved mixer volumes to FMOD native buses
        _applyBusVolumes();

        const MethodChannel platformChannel = MethodChannel(
          'com.moonedgestudio.cyberninjarunner/fmod',
        );
        platformChannel.setMethodCallHandler((call) async {
          if (call.method == 'runAudioQA') {
            await runRealDeviceAudioQASuite();
          }
        });

        // Check if launched directly with RUN_AUDIO_QA intent extra
        try {
          final runQa = await platformChannel.invokeMethod<String>(
            'getIntentExtra',
            {'key': 'RUN_AUDIO_QA'},
          );
          if (runQa == 'true') {
            Future.delayed(const Duration(milliseconds: 600), () {
              runRealDeviceAudioQASuite();
            });
          }
        } catch (_) {}
      }

      _isInitialized = true;
      debugPrint(
        '[AudioManager] FMOD Audio Architecture initialized successfully.',
      );
    } catch (e) {
      debugPrint('[AudioManager] Initialization warning: $e');
    }
  }

  bool _isAudioQaRunning = false;

  /// Executes full runtime QA suite across all 35 events, banks, buses, and snapshots.
  Future<Map<String, dynamic>> runRealDeviceAudioQASuite() async {
    _isAudioQaRunning = true;
    try {
      return await _fmod.runRuntimeAudioQASuite();
    } finally {
      _isAudioQaRunning = false;
    }
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    switch (state) {
      case AppLifecycleState.paused:
      case AppLifecycleState.inactive:
      case AppLifecycleState.hidden:
        _handleAppBackground();
        break;
      case AppLifecycleState.resumed:
        _handleAppForeground();
        break;
      case AppLifecycleState.detached:
        stopAll();
        break;
    }
  }

  void _handleAppBackground() {
    _fmod.setBusPaused('bus:/', true);
  }

  void _handleAppForeground() {
    if (!_isMuted) {
      _fmod.setBusPaused('bus:/', false);
      _applyBusVolumes();
    }
  }

  // =========================================================================
  // 5. AUDIO EVENT DISPATCH (SFX)
  // =========================================================================

  /// Triggers a strongly-typed game audio event with zero latency.
  void trigger(
    GameAudioEvent event, {
    double volumeMultiplier = 1.0,
    bool heavyHaptic = false,
    bool rumbleHaptic = false,
  }) {
    // 1. Tactile haptic feedback
    if (rumbleHaptic) {
      triggerHaptic(rumble: true);
    } else if (heavyHaptic) {
      triggerHaptic(heavy: true);
    }

    if (_isMuted || effectiveSfxVolume <= 0) return;

    // 2. Cooldown check
    final now = DateTime.now().millisecondsSinceEpoch;
    final cooldown = _cooldowns[event] ?? 30;
    final lastTime = _lastTriggerTimestamps[event] ?? 0;
    if (now - lastTime < cooldown) {
      return;
    }
    _lastTriggerTimestamps[event] = now;

    // 3. Resolve FMOD event path
    final eventPath = fmodEventMap[event];
    if (eventPath == null) return;

    // 4. Fire one-shot via FMOD engine
    _fmod.playOneShot(eventPath, volumeMultiplier: volumeMultiplier);
  }

  // =========================================================================
  // 6. ADAPTIVE MUSIC SYSTEM
  // =========================================================================

  Future<void> setMusicState(MusicState newState, {bool force = false}) async {
    if (_isAudioQaRunning) {
      debugPrint(
        '[AudioManager] setMusicState ($newState) ignored during active Audio QA suite',
      );
      return;
    }
    if (!force && _currentMusicState == newState) return;
    _currentMusicState = newState;

    if (_isMuted || effectiveMusicVolume <= 0) return;

    // Ensure music bus is always unpaused when setting a new active music state
    _fmod.setBusPaused('bus:/Music', false);

    switch (newState) {
      case MusicState.menu:
        _fmod.stopMusicTrack(musicGameplayEvent, immediate: true);
        _fmod.stopMusicTrack(musicDangerEvent);
        _fmod.setGlobalParameter('MusicState', 0.0);
        _fmod.playMusicTrack(musicMenuEvent);
        break;

      case MusicState.gameplay:
        _fmod.stopMusicTrack(musicMenuEvent);
        _fmod.stopMusicTrack(musicDangerEvent);
        _fmod.stopMusicTrack(musicGameplayEvent, immediate: true);
        _fmod.setGlobalParameter('MusicState', 1.0);
        _fmod.playMusicTrack(musicGameplayEvent);
        break;

      case MusicState.danger:
        _fmod.setGlobalParameter('MusicState', 2.0);
        _fmod.setGlobalParameter('DangerIntensity', 1.0);
        _fmod.playOneShot(snapshotDanger);
        _fmod.playMusicTrack(musicDangerEvent);
        break;

      case MusicState.victory:
        _fmod.stopMusicTrack(musicGameplayEvent);
        _fmod.stopMusicTrack(musicDangerEvent);
        _fmod.setGlobalParameter('MusicState', 3.0);
        _fmod.playOneShot(musicVictoryEvent);
        break;

      case MusicState.gameOver:
        _fmod.stopMusicTrack(musicGameplayEvent);
        _fmod.stopMusicTrack(musicDangerEvent);
        _fmod.setGlobalParameter('MusicState', 4.0);
        _fmod.playOneShot(musicGameOverEvent);
        break;
    }
  }

  /// Sets player speed parameter in FMOD engine (0.0 to 2.0).
  void setPlayerSpeed(double speed) {
    final clamped = speed.clamp(0.0, 2.0);
    _fmod.setGlobalParameter('PlayerSpeed', clamped);
  }

  /// Sets danger intensity parameter in FMOD engine (0.0 to 1.0).
  void setDangerIntensity(double intensity) {
    final clamped = intensity.clamp(0.0, 1.0);
    _fmod.setGlobalParameter('DangerIntensity', clamped);
    if (clamped >= 0.7) {
      _fmod.playOneShot(snapshotDanger);
    }
  }

  /// Real-time adaptive parameter modulation for dynamic game intensity.
  void setIntensity(double intensity) {
    setDangerIntensity(intensity);
  }

  /// Sets threat / danger parameter in the FMOD engine.
  void setDanger(double danger) {
    setDangerIntensity(danger);
  }

  /// Sets score combo streak multiplier parameter.
  void setCombo(int combo) {
    final speedMultiplier = (1.0 + (combo * 0.1)).clamp(1.0, 2.0);
    setPlayerSpeed(speedMultiplier);
  }

  Future<void> pauseMusic() async {
    _fmod.setBusPaused('bus:/Music', true);
  }

  Future<void> resumeMusic() async {
    if (!_isMuted && _currentMusicState != null) {
      _fmod.setBusPaused('bus:/Music', false);
    }
  }

  Future<void> stopMusic() async {
    _currentMusicState = null;
    _fmod.stopAllMusic();
  }

  // =========================================================================
  // 7. AMBIENCE ENGINE
  // =========================================================================

  Future<void> startAmbience({String eventPath = ambienceEvent}) async {
    if (_isMuted || effectiveAmbienceVolume <= 0) return;
    _fmod.playMusicTrack(eventPath);
  }

  Future<void> stopAmbience() async {
    _fmod.stopMusicTrack(ambienceEvent);
  }

  // =========================================================================
  // 8. AUDIO SNAPSHOTS (Pause filter & low health)
  // =========================================================================

  /// Activates or deactivates the studio pause snapshot (low-pass filter on music).
  void setPausedSnapshot(bool active) {
    if (active) {
      _fmod.playOneShot(snapshotPause);
    }
  }

  // =========================================================================
  // 9. MIXER BUS CONTROLS & PERSISTENCE
  // =========================================================================

  Future<void> setMasterVolume(double volume) async {
    _masterVolume = volume.clamp(0.0, 1.0);
    _applyBusVolumes();
  }

  Future<void> setMusicVolume(double volume) async {
    _musicVolume = volume.clamp(0.0, 1.0);
    _applyBusVolumes();
  }

  void setSfxVolume(double volume) {
    _sfxVolume = volume.clamp(0.0, 1.0);
    _applyBusVolumes();
  }

  Future<void> setAmbienceVolume(double volume) async {
    _ambienceVolume = volume.clamp(0.0, 1.0);
    _applyBusVolumes();
  }

  Future<void> setMuted(bool muted) async {
    _isMuted = muted;
    _fmod.setBusMute('bus:/', _isMuted);
    _applyBusVolumes();
  }

  Future<void> updateVolumes({
    double? master,
    required double music,
    required double sfx,
    double? ambience,
    bool? muted,
  }) async {
    if (master != null) _masterVolume = master.clamp(0.0, 1.0);
    _musicVolume = music.clamp(0.0, 1.0);
    _sfxVolume = sfx.clamp(0.0, 1.0);
    if (ambience != null) _ambienceVolume = ambience.clamp(0.0, 1.0);
    if (muted != null) _isMuted = muted;
    _applyBusVolumes();
  }

  void _applyBusVolumes() {
    _fmod.setBusVolume('bus:/', _isMuted ? 0.0 : _masterVolume);
    _fmod.setBusVolume('bus:/Music', effectiveMusicVolume);
    _fmod.setBusVolume('bus:/SFX', effectiveSfxVolume);
    _fmod.setBusVolume('bus:/Ambience', effectiveAmbienceVolume);
  }

  Future<void> stopAll() async {
    stopMusic();
    stopAmbience();
    _fmod.stopAllMusic(immediate: true);
  }

  // =========================================================================
  // 10. HAPTIC FEEDBACK
  // =========================================================================

  void triggerHaptic({bool heavy = false, bool rumble = false}) {
    if (!hapticsEnabled) return;
    try {
      if (rumble) {
        HapticFeedback.vibrate();
      } else if (heavy) {
        HapticFeedback.heavyImpact();
      } else {
        HapticFeedback.lightImpact();
      }
    } catch (_) {}
  }

  // =========================================================================
  // 11. DISPOSE
  // =========================================================================

  void dispose() {
    WidgetsBinding.instance.removeObserver(this);
    _fmod.dispose();
  }
}
