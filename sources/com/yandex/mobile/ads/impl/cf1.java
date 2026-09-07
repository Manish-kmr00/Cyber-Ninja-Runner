package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls0 f8598a;

    public /* synthetic */ cf1(Context context) {
        this(context, ns0.a(context));
    }

    public final void b() {
        this.f8598a.b("OPT_OUT_ENABLED", true);
    }

    public cf1(Context context, ls0 localStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.f8598a = localStorage;
    }

    public final boolean a() {
        return this.f8598a.a("OPT_OUT_ENABLED", false);
    }
}
