import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../hazards/base_hazard.dart';
import '../hazards/dark_box.dart';
import '../sqube_game.dart';

/// Temporary melee attack hitbox that appears in front of the ninja
/// for _activeFor seconds, destroying any enemy or obstacle it overlaps.
class AttackHitbox extends PositionComponent with HasGameReference<SqubeGame> {
  static const double _activeFor = 0.20; // seconds hitbox stays active
  double _timer = _activeFor;
  bool _hasHit = false; // prevent multi-frame duplicate kills

  final List<_SlashArc> _arcs = [];
  final Random _rng = Random();

  AttackHitbox(Vector2 playerPos, Vector2 playerSize)
    : super(
        position: Vector2(
          playerPos.x + playerSize.x / 2 + 20,
          playerPos.y - playerSize.y,
        ),
        size: Vector2(60, 80),
        priority: 110,
      ) {
    for (int i = 0; i < 5; i++) {
      _arcs.add(_SlashArc(rng: _rng));
    }
  }

  @override
  void update(double dt) {
    super.update(dt);
    _timer -= dt;
    for (final arc in _arcs) {
      arc.alpha -= dt * 4.0;
    }

    if (_timer <= 0) {
      removeFromParent();
      return;
    }

    if (_hasHit) return; // already destroyed something this frame

    final hitRect = Rect.fromLTWH(position.x, position.y, size.x, size.y);

    for (final chunk in game.worldGen.activeChunks) {
      final toRemove = <BaseHazard>[];
      for (final hazard in chunk.hazards) {
        final hWorld = hazard.worldPosition;
        final hRect = Rect.fromLTWH(
          hWorld.x - hazard.size.x / 2,
          hWorld.y - hazard.size.y,
          hazard.size.x,
          hazard.size.y,
        );
        if (hitRect.overlaps(hRect)) {
          if (hazard is DarkBox) {
            if (!hazard.isSliced) {
              hazard.sliceAndDestroy();
              game.shakeCamera(0.55);
              AudioService().playSfx('laser');
              _awardPoints(25, 50);
            }
          } else {
            toRemove.add(hazard);
            game.shakeCamera(0.40);
            AudioService().playClick();
            _awardPoints(15, 30);
          }
          _hasHit = true;
        }
      }
      for (final h in toRemove) {
        h.removeFromParent();
        chunk.hazards.remove(h);
      }
    }
  }

  void _awardPoints(int normal, int tenX) {
    final bonus = game.mode.name == 'tenXChallenge' ? tenX : normal;
    game.collectedCP += bonus;
    game.saveService.addCubePoints(bonus);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);
    for (final arc in _arcs) {
      if (arc.alpha <= 0) continue;
      final paint = Paint()
        ..color = AppConstants.stealthBlue.withValues(alpha: arc.alpha.clamp(0.0, 1.0))
        ..style = PaintingStyle.stroke
        ..strokeWidth = arc.width
        ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);
      canvas.drawArc(
        Rect.fromCenter(
          center: Offset(0, size.y / 2),
          width: arc.radius * 2,
          height: arc.radius * 2,
        ),
        arc.startAngle,
        arc.sweepAngle,
        false,
        paint,
      );
    }
  }
}

class _SlashArc {
  final double radius;
  final double startAngle;
  final double sweepAngle;
  final double width;
  double alpha;

  _SlashArc({required Random rng})
    : radius = 24.0 + rng.nextDouble() * 24.0,
      startAngle = -pi / 2 + (rng.nextDouble() - 0.5) * 0.8,
      sweepAngle = pi * 0.5 + rng.nextDouble() * 0.5,
      width = 2.0 + rng.nextDouble() * 3.0,
      alpha = 0.85 + rng.nextDouble() * 0.15;
}
