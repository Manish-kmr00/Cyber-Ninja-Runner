package com.amazon.aps.ads.listeners;

import com.amazon.aps.ads.ApsAd;
import com.amazon.aps.ads.ApsAdError;

/* JADX INFO: loaded from: classes4.dex */
public interface ApsAdRequestListener {
    void onFailure(ApsAdError apsAdError);

    void onSuccess(ApsAd apsAd);
}
