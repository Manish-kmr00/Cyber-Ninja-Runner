package com.pubmatic.sdk.openwrap.interstitial;

import com.pubmatic.sdk.common.ui.POBInterstitialRendering;
import com.pubmatic.sdk.openwrap.core.POBBaseEvent;
import com.pubmatic.sdk.openwrap.core.POBFullScreenAdInteractionListener;

/* JADX INFO: loaded from: classes12.dex */
public abstract class POBInterstitialEvent extends POBBaseEvent {
    public POBFullScreenAdInteractionListener getAdInteractionListener() {
        return null;
    }

    public POBInterstitialRendering getRenderer(String str) {
        return null;
    }

    public abstract void setEventListener(POBInterstitialEventListener pOBInterstitialEventListener);

    public void show() {
    }
}
