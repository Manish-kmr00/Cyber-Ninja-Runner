package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9701a;
    private final o8<?> b;
    private final Context c;

    public final f70 a() {
        k60 k60VarA = new k60.b(this.c).a();
        ww0 ww0Var = new ww0(this.c, new vw0());
        Context context = this.c;
        o3 o3Var = this.f9701a;
        o8<?> o8Var = this.b;
        o3Var.q().f();
        ef2 ef2Var = new ef2(context, o3Var, o8Var, nd.a(context, bn2.f8524a, o3Var.q().b()), new mc2(o3Var, o8Var));
        Intrinsics.checkNotNull(k60VarA);
        return new f70(k60VarA, ww0Var, ef2Var, new na1(), new of2());
    }

    public n60(Context context, o8 adResponse, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9701a = adConfiguration;
        this.b = adResponse;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
    }
}
