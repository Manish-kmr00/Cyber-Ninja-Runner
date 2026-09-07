package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b0 {
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adm, m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        return new a0(context, customUserEventBuilderService, adm, externalLinkHandler, watermark);
    }
}
