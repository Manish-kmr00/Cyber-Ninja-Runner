package com.smaato.sdk.rewarded.viewmodel;

import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel;
import com.smaato.sdk.rewarded.EventListener;
import com.smaato.sdk.rewarded.RewardedInterstitialAd;
import com.smaato.sdk.rewarded.view.RewardedAdDelegate;

/* JADX INFO: loaded from: classes13.dex */
public class RewardedAdViewModel extends InterstitialAdBaseViewModel {
    private RewardedAdDelegate rewardedAdDelegate;

    public RewardedAdViewModel(SmaatoSdkRepository smaatoSdkRepository, VastObjectChecker vastObjectChecker, Logger logger) {
        super(smaatoSdkRepository, vastObjectChecker, logger, new RewardedAdEventListenerNotifications(logger));
    }

    public void setRewardedAdEventListener(EventListener eventListener) {
        this.eventListenerNotifications.setEventListener(eventListener);
    }

    public void setRewardedAdDelegate(RewardedAdDelegate rewardedAdDelegate) {
        setInterstitialAdBaseDelegate(rewardedAdDelegate);
        this.rewardedAdDelegate = rewardedAdDelegate;
    }

    public void onAdStarted() {
        this.eventListenerNotifications.onAdStarted();
    }

    public void onAdError() {
        this.eventListenerNotifications.onInternalError();
    }

    public void onAdRewarded() {
        this.eventListenerNotifications.onAdReward();
    }

    public Integer getRichMediaRewardIntervalSeconds() {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse == null) {
            return null;
        }
        return adResponse.getRichMediaRewardIntervalSeconds();
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel
    protected void onAdLoadingSucceeded(AdResponse adResponse) {
        if (adResponse.getAdType() == AdType.RICH_MEDIA && adResponse.getRichMediaRewardIntervalSeconds() == null) {
            this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
            this.eventListenerNotifications.onAdLoadingException(new SomaException(SomaException.Type.BAD_RESPONSE, "Rich media ad for rewarded interstitial but no time for close button set"));
        } else {
            super.onAdLoadingSucceeded(adResponse);
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.rewarded.viewmodel.RewardedAdViewModel$1, reason: invalid class name */
    class AnonymousClass1 extends RewardedInterstitialAd {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public String getSessionId() {
            String sessionId = RewardedAdViewModel.this.getSessionId();
            return sessionId != null ? sessionId : "";
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public String getCreativeId() {
            return RewardedAdViewModel.this.getCreativeId();
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public String getAdSpaceId() {
            String adSpaceId = RewardedAdViewModel.this.getAdSpaceId();
            return adSpaceId != null ? adSpaceId : "";
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public boolean isAvailableForPresentation() {
            return RewardedAdViewModel.this.isAvailableForPresentation();
        }

        /* JADX INFO: renamed from: lambda$showAdInternal$0$com-smaato-sdk-rewarded-viewmodel-RewardedAdViewModel$1, reason: not valid java name */
        /* synthetic */ void m5644x10aa73b9() {
            RewardedAdViewModel.this.rewardedAdDelegate.showAd();
        }

        @Override // com.smaato.sdk.rewarded.RewardedInterstitialAd
        protected void showAdInternal() {
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdViewModel$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5644x10aa73b9();
                }
            });
        }
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel
    protected void createInterstitialAd() {
        this.interstitialAdBase = new AnonymousClass1();
    }
}
