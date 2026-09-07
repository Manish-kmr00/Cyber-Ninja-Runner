package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t81 f10364a;
    private final z9 b;
    private final m41 c;

    public final ArrayList a(Context context, o41 nativeAdBlock, pj0 imageProvider, o51 nativeAdFactoriesProvider, dc0 forceController, a51 nativeAdControllers) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(forceController, "forceController");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        ArrayList arrayList = new ArrayList();
        List<c41> listE = nativeAdBlock.c().e();
        ac1 ac1VarD = nativeAdFactoriesProvider.d();
        for (c41 c41Var : listE) {
            zb1 zb1VarA = ac1VarD.a(c41Var);
            i61 i61Var = new i61(context2, c41Var, imageProvider, zb1VarA);
            ac1 ac1Var = ac1VarD;
            ArrayList arrayList2 = arrayList;
            jl jlVarA = this.c.a(context, nativeAdBlock, this.b.a(c41Var), zb1VarA, nativeAdFactoriesProvider, forceController, c41Var, s9.d);
            s81 s81VarA = this.f10364a.a(c41Var.g());
            if (s81VarA != null) {
                arrayList2.add(s81VarA.a(context, c41Var, i61Var, imageProvider, jlVarA, nativeAdControllers));
            }
            arrayList = arrayList2;
            ac1VarD = ac1Var;
            context2 = context;
        }
        return arrayList;
    }

    public /* synthetic */ u81(uu1 uu1Var) {
        this(uu1Var, new t81(), new z9(), new m41(uu1Var));
    }

    public u81(uu1 sdkEnvironmentModule, t81 nativeGenericAdCreatorProvider, z9 adUnitAdNativeVisualBlockCreator, m41 nativeAdBinderConfigurationCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeGenericAdCreatorProvider, "nativeGenericAdCreatorProvider");
        Intrinsics.checkNotNullParameter(adUnitAdNativeVisualBlockCreator, "adUnitAdNativeVisualBlockCreator");
        Intrinsics.checkNotNullParameter(nativeAdBinderConfigurationCreator, "nativeAdBinderConfigurationCreator");
        this.f10364a = nativeGenericAdCreatorProvider;
        this.b = adUnitAdNativeVisualBlockCreator;
        this.c = nativeAdBinderConfigurationCreator;
    }
}
