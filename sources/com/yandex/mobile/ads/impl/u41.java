package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10357a;
    private final o8<?> b;
    private final Context c;
    private t71 d;

    public final cp a(String assetName, String clickType) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        return new cp(this.c, this.b, this.f10357a, new v41(assetName, clickType, this.d));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ u41(Context context, o3 o3Var, o8 o8Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, o8Var, applicationContext);
    }

    public u41(Context context, o3 adConfiguration, o8<?> adResponse, Context appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.f10357a = adConfiguration;
        this.b = adResponse;
        this.c = appContext;
    }

    public final void a(t71 t71Var) {
        this.d = t71Var;
    }
}
