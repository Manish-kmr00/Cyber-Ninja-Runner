package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8584a;
    private final gi2 b;
    private final Context c;
    private final v5 d;
    private final af2 e;
    private final v60 f;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ cb(Context context, wm2 wm2Var, cm2 cm2Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, wm2Var, cm2Var, applicationContext, new v5(), new af2(), new v60());
    }

    public cb(Context context, wm2 sdkEnvironmentModule, cm2 vmapRequestConfig, Context applicationContext, v5 adPlayerCreator, af2 videoPlayerCreator, v60 exoPlayerListenerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(vmapRequestConfig, "vmapRequestConfig");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(adPlayerCreator, "adPlayerCreator");
        Intrinsics.checkNotNullParameter(videoPlayerCreator, "videoPlayerCreator");
        Intrinsics.checkNotNullParameter(exoPlayerListenerCreator, "exoPlayerListenerCreator");
        this.f8584a = sdkEnvironmentModule;
        this.b = vmapRequestConfig;
        this.c = applicationContext;
        this.d = adPlayerCreator;
        this.e = videoPlayerCreator;
        this.f = exoPlayerListenerCreator;
    }

    public final an0 a() {
        Context context = this.c;
        uu1 uu1Var = this.f8584a;
        gs0 gs0Var = new gs0(context, uu1Var, this.b, new cm0(context, uu1Var));
        p9 adStateDataController = new p9(new r9(null), new p5(null), new a5());
        ri1 ri1Var = new ri1();
        he2 he2Var = new he2(-9223372036854775807L);
        y60 y60Var = new y60();
        pi1 playerStateController = new pi1(ri1Var, he2Var, y60Var, new vi1(y60Var), new fi1(y60Var));
        he2 he2VarA = playerStateController.a();
        y60 y60VarC = playerStateController.c();
        qj1 positionProviderHolder = new qj1(null, null);
        z5 adPlayerEventsController = new z5(new n9(new g80(positionProviderHolder, he2VarA)));
        bf2 videoPlayerEventsController = new bf2();
        pl bindingControllerHolder = new pl(null);
        this.f.getClass();
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoEventsController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        r9 r9VarB = adStateDataController.b();
        p5 p5VarC = adStateDataController.c();
        y60 y60VarC2 = playerStateController.c();
        he2 he2VarA2 = playerStateController.a();
        n3 n3Var = new n3(bindingControllerHolder, adStateDataController, playerStateController, adPlayerEventsController, adStateDataController.b(), adStateDataController.c(), playerStateController.c(), playerStateController.e(), playerStateController.d(), new t5());
        ee2 ee2Var = new ee2(p5VarC, he2VarA2, positionProviderHolder, videoPlayerEventsController, new ce2(positionProviderHolder, he2VarA2));
        ni1 ni1Var = new ni1(r9VarB, n3Var, ee2Var, adPlayerEventsController);
        ci1 ci1Var = new ci1(p5VarC, positionProviderHolder, he2VarA2, ni1Var, new fs0(positionProviderHolder, he2VarA2));
        hi1 hi1Var = new hi1(r9VarB, adPlayerEventsController, new eb());
        g80 g80Var = new g80(positionProviderHolder, he2VarA2);
        m5 m5Var = new m5(adStateDataController, g80Var, ee2Var, adStateDataController.b(), adStateDataController.c());
        p5 p5VarC2 = adStateDataController.c();
        a5 a5VarA = adStateDataController.a();
        ri1 ri1VarD = playerStateController.d();
        qh1 qh1Var = new qh1(bindingControllerHolder, playerStateController, adStateDataController, ee2Var, g80Var, n3Var, m5Var, p5VarC2, a5VarA, ri1VarD, playerStateController.c(), new wf2(ri1VarD, ee2Var));
        t60 t60Var = new t60(bindingControllerHolder, y60VarC2, ci1Var, ni1Var, hi1Var, new d52(p5VarC, playerStateController, new gb(bindingControllerHolder, p5VarC, he2VarA2, positionProviderHolder), qh1Var, playerStateController.d(), playerStateController.a(), new g82()), qh1Var);
        r5 r5Var = new r5(he2VarA, new c3(he2VarA));
        this.d.getClass();
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        r9 r9VarB2 = adStateDataController.b();
        p5 p5VarC3 = adStateDataController.c();
        he2 he2VarA3 = playerStateController.a();
        y60 y60VarC3 = playerStateController.c();
        ol1 ol1Var = new ol1(new t6(r9VarB2, playerStateController, playerStateController.d(), playerStateController.c()));
        y60VarC3.a(ol1Var);
        d6 d6Var = new d6(adStateDataController, new e4(he2VarA3, p5VarC3, new c3(he2VarA3)), new yn0());
        r9 r9VarB3 = adStateDataController.b();
        a5 a5VarA2 = adStateDataController.a();
        ri1 ri1VarD2 = playerStateController.d();
        fi1 fi1VarB = playerStateController.b();
        w5 w5Var = new w5(adStateDataController, playerStateController);
        int i = xn0.g;
        g60 g60Var = new g60(r9VarB2, playerStateController, ol1Var, d6Var, new b6(adStateDataController, playerStateController, adPlayerEventsController, r9VarB3, a5VarA2, ri1VarD2, fi1VarB, w5Var, xn0.a.a()), adPlayerEventsController, playerStateController.d(), playerStateController.e());
        this.e.getClass();
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoPlayerEventsController");
        r9 r9VarB4 = adStateDataController.b();
        y60 y60VarC4 = playerStateController.c();
        ol1 ol1Var2 = new ol1(new lf2(r9VarB4, playerStateController, positionProviderHolder, playerStateController.a(), playerStateController.d()));
        y60VarC4.a(ol1Var2);
        tw1 tw1Var = new tw1(ol1Var2, playerStateController.e(), videoPlayerEventsController);
        Context context2 = this.c;
        uu1 uu1Var2 = this.f8584a;
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new an0(adStateDataController, r5Var, new nl(context2, uu1Var2, g60Var, tw1Var, applicationContext), bindingControllerHolder, gs0Var, playerStateController, new m60(bindingControllerHolder, adStateDataController, adPlayerEventsController, y60VarC, this.f8584a.c(), adStateDataController.b(), adStateDataController.a(), adStateDataController.c(), new eb(), new Handler(Looper.getMainLooper())), positionProviderHolder, t60Var, new fb2(), adStateDataController.b(), adStateDataController.c(), playerStateController.c(), playerStateController.d());
    }
}
