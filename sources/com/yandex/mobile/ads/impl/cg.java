package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jd0 f8600a;
    private final Context b;

    public cg(Context context, jd0 jd0Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8600a = jd0Var;
        this.b = context.getApplicationContext();
    }

    public final bg a(uf appOpenAdContentController) {
        Intrinsics.checkNotNullParameter(appOpenAdContentController, "appOpenAdContentController");
        Context appContext = this.b;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        return new bg(appContext, appOpenAdContentController, new lm1(this.f8600a), new ht0(appContext), new dt0());
    }
}
