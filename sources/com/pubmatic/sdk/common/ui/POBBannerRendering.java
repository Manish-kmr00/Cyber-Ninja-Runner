package com.pubmatic.sdk.common.ui;

import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBAdRendererListener;

/* JADX INFO: loaded from: classes11.dex */
public interface POBBannerRendering {
    void destroy();

    void invalidateExpiration();

    void renderAd(POBAdDescriptor pOBAdDescriptor);

    void setAdRendererListener(POBAdRendererListener pOBAdRendererListener);
}
