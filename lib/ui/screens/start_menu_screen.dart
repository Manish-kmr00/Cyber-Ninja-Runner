import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:url_launcher/url_launcher.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/services/daily_crate_service.dart';
import '../../core/storage/save_service.dart';
import '../widgets/daily_crate_dialog.dart';
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
    AudioService().playClick();
    showDialog(
      context: context,
      barrierDismissible: true,
      builder: (_) => const DailyCrateDialog(),
    );
  }

  Future<void> _openDeveloperPage() async {
    AudioService().playClick();
    final Uri url = Uri.parse(
      'https://play.google.com/store/apps/developer?id=Moon+Edge+Studio',
    );
    try {
      final launched = await launchUrl(
        url,
        mode: LaunchMode.externalApplication,
      );
      if (!launched) {
        await launchUrl(url);
      }
    } catch (e) {
      debugPrint('Could not launch developer URL: $e');
    }
  }

  Future<void> _openImgResizer() async {
    AudioService().playClick();
    final Uri url = Uri.parse(
      'https://play.google.com/store/apps/details?id=com.moonedgestudio.imageresizer',
    );
    try {
      final launched = await launchUrl(
        url,
        mode: LaunchMode.externalApplication,
      );
      if (!launched) {
        await launchUrl(url);
      }
    } catch (e) {
      debugPrint('Could not launch Img Resizer URL: $e');
    }
  }

  void _showStudioDialog(BuildContext context) {
    showDialog(
      context: context,
      barrierDismissible: true,
      builder: (dialogCtx) {
        return Dialog(
          backgroundColor: Colors.transparent,
          insetPadding: const EdgeInsets.symmetric(
            horizontal: 24,
            vertical: 16,
          ),
          child: Container(
            width: 480,
            constraints: const BoxConstraints(maxHeight: 360),
            padding: const EdgeInsets.all(20),
            decoration: BoxDecoration(
              color: const Color(0xFF0D0F18),
              borderRadius: BorderRadius.circular(22),
              border: Border.all(
                color: const Color(0xFFFF007F).withValues(alpha: 0.65),
                width: 1.5,
              ),
              boxShadow: [
                BoxShadow(
                  color: const Color(0xFFFF007F).withValues(alpha: 0.25),
                  blurRadius: 24,
                  spreadRadius: 2,
                ),
              ],
            ),
            child: SingleChildScrollView(
              physics: const BouncingScrollPhysics(),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  // Top Header Row
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 10,
                          vertical: 4,
                        ),
                        decoration: BoxDecoration(
                          color: const Color(
                            0xFFFF007F,
                          ).withValues(alpha: 0.15),
                          borderRadius: BorderRadius.circular(8),
                          border: Border.all(
                            color: const Color(
                              0xFFFF007F,
                            ).withValues(alpha: 0.5),
                          ),
                        ),
                        child: const Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            Icon(
                              Icons.verified_rounded,
                              color: Color(0xFFFF007F),
                              size: 14,
                            ),
                            SizedBox(width: 6),
                            Text(
                              'OFFICIAL DEVELOPER',
                              style: TextStyle(
                                fontSize: 10,
                                fontWeight: FontWeight.w900,
                                color: Color(0xFFFF007F),
                                letterSpacing: 1.2,
                              ),
                            ),
                          ],
                        ),
                      ),
                      IconButton(
                        icon: const Icon(
                          Icons.close_rounded,
                          color: Colors.white60,
                          size: 20,
                        ),
                        padding: EdgeInsets.zero,
                        constraints: const BoxConstraints(),
                        onPressed: () => Navigator.of(dialogCtx).pop(),
                      ),
                    ],
                  ),

                  const SizedBox(height: 14),

                  // Studio Emblem / Logo
                  Container(
                    width: 58,
                    height: 58,
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      gradient: const LinearGradient(
                        colors: [Color(0xFFFF007F), Color(0xFF7928CA)],
                        begin: Alignment.topLeft,
                        end: Alignment.bottomRight,
                      ),
                      boxShadow: [
                        BoxShadow(
                          color: const Color(0xFFFF007F).withValues(alpha: 0.4),
                          blurRadius: 16,
                        ),
                      ],
                    ),
                    child: const Center(
                      child: Icon(
                        Icons.nightlight_round,
                        color: Colors.white,
                        size: 30,
                      ),
                    ),
                  ),

                  const SizedBox(height: 10),

                  // Studio Title
                  const Text(
                    'MOON EDGE STUDIO',
                    style: TextStyle(
                      fontSize: 19,
                      fontWeight: FontWeight.w900,
                      color: Colors.white,
                      letterSpacing: 1.8,
                    ),
                  ),
                  const SizedBox(height: 3),
                  const Text(
                    'INNOVATIVE MOBILE GAMING & ACTION EXPERIENCES',
                    textAlign: TextAlign.center,
                    style: TextStyle(
                      fontSize: 8.5,
                      fontWeight: FontWeight.w700,
                      color: AppConstants.stealthBlue,
                      letterSpacing: 1.3,
                    ),
                  ),

                  const SizedBox(height: 12),

                  // Description Box
                  Container(
                    width: double.infinity,
                    padding: const EdgeInsets.symmetric(
                      horizontal: 14,
                      vertical: 10,
                    ),
                    decoration: BoxDecoration(
                      color: const Color(0xFF141724),
                      borderRadius: BorderRadius.circular(12),
                      border: Border.all(color: Colors.white10),
                    ),
                    child: const Text(
                      'Explore our full catalog of games, updates, and upcoming releases directly on Google Play Store.',
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 11.5,
                        color: Colors.white70,
                        height: 1.35,
                      ),
                    ),
                  ),

                  const SizedBox(height: 16),

                  // Action Button
                  GestureDetector(
                    behavior: HitTestBehavior.opaque,
                    onTap: () {
                      AudioService().playClick();
                      _openDeveloperPage();
                    },
                    child: Container(
                      width: double.infinity,
                      padding: const EdgeInsets.symmetric(vertical: 12),
                      decoration: BoxDecoration(
                        gradient: const LinearGradient(
                          colors: [Color(0xFFFF007F), Color(0xFFE0006C)],
                        ),
                        borderRadius: BorderRadius.circular(12),
                        boxShadow: [
                          BoxShadow(
                            color: const Color(
                              0xFFFF007F,
                            ).withValues(alpha: 0.4),
                            blurRadius: 12,
                          ),
                        ],
                      ),
                      child: const Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Icon(
                            Icons.shop_2_rounded,
                            color: Colors.white,
                            size: 18,
                          ),
                          SizedBox(width: 8),
                          Text(
                            'VIEW ON GOOGLE PLAY',
                            style: TextStyle(
                              fontSize: 12.5,
                              fontWeight: FontWeight.w900,
                              color: Colors.white,
                              letterSpacing: 1.0,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        );
      },
    );
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
            child: LayoutBuilder(
              builder: (context, constraints) {
                final isCompact = constraints.maxHeight < 390;
                final isUltraCompact = constraints.maxHeight < 340;

                return Padding(
                  padding: EdgeInsets.symmetric(
                    horizontal: isCompact ? 16 : 22,
                    vertical: isUltraCompact ? 4 : (isCompact ? 6 : 14),
                  ),
                  child: Column(
                    children: [
                      // 1. Top Bar: Game Title & Utility Actions
                      _buildHeader(context, player, isCompact: isCompact),
                      SizedBox(
                        height: isUltraCompact ? 3 : (isCompact ? 5 : 12),
                      ),

                      // 2. Active Operative Status Badge
                      _buildOperativeBadge(context, isCompact: isCompact),

                      // 3. Center: Holographic Mode Selection Carousel (Adaptive Auto-Scale)
                      Expanded(
                        child: Padding(
                          padding: EdgeInsets.symmetric(
                            vertical: isUltraCompact ? 2 : (isCompact ? 4 : 8),
                          ),
                          child: Center(
                            child: FittedBox(
                              fit: BoxFit.scaleDown,
                              alignment: Alignment.center,
                              child: _buildModeCarousel(
                                context,
                                saveService,
                                isCompact: isCompact,
                              ),
                            ),
                          ),
                        ),
                      ),

                      // 4. Bottom Utility Dock: Daily Crate, Arsenal & Hangar, Moon Edge Studio
                      _buildBottomDock(context, isCompact: isCompact),
                    ],
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildHeader(
    BuildContext context,
    dynamic player, {
    bool isCompact = false,
  }) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        // Cyberpunk Title Lockup
        Row(
          children: [
            Container(
              width: isCompact ? 3.5 : 4,
              height: isCompact ? 28 : 36,
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
            SizedBox(width: isCompact ? 8 : 12),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Text(
                      context.l10n.tr('game_title_cyber'),
                      style: TextStyle(
                        fontSize: isCompact ? 18 : 22,
                        fontWeight: FontWeight.w900,
                        color: AppConstants.stealthBlue,
                        letterSpacing: isCompact ? 1.5 : 2.0,
                        height: 1.0,
                      ),
                    ),
                    const SizedBox(width: 6),
                    Text(
                      context.l10n.tr('game_title_runner'),
                      style: TextStyle(
                        fontSize: isCompact ? 18 : 22,
                        fontWeight: FontWeight.w900,
                        color: Colors.white,
                        letterSpacing: isCompact ? 1.5 : 2.0,
                        height: 1.0,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: isCompact ? 2 : 3),
                Text(
                  context.l10n.tr('game_protocol'),
                  style: TextStyle(
                    fontSize: isCompact ? 7.5 : 9,
                    fontWeight: FontWeight.bold,
                    color: Colors.white38,
                    letterSpacing: isCompact ? 1.8 : 2.5,
                  ),
                ),
              ],
            ),
          ],
        ),

        // Header Actions: Img Resizer, CP Counter & Settings/Leaderboard
        Row(
          children: [
            // Also Try Now: Img Resizer
            _buildImgResizerButton(isCompact: isCompact),
            SizedBox(width: isCompact ? 6 : 10),

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
                padding: EdgeInsets.symmetric(
                  horizontal: isCompact ? 10 : 14,
                  vertical: isCompact ? 5 : 7,
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
                    Icon(
                      Icons.diamond,
                      color: AppConstants.coinGold,
                      size: isCompact ? 14 : 17,
                    ),
                    SizedBox(width: isCompact ? 4 : 6),
                    Text(
                      '${player.cyberPoints.value}',
                      style: TextStyle(
                        fontSize: isCompact ? 12 : 14,
                        fontWeight: FontWeight.w900,
                        color: AppConstants.coinGold,
                        letterSpacing: 0.5,
                      ),
                    ),
                  ],
                ),
              ),
            ),
            SizedBox(width: isCompact ? 6 : 10),

            // Leaderboard
            _buildRoundIconButton(
              icon: Icons.leaderboard_rounded,
              color: AppConstants.stealthBlue,
              isCompact: isCompact,
              onTap: () {
                AudioService().playClick();
                Navigator.of(context).push(
                  MaterialPageRoute(builder: (_) => const LeaderboardScreen()),
                );
              },
            ),
            SizedBox(width: isCompact ? 6 : 8),

            // Settings
            _buildRoundIconButton(
              icon: Icons.tune_rounded,
              color: Colors.white70,
              isCompact: isCompact,
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

  Widget _buildImgResizerButton({bool isCompact = false}) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: _openImgResizer,
      child: Container(
        padding: EdgeInsets.symmetric(
          horizontal: isCompact ? 8 : 11,
          vertical: isCompact ? 4.5 : 6.5,
        ),
        decoration: BoxDecoration(
          gradient: const LinearGradient(
            colors: [Color(0xFF0D2338), Color(0xFF131A28)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
          borderRadius: BorderRadius.circular(20),
          border: Border.all(
            color: const Color(0xFF00C6FF).withValues(alpha: 0.75),
            width: 1.2,
          ),
          boxShadow: [
            BoxShadow(
              color: const Color(0xFF00C6FF).withValues(alpha: 0.22),
              blurRadius: 8,
              spreadRadius: 0.5,
            ),
          ],
        ),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              padding: EdgeInsets.all(isCompact ? 2.5 : 3.5),
              decoration: const BoxDecoration(
                shape: BoxShape.circle,
                gradient: LinearGradient(
                  colors: [Color(0xFF0072FF), Color(0xFF00C6FF)],
                ),
              ),
              child: Icon(
                Icons.auto_fix_high_rounded,
                color: Colors.white,
                size: isCompact ? 9 : 11,
              ),
            ),
            SizedBox(width: isCompact ? 4 : 6),
            Text(
              'TRY: IMG RESIZER',
              style: TextStyle(
                fontSize: isCompact ? 9 : 10.5,
                fontWeight: FontWeight.w900,
                color: Colors.white,
                letterSpacing: 0.6,
              ),
            ),
            SizedBox(width: isCompact ? 3 : 4),
            Icon(
              Icons.open_in_new_rounded,
              color: const Color(0xFF00C6FF).withValues(alpha: 0.85),
              size: isCompact ? 9 : 11,
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildRoundIconButton({
    required IconData icon,
    required Color color,
    required VoidCallback onTap,
    bool isCompact = false,
  }) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Container(
        width: isCompact ? 32 : 38,
        height: isCompact ? 32 : 38,
        decoration: BoxDecoration(
          color: const Color(0xFF131722),
          borderRadius: BorderRadius.circular(isCompact ? 10 : 12),
          border: Border.all(color: Colors.white12),
        ),
        child: Center(
          child: Icon(icon, color: color, size: isCompact ? 16 : 19),
        ),
      ),
    );
  }

  Widget _buildOperativeBadge(BuildContext context, {bool isCompact = false}) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: () {
        AudioService().playClick();
        Navigator.of(
          context,
        ).push(MaterialPageRoute(builder: (_) => const ShopScreen()));
      },
      child: Container(
        padding: EdgeInsets.symmetric(
          horizontal: isCompact ? 12 : 18,
          vertical: isCompact ? 4.5 : 8,
        ),
        decoration: BoxDecoration(
          color: const Color(0xFF0F1522),
          borderRadius: BorderRadius.circular(isCompact ? 12 : 16),
          border: Border.all(
            color: AppConstants.stealthBlue.withValues(alpha: 0.45),
            width: 1.2,
          ),
          boxShadow: [
            BoxShadow(
              color: AppConstants.stealthBlue.withValues(alpha: 0.15),
              blurRadius: isCompact ? 6 : 10,
            ),
          ],
        ),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(
              Icons.sports_martial_arts_rounded,
              color: AppConstants.stealthBlue,
              size: isCompact ? 14 : 18,
            ),
            SizedBox(width: isCompact ? 6 : 8),
            Text(
              context.l10n.tr('active_operative'),
              style: TextStyle(
                fontWeight: FontWeight.w900,
                fontSize: isCompact ? 9.5 : 11,
                letterSpacing: isCompact ? 1.0 : 1.4,
                color: Colors.white,
              ),
            ),
            SizedBox(width: isCompact ? 6 : 8),
            Container(
              padding: EdgeInsets.symmetric(
                horizontal: isCompact ? 5 : 6,
                vertical: isCompact ? 1.5 : 2,
              ),
              decoration: BoxDecoration(
                color: AppConstants.stealthBlue.withValues(alpha: 0.2),
                borderRadius: BorderRadius.circular(isCompact ? 4 : 6),
              ),
              child: Text(
                context.l10n.tr('deployed'),
                style: TextStyle(
                  fontSize: isCompact ? 8 : 9,
                  fontWeight: FontWeight.w900,
                  color: AppConstants.stealthBlue,
                  letterSpacing: 0.8,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildModeCarousel(
    BuildContext context,
    SaveService saveService, {
    bool isCompact = false,
  }) {
    final isTenXUnlocked = saveService.player.isTenXUnlocked;
    final isFlightUnlocked = saveService.player.isFlightUnlocked;
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      physics: const BouncingScrollPhysics(),
      child: Row(
        mainAxisSize: MainAxisSize.min,
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
            isCompact: isCompact,
            onTap: () => _launchGame(context, GameMode.run),
          ),
          SizedBox(width: isCompact ? 12 : 16),
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
            isCompact: isCompact,
            onTap: isTenXUnlocked
                ? () => _launchGame(context, GameMode.tenXChallenge)
                : () => _promptTenXUnlock(context, saveService),
          ),
          SizedBox(width: isCompact ? 12 : 16),
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
            bestScore: saveService.stats.bestDistanceFlight,
            isLocked: !isFlightUnlocked,
            unlockPrice: 100000,
            isCompact: isCompact,
            onTap: isFlightUnlocked
                ? () => _launchGame(context, GameMode.flightRunner)
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
    bool isCompact = false,
  }) {
    final formattedPrice = unlockPrice.toString().replaceAllMapped(
      RegExp(r'(\d{1,3})(?=(\d{3})+(?!\d))'),
      (m) => '${m[1]},',
    );
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Container(
        width: isCompact ? 260 : 290,
        padding: EdgeInsets.symmetric(
          horizontal: isCompact ? 12 : 16,
          vertical: isCompact ? 8 : 13,
        ),
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: isLocked
                ? const [Color(0xFF15141E), Color(0xFF0D0C14)]
                : const [Color(0xFF131926), Color(0xFF0C101A)],
          ),
          borderRadius: BorderRadius.circular(isCompact ? 16 : 20),
          border: Border.all(
            color: isLocked
                ? AppConstants.coinGold.withValues(alpha: 0.5)
                : accentColor.withValues(alpha: 0.45),
            width: isCompact ? 1.2 : 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: isLocked
                  ? AppConstants.coinGold.withValues(alpha: 0.15)
                  : accentColor.withValues(alpha: 0.14),
              blurRadius: isCompact ? 10 : 16,
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
                      padding: EdgeInsets.symmetric(
                        horizontal: isCompact ? 6 : 8,
                        vertical: isCompact ? 2.5 : 3.5,
                      ),
                      decoration: BoxDecoration(
                        color: (isLocked ? AppConstants.hazardRed : accentColor)
                            .withValues(alpha: 0.18),
                        borderRadius: BorderRadius.circular(isCompact ? 5 : 6),
                        border: Border.all(
                          color:
                              (isLocked ? AppConstants.hazardRed : accentColor)
                                  .withValues(alpha: 0.4),
                        ),
                      ),
                      child: Text(
                        tag,
                        style: TextStyle(
                          fontSize: isCompact ? 8 : 9,
                          fontWeight: FontWeight.w900,
                          color: isLocked
                              ? AppConstants.hazardRed
                              : accentColor,
                          letterSpacing: 0.8,
                        ),
                      ),
                    ),
                    SizedBox(width: isCompact ? 4 : 6),
                    if (isLocked)
                      Container(
                        padding: EdgeInsets.symmetric(
                          horizontal: isCompact ? 5 : 7,
                          vertical: isCompact ? 2.5 : 3.5,
                        ),
                        decoration: BoxDecoration(
                          color: AppConstants.coinGold.withValues(alpha: 0.18),
                          borderRadius: BorderRadius.circular(
                            isCompact ? 5 : 6,
                          ),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(alpha: 0.5),
                          ),
                        ),
                        child: Row(
                          children: [
                            Icon(
                              Icons.lock_rounded,
                              color: AppConstants.coinGold,
                              size: isCompact ? 9.5 : 11,
                            ),
                            const SizedBox(width: 3),
                            Text(
                              '$formattedPrice CP',
                              style: TextStyle(
                                fontSize: isCompact ? 8 : 9,
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
                        padding: EdgeInsets.symmetric(
                          horizontal: isCompact ? 5 : 7,
                          vertical: isCompact ? 2.5 : 3.5,
                        ),
                        decoration: BoxDecoration(
                          color: AppConstants.coinGold.withValues(alpha: 0.16),
                          borderRadius: BorderRadius.circular(
                            isCompact ? 5 : 6,
                          ),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(
                              alpha: 0.35,
                            ),
                          ),
                        ),
                        child: Row(
                          children: [
                            Icon(
                              Icons.bolt,
                              color: AppConstants.coinGold,
                              size: isCompact ? 9.5 : 11,
                            ),
                            const SizedBox(width: 2),
                            Text(
                              rewardMultiplier,
                              style: TextStyle(
                                fontSize: isCompact ? 8 : 9,
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
                  width: isCompact ? 28 : 34,
                  height: isCompact ? 28 : 34,
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
                    size: isLocked
                        ? (isCompact ? 14 : 17)
                        : (isCompact ? 16 : 19),
                  ),
                ),
              ],
            ),
            SizedBox(height: isCompact ? 4 : 8),

            // 2. Mode Title & Tactical Objective
            Text(
              title,
              style: TextStyle(
                fontSize: isCompact ? 13.5 : 15,
                fontWeight: FontWeight.w900,
                color: Colors.white,
                letterSpacing: 0.8,
              ),
            ),
            SizedBox(height: isCompact ? 1.5 : 2),
            Text(
              objective,
              style: TextStyle(
                fontSize: isCompact ? 8.5 : 10,
                color: Colors.white54,
                height: 1.15,
              ),
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
            ),
            SizedBox(height: isCompact ? 4 : 8),

            // 3. Map & Sector Telemetry Banner
            Container(
              width: double.infinity,
              padding: EdgeInsets.symmetric(
                horizontal: isCompact ? 6 : 8,
                vertical: isCompact ? 3.5 : 5,
              ),
              decoration: BoxDecoration(
                color: const Color(0xFF161E2E),
                borderRadius: BorderRadius.circular(isCompact ? 6 : 8),
                border: Border.all(color: Colors.white10),
              ),
              child: Row(
                children: [
                  Icon(
                    isLocked ? Icons.lock_outline_rounded : Icons.radar_rounded,
                    color: isLocked ? AppConstants.coinGold : accentColor,
                    size: isCompact ? 12 : 14,
                  ),
                  SizedBox(width: isCompact ? 4 : 6),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          mapName,
                          style: TextStyle(
                            fontSize: isCompact ? 8.5 : 9.5,
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
                          style: TextStyle(
                            fontSize: isCompact ? 7.5 : 8.5,
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
            SizedBox(height: isCompact ? 3 : 6),

            // 4. Hazard Intel Tags
            Row(
              children: [
                Icon(
                  Icons.warning_amber_rounded,
                  color: Colors.white38,
                  size: isCompact ? 9.5 : 11,
                ),
                const SizedBox(width: 4),
                Text(
                  context.l10n.tr('hazards_label'),
                  style: TextStyle(
                    fontSize: isCompact ? 7 : 8,
                    fontWeight: FontWeight.w900,
                    color: Colors.white38,
                    letterSpacing: 0.5,
                  ),
                ),
                SizedBox(width: isCompact ? 4 : 5),
                Expanded(
                  child: SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    child: Row(
                      children: hazardTags.map((hazard) {
                        return Container(
                          margin: const EdgeInsets.only(right: 4),
                          padding: EdgeInsets.symmetric(
                            horizontal: isCompact ? 3.5 : 5,
                            vertical: isCompact ? 1.5 : 2,
                          ),
                          decoration: BoxDecoration(
                            color: Colors.white.withValues(alpha: 0.06),
                            borderRadius: BorderRadius.circular(3),
                            border: Border.all(color: Colors.white12),
                          ),
                          child: Text(
                            hazard,
                            style: TextStyle(
                              fontSize: isCompact ? 6.5 : 7.5,
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
            SizedBox(height: isCompact ? 4 : 8),

            // 5. Threat Level & Best Record Pill OR Unlock Pill
            Container(
              width: double.infinity,
              padding: EdgeInsets.symmetric(
                horizontal: isCompact ? 7 : 10,
                vertical: isCompact ? 3.5 : 6,
              ),
              decoration: BoxDecoration(
                color: const Color(0xFF161E2E),
                borderRadius: BorderRadius.circular(isCompact ? 8 : 10),
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
                        width: isCompact ? 5 : 6,
                        height: isCompact ? 5 : 6,
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
                          fontSize: isCompact ? 8 : 9,
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
                      padding: EdgeInsets.symmetric(
                        horizontal: isCompact ? 6 : 8,
                        vertical: isCompact ? 2 : 3,
                      ),
                      decoration: BoxDecoration(
                        color: AppConstants.coinGold.withValues(alpha: 0.2),
                        borderRadius: BorderRadius.circular(5),
                        border: Border.all(
                          color: AppConstants.coinGold.withValues(alpha: 0.6),
                        ),
                      ),
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Icon(
                            Icons.key_rounded,
                            color: AppConstants.coinGold,
                            size: isCompact ? 9 : 11,
                          ),
                          const SizedBox(width: 4),
                          Text(
                            'UNLOCK MAP',
                            style: TextStyle(
                              fontSize: isCompact ? 7.5 : 9,
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
                        Icon(
                          Icons.emoji_events_outlined,
                          color: AppConstants.coinGold,
                          size: isCompact ? 11 : 13,
                        ),
                        const SizedBox(width: 4),
                        Text(
                          '${bestScore}M',
                          style: TextStyle(
                            fontSize: isCompact ? 8.5 : 10,
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
    final currentCP = saveService.player.cyberPoints.value;
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
            child: SingleChildScrollView(
              physics: const BouncingScrollPhysics(),
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
                            color: AppConstants.hazardRed.withValues(
                              alpha: 0.5,
                            ),
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

  Widget _buildBottomDock(BuildContext context, {bool isCompact = false}) {
    final saveService = context.watch<SaveService>();
    final isCrateReady = DailyCrateService().isCrateReady(saveService);

    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        // 1. Daily Gift Button
        _buildDockButton(
          title: context.l10n.tr('daily_crate'),
          icon: Icons.card_giftcard_rounded,
          accentColor: AppConstants.coinGold,
          showBadge: isCrateReady,
          isCompact: isCompact,
          onTap: () => _claimDailyGift(context),
        ),

        // 2. Skins & Arsenal Button
        _buildDockButton(
          title: context.l10n.tr('arsenal_hangar'),
          icon: Icons.shopping_bag_rounded,
          accentColor: AppConstants.stealthBlue,
          isHighlight: true,
          isCompact: isCompact,
          onTap: () {
            AudioService().playClick();
            Navigator.of(
              context,
            ).push(MaterialPageRoute(builder: (_) => const ShopScreen()));
          },
        ),

        // 3. Moon Edge Studio Developer Page
        _buildStudioDockButton(context, isCompact: isCompact),
      ],
    );
  }

  Widget _buildStudioDockButton(
    BuildContext context, {
    bool isCompact = false,
  }) {
    return AnimatedBuilder(
      animation: _pulseController,
      builder: (context, child) {
        final glowAlpha = 0.20 + 0.15 * _pulseController.value;
        return GestureDetector(
          behavior: HitTestBehavior.opaque,
          onTap: () {
            AudioService().playClick();
            _showStudioDialog(context);
          },
          child: Container(
            padding: EdgeInsets.symmetric(
              horizontal: isCompact ? 10 : 14,
              vertical: isCompact ? 6 : 8,
            ),
            decoration: BoxDecoration(
              gradient: const LinearGradient(
                colors: [Color(0xFF26102E), Color(0xFF131722)],
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
              ),
              borderRadius: BorderRadius.circular(isCompact ? 12 : 16),
              border: Border.all(
                color: Color.lerp(
                  const Color(0xFFFF007F),
                  const Color(0xFFA855F7),
                  _pulseController.value,
                )!,
                width: isCompact ? 1.2 : 1.5,
              ),
              boxShadow: [
                BoxShadow(
                  color: const Color(0xFFFF007F).withValues(alpha: glowAlpha),
                  blurRadius: isCompact ? 6 : 10,
                  spreadRadius: 1,
                ),
              ],
            ),
            child: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                Container(
                  padding: EdgeInsets.all(isCompact ? 4 : 5),
                  decoration: BoxDecoration(
                    gradient: const LinearGradient(
                      colors: [Color(0xFFFF007F), Color(0xFF7928CA)],
                    ),
                    shape: BoxShape.circle,
                    boxShadow: [
                      BoxShadow(
                        color: const Color(0xFFFF007F).withValues(alpha: 0.4),
                        blurRadius: isCompact ? 4 : 6,
                      ),
                    ],
                  ),
                  child: Icon(
                    Icons.nightlight_round,
                    color: Colors.white,
                    size: isCompact ? 11 : 14,
                  ),
                ),
                SizedBox(width: isCompact ? 6 : 8),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text(
                          'MOON EDGE STUDIO',
                          style: TextStyle(
                            fontWeight: FontWeight.w900,
                            fontSize: isCompact ? 9 : 10.5,
                            letterSpacing: 0.8,
                            color: Colors.white,
                          ),
                        ),
                        const SizedBox(width: 4),
                        Icon(
                          Icons.open_in_new_rounded,
                          color: const Color(0xFFFF007F).withValues(alpha: 0.9),
                          size: isCompact ? 9.5 : 11,
                        ),
                      ],
                    ),
                    const SizedBox(height: 1),
                    Text(
                      'DEV HUB // GOOGLE PLAY',
                      style: TextStyle(
                        fontSize: isCompact ? 6.5 : 7.5,
                        fontWeight: FontWeight.w800,
                        color: const Color(0xFFFF77A9).withValues(alpha: 0.85),
                        letterSpacing: 0.8,
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

  Widget _buildDockButton({
    required String title,
    required IconData icon,
    required Color accentColor,
    bool isHighlight = false,
    bool showBadge = false,
    bool isCompact = false,
    required VoidCallback onTap,
  }) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Stack(
        clipBehavior: Clip.none,
        children: [
          Container(
            padding: EdgeInsets.symmetric(
              horizontal: isCompact ? 11 : 16,
              vertical: isCompact ? 7 : 12,
            ),
            decoration: BoxDecoration(
              color: isHighlight
                  ? accentColor.withValues(alpha: 0.16)
                  : const Color(0xFF131722),
              borderRadius: BorderRadius.circular(isCompact ? 12 : 16),
              border: Border.all(
                color: isHighlight
                    ? accentColor
                    : (showBadge
                          ? accentColor.withValues(alpha: 0.8)
                          : Colors.white12),
                width: isHighlight || showBadge ? (isCompact ? 1.2 : 1.5) : 1.0,
              ),
              boxShadow: isHighlight || showBadge
                  ? [
                      BoxShadow(
                        color: accentColor.withValues(alpha: 0.22),
                        blurRadius: isCompact ? 6 : 10,
                      ),
                    ]
                  : null,
            ),
            child: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                Icon(icon, color: accentColor, size: isCompact ? 14 : 18),
                SizedBox(width: isCompact ? 6 : 8),
                Text(
                  title,
                  style: TextStyle(
                    fontWeight: FontWeight.w900,
                    fontSize: isCompact ? 9 : 11,
                    letterSpacing: isCompact ? 0.6 : 1.0,
                    color: isHighlight ? Colors.white : Colors.white70,
                  ),
                ),
              ],
            ),
          ),
          if (showBadge)
            Positioned(
              top: isCompact ? -3 : -5,
              right: isCompact ? -3 : -5,
              child: Container(
                width: isCompact ? 12 : 14,
                height: isCompact ? 12 : 14,
                decoration: BoxDecoration(
                  color: const Color(0xFFFF2E4C),
                  shape: BoxShape.circle,
                  border: Border.all(
                    color: Colors.white,
                    width: isCompact ? 1.0 : 1.5,
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: const Color(0xFFFF2E4C).withValues(alpha: 0.6),
                      blurRadius: isCompact ? 4 : 6,
                    ),
                  ],
                ),
                child: Center(
                  child: Text(
                    '!',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: isCompact ? 7 : 8,
                      fontWeight: FontWeight.w900,
                      height: 1.0,
                    ),
                  ),
                ),
              ),
            ),
        ],
      ),
    );
  }
}
