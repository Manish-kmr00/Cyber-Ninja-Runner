import 'package:flame/game.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/constants/game_enums.dart';
import '../../core/storage/save_service.dart';
import '../../game/cyber_ninja_game.dart';
import '../overlays/death_overlay.dart';
import '../overlays/hud_overlay.dart';
import '../overlays/pause_overlay.dart';

class GameScreen extends StatefulWidget {
  final GameMode mode;

  const GameScreen({super.key, required this.mode});

  @override
  State<GameScreen> createState() => _GameScreenState();
}

class _GameScreenState extends State<GameScreen> {
  late final CyberNinjaRunnerGame _game;

  @override
  void initState() {
    super.initState();
    final saveService = context.read<SaveService>();
    _game = CyberNinjaRunnerGame(mode: widget.mode, saveService: saveService);
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: false,
      onPopInvokedWithResult: (didPop, result) {
        if (didPop) return;
        if (!_game.isGamePaused && !_game.isGameOver) {
          _game.pauseGame();
        } else if (_game.isGamePaused) {
          _game.resumeGame();
        } else {
          Navigator.of(context).pop();
        }
      },
      child: Scaffold(
        backgroundColor: Colors.black,
        body: GameWidget<CyberNinjaRunnerGame>(
          game: _game,
          initialActiveOverlays: const ['HudOverlay'],
          overlayBuilderMap: {
            'HudOverlay': (context, game) => HudOverlay(game: game),
            'PauseOverlay': (context, game) => PauseOverlay(game: game),
            'DeathOverlay': (context, game) => DeathOverlay(game: game),
          },
        ),
      ),
    );
  }
}
