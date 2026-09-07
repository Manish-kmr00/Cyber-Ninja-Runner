package com.pubmatic.sdk.webrendering.mraid;

import android.view.View;
import com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener;

/* JADX INFO: loaded from: classes3.dex */
interface n extends POBObstructionUpdateListener {
    boolean isUserInteracted(boolean z);

    void onAdInteractionStarted();

    void onAdInteractionStopped();

    void onAdUnload();

    void onAdViewChanged(View view);

    void onLeavingApplication();

    void onMRAIDAdClick();

    void onOpen(String str);

    void shouldUseCustomClose(boolean z);
}
