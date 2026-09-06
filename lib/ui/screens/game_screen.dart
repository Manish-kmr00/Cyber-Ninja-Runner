import 'package:flame/game.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/constants/game_enums.dart';
import '../../core/storage/save_service.dart';
import '../../game/sqube_game.dart';
import '../overlays/death_overlay.dart';
import '../overlays/hud_overlay.dart';
import '../overlays/pause_overlay.dart';

class GameScreen extends StatelessWidget {
  final GameMode mode;

  const GameScreen({super.key, required this.mode});

  @override
  Widget build(BuildContext context) {
    final saveService = context.read<SaveService>();

    return Scaffold(
      backgroundColor: Colors.black,
      body: GameWidget<SqubeGame>(
        game: SqubeGame(mode: mode, saveService: saveService),
        initialActiveOverlays: const ['HudOverlay'],
        overlayBuilderMap: {
          'HudOverlay': (context, game) => HudOverlay(game: game),
          'PauseOverlay': (context, game) => PauseOverlay(game: game),
          'DeathOverlay': (context, game) => DeathOverlay(game: game),
        },
      ),
    );
  }
}
