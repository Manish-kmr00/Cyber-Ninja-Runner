import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/constants/app_constants.dart';
import '../../core/storage/save_service.dart';

class LeaderboardScreen extends StatefulWidget {
  const LeaderboardScreen({super.key});

  @override
  State<LeaderboardScreen> createState() => _LeaderboardScreenState();
}

class _LeaderboardScreenState extends State<LeaderboardScreen>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 3, vsync: this);
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();

    return Scaffold(
      backgroundColor: AppConstants.backgroundDark,
      appBar: AppBar(
        backgroundColor: AppConstants.backgroundDark,
        elevation: 0,
        title: const Text(
          'GLOBAL LEADERBOARDS',
          style: TextStyle(
            fontWeight: FontWeight.w900,
            letterSpacing: 1.5,
            fontSize: 18,
          ),
        ),
        bottom: TabBar(
          controller: _tabController,
          indicatorColor: AppConstants.coinGold,
          labelColor: AppConstants.coinGold,
          unselectedLabelColor: Colors.white60,
          tabs: const [
            Tab(text: 'ENDLESS RUN'),
            Tab(text: '10X CHALLENGE'),
            Tab(text: 'SQUBE BIRD'),
          ],
        ),
      ),
      body: TabBarView(
        controller: _tabController,
        children: [
          _buildLeaderboardTab(
            modeTitle: 'Endless Run',
            personalBest: saveService.stats.bestDistanceRun,
            mockLeaderboard: [
              _RankEntry(1, 'ShadowRunner_99', 4280),
              _RankEntry(2, 'DarkSqubeMaster', 3910),
              _RankEntry(3, 'StealthNinja_X', 3450),
              _RankEntry(4, 'GhostCrawler', 2890),
              _RankEntry(5, 'You (Local)', saveService.stats.bestDistanceRun),
            ],
          ),
          _buildLeaderboardTab(
            modeTitle: '10X Challenge',
            personalBest: saveService.stats.bestDistance10x,
            mockLeaderboard: [
              _RankEntry(1, 'MatrixGod', 2140),
              _RankEntry(2, 'ProGamer_Dark', 1890),
              _RankEntry(3, 'You (Local)', saveService.stats.bestDistance10x),
              _RankEntry(4, 'CyberRunner', 950),
            ],
          ),
          _buildLeaderboardTab(
            modeTitle: 'Sqube Bird',
            personalBest: saveService.stats.bestDistanceSqubeBird,
            mockLeaderboard: [
              _RankEntry(1, 'FlappySqube', 1650),
              _RankEntry(2, 'WingedCube', 1200),
              _RankEntry(
                3,
                'You (Local)',
                saveService.stats.bestDistanceSqubeBird,
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildLeaderboardTab({
    required String modeTitle,
    required int personalBest,
    required List<_RankEntry> mockLeaderboard,
  }) {
    // Sort entries descending by score
    final sorted = List<_RankEntry>.from(mockLeaderboard)
      ..sort((a, b) => b.distance.compareTo(a.distance));

    return Padding(
      padding: const EdgeInsets.all(20),
      child: Column(
        children: [
          // Personal Best Banner
          Container(
            width: double.infinity,
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: AppConstants.surfaceDark,
              borderRadius: BorderRadius.circular(16),
              border: Border.all(
                color: AppConstants.coinGold.withValues(alpha: 0.5),
              ),
            ),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text(
                      'YOUR PERSONAL BEST',
                      style: TextStyle(
                        color: Colors.white60,
                        fontSize: 11,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    const SizedBox(height: 4),
                    Text(
                      '$personalBest m',
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 24,
                        fontWeight: FontWeight.w900,
                      ),
                    ),
                  ],
                ),
                const Icon(
                  Icons.emoji_events,
                  color: AppConstants.coinGold,
                  size: 36,
                ),
              ],
            ),
          ),
          const SizedBox(height: 16),

          // List of Ranks
          Expanded(
            child: ListView.separated(
              itemCount: sorted.length,
              separatorBuilder: (context, index) => const SizedBox(height: 8),
              itemBuilder: (context, index) {
                final entry = sorted[index];
                final isUser = entry.playerName.contains('You');
                final rankColor = index == 0
                    ? AppConstants.coinGold
                    : (index == 1
                          ? const Color(0xFFC0C0C0)
                          : (index == 2
                                ? const Color(0xFFCD7F32)
                                : Colors.white70));

                return Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 16,
                    vertical: 14,
                  ),
                  decoration: BoxDecoration(
                    color: isUser
                        ? AppConstants.cardDark
                        : AppConstants.surfaceDark,
                    borderRadius: BorderRadius.circular(12),
                    border: isUser
                        ? Border.all(color: AppConstants.stealthBlue)
                        : null,
                  ),
                  child: Row(
                    children: [
                      Text(
                        '#${index + 1}',
                        style: TextStyle(
                          fontWeight: FontWeight.w900,
                          color: rankColor,
                          fontSize: 16,
                        ),
                      ),
                      const SizedBox(width: 16),
                      Expanded(
                        child: Text(
                          entry.playerName,
                          style: TextStyle(
                            fontWeight: isUser
                                ? FontWeight.w900
                                : FontWeight.bold,
                            color: isUser
                                ? AppConstants.stealthBlue
                                : Colors.white,
                          ),
                        ),
                      ),
                      Text(
                        '${entry.distance} m',
                        style: const TextStyle(
                          fontWeight: FontWeight.w900,
                          color: Colors.white,
                          fontSize: 15,
                        ),
                      ),
                    ],
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}

class _RankEntry {
  final int rank;
  final String playerName;
  final int distance;

  _RankEntry(this.rank, this.playerName, this.distance);
}
