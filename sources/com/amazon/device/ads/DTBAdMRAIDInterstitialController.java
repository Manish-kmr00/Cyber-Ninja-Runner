package com.amazon.device.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes7.dex */
public class DTBAdMRAIDInterstitialController extends DTBAdMRAIDController implements DTBAdViewDisplayListener {
    private String bidId;
    DTBAdInterstitialListener interstitialListener;
    boolean pageDisplayed;
    boolean pageLoaded;

    DTBAdMRAIDInterstitialController(DTBAdView dTBAdView, DTBAdInterstitialListener dTBAdInterstitialListener) {
        super(dTBAdView);
        this.pageLoaded = false;
        this.pageDisplayed = false;
        this.interstitialListener = dTBAdInterstitialListener;
    }

    DTBAdInterstitialListener getInterstitialListener() {
        return this.interstitialListener;
    }

    void setInterstitialListener(DTBAdInterstitialListener dTBAdInterstitialListener) {
        this.interstitialListener = dTBAdInterstitialListener;
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onPageLoad() {
        this.pageLoaded = true;
        try {
            initializeOnLoadAndDisplay();
            if (DTBMetricsConfiguration.getInstance().isFeatureEnabled("additional_webview_metric")) {
                String bidId = getAdView().getBidId();
                this.bidId = bidId;
                ApsMetrics.customEvent("interstitialCreativeFinished", bidId, null);
            }
        } catch (JSONException e) {
            DtbLog.error("Error:" + e.getMessage());
        }
    }

    void initializeOnLoadAndDisplay() throws JSONException {
        if (this.pageLoaded && this.pageDisplayed) {
            prepareMraid();
        } else {
            createLoadReport();
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected String getPlacementType() {
        return "interstitial";
    }

    @Override // com.amazon.device.ads.DTBAdViewDisplayListener
    public void onInitialDisplay() {
        this.pageDisplayed = true;
        try {
            initializeOnLoadAndDisplay();
        } catch (JSONException e) {
            DtbLog.error("JSON exception:" + e.getMessage());
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void onMRAIDClose() {
        executeClose("close");
    }

    private void executeClose(String str) {
        if (getDtbOmSdkSessionManager() != null) {
            getDtbOmSdkSessionManager().stopOmAdSession();
        }
        commandCompleted(str);
        setState(MraidStateType.HIDDEN);
        fireViewableChange(false);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4403xb0f4179();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: cleanOnCloseHandler, reason: merged with bridge method [inline-methods] */
    public void m4403xb0f4179() {
        try {
            if (this.adView != null) {
                this.adView.setWebViewClient(null);
                this.adView.removeAllViews();
                this.adView.cleanup();
                DTBAdInterstitialListener dTBAdInterstitialListener = this.interstitialListener;
                if (dTBAdInterstitialListener != null) {
                    dTBAdInterstitialListener.onAdClosed(this.adView);
                }
            }
            Activity currentActivity = ActivityMonitor.getInstance().getCurrentActivity();
            if (this.useCustomClose && !currentActivity.isFinishing() && (currentActivity instanceof DTBInterstitialActivity)) {
                DTBInterstitialActivity dTBInterstitialActivity = (DTBInterstitialActivity) currentActivity;
                dTBInterstitialActivity.cleanup();
                dTBInterstitialActivity.finish();
            }
        } catch (RuntimeException e) {
            DtbLog.error(LOG_TAG, "Failed to execute cleanOnCloseHandler method");
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Failed to execute cleanOnCloseHandler method", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void onMRAIDUnload() {
        executeClose(MraidJsMethods.UNLOAD);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void onResize(Map<String, Object> map) {
        fireErrorEvent("resize", "invalid placement type");
        commandCompleted("resize");
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    protected void expand(Map<String, Object> map) {
        fireErrorEvent("expand", "invalid placement type for interstitial ");
        commandCompleted("expand");
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdOpened() {
        DTBAdInterstitialListener dTBAdInterstitialListener = this.interstitialListener;
        if (dTBAdInterstitialListener != null) {
            dTBAdInterstitialListener.onAdOpen(this.adView);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdClicked() {
        if (this.interstitialListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4405xf2589090();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdClicked$1$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4405xf2589090() {
        this.interstitialListener.onAdClicked(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdLoaded() {
        if (this.interstitialListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Failed to get interstitialListener on OnAdLoaded");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4409xb60742f3();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdLoaded$2$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4409xb60742f3() {
        this.interstitialListener.onAdLoaded(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdFailedToLoad() {
        if (this.interstitialListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Failed to get interstitialListener on onAdFailedToLoad");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4407x2e63fa99();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdFailedToLoad$3$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4407x2e63fa99() {
        this.interstitialListener.onAdFailed(this.adView);
    }

    public void onAdError() {
        if (this.interstitialListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Failed to get interstitialListener on onAdError");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4406x6f47fe2c();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdError$4$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4406x6f47fe2c() {
        this.interstitialListener.onAdError(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    void passLoadError() {
        onAdError();
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onAdLeftApplication() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4408xcd830caa();
            }
        });
        ActivityMonitor.getInstance().setActivityListener(this);
    }

    /* JADX INFO: renamed from: lambda$onAdLeftApplication$5$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4408xcd830caa() {
        this.interstitialListener.onAdLeftApplication(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController, com.amazon.device.ads.DTBActivityListener
    public void onActivityResumed(Activity activity) {
        ActivityMonitor.getInstance().setActivityListener(null);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController, com.amazon.device.ads.DTBActivityListener
    public void onActivityDestroyed(Activity activity) {
        if (getDtbOmSdkSessionManager() != null) {
            getDtbOmSdkSessionManager().stopOmAdSession();
        }
        ActivityMonitor.getInstance().setActivityListener(null);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void impressionFired() {
        if (this.interstitialListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Failed to get interstitialListener on onAdError");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4404x7950776b();
                }
            });
            super.impressionFired();
        }
    }

    /* JADX INFO: renamed from: lambda$impressionFired$6$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4404x7950776b() {
        this.interstitialListener.onImpressionFired(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void onVideoCompleted() {
        if (this.interstitialListener == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Failed to get interstitialListener on onAdError");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDInterstitialController$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4410xc8a98d46();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onVideoCompleted$7$com-amazon-device-ads-DTBAdMRAIDInterstitialController, reason: not valid java name */
    /* synthetic */ void m4410xc8a98d46() {
        this.interstitialListener.onVideoCompleted(this.adView);
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void startOMSDKSession() {
        if (getDtbOmSdkSessionManager() == null || getAdView() == null) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.LOG, "OMSDK : Aps OMSDK Session Manager or AdView is null on start");
            return;
        }
        try {
            if (getDtbOmSdkSessionManager().getCurrentAdSession() != null) {
                getDtbOmSdkSessionManager().stopOmAdSession();
            }
            if (!getAdView().getIsVideo()) {
                getDtbOmSdkSessionManager().initHtmlDisplayOmAdSession(getAdView(), "https://c.amazon-adsystem.com/");
            } else {
                getDtbOmSdkSessionManager().initJavaScriptOmAdSession(getAdView(), "https://c.amazon-adsystem.com/");
            }
            getDtbOmSdkSessionManager().registerAdView(getAdView());
            getDtbOmSdkSessionManager().startAdSession();
            getDtbOmSdkSessionManager().displayAdEventLoaded();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "OMSDK :Unable to start OM SDK session", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void stopOMSDKSession() {
        if (getDtbOmSdkSessionManager() == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMSDK : Aps OmSdk Session Manager is null on Stop Session");
        } else {
            getDtbOmSdkSessionManager().stopOmAdSession();
        }
    }

    @Override // com.amazon.device.ads.DTBAdMRAIDController
    public void startEndCardDisplayOMSDKSession() {
        if (getDtbOmSdkSessionManager() == null || getAdView() == null) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.LOG, "OMSDK : Aps OMSDK Session Manager or AdView is null on start");
            return;
        }
        try {
            if (getDtbOmSdkSessionManager().getCurrentAdSession() != null) {
                getDtbOmSdkSessionManager().stopOmAdSession();
            }
            getDtbOmSdkSessionManager().initHtmlDisplayOmAdSession(getAdView(), "https://c.amazon-adsystem.com/");
            getDtbOmSdkSessionManager().registerAdView(getAdView());
            getDtbOmSdkSessionManager().startAdSession();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "OMSDK : End Card display : Unable to restart OM SDK session", e);
        }
    }
}
