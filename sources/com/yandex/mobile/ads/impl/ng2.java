package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
public abstract class ng2<V extends View, T> {
    static final /* synthetic */ KProperty<Object>[] b = {ta.a(ng2.class, "viewReference", "getViewReference()Landroid/view/View;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn1 f9730a;

    public ng2(V view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f9730a = ao1.a(view);
    }

    public void a() {
    }

    public void a(V view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(8);
        view.setOnClickListener(null);
        view.setOnTouchListener(null);
        view.setSelected(false);
    }

    public abstract boolean a(V v, T t);

    public abstract void b(V v, T t);

    public final V b() {
        return (V) this.f9730a.getValue(this, b[0]);
    }

    public final boolean c() {
        View view = b();
        if (view != null && !oh2.d(view)) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.getWidth() >= 1 && view.getHeight() >= 1) {
                return true;
            }
        }
        return false;
    }

    public void a(ig<?> asset, qg2 viewConfigurator, T t) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        View viewB = b();
        if (viewB == null) {
            return;
        }
        viewConfigurator.a(viewB, asset);
        viewConfigurator.a(asset, new pg2(viewB));
    }
}
