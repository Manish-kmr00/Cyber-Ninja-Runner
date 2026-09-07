package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10215a;
    private final xb2 b;

    public sl0(uu1 sdkEnvironmentModule, xb2 videoAdLoader) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(videoAdLoader, "videoAdLoader");
        this.f10215a = sdkEnvironmentModule;
        this.b = videoAdLoader;
    }

    public final void a(Context context, p2 adBreak, wp1 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        uu1 uu1Var = this.f10215a;
        w92 w92Var = new w92(context, uu1Var, adBreak, requestListener, new eo0(context, uu1Var));
        z92 z92Var = new z92(new z92.a(adBreak).c(), 0);
        this.b.a(z92Var, new co0(z92Var), w92Var);
    }
}
