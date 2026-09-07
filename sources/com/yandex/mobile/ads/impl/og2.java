package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class og2<V extends View, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ng2<V, T> f9815a;

    public og2(ng2<V, T> viewAdapter) {
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        this.f9815a = viewAdapter;
    }

    public final void a() {
        View viewB = this.f9815a.b();
        if (viewB == null) {
            return;
        }
        this.f9815a.a(viewB);
    }

    public final void a(ig<?> asset, qg2 viewConfigurator, T t) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        if (this.f9815a.b() == null) {
            return;
        }
        this.f9815a.a(asset, viewConfigurator, t);
    }

    public final void b() {
        this.f9815a.a();
    }

    public final void b(T t) {
        View viewB = this.f9815a.b();
        if (viewB == null) {
            return;
        }
        this.f9815a.b(viewB, t);
        viewB.setVisibility(0);
    }

    public final boolean a(T t) {
        View viewB = this.f9815a.b();
        return viewB != null && this.f9815a.a(viewB, t);
    }
}
