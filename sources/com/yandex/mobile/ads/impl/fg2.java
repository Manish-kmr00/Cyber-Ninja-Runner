package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fg2 implements eg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eg2 f8893a;
    private boolean b;
    private boolean c;

    public fg2(er videoTracker) {
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        this.f8893a = videoTracker;
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(View view, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        this.f8893a.a(view, friendlyOverlays);
        this.b = false;
        this.c = false;
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void c() {
        this.f8893a.c();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void d() {
        this.f8893a.d();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void f() {
        this.f8893a.f();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void i() {
        this.f8893a.i();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void j() {
        this.f8893a.j();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void l() {
        this.f8893a.l();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        this.f8893a.a(assetName);
        h();
        n();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void h() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f8893a.h();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void n() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f8893a.n();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void m() {
        this.f8893a.m();
        h();
        n();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void b() {
        this.f8893a.b();
        k();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void g() {
        this.f8893a.g();
        k();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void e() {
        this.f8893a.e();
        k();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(pc2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f8893a.a(error);
        k();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void k() {
        this.f8893a.k();
        this.b = false;
        this.c = false;
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(eg2.a quartile) {
        Intrinsics.checkNotNullParameter(quartile, "quartile");
        this.f8893a.a(quartile);
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f, long j) {
        this.f8893a.a(f, j);
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a() {
        this.f8893a.a();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f) {
        this.f8893a.a(f);
    }
}
