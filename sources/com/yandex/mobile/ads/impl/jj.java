package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class jj<T extends ViewGroup> {
    static final /* synthetic */ KProperty<Object>[] d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(jj.class, "parentDesignView", "getParentDesignView()Landroid/view/ViewGroup;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f9323a;
    private y00<T> b;
    private final zn1 c;

    public jj(ViewTreeObserver.OnPreDrawListener preDrawListener) {
        Intrinsics.checkNotNullParameter(preDrawListener, "preDrawListener");
        this.f9323a = preDrawListener;
        this.c = ao1.a(null);
    }

    public final void a(ViewGroup container, T contentView, br0<T> layoutDesign, zy1 zy1Var) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(contentView, "designView");
        Intrinsics.checkNotNullParameter(layoutDesign, "layoutDesign");
        this.c.setValue(this, d[0], contentView);
        container.setVisibility(0);
        container.removeAllViews();
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f9323a;
        int i = rg2.b;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        if (container.indexOfChild(contentView) == -1) {
            RelativeLayout.LayoutParams layoutParamsA = m8.a(context, zy1Var);
            container.setVisibility(0);
            contentView.setVisibility(0);
            container.addView(contentView, layoutParamsA);
            if (onPreDrawListener != null) {
                oh2.a(contentView, onPreDrawListener);
            }
        }
        y00<T> y00Var = (y00<T>) layoutDesign.a();
        this.b = y00Var;
        if (y00Var != null) {
            y00Var.a(contentView);
        }
    }

    public final void a() {
        ViewGroup viewGroup = (ViewGroup) this.c.getValue(this, d[0]);
        if (viewGroup != null) {
            sg2.a(viewGroup);
        }
        y00<T> y00Var = this.b;
        if (y00Var != null) {
            y00Var.c();
        }
    }
}
