package com.five_corp.ad.internal.movie.exoplayer;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.internal.movie.G;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.view.E;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f1440a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final E c;

    public a(l lVar, E e) {
        this.c = e;
        lVar.g = this;
        this.f1440a = new d(lVar, this, 0, true);
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final int a() {
        return this.f1440a.b();
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void b() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    public final /* synthetic */ void c() {
        this.f1440a = this.f1440a.a();
    }

    public final /* synthetic */ void d() {
        this.f1440a = this.f1440a.c();
    }

    public final /* synthetic */ void e() {
        this.f1440a = this.f1440a.d();
    }

    public final /* synthetic */ void f() {
        this.f1440a = this.f1440a.e();
    }

    public final /* synthetic */ void g() {
        this.f1440a = this.f1440a.f();
    }

    public final /* synthetic */ void h() {
        this.f1440a = this.f1440a.g();
    }

    public final /* synthetic */ void i() {
        this.f1440a = this.f1440a.h();
    }

    public final /* synthetic */ void j() {
        this.f1440a = this.f1440a.i();
    }

    public final void k() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    public final void l() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public final void m() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        });
    }

    public final void n() {
        Handler handler = this.b;
        final E e = this.c;
        Objects.requireNonNull(e);
        handler.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                e.a();
            }
        });
    }

    public final void o() {
        Handler handler = this.b;
        final E e = this.c;
        Objects.requireNonNull(e);
        handler.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                e.b();
            }
        });
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void pause() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g();
            }
        });
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void prepare() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h();
            }
        });
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void release() {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/exoplayer/a;->release()V");
        CreativeInfoManager.onVideoCompleted("com.five_corp.ad", "line exo-player");
        safedk_a_release_24b9172cc4ef0e9845aaadfac91d3065();
    }

    public void safedk_a_release_24b9172cc4ef0e9845aaadfac91d3065() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.i();
            }
        });
    }

    public void safedk_a_start_5a6a5da32b01c29205b2807c22f1d2f3() {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j();
            }
        });
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void start() {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/exoplayer/a;->start()V");
        CreativeInfoManager.onVideoStart("com.five_corp.ad", this, "line exo-player");
        safedk_a_start_5a6a5da32b01c29205b2807c22f1d2f3();
    }

    public final /* synthetic */ void a(o oVar) {
        this.f1440a = this.f1440a.a(oVar);
    }

    public final /* synthetic */ void b(int i) {
        this.c.b(i);
    }

    public final void c(int i) {
        com.five_corp.ad.f fVar = this.c.d;
        fVar.o.p(i, fVar.t);
    }

    public final /* synthetic */ void d(int i) {
        this.c.c(i);
    }

    public final void e(int i) {
        com.five_corp.ad.f fVar = this.c.d;
        fVar.s.a();
        fVar.o.u(i, fVar.t);
    }

    public final void f(final int i) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i);
            }
        });
    }

    public final void g(final int i) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i);
            }
        });
    }

    public final void h(final int i) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(i);
            }
        });
    }

    public final void i(final int i) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(i);
            }
        });
    }

    public final void j(final int i) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(i);
            }
        });
    }

    public final /* synthetic */ void a(int i) {
        this.c.a(i);
    }

    public final /* synthetic */ void b(boolean z) {
        this.f1440a.a(z);
    }

    public final void a(int i, o oVar) {
        this.c.a(oVar);
    }

    public final void b(final o oVar) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(oVar);
            }
        });
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void a(final boolean z) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(z);
            }
        });
    }

    public final void b(final int i, final o oVar) {
        this.b.post(new Runnable() { // from class: com.five_corp.ad.internal.movie.exoplayer.a$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, oVar);
            }
        });
    }
}
