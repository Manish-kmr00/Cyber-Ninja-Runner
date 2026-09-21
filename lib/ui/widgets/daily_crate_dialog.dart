import '../../core/localization/app_localizations.dart';
import 'dart:async';
import 'dart:math';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/monetization/monetization_manager.dart';
import '../../core/services/daily_crate_service.dart';
import '../../core/storage/save_service.dart';

enum _CrateStage {
  locked, // Cooldown active
  readyToTap, // Ready (Tap 1)
  cracking1, // Lock 1 broken (Tap 2)
  cracking2, // Lock 2 broken (Tap 3)
  opened, // Burst open, loot cards showing
}

class DailyCrateDialog extends StatefulWidget {
  const DailyCrateDialog({super.key});

  @override
  State<DailyCrateDialog> createState() => _DailyCrateDialogState();
}

class _DailyCrateDialogState extends State<DailyCrateDialog>
    with TickerProviderStateMixin {
  final DailyCrateService _crateService = DailyCrateService();

  late AnimationController _bobController;
  late AnimationController _pulseController;
  late AnimationController _burstController;
  Timer? _countdownTimer;

  _CrateStage _stage = _CrateStage.locked;
  DailyCrateReward? _generatedReward;
  int _remainingMs = 0;
  bool _streakBroken = false;
  int _tapCount = 0;
  bool _isWatchingAd = false;

  @override
  void initState() {
    super.initState();

    _bobController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1800),
    )..repeat(reverse: true);

    _pulseController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1200),
    )..repeat(reverse: true);

    _burstController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 900),
    );

    _initCrateState();

    _countdownTimer = Timer.periodic(const Duration(seconds: 1), (_) {
      if (mounted) {
        final saveService = context.read<SaveService>();
        final rem = _crateService.getRemainingCooldownMs(saveService);
        setState(() {
          _remainingMs = rem;
          if (_remainingMs <= 0 && _stage == _CrateStage.locked) {
            _initCrateState();
          }
        });
      }
    });
  }

  void _initCrateState() {
    final saveService = context.read<SaveService>();
    final ready = _crateService.isCrateReady(saveService);
    final broken = _crateService.isStreakBroken(saveService);

    setState(() {
      _streakBroken = broken;
      _remainingMs = _crateService.getRemainingCooldownMs(saveService);
      if (ready) {
        _stage = _CrateStage.readyToTap;
        _tapCount = 0;
      } else {
        _stage = _CrateStage.locked;
      }
    });
  }

  @override
  void dispose() {
    _countdownTimer?.cancel();
    _bobController.dispose();
    _pulseController.dispose();
    _burstController.dispose();
    super.dispose();
  }

  void _onCrateTap() {
    if (_stage == _CrateStage.locked) {
      AudioService().playClick();
      return;
    }

    final saveService = context.read<SaveService>();

    if (_stage == _CrateStage.readyToTap) {
      AudioService().playClick();
      AudioService().playSfx('laser');
      setState(() {
        _stage = _CrateStage.cracking1;
        _tapCount = 1;
      });
    } else if (_stage == _CrateStage.cracking1) {
      AudioService().playClick();
      AudioService().playSfx('laser');
      setState(() {
        _stage = _CrateStage.cracking2;
        _tapCount = 2;
      });
    } else if (_stage == _CrateStage.cracking2) {
      // Final burst open!
      AudioService().playCrateOpen();
      _burstController.forward(from: 0.0);

      _generatedReward = _crateService.generateReward(saveService);

      setState(() {
        _stage = _CrateStage.opened;
        _tapCount = 3;
      });
    }
  }

  void _claimAndClose() {
    if (_generatedReward != null) {
      final saveService = context.read<SaveService>();
      _crateService.claimReward(saveService, _generatedReward!);
      AudioService().playCollect();
    }
    Navigator.of(context).pop();
  }

  Future<void> _claimEnhancedWithAd() async {
    if (_isWatchingAd) return;
    setState(() => _isWatchingAd = true);

    try {
      final success = await MonetizationManager().showRewarded(
        rewardType: RewardType.dailyCrateBonus,
      );

      if (!mounted) return;
      setState(() => _isWatchingAd = false);

      if (success && _generatedReward != null) {
        final saveService = context.read<SaveService>();
        // 1. Claim standard rewards
        _crateService.claimReward(saveService, _generatedReward!);

        // 2. Grant 2X duplicate CP and boosters
        for (final item in _generatedReward!.items) {
          if (item.iconType == 'cp' || item.iconType == 'jackpot') {
            saveService.addCyberPoints(item.count);
          } else if (item.boosterType != null) {
            saveService.addBooster(item.boosterType!, item.count);
          }
        }

        AudioService().playCollect();
        MonetizationManager().playRewardCelebration(
          context,
          RewardAnimationType.treasureCrate,
          customTitle: 'CRATE LOOT MULTIPLIED 2X!',
          customSubtitle: 'Bonus CP and boosters credited to inventory',
        );
        Navigator.of(context).pop();
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text(
              '// AD CANCELLED OR UNAVAILABLE. STANDARD REWARDS REMAIN AVAILABLE.',
              style: TextStyle(fontFamily: 'monospace', fontSize: 11),
            ),
            backgroundColor: Color(0xFF141926),
            duration: Duration(milliseconds: 1800),
          ),
        );
      }
    } catch (e) {
      if (mounted) {
        setState(() => _isWatchingAd = false);
      }
    }
  }

  void _restoreStreak() {
    final saveService = context.read<SaveService>();
    final success = _crateService.restoreStreakWithCP(saveService);
    if (success) {
      AudioService().playCollect();
      setState(() {
        _streakBroken = false;
      });
      _initCrateState();
    } else {
      AudioService().playClick();
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text(
            'Not enough CP to restore streak! Need ${DailyCrateService.streakSaverCostCP} CP.',
          ),
          backgroundColor: Color(0xFFE53935),
        ),
      );
    }
  }

  void _resetStreak() {
    final saveService = context.read<SaveService>();
    _crateService.resetStreak(saveService);
    AudioService().playClick();
    setState(() {
      _streakBroken = false;
    });
    _initCrateState();
  }

  String _formatDuration(int ms) {
    final dur = Duration(milliseconds: ms);
    final hours = dur.inHours.toString().padLeft(2, '0');
    final minutes = (dur.inMinutes % 60).toString().padLeft(2, '0');
    final seconds = (dur.inSeconds % 60).toString().padLeft(2, '0');
    return '$hours:$minutes:$seconds';
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final currentStreak = saveService.player.dailyStreak;

    return Dialog(
      backgroundColor: Colors.transparent,
      insetPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 6),
      child: Container(
        constraints: const BoxConstraints(maxWidth: 820, maxHeight: 680),
        decoration: BoxDecoration(
          color: const Color(0xFF090D16).withValues(alpha: 0.95),
          borderRadius: BorderRadius.circular(24),
          border: Border.all(
            color: AppConstants.stealthBlue.withValues(alpha: 0.5),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: AppConstants.stealthBlue.withValues(alpha: 0.25),
              blurRadius: 28,
              spreadRadius: 2,
            ),
          ],
        ),
        child: ClipRRect(
          borderRadius: BorderRadius.circular(24),
          child: Stack(
            children: [
              // Background Holographic Grid Lines
              Positioned.fill(
                child: CustomPaint(
                  painter: _CyberGridPainter(
                    accentColor: AppConstants.stealthBlue,
                  ),
                ),
              ),

              // Main Dialog Column
              Padding(
                padding: const EdgeInsets.symmetric(
                  horizontal: 16.0,
                  vertical: 10.0,
                ),
                child: Column(
                  children: [
                    // 1. Top Header Bar
                    _buildTopBar(context),
                    const SizedBox(height: 6),

                    // Streak Broken Warning (if applicable)
                    if (_streakBroken && _stage != _CrateStage.opened)
                      _buildStreakBrokenBanner(),

                    // 2. 7-Day Streak Roadmap Tracker
                    _buildStreakTimeline(currentStreak),
                    const SizedBox(height: 6),

                    // 3. Center Area: Interactive Crate OR Loot Cards
                    Expanded(
                      child: _stage == _CrateStage.opened
                          ? _buildLootReveal()
                          : _buildCrateCenter(currentStreak),
                    ),

                    const SizedBox(height: 6),

                    // 4. Bottom Action Bar
                    _buildBottomAction(),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildTopBar(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: [
            Container(
              padding: const EdgeInsets.all(8),
              decoration: BoxDecoration(
                gradient: const LinearGradient(
                  colors: [AppConstants.stealthBlue, Color(0xFF7928CA)],
                ),
                borderRadius: BorderRadius.circular(12),
                boxShadow: [
                  BoxShadow(
                    color: AppConstants.stealthBlue.withValues(alpha: 0.5),
                    blurRadius: 8,
                  ),
                ],
              ),
              child: const Icon(
                Icons.card_giftcard_rounded,
                color: Colors.white,
                size: 20,
              ),
            ),
            const SizedBox(width: 12),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  context.l10n.tr('neural_supply_drop'),
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 17,
                    fontWeight: FontWeight.w900,
                    letterSpacing: 2.0,
                  ),
                ),
                Text(
                  context.l10n.tr('cybernetic_reward_protocol'),
                  style: const TextStyle(
                    color: AppConstants.stealthBlue,
                    fontSize: 9,
                    fontWeight: FontWeight.bold,
                    letterSpacing: 1.5,
                  ),
                ),
              ],
            ),
          ],
        ),

        // Countdown / Status Pill
        Row(
          children: [
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 6),
              decoration: BoxDecoration(
                color: const Color(0xFF131722),
                borderRadius: BorderRadius.circular(16),
                border: Border.all(
                  color: _stage == _CrateStage.locked
                      ? Colors.white24
                      : AppConstants.coinGold.withValues(alpha: 0.8),
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    _stage == _CrateStage.locked
                        ? Icons.timer_outlined
                        : Icons.bolt_rounded,
                    color: _stage == _CrateStage.locked
                        ? Colors.white54
                        : AppConstants.coinGold,
                    size: 14,
                  ),
                  const SizedBox(width: 6),
                  Text(
                    _stage == _CrateStage.locked
                        ? 'RECHARGING: ${_formatDuration(_remainingMs)}'
                        : 'SUPPLY DROP READY',
                    style: TextStyle(
                      color: _stage == _CrateStage.locked
                          ? Colors.white70
                          : AppConstants.coinGold,
                      fontSize: 11,
                      fontWeight: FontWeight.w800,
                      letterSpacing: 1.0,
                    ),
                  ),
                ],
              ),
            ),
            const SizedBox(width: 8),

            // Close Icon
            IconButton(
              onPressed: () {
                AudioService().playClick();
                Navigator.of(context).pop();
              },
              icon: const Icon(Icons.close_rounded, color: Colors.white60),
              splashRadius: 20,
            ),
          ],
        ),
      ],
    );
  }

  Widget _buildStreakBrokenBanner() {
    return Container(
      margin: const EdgeInsets.only(bottom: 10),
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 8),
      decoration: BoxDecoration(
        color: const Color(0xFF3B151E),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: const Color(0xFFFF4D63)),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Row(
            children: [
              const Icon(
                Icons.warning_amber_rounded,
                color: Color(0xFFFF4D63),
                size: 18,
              ),
              const SizedBox(width: 10),
              Text(
                context.l10n.tr('streak_interrupted'),
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 12,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
          Row(
            children: [
              TextButton(
                onPressed: _resetStreak,
                child: Text(
                  context.l10n.tr('restart_day_1'),
                  style: TextStyle(color: Colors.white54, fontSize: 11),
                ),
              ),
              const SizedBox(width: 6),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: const Color(0xFFFF4D63),
                  padding: const EdgeInsets.symmetric(
                    horizontal: 12,
                    vertical: 6,
                  ),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                ),
                onPressed: _restoreStreak,
                child: Text(
                  context.l10n.tr('restore_streak'),
                  style: TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                    fontSize: 11,
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildStreakTimeline(int currentStreak) {
    const rewardsPreview = [
      '200 CP',
      '350 CP',
      '500 CP',
      '750 CP',
      '1,200 CP',
      '1,800 CP',
      'QUANTUM 5K',
    ];

    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 10),
      decoration: BoxDecoration(
        color: const Color(0xFF0F1420),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.white12),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: List.generate(7, (index) {
          final dayNum = index + 1;
          final isClaimed = dayNum < currentStreak;
          final isCurrent = dayNum == currentStreak;
          final isGrand = dayNum == 7;

          Color borderColor = Colors.white12;
          Color bgColor = const Color(0xFF141926);

          if (isClaimed) {
            borderColor = const Color(0xFF00E676).withValues(alpha: 0.6);
            bgColor = const Color(0xFF0C2417);
          } else if (isCurrent) {
            borderColor = isGrand
                ? AppConstants.coinGold
                : AppConstants.stealthBlue;
            bgColor = isGrand
                ? const Color(0xFF332408)
                : const Color(0xFF0D2536);
          } else if (isGrand) {
            borderColor = AppConstants.coinGold.withValues(alpha: 0.35);
          }

          return Expanded(
            child: Container(
              margin: const EdgeInsets.symmetric(horizontal: 2),
              padding: const EdgeInsets.symmetric(vertical: 4),
              decoration: BoxDecoration(
                color: bgColor,
                borderRadius: BorderRadius.circular(10),
                border: Border.all(
                  color: borderColor,
                  width: isCurrent ? 1.5 : 1.0,
                ),
                boxShadow: isCurrent
                    ? [
                        BoxShadow(
                          color:
                              (isGrand
                                      ? AppConstants.coinGold
                                      : AppConstants.stealthBlue)
                                  .withValues(alpha: 0.35),
                          blurRadius: 8,
                        ),
                      ]
                    : null,
              ),
              child: Column(
                children: [
                  Text(
                    'DAY $dayNum',
                    style: TextStyle(
                      color: isCurrent
                          ? (isGrand
                                ? AppConstants.coinGold
                                : AppConstants.stealthBlue)
                          : (isClaimed
                                ? const Color(0xFF00E676)
                                : Colors.white54),
                      fontSize: 8.5,
                      fontWeight: FontWeight.w900,
                      letterSpacing: 0.5,
                    ),
                  ),
                  const SizedBox(height: 2),
                  if (isClaimed)
                    const Icon(
                      Icons.check_circle_rounded,
                      color: Color(0xFF00E676),
                      size: 14,
                    )
                  else if (isGrand)
                    const Icon(
                      Icons.military_tech_rounded,
                      color: AppConstants.coinGold,
                      size: 14,
                    )
                  else
                    Icon(
                      isCurrent
                          ? Icons.lock_open_rounded
                          : Icons.lock_outline_rounded,
                      color: isCurrent
                          ? AppConstants.stealthBlue
                          : Colors.white24,
                      size: 13,
                    ),
                  const SizedBox(height: 2),
                  Text(
                    rewardsPreview[index],
                    style: TextStyle(
                      color: isCurrent ? Colors.white : Colors.white38,
                      fontSize: 7.5,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            ),
          );
        }),
      ),
    );
  }

  Widget _buildCrateCenter(int currentStreak) {
    return AnimatedBuilder(
      animation: Listenable.merge([_bobController, _pulseController]),
      builder: (context, child) {
        final bobY = sin(_bobController.value * pi) * 6.0;
        final glowScale = 0.8 + 0.3 * _pulseController.value;

        return GestureDetector(
          behavior: HitTestBehavior.opaque,
          onTap: _onCrateTap,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              // 3D Cyber Crate Visual
              Transform.translate(
                offset: Offset(0, bobY),
                child: SizedBox(
                  width: 150,
                  height: 105,
                  child: Stack(
                    alignment: Alignment.center,
                    children: [
                      // Ambient Glow
                      Container(
                        width: 120 * glowScale,
                        height: 90 * glowScale,
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          color: _getGlowColor().withValues(alpha: 0.22),
                        ),
                      ),

                      // Custom Painted Cyber Crate
                      CustomPaint(
                        size: const Size(140, 100),
                        painter: _CyberCratePainter(
                          stage: _stage,
                          glowColor: _getGlowColor(),
                          pulseValue: _pulseController.value,
                          isGrand: currentStreak == 7,
                        ),
                      ),
                    ],
                  ),
                ),
              ),

              const SizedBox(height: 8),

              // Tap Prompt / Cooldown Banner
              if (_stage == _CrateStage.locked) ...[
                Text(
                  context.l10n.tr('crate_recharging'),
                  style: TextStyle(
                    color: Colors.white70,
                    fontSize: 12,
                    fontWeight: FontWeight.w900,
                    letterSpacing: 1.5,
                  ),
                ),
                const SizedBox(height: 2),
                Text(
                  '${context.l10n.tr('next_supply_beacon')} ${_formatDuration(_remainingMs)}',
                  style: const TextStyle(color: Colors.white38, fontSize: 10),
                ),
              ] else ...[
                Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 20,
                    vertical: 8,
                  ),
                  decoration: BoxDecoration(
                    color: _getGlowColor().withValues(alpha: 0.15),
                    borderRadius: BorderRadius.circular(20),
                    border: Border.all(
                      color: _getGlowColor().withValues(alpha: 0.6),
                      width: 1.5,
                    ),
                    boxShadow: [
                      BoxShadow(
                        color: _getGlowColor().withValues(alpha: 0.25),
                        blurRadius: 12,
                      ),
                    ],
                  ),
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Icon(
                        Icons.touch_app_rounded,
                        color: _getGlowColor(),
                        size: 16,
                      ),
                      const SizedBox(width: 8),
                      Text(
                        _getTapInstructionText(),
                        style: TextStyle(
                          color: _getGlowColor(),
                          fontSize: 12,
                          fontWeight: FontWeight.w900,
                          letterSpacing: 1.5,
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ],
          ),
        );
      },
    );
  }

  Color _getGlowColor() {
    switch (_stage) {
      case _CrateStage.locked:
        return Colors.white38;
      case _CrateStage.readyToTap:
        return AppConstants.stealthBlue;
      case _CrateStage.cracking1:
        return const Color(0xFFA855F7); // Purple Epic
      case _CrateStage.cracking2:
        return AppConstants.coinGold; // Gold Mythic
      case _CrateStage.opened:
        return AppConstants.coinGold;
    }
  }

  String _getTapInstructionText() {
    switch (_stage) {
      case _CrateStage.readyToTap:
        return 'TAP TO INITIATE DECRYPTION (1/3)';
      case _CrateStage.cracking1:
        return 'BREACH FIREWALL // TAP AGAIN (2/3)';
      case _CrateStage.cracking2:
        return 'OVERLOAD CORE // TAP TO BURST OPEN (3/3)';
      default:
        return '';
    }
  }

  Widget _buildLootReveal() {
    if (_generatedReward == null) return const SizedBox();

    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        // Top Banner
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Icon(
              Icons.stars_rounded,
              color: AppConstants.coinGold,
              size: 18,
            ),
            const SizedBox(width: 6),
            Text(
              _generatedReward!.isJackpot
                  ? '⚡ JACKPOT UNLOCKED! ⚡'
                  : 'SUPPLIES DECRYPTED',
              style: TextStyle(
                color: _generatedReward!.isJackpot
                    ? AppConstants.coinGold
                    : Colors.white,
                fontSize: 13,
                fontWeight: FontWeight.w900,
                letterSpacing: 1.5,
              ),
            ),
          ],
        ),
        const SizedBox(height: 8),

        // 3 Loot Cards in a Row
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: _generatedReward!.items.map((item) {
            return Container(
              width: 140,
              height: 125,
              margin: const EdgeInsets.symmetric(horizontal: 6),
              padding: const EdgeInsets.all(8),
              decoration: BoxDecoration(
                gradient: LinearGradient(
                  colors: [
                    _getRarityBgColor(item.rarity),
                    const Color(0xFF0F1420),
                  ],
                  begin: Alignment.topCenter,
                  end: Alignment.bottomCenter,
                ),
                borderRadius: BorderRadius.circular(14),
                border: Border.all(
                  color: _getRarityBorderColor(item.rarity),
                  width: 1.5,
                ),
                boxShadow: [
                  BoxShadow(
                    color: _getRarityBorderColor(
                      item.rarity,
                    ).withValues(alpha: 0.35),
                    blurRadius: 10,
                  ),
                ],
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  // Rarity Tag
                  Container(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 8,
                      vertical: 3,
                    ),
                    decoration: BoxDecoration(
                      color: Colors.black45,
                      borderRadius: BorderRadius.circular(8),
                    ),
                    child: Text(
                      item.rarity.name.toUpperCase(),
                      style: TextStyle(
                        color: _getRarityBorderColor(item.rarity),
                        fontSize: 8.5,
                        fontWeight: FontWeight.w900,
                        letterSpacing: 1.0,
                      ),
                    ),
                  ),
                  const Spacer(),

                  // Item Icon
                  _buildItemIcon(item),
                  const Spacer(),

                  // Count / Amount
                  Text(
                    item.iconType == 'cp' || item.iconType == 'jackpot'
                        ? '+${item.count} CP'
                        : '+${item.count}',
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.w900,
                    ),
                  ),
                  const SizedBox(height: 2),

                  // Item Title
                  Text(
                    item.title,
                    textAlign: TextAlign.center,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: const TextStyle(
                      color: Colors.white70,
                      fontSize: 10.5,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            );
          }).toList(),
        ),
      ],
    );
  }

  Widget _buildItemIcon(CrateDropItem item) {
    if (item.iconType == 'cp' || item.iconType == 'jackpot') {
      return Container(
        padding: const EdgeInsets.all(6),
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          color: AppConstants.coinGold.withValues(alpha: 0.2),
          border: Border.all(color: AppConstants.coinGold, width: 1.5),
        ),
        child: const Icon(
          Icons.diamond_rounded,
          color: AppConstants.coinGold,
          size: 22,
        ),
      );
    }

    IconData icon;
    Color iconColor;
    switch (item.boosterType) {
      case BoosterType.safeGround:
        icon = Icons.shield_rounded;
        iconColor = const Color(0xFF00E5FF);
        break;
      case BoosterType.invisibility:
        icon = Icons.visibility_off_rounded;
        iconColor = const Color(0xFFA855F7);
        break;
      case BoosterType.matrixSlowMo:
        icon = Icons.slow_motion_video_rounded;
        iconColor = const Color(0xFF00E676);
        break;
      case BoosterType.killEyes:
        icon = Icons.flash_on_rounded;
        iconColor = const Color(0xFFFF9100);
        break;
      default:
        icon = Icons.backpack_rounded;
        iconColor = AppConstants.coinGold;
        break;
    }

    return Container(
      padding: const EdgeInsets.all(6),
      decoration: BoxDecoration(
        shape: BoxShape.circle,
        color: iconColor.withValues(alpha: 0.2),
        border: Border.all(color: iconColor, width: 1.5),
      ),
      child: Icon(icon, color: iconColor, size: 20),
    );
  }

  Color _getRarityBgColor(CrateRarity rarity) {
    switch (rarity) {
      case CrateRarity.common:
        return const Color(0xFF132338);
      case CrateRarity.rare:
        return const Color(0xFF1C2A44);
      case CrateRarity.epic:
        return const Color(0xFF321A44);
      case CrateRarity.mythic:
        return const Color(0xFF423010);
    }
  }

  Color _getRarityBorderColor(CrateRarity rarity) {
    switch (rarity) {
      case CrateRarity.common:
        return const Color(0xFF00E5FF);
      case CrateRarity.rare:
        return const Color(0xFF2979FF);
      case CrateRarity.epic:
        return const Color(0xFFA855F7);
      case CrateRarity.mythic:
        return const Color(0xFFFFD700);
    }
  }

  Widget _buildBottomAction() {
    if (_stage == _CrateStage.opened) {
      return Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          // Normal Standard Claim (Unchanged, free)
          SizedBox(
            height: 46,
            child: OutlinedButton(
              style: OutlinedButton.styleFrom(
                foregroundColor: Colors.white70,
                side: BorderSide(
                  color: Colors.white.withValues(alpha: 0.3),
                  width: 1.2,
                ),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(14),
                ),
                padding: const EdgeInsets.symmetric(horizontal: 16),
              ),
              onPressed: _isWatchingAd ? null : _claimAndClose,
              child: Text(
                context.l10n.tr('claim_standard'),
                style: const TextStyle(
                  fontWeight: FontWeight.w800,
                  fontSize: 12,
                  letterSpacing: 1.0,
                ),
              ),
            ),
          ),
          const SizedBox(width: 12),

          // 2X Enhanced Claim with Rewarded Ad
          Container(
            height: 46,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(14),
              gradient: const LinearGradient(
                colors: [Color(0xFF00E5FF), AppConstants.coinGold],
              ),
              boxShadow: [
                BoxShadow(
                  color: AppConstants.coinGold.withValues(alpha: 0.35),
                  blurRadius: 10,
                  offset: const Offset(0, 2),
                ),
              ],
            ),
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.transparent,
                shadowColor: Colors.transparent,
                foregroundColor: Colors.black,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(14),
                ),
                padding: const EdgeInsets.symmetric(horizontal: 16),
              ),
              onPressed: _isWatchingAd ? null : _claimEnhancedWithAd,
              child: Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  const Icon(
                    Icons.play_circle_fill_rounded,
                    color: Colors.black,
                    size: 17,
                  ),
                  const SizedBox(width: 6),
                  Text(
                    _isWatchingAd
                        ? 'LOADING AD...'
                        : 'WATCH AD → 2X ALL SUPPLIES',
                    style: const TextStyle(
                      fontWeight: FontWeight.w900,
                      fontSize: 12,
                      letterSpacing: 1.0,
                      color: Colors.black,
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      );
    }

    if (_stage == _CrateStage.locked) {
      return SizedBox(
        width: 180,
        height: 42,
        child: OutlinedButton(
          style: OutlinedButton.styleFrom(
            foregroundColor: Colors.white70,
            side: const BorderSide(color: Colors.white24),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(14),
            ),
          ),
          onPressed: () {
            AudioService().playClick();
            Navigator.of(context).pop();
          },
          child: Text(
            context.l10n.tr('return_to_base'),
            style: const TextStyle(
              fontWeight: FontWeight.bold,
              fontSize: 12,
              letterSpacing: 1.2,
            ),
          ),
        ),
      );
    }

    return Text(
      '${context.l10n.tr('tap_crate_step')} ${_tapCount + 1} ${context.l10n.tr('of_step')}',
      style: TextStyle(
        color: _getGlowColor().withValues(alpha: 0.7),
        fontSize: 11,
        fontWeight: FontWeight.w800,
        letterSpacing: 1.5,
      ),
    );
  }
}

