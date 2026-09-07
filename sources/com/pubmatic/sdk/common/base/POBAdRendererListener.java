package com.pubmatic.sdk.common.base;

import android.view.View;
import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes12.dex */
public interface POBAdRendererListener {
    void onAdExpired();

    void onAdImpression();

    void onAdInteractionStarted();

    void onAdInteractionStopped();

    void onAdReadyToRefresh(int i);

    void onAdRender(View view, POBAdDescriptor pOBAdDescriptor);

    void onAdRenderingFailed(POBError pOBError);

    void onAdUnload();

    void onLeavingApplication();

    void onRenderAdClick();

    void onRenderProcessGone();
}
