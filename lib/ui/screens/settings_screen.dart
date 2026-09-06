import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/storage/save_service.dart';

class SettingsScreen extends StatelessWidget {
  const SettingsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();

    return Scaffold(
      backgroundColor: AppConstants.backgroundDark,
      appBar: AppBar(
        backgroundColor: AppConstants.backgroundDark,
        elevation: 0,
        title: const Text(
          'SETTINGS',
          style: TextStyle(
            fontWeight: FontWeight.w900,
            letterSpacing: 1.5,
            fontSize: 18,
          ),
        ),
      ),
      body: ListView(
        padding: const EdgeInsets.all(20),
        physics: const BouncingScrollPhysics(),
        children: [
          // Section: Audio Volumes
          const Text(
            'AUDIO SETTINGS',
            style: TextStyle(
              color: Colors.white70,
              fontWeight: FontWeight.bold,
              fontSize: 13,
              letterSpacing: 1.2,
            ),
          ),
          const SizedBox(height: 12),
          Container(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: AppConstants.surfaceDark,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Column(
              children: [
                Row(
                  children: [
                    const Icon(Icons.music_note, color: Colors.white70),
                    const SizedBox(width: 14),
                    const Text(
                      'Music Volume',
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    Expanded(
                      child: Slider(
                        value: saveService.settings.musicVolume,
                        activeColor: Colors.white,
                        inactiveColor: Colors.white24,
                        onChanged: (v) {
                          saveService.settings.musicVolume = v;
                          AudioService().updateVolumes(
                            music: v,
                            sfx: saveService.settings.sfxVolume,
                          );
                          saveService.saveAll();
                        },
                      ),
                    ),
                  ],
                ),
                const Divider(color: Colors.white12),
                Row(
                  children: [
                    const Icon(Icons.volume_up, color: Colors.white70),
                    const SizedBox(width: 14),
                    const Text(
                      'SFX Volume',
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    Expanded(
                      child: Slider(
                        value: saveService.settings.sfxVolume,
                        activeColor: Colors.white,
                        inactiveColor: Colors.white24,
                        onChanged: (v) {
                          saveService.settings.sfxVolume = v;
                          AudioService().updateVolumes(
                            music: saveService.settings.musicVolume,
                            sfx: v,
                          );
                          saveService.saveAll();
                        },
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),

          const SizedBox(height: 24),

          // Section: Controls & Sensitivity
          const Text(
            'CONTROL PREFERENCES',
            style: TextStyle(
              color: Colors.white70,
              fontWeight: FontWeight.bold,
              fontSize: 13,
              letterSpacing: 1.2,
            ),
          ),
          const SizedBox(height: 12),
          Container(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: AppConstants.surfaceDark,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    const Text(
                      'Control Scheme',
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    DropdownButton<ControlScheme>(
                      value: saveService.settings.controlScheme,
                      dropdownColor: AppConstants.surfaceDark,
                      style: const TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                      ),
                      underline: const SizedBox(),
                      items: const [
                        DropdownMenuItem(
                          value: ControlScheme.buttons,
                          child: Text('Virtual Buttons'),
                        ),
                        DropdownMenuItem(
                          value: ControlScheme.swipe,
                          child: Text('Swipe Gestures'),
                        ),
                      ],
                      onChanged: (v) {
                        if (v != null) {
                          saveService.settings.controlScheme = v;
                          saveService.saveAll();
                        }
                      },
                    ),
                  ],
                ),
                const Divider(color: Colors.white12),
                Row(
                  children: [
                    const Text(
                      'Swipe Sensitivity',
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    Expanded(
                      child: Slider(
                        value: saveService.settings.swipeSensitivity,
                        min: 0.5,
                        max: 2.0,
                        activeColor: AppConstants.stealthBlue,
                        inactiveColor: Colors.white24,
                        onChanged: (v) {
                          saveService.settings.swipeSensitivity = v;
                          saveService.saveAll();
                        },
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),

          const SizedBox(height: 24),

          // Section: Language Selection
          const Text(
            'LANGUAGE',
            style: TextStyle(
              color: Colors.white70,
              fontWeight: FontWeight.bold,
              fontSize: 13,
              letterSpacing: 1.2,
            ),
          ),
          const SizedBox(height: 12),
          Container(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: AppConstants.surfaceDark,
              borderRadius: BorderRadius.circular(16),
            ),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                const Text(
                  'App Language',
                  style: TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                DropdownButton<String>(
                  value: saveService.settings.languageCode,
                  dropdownColor: AppConstants.surfaceDark,
                  style: const TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                  ),
                  underline: const SizedBox(),
                  items: const [
                    DropdownMenuItem(value: 'en', child: Text('English (US)')),
                    DropdownMenuItem(value: 'es', child: Text('Español')),
                    DropdownMenuItem(
                      value: 'ar',
                      child: Text('العربية (Arabic)'),
                    ),
                  ],
                  onChanged: (v) {
                    if (v != null) {
                      saveService.settings.languageCode = v;
                      saveService.saveAll();
                    }
                  },
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
