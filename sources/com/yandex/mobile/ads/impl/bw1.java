package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bw1 implements ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f8542a;

    public bw1(uu1 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f8542a = sdkEnvironmentModule;
    }

    @Override // com.yandex.mobile.ads.impl.ej
    public final dj a(zi adViewController) {
        Intrinsics.checkNotNullParameter(adViewController, "adViewController");
        uu1 uu1Var = this.f8542a;
        v91 v91Var = new v91(adViewController.l(), uu1Var, adViewController.f(), adViewController.i());
        mj mjVar = new mj(adViewController.f());
        p71 p71Var = new p71(adViewController.f());
        qt1 qt1Var = new qt1(adViewController.f());
        x71 x71Var = new x71(adViewController);
        Handler handler = new Handler(Looper.getMainLooper());
        int i = iw1.l;
        return new aw1(adViewController, uu1Var, v91Var, mjVar, p71Var, qt1Var, x71Var, handler, iw1.a.a(), new bj(), new z51());
    }
}
