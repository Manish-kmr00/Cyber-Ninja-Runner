package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t81 f9895a;
    private final m41 b;

    public final m61 a(Context context, o41 nativeAdBlock, pj0 imageProvider, n41 nativeAdBinderFactory, o51 nativeAdFactoriesProvider, a51 nativeAdControllers, c41 c41Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdBinderFactory, "nativeAdBinderFactory");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        if (c41Var == null) {
            return null;
        }
        s81 s81VarA = this.f9895a.a(c41Var.g());
        zb1 zb1VarA = nativeAdFactoriesProvider.d().a(c41Var);
        dc0 dc0Var = new dc0();
        return s81VarA.a(context, c41Var, new i61(context, c41Var, imageProvider, zb1VarA), imageProvider, this.b.a(context, nativeAdBlock, nativeAdBinderFactory.a(nativeAdBlock, c41Var), zb1VarA, nativeAdFactoriesProvider, dc0Var, c41Var, s9.b), nativeAdControllers);
    }

    public /* synthetic */ p51(uu1 uu1Var) {
        this(uu1Var, new t81(), new m41(uu1Var));
    }

    public p51(uu1 sdkEnvironmentModule, t81 nativeGenericAdCreatorProvider, m41 nativeAdBinderConfigurationCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeGenericAdCreatorProvider, "nativeGenericAdCreatorProvider");
        Intrinsics.checkNotNullParameter(nativeAdBinderConfigurationCreator, "nativeAdBinderConfigurationCreator");
        this.f9895a = nativeGenericAdCreatorProvider;
        this.b = nativeAdBinderConfigurationCreator;
    }
}
