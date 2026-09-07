package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class oz1<V extends ViewGroup> implements y00<V>, f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m6 f9879a;
    private final e1 b;
    private final x41 c;
    private final ez1 d;
    private m00 e;

    public oz1(m6 m6Var, e1 adActivityEventController, x41 nativeAdControlViewProvider, ez1 skipAppearanceController) {
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(nativeAdControlViewProvider, "nativeAdControlViewProvider");
        Intrinsics.checkNotNullParameter(skipAppearanceController, "skipAppearanceController");
        this.f9879a = m6Var;
        this.b = adActivityEventController;
        this.c = nativeAdControlViewProvider;
        this.d = skipAppearanceController;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        n6 n6VarB;
        Intrinsics.checkNotNullParameter(container, "container");
        View viewB = this.c.b(container);
        if (viewB != null) {
            this.b.a(this);
            ez1 ez1Var = this.d;
            m6 m6Var = this.f9879a;
            Long lValueOf = (m6Var == null || (n6VarB = m6Var.b()) == null) ? null : Long.valueOf(n6VarB.a());
            m00 m00Var = new m00(viewB, ez1Var, lValueOf != null ? lValueOf.longValue() : 0L, lg1.a());
            this.e = m00Var;
            m00Var.b();
            if (viewB.getTag() == null) {
                viewB.setTag("skip_button");
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.f1
    public final void b() {
        m00 m00Var = this.e;
        if (m00Var != null) {
            m00Var.c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.b.b(this);
        m00 m00Var = this.e;
        if (m00Var != null) {
            m00Var.a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.f1
    public final void a() {
        m00 m00Var = this.e;
        if (m00Var != null) {
            m00Var.d();
        }
    }
}
