import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/constants/game_enums.dart';
import '../../core/localization/app_localizations.dart';
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
        leading: Padding(
          padding: const EdgeInsets.only(left: 12),
          child: Center(
            child: Material(
              color: Colors.transparent,
              child: InkWell(
                borderRadius: BorderRadius.circular(10),
                splashColor: AppConstants.stealthBlue.withValues(alpha: 0.3),
                onTap: () {
                  AudioService().playClick();
                  Navigator.of(context).pop();
                },
                child: Container(
                  width: 36,
                  height: 36,
                  decoration: BoxDecoration(
                    color: const Color(0xFF161E2E),
                    borderRadius: BorderRadius.circular(10),
                    border: Border.all(
                      color: AppConstants.stealthBlue.withValues(alpha: 0.5),
                    ),
                  ),
                  child: const Icon(
                    Icons.arrow_back_ios_new_rounded,
                    color: Colors.white,
                    size: 16,
                  ),
                ),
              ),
            ),
          ),
        ),
        title: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              context.l10n.tr('arsenal_hangar'),
              style: const TextStyle(
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
                  '${saveService.player.cyberPoints.value}',
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
        padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 16),
        physics: const BouncingScrollPhysics(),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Section 1: Operative Armory (Hero Chassis Skins)
            _buildSectionHeader(
              badge: context.l10n.tr('section_armory'),
              title: context.l10n.tr('armory_title'),
              subtitle: context.l10n.tr('armory_desc'),
              color: const Color(0xFF00E5FF),
              icon: Icons.sports_martial_arts_rounded,
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
                    price: 50000,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.cyberNeon,
                    name: 'Synthwave Shinobi',
                    color: const Color(0xFFFF007F),
                    price: 100000,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.crimsonShadow,
                    name: 'Bloodblade Assassin',
                    color: AppConstants.hazardRed,
                    price: 150000,
                    saveService: saveService,
                  ),
                  const SizedBox(width: 14),
                  _buildSkinCard(
                    context,
                    skin: PlayerSkin.goldenAura,
                    name: 'Shogun Mecha',
                    color: AppConstants.coinGold,
                    price: 200000,
                    saveService: saveService,
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // Section 2: Tactical Modules (Consumable Combat Overclock Boosters)
            _buildSectionHeader(
              badge: context.l10n.tr('section_modules'),
              title: context.l10n.tr('modules_title'),
              subtitle: context.l10n.tr('modules_desc'),
              color: const Color(0xFF00FF88),
              icon: Icons.bolt_rounded,
            ),
            const SizedBox(height: 14),
            _buildBoosterShopItem(
              context,
              type: BoosterType.safeGround,
              name: 'Safe Ground Pack x3',
              description: 'Forces checkpoint havens to spawn',
              icon: Icons.shield_rounded,
              color: AppConstants.stealthBlue,
              price: 200,
              count: 3,
              saveService: saveService,
            ),
            const SizedBox(height: 10),
            _buildBoosterShopItem(
              context,
              type: BoosterType.matrixSlowMo,
              name: 'Matrix Slow-Mo x3',
              description: 'World slows for 8s while Ninja runs at full speed',
              icon: Icons.speed_rounded,
              color: AppConstants.matrixGreen,
              price: 400,
              count: 3,
              saveService: saveService,
            ),
            const SizedBox(height: 10),
            _buildBoosterShopItem(
              context,
              type: BoosterType.invisibility,
              name: 'Invisibility Pack x3',
              description: 'Immunity against Dark Eye drone sentries',
              icon: Icons.visibility_off_rounded,
              color: AppConstants.boosterPurple,
              price: 600,
              count: 3,
              saveService: saveService,
            ),
            const SizedBox(height: 10),
            _buildBoosterShopItem(
              context,
              type: BoosterType.killEyes,
              name: 'EMP Shockwave Pack x3',
              description: 'Neutralizes active sentries on screen',
              icon: Icons.electric_bolt_rounded,
              color: const Color(0xFFFF3366),
              price: 800,
              count: 3,
              saveService: saveService,
            ),

            const SizedBox(height: 32),

            // Section 3: Neural Protocols & Augments (Permanent VIP Privileges)
            _buildSectionHeader(
              badge: context.l10n.tr('section_protocols'),
              title: context.l10n.tr('protocols_title'),
              subtitle: context.l10n.tr('protocols_desc'),
              color: const Color(0xFFB026FF),
              icon: Icons.memory_rounded,
            ),

            const SizedBox(height: 14),
            _buildProtocolItem(
              context,
              title: 'Daily Quantum Supply Hub',
              description:
                  'Consecutive daily link: ${saveService.player.dailyStreak} Day Streak // Neural Supply Drop Active',
              icon: Icons.calendar_month_rounded,
              color: AppConstants.coinGold,
              trailing: Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 12,
                  vertical: 8,
                ),
                decoration: BoxDecoration(
                  color: AppConstants.coinGold.withValues(alpha: 0.12),
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(
                    color: AppConstants.coinGold.withValues(alpha: 0.5),
                  ),
                ),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    const Icon(
                      Icons.bolt_rounded,
                      color: AppConstants.coinGold,
                      size: 14,
                    ),
                    const SizedBox(width: 4),
                    Text(
                      'DAY ${saveService.player.dailyStreak}',
                      style: const TextStyle(
                        fontSize: 11,
                        fontWeight: FontWeight.w900,
                        color: AppConstants.coinGold,
                      ),
                    ),
                  ],
                ),
              ),
            ),

            const SizedBox(height: 32),

            // Section 4: Data Vault (Cyber Point CP Acquisition)
            _buildSectionHeader(
              badge: context.l10n.tr('section_vault'),
              title: context.l10n.tr('vault_title'),
              subtitle: context.l10n.tr('vault_desc'),
              color: const Color(0xFFFFD700),
              icon: Icons.diamond_rounded,
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
                      saveService.addCyberPoints(500);
                      AudioService().playCollect();
                      _showPurchasedToast(context, '500 CP Added!');
                    },
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: _buildCPCard(
                    amount: 2000,
                    label: '+2000 CP',
                    priceTag: '\$2.99',
                    isBestValue: true,
                    onTap: () {
                      saveService.addCyberPoints(2000);
                      AudioService().playCollect();
                      _showPurchasedToast(context, '2000 CP Added!');
                    },
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: _buildCPCard(
                    amount: 5000,
                    label: '+5000 CP',
                    priceTag: '\$5.99',
                    onTap: () {
                      saveService.addCyberPoints(5000);
                      AudioService().playCollect();
                      _showPurchasedToast(context, '5000 CP Added!');
                    },
                  ),
                ),
              ],
            ),
            const SizedBox(height: 20),
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

    void onCardTap() {
      if (isEquipped) {
        AudioService().playClick();
        return;
      }
      if (isUnlocked) {
        AudioService().playClick();
        saveService.equipSkin(skin);
      } else {
        if (saveService.spendCyberPoints(price)) {
          AudioService().playCollect();
          saveService.unlockSkin(skin);
          _showPurchasedToast(context, '$name Unlocked & Equipped!');
        } else {
          _showPurchasedToast(context, 'Not enough Cyber Ninja Points!');
        }
      }
    }

    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onCardTap,
      child: Container(
        width: 150,
        padding: const EdgeInsets.all(14),
        decoration: BoxDecoration(
          color: isEquipped
              ? color.withValues(alpha: 0.14)
              : AppConstants.surfaceDark,
          borderRadius: BorderRadius.circular(18),
          border: Border.all(
            color: isEquipped
                ? AppConstants.coinGold
                : (isUnlocked ? color.withValues(alpha: 0.5) : Colors.white12),
            width: isEquipped ? 2 : 1,
          ),
          boxShadow: isEquipped
              ? [
                  BoxShadow(
                    color: AppConstants.coinGold.withValues(alpha: 0.25),
                    blurRadius: 14,
                    spreadRadius: 1,
                  ),
                ]
              : null,
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
                border: Border.all(
                  color: color.withValues(alpha: isEquipped ? 1.0 : 0.6),
                  width: 2,
                ),
                boxShadow: [
                  BoxShadow(
                    color: color.withValues(alpha: isEquipped ? 0.35 : 0.15),
                    blurRadius: 14,
                  ),
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
              textAlign: TextAlign.center,
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 13,
                color: isEquipped ? Colors.white : Colors.white70,
              ),
            ),
            const SizedBox(height: 10),
            if (isEquipped)
              Container(
                width: double.infinity,
                padding: const EdgeInsets.symmetric(
                  horizontal: 10,
                  vertical: 6,
                ),
                decoration: BoxDecoration(
                  color: AppConstants.coinGold,
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Center(
                  child: Text(
                    context.l10n.tr('equipped'),
                    style: const TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.w900,
                      fontSize: 10.5,
                      letterSpacing: 0.5,
                    ),
                  ),
                ),
              )
            else if (isUnlocked)
              Container(
                width: double.infinity,
                padding: const EdgeInsets.symmetric(
                  horizontal: 10,
                  vertical: 6,
                ),
                decoration: BoxDecoration(
                  color: Colors.white.withValues(alpha: 0.08),
                  borderRadius: BorderRadius.circular(8),
                  border: Border.all(color: Colors.white30),
                ),
                child: Center(
                  child: Text(
                    context.l10n.tr('equip'),
                    style: const TextStyle(
                      fontSize: 10.5,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                      letterSpacing: 0.5,
                    ),
                  ),
                ),
              )
            else
              Container(
                width: double.infinity,
                padding: const EdgeInsets.symmetric(
                  horizontal: 10,
                  vertical: 6,
                ),
                decoration: BoxDecoration(
                  color: AppConstants.cardDark,
                  borderRadius: BorderRadius.circular(8),
                  border: Border.all(
                    color: AppConstants.coinGold.withValues(alpha: 0.4),
                  ),
                ),
                child: Center(
                  child: Text(
                    price >= 1000 ? '${price ~/ 1000},000 CP' : '$price CP',
                    style: const TextStyle(
                      fontSize: 10.5,
                      fontWeight: FontWeight.bold,
                      color: AppConstants.coinGold,
                    ),
                  ),
                ),
              ),
          ],
        ),
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
              if (saveService.spendCyberPoints(price)) {
                saveService.addBooster(type, count);
                AudioService().playCollect();
                _showPurchasedToast(context, 'Purchased +$count Boosters!');
              } else {
                _showPurchasedToast(context, 'Not enough Cyber Ninja Points!');
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

  Widget _buildSectionHeader({
    required String badge,
    required String title,
    String? subtitle,
    required Color color,
    required IconData icon,
  }) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          children: [
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 4),
              decoration: BoxDecoration(
                color: color.withValues(alpha: 0.14),
                borderRadius: BorderRadius.circular(8),
                border: Border.all(
                  color: color.withValues(alpha: 0.5),
                  width: 1.2,
                ),
                boxShadow: [
                  BoxShadow(
                    color: color.withValues(alpha: 0.2),
                    blurRadius: 8,
                    spreadRadius: 0.5,
                  ),
                ],
              ),
              child: Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(icon, color: color, size: 13),
                  const SizedBox(width: 6),
                  Text(
                    badge,
                    style: TextStyle(
                      fontSize: 10,
                      fontWeight: FontWeight.w900,
                      color: color,
                      letterSpacing: 1.2,
                    ),
                  ),
                ],
              ),
            ),
            const SizedBox(width: 10),
            Expanded(
              child: Text(
                title,
                style: const TextStyle(
                  fontSize: 13,
                  fontWeight: FontWeight.w900,
                  color: Colors.white,
                  letterSpacing: 1.1,
                ),
              ),
            ),
          ],
        ),
        if (subtitle != null) ...[
          const SizedBox(height: 4),
          Padding(
            padding: const EdgeInsets.only(left: 4),
            child: Text(
              subtitle,
              style: TextStyle(
                fontSize: 10,
                fontWeight: FontWeight.w600,
                color: Colors.white.withValues(alpha: 0.4),
                letterSpacing: 0.8,
              ),
            ),
          ),
        ],
      ],
    );
  }

  Widget _buildProtocolItem(
    BuildContext context, {
    required String title,
    required String description,
    required IconData icon,
    required Color color,
    required Widget trailing,
  }) {
    return Container(
      padding: const EdgeInsets.all(14),
      decoration: BoxDecoration(
        color: AppConstants.surfaceDark,
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: color.withValues(alpha: 0.2), width: 1),
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
                  title,
                  style: const TextStyle(
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    fontSize: 13,
                  ),
                ),
                const SizedBox(height: 2),
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
          const SizedBox(width: 10),
          trailing,
        ],
      ),
    );
  }
}
