package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6567a = new h();

    public final boolean a(String adm) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        return StringsKt.contains((CharSequence) adm, (CharSequence) "mraid.js", true);
    }

    public final boolean b(String adm) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        return StringsKt.contains((CharSequence) adm, (CharSequence) "<VAST", true);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h c(String adm) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        if (b(adm)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST;
        }
        return a(adm) ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.MRAID : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.STATIC;
    }
}
