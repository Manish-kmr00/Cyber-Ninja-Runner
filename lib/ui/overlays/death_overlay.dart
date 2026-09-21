import 'dart:async';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/monetization/monetization_manager.dart';
import '../../core/storage/save_service.dart';
import '../../game/cyber_ninja_game.dart';

class DeathOverlay extends StatefulWidget {
  final CyberNinjaRunnerGame game;

  const DeathOverlay({super.key, required this.game});

  @override
  State<DeathOverlay> createState() => _DeathOverlayState();
}

class _DeathOverlayState extends State<DeathOverlay> {
  bool _isWatchingReviveAd = false;
  bool _isWatchingDoubleAd = false;
  bool _doubleCpClaimed = false;

  CyberNinjaRunnerGame get game => widget.game;

  Future<void> _watchAdToRevive() async {
    debugPrint('REVIVE_DEBUG: BUTTON_CLICKED');
    debugPrint(
      'REVIVE_DEBUG: TopOn initialized=${MonetizationManager().isInitialized}',
    );
    if (_isWatchingReviveAd) return;
    setState(() => _isWatchingReviveAd = true);

    bool rewardGranted = false;
    try {
      final success = await MonetizationManager().showRewarded(
        rewardType: RewardType.revive,
        onReviveReward: () {
          debugPrint('REVIVE_DEBUG: onReviveReward callback received from SDK');
          rewardGranted = true;
        },
      );

      if (mounted) {
        setState(() => _isWatchingReviveAd = false);
      }

      if (success || rewardGranted) {
        debugPrint(
          'REVIVE_DEBUG: Ad flow completed with verified reward. Executing exact revive now.',
        );
        AudioService().playCollect();
        AudioService().playBooster();
        game.revivePlayer();
        debugPrint('REVIVE_DEBUG: PLAYER_REVIVED_AT_EXACT_LOCATION');
      } else {
        debugPrint('REVIVE_DEBUG: Ad closed without reward or load failed.');
        if (mounted) {
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              backgroundColor: const Color(0xFF141926),
              duration: const Duration(milliseconds: 1800),
              content: Text(
                context.l10n.tr('ad_unavailable_toast'),
                style: TextStyle(
                  color: AppConstants.stealthBlue,
                  fontWeight: FontWeight.bold,
                  fontFamily: 'monospace',
                  fontSize: 11,
                ),
              ),
            ),
          );
        }
      }
    } catch (e) {
      if (mounted) {
        setState(() => _isWatchingReviveAd = false);
      }
    }
  }

  Future<void> _watchAdForDoubleCP(SaveService saveService) async {
    if (_isWatchingDoubleAd || _doubleCpClaimed) return;
    setState(() => _isWatchingDoubleAd = true);

    try {
      final success = await MonetizationManager().showRewarded(
        rewardType: RewardType.doubleCyberPoints,
      );

      if (!mounted) return;
      setState(() => _isWatchingDoubleAd = false);

      if (success) {
        setState(() => _doubleCpClaimed = true);
        saveService.addCyberPoints(game.collectedCP);
        AudioService().playCollect();
        MonetizationManager().playRewardCelebration(
          context,
          RewardAnimationType.doubleReward,
          customTitle: 'LOOT MULTIPLIED 2X!',
          customSubtitle: '+${game.collectedCP} CP Credited to Cyber Vault',
          count: game.collectedCP * 2,
        );
      }
    } catch (e) {
      if (mounted) {
        setState(() => _isWatchingDoubleAd = false);
      }
    }
  }

  BoxDecoration get _modalDecoration => BoxDecoration(
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
      BoxShadow(color: Colors.black.withValues(alpha: 0.8), blurRadius: 16),
    ],
  );

  Widget _buildStatusHeader(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Flexible(
          child: Container(
            padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 3),
            decoration: BoxDecoration(
              color: AppConstants.hazardRed.withValues(alpha: 0.2),
              borderRadius: BorderRadius.circular(6),
              border: Border.all(
                color: AppConstants.hazardRed.withValues(alpha: 0.5),
              ),
            ),
            child: FittedBox(
              fit: BoxFit.scaleDown,
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
          ),
        ),
        const SizedBox(width: 6),
        Flexible(
          child: FittedBox(
            fit: BoxFit.scaleDown,
            child: Text(
              'SECTOR_${game.mode.name.toUpperCase()}',
              style: TextStyle(
                color: Colors.white.withValues(alpha: 0.4),
                fontSize: 10,
                fontWeight: FontWeight.bold,
                letterSpacing: 1.0,
              ),
            ),
          ),
        ),
      ],
    );
  }

  Widget _buildTitleSection({bool isCompact = false}) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        FittedBox(
          fit: BoxFit.scaleDown,
          alignment: Alignment.centerLeft,
          child: Text(
            context.l10n.tr('neural_link_severed'),
            style: TextStyle(
              fontSize: isCompact ? 16 : 18,
              fontWeight: FontWeight.w900,
              color: Colors.white,
              letterSpacing: 1.8,
            ),
          ),
        ),
        const SizedBox(height: 2),
        FittedBox(
          fit: BoxFit.scaleDown,
          alignment: Alignment.centerLeft,
          child: Text(
            context.l10n.tr('chassis_compromised'),
            style: TextStyle(
              fontSize: isCompact ? 9 : 10,
              fontWeight: FontWeight.w600,
              color: AppConstants.hazardRed.withValues(alpha: 0.85),
              letterSpacing: 1.1,
            ),
          ),
        ),
      ],
    );
  }

  Widget _buildTelemetryCard(
    BuildContext context,
    SaveService saveService,
    int bestDistance,
    bool isNewRecord, {
    bool compact = false,
  }) {
    return Container(
      width: double.infinity,
      padding: EdgeInsets.symmetric(vertical: compact ? 7 : 10, horizontal: 12),
      decoration: BoxDecoration(
        color: const Color(0xFF141A24),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: Colors.white.withValues(alpha: 0.08)),
      ),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              // Distance Column
              Expanded(
                child: Column(
                  children: [
                    Text(
                      context.l10n.tr('distance_label'),
                      style: TextStyle(
                        fontSize: compact ? 9 : 10,
                        fontWeight: FontWeight.w700,
                        letterSpacing: 1.2,
                        color: Colors.white.withValues(alpha: 0.5),
                      ),
                    ),
                    const SizedBox(height: 2),
                    FittedBox(
                      fit: BoxFit.scaleDown,
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        crossAxisAlignment: CrossAxisAlignment.baseline,
                        textBaseline: TextBaseline.alphabetic,
                        children: [
                          Text(
                            '${game.currentDistance}',
                            style: TextStyle(
                              fontSize: compact ? 22 : 26,
                              fontWeight: FontWeight.w900,
                              color: Colors.white,
                              letterSpacing: 1.0,
                            ),
                          ),
                          const SizedBox(width: 3),
                          Text(
                            'M',
                            style: TextStyle(
                              fontSize: compact ? 12 : 13,
                              fontWeight: FontWeight.w900,
                              color: AppConstants.stealthBlue,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
              Container(
                width: 1,
                height: compact ? 28 : 34,
                color: Colors.white.withValues(alpha: 0.1),
              ),
              // Loot Column
              Expanded(
                child: Column(
                  children: [
                    Text(
                      context.l10n.tr('loot_collected'),
                      style: TextStyle(
                        fontSize: compact ? 9 : 10,
                        fontWeight: FontWeight.w700,
                        letterSpacing: 1.2,
                        color: Colors.white.withValues(alpha: 0.5),
                      ),
                    ),
                    const SizedBox(height: 2),
                    FittedBox(
                      fit: BoxFit.scaleDown,
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Icon(
                            Icons.diamond_rounded,
                            color: AppConstants.coinGold,
                            size: compact ? 14 : 16,
                          ),
                          const SizedBox(width: 4),
                          Text(
                            '+${game.collectedCP} CP',
                            style: TextStyle(
                              color: AppConstants.coinGold,
                              fontWeight: FontWeight.w900,
                              fontSize: compact ? 15 : 17,
                              letterSpacing: 0.8,
                            ),
                          ),
                        ],
                      ),
                    ),
                    if (game.collectedCP > 0) ...[
                      const SizedBox(height: 4),
                      GestureDetector(
                        onTap: (_isWatchingDoubleAd || _doubleCpClaimed)
                            ? null
                            : () => _watchAdForDoubleCP(saveService),
                        child: Container(
                          padding: const EdgeInsets.symmetric(
                            horizontal: 6,
                            vertical: 2.5,
                          ),
                          decoration: BoxDecoration(
                            color: _doubleCpClaimed
                                ? const Color(0xFF00E676).withValues(alpha: 0.2)
                                : AppConstants.coinGold.withValues(alpha: 0.15),
                            borderRadius: BorderRadius.circular(6),
                            border: Border.all(
                              color: _doubleCpClaimed
                                  ? const Color(0xFF00E676)
                                  : AppConstants.coinGold,
                              width: 1,
                            ),
                          ),
                          child: FittedBox(
                            fit: BoxFit.scaleDown,
                            child: Row(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                Icon(
                                  _doubleCpClaimed
                                      ? Icons.check_circle_rounded
                                      : Icons.play_circle_filled_rounded,
                                  size: 10,
                                  color: _doubleCpClaimed
                                      ? const Color(0xFF00E676)
                                      : AppConstants.coinGold,
                                ),
                                const SizedBox(width: 3),
                                Text(
                                  _doubleCpClaimed
                                      ? '2X CLAIMED'
                                      : _isWatchingDoubleAd
                                      ? 'LOADING...'
                                      : 'WATCH AD: 2X CP',
                                  style: TextStyle(
                                    color: _doubleCpClaimed
                                        ? const Color(0xFF00E676)
                                        : AppConstants.coinGold,
                                    fontSize: 8.5,
                                    fontWeight: FontWeight.w900,
                                    letterSpacing: 0.4,
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    ],
                  ],
                ),
              ),
            ],
          ),
          SizedBox(height: compact ? 4 : 6),
          if (isNewRecord)
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 2),
              decoration: BoxDecoration(
                color: AppConstants.coinGold.withValues(alpha: 0.2),
                borderRadius: BorderRadius.circular(10),
                border: Border.all(color: AppConstants.coinGold, width: 1.0),
              ),
              child: FittedBox(
                fit: BoxFit.scaleDown,
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Icon(
                      Icons.emoji_events,
                      color: AppConstants.coinGold,
                      size: 12,
                    ),
                    SizedBox(width: 4),
                    Text(
                      context.l10n.tr('new_record_registered'),
                      style: TextStyle(
                        color: AppConstants.coinGold,
                        fontSize: 9.5,
                        fontWeight: FontWeight.w900,
                        letterSpacing: 0.8,
                      ),
                    ),
                  ],
                ),
              ),
            )
          else
            FittedBox(
              fit: BoxFit.scaleDown,
              child: Text(
                '${context.l10n.tr('sector_best')} $bestDistance M',
                style: TextStyle(
                  color: Colors.white.withValues(alpha: 0.45),
                  fontSize: 9.5,
                  fontWeight: FontWeight.w700,
                  letterSpacing: 0.8,
                ),
              ),
            ),
        ],
      ),
    );
  }

  Widget _buildAdReviveButton({bool compact = false}) {
    return Container(
      width: double.infinity,
      height: compact ? 36 : 40,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10),
        gradient: const LinearGradient(
          colors: [Color(0xFF00E5FF), Color(0xFF0052D4)],
        ),
        boxShadow: [
          BoxShadow(
            color: const Color(0xFF00E5FF).withValues(alpha: 0.3),
            blurRadius: 8,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          backgroundColor: Colors.transparent,
          shadowColor: Colors.transparent,
          foregroundColor: Colors.black,
          padding: const EdgeInsets.symmetric(horizontal: 8),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
        ),
        onPressed: _isWatchingReviveAd ? null : _watchAdToRevive,
        child: FittedBox(
          fit: BoxFit.scaleDown,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Icon(Icons.videocam_rounded, size: 16, color: Colors.black),
              const SizedBox(width: 6),
              Text(
                _isWatchingReviveAd
                    ? context.l10n.tr('ad_connecting')
                    : context.l10n.tr('watch_ad_revive'),
                style: const TextStyle(
                  fontSize: 11,
                  fontWeight: FontWeight.w900,
                  letterSpacing: 0.8,
                  color: Colors.black,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildContinueSpotBanner(
    SaveService saveService, {
    bool compact = false,
  }) {
    const reviveCostCP = 2000;
    final canAffordRevive =
        saveService.player.cyberPoints.value >= reviveCostCP;

    return Container(
      width: double.infinity,
      padding: EdgeInsets.symmetric(horizontal: 8, vertical: compact ? 3 : 5),
      decoration: BoxDecoration(
        color: canAffordRevive
            ? const Color(0xFF131A26)
            : const Color(0xFF221118),
        borderRadius: BorderRadius.circular(8),
        border: Border.all(
          color: canAffordRevive
              ? AppConstants.coinGold.withValues(alpha: 0.4)
              : AppConstants.hazardRed.withValues(alpha: 0.4),
          width: 1.0,
        ),
      ),
      child: FittedBox(
        fit: BoxFit.scaleDown,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                Icon(
                  Icons.settings_backup_restore_rounded,
                  size: 13,
                  color: canAffordRevive
                      ? AppConstants.coinGold
                      : AppConstants.hazardRed,
                ),
                const SizedBox(width: 5),
                Text(
                  context.l10n.tr('continue_spot'),
                  style: TextStyle(
                    fontSize: 9.5,
                    fontWeight: FontWeight.w700,
                    fontFamily: 'monospace',
                    color: Colors.white70,
                    letterSpacing: 0.6,
                  ),
                ),
                const SizedBox(width: 5),
                Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 5,
                    vertical: 1.5,
                  ),
                  decoration: BoxDecoration(
                    color: AppConstants.coinGold.withValues(alpha: 0.2),
                    borderRadius: BorderRadius.circular(4),
                  ),
                  child: const Text(
                    '2000 CP',
                    style: TextStyle(
                      fontSize: 9.5,
                      fontWeight: FontWeight.w900,
                      color: AppConstants.coinGold,
                      fontFamily: 'monospace',
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(width: 10),
            Text(
              '${context.l10n.tr('cp_vault')} ${saveService.player.cyberPoints.value} CP',
              style: TextStyle(
                fontSize: 9.5,
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
    );
  }

  Widget _buildDeployAgainButton(
    BuildContext context,
    SaveService saveService, {
    bool compact = false,
  }) {
    const reviveCostCP = 2000;
    final canAffordRevive =
        saveService.player.cyberPoints.value >= reviveCostCP;

    return Container(
      width: double.infinity,
      height: compact ? 36 : 40,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10),
        gradient: LinearGradient(
          colors: canAffordRevive
              ? const [AppConstants.coinGold, Color(0xFFFFB300)]
              : const [Color(0xFF2C3240), Color(0xFF1E2430)],
        ),
        boxShadow: [
          BoxShadow(
            color: canAffordRevive
                ? AppConstants.coinGold.withValues(alpha: 0.35)
                : Colors.transparent,
            blurRadius: 10,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          backgroundColor: Colors.transparent,
          shadowColor: Colors.transparent,
          foregroundColor: canAffordRevive ? Colors.black : Colors.white70,
          padding: const EdgeInsets.symmetric(horizontal: 8),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
        ),
        onPressed: () {
          if (saveService.spendCyberPoints(reviveCostCP)) {
            AudioService().playCollect();
            AudioService().playBooster();
            game.revivePlayer();
          } else {
            AudioService().playClick();
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                backgroundColor: const Color(0xFF141926),
                duration: const Duration(milliseconds: 1800),
                content: Text(
                  context.l10n.tr('insufficient_cp_toast'),
                  style: TextStyle(
                    color: AppConstants.hazardRed,
                    fontWeight: FontWeight.bold,
                    fontFamily: 'monospace',
                  ),
                ),
              ),
            );
            game.restartMission();
          }
        },
        child: FittedBox(
          fit: BoxFit.scaleDown,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(
                Icons.bolt_rounded,
                size: 15,
                color: canAffordRevive ? Colors.black : Colors.white54,
              ),
              const SizedBox(width: 4),
              Text(
                context.l10n.tr('deploy_again'),
                style: TextStyle(
                  fontWeight: FontWeight.w900,
                  fontSize: 11,
                  letterSpacing: 0.8,
                  color: canAffordRevive ? Colors.black : Colors.white70,
                ),
              ),
              const SizedBox(width: 5),
              Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 5,
                  vertical: 1.5,
                ),
                decoration: BoxDecoration(
                  color: canAffordRevive
                      ? Colors.black.withValues(alpha: 0.25)
                      : Colors.white.withValues(alpha: 0.1),
                  borderRadius: BorderRadius.circular(4),
                ),
                child: Text(
                  '2000 CP',
                  style: TextStyle(
                    fontSize: 8.5,
                    fontWeight: FontWeight.w900,
                    color: canAffordRevive ? Colors.black : Colors.white54,
                    fontFamily: 'monospace',
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildActionRow(BuildContext context, {bool compact = false}) {
    return Row(
      children: [
        // Restart Button
        Expanded(
          flex: 1,
          child: SizedBox(
            height: compact ? 36 : 40,
            child: OutlinedButton.icon(
              style: OutlinedButton.styleFrom(
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(horizontal: 6),
                side: BorderSide(
                  color: const Color(0xFF00E5FF).withValues(alpha: 0.4),
                  width: 1.2,
                ),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
              onPressed: () {
                AudioService().playClick();
                game.restartMission();
              },
              icon: const Icon(
                Icons.refresh_rounded,
                size: 14,
                color: Color(0xFF00E5FF),
              ),
              label: FittedBox(
                fit: BoxFit.scaleDown,
                child: Text(
                  context.l10n.tr('restart_btn'),
                  style: const TextStyle(
                    fontWeight: FontWeight.w900,
                    fontSize: 11,
                    letterSpacing: 0.8,
                    color: Color(0xFF00E5FF),
                  ),
                ),
              ),
            ),
          ),
        ),
        const SizedBox(width: 8),

        // Exit Hub Button
        Expanded(
          flex: 1,
          child: SizedBox(
            height: compact ? 36 : 40,
            child: OutlinedButton(
              style: OutlinedButton.styleFrom(
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(horizontal: 6),
                side: BorderSide(
                  color: Colors.white.withValues(alpha: 0.25),
                  width: 1.2,
                ),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
              onPressed: () {
                AudioService().playClick();
                MonetizationManager().recordRunCompleted();
                Navigator.of(context).pop();
                unawaited(MonetizationManager().showInterstitialIfEligible());
              },
              child: FittedBox(
                fit: BoxFit.scaleDown,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Icon(Icons.logout_rounded, size: 14),
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
          ),
        ),
      ],
    );
  }

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
          SafeArea(
            child: Center(
              child: LayoutBuilder(
                builder: (context, constraints) {
                  final isLandscape =
                      constraints.maxWidth >= 540 &&
                      constraints.maxWidth > constraints.maxHeight;
                  final isShortHeight = constraints.maxHeight < 360;

                  if (isLandscape) {
                    final modalWidth = (constraints.maxWidth * 0.92).clamp(
                      500.0,
                      740.0,
                    );
                    return SingleChildScrollView(
                      physics: const BouncingScrollPhysics(),
                      padding: EdgeInsets.symmetric(
                        vertical: isShortHeight ? 6 : 10,
                        horizontal: 16,
                      ),
                      child: Container(
                        width: modalWidth,
                        padding: EdgeInsets.symmetric(
                          horizontal: 16,
                          vertical: isShortHeight ? 10 : 14,
                        ),
                        decoration: _modalDecoration,
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            // Left Column: Telemetry & Mission status
                            Expanded(
                              flex: 11,
                              child: Column(
                                mainAxisSize: MainAxisSize.min,
                                crossAxisAlignment: CrossAxisAlignment.stretch,
                                children: [
                                  _buildStatusHeader(context),
                                  SizedBox(height: isShortHeight ? 4 : 8),
                                  _buildTitleSection(isCompact: isShortHeight),
                                  SizedBox(height: isShortHeight ? 6 : 10),
                                  _buildTelemetryCard(
                                    context,
                                    saveService,
                                    bestDistance,
                                    isNewRecord,
                                    compact: isShortHeight,
                                  ),
                                ],
                              ),
                            ),
                            Padding(
                              padding: const EdgeInsets.symmetric(
                                horizontal: 12,
                              ),
                              child: Container(
                                width: 1,
                                height: isShortHeight ? 165 : 195,
                                color: Colors.white.withValues(alpha: 0.1),
                              ),
                            ),
                            // Right Column: Revive options & Action deck
                            Expanded(
                              flex: 12,
                              child: Column(
                                mainAxisSize: MainAxisSize.min,
                                crossAxisAlignment: CrossAxisAlignment.stretch,
                                children: [
                                  _buildAdReviveButton(compact: isShortHeight),
                                  SizedBox(height: isShortHeight ? 5 : 7),
                                  _buildContinueSpotBanner(
                                    saveService,
                                    compact: isShortHeight,
                                  ),
                                  SizedBox(height: isShortHeight ? 5 : 7),
                                  _buildDeployAgainButton(
                                    context,
                                    saveService,
                                    compact: isShortHeight,
                                  ),
                                  SizedBox(height: isShortHeight ? 6 : 9),
                                  _buildActionRow(
                                    context,
                                    compact: isShortHeight,
                                  ),
                                ],
                              ),
                            ),
                          ],
                        ),
                      ),
                    );
                  }

                  // Fallback for narrow / portrait screens
                  final modalWidth = (constraints.maxWidth * 0.88).clamp(
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
                        horizontal: 18,
                        vertical: 14,
                      ),
                      decoration: _modalDecoration,
                      child: Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          _buildStatusHeader(context),
                          const SizedBox(height: 8),
                          _buildTitleSection(isCompact: isShortHeight),
                          const SizedBox(height: 10),
                          _buildTelemetryCard(
                            context,
                            saveService,
                            bestDistance,
                            isNewRecord,
                            compact: isShortHeight,
                          ),
                          const SizedBox(height: 12),
                          _buildAdReviveButton(compact: isShortHeight),
                          const SizedBox(height: 8),
                          _buildContinueSpotBanner(
                            saveService,
                            compact: isShortHeight,
                          ),
                          const SizedBox(height: 8),
                          _buildDeployAgainButton(
                            context,
                            saveService,
                            compact: isShortHeight,
                          ),
                          const SizedBox(height: 10),
                          _buildActionRow(context, compact: isShortHeight),
                        ],
                      ),
                    ),
                  );
                },
              ),
            ),
          ),
        ],
      ),
    );
  }
}
