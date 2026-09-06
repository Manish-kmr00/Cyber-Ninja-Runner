import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/storage/save_service.dart';

class ShopScreen extends StatelessWidget {
  const ShopScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();

    return Scaffold(
      backgroundColor: const Color(0xFF070A0F),
      appBar: AppBar(
        backgroundColor: const Color(0xFF0C1017),
        elevation: 0,
        title: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'MECHA ARSENAL & HANGAR',
              style: TextStyle(
                fontWeight: FontWeight.w900,
                letterSpacing: 1.8,
                fontSize: 16,
                color: Colors.white,
              ),
            ),
            Text(
              '// CHASSIS & MODULE CUSTOMIZATION',
              style: TextStyle(
                fontWeight: FontWeight.w700,
                letterSpacing: 1.2,
                fontSize: 9,
                color: AppConstants.stealthBlue.withValues(alpha: 0.8),
              ),
            ),
          ],
        ),
        actions: [
          Container(
            margin: const EdgeInsets.only(right: 16),
            padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 6),
            decoration: BoxDecoration(
              color: AppConstants.surfaceDark,
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
                  size: 18,
                ),
                const SizedBox(width: 6),
                Text(
                  '${saveService.player.cubePoints.value}',
                  style: const TextStyle(
                    fontWeight: FontWeight.w900,
                    color: AppConstants.coinGold,
                    fontSize: 13,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20),
        physics: const BouncingScrollPhysics(),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Section 1: Hero Skins
            _buildSectionHeader(
              code: '// SYS_01',
              title: 'CYBER NINJA (SHINOBI) CHASSIS SKINS',
            ),
            const SizedBox(height: 14),
            SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              physics: const BouncingScrollPhysics(),
              child: Row(
                children: [
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.classicWhite,
                    name: 'Shadow Shinobi',
                    color: AppConstants.stealthBlue,
                    price: 0,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.stealthBlack,
                    name: 'Blackout Phantom',
                    color: const Color(0xFF2C3440),
                    price: 250,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.cyberNeon,
                    name: 'Synthwave Shinobi',
                    color: const Color(0xFFFF007F),
                    price: 500,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.crimsonShadow,
                    name: 'Bloodblade Assassin',
                    color: AppConstants.hazardRed,
                    price: 800,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.goldenAura,
                    name: 'Shogun Mecha',
                    color: AppConstants.coinGold,
                    price: 1500,
                    saveService: saveService,
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // Section 2: Consumable Booster Packs
            _buildSectionHeader(
              code: '// SYS_03',
              title: 'TACTICAL OVERCLOCK BOOSTERS',
            ),
            const SizedBox(height: 14),
            _buildBoosterShopItem(
              context,
              type: BoosterType.safeGround,
              name: 'Safe Ground Pack x3',
              description: 'Forces checkpoint havens to spawn',
              icon: Icons.shield,
              color: AppConstants.stealthBlue,
              price: 120,
              count: 3,
              saveService: saveService,
            ),
            const SizedBox(height: 10),
            _buildBoosterShopItem(
              context,
              type: BoosterType.matrixSlowMo,
              name: 'Matrix Slow-Mo x3',
              description: 'Slows down time by 55%',
              icon: Icons.speed,
              color: AppConstants.matrixGreen,
              price: 150,
              count: 3,
              saveService: saveService,
            ),
            const SizedBox(height: 10),
            _buildBoosterShopItem(
              context,
              type: BoosterType.invisibility,
              name: 'Invisibility Pack x3',
              description: 'Immunity against Dark Eye sentries',
              icon: Icons.visibility_off,
              color: AppConstants.boosterPurple,
              price: 180,
              count: 3,
              saveService: saveService,
            ),

            const SizedBox(height: 32),

            // Section 3: Cube Point Bundles
            _buildSectionHeader(
              code: '// SYS_04',
              title: 'CYBER POINT (CP) ACQUISITION',
            ),
            const SizedBox(height: 14),
            Row(
              children: [
                Expanded(
                  child: _buildCPCard(
                    amount: 500,
                    label: '+500 CP',
                    priceTag: '\$0.99',
                    onTap: () {
                      saveService.addCubePoints(500);
                      AudioService().playCollect();
                      _showPurchasedToast(context, '500 CP Added!');
                    },
                  ),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: _buildCPCard(
                    amount: 2000,
                    label: '+2000 CP',
                    priceTag: '\$2.99',
                    isBestValue: true,
                    onTap: () {
                      saveService.addCubePoints(2000);
                      AudioService().playCollect();
                      _showPurchasedToast(context, '2000 CP Added!');
                    },
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  void _showPurchasedToast(BuildContext context, String msg) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        backgroundColor: AppConstants.surfaceDark,
        content: Text(
          msg,
          style: const TextStyle(
            color: AppConstants.coinGold,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
    );
  }

  Widget _buildSkinCard(
    BuildContext context, {
    required PlayerSkin skin,
    required String name,
    required Color color,
    required int price,
    required SaveService saveService,
  }) {
    final isUnlocked = saveService.player.unlockedSkins.contains(skin);
    final isEquipped = saveService.player.equippedSkin == skin;

    return Container(
      width: 150,
      padding: const EdgeInsets.all(14),
      decoration: BoxDecoration(
        color: AppConstants.surfaceDark,
        borderRadius: BorderRadius.circular(18),
        border: Border.all(
          color: isEquipped
              ? AppConstants.coinGold
              : (isUnlocked ? Colors.white24 : Colors.transparent),
          width: isEquipped ? 2 : 1,
        ),
      ),
      child: Column(
        children: [
          // Cyber Cat Skin Preview Box
          Container(
            width: 64,
            height: 64,
            decoration: BoxDecoration(
              color: AppConstants.backgroundDark,
              borderRadius: BorderRadius.circular(14),
              border: Border.all(color: color.withValues(alpha: 0.8), width: 2),
              boxShadow: [
                BoxShadow(color: color.withValues(alpha: 0.25), blurRadius: 14),
              ],
            ),
            child: Center(
              child: Icon(
                Icons.sports_martial_arts_rounded,
                color: color,
                size: 32,
              ),
            ),
          ),
          const SizedBox(height: 12),
          Text(
            name,
            style: const TextStyle(
              fontWeight: FontWeight.bold,
              fontSize: 13,
              color: Colors.white,
            ),
          ),
          const SizedBox(height: 10),
          if (isEquipped)
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 4),
              decoration: BoxDecoration(
                color: AppConstants.coinGold,
                borderRadius: BorderRadius.circular(8),
              ),
              child: const Text(
                'EQUIPPED',
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.w900,
                  fontSize: 10,
                ),
              ),
            )
          else if (isUnlocked)
            OutlinedButton(
              style: OutlinedButton.styleFrom(
                foregroundColor: Colors.white,
                side: const BorderSide(color: Colors.white30),
                minimumSize: const Size(double.infinity, 30),
                padding: EdgeInsets.zero,
              ),
              onPressed: () {
                AudioService().playClick();
                saveService.equipSkin(skin);
              },
              child: const Text(
                'EQUIP',
                style: TextStyle(fontSize: 11, fontWeight: FontWeight.bold),
              ),
            )
          else
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: AppConstants.cardDark,
                foregroundColor: AppConstants.coinGold,
                minimumSize: const Size(double.infinity, 30),
                padding: EdgeInsets.zero,
              ),
              onPressed: () {
                if (saveService.spendCubePoints(price)) {
                  AudioService().playCollect();
                  saveService.unlockSkin(skin);
                } else {
                  _showPurchasedToast(context, 'Not enough Cube Points!');
                }
              },
              child: Text(
                '$price CP',
                style: const TextStyle(
                  fontSize: 11,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
        ],
      ),
    );
  }

  Widget _buildBoosterShopItem(
    BuildContext context, {
    required BoosterType type,
    required String name,
    required String description,
    required IconData icon,
    required Color color,
    required int price,
    required int count,
    required SaveService saveService,
  }) {
    return Container(
      padding: const EdgeInsets.all(14),
      decoration: BoxDecoration(
        color: AppConstants.surfaceDark,
        borderRadius: BorderRadius.circular(16),
      ),
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.all(10),
            decoration: BoxDecoration(
              color: color.withValues(alpha: 0.15),
              borderRadius: BorderRadius.circular(12),
            ),
            child: Icon(icon, color: color, size: 24),
          ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  name,
                  style: const TextStyle(
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    fontSize: 14,
                  ),
                ),
                Text(
                  description,
                  style: TextStyle(
                    color: Colors.white.withValues(alpha: 0.5),
                    fontSize: 11,
                  ),
                ),
              ],
            ),
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: AppConstants.cardDark,
              foregroundColor: AppConstants.coinGold,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(10),
              ),
            ),
            onPressed: () {
              if (saveService.spendCubePoints(price)) {
                saveService.addBooster(type, count);
                AudioService().playCollect();
                _showPurchasedToast(context, 'Purchased +$count Boosters!');
              } else {
                _showPurchasedToast(context, 'Not enough Cube Points!');
              }
            },
            child: Text(
              '$price CP',
              style: const TextStyle(fontWeight: FontWeight.bold),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildCPCard({
    required int amount,
    required String label,
    required String priceTag,
    required VoidCallback onTap,
    bool isBestValue = false,
  }) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
          color: AppConstants.surfaceDark,
          borderRadius: BorderRadius.circular(16),
          border: Border.all(
            color: isBestValue ? AppConstants.coinGold : Colors.white24,
          ),
        ),
        child: Column(
          children: [
            if (isBestValue)
              Container(
                margin: const EdgeInsets.only(bottom: 6),
                padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 2),
                decoration: BoxDecoration(
                  color: AppConstants.coinGold,
                  borderRadius: BorderRadius.circular(6),
                ),
                child: const Text(
                  'BEST VALUE',
                  style: TextStyle(
                    color: Colors.black,
                    fontWeight: FontWeight.bold,
                    fontSize: 9,
                  ),
                ),
              ),
            const Icon(Icons.diamond, color: AppConstants.coinGold, size: 32),
            const SizedBox(height: 8),
            Text(
              label,
              style: const TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.w900,
                color: Colors.white,
              ),
            ),
            const SizedBox(height: 6),
            Text(
              priceTag,
              style: const TextStyle(
                fontSize: 14,
                fontWeight: FontWeight.bold,
                color: AppConstants.coinGold,
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildSectionHeader({required String code, required String title}) {
    return Row(
      children: [
        Container(
          padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
          decoration: BoxDecoration(
            color: AppConstants.stealthBlue.withValues(alpha: 0.15),
            borderRadius: BorderRadius.circular(4),
            border: Border.all(
              color: AppConstants.stealthBlue.withValues(alpha: 0.4),
            ),
          ),
          child: Text(
            code,
            style: const TextStyle(
              fontSize: 10,
              fontWeight: FontWeight.w900,
              color: AppConstants.stealthBlue,
              letterSpacing: 1.0,
            ),
          ),
        ),
        const SizedBox(width: 8),
        Text(
          title,
          style: const TextStyle(
            fontSize: 14,
            fontWeight: FontWeight.w900,
            color: Colors.white,
            letterSpacing: 1.2,
          ),
        ),
      ],
    );
  }
}
