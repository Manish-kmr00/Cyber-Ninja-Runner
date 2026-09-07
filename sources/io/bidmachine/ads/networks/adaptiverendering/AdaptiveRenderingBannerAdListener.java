package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import io.bidmachine.Executable;
import io.bidmachine.core.Utils;
import io.bidmachine.rendering.ad.view.AdView;
import io.bidmachine.rendering.ad.view.AdViewListener;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes9.dex */
class AdaptiveRenderingBannerAdListener implements AdViewListener {
    private final UnifiedBannerAdCallback callback;

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdAppeared(AdView adView) {
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdDisappeared(AdView adView) {
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFinished(AdView adView) {
    }

    AdaptiveRenderingBannerAdListener(UnifiedBannerAdCallback unifiedBannerAdCallback) {
        this.callback = unifiedBannerAdCallback;
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdLoaded(AdView adView) {
        this.callback.onAdLoaded(adView);
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToLoad(AdView adView, Error error) {
        this.callback.onAdLoadFailed(AdaptiveRenderingAdapter.mapError(BMError.NoFill, error));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdShown(AdView adView) {
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToShow(AdView adView, Error error) {
        this.callback.onAdShowFailed(AdaptiveRenderingAdapter.mapError(BMError.InternalUnknownError, error));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdClicked(AdView adView) {
        this.callback.onAdClicked();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdExpired(AdView adView) {
        this.callback.onAdExpired();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onOpenPrivacySheet(AdView adView, final PrivacySheetParams privacySheetParams) {
        Utils.ifNotNull(Utils.findDialogContext(adView.getContext(), adView), new Executable() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingBannerAdListener$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                PrivacySheetDialog.show((Context) obj, privacySheetParams);
            }
        });
    }
}
