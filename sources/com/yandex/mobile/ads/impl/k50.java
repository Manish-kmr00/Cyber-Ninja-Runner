package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f9380a = new l10();

    public final boolean a(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i5 = i3 - i;
        int i6 = i4 - i2;
        l10 l10Var = this.f9380a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        l10Var.getClass();
        int iA = l10.a(context, 144.0f);
        l10 l10Var2 = this.f9380a;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        l10Var2.getClass();
        return i5 >= iA && i6 >= l10.a(context2, 96.0f);
    }
}
