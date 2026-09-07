package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10278a;
    private final uu1 b;
    private final o3 c;

    public t90(Context context, wm2 sdkEnvironmentModule, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f10278a = context;
        this.b = sdkEnvironmentModule;
        this.c = adConfiguration;
    }

    public final s90 a(w90 listener, v7 adRequestData, ha0 ha0Var) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Context context = this.f10278a;
        uu1 uu1Var = this.b;
        o3 o3Var = this.c;
        s90 s90Var = new s90(context, uu1Var, o3Var, listener, adRequestData, ha0Var, new qt1(o3Var), new p71(o3Var), new v91(context, uu1Var, o3Var, new g5()), new pg0());
        s90Var.a(adRequestData.a());
        s90Var.a((zy1) new ob0(-1, 0, zy1.a.d));
        return s90Var;
    }
}
