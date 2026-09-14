/// Core monetization types and event definitions for Cyber Ninja Runner.
library;

/// Supported reward types for rewarded video ads.
enum RewardType {
  revive,
  doubleCyberPoints,
  dailyCrateBonus,
  bonusReward,
  cpBoost,
}

/// Supported ad formats in the monetization architecture.
enum AdFormat { rewarded, interstitial }

/// Lifecycle events for ad operations.
enum AdEventType {
  adInitStarted,
  adInitCompleted,
  adInitFailed,
  rewardedLoadStarted,
  rewardedLoaded,
  rewardedLoadFailed,
  rewardedShown,
  rewardedCompleted,
  rewardGranted,
  rewardGrantDuplicateBlocked,
  interstitialLoadStarted,
  interstitialLoaded,
  interstitialShown,
  interstitialFailed,
  adNetworkSelected,
  adImpression,
  adClick,
  reviveAdRequested,
  reviveAdCompleted,
  reviveAdFailed,
  doubleCpRequested,
  doubleCpCompleted,
  dailyCrateAdRequested,
  dailyCrateAdCompleted,
  iapPurchaseStarted,
  iapPurchaseCompleted,
  cpBoostOpened,
  cpBoostAdRequested,
  cpBoostAdLoaded,
  cpBoostAdFailed,
  cpBoostAdCompleted,
  cpBoostRewardGranted,
  cpBoostRewardDuplicateBlocked,
  cpBoostDailyLimitReached,
}

/// Operating environment with strict test/production separation.
enum MonetizationEnvironment { test, production }

/// Status of a reward grant transaction.
enum RewardTransactionStatus { pending, granted, duplicateBlocked, failed }

/// Animation types supported by RewardAnimationService.
enum RewardAnimationType { coinReward, revive, doubleReward, treasureCrate }
