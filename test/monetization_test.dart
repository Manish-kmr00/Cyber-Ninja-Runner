import 'package:flutter_test/flutter_test.dart';
import 'package:cyber_ninja_runner/core/monetization/frequency_manager.dart';
import 'package:cyber_ninja_runner/core/monetization/reward_validator.dart';
import 'package:cyber_ninja_runner/core/monetization/shared_counter_service.dart';

import 'package:cyber_ninja_runner/core/monetization/cp_boost_config.dart';
import 'package:cyber_ninja_runner/core/monetization/cp_boost_service.dart';
import 'package:cyber_ninja_runner/core/monetization/monetization_manager.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  group('Monetization Architecture Unit Tests', () {
    test('MonetizationConfig strictly enforces test mode by default', () {
      expect(MonetizationConfig.environment, MonetizationEnvironment.test);
      expect(MonetizationConfig.isTestMode, isTrue);

      // Verify default validation passes without throwing
      expect(() => MonetizationConfig.validateConfiguration(), returnsNormally);

      // Verify test AdMob IDs match Google test IDs
      expect(MonetizationConfig.adMobAppId, MonetizationConfig.testAdMobAppId);
      expect(
        MonetizationConfig.adMobRewardedUnitId,
        MonetizationConfig.testRewardedAdUnitId,
      );
      expect(
        MonetizationConfig.adMobInterstitialUnitId,
        MonetizationConfig.testInterstitialAdUnitId,
      );
      expect(MonetizationConfig.adMobAppId, contains('3940256099942544'));

      // Verify TopOn IDs are populated
      expect(MonetizationConfig.topOnAppId, equals('h6aa91bb8dc11b'));
      expect(MonetizationConfig.rewardedPlacementId, equals('n6aa91d84caf8e'));
      expect(
        MonetizationConfig.interstitialPlacementId,
        equals('n6aa925b616e0b'),
      );
    });

    test(
      'MonetizationConfig validates configuration and rejects cross-contamination',
      () {
        // Valid Test configuration must pass
        expect(
          () => MonetizationConfig.validateIdsForEnvironment(
            MonetizationEnvironment.test,
            appId: MonetizationConfig.testAdMobAppId,
            rewardedUnitId: MonetizationConfig.testRewardedAdUnitId,
            interstitialUnitId: MonetizationConfig.testInterstitialAdUnitId,
          ),
          returnsNormally,
        );

        // Test environment using Production AdMob IDs must be rejected
        expect(
          () => MonetizationConfig.validateIdsForEnvironment(
            MonetizationEnvironment.test,
            appId: MonetizationConfig.productionAdMobAppId, // Contamination!
            rewardedUnitId: MonetizationConfig.testRewardedAdUnitId,
            interstitialUnitId: MonetizationConfig.testInterstitialAdUnitId,
          ),
          throwsA(isA<StateError>()),
        );

        // Production environment using Test AdMob IDs must be rejected
        expect(
          () => MonetizationConfig.validateIdsForEnvironment(
            MonetizationEnvironment.production,
            appId: MonetizationConfig.testAdMobAppId, // Contamination!
            rewardedUnitId: MonetizationConfig.productionRewardedAdUnitId,
            interstitialUnitId:
                MonetizationConfig.productionInterstitialAdUnitId,
          ),
          throwsA(isA<StateError>()),
        );

        // Valid Production configuration must pass
        expect(
          () => MonetizationConfig.validateIdsForEnvironment(
            MonetizationEnvironment.production,
            appId: MonetizationConfig.productionAdMobAppId,
            rewardedUnitId: MonetizationConfig.productionRewardedAdUnitId,
            interstitialUnitId:
                MonetizationConfig.productionInterstitialAdUnitId,
          ),
          returnsNormally,
        );
      },
    );

    test('SharedCounterService increment, get, and reset logic', () {
      final counter = SharedCounterService();
      const testKey = 'test_counter_metric';

      counter.reset(testKey);
      expect(counter.get(testKey), 0);

      counter.increment(testKey);
      expect(counter.get(testKey), 1);

      counter.increment(testKey, delta: 4);
      expect(counter.get(testKey), 5);

      final allowed = counter.incrementIfAllowed(testKey, 6);
      expect(allowed, isTrue);
      expect(counter.get(testKey), 6);

      final rejected = counter.incrementIfAllowed(testKey, 6);
      expect(rejected, isFalse);
      expect(counter.get(testKey), 6);
    });

    test('RewardValidator enforces single-grant and blocks duplicates', () {
      final validator = RewardValidator();
      final tx = validator.createTransaction(RewardType.revive);

      expect(tx.status, RewardTransactionStatus.pending);
      expect(tx.granted, isFalse);

      // First validation: must succeed
      final firstAttempt = validator.validateAndGrant(tx.transactionId);
      expect(firstAttempt, isTrue);
      expect(tx.granted, isTrue);
      expect(tx.status, RewardTransactionStatus.granted);

      // Second validation attempt: must be blocked as duplicate
      final secondAttempt = validator.validateAndGrant(tx.transactionId);
      expect(secondAttempt, isFalse);
    });

    test('FrequencyManager gates interstitials before minimum runs', () {
      final freq = FrequencyManager();
      // Initially, runs < 3 -> should be gated
      final check = freq.canShowInterstitial();
      if (freq.getCompletedRunsInSession() <
          MonetizationConfig.minimumRunsBeforeFirstInterstitial) {
        expect(check.allowed, isFalse);
        expect(check.reason, contains('completed runs'));
      }
    });

    test(
      'CpBoostConfig contains configured tiers, daily limits, and cooldown',
      () {
        expect(CpBoostConfig.maxDailyAds, 10);
        expect(CpBoostConfig.cooldownSeconds, 60);
        expect(CpBoostConfig.tiers.length, 3);

        expect(CpBoostConfig.tiers[0].rewardCp, 500);
        expect(CpBoostConfig.tiers[1].rewardCp, 750);
        expect(CpBoostConfig.tiers[2].rewardCp, 1000);
      },
    );

    test('CpBoostService correctly evaluates button states and limits', () {
      final boostService = CpBoostService();
      boostService.resetForTesting();

      expect(boostService.adsWatchedToday, 0);
      expect(boostService.remainingAdsToday, 10);
      expect(boostService.isDailyLimitReached, isFalse);
      expect(boostService.isCooldownActive, isFalse);

      // Button state when ad is ready
      final readyState = boostService.getButtonState(
        tierId: 'tier_1',
        isAdReady: true,
      );
      expect(readyState, CpBoostButtonState.watchAd);

      // Button state when ad is not ready
      final notReadyState = boostService.getButtonState(
        tierId: 'tier_1',
        isAdReady: false,
      );
      expect(notReadyState, CpBoostButtonState.adNotReady);
    });

    test('RewardValidator validates and grants cpBoost transactions', () {
      final validator = RewardValidator();
      final tx = validator.createTransaction(RewardType.cpBoost);

      expect(tx.rewardType, RewardType.cpBoost);
      expect(tx.status, RewardTransactionStatus.pending);

      final granted = validator.validateAndGrant(tx.transactionId);
      expect(granted, isTrue);
      expect(tx.status, RewardTransactionStatus.granted);

      // Second grant must be rejected
      final duplicateBlocked = validator.validateAndGrant(tx.transactionId);
      expect(duplicateBlocked, isFalse);
    });

    test(
      'Single-ad Revive: RewardValidator grants exactly once and blocks duplicates',
      () {
        final validator = RewardValidator();
        final tx = validator.createTransaction(RewardType.revive);

        expect(tx.rewardType, RewardType.revive);
        expect(tx.status, RewardTransactionStatus.pending);

        // First callback grants reward (triggers single revive)
        final granted = validator.validateAndGrant(tx.transactionId);
        expect(granted, isTrue);
        expect(tx.status, RewardTransactionStatus.granted);

        // Duplicate callback must be blocked
        final duplicateBlocked = validator.validateAndGrant(tx.transactionId);
        expect(duplicateBlocked, isFalse);
      },
    );

    test(
      'Single-ad Daily Crate: RewardValidator grants exactly once and blocks duplicates',
      () {
        final validator = RewardValidator();
        final tx = validator.createTransaction(RewardType.dailyCrateBonus);

        expect(tx.rewardType, RewardType.dailyCrateBonus);
        expect(tx.status, RewardTransactionStatus.pending);

        final granted = validator.validateAndGrant(tx.transactionId);
        expect(granted, isTrue);
        expect(tx.status, RewardTransactionStatus.granted);

        final duplicateBlocked = validator.validateAndGrant(tx.transactionId);
        expect(duplicateBlocked, isFalse);
      },
    );

    test(
      'Single-ad Double CP: RewardValidator grants exactly once and blocks duplicates',
      () {
        final validator = RewardValidator();
        final tx = validator.createTransaction(RewardType.doubleCyberPoints);

        expect(tx.rewardType, RewardType.doubleCyberPoints);
        expect(tx.status, RewardTransactionStatus.pending);

        final granted = validator.validateAndGrant(tx.transactionId);
        expect(granted, isTrue);
        expect(tx.status, RewardTransactionStatus.granted);

        final duplicateBlocked = validator.validateAndGrant(tx.transactionId);
        expect(duplicateBlocked, isFalse);
      },
    );

    test(
      'Single-ad cancellation: ungranted transaction remains unfulfilled',
      () {
        final validator = RewardValidator();
        final tx = validator.createTransaction(RewardType.revive);

        // User closed ad before earning reward -> markFailed
        validator.markFailed(tx.transactionId);
        expect(tx.status, RewardTransactionStatus.failed);
        expect(tx.granted, isFalse);
      },
    );

    test('ConsentResult parses native UMP maps correctly and safely', () {
      // 1. Null map returns safe defaults
      final defaultResult = ConsentResult.fromMap(null);
      expect(defaultResult.canRequestAds, isTrue);
      expect(defaultResult.consentStatus, 'NOT_REQUIRED');
      expect(defaultResult.isPrivacyOptionsRequired, isFalse);
      expect(defaultResult.error, isNull);

      // 2. Parsed valid map with consent obtained
      final obtainedResult = ConsentResult.fromMap({
        'canRequestAds': true,
        'consentStatus': 'OBTAINED',
        'isPrivacyOptionsRequired': true,
      });
      expect(obtainedResult.canRequestAds, isTrue);
      expect(obtainedResult.consentStatus, 'OBTAINED');
      expect(obtainedResult.isPrivacyOptionsRequired, isTrue);
      expect(obtainedResult.error, isNull);

      // 3. Parsed map where user/regulation restricted ads
      final restrictedResult = ConsentResult.fromMap({
        'canRequestAds': false,
        'consentStatus': 'REQUIRED',
        'isPrivacyOptionsRequired': true,
      });
      expect(restrictedResult.canRequestAds, isFalse);
      expect(restrictedResult.consentStatus, 'REQUIRED');
      expect(restrictedResult.isPrivacyOptionsRequired, isTrue);

      // 4. Parsed map with error payload
      final errorResult = ConsentResult.fromMap({
        'canRequestAds': true,
        'consentStatus': 'ERROR',
        'isPrivacyOptionsRequired': false,
        'error': 'Network timeout',
      });
      expect(errorResult.canRequestAds, isTrue);
      expect(errorResult.consentStatus, 'ERROR');
      expect(errorResult.isPrivacyOptionsRequired, isFalse);
      expect(errorResult.error, 'Network timeout');
    });

    test('MonetizationManager exposes UMP consent state and privacy options', () {
      final manager = MonetizationManager();
      // Initially, consentResult may be null before init completes in test harness
      expect(manager.canRequestAds, isTrue);
      expect(manager.isPrivacyOptionsRequired, isFalse);
    });
  });
}
