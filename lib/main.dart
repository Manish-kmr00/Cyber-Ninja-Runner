import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'core/audio/audio_service.dart';
import 'core/constants/app_constants.dart';
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

  runApp(
    MultiProvider(
      providers: [ChangeNotifierProvider(create: (_) => SaveService())],
      child: const SqubeDarknessApp(),
    ),
  );
}

class SqubeDarknessApp extends StatelessWidget {
  const SqubeDarknessApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Cyber Ninja Runner',
      debugShowCheckedModeBanner: false,
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
