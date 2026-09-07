package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f10799a;

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA = this.f10799a.a(context);
        return cu1VarA != null && cu1VarA.L();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z82() {
        this(iw1.a.a());
        int i = iw1.l;
    }

    public z82(iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f10799a = sdkSettings;
    }
}
