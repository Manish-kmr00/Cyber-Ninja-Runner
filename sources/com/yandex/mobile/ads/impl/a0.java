package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8346a;
    private final o8<?> b;
    private final mp1 c;
    private final o91 d;
    private final c71 e;
    private final l51 f;
    private final t71 g;

    public a0(o3 adConfiguration, o8 adResponse, cp reporter, o91 nativeOpenUrlHandlerCreator, c71 nativeAdViewAdapter, l51 nativeAdEventController, t71 t71Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeOpenUrlHandlerCreator, "nativeOpenUrlHandlerCreator");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        this.f8346a = adConfiguration;
        this.b = adResponse;
        this.c = reporter;
        this.d = nativeOpenUrlHandlerCreator;
        this.e = nativeAdViewAdapter;
        this.f = nativeAdEventController;
        this.g = t71Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final z<? extends x> a(Context context, x action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        n91 n91VarA = this.d.a(this.c);
        String strA = action.a();
        switch (strA.hashCode()) {
            case -1895850168:
                if (strA.equals("social_action")) {
                    o8<?> o8Var = this.b;
                    o3 o3Var = this.f8346a;
                    t71 t71Var = this.g;
                    o3Var.q().f();
                    ay1 ay1Var = new ay1(context, o8Var, o3Var, t71Var, nd.a(context, bn2.f8524a, o3Var.q().b()));
                    o3 o3Var2 = this.f8346a;
                    o8<?> o8Var2 = this.b;
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    u41 u41Var = new u41(context, o3Var2, o8Var2, applicationContext);
                    o3 o3Var3 = this.f8346a;
                    o8<?> o8Var3 = this.b;
                    l51 l51Var = this.f;
                    c71 c71Var = this.e;
                    return new q02(ay1Var, new y02(context, o3Var3, o8Var3, u41Var, l51Var, c71Var, this.d, new d12(new gj0(context, new z81(o8Var3), c71Var.d(), ed1.c.a(context).b()), new hj1())));
                }
                return null;
            case -1422015845:
                if (strA.equals("adtune")) {
                    return new kb(new yb(this.f, n91VarA), new v9(context, this.f8346a), this.c);
                }
                return null;
            case -191501435:
                if (strA.equals("feedback")) {
                    return new ma0(new va0(this.f8346a, this.c, this.e, this.f, new ua0()));
                }
                return null;
            case 94756344:
                if (strA.equals("close")) {
                    return new kp(this.c, this.f);
                }
                return null;
            case 629233382:
                if (strA.equals("deeplink")) {
                    o3 o3Var4 = this.f8346a;
                    o8<?> o8Var4 = this.b;
                    return new sy(new vy(o3Var4, o8Var4, this.c, n91VarA, this.f, new zj1(o3Var4, o8Var4)));
                }
                return null;
            default:
                return null;
        }
    }
}
