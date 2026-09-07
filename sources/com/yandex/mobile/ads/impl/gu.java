package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yr1 f9035a;

    public gu(Context context, yr1 adLoadController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadController, "adLoadController");
        this.f9035a = adLoadController;
        p0.a(context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gu(Context context, wm2 sdkEnvironmentModule) {
        this(context, zr1.a(context, sdkEnvironmentModule));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
    }

    public final void a() {
        this.f9035a.a();
    }

    public final void a(v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.f9035a.a(adRequestData);
    }

    public final void a(vm2 vm2Var) {
        this.f9035a.a(vm2Var);
    }
}
