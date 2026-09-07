package com.fyber.marketplace.fairbid.bridge;

import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;

/* JADX INFO: loaded from: classes4.dex */
public interface MarketplaceAdLoadListener<T extends MarketplaceBridgeAd> {
    void onAdLoadFailed(MarketplaceAdLoadError marketplaceAdLoadError);

    void onAdLoaded(T t);
}
