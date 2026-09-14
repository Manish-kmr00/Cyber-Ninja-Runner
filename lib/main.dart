import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'core/audio/audio_service.dart';
import 'core/constants/app_constants.dart';
import 'core/monetization/monetization_manager.dart';
import 'core/services/iap_service.dart';
import 'core/storage/save_service.dart';
import 'ui/screens/splash_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // 1. Lock screen orientation to Landscape
  await SystemChrome.setPreferredOrientations([
    DeviceOrientation.landscapeLeft,
    DeviceOrientation.landscapeRight,
  ]);

  // 2. Enable fullscreen sticky immersive mode
  await SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);

  // 3. Initialize Audio service
  await AudioService().init();

  // 4. Initialize Monetization asynchronously (non-blocking)
  MonetizationManager().init();

  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => SaveService()),
        ChangeNotifierProvider.value(value: IAPService()),
      ],
      child: const CyberNinjaRunnerApp(),
    ),
  );
}

class CyberNinjaRunnerApp extends StatelessWidget {
  const CyberNinjaRunnerApp({super.key});

  @override
  Widget build(BuildContext context) {
    final saveService = context.watch<SaveService>();
    final isArabic = saveService.settings.languageCode == 'ar';

    return MaterialApp(
      title: 'Cyber Ninja Runner',
      debugShowCheckedModeBanner: false,
      locale: Locale(saveService.settings.languageCode),
      builder: (context, child) {
        final mediaQuery = MediaQuery.of(context);
        return MediaQuery(
          data: mediaQuery.copyWith(
            textScaler: mediaQuery.textScaler.clamp(
              minScaleFactor: 0.85,
              maxScaleFactor: 1.0,
            ),
          ),
          child: Directionality(
            textDirection: isArabic ? TextDirection.rtl : TextDirection.ltr,
            child: child ?? const SizedBox(),
          ),
        );
      },
      theme: ThemeData(
        brightness: Brightness.dark,
        scaffoldBackgroundColor: AppConstants.backgroundDark,
        textTheme: GoogleFonts.rajdhaniTextTheme(ThemeData.dark().textTheme),
        colorScheme: const ColorScheme.dark(
          primary: Colors.white,
          secondary: AppConstants.stealthBlue,
          surface: AppConstants.surfaceDark,
        ),
      ),
      home: const SplashScreen(),
    );
  }
}

/// Backward compatibility aliases
typedef CyberNinjaApp = CyberNinjaRunnerApp;
typedef SqubeDarknessApp = CyberNinjaRunnerApp;
