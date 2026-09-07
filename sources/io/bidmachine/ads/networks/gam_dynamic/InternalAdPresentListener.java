package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes13.dex */
public interface InternalAdPresentListener {
    void onAdClicked();

    void onAdExpired();

    void onAdShowFailed(BMError bMError);

    void onAdShown();
}
