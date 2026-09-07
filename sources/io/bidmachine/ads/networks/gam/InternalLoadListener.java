package io.bidmachine.ads.networks.gam;

import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes7.dex */
public interface InternalLoadListener {
    void onAdLoadFailed(InternalGAMAd internalGAMAd, BMError bMError);

    void onAdLoaded(InternalGAMAd internalGAMAd);
}
