package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class um0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xl0 f10405a;
    private final r00 b;

    public final gb2 a(q70 instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        gb2 gb2VarA = this.f10405a.a();
        if (gb2VarA != null) {
            return gb2VarA;
        }
        r00 r00Var = this.b;
        Context context = instreamAdView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return r00Var.a(context, instreamAdView);
    }

    public /* synthetic */ um0(xl0 xl0Var, mn0 mn0Var) {
        this(xl0Var, mn0Var, new r00(mn0Var));
    }

    public um0(xl0 customUiElementsHolder, mn0 instreamDesign, r00 defaultUiElementsCreator) {
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamDesign, "instreamDesign");
        Intrinsics.checkNotNullParameter(defaultUiElementsCreator, "defaultUiElementsCreator");
        this.f10405a = customUiElementsHolder;
        this.b = defaultUiElementsCreator;
    }
}
