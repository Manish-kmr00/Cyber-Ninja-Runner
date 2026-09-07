package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vp0 {
    public static up0 a(Context context, wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(applicationContext);
        if (cu1VarA == null || !cu1VarA.g0()) {
            return new nk(applicationContext, sdkEnvironmentModule, new ht0(applicationContext), new dt0(), new tp0(sdkEnvironmentModule));
        }
        ht0 ht0Var = new ht0(applicationContext);
        dt0 dt0Var = new dt0();
        tp0 tp0Var = new tp0(sdkEnvironmentModule);
        int i2 = bq0.e;
        return new kn(applicationContext, sdkEnvironmentModule, ht0Var, dt0Var, tp0Var, bq0.a.a(), new sk1());
    }
}
