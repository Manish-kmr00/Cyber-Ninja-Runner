package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nm1 f10669a;
    private final Context b;

    public final wp0 a(qp0 contentController) {
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Context appContext = this.b;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        return new wp0(appContext, contentController, this.f10669a, new ht0(appContext), new dt0());
    }

    public /* synthetic */ xp0(Context context, jd0 jd0Var) {
        this(context, new nm1(jd0Var));
    }

    public xp0(Context context, nm1 proxyInterstitialAdShowListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(proxyInterstitialAdShowListener, "proxyInterstitialAdShowListener");
        this.f10669a = proxyInterstitialAdShowListener;
        this.b = context.getApplicationContext();
    }
}
