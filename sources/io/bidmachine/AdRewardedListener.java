package io.bidmachine;

import io.bidmachine.IAd;

/* JADX INFO: loaded from: classes8.dex */
public interface AdRewardedListener<AdType extends IAd> {
    void onAdRewarded(AdType adtype);
}
