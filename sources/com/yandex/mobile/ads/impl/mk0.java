package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mk0 implements ec0, me2, rk0, n11, vo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f9646a = new LinkedHashSet();
    private final LinkedHashSet b = new LinkedHashSet();
    private final LinkedHashSet c = new LinkedHashSet();
    private final LinkedHashSet d = new LinkedHashSet();
    private final LinkedHashSet e = new LinkedHashSet();

    public final void a(ec0 forceImpressionTrackingListener) {
        Intrinsics.checkNotNullParameter(forceImpressionTrackingListener, "forceImpressionTrackingListener");
        this.f9646a.add(forceImpressionTrackingListener);
    }

    public final void b(nk0 impressionTrackingListener) {
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
        this.c.add(impressionTrackingListener);
    }

    public final void c(nk0 videoImpressionTrackingListener) {
        Intrinsics.checkNotNullParameter(videoImpressionTrackingListener, "videoImpressionTrackingListener");
        this.b.add(videoImpressionTrackingListener);
    }

    public final void a(n11 mobileAdsSchemeImpressionListener) {
        Intrinsics.checkNotNullParameter(mobileAdsSchemeImpressionListener, "mobileAdsSchemeImpressionListener");
        this.e.add(mobileAdsSchemeImpressionListener);
    }

    @Override // com.yandex.mobile.ads.impl.vo1
    public final void f() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((vo1) it.next()).f();
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk0
    public final void c() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((rk0) it.next()).c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk0
    public final void g() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((rk0) it.next()).g();
        }
    }

    public final void a(nk0 impressionTrackingListener) {
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
        this.d.add(impressionTrackingListener);
    }

    @Override // com.yandex.mobile.ads.impl.me2
    public final void d() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((me2) it.next()).d();
        }
    }

    @Override // com.yandex.mobile.ads.impl.me2
    public final void h() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((me2) it.next()).h();
        }
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void e() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((n11) it.next()).e();
        }
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void b() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((n11) it.next()).b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ec0
    public final void a() {
        Iterator it = this.f9646a.iterator();
        while (it.hasNext()) {
            ((ec0) it.next()).a();
        }
    }
}
