package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6665a;

    public n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6665a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m
    public boolean a(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return o.b(this.f6665a, uri);
    }
}
