package com.ogury.ad.internal;

import com.ogury.ad.OguryAdError;
import com.ogury.ad.internal.t5;

/* JADX INFO: loaded from: classes13.dex */
public interface v5<T extends t5> {
    void onAdClicked(T t);

    void onAdClosed(T t);

    void onAdError(T t, OguryAdError oguryAdError);

    void onAdImpression(T t);

    void onAdLoaded(T t);
}
