package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class cz<V extends View, T> implements jg<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ng2<V, T> f8652a;

    public cz(ng2<V, T> viewAdapter) {
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        this.f8652a = viewAdapter;
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void destroy() {
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean d() {
        return oh2.a(this.f8652a.b(), 100);
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean b() {
        return this.f8652a.b() != null;
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean e() {
        return this.f8652a.c();
    }

    public void b(T t) {
        c(t);
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final dh2 c() {
        View view = this.f8652a.b();
        if (view == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        return new dh2(view.getWidth(), view.getHeight());
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void a() {
        View viewB = this.f8652a.b();
        if (viewB == null) {
            return;
        }
        this.f8652a.a(viewB);
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void a(ig<T> asset, qg2 viewConfigurator) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        this.f8652a.a(asset, viewConfigurator, asset.d());
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final void c(T t) {
        View viewB = this.f8652a.b();
        if (viewB == null) {
            return;
        }
        this.f8652a.b(viewB, t);
        viewB.setVisibility(0);
    }

    @Override // com.yandex.mobile.ads.impl.jg
    public final boolean a(T t) {
        View viewB = this.f8652a.b();
        return viewB != null && this.f8652a.a(viewB, t);
    }
}
