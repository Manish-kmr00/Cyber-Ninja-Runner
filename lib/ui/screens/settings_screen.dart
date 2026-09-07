import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/storage/save_service.dart';

class SettingsScreen extends StatelessWidget {
  const SettingsScreen({super.key});

  void _showLanguageDialog(BuildContext context, SaveService saveService) {
    AudioService().playClick();
    showDialog(
      context: context,
      builder: (dialogCtx) {
        return Dialog(
          backgroundColor: const Color(0xFF0F1522),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(24),
            side: BorderSide(
              color: AppConstants.stealthBlue.withValues(alpha: 0.5),
              width: 1.5,
            ),
          ),
          child: Container(
            width: 560,
            constraints: const BoxConstraints(maxHeight: 320),
            padding: const EdgeInsets.all(18),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Row(
                      children: [
                        const Icon(
                          Icons.language_rounded,
                          color: AppConstants.stealthBlue,
                          size: 20,
                        ),
                        const SizedBox(width: 8),
                        Text(
                          context.l10n.tr('language'),
                          style: const TextStyle(
                            color: Colors.white,
                            fontSize: 16,
                            fontWeight: FontWeight.w900,
                            letterSpacing: 1.2,
                          ),
                        ),
                      ],
                    ),
                    IconButton(
                      icon: const Icon(
                        Icons.close_rounded,
                        color: Colors.white54,
                        size: 20,
                      ),
                      onPressed: () => Navigator.of(dialogCtx).pop(),
                    ),
                  ],
                ),
                const SizedBox(height: 10),
                Flexible(
                  child: GridView.builder(
                    shrinkWrap: true,
                    physics: const BouncingScrollPhysics(),
                    gridDelegate:
                        const SliverGridDelegateWithFixedCrossAxisCount(
                          crossAxisCount: 2,
                          childAspectRatio: 3.6,
                          crossAxisSpacing: 10,
                          mainAxisSpacing: 10,
                        ),
                    itemCount: AppLocalizations.supportedLanguages.length,
                    itemBuilder: (ctx, index) {
                      final lang = AppLocalizations.supportedLanguages[index];
                      final isSelected =
                          lang.code == saveService.settings.languageCode;
                      return GestureDetector(
                        behavior: HitTestBehavior.opaque,
                        onTap: () {
                          AudioService().playClick();
                          saveService.settings.languageCode = lang.code;
                          saveService.saveAll();
                          Navigator.of(dialogCtx).pop();
                        },
                        child: Container(
                          padding: const EdgeInsets.symmetric(
                            horizontal: 12,
                            vertical: 6,
                          ),
                          decoration: BoxDecoration(
                            color: isSelected
                                ? AppConstants.stealthBlue.withValues(
                                    alpha: 0.2,
                                  )
                                : const Color(0xFF161E2E),
                            borderRadius: BorderRadius.circular(12),
                            border: Border.all(
                              color: isSelected
                                  ? AppConstants.stealthBlue
                                  : Colors.white12,
                              width: isSelected ? 1.5 : 1,
                            ),
                          ),
                          child: Row(
                            children: [
                              Text(
                                lang.flag,
                                style: const TextStyle(fontSize: 18),
                              ),
                              const SizedBox(width: 10),
                              Expanded(
                                child: Column(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                      lang.nativeName,
                                      style: TextStyle(
                                        color: isSelected
                                            ? AppConstants.stealthBlue
                                            : Colors.white,
                                        fontWeight: FontWeight.w900,
                                        fontSize: 12,
                                      ),
                                    ),
                                    Text(
                                      lang.englishName,
                                      style: TextStyle(
                                        color: isSelected
                                            ? AppConstants.stealthBlue
                                                  .withValues(alpha: 0.7)
                                            : Colors.white54,
                                        fontSize: 9.5,
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                              if (isSelected)
                                const Icon(
                                  Icons.check_circle_rounded,
                                  color: AppConstants.stealthBlue,
                                  size: 16,
                                ),
                            ],
                          ),
                        ),
                      );
                    },
                  ),
                ),
              ],
            ),
          ),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final l10n = context.l10n;

    final currentLang = AppLocalizations.supportedLanguages.firstWhere(
      (l) => l.code == saveService.settings.languageCode,
      orElse: () => AppLocalizations.supportedLanguages.first,
    );

    return Scaffold(
      backgroundColor: AppConstants.backgroundDark,
      appBar: AppBar(
        backgroundColor: AppConstants.backgroundDark,
        elevation: 0,
        title: Text(
          l10n.tr('settings'),
          style: const TextStyle(
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
          Text(
            l10n.tr('audio_settings'),
            style: const TextStyle(
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
                    Text(
                      l10n.tr('music_volume'),
                      style: const TextStyle(
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
                    Text(
                      l10n.tr('sfx_volume'),
                      style: const TextStyle(
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
          Text(
            l10n.tr('control_preferences'),
            style: const TextStyle(
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
                    Text(
                      l10n.tr('control_scheme'),
                      style: const TextStyle(
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
                      items: [
                        DropdownMenuItem(
                          value: ControlScheme.buttons,
                          child: Text(l10n.tr('virtual_buttons')),
                        ),
                        DropdownMenuItem(
                          value: ControlScheme.swipe,
                          child: Text(l10n.tr('swipe_gestures')),
                        ),
                      ],
                      onChanged: (v) {
                        if (v != null) {
                          AudioService().playClick();
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
                    Text(
                      l10n.tr('swipe_sensitivity'),
                      style: const TextStyle(
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
          Text(
            l10n.tr('language'),
            style: const TextStyle(
              color: Colors.white70,
              fontWeight: FontWeight.bold,
              fontSize: 13,
              letterSpacing: 1.2,
            ),
          ),
          const SizedBox(height: 12),
          Material(
            color: AppConstants.surfaceDark,
            borderRadius: BorderRadius.circular(16),
            child: InkWell(
              borderRadius: BorderRadius.circular(16),
              onTap: () => _showLanguageDialog(context, saveService),
              child: Padding(
                padding: const EdgeInsets.all(16),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      l10n.tr('app_language'),
                      style: const TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 14,
                      ),
                    ),
                    Container(
                      padding: const EdgeInsets.symmetric(
                        horizontal: 12,
                        vertical: 7,
                      ),
                      decoration: BoxDecoration(
                        color: const Color(0xFF131926),
                        borderRadius: BorderRadius.circular(10),
                        border: Border.all(
                          color: AppConstants.stealthBlue.withValues(
                            alpha: 0.4,
                          ),
                        ),
                      ),
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Text(
                            currentLang.flag,
                            style: const TextStyle(fontSize: 16),
                          ),
                          const SizedBox(width: 8),
                          Text(
                            '${currentLang.nativeName} (${currentLang.englishName})',
                            style: const TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.w900,
                              fontSize: 12,
                            ),
                          ),
                          const SizedBox(width: 8),
                          const Icon(
                            Icons.keyboard_arrow_down_rounded,
                            color: AppConstants.stealthBlue,
                            size: 18,
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),

          const SizedBox(height: 24),

          // Section: Reset Data & Progress
          Text(
            l10n.tr('reset_data'),
            style: const TextStyle(
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
                Text(
                  l10n.tr('reset_warning'),
                  style: const TextStyle(
                    color: Colors.white60,
                    fontSize: 12,
                    height: 1.4,
                  ),
                ),
                const SizedBox(height: 14),
                ElevatedButton.icon(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: AppConstants.hazardRed.withValues(
                      alpha: 0.2,
                    ),
                    foregroundColor: AppConstants.hazardRed,
                    side: BorderSide(
                      color: AppConstants.hazardRed.withValues(alpha: 0.6),
                    ),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  icon: const Icon(Icons.delete_forever_rounded, size: 18),
                  label: Text(
                    l10n.tr('reset_button'),
                    style: const TextStyle(
                      fontWeight: FontWeight.w900,
                      letterSpacing: 0.8,
                    ),
                  ),
                  onPressed: () {
                    AudioService().playClick();
                    showDialog(
                      context: context,
                      builder: (dialogCtx) => AlertDialog(
                        backgroundColor: const Color(0xFF131722),
                        title: Text(
                          l10n.tr('reset_data'),
                          style: const TextStyle(color: Colors.white),
                        ),
                        content: Text(
                          l10n.tr('reset_warning'),
                          style: const TextStyle(color: Colors.white70),
                        ),
                        actions: [
                          TextButton(
                            onPressed: () => Navigator.of(dialogCtx).pop(),
                            child: const Text('CANCEL'),
                          ),
                          ElevatedButton(
                            style: ElevatedButton.styleFrom(
                              backgroundColor: AppConstants.hazardRed,
                            ),
                            onPressed: () {
                              saveService.player.cubePoints.value = 0;
                              saveService.stats.bestDistanceRun = 0;
                              saveService.stats.bestDistance10x = 0;
                              saveService.stats.bestDistanceSqubeBird = 0;
                              saveService.saveAll();
                              Navigator.of(dialogCtx).pop();
                              ScaffoldMessenger.of(context).showSnackBar(
                                const SnackBar(
                                  content: Text('Data has been reset.'),
                                ),
                              );
                            },
                            child: const Text('CONFIRM'),
                          ),
                        ],
                      ),
                    );
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
