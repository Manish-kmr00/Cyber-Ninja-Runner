package io.bidmachine.ads.networks.gam;

import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes6.dex */
public interface InternalGAMAdPresentListener {
    void onAdClicked();

    void onAdExpired();

    void onAdShowFailed(BMError bMError);

    void onAdShown();
}
