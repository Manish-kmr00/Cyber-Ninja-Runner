package com.five_corp.ad.internal;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.FiveAdViewEventListener;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public final class w {
    public final y b;
    public final B c;
    public final z d;
    public final com.five_corp.ad.internal.soundstate.c e;
    public final com.five_corp.ad.internal.time.a f;
    public final com.five_corp.ad.internal.context.l g;
    public final boolean i;
    public final com.five_corp.ad.internal.hub.a j;
    public final EnumMap h = new EnumMap(com.five_corp.ad.internal.ad.beacon.e.class);
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1591a = new Handler(Looper.getMainLooper());
    public int k = 1;

    public w(y yVar, B b, z zVar, com.five_corp.ad.internal.soundstate.c cVar, com.five_corp.ad.internal.time.a aVar, com.five_corp.ad.internal.context.l lVar, boolean z, com.five_corp.ad.internal.hub.a aVar2) {
        this.b = yVar;
        this.c = b;
        this.d = zVar;
        this.e = cVar;
        this.f = aVar;
        this.g = lVar;
        this.i = z;
        this.j = aVar2;
    }

    public final com.five_corp.ad.internal.beacon.a a(long j, double d, boolean z) {
        com.five_corp.ad.internal.beacon.a aVar = new com.five_corp.ad.internal.beacon.a(this.g, 3, this.e.a(), j, d);
        aVar.m = z;
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void b() {
        if (this.i && !this.o) {
            y yVar = this.b;
            FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
            if (fiveAdViewEventListener != 0) {
                fiveAdViewEventListener.onFiveAdClick(yVar.f1593a);
            }
            g gVar = (g) yVar.d.get();
            if (gVar != null) {
                gVar.d();
            }
        }
        a(com.five_corp.ad.internal.ad.beacon.e.CLICK_BEACON);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void c(long j, double d) {
        com.five_corp.ad.internal.context.l lVar = this.g;
        this.f.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (lVar) {
            lVar.k = jCurrentTimeMillis;
        }
        a(1, j, d, this.g.b.z.b, null);
        a(com.five_corp.ad.internal.ad.beacon.e.IMPRESSION);
        if (this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdImpression(yVar.f1593a);
        }
        g gVar = (g) yVar.d.get();
        if (gVar != null) {
            gVar.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void d(long j, double d) {
        a(7, j, d, null, null);
        a(com.five_corp.ad.internal.ad.beacon.e.PAUSE);
        if (this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdPause(yVar.f1593a);
        }
        g gVar = (g) yVar.d.get();
        if (gVar != null) {
            gVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void e(long j, double d) {
        a(18, j, d, null, null);
        if (this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdRecover(yVar.f1593a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void f(long j, double d) {
        a(6, j, d, null, null);
        a(com.five_corp.ad.internal.ad.beacon.e.CLOSE);
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdClose(yVar.f1593a);
        }
        m mVar = (m) this.b.f.get();
        if (mVar != null) {
            mVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void g(long j, double d) {
        a(9, j, d, null, null);
        a(com.five_corp.ad.internal.ad.beacon.e.REWIND);
        if (!this.o) {
            y yVar = this.b;
            FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
            if (fiveAdViewEventListener != 0) {
                fiveAdViewEventListener.onFiveAdReplay(yVar.f1593a);
            }
            g gVar = (g) yVar.d.get();
            if (gVar != null) {
                gVar.a();
            }
        }
        this.k = 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void h(long j, double d) {
        int iA = com.five_corp.ad.e.a(this.k);
        if (iA != 0) {
            if (iA == 1) {
                a(8, j, d, null, null);
                a(com.five_corp.ad.internal.ad.beacon.e.RESUME);
                if (!this.o) {
                    y yVar = this.b;
                    FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
                    if (fiveAdViewEventListener != 0) {
                        fiveAdViewEventListener.onFiveAdResume(yVar.f1593a);
                    }
                    g gVar = (g) yVar.d.get();
                    if (gVar != null) {
                        gVar.a();
                    }
                }
            }
        } else if (!this.o) {
            y yVar2 = this.b;
            FiveAdViewEventListener fiveAdViewEventListener2 = (FiveAdViewEventListener) yVar2.c.get();
            if (fiveAdViewEventListener2 != 0) {
                fiveAdViewEventListener2.onFiveAdStart(yVar2.f1593a);
            }
            g gVar2 = (g) yVar2.d.get();
            if (gVar2 != null) {
                gVar2.a();
            }
        }
        this.k = 2;
    }

    public final void i(long j, double d) {
        if (this.o || this.n) {
            return;
        }
        this.n = true;
        a(19, j, d, null, null);
        u uVar = (u) this.b.e.get();
        if (uVar != null) {
            uVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void j(long j, double d) {
        a(17, j, d, null, null);
        if (this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdStall(yVar.f1593a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void k(long j, double d) {
        if (!this.l) {
            this.l = true;
            a(2, j, d, null, null);
            a(com.five_corp.ad.internal.ad.beacon.e.VT_100);
        }
        if (this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdViewThrough(yVar.f1593a);
        }
        g gVar = (g) yVar.d.get();
        if (gVar != null) {
            gVar.b();
        }
    }

    public final void l(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, d);
            }
        });
    }

    public final void m(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(j, d);
            }
        });
    }

    public final void n(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(j, d);
            }
        });
    }

    public final void o(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(j, d);
            }
        });
    }

    public final void p(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(j, d);
            }
        });
    }

    public final void q(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f(j, d);
            }
        });
    }

    public final void r(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g(j, d);
            }
        });
    }

    public final void s(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h(j, d);
            }
        });
    }

    public final void t(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.i(j, d);
            }
        });
    }

    public final void u(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j(j, d);
            }
        });
    }

    public final void v(final long j, final double d) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.k(j, d);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void a() {
        if (this.i || this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdClick(yVar.f1593a);
        }
        g gVar = (g) yVar.d.get();
        if (gVar != null) {
            gVar.d();
        }
    }

    public final void a(long j, double d) {
        a(6, j, d, null, null);
        a(com.five_corp.ad.internal.ad.beacon.e.CLOSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void b(long j, double d) {
        a(6, j, d, null, null);
        a(com.five_corp.ad.internal.ad.beacon.e.CLOSE);
        y yVar = this.b;
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdClose(yVar.f1593a);
        }
    }

    public final void d() {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public final void e() {
        Handler handler = this.f1591a;
        final y yVar = this.b;
        Objects.requireNonNull(yVar);
        handler.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                yVar.a();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void a(o oVar, long j) {
        long j2;
        com.five_corp.ad.internal.hub.a aVar = this.j;
        com.five_corp.ad.internal.context.l lVar = this.g;
        com.five_corp.ad.internal.ad.a aVar2 = lVar.b;
        com.five_corp.ad.internal.context.i iVar = lVar.d.f1370a;
        com.five_corp.ad.internal.context.h hVar = lVar.f;
        com.five_corp.ad.internal.soundstate.a aVarA = this.e.a();
        com.five_corp.ad.internal.context.l lVar2 = this.g;
        synchronized (lVar2) {
            j2 = lVar2.k;
        }
        com.five_corp.ad.internal.beacon.b bVar = new com.five_corp.ad.internal.beacon.b(aVar2, iVar, hVar, oVar, aVarA, j, Long.valueOf(j2), this.g.i);
        Iterator it = aVar.b.a().iterator();
        while (it.hasNext()) {
            B b = (B) ((com.five_corp.ad.internal.hub.b) it.next());
            if (!b.f.contains(Integer.valueOf(bVar.d.f1517a.f1518a))) {
                b.c.a(new com.five_corp.ad.internal.bgtask.f(bVar, b.f1262a, b.b));
            }
        }
        a(com.five_corp.ad.internal.ad.beacon.e.ERROR);
        if (this.o) {
            return;
        }
        y yVar = this.b;
        FiveAdErrorCode fiveAdErrorCodeA = oVar.a();
        FiveAdViewEventListener fiveAdViewEventListener = (FiveAdViewEventListener) yVar.c.get();
        if (fiveAdViewEventListener != 0) {
            fiveAdViewEventListener.onFiveAdViewError(yVar.f1593a, fiveAdErrorCodeA);
        }
        g gVar = (g) yVar.d.get();
        if (gVar != null) {
            gVar.a(fiveAdErrorCodeA);
        }
        this.o = true;
    }

    public final void b(final o oVar, final long j) {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(oVar, j);
            }
        });
    }

    public final void f() {
        Handler handler = this.f1591a;
        final y yVar = this.b;
        Objects.requireNonNull(yVar);
        handler.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                yVar.b();
            }
        });
    }

    public final void c() {
        this.f1591a.post(new Runnable() { // from class: com.five_corp.ad.internal.w$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    public final void a(int i, long j, double d, com.five_corp.ad.internal.ad.beacon.a aVar, Map map) {
        com.five_corp.ad.internal.beacon.a aVar2 = new com.five_corp.ad.internal.beacon.a(this.g, i, this.e.a(), j, d);
        aVar2.k = aVar;
        aVar2.l = map;
        this.c.a(aVar2);
    }

    public final void a(com.five_corp.ad.internal.ad.beacon.e eVar) {
        List<com.five_corp.ad.internal.ad.beacon.d> list = this.g.b.x;
        if (list == null) {
            return;
        }
        for (com.five_corp.ad.internal.ad.beacon.d dVar : list) {
            if (dVar.f1269a == eVar) {
                String str = dVar.b;
                if (eVar.b) {
                    B b = this.c;
                    b.d.a(new com.five_corp.ad.internal.bgtask.k(str, b.b));
                } else {
                    Set hashSet = (Set) this.h.get(eVar);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.h.put(eVar, hashSet);
                    }
                    if (hashSet.add(str)) {
                        B b2 = this.c;
                        b2.d.a(new com.five_corp.ad.internal.bgtask.k(str, b2.b));
                    }
                }
            }
        }
    }
}
