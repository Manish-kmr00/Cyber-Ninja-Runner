package io.bidmachine.ads.networks.mraid;

import android.content.Context;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.mraid.MraidInterstitial;
import io.bidmachine.iab.mraid.MraidType;
import io.bidmachine.measurer.MraidOMSDKAdMeasurer;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes2.dex */
class MraidFullScreenAd extends UnifiedFullscreenAd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MraidInterstitial mraidInterstitial;
    private MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer;
    private final MraidType mraidType;

    MraidFullScreenAd(MraidType mraidType) {
        this.mraidType = mraidType;
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, final UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, UnifiedFullscreenAdRequestParams unifiedFullscreenAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        String strPrepareCreativeForMeasure;
        final MraidParams mraidParams = new MraidParams(unifiedMediationParams);
        if (mraidParams.isValid(unifiedFullscreenAdCallback)) {
            final Context applicationContext = contextProvider.getApplicationContext();
            if (mraidParams.omsdkEnabled) {
                MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = new MraidOMSDKAdMeasurer();
                this.mraidOMSDKAdMeasurer = mraidOMSDKAdMeasurer;
                strPrepareCreativeForMeasure = mraidOMSDKAdMeasurer.prepareCreativeForMeasure(mraidParams.creativeAdm);
            } else {
                strPrepareCreativeForMeasure = mraidParams.creativeAdm;
            }
            final String str = strPrepareCreativeForMeasure;
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.mraid.MraidFullScreenAd.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MraidFullScreenAd.this.mraidInterstitial = MraidInterstitial.newBuilder().setCacheControl(mraidParams.cacheControl).setPlaceholderTimeoutSec(mraidParams.placeholderTimeoutSec).setCloseTime(mraidParams.skipOffset).forceUseNativeCloseButton(mraidParams.useNativeClose).setListener(new MraidFullScreenAdListener(applicationContext, unifiedFullscreenAdCallback, MraidFullScreenAd.this.mraidOMSDKAdMeasurer)).setR1(mraidParams.r1).setR2(mraidParams.r2).setDurationSec(mraidParams.progressDuration).setProductLink(mraidParams.storeUrl).setCloseStyle(mraidParams.closeableViewStyle).setCountDownStyle(mraidParams.countDownStyle).setProgressStyle(mraidParams.progressStyle).setAdMeasurer(MraidFullScreenAd.this.mraidOMSDKAdMeasurer).build(applicationContext);
                        MraidFullScreenAd.this.mraidInterstitial.load(str);
                    } catch (Throwable th) {
                        Logger.w(th);
                        unifiedFullscreenAdCallback.onAdLoadFailed(BMError.throwable("Exception loading MRAID fullscreen object", th));
                    }
                }
            });
        }
    }

    @Override // io.bidmachine.unified.UnifiedFullscreenAd
    public void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback) throws Throwable {
        MraidInterstitial mraidInterstitial = this.mraidInterstitial;
        if (mraidInterstitial == null) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("MRAID fullscreen object is null"));
            return;
        }
        if (!mraidInterstitial.isReady()) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("MRAID fullscreen object is not ready"));
        } else if (this.mraidInterstitial.isShown()) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("MRAID fullscreen object is already was shown"));
        } else {
            this.mraidInterstitial.show(contextProvider.getContext(), this.mraidType);
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = this.mraidOMSDKAdMeasurer;
        if (mraidOMSDKAdMeasurer != null) {
            mraidOMSDKAdMeasurer.destroy(new Runnable() { // from class: io.bidmachine.ads.networks.mraid.MraidFullScreenAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MraidFullScreenAd.this.destroyMraidInterstitial();
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
            this.mraidOMSDKAdMeasurer = null;
        } else {
            destroyMraidInterstitial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyMraidInterstitial() {
        MraidInterstitial mraidInterstitial = this.mraidInterstitial;
        if (mraidInterstitial != null) {
            mraidInterstitial.destroy();
            this.mraidInterstitial = null;
        }
    }
}
