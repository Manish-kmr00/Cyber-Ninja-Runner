package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9754a;
    private final Context b;
    private final z2 c;

    public nt0(Context context, wm2 sdkEnvironmentModule, bt instreamVideoAd) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        this.f9754a = sdkEnvironmentModule;
        this.b = context.getApplicationContext();
        this.c = new z2(instreamVideoAd.a());
    }

    public final mt0 a(dt coreInstreamAdBreak) {
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Context context = this.b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        uu1 uu1Var = this.f9754a;
        z2 z2Var = this.c;
        xl0 xl0Var = new xl0();
        jm0 jm0Var = new jm0();
        tt0 tt0Var = new tt0();
        return new mt0(context, uu1Var, coreInstreamAdBreak, z2Var, xl0Var, jm0Var, tt0Var, new fb2(), new pt0(context, uu1Var, coreInstreamAdBreak, z2Var, tt0Var, xl0Var));
    }
}
