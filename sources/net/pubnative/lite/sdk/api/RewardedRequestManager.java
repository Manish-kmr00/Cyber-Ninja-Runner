package net.pubnative.lite.sdk.api;

import net.pubnative.lite.sdk.models.AdSize;

/* JADX INFO: loaded from: classes13.dex */
public class RewardedRequestManager extends RequestManager {
    @Override // net.pubnative.lite.sdk.api.RequestManager
    public boolean isRewarded() {
        return true;
    }

    @Override // net.pubnative.lite.sdk.api.RequestManager
    public AdSize getAdSize() {
        return AdSize.SIZE_INTERSTITIAL;
    }
}
