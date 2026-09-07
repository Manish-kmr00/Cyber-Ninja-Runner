package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;

/* JADX INFO: loaded from: classes9.dex */
class GAMRewardedAd extends GAMFullscreenAd {
    InternalRewardedAdListener listener;

    protected GAMRewardedAd(GAMNetwork gAMNetwork) {
        super(gAMNetwork);
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, UnifiedFullscreenAdRequestParams unifiedFullscreenAdRequestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        this.listener = new Listener(unifiedFullscreenAdCallback, this);
        this.gamNetwork.loadRewarded(networkAdUnit, this.listener);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMFullscreenAd, io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        this.listener = null;
        super.onDestroy();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMFullscreenAd
    protected InternalFullscreenAdPresentListener getPresentListener() {
        return this.listener;
    }

    static final class Listener extends GAMFullscreenAdListener<InternalRewardedAd> implements InternalRewardedAdListener {
        Listener(UnifiedFullscreenAdCallback unifiedFullscreenAdCallback, GAMFullscreenAd gAMFullscreenAd) {
            super(unifiedFullscreenAdCallback, gAMFullscreenAd);
        }
    }
}
