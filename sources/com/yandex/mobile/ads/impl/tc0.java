package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10285a;

    public tc0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10285a = context.getApplicationContext();
    }

    public final boolean a() {
        int i = iw1.l;
        iw1 iw1VarA = iw1.a.a();
        Context context = this.f10285a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cu1 cu1VarA = iw1VarA.a(context);
        return cu1VarA != null && cu1VarA.c0();
    }
}
