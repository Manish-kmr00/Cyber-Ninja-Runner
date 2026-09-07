import 'dart:math';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/storage/save_service.dart';
import '../../game/sqube_game.dart';

class HudOverlay extends StatefulWidget {
  final SqubeGame game;

  const HudOverlay({super.key, required this.game});

  @override
  State<HudOverlay> createState() => _HudOverlayState();
}

class _HudOverlayState extends State<HudOverlay> with TickerProviderStateMixin {
  late final AnimationController _pulseController;
  late final AnimationController _sectorBannerController;
  late final Animation<double> _sectorBannerOpacity;
  late final Animation<Offset> _sectorBannerSlide;
  SectorBiome? _announcedSector;

  // Attack button: scale-punch + glow flash animation
  late final AnimationController _attackPunchController;
  late final Animation<double> _attackScaleAnim;
  late final Animation<double> _attackGlowAnim;
  bool _attackFlashing = false;


  int _lastJumpTime = 0;
  void _triggerJump() {
    if (widget.game.player.isAttacking) return; // no jump mid-swing
    final now = DateTime.now().millisecondsSinceEpoch;
    if (now - _lastJumpTime < 160) return;
    _lastJumpTime = now;
    widget.game.player.jump();
    AudioService().playJump();
  }

  void _triggerSlide() {
    if (widget.game.player.isAttacking) return; // no slide mid-swing
    widget.game.player.startSlide();
    AudioService().playSlide();
  }

  void _triggerAttack() {
    if (widget.game.player.attackCooldown > 0) return;
    widget.game.player.startAttack();
    // Fire punch-scale + glow flash animation
    _attackPunchController.forward(from: 0.0);
    if (mounted) setState(() => _attackFlashing = true);
    Future.delayed(const Duration(milliseconds: 350),
        () { if (mounted) setState(() => _attackFlashing = false); });
  }

