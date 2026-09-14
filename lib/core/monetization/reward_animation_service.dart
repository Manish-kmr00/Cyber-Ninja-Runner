import 'package:flutter/material.dart';
import '../audio/audio_service.dart';
import '../constants/app_constants.dart';
import 'monetization_events.dart';

/// Pluggable interface for SVGA binary animation rendering.
/// When SVGA assets (.svga) are provided, an implementation of this adapter
/// can be registered to render hardware-accelerated vector animations.
abstract class SvgaAnimationAdapter {
  Widget buildSvgaWidget({
    required String assetPath,
    required double width,
    required double height,
    VoidCallback? onComplete,
  });
}

/// Central service for playing high-impact reward celebration overlays.
class RewardAnimationService {
  static final RewardAnimationService _instance =
      RewardAnimationService._internal();
  factory RewardAnimationService() => _instance;
  RewardAnimationService._internal();

  SvgaAnimationAdapter? _svgaAdapter;

  /// Registers an optional SVGA renderer adapter.
  void registerSvgaAdapter(SvgaAnimationAdapter adapter) {
    _svgaAdapter = adapter;
  }

  bool get hasSvgaSupport => _svgaAdapter != null;

  /// Plays a reward celebration overlay on top of the given [context].
  void play(
    BuildContext context,
    RewardAnimationType type, {
    String? customTitle,
    String? customSubtitle,
    int? count,
  }) {
    // Play appropriate sound effect
    switch (type) {
      case RewardAnimationType.coinReward:
      case RewardAnimationType.doubleReward:
        AudioService().playPurchase();
        break;
      case RewardAnimationType.revive:
        AudioService().playBooster();
        break;
      case RewardAnimationType.treasureCrate:
        AudioService().playCrateOpen();
        break;
    }

    showDialog(
      context: context,
      barrierDismissible: true,
      barrierColor: Colors.black.withValues(alpha: 0.75),
      builder: (dialogCtx) => _RewardCelebrationDialog(
        type: type,
        customTitle: customTitle,
        customSubtitle: customSubtitle,
        count: count,
        svgaAdapter: _svgaAdapter,
      ),
    );
  }
}

class _RewardCelebrationDialog extends StatefulWidget {
  final RewardAnimationType type;
  final String? customTitle;
  final String? customSubtitle;
  final int? count;
  final SvgaAnimationAdapter? svgaAdapter;

  const _RewardCelebrationDialog({
    required this.type,
    this.customTitle,
    this.customSubtitle,
    this.count,
    this.svgaAdapter,
  });

  @override
  State<_RewardCelebrationDialog> createState() =>
      _RewardCelebrationDialogState();
}

