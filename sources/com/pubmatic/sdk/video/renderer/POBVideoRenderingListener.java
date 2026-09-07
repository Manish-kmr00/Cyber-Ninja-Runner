package com.pubmatic.sdk.video.renderer;

import com.pubmatic.sdk.common.POBDataType;

/* JADX INFO: loaded from: classes13.dex */
public interface POBVideoRenderingListener {
    void notifyAdEvent(POBDataType.POBVideoAdEventType pOBVideoAdEventType);

    void onSkipOptionUpdate(boolean z);
}
