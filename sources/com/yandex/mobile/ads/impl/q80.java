package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j80 f9994a;
    private final v9 b;

    public /* synthetic */ q80(Context context, o3 o3Var, j80 j80Var) {
        this(context, o3Var, j80Var, new v9(context, o3Var));
    }

    public q80(Context context, o3 adConfiguration, j80 falseClick, v9 adTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(falseClick, "falseClick");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        this.f9994a = falseClick;
        this.b = adTracker;
    }

    public final void a(long j) {
        if (j <= this.f9994a.c()) {
            this.b.a(this.f9994a.d(), s62.e);
        }
    }
}
