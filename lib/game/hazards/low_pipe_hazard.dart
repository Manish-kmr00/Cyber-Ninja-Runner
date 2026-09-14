import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/game_enums.dart';
import '../player/runner_player.dart';
import 'base_hazard.dart';

/// Low overhead industrial steam pipe or structural girder.
/// Requires the Cyber Ninja to SLIDE underneath.
/// If the player is sliding, they pass safely below;
/// if standing or jumping, they hit the pipe and collide.
class LowPipeHazard extends BaseHazard {
  double steamTimer = 0.0;
  final double pipeWidth;
  final double pipeHeight;

  LowPipeHazard({
    required super.position,
    this.pipeWidth = 60.0,
    this.pipeHeight = 24.0,
    super.biome,
  }) : super(
         size: Vector2(pipeWidth, pipeHeight),
         obstacleType: ObstacleType.lowPipe,
         deathType: DeathType.crushedByColumn,
         anchor: Anchor.bottomCenter,
       );

  @override
  void update(double dt) {
    super.update(dt);
    steamTimer += dt * 5.0;
  }

  @override
  bool checkCollision(RunnerPlayer player) {
    if (player.isStealthActive) return false;
    // When sliding, the ninja crouches/slides safely below the pipe!
    if (player.isSliding) return false;

    final pos = worldPosition;
    final pRect = Rect.fromLTWH(
      player.position.x - player.size.x / 2 + 10,
      player.position.y - player.size.y + 12,
      player.size.x - 20,
      player.size.y - 12,
    );

    final pipeRect = Rect.fromLTWH(
      pos.x - size.x / 2,
      pos.y - size.y,
      size.x,
      size.y,
    );

    return pRect.overlaps(pipeRect);
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    final accent = biome.primaryAccent;
    final pipeRect = Rect.fromLTWH(-size.x / 2, -size.y, size.x, size.y);

    // 1. Suspension drop brackets from ceiling/framework
    final hangerPaint = Paint()
      ..color = const Color(0xFF263238)
      ..strokeWidth = 3.5;
    canvas.drawLine(
      Offset(-size.x / 2 + 10, -size.y),
      Offset(-size.x / 2 + 10, -size.y - 45),
      hangerPaint,
    );
    canvas.drawLine(
      Offset(size.x / 2 - 10, -size.y),
      Offset(size.x / 2 - 10, -size.y - 45),
      hangerPaint,
    );

    // 2. Heavy Steel Pipe Cylinder (Beveled gradient)
    final pipeGradient = LinearGradient(
      begin: Alignment.topCenter,
      end: Alignment.bottomCenter,
      colors: const [
        Color(0xFF455A64),
        Color(0xFF263238),
        Color(0xFF10171D),
        Color(0xFF37474F),
      ],
      stops: const [0.0, 0.35, 0.75, 1.0],
    ).createShader(pipeRect);

    canvas.drawRRect(
      RRect.fromRectAndRadius(pipeRect, const Radius.circular(5.0)),
      Paint()..shader = pipeGradient,
    );

    // 3. Yellow/Black Hazard Stripes on Pipe Body
    final hazardPaint = Paint()
      ..color = const Color(0xFFFFB300).withValues(alpha: 0.85)
      ..strokeWidth = 4.0;
    for (double x = -size.x / 2 + 6; x < size.x / 2 - 6; x += 14) {
      canvas.drawLine(Offset(x + 6, -size.y + 2), Offset(x, -2), hazardPaint);
    }

    // 4. Pipe Flanges / Couplings at edges
    final flangePaint = Paint()..color = const Color(0xFF1A232A);
    canvas.drawRect(
      Rect.fromLTWH(-size.x / 2 - 2, -size.y - 3, 7, size.y + 6),
      flangePaint,
    );
    canvas.drawRect(
      Rect.fromLTWH(size.x / 2 - 5, -size.y - 3, 7, size.y + 6),
      flangePaint,
    );

    // 5. Warning Downward Arrow Icon / SLIDE prompt
    final arrowPaint = Paint()
      ..color = accent.withValues(alpha: 0.90)
      ..strokeWidth = 2.0
      ..style = PaintingStyle.stroke;
    final arrowY = -size.y / 2;
    final arrowPath = Path()
      ..moveTo(-4, arrowY - 4)
      ..lineTo(0, arrowY + 3)
      ..lineTo(4, arrowY - 4);
    canvas.drawPath(arrowPath, arrowPaint);

    // 6. Escaping High-Pressure Steam Puffs
    final steamAlpha = 0.35 + 0.3 * sin(steamTimer).abs();
    final steamPaint = Paint()
      ..color = Colors.white.withValues(alpha: steamAlpha)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 5);
    final puffOffset = (steamTimer * 10) % 20;
    canvas.drawCircle(Offset(-size.x / 2 + 10, 2 + puffOffset), 5, steamPaint);
    canvas.drawCircle(
      Offset(size.x / 2 - 10, 3 + puffOffset * 0.8),
      6,
      steamPaint,
    );
  }
}
