package com.pubmatic.sdk.openwrap.banner;

import android.view.View;
import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.ui.POBBannerRendering;
import com.pubmatic.sdk.openwrap.core.POBBaseAdInteractionListener;
import com.pubmatic.sdk.openwrap.core.POBBaseEvent;

/* JADX INFO: loaded from: classes11.dex */
public abstract class POBBannerEvent extends POBBaseEvent {
    public POBBaseAdInteractionListener getAdInteractionListener() {
        return null;
    }

    public View getAdServerView() {
        return null;
    }

    public POBAdSize getAdSize() {
        return null;
    }

    public POBBannerRendering getRenderer(String str) {
        return null;
    }

    public POBAdSize[] requestedAdSizes() {
        return null;
    }

    public abstract void setEventListener(POBBannerEventListener pOBBannerEventListener);
}
