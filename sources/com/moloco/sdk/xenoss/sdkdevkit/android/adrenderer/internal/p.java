package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes13.dex */
public interface p {
    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s> a(Context context, com.moloco.sdk.internal.ortb.model.c cVar, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar);

    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, String str, m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar);

    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> a(Context context, CoroutineScope coroutineScope, com.moloco.sdk.internal.ortb.model.c cVar, m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, MutableStateFlow<Boolean> mutableStateFlow);
}
