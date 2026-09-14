import 'dart:async';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/monetization/cp_boost_config.dart';
import '../../core/monetization/cp_boost_service.dart';
import '../../core/monetization/monetization_analytics.dart';
import '../../core/monetization/monetization_manager.dart';
import '../../core/storage/save_service.dart';

/// Modal dialog for the CP Boost / CP Vault feature.
///
/// Presents player with real rewarded ad opportunities to earn Cyber Points,
/// displaying live cooldown timers, daily caps, and reward tiers.
class CpBoostDialog extends StatefulWidget {
  const CpBoostDialog({super.key});

  @override
  State<CpBoostDialog> createState() => _CpBoostDialogState();
}

class _CpBoostDialogState extends State<CpBoostDialog>
    with SingleTickerProviderStateMixin {
  final CpBoostService _boostService = CpBoostService();
  Timer? _tickerTimer;
  bool _isAdReady = false;
  late AnimationController _pulseController;

  @override
  void initState() {
    super.initState();

    _pulseController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1500),
    )..repeat(reverse: true);

    MonetizationAnalytics.trackEvent(AdEventType.cpBoostOpened);

    // Initial readiness check
    _checkAdReadiness();

    // 1-second periodic timer for live cooldown countdowns and readiness sync
    _tickerTimer = Timer.periodic(const Duration(seconds: 1), (_) {
      if (mounted) {
        setState(() {});
        if (!_isAdReady) {
          _checkAdReadiness();
        }
      }
    });
  }

  Future<void> _checkAdReadiness() async {
    final ready = await MonetizationManager().isRewardedReady();
    if (mounted && ready != _isAdReady) {
      setState(() {
        _isAdReady = ready;
      });
      if (ready) {
        MonetizationAnalytics.trackEvent(AdEventType.cpBoostAdLoaded);
      }
    }
  }

  @override
  void dispose() {
    _tickerTimer?.cancel();
    _pulseController.dispose();
    super.dispose();
  }

  Future<void> _onWatchAdTapped(CpBoostTier tier) async {
    AudioService().playClick();

    final saveService = context.read<SaveService>();
    final success = await _boostService.watchAndClaimReward(
      context: context,
      tier: tier,
      saveService: saveService,
    );

    if (mounted) {
      setState(() {});
      if (!success && !_isAdReady) {
        // Attempt to preload for the next try
        MonetizationManager().init();
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final player = saveService.player;
    final remainingAds = _boostService.remainingAdsToday;
    final earnedToday = _boostService.totalCpEarnedToday;
    final cooldownRemaining = _boostService.cooldownRemainingSeconds;

    return Dialog(
      backgroundColor: Colors.transparent,
      insetPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
      child: Container(
        width: 620,
        constraints: const BoxConstraints(maxHeight: 380),
        decoration: BoxDecoration(
          color: const Color(0xFF0C101A),
          borderRadius: BorderRadius.circular(20),
          border: Border.all(
            color: AppConstants.stealthBlue.withValues(alpha: 0.65),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: AppConstants.stealthBlue.withValues(alpha: 0.25),
              blurRadius: 24,
              spreadRadius: 2,
            ),
            BoxShadow(
              color: Colors.black.withValues(alpha: 0.85),
              blurRadius: 30,
            ),
          ],
        ),
        child: Column(
          children: [
            // 1. Header Bar
            _buildHeader(context),

            // 2. Metrics Bar (Current CP, Earned Today, Daily Remaining)
            _buildMetricsBar(
              currentCp: player.cyberPoints.value,
              earnedToday: earnedToday,
              remainingAds: remainingAds,
              cooldownRemaining: cooldownRemaining,
            ),

            // 3. Tiers List
            Expanded(
              child: ListView.separated(
                padding: const EdgeInsets.fromLTRB(16, 8, 16, 14),
                itemCount: CpBoostConfig.tiers.length,
                separatorBuilder: (_, _) => const SizedBox(height: 8),
                itemBuilder: (context, index) {
                  final tier = CpBoostConfig.tiers[index];
                  return _buildTierCard(tier, cooldownRemaining);
                },
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildHeader(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 18, vertical: 12),
      decoration: BoxDecoration(
        color: const Color(0xFF111728),
        borderRadius: const BorderRadius.vertical(top: Radius.circular(19)),
        border: Border(
          bottom: BorderSide(
            color: AppConstants.stealthBlue.withValues(alpha: 0.3),
            width: 1.0,
          ),
        ),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Row(
            children: [
              Container(
                padding: const EdgeInsets.all(6),
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  gradient: const LinearGradient(
                    colors: [Color(0xFF00C6FF), Color(0xFF0072FF)],
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: AppConstants.stealthBlue.withValues(alpha: 0.5),
                      blurRadius: 8,
                    ),
                  ],
                ),
                child: const Icon(
                  Icons.electric_bolt_rounded,
                  color: Colors.white,
                  size: 16,
                ),
              ),
              const SizedBox(width: 10),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisSize: MainAxisSize.min,
                children: [
                  Row(
                    children: [
                      const Text(
                        'CP BOOST',
                        style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.w900,
                          color: Colors.white,
                          letterSpacing: 1.5,
                        ),
                      ),
                      const SizedBox(width: 8),
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 6,
                          vertical: 2,
                        ),
                        decoration: BoxDecoration(
                          color: AppConstants.coinGold.withValues(alpha: 0.15),
                          borderRadius: BorderRadius.circular(6),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(alpha: 0.5),
                            width: 0.8,
                          ),
                        ),
                        child: const Text(
                          'TEST MODE',
                          style: TextStyle(
                            fontSize: 8.5,
                            fontWeight: FontWeight.w800,
                            color: AppConstants.coinGold,
                            letterSpacing: 0.8,
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 2),
                  const Text(
                    'Watch short rewards and earn Cyber Points.',
                    style: TextStyle(
                      fontSize: 10.5,
                      fontWeight: FontWeight.w600,
                      color: Colors.white60,
                      letterSpacing: 0.4,
                    ),
                  ),
                ],
              ),
            ],
          ),
          IconButton(
            icon: const Icon(
              Icons.close_rounded,
              color: Colors.white70,
              size: 20,
            ),
            padding: EdgeInsets.zero,
            constraints: const BoxConstraints(),
            onPressed: () {
              AudioService().playClick();
              Navigator.of(context).pop();
            },
          ),
        ],
      ),
    );
  }

  Widget _buildMetricsBar({
    required int currentCp,
    required int earnedToday,
    required int remainingAds,
    required int cooldownRemaining,
  }) {
    return Container(
      margin: const EdgeInsets.fromLTRB(16, 10, 16, 6),
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 8),
      decoration: BoxDecoration(
        color: const Color(0xFF141926),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: Colors.white12),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          // Current Balance
          _buildMetricItem(
            label: 'CURRENT BALANCE',
            value: '$currentCp CP',
            icon: Icons.diamond_rounded,
            iconColor: AppConstants.coinGold,
            valueColor: AppConstants.coinGold,
          ),
          _buildDivider(),
          // Earned Today
          _buildMetricItem(
            label: 'EARNED TODAY',
            value: '+$earnedToday CP',
            icon: Icons.trending_up_rounded,
            iconColor: const Color(0xFF00E676),
            valueColor: const Color(0xFF00E676),
          ),
          _buildDivider(),
          // Remaining Ads
          _buildMetricItem(
            label: 'DAILY LIMIT',
            value: '$remainingAds / ${CpBoostConfig.maxDailyAds} LEFT',
            icon: Icons.movie_filter_rounded,
            iconColor: AppConstants.stealthBlue,
            valueColor: remainingAds > 0 ? Colors.white : Colors.redAccent,
          ),
        ],
      ),
    );
  }

  Widget _buildMetricItem({
    required String label,
    required String value,
    required IconData icon,
    required Color iconColor,
    required Color valueColor,
  }) {
    return Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        Icon(icon, color: iconColor, size: 14),
        const SizedBox(width: 6),
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(
              label,
              style: const TextStyle(
                fontSize: 8,
                fontWeight: FontWeight.w700,
                color: Colors.white38,
                letterSpacing: 0.8,
              ),
            ),
            Text(
              value,
              style: TextStyle(
                fontSize: 12,
                fontWeight: FontWeight.w900,
                color: valueColor,
                letterSpacing: 0.5,
              ),
            ),
          ],
        ),
      ],
    );
  }

  Widget _buildDivider() {
    return Container(width: 1, height: 24, color: Colors.white10);
  }

  Widget _buildTierCard(CpBoostTier tier, int cooldownRemaining) {
    final buttonState = _boostService.getButtonState(
      tierId: tier.id,
      isAdReady: _isAdReady,
    );

    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 10),
      decoration: BoxDecoration(
        color: const Color(0xFF131828),
        borderRadius: BorderRadius.circular(14),
        border: Border.all(
          color: _isHighlighted(tier)
              ? AppConstants.coinGold.withValues(alpha: 0.45)
              : Colors.white10,
          width: 1.1,
        ),
        boxShadow: [
          if (_isHighlighted(tier))
            BoxShadow(
              color: AppConstants.coinGold.withValues(alpha: 0.08),
              blurRadius: 10,
            ),
        ],
      ),
      child: Row(
        children: [
          // Tier Icon Lockup
          Container(
            width: 40,
            height: 40,
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              color: _getTierColor(tier).withValues(alpha: 0.15),
              border: Border.all(
                color: _getTierColor(tier).withValues(alpha: 0.6),
                width: 1.2,
              ),
            ),
            child: Icon(tier.icon, color: _getTierColor(tier), size: 20),
          ),
          const SizedBox(width: 12),

          // Details
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisSize: MainAxisSize.min,
              children: [
                Row(
                  children: [
                    Text(
                      tier.title,
                      style: const TextStyle(
                        fontSize: 12.5,
                        fontWeight: FontWeight.w900,
                        color: Colors.white,
                        letterSpacing: 0.8,
                      ),
                    ),
                    const SizedBox(width: 6),
                    const Icon(
                      Icons.movie_outlined,
                      size: 13,
                      color: Colors.white38,
                    ),
                  ],
                ),
                const SizedBox(height: 2),
                Text(
                  tier.subtitle,
                  style: const TextStyle(
                    fontSize: 9.5,
                    fontWeight: FontWeight.w600,
                    color: Colors.white54,
                  ),
                ),
              ],
            ),
          ),

          // Reward Amount Pill
          Container(
            padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 5),
            margin: const EdgeInsets.only(right: 12),
            decoration: BoxDecoration(
              color: AppConstants.coinGold.withValues(alpha: 0.12),
              borderRadius: BorderRadius.circular(8),
              border: Border.all(
                color: AppConstants.coinGold.withValues(alpha: 0.4),
                width: 0.8,
              ),
            ),
            child: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                const Icon(
                  Icons.diamond_rounded,
                  color: AppConstants.coinGold,
                  size: 12,
                ),
                const SizedBox(width: 4),
                Text(
                  '+${tier.rewardCp} CP',
                  style: const TextStyle(
                    fontSize: 12,
                    fontWeight: FontWeight.w900,
                    color: AppConstants.coinGold,
                    letterSpacing: 0.6,
                  ),
                ),
              ],
            ),
          ),

          // Action Button
          _buildActionButton(tier, buttonState, cooldownRemaining),
        ],
      ),
    );
  }

  Widget _buildActionButton(
    CpBoostTier tier,
    CpBoostButtonState state,
    int cooldownRemaining,
  ) {
    switch (state) {
      case CpBoostButtonState.loading:
        return Container(
          width: 125,
          height: 36,
          decoration: BoxDecoration(
            color: const Color(0xFF1B2236),
            borderRadius: BorderRadius.circular(10),
            border: Border.all(
              color: AppConstants.stealthBlue.withValues(alpha: 0.5),
            ),
          ),
          child: const Center(
            child: SizedBox(
              width: 16,
              height: 16,
              child: CircularProgressIndicator(
                strokeWidth: 2,
                valueColor: AlwaysStoppedAnimation<Color>(
                  AppConstants.stealthBlue,
                ),
              ),
            ),
          ),
        );

      case CpBoostButtonState.limitReached:
        return Container(
          width: 125,
          height: 36,
          decoration: BoxDecoration(
            color: Colors.white.withValues(alpha: 0.05),
            borderRadius: BorderRadius.circular(10),
            border: Border.all(color: Colors.white12),
          ),
          child: const Center(
            child: Text(
              'LIMIT REACHED',
              style: TextStyle(
                fontSize: 9.5,
                fontWeight: FontWeight.w800,
                color: Colors.white30,
                letterSpacing: 0.6,
              ),
            ),
          ),
        );

      case CpBoostButtonState.cooldown:
        return Container(
          width: 125,
          height: 36,
          decoration: BoxDecoration(
            color: Colors.white.withValues(alpha: 0.06),
            borderRadius: BorderRadius.circular(10),
            border: Border.all(color: Colors.white24),
          ),
          child: Center(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Icon(
                  Icons.timer_outlined,
                  size: 12,
                  color: Colors.white60,
                ),
                const SizedBox(width: 4),
                Text(
                  'READY IN ${cooldownRemaining}s',
                  style: const TextStyle(
                    fontSize: 9.5,
                    fontWeight: FontWeight.w800,
                    color: Colors.white70,
                    letterSpacing: 0.5,
                  ),
                ),
              ],
            ),
          ),
        );

      case CpBoostButtonState.adNotReady:
        return GestureDetector(
          behavior: HitTestBehavior.opaque,
          onTap: () {
            AudioService().playClick();
            _checkAdReadiness();
          },
          child: Container(
            width: 125,
            height: 36,
            decoration: BoxDecoration(
              color: const Color(0xFF2A1C12),
              borderRadius: BorderRadius.circular(10),
              border: Border.all(
                color: const Color(0xFFFF9800).withValues(alpha: 0.6),
                width: 1.0,
              ),
            ),
            child: const Center(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    Icons.refresh_rounded,
                    size: 13,
                    color: Color(0xFFFF9800),
                  ),
                  SizedBox(width: 4),
                  Text(
                    'AD NOT READY',
                    style: TextStyle(
                      fontSize: 9.5,
                      fontWeight: FontWeight.w800,
                      color: Color(0xFFFF9800),
                      letterSpacing: 0.5,
                    ),
                  ),
                ],
              ),
            ),
          ),
        );

      case CpBoostButtonState.watchAd:
        return AnimatedBuilder(
          animation: _pulseController,
          builder: (context, child) {
            final pulseGlow = 0.3 + 0.25 * _pulseController.value;
            return GestureDetector(
              behavior: HitTestBehavior.opaque,
              onTap: () => _onWatchAdTapped(tier),
              child: Container(
                width: 125,
                height: 36,
                decoration: BoxDecoration(
                  gradient: const LinearGradient(
                    colors: [Color(0xFF0072FF), Color(0xFF00C6FF)],
                    begin: Alignment.topLeft,
                    end: Alignment.bottomRight,
                  ),
                  borderRadius: BorderRadius.circular(10),
                  boxShadow: [
                    BoxShadow(
                      color: AppConstants.stealthBlue.withValues(
                        alpha: pulseGlow,
                      ),
                      blurRadius: 10,
                      spreadRadius: 1,
                    ),
                  ],
                ),
                child: const Center(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(
                        Icons.play_arrow_rounded,
                        color: Colors.white,
                        size: 16,
                      ),
                      SizedBox(width: 4),
                      Text(
                        'WATCH AD',
                        style: TextStyle(
                          fontSize: 11,
                          fontWeight: FontWeight.w900,
                          color: Colors.white,
                          letterSpacing: 1.0,
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
  }

  Color _getTierColor(CpBoostTier tier) {
    switch (tier.id) {
      case 'tier_1':
        return AppConstants.stealthBlue;
      case 'tier_2':
        return const Color(0xFF00E5FF);
      case 'tier_3':
        return AppConstants.coinGold;
      default:
        return AppConstants.stealthBlue;
    }
  }

  bool _isHighlighted(CpBoostTier tier) => tier.id == 'tier_3';
}
