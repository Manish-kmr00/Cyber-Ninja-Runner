package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9949a;
    private final dt b;
    private final z2 c;
    private final tt0 d;
    private final xl0 e;
    private final Context f;

    public pt0(Context context, uu1 sdkEnvironmentModule, dt instreamAdBreak, z2 adBreakStatusController, tt0 manualPlaybackEventListener, xl0 instreamAdCustomUiElementsHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAdBreak, "instreamAdBreak");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        Intrinsics.checkNotNullParameter(manualPlaybackEventListener, "manualPlaybackEventListener");
        Intrinsics.checkNotNullParameter(instreamAdCustomUiElementsHolder, "instreamAdCustomUiElementsHolder");
        this.f9949a = sdkEnvironmentModule;
        this.b = instreamAdBreak;
        this.c = adBreakStatusController;
        this.d = manualPlaybackEventListener;
        this.e = instreamAdCustomUiElementsHolder;
        this.f = context.getApplicationContext();
    }

    public final ot0 a(zl2 instreamAdPlayer) {
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        gm0 gm0Var = new gm0(instreamAdPlayer);
        Context context = this.f;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        uu1 uu1Var = this.f9949a;
        dt dtVar = this.b;
        z2 z2Var = this.c;
        tt0 tt0Var = this.d;
        xl0 xl0Var = this.e;
        int i = ut0.d;
        ut0 ut0VarA = ut0.a.a();
        zm0 zm0Var = new zm0();
        return new ot0(context, uu1Var, dtVar, gm0Var, z2Var, tt0Var, xl0Var, ut0VarA, zm0Var, new u2(context, dtVar, gm0Var, new vm0(context, uu1Var, zm0Var, new vt0(gm0Var, dtVar), gm0Var, xl0Var), zm0Var, z2Var));
    }
}
