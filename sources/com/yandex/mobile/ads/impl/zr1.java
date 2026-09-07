package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zr1 {
    public static yr1 a(Context context, wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(applicationContext);
        if (cu1VarA == null || !cu1VarA.v0()) {
            return new sk(applicationContext, sdkEnvironmentModule, new ht0(applicationContext), new dt0(), new xr1(sdkEnvironmentModule));
        }
        ht0 ht0Var = new ht0(applicationContext);
        dt0 dt0Var = new dt0();
        xr1 xr1Var = new xr1(sdkEnvironmentModule);
        int i2 = ks1.e;
        return new ln(applicationContext, sdkEnvironmentModule, ht0Var, dt0Var, xr1Var, ks1.a.a(), new sk1());
    }
}
