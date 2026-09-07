package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10814a;

    public zf(wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f10814a = sdkEnvironmentModule;
    }

    public final wf a(Context context, b5<wf> finishListener, v7 adRequestData, jd0 jd0Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(finishListener, "finishListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        uu1 uu1Var = this.f10814a;
        g5 g5Var = new g5();
        pg0 pg0Var = new pg0();
        vf vfVar = new vf(context);
        o3 o3Var = new o3(qs.i, uu1Var);
        return new wf(context, uu1Var, finishListener, adRequestData, g5Var, pg0Var, vfVar, o3Var, new km1(context, o3Var, g5Var, jd0Var));
    }
}
