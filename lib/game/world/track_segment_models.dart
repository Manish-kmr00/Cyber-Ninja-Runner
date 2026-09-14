import '../../core/constants/game_enums.dart';

/// 32 Distinct Modular Procedural Track Segment Archetypes
enum TrackSegmentType {
  /// 0. Standard smooth cyberpunk highway with lane lights and side lamps
  straightNeonBoulevard,

  /// 1. Gradual incline slope upward (-30px Y)
  gradualSlopeUp,

  /// 2. Gradual decline slope downward (+30px Y)
  gradualSlopeDown,

  /// 3. Elevated viaduct roadway supported by high concrete pillars
  elevatedViaduct,

  /// 4. Sunken roadway with towering retaining side bulkheads
  sunkenExpressway,

  /// 5. Chasm overpass with dual emergency catwalks spanning the gap
  splitChasmOverpass,

  /// 6. Dual-tier structural catwalk spanning the entire 50m
  dualTierCatwalk,

  /// 7. Stepped terrace incline ramp (-40px Y)
  steppedTerraceAscent,

  /// 8. Stepped terrace decline ramp (+40px Y)
  steppedTerraceDescent,

  /// 9. Heavy steel overhead triangular industrial truss archway
  industrialTrussArchway,

  /// 10. Cable-stayed suspension bridge with glowing cyber-cables
  cantileveredSuspensionBridge,

  /// 11. Magnetic levitation conduit with pulsing linear induction coils
  maglevConduitRun,

  /// 12. Security checkpoint with overhead holographic scanner beams
  laserGateCorridor,

  /// 13. Cyber colonnade / torii gate pillars along the roadway
  cyberShrineColonnade,

  /// 14. Massive industrial chemical aqueduct pipes with steam exhaust
  toxicPipeAqueduct,

  /// 15. Wide high-speed expressway with triple speed chevrons
  wideHighSpeedHighway,

  /// 16. Narrow high-precision beam rail with cautionary glowing edges
  narrowPrecisionPass,

  /// 17. Double-deck skyway with elevated upper express track
  doubleDeckSkyway,

  /// 18. Reinforced military blast bunker gate checkpoint
  bunkerCheckpoint,

  /// 19. High-voltage electrical substation pylon grid with power arcs
  substationPylonGrid,

  /// 20. Surveillance drone launch platform gantry overhead
  droneGantryPlatform,

  /// 21. Giant holographic neon billboard advertisements lining the roadway
  holographicBillboardRow,

  /// 22. Slight left curved skyway with angled perspective girders
  curvedOverpassSlightLeft,

  /// 23. Slight right curved skyway with angled perspective girders
  curvedOverpassSlightRight,

  /// 24. Industrial perforated steel mesh grating track with underglow
  meshGrateWalkway,

  /// 25. Cyber sewer culvert canal with drainage grates and runoff pipes
  cyberSewerCulvert,

  /// 26. High-rise rooftop sector with spinning exhaust ventilation turbines
  rooftopTurbineExhaust,

  /// 27. Unstable quantum energy rift fissures glowing on asphalt
  quantumRiftSplit,

  /// 28. High-speed monorail / hyperloop track crossing diagonally overhead
  monorailTrackCrossing,

  /// 29. Aerodynamic speed booster runway with glowing energy arrows
  speedBoosterRunway,

  /// 30. Heavy security perimeter concrete barriers with strobe hazard lights
  reinforcedBarricadeSector,

  /// 31. Reinforced flat combat arena for milestone Cyber Titan encounters
  titanArenaPlateau,
}

/// Profile and configuration data for a specific 50m track segment instance.
class TrackSegmentProfile {
  final TrackSegmentType type;
  final double entryElevation;
  final double exitElevation;
  final double trackDepth;
  final SectorBiome biome;
  final CyberEnvironmentTheme theme;
  final SegmentGameplayEvent gameplayEvent;

  const TrackSegmentProfile({
    required this.type,
    required this.entryElevation,
    required this.exitElevation,
    this.trackDepth = 26.0,
    required this.biome,
    this.theme = CyberEnvironmentTheme.cyberAlley,
    this.gameplayEvent = SegmentGameplayEvent.runPacing,
  });

