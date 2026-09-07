package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class nk0 implements rk0, n11, me2, vo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9736a;
    private final s4 b;
    private final pk0 c;
    private final Context d;
    private List<xx1> e;
    private t4 f;

    public interface a {
        void a(t4 t4Var);
    }

    public nk0(Context context, a impressionListener, qk0 impressionReporter, s4 adIdStorageManager, pk0 impressionReportController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(adIdStorageManager, "adIdStorageManager");
        Intrinsics.checkNotNullParameter(impressionReportController, "impressionReportController");
        this.f9736a = impressionListener;
        this.b = adIdStorageManager;
        this.c = impressionReportController;
        this.d = context.getApplicationContext();
    }

    public final void a(List<xx1> showNotices, t4 t4Var) {
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        this.e = showNotices;
        this.f = t4Var;
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.vo1
    public final void f() {
    }

    private final boolean a() {
        int i = iw1.l;
        iw1 iw1VarA = iw1.a.a();
        Context context = this.d;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cu1 cu1VarA = iw1VarA.a(context);
        return cu1VarA == null || cu1VarA.a0();
    }

    @Override // com.yandex.mobile.ads.impl.rk0
    public final void c() {
        if (!i() || a()) {
            return;
        }
        this.b.a();
        this.f9736a.a(this.f);
    }

    @Override // com.yandex.mobile.ads.impl.rk0
    public final void g() {
        if (i() && a()) {
            this.b.a();
            this.f9736a.a(this.f);
        }
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void e() {
        if (i()) {
            return;
        }
        this.c.b();
        if (a()) {
            return;
        }
        this.b.a();
        this.f9736a.a(this.f);
    }

    @Override // com.yandex.mobile.ads.impl.n11
    public final void b() {
        if (i()) {
            return;
        }
        this.c.c();
        if (a()) {
            this.b.a();
            this.f9736a.a(this.f);
        }
    }

    @Override // com.yandex.mobile.ads.impl.me2
    public final void d() {
        if (i()) {
            return;
        }
        this.c.b();
        if (a()) {
            return;
        }
        this.b.a();
        this.f9736a.a(this.f);
    }

    @Override // com.yandex.mobile.ads.impl.me2
    public final void h() {
        if (i()) {
            return;
        }
        this.c.c();
        if (a()) {
            this.b.a();
            this.f9736a.a(this.f);
        }
    }

    private final boolean i() {
        List<xx1> list = this.e;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
