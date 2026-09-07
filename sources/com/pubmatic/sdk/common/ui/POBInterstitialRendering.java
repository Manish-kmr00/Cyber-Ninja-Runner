package com.pubmatic.sdk.common.ui;

import com.pubmatic.sdk.common.base.POBAdDescriptor;

/* JADX INFO: loaded from: classes12.dex */
public interface POBInterstitialRendering {
    void destroy();

    void renderAd(POBAdDescriptor pOBAdDescriptor);

    void setAdRendererListener(POBInterstitialRendererListener pOBInterstitialRendererListener);

    void setVideoAdEventListener(POBVideoAdEventListener pOBVideoAdEventListener);

    void show(int i);
}
