package com.pubmatic.sdk.common.ui;

import android.view.View;
import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes14.dex */
public interface POBRendererViewListener {
    void onAdInteractionStarted();

    void onAdInteractionStopped();

    void onAdUnload();

    void onLeavingApplication();

    void onViewClicked(String str);

    void onViewRendered(View view);

    void onViewRenderingFailed(POBError pOBError);
}
