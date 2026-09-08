import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/localization/app_localizations.dart';
import '../../core/storage/save_service.dart';

class LeaderboardScreen extends StatefulWidget {
  const LeaderboardScreen({super.key});

  @override
  State<LeaderboardScreen> createState() => _LeaderboardScreenState();
}

class _LeaderboardScreenState extends State<LeaderboardScreen>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;
  int _selectedTab = 0;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 3, vsync: this);
    _tabController.addListener(() {
      if (_selectedTab != _tabController.index) {
        setState(() {
          _selectedTab = _tabController.index;
        });
      }
    });
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final l10n = context.l10n;

    return Scaffold(
      backgroundColor: const Color(0xFF080B12),
      body: SafeArea(
        child: Column(
          children: [
            // 1. Cyberpunk Header Bar
            _buildCyberHeader(context, saveService, l10n),

            // 2. Futuristic Segmented Mode Tabs
            _buildModeTabs(l10n),

            // 3. Tab Views: Dual-Pane Hero Dashboard & Ranked Stream
            Expanded(
              child: TabBarView(
                controller: _tabController,
                physics: const BouncingScrollPhysics(),
                children: [
                  // Tab 1: Core Campaign (Endless Overdrive)
                  _buildLeaderboardTab(
                    context,
                    modeName: l10n.tr('core_campaign'),
                    modeTag: 'NEO-TOKYO MATRIX // SECTORS 01-05',
                    modeColor: const Color(0xFF00E5FF),
                    personalBest: saveService.stats.bestDistanceRun,
                    saveService: saveService,
                    baseRoster: [
                      _RankEntry(
                        callSign: 'ShadowRunner_99',
                        title: 'TITAN SLAYER',
                        sector: 'NEO-TOKYO',
                        distance: 4280,
                        avatarIcon: Icons.shield_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'CyberNinjaMaster',
                        title: 'VOID INFILTRATOR',
                        sector: 'CYBER-CORE',
                        distance: 3910,
                        avatarIcon: Icons.bolt_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'StealthNinja_X',
                        title: 'APEX HUNTER',
                        sector: 'SECTOR-04',
                        distance: 3450,
                        avatarIcon: Icons.radar_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'GhostCrawler_JP',
                        title: 'OVERCLOCKER',
                        sector: 'SHIN-SHINJUKU',
                        distance: 2890,
                        avatarIcon: Icons.military_tech_rounded,
                        isVerified: false,
                      ),
                      _RankEntry(
                        callSign: 'NeonShinobi_88',
                        title: 'SHADOW RUNNER',
                        sector: 'SECTOR-02',
                        distance: 2150,
                        avatarIcon: Icons.vpn_key_rounded,
                        isVerified: false,
                      ),
                      _RankEntry(
                        callSign: 'Kuro_Phantom',
                        title: 'CYBER RECON',
                        sector: 'SECTOR-01',
                        distance: 1620,
                        avatarIcon: Icons.navigation_rounded,
                        isVerified: false,
                      ),
                      _RankEntry(
                        callSign: 'Zero_Glitch',
                        title: 'GRID STALKER',
                        sector: 'DATA-VALLEY',
                        distance: 980,
                        avatarIcon: Icons.terminal_rounded,
                        isVerified: false,
                      ),
                    ],
                  ),

                  // Tab 2: Extreme Risk (10X Hyper Run)
                  _buildLeaderboardTab(
                    context,
                    modeName: l10n.tr('extreme_risk'),
                    modeTag: 'REACTOR CORE // 2X VELOCITY',
                    modeColor: const Color(0xFFFF3366),
                    personalBest: saveService.stats.bestDistance10x,
                    saveService: saveService,
                    baseRoster: [
                      _RankEntry(
                        callSign: 'MatrixGod_VIP',
                        title: 'HYPER OVERCLOCK',
                        sector: 'REACTOR CORE',
                        distance: 2840,
                        avatarIcon: Icons.local_fire_department_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'ProGamer_Dark',
                        title: 'EXTREME OPERATIVE',
                        sector: 'VOLT FORGE',
                        distance: 2390,
                        avatarIcon: Icons.bolt_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'OverchargeKing',
                        title: 'THERMAL BREAKER',
                        sector: 'CORE-09',
                        distance: 1780,
                        avatarIcon: Icons.flash_on_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'CyberRonin',
                        title: 'LETHAL SHADOW',
                        sector: 'FORGE DEPTHS',
                        distance: 1240,
                        avatarIcon: Icons.crisis_alert_rounded,
                        isVerified: false,
                      ),
                      _RankEntry(
                        callSign: 'SpeedDemon_X',
                        title: 'IMPULSE PILOT',
                        sector: 'OVERCHARGE',
                        distance: 820,
                        avatarIcon: Icons.speed_rounded,
                        isVerified: false,
                      ),
                    ],
                  ),

                  // Tab 3: Aerial Zero-G (Jet Shinobi Flight)
                  _buildLeaderboardTab(
                    context,
                    modeName: l10n.tr('aerial_zero_g'),
                    modeTag: 'STRATOSPHERE SKYWAY // FLIGHT VECTOR',
                    modeColor: const Color(0xFFB026FF),
                    personalBest: saveService.stats.bestDistanceFlight,
                    saveService: saveService,
                    baseRoster: [
                      _RankEntry(
                        callSign: 'CyberNinja_Sky',
                        title: 'ZERO-G ACE',
                        sector: 'STRATOSPHERE',
                        distance: 2650,
                        avatarIcon: Icons.air_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'WingedNinja_07',
                        title: 'SKY VECTOR MASTER',
                        sector: 'ORBITAL-7',
                        distance: 2100,
                        avatarIcon: Icons.flight_takeoff_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'AeroShinobi',
                        title: 'ION DRIFTER',
                        sector: 'SKYWAY HIGH',
                        distance: 1540,
                        avatarIcon: Icons.cloud_queue_rounded,
                        isVerified: true,
                      ),
                      _RankEntry(
                        callSign: 'Valkyrie_Unit',
                        title: 'CEILING GLIDER',
                        sector: 'MESOSPHERE',
                        distance: 1120,
                        avatarIcon: Icons.navigation_rounded,
                        isVerified: false,
                      ),
                      _RankEntry(
                        callSign: 'CloudStrider',
                        title: 'AERIAL RECON',
                        sector: 'LOW-ORBIT',
                        distance: 750,
                        avatarIcon: Icons.flight_rounded,
                        isVerified: false,
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  // 1. Top Cyber Bar
  Widget _buildCyberHeader(
    BuildContext context,
    SaveService saveService,
    AppLocalizations l10n,
  ) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
      decoration: BoxDecoration(
        color: const Color(0xFF0F1420),
        border: Border(
          bottom: BorderSide(
            color: Colors.white.withValues(alpha: 0.08),
            width: 1,
          ),
        ),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          // Left: Back button & Title
          Row(
            children: [
              Material(
                color: Colors.transparent,
                child: InkWell(
                  borderRadius: BorderRadius.circular(12),
                  splashColor: AppConstants.stealthBlue.withValues(alpha: 0.2),
                  onTap: () {
                    AudioService().playClick();
                    Navigator.of(context).pop();
                  },
                  child: Container(
                    width: 40,
                    height: 40,
                    decoration: BoxDecoration(
                      color: const Color(0xFF161E2E),
                      borderRadius: BorderRadius.circular(12),
                      border: Border.all(
                        color: AppConstants.stealthBlue.withValues(alpha: 0.5),
                      ),
                    ),
                    child: const Icon(
                      Icons.arrow_back_ios_new_rounded,
                      color: Colors.white,
                      size: 18,
                    ),
                  ),
                ),
              ),
              const SizedBox(width: 14),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Container(
                        width: 8,
                        height: 8,
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          color: AppConstants.coinGold,
                          boxShadow: [
                            BoxShadow(
                              color: AppConstants.coinGold.withValues(
                                alpha: 0.6,
                              ),
                              blurRadius: 8,
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(width: 8),
                      Text(
                        l10n.tr('hall_of_fame'),
                        style: const TextStyle(
                          fontWeight: FontWeight.w900,
                          letterSpacing: 2.0,
                          fontSize: 18,
                          color: Colors.white,
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 2),
                  Text(
                    '// ${l10n.tr('global_rankings')}',
                    style: TextStyle(
                      fontWeight: FontWeight.w700,
                      letterSpacing: 1.2,
                      fontSize: 9.5,
                      color: AppConstants.stealthBlue.withValues(alpha: 0.8),
                    ),
                  ),
                ],
              ),
            ],
          ),

          // Right: Operative Identity & CP Pill
          Row(
            children: [
              // Equipped Shinobi Tag
              Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 10,
                  vertical: 6,
                ),
                decoration: BoxDecoration(
                  color: const Color(0xFF131A26),
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(
                    color: AppConstants.stealthBlue.withValues(alpha: 0.35),
                  ),
                ),
                child: Row(
                  children: [
                    const Icon(
                      Icons.person_pin_circle_rounded,
                      color: AppConstants.stealthBlue,
                      size: 16,
                    ),
                    const SizedBox(width: 6),
                    Text(
                      saveService.player.equippedSkin.name.toUpperCase(),
                      style: const TextStyle(
                        color: AppConstants.stealthBlue,
                        fontWeight: FontWeight.w900,
                        fontSize: 11,
                        letterSpacing: 1.0,
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(width: 12),

              // Currency Pill
              Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 12,
                  vertical: 6,
                ),
                decoration: BoxDecoration(
                  color: const Color(0xFF171B24),
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(
                    color: AppConstants.coinGold.withValues(alpha: 0.6),
                    width: 1.2,
                  ),
                  boxShadow: [
                    BoxShadow(
                      color: AppConstants.coinGold.withValues(alpha: 0.2),
                      blurRadius: 10,
                    ),
                  ],
                ),
                child: Row(
                  children: [
                    const Icon(
                      Icons.diamond_rounded,
                      color: AppConstants.coinGold,
                      size: 16,
                    ),
                    const SizedBox(width: 6),
                    Text(
                      '${saveService.player.cyberPoints.value}',
                      style: const TextStyle(
                        fontWeight: FontWeight.w900,
                        color: AppConstants.coinGold,
                        fontSize: 13,
                        letterSpacing: 0.8,
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  // 2. Futuristic Segmented Mode Tabs
  Widget _buildModeTabs(AppLocalizations l10n) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 8),
      color: const Color(0xFF0A0E17),
      child: Row(
        children: [
          Expanded(
            child: _buildCyberTabItem(
              index: 0,
              icon: Icons.bolt_rounded,
              label: l10n.tr('core_campaign'),
              accentColor: const Color(0xFF00E5FF),
            ),
          ),
          const SizedBox(width: 10),
          Expanded(
            child: _buildCyberTabItem(
              index: 1,
              icon: Icons.local_fire_department_rounded,
              label: l10n.tr('extreme_risk'),
              accentColor: const Color(0xFFFF3366),
            ),
          ),
          const SizedBox(width: 10),
          Expanded(
            child: _buildCyberTabItem(
              index: 2,
              icon: Icons.air_rounded,
              label: l10n.tr('aerial_zero_g'),
              accentColor: const Color(0xFFB026FF),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildCyberTabItem({
    required int index,
    required IconData icon,
    required String label,
    required Color accentColor,
  }) {
    final isSelected = _selectedTab == index;

    return Material(
      color: Colors.transparent,
      child: InkWell(
        borderRadius: BorderRadius.circular(14),
        onTap: () {
          AudioService().playClick();
          setState(() {
            _selectedTab = index;
          });
          _tabController.animateTo(index);
        },
        child: AnimatedContainer(
          duration: const Duration(milliseconds: 220),
          curve: Curves.easeOutCubic,
          padding: const EdgeInsets.symmetric(vertical: 9, horizontal: 12),
          decoration: BoxDecoration(
            color: isSelected
                ? accentColor.withValues(alpha: 0.15)
                : const Color(0xFF121722),
            borderRadius: BorderRadius.circular(14),
            border: Border.all(
              color: isSelected
                  ? accentColor
                  : Colors.white.withValues(alpha: 0.1),
              width: isSelected ? 1.6 : 1.0,
            ),
            boxShadow: isSelected
                ? [
                    BoxShadow(
                      color: accentColor.withValues(alpha: 0.3),
                      blurRadius: 14,
                      spreadRadius: 1,
                    ),
                  ]
                : [],
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(
                icon,
                color: isSelected ? accentColor : Colors.white60,
                size: 16,
              ),
              const SizedBox(width: 8),
              Flexible(
                child: Text(
                  label,
                  style: TextStyle(
                    color: isSelected ? Colors.white : Colors.white60,
                    fontWeight: isSelected ? FontWeight.w900 : FontWeight.w700,
                    fontSize: 12,
                    letterSpacing: 1.0,
                  ),
                  overflow: TextOverflow.ellipsis,
                  maxLines: 1,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // 3. Tab Dashboard View
  Widget _buildLeaderboardTab(
    BuildContext context, {
    required String modeName,
    required String modeTag,
    required Color modeColor,
    required int personalBest,
    required SaveService saveService,
    required List<_RankEntry> baseRoster,
  }) {
    // Inject the player's live entry
    final rosterWithUser = List<_RankEntry>.from(baseRoster);
    final userEntry = _RankEntry(
      callSign: 'YOU (ACTIVE OPERATIVE)',
      title: saveService.player.equippedSkin.name.toUpperCase(),
      sector: 'TACTICAL UNIT',
      distance: personalBest,
      avatarIcon: Icons.person_rounded,
      isUser: true,
      isVerified: true,
    );
    rosterWithUser.add(userEntry);

    // Sort descending by distance
    rosterWithUser.sort((a, b) => b.distance.compareTo(a.distance));

    // Determine user's rank index
    final userRank = rosterWithUser.indexWhere((e) => e.isUser) + 1;
    final apexChampion = rosterWithUser.first;

    return Padding(
      padding: const EdgeInsets.fromLTRB(20, 10, 20, 16),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Left Column: Hero Spotlight & Personal Dossier
          SizedBox(
            width: 330,
            child: SingleChildScrollView(
              physics: const BouncingScrollPhysics(),
              child: Column(
                children: [
                  // Apex Champion Showcase
                  _buildChampionPodiumCard(
                    champion: apexChampion,
                    modeColor: modeColor,
                    modeTag: modeTag,
                  ),
                  const SizedBox(height: 12),

                  // User's Career Dossier Card
                  _buildUserDossierCard(
                    userRank: userRank,
                    personalBest: personalBest,
                    modeColor: modeColor,
                    saveService: saveService,
                  ),
                ],
              ),
            ),
          ),
          const SizedBox(width: 18),

          // Right Column: Full Ranked Stream
          Expanded(
            child: Container(
              decoration: BoxDecoration(
                color: const Color(0xFF0E131E),
                borderRadius: BorderRadius.circular(20),
                border: Border.all(color: Colors.white.withValues(alpha: 0.08)),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  // Stream Header Tag
                  Container(
                    padding: const EdgeInsets.symmetric(
                      horizontal: 18,
                      vertical: 11,
                    ),
                    decoration: BoxDecoration(
                      color: const Color(0xFF131A26),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(20),
                        topRight: Radius.circular(20),
                      ),
                      border: Border(
                        bottom: BorderSide(
                          color: Colors.white.withValues(alpha: 0.06),
                        ),
                      ),
                    ),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Row(
                          children: [
                            const Icon(
                              Icons.format_list_numbered_rounded,
                              color: Colors.white70,
                              size: 15,
                            ),
                            const SizedBox(width: 8),
                            Text(
                              'GLOBAL SHADOW ROSTER [TOP AGENTS]',
                              style: TextStyle(
                                color: Colors.white.withValues(alpha: 0.8),
                                fontSize: 11,
                                fontWeight: FontWeight.w900,
                                letterSpacing: 1.2,
                              ),
                            ),
                          ],
                        ),
                        Text(
                          '${rosterWithUser.length} CLASSIFIED ENTRIES',
                          style: TextStyle(
                            color: Colors.white.withValues(alpha: 0.4),
                            fontSize: 10,
                            fontWeight: FontWeight.bold,
                            letterSpacing: 1.0,
                          ),
                        ),
                      ],
                    ),
                  ),

                  // Ranked List Stream
                  Expanded(
                    child: ListView.separated(
                      padding: const EdgeInsets.all(12),
                      physics: const BouncingScrollPhysics(),
                      itemCount: rosterWithUser.length,
                      separatorBuilder: (context, index) =>
                          const SizedBox(height: 8),
                      itemBuilder: (context, index) {
                        final entry = rosterWithUser[index];
                        final rank = index + 1;
                        return _buildRankEntryRow(
                          rank: rank,
                          entry: entry,
                          modeColor: modeColor,
                        );
                      },
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  // Apex Champion Podium Card
  Widget _buildChampionPodiumCard({
    required _RankEntry champion,
    required Color modeColor,
    required String modeTag,
  }) {
    return Container(
      width: double.infinity,
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        gradient: const LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: [Color(0xFF1E1A0C), Color(0xFF141208), Color(0xFF0F1420)],
        ),
        borderRadius: BorderRadius.circular(20),
        border: Border.all(
          color: AppConstants.coinGold.withValues(alpha: 0.7),
          width: 1.5,
        ),
        boxShadow: [
          BoxShadow(
            color: AppConstants.coinGold.withValues(alpha: 0.2),
            blurRadius: 20,
            spreadRadius: 1,
          ),
        ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Apex Tag & Crown
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 8,
                  vertical: 3.5,
                ),
                decoration: BoxDecoration(
                  color: AppConstants.coinGold.withValues(alpha: 0.2),
                  borderRadius: BorderRadius.circular(6),
                  border: Border.all(
                    color: AppConstants.coinGold.withValues(alpha: 0.5),
                  ),
                ),
                child: const Row(
                  children: [
                    Icon(
                      Icons.workspace_premium_rounded,
                      color: AppConstants.coinGold,
                      size: 13,
                    ),
                    SizedBox(width: 4),
                    Text(
                      'APEX WORLD RECORD',
                      style: TextStyle(
                        color: AppConstants.coinGold,
                        fontSize: 9.5,
                        fontWeight: FontWeight.w900,
                        letterSpacing: 1.0,
                      ),
                    ),
                  ],
                ),
              ),
              const Icon(
                Icons.emoji_events_rounded,
                color: AppConstants.coinGold,
                size: 24,
              ),
            ],
          ),
          const SizedBox(height: 10),

          // Champion Callsign
          Row(
            children: [
              Container(
                width: 38,
                height: 38,
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: AppConstants.coinGold.withValues(alpha: 0.2),
                  border: Border.all(color: AppConstants.coinGold, width: 1.5),
                ),
                child: Icon(
                  champion.avatarIcon,
                  color: AppConstants.coinGold,
                  size: 20,
                ),
              ),
              const SizedBox(width: 10),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        Flexible(
                          child: Text(
                            champion.callSign,
                            style: const TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.w900,
                              fontSize: 14,
                              letterSpacing: 1.0,
                            ),
                            overflow: TextOverflow.ellipsis,
                          ),
                        ),
                        if (champion.isVerified) ...[
                          const SizedBox(width: 4),
                          const Icon(
                            Icons.verified_rounded,
                            color: AppConstants.stealthBlue,
                            size: 14,
                          ),
                        ],
                      ],
                    ),
                    Text(
                      champion.title,
                      style: const TextStyle(
                        color: AppConstants.coinGold,
                        fontSize: 10,
                        fontWeight: FontWeight.w800,
                        letterSpacing: 1.2,
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
          const SizedBox(height: 12),

          // Distance Score Readout
          Container(
            width: double.infinity,
            padding: const EdgeInsets.symmetric(vertical: 8, horizontal: 12),
            decoration: BoxDecoration(
              color: Colors.black.withValues(alpha: 0.4),
              borderRadius: BorderRadius.circular(12),
              border: Border.all(
                color: AppConstants.coinGold.withValues(alpha: 0.3),
              ),
            ),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                const Text(
                  'APEX RECORD',
                  style: TextStyle(
                    color: Colors.white54,
                    fontSize: 10,
                    fontWeight: FontWeight.w700,
                    letterSpacing: 1.0,
                  ),
                ),
                Row(
                  crossAxisAlignment: CrossAxisAlignment.baseline,
                  textBaseline: TextBaseline.alphabetic,
                  children: [
                    Text(
                      '${champion.distance}',
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 22,
                        fontWeight: FontWeight.w900,
                        fontFamily: 'monospace',
                        letterSpacing: 1.0,
                      ),
                    ),
                    const SizedBox(width: 3),
                    const Text(
                      'M',
                      style: TextStyle(
                        color: AppConstants.coinGold,
                        fontSize: 12,
                        fontWeight: FontWeight.w900,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  // User's Career Dossier Card
  Widget _buildUserDossierCard({
    required int userRank,
    required int personalBest,
    required Color modeColor,
    required SaveService saveService,
  }) {
    final rankColor = userRank == 1
        ? AppConstants.coinGold
        : (userRank == 2
              ? const Color(0xFFC0C0C0)
              : (userRank == 3
                    ? const Color(0xFFCD7F32)
                    : AppConstants.stealthBlue));

    return Container(
      width: double.infinity,
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: const Color(0xFF0F1522),
        borderRadius: BorderRadius.circular(20),
        border: Border.all(
          color: AppConstants.stealthBlue.withValues(alpha: 0.5),
          width: 1.4,
        ),
        boxShadow: [
          BoxShadow(
            color: AppConstants.stealthBlue.withValues(alpha: 0.12),
            blurRadius: 16,
          ),
        ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Header: You & Current Standing
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Row(
                children: [
                  Container(
                    width: 7,
                    height: 7,
                    decoration: const BoxDecoration(
                      shape: BoxShape.circle,
                      color: AppConstants.matrixGreen,
                    ),
                  ),
                  const SizedBox(width: 6),
                  const Text(
                    'YOUR OPERATIVE DOSSIER',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 11,
                      fontWeight: FontWeight.w900,
                      letterSpacing: 1.2,
                    ),
                  ),
                ],
              ),
              Container(
                padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 3),
                decoration: BoxDecoration(
                  color: rankColor.withValues(alpha: 0.2),
                  borderRadius: BorderRadius.circular(8),
                  border: Border.all(color: rankColor, width: 1),
                ),
                child: Text(
                  'GLOBAL #$userRank',
                  style: TextStyle(
                    color: rankColor,
                    fontWeight: FontWeight.w900,
                    fontSize: 10,
                    letterSpacing: 1.0,
                  ),
                ),
              ),
            ],
          ),
          const SizedBox(height: 12),

          // Personal Best Distance
          Container(
            padding: const EdgeInsets.symmetric(vertical: 8, horizontal: 12),
            decoration: BoxDecoration(
              color: const Color(0xFF141B28),
              borderRadius: BorderRadius.circular(12),
              border: Border.all(color: Colors.white.withValues(alpha: 0.08)),
            ),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                const Text(
                  'PERSONAL RECORD',
                  style: TextStyle(
                    color: Colors.white60,
                    fontSize: 10,
                    fontWeight: FontWeight.bold,
                    letterSpacing: 1.0,
                  ),
                ),
                Row(
                  crossAxisAlignment: CrossAxisAlignment.baseline,
                  textBaseline: TextBaseline.alphabetic,
                  children: [
                    Text(
                      '$personalBest',
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 20,
                        fontWeight: FontWeight.w900,
                        fontFamily: 'monospace',
                      ),
                    ),
                    const SizedBox(width: 3),
                    const Text(
                      'M',
                      style: TextStyle(
                        color: AppConstants.stealthBlue,
                        fontWeight: FontWeight.w900,
                        fontSize: 12,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
          const SizedBox(height: 10),

          // Career Metrics Mini-Grid
          Row(
            children: [
              Expanded(
                child: _buildMetricTile(
                  label: 'TOTAL RUNS',
                  value: '${saveService.stats.totalRuns}',
                  icon: Icons.directions_run_rounded,
                  color: const Color(0xFF00E5FF),
                ),
              ),
              const SizedBox(width: 8),
              Expanded(
                child: _buildMetricTile(
                  label: 'TOTAL JUMPS',
                  value: '${saveService.stats.totalJumps}',
                  icon: Icons.upgrade_rounded,
                  color: const Color(0xFFFFD700),
                ),
              ),
              const SizedBox(width: 8),
              Expanded(
                child: _buildMetricTile(
                  label: 'SHADOW HIDES',
                  value: '${saveService.stats.totalShadowHides}',
                  icon: Icons.visibility_off_rounded,
                  color: const Color(0xFFD500F9),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildMetricTile({
    required String label,
    required String value,
    required IconData icon,
    required Color color,
  }) {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: 6, horizontal: 6),
      decoration: BoxDecoration(
        color: const Color(0xFF121824),
        borderRadius: BorderRadius.circular(10),
        border: Border.all(color: Colors.white.withValues(alpha: 0.06)),
      ),
      child: Column(
        children: [
          Icon(icon, size: 14, color: color),
          const SizedBox(height: 2),
          Text(
            value,
            style: const TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.w900,
              fontSize: 12,
              fontFamily: 'monospace',
            ),
          ),
          Text(
            label,
            style: TextStyle(
              color: Colors.white.withValues(alpha: 0.4),
              fontSize: 7.5,
              fontWeight: FontWeight.w800,
              letterSpacing: 0.5,
            ),
            maxLines: 1,
            overflow: TextOverflow.ellipsis,
          ),
        ],
      ),
    );
  }

  // Row Item in Ranked Stream
  Widget _buildRankEntryRow({
    required int rank,
    required _RankEntry entry,
    required Color modeColor,
  }) {
    final isTop1 = rank == 1;
    final isTop2 = rank == 2;
    final isTop3 = rank == 3;
    final isUser = entry.isUser;

    Color rankColor;
    IconData? rankIcon;

    if (isTop1) {
      rankColor = AppConstants.coinGold;
      rankIcon = Icons.emoji_events_rounded;
    } else if (isTop2) {
      rankColor = const Color(0xFFD1D5DB);
      rankIcon = Icons.military_tech_rounded;
    } else if (isTop3) {
      rankColor = const Color(0xFFD97706);
      rankIcon = Icons.military_tech_rounded;
    } else {
      rankColor = Colors.white54;
      rankIcon = null;
    }

    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 10),
      decoration: BoxDecoration(
        color: isUser
            ? const Color(0xFF112338)
            : (isTop1 ? const Color(0xFF18150A) : const Color(0xFF131824)),
        borderRadius: BorderRadius.circular(14),
        border: Border.all(
          color: isUser
              ? AppConstants.stealthBlue
              : (isTop1
                    ? AppConstants.coinGold.withValues(alpha: 0.6)
                    : Colors.white.withValues(alpha: 0.08)),
          width: isUser ? 1.8 : 1.0,
        ),
        boxShadow: isUser
            ? [
                BoxShadow(
                  color: AppConstants.stealthBlue.withValues(alpha: 0.25),
                  blurRadius: 14,
                  spreadRadius: 1,
                ),
              ]
            : (isTop1
                  ? [
                      BoxShadow(
                        color: AppConstants.coinGold.withValues(alpha: 0.12),
                        blurRadius: 10,
                      ),
                    ]
                  : []),
      ),
      child: Row(
        children: [
          // Rank Badge
          Container(
            width: 36,
            height: 36,
            decoration: BoxDecoration(
              color: rankColor.withValues(alpha: 0.15),
              borderRadius: BorderRadius.circular(10),
              border: Border.all(
                color: rankColor.withValues(alpha: 0.5),
                width: 1.2,
              ),
            ),
            child: Center(
              child: rankIcon != null
                  ? Icon(rankIcon, color: rankColor, size: 18)
                  : Text(
                      '#$rank',
                      style: TextStyle(
                        color: rankColor,
                        fontWeight: FontWeight.w900,
                        fontSize: 12,
                        fontFamily: 'monospace',
                      ),
                    ),
            ),
          ),
          const SizedBox(width: 12),

          // Operative Avatar
          Container(
            width: 32,
            height: 32,
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              color: isUser
                  ? AppConstants.stealthBlue.withValues(alpha: 0.2)
                  : const Color(0xFF1E2638),
              border: Border.all(
                color: isUser
                    ? AppConstants.stealthBlue
                    : Colors.white.withValues(alpha: 0.15),
              ),
            ),
            child: Icon(
              entry.avatarIcon,
              size: 16,
              color: isUser ? AppConstants.stealthBlue : Colors.white70,
            ),
          ),
          const SizedBox(width: 10),

          // Name, Title & Sector Badge
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Flexible(
                      child: Text(
                        entry.callSign,
                        style: TextStyle(
                          color: isUser
                              ? AppConstants.stealthBlue
                              : Colors.white,
                          fontWeight: isUser
                              ? FontWeight.w900
                              : FontWeight.w800,
                          fontSize: 13,
                          letterSpacing: 0.8,
                        ),
                        overflow: TextOverflow.ellipsis,
                      ),
                    ),
                    if (entry.isVerified) ...[
                      const SizedBox(width: 4),
                      Icon(
                        Icons.verified_rounded,
                        color: isUser
                            ? AppConstants.stealthBlue
                            : AppConstants.matrixGreen,
                        size: 13,
                      ),
                    ],
                    if (isUser) ...[
                      const SizedBox(width: 6),
                      Container(
                        padding: const EdgeInsets.symmetric(
                          horizontal: 6,
                          vertical: 1.5,
                        ),
                        decoration: BoxDecoration(
                          color: AppConstants.stealthBlue.withValues(
                            alpha: 0.25,
                          ),
                          borderRadius: BorderRadius.circular(4),
                        ),
                        child: const Text(
                          'YOU',
                          style: TextStyle(
                            color: AppConstants.stealthBlue,
                            fontSize: 8.5,
                            fontWeight: FontWeight.w900,
                            letterSpacing: 0.8,
                          ),
                        ),
                      ),
                    ],
                  ],
                ),
                const SizedBox(height: 2),
                Row(
                  children: [
                    Text(
                      entry.title,
                      style: TextStyle(
                        color: isTop1
                            ? AppConstants.coinGold
                            : (isUser
                                  ? AppConstants.stealthBlue.withValues(
                                      alpha: 0.8,
                                    )
                                  : Colors.white54),
                        fontSize: 9.5,
                        fontWeight: FontWeight.w700,
                        letterSpacing: 0.8,
                      ),
                    ),
                    const SizedBox(width: 6),
                    Text(
                      '•',
                      style: TextStyle(
                        color: Colors.white.withValues(alpha: 0.3),
                        fontSize: 10,
                      ),
                    ),
                    const SizedBox(width: 6),
                    Text(
                      entry.sector,
                      style: TextStyle(
                        color: Colors.white.withValues(alpha: 0.4),
                        fontSize: 9,
                        fontWeight: FontWeight.w600,
                        letterSpacing: 0.6,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),

          // Distance Score
          Container(
            padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 5),
            decoration: BoxDecoration(
              color: Colors.black.withValues(alpha: 0.35),
              borderRadius: BorderRadius.circular(8),
              border: Border.all(
                color: isUser
                    ? AppConstants.stealthBlue.withValues(alpha: 0.4)
                    : Colors.white.withValues(alpha: 0.06),
              ),
            ),
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.baseline,
              textBaseline: TextBaseline.alphabetic,
              children: [
                Text(
                  '${entry.distance}',
                  style: TextStyle(
                    color: isUser ? AppConstants.stealthBlue : Colors.white,
                    fontWeight: FontWeight.w900,
                    fontSize: 16,
                    fontFamily: 'monospace',
                    letterSpacing: 0.8,
                  ),
                ),
                const SizedBox(width: 2),
                Text(
                  'M',
                  style: TextStyle(
                    color: isUser
                        ? AppConstants.stealthBlue
                        : modeColor.withValues(alpha: 0.85),
                    fontWeight: FontWeight.w900,
                    fontSize: 10,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class _RankEntry {
  final String callSign;
  final String title;
  final String sector;
  final int distance;
  final IconData avatarIcon;
  final bool isUser;
  final bool isVerified;

  _RankEntry({
    required this.callSign,
    required this.title,
    required this.sector,
    required this.distance,
    required this.avatarIcon,
    this.isUser = false,
    this.isVerified = false,
  });
}
