package com.smaato.sdk.rewarded.view;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.ad.KeyValuePairs;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Intents;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate;
import com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel;
import com.smaato.sdk.rewarded.EventListener;
import com.smaato.sdk.rewarded.model.csm.RewardedCsmDelegate;
import com.smaato.sdk.rewarded.viewmodel.RewardedAdViewModel;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RewardedAdDelegate extends InterstitialAdBaseDelegate {

    @Inject
    private Application application;
    private CountDownTimer progressBarTimer;

    @Inject
    private RewardedAdViewModel rewardedAdViewModel;

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate
    protected boolean videoIsClickable() {
        return true;
    }

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate
    protected boolean videoIsSkippable() {
        return false;
    }

    public RewardedAdDelegate() {
        setViewModel((InterstitialAdBaseViewModel) this.rewardedAdViewModel);
        this.rewardedAdViewModel.setRewardedAdDelegate(this);
    }

    public void loadAd(String str, EventListener eventListener, String str2, String str3, String str4, AdRequestParams adRequestParams, KeyValuePairs keyValuePairs, Map<String, Object> map) {
        if (eventListener == null) {
            ((InterstitialAdBaseDelegate) this).logger.error(LogDomain.REWARDED, "Failed to proceed with Interstitial::loadAd. Missing required parameter: eventListener", new Object[0]);
        } else {
            this.rewardedAdViewModel.setRewardedAdEventListener(eventListener);
            super.loadAd(str, AdFormat.VIDEO, str2, str3, str4, adRequestParams, keyValuePairs, map, "rewarded", false, true);
        }
    }

    public void showAd() {
        this.contentAdViewCreator.accept(this.application, new Runnable() { // from class: com.smaato.sdk.rewarded.view.RewardedAdDelegate$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5631lambda$showAd$0$comsmaatosdkrewardedviewRewardedAdDelegate();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAd$0$com-smaato-sdk-rewarded-view-RewardedAdDelegate, reason: not valid java name */
    /* synthetic */ void m5631lambda$showAd$0$comsmaatosdkrewardedviewRewardedAdDelegate() {
        Object obj = this.csmDelegate;
        if (obj instanceof RewardedCsmDelegate) {
            RewardedCsmDelegate rewardedCsmDelegate = (RewardedCsmDelegate) obj;
            rewardedCsmDelegate.setDelegateListener(createCsmDelegateListener());
            rewardedCsmDelegate.showAd();
        } else {
            Intent intentCreateIntent = RewardedInterstitialAdActivity.createIntent(this.application, this.delegateUUID);
            this.viewDelegateStorage.add(this.delegateUUID, this);
            Intents.startIntent(this.application, intentCreateIntent);
            this.rewardedAdViewModel.onAdStarted();
        }
    }

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate, com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onVideoCompleted(boolean z) {
        super.onVideoCompleted(z);
        this.rewardedAdViewModel.onAdRewarded();
    }

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate
    public void onCloseClicked() {
        super.onCloseClicked();
        if (this.rewardedAdViewModel.isDisplayingVideoAd()) {
            return;
        }
        this.rewardedAdViewModel.onAdRewarded();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    protected void onPredrawOfAdContentView(AdContentView adContentView) {
        if (this.rewardedAdViewModel.isDisplayingVideoAd() || this.rewardedAdViewModel.getRichMediaRewardIntervalSeconds() == null) {
            return;
        }
        startCloseButtonTimerForRewardedRichMediaAd(this.rewardedAdViewModel.getRichMediaRewardIntervalSeconds());
        updateProgressBar(this.rewardedAdViewModel.getRichMediaRewardIntervalSeconds().intValue());
    }

    private RewardedCsmDelegate.CsmRewardedListener createCsmDelegateListener() {
        return new RewardedCsmDelegate.CsmRewardedListener() { // from class: com.smaato.sdk.rewarded.view.RewardedAdDelegate.1
            @Override // com.smaato.sdk.rewarded.model.csm.RewardedCsmDelegate.CsmRewardedListener
            public void onAdStarted() {
                RewardedAdDelegate.this.rewardedAdViewModel.onAdStarted();
            }

            @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate.CsmBaseDelegateListener
            public void onAdImpressed() {
                RewardedAdDelegate.this.rewardedAdViewModel.onAdImpressed();
            }

            @Override // com.smaato.sdk.rewarded.model.csm.RewardedCsmDelegate.CsmRewardedListener
            public void onAdError() {
                RewardedAdDelegate.this.rewardedAdViewModel.onAdError();
            }

            @Override // com.smaato.sdk.rewarded.model.csm.RewardedCsmDelegate.CsmRewardedListener
            public void onAdReward() {
                RewardedAdDelegate.this.rewardedAdViewModel.onAdRewarded();
            }

            @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate.CsmBaseDelegateListener
            public void onAdClosed() {
                ((InterstitialAdBaseDelegate) RewardedAdDelegate.this).interstitialAdBaseViewModel.onAdClosed();
            }
        };
    }

    private void startCloseButtonTimerForRewardedRichMediaAd(Integer num) {
        if (num == null || this.useCustomClose) {
            return;
        }
        startOrResumeCountdownAndCloseButtonTimer(num.intValue() * 1000);
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void hideRichMediaAd() {
        onCloseClicked();
    }

    void updateProgressBar(long j) {
        ProgressBar progressBar;
        if (j <= 0) {
            return;
        }
        final long j2 = j * 1000;
        if (this.rewardedAdViewModel.isDisplayingVideoAd() || (progressBar = this.progressBar) == null) {
            return;
        }
        progressBar.setVisibility(0);
        this.progressBar.setProgress(0);
        this.progressBar.setMax(((int) j2) / 50);
        CountDownTimer countDownTimer = new CountDownTimer(j2, 10L) { // from class: com.smaato.sdk.rewarded.view.RewardedAdDelegate.2
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                int i = (int) ((j2 - j3) / 50.0f);
                if (((InterstitialAdBaseDelegate) RewardedAdDelegate.this).progressBar != null) {
                    ((InterstitialAdBaseDelegate) RewardedAdDelegate.this).progressBar.setProgress(i, true);
                } else if (((InterstitialAdBaseDelegate) RewardedAdDelegate.this).progressBar != null) {
                    ((InterstitialAdBaseDelegate) RewardedAdDelegate.this).progressBar.setProgress(i);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                RewardedAdDelegate.this.progressBarTimer.cancel();
            }
        };
        this.progressBarTimer = countDownTimer;
        countDownTimer.start();
    }

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate
    public void onActivityFinishing() {
        super.onActivityFinishing();
        CountDownTimer countDownTimer = this.progressBarTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
