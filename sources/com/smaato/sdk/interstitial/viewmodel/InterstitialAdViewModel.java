package com.smaato.sdk.interstitial.viewmodel;

import android.app.Activity;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.view.InterstitialAdDelegate;

/* JADX INFO: loaded from: classes4.dex */
public class InterstitialAdViewModel extends InterstitialAdBaseViewModel {
    private InterstitialAdDelegate interstitialAdDelegate;

    public InterstitialAdViewModel(SmaatoSdkRepository smaatoSdkRepository, VastObjectChecker vastObjectChecker, Logger logger) {
        super(smaatoSdkRepository, vastObjectChecker, logger, new EventListenerNotifications(logger));
    }

    public void setInterstitialAdEventListener(EventListener eventListener) {
        this.eventListenerNotifications.setEventListener(eventListener);
    }

    public void setInterstitialAdDelegate(InterstitialAdDelegate interstitialAdDelegate) {
        setInterstitialAdBaseDelegate(interstitialAdDelegate);
        this.interstitialAdDelegate = interstitialAdDelegate;
    }

    public void onAdOpened() {
        this.eventListenerNotifications.onAdOpened();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.interstitial.viewmodel.InterstitialAdViewModel$1, reason: invalid class name */
    class AnonymousClass1 extends InterstitialAd {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public String getSessionId() {
            String sessionId = InterstitialAdViewModel.this.getSessionId();
            return sessionId != null ? sessionId : "";
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public String getCreativeId() {
            return InterstitialAdViewModel.this.getCreativeId();
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public String getAdSpaceId() {
            String adSpaceId = InterstitialAdViewModel.this.getAdSpaceId();
            return adSpaceId != null ? adSpaceId : "";
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAdBase
        public boolean isAvailableForPresentation() {
            return InterstitialAdViewModel.this.isAvailableForPresentation();
        }

        /* JADX INFO: renamed from: lambda$showAdInternal$0$com-smaato-sdk-interstitial-viewmodel-InterstitialAdViewModel$1, reason: not valid java name */
        /* synthetic */ void m5619xeb211079(Activity activity) {
            InterstitialAdViewModel.this.interstitialAdDelegate.showAd(activity, this.backgroundColor);
        }

        @Override // com.smaato.sdk.interstitial.InterstitialAd
        protected void showAdInternal(final Activity activity) {
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.interstitial.viewmodel.InterstitialAdViewModel$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5619xeb211079(activity);
                }
            });
        }
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel
    protected void createInterstitialAd() {
        this.interstitialAdBase = new AnonymousClass1();
    }
}
