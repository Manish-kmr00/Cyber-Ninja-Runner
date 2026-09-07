package com.smaato.sdk.nativead;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public interface NativeAdRenderer {
    String creativeId();

    NativeAdAssets getAssets();

    void onDestroyView();

    void registerForClicks(Iterable<? extends View> iterable);

    void registerForClicks(View... viewArr);

    void registerForImpression(View view);

    void renderInView(NativeAdView nativeAdView);

    String sessionId();
}
