import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:provider/provider.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/game/cyber_ninja_game.dart';
import 'package:cyber_ninja_runner/ui/overlays/death_overlay.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    SharedPreferences.setMockInitialValues({});
  });

  testWidgets(
    'DeathOverlay renders cleanly without overflow on various screen sizes',
    (tester) async {
      addTearDown(tester.view.resetPhysicalSize);
      addTearDown(tester.view.resetDevicePixelRatio);

      final saveService = SaveService();
      final game = CyberNinjaRunnerGame(
        mode: GameMode.run,
        saveService: saveService,
      );
      game.currentDistance = 450;
      game.collectedCP = 35;

      final testResolutions = [
        const Size(640, 360), // Standard 16:9 compact landscape phone
        const Size(568, 320), // Small budget landscape phone
        const Size(844, 390), // Modern tall 19.5:9 landscape phone
        const Size(920, 360), // Ultra-wide 21:9 landscape phone
        const Size(1024, 768), // Tablet
        const Size(360, 640), // Narrow / portrait fallback
      ];

      for (final size in testResolutions) {
        tester.view.physicalSize = size;
        tester.view.devicePixelRatio = 1.0;

        await tester.pumpWidget(
          MaterialApp(
            home: ChangeNotifierProvider<SaveService>.value(
              value: saveService,
              child: Scaffold(body: DeathOverlay(game: game)),
            ),
          ),
        );
        await tester.pump();

        // Ensure key elements are visible
        expect(find.text('NEURAL LINK SEVERED'), findsOneWidget);
        expect(find.text('RESTART'), findsOneWidget);
        expect(find.byIcon(Icons.videocam_rounded), findsOneWidget);
        expect(find.byIcon(Icons.bolt_rounded), findsOneWidget);

        final exception = tester.takeException();
        expect(exception, isNull, reason: 'Failed layout on size $size');

        tester.view.resetPhysicalSize();
        tester.view.resetDevicePixelRatio();
      }
    },
  );
}
