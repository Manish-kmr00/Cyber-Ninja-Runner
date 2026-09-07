package io.bidmachine.ads.networks.vast;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastRequestListener;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.utils.IabUtils;

/* JADX INFO: loaded from: classes13.dex */
class VastFullScreenAdLoadListener implements VastRequestListener {
    private final UnifiedFullscreenAdCallback callback;

    VastFullScreenAdLoadListener(UnifiedFullscreenAdCallback unifiedFullscreenAdCallback) {
        this.callback = unifiedFullscreenAdCallback;
    }

    @Override // io.bidmachine.iab.vast.VastRequestListener
    public void onVastLoaded(VastRequest vastRequest) {
        this.callback.onAdLoaded();
    }

    @Override // io.bidmachine.iab.vast.VastRequestListener
    public void onVastLoadFailed(VastRequest vastRequest, IabError iabError) {
        if (iabError.getCode() == 6) {
            this.callback.onAdExpired();
        } else {
            this.callback.onAdLoadFailed(IabUtils.mapError(iabError));
        }
    }
}
