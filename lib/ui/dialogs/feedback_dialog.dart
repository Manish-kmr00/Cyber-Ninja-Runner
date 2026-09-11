import 'package:flutter/material.dart';
import '../../core/audio/audio_service.dart';
import '../../core/constants/app_constants.dart';
import '../../core/services/feedback_service.dart';
import '../../core/storage/save_service.dart';

class FeedbackDialog extends StatefulWidget {
  final SaveService saveService;

  const FeedbackDialog({super.key, required this.saveService});

  static Future<void> show(BuildContext context, SaveService saveService) {
    AudioService().playClick();
    return showDialog(
      context: context,
      barrierDismissible: false,
      builder: (ctx) => FeedbackDialog(saveService: saveService),
    );
  }

  @override
  State<FeedbackDialog> createState() => _FeedbackDialogState();
}

class _FeedbackDialogState extends State<FeedbackDialog> {
  final _emailController = TextEditingController();
  final _messageController = TextEditingController();
  final _formKey = GlobalKey<FormState>();

  String _selectedCategory = 'BUG REPORT';
  bool _includeTelemetry = true;
  bool _isTransmitting = false;
  String? _statusMessage;
  bool _isSuccess = false;
  bool _showDirectEmailOption = false;

  final List<String> _categories = [
    'BUG REPORT',
    'GAMEPLAY ISSUE',
    'FEATURE REQUEST',
    'GENERAL FEEDBACK',
  ];

  @override
  void dispose() {
    _emailController.dispose();
    _messageController.dispose();
    super.dispose();
  }

  Color _getCategoryColor(String cat) {
    switch (cat) {
      case 'BUG REPORT':
        return AppConstants.hazardRed;
      case 'GAMEPLAY ISSUE':
        return AppConstants.coinGold;
      case 'FEATURE REQUEST':
        return const Color(0xFF00E5FF);
      default:
        return const Color(0xFF00E676);
    }
  }

  Future<void> _handleTransmit() async {
    if (!_formKey.currentState!.validate()) return;
    AudioService().playClick();

    setState(() {
      _isTransmitting = true;
      _statusMessage = '// ENCRYPTING & TRANSMITTING TO DEV HQ...';
      _showDirectEmailOption = false;
    });

    Map<String, dynamic>? telemetry;
    if (_includeTelemetry) {
      telemetry = {
        'gameVersion': 'Protocol v2.5',
        'vaultCP': widget.saveService.player.cyberPoints.value,
        'selectedHero': widget.saveService.player.selectedHero.name,
        'equippedSkin': widget.saveService.player.equippedSkin.name,
        'highScoreSector1': widget.saveService.stats.bestDistanceRun,
        'totalRuns': widget.saveService.stats.totalRuns,
        'sfxVolume': widget.saveService.settings.sfxVolume,
        'musicVolume': widget.saveService.settings.musicVolume,
        'hapticsEnabled': widget.saveService.settings.hapticsEnabled,
        'controlScheme': widget.saveService.settings.controlScheme.name,
      };
    }

    final result = await FeedbackService().sendFeedback(
      category: _selectedCategory,
      message: _messageController.text.trim(),
      email: _emailController.text.trim(),
      telemetry: telemetry,
    );

    if (!mounted) return;

    if (result.success) {
      AudioService().playCollect();
      setState(() {
        _isTransmitting = false;
        _isSuccess = true;
        _statusMessage = '// TRANSMISSION CONFIRMED. LOG DELIVERED TO GMAIL.';
      });
    } else {
      AudioService().playBooster();
      setState(() {
        _isTransmitting = false;
        _isSuccess = false;
        _showDirectEmailOption = true;
        if (result.message == 'SCRIPT_URL_NOT_CONFIGURED') {
          _statusMessage =
              '// GOOGLE SCRIPT URL PENDING SETUP. USE DIRECT GMAIL DISPATCH:';
        } else if (result.message == 'AUTH_REQUIRED') {
          _statusMessage =
              '// APPS SCRIPT PERMISSION: IN DEPLOYMENT, SET "WHO HAS ACCESS: ANYONE". DISPATCH VIA GMAIL DIRECTLY:';
        } else {
          _statusMessage =
              '// NETWORK DISPATCH FAILED. DISPATCH VIA GMAIL DIRECTLY:';
        }
      });
    }
  }

