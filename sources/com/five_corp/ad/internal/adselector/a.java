package com.five_corp.ad.internal.adselector;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.internal.A;
import com.five_corp.ad.internal.B;
import com.five_corp.ad.internal.ad_check.c;
import com.five_corp.ad.internal.ad_check.e;
import com.five_corp.ad.internal.cache.x;
import com.five_corp.ad.internal.context.g;
import com.five_corp.ad.internal.context.i;
import com.five_corp.ad.internal.context.k;
import com.five_corp.ad.internal.context.l;
import com.five_corp.ad.internal.context.m;
import com.five_corp.ad.internal.context.q;
import com.five_corp.ad.internal.context.r;
import com.five_corp.ad.internal.context.s;
import com.five_corp.ad.internal.context.t;
import com.five_corp.ad.internal.h;
import com.five_corp.ad.internal.j;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.util.f;
import com.five_corp.ad.internal.v;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1316a;
    public final k b;
    public final B c;
    public final j d;
    public final s e;
    public final Handler f = new Handler(Looper.getMainLooper());

    static {
        a.class.toString();
    }

    public a(g gVar, k kVar, B b, j jVar, s sVar) {
        this.f1316a = gVar;
        this.b = kVar;
        this.c = b;
        this.d = jVar;
        this.e = sVar;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(final o oVar, final b bVar) {
        this.f.post(new Runnable() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(oVar, bVar);
            }
        });
    }

    public final void b(o oVar, b bVar) {
        j jVar = this.d;
        if (oVar.a() == FiveAdErrorCode.NO_AD) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (jVar.g) {
                x xVar = jVar.i;
                com.five_corp.ad.internal.media_config.a aVar = xVar.b;
                long j = aVar != null ? aVar.e : 1800000L;
                if (!jVar.h && jCurrentTimeMillis - xVar.c >= j) {
                    jVar.h = true;
                    jVar.d.a(new h(jVar.f1411a, jVar.b, jVar.c, jVar.e, jVar.f, 4, jVar));
                }
            }
        }
        bVar.onFailureToSelectAd(oVar);
    }

    public final /* synthetic */ void d(final b bVar, final o oVar) {
        this.f.post(new Runnable() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onFailureToSelectAd(oVar);
            }
        });
    }

    public final void a(List list, m mVar, b bVar) {
        com.five_corp.ad.internal.ad.format_config.a aVarA;
        int iOrdinal;
        Iterator it = list.iterator();
        o oVar = null;
        while (it.hasNext()) {
            e eVar = (e) it.next();
            com.five_corp.ad.internal.ad.a aVar = eVar.f1313a;
            String str = mVar.b.f1370a.b;
            f fVar = (!v.a(aVar, mVar.d) || com.five_corp.ad.internal.ad.a.a(aVar, str) == null || (aVarA = com.five_corp.ad.internal.ad.a.a(aVar, str)) == null || ((iOrdinal = mVar.f1365a.ordinal()) == 0 || iOrdinal == 1 ? aVarA.b == null : !((iOrdinal == 2 || iOrdinal == 3) && aVarA.c != null))) ? new f(false, new o(p.h0, null, null, null), null) : new f(true, null, eVar.f1313a);
            if (fVar.f1560a) {
                com.five_corp.ad.internal.context.j jVarA = this.b.a((com.five_corp.ad.internal.ad.a) fVar.c);
                if (jVarA != null) {
                    a(jVarA, mVar, bVar);
                    return;
                }
                oVar = new o(p.i0, null, null, null);
            } else {
                oVar = fVar.b;
            }
        }
        if (oVar != null) {
            b(oVar, bVar);
        } else {
            b(new o(p.f0, null, null, null), bVar);
        }
    }

    public final /* synthetic */ void b(final b bVar, final l lVar) {
        this.f.post(new Runnable() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onAdSuccessfullySelected(lVar);
            }
        });
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(final List list, final m mVar, final b bVar) {
        this.f.post(new Runnable() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(list, mVar, bVar);
            }
        });
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(final com.five_corp.ad.internal.context.h hVar, final t tVar, final b bVar, final com.five_corp.ad.internal.soundstate.a aVar) {
        this.f.post(new Runnable() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(hVar, tVar, bVar, aVar);
            }
        });
    }

    public final void a(com.five_corp.ad.internal.context.h hVar, t tVar, final b bVar, com.five_corp.ad.internal.soundstate.a aVar) {
        if (hVar == com.five_corp.ad.internal.context.h.NATIVE && !tVar.c.c) {
            b(new o(p.G5, null, null, null), bVar);
            return;
        }
        final m mVar = new m(hVar, tVar, aVar, System.currentTimeMillis());
        new Thread(new A(this.c, mVar, new com.five_corp.ad.internal.ad_check.b() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda1
            @Override // com.five_corp.ad.internal.ad_check.b
            public final void a(o oVar) {
                this.f$0.b(bVar, oVar);
            }
        }, new c() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda10
            @Override // com.five_corp.ad.internal.ad_check.c
            public final void a(List list) {
                this.f$0.a(mVar, bVar, list);
            }
        })).start();
    }

    public final void a(i iVar, final com.five_corp.ad.internal.context.h hVar, final com.five_corp.ad.internal.soundstate.a aVar, final b bVar) {
        this.e.a(iVar, 10000L, new q() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda8
            @Override // com.five_corp.ad.internal.context.q
            public final void a(t tVar) {
                this.f$0.a(hVar, aVar, bVar, tVar);
            }
        }, new r() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda9
            @Override // com.five_corp.ad.internal.context.r
            public final void a(o oVar) {
                this.f$0.a(bVar, oVar);
            }
        });
    }

    public final void a(com.five_corp.ad.internal.context.j jVar, m mVar, final b bVar) {
        this.f1316a.a(jVar, null, mVar.b, mVar.f1365a, new com.five_corp.ad.internal.context.e() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda6
            @Override // com.five_corp.ad.internal.context.e
            public final void a(l lVar) {
                this.f$0.b(bVar, lVar);
            }
        }, new com.five_corp.ad.internal.context.f() { // from class: com.five_corp.ad.internal.adselector.a$$ExternalSyntheticLambda7
            @Override // com.five_corp.ad.internal.context.f
            public final void a(o oVar) {
                this.f$0.d(bVar, oVar);
            }
        });
    }
}
