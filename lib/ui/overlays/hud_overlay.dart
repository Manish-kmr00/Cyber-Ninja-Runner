import '../../core/localization/app_localizations.dart';
import 'dart:math';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/gameplay/difficulty/difficulty_config.dart';
import '../../core/storage/save_service.dart';
import '../../game/cyber_ninja_game.dart';

class HudOverlay extends StatefulWidget {
  final CyberNinjaRunnerGame game;

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

  late final AnimationController _milestoneBannerController;
  late final Animation<double> _milestoneBannerOpacity;
  late final Animation<Offset> _milestoneBannerSlide;
  MilestoneThreshold? _announcedMilestone;
  bool _showDebugOverlay = false;

  Offset? _swipeStartOffset;
  bool _swipeActionTriggered = false;

  int _lastJumpTime = 0;
  void _triggerJump() {
    final now = DateTime.now().millisecondsSinceEpoch;
    if (now - _lastJumpTime < 160) return;
    _lastJumpTime = now;
    widget.game.player.jump();
  }

  void _triggerSlide() {
    widget.game.player.startSlide();
  }

  @override
  void initState() {
    super.initState();
    _pulseController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1400),
    )..repeat(reverse: true);

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

    widget.game.onCPChanged = () {
      if (mounted) setState(() {});
    };

    widget.game.onSectorChanged = (newSector) {
      if (mounted) {
        setState(() {
          _announcedSector = newSector;
        });
        _sectorBannerController.forward(from: 0.0);
        Future.delayed(const Duration(milliseconds: 2600), () {
          if (mounted && _announcedSector == newSector) {
            _sectorBannerController.reverse();
          }
        });
      }
    };

    _milestoneBannerController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 500),
    );
    _milestoneBannerController.addStatusListener((status) {
      if (status == AnimationStatus.dismissed) {
        if (mounted) {
          setState(() {
            _announcedMilestone = null;
          });
        }
      }
    });
    _milestoneBannerOpacity = CurvedAnimation(
      parent: _milestoneBannerController,
      curve: Curves.easeOut,
    );
    _milestoneBannerSlide =
        Tween<Offset>(begin: const Offset(0, -0.6), end: Offset.zero).animate(
          CurvedAnimation(
            parent: _milestoneBannerController,
            curve: Curves.easeOutCubic,
          ),
        );

    widget.game.difficultyManager.onMilestoneReached = (milestone) {
      if (mounted) {
        setState(() {
          _announcedMilestone = milestone;
        });
        _milestoneBannerController.forward(from: 0.0);
        AudioService().playAlert();
        Future.delayed(const Duration(milliseconds: 2800), () {
          if (mounted && _announcedMilestone == milestone) {
            _milestoneBannerController.reverse();
          }
        });
      }
    };
  }

  @override
  void dispose() {
    _pulseController.dispose();
    _sectorBannerController.dispose();
    _milestoneBannerController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final isSwipeMode =
        saveService.settings.controlScheme == ControlScheme.swipe;
    final bestScore = saveService.stats.getBestForMode(widget.game.mode);

    return SizedBox.expand(
      child: SafeArea(
        child: LayoutBuilder(
          builder: (context, constraints) {
            final screenH = constraints.maxHeight;
            final scale = (screenH / 420.0).clamp(0.72, 1.25);
            final topSpacing = (10.0 * scale).clamp(6.0, 16.0);
            final hPadding = (16.0 * scale).clamp(10.0, 24.0);
            final bottomSpacing = (14.0 * scale).clamp(8.0, 24.0);

            return Stack(
              fit: StackFit.expand,
              children: [
                // 0. Full-Screen Swipe & Gesture Controller (Active in SWIPE mode)
                if (isSwipeMode)
                  Positioned.fill(
                    child: GestureDetector(
                      behavior: HitTestBehavior.translucent,
                      onPanStart: (details) {
                        _swipeStartOffset = details.localPosition;
                        _swipeActionTriggered = false;
                      },
                      onPanUpdate: (details) {
                        if (_swipeStartOffset == null ||
                            _swipeActionTriggered) {
                          return;
                        }
                        final delta =
                            details.localPosition - _swipeStartOffset!;
                        final sensitivity = saveService
                            .settings
                            .swipeSensitivity
                            .clamp(0.4, 2.5);
                        final threshold = 34.0 / sensitivity;

                        if (delta.dy < -threshold) {
                          // Upward flick -> JUMP
                          _swipeActionTriggered = true;
                          _triggerJump();
                        } else if (delta.dy > threshold) {
                          // Downward flick -> SLIDE
                          _swipeActionTriggered = true;
                          _triggerSlide();
                        } else if (delta.dx > threshold * 1.3) {
                          // Forward flick -> SLIDE / DASH
                          _swipeActionTriggered = true;
                          _triggerSlide();
                        }
                      },
                      onPanEnd: (_) {
                        if (_swipeActionTriggered) {
                          widget.game.player.stopSlide();
                        }
                        _swipeStartOffset = null;
                        _swipeActionTriggered = false;
                      },
                      onPanCancel: () {
                        if (_swipeActionTriggered) {
                          widget.game.player.stopSlide();
                        }
                        _swipeStartOffset = null;
                        _swipeActionTriggered = false;
                      },
                      onTapDown: (details) {
                        final screenWidth = MediaQuery.of(context).size.width;
                        if (details.localPosition.dx < screenWidth * 0.5) {
                          // Left side click / tap -> JUMP
                          _triggerJump();
                        } else {
                          // Right side click / tap -> KATANA SLASH
                          _triggerSlide();
                        }
                      },
                      child: Container(color: Colors.transparent),
                    ),
                  ),

                // 1. Top Cyber Telemetry Header
                Positioned(
                  top: topSpacing,
                  left: hPadding,
                  right: hPadding,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      // Distance & Telemetry Display (Exact Sci-Fi Chamfered Frame)
                      GestureDetector(
                        onDoubleTap: kDebugMode
                            ? () => setState(
                                () => _showDebugOverlay = !_showDebugOverlay,
                              )
                            : null,
                        child: CustomPaint(
                          painter: _SciFiCardBorderPainter(
                            borderColor:
                                widget.game.currentSector.primaryAccent,
                            glowColor: widget.game.currentSector.primaryAccent
                                .withValues(alpha: 0.35),
                            cut: (12.0 * scale).clamp(8.0, 16.0),
                          ),
                          child: Container(
                            padding: EdgeInsets.symmetric(
                              horizontal: (14.0 * scale).clamp(10.0, 22.0),
                              vertical: (6.0 * scale).clamp(4.0, 10.0),
                            ),
                            color: Colors.transparent,
                            child: Row(
                              mainAxisSize: MainAxisSize.min,
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  mainAxisSize: MainAxisSize.min,
                                  children: [
                                    Row(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.baseline,
                                      textBaseline: TextBaseline.alphabetic,
                                      children: [
                                        Text(
                                          '${widget.game.currentDistance}',
                                          style: TextStyle(
                                            fontSize: (25.0 * scale).clamp(
                                              18.0,
                                              32.0,
                                            ),
                                            fontWeight: FontWeight.w900,
                                            color: Colors.white,
                                            letterSpacing: 1.0,
                                            fontFamily: 'monospace',
                                          ),
                                        ),
                                        SizedBox(
                                          width: (5.0 * scale).clamp(3.0, 8.0),
                                        ),
                                        Text(
                                          'M',
                                          style: TextStyle(
                                            fontSize: (14.0 * scale).clamp(
                                              11.0,
                                              18.0,
                                            ),
                                            fontWeight: FontWeight.w900,
                                            color: Colors.white,
                                            letterSpacing: 1.0,
                                            fontFamily: 'monospace',
                                          ),
                                        ),
                                      ],
                                    ),
                                    SizedBox(
                                      height: (1.0 * scale).clamp(0.5, 2.0),
                                    ),
                                    Text(
                                      '${context.l10n.tr('sector_best')} $bestScore M',
                                      style: TextStyle(
                                        fontSize: (9.5 * scale).clamp(
                                          7.5,
                                          11.0,
                                        ),
                                        fontWeight: FontWeight.w800,
                                        color: Colors.white.withValues(
                                          alpha: 0.65,
                                        ),
                                        letterSpacing: 1.0,
                                        fontFamily: 'monospace',
                                      ),
                                    ),
                                    SizedBox(
                                      height: (5.0 * scale).clamp(3.0, 7.0),
                                    ),
                                    // Exact Chamfered Sector Pill
                                    CustomPaint(
                                      painter: _SciFiPillBorderPainter(
                                        color: widget
                                            .game
                                            .currentSector
                                            .primaryAccent,
                                        cut: (5.0 * scale).clamp(3.0, 6.0),
                                      ),
                                      child: Container(
                                        padding: EdgeInsets.symmetric(
                                          horizontal: (8.0 * scale).clamp(
                                            6.0,
                                            10.0,
                                          ),
                                          vertical: (2.5 * scale).clamp(
                                            1.5,
                                            4.0,
                                          ),
                                        ),
                                        child: Text(
                                          '${widget.game.currentSector.sectorTag} | [${widget.game.currentSector.displayName}]',
                                          style: TextStyle(
                                            fontSize: (8.5 * scale).clamp(
                                              7.0,
                                              10.0,
                                            ),
                                            fontWeight: FontWeight.w900,
                                            color: widget
                                                .game
                                                .currentSector
                                                .primaryAccent,
                                            letterSpacing: 1.0,
                                            fontFamily: 'monospace',
                                          ),
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                                SizedBox(
                                  width: (10.0 * scale).clamp(6.0, 14.0),
                                ),
                                // Sci-Fi Tech Divider Line
                                Container(
                                  width: 1.2,
                                  height: (48.0 * scale).clamp(38.0, 56.0),
                                  decoration: BoxDecoration(
                                    gradient: LinearGradient(
                                      begin: Alignment.topCenter,
                                      end: Alignment.bottomCenter,
                                      colors: [
                                        widget.game.currentSector.primaryAccent
                                            .withValues(alpha: 0.05),
                                        widget.game.currentSector.primaryAccent
                                            .withValues(alpha: 0.55),
                                        widget.game.currentSector.primaryAccent
                                            .withValues(alpha: 0.05),
                                      ],
                                    ),
                                  ),
                                ),
                                SizedBox(
                                  width: (10.0 * scale).clamp(6.0, 14.0),
                                ),
                                // Animated Cyber Ninja Avatar
                                _AnimatedNinjaAvatar(
                                  accentColor:
                                      widget.game.currentSector.primaryAccent,
                                  scale: scale,
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),

                      // Center: Active Booster Timers
                      Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          ListenableBuilder(
                            listenable: widget.game.boosterManager,
                            builder: (context, _) {
                              final bm = widget.game.boosterManager;
                              return Row(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  if (bm.isSafeGroundActive)
                                    _buildActiveTimerBadge(
                                      icon: Icons.shield_rounded,
                                      label:
                                          '${bm.safeGroundTimeRemaining.toStringAsFixed(1)}s',
                                      color: const Color(0xFF00E5FF),
                                      scale: scale,
                                    ),
                                  if (bm.isMatrixActive)
                                    _buildActiveTimerBadge(
                                      icon: Icons.timer_rounded,
                                      label:
                                          '${bm.matrixTimeRemaining.toStringAsFixed(1)}s',
                                      color: AppConstants.matrixGreen,
                                      scale: scale,
                                    ),
                                  if (bm.isInvisibilityActive)
                                    _buildActiveTimerBadge(
                                      icon: Icons.visibility_off_rounded,
                                      label:
                                          '${bm.invisibilityTimeRemaining.toStringAsFixed(1)}s',
                                      color: AppConstants.stealthBlue,
                                      scale: scale,
                                    ),
                                  if (bm.isEmpShockwaveActive)
                                    _buildActiveTimerBadge(
                                      icon: Icons.electric_bolt_rounded,
                                      label:
                                          'EMP ${bm.empShockwaveTimer.toStringAsFixed(1)}s',
                                      color: const Color(0xFFFF3366),
                                      scale: scale,
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
                            padding: EdgeInsets.symmetric(
                              horizontal: (10.0 * scale).clamp(8.0, 14.0),
                              vertical: (5.0 * scale).clamp(4.0, 8.0),
                            ),
                            decoration: BoxDecoration(
                              color: const Color(
                                0xFF0B0E17,
                              ).withValues(alpha: 0.90),
                              borderRadius: BorderRadius.circular(8),
                              border: Border.all(
                                color: AppConstants.coinGold.withValues(
                                  alpha: 0.7,
                                ),
                                width: 1.2,
                              ),
                              boxShadow: [
                                BoxShadow(
                                  color: AppConstants.coinGold.withValues(
                                    alpha: 0.15,
                                  ),
                                  blurRadius: 8,
                                ),
                              ],
                            ),
                            child: Row(
                              children: [
                                // 3D Faceted Diamond Icon
                                CustomPaint(
                                  size: Size(
                                    (15.0 * scale).clamp(12.0, 18.0),
                                    (17.0 * scale).clamp(14.0, 20.0),
                                  ),
                                  painter: _FacetedDiamondPainter(),
                                ),
                                SizedBox(width: (6.0 * scale).clamp(4.0, 8.0)),
                                Text(
                                  '${saveService.player.cyberPoints.value}',
                                  style: TextStyle(
                                    fontSize: (15.0 * scale).clamp(12.0, 18.0),
                                    fontWeight: FontWeight.w900,
                                    color: Colors.white,
                                    fontFamily: 'monospace',
                                    letterSpacing: 1.1,
                                  ),
                                ),
                              ],
                            ),
                          ),
                          SizedBox(width: (10.0 * scale).clamp(6.0, 12.0)),
                          // Sci-Fi Chamfered Pause Button
                          Material(
                            color: Colors.transparent,
                            child: InkWell(
                              borderRadius: BorderRadius.circular(10),
                              splashColor: const Color(
                                0xFF00E5FF,
                              ).withValues(alpha: 0.3),
                              highlightColor: const Color(
                                0xFF00E5FF,
                              ).withValues(alpha: 0.15),
                              onTap: () {
                                AudioService().playClick();
                                widget.game.pauseGame();
                              },
                              child: Padding(
                                padding: const EdgeInsets.all(2.0),
                                child: CustomPaint(
                                  painter: _SciFiSquareBorderPainter(
                                    color: const Color(0xFF00E5FF),
                                  ),
                                  child: Container(
                                    width: (40.0 * scale).clamp(32.0, 48.0),
                                    height: (40.0 * scale).clamp(32.0, 48.0),
                                    alignment: Alignment.center,
                                    child: Icon(
                                      Icons.pause_rounded,
                                      color: Colors.white,
                                      size: (24.0 * scale).clamp(18.0, 30.0),
                                    ),
                                  ),
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ],
                  ),
                ),

                // 2. Left Booster Dock: Quick Activate & Jump Pedal
                Positioned(
                  left: hPadding,
                  bottom: bottomSpacing,
                  child: Row(
                    crossAxisAlignment: CrossAxisAlignment.end,
                    children: [
                      ListenableBuilder(
                        listenable: widget.game.boosterManager,
                        builder: (context, _) {
                          final bm = widget.game.boosterManager;
                          return Column(
                            mainAxisSize: MainAxisSize.min,
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
                                scale: scale,
                                activeTimeRemaining: bm.safeGroundTimeRemaining,
                                onTap: () {
                                  if (saveService.useBooster(
                                    BoosterType.safeGround,
                                  )) {
                                    widget.game.boosterManager.activateBooster(
                                      BoosterType.safeGround,
                                    );
                                    AudioService().playBooster();
                                    setState(() {});
                                  }
                                },
                              ),
                              SizedBox(height: (5.0 * scale).clamp(3.0, 8.0)),
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
                                scale: scale,
                                activeTimeRemaining: bm.matrixTimeRemaining,
                                onTap: () {
                                  if (saveService.useBooster(
                                    BoosterType.matrixSlowMo,
                                  )) {
                                    widget.game.boosterManager.activateBooster(
                                      BoosterType.matrixSlowMo,
                                    );
                                    AudioService().playBooster();
                                    setState(() {});
                                  }
                                },
                              ),
                              SizedBox(height: (5.0 * scale).clamp(3.0, 8.0)),
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
                                scale: scale,
                                activeTimeRemaining:
                                    bm.invisibilityTimeRemaining,
                                onTap: () {
                                  if (saveService.useBooster(
                                    BoosterType.invisibility,
                                  )) {
                                    widget.game.boosterManager.activateBooster(
                                      BoosterType.invisibility,
                                    );
                                    AudioService().playBooster();
                                    setState(() {});
                                  }
                                },
                              ),
                              SizedBox(height: (5.0 * scale).clamp(3.0, 8.0)),
                              _buildBoosterPill(
                                type: BoosterType.killEyes,
                                icon: Icons.electric_bolt_rounded,
                                color: const Color(0xFFFF3366),
                                count:
                                    saveService
                                        .player
                                        .boosters[BoosterType.killEyes]
                                        ?.value ??
                                    0,
                                scale: scale,
                                activeTimeRemaining: bm.empShockwaveTimer,
                                onTap: () {
                                  if (saveService.useBooster(
                                    BoosterType.killEyes,
                                  )) {
                                    widget.game.triggerEmpShockwave();
                                    setState(() {});
                                  }
                                },
                              ),
                            ],
                          );
                        },
                      ),
                      // Left Action Pedal (Only visible in BUTTONS mode)
                      if (!isSwipeMode) ...[
                        SizedBox(width: (14.0 * scale).clamp(8.0, 18.0)),
                        _buildJumpPedal(
                          saveService.settings.buttonOpacity.clamp(0.4, 1.0),
                          scale,
                        ),
                      ],
                    ],
                  ),
                ),

                // 3. Right Action Touch Control: (Only visible in BUTTONS mode)
                if (!isSwipeMode)
                  Positioned(
                    right: (20.0 * scale).clamp(12.0, 26.0),
                    bottom: bottomSpacing,
                    child: _buildSlashPedal(
                      saveService.settings.buttonOpacity.clamp(0.4, 1.0),
                      scale,
                    ),
                  ),

                // 3b. Swipe Mode Watermark Indicator (Only visible in SWIPE mode)
                if (isSwipeMode)
                  Positioned(
                    right: (20.0 * scale).clamp(12.0, 26.0),
                    bottom: bottomSpacing,
                    child: IgnorePointer(
                      child: Container(
                        padding: EdgeInsets.symmetric(
                          horizontal: (12.0 * scale).clamp(8.0, 16.0),
                          vertical: (6.0 * scale).clamp(4.0, 8.0),
                        ),
                        decoration: BoxDecoration(
                          color: const Color(
                            0xFF0F131D,
                          ).withValues(alpha: 0.65),
                          borderRadius: BorderRadius.circular(8),
                          border: Border.all(
                            color: const Color(
                              0xFF00E5FF,
                            ).withValues(alpha: 0.3),
                            width: 1.0,
                          ),
                        ),
                        child: Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            Icon(
                              Icons.touch_app_rounded,
                              color: const Color(0xFF00E5FF),
                              size: (14.0 * scale).clamp(11.0, 16.0),
                            ),
                            SizedBox(width: (6.0 * scale).clamp(4.0, 8.0)),
                            Text(
                              context.l10n.tr('swipe_hud_hint'),
                              style: TextStyle(
                                color: const Color(
                                  0xFF00E5FF,
                                ).withValues(alpha: 0.8),
                                fontSize: (9.0 * scale).clamp(7.5, 10.5),
                                fontWeight: FontWeight.w700,
                                fontFamily: 'monospace',
                                letterSpacing: 1.0,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),

                // 4. Holographic Sector Transition Announcement Banner
                if (_announcedSector != null)
                  Positioned(
                    top: (55.0 * scale).clamp(36.0, 80.0),
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
                              padding: EdgeInsets.symmetric(
                                horizontal: (20.0 * scale).clamp(14.0, 24.0),
                                vertical: (9.0 * scale).clamp(6.0, 12.0),
                              ),
                              decoration: BoxDecoration(
                                color: const Color(
                                  0xFF0A0E17,
                                ).withValues(alpha: 0.94),
                                borderRadius: BorderRadius.circular(12),
                                border: Border.all(
                                  color: _announcedSector!.primaryAccent,
                                  width: 1.5,
                                ),
                                boxShadow: [
                                  BoxShadow(
                                    color: _announcedSector!.primaryAccent
                                        .withValues(alpha: 0.35),
                                    blurRadius: 18,
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
                                        size: (14.0 * scale).clamp(11.0, 16.0),
                                      ),
                                      SizedBox(
                                        width: (6.0 * scale).clamp(4.0, 8.0),
                                      ),
                                      Text(
                                        '// ENTERING ${_announcedSector!.sectorTag} //',
                                        style: TextStyle(
                                          color:
                                              _announcedSector!.primaryAccent,
                                          fontSize: (10.0 * scale).clamp(
                                            8.5,
                                            11.5,
                                          ),
                                          fontWeight: FontWeight.w900,
                                          letterSpacing: 1.8,
                                        ),
                                      ),
                                    ],
                                  ),
                                  SizedBox(
                                    height: (3.0 * scale).clamp(2.0, 5.0),
                                  ),
                                  Text(
                                    _announcedSector!.displayName,
                                    style: TextStyle(
                                      color: Colors.white,
                                      fontSize: (16.0 * scale).clamp(
                                        13.0,
                                        19.0,
                                      ),
                                      fontWeight: FontWeight.w900,
                                      letterSpacing: 2.2,
                                    ),
                                  ),
                                  Text(
                                    _announcedSector!.subtitle,
                                    style: TextStyle(
                                      color: Colors.white.withValues(
                                        alpha: 0.6,
                                      ),
                                      fontSize: (9.0 * scale).clamp(7.5, 10.5),
                                      fontWeight: FontWeight.bold,
                                      letterSpacing: 1.1,
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

                // 4b. Milestone Announcement Banner
                if (_announcedMilestone != null)
                  Positioned(
                    top: (55.0 * scale).clamp(36.0, 80.0),
                    left: 0,
                    right: 0,
                    child: IgnorePointer(
                      ignoring: true,
                      child: Center(
                        child: FadeTransition(
                          opacity: _milestoneBannerOpacity,
                          child: SlideTransition(
                            position: _milestoneBannerSlide,
                            child: Container(
                              padding: EdgeInsets.symmetric(
                                horizontal: (22.0 * scale).clamp(16.0, 28.0),
                                vertical: (10.0 * scale).clamp(7.0, 14.0),
                              ),
                              decoration: BoxDecoration(
                                color: const Color(
                                  0xFF140810,
                                ).withValues(alpha: 0.95),
                                borderRadius: BorderRadius.circular(12),
                                border: Border.all(
                                  color: AppConstants.hazardRed,
                                  width: 1.8,
                                ),
                                boxShadow: [
                                  BoxShadow(
                                    color: AppConstants.hazardRed.withValues(
                                      alpha: 0.45,
                                    ),
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
                                        Icons.warning_amber_rounded,
                                        color: AppConstants.hazardRed,
                                        size: (15.0 * scale).clamp(12.0, 18.0),
                                      ),
                                      SizedBox(
                                        width: (6.0 * scale).clamp(4.0, 8.0),
                                      ),
                                      Text(
                                        '// THREAT LEVEL ELEVATED //',
                                        style: TextStyle(
                                          color: AppConstants.hazardRed,
                                          fontSize: (10.0 * scale).clamp(
                                            8.5,
                                            11.5,
                                          ),
                                          fontWeight: FontWeight.w900,
                                          letterSpacing: 2.0,
                                        ),
                                      ),
                                    ],
                                  ),
                                  SizedBox(
                                    height: (3.0 * scale).clamp(2.0, 5.0),
                                  ),
                                  Text(
                                    _announcedMilestone!.title,
                                    style: TextStyle(
                                      color: Colors.white,
                                      fontSize: (18.0 * scale).clamp(
                                        14.0,
                                        22.0,
                                      ),
                                      fontWeight: FontWeight.w900,
                                      letterSpacing: 2.5,
                                    ),
                                  ),
                                  Text(
                                    _announcedMilestone!.subtitle,
                                    style: TextStyle(
                                      color: Colors.white70,
                                      fontSize: (9.0 * scale).clamp(7.5, 10.5),
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

                // 5. Development-Only Difficulty Debug Overlay (Gated to kDebugMode)
                if (kDebugMode && _showDebugOverlay)
                  Positioned(
                    top: (55.0 * scale).clamp(40.0, 85.0),
                    right: 14,
                    child: ListenableBuilder(
                      listenable: widget.game.difficultyManager,
                      builder: (context, _) {
                        final s = widget.game.difficultyManager.state;
                        final history = widget
                            .game
                            .difficultyManager
                            .patternSystem
                            .recentPatternHistory;
                        return Container(
                          padding: const EdgeInsets.all(10),
                          decoration: BoxDecoration(
                            color: Colors.black.withValues(alpha: 0.90),
                            borderRadius: BorderRadius.circular(8),
                            border: Border.all(
                              color: AppConstants.stealthBlue,
                              width: 1.2,
                            ),
                            boxShadow: [
                              BoxShadow(
                                color: AppConstants.stealthBlue.withValues(
                                  alpha: 0.3,
                                ),
                                blurRadius: 10,
                              ),
                            ],
                          ),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              const Text(
                                'DIFFICULTY DIRECTOR [DEBUG]',
                                style: TextStyle(
                                  color: AppConstants.matrixGreen,
                                  fontSize: 10,
                                  fontWeight: FontWeight.bold,
                                  letterSpacing: 1.2,
                                ),
                              ),
                              const SizedBox(height: 4),
                              Text(
                                'Dist: ${s.currentDistance}m | Tier: ${s.difficultyTier.name} (Lvl ${s.difficultyLevel})',
                                style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 9.5,
                                ),
                              ),
                              Text(
                                'Speed: ${s.currentForwardSpeed.toStringAsFixed(1)} px/s (${s.speedMultiplier.toStringAsFixed(2)}x)',
                                style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 9.5,
                                ),
                              ),
                              Text(
                                'Density: ${(s.obstacleDensity * 100).toStringAsFixed(0)}% | React: ${s.minReactionTime.toStringAsFixed(2)}s',
                                style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 9.5,
                                ),
                              ),
                              Text(
                                'Near Misses: ${s.nearMissCount} | Streak: ${s.currentRunStreak}',
                                style: const TextStyle(
                                  color: Colors.cyanAccent,
                                  fontSize: 9.5,
                                ),
                              ),
                              Text(
                                'Pattern: ${s.activePatternName}',
                                style: const TextStyle(
                                  color: Colors.amberAccent,
                                  fontSize: 9.5,
                                ),
                              ),
                              if (history.isNotEmpty)
                                Text(
                                  'History: ${history.join(", ")}',
                                  style: const TextStyle(
                                    color: Colors.white54,
                                    fontSize: 8.5,
                                  ),
                                ),
                            ],
                          ),
                        );
                      },
                    ),
                  ),
              ],
            );
          },
        ),
      ),
    );
  }

  Widget _buildActiveTimerBadge({
    required IconData icon,
    required String label,
    required Color color,
    double scale = 1.0,
  }) {
    return Container(
      margin: EdgeInsets.symmetric(horizontal: (3.0 * scale).clamp(2.0, 6.0)),
      padding: EdgeInsets.symmetric(
        horizontal: (8.0 * scale).clamp(6.0, 12.0),
        vertical: (4.0 * scale).clamp(3.0, 7.0),
      ),
      decoration: BoxDecoration(
        color: color.withValues(alpha: 0.18),
        borderRadius: BorderRadius.circular(10),
        border: Border.all(color: color, width: 1.0),
      ),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Icon(icon, color: color, size: (12.0 * scale).clamp(10.0, 15.0)),
          SizedBox(width: (4.0 * scale).clamp(3.0, 6.0)),
          Text(
            label,
            style: TextStyle(
              color: color,
              fontWeight: FontWeight.w900,
              fontSize: (10.5 * scale).clamp(8.5, 12.5),
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
    double scale = 1.0,
    double activeTimeRemaining = 0.0,
  }) {
    final isActive = activeTimeRemaining > 0;
    final hasStock = count > 0;
    final pillW = (44.0 * scale).clamp(36.0, 54.0);
    final pillH = (48.0 * scale).clamp(40.0, 60.0);

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
                context.l10n.tr('no_modules_left'),
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
          borderColor: isActive ? color : (hasStock ? color : Colors.white24),
          glowColor: isActive
              ? color.withValues(alpha: 0.85)
              : (hasStock ? color.withValues(alpha: 0.35) : Colors.transparent),
        ),
        child: SizedBox(
          width: pillW,
          height: pillH,
          child: Stack(
            alignment: Alignment.center,
            children: [
              Icon(
                icon,
                color: isActive
                    ? Colors.white
                    : (hasStock ? color : Colors.white24),
                size: (20.0 * scale).clamp(16.0, 24.0),
              ),
              Positioned(
                right: 0,
                bottom: (8.0 * scale).clamp(6.0, 12.0),
                child: Container(
                  padding: EdgeInsets.symmetric(
                    horizontal: isActive
                        ? (3.0 * scale).clamp(2.0, 5.0)
                        : (4.0 * scale).clamp(3.0, 6.0),
                    vertical: 1,
                  ),
                  decoration: BoxDecoration(
                    color: isActive
                        ? color.withValues(alpha: 0.90)
                        : Colors.transparent,
                    borderRadius: BorderRadius.circular(4),
                  ),
                  child: Text(
                    isActive
                        ? '${activeTimeRemaining.toStringAsFixed(1)}s'
                        : '$count',
                    style: TextStyle(
                      fontSize: isActive
                          ? (8.5 * scale).clamp(7.0, 10.5)
                          : (11.5 * scale).clamp(9.0, 14.0),
                      fontWeight: FontWeight.w900,
                      color: isActive
                          ? Colors.black
                          : (hasStock ? Colors.white : Colors.white38),
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

  Widget _buildJumpPedal(double opacity, [double scale = 1.0]) {
    final pedalSize = (78.0 * scale).clamp(64.0, 92.0);

    return Opacity(
      opacity: opacity,
      child: GestureDetector(
        behavior: HitTestBehavior.opaque,
        onTapDown: (_) => _triggerJump(),
        onTap: () => _triggerJump(),
        child: AnimatedBuilder(
          animation: _pulseController,
          builder: (context, child) {
            return Container(
              width: pedalSize,
              height: pedalSize,
              decoration: BoxDecoration(
                color: const Color(0xFF0F131D).withValues(alpha: 0.90),
                shape: BoxShape.circle,
                border: Border.all(
                  color: const Color(0xFFFFB300),
                  width: (2.4 * scale).clamp(1.8, 2.8),
                ),
                boxShadow: [
                  BoxShadow(
                    color: const Color(0xFFFFB300).withValues(
                      alpha: 0.50 + 0.25 * sin(_pulseController.value * pi),
                    ),
                    blurRadius: (18 * scale).clamp(12.0, 22.0),
                    spreadRadius: (2 * scale).clamp(1.0, 3.0),
                  ),
                ],
              ),
              child: Container(
                margin: EdgeInsets.all((4.0 * scale).clamp(3.0, 5.0)),
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  border: Border.all(
                    color: const Color(0xFFFFB300).withValues(alpha: 0.5),
                    width: 1.0,
                  ),
                ),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    CustomPaint(
                      size: Size(
                        (24.0 * scale).clamp(18.0, 28.0),
                        (22.0 * scale).clamp(16.0, 26.0),
                      ),
                      painter: _JumpRunnerIconPainter(color: Colors.white),
                    ),
                    SizedBox(height: (1.5 * scale).clamp(1.0, 2.5)),
                    Text(
                      context.l10n.tr('jump_label'),
                      style: TextStyle(
                        fontSize: (9.5 * scale).clamp(8.0, 11.5),
                        fontWeight: FontWeight.w900,
                        letterSpacing: 1.5,
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
    );
  }

  Widget _buildSlashPedal(double opacity, [double scale = 1.0]) {
    final pedalSize = (78.0 * scale).clamp(64.0, 92.0);

    return Opacity(
      opacity: opacity,
      child: GestureDetector(
        behavior: HitTestBehavior.opaque,
        onTapDown: (_) => _triggerSlide(),
        onTap: () => _triggerSlide(),
        onTapUp: (_) => widget.game.player.stopSlide(),
        onTapCancel: () => widget.game.player.stopSlide(),
        child: AnimatedBuilder(
          animation: _pulseController,
          builder: (context, child) {
            return Container(
              width: pedalSize,
              height: pedalSize,
              decoration: BoxDecoration(
                color: const Color(0xFF0F131D).withValues(alpha: 0.90),
                shape: BoxShape.circle,
                border: Border.all(
                  color: const Color(0xFFFF007F),
                  width: (2.4 * scale).clamp(1.8, 2.8),
                ),
                boxShadow: [
                  BoxShadow(
                    color: const Color(0xFFFF007F).withValues(
                      alpha: 0.50 + 0.25 * sin(_pulseController.value * pi),
                    ),
                    blurRadius: (18 * scale).clamp(12.0, 22.0),
                    spreadRadius: (2 * scale).clamp(1.0, 3.0),
                  ),
                ],
              ),
              child: Container(
                margin: EdgeInsets.all((4.0 * scale).clamp(3.0, 5.0)),
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  border: Border.all(
                    color: const Color(0xFFFF007F).withValues(alpha: 0.5),
                    width: 1.0,
                  ),
                ),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    CustomPaint(
                      size: Size(
                        (28.0 * scale).clamp(20.0, 34.0),
                        (20.0 * scale).clamp(15.0, 24.0),
                      ),
                      painter: _SlideRunnerIconPainter(color: Colors.white),
                    ),
                    SizedBox(height: (1.5 * scale).clamp(1.0, 2.5)),
                    Text(
                      context.l10n.tr('slash_label'),
                      style: TextStyle(
                        fontSize: (9.5 * scale).clamp(8.0, 11.5),
                        fontWeight: FontWeight.w900,
                        letterSpacing: 1.5,
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
    );
  }
}

/// Animated Cyber Ninja Avatar portrait for HUD telemetry card.
/// Features smooth breathing/hover oscillation, tactical holographic laser scanline sweep,
/// sci-fi chamfered frame with pulsing neon glow, and live operative link status blip.
class _AnimatedNinjaAvatar extends StatefulWidget {
  final Color accentColor;
  final double scale;

  const _AnimatedNinjaAvatar({required this.accentColor, this.scale = 1.0});

  @override
  State<_AnimatedNinjaAvatar> createState() => _AnimatedNinjaAvatarState();
}

class _AnimatedNinjaAvatarState extends State<_AnimatedNinjaAvatar>
    with TickerProviderStateMixin {
  late final AnimationController _breathController;
  late final Animation<double> _breathAnimation;
  late final AnimationController _scanController;
  late final Animation<double> _scanAnimation;

  @override
  void initState() {
    super.initState();
    _breathController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 2200),
    )..repeat(reverse: true);

    _breathAnimation = Tween<double>(begin: 0.96, end: 1.04).animate(
      CurvedAnimation(parent: _breathController, curve: Curves.easeInOutSine),
    );

    _scanController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 2600),
    )..repeat();

    _scanAnimation = Tween<double>(begin: -0.2, end: 1.2).animate(
      CurvedAnimation(parent: _scanController, curve: Curves.easeInOut),
    );
  }

  @override
  void dispose() {
    _breathController.dispose();
    _scanController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final size = (52.0 * widget.scale).clamp(42.0, 62.0);
    final cut = (9.0 * widget.scale).clamp(6.0, 12.0);

    return AnimatedBuilder(
      animation: Listenable.merge([_breathController, _scanController]),
      builder: (context, _) {
        final breath = _breathAnimation.value;
        final scanProgress = _scanAnimation.value;
        final glowAlpha = 0.40 + 0.35 * _breathController.value;

        return Transform.scale(
          scale: breath,
          child: Container(
            width: size,
            height: size,
            decoration: BoxDecoration(
              boxShadow: [
                BoxShadow(
                  color: widget.accentColor.withValues(alpha: glowAlpha * 0.8),
                  blurRadius: 12 * widget.scale,
                  spreadRadius: 1.5 * widget.scale,
                ),
              ],
            ),
            child: Stack(
              clipBehavior: Clip.none,
              children: [
                // Base chamfered ninja image container
                CustomPaint(
                  size: Size(size, size),
                  painter: _SciFiChamferBorderPainter(
                    borderColor: widget.accentColor,
                    glowColor: widget.accentColor.withValues(alpha: glowAlpha),
                    cut: cut,
                  ),
                  child: ClipPath(
                    clipper: _SciFiChamferClipper(cut: cut),
                    child: Stack(
                      fit: StackFit.expand,
                      children: [
                        // Cyber Tech Radial Background
                        Container(
                          decoration: BoxDecoration(
                            gradient: RadialGradient(
                              center: Alignment.center,
                              radius: 0.8,
                              colors: [
                                widget.accentColor.withValues(alpha: 0.30),
                                const Color(0xFF090D18),
                              ],
                            ),
                          ),
                        ),

                        // Ninja Avatar Image (App Icon 512, focused on the glowing cyber ninja)
                        Transform.scale(
                          scale: 1.45,
                          alignment: const Alignment(0.0, -0.65),
                          child: Image.asset(
                            'assets/images/app_icon_512.png',
                            fit: BoxFit.cover,
                            alignment: const Alignment(0.0, -0.65),
                            errorBuilder: (_, _, _) => Center(
                              child: Icon(
                                Icons.sports_martial_arts_rounded,
                                color: widget.accentColor,
                                size: size * 0.7,
                              ),
                            ),
                          ),
                        ),

                        // Subtle outer rim vignette (leaves center face crystal clear)
                        Container(
                          decoration: BoxDecoration(
                            gradient: RadialGradient(
                              center: Alignment.center,
                              radius: 0.82,
                              colors: [
                                Colors.transparent,
                                Colors.black.withValues(alpha: 0.35),
                              ],
                            ),
                          ),
                        ),

                        // Holographic Laser Scanline Sweep
                        if (scanProgress >= 0.0 && scanProgress <= 1.0)
                          Positioned(
                            top: scanProgress * size - 4,
                            left: 0,
                            right: 0,
                            height: 8,
                            child: Container(
                              decoration: BoxDecoration(
                                gradient: LinearGradient(
                                  begin: Alignment.topCenter,
                                  end: Alignment.bottomCenter,
                                  colors: [
                                    widget.accentColor.withValues(alpha: 0.0),
                                    widget.accentColor.withValues(alpha: 0.85),
                                    Colors.white,
                                    widget.accentColor.withValues(alpha: 0.85),
                                    widget.accentColor.withValues(alpha: 0.0),
                                  ],
                                  stops: const [0.0, 0.3, 0.5, 0.7, 1.0],
                                ),
                              ),
                            ),
                          ),
                      ],
                    ),
                  ),
                ),

                // Corner Tech Reticles (Sci-Fi brackets on top-left)
                Positioned(
                  top: -2,
                  left: -2,
                  child: Container(
                    width: 5 * widget.scale,
                    height: 5 * widget.scale,
                    decoration: BoxDecoration(
                      color: widget.accentColor,
                      shape: BoxShape.circle,
                    ),
                  ),
                ),

                // Tactical Status Dot (Bottom Right Pulse)
                Positioned(
                  bottom: -1,
                  right: -1,
                  child: Container(
                    padding: EdgeInsets.symmetric(
                      horizontal: 3.5 * widget.scale,
                      vertical: 1.0 * widget.scale,
                    ),
                    decoration: BoxDecoration(
                      color: const Color(0xFF070A12).withValues(alpha: 0.9),
                      borderRadius: BorderRadius.circular(3),
                      border: Border.all(
                        color: const Color(0xFF00E5FF).withValues(alpha: 0.8),
                        width: 0.8,
                      ),
                    ),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Container(
                          width: 4 * widget.scale,
                          height: 4 * widget.scale,
                          decoration: BoxDecoration(
                            color: const Color(0xFF00E676),
                            shape: BoxShape.circle,
                            boxShadow: [
                              BoxShadow(
                                color: const Color(
                                  0xFF00E676,
                                ).withValues(alpha: 0.8),
                                blurRadius: 4,
                              ),
                            ],
                          ),
                        ),
                        SizedBox(width: 2.5 * widget.scale),
                        Text(
                          'LINK',
                          style: TextStyle(
                            fontSize: (6.5 * widget.scale).clamp(5.0, 8.0),
                            fontWeight: FontWeight.w900,
                            color: const Color(0xFF00E5FF),
                            fontFamily: 'monospace',
                            letterSpacing: 0.5,
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
      },
    );
  }
}

/// Custom Clipper for Chamfered Sci-Fi Polygon
class _SciFiChamferClipper extends CustomClipper<Path> {
  final double cut;

  _SciFiChamferClipper({required this.cut});

  @override
  Path getClip(Size size) {
    final c = cut.clamp(2.0, size.width * 0.35);
    return Path()
      ..moveTo(c, 0)
      ..lineTo(size.width - c, 0)
      ..lineTo(size.width, c)
      ..lineTo(size.width, size.height - c)
      ..lineTo(size.width - c, size.height)
      ..lineTo(c, size.height)
      ..lineTo(0, size.height - c)
      ..lineTo(0, c)
      ..close();
  }

  @override
  bool shouldReclip(covariant _SciFiChamferClipper oldClipper) =>
      oldClipper.cut != cut;
}

/// Custom Border Painter for Chamfered Sci-Fi Polygon
class _SciFiChamferBorderPainter extends CustomPainter {
  final Color borderColor;
  final Color glowColor;
  final double cut;

  _SciFiChamferBorderPainter({
    required this.borderColor,
    required this.glowColor,
    required this.cut,
  });

  @override
  void paint(Canvas canvas, Size size) {
    final c = cut.clamp(2.0, size.width * 0.35);
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

    // Outer Neon Glow
    final glowPaint = Paint()
      ..color = glowColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2.8
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 4);
    canvas.drawPath(path, glowPaint);

    // Sharp Sci-Fi Stroke
    final strokePaint = Paint()
      ..color = borderColor
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.4;
    canvas.drawPath(path, strokePaint);
  }

  @override
  bool shouldRepaint(covariant _SciFiChamferBorderPainter oldDelegate) =>
      oldDelegate.borderColor != borderColor ||
      oldDelegate.glowColor != glowColor ||
      oldDelegate.cut != cut;
}

/// Exact Sci-Fi Beveled Chamfered Card Border Painter
class _SciFiCardBorderPainter extends CustomPainter {
  final Color borderColor;
  final Color glowColor;
  final double cut;

  _SciFiCardBorderPainter({
    required this.borderColor,
    required this.glowColor,
    this.cut = 14.0,
  });

  @override
  void paint(Canvas canvas, Size size) {
    final effectiveCut = cut.clamp(4.0, size.height * 0.4);
    final path = Path()
      ..moveTo(effectiveCut, 0)
      ..lineTo(size.width - effectiveCut, 0)
      ..lineTo(size.width, effectiveCut)
      ..lineTo(size.width, size.height - effectiveCut)
      ..lineTo(size.width - effectiveCut, size.height)
      ..lineTo(effectiveCut, size.height)
      ..lineTo(0, size.height - effectiveCut)
      ..lineTo(0, effectiveCut)
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
    canvas.drawLine(
      Offset(0, effectiveCut),
      Offset(effectiveCut, 0),
      notchPaint,
    );
    canvas.drawLine(
      Offset(size.width - effectiveCut, 0),
      Offset(size.width, effectiveCut),
      notchPaint,
    );
  }

  @override
  bool shouldRepaint(covariant _SciFiCardBorderPainter oldDelegate) =>
      oldDelegate.borderColor != borderColor || oldDelegate.cut != cut;
}

/// Chamfered Pill Border
class _SciFiPillBorderPainter extends CustomPainter {
  final Color color;
  final double cut;

  _SciFiPillBorderPainter({required this.color, this.cut = 6.0});

  @override
  void paint(Canvas canvas, Size size) {
    final effectiveCut = cut.clamp(2.0, size.height * 0.4);
    final path = Path()
      ..moveTo(effectiveCut, 0)
      ..lineTo(size.width - effectiveCut, 0)
      ..lineTo(size.width, effectiveCut)
      ..lineTo(size.width, size.height - effectiveCut)
      ..lineTo(size.width - effectiveCut, size.height)
      ..lineTo(effectiveCut, size.height)
      ..lineTo(0, size.height - effectiveCut)
      ..lineTo(0, effectiveCut)
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
  bool shouldRepaint(covariant _SciFiPillBorderPainter oldDelegate) =>
      oldDelegate.color != color || oldDelegate.cut != cut;
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