  Future<void> _handleDirectEmail() async {
    AudioService().playClick();
    Map<String, dynamic>? telemetry;
    if (_includeTelemetry) {
      telemetry = {
        'gameVersion': 'Protocol v2.5',
        'vaultCP': widget.saveService.player.cyberPoints.value,
        'highScore': widget.saveService.stats.bestDistanceRun,
      };
    }
    await FeedbackService().launchEmailClient(
      category: _selectedCategory,
      message: _messageController.text.trim().isNotEmpty
          ? _messageController.text.trim()
          : 'User Feedback / Problem Submission',
      telemetry: telemetry,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Dialog(
      backgroundColor: Colors.transparent,
      insetPadding: const EdgeInsets.symmetric(horizontal: 24, vertical: 20),
      child: Center(
        child: Container(
          width: 620,
          constraints: const BoxConstraints(maxHeight: 580),
          decoration: BoxDecoration(
            color: const Color(0xFF0C1017),
            borderRadius: BorderRadius.circular(18),
            border: Border.all(
              color: const Color(0xFF00E5FF).withValues(alpha: 0.6),
              width: 1.5,
            ),
            boxShadow: [
              BoxShadow(
                color: const Color(0xFF00E5FF).withValues(alpha: 0.2),
                blurRadius: 28,
                spreadRadius: 2,
              ),
            ],
          ),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              // Header
              Container(
                padding: const EdgeInsets.symmetric(
                  horizontal: 18,
                  vertical: 14,
                ),
                decoration: BoxDecoration(
                  color: const Color(0xFF131924),
                  borderRadius: const BorderRadius.vertical(
                    top: Radius.circular(16),
                  ),
                  border: Border(
                    bottom: BorderSide(
                      color: Colors.white.withValues(alpha: 0.1),
                    ),
                  ),
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Row(
                      children: [
                        Container(
                          padding: const EdgeInsets.all(6),
                          decoration: BoxDecoration(
                            color: const Color(
                              0xFF00E5FF,
                            ).withValues(alpha: 0.15),
                            borderRadius: BorderRadius.circular(8),
                          ),
                          child: const Icon(
                            Icons.terminal_rounded,
                            color: Color(0xFF00E5FF),
                            size: 18,
                          ),
                        ),
                        const SizedBox(width: 10),
                        Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: const [
                            Text(
                              'TRANSMIT FEEDBACK // PROBLEM REPORT',
                              style: TextStyle(
                                color: Colors.white,
                                fontWeight: FontWeight.w900,
                                fontSize: 13,
                                letterSpacing: 1.2,
                                fontFamily: 'monospace',
                              ),
                            ),
                            Text(
                              'DIRECT GOOGLE GMAIL SCRIPT LINK',
                              style: TextStyle(
                                color: Color(0xFF00E5FF),
                                fontSize: 10,
                                fontFamily: 'monospace',
                                letterSpacing: 0.8,
                              ),
                            ),
                          ],
                        ),
                      ],
                    ),
                    IconButton(
                      icon: const Icon(Icons.close, color: Colors.white60),
                      onPressed: () {
                        AudioService().playClick();
                        Navigator.of(context).pop();
                      },
                    ),
                  ],
                ),
              ),

              // Form body
              Flexible(
                child: SingleChildScrollView(
                  padding: const EdgeInsets.all(18),
                  child: Form(
                    key: _formKey,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        // Success View
                        if (_isSuccess) ...[
                          Container(
                            padding: const EdgeInsets.all(16),
                            decoration: BoxDecoration(
                              color: const Color(0xFF0E251A),
                              borderRadius: BorderRadius.circular(12),
                              border: Border.all(
                                color: const Color(0xFF00E676),
                                width: 1.2,
                              ),
                            ),
                            child: Column(
                              children: [
                                const Icon(
                                  Icons.check_circle_outline_rounded,
                                  color: Color(0xFF00E676),
                                  size: 42,
                                ),
                                const SizedBox(height: 10),
                                const Text(
                                  'TRANSMISSION DELIVERED',
                                  style: TextStyle(
                                    color: Color(0xFF00E676),
                                    fontWeight: FontWeight.w900,
                                    fontSize: 14,
                                    letterSpacing: 1.2,
                                    fontFamily: 'monospace',
                                  ),
                                ),
                                const SizedBox(height: 6),
                                Text(
                                  _statusMessage ?? '',
                                  textAlign: TextAlign.center,
                                  style: const TextStyle(
                                    color: Colors.white70,
                                    fontSize: 11.5,
                                    fontFamily: 'monospace',
                                  ),
                                ),
                              ],
                            ),
                          ),
                          const SizedBox(height: 20),
                          Center(
                            child: ElevatedButton(
                              style: ElevatedButton.styleFrom(
                                backgroundColor: const Color(0xFF00E5FF),
                                foregroundColor: Colors.black,
                                padding: const EdgeInsets.symmetric(
                                  horizontal: 32,
                                  vertical: 12,
                                ),
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(10),
                                ),
                              ),
                              onPressed: () {
                                AudioService().playClick();
                                Navigator.of(context).pop();
                              },
                              child: const Text(
                                'CLOSE CONSOLE',
                                style: TextStyle(
                                  fontWeight: FontWeight.w900,
                                  letterSpacing: 1.0,
                                ),
                              ),
                            ),
                          ),
                        ] else ...[
                          // Category Selector
                          const Text(
                            'REPORT CATEGORY',
                            style: TextStyle(
                              color: Colors.white70,
                              fontSize: 10.5,
                              fontWeight: FontWeight.w800,
                              fontFamily: 'monospace',
                              letterSpacing: 1.0,
                            ),
                          ),
                          const SizedBox(height: 8),
                          Wrap(
                            spacing: 8,
                            runSpacing: 8,
                            children: _categories.map((cat) {
                              final isSelected = _selectedCategory == cat;
                              final catColor = _getCategoryColor(cat);
                              return InkWell(
                                onTap: () {
                                  AudioService().playClick();
                                  setState(() => _selectedCategory = cat);
                                },
                                borderRadius: BorderRadius.circular(8),
                                child: Container(
                                  padding: const EdgeInsets.symmetric(
                                    horizontal: 10,
                                    vertical: 6,
                                  ),
                                  decoration: BoxDecoration(
                                    color: isSelected
                                        ? catColor.withValues(alpha: 0.2)
                                        : const Color(0xFF131A26),
                                    borderRadius: BorderRadius.circular(8),
                                    border: Border.all(
                                      color: isSelected
                                          ? catColor
                                          : Colors.white12,
                                      width: isSelected ? 1.5 : 1.0,
                                    ),
                                  ),
                                  child: Text(
                                    cat,
                                    style: TextStyle(
                                      color: isSelected
                                          ? catColor
                                          : Colors.white60,
                                      fontSize: 10.5,
                                      fontWeight: FontWeight.w800,
                                      fontFamily: 'monospace',
                                    ),
                                  ),
                                ),
                              );
                            }).toList(),
                          ),
                          const SizedBox(height: 14),

                          // Contact Email (Optional)
                          const Text(
                            'YOUR CONTACT EMAIL (OPTIONAL)',
                            style: TextStyle(
                              color: Colors.white70,
                              fontSize: 10.5,
                              fontWeight: FontWeight.w800,
                              fontFamily: 'monospace',
                              letterSpacing: 1.0,
                            ),
                          ),
                          const SizedBox(height: 6),
                          TextFormField(
                            controller: _emailController,
                            style: const TextStyle(
                              color: Colors.white,
                              fontSize: 12,
                              fontFamily: 'monospace',
                            ),
                            decoration: InputDecoration(
                              hintText: 'e.g. agent@cybermail.com',
                              hintStyle: const TextStyle(
                                color: Colors.white24,
                                fontSize: 11,
                              ),
                              filled: true,
                              fillColor: const Color(0xFF121824),
                              contentPadding: const EdgeInsets.symmetric(
                                horizontal: 12,
                                vertical: 10,
                              ),
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  color: Colors.white12,
                                ),
                              ),
                              enabledBorder: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  color: Colors.white12,
                                ),
                              ),
                              focusedBorder: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  color: Color(0xFF00E5FF),
                                ),
                              ),
                            ),
                          ),
                          const SizedBox(height: 14),