  /// Height offset at relative position [relX] along this 50m segment.
  double getSurfaceElevationAt(double relX, double segmentLength) {
    if (segmentLength <= 0) return entryElevation;
    final t = (relX / segmentLength).clamp(0.0, 1.0);
    return entryElevation + (exitElevation - entryElevation) * t;
  }

  /// Whether this segment changes elevation.
  bool get isSloped => (exitElevation - entryElevation).abs() > 0.001;

  /// Elevation difference across the 50m segment.
  double get elevationDelta => exitElevation - entryElevation;

  /// Human-readable title of this segment structure.
  String get name {
    switch (type) {
      case TrackSegmentType.straightNeonBoulevard:
        return 'Neon Boulevard';
      case TrackSegmentType.gradualSlopeUp:
        return 'Incline Ascent';
      case TrackSegmentType.gradualSlopeDown:
        return 'Decline Descent';
      case TrackSegmentType.elevatedViaduct:
        return 'Elevated Viaduct';
      case TrackSegmentType.sunkenExpressway:
        return 'Sunken Expressway';
      case TrackSegmentType.splitChasmOverpass:
        return 'Chasm Overpass';
      case TrackSegmentType.dualTierCatwalk:
        return 'Dual-Tier Catwalk';
      case TrackSegmentType.steppedTerraceAscent:
        return 'Stepped Ascent';
      case TrackSegmentType.steppedTerraceDescent:
        return 'Stepped Descent';
      case TrackSegmentType.industrialTrussArchway:
        return 'Industrial Truss';
      case TrackSegmentType.cantileveredSuspensionBridge:
        return 'Suspension Bridge';
      case TrackSegmentType.maglevConduitRun:
        return 'Maglev Conduit';
      case TrackSegmentType.laserGateCorridor:
        return 'Laser Gate Corridor';
      case TrackSegmentType.cyberShrineColonnade:
        return 'Cyber Colonnade';
      case TrackSegmentType.toxicPipeAqueduct:
        return 'Pipe Aqueduct';
      case TrackSegmentType.wideHighSpeedHighway:
        return 'High-Speed Highway';
      case TrackSegmentType.narrowPrecisionPass:
        return 'Precision Pass';
      case TrackSegmentType.doubleDeckSkyway:
        return 'Double-Deck Skyway';
      case TrackSegmentType.bunkerCheckpoint:
        return 'Bunker Checkpoint';
      case TrackSegmentType.substationPylonGrid:
        return 'Substation Grid';
      case TrackSegmentType.droneGantryPlatform:
        return 'Drone Gantry';
      case TrackSegmentType.holographicBillboardRow:
        return 'Billboard Strip';
      case TrackSegmentType.curvedOverpassSlightLeft:
        return 'Curved Overpass (L)';
      case TrackSegmentType.curvedOverpassSlightRight:
        return 'Curved Overpass (R)';
      case TrackSegmentType.meshGrateWalkway:
        return 'Steel Mesh Grate';
      case TrackSegmentType.cyberSewerCulvert:
        return 'Sewer Culvert';
      case TrackSegmentType.rooftopTurbineExhaust:
        return 'Turbine Rooftop';
      case TrackSegmentType.quantumRiftSplit:
        return 'Quantum Rift Sector';
      case TrackSegmentType.monorailTrackCrossing:
        return 'Monorail Crossing';
      case TrackSegmentType.speedBoosterRunway:
        return 'Booster Runway';
      case TrackSegmentType.reinforcedBarricadeSector:
        return 'Barricade Sector';
      case TrackSegmentType.titanArenaPlateau:
        return 'Titan Arena Plateau';
    }
  }
}

/// 9 Distinct Cyberpunk Environment Themes
enum CyberEnvironmentTheme {
  /// Narrow futuristic street, neon signs, hanging cables, vending machines, shops, drones
  cyberAlley,

