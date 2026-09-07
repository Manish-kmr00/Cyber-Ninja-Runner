package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i0 {
    public static /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k a(Context context, com.moloco.sdk.internal.ortb.model.c cVar, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar, j jVar, int i, Object obj) {
        if ((i & 16) != 0) {
            dVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(context);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2 = dVar;
        if ((i & 32) != 0) {
            jVar = com.moloco.sdk.service_locator.a.C0569a.f6452a.a();
        }
        return a(context, cVar, z, tVar, dVar2, jVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s> a(Context context, com.moloco.sdk.internal.ortb.model.c bid, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, j decLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        return new h0(context, bid, loadVast, decLoader, z, watermark);
    }
}
