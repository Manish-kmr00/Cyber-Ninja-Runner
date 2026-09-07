package io.bidmachine.ads.networks.gam_dynamic;

import android.app.Activity;
import io.bidmachine.ContextProvider;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.utils.BMError;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
abstract class GAMFullscreenAd extends UnifiedFullscreenAd {
    protected final GAMNetwork gamNetwork;
    protected InternalFullscreenAd internalFullscreenAd;

    protected abstract InternalFullscreenAdPresentListener getPresentListener();

    protected GAMFullscreenAd(GAMNetwork gAMNetwork) {
        this.gamNetwork = gAMNetwork;
    }

    @Override // io.bidmachine.unified.UnifiedFullscreenAd
    public void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback) throws Throwable {
        Activity activity = contextProvider.getActivity();
        if (activity == null) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("Activity is null"));
            return;
        }
        InternalFullscreenAd internalFullscreenAd = this.internalFullscreenAd;
        if (internalFullscreenAd == null) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("Fullscreen object is null"));
            return;
        }
        if (internalFullscreenAd.isExpired()) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("Fullscreen object is expired"));
            return;
        }
        if (!this.internalFullscreenAd.isLoaded()) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("Fullscreen object not loaded"));
            return;
        }
        InternalFullscreenAdPresentListener presentListener = getPresentListener();
        if (presentListener == null) {
            unifiedFullscreenAdCallback.onAdShowFailed(BMError.internal("Fullscreen listener is null"));
        } else {
            this.internalFullscreenAd.show(activity, presentListener);
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onShown() {
        super.onShown();
        InternalFullscreenAd internalFullscreenAd = this.internalFullscreenAd;
        if (internalFullscreenAd != null) {
            internalFullscreenAd.onAdShown();
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        InternalFullscreenAd internalFullscreenAd = this.internalFullscreenAd;
        if (internalFullscreenAd != null) {
            internalFullscreenAd.destroy();
            this.internalFullscreenAd = null;
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public Map<String, Object> getCustomParams() {
        InternalFullscreenAd internalFullscreenAd = this.internalFullscreenAd;
        if (internalFullscreenAd != null) {
            return internalFullscreenAd.getCustomParamsMap();
        }
        return null;
    }
}
