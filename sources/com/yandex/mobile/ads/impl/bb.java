package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8489a;
    private final gi2 b;
    private final Context c;
    private final u5 d;
    private final ze2 e;
    private final u60 f;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ bb(Context context, wm2 wm2Var, cm2 cm2Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, wm2Var, cm2Var, applicationContext, new u5(), new ze2(), new u60());
    }

    public bb(Context context, wm2 sdkEnvironmentModule, cm2 vmapRequestConfig, Context applicationContext, u5 adPlayerCreator, ze2 videoPlayerCreator, u60 exoPlayerListenerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(vmapRequestConfig, "vmapRequestConfig");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(adPlayerCreator, "adPlayerCreator");
        Intrinsics.checkNotNullParameter(videoPlayerCreator, "videoPlayerCreator");
        Intrinsics.checkNotNullParameter(exoPlayerListenerCreator, "exoPlayerListenerCreator");
        this.f8489a = sdkEnvironmentModule;
        this.b = vmapRequestConfig;
        this.c = applicationContext;
        this.d = adPlayerCreator;
        this.e = videoPlayerCreator;
        this.f = exoPlayerListenerCreator;
    }

    public final bn0 a() {
        Context context = this.c;
        uu1 uu1Var = this.f8489a;
        hs0 hs0Var = new hs0(context, uu1Var, this.b, new cm0(context, uu1Var));
        o9 adStateDataController = new o9(new q9(null), new o5(null), new z4());
        qi1 qi1Var = new qi1();
        ge2 ge2Var = new ge2(-9223372036854775807L);
        x60 x60Var = new x60();
        oi1 playerStateController = new oi1(qi1Var, ge2Var, x60Var, new ui1(x60Var), new ei1(x60Var));
        ge2 ge2VarA = playerStateController.a();
        x60 x60VarC = playerStateController.c();
        pj1 positionProviderHolder = new pj1(null, null);
        y5 adPlayerEventsController = new y5(new m9(new f80(positionProviderHolder, ge2VarA)));
        cf2 videoPlayerEventsController = new cf2();
        ol bindingControllerHolder = new ol(null);
        this.f.getClass();
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoEventsController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        q9 q9VarB = adStateDataController.b();
        o5 o5VarC = adStateDataController.c();
        x60 x60VarC2 = playerStateController.c();
        ge2 ge2VarA2 = playerStateController.a();
        m3 m3Var = new m3(bindingControllerHolder, adStateDataController, playerStateController, adPlayerEventsController, adStateDataController.b(), adStateDataController.c(), playerStateController.c(), playerStateController.e(), playerStateController.d(), new s5());
        de2 de2Var = new de2(o5VarC, ge2VarA2, positionProviderHolder, videoPlayerEventsController, new be2(positionProviderHolder, ge2VarA2));
        mi1 mi1Var = new mi1(q9VarB, m3Var, de2Var, adPlayerEventsController);
        bi1 bi1Var = new bi1(o5VarC, positionProviderHolder, ge2VarA2, mi1Var, new es0(positionProviderHolder, ge2VarA2));
        gi1 gi1Var = new gi1(q9VarB, adPlayerEventsController, new db());
        f80 f80Var = new f80(positionProviderHolder, ge2VarA2);
        l5 l5Var = new l5(adStateDataController, f80Var, de2Var, adStateDataController.b(), adStateDataController.c());
        o5 o5VarC2 = adStateDataController.c();
        z4 z4VarA = adStateDataController.a();
        qi1 qi1VarD = playerStateController.d();
        ph1 ph1Var = new ph1(bindingControllerHolder, playerStateController, adStateDataController, de2Var, f80Var, m3Var, l5Var, o5VarC2, z4VarA, qi1VarD, playerStateController.c(), new vf2(qi1VarD, de2Var));
        s60 s60Var = new s60(bindingControllerHolder, x60VarC2, bi1Var, mi1Var, gi1Var, new c52(o5VarC, playerStateController, new fb(bindingControllerHolder, o5VarC, ge2VarA2, positionProviderHolder), ph1Var, playerStateController.d(), playerStateController.a(), new f82()), ph1Var);
        q5 q5Var = new q5(ge2VarA, new b3(ge2VarA));
        this.d.getClass();
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        q9 q9VarB2 = adStateDataController.b();
        o5 o5VarC3 = adStateDataController.c();
        ge2 ge2VarA3 = playerStateController.a();
        x60 x60VarC3 = playerStateController.c();
        nl1 nl1Var = new nl1(new s6(q9VarB2, playerStateController, playerStateController.d(), playerStateController.c()));
        x60VarC3.a(nl1Var);
        c6 c6Var = new c6(adStateDataController, new d4(ge2VarA3, o5VarC3, new b3(ge2VarA3)), new yn0());
        q9 q9VarB3 = adStateDataController.b();
        z4 z4VarA2 = adStateDataController.a();
        qi1 qi1VarD2 = playerStateController.d();
        ei1 ei1VarB = playerStateController.b();
        x5 x5Var = new x5(adStateDataController, playerStateController);
        int i = xn0.g;
        f60 f60Var = new f60(q9VarB2, playerStateController, nl1Var, c6Var, new a6(adStateDataController, playerStateController, adPlayerEventsController, q9VarB3, z4VarA2, qi1VarD2, ei1VarB, x5Var, xn0.a.a()), adPlayerEventsController, playerStateController.d(), playerStateController.e());
        this.e.getClass();
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoPlayerEventsController, "videoPlayerEventsController");
        q9 q9VarB4 = adStateDataController.b();
        x60 x60VarC4 = playerStateController.c();
        nl1 nl1Var2 = new nl1(new kf2(q9VarB4, playerStateController, positionProviderHolder, playerStateController.a(), playerStateController.d()));
        x60VarC4.a(nl1Var2);
        sw1 sw1Var = new sw1(nl1Var2, playerStateController.e(), videoPlayerEventsController);
        Context context2 = this.c;
        uu1 uu1Var2 = this.f8489a;
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new bn0(adStateDataController, q5Var, new ml(context2, uu1Var2, f60Var, sw1Var, applicationContext), bindingControllerHolder, hs0Var, playerStateController, new l60(bindingControllerHolder, adStateDataController, adPlayerEventsController, x60VarC, this.f8489a.c(), adStateDataController.b(), adStateDataController.a(), adStateDataController.c(), new db(), new Handler(Looper.getMainLooper())), positionProviderHolder, s60Var, new fb2(), adStateDataController.b(), adStateDataController.c(), playerStateController.c(), playerStateController.d());
    }
}
