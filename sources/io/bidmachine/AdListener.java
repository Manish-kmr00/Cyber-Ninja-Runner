package io.bidmachine;

import io.bidmachine.IAd;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes13.dex */
public interface AdListener<AdType extends IAd> {
    void onAdClicked(AdType adtype);

    void onAdExpired(AdType adtype);

    void onAdImpression(AdType adtype);

    void onAdLoadFailed(AdType adtype, BMError bMError);

    void onAdLoaded(AdType adtype);

    void onAdShowFailed(AdType adtype, BMError bMError);
}
