import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/foundation.dart';

class AudioService {
  static final AudioService _instance = AudioService._internal();
  factory AudioService() => _instance;
  AudioService._internal();

  final AudioPlayer _musicPlayer = AudioPlayer();
  final List<AudioPlayer> _sfxPool = List.generate(4, (_) => AudioPlayer());
  int _poolIndex = 0;

  double musicVolume = 0.8;
  double sfxVolume = 1.0;
  bool isMuted = false;

  Future<void> init() async {
    _musicPlayer.setReleaseMode(ReleaseMode.loop);
    for (final player in _sfxPool) {
      player.setReleaseMode(ReleaseMode.stop);
    }
  }

  void updateVolumes({required double music, required double sfx}) {
    musicVolume = music;
    sfxVolume = sfx;
    _musicPlayer.setVolume(isMuted ? 0 : musicVolume);
  }

  Future<void> playMusic(String path) async {
    if (isMuted) return;
    try {
      await _musicPlayer.setVolume(musicVolume);
      await _musicPlayer.play(AssetSource(path));
    } catch (e) {
      debugPrint('AudioService music error (may run in simulator/mock): $e');
    }
  }

  Future<void> stopMusic() async {
    try {
      await _musicPlayer.stop();
    } catch (e) {
      debugPrint('AudioService stopMusic error: $e');
    }
  }

  Future<void> playSfx(String sfxName) async {
    if (isMuted || sfxVolume <= 0) return;
    try {
      final player = _sfxPool[_poolIndex];
      _poolIndex = (_poolIndex + 1) % _sfxPool.length;
      await player.setVolume(sfxVolume);
      await player.play(AssetSource('audio/$sfxName.wav'));
    } catch (e) {
      // Audio playback fails gracefully if audio file is not present
      debugPrint('AudioService sfx trigger ($sfxName): $e');
    }
  }

  void playJump() => playSfx('jump');
  void playSlide() => playSfx('slide');
  void playHide() => playSfx('hide');
  void playDeath() => playSfx('death');
  void playCollect() => playSfx('collect');
  void playBooster() => playSfx('booster');
  void playClick() => playSfx('click');
}
