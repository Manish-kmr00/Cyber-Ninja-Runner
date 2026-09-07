package com.pubmatic.sdk.common.ui;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;

/* JADX INFO: loaded from: classes11.dex */
public interface POBInterstitialRendererListener {
    void onAdClicked();

    void onAdExpired();

    void onAdImpression();

    void onAdInteractionStarted();

    void onAdInteractionStopped();

    void onAdRender(POBAdDescriptor pOBAdDescriptor);

    void onAdRenderingFailed(POBError pOBError);

    void onAdUnload();

    void onLeavingApplication();

    void onRenderProcessGone();
}