class _RewardCelebrationDialogState extends State<_RewardCelebrationDialog>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _scaleAnim;
  late Animation<double> _rotationAnim;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1400),
    );

    _scaleAnim = TweenSequence<double>([
      TweenSequenceItem(
        tween: Tween(
          begin: 0.0,
          end: 1.2,
        ).chain(CurveTween(curve: Curves.easeOutBack)),
        weight: 40,
      ),
      TweenSequenceItem(
        tween: Tween(
          begin: 1.2,
          end: 1.0,
        ).chain(CurveTween(curve: Curves.easeInOut)),
        weight: 60,
      ),
    ]).animate(_controller);

    _rotationAnim = Tween<double>(
      begin: -0.15,
      end: 0.0,
    ).animate(CurvedAnimation(parent: _controller, curve: Curves.easeOutCubic));

    _controller.forward();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final title = widget.customTitle ?? _getDefaultTitle();
    final subtitle = widget.customSubtitle ?? _getDefaultSubtitle();
    final primaryColor = _getPrimaryColor();

    return Center(
      child: AnimatedBuilder(
        animation: _controller,
        builder: (context, child) {
          return Transform.rotate(
            angle: _rotationAnim.value,
            child: Transform.scale(
              scale: _scaleAnim.value,
              child: Container(
                width: 380,
                padding: const EdgeInsets.symmetric(
                  horizontal: 24,
                  vertical: 20,
                ),
                decoration: BoxDecoration(
                  color: const Color(0xFF0C101A).withValues(alpha: 0.98),
                  borderRadius: BorderRadius.circular(24),
                  border: Border.all(
                    color: primaryColor.withValues(alpha: 0.8),
                    width: 2.0,
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: primaryColor.withValues(alpha: 0.4),
                      blurRadius: 35,
                      spreadRadius: 2,
                    ),
                    BoxShadow(
                      color: Colors.black.withValues(alpha: 0.9),
                      blurRadius: 20,
                    ),
                  ],
                ),
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    // Particle Burst Rings
                    Stack(
                      alignment: Alignment.center,
                      children: [
                        // Cyber pulse aura
                        Container(
                          width: 90,
                          height: 90,
                          decoration: BoxDecoration(
                            shape: BoxShape.circle,
                            color: primaryColor.withValues(alpha: 0.15),
                            boxShadow: [
                              BoxShadow(
                                color: primaryColor.withValues(alpha: 0.5),
                                blurRadius: 25,
                              ),
                            ],
                          ),
                        ),
                        // Badge Icon
                        Icon(_getIcon(), size: 48, color: primaryColor),
                      ],
                    ),
                    const SizedBox(height: 16),

                    // Main Title
                    Text(
                      title,
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.w900,
                        color: Colors.white,
                        letterSpacing: 1.5,
                        shadows: [Shadow(color: primaryColor, blurRadius: 15)],
                      ),
                    ),
                    const SizedBox(height: 4),

                    // Subtitle / Amount
                    Text(
                      subtitle,
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 13,
                        fontWeight: FontWeight.w700,
                        color: primaryColor,
                        letterSpacing: 1.0,
                        fontFamily: 'monospace',
                      ),
                    ),
                    const SizedBox(height: 18),

                    // Claim / Dismiss Button
                    SizedBox(
                      width: 160,
                      height: 40,
                      child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          backgroundColor: primaryColor,
                          foregroundColor: Colors.black,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(12),
                          ),
                          elevation: 6,
                        ),
                        onPressed: () {
                          AudioService().playClick();
                          Navigator.of(context).pop();
                        },
                        child: const Text(
                          'CONFIRM',
                          style: TextStyle(
                            fontSize: 12,
                            fontWeight: FontWeight.w900,
                            letterSpacing: 1.2,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          );
        },
      ),
    );
  }

  String _getDefaultTitle() {
    switch (widget.type) {
      case RewardAnimationType.coinReward:
        return 'REWARD PROTOCOL GRANTED';
      case RewardAnimationType.revive:
        return 'SYSTEM OVERCLOCKED';
      case RewardAnimationType.doubleReward:
        return '2X MULTIPLIER UNLOCKED';
      case RewardAnimationType.treasureCrate:
        return 'SUPPLY CRATE DECRYPTED';
    }
  }

  String _getDefaultSubtitle() {
    if (widget.count != null) {
      return '+${widget.count} CYBER POINTS';
    }
    switch (widget.type) {
      case RewardAnimationType.coinReward:
        return 'SUPPLIES CREDITED TO VAULT';
      case RewardAnimationType.revive:
        return 'CHASSIS REPAIRED • RESUMING RUN';
      case RewardAnimationType.doubleReward:
        return 'DOUBLE LOOT BONUS APPLIED';
      case RewardAnimationType.treasureCrate:
        return 'ALL REWARDS CREDITED';
    }
  }

  IconData _getIcon() {
    switch (widget.type) {
      case RewardAnimationType.coinReward:
        return Icons.diamond_rounded;
      case RewardAnimationType.revive:
        return Icons.bolt_rounded;
      case RewardAnimationType.doubleReward:
        return Icons.flash_on_rounded;
      case RewardAnimationType.treasureCrate:
        return Icons.inventory_2_rounded;
    }
  }

  Color _getPrimaryColor() {
    switch (widget.type) {
      case RewardAnimationType.coinReward:
      case RewardAnimationType.doubleReward:
        return AppConstants.coinGold;
      case RewardAnimationType.revive:
        return const Color(0xFF00E5FF);
      case RewardAnimationType.treasureCrate:
        return const Color(0xFFA855F7);
    }
  }
}
