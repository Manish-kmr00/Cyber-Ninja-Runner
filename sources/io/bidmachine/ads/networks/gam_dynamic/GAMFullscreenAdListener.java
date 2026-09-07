package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;

/* JADX INFO: loaded from: classes13.dex */
class GAMFullscreenAdListener<InternalAdType extends InternalFullscreenAd> extends GAMBaseAdListener<InternalAdType, UnifiedFullscreenAdCallback> implements InternalAdLoadListener<InternalAdType>, InternalFullscreenAdPresentListener {
    private final GAMFullscreenAd gamFullscreenAd;

    GAMFullscreenAdListener(UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, GAMFullscreenAd gAMFullscreenAd) {
        super(unifiedFullscreenAdCallback);
        this.gamFullscreenAd = gAMFullscreenAd;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadListener
    public void onAdLoaded(InternalAdType internaladtype) {
        this.gamFullscreenAd.internalFullscreenAd = internaladtype;
        getCallback().onAdLoaded();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener
    public void onAdComplete() {
        getCallback().onAdFinished();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener
    public void onAdClosed() {
        getCallback().onAdClosed();
    }
}
