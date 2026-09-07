package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f81 implements m61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<m61> f8877a;
    private final m61 b;

    public f81(ArrayList nativePrivates) {
        Intrinsics.checkNotNullParameter(nativePrivates, "nativePrivates");
        this.f8877a = nativePrivates;
        this.b = nativePrivates.isEmpty() ? null : (m61) nativePrivates.get(0);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.b(listener);
        }
    }

    public final List<m61> e() {
        return this.f8877a;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final ot getAdAssets() {
        ot adAssets;
        m61 m61Var = this.b;
        return (m61Var == null || (adAssets = m61Var.getAdAssets()) == null) ? new ot(0) : adAssets;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final zq1 getAdType() {
        zq1 adType;
        m61 m61Var = this.b;
        return (m61Var == null || (adType = m61Var.getAdType()) == null) ? zq1.c : adType;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final String getInfo() {
        m61 m61Var = this.b;
        if (m61Var != null) {
            return m61Var.getInfo();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final vt getNativeAdVideoController() {
        m61 m61Var = this.b;
        if (m61Var != null) {
            return m61Var.getNativeAdVideoController();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final List<y20> c() {
        m61 m61Var = this.b;
        if (m61Var != null) {
            return m61Var.c();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final u61 a() {
        m61 m61Var = this.b;
        if (m61Var != null) {
            return m61Var.a();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void a(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.a(listener);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(g71 viewProvider, to clickConnector) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.b(viewProvider, clickConnector);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void loadImages() {
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.loadImages();
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void destroy() {
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.destroy();
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void a(com.yandex.mobile.ads.nativeads.c cVar) {
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.a(cVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(g71 viewProvider) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.b(viewProvider);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void a(pt ptVar) {
        m61 m61Var = this.b;
        if (m61Var != null) {
            m61Var.a(ptVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final j91 b() {
        j91 j91VarB;
        m61 m61Var = this.b;
        return (m61Var == null || (j91VarB = m61Var.b()) == null) ? new j91(null, null) : j91VarB;
    }
}
