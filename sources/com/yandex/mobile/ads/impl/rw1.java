package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class rw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a92 f10148a;
    private final c92 b;

    public /* synthetic */ rw1(Context context) {
        this(context, new a92(context), new c92(context));
    }

    public rw1(Context context, a92 indicatorController, c92 logController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(indicatorController, "indicatorController");
        Intrinsics.checkNotNullParameter(logController, "logController");
        this.f10148a = indicatorController;
        this.b = logController;
    }

    public final void a() {
        this.b.a();
        this.f10148a.a();
    }
}
