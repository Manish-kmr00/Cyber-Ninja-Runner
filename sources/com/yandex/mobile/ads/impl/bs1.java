package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pm1 f8537a;
    private final Context b;

    public final as1 a(ur1 contentController) {
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Context appContext = this.b;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        return new as1(appContext, contentController, this.f8537a, new ht0(appContext), new dt0());
    }

    public /* synthetic */ bs1(Context context, jd0 jd0Var) {
        this(context, new pm1(jd0Var));
    }

    public bs1(Context context, pm1 proxyRewardedAdShowListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(proxyRewardedAdShowListener, "proxyRewardedAdShowListener");
        this.f8537a = proxyRewardedAdShowListener;
        this.b = context.getApplicationContext();
    }
}
