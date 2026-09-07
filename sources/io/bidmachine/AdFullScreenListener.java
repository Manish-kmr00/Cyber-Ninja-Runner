package io.bidmachine;

import io.bidmachine.IAd;

/* JADX INFO: loaded from: classes9.dex */
public interface AdFullScreenListener<AdType extends IAd> {
    void onAdClosed(AdType adtype, boolean z);
}
