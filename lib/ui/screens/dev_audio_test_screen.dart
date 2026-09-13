import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';

/// Development-only FMOD Audio Testing Interface.
///
/// CAUTION: This screen is strictly for audio QA and engineering diagnostics.
/// It must not be presented to end-users in production builds.
class DevAudioTestScreen extends StatefulWidget {
  const DevAudioTestScreen({super.key});

  @override
  State<DevAudioTestScreen> createState() => _DevAudioTestScreenState();
}

class _DevAudioTestScreenState extends State<DevAudioTestScreen> {
  final AudioService _audio = AudioService();

  double _intensity = 0.3;
  double _danger = 0.0;
  int _combo = 0;
  bool _pauseSnapshotActive = false;

  late double _masterVol;
  late double _musicVol;
  late double _sfxVol;
  late double _ambienceVol;

  @override
  void initState() {
    super.initState();
    _masterVol = _audio.masterVolume;
    _musicVol = _audio.musicVolume;
    _sfxVol = _audio.sfxVolume;
    _ambienceVol = _audio.ambienceVolume;
  }

  @override
  Widget build(BuildContext context) {
    // Safety guard: prevent render in production release
    if (!kDebugMode) {
      return const Scaffold(
        body: Center(
          child: Text(
            'Development Only Feature - Unavailable in Release Build',
          ),
        ),
      );
    }

    return Scaffold(
      backgroundColor: const Color(0xFF090A10),
      appBar: AppBar(
        backgroundColor: const Color(0xFF141724),
        title: const Row(
          children: [
            Icon(Icons.terminal, color: Colors.amberAccent, size: 20),
            SizedBox(width: 8),
            Text(
              '[DEV ONLY] FMOD Audio Lab',
              style: TextStyle(
                fontFamily: 'monospace',
                fontSize: 16,
                fontWeight: FontWeight.bold,
                color: Colors.amberAccent,
              ),
            ),
          ],
        ),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.white),
          onPressed: () => Navigator.of(context).pop(),
        ),
      ),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          // Banner
          Container(
            padding: const EdgeInsets.all(12),
            decoration: BoxDecoration(
              color: Colors.amber.withValues(alpha: 0.1),
              border: Border.all(color: Colors.amber.withValues(alpha: 0.4)),
              borderRadius: BorderRadius.circular(8),
            ),
            child: const Text(
              'ENGINEERING DIAGNOSTICS: Low-latency C FFI -> FMOD Studio 2.03.14 native sound system. Real-time bus & parameter modulation.',
              style: TextStyle(
                color: Colors.amber,
                fontSize: 11,
                fontFamily: 'monospace',
              ),
            ),
          ),
          const SizedBox(height: 20),

          // 1. SOUND EFFECTS (SFX)
          _buildSectionHeader('1. ONE-SHOT SFX TRIGGERS (FMOD SFX.bank)'),
          Wrap(
            spacing: 8,
            runSpacing: 8,
            children: [
              _buildActionButton(
                'Jump',
                Colors.cyanAccent,
                () => _audio.playJump(),
              ),
              _buildActionButton(
                'Wall Jump',
                Colors.cyanAccent,
                () => _audio.playWallJump(),
              ),
              _buildActionButton(
                'Slide',
                Colors.cyanAccent,
                () => _audio.playSlide(),
              ),
              _buildActionButton(
                'Katana Slash',
                Colors.redAccent,
                () => _audio.playSlash(),
              ),
              _buildActionButton(
                'Hit Impact',
                Colors.orangeAccent,
                () => _audio.playHit(),
              ),
              _buildActionButton(
                'Crit Hit',
                Colors.red,
                () => _audio.trigger(GameAudioEvent.criticalHit),
              ),
              _buildActionButton(
                'Explosion',
                Colors.deepOrangeAccent,
                () => _audio.trigger(GameAudioEvent.explosion),
              ),
              _buildActionButton(
                'Laser Shot',
                Colors.purpleAccent,
                () => _audio.playLaser(),
              ),
              _buildActionButton(
                'Enemy Destroy',
                Colors.redAccent,
                () => _audio.playEnemyDestroy(),
              ),
              _buildActionButton(
                'Collect Coin',
                Colors.greenAccent,
                () => _audio.playCollect(),
              ),
              _buildActionButton(
                'Checkpoint',
                Colors.blueAccent,
                () => _audio.playCheckpoint(),
              ),
              _buildActionButton(
                'Speed Booster',
                Colors.yellowAccent,
                () => _audio.playBooster(),
              ),
              _buildActionButton(
                'UI Click',
                Colors.grey,
                () => _audio.playClick(),
              ),
            ],
          ),
          const SizedBox(height: 24),

          // 2. ADAPTIVE MUSIC & AMBIENCE
          _buildSectionHeader('2. ADAPTIVE MUSIC STATES (FMOD Music.bank)'),
          Wrap(
            spacing: 8,
            runSpacing: 8,
            children: [
              _buildActionButton(
                'Menu Theme',
                Colors.indigoAccent,
                () => _audio.startMenuMusic(),
              ),
              _buildActionButton(
                'Gameplay Track',
                Colors.tealAccent,
                () => _audio.startGameplayMusic(),
              ),
              _buildActionButton(
                'Danger Music',
                Colors.pinkAccent,
                () => _audio.setMusicState(MusicState.danger),
              ),
              _buildActionButton(
                'Victory Fanfare',
                Colors.amberAccent,
                () => _audio.setMusicState(MusicState.victory),
              ),
              _buildActionButton(
                'Game Over Cue',
                Colors.deepPurpleAccent,
                () => _audio.setMusicState(MusicState.gameOver),
              ),
              _buildActionButton(
                'Stop Music',
                Colors.blueGrey,
                () => _audio.stopMusic(),
              ),
            ],
          ),
          const SizedBox(height: 24),

