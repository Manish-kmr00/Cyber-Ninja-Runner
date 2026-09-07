package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class jf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dx1 f9312a;

    public final kd a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        dx1 dx1Var = this.f9312a;
        dx1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return new kd(!dx1Var.b(context));
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        dx1 dx1Var = this.f9312a;
        dx1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return !dx1Var.b(context);
    }

    public /* synthetic */ jf() {
        this(new dx1());
    }

    public jf(dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        this.f9312a = sensitiveModeChecker;
    }
}
