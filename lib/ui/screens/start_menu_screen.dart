import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/storage/save_service.dart';
import 'game_screen.dart';
import 'leaderboard_screen.dart';
import 'settings_screen.dart';
import 'shop_screen.dart';

class StartMenuScreen extends StatefulWidget {
  const StartMenuScreen({super.key});

  @override
  State<StartMenuScreen> createState() => _StartMenuScreenState();
}

class _StartMenuScreenState extends State<StartMenuScreen>
    with SingleTickerProviderStateMixin {
  late final AnimationController _pulseController;

  @override
  void initState() {
    super.initState();
    _pulseController = AnimationController(
      vsync: this,
      duration: const Duration(seconds: 3),
    )..repeat(reverse: true);
  }

  @override
  void dispose() {
    _pulseController.dispose();
    super.dispose();
  }

  void _launchGame(BuildContext context, GameMode mode) {
    AudioService().playClick();
    Navigator.of(
      context,
    ).push(MaterialPageRoute(builder: (_) => GameScreen(mode: mode)));
  }

  void _claimDailyGift(BuildContext context) {
    final saveService = context.read<SaveService>();
    final nowEpoch = DateTime.now().millisecondsSinceEpoch;
    final lastClaim = saveService.player.lastDailyClaimEpoch;

    // 20 hours cooldown
    if (nowEpoch - lastClaim > 20 * 60 * 60 * 1000) {
      AudioService().playCollect();
      saveService.player.lastDailyClaimEpoch = nowEpoch;
      saveService.addCubePoints(150);
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          backgroundColor: const Color(0xFF161B26),
          content: const Row(
            children: [
              Icon(Icons.diamond, color: AppConstants.coinGold),
              SizedBox(width: 10),
              Text(
                'NEURAL CRATE UNLOCKED! +150 CP',
                style: TextStyle(
                  fontWeight: FontWeight.w900,
                  color: AppConstants.coinGold,
                  letterSpacing: 1.0,
                ),
              ),
            ],
          ),
          duration: const Duration(seconds: 2),
          behavior: SnackBarBehavior.floating,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(14),
            side: const BorderSide(color: AppConstants.coinGold, width: 1.5),
          ),
        ),
      );
    } else {
      final hoursLeft = (20 - (nowEpoch - lastClaim) / (60 * 60 * 1000)).ceil();
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          backgroundColor: const Color(0xFF161B26),
          content: Text(
            'RECHARGING CRATE: Next supply drop in ${hoursLeft}h',
            style: const TextStyle(color: Colors.white70),
          ),
          duration: const Duration(seconds: 2),
          behavior: SnackBarBehavior.floating,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(14),
          ),
        ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final player = saveService.player;

    return Scaffold(
      backgroundColor: const Color(0xFF090B10),
      body: Stack(
        children: [
          // Background Cyberpunk Ambient Glow Gradients
          Positioned(
            top: -100,
            left: -100,
            child: Container(
              width: 320,
              height: 320,
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                color: AppConstants.stealthBlue.withValues(alpha: 0.10),
              ),
            ),
          ),
          Positioned(
            bottom: -100,
            right: -100,
            child: Container(
              width: 350,
              height: 350,
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                color: const Color(0xFFFF007F).withValues(alpha: 0.08),
              ),
            ),
          ),

          SafeArea(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 22, vertical: 16),
              child: Column(
                children: [
                  // 1. Top Bar: Game Title & Utility Actions
                  _buildHeader(context, player),
                  const SizedBox(height: 14),

                  // 2. Active Operative Status Badge
                  _buildOperativeBadge(context),

                  const Spacer(),

                  // 3. Center: Holographic Mode Selection Carousel
                  _buildModeCarousel(context, saveService),

                  const Spacer(),

                  // 4. Bottom Utility Dock: Daily Crate, Arsenal & Hangar, Leaderboard
                  _buildBottomDock(context),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildHeader(BuildContext context, dynamic player) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        // Cyberpunk Title Lockup
        Row(
          children: [
            Container(
              width: 4,
              height: 36,
              decoration: BoxDecoration(
                color: AppConstants.stealthBlue,
                borderRadius: BorderRadius.circular(2),
                boxShadow: [
                  BoxShadow(
                    color: AppConstants.stealthBlue.withValues(alpha: 0.6),
                    blurRadius: 8,
                  ),
                ],
              ),
            ),
            const SizedBox(width: 12),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Text(
                      context.l10n.tr('game_title_cyber'),
                      style: const TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.w900,
                        color: AppConstants.stealthBlue,
                        letterSpacing: 2.0,
                        height: 1.0,
                      ),
                    ),
                    const SizedBox(width: 6),
                    Text(
                      context.l10n.tr('game_title_runner'),
                      style: const TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.w900,
                        color: Colors.white,
                        letterSpacing: 2.0,
                        height: 1.0,
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 3),
                Text(
                  context.l10n.tr('game_protocol'),
                  style: const TextStyle(
                    fontSize: 9,
                    fontWeight: FontWeight.bold,
                    color: Colors.white38,
                    letterSpacing: 2.5,
                  ),
                ),
              ],
            ),
          ],
        ),

        // Header Actions: CP Counter & Settings/Leaderboard
        Row(
          children: [
            // Currency Pill
            GestureDetector(
              behavior: HitTestBehavior.opaque,
              onTap: () {
                AudioService().playClick();
                Navigator.of(
                  context,
                ).push(MaterialPageRoute(builder: (_) => const ShopScreen()));
              },
              child: Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 14,
                  vertical: 7,
                ),
                decoration: BoxDecoration(
                  color: const Color(0xFF131722),
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(
                    color: AppConstants.coinGold.withValues(alpha: 0.6),
                    width: 1.2,
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: AppConstants.coinGold.withValues(alpha: 0.15),
                      blurRadius: 8,
                    ),
                  ],
                ),
                child: Row(
                  children: [
                    const Icon(
                      Icons.diamond,
                      color: AppConstants.coinGold,
                      size: 17,
                    ),
                    const SizedBox(width: 6),
                    Text(
                      '${player.cubePoints.value}',
                      style: const TextStyle(
                        fontSize: 14,
                        fontWeight: FontWeight.w900,
                        color: AppConstants.coinGold,
                        letterSpacing: 0.5,
                      ),
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(width: 10),

            // Leaderboard
            _buildRoundIconButton(
              icon: Icons.leaderboard_rounded,
              color: AppConstants.stealthBlue,
              onTap: () {
                AudioService().playClick();
                Navigator.of(context).push(
                  MaterialPageRoute(builder: (_) => const LeaderboardScreen()),
                );
              },
            ),
            const SizedBox(width: 8),

            // Settings
            _buildRoundIconButton(
              icon: Icons.tune_rounded,
              color: Colors.white70,
              onTap: () {
                AudioService().playClick();
                Navigator.of(context).push(
                  MaterialPageRoute(builder: (_) => const SettingsScreen()),
                );
              },
            ),
          ],
        ),
      ],
    );
  }

  Widget _buildRoundIconButton({
    required IconData icon,
    required Color color,
    required VoidCallback onTap,
  }) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Container(
        width: 38,
        height: 38,
        decoration: BoxDecoration(
          color: const Color(0xFF131722),
          borderRadius: BorderRadius.circular(12),
          border: Border.all(color: Colors.white12),
        ),
        child: Center(child: Icon(icon, color: color, size: 19)),
      ),
    );
  }

  Widget _buildOperativeBadge(BuildContext context) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: () {
        AudioService().playClick();
        Navigator.of(
          context,
        ).push(MaterialPageRoute(builder: (_) => const ShopScreen()));
      },
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 18, vertical: 8),
        decoration: BoxDecoration(
          color: const Color(0xFF0F1522),
          borderRadius: BorderRadius.circular(16),
          border: Border.all(
            color: AppConstants.stealthBlue.withValues(alpha: 0.45),
            width: 1.2,
          ),
          boxShadow: [
            BoxShadow(
              color: AppConstants.stealthBlue.withValues(alpha: 0.15),
              blurRadius: 10,
            ),
          ],
        ),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Icon(
              Icons.sports_martial_arts_rounded,
              color: AppConstants.stealthBlue,
              size: 18,
            ),
            const SizedBox(width: 8),
            Text(
              context.l10n.tr('active_operative'),
              style: const TextStyle(
                fontWeight: FontWeight.w900,
                fontSize: 11,
                letterSpacing: 1.4,
                color: Colors.white,
              ),
            ),
            const SizedBox(width: 8),
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
              decoration: BoxDecoration(
                color: AppConstants.stealthBlue.withValues(alpha: 0.2),
                borderRadius: BorderRadius.circular(6),
              ),
              child: Text(
                context.l10n.tr('deployed'),
                style: const TextStyle(
                  fontSize: 9,
                  fontWeight: FontWeight.w900,
                  color: AppConstants.stealthBlue,
                  letterSpacing: 1.0,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildModeCarousel(BuildContext context, SaveService saveService) {
    final isTenXUnlocked = saveService.player.isTenXUnlocked;
    final isFlightUnlocked = saveService.player.isFlightUnlocked;
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      physics: const BouncingScrollPhysics(),
      child: Row(
        children: [
          _buildModernModeCard(
            context,
            title: context.l10n.tr('endless_title'),
            tag: context.l10n.tr('core_campaign'),
            mapName: context.l10n.tr('endless_map'),
            mapSector: context.l10n.tr('endless_sector'),
            threatLevel: context.l10n.tr('threat_lvl_3'),
            threatColor: AppConstants.stealthBlue,
            hazardTags: const ['TITAN MECH', 'DROID CANNONS', 'PLASMA SPIKES'],
            rewardMultiplier: '1.0X CP',
            objective: context.l10n.tr('endless_obj'),
            icon: Icons.play_arrow_rounded,
            accentColor: AppConstants.stealthBlue,
            bestScore: saveService.stats.bestDistanceRun,
            onTap: () => _launchGame(context, GameMode.run),
          ),
          const SizedBox(width: 16),
          _buildModernModeCard(
            context,
            title: context.l10n.tr('tenx_title'),
            tag: context.l10n.tr('extreme_risk'),
            mapName: context.l10n.tr('tenx_map'),
            mapSector: context.l10n.tr('tenx_sector'),
            threatLevel: context.l10n.tr('threat_lvl_5'),
            threatColor: AppConstants.hazardRed,
            hazardTags: const [
              'OVERCHARGED TITAN',
              'RAPID CANNONS',
              'WARP TRAPS',
            ],
            rewardMultiplier: '10.0X CP',
            objective: context.l10n.tr('tenx_obj'),
            icon: Icons.flash_on_rounded,
            accentColor: AppConstants.hazardRed,
            bestScore: saveService.stats.bestDistance10x,
            isLocked: !isTenXUnlocked,
            unlockPrice: 50000,
            onTap: isTenXUnlocked
                ? () => _launchGame(context, GameMode.tenXChallenge)
                : () => _promptTenXUnlock(context, saveService),
          ),
          const SizedBox(width: 16),
          _buildModernModeCard(
            context,
            title: context.l10n.tr('flight_title'),
            tag: context.l10n.tr('aerial_zero_g'),
            mapName: context.l10n.tr('flight_map'),
            mapSector: context.l10n.tr('flight_sector'),
            threatLevel: context.l10n.tr('threat_lvl_4'),
            threatColor: const Color(0xFFD500F9),
            hazardTags: const ['LASER WEBS', 'AERIAL MINES', 'ION CEILINGS'],
            rewardMultiplier: '2.5X CP',
            objective: context.l10n.tr('flight_obj'),
            icon: Icons.flight_takeoff_rounded,
            accentColor: const Color(0xFFD500F9),
            bestScore: saveService.stats.bestDistanceSqubeBird,
            isLocked: !isFlightUnlocked,
            unlockPrice: 100000,
            onTap: isFlightUnlocked
                ? () => _launchGame(context, GameMode.squbeBird)
                : () => _promptFlightUnlock(context, saveService),
          ),
        ],
      ),
    );
  }

  Widget _buildModernModeCard(
    BuildContext context, {
    required String title,
    required String tag,
    required String mapName,
    required String mapSector,
    required String threatLevel,
    required Color threatColor,
    required List<String> hazardTags,
    required String rewardMultiplier,
    required String objective,
    required IconData icon,
    required Color accentColor,
    required int bestScore,
    required VoidCallback onTap,
    bool isLocked = false,
    int unlockPrice = 0,
  }) {
    final formattedPrice = unlockPrice.toString().replaceAllMapped(
      RegExp(r'(\d{1,3})(?=(\d{3})+(?!\d))'),
      (m) => '${m[1]},',
    );
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Container(
        width: 290,
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 13),
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: isLocked
                ? const [Color(0xFF15141E), Color(0xFF0D0C14)]
                : const [Color(0xFF131926), Color(0xFF0C101A)],
          ),
          borderRadius: BorderRadius.circular(20),
          border: Border.all(
            color: isLocked
                ? AppConstants.coinGold.withValues(alpha: 0.5)
                : accentColor.withValues(alpha: 0.45),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: isLocked
                  ? AppConstants.coinGold.withValues(alpha: 0.15)
                  : accentColor.withValues(alpha: 0.14),
              blurRadius: 16,
              spreadRadius: 1,
            ),
          ],
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisSize: MainAxisSize.min,
          children: [
            // 1. Top Row: Tag, Multiplier Pill & Action Icon
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Row(
                  children: [
                    Container(
                      padding: const EdgeInsets.symmetric(
                        horizontal: 8,
                        vertical: 3.5,
                      ),
                      decoration: BoxDecoration(
                        color: (isLocked ? AppConstants.hazardRed : accentColor)
                            .withValues(alpha: 0.18),
                        borderRadius: BorderRadius.circular(6),
                        border: Border.all(
                          color:
                              (isLocked ? AppConstants.hazardRed : accentColor)
                                  .withValues(alpha: 0.4),
                        ),
                      ),
                      child: Text(
                        tag,
                        style: TextStyle(
                          fontSize: 9,
                          fontWeight: FontWeight.w900,
                          color: isLocked
                              ? AppConstants.hazardRed
                              : accentColor,
                          letterSpacing: 0.8,
                        ),
                      ),
                    ),
                    const SizedBox(width: 6),
                    if (isLocked)
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 7,
                          vertical: 3.5,
                        ),
                        decoration: BoxDecoration(
                          color: AppConstants.coinGold.withValues(alpha: 0.18),
                          borderRadius: BorderRadius.circular(6),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(alpha: 0.5),
                          ),
                        ),
                        child: Row(
                          children: [
                            const Icon(
                              Icons.lock_rounded,
                              color: AppConstants.coinGold,
                              size: 11,
                            ),
                            const SizedBox(width: 3),
                            Text(
                              '$formattedPrice CP',
                              style: const TextStyle(
                                fontSize: 9,
                                fontWeight: FontWeight.w900,
                                color: AppConstants.coinGold,
                                letterSpacing: 0.5,
                              ),
                            ),
                          ],
                        ),
                      )
                    else
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 7,
                          vertical: 3.5,
                        ),
                        decoration: BoxDecoration(
                          color: AppConstants.coinGold.withValues(alpha: 0.16),
                          borderRadius: BorderRadius.circular(6),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(
                              alpha: 0.35,
                            ),
                          ),
                        ),
                        child: Row(
                          children: [
                            const Icon(
                              Icons.bolt,
                              color: AppConstants.coinGold,
                              size: 11,
                            ),
                            const SizedBox(width: 2),
                            Text(
                              rewardMultiplier,
                              style: const TextStyle(
                                fontSize: 9,
                                fontWeight: FontWeight.w900,
                                color: AppConstants.coinGold,
                                letterSpacing: 0.5,
                              ),
                            ),
                          ],
                        ),
                      ),
                  ],
                ),
                Container(
                  width: 34,
                  height: 34,
                  decoration: BoxDecoration(
                    color: (isLocked ? AppConstants.coinGold : accentColor)
                        .withValues(alpha: 0.18),
                    shape: BoxShape.circle,
                    border: Border.all(
                      color: (isLocked ? AppConstants.coinGold : accentColor)
                          .withValues(alpha: 0.5),
                    ),
                  ),
                  child: Icon(
                    isLocked ? Icons.lock_rounded : icon,
                    color: isLocked ? AppConstants.coinGold : accentColor,
                    size: isLocked ? 17 : 19,
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),

            // 2. Mode Title & Tactical Objective
            Text(
              title,
              style: const TextStyle(
                fontSize: 15,
                fontWeight: FontWeight.w900,
                color: Colors.white,
                letterSpacing: 0.8,
              ),
            ),
            const SizedBox(height: 2),
            Text(
              objective,
              style: const TextStyle(
                fontSize: 10,
                color: Colors.white54,
                height: 1.2,
              ),
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
            ),
            const SizedBox(height: 8),

            // 3. Map & Sector Telemetry Banner
            Container(
              width: double.infinity,
              padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 5),
              decoration: BoxDecoration(
                color: const Color(0xFF161E2E),
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Colors.white10),
              ),
              child: Row(
                children: [
                  Icon(
                    isLocked ? Icons.lock_outline_rounded : Icons.radar_rounded,
                    color: isLocked ? AppConstants.coinGold : accentColor,
                    size: 14,
                  ),
                  const SizedBox(width: 6),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          mapName,
                          style: TextStyle(
                            fontSize: 9.5,
                            fontWeight: FontWeight.w900,
                            color: isLocked
                                ? AppConstants.coinGold
                                : accentColor,
                            letterSpacing: 0.6,
                          ),
                          maxLines: 1,
                          overflow: TextOverflow.ellipsis,
                        ),
                        Text(
                          mapSector,
                          style: const TextStyle(
                            fontSize: 8.5,
                            fontWeight: FontWeight.bold,
                            color: Colors.white54,
                            letterSpacing: 0.4,
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
            const SizedBox(height: 6),

            // 4. Hazard Intel Tags
            Row(
              children: [
                const Icon(
                  Icons.warning_amber_rounded,
                  color: Colors.white38,
                  size: 11,
                ),
                const SizedBox(width: 4),
                Text(
                  context.l10n.tr('hazards_label'),
                  style: const TextStyle(
                    fontSize: 8,
                    fontWeight: FontWeight.w900,
                    color: Colors.white38,
                    letterSpacing: 0.5,
                  ),
                ),
                const SizedBox(width: 5),
                Expanded(
                  child: SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    child: Row(
                      children: hazardTags.map((hazard) {
                        return Container(
                          margin: const EdgeInsets.only(right: 4),
                          padding: const EdgeInsets.symmetric(
                            horizontal: 5,
                            vertical: 2,
                          ),
                          decoration: BoxDecoration(
                            color: Colors.white.withValues(alpha: 0.06),
                            borderRadius: BorderRadius.circular(4),
                            border: Border.all(color: Colors.white12),
                          ),
                          child: Text(
                            hazard,
                            style: const TextStyle(
                              fontSize: 7.5,
                              fontWeight: FontWeight.bold,
                              color: Colors.white70,
                              letterSpacing: 0.3,
                            ),
                          ),
                        );
                      }).toList(),
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),

            // 5. Threat Level & Best Record Pill OR Unlock Pill
            Container(
              width: double.infinity,
              padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 6),
              decoration: BoxDecoration(
                color: const Color(0xFF161E2E),
                borderRadius: BorderRadius.circular(10),
                border: Border.all(color: Colors.white12),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  // Threat level with indicator dot
                  Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 6,
                        height: 6,
                        decoration: BoxDecoration(
                          color: threatColor,
                          shape: BoxShape.circle,
                          boxShadow: [
                            BoxShadow(
                              color: threatColor.withValues(alpha: 0.8),
                              blurRadius: 4,
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(width: 5),
                      Text(
                        threatLevel,
                        style: TextStyle(
                          fontSize: 9,
                          fontWeight: FontWeight.w900,
                          color: threatColor,
                          letterSpacing: 0.5,
                        ),
                      ),
                    ],
                  ),

                  // Best score record OR Unlock CTA
                  if (isLocked)
                    Container(
                      padding: const EdgeInsets.symmetric(
                        horizontal: 8,
                        vertical: 3,
                      ),
                      decoration: BoxDecoration(
                        color: AppConstants.coinGold.withValues(alpha: 0.2),
                        borderRadius: BorderRadius.circular(6),
                        border: Border.all(
                          color: AppConstants.coinGold.withValues(alpha: 0.6),
                        ),
                      ),
                      child: const Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Icon(
                            Icons.key_rounded,
                            color: AppConstants.coinGold,
                            size: 11,
                          ),
                          SizedBox(width: 4),
                          Text(
                            'UNLOCK MAP',
                            style: TextStyle(
                              fontSize: 9,
                              fontWeight: FontWeight.w900,
                              color: AppConstants.coinGold,
                              letterSpacing: 0.6,
                            ),
                          ),
                        ],
                      ),
                    )
                  else
                    Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        const Icon(
                          Icons.emoji_events_outlined,
                          color: AppConstants.coinGold,
                          size: 13,
                        ),
                        const SizedBox(width: 4),
                        Text(
                          '${bestScore}M',
                          style: const TextStyle(
                            fontSize: 10,
                            fontWeight: FontWeight.w900,
                            color: Colors.white,
                            letterSpacing: 0.5,
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
    );
  }

  void _promptMapUnlock({
    required BuildContext context,
    required SaveService saveService,
    required String modeTitle,
    required String modeSubtitle,
    required int unlockCost,
    required bool Function() onUnlock,
    required String successMessage,
  }) {
    AudioService().playClick();
    final currentCP = saveService.player.cubePoints.value;
    final canAfford = currentCP >= unlockCost;
    final formattedCost = unlockCost.toString().replaceAllMapped(
      RegExp(r'(\d{1,3})(?=(\d{3})+(?!\d))'),
      (m) => '${m[1]},',
    );
    final neededCP = (unlockCost - currentCP).toString().replaceAllMapped(
      RegExp(r'(\d{1,3})(?=(\d{3})+(?!\d))'),
      (m) => '${m[1]},',
    );

    showDialog(
      context: context,
      barrierDismissible: true,
      builder: (dialogCtx) {
        return Dialog(
          backgroundColor: Colors.transparent,
          insetPadding: const EdgeInsets.symmetric(
            horizontal: 40,
            vertical: 24,
          ),
          child: Container(
            width: 460,
            padding: const EdgeInsets.all(22),
            decoration: BoxDecoration(
              color: const Color(0xFF0C101A),
              borderRadius: BorderRadius.circular(20),
              border: Border.all(
                color: canAfford
                    ? AppConstants.coinGold.withValues(alpha: 0.6)
                    : AppConstants.hazardRed.withValues(alpha: 0.6),
                width: 1.5,
              ),
              boxShadow: [
                BoxShadow(
                  color:
                      (canAfford
                              ? AppConstants.coinGold
                              : AppConstants.hazardRed)
                          .withValues(alpha: 0.2),
                  blurRadius: 20,
                  spreadRadius: 2,
                ),
              ],
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                // Top Tag
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Container(
                      padding: const EdgeInsets.symmetric(
                        horizontal: 8,
                        vertical: 4,
                      ),
                      decoration: BoxDecoration(
                        color: AppConstants.hazardRed.withValues(alpha: 0.15),
                        borderRadius: BorderRadius.circular(6),
                        border: Border.all(
                          color: AppConstants.hazardRed.withValues(alpha: 0.5),
                        ),
                      ),
                      child: const Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Icon(
                            Icons.security_rounded,
                            size: 12,
                            color: AppConstants.hazardRed,
                          ),
                          SizedBox(width: 5),
                          Text(
                            'SECTOR CLEARANCE REQUIRED',
                            style: TextStyle(
                              fontSize: 9.5,
                              fontWeight: FontWeight.w900,
                              color: AppConstants.hazardRed,
                              letterSpacing: 1.0,
                            ),
                          ),
                        ],
                      ),
                    ),
                    const Icon(
                      Icons.lock_outline_rounded,
                      color: AppConstants.coinGold,
                      size: 18,
                    ),
                  ],
                ),
                const SizedBox(height: 14),

                // Title
                Text(
                  modeTitle,
                  style: const TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.w900,
                    color: Colors.white,
                    letterSpacing: 1.0,
                  ),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 4),
                Text(
                  modeSubtitle,
                  style: TextStyle(
                    fontSize: 10,
                    fontWeight: FontWeight.w600,
                    color: AppConstants.hazardRed.withValues(alpha: 0.8),
                    letterSpacing: 1.2,
                  ),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 16),

                // Telemetry Card
                Container(
                  padding: const EdgeInsets.all(14),
                  decoration: BoxDecoration(
                    color: const Color(0xFF131926),
                    borderRadius: BorderRadius.circular(12),
                    border: Border.all(color: Colors.white12),
                  ),
                  child: Column(
                    children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          const Text(
                            'UNLOCK CLEARANCE FEE:',
                            style: TextStyle(
                              fontSize: 11,
                              fontWeight: FontWeight.bold,
                              color: Colors.white60,
                            ),
                          ),
                          Text(
                            '$formattedCost CP',
                            style: const TextStyle(
                              fontSize: 13,
                              fontWeight: FontWeight.w900,
                              color: AppConstants.coinGold,
                            ),
                          ),
                        ],
                      ),
                      const Divider(color: Colors.white10, height: 16),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          const Text(
                            'YOUR CURRENT BALANCE:',
                            style: TextStyle(
                              fontSize: 11,
                              fontWeight: FontWeight.bold,
                              color: Colors.white60,
                            ),
                          ),
                          Text(
                            '$currentCP CP',
                            style: TextStyle(
                              fontSize: 12,
                              fontWeight: FontWeight.w900,
                              color: canAfford
                                  ? const Color(0xFF00FF88)
                                  : AppConstants.hazardRed,
                            ),
                          ),
                        ],
                      ),
                      if (!canAfford) ...[
                        const SizedBox(height: 6),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            const Text(
                              'ADDITIONAL CP NEEDED:',
                              style: TextStyle(
                                fontSize: 10,
                                fontWeight: FontWeight.bold,
                                color: AppConstants.hazardRed,
                              ),
                            ),
                            Text(
                              '$neededCP CP',
                              style: const TextStyle(
                                fontSize: 11,
                                fontWeight: FontWeight.w900,
                                color: AppConstants.hazardRed,
                              ),
                            ),
                          ],
                        ),
                      ],
                    ],
                  ),
                ),
                const SizedBox(height: 18),

                // Buttons
                Row(
                  children: [
                    Expanded(
                      child: TextButton(
                        style: TextButton.styleFrom(
                          foregroundColor: Colors.white60,
                          padding: const EdgeInsets.symmetric(vertical: 12),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                            side: const BorderSide(color: Colors.white24),
                          ),
                        ),
                        onPressed: () => Navigator.of(dialogCtx).pop(),
                        child: const Text(
                          'CANCEL',
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 12,
                          ),
                        ),
                      ),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          backgroundColor: canAfford
                              ? AppConstants.coinGold
                              : const Color(0xFF161E2E),
                          foregroundColor: canAfford
                              ? Colors.black
                              : Colors.white70,
                          padding: const EdgeInsets.symmetric(vertical: 12),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                            side: BorderSide(
                              color: canAfford
                                  ? AppConstants.coinGold
                                  : Colors.white24,
                            ),
                          ),
                        ),
                        onPressed: () {
                          Navigator.of(dialogCtx).pop();
                          if (canAfford) {
                            final success = onUnlock();
                            if (success) {
                              AudioService().playCollect();
                              ScaffoldMessenger.of(context).showSnackBar(
                                SnackBar(
                                  backgroundColor: const Color(0xFF0C101A),
                                  content: Text(
                                    successMessage,
                                    style: const TextStyle(
                                      color: AppConstants.coinGold,
                                      fontWeight: FontWeight.bold,
                                    ),
                                  ),
                                ),
                              );
                            }
                          } else {
                            Navigator.of(context).push(
                              MaterialPageRoute(
                                builder: (_) => const ShopScreen(),
                              ),
                            );
                          }
                        },
                        child: Text(
                          canAfford
                              ? 'AUTHORIZE & UNLOCK'
                              : 'ACQUIRE CP (SHOP)',
                          style: const TextStyle(
                            fontWeight: FontWeight.w900,
                            fontSize: 11,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        );
      },
    );
  }

  void _promptTenXUnlock(BuildContext context, SaveService saveService) {
    _promptMapUnlock(
      context: context,
      saveService: saveService,
      modeTitle: '10X HYPER RUN // OVERCHARGED FORGE',
      modeSubtitle: 'HIGH-RISK REACTOR CORE // 10.0X CP MULTIPLIER',
      unlockCost: 50000,
      onUnlock: () => saveService.unlockTenXMode(),
      successMessage: '10X HYPER RUN MAP UNLOCKED // ACCESS GRANTED!',
    );
  }

  void _promptFlightUnlock(BuildContext context, SaveService saveService) {
    _promptMapUnlock(
      context: context,
      saveService: saveService,
      modeTitle: 'JET SHINOBI FLIGHT // STRATOSPHERE SKYWAY',
      modeSubtitle: 'AERIAL ZERO-G VECTOR // 2.5X CP MULTIPLIER',
      unlockCost: 100000,
      onUnlock: () => saveService.unlockFlightMode(),
      successMessage: 'JET SHINOBI FLIGHT UNLOCKED // ACCESS GRANTED!',
    );
  }

  Widget _buildBottomDock(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        // 1. Daily Gift Button
        _buildDockButton(
          title: context.l10n.tr('daily_crate'),
          icon: Icons.card_giftcard_rounded,
          accentColor: AppConstants.coinGold,
          onTap: () => _claimDailyGift(context),
        ),

        // 2. Skins & Arsenal Button
        _buildDockButton(
          title: context.l10n.tr('arsenal_hangar'),
          icon: Icons.shopping_bag_rounded,
          accentColor: AppConstants.stealthBlue,
          isHighlight: true,
          onTap: () {
            AudioService().playClick();
            Navigator.of(
              context,
            ).push(MaterialPageRoute(builder: (_) => const ShopScreen()));
          },
        ),

        // 3. Global Leaderboards Button
        _buildDockButton(
          title: context.l10n.tr('hall_of_fame'),
          icon: Icons.leaderboard_rounded,
          accentColor: const Color(0xFFFF007F),
          onTap: () {
            AudioService().playClick();
            Navigator.of(context).push(
              MaterialPageRoute(builder: (_) => const LeaderboardScreen()),
            );
          },
        ),
      ],
    );
  }

  Widget _buildDockButton({
    required String title,
    required IconData icon,
    required Color accentColor,
    bool isHighlight = false,
    required VoidCallback onTap,
  }) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
        decoration: BoxDecoration(
          color: isHighlight
              ? accentColor.withValues(alpha: 0.16)
              : const Color(0xFF131722),
          borderRadius: BorderRadius.circular(16),
          border: Border.all(
            color: isHighlight ? accentColor : Colors.white12,
            width: isHighlight ? 1.5 : 1.0,
          ),
          boxShadow: isHighlight
              ? [
                  BoxShadow(
                    color: accentColor.withValues(alpha: 0.22),
                    blurRadius: 10,
                  ),
                ]
              : null,
        ),
        child: Row(
          children: [
            Icon(icon, color: accentColor, size: 18),
            const SizedBox(width: 8),
            Text(
              title,
              style: TextStyle(
                fontWeight: FontWeight.w900,
                fontSize: 11,
                letterSpacing: 1.0,
                color: isHighlight ? Colors.white : Colors.white70,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
