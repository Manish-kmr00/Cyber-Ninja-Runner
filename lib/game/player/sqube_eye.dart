import 'dart:math';
import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import '../../core/constants/app_constants.dart';

/// Procedural eye pupil that rotates and gazes towards motion vectors and threats.
class CyberNinjaRunnerEye extends PositionComponent {
  Vector2 gazeDirection = Vector2(1, 0);
  double blinkProgress = 0.0;
  bool isBlinking = false;
  double _blinkTimer = 0.0;

  CyberNinjaRunnerEye({required Vector2 position})
    : super(position: position, size: Vector2(12, 12));

  @override
  void update(double dt) {
    super.update(dt);
    _blinkTimer += dt;
    if (_blinkTimer > 3.5 + (Random().nextDouble() * 2.0)) {
      isBlinking = true;
      _blinkTimer = 0.0;
    }

    if (isBlinking) {
      blinkProgress += dt * 8.0;
      if (blinkProgress >= 1.0) {
        blinkProgress = 0.0;
        isBlinking = false;
      }
    }
  }

  @override
  void render(Canvas canvas) {
    super.render(canvas);

    if (isBlinking && blinkProgress > 0.4 && blinkProgress < 0.6) {
      // Blink line
      final blinkPaint = Paint()
        ..color = AppConstants.eyeIrisBlack
        ..strokeWidth = 2.0
        ..style = PaintingStyle.stroke;
      canvas.drawLine(
        Offset(2, size.y / 2),
        Offset(size.x - 2, size.y / 2),
        blinkPaint,
      );
      return;
    }

    // Outer Sclera (White circle)
    final scleraPaint = Paint()
      ..color = Colors.white
      ..style = PaintingStyle.fill;
    canvas.drawCircle(Offset(size.x / 2, size.y / 2), size.x / 2, scleraPaint);

    // Eyelid / Sclera outline for sharp contrast on white body
    final eyeBorderPaint = Paint()
      ..color = AppConstants.eyeIrisBlack
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    canvas.drawCircle(
      Offset(size.x / 2, size.y / 2),
      size.x / 2,
      eyeBorderPaint,
    );

    // Inner Iris/Pupil (Black circle offset towards gazeDirection)
    final irisOffset = Offset(
      size.x / 2 + gazeDirection.x * 2.5,
      size.y / 2 + gazeDirection.y * 2.5,
    );
    final irisPaint = Paint()
      ..color = AppConstants.eyeIrisBlack
      ..style = PaintingStyle.fill;
    canvas.drawCircle(irisOffset, 3.2, irisPaint);

    // Glint (Tiny white reflection)
    final glintOffset = Offset(irisOffset.dx - 1.0, irisOffset.dy - 1.0);
    final glintPaint = Paint()
      ..color = AppConstants.eyeGlintWhite
      ..style = PaintingStyle.fill;
    canvas.drawCircle(glintOffset, 1.0, glintPaint);
  }
}

typedef CyberNinjaEye = CyberNinjaRunnerEye;
typedef SqubeEye = CyberNinjaRunnerEye;
