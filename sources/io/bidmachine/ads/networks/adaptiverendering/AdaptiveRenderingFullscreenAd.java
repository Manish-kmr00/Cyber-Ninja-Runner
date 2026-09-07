package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.rendering.ad.fullscreen.FullScreenAd;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes10.dex */
class AdaptiveRenderingFullscreenAd extends UnifiedFullscreenAd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private FullScreenAd fullScreenAd;

    AdaptiveRenderingFullscreenAd() {
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, UnifiedFullscreenAdRequestParams unifiedFullscreenAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        Context applicationContext = contextProvider.getApplicationContext();
        AdaptiveRenderingParams adaptiveRenderingParams = new AdaptiveRenderingParams(unifiedMediationParams);
        if (adaptiveRenderingParams.isValid(unifiedFullscreenAdCallback)) {
            FullScreenAd fullScreenAd = new FullScreenAd(applicationContext, adaptiveRenderingParams.adParams);
            this.fullScreenAd = fullScreenAd;
            fullScreenAd.setFullScreenAdListener(new AdaptiveRenderingFullscreenAdListener(applicationContext, unifiedFullscreenAdCallback));
            this.fullScreenAd.load();
        }
    }

    @Override // io.bidmachine.unified.UnifiedFullscreenAd
    public void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback) throws Throwable {
        FullScreenAd fullScreenAd = this.fullScreenAd;
        if (fullScreenAd == null) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("AdaptiveRendering fullscreen object is null"));
            return;
        }
        if (!fullScreenAd.isLoaded()) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("AdaptiveRendering fullscreen object not loaded"));
        } else if (this.fullScreenAd.isFinished()) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("AdaptiveRendering fullscreen object already is finished"));
        } else {
            this.fullScreenAd.show(contextProvider.getApplicationContext());
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        FullScreenAd fullScreenAd = this.fullScreenAd;
        if (fullScreenAd != null) {
            fullScreenAd.destroy();
            this.fullScreenAd = null;
        }
    }
}
