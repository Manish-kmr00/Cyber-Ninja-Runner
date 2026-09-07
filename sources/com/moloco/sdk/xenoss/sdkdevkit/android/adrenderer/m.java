package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m {
    public static /* synthetic */ k a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, h hVar, com.moloco.sdk.internal.ortb.model.c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, t tVar, int i, Object obj) {
        if ((i & 4) != 0) {
            hVar = null;
        }
        return a(context, aVar, hVar, cVar, mVar, tVar);
    }

    public static final k<f, g> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, h hVar, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, t watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c(context, customUserEventBuilderService, hVar, bid, externalLinkHandler, watermark);
    }
}
