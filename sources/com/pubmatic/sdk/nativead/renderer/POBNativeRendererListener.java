package com.pubmatic.sdk.nativead.renderer;

import android.view.View;
import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes2.dex */
public interface POBNativeRendererListener {
    void onAdClicked();

    void onAdClicked(int i);

    void onAdClosed();

    void onAdImpression();

    void onAdLeavingApplication();

    void onAdOpened();

    void onAdRendered(View view);

    void onAdRenderingFailed(POBError pOBError);

    void onDsaInfoIconClicked();
}