          // 3. FMOD REAL-TIME PARAMETERS
          _buildSectionHeader('3. DYNAMIC PARAMETERS (Timeline & DSP)'),
          _buildSlider(
            label: 'Intensity (Speed/Multiplier)',
            value: _intensity,
            min: 0.0,
            max: 1.0,
            divisions: 20,
            accentColor: Colors.tealAccent,
            onChanged: (v) {
              setState(() => _intensity = v);
              _audio.setIntensity(v);
            },
          ),
          _buildSlider(
            label: 'Danger / Threat Proximity',
            value: _danger,
            min: 0.0,
            max: 1.0,
            divisions: 20,
            accentColor: Colors.pinkAccent,
            onChanged: (v) {
              setState(() => _danger = v);
              _audio.setDanger(v);
            },
          ),
          _buildSlider(
            label: 'Combo Streak: $_combo',
            value: _combo.toDouble(),
            min: 0,
            max: 5,
            divisions: 5,
            accentColor: Colors.yellowAccent,
            onChanged: (v) {
              setState(() => _combo = v.round());
              _audio.setCombo(v.round());
            },
          ),
          const SizedBox(height: 24),

          // 4. AUDIO SNAPSHOTS
          _buildSectionHeader('4. FMOD SNAPSHOTS'),
          SwitchListTile(
            title: const Text(
              'snapshot:/Pause (Low-Pass Filter)',
              style: TextStyle(color: Colors.white, fontSize: 13),
            ),
            subtitle: const Text(
              'Applies real-time 600Hz LPF on Music bus without clipping',
              style: TextStyle(color: Colors.white54, fontSize: 11),
            ),
            value: _pauseSnapshotActive,
            activeThumbColor: Colors.amberAccent,
            onChanged: (val) {
              setState(() => _pauseSnapshotActive = val);
              _audio.setPausedSnapshot(val);
            },
          ),
          const SizedBox(height: 24),

          // 5. NATIVE MIXER BUS VOLUMES
          _buildSectionHeader('5. NATIVE MIXER BUS VOLUME'),
          _buildSlider(
            label: 'bus:/ (Master)',
            value: _masterVol,
            min: 0.0,
            max: 1.0,
            divisions: 20,
            accentColor: Colors.white,
            onChanged: (v) {
              setState(() => _masterVol = v);
              _audio.setMasterVolume(v);
            },
          ),
          _buildSlider(
            label: 'bus:/Music',
            value: _musicVol,
            min: 0.0,
            max: 1.0,
            divisions: 20,
            accentColor: Colors.cyanAccent,
            onChanged: (v) {
              setState(() => _musicVol = v);
              _audio.setMusicVolume(v);
            },
          ),
          _buildSlider(
            label: 'bus:/SFX',
            value: _sfxVol,
            min: 0.0,
            max: 1.0,
            divisions: 20,
            accentColor: Colors.orangeAccent,
            onChanged: (v) {
              setState(() => _sfxVol = v);
              _audio.setSfxVolume(v);
            },
          ),
          _buildSlider(
            label: 'bus:/Ambience',
            value: _ambienceVol,
            min: 0.0,
            max: 1.0,
            divisions: 20,
            accentColor: Colors.purpleAccent,
            onChanged: (v) {
              setState(() => _ambienceVol = v);
              _audio.setAmbienceVolume(v);
            },
          ),
          const SizedBox(height: 40),
        ],
      ),
    );
  }

  Widget _buildSectionHeader(String title) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 12),
      child: Text(
        title,
        style: const TextStyle(
          color: Colors.white70,
          fontSize: 12,
          fontWeight: FontWeight.bold,
          letterSpacing: 1.1,
          fontFamily: 'monospace',
        ),
      ),
    );
  }

  Widget _buildActionButton(String label, Color color, VoidCallback onTap) {
    return ElevatedButton(
      style: ElevatedButton.styleFrom(
        backgroundColor: const Color(0xFF191D30),
        foregroundColor: color,
        side: BorderSide(color: color.withValues(alpha: 0.5)),
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(6)),
        padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
      ),
      onPressed: onTap,
      child: Text(
        label,
        style: const TextStyle(fontSize: 12, fontWeight: FontWeight.bold),
      ),
    );
  }

  Widget _buildSlider({
    required String label,
    required double value,
    required double min,
    required double max,
    required int divisions,
    required Color accentColor,
    required ValueChanged<double> onChanged,
  }) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Text(
              label,
              style: const TextStyle(
                color: Colors.white,
                fontSize: 12,
                fontFamily: 'monospace',
              ),
            ),
            Text(
              value.toStringAsFixed(2),
              style: TextStyle(
                color: accentColor,
                fontSize: 12,
                fontFamily: 'monospace',
              ),
            ),
          ],
        ),
        SliderTheme(
          data: SliderThemeData(
            activeTrackColor: accentColor,
            thumbColor: accentColor,
            inactiveTrackColor: Colors.white24,
            thumbShape: const RoundSliderThumbShape(enabledThumbRadius: 6),
            trackHeight: 2,
          ),
          child: Slider(
            value: value,
            min: min,
            max: max,
            divisions: divisions,
            onChanged: onChanged,
          ),
        ),
      ],
    );
  }
}
