package io.bidmachine.iab.vast;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.vast.processor.VastAd;

/* JADX INFO: loaded from: classes11.dex */
public interface VastVideoLoadedListener {
    void onError(VastRequest vastRequest, IabError iabError);

    void onSuccess(VastRequest vastRequest, VastAd vastAd);
}
