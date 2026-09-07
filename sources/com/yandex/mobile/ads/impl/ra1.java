package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ra1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e00 f10089a;

    public final oa1 a(rb2<gb1> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        int i = c70.d;
        oa1 oa1VarA = c70.a.a().a(videoAdInfo);
        if (oa1VarA != null && !oa1VarA.e()) {
            return oa1VarA;
        }
        f70 f70VarA = this.f10089a.a();
        c70.a.a().a(videoAdInfo, f70VarA);
        return f70VarA;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ra1(Context context, o3 o3Var, o8 o8Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, o8Var, new e00(applicationContext, o8Var, o3Var));
    }

    public ra1(Context context, o3 adConfiguration, o8<?> adResponse, e00 exoPlayerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(exoPlayerCreator, "exoPlayerCreator");
        this.f10089a = exoPlayerCreator;
    }
}
