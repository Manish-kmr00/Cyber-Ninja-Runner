package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10675a;

    public xr1(wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f10675a = sdkEnvironmentModule;
    }

    public final wr1 a(Context context, b5<wr1> itemsLoadFinishListener, v7 adRequestData, jd0 jd0Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemsLoadFinishListener, "itemsLoadFinishListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        uu1 uu1Var = this.f10675a;
        g5 g5Var = new g5();
        pg0 pg0Var = new pg0();
        vr1 vr1Var = new vr1(context);
        bs1 bs1Var = new bs1(context, jd0Var);
        o3 o3Var = new o3(qs.f, uu1Var);
        return new wr1(context, uu1Var, itemsLoadFinishListener, adRequestData, g5Var, pg0Var, vr1Var, bs1Var, o3Var, new om1(context, o3Var, g5Var, bs1Var), new qr1());
    }
}
