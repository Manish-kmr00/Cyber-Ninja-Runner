package com.smaato.sdk.interstitial.viewmodel;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdRequest;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.mvvm.viewmodel.AdStatus;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel;
import com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.InterstitialAdBase;
import com.smaato.sdk.interstitial.model.InterstitialAdRequest;
import com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate;

/* JADX INFO: loaded from: classes8.dex */
public abstract class InterstitialAdBaseViewModel extends SmaatoSdkViewModel {
    protected final EventListenerNotificationsInterface eventListenerNotifications;
    protected InterstitialAdBase interstitialAdBase;
    protected InterstitialAdBaseDelegate interstitialAdBaseDelegate;
    protected InterstitialAdRequest lastInterstitialAdRequest;
    protected final Logger logger;
    private boolean shouldUseCustomClose;
    private final VastObjectChecker vastObjectChecker;

    protected abstract void createInterstitialAd();

    public long getUseCustomCloseBackButtonEnableInterval() {
        return 3000L;
    }

    public long getUseCustomCloseButtonShowInterval() {
        return 15000L;
    }

    public InterstitialAdBaseViewModel(SmaatoSdkRepository smaatoSdkRepository, VastObjectChecker vastObjectChecker, Logger logger, EventListenerNotificationsInterface eventListenerNotificationsInterface) {
        super(smaatoSdkRepository, logger);
        this.vastObjectChecker = vastObjectChecker;
        this.logger = logger;
        this.eventListenerNotifications = eventListenerNotificationsInterface;
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onFailedToCreateContentView(Exception exc) {
        super.onFailedToCreateContentView(exc);
        this.eventListenerNotifications.onInternalError();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onVideoClicked() {
        super.onVideoClicked();
        this.eventListenerNotifications.onAdClicked();
    }

    public void setInterstitialAdBaseDelegate(InterstitialAdBaseDelegate interstitialAdBaseDelegate) {
        this.interstitialAdBaseDelegate = interstitialAdBaseDelegate;
    }

    public void loadAd(String str, AdFormat adFormat, String str2, int i, int i2, AdRequestParams adRequestParams, String str3, boolean z, boolean z2) {
        super.onLoadAd();
        if (checkSdkInitialization(str)) {
            AdRequest adRequestCreateAdRequest = createAdRequest(str, adFormat, adRequestParams != null ? adRequestParams.getUBUniqueId() : null);
            InterstitialAdRequest interstitialAdRequest = new InterstitialAdRequest(adRequestCreateAdRequest, str3, str2, i, i2, z, z2);
            this.lastInterstitialAdRequest = interstitialAdRequest;
            this.lastAdRequest = adRequestCreateAdRequest;
            this.smaatoSdkRepository.loadAd(interstitialAdRequest, new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.onAdLoadingSucceeded((AdResponse) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.onAdLoadingFailed((Throwable) obj);
                }
            });
        }
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdImpressed() {
        super.onAdImpressed();
        stopTTLTimer();
        this.eventListenerNotifications.onImpression();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onCompanionAdImpressed() {
        super.onCompanionAdImpressed();
        this.eventListenerNotifications.onCompanionAdImpressed();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onCompanionAdClicked() {
        super.onCompanionAdClicked();
        this.eventListenerNotifications.onCompanionAdClicked();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaWebViewUnloaded() {
        this.interstitialAdBaseDelegate.finishAd();
        this.eventListenerNotifications.onAdUnloaded();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaAdRendererProcessGone() {
        this.eventListenerNotifications.onInternalError();
        this.eventListenerNotifications.onAdClosed();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onExecuteCtaLinkSuccess() {
        super.onExecuteCtaLinkSuccess();
        this.eventListenerNotifications.onAdClicked();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdExpired() {
        if (this.adStatus != AdStatus.DISPLAYED) {
            this.eventListenerNotifications.onAdTtlExpired();
        }
    }

    public void onShowError() {
        if (this.interstitialAdBase != null) {
            this.eventListenerNotifications.onInternalError();
        } else {
            this.logger.error(LogDomain.INTERSTITIAL, "An internal error occured, interstitialAd = null", new Object[0]);
        }
    }

    public void setShouldUseCustomClose(boolean z) {
        this.shouldUseCustomClose = z;
    }

    public boolean isShouldUseCustomClose() {
        return this.shouldUseCustomClose;
    }

    public void onAdClosed() {
        this.eventListenerNotifications.onAdClosed();
    }

    public void onActivityFinishing() {
        this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
        stopTTLTimer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAvailableForPresentation() {
        return this.adStatus == AdStatus.LOADED;
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onVideoPlayerBuildError(SomaException somaException) {
        this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
        this.eventListenerNotifications.onAdLoadingException(somaException);
        this.interstitialAdBaseDelegate.finishAd();
    }

    public boolean isDisplayingVideoAd() {
        AdResponse adResponse = this.lastAdResponse;
        return (adResponse == null || adResponse.getVastObject() == null) ? false : true;
    }

    public boolean isDisplayingImageAd() {
        AdResponse adResponse = this.lastAdResponse;
        return adResponse != null && adResponse.getAdType() == AdType.IMAGE;
    }

    protected void onAdLoadingSucceeded(AdResponse adResponse) {
        super.onAdLoadingSucceeded();
        this.lastAdResponse = adResponse;
        if (adResponse.getAdType() == AdType.VIDEO && !this.vastObjectChecker.check(adResponse.getVastObject())) {
            this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
            this.eventListenerNotifications.onAdLoadingException(new SomaException(SomaException.Type.BAD_RESPONSE, "VAST string contains error. Check log for details"));
        } else {
            if (notifyViewModelListener(adResponse)) {
                if (adResponse.getCsmObject() == null) {
                    startTtlTimer(adResponse.getTtlMs());
                }
                createInterstitialAd();
                this.eventListenerNotifications.setAd(this.interstitialAdBase);
                this.eventListenerNotifications.onAdLoaded();
                return;
            }
            this.eventListenerNotifications.onInternalError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadingFailed(Throwable th) {
        super.onAdLoadingFailed();
        this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
        if (this.smaatoSdkRepository.appIsOnline()) {
            this.eventListenerNotifications.onAdLoadingException(th);
        } else {
            this.eventListenerNotifications.onNetworkError();
        }
    }

    private boolean checkSdkInitialization(String str) {
        if (!SmaatoSdk.isGPSEnabled()) {
            this.logger.warning(LogDomain.INTERSTITIAL, "Usage of the GPS coordinates for advertising purposes is disabled. You can change that by setting setGPSLocation to TRUE.", new Object[0]);
        }
        String publisherId = SmaatoSdk.getPublisherId();
        if (TextUtils.isEmpty(publisherId)) {
            this.logger.error(LogDomain.INTERSTITIAL, "Failed to proceed with Interstitial::loadAd. Missing required parameter: publisherId", new Object[0]);
            this.eventListenerNotifications.onInvalidRequest(publisherId, str);
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.logger.error(LogDomain.INTERSTITIAL, "Failed to proceed with Interstitial::loadAd. Missing required parameter: adSpaceId", new Object[0]);
        this.eventListenerNotifications.onInvalidRequest(publisherId, str);
        return false;
    }
}
