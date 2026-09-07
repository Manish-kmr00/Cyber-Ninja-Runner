package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8966a;
    private final a51 b;
    private final n41 c;
    private final q41 d;

    public final void a(Context context, o41 nativeAdBlock, pj0 imageProvider, o51 nativeAdFactoriesProvider, c51 nativeAdCreationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
        p41 p41VarA = this.d.a(this.f8966a.p());
        if (p41VarA != null) {
            p41VarA.a(context, nativeAdBlock, imageProvider, this.c, nativeAdFactoriesProvider, this.b, nativeAdCreationListener);
        } else {
            nativeAdCreationListener.a(w7.x());
        }
    }

    public /* synthetic */ g51(o3 o3Var, uu1 uu1Var, a51 a51Var) {
        this(o3Var, uu1Var, a51Var, new n41(uu1Var), new q41(uu1Var));
    }

    public g51(o3 adConfiguration, uu1 sdkEnvironmentModule, a51 nativeAdControllers, n41 nativeAdBinderFactory, q41 nativeAdBlockCreatorProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(nativeAdBinderFactory, "nativeAdBinderFactory");
        Intrinsics.checkNotNullParameter(nativeAdBlockCreatorProvider, "nativeAdBlockCreatorProvider");
        this.f8966a = adConfiguration;
        this.b = nativeAdControllers;
        this.c = nativeAdBinderFactory;
        this.d = nativeAdBlockCreatorProvider;
    }
}
