package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yf {
    public static xf a(Context context, wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(applicationContext);
        if (cu1VarA == null || !cu1VarA.V()) {
            return new gk(applicationContext, sdkEnvironmentModule, new ht0(applicationContext), new dt0(), new zf(sdkEnvironmentModule));
        }
        ht0 ht0Var = new ht0(applicationContext);
        dt0 dt0Var = new dt0();
        zf zfVar = new zf(sdkEnvironmentModule);
        int i2 = ag.e;
        return new hn(applicationContext, sdkEnvironmentModule, ht0Var, dt0Var, zfVar, ag.a.a(), new sk1());
    }
}
