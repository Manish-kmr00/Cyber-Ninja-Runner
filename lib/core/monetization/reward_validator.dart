import 'dart:math';
import 'package:flutter/foundation.dart';
import 'monetization_analytics.dart';
import 'monetization_events.dart';
import 'shared_counter_service.dart';

/// Represents an individual reward claim transaction.
class RewardTransaction {
  final String transactionId;
  final RewardType rewardType;
  final DateTime createdAt;
  RewardTransactionStatus status;
  bool granted;

  RewardTransaction({
    required this.transactionId,
    required this.rewardType,
    required this.createdAt,
    this.status = RewardTransactionStatus.pending,
    this.granted = false,
  });
}

/// Validates reward grants and strictly enforces idempotency against duplicate callbacks.
class RewardValidator {
  static final RewardValidator _instance = RewardValidator._internal();
  factory RewardValidator() => _instance;
  RewardValidator._internal();

  final SharedCounterService _counter = SharedCounterService();
  final Map<String, RewardTransaction> _activeTransactions = {};
  final Random _random = Random();

  /// Creates a new pending reward transaction.
  RewardTransaction createTransaction(RewardType rewardType) {
    final txId =
        'tx_${DateTime.now().millisecondsSinceEpoch}_${_random.nextInt(999999).toString().padLeft(6, '0')}';
    final tx = RewardTransaction(
      transactionId: txId,
      rewardType: rewardType,
      createdAt: DateTime.now(),
    );
    _activeTransactions[txId] = tx;
    debugPrint(
      '[RewardValidator] Created reward transaction: $txId (${rewardType.name})',
    );
    return tx;
  }

  /// Validates the transaction and marks it as granted.
  ///
  /// Returns true ONLY if the transaction was pending and not previously granted.
  /// Returns false if duplicate, unknown, or already fulfilled.
  bool validateAndGrant(String transactionId) {
    // 1. Check persistent MMKV storage to guarantee lifetime uniqueness
    final isAlreadyGrantedInStorage =
        _counter.getString('monetization.granted_tx.$transactionId') != null;
    if (isAlreadyGrantedInStorage) {
      debugPrint(
        '[RewardValidator] DUPLICATE REWARD BLOCKED: $transactionId was already granted in storage!',
      );
      MonetizationAnalytics.trackEvent(
        AdEventType.rewardGrantDuplicateBlocked,
        {'transaction_id': transactionId},
      );
      return false;
    }

    final tx = _activeTransactions[transactionId];
    if (tx == null) {
      debugPrint(
        '[RewardValidator] VALIDATION FAILED: Transaction $transactionId not found in active map.',
      );
      return false;
    }

    if (tx.granted || tx.status == RewardTransactionStatus.granted) {
      debugPrint(
        '[RewardValidator] DUPLICATE REWARD BLOCKED: Transaction $transactionId already marked granted in memory.',
      );
      MonetizationAnalytics.trackEvent(
        AdEventType.rewardGrantDuplicateBlocked,
        {'transaction_id': transactionId, 'reward_type': tx.rewardType.name},
      );
      return false;
    }

    // Mark as granted atomically
    tx.granted = true;
    tx.status = RewardTransactionStatus.granted;
    _counter.setString(
      'monetization.granted_tx.$transactionId',
      DateTime.now().toIso8601String(),
    );

    debugPrint(
      '[RewardValidator] TRANSACTION VALIDATED & GRANTED: $transactionId (${tx.rewardType.name})',
    );
    MonetizationAnalytics.trackEvent(AdEventType.rewardGranted, {
      'transaction_id': transactionId,
      'reward_type': tx.rewardType.name,
    });
    return true;
  }

  /// Marks a transaction as failed or cancelled.
  void markFailed(String transactionId) {
    final tx = _activeTransactions[transactionId];
    if (tx != null) {
      tx.status = RewardTransactionStatus.failed;
      debugPrint('[RewardValidator] Transaction marked failed: $transactionId');
    }
  }
}
