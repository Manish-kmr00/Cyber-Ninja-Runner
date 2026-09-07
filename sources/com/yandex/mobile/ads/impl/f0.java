package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a0 f8855a;

    public f0(o3 adConfiguration, o8 adResponse, cp reporter, o91 nativeOpenUrlHandlerCreator, c71 nativeAdViewAdapter, l51 nativeAdEventController, a0 actionHandlerProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeOpenUrlHandlerCreator, "nativeOpenUrlHandlerCreator");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(actionHandlerProvider, "actionHandlerProvider");
        this.f8855a = actionHandlerProvider;
    }

    public final df0 a(View view, List<? extends x> list) {
        Intrinsics.checkNotNullParameter(view, "view");
        df0 df0Var = new df0(list == null || list.isEmpty());
        if (list != null) {
            for (x xVar : list) {
                a0 a0Var = this.f8855a;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                z<? extends x> zVarA = a0Var.a(context, xVar);
                if (!(zVarA instanceof z)) {
                    zVarA = null;
                }
                if (zVarA != null) {
                    df0Var = new df0(df0Var.a() || zVarA.a(view, xVar).a());
                }
            }
        }
        return df0Var;
    }
}
