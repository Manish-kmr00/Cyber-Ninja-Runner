package com.pubmatic.sdk.video.renderer;

import com.pubmatic.sdk.common.ui.POBBannerRendering;

/* JADX INFO: loaded from: classes9.dex */
public interface POBVideoRendering extends POBBannerRendering {
    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    void destroy();

    void proceedAdSkip(boolean z);

    void setVideoRenderingListener(POBVideoRenderingListener pOBVideoRenderingListener);

    void setVideoSkipEventListener(POBVideoSkipEventListener pOBVideoSkipEventListener);
}
