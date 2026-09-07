import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
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
      final a = arc.alpha.clamp(0.0, 1.0);
      // Outer glow ring
      canvas.drawArc(
        Rect.fromCenter(
          center: Offset(0, size.y / 2),
          width: arc.radius * 2 + 6,
          height: arc.radius * 2 + 6,
        ),
        arc.startAngle,
        arc.sweepAngle,
        false,
        Paint()
          ..color = const Color(0xFFFF1744).withValues(alpha: a * 0.35)
          ..style = PaintingStyle.stroke
          ..strokeWidth = arc.width + 4
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 6),
      );
      // Core arc (hot red/orange)
      canvas.drawArc(
        Rect.fromCenter(
          center: Offset(0, size.y / 2),
          width: arc.radius * 2,
          height: arc.radius * 2,
        ),
        arc.startAngle,
        arc.sweepAngle,
        false,
        Paint()
          ..color = (arc.isWhite
                  ? Colors.white
                  : const Color(0xFFFF5722))
              .withValues(alpha: a)
          ..style = PaintingStyle.stroke
          ..strokeWidth = arc.width
          ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 2),
      );
    }

    // Diagonal blade streak lines across hitbox
    final t = 1.0 - (_timer / 0.20).clamp(0.0, 1.0); // 0=fresh 1=fading
    final streakAlpha = (1.0 - t * 1.8).clamp(0.0, 0.9);
    if (streakAlpha > 0) {
      for (int i = 0; i < 3; i++) {
        final yOffset = -10.0 + i * 18.0;
        canvas.drawLine(
          Offset(-8, size.y / 2 + yOffset + 10),
          Offset(size.x + 4, size.y / 2 + yOffset - 10),
          Paint()
            ..color = Colors.white.withValues(alpha: streakAlpha * (1.0 - i * 0.25))
            ..strokeWidth = 2.0 - i * 0.4
            ..strokeCap = StrokeCap.round
            ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 1.5),
        );
      }
    }
  }
}

class _SlashArc {
  final double radius;
  final double startAngle;
  final double sweepAngle;
  final double width;
  final bool isWhite;
  double alpha;

  _SlashArc({required Random rng})
    : radius = 18.0 + rng.nextDouble() * 30.0,
      startAngle = -pi * 0.8 + rng.nextDouble() * pi * 0.6,
      sweepAngle = pi * 0.4 + rng.nextDouble() * pi * 0.4,
      width = 1.8 + rng.nextDouble() * 2.8,
      isWhite = rng.nextDouble() > 0.7,
      alpha = 0.9 + rng.nextDouble() * 0.10;
}
