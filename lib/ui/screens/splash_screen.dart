import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../core/constants/app_constants.dart';
import '../../core/services/iap_service.dart';
import '../../core/storage/save_service.dart';
import 'start_menu_screen.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen>
    with SingleTickerProviderStateMixin {
  late AnimationController _animController;
  late Animation<double> _fadeAnim;
  late Animation<double> _scaleAnim;

  @override
  void initState() {
    super.initState();
    _animController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1400),
    );

    _fadeAnim = CurvedAnimation(parent: _animController, curve: Curves.easeIn);
    _scaleAnim = Tween<double>(begin: 0.8, end: 1.0).animate(
      CurvedAnimation(parent: _animController, curve: Curves.easeOutBack),
    );

    _animController.forward();

    // Initialize SaveService and IAPService and navigate to StartMenu
    WidgetsBinding.instance.addPostFrameCallback((_) async {
      final saveService = context.read<SaveService>();
      await saveService.init();
      await IAPService().init(saveService);
      await Future.delayed(const Duration(milliseconds: 1600));
      if (mounted) {
        Navigator.of(context).pushReplacement(
          PageRouteBuilder(
            pageBuilder: (context, anim1, anim2) => const StartMenuScreen(),
            transitionsBuilder: (context, anim1, anim2, child) =>
                FadeTransition(opacity: anim1, child: child),
            transitionDuration: const Duration(milliseconds: 600),
          ),
        );
      }
    });
  }

  @override
  void dispose() {
    _animController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppConstants.backgroundDark,
      body: Center(
        child: FadeTransition(
          opacity: _fadeAnim,
          child: ScaleTransition(
            scale: _scaleAnim,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                // Cyber Cat Logo Icon
                Container(
                  width: 88,
                  height: 88,
                  decoration: BoxDecoration(
                    color: AppConstants.surfaceDark,
                    borderRadius: BorderRadius.circular(22),
                    border: Border.all(
                      color: AppConstants.stealthBlue.withValues(alpha: 0.8),
                      width: 2.5,
                    ),
                    boxShadow: [
                      BoxShadow(
                        color: AppConstants.stealthBlue.withValues(alpha: 0.35),
                        blurRadius: 30,
                        spreadRadius: 4,
                      ),
                    ],
                  ),
                  child: Stack(
                    alignment: Alignment.center,
                    children: [
                      // Ninja Shinobi Icon
                      Icon(
                        Icons.sports_martial_arts_rounded,
                        size: 46,
                        color: AppConstants.stealthBlue,
                      ),
                    ],
                  ),
                ),
                const SizedBox(height: 28),
                const Text(
                  'CYBER NINJA RUNNER',
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.w900,
                    color: Colors.white,
                    letterSpacing: 4.0,
                  ),
                ),
                const SizedBox(height: 8),
                Text(
                  'SHADOW SHINOBI EDITION',
                  style: TextStyle(
                    fontSize: 12,
                    fontWeight: FontWeight.bold,
                    color: AppConstants.stealthBlue.withValues(alpha: 0.8),
                    letterSpacing: 2.5,
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
