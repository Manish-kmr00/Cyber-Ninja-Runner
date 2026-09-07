package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ads.networks.gam_dynamic.InternalAd;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes10.dex */
interface InternalAdLoadListener<InternalAdType extends InternalAd> {
    void onAdLoadFailed(BMError bMError);

    void onAdLoaded(InternalAdType internaladtype);
}
