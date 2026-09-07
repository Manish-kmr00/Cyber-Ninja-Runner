package com.five_corp.ad.internal.movie;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.C3002f;
import com.five_corp.ad.internal.movie.partialcache.s1;
import com.five_corp.ad.internal.movie.partialcache.v1;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class x implements G, L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1513a;
    public final com.five_corp.ad.internal.view.E b;
    public final long c;
    public final com.five_corp.ad.internal.ad.m d;
    public final com.five_corp.ad.internal.view.B e;
    public final M f;
    public final s1 g;
    public final C3002f h;
    public final com.five_corp.ad.internal.movie.partialcache.audio.c i;
    public final com.five_corp.ad.internal.movie.partialcache.audio.d j;
    public final com.five_corp.ad.internal.movie.partialcache.video.c k;
    public final com.five_corp.ad.internal.movie.partialcache.video.d l;
    public final C2994b m;
    public final Handler n;
    public int o;
    public long p;
    public Object q;

    public x(com.five_corp.ad.internal.view.E e, com.five_corp.ad.internal.cache.o oVar, com.five_corp.ad.internal.context.l lVar, com.five_corp.ad.internal.http.movcache.h hVar, com.five_corp.ad.internal.view.B b, TextureView textureView, Looper looper, com.five_corp.ad.internal.logger.a aVar) {
        System.identityHashCode(this);
        this.f1513a = new Handler(Looper.getMainLooper());
        this.o = 1;
        this.q = null;
        Handler handler = new Handler(looper);
        this.n = handler;
        this.b = e;
        com.five_corp.ad.internal.ad.a aVar2 = lVar.b;
        com.five_corp.ad.internal.ad.q qVar = aVar2.g;
        this.c = qVar == null ? 2000000L : qVar.f1308a * 1000;
        this.d = aVar2.h;
        this.e = b;
        b.e.post(new com.five_corp.ad.internal.view.u(b));
        M m = new M(textureView, aVar);
        this.f = m;
        synchronized (m.b) {
            m.g = false;
            m.e = this;
            m.f = handler;
        }
        this.g = new s1(aVar, oVar, lVar, hVar, this, looper);
        this.h = new C3002f(this);
        com.five_corp.ad.internal.movie.partialcache.audio.d dVar = new com.five_corp.ad.internal.movie.partialcache.audio.d();
        this.j = dVar;
        com.five_corp.ad.internal.movie.partialcache.video.d dVar2 = new com.five_corp.ad.internal.movie.partialcache.video.d();
        this.l = dVar2;
        C2994b c2994b = new C2994b(dVar, dVar2);
        this.m = c2994b;
        this.i = new com.five_corp.ad.internal.movie.partialcache.audio.c(handler.getLooper(), c2994b, this);
        this.k = new com.five_corp.ad.internal.movie.partialcache.video.c(handler.getLooper(), c2994b, this);
    }

    public static void a(x xVar, C2994b c2994b) {
        xVar.getClass();
        if (xVar.a(c2994b.b + xVar.c)) {
            Object obj = xVar.q;
            if (obj != null) {
                xVar.n.removeCallbacksAndMessages(obj);
                xVar.q = null;
            }
            int i = xVar.o;
            if (i == 11) {
                xVar.o = 6;
                xVar.f.b();
                com.five_corp.ad.internal.view.B b = xVar.e;
                b.e.post(new com.five_corp.ad.internal.view.A(b));
                xVar.f1513a.post(new RunnableC2982d(xVar));
                return;
            }
            if (i == 12) {
                xVar.o = 5;
                com.five_corp.ad.internal.view.B b2 = xVar.e;
                b2.e.post(new com.five_corp.ad.internal.view.A(b2));
                xVar.f1513a.post(new RunnableC2982d(xVar));
            }
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void b() {
        this.n.post(new RunnableC2990l(this, new q(this)));
    }

    @Override // com.five_corp.ad.internal.movie.L
    public final void c() {
        int iA = com.five_corp.ad.e.a(this.o);
        if (iA == 3) {
            this.o = 3;
        } else {
            if (iA != 6 && iA != 7 && iA != 8) {
                return;
            }
            this.o = 6;
            this.h.a();
            com.five_corp.ad.internal.view.B b = this.e;
            b.e.post(new com.five_corp.ad.internal.view.x(b));
            this.i.a(this.m);
        }
        com.five_corp.ad.internal.movie.partialcache.video.c cVar = this.k;
        C2994b c2994b = this.m;
        cVar.getClass();
        com.five_corp.ad.internal.movie.partialcache.video.c.a(c2994b);
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void pause() {
        this.n.post(new RunnableC2990l(this, new s(this)));
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void prepare() {
        this.n.post(new RunnableC2990l(this, new p(this)));
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void release() {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/x;->release()V");
        CreativeInfoManager.onVideoCompleted("com.five_corp.ad", "line exo-player");
        safedk_x_release_80ca8a6764974350729c9ae4f994a648();
    }

    public void safedk_x_release_80ca8a6764974350729c9ae4f994a648() {
    }

    public void safedk_x_start_7423f661189dce1581498864ec43f714() {
        this.n.post(new RunnableC2990l(this, new r(this)));
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void start() {
        Logger.d("LINE|SafeDK: Execution> Lcom/five_corp/ad/internal/movie/x;->start()V");
        CreativeInfoManager.onVideoStart("com.five_corp.ad", this, "line exo-player");
        safedk_x_start_7423f661189dce1581498864ec43f714();
    }

    public final boolean a(long j) {
        boolean z;
        boolean z2;
        while (true) {
            com.five_corp.ad.internal.movie.partialcache.audio.d dVar = this.j;
            if (!dVar.c || dVar.d || dVar.e >= j) {
                z = true;
                break;
            }
            v1 v1VarA = this.g.a();
            if (v1VarA == null) {
                z = false;
                break;
            }
            this.j.a(v1VarA);
        }
        while (true) {
            com.five_corp.ad.internal.movie.partialcache.video.d dVar2 = this.l;
            if (dVar2.e || dVar2.f >= j) {
                z2 = true;
                break;
            }
            v1 v1VarB = this.g.b();
            if (v1VarB == null) {
                z2 = false;
                break;
            }
            this.l.a(v1VarB);
        }
        return z && z2;
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final int a() {
        return (int) (this.m.b / 1000);
    }

    public final void a(com.five_corp.ad.internal.o oVar) {
        this.n.postAtFrontOfQueue(new o(this, new C2989k(this, oVar)));
    }

    @Override // com.five_corp.ad.internal.movie.L
    public final void a(Surface surface) {
        int i = this.o;
        if (i == 3) {
            com.five_corp.ad.internal.movie.partialcache.video.c cVar = this.k;
            C2994b c2994b = this.m;
            cVar.getClass();
            c2994b.f.c();
            c2994b.e.a(surface, c2994b.b);
            this.o = 4;
            return;
        }
        if (i == 6) {
            com.five_corp.ad.internal.movie.partialcache.video.c cVar2 = this.k;
            C2994b c2994b2 = this.m;
            cVar2.getClass();
            c2994b2.f.c();
            c2994b2.e.a(surface, c2994b2.b);
            this.o = 7;
        }
    }

    @Override // com.five_corp.ad.internal.movie.G
    public final void a(boolean z) {
        this.n.post(new RunnableC2990l(this, new t(this, z)));
    }
}
