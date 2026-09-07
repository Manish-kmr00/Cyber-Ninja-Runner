package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class jb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zy1 f9300a;
    private final j1 b;
    private final Context c;

    public jb0(Context context, zy1 sizeInfo, j1 adActivityListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        this.f9300a = sizeInfo;
        this.b = adActivityListener;
        this.c = context.getApplicationContext();
    }

    public final void a() {
        int i;
        int i2 = this.c.getResources().getConfiguration().orientation;
        Context context = this.c;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        zy1 zy1Var = this.f9300a;
        boolean zB = qa.b(context, zy1Var);
        boolean zA = qa.a(context, zy1Var);
        if (zB == zA) {
            i = -1;
        } else {
            i = (!zA ? 1 == i2 : 1 != i2) ? 6 : 7;
        }
        if (-1 != i) {
            this.b.a(i);
        }
    }
}
