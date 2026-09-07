package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10325a;

    public tp0(wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f10325a = sdkEnvironmentModule;
    }

    public final sp0 a(Context context, b5<sp0> itemsLoadFinishListener, v7 adRequestData, jd0 jd0Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemsLoadFinishListener, "itemsLoadFinishListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        uu1 uu1Var = this.f10325a;
        g5 g5Var = new g5();
        pg0 pg0Var = new pg0();
        rp0 rp0Var = new rp0(context);
        xp0 xp0Var = new xp0(context, jd0Var);
        o3 o3Var = new o3(qs.e, uu1Var);
        return new sp0(context, uu1Var, itemsLoadFinishListener, adRequestData, g5Var, pg0Var, rp0Var, xp0Var, o3Var, new mm1(context, o3Var, g5Var, xp0Var));
    }
}
