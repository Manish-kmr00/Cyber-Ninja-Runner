package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import io.bidmachine.Executable;
import io.bidmachine.core.Utils;
import io.bidmachine.rendering.ad.fullscreen.FullScreenAd;
import io.bidmachine.rendering.ad.fullscreen.FullScreenAdListener;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes13.dex */
class AdaptiveRenderingFullscreenAdListener implements FullScreenAdListener {
    private final Context applicationContext;
    private final UnifiedFullscreenAdCallback callback;
    private volatile boolean isShown = false;

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdAppeared(FullScreenAd fullScreenAd) {
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdDisappeared(FullScreenAd fullScreenAd) {
    }

    AdaptiveRenderingFullscreenAdListener(Context context, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback) {
        this.applicationContext = context.getApplicationContext();
        this.callback = unifiedFullscreenAdCallback;
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdLoaded(FullScreenAd fullScreenAd) {
        this.callback.onAdLoaded();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToLoad(FullScreenAd fullScreenAd, Error error) {
        this.callback.onAdLoadFailed(AdaptiveRenderingAdapter.mapError(BMError.NoFill, error));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdShown(FullScreenAd fullScreenAd) {
        this.isShown = true;
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToShow(FullScreenAd fullScreenAd, Error error) {
        this.callback.onAdShowFailed(AdaptiveRenderingAdapter.mapError(BMError.InternalUnknownError, error));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdClicked(FullScreenAd fullScreenAd) {
        this.callback.onAdClicked();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFinished(FullScreenAd fullScreenAd) {
        if (this.isShown) {
            this.callback.onAdFinished();
        }
        this.callback.onAdClosed();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdExpired(FullScreenAd fullScreenAd) {
        this.callback.onAdExpired();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onOpenPrivacySheet(FullScreenAd fullScreenAd, final PrivacySheetParams privacySheetParams) {
        Utils.ifNotNull(Utils.findDialogContext(this.applicationContext), new Executable() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingFullscreenAdListener$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                PrivacySheetDialog.show((Context) obj, privacySheetParams);
            }
        });
    }
}