/// Custom Background Cyberpunk Grid Painter
class _CyberGridPainter extends CustomPainter {
  final Color accentColor;

  _CyberGridPainter({required this.accentColor});

  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = accentColor.withValues(alpha: 0.035)
      ..strokeWidth = 1.0;

    for (double x = 0; x < size.width; x += 35) {
      canvas.drawLine(Offset(x, 0), Offset(x, size.height), paint);
    }
    for (double y = 0; y < size.height; y += 35) {
      canvas.drawLine(Offset(0, y), Offset(size.width, y), paint);
    }
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) => false;
}

/// 3D Perspective Cyber Crate Painter
class _CyberCratePainter extends CustomPainter {
  final _CrateStage stage;
  final Color glowColor;
  final double pulseValue;
  final bool isGrand;

  _CyberCratePainter({
    required this.stage,
    required this.glowColor,
    required this.pulseValue,
    required this.isGrand,
  });

  @override
  void paint(Canvas canvas, Size size) {
    final cx = size.width / 2;
    final cy = size.height / 2;

    const boxW = 86.0;
    const boxH = 56.0;
    const depth = 18.0;

    // 1. 3D Top Slanted Face
    final topFace = Path()
      ..moveTo(cx - boxW / 2, cy - boxH / 2)
      ..lineTo(cx - boxW / 2 + depth, cy - boxH / 2 - depth)
      ..lineTo(cx + boxW / 2 + depth, cy - boxH / 2 - depth)
      ..lineTo(cx + boxW / 2, cy - boxH / 2)
      ..close();

    final topPaint = Paint()
      ..color = isGrand ? const Color(0xFF4A3814) : const Color(0xFF1E2838)
      ..style = PaintingStyle.fill;
    canvas.drawPath(topFace, topPaint);

    // 2. 3D Right Side Facet
    final sideFace = Path()
      ..moveTo(cx + boxW / 2, cy - boxH / 2)
      ..lineTo(cx + boxW / 2 + depth, cy - boxH / 2 - depth)
      ..lineTo(cx + boxW / 2 + depth, cy + boxH / 2 - depth)
      ..lineTo(cx + boxW / 2, cy + boxH / 2)
      ..close();

    final sidePaint = Paint()
      ..color = isGrand ? const Color(0xFF2E220A) : const Color(0xFF111722)
      ..style = PaintingStyle.fill;
    canvas.drawPath(sideFace, sidePaint);

    // 3. Front Face
    final frontRect = Rect.fromCenter(
      center: Offset(cx, cy),
      width: boxW,
      height: boxH,
    );
    final frontPaint = Paint()
      ..color = isGrand ? const Color(0xFF33250C) : const Color(0xFF161E2C)
      ..style = PaintingStyle.fill;
    canvas.drawRect(frontRect, frontPaint);

    // Neon Frame Outlines
    final outlinePaint = Paint()
      ..color = glowColor.withValues(alpha: 0.85)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0;

    canvas.drawRect(frontRect, outlinePaint);
    canvas.drawPath(topFace, outlinePaint);
    canvas.drawPath(sideFace, outlinePaint);

    // Cross Brace Laser Bands (reinforced crate look)
    final bandPaint = Paint()
      ..color = glowColor.withValues(alpha: 0.6)
      ..strokeWidth = 2.5;

    canvas.drawLine(
      Offset(cx - boxW / 4, cy - boxH / 2),
      Offset(cx - boxW / 4, cy + boxH / 2),
      bandPaint,
    );
    canvas.drawLine(
      Offset(cx + boxW / 4, cy - boxH / 2),
      Offset(cx + boxW / 4, cy + boxH / 2),
      bandPaint,
    );

    // Center Quantum Lock Mechanism
    final lockPaint = Paint()
      ..color = glowColor
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(cx, cy), 10, lockPaint);

    final innerLockPaint = Paint()
      ..color = Colors.black
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(cx, cy), 5, innerLockPaint);

    // Lock State Indicator
    if (stage == _CrateStage.cracking1 || stage == _CrateStage.cracking2) {
      // Draw energetic breach cracks
      final crackPaint = Paint()
        ..color = Colors.white
        ..strokeWidth = 2.0;
      canvas.drawLine(
        Offset(cx - 8, cy - 6),
        Offset(cx + 6, cy + 9),
        crackPaint,
      );
      canvas.drawLine(
        Offset(cx + 3, cy - 10),
        Offset(cx - 5, cy + 5),
        crackPaint,
      );
    }
  }

  @override
  bool shouldRepaint(covariant _CyberCratePainter oldDelegate) =>
      oldDelegate.stage != stage ||
      oldDelegate.glowColor != glowColor ||
      oldDelegate.pulseValue != pulseValue;
}
