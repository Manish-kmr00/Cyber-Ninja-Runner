package com.pubmatic.sdk.common.ui;

import com.pubmatic.sdk.common.base.POBAdDescriptor;

/* JADX INFO: loaded from: classes10.dex */
public interface POBRewardedAdRendering {
    void destroy();

    void renderAd(POBAdDescriptor pOBAdDescriptor);

    void setAdRendererListener(POBRewardedAdRendererListener pOBRewardedAdRendererListener);

    void show();
}
