package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9089a;
    private final j1 b;
    private final Context c;

    public hf1(Context context, o8 adResponse, v1 adActivityListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        this.f9089a = adResponse;
        this.b = adActivityListener;
        this.c = context.getApplicationContext();
    }

    public final void a() {
        if (this.f9089a.S()) {
            return;
        }
        zy1 zy1VarM = this.f9089a.M();
        Context context = this.c;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new jb0(context, zy1VarM, this.b).a();
    }
}
