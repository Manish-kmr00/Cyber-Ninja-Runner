package io.bidmachine.iab.vast;

import io.bidmachine.iab.IabError;

/* JADX INFO: loaded from: classes7.dex */
public interface VastRequestListener {
    void onVastLoadFailed(VastRequest vastRequest, IabError iabError);

    void onVastLoaded(VastRequest vastRequest);
}
