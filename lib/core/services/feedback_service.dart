import 'dart:convert';
import 'dart:io';
import 'package:flutter/foundation.dart';
import 'package:url_launcher/url_launcher.dart';
import '../constants/app_constants.dart';

class FeedbackResult {
  final bool success;
  final String message;

  FeedbackResult({required this.success, required this.message});
}

class FeedbackService {
  static final FeedbackService _instance = FeedbackService._internal();
  factory FeedbackService() => _instance;
  FeedbackService._internal();

  /// Transmits user feedback payload to the configured Google Apps Script Web App.
  Future<FeedbackResult> sendFeedback({
    required String category,
    required String message,
    String? email,
    Map<String, dynamic>? telemetry,
  }) async {
    // If URL is not yet configured, notify the UI to offer fallback
    if (AppConstants.feedbackScriptUrl.contains('YOUR_SCRIPT_ID_HERE')) {
      return FeedbackResult(
        success: false,
        message: 'SCRIPT_URL_NOT_CONFIGURED',
      );
    }

    try {
      final uri = Uri.parse(AppConstants.feedbackScriptUrl);
      final client = HttpClient();
      client.connectionTimeout = const Duration(seconds: 15);

      final request = await client.postUrl(uri);
      // Google Apps Script redirect responses (302) to googleusercontent
      request.followRedirects = true;
      request.maxRedirects = 5;
      request.headers.contentType = ContentType.json;

      final payload = {
        'category': category,
        'message': message,
        'email': (email != null && email.trim().isNotEmpty)
            ? email.trim()
            : 'Anonymous Shinobi',
        'telemetry': telemetry ?? {},
        'timestamp': DateTime.now().toUtc().toIso8601String(),
      };

      request.write(jsonEncode(payload));
      final response = await request.close();
      final responseBody = await response.transform(utf8.decoder).join();
      client.close();

      debugPrint('Feedback response [${response.statusCode}]: $responseBody');

      if (response.statusCode >= 200 && response.statusCode < 400) {
        if (responseBody.contains('You need access') ||
            responseBody.contains('accounts.google.com') ||
            responseBody.contains('request-access-icon') ||
            responseBody.contains('Access denied')) {
          return FeedbackResult(success: false, message: 'AUTH_REQUIRED');
        }
        return FeedbackResult(success: true, message: 'Transmission received.');
      } else {
        if (response.statusCode == 403 ||
            responseBody.contains('You need access') ||
            responseBody.contains('accounts.google.com') ||
            responseBody.contains('Access denied')) {
          return FeedbackResult(success: false, message: 'AUTH_REQUIRED');
        }
        return FeedbackResult(
          success: false,
          message: 'Server responded with status: ${response.statusCode}',
        );
      }
    } catch (e) {
      debugPrint('Feedback transmission error: $e');
      return FeedbackResult(success: false, message: e.toString());
    }
  }

  /// Direct fallback to open device's default Gmail / email client with pre-filled content.
  Future<bool> launchEmailClient({
    required String category,
    required String message,
    Map<String, dynamic>? telemetry,
  }) async {
    final subject = Uri.encodeComponent('[Cyber Ninja Runner] $category');
    final telemetryText = telemetry != null && telemetry.isNotEmpty
        ? '\n\n--- SYSTEM TELEMETRY ---\n${telemetry.entries.map((e) => '${e.key}: ${e.value}').join('\n')}'
        : '';
    final body = Uri.encodeComponent(
      'Feedback / Issue Details:\n$message\n$telemetryText',
    );
    final mailtoUri = Uri.parse(
      'mailto:${AppConstants.supportEmail}?subject=$subject&body=$body',
    );
    try {
      final launched = await launchUrl(
        mailtoUri,
        mode: LaunchMode.externalApplication,
      );
      if (!launched) {
        return await launchUrl(mailtoUri);
      }
      return true;
    } catch (e) {
      debugPrint('Error launching email client: $e');
      return false;
    }
  }
}
