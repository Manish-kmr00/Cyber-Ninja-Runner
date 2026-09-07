package com.smaato.sdk.interstitial.view;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.ad.KeyValuePairs;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Intents;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.model.csm.InterstitialCsmDelegate;
import com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel;
import com.smaato.sdk.interstitial.viewmodel.InterstitialAdViewModel;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class InterstitialAdDelegate extends InterstitialAdBaseDelegate {

    @Inject
    private InterstitialAdViewModel interstitialAdViewModel;
    private boolean isSplash;

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate
    protected boolean videoIsClickable() {
        return true;
    }

    @Override // com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate
    protected boolean videoIsSkippable() {
        return true;
    }

    public InterstitialAdDelegate() {
        setViewModel((InterstitialAdBaseViewModel) this.interstitialAdViewModel);
        this.interstitialAdViewModel.setInterstitialAdDelegate(this);
    }

    public void loadAd(String str, EventListener eventListener, String str2, String str3, String str4, AdRequestParams adRequestParams, KeyValuePairs keyValuePairs, Map<String, Object> map, boolean z) {
        if (eventListener == null) {
            ((InterstitialAdBaseDelegate) this).logger.error(LogDomain.INTERSTITIAL, "Failed to proceed with Interstitial::loadAd. Missing required parameter: eventListener", new Object[0]);
            return;
        }
        this.interstitialAdViewModel.setInterstitialAdEventListener(eventListener);
        this.isSplash = z;
        super.loadAd(str, AdFormat.INTERSTITIAL, str2, str3, str4, adRequestParams, keyValuePairs, map, "interstitial", z, false);
    }

    public void showAd(final Activity activity, final int i) {
        this.contentAdViewCreator.accept(activity, new Runnable() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdDelegate$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5601xcfe27e1f(activity, i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAd$0$com-smaato-sdk-interstitial-view-InterstitialAdDelegate, reason: not valid java name */
    /* synthetic */ void m5601xcfe27e1f(Activity activity, int i) {
        Object obj = this.csmDelegate;
        if (obj instanceof InterstitialCsmDelegate) {
            InterstitialCsmDelegate interstitialCsmDelegate = (InterstitialCsmDelegate) obj;
            interstitialCsmDelegate.setDelegateListener(createCsmDelegateListener());
            interstitialCsmDelegate.showAd();
        } else {
            Intent intentCreateIntent = InterstitialAdActivity.createIntent(activity, this.delegateUUID, i, this.isSplash);
            if (this.viewDelegateStorage.get(this.delegateUUID) == null) {
                this.viewDelegateStorage.add(this.delegateUUID, this);
                Intents.startIntent(activity, intentCreateIntent);
            }
            this.interstitialAdViewModel.onAdOpened();
        }
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    protected void onPredrawOfAdContentView(AdContentView adContentView) {
        if (this.interstitialAdBaseViewModel.isDisplayingImageAd()) {
            initializeAndStartCountdownAndCloseButtonTimer();
        }
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onRichMediaWebViewLoaded(WebView webView) {
        super.onRichMediaWebViewLoaded(webView);
        if (this.isCountDownRunning) {
            return;
        }
        initializeAndStartCountdownAndCloseButtonTimer();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onWebViewError() {
        super.onWebViewError();
        if (this.isCountDownRunning) {
            return;
        }
        initializeAndStartCountdownAndCloseButtonTimer();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void hideRichMediaAd() {
        onCloseClicked();
    }

    private InterstitialCsmDelegate.CsmInterstitialDelegateListener createCsmDelegateListener() {
        return new InterstitialCsmDelegate.CsmInterstitialDelegateListener() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdDelegate.1
            @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmDelegate.CsmInterstitialDelegateListener
            public void onAdOpened() {
                InterstitialAdDelegate.this.interstitialAdViewModel.onAdOpened();
            }

            @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate.CsmBaseDelegateListener
            public void onAdImpressed() {
                InterstitialAdDelegate.this.interstitialAdViewModel.onAdImpressed();
            }

            @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate.CsmBaseDelegateListener
            public void onAdClosed() {
                InterstitialAdDelegate.this.interstitialAdViewModel.onAdClosed();
            }
        };
    }
}
