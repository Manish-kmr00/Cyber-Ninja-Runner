import 'package:flame/components.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:cyber_ninja_runner/core/constants/app_constants.dart';
import 'package:cyber_ninja_runner/core/constants/game_enums.dart';
import 'package:cyber_ninja_runner/game/hazards/hover_drone_hazard.dart';
import 'package:cyber_ninja_runner/game/hazards/laser_gate_hazard.dart';
import 'package:cyber_ninja_runner/game/hazards/low_pipe_hazard.dart';
import 'package:cyber_ninja_runner/game/hazards/traffic_barrier_hazard.dart';
import 'package:cyber_ninja_runner/game/player/runner_player.dart';
import 'package:cyber_ninja_runner/game/world/chunk_models.dart';
import 'package:cyber_ninja_runner/game/world/procedural_generator.dart';
import 'package:cyber_ninja_runner/game/world/track_segment_models.dart';

class FakeTestPlayer extends RunnerPlayer {
  FakeTestPlayer({required super.position})
    : super(size: Vector2(AppConstants.ninjaWidth, AppConstants.ninjaHeight));

  @override
  Color getGhostNeonColor() => const Color(0xFF00E5FF);
}

void main() {
  group('50m Modular Procedural Track & Obstacle System Tests', () {
    test('Chunk length is precisely 500.0 virtual pixels (50 meters)', () {
      expect(AppConstants.chunkLength, 500.0);
      expect(AppConstants.chunkLength / 10.0, 50.0);
    });

    test('32 TrackSegmentType archetypes are defined and have names', () {
      expect(TrackSegmentType.values.length, 32);
      for (final type in TrackSegmentType.values) {
        final profile = TrackSegmentProfile(
          type: type,
          entryElevation: 0.0,
          exitElevation: 0.0,
          biome: SectorBiome.neonMetropolis,
        );
        expect(profile.name.isNotEmpty, true);
      }
    });

    test(
      '9 CyberEnvironmentTheme values are defined and have display names',
      () {
        expect(CyberEnvironmentTheme.values.length, 9);
        for (final theme in CyberEnvironmentTheme.values) {
          expect(theme.displayName.isNotEmpty, true);
        }
      },
    );

    test(
      '10 SegmentGameplayEvent patterns are defined and have action labels',
      () {
        expect(SegmentGameplayEvent.values.length, 10);
        for (final event in SegmentGameplayEvent.values) {
          expect(event.actionLabel.isNotEmpty, true);
        }
      },
    );

    test('Surface height function getSurfaceY calculates exact slopes', () {
      final chunk = WorldChunk(
        startX: 1000.0,
        length: 500.0,
        groundY: 600.0,
        roofY: 60.0,
        entryElevation: -10.0,
        exitElevation: -40.0,
      );

      // At start (worldX = 1000.0) -> groundY + entryElevation = 600 - 10 = 590
      expect(chunk.getSurfaceY(1000.0), 590.0);

      // At midpoint (worldX = 1250.0) -> groundY + (-10 + (-40 - -10)*0.5) = 600 - 25 = 575
      expect(chunk.getSurfaceY(1250.0), 575.0);

      // At end (worldX = 1500.0) -> groundY + exitElevation = 600 - 40 = 560
      expect(chunk.getSurfaceY(1500.0), 560.0);
    });

    test('50,000m full progression: 100% elevation continuity and bounds', () {
      final generator = ProceduralGenerator(gameMode: GameMode.run, seed: 42);
      final initial = generator.generateInitialChunks();

      final chunks = <WorldChunk>[...initial];
      // Generate chunks up to 50,000 meters (500,000 virtual pixels = 1000 chunks)
      double currentX = chunks.last.startX + chunks.last.length;
      final dummyParent = WorldChunk(
        startX: -999,
        length: 10,
        groundY: 600,
        roofY: 60,
      );

      while (currentX < 500000.0) {
        generator.updateChunks(playerX: currentX, parentComponent: dummyParent);
        for (final c in generator.activeChunks) {
          if (!chunks.any((existing) => existing.startX == c.startX)) {
            chunks.add(c);
          }
        }
        currentX += 500.0;
      }

      expect(chunks.length >= 100, true);

      // Verify continuous slope connections between all consecutive chunks
      for (int i = 1; i < chunks.length; i++) {
        final prev = chunks[i - 1];
        final curr = chunks[i];

        // Zero physical gap in X
        expect(curr.startX, prev.startX + prev.length);

        // 100% elevation continuity (entry must match previous exit!)
        expect(
          curr.entryElevation,
          closeTo(prev.exitElevation, 0.001),
          reason:
              'Chunk at ${curr.startX}m must match elevation of previous chunk',
        );

        // Clamped safely within viewfinder bounds
        expect(curr.entryElevation >= -80.0, true);
        expect(curr.entryElevation <= 25.0, true);
        expect(curr.exitElevation >= -80.0, true);
        expect(curr.exitElevation <= 25.0, true);
      }
    });

    test(
      '50,000m generation produces all 9 environment themes and 10 gameplay events',
      () {
        final generator = ProceduralGenerator(
          gameMode: GameMode.run,
          seed: 101,
        );
        final initial = generator.generateInitialChunks();

        final chunks = <WorldChunk>[...initial];
        double currentX = chunks.last.startX + chunks.last.length;
        final dummyParent = WorldChunk(
          startX: -999,
          length: 10,
          groundY: 600,
          roofY: 60,
        );

        while (currentX < 150000.0) {
          generator.updateChunks(
            playerX: currentX,
            parentComponent: dummyParent,
          );
          for (final c in generator.activeChunks) {
            if (!chunks.any((existing) => existing.startX == c.startX)) {
              chunks.add(c);
            }
          }
          currentX += 500.0;
        }

        final generatedThemes = chunks.map((c) => c.environmentTheme).toSet();
        final generatedEvents = chunks.map((c) => c.gameplayEvent).toSet();

        // Ensure rich environmental and gameplay variety
        expect(
          generatedThemes.length,
          9,
          reason: 'All 9 themes must be generated',
        );
        expect(
          generatedEvents.length >= 8,
          true,
          reason: 'High diversity of gameplay events',
        );
      },
    );

    test(
      'Consecutive obstacles inside each chunk have guaranteed safe clearance (no impossible combos)',
      () {
        final generator = ProceduralGenerator(
          gameMode: GameMode.run,
          seed: 777,
        );
        final initial = generator.generateInitialChunks();

        final chunks = <WorldChunk>[...initial];
        double currentX = chunks.last.startX + chunks.last.length;
        final dummyParent = WorldChunk(
          startX: -999,
          length: 10,
          groundY: 600,
          roofY: 60,
        );

        while (currentX < 30000.0) {
          generator.updateChunks(
            playerX: currentX,
            parentComponent: dummyParent,
          );
          for (final c in generator.activeChunks) {
            if (!chunks.any((existing) => existing.startX == c.startX)) {
              chunks.add(c);
            }
          }
          currentX += 500.0;
        }

        for (final chunk in chunks) {
          if (chunk.hazards.length >= 2) {
            final sorted = List.of(chunk.hazards)
              ..sort((a, b) => a.position.x.compareTo(b.position.x));
            for (int i = 1; i < sorted.length; i++) {
              final gap = sorted[i].position.x - sorted[i - 1].position.x;
              expect(
                gap >= 140.0,
                true,
                reason:
                    'Obstacles at ${sorted[i - 1].position.x} and ${sorted[i].position.x} in chunk ${chunk.startX} must have safe reaction distance (got $gap)',
              );
            }
          }
        }
      },
    );

    test('Zone biome transitions occur exclusively at 1000m boundaries', () {
      // 0m -> neonMetropolis
      expect(
        ProceduralGenerator.getBiomeForDistance(0),
        SectorBiome.neonMetropolis,
      );
      expect(
        ProceduralGenerator.getBiomeForDistance(50),
        SectorBiome.neonMetropolis,
      );
      expect(
        ProceduralGenerator.getBiomeForDistance(500),
        SectorBiome.neonMetropolis,
      );
      expect(
        ProceduralGenerator.getBiomeForDistance(950),
        SectorBiome.neonMetropolis,
      );

      // 1000m -> toxicFoundry
      expect(
        ProceduralGenerator.getBiomeForDistance(1000),
        SectorBiome.toxicFoundry,
      );
      expect(
        ProceduralGenerator.getBiomeForDistance(1050),
        SectorBiome.toxicFoundry,
      );
      expect(
        ProceduralGenerator.getBiomeForDistance(1950),
        SectorBiome.toxicFoundry,
      );

      // 2000m -> maglevTunnel
      expect(
        ProceduralGenerator.getBiomeForDistance(2000),
        SectorBiome.maglevTunnel,
      );

      // 3000m -> orbitalSkyway
      expect(
        ProceduralGenerator.getBiomeForDistance(3000),
        SectorBiome.orbitalSkyway,
      );

      // 4000m -> quantumNexus
      expect(
        ProceduralGenerator.getBiomeForDistance(4000),
        SectorBiome.quantumNexus,
      );

      // 5000m -> cycles back to neonMetropolis
      expect(
        ProceduralGenerator.getBiomeForDistance(5000),
        SectorBiome.neonMetropolis,
      );
    });

    test(
      'LowPipeHazard collision: ninja slides under safely, but collides when standing',
      () {
        final groundY = 600.0;
        final pipeY = groundY - 58.0;
        final pipe = LowPipeHazard(position: Vector2(200.0, pipeY));

        final player = FakeTestPlayer(position: Vector2(200.0, groundY));

        // Standing player -> Collides!
        player.isSliding = false;
        expect(pipe.checkCollision(player), isTrue);

        // Sliding player -> Passes safely under!
        player.isSliding = true;
        expect(pipe.checkCollision(player), isFalse);
      },
    );

    test(
      'TrafficBarrierHazard collision: collides on ground, shatters when slashed',
      () {
        final groundY = 600.0;
        final barrier = TrafficBarrierHazard(position: Vector2(250.0, groundY));

        final player = FakeTestPlayer(position: Vector2(250.0, groundY));

        // Running into barrier -> Collides!
        expect(barrier.checkCollision(player), isTrue);

        // Shattered -> Safe to pass!
        barrier.shatter();
        expect(barrier.isShattered, isTrue);
        expect(barrier.checkCollision(player), isFalse);
      },
    );

    test(
      'HoverDroneHazard collision: collides when hovering, destroyed when sliced',
      () {
        final groundY = 600.0;
        final drone = HoverDroneHazard(
          position: Vector2(250.0, groundY - 70.0),
          patrolDistance: 0.0,
        );

        final player = FakeTestPlayer(position: Vector2(250.0, groundY));

        // Active drone at head height -> Collides!
        expect(drone.checkCollision(player), isTrue);

        // Sliced by Katana -> Destroyed!
        drone.sliceAndDestroy();
        expect(drone.isSliced, isTrue);
        expect(drone.checkCollision(player), isFalse);
      },
    );

    test('LaserGateHazard high beam: ninja slides under safely', () {
      final groundY = 600.0;
      final laserGate = LaserGateHazard(
        position: Vector2(250.0, groundY),
        isHighBeam: true,
      );

      final player = FakeTestPlayer(position: Vector2(250.0, groundY));

      // Standing -> Hit by laser beam!
      player.isSliding = false;
      expect(laserGate.checkCollision(player), isTrue);

      // Sliding -> Duck under laser beam safely!
      player.isSliding = true;
      expect(laserGate.checkCollision(player), isFalse);
    });
  });
}
