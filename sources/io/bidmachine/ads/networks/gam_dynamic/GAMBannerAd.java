package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
class GAMBannerAd extends UnifiedBannerAd {
    private final GAMNetwork gamNetwork;
    InternalBannerAd internalBannerAd;
    InternalBannerAdListener listener;

    protected GAMBannerAd(GAMNetwork gAMNetwork) {
        this.gamNetwork = gAMNetwork;
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedBannerAdCallback unifiedBannerAdCallback, UnifiedBannerAdRequestParams unifiedBannerAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        Listener listener = new Listener(unifiedBannerAdCallback, this);
        this.listener = listener;
        this.gamNetwork.loadBanner(networkAdUnit, listener);
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onShown() {
        super.onShown();
        InternalBannerAd internalBannerAd = this.internalBannerAd;
        if (internalBannerAd != null) {
            internalBannerAd.onAdShown();
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        this.listener = null;
        InternalBannerAd internalBannerAd = this.internalBannerAd;
        if (internalBannerAd != null) {
            internalBannerAd.destroy();
            this.internalBannerAd = null;
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public Map<String, Object> getCustomParams() {
        InternalBannerAd internalBannerAd = this.internalBannerAd;
        if (internalBannerAd != null) {
            return internalBannerAd.getCustomParamsMap();
        }
        return null;
    }

    static final class Listener extends GAMBaseAdListener<InternalBannerAd, UnifiedBannerAdCallback> implements InternalBannerAdListener {
        private final GAMBannerAd gamBannerAd;

        Listener(UnifiedBannerAdCallback unifiedBannerAdCallback, GAMBannerAd gAMBannerAd) {
            super(unifiedBannerAdCallback);
            this.gamBannerAd = gAMBannerAd;
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadListener
        public void onAdLoaded(InternalBannerAd internalBannerAd) {
            this.gamBannerAd.internalBannerAd = internalBannerAd;
            if (internalBannerAd.getAdUnit().getOverrideCallbacks()) {
                getCallback().setVisibilitySource(VisibilitySource.BidMachine);
            }
            getCallback().onAdLoaded(internalBannerAd.getAdView());
        }
    }
}