  @override
  void initState() {
    super.initState();
    _pulseController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1400),
    )..repeat(reverse: true);

    // Attack button punch-scale + glow flash (300ms one-shot)
    _attackPunchController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 300),
    );
    _attackScaleAnim = TweenSequence<double>([
      TweenSequenceItem(
        tween: Tween(begin: 1.0, end: 0.82).chain(CurveTween(curve: Curves.easeIn)),
        weight: 30,
      ),
      TweenSequenceItem(
        tween: Tween(begin: 0.82, end: 1.08).chain(CurveTween(curve: Curves.elasticOut)),
        weight: 70,
      ),
    ]).animate(_attackPunchController);
    _attackGlowAnim = Tween<double>(begin: 0.0, end: 1.0).animate(
      CurvedAnimation(parent: _attackPunchController, curve: Curves.easeOutCubic),
    );

    _sectorBannerController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 550),
    );
    _sectorBannerController.addStatusListener((status) {
      if (status == AnimationStatus.dismissed) {
        if (mounted) {
          setState(() {
            _announcedSector = null;
          });
        }
      }
    });

    _sectorBannerOpacity = CurvedAnimation(
      parent: _sectorBannerController,
      curve: Curves.easeOut,
    );
    _sectorBannerSlide =
        Tween<Offset>(begin: const Offset(0, -0.6), end: Offset.zero).animate(
          CurvedAnimation(
            parent: _sectorBannerController,
            curve: Curves.easeOutCubic,
          ),
        );

    widget.game.onDistanceChanged = () {
      if (mounted) setState(() {});
    };

    widget.game.onSectorChanged = (newSector) {
      if (mounted) {
        setState(() {
          _announcedSector = newSector;
        });
        _sectorBannerController.forward(from: 0.0);
        AudioService().playBooster();
        Future.delayed(const Duration(milliseconds: 2600), () {
          if (mounted && _announcedSector == newSector) {
            _sectorBannerController.reverse();
          }
        });
      }
    };
  }

  @override
  void dispose() {
    _pulseController.dispose();
    _sectorBannerController.dispose();
    _attackPunchController.dispose();
    super.dispose();
  }


  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final bestScore = saveService.stats.getBestForMode(widget.game.mode);

    return SizedBox.expand(
      child: SafeArea(
        child: Stack(
          fit: StackFit.expand,
          children: [
            // 0. Full-Screen Interactive Touch Surface (Tap anywhere to Jump, Drag down to Slide)
            // Non-positioned SizedBox.expand guarantees the Stack is fully expanded
            // and catches taps/clicks anywhere across the entire screen!
            SizedBox.expand(
              child: GestureDetector(
                behavior: HitTestBehavior.translucent,
                onTapDown: (_) => _triggerJump(),
                onTap: () => _triggerJump(),
                onVerticalDragUpdate: (details) {
                  if (details.primaryDelta != null &&
                      details.primaryDelta! > 10) {
                    _triggerSlide();
                  } else if (details.primaryDelta != null &&
                      details.primaryDelta! < -10) {
                    _triggerJump();
                  }
                },
                onVerticalDragEnd: (_) {
                  widget.game.player.stopSlide();
                },
                child: const SizedBox.expand(),
              ),
            ),

            // 1. Top Cyber Telemetry Header
            Positioned(
              top: 14,
              left: 20,
              right: 20,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  // Distance & Telemetry Display (Exact Sci-Fi Chamfered Frame)
                  CustomPaint(
                    painter: _SciFiCardBorderPainter(
                      borderColor: widget.game.currentSector.primaryAccent,
                      glowColor: widget.game.currentSector.primaryAccent
                          .withValues(alpha: 0.35),
                    ),
                    child: Container(
                      padding: const EdgeInsets.only(
                        left: 18,
                        right: 24,
                        top: 10,
                        bottom: 10,
                      ),
                      color: Colors.transparent,
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            crossAxisAlignment: CrossAxisAlignment.baseline,
                            textBaseline: TextBaseline.alphabetic,
                            children: [
                              Text(
                                '${widget.game.currentDistance}',
                                style: const TextStyle(
                                  fontSize: 32,
                                  fontWeight: FontWeight.w900,
                                  color: Colors.white,
                                  letterSpacing: 1.0,
                                  fontFamily: 'monospace',
                                ),
                              ),
                              const SizedBox(width: 6),
                              const Text(
                                'M',
                                style: TextStyle(
                                  fontSize: 18,
                                  fontWeight: FontWeight.w900,
                                  color: Colors.white,
                                  letterSpacing: 1.0,
                                  fontFamily: 'monospace',
                                ),
                              ),
                            ],
                          ),
                          const SizedBox(height: 1),
                          Text(
                            'SECTOR BEST: $bestScore M',
                            style: TextStyle(
                              fontSize: 10.5,
                              fontWeight: FontWeight.w800,
                              color: Colors.white.withValues(alpha: 0.65),
                              letterSpacing: 1.0,
                              fontFamily: 'monospace',
                            ),
                          ),
                          const SizedBox(height: 6),
                          // Exact Chamfered Sector Pill
                          CustomPaint(
                            painter: _SciFiPillBorderPainter(
                              color: widget.game.currentSector.primaryAccent,
                            ),
                            child: Container(
                              padding: const EdgeInsets.symmetric(
                                horizontal: 10,
                                vertical: 3,
                              ),
                              child: Text(
                                '${widget.game.currentSector.sectorTag} | [${widget.game.currentSector.displayName}]',
                                style: TextStyle(
                                  fontSize: 9.5,
                                  fontWeight: FontWeight.w900,
                                  color:
                                      widget.game.currentSector.primaryAccent,
                                  letterSpacing: 1.0,
                                  fontFamily: 'monospace',
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),

                  // Center: Test Mode Immortal Badge & Active Booster Timers
                  Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      if (widget.game.godMode)
                        CustomPaint(
                          painter: _HexagonBadgeBorderPainter(
                            borderColor: const Color(0xFF00E5FF),
                            glowColor: const Color(
                              0xFF00E5FF,
                            ).withValues(alpha: 0.45),
                          ),
                          child: Container(
                            padding: const EdgeInsets.symmetric(
                              horizontal: 14,
                              vertical: 8,
                            ),
                            child: Row(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                // Hex Shield Icon Badge
                                Container(
                                  padding: const EdgeInsets.all(5),
                                  decoration: BoxDecoration(
                                    shape: BoxShape.circle,
                                    color: const Color(
                                      0xFF00E5FF,
                                    ).withValues(alpha: 0.2),
                                    border: Border.all(
                                      color: const Color(0xFF00E5FF),
                                      width: 1.5,
                                    ),
                                  ),
                                  child: const Icon(
                                    Icons.shield_rounded,
                                    color: Color(0xFF00E5FF),
                                    size: 16,
                                  ),
                                ),
                                const SizedBox(width: 10),
                                const Text(
                                  'TEST MODE: IMMORTAL',
                                  style: TextStyle(
                                    color: Color(0xFF00E5FF),
                                    fontWeight: FontWeight.w900,
                                    fontSize: 13,
                                    letterSpacing: 1.5,
                                    fontFamily: 'monospace',
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ),
                      ListenableBuilder(
                        listenable: widget.game.boosterManager,
                        builder: (context, _) {
                          final bm = widget.game.boosterManager;
                          return Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              if (bm.isMatrixActive)
                                _buildActiveTimerBadge(
                                  icon: Icons.timer_rounded,
                                  label:
                                      '${bm.matrixTimeRemaining.toStringAsFixed(1)}s',
                                  color: AppConstants.matrixGreen,
                                ),
                              if (bm.isInvisibilityActive)
                                _buildActiveTimerBadge(
                                  icon: Icons.visibility_off_rounded,
                                  label:
                                      '${bm.invisibilityTimeRemaining.toStringAsFixed(1)}s',
                                  color: AppConstants.stealthBlue,
                                ),
                            ],
                          );
                        },
                      ),
                    ],
                  ),

                  // Right: Currency & Sci-Fi Pause Button
                  Row(
                    children: [
                      // Faceted 3D Gold Diamond Pill
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 14,
                          vertical: 8,
                        ),
                        decoration: BoxDecoration(
                          color: const Color(
                            0xFF0B0E17,
                          ).withValues(alpha: 0.90),
                          borderRadius: BorderRadius.circular(10),
                          border: Border.all(
                            color: AppConstants.coinGold.withValues(alpha: 0.7),
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
                            // 3D Faceted Diamond Icon
                            CustomPaint(
                              size: const Size(18, 20),
                              painter: _FacetedDiamondPainter(),
                            ),
                            const SizedBox(width: 8),
                            Text(
                              '${saveService.player.cubePoints.value}',
                              style: const TextStyle(
                                fontSize: 18,
                                fontWeight: FontWeight.w900,
                                color: Colors.white,
                                fontFamily: 'monospace',
                                letterSpacing: 1.2,
                              ),
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(width: 12),
                      // Sci-Fi Chamfered Pause Button
                      GestureDetector(
                        behavior: HitTestBehavior.opaque,
                        onTap: () {
                          AudioService().playClick();
                          widget.game.pauseGame();
                        },
                        child: CustomPaint(
                          painter: _SciFiSquareBorderPainter(
                            color: const Color(0xFF00E5FF),
                          ),
                          child: Container(
                            width: 46,
                            height: 46,
                            alignment: Alignment.center,
                            child: const Icon(
                              Icons.pause_rounded,
                              color: Colors.white,
                              size: 28,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),

            // 2. Left Booster Dock: Quick Activate
            Positioned(
              left: 20,
              bottom: 24,
              child: Column(
                children: [
                  _buildBoosterPill(
                    type: BoosterType.safeGround,
                    icon: Icons.shield_rounded,
                    color: AppConstants.stealthBlue,
                    count:
                        saveService
                            .player
                            .boosters[BoosterType.safeGround]
                            ?.value ??
                        0,
                    onTap: () {
                      if (saveService.useBooster(BoosterType.safeGround)) {
                        widget.game.boosterManager.activateBooster(
                          BoosterType.safeGround,
                        );
                        AudioService().playBooster();
                      }
                    },
                  ),
                  const SizedBox(height: 10),
                  _buildBoosterPill(
                    type: BoosterType.matrixSlowMo,
                    icon: Icons.slow_motion_video_rounded,
                    color: AppConstants.matrixGreen,
                    count:
                        saveService
                            .player
                            .boosters[BoosterType.matrixSlowMo]
                            ?.value ??
                        0,
                    onTap: () {
                      if (saveService.useBooster(BoosterType.matrixSlowMo)) {
                        widget.game.boosterManager.activateBooster(
                          BoosterType.matrixSlowMo,
                        );
                        AudioService().playBooster();
                      }
                    },
                  ),
                  const SizedBox(height: 10),
                  _buildBoosterPill(
                    type: BoosterType.invisibility,
                    icon: Icons.visibility_off_rounded,
                    color: const Color(0xFFD500F9),
                    count:
                        saveService
                            .player
                            .boosters[BoosterType.invisibility]
                            ?.value ??
                        0,
                    onTap: () {
                      if (saveService.useBooster(BoosterType.invisibility)) {
                        widget.game.boosterManager.activateBooster(
                          BoosterType.invisibility,
                        );
                        AudioService().playBooster();
                      }
                    },
                  ),
                ],
              ),
            ),

            // 3. Right Action Touch Controls: Slide & Jump (Exact Dual-Ring Neon Pedals from Screenshot)
            Positioned(
              right: 24,
              bottom: 24,
              child: Row(
                children: [
                  // SLIDE Neon Pedal (Hot Pink / Magenta Dual-Ring)
                  GestureDetector(
                    behavior: HitTestBehavior.opaque,
                    onTapDown: (_) => _triggerSlide(),
                    onTap: () => _triggerSlide(),
                    onTapUp: (_) => widget.game.player.stopSlide(),
                    onTapCancel: () => widget.game.player.stopSlide(),
                    child: Container(
                      width: 82,
                      height: 82,
                      decoration: BoxDecoration(
                        color: const Color(0xFF0F131D).withValues(alpha: 0.90),
                        shape: BoxShape.circle,
                        border: Border.all(
                          color: const Color(0xFFFF007F),
                          width: 2.4,
                        ),
                        boxShadow: [
                          BoxShadow(
                            color: const Color(
                              0xFFFF007F,
                            ).withValues(alpha: 0.45),
                            blurRadius: 18,
                            spreadRadius: 2,
                          ),
                        ],
                      ),
                      child: Container(
                        margin: const EdgeInsets.all(4.5),
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          border: Border.all(
                            color: const Color(
                              0xFFFF007F,
                            ).withValues(alpha: 0.5),
                            width: 1.2,
                          ),
                        ),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            CustomPaint(
                              size: const Size(32, 22),
                              painter: _SlideRunnerIconPainter(
                                color: Colors.white,
                              ),
                            ),
                            const SizedBox(height: 3),
                            const Text(
                              'SLASH',
                              style: TextStyle(
                                fontSize: 10,
                                fontWeight: FontWeight.w900,
                                letterSpacing: 1.5,
                                color: Colors.white,
                                fontFamily: 'monospace',
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),
                  const SizedBox(width: 18),

                  // ⚔️ ATTACK — Animated Neon Katana Battle Button
                  GestureDetector(
                    behavior: HitTestBehavior.opaque,
                    onTapDown: (_) => _triggerAttack(),
                    child: AnimatedBuilder(
                      animation: _attackPunchController,
                      builder: (context, _) {
                        final scale = _attackPunchController.isAnimating
                            ? _attackScaleAnim.value
                            : 1.0;
                        final glow = _attackFlashing
                            ? (0.45 + 0.55 * _attackGlowAnim.value).clamp(0.0, 1.0)
                            : 0.45;
                        return Transform.scale(
                          scale: scale,
                          child: Stack(
                            alignment: Alignment.center,
                            children: [
                              // Outer neon ring — crimson red katana aura
                              Container(
                                width: 88,
                                height: 88,
                                decoration: BoxDecoration(
                                  shape: BoxShape.circle,
                                  color: const Color(0xFF0A0C14).withValues(alpha: 0.92),
                                  border: Border.all(
                                    color: _attackFlashing
                                        ? const Color(0xFFFF2A2A)
                                        : const Color(0xFFE53935),
                                    width: 2.6,
                                  ),
                                  boxShadow: [
                                    BoxShadow(
                                      color: const Color(0xFFFF1744).withValues(alpha: glow),
                                      blurRadius: _attackFlashing ? 28 : 16,
                                      spreadRadius: _attackFlashing ? 6 : 2,
                                    ),
                                    BoxShadow(
                                      color: const Color(0xFFFF6D00).withValues(alpha: glow * 0.5),
                                      blurRadius: _attackFlashing ? 44 : 8,
                                      spreadRadius: 0,
                                    ),
                                  ],
                                ),
                              ),
                              // Inner ring
                              Container(
                                width: 74,
                                height: 74,
                                decoration: BoxDecoration(
                                  shape: BoxShape.circle,
                                  border: Border.all(
                                    color: const Color(0xFFFF1744).withValues(alpha: 0.35),
                                    width: 1.2,
                                  ),
                                ),
                              ),
                              // Center content: katana icon + label
                              Column(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  // Custom Katana Sword Painter
                                  CustomPaint(
                                    size: const Size(34, 34),
                                    painter: _KatanaSwordPainter(
                                      color: _attackFlashing
                                          ? Colors.white
                                          : const Color(0xFFFF6D6D),
                                      glowColor: _attackFlashing
                                          ? const Color(0xFFFF1744)
                                          : const Color(0xFFE53935),
                                    ),
                                  ),
                                  const SizedBox(height: 3),
                                  Text(
                                    '斬',
                                    style: TextStyle(
                                      fontSize: 8,
                                      fontWeight: FontWeight.w900,
                                      letterSpacing: 0.5,
                                      color: _attackFlashing
                                          ? Colors.white
                                          : const Color(0xFFFF6D6D),
                                      fontFamily: 'monospace',
                                    ),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        );
                      },
                    ),
                  ),
                  const SizedBox(width: 18),


                  // JUMP Neon Pedal (Golden / Orange Glowing Dual-Ring)
                  GestureDetector(
                    behavior: HitTestBehavior.opaque,
                    onTapDown: (_) => _triggerJump(),
                    onTap: () => _triggerJump(),
                    child: AnimatedBuilder(
                      animation: _pulseController,
                      builder: (context, child) {
                        return Container(
                          width: 92,
                          height: 92,
                          decoration: BoxDecoration(
                            color: const Color(
                              0xFF0F131D,
                            ).withValues(alpha: 0.90),
                            shape: BoxShape.circle,
                            border: Border.all(
                              color: const Color(0xFFFFB300),
                              width: 2.8,
                            ),
                            boxShadow: [
                              BoxShadow(
                                color: const Color(0xFFFFB300).withValues(
                                  alpha:
                                      0.50 +
                                      0.25 * sin(_pulseController.value * pi),
                                ),
                                blurRadius: 22,
                                spreadRadius: 3,
                              ),
                            ],
                          ),
                          child: Container(
                            margin: const EdgeInsets.all(5.0),
                            decoration: BoxDecoration(
                              shape: BoxShape.circle,
                              border: Border.all(
                                color: const Color(
                                  0xFFFFB300,
                                ).withValues(alpha: 0.5),
                                width: 1.2,
                              ),
                            ),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                CustomPaint(
                                  size: const Size(28, 26),
                                  painter: _JumpRunnerIconPainter(
                                    color: Colors.white,
                                  ),
                                ),
                                const SizedBox(height: 2),
                                const Text(
                                  'JUMP',
                                  style: TextStyle(
                                    fontSize: 11,
                                    fontWeight: FontWeight.w900,
                                    letterSpacing: 1.8,
                                    color: Colors.white,
                                    fontFamily: 'monospace',
                                  ),
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

            // 4. Holographic Sector Transition Announcement Banner
            if (_announcedSector != null)
              Positioned(
                top: 80,
                left: 0,
                right: 0,
                child: IgnorePointer(
                  ignoring: true,
                  child: Center(
                    child: FadeTransition(
                      opacity: _sectorBannerOpacity,
                      child: SlideTransition(
                        position: _sectorBannerSlide,
                        child: Container(
                          padding: const EdgeInsets.symmetric(
                            horizontal: 24,
                            vertical: 12,
                          ),
                          decoration: BoxDecoration(
                            color: const Color(
                              0xFF0A0E17,
                            ).withValues(alpha: 0.94),
                            borderRadius: BorderRadius.circular(14),
                            border: Border.all(
                              color: _announcedSector!.primaryAccent,
                              width: 1.8,
                            ),
                            boxShadow: [
                              BoxShadow(
                                color: _announcedSector!.primaryAccent
                                    .withValues(alpha: 0.35),
                                blurRadius: 20,
                                spreadRadius: 2,
                              ),
                            ],
                          ),
                          child: Column(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Row(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  Icon(
                                    Icons.sensors_rounded,
                                    color: _announcedSector!.primaryAccent,
                                    size: 15,
                                  ),
                                  const SizedBox(width: 8),
                                  Text(
                                    '// ENTERING ${_announcedSector!.sectorTag} //',
                                    style: TextStyle(
                                      color: _announcedSector!.primaryAccent,
                                      fontSize: 11,
                                      fontWeight: FontWeight.w900,
                                      letterSpacing: 2.0,
                                    ),
                                  ),
                                ],
                              ),
                              const SizedBox(height: 4),
                              Text(
                                _announcedSector!.displayName,
                                style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 18,
                                  fontWeight: FontWeight.w900,
                                  letterSpacing: 2.5,
                                ),
                              ),
                              Text(
                                _announcedSector!.subtitle,
                                style: TextStyle(
                                  color: Colors.white.withValues(alpha: 0.6),
                                  fontSize: 10,
                                  fontWeight: FontWeight.bold,
                                  letterSpacing: 1.2,
                                ),
                              ),
                            ],
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
              ),
          ],
        ),
      ),
    );
  }

  Widget _buildActiveTimerBadge({
    required IconData icon,
    required String label,
    required Color color,
  }) {
    return Container(
      margin: const EdgeInsets.symmetric(horizontal: 4),
      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 6),
      decoration: BoxDecoration(
        color: color.withValues(alpha: 0.18),
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: color, width: 1.2),
      ),
      child: Row(
        children: [
          Icon(icon, color: color, size: 14),
          const SizedBox(width: 5),
          Text(
            label,
            style: TextStyle(
              color: color,
              fontWeight: FontWeight.w900,
              fontSize: 12,
              fontFamily: 'monospace',
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildBoosterPill({
    required BoosterType type,
    required IconData icon,
    required Color color,
    required int count,
    required VoidCallback onTap,
  }) {
    final hasStock = count > 0;

    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: () {
        if (hasStock) {
          onTap();
        } else {
          AudioService().playClick();
          ScaffoldMessenger.of(context).hideCurrentSnackBar();
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              backgroundColor: const Color(0xFF141926),
              duration: const Duration(milliseconds: 1200),
              behavior: SnackBarBehavior.floating,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(12),
                side: BorderSide(color: color.withValues(alpha: 0.5)),
              ),
              content: Text(
                'NO MODULES LEFT: Re-arm in Hangar!',
                style: TextStyle(
                  fontSize: 11,
                  fontWeight: FontWeight.bold,
                  color: color,
                ),
              ),
            ),
          );
        }
      },
      child: CustomPaint(
        painter: _HexagonBoosterPainter(
          borderColor: hasStock ? color : Colors.white24,
          glowColor: hasStock
              ? color.withValues(alpha: 0.35)
              : Colors.transparent,
        ),
        child: SizedBox(
          width: 54,
          height: 60,
          child: Stack(
            alignment: Alignment.center,
            children: [
              Icon(icon, color: hasStock ? color : Colors.white24, size: 24),
              Positioned(
                right: 0,
                bottom: 12,
                child: Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 5,
                    vertical: 1,
                  ),
                  decoration: BoxDecoration(
                    color: Colors.transparent,
                    borderRadius: BorderRadius.circular(4),
                  ),
                  child: Text(
                    '$count',
                    style: TextStyle(
                      fontSize: 14,
                      fontWeight: FontWeight.w900,
                      color: hasStock ? Colors.white : Colors.white38,
                      fontFamily: 'monospace',
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

/// Exact Sci-Fi Beveled Chamfered Card Border Painter
class _SciFiCardBorderPainter extends CustomPainter {
  final Color borderColor;
  final Color glowColor;

  _SciFiCardBorderPainter({required this.borderColor, required this.glowColor});

  @override
  void paint(Canvas canvas, Size size) {
    const cut = 14.0;
    final path = Path()
      ..moveTo(cut, 0)
      ..lineTo(size.width - cut, 0)
      ..lineTo(size.width, cut)
      ..lineTo(size.width, size.height - cut)
      ..lineTo(size.width - cut, size.height)
      ..lineTo(cut, size.height)
      ..lineTo(0, size.height - cut)
      ..lineTo(0, cut)
      ..close();

    final bgPaint = Paint()
      ..color = const Color(0xFF080C14).withValues(alpha: 0.90)
      ..style = PaintingStyle.fill;
    canvas.drawPath(path, bgPaint);

    final glowPaint = Paint()
      ..color = glowColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 3.5
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawPath(path, glowPaint);

    final linePaint = Paint()
      ..color = borderColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.8;
    canvas.drawPath(path, linePaint);

    // Corner tech notches
    final notchPaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.8)
      ..strokeWidth = 2.5;
    canvas.drawLine(const Offset(0, cut), const Offset(cut, 0), notchPaint);
    canvas.drawLine(
      Offset(size.width - cut, 0),
      Offset(size.width, cut),
      notchPaint,
    );
  }

  @override
  bool shouldRepaint(covariant _SciFiCardBorderPainter oldDelegate) =>
      oldDelegate.borderColor != borderColor;
}

/// Chamfered Pill Border
class _SciFiPillBorderPainter extends CustomPainter {
  final Color color;

  _SciFiPillBorderPainter({required this.color});

  @override
  void paint(Canvas canvas, Size size) {
    const cut = 6.0;
    final path = Path()
      ..moveTo(cut, 0)
      ..lineTo(size.width - cut, 0)
      ..lineTo(size.width, cut)
      ..lineTo(size.width, size.height - cut)
      ..lineTo(size.width - cut, size.height)
      ..lineTo(cut, size.height)
      ..lineTo(0, size.height - cut)
      ..lineTo(0, cut)
      ..close();

    final bgPaint = Paint()
      ..color = color.withValues(alpha: 0.15)
      ..style = PaintingStyle.fill;
    canvas.drawPath(path, bgPaint);

    final borderPaint = Paint()
      ..color = color.withValues(alpha: 0.7)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;
    canvas.drawPath(path, borderPaint);
  }

  @override
  bool shouldRepaint(covariant _SciFiPillBorderPainter oldDelegate) => false;
}

/// Hexagonal Badge Border Painter (for Test Mode)
class _HexagonBadgeBorderPainter extends CustomPainter {
  final Color borderColor;
  final Color glowColor;

  _HexagonBadgeBorderPainter({
    required this.borderColor,
    required this.glowColor,
  });

  @override
  void paint(Canvas canvas, Size size) {
    const cut = 12.0;
    final path = Path()
      ..moveTo(cut, 0)
      ..lineTo(size.width - cut, 0)
      ..lineTo(size.width, size.height / 2)
      ..lineTo(size.width - cut, size.height)
      ..lineTo(cut, size.height)
      ..lineTo(0, size.height / 2)
      ..close();

    final bgPaint = Paint()
      ..color = const Color(0xFF06141D).withValues(alpha: 0.92)
      ..style = PaintingStyle.fill;
    canvas.drawPath(path, bgPaint);

    final glowPaint = Paint()
      ..color = glowColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 3.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6);
    canvas.drawPath(path, glowPaint);

    final strokePaint = Paint()
      ..color = borderColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    canvas.drawPath(path, strokePaint);
  }

  @override
  bool shouldRepaint(covariant _HexagonBadgeBorderPainter oldDelegate) => false;
}

/// Hexagonal Booster Pill
class _HexagonBoosterPainter extends CustomPainter {
  final Color borderColor;
  final Color glowColor;

  _HexagonBoosterPainter({required this.borderColor, required this.glowColor});

  @override
  void paint(Canvas canvas, Size size) {
    final w = size.width;
    final h = size.height;
    final path = Path()
      ..moveTo(w * 0.5, 0)
      ..lineTo(w, h * 0.25)
      ..lineTo(w, h * 0.75)
      ..lineTo(w * 0.5, h)
      ..lineTo(0, h * 0.75)
      ..lineTo(0, h * 0.25)
      ..close();

    final bg = Paint()
      ..color = const Color(0xFF090D17).withValues(alpha: 0.90)
      ..style = PaintingStyle.fill;
    canvas.drawPath(path, bg);

    final glow = Paint()
      ..color = glowColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 3.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawPath(path, glow);

    final stroke = Paint()
      ..color = borderColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    canvas.drawPath(path, stroke);
  }

  @override
  bool shouldRepaint(covariant _HexagonBoosterPainter oldDelegate) =>
      oldDelegate.borderColor != borderColor;
}

/// Sci-Fi Square Chamfered Border Painter
class _SciFiSquareBorderPainter extends CustomPainter {
  final Color color;

  _SciFiSquareBorderPainter({required this.color});

  @override
  void paint(Canvas canvas, Size size) {
    const c = 8.0;
    final path = Path()
      ..moveTo(c, 0)
      ..lineTo(size.width - c, 0)
      ..lineTo(size.width, c)
      ..lineTo(size.width, size.height - c)
      ..lineTo(size.width - c, size.height)
      ..lineTo(c, size.height)
      ..lineTo(0, size.height - c)
      ..lineTo(0, c)
      ..close();

    final bg = Paint()
      ..color = const Color(0xFF080C14).withValues(alpha: 0.90)
      ..style = PaintingStyle.fill;
    canvas.drawPath(path, bg);

    final stroke = Paint()
      ..color = color.withValues(alpha: 0.7)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.5;
    canvas.drawPath(path, stroke);
  }

  @override
  bool shouldRepaint(covariant _SciFiSquareBorderPainter oldDelegate) => false;
}

/// 3D Faceted Diamond Painter
class _FacetedDiamondPainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    final w = size.width;
    final h = size.height;
    final midX = w / 2;
    final midY = h / 2;

    // Top facet
    final topFacet = Path()
      ..moveTo(midX, 0)
      ..lineTo(w, midY)
      ..lineTo(midX, midY)
      ..close();
    canvas.drawPath(topFacet, Paint()..color = const Color(0xFFFFD54F));

    final leftFacet = Path()
      ..moveTo(midX, 0)
      ..lineTo(0, midY)
      ..lineTo(midX, midY)
      ..close();
    canvas.drawPath(leftFacet, Paint()..color = const Color(0xFFFFE082));

    // Bottom facets
    final botRightFacet = Path()
      ..moveTo(midX, h)
      ..lineTo(w, midY)
      ..lineTo(midX, midY)
      ..close();
    canvas.drawPath(botRightFacet, Paint()..color = const Color(0xFFFF8F00));

    final botLeftFacet = Path()
      ..moveTo(midX, h)
      ..lineTo(0, midY)
      ..lineTo(midX, midY)
      ..close();
    canvas.drawPath(botLeftFacet, Paint()..color = const Color(0xFFFFB300));

    // Glowing border
    final outline = Path()
      ..moveTo(midX, 0)
      ..lineTo(w, midY)
      ..lineTo(midX, h)
      ..lineTo(0, midY)
      ..close();
    canvas.drawPath(
      outline,
      Paint()
        ..color = Colors.white
        ..style = PaintingStyle.stroke
        ..strokeWidth = 1.2,
    );
  }

  @override
  bool shouldRepaint(covariant _FacetedDiamondPainter oldDelegate) => false;
}

/// Dual Katana Cross-Slash Icon Painter
class _SlideRunnerIconPainter extends CustomPainter {
  final Color color;

  _SlideRunnerIconPainter({required this.color});

  @override
  void paint(Canvas canvas, Size size) {
    // 1. Dual Crossed Blades (Blade 1: Top-Left to Bottom-Right)
    final blade1 = Paint()
      ..color = const Color(0xFFFF007F)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.6
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(size.width * 0.12, size.height * 0.15),
      Offset(size.width * 0.88, size.height * 0.85),
      blade1,
    );

    // Blade 2: Bottom-Left to Top-Right
    canvas.drawLine(
      Offset(size.width * 0.12, size.height * 0.85),
      Offset(size.width * 0.88, size.height * 0.15),
      blade1,
    );

    // White Laser Cutting Edges
    final whiteBlade = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(size.width * 0.28, size.height * 0.28),
      Offset(size.width * 0.84, size.height * 0.82),
      whiteBlade,
    );
    canvas.drawLine(
      Offset(size.width * 0.28, size.height * 0.72),
      Offset(size.width * 0.84, size.height * 0.18),
      whiteBlade,
    );

    // 2. Dynamic Crescent Blade Slash Arc
    final slashArc = Path()
      ..moveTo(size.width * 0.05, size.height * 0.50)
      ..quadraticBezierTo(
        size.width * 0.55,
        size.height * 0.05,
        size.width * 0.95,
        size.height * 0.50,
      );
    final slashPaint = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0
      ..strokeCap = StrokeCap.round;
    canvas.drawPath(slashArc, slashPaint);

    // Central Crossing Rivet
    canvas.drawCircle(
      Offset(size.width * 0.50, size.height * 0.50),
      2.5,
      Paint()..color = Colors.white,
    );
  }

  @override
  bool shouldRepaint(covariant _SlideRunnerIconPainter oldDelegate) => false;
}

/// Jump Runner Silhouette with Up-Arrow Painter
class _JumpRunnerIconPainter extends CustomPainter {
  final Color color;

  _JumpRunnerIconPainter({required this.color});

  @override
  void paint(Canvas canvas, Size size) {
    final p = Paint()
      ..color = color
      ..style = PaintingStyle.fill;

    // Head
    canvas.drawCircle(Offset(size.width * 0.40, size.height * 0.30), 3.8, p);

    // Leaping body
    final body = Path()
      ..moveTo(size.width * 0.38, size.height * 0.38)
      ..lineTo(size.width * 0.50, size.height * 0.55)
      ..lineTo(size.width * 0.60, size.height * 0.88)
      ..lineTo(size.width * 0.50, size.height * 0.88)
      ..lineTo(size.width * 0.42, size.height * 0.65)
      ..lineTo(size.width * 0.22, size.height * 0.82)
      ..lineTo(size.width * 0.15, size.height * 0.72)
      ..lineTo(size.width * 0.30, size.height * 0.52)
      ..close();
    canvas.drawPath(body, p);

    // Up-Forward Arrow
    final arrowPaint = Paint()
      ..color = color
      ..strokeWidth = 2.4
      ..strokeCap = StrokeCap.round
      ..style = PaintingStyle.stroke;
    canvas.drawLine(
      Offset(size.width * 0.65, size.height * 0.55),
      Offset(size.width * 0.85, size.height * 0.18),
      arrowPaint,
    );
    final arrowHead = Path()
      ..moveTo(size.width * 0.70, size.height * 0.18)
      ..lineTo(size.width * 0.85, size.height * 0.18)
      ..lineTo(size.width * 0.85, size.height * 0.33);
    canvas.drawPath(arrowHead, arrowPaint);
  }

  @override
  bool shouldRepaint(covariant _JumpRunnerIconPainter oldDelegate) => false;
}

/// Draws a stylized diagonal katana sword: guard, grip, blade, and glow.
class _KatanaSwordPainter extends CustomPainter {
  final Color color;
  final Color glowColor;

  _KatanaSwordPainter({required this.color, required this.glowColor});

  @override
  void paint(Canvas canvas, Size size) {
    final cx = size.width / 2;
    final cy = size.height / 2;

    // ── Glow halo behind blade ──
    final glowPaint = Paint()
      ..color = glowColor.withValues(alpha: 0.55)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 5.0
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    canvas.drawLine(
      Offset(cx - 10, cy + 12),
      Offset(cx + 12, cy - 14),
      glowPaint,
    );

    // ── Blade (sharp diagonal line) ──
    final bladePaint = Paint()
      ..color = color
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.0
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(cx - 10, cy + 12), // tip bottom-left
      Offset(cx + 12, cy - 14), // point top-right
      bladePaint,
    );

    // ── Bright tip glint ──
    canvas.drawCircle(
      Offset(cx + 12, cy - 14),
      1.8,
      Paint()..color = Colors.white,
    );

    // ── Tsuba (guard) — small diamond ──
    final guardPath = Path()
      ..moveTo(cx - 0.5, cy + 1.5)
      ..lineTo(cx + 3.5, cy - 2)
      ..lineTo(cx + 1, cy - 4.5)
      ..lineTo(cx - 3, cy - 1)
      ..close();
    canvas.drawPath(
      guardPath,
      Paint()
        ..color = color.withValues(alpha: 0.85)
        ..style = PaintingStyle.fill,
    );

    // ── Grip (tsuka) ──
    final gripPaint = Paint()
      ..color = color.withValues(alpha: 0.65)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 3.5
      ..strokeCap = StrokeCap.round;
    canvas.drawLine(
      Offset(cx - 3, cy - 1),
      Offset(cx - 10, cy + 6),
      gripPaint,
    );

    // ── Wrap lines on grip ──
    final wrapPaint = Paint()
      ..color = Colors.white.withValues(alpha: 0.4)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.0;
    for (int i = 0; i < 3; i++) {
      final t = (i + 1) / 4.0;
      final gx = cx - 3 - 7 * t;
      final gy = cy - 1 + 7 * t;
      canvas.drawLine(Offset(gx + 2, gy - 1), Offset(gx - 1, gy + 2), wrapPaint);
    }
  }

  @override
  bool shouldRepaint(covariant _KatanaSwordPainter old) =>
      old.color != color || old.glowColor != glowColor;
}