  /// High-rise building rooftops, AC units, ventilation fans, water tanks, rooftop gap jumps
  rooftop,

  /// Dark subterranean tunnel, conduit pipes, steam vents, low ceilings, slide + jump gameplay
  undergroundTunnel,

  /// Giant holographic advertisements, floating signs, digital billboards, glowing portals
  hologramDistrict,

  /// High futuristic suspension bridge, city far below, traffic trails, bridge gaps
  skyBridge,

  /// Very dark environment, minimal lighting, red/blue emergency beacons, heavy fog, high tension
  darkSector,

  /// Heavy factories, shipping containers, large pipes, cranes, metal platforms, steam
  industrialDistrict,

  /// Cyberpunk street market, lantern neon, food stalls, crowded street props, vending machines
  neonMarket,

  /// Multi-lane expressway, speed chevrons, flying vehicles, road barriers, speed ramps
  futuristicHighway,
}

extension CyberEnvironmentThemeExtension on CyberEnvironmentTheme {
  String get displayName {
    switch (this) {
      case CyberEnvironmentTheme.cyberAlley:
        return 'CYBER ALLEY';
      case CyberEnvironmentTheme.rooftop:
        return 'ROOFTOP CITADEL';
      case CyberEnvironmentTheme.undergroundTunnel:
        return 'UNDERGROUND TUNNEL';
      case CyberEnvironmentTheme.hologramDistrict:
        return 'HOLOGRAM DISTRICT';
      case CyberEnvironmentTheme.skyBridge:
        return 'SKY BRIDGE';
      case CyberEnvironmentTheme.darkSector:
        return 'DARK SECTOR';
      case CyberEnvironmentTheme.industrialDistrict:
        return 'INDUSTRIAL DISTRICT';
      case CyberEnvironmentTheme.neonMarket:
        return 'NEON MARKET';
      case CyberEnvironmentTheme.futuristicHighway:
        return 'FUTURISTIC HIGHWAY';
    }
  }
}

/// Mini Gameplay Event associated with a 50m track segment
enum SegmentGameplayEvent {
  /// Open runway, pacing and CP line collection
  runPacing,

  /// Incline ramp followed by a road barrier jump
  rampJump,

  /// Rooftop chasm gap requiring clean leap
  rooftopGapJump,

  /// Low overhead steam pipe or beam requiring ninja slide
  tunnelLowSlide,

  /// Narrow corridor with patrol drone requiring slash or dodge
  alleyDroneEncounter,

  /// High-altitude suspension bridge gap requiring jump
  skyBridgeGapJump,

  /// Heavy shipping container requiring jump or vault
  industrialContainerVault,

  /// Security laser gate requiring slide under or jump timing
  hologramLaserGateTiming,

  /// Double-tier catwalk requiring mid-air double jump chain
  catwalkMultiJumpChain,

  /// Dark sector reflex gauntlet: fast hazards requiring quick reaction
  darkReactionGauntlet,
}

extension SegmentGameplayEventExtension on SegmentGameplayEvent {
  String get actionLabel {
    switch (this) {
      case SegmentGameplayEvent.runPacing:
        return 'RUN';
      case SegmentGameplayEvent.rampJump:
        return 'RAMP → JUMP';
      case SegmentGameplayEvent.rooftopGapJump:
        return 'CHASM → JUMP';
      case SegmentGameplayEvent.tunnelLowSlide:
        return 'LOW PIPE → SLIDE';
      case SegmentGameplayEvent.alleyDroneEncounter:
        return 'DRONE → SLASH';
      case SegmentGameplayEvent.skyBridgeGapJump:
        return 'BRIDGE → JUMP';
      case SegmentGameplayEvent.industrialContainerVault:
        return 'CONTAINER → VAULT';
      case SegmentGameplayEvent.hologramLaserGateTiming:
        return 'LASER GATE → SLIDE';
      case SegmentGameplayEvent.catwalkMultiJumpChain:
        return 'CATWALK → DOUBLE JUMP';
      case SegmentGameplayEvent.darkReactionGauntlet:
        return 'REACTION → DODGE';
    }
  }
}
