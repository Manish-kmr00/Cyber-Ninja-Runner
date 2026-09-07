package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class us {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xf f10415a;

    public us(Context context, wm2 sdkModule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkModule, "sdkModule");
        this.f10415a = yf.a(context, sdkModule);
        p0.a(context);
    }

    public final void a() {
        this.f10415a.a();
    }

    public final void a(v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.f10415a.a(adRequestData);
    }

    public final void a(jl2 jl2Var) {
        this.f10415a.a(jl2Var);
    }
}
