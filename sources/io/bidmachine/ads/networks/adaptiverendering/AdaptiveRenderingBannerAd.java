package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.rendering.ad.view.AdView;
import io.bidmachine.rendering.model.CacheType;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;

/* JADX INFO: loaded from: classes13.dex */
class AdaptiveRenderingBannerAd extends UnifiedBannerAd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private AdView adView;

    AdaptiveRenderingBannerAd() {
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedBannerAdCallback unifiedBannerAdCallback, UnifiedBannerAdRequestParams unifiedBannerAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        VisibilitySource visibilitySource;
        Context applicationContext = contextProvider.getApplicationContext();
        AdaptiveRenderingParams adaptiveRenderingParams = new AdaptiveRenderingParams(unifiedMediationParams);
        if (adaptiveRenderingParams.isValid(unifiedBannerAdCallback)) {
            if (adaptiveRenderingParams.adParams.getCacheType() == CacheType.FullLoad) {
                visibilitySource = VisibilitySource.BidMachine;
            } else {
                visibilitySource = VisibilitySource.All;
            }
            unifiedBannerAdCallback.setVisibilitySource(visibilitySource);
            AdView adView = new AdView(applicationContext, adaptiveRenderingParams.adParams);
            this.adView = adView;
            adView.setAdViewListener(new AdaptiveRenderingBannerAdListener(unifiedBannerAdCallback));
            this.adView.load();
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        AdView adView = this.adView;
        if (adView != null) {
            adView.destroy();
            this.adView = null;
        }
    }
}
