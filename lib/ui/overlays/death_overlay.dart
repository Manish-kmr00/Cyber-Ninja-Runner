import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/storage/save_service.dart';
import '../../game/cyber_ninja_game.dart';

class DeathOverlay extends StatelessWidget {
  final CyberNinjaRunnerGame game;

  const DeathOverlay({super.key, required this.game});

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final bestDistance = saveService.stats.getBestForMode(game.mode);
    final isNewRecord =
        game.currentDistance >= bestDistance && game.currentDistance > 0;

    return Scaffold(
      backgroundColor: Colors.transparent,
      body: Stack(
        children: [
          // Solid semi-transparent dark backdrop (eliminates shader bugs)
          Positioned.fill(
            child: Container(color: Colors.black.withValues(alpha: 0.88)),
          ),
          Center(
            child: LayoutBuilder(
              builder: (context, constraints) {
                final modalWidth = (constraints.maxWidth * 0.85).clamp(
                  280.0,
                  460.0,
                );
                return SingleChildScrollView(
                  physics: const BouncingScrollPhysics(),
                  padding: const EdgeInsets.symmetric(
                    vertical: 12,
                    horizontal: 16,
                  ),
                  child: Container(
                    width: modalWidth,
                    padding: const EdgeInsets.symmetric(
                      horizontal: 20,
                      vertical: 16,
                    ),
                    decoration: BoxDecoration(
                      color: const Color(0xFF0C1017).withValues(alpha: 0.98),
                      borderRadius: BorderRadius.circular(20),
                      border: Border.all(
                        color: AppConstants.hazardRed.withValues(alpha: 0.6),
                        width: 1.5,
                      ),
                      boxShadow: [
                        BoxShadow(
                          color: AppConstants.hazardRed.withValues(alpha: 0.25),
                          blurRadius: 30,
                          spreadRadius: 1,
                        ),
                        BoxShadow(
                          color: Colors.black.withValues(alpha: 0.8),
                          blurRadius: 16,
                        ),
                      ],
                    ),
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        // Top Status Header Tag
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Container(
                              padding: const EdgeInsets.symmetric(
                                horizontal: 8,
                                vertical: 3,
                              ),
                              decoration: BoxDecoration(
                                color: AppConstants.hazardRed.withValues(
                                  alpha: 0.2,
                                ),
                                borderRadius: BorderRadius.circular(6),
                                border: Border.all(
                                  color: AppConstants.hazardRed.withValues(
                                    alpha: 0.5,
                                  ),
                                ),
                              ),
                              child: Row(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  const Icon(
                                    Icons.warning_amber_rounded,
                                    size: 13,
                                    color: AppConstants.hazardRed,
                                  ),
                                  const SizedBox(width: 5),
                                  Text(
                                    context.l10n.tr('mission_failed'),
                                    style: const TextStyle(
                                      color: AppConstants.hazardRed,
                                      fontSize: 10,
                                      fontWeight: FontWeight.w900,
                                      letterSpacing: 1.2,
                                    ),
                                  ),
                                ],
                              ),
                            ),
                            Text(
                              'SECTOR_${game.mode.name.toUpperCase()}',
                              style: TextStyle(
                                color: Colors.white.withValues(alpha: 0.4),
                                fontSize: 10,
                                fontWeight: FontWeight.bold,
                                letterSpacing: 1.0,
                              ),
                            ),
                          ],
                        ),
                        const SizedBox(height: 10),

                        // Main Failure Title
                        const Text(
                          'NEURAL LINK SEVERED',
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.w900,
                            color: Colors.white,
                            letterSpacing: 2.0,
                          ),
                        ),
                        const SizedBox(height: 2),
                        Text(
                          'CHASSIS INTEGRITY COMPROMISED',
                          style: TextStyle(
                            fontSize: 10,
                            fontWeight: FontWeight.w600,
                            color: AppConstants.hazardRed.withValues(
                              alpha: 0.85,
                            ),
                            letterSpacing: 1.2,
                          ),
                        ),
                        const SizedBox(height: 12),

                        // Telemetry Summary Card
                        Container(
                          width: double.infinity,
                          padding: const EdgeInsets.symmetric(
                            vertical: 10,
                            horizontal: 14,
                          ),
                          decoration: BoxDecoration(
                            color: const Color(0xFF141A24),
                            borderRadius: BorderRadius.circular(14),
                            border: Border.all(
                              color: Colors.white.withValues(alpha: 0.08),
                            ),
                          ),
                          child: Column(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceEvenly,
                                children: [
                                  Column(
                                    children: [
                                      Text(
                                        'DISTANCE',
                                        style: TextStyle(
                                          fontSize: 10,
                                          fontWeight: FontWeight.w700,
                                          letterSpacing: 1.2,
                                          color: Colors.white.withValues(
                                            alpha: 0.5,
                                          ),
                                        ),
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.min,
                                        crossAxisAlignment:
                                            CrossAxisAlignment.baseline,
                                        textBaseline: TextBaseline.alphabetic,
                                        children: [
                                          Text(
                                            '${game.currentDistance}',
                                            style: const TextStyle(
                                              fontSize: 28,
                                              fontWeight: FontWeight.w900,
                                              color: Colors.white,
                                              letterSpacing: 1.0,
                                            ),
                                          ),
                                          const SizedBox(width: 3),
                                          const Text(
                                            'M',
                                            style: TextStyle(
                                              fontSize: 14,
                                              fontWeight: FontWeight.w900,
                                              color: AppConstants.stealthBlue,
                                            ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                  Container(
                                    width: 1,
                                    height: 36,
                                    color: Colors.white.withValues(alpha: 0.1),
                                  ),
                                  Column(
                                    children: [
                                      Text(
                                        'LOOT COLLECTED',
                                        style: TextStyle(
                                          fontSize: 10,
                                          fontWeight: FontWeight.w700,
                                          letterSpacing: 1.2,
                                          color: Colors.white.withValues(
                                            alpha: 0.5,
                                          ),
                                        ),
                                      ),
                                      Row(
                                        mainAxisSize: MainAxisSize.min,
                                        children: [
                                          const Icon(
                                            Icons.diamond_rounded,
                                            color: AppConstants.coinGold,
                                            size: 16,
                                          ),
                                          const SizedBox(width: 4),
                                          Text(
                                            '+${game.collectedCP} CP',
                                            style: const TextStyle(
                                              color: AppConstants.coinGold,
                                              fontWeight: FontWeight.w900,
                                              fontSize: 18,
                                              letterSpacing: 1.0,
                                            ),
                                          ),
                                        ],
                                      ),
                                    ],
                                  ),
                                ],
                              ),
                              const SizedBox(height: 6),
                              if (isNewRecord)
                                Container(
                                  padding: const EdgeInsets.symmetric(
                                    horizontal: 10,
                                    vertical: 3,
                                  ),
                                  decoration: BoxDecoration(
                                    color: AppConstants.coinGold.withValues(
                                      alpha: 0.2,
                                    ),
                                    borderRadius: BorderRadius.circular(12),
                                    border: Border.all(
                                      color: AppConstants.coinGold,
                                      width: 1.0,
                                    ),
                                  ),
                                  child: const Row(
                                    mainAxisSize: MainAxisSize.min,
                                    children: [
                                      Icon(
                                        Icons.emoji_events,
                                        color: AppConstants.coinGold,
                                        size: 13,
                                      ),
                                      SizedBox(width: 5),
                                      Text(
                                        'NEW RECORD REGISTERED!',
                                        style: TextStyle(
                                          color: AppConstants.coinGold,
                                          fontSize: 10,
                                          fontWeight: FontWeight.w900,
                                          letterSpacing: 0.8,
                                        ),
                                      ),
                                    ],
                                  ),
                                )
                              else
                                Text(
                                  'SECTOR BEST: $bestDistance M',
                                  style: TextStyle(
                                    color: Colors.white.withValues(alpha: 0.45),
                                    fontSize: 10,
                                    fontWeight: FontWeight.w700,
                                    letterSpacing: 1.0,
                                  ),
                                ),
                            ],
                          ),
                        ),
                        const SizedBox(height: 14),

                        // 2000 CP Revive Status Banner
                        Builder(
                          builder: (context) {
                            const reviveCostCP = 2000;
                            final canAffordRevive =
                                saveService.player.cyberPoints.value >=
                                reviveCostCP;

                            return Column(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                Container(
                                  width: double.infinity,
                                  padding: const EdgeInsets.symmetric(
                                    horizontal: 14,
                                    vertical: 8,
                                  ),
                                  decoration: BoxDecoration(
                                    color: canAffordRevive
                                        ? const Color(0xFF131A26)
                                        : const Color(0xFF221118),
                                    borderRadius: BorderRadius.circular(10),
                                    border: Border.all(
                                      color: canAffordRevive
                                          ? AppConstants.coinGold.withValues(
                                              alpha: 0.4,
                                            )
                                          : AppConstants.hazardRed.withValues(
                                              alpha: 0.4,
                                            ),
                                      width: 1.0,
                                    ),
                                  ),
                                  child: Row(
                                    mainAxisAlignment:
                                        MainAxisAlignment.spaceBetween,
                                    children: [
                                      Row(
                                        children: [
                                          Icon(
                                            Icons
                                                .settings_backup_restore_rounded,
                                            size: 14,
                                            color: canAffordRevive
                                                ? AppConstants.coinGold
                                                : AppConstants.hazardRed,
                                          ),
                                          const SizedBox(width: 6),
                                          const Text(
                                            'CONTINUE SPOT:',
                                            style: TextStyle(
                                              fontSize: 10,
                                              fontWeight: FontWeight.w700,
                                              fontFamily: 'monospace',
                                              color: Colors.white70,
                                              letterSpacing: 0.8,
                                            ),
                                          ),
                                          const SizedBox(width: 6),
                                          Container(
                                            padding: const EdgeInsets.symmetric(
                                              horizontal: 6,
                                              vertical: 2,
                                            ),
                                            decoration: BoxDecoration(
                                              color: AppConstants.coinGold
                                                  .withValues(alpha: 0.2),
                                              borderRadius:
                                                  BorderRadius.circular(4),
                                            ),
                                            child: const Text(
                                              '2000 CP',
                                              style: TextStyle(
                                                fontSize: 10,
                                                fontWeight: FontWeight.w900,
                                                color: AppConstants.coinGold,
                                                fontFamily: 'monospace',
                                              ),
                                            ),
                                          ),
                                        ],
                                      ),
                                      Text(
                                        'VAULT: ${saveService.player.cyberPoints.value} CP',
                                        style: TextStyle(
                                          fontSize: 10.5,
                                          fontWeight: FontWeight.w900,
                                          fontFamily: 'monospace',
                                          color: canAffordRevive
                                              ? const Color(0xFF00E676)
                                              : AppConstants.hazardRed,
                                        ),
                                      ),
                                    ],
                                  ),
                                ),
                                const SizedBox(height: 12),

                                // Action Buttons: Exit, Restart (Free 0 M), Deploy Again (2000 CP)
                                Row(
                                  children: [
                                    // Exit Hub Button
                                    SizedBox(
                                      height: 44,
                                      width: 95,
                                      child: OutlinedButton(
                                        style: OutlinedButton.styleFrom(
                                          foregroundColor: Colors.white,
                                          padding: EdgeInsets.zero,
                                          side: BorderSide(
                                            color: Colors.white.withValues(
                                              alpha: 0.25,
                                            ),
                                            width: 1.2,
                                          ),
                                          shape: RoundedRectangleBorder(
                                            borderRadius: BorderRadius.circular(
                                              12,
                                            ),
                                          ),
                                        ),
                                        onPressed: () {
                                          AudioService().playClick();
                                          Navigator.of(context).pop();
                                        },
                                        child: Row(
                                          mainAxisAlignment:
                                              MainAxisAlignment.center,
                                          children: [
                                            const Icon(
                                              Icons.logout_rounded,
                                              size: 14,
                                            ),
                                            const SizedBox(width: 4),
                                            Text(
                                              context.l10n.tr('exit_hub'),
                                              style: const TextStyle(
                                                fontWeight: FontWeight.w800,
                                                fontSize: 11,
                                                letterSpacing: 0.8,
                                              ),
                                            ),
                                          ],
                                        ),
                                      ),
                                    ),
                                    const SizedBox(width: 8),

                                    // Restart Mission (Free 0 CP)
                                    Expanded(
                                      flex: 3,
                                      child: SizedBox(
                                        height: 44,
                                        child: OutlinedButton.icon(
                                          style: OutlinedButton.styleFrom(
                                            foregroundColor: Colors.white,
                                            side: BorderSide(
                                              color: const Color(
                                                0xFF00E5FF,
                                              ).withValues(alpha: 0.4),
                                              width: 1.2,
                                            ),
                                            shape: RoundedRectangleBorder(
                                              borderRadius:
                                                  BorderRadius.circular(12),
                                            ),
                                          ),
                                          onPressed: () {
                                            AudioService().playClick();
                                            game.restartMission();
                                          },
                                          icon: const Icon(
                                            Icons.refresh_rounded,
                                            size: 15,
                                            color: Color(0xFF00E5FF),
                                          ),
                                          label: const Text(
                                            'RESTART',
                                            style: TextStyle(
                                              fontWeight: FontWeight.w900,
                                              fontSize: 11,
                                              letterSpacing: 0.8,
                                              color: Color(0xFF00E5FF),
                                            ),
                                          ),
                                        ),
                                      ),
                                    ),
                                    const SizedBox(width: 8),

                                    // Deploy Again (Requires 2000 CP to continue, otherwise restarts)
                                    Expanded(
                                      flex: 4,
                                      child: Container(
                                        height: 44,
                                        decoration: BoxDecoration(
                                          borderRadius: BorderRadius.circular(
                                            12,
                                          ),
                                          gradient: LinearGradient(
                                            colors: canAffordRevive
                                                ? const [
                                                    AppConstants.coinGold,
                                                    Color(0xFFFFB300),
                                                  ]
                                                : const [
                                                    Color(0xFF2C3240),
                                                    Color(0xFF1E2430),
                                                  ],
                                          ),
                                          boxShadow: [
                                            BoxShadow(
                                              color: canAffordRevive
                                                  ? AppConstants.coinGold
                                                        .withValues(alpha: 0.35)
                                                  : Colors.transparent,
                                              blurRadius: 12,
                                              offset: const Offset(0, 2),
                                            ),
                                          ],
                                        ),
                                        child: ElevatedButton(
                                          style: ElevatedButton.styleFrom(
                                            backgroundColor: Colors.transparent,
                                            shadowColor: Colors.transparent,
                                            foregroundColor: canAffordRevive
                                                ? Colors.black
                                                : Colors.white70,
                                            padding: const EdgeInsets.symmetric(
                                              horizontal: 8,
                                            ),
                                            shape: RoundedRectangleBorder(
                                              borderRadius:
                                                  BorderRadius.circular(12),
                                            ),
                                          ),
                                          onPressed: () {
                                            if (saveService.spendCyberPoints(
                                              reviveCostCP,
                                            )) {
                                              AudioService().playCollect();
                                              AudioService().playBooster();
                                              game.revivePlayer();
                                            } else {
                                              AudioService().playClick();
                                              ScaffoldMessenger.of(
                                                context,
                                              ).showSnackBar(
                                                const SnackBar(
                                                  backgroundColor: Color(
                                                    0xFF141926,
                                                  ),
                                                  duration: Duration(
                                                    milliseconds: 1800,
                                                  ),
                                                  content: Text(
                                                    '// INSUFFICIENT CP (2,000 CP REQUIRED). RESTARTING MISSION FROM 0 M...',
                                                    style: TextStyle(
                                                      color: AppConstants
                                                          .hazardRed,
                                                      fontWeight:
                                                          FontWeight.bold,
                                                      fontFamily: 'monospace',
                                                    ),
                                                  ),
                                                ),
                                              );
                                              game.restartMission();
                                            }
                                          },
                                          child: Row(
                                            mainAxisAlignment:
                                                MainAxisAlignment.center,
                                            children: [
                                              Icon(
                                                Icons.bolt_rounded,
                                                size: 16,
                                                color: canAffordRevive
                                                    ? Colors.black
                                                    : Colors.white54,
                                              ),
                                              const SizedBox(width: 3),
                                              Flexible(
                                                child: Text(
                                                  context.l10n.tr(
                                                    'deploy_again',
                                                  ),
                                                  style: TextStyle(
                                                    fontWeight: FontWeight.w900,
                                                    fontSize: 11,
                                                    letterSpacing: 0.8,
                                                    color: canAffordRevive
                                                        ? Colors.black
                                                        : Colors.white70,
                                                  ),
                                                  overflow:
                                                      TextOverflow.ellipsis,
                                                ),
                                              ),
                                              const SizedBox(width: 4),
                                              Container(
                                                padding:
                                                    const EdgeInsets.symmetric(
                                                      horizontal: 4,
                                                      vertical: 2,
                                                    ),
                                                decoration: BoxDecoration(
                                                  color: canAffordRevive
                                                      ? Colors.black.withValues(
                                                          alpha: 0.25,
                                                        )
                                                      : Colors.white.withValues(
                                                          alpha: 0.1,
                                                        ),
                                                  borderRadius:
                                                      BorderRadius.circular(4),
                                                ),
                                                child: Text(
                                                  '2000 CP',
                                                  style: TextStyle(
                                                    fontSize: 9,
                                                    fontWeight: FontWeight.w900,
                                                    color: canAffordRevive
                                                        ? Colors.black
                                                        : Colors.white54,
                                                    fontFamily: 'monospace',
                                                  ),
                                                ),
                                              ),
                                            ],
                                          ),
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                              ],
                            );
                          },
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
    );
  }
}
