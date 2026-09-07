package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class eg {
    public static void a(Context context, wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        int i = z72.c;
        z72.a(context, sdkEnvironmentModule.c());
        de.a(context, sdkEnvironmentModule.c());
        it0 it0Var = new it0();
        Boolean boolC = it0.c(context);
        if (boolC != null) {
            m11.b(boolC.booleanValue());
        }
        Boolean boolF = it0.f(context);
        if (boolF != null) {
            m11.a(boolF.booleanValue());
        }
        if (pa.a(context)) {
            new e11();
            e11.a aVarA = e11.a(context);
            if (aVarA instanceof e11.a.b) {
                dp0.a(new ep0().a((e11.a.b) aVarA), new Object[0]);
            } else if (aVarA instanceof e11.a.C0741a) {
                dp0.b("Yandex Mobile Ads 7.12.1 integrated successfully", new Object[0]);
            }
            new w01().a();
            nz0 nz0Var = new nz0();
            int i2 = iz0.d;
            yz0.a(new zz0(nz0Var).a(new wz0().a(iz0.a.a())));
        }
        jw1 jw1Var = new jw1(new et0(), it0Var, sdkEnvironmentModule);
        p0.a(context);
        jw1Var.a(context);
    }
}
