package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.webkit.WebView;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes7.dex */
public interface f extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j {
    StateFlow<Boolean> H();

    Object a(String str, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation);

    void a(n nVar, String str);

    void a(q qVar);

    void a(r rVar);

    void a(s sVar);

    void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    WebView c();

    void d(boolean z);

    void i();

    SharedFlow<n> w();

    StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> x();
}
