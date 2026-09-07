package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f8483a;

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA = this.f8483a.a(context);
        return cu1VarA != null && cu1VarA.M();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b92() {
        this(iw1.a.a());
        int i = iw1.l;
    }

    public b92(iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f8483a = sdkSettings;
    }
}
