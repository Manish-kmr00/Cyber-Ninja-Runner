package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cr0<V extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y00<V> f8634a;

    public final void a(ViewGroup container, V designView, br0<V> layoutDesign) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(designView, "designView");
        Intrinsics.checkNotNullParameter(layoutDesign, "layoutDesign");
        try {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            container.removeAllViews();
            container.addView(designView, layoutParams);
        } catch (Throwable unused) {
        }
        y00<V> y00VarA = layoutDesign.a();
        this.f8634a = y00VarA;
        if (y00VarA != null) {
            y00VarA.a(designView);
        }
    }

    public final void a(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        try {
            container.removeAllViews();
            y00<V> y00Var = this.f8634a;
            if (y00Var != null) {
                y00Var.c();
            }
        } catch (Throwable unused) {
        }
    }
}
