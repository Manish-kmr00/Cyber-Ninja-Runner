package io.bidmachine.ads.networks.vast;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.vast.VastActivityListener;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.activity.VastActivity;
import io.bidmachine.measurer.MraidOMSDKAdMeasurer;
import io.bidmachine.measurer.VastOMSDKAdMeasurer;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.util.SafeExecutable;
import io.bidmachine.utils.IabUtils;

/* JADX INFO: loaded from: classes7.dex */
class VastFullScreenAdShowListener implements VastActivityListener {
    private final UnifiedFullscreenAdCallback callback;
    private final MraidOMSDKAdMeasurer postBannerAdMeasurer;
    private final VastOMSDKAdMeasurer vastOMSDKAdMeasurer;

    VastFullScreenAdShowListener(UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, VastOMSDKAdMeasurer vastOMSDKAdMeasurer, MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer) {
        this.callback = unifiedFullscreenAdCallback;
        this.vastOMSDKAdMeasurer = vastOMSDKAdMeasurer;
        this.postBannerAdMeasurer = mraidOMSDKAdMeasurer;
    }

    @Override // io.bidmachine.iab.vast.VastActivityListener
    public void onVastShown(VastActivity vastActivity, VastRequest vastRequest) {
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.iab.vast.VastActivityListener
    public void onVastShowFailed(VastRequest vastRequest, IabError iabError) {
        this.callback.onAdShowFailed(IabUtils.mapError(iabError));
    }

    @Override // io.bidmachine.iab.vast.VastActivityListener
    public void onVastClick(VastActivity vastActivity, VastRequest vastRequest, final IabClickCallback iabClickCallback, String str) {
        this.callback.onAdClicked();
        if (str != null) {
            UrlHandler.openUrl(vastActivity, str, new SafeExecutable() { // from class: io.bidmachine.ads.networks.vast.VastFullScreenAdShowListener$$ExternalSyntheticLambda0
                @Override // io.bidmachine.util.SafeExecutable
                public final void onExecute(Object obj) {
                    iabClickCallback.clickHandled();
                }
            });
        } else {
            iabClickCallback.clickHandleCanceled();
        }
    }

    @Override // io.bidmachine.iab.vast.VastActivityListener
    public void onVastComplete(VastActivity vastActivity, VastRequest vastRequest) {
        VastOMSDKAdMeasurer vastOMSDKAdMeasurer = this.vastOMSDKAdMeasurer;
        if (vastOMSDKAdMeasurer != null) {
            vastOMSDKAdMeasurer.destroy();
        }
        this.callback.onAdFinished();
    }

    @Override // io.bidmachine.iab.vast.VastActivityListener
    public void onVastDismiss(VastActivity vastActivity, VastRequest vastRequest, boolean z) {
        MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = this.postBannerAdMeasurer;
        if (mraidOMSDKAdMeasurer != null) {
            mraidOMSDKAdMeasurer.destroy();
        }
        this.callback.onAdClosed();
    }
}
