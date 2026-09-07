package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final up0 f9753a;

    public /* synthetic */ nt(Context context, wm2 wm2Var) {
        this(context, wm2Var, new vp0());
    }

    public nt(Context context, wm2 sdkEnvironmentModule, vp0 itemsLoadControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(itemsLoadControllerFactory, "itemsLoadControllerFactory");
        itemsLoadControllerFactory.getClass();
        this.f9753a = vp0.a(context, sdkEnvironmentModule);
        p0.a(context);
    }

    public final void a() {
        this.f9753a.a();
    }

    public final void a(v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.f9753a.a(adRequestData);
    }

    public final void a(gm2 gm2Var) {
        this.f9753a.a(gm2Var);
    }
}
