import 'package:flame/components.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/constants/app_constants.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';
import 'package:cyber_ninja_runner/game/cyber_ninja_game.dart';
import 'package:cyber_ninja_runner/game/hazards/cyber_titan.dart';
import 'package:cyber_ninja_runner/game/world/chunk_models.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    SharedPreferences.setMockInitialValues({});
  });

  group('Robot Bullet vs Sword Slash Mechanics Tests', () {
    test(
      'Ninja swinging sword does NOT deflect robot bullet; bullet hits and kills ninja',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        // Clear default world chunks
        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final chunk = WorldChunk(
          startX: 0,
          length: 1000,
          groundY: groundY,
          roofY: 0,
        );
        game.world.add(chunk);
        game.worldGen.activeChunks.add(chunk);

        // Create CyberTitan (Robot boss) at X=400
        final titan = CyberTitan(position: Vector2(400, groundY), maxHp: 3);
        chunk.hazards.add(titan);
        chunk.add(titan);

        // Position player at X=200 on ground
        final targetGroundY = chunk.getSurfaceY(200) - 8.0;
        game.player.position = Vector2(200, targetGroundY);
        game.player.velocity = Vector2(0, 0);
        game.player.isGrounded = true;

        // Make ninja slash with his sword!
        game.player.isSlashing = true;
        expect(game.player.isSlashing, isTrue);

        // Spawn a low plasma round from the robot heading directly at the ninja's chest
        final bulletSpawnPos = Vector2(210 - titan.position.x, -50.0);
        final bullet = TitanPlasmaRound(
          position: bulletSpawnPos,
          velocity: Vector2(-300, 0),
          isHighShot: false,
        );
        titan.activeRounds.add(bullet);

        expect(game.isGameOver, isFalse);

        // Verify that bullet is NOT destroyed in mid-air by the sword
        expect(bullet.isDead, isFalse);
        final collisionBefore = titan.checkCollision(game.player);
        // Sword did NOT destroy the bullet!
        expect(bullet.isDead, isTrue); // Bullet was consumed by collision
        expect(collisionBefore, isTrue); // Collision was detected!

        // Now run a game update tick with collision resolution
        titan.activeRounds.clear();
        final bullet2 = TitanPlasmaRound(
          position: Vector2(200 - titan.position.x, -50.0),
          velocity: Vector2(-300, 0),
          isHighShot: false,
        );
        titan.activeRounds.add(bullet2);

        game.update(0.016);

        // Ninja must DIE from the robot bullet even while slashing!
        expect(game.isGameOver, isTrue);
        expect(game.player.isDead, isTrue);
        expect(game.lastDeathCause, DeathType.hitByTitan);
      },
    );

    test(
      'Ninja slashing Titan directly at close melee range damages the Titan',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final chunk = WorldChunk(
          startX: 0,
          length: 1000,
          groundY: groundY,
          roofY: 0,
        );
        game.world.add(chunk);
        game.worldGen.activeChunks.add(chunk);

        final titan = CyberTitan(position: Vector2(300, groundY), maxHp: 3);
        chunk.hazards.add(titan);
        chunk.add(titan);

        // Place player right in front of Titan within sword reach
        final targetGroundY = chunk.getSurfaceY(280) - 8.0;
        game.player.position = Vector2(280, targetGroundY);
        game.player.isGrounded = true;
        game.player.isSlashing = true;
        game.player.slashTimer = 0.5;

        final initialHp = titan.currentHp;
        game.update(0.016);

        // Player does not die, Titan takes damage
        expect(game.isGameOver, isFalse);
        expect(titan.currentHp, lessThan(initialHp));
      },
    );

    test(
      'Ninja jumping onto or touching robot without slashing dies; robot takes NO damage',
      () async {
        final saveService = SaveService();
        final game = CyberNinjaRunnerGame(
          mode: GameMode.run,
          saveService: saveService,
        );
        game.onGameResize(Vector2(1280, 720));
        await game.onLoad();

        for (final chunk in game.worldGen.activeChunks) {
          chunk.removeFromParent();
        }
        game.worldGen.activeChunks.clear();

        final groundY = AppConstants.virtualHeight - AppConstants.groundHeight;
        final chunk = WorldChunk(
          startX: 0,
          length: 1000,
          groundY: groundY,
          roofY: 0,
        );
        game.world.add(chunk);
        game.worldGen.activeChunks.add(chunk);

        final titan = CyberTitan(position: Vector2(400, groundY), maxHp: 3);
        chunk.hazards.add(titan);
        chunk.add(titan);

        // Place player jumping from above landing directly onto Titan head/body
        game.player.position = Vector2(400, groundY - 80);
        game.player.velocity = Vector2(100, 200); // descending in jump
        game.player.isGrounded = false;
        game.player.isSlashing = false; // NOT swinging sword!

        final initialHp = titan.currentHp;
        game.update(0.016);

        // Ninja dies, Titan takes NO damage!
        expect(game.isGameOver, isTrue);
        expect(game.player.isDead, isTrue);
        expect(game.lastDeathCause, DeathType.hitByTitan);
        expect(titan.currentHp, equals(initialHp));
      },
    );
  });
}
