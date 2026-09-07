package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10497a;
    private final dt b;
    private final rb2<do0> c;
    private final Context d;

    public vn0(Context context, uu1 sdkEnvironmentModule, dt coreInstreamAdBreak, rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f10497a = sdkEnvironmentModule;
        this.b = coreInstreamAdBreak;
        this.c = videoAdInfo;
        this.d = context.getApplicationContext();
    }

    public final bf1 a() {
        this.b.c();
        ru ruVarB = this.c.b();
        Context context = this.d;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        uu1 uu1Var = this.f10497a;
        sn0 sn0Var = new sn0(context, uu1Var, ruVarB, new o3(qs.h, uu1Var));
        Context context2 = this.d;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        return new ln0(context2, sn0Var, new q82(new p82()));
    }
}
