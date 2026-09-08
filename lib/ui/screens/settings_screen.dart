import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';
import 'package:url_launcher/url_launcher.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/storage/save_service.dart';

class SettingsScreen extends StatefulWidget {
  const SettingsScreen({super.key});

  @override
  State<SettingsScreen> createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen>
    with SingleTickerProviderStateMixin {
  late final AnimationController _ledPulseController;

  static const String _moonEdgeUrl =
      'https://play.google.com/store/apps/developer?id=Moon+Edge+Studio';
  static const String _imgResizerUrl =
      'https://play.google.com/store/apps/details?id=com.moonedgestudio.imageresizer';

  @override
  void initState() {
    super.initState();
    _ledPulseController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1200),
    )..repeat(reverse: true);
  }

  @override
  void dispose() {
    _ledPulseController.dispose();
    super.dispose();
  }

  Future<void> _openUrl(String urlString) async {
    AudioService().playClick();
    final Uri url = Uri.parse(urlString);
    try {
      final launched = await launchUrl(
        url,
        mode: LaunchMode.externalApplication,
      );
      if (!launched) {
        await launchUrl(url);
      }
    } catch (e) {
      debugPrint('Error launching $urlString: $e');
    }
  }

  void _showLanguageDialog(BuildContext context, SaveService saveService) {
    AudioService().playClick();
    showDialog(
      context: context,
      builder: (dialogCtx) {
        return Dialog(
          backgroundColor: const Color(0xFF0D121B),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(20),
            side: BorderSide(
              color: const Color(0xFF00E5FF).withValues(alpha: 0.6),
              width: 1.5,
            ),
          ),
          child: Container(
            width: 580,
            constraints: const BoxConstraints(maxHeight: 360),
            padding: const EdgeInsets.all(20),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Row(
                      children: [
                        Container(
                          padding: const EdgeInsets.all(6),
                          decoration: BoxDecoration(
                            shape: BoxShape.circle,
                            color: const Color(
                              0xFF00E5FF,
                            ).withValues(alpha: 0.15),
                          ),
                          child: const Icon(
                            Icons.language_rounded,
                            color: Color(0xFF00E5FF),
                            size: 18,
                          ),
                        ),
                        const SizedBox(width: 10),
                        const Text(
                          'GLOBAL LOCALIZATION MATRIX',
                          style: TextStyle(
                            color: Colors.white,
                            fontSize: 14,
                            fontWeight: FontWeight.w900,
                            letterSpacing: 1.5,
                            fontFamily: 'monospace',
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
                      onPressed: () {
                        AudioService().playClick();
                        Navigator.of(dialogCtx).pop();
                      },
                    ),
                  ],
                ),
                const SizedBox(height: 12),
                Flexible(
                  child: GridView.builder(
                    shrinkWrap: true,
                    physics: const BouncingScrollPhysics(),
                    gridDelegate:
                        const SliverGridDelegateWithFixedCrossAxisCount(
                          crossAxisCount: 2,
                          childAspectRatio: 3.5,
                          crossAxisSpacing: 12,
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
                        child: AnimatedContainer(
                          duration: const Duration(milliseconds: 200),
                          padding: const EdgeInsets.symmetric(
                            horizontal: 14,
                            vertical: 8,
                          ),
                          decoration: BoxDecoration(
                            color: isSelected
                                ? const Color(
                                    0xFF00E5FF,
                                  ).withValues(alpha: 0.18)
                                : const Color(0xFF131926),
                            borderRadius: BorderRadius.circular(12),
                            border: Border.all(
                              color: isSelected
                                  ? const Color(0xFF00E5FF)
                                  : Colors.white12,
                              width: isSelected ? 1.8 : 1.0,
                            ),
                            boxShadow: isSelected
                                ? [
                                    BoxShadow(
                                      color: const Color(
                                        0xFF00E5FF,
                                      ).withValues(alpha: 0.25),
                                      blurRadius: 10,
                                    ),
                                  ]
                                : null,
                          ),
                          child: Row(
                            children: [
                              Text(
                                lang.flag,
                                style: const TextStyle(fontSize: 20),
                              ),
                              const SizedBox(width: 12),
                              Expanded(
                                child: Column(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                      lang.nativeName,
                                      style: TextStyle(
                                        color: isSelected
                                            ? const Color(0xFF00E5FF)
                                            : Colors.white,
                                        fontWeight: FontWeight.w900,
                                        fontSize: 12.5,
                                      ),
                                      maxLines: 1,
                                      overflow: TextOverflow.ellipsis,
                                    ),
                                    Text(
                                      lang.englishName,
                                      style: TextStyle(
                                        color: isSelected
                                            ? const Color(
                                                0xFF00E5FF,
                                              ).withValues(alpha: 0.75)
                                            : Colors.white54,
                                        fontSize: 10,
                                        fontFamily: 'monospace',
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                              if (isSelected)
                                const Icon(
                                  Icons.check_circle_rounded,
                                  color: Color(0xFF00E5FF),
                                  size: 18,
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

  void _showResetStatsDialog(BuildContext context, SaveService saveService) {
    AudioService().playClick();
    showDialog(
      context: context,
      builder: (dialogCtx) => AlertDialog(
        backgroundColor: const Color(0xFF131926),
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(18),
          side: BorderSide(
            color: AppConstants.hazardRed.withValues(alpha: 0.6),
            width: 1.5,
          ),
        ),
        title: Row(
          children: [
            const Icon(Icons.analytics_outlined, color: AppConstants.hazardRed),
            const SizedBox(width: 10),
            const Text(
              'RESET MISSION TELEMETRY',
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.w900,
                fontSize: 15,
                letterSpacing: 1.2,
                fontFamily: 'monospace',
              ),
            ),
          ],
        ),
        content: const Text(
          'This will reset your Sector High Scores and Run Records to 0 M. Your Cyber Points and unlocked Chassis skins will NOT be lost.',
          style: TextStyle(color: Colors.white70, fontSize: 12.5, height: 1.4),
        ),
        actions: [
          TextButton(
            onPressed: () {
              AudioService().playClick();
              Navigator.of(dialogCtx).pop();
            },
            child: const Text(
              'CANCEL',
              style: TextStyle(color: Colors.white60),
            ),
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: AppConstants.hazardRed,
              foregroundColor: Colors.white,
            ),
            onPressed: () {
              AudioService().playClick();
              saveService.resetStatsOnly();
              Navigator.of(dialogCtx).pop();
              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(
                  backgroundColor: Color(0xFF141926),
                  content: Text(
                    '// MISSION TELEMETRY RESET COMPLETED',
                    style: TextStyle(
                      color: Color(0xFF00E5FF),
                      fontFamily: 'monospace',
                    ),
                  ),
                ),
              );
            },
            child: const Text(
              'RESET RECORDS',
              style: TextStyle(fontWeight: FontWeight.w900),
            ),
          ),
        ],
      ),
    );
  }

  void _showFactoryResetDialog(BuildContext context, SaveService saveService) {
    AudioService().playClick();
    showDialog(
      context: context,
      builder: (dialogCtx) => AlertDialog(
        backgroundColor: const Color(0xFF140D14),
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(18),
          side: BorderSide(
            color: AppConstants.hazardRed.withValues(alpha: 0.8),
            width: 1.8,
          ),
        ),
        title: Row(
          children: [
            const Icon(
              Icons.warning_amber_rounded,
              color: AppConstants.hazardRed,
              size: 24,
            ),
            const SizedBox(width: 10),
            const Text(
              'FACTORY DATA WIPE',
              style: TextStyle(
                color: AppConstants.hazardRed,
                fontWeight: FontWeight.w900,
                fontSize: 15,
                letterSpacing: 1.2,
                fontFamily: 'monospace',
              ),
            ),
          ],
        ),
        content: const Text(
          'WARNING: This will permanently wipe all Cyber Points, unlocked skins, game modes, and all records back to fresh install defaults. This action CANNOT be undone.',
          style: TextStyle(color: Colors.white70, fontSize: 12.5, height: 1.4),
        ),
        actions: [
          TextButton(
            onPressed: () {
              AudioService().playClick();
              Navigator.of(dialogCtx).pop();
            },
            child: const Text('ABORT', style: TextStyle(color: Colors.white60)),
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: AppConstants.hazardRed,
              foregroundColor: Colors.white,
            ),
            onPressed: () {
              AudioService().playClick();
              saveService.resetAllProgress();
              Navigator.of(dialogCtx).pop();
              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(
                  backgroundColor: Color(0xFF141926),
                  content: Text(
                    '// FULL FACTORY DATA RESET COMPLETED',
                    style: TextStyle(
                      color: AppConstants.hazardRed,
                      fontFamily: 'monospace',
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              );
            },
            child: const Text(
              'CONFIRM WIPE',
              style: TextStyle(fontWeight: FontWeight.w900),
            ),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();

    final currentLang = AppLocalizations.supportedLanguages.firstWhere(
      (l) => l.code == saveService.settings.languageCode,
      orElse: () => AppLocalizations.supportedLanguages.first,
    );

    return Scaffold(
      backgroundColor: const Color(0xFF070A11),
      body: SafeArea(
        child: Column(
          children: [
            // 1. Top Cyberpunk Command Header
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
              decoration: BoxDecoration(
                color: const Color(0xFF0A0F19).withValues(alpha: 0.95),
                border: Border(
                  bottom: BorderSide(
                    color: const Color(0xFF00E5FF).withValues(alpha: 0.25),
                    width: 1.2,
                  ),
                ),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  // Back button + Title
                  Row(
                    children: [
                      Material(
                        color: Colors.transparent,
                        child: InkWell(
                          borderRadius: BorderRadius.circular(10),
                          onTap: () {
                            AudioService().playClick();
                            Navigator.of(context).pop();
                          },
                          child: Container(
                            width: 40,
                            height: 40,
                            decoration: BoxDecoration(
                              color: const Color(0xFF0F1522),
                              borderRadius: BorderRadius.circular(10),
                              border: Border.all(
                                color: const Color(
                                  0xFF00E5FF,
                                ).withValues(alpha: 0.6),
                                width: 1.4,
                              ),
                              boxShadow: [
                                BoxShadow(
                                  color: const Color(
                                    0xFF00E5FF,
                                  ).withValues(alpha: 0.25),
                                  blurRadius: 10,
                                ),
                              ],
                            ),
                            alignment: Alignment.center,
                            child: const Icon(
                              Icons.arrow_back_ios_new_rounded,
                              color: Color(0xFF00E5FF),
                              size: 18,
                            ),
                          ),
                        ),
                      ),
                      const SizedBox(width: 16),
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            children: [
                              Container(
                                width: 4,
                                height: 16,
                                decoration: BoxDecoration(
                                  color: const Color(0xFF00E5FF),
                                  borderRadius: BorderRadius.circular(2),
                                  boxShadow: [
                                    BoxShadow(
                                      color: const Color(
                                        0xFF00E5FF,
                                      ).withValues(alpha: 0.6),
                                      blurRadius: 6,
                                    ),
                                  ],
                                ),
                              ),
                              const SizedBox(width: 8),
                              const Text(
                                'SYSTEM CONFIGURATION',
                                style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 17,
                                  fontWeight: FontWeight.w900,
                                  letterSpacing: 2.0,
                                  fontFamily: 'monospace',
                                ),
                              ),
                            ],
                          ),
                          const SizedBox(height: 2),
                          Text(
                            '// CYBER MATRIX KERNEL V2.5 // CORE PREFERENCES & PROTOCOLS',
                            style: TextStyle(
                              color: Colors.white.withValues(alpha: 0.50),
                              fontSize: 9.5,
                              fontFamily: 'monospace',
                              letterSpacing: 1.0,
                            ),
                          ),
                        ],
                      ),
                    ],
                  ),

                  // Right: LED Status & CP Vault Pill
                  Row(
                    children: [
                      // Pulsing Online LED Badge
                      AnimatedBuilder(
                        animation: _ledPulseController,
                        builder: (context, child) {
                          return Container(
                            padding: const EdgeInsets.symmetric(
                              horizontal: 10,
                              vertical: 5,
                            ),
                            decoration: BoxDecoration(
                              color: const Color(0xFF00E676).withValues(
                                alpha: 0.12 + 0.08 * _ledPulseController.value,
                              ),
                              borderRadius: BorderRadius.circular(8),
                              border: Border.all(
                                color: const Color(0xFF00E676).withValues(
                                  alpha: 0.4 + 0.3 * _ledPulseController.value,
                                ),
                                width: 1.0,
                              ),
                            ),
                            child: Row(
                              children: [
                                Container(
                                  width: 7,
                                  height: 7,
                                  decoration: BoxDecoration(
                                    shape: BoxShape.circle,
                                    color: const Color(0xFF00E676),
                                    boxShadow: [
                                      BoxShadow(
                                        color: const Color(0xFF00E676)
                                            .withValues(
                                              alpha:
                                                  0.6 *
                                                  _ledPulseController.value,
                                            ),
                                        blurRadius: 8,
                                        spreadRadius: 1,
                                      ),
                                    ],
                                  ),
                                ),
                                const SizedBox(width: 6),
                                const Text(
                                  'SYS: OPTIMAL',
                                  style: TextStyle(
                                    color: Color(0xFF00E676),
                                    fontSize: 10,
                                    fontWeight: FontWeight.w900,
                                    fontFamily: 'monospace',
                                    letterSpacing: 1.2,
                                  ),
                                ),
                              ],
                            ),
                          );
                        },
                      ),
                      const SizedBox(width: 12),

                      // CP Vault Balance
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 12,
                          vertical: 6,
                        ),
                        decoration: BoxDecoration(
                          color: const Color(0xFF121724),
                          borderRadius: BorderRadius.circular(8),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(alpha: 0.6),
                            width: 1.2,
                          ),
                          boxShadow: [
                            BoxShadow(
                              color: AppConstants.coinGold.withValues(
                                alpha: 0.15,
                              ),
                              blurRadius: 10,
                            ),
                          ],
                        ),
                        child: Row(
                          children: [
                            const Icon(
                              Icons.diamond_rounded,
                              color: AppConstants.coinGold,
                              size: 15,
                            ),
                            const SizedBox(width: 6),
                            Text(
                              '${saveService.player.cyberPoints.value} CP',
                              style: const TextStyle(
                                color: Colors.white,
                                fontWeight: FontWeight.w900,
                                fontSize: 13,
                                fontFamily: 'monospace',
                                letterSpacing: 1.0,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),

            // 2. Landscape Dual-Column Scrollable Body
            Expanded(
              child: SingleChildScrollView(
                physics: const BouncingScrollPhysics(),
                padding: const EdgeInsets.only(
                  left: 20,
                  right: 20,
                  top: 14,
                  bottom: 30,
                ),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    // ===== LEFT COLUMN: AUDIO & CONTROLS MATRIX =====
                    Expanded(
                      child: Column(
                        children: [
                          // Card 1: Audio & Haptics Matrix
                          _buildCyberCard(
                            title: 'AUDIO & SENSORY MATRIX',
                            subtitle: '// ACOUSTIC ENGINE & HAPTIC FEEDBACK',
                            accentColor: const Color(0xFF00E5FF),
                            icon: Icons.headphones_rounded,
                            child: Column(
                              children: [
                                // Master Mute Toggle
                                _buildCyberSwitchTile(
                                  title: 'Master Audio Output',
                                  subtitle: saveService.settings.isMuted
                                      ? 'ALL AUDIO SILENCED'
                                      : 'AUDIO OUTPUT ACTIVE',
                                  icon: saveService.settings.isMuted
                                      ? Icons.volume_off_rounded
                                      : Icons.volume_up_rounded,
                                  accentColor: const Color(0xFF00E5FF),
                                  value: !saveService.settings.isMuted,
                                  onChanged: (active) {
                                    saveService.settings.isMuted = !active;
                                    AudioService().updateVolumes(
                                      music: saveService.settings.musicVolume,
                                      sfx: saveService.settings.sfxVolume,
                                      muted: !active,
                                    );
                                    saveService.saveAll();
                                    AudioService().playClick();
                                  },
                                ),
                                const Divider(
                                  color: Colors.white10,
                                  height: 16,
                                ),

                                // BGM Volume Slider
                                _buildCyberSliderTile(
                                  title: 'BGM / Cyber Synthwave Volume',
                                  percent:
                                      (saveService.settings.musicVolume * 100)
                                          .toInt(),
                                  icon: Icons.music_note_rounded,
                                  accentColor: const Color(0xFF00E5FF),
                                  value: saveService.settings.musicVolume,
                                  enabled: !saveService.settings.isMuted,
                                  onChanged: (val) {
                                    saveService.settings.musicVolume = val;
                                    AudioService().updateVolumes(
                                      music: val,
                                      sfx: saveService.settings.sfxVolume,
                                    );
                                    saveService.saveAll();
                                  },
                                ),
                                const SizedBox(height: 8),

                                // SFX Volume Slider
                                _buildCyberSliderTile(
                                  title: 'SFX & Weapon Blade Volume',
                                  percent:
                                      (saveService.settings.sfxVolume * 100)
                                          .toInt(),
                                  icon: Icons.graphic_eq_rounded,
                                  accentColor: const Color(0xFF00E5FF),
                                  value: saveService.settings.sfxVolume,
                                  enabled: !saveService.settings.isMuted,
                                  onChanged: (val) {
                                    saveService.settings.sfxVolume = val;
                                    AudioService().updateVolumes(
                                      music: saveService.settings.musicVolume,
                                      sfx: val,
                                    );
                                    saveService.saveAll();
                                  },
                                  onChangeEnd: (_) {
                                    AudioService().playClick();
                                  },
                                ),
                                const Divider(
                                  color: Colors.white10,
                                  height: 16,
                                ),

                                // Haptics Toggle
                                _buildCyberSwitchTile(
                                  title: 'Cyber Haptic Vibration',
                                  subtitle:
                                      'Tactile pulses on Jump, Katana Slash & Impact',
                                  icon: Icons.vibration_rounded,
                                  accentColor: const Color(0xFF00E5FF),
                                  value: saveService.settings.hapticsEnabled,
                                  onChanged: (active) {
                                    saveService.settings.hapticsEnabled =
                                        active;
                                    AudioService().hapticsEnabled = active;
                                    saveService.saveAll();
                                    if (active) {
                                      HapticFeedback.heavyImpact();
                                    }
                                  },
                                ),
                              ],
                            ),
                          ),
                          const SizedBox(height: 14),

                          // Card 2: Controls & HUD Customization
                          _buildCyberCard(
                            title: 'CONTROLS & HUD DOCK',
                            subtitle:
                                saveService.settings.controlScheme ==
                                    ControlScheme.swipe
                                ? '// GESTURE SWIPE & SENSITIVITY CONFIG'
                                : '// ACTION PEDALS GLOW & OPACITY DOCK',
                            accentColor: const Color(0xFFFFB300),
                            icon: Icons.sports_esports_rounded,
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                // Dual Mode Selector: SWIPE vs BUTTONS (Ref: Sqube Darkness style)
                                Row(
                                  children: [
                                    _buildControlModeCard(
                                      title: 'SWIPE',
                                      subtitle: 'Left: Jump • Right: Slash',
                                      accentColor: const Color(0xFF00E5FF),
                                      isSelected:
                                          saveService.settings.controlScheme ==
                                          ControlScheme.swipe,
                                      onTap: () {
                                        AudioService().playClick();
                                        saveService.settings.controlScheme =
                                            ControlScheme.swipe;
                                        saveService.saveAll();
                                      },
                                      previewWidget: Row(
                                        children: [
                                          Expanded(
                                            child: Column(
                                              mainAxisAlignment:
                                                  MainAxisAlignment.center,
                                              children: [
                                                const Icon(
                                                  Icons.arrow_upward_rounded,
                                                  size: 18,
                                                  color: Color(0xFF00E5FF),
                                                ),
                                                const SizedBox(height: 2),
                                                Text(
                                                  'LEFT: JUMP',
                                                  style: TextStyle(
                                                    color: const Color(
                                                      0xFF00E5FF,
                                                    ).withValues(alpha: 0.9),
                                                    fontSize: 8.0,
                                                    fontWeight: FontWeight.w800,
                                                    fontFamily: 'monospace',
                                                  ),
                                                ),
                                              ],
                                            ),
                                          ),
                                          Container(
                                            width: 1,
                                            height: 28,
                                            color: Colors.white12,
                                          ),
                                          Expanded(
                                            child: Column(
                                              mainAxisAlignment:
                                                  MainAxisAlignment.center,
                                              children: [
                                                const Icon(
                                                  Icons.flash_on_rounded,
                                                  size: 18,
                                                  color: Color(0xFFFF007F),
                                                ),
                                                const SizedBox(height: 2),
                                                Text(
                                                  'RIGHT: SLASH',
                                                  style: TextStyle(
                                                    color: const Color(
                                                      0xFFFF007F,
                                                    ).withValues(alpha: 0.9),
                                                    fontSize: 8.0,
                                                    fontWeight: FontWeight.w800,
                                                    fontFamily: 'monospace',
                                                  ),
                                                ),
                                              ],
                                            ),
                                          ),
                                        ],
                                      ),
                                    ),
                                    const SizedBox(width: 10),
                                    _buildControlModeCard(
                                      title: 'BUTTONS',
                                      subtitle: 'Pedals: Jump • Slash',
                                      accentColor: const Color(0xFFFFB300),
                                      isSelected:
                                          saveService.settings.controlScheme ==
                                          ControlScheme.buttons,
                                      onTap: () {
                                        AudioService().playClick();
                                        saveService.settings.controlScheme =
                                            ControlScheme.buttons;
                                        saveService.saveAll();
                                      },
                                      previewWidget: Row(
                                        children: [
                                          Expanded(
                                            child: Column(
                                              mainAxisAlignment:
                                                  MainAxisAlignment.center,
                                              children: [
                                                Container(
                                                  width: 24,
                                                  height: 24,
                                                  decoration: BoxDecoration(
                                                    shape: BoxShape.circle,
                                                    color: const Color(
                                                      0xFF00E5FF,
                                                    ).withValues(alpha: 0.18),
                                                    border: Border.all(
                                                      color: const Color(
                                                        0xFF00E5FF,
                                                      ).withValues(alpha: 0.6),
                                                      width: 1.0,
                                                    ),
                                                  ),
                                                  child: const Icon(
                                                    Icons.arrow_upward_rounded,
                                                    size: 14,
                                                    color: Color(0xFF00E5FF),
                                                  ),
                                                ),
                                                const SizedBox(height: 2),
                                                Text(
                                                  'JUMP',
                                                  style: TextStyle(
                                                    color: const Color(
                                                      0xFF00E5FF,
                                                    ).withValues(alpha: 0.9),
                                                    fontSize: 8.5,
                                                    fontWeight: FontWeight.w800,
                                                    fontFamily: 'monospace',
                                                  ),
                                                ),
                                              ],
                                            ),
                                          ),
                                          Container(
                                            width: 1,
                                            height: 28,
                                            color: Colors.white12,
                                          ),
                                          Expanded(
                                            child: Column(
                                              mainAxisAlignment:
                                                  MainAxisAlignment.center,
                                              children: [
                                                Container(
                                                  width: 24,
                                                  height: 24,
                                                  decoration: BoxDecoration(
                                                    shape: BoxShape.circle,
                                                    color: const Color(
                                                      0xFFFF007F,
                                                    ).withValues(alpha: 0.18),
                                                    border: Border.all(
                                                      color: const Color(
                                                        0xFFFF007F,
                                                      ).withValues(alpha: 0.6),
                                                      width: 1.0,
                                                    ),
                                                  ),
                                                  child: const Icon(
                                                    Icons.flash_on_rounded,
                                                    size: 14,
                                                    color: Color(0xFFFF007F),
                                                  ),
                                                ),
                                                const SizedBox(height: 2),
                                                Text(
                                                  'SLASH',
                                                  style: TextStyle(
                                                    color: const Color(
                                                      0xFFFF007F,
                                                    ).withValues(alpha: 0.9),
                                                    fontSize: 8.5,
                                                    fontWeight: FontWeight.w800,
                                                    fontFamily: 'monospace',
                                                  ),
                                                ),
                                              ],
                                            ),
                                          ),
                                        ],
                                      ),
                                    ),
                                  ],
                                ),
                                const Divider(
                                  color: Colors.white10,
                                  height: 18,
                                ),

                                // Contextual Controls based on Mode
                                if (saveService.settings.controlScheme ==
                                    ControlScheme.swipe) ...[
                                  // Sensitivity Slider
                                  _buildSensitivitySliderTile(
                                    saveService: saveService,
                                    accentColor: const Color(0xFF00E5FF),
                                  ),
                                ] else ...[
                                  // Button Opacity Slider
                                  _buildCyberSliderTile(
                                    title: 'HUD Pedal Opacity / Glow',
                                    percent:
                                        (saveService.settings.buttonOpacity *
                                                100)
                                            .toInt(),
                                    icon: Icons.opacity_rounded,
                                    accentColor: const Color(0xFFFFB300),
                                    value: saveService.settings.buttonOpacity,
                                    min: 0.4,
                                    max: 1.0,
                                    onChanged: (val) {
                                      saveService.settings.buttonOpacity = val;
                                      saveService.saveAll();
                                    },
                                  ),
                                ],
                              ],
                            ),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(width: 14),

                    // ===== RIGHT COLUMN: PROTOCOLS, LOCALIZATION & DATA =====
                    Expanded(
                      child: Column(
                        children: [
                          // Card 3: Game Protocols & Localization
                          _buildCyberCard(
                            title: 'PROTOCOLS & INTERFACE',
                            subtitle:
                                '// SYSTEM OVERRIDES & LOCALIZATION MATRIX',
                            accentColor: const Color(0xFFD500F9),
                            icon: Icons.developer_mode_rounded,
                            child: Column(
                              children: [
                                // God Mode / Immortal Protocol Toggle
                                _buildCyberSwitchTile(
                                  title: 'Immortal Protocol (Test Mode)',
                                  subtitle: saveService.settings.godModeEnabled
                                      ? 'ENABLED: Ninja deflects all hazard lethal damage'
                                      : 'OFF: Real survival mode (death triggers Game Over)',
                                  icon: Icons.shield_rounded,
                                  accentColor: const Color(0xFFD500F9),
                                  value: saveService.settings.godModeEnabled,
                                  onChanged: (active) {
                                    AudioService().playClick();
                                    saveService.settings.godModeEnabled =
                                        active;
                                    saveService.saveAll();
                                  },
                                ),
                                const Divider(
                                  color: Colors.white10,
                                  height: 16,
                                ),

                                // Screen Glow / Visual FX Toggle
                                _buildCyberSwitchTile(
                                  title: 'Ultra Neon Bloom & FX',
                                  subtitle:
                                      saveService.settings.highQualityEffects
                                      ? 'ENABLED: Full particle trails & neon bloom'
                                      : 'BATTERY SAVER: Minimal shader footprint',
                                  icon: Icons.auto_awesome_rounded,
                                  accentColor: const Color(0xFFD500F9),
                                  value:
                                      saveService.settings.highQualityEffects,
                                  onChanged: (active) {
                                    AudioService().playClick();
                                    saveService.settings.highQualityEffects =
                                        active;
                                    saveService.saveAll();
                                  },
                                ),
                                const Divider(
                                  color: Colors.white10,
                                  height: 16,
                                ),

                                // Interface Language Selector Tile
                                Row(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceBetween,
                                  children: [
                                    Expanded(
                                      child: Row(
                                        children: [
                                          Container(
                                            padding: const EdgeInsets.all(8),
                                            decoration: BoxDecoration(
                                              shape: BoxShape.circle,
                                              color: const Color(
                                                0xFFD500F9,
                                              ).withValues(alpha: 0.15),
                                            ),
                                            child: const Icon(
                                              Icons.translate_rounded,
                                              color: Color(0xFFD500F9),
                                              size: 18,
                                            ),
                                          ),
                                          const SizedBox(width: 12),
                                          Expanded(
                                            child: Column(
                                              crossAxisAlignment:
                                                  CrossAxisAlignment.start,
                                              children: [
                                                const Text(
                                                  'Interface Language',
                                                  style: TextStyle(
                                                    color: Colors.white,
                                                    fontWeight: FontWeight.w900,
                                                    fontSize: 13,
                                                  ),
                                                ),
                                                Text(
                                                  '${currentLang.flag} ${currentLang.nativeName} (${currentLang.englishName})',
                                                  maxLines: 1,
                                                  overflow:
                                                      TextOverflow.ellipsis,
                                                  style: TextStyle(
                                                    color: const Color(
                                                      0xFFD500F9,
                                                    ).withValues(alpha: 0.8),
                                                    fontSize: 10.5,
                                                    fontFamily: 'monospace',
                                                  ),
                                                ),
                                              ],
                                            ),
                                          ),
                                        ],
                                      ),
                                    ),
                                    const SizedBox(width: 8),
                                    Material(
                                      color: Colors.transparent,
                                      child: InkWell(
                                        borderRadius: BorderRadius.circular(8),
                                        onTap: () => _showLanguageDialog(
                                          context,
                                          saveService,
                                        ),
                                        child: Container(
                                          padding: const EdgeInsets.symmetric(
                                            horizontal: 12,
                                            vertical: 7,
                                          ),
                                          decoration: BoxDecoration(
                                            color: const Color(0xFF191226),
                                            borderRadius: BorderRadius.circular(
                                              8,
                                            ),
                                            border: Border.all(
                                              color: const Color(
                                                0xFFD500F9,
                                              ).withValues(alpha: 0.6),
                                              width: 1.2,
                                            ),
                                          ),
                                          child: const Row(
                                            children: [
                                              Text(
                                                'CHANGE',
                                                style: TextStyle(
                                                  color: Color(0xFFD500F9),
                                                  fontWeight: FontWeight.w900,
                                                  fontSize: 11,
                                                  fontFamily: 'monospace',
                                                  letterSpacing: 1.0,
                                                ),
                                              ),
                                              SizedBox(width: 4),
                                              Icon(
                                                Icons.arrow_forward_ios_rounded,
                                                color: Color(0xFFD500F9),
                                                size: 11,
                                              ),
                                            ],
                                          ),
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                              ],
                            ),
                          ),
                          const SizedBox(height: 14),

                          // Card 4: Data Vault & Studio Hub
                          _buildCyberCard(
                            title: 'DATA VAULT & STUDIO ACCESS',
                            subtitle:
                                '// MISSION ARCHIVE & MOON EDGE STUDIO HUB',
                            accentColor: AppConstants.hazardRed,
                            icon: Icons.shield_moon_rounded,
                            child: Column(
                              children: [
                                // Data management buttons row
                                Row(
                                  children: [
                                    Expanded(
                                      child: _buildCyberButton(
                                        label: 'RESET TELEMETRY',
                                        icon: Icons.replay_rounded,
                                        color: const Color(0xFF00E5FF),
                                        onTap: () => _showResetStatsDialog(
                                          context,
                                          saveService,
                                        ),
                                      ),
                                    ),
                                    const SizedBox(width: 10),
                                    Expanded(
                                      child: _buildCyberButton(
                                        label: 'FACTORY RESET',
                                        icon: Icons.delete_forever_rounded,
                                        color: AppConstants.hazardRed,
                                        onTap: () => _showFactoryResetDialog(
                                          context,
                                          saveService,
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                                const Divider(
                                  color: Colors.white10,
                                  height: 16,
                                ),

                                // Developer Links Row
                                Row(
                                  children: [
                                    Expanded(
                                      child: _buildCyberLinkCard(
                                        title: 'MOON EDGE STUDIO',
                                        subtitle:
                                            'Developer Catalog on Google Play',
                                        icon: Icons.shop_rounded,
                                        accentColor: const Color(0xFF00E676),
                                        onTap: () => _openUrl(_moonEdgeUrl),
                                      ),
                                    ),
                                    const SizedBox(width: 10),
                                    Expanded(
                                      child: _buildCyberLinkCard(
                                        title: 'IMAGE RESIZER',
                                        subtitle:
                                            'Featured Utility Tool on Play Store',
                                        icon: Icons
                                            .photo_size_select_large_rounded,
                                        accentColor: const Color(0xFF00E5FF),
                                        onTap: () => _openUrl(_imgResizerUrl),
                                      ),
                                    ),
                                  ],
                                ),
                              ],
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ),

            // 3. Bottom Tech Watermark
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 6),
              color: const Color(0xFF06090F),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    'CYBER NINJA RUNNER // PROTOCOL V2.5 // CORE CLEANROOM ENGINE',
                    style: TextStyle(
                      color: Colors.white.withValues(alpha: 0.35),
                      fontSize: 9,
                      fontFamily: 'monospace',
                      letterSpacing: 1.0,
                    ),
                  ),
                  Text(
                    '© MOON EDGE STUDIO • ALL RIGHTS RESERVED',
                    style: TextStyle(
                      color: Colors.white.withValues(alpha: 0.35),
                      fontSize: 9,
                      fontFamily: 'monospace',
                      letterSpacing: 1.0,
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  // --- Sci-Fi Card Container ---
  Widget _buildCyberCard({
    required String title,
    required String subtitle,
    required Color accentColor,
    required IconData icon,
    required Widget child,
  }) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: const Color(0xFF0C101A).withValues(alpha: 0.95),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(
          color: accentColor.withValues(alpha: 0.4),
          width: 1.3,
        ),
        boxShadow: [
          BoxShadow(
            color: accentColor.withValues(alpha: 0.08),
            blurRadius: 16,
            spreadRadius: 1,
          ),
        ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Card Header
          Row(
            children: [
              Container(
                padding: const EdgeInsets.all(6),
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: accentColor.withValues(alpha: 0.15),
                  border: Border.all(
                    color: accentColor.withValues(alpha: 0.5),
                    width: 1.0,
                  ),
                ),
                child: Icon(icon, color: accentColor, size: 15),
              ),
              const SizedBox(width: 10),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    title,
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 12.5,
                      fontWeight: FontWeight.w900,
                      letterSpacing: 1.5,
                      fontFamily: 'monospace',
                    ),
                  ),
                  Text(
                    subtitle,
                    style: TextStyle(
                      color: Colors.white.withValues(alpha: 0.45),
                      fontSize: 8.5,
                      fontFamily: 'monospace',
                      letterSpacing: 0.8,
                    ),
                  ),
                ],
              ),
            ],
          ),
          const SizedBox(height: 12),
          child,
        ],
      ),
    );
  }

  // --- Sci-Fi Switch Tile ---
  Widget _buildCyberSwitchTile({
    required String title,
    required String subtitle,
    required IconData icon,
    required Color accentColor,
    required bool value,
    required ValueChanged<bool> onChanged,
  }) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Expanded(
          child: Row(
            children: [
              Container(
                padding: const EdgeInsets.all(7),
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: accentColor.withValues(alpha: value ? 0.2 : 0.06),
                ),
                child: Icon(
                  icon,
                  color: value ? accentColor : Colors.white38,
                  size: 17,
                ),
              ),
              const SizedBox(width: 12),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      title,
                      style: const TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.w900,
                        fontSize: 12.5,
                      ),
                    ),
                    Text(
                      subtitle,
                      style: TextStyle(
                        color: value
                            ? accentColor.withValues(alpha: 0.8)
                            : Colors.white38,
                        fontSize: 9.5,
                        fontFamily: 'monospace',
                      ),
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
        const SizedBox(width: 8),
        Switch(
          value: value,
          activeThumbColor: accentColor,
          activeTrackColor: accentColor.withValues(alpha: 0.35),
          inactiveThumbColor: Colors.white38,
          inactiveTrackColor: Colors.white12,
          onChanged: onChanged,
        ),
      ],
    );
  }

  // --- Sci-Fi Slider Tile ---
  Widget _buildCyberSliderTile({
    required String title,
    required int percent,
    required IconData icon,
    required Color accentColor,
    required double value,
    double min = 0.0,
    double max = 1.0,
    bool enabled = true,
    required ValueChanged<double> onChanged,
    ValueChanged<double>? onChangeEnd,
  }) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Row(
              children: [
                Icon(
                  icon,
                  size: 15,
                  color: enabled ? accentColor : Colors.white24,
                ),
                const SizedBox(width: 8),
                Text(
                  title,
                  style: TextStyle(
                    color: enabled ? Colors.white : Colors.white38,
                    fontWeight: FontWeight.w900,
                    fontSize: 12,
                  ),
                ),
              ],
            ),
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 2),
              decoration: BoxDecoration(
                color: enabled
                    ? accentColor.withValues(alpha: 0.15)
                    : Colors.white.withValues(alpha: 0.05),
                borderRadius: BorderRadius.circular(6),
                border: Border.all(
                  color: enabled
                      ? accentColor.withValues(alpha: 0.5)
                      : Colors.white12,
                  width: 1.0,
                ),
              ),
              child: Text(
                '$percent%',
                style: TextStyle(
                  color: enabled ? accentColor : Colors.white38,
                  fontWeight: FontWeight.w900,
                  fontSize: 11,
                  fontFamily: 'monospace',
                ),
              ),
            ),
          ],
        ),
        SliderTheme(
          data: SliderThemeData(
            activeTrackColor: accentColor,
            inactiveTrackColor: Colors.white12,
            thumbColor: Colors.white,
            overlayColor: accentColor.withValues(alpha: 0.2),
            trackHeight: 3.5,
            thumbShape: const RoundSliderThumbShape(enabledThumbRadius: 7),
          ),
          child: Slider(
            value: value.clamp(min, max),
            min: min,
            max: max,
            onChanged: enabled ? onChanged : null,
            onChangeEnd: onChangeEnd,
          ),
        ),
      ],
    );
  }

  // --- Sci-Fi Button ---
  Widget _buildCyberButton({
    required String label,
    required IconData icon,
    required Color color,
    required VoidCallback onTap,
  }) {
    return Material(
      color: Colors.transparent,
      child: InkWell(
        borderRadius: BorderRadius.circular(10),
        onTap: onTap,
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 9, horizontal: 10),
          decoration: BoxDecoration(
            color: color.withValues(alpha: 0.12),
            borderRadius: BorderRadius.circular(10),
            border: Border.all(color: color.withValues(alpha: 0.6), width: 1.2),
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(icon, size: 15, color: color),
              const SizedBox(width: 6),
              Text(
                label,
                style: TextStyle(
                  color: color,
                  fontWeight: FontWeight.w900,
                  fontSize: 10.5,
                  fontFamily: 'monospace',
                  letterSpacing: 0.8,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // --- Sci-Fi External Link Card ---
  Widget _buildCyberLinkCard({
    required String title,
    required String subtitle,
    required IconData icon,
    required Color accentColor,
    required VoidCallback onTap,
  }) {
    return Material(
      color: Colors.transparent,
      child: InkWell(
        borderRadius: BorderRadius.circular(10),
        onTap: onTap,
        child: Container(
          padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 8),
          decoration: BoxDecoration(
            color: const Color(0xFF101522),
            borderRadius: BorderRadius.circular(10),
            border: Border.all(
              color: accentColor.withValues(alpha: 0.45),
              width: 1.0,
            ),
          ),
          child: Row(
            children: [
              Container(
                padding: const EdgeInsets.all(5),
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: accentColor.withValues(alpha: 0.15),
                ),
                child: Icon(icon, color: accentColor, size: 14),
              ),
              const SizedBox(width: 8),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        Flexible(
                          child: Text(
                            title,
                            style: const TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.w900,
                              fontSize: 10.5,
                              letterSpacing: 0.8,
                              fontFamily: 'monospace',
                            ),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          ),
                        ),
                        const SizedBox(width: 4),
                        Icon(
                          Icons.open_in_new_rounded,
                          color: accentColor,
                          size: 10,
                        ),
                      ],
                    ),
                    Text(
                      subtitle,
                      style: TextStyle(
                        color: Colors.white.withValues(alpha: 0.45),
                        fontSize: 8.5,
                      ),
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // --- Sci-Fi Control Scheme Mode Card (SWIPE vs BUTTONS) ---
  Widget _buildControlModeCard({
    required String title,
    required String subtitle,
    required Widget previewWidget,
    required bool isSelected,
    required Color accentColor,
    required VoidCallback onTap,
  }) {
    return Expanded(
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          borderRadius: BorderRadius.circular(12),
          onTap: onTap,
          child: AnimatedContainer(
            duration: const Duration(milliseconds: 200),
            padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 12),
            decoration: BoxDecoration(
              color: isSelected
                  ? accentColor.withValues(alpha: 0.12)
                  : const Color(0xFF0C101A),
              borderRadius: BorderRadius.circular(12),
              border: Border.all(
                color: isSelected
                    ? accentColor
                    : Colors.white.withValues(alpha: 0.12),
                width: isSelected ? 1.8 : 1.0,
              ),
              boxShadow: isSelected
                  ? [
                      BoxShadow(
                        color: accentColor.withValues(alpha: 0.25),
                        blurRadius: 10,
                        spreadRadius: 1,
                      ),
                    ]
                  : null,
            ),
            child: Column(
              children: [
                // Radio indicator + Title
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(
                      isSelected
                          ? Icons.radio_button_checked_rounded
                          : Icons.radio_button_off_rounded,
                      size: 14,
                      color: isSelected ? accentColor : Colors.white38,
                    ),
                    const SizedBox(width: 6),
                    Text(
                      title,
                      style: TextStyle(
                        color: isSelected ? Colors.white : Colors.white70,
                        fontWeight: FontWeight.w900,
                        fontSize: 13,
                        letterSpacing: 1.0,
                        fontFamily: 'monospace',
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 8),
                // Visual Preview Container
                Container(
                  height: 52,
                  decoration: BoxDecoration(
                    color: const Color(0xFF080B12),
                    borderRadius: BorderRadius.circular(8),
                    border: Border.all(
                      color: isSelected
                          ? accentColor.withValues(alpha: 0.35)
                          : Colors.white10,
                    ),
                  ),
                  child: previewWidget,
                ),
                const SizedBox(height: 8),
                // Subtitle description
                Text(
                  subtitle,
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    color: isSelected
                        ? accentColor.withValues(alpha: 0.9)
                        : Colors.white38,
                    fontSize: 9.5,
                    fontWeight: isSelected ? FontWeight.w700 : FontWeight.w500,
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // --- Sensitivity Slider with Low / High Indicators ---
  Widget _buildSensitivitySliderTile({
    required SaveService saveService,
    required Color accentColor,
  }) {
    final sensitivity = saveService.settings.swipeSensitivity;
    final percentInt = (sensitivity * 100).toInt();

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Row(
              children: [
                Icon(Icons.tune_rounded, size: 14, color: accentColor),
                const SizedBox(width: 6),
                const Text(
                  'Sensitivity',
                  style: TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.w900,
                    fontSize: 12.5,
                    fontFamily: 'monospace',
                    letterSpacing: 0.5,
                  ),
                ),
              ],
            ),
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 2),
              decoration: BoxDecoration(
                color: accentColor.withValues(alpha: 0.15),
                borderRadius: BorderRadius.circular(6),
                border: Border.all(
                  color: accentColor.withValues(alpha: 0.5),
                  width: 0.8,
                ),
              ),
              child: Text(
                '$percentInt%',
                style: TextStyle(
                  color: accentColor,
                  fontWeight: FontWeight.w900,
                  fontSize: 10.5,
                  fontFamily: 'monospace',
                ),
              ),
            ),
          ],
        ),
        const SizedBox(height: 2),
        SliderTheme(
          data: SliderThemeData(
            activeTrackColor: accentColor,
            inactiveTrackColor: Colors.white12,
            thumbColor: accentColor,
            overlayColor: accentColor.withValues(alpha: 0.2),
            trackHeight: 3.5,
            thumbShape: const RoundSliderThumbShape(enabledThumbRadius: 6),
          ),
          child: Slider(
            value: sensitivity.clamp(0.5, 2.0),
            min: 0.5,
            max: 2.0,
            onChanged: (val) {
              saveService.settings.swipeSensitivity = val;
              saveService.saveAll();
            },
          ),
        ),
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                'Low',
                style: TextStyle(
                  color: Colors.white.withValues(alpha: 0.5),
                  fontSize: 10,
                  fontWeight: FontWeight.w700,
                  fontFamily: 'monospace',
                ),
              ),
              Text(
                'High',
                style: TextStyle(
                  color: Colors.white.withValues(alpha: 0.5),
                  fontSize: 10,
                  fontWeight: FontWeight.w700,
                  fontFamily: 'monospace',
                ),
              ),
            ],
          ),
        ),
      ],
    );
  }
}
