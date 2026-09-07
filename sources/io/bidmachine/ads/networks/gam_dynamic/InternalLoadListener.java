package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
public interface InternalLoadListener {
    void onAdLoadFailed(InternalAd internalAd, BMError bMError);

    void onAdLoaded(InternalAd internalAd, InternalAdLoadData internalAdLoadData);
}
