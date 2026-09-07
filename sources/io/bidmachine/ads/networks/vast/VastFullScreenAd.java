package io.bidmachine.ads.networks.vast;

import android.content.Context;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VideoType;
import io.bidmachine.iab.vast.activity.VastView;
import io.bidmachine.measurer.MraidOMSDKAdMeasurer;
import io.bidmachine.measurer.VastOMSDKAdMeasurer;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes5.dex */
class VastFullScreenAd extends UnifiedFullscreenAd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MraidOMSDKAdMeasurer postBannerAdMeasurer;
    private VastFullScreenAdLoadListener vastAdLoadListener;
    private VastFullScreenAdShowListener vastAdShowListener;
    private VastOMSDKAdMeasurer vastOMSDKAdMeasurer;
    private VastRequest vastRequest;
    private VastView vastView;
    private final VideoType videoType;

    VastFullScreenAd(VideoType videoType) {
        this.videoType = videoType;
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, UnifiedFullscreenAdRequestParams unifiedFullscreenAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        VastParams vastParams = new VastParams(unifiedMediationParams);
        if (vastParams.isValid(unifiedFullscreenAdCallback)) {
            if (vastParams.omsdkEnabled) {
                this.vastOMSDKAdMeasurer = new VastOMSDKAdMeasurer();
                this.postBannerAdMeasurer = new MraidOMSDKAdMeasurer();
            }
            Context applicationContext = contextProvider.getApplicationContext();
            this.vastAdLoadListener = new VastFullScreenAdLoadListener(unifiedFullscreenAdCallback);
            this.vastView = new VastView(applicationContext);
            VastRequest vastRequestBuild = VastRequest.newBuilder().setCacheControl(vastParams.cacheControl).setPlaceholderTimeoutSec(vastParams.placeholderTimeoutSec).setVideoCloseTime(vastParams.skipOffset).setCompanionCloseTime(vastParams.companionSkipOffset).forceUseNativeCloseTime(vastParams.useNativeClose).setAdMeasurer(this.vastOMSDKAdMeasurer).build();
            this.vastRequest = vastRequestBuild;
            vastRequestBuild.loadVideoWithData(applicationContext, vastParams.creativeAdm, this.vastAdLoadListener);
        }
    }

    @Override // io.bidmachine.unified.UnifiedFullscreenAd
    public void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback) throws Throwable {
        VastRequest vastRequest = this.vastRequest;
        if (vastRequest != null && vastRequest.canDisplay()) {
            this.vastAdShowListener = new VastFullScreenAdShowListener(unifiedFullscreenAdCallback, this.vastOMSDKAdMeasurer, this.postBannerAdMeasurer);
            this.vastRequest.display(contextProvider.getContext(), this.videoType, this.vastAdShowListener, this.vastView, this.vastOMSDKAdMeasurer, this.postBannerAdMeasurer);
        } else {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("VAST fullscreen object is null or can not find video file"));
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        this.vastAdLoadListener = null;
        this.vastAdShowListener = null;
        VastOMSDKAdMeasurer vastOMSDKAdMeasurer = this.vastOMSDKAdMeasurer;
        if (vastOMSDKAdMeasurer != null) {
            vastOMSDKAdMeasurer.destroy();
            this.vastOMSDKAdMeasurer = null;
        }
        MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = this.postBannerAdMeasurer;
        if (mraidOMSDKAdMeasurer != null) {
            mraidOMSDKAdMeasurer.destroy(new Runnable() { // from class: io.bidmachine.ads.networks.vast.VastFullScreenAd.1
                @Override // java.lang.Runnable
                public void run() {
                    VastFullScreenAd.this.destroyVastView();
                }
            });
            this.postBannerAdMeasurer = null;
        } else {
            destroyVastView();
        }
        if (this.vastRequest != null) {
            this.vastRequest = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyVastView() {
        VastView vastView = this.vastView;
        if (vastView != null) {
            vastView.destroy();
            this.vastView = null;
        }
    }
}
