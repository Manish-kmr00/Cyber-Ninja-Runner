import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
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
            const Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Text(
                      'CYBER',
                      style: TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.w900,
                        color: AppConstants.stealthBlue,
                        letterSpacing: 2.0,
                        height: 1.0,
                      ),
                    ),
                    SizedBox(width: 6),
                    Text(
                      'RUNNER',
                      style: TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.w900,
                        color: Colors.white,
                        letterSpacing: 2.0,
                        height: 1.0,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 3),
                Text(
                  'SHADOW & STEEL // PROTOCOL V2.5',
                  style: TextStyle(
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
            const Text(
              'ACTIVE OPERATIVE // SHADOW SHINOBI',
              style: TextStyle(
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
              child: const Text(
                'DEPLOYED',
                style: TextStyle(
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
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      physics: const BouncingScrollPhysics(),
      child: Row(
        children: [
          _buildModernModeCard(
            context,
            title: 'ENDLESS OVERDRIVE',
            subtitle: 'Survive shadows, spikes & laser drones',
            tag: 'CORE CAMPAIGN',
            icon: Icons.play_arrow_rounded,
            accentColor: AppConstants.stealthBlue,
            bestScore: saveService.stats.bestDistanceRun,
            onTap: () => _launchGame(context, GameMode.run),
          ),
          const SizedBox(width: 16),
          _buildModernModeCard(
            context,
            title: '10X HYPER RUN',
            subtitle: 'Lethal difficulty • 10x CP rewards',
            tag: 'HIGH RISK // HIGH REWARD',
            icon: Icons.flash_on_rounded,
            accentColor: AppConstants.hazardRed,
            bestScore: saveService.stats.bestDistance10x,
            onTap: () => _launchGame(context, GameMode.tenXChallenge),
          ),
          const SizedBox(width: 16),
          _buildModernModeCard(
            context,
            title: 'JET SHINOBI FLIGHT',
            subtitle: 'Aerial thrusters & laser webs',
            tag: 'AERIAL MODE',
            icon: Icons.flight_takeoff_rounded,
            accentColor: const Color(0xFFD500F9),
            bestScore: saveService.stats.bestDistanceSqubeBird,
            onTap: () => _launchGame(context, GameMode.squbeBird),
          ),
        ],
      ),
    );
  }

  Widget _buildModernModeCard(
    BuildContext context, {
    required String title,
    required String subtitle,
    required String tag,
    required IconData icon,
    required Color accentColor,
    required int bestScore,
    required VoidCallback onTap,
  }) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Container(
        width: 250,
        padding: const EdgeInsets.all(20),
        decoration: BoxDecoration(
          color: const Color(0xFF111520),
          borderRadius: BorderRadius.circular(24),
          border: Border.all(
            color: accentColor.withValues(alpha: 0.4),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: accentColor.withValues(alpha: 0.12),
              blurRadius: 16,
              spreadRadius: 1,
            ),
          ],
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Top Row: Tag & Action Icon
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 9,
                    vertical: 4,
                  ),
                  decoration: BoxDecoration(
                    color: accentColor.withValues(alpha: 0.16),
                    borderRadius: BorderRadius.circular(8),
                  ),
                  child: Text(
                    tag,
                    style: TextStyle(
                      fontSize: 9,
                      fontWeight: FontWeight.w900,
                      color: accentColor,
                      letterSpacing: 1.0,
                    ),
                  ),
                ),
                Container(
                  width: 44,
                  height: 44,
                  decoration: BoxDecoration(
                    color: accentColor.withValues(alpha: 0.15),
                    shape: BoxShape.circle,
                  ),
                  child: Icon(icon, color: accentColor, size: 24),
                ),
              ],
            ),
            const SizedBox(height: 20),

            // Mode Title & Subtitle
            Text(
              title,
              style: const TextStyle(
                fontSize: 17,
                fontWeight: FontWeight.w900,
                color: Colors.white,
                letterSpacing: 1.0,
              ),
            ),
            const SizedBox(height: 6),
            Text(
              subtitle,
              style: const TextStyle(
                fontSize: 11,
                color: Colors.white54,
                height: 1.3,
              ),
            ),
            const SizedBox(height: 20),

            // Best Distance Telemetry Pill
            Container(
              width: double.infinity,
              padding: const EdgeInsets.symmetric(vertical: 9),
              decoration: BoxDecoration(
                color: const Color(0xFF181E2C),
                borderRadius: BorderRadius.circular(12),
                border: Border.all(color: Colors.white10),
              ),
              child: Center(
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Icon(Icons.flag_rounded, color: accentColor, size: 14),
                    const SizedBox(width: 6),
                    Text(
                      'BEST RECORD: $bestScore M',
                      style: TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.w900,
                        color: accentColor,
                        letterSpacing: 0.8,
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildBottomDock(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        // 1. Daily Gift Button
        _buildDockButton(
          title: 'DAILY CRATE',
          icon: Icons.card_giftcard_rounded,
          accentColor: AppConstants.coinGold,
          onTap: () => _claimDailyGift(context),
        ),

        // 2. Skins & Arsenal Button
        _buildDockButton(
          title: 'ARSENAL & HANGAR',
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
          title: 'HALL OF FAME',
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