                          // Problem Description
                          const Text(
                            'PROBLEM DETAILS / FEEDBACK *',
                            style: TextStyle(
                              color: Colors.white70,
                              fontSize: 10.5,
                              fontWeight: FontWeight.w800,
                              fontFamily: 'monospace',
                              letterSpacing: 1.0,
                            ),
                          ),
                          const SizedBox(height: 6),
                          TextFormField(
                            controller: _messageController,
                            maxLines: 4,
                            validator: (val) {
                              if (val == null || val.trim().isEmpty) {
                                return 'Please describe your problem or suggestion';
                              }
                              return null;
                            },
                            style: const TextStyle(
                              color: Colors.white,
                              fontSize: 12,
                              fontFamily: 'monospace',
                            ),
                            decoration: InputDecoration(
                              hintText:
                                  'Explain what happened or what you would like improved...',
                              hintStyle: const TextStyle(
                                color: Colors.white24,
                                fontSize: 11,
                              ),
                              filled: true,
                              fillColor: const Color(0xFF121824),
                              contentPadding: const EdgeInsets.all(12),
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  color: Colors.white12,
                                ),
                              ),
                              enabledBorder: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  color: Colors.white12,
                                ),
                              ),
                              focusedBorder: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10),
                                borderSide: const BorderSide(
                                  color: Color(0xFF00E5FF),
                                ),
                              ),
                            ),
                          ),
                          const SizedBox(height: 10),

                          // Telemetry toggle
                          Row(
                            children: [
                              SizedBox(
                                height: 24,
                                width: 24,
                                child: Checkbox(
                                  value: _includeTelemetry,
                                  activeColor: const Color(0xFF00E5FF),
                                  checkColor: Colors.black,
                                  onChanged: (val) {
                                    setState(
                                      () => _includeTelemetry = val ?? true,
                                    );
                                  },
                                ),
                              ),
                              const SizedBox(width: 8),
                              const Expanded(
                                child: Text(
                                  'Attach diagnostic telemetry (App v2.5, Vault CP, High Score)',
                                  style: TextStyle(
                                    color: Colors.white60,
                                    fontSize: 11,
                                    fontFamily: 'monospace',
                                  ),
                                ),
                              ),
                            ],
                          ),

                          // Status / Fallback Notice
                          if (_statusMessage != null) ...[
                            const SizedBox(height: 10),
                            Container(
                              width: double.infinity,
                              padding: const EdgeInsets.all(10),
                              decoration: BoxDecoration(
                                color: _showDirectEmailOption
                                    ? const Color(0xFF231218)
                                    : const Color(0xFF121D2A),
                                borderRadius: BorderRadius.circular(8),
                                border: Border.all(
                                  color: _showDirectEmailOption
                                      ? AppConstants.hazardRed
                                      : const Color(0xFF00E5FF),
                                  width: 1,
                                ),
                              ),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    _statusMessage!,
                                    style: TextStyle(
                                      color: _showDirectEmailOption
                                          ? AppConstants.hazardRed
                                          : const Color(0xFF00E5FF),
                                      fontSize: 10.5,
                                      fontWeight: FontWeight.bold,
                                      fontFamily: 'monospace',
                                    ),
                                  ),
                                  if (_showDirectEmailOption) ...[
                                    const SizedBox(height: 8),
                                    ElevatedButton.icon(
                                      style: ElevatedButton.styleFrom(
                                        backgroundColor: const Color(
                                          0xFFEA4335,
                                        ),
                                        foregroundColor: Colors.white,
                                        padding: const EdgeInsets.symmetric(
                                          horizontal: 14,
                                          vertical: 8,
                                        ),
                                        shape: RoundedRectangleBorder(
                                          borderRadius: BorderRadius.circular(
                                            8,
                                          ),
                                        ),
                                      ),
                                      onPressed: _handleDirectEmail,
                                      icon: const Icon(
                                        Icons.mail_outline_rounded,
                                        size: 16,
                                      ),
                                      label: const Text(
                                        'OPEN GMAIL DIRECTLY',
                                        style: TextStyle(
                                          fontSize: 11,
                                          fontWeight: FontWeight.w900,
                                          letterSpacing: 0.8,
                                        ),
                                      ),
                                    ),
                                  ],
                                ],
                              ),
                            ),
                          ],

                          const SizedBox(height: 16),

                          // Buttons
                          Row(
                            mainAxisAlignment: MainAxisAlignment.end,
                            children: [
                              TextButton(
                                onPressed: _isTransmitting
                                    ? null
                                    : () {
                                        AudioService().playClick();
                                        Navigator.of(context).pop();
                                      },
                                child: const Text(
                                  'ABORT',
                                  style: TextStyle(
                                    color: Colors.white54,
                                    fontFamily: 'monospace',
                                    fontWeight: FontWeight.w800,
                                  ),
                                ),
                              ),
                              const SizedBox(width: 10),
                              ElevatedButton(
                                style: ElevatedButton.styleFrom(
                                  backgroundColor: const Color(0xFF00E5FF),
                                  foregroundColor: Colors.black,
                                  padding: const EdgeInsets.symmetric(
                                    horizontal: 20,
                                    vertical: 10,
                                  ),
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(10),
                                  ),
                                ),
                                onPressed: _isTransmitting
                                    ? null
                                    : _handleTransmit,
                                child: _isTransmitting
                                    ? const SizedBox(
                                        width: 18,
                                        height: 18,
                                        child: CircularProgressIndicator(
                                          strokeWidth: 2,
                                          color: Colors.black,
                                        ),
                                      )
                                    : Row(
                                        mainAxisSize: MainAxisSize.min,
                                        children: const [
                                          Icon(
                                            Icons.send_rounded,
                                            size: 14,
                                            color: Colors.black,
                                          ),
                                          SizedBox(width: 6),
                                          Text(
                                            'TRANSMIT LOG',
                                            style: TextStyle(
                                              fontWeight: FontWeight.w900,
                                              fontSize: 11.5,
                                              letterSpacing: 1.0,
                                              fontFamily: 'monospace',
                                            ),
                                          ),
                                        ],
                                      ),
                              ),
                            ],
                          ),
                        ],
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
