package com.five_corp.ad.internal.context;

import android.os.Looper;
import com.five_corp.ad.FiveAdConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FiveAdConfig f1359a;
    public final com.five_corp.ad.internal.cache.s b;
    public final com.five_corp.ad.internal.cache.p c;
    public final com.five_corp.ad.internal.time.a d;
    public final com.five_corp.ad.internal.soundstate.e e;
    public final com.five_corp.ad.internal.system.c f;
    public final com.five_corp.ad.internal.http.auxcache.i g;
    public final com.five_corp.ad.internal.http.movcache.h h;

    public g(FiveAdConfig fiveAdConfig, com.five_corp.ad.internal.cache.s sVar, com.five_corp.ad.internal.cache.p pVar, com.five_corp.ad.internal.time.a aVar, com.five_corp.ad.internal.soundstate.e eVar, com.five_corp.ad.internal.system.c cVar, com.five_corp.ad.internal.http.auxcache.i iVar, com.five_corp.ad.internal.http.movcache.h hVar) {
        this.f1359a = fiveAdConfig;
        this.b = sVar;
        this.c = pVar;
        this.d = aVar;
        this.e = eVar;
        this.f = cVar;
        this.g = iVar;
        this.h = hVar;
    }

    public final i a(String str) {
        String string = UUID.randomUUID().toString();
        String str2 = this.f1359a.appId;
        return new i(string, str);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009b  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:48:0x0117  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void a(j jVar, String str, t tVar, h hVar, e eVar, final f fVar) {
        com.five_corp.ad.internal.util.f fVar2;
        com.five_corp.ad.internal.util.f fVar3;
        com.five_corp.ad.internal.beacon.e eVar2;
        Looper looperA;
        com.five_corp.ad.internal.cache.p pVar;
        ArrayList arrayList;
        l lVar;
        com.five_corp.ad.internal.ad.m mVar;
        long j;
        com.five_corp.ad.internal.ad.e eVar3;
        com.five_corp.ad.internal.ad.a aVar = jVar.f1362a;
        com.five_corp.ad.internal.ad.format_config.a aVarA = com.five_corp.ad.internal.ad.a.a(aVar, tVar.f1370a.b);
        if (aVarA == null) {
            fVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.H5, null, null, null));
            return;
        }
        int i = d.f1358a[aVar.f1266a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.I5, "CreativeType: " + aVar.f1266a.value, null, null), null);
            } else {
                int i2 = aVar.F;
                if (i2 == 2) {
                    if (aVar.G == 1) {
                        fVar2 = new com.five_corp.ad.internal.util.f(true, null, com.five_corp.ad.internal.beacon.e.LEGACY_PARTIAL_CACHE_PLAYER);
                    } else {
                        fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.L6, null, null, null), null);
                    }
                } else if (i2 == 1) {
                    fVar2 = aVar.G == 1 ? new com.five_corp.ad.internal.util.f(true, null, com.five_corp.ad.internal.beacon.e.LEGACY_FULL_CACHE_PLAYER) : new com.five_corp.ad.internal.util.f(true, null, com.five_corp.ad.internal.beacon.e.FULL_CACHE_PLAYER);
                } else {
                    fVar2 = new com.five_corp.ad.internal.util.f(true, null, com.five_corp.ad.internal.beacon.e.STREAMING_PLAYER);
                }
            }
            if (!fVar3.f1560a) {
                fVar.a(fVar3.b);
                return;
            }
            eVar2 = (com.five_corp.ad.internal.beacon.e) fVar3.c;
            looperA = this.f.a();
            if (looperA == null) {
                fVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.A0, null, null, null));
                return;
            }
            pVar = this.c;
            arrayList = jVar.f1362a.D;
            synchronized (pVar) {
                HashMap mapA = pVar.f1348a.a(arrayList);
                com.five_corp.ad.internal.cache.q qVar = new com.five_corp.ad.internal.cache.q(mapA);
                pVar.b.f1561a.add(new WeakReference(qVar));
            }
            lVar = new l(jVar, str, tVar, aVarA, hVar, qVar, eVar2, looperA);
            com.five_corp.ad.internal.http.auxcache.i iVar = this.g;
            iVar.f1388a.post(new com.five_corp.ad.internal.http.auxcache.b(iVar, lVar));
            com.five_corp.ad.internal.http.movcache.h hVar2 = this.h;
            hVar2.f1404a.post(new com.five_corp.ad.internal.http.movcache.b(hVar2, lVar));
            if (eVar2 == com.five_corp.ad.internal.beacon.e.FULL_CACHE_PLAYER && eVar2 != com.five_corp.ad.internal.beacon.e.LEGACY_FULL_CACHE_PLAYER) {
                eVar.a(lVar);
                return;
            }
            mVar = aVar.h;
            if (mVar != null || (eVar3 = mVar.b) == null) {
                j = 10000;
            } else {
                j = eVar3.f1287a;
            }
            com.five_corp.ad.internal.time.c cVar = new com.five_corp.ad.internal.time.c(this.d, j, new com.five_corp.ad.internal.time.b() { // from class: com.five_corp.ad.internal.context.g$$ExternalSyntheticLambda0
                @Override // com.five_corp.ad.internal.time.b
                public final void a() {
                    g.a(fVar);
                }
            });
            cVar.c();
            ((com.five_corp.ad.internal.cache.o) Objects.requireNonNull((com.five_corp.ad.internal.cache.o) mapA.get(aVar.k))).a(new c(cVar, eVar, lVar, fVar));
        }
        fVar2 = new com.five_corp.ad.internal.util.f(true, null, com.five_corp.ad.internal.beacon.e.NOT_MOVIE);
        fVar3 = fVar2;
        if (!fVar3.f1560a) {
            fVar.a(fVar3.b);
            return;
        }
        eVar2 = (com.five_corp.ad.internal.beacon.e) fVar3.c;
        looperA = this.f.a();
        if (looperA == null) {
            fVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.A0, null, null, null));
            return;
        }
        pVar = this.c;
        arrayList = jVar.f1362a.D;
        synchronized (pVar) {
            HashMap mapA2 = pVar.f1348a.a(arrayList);
            com.five_corp.ad.internal.cache.q qVar2 = new com.five_corp.ad.internal.cache.q(mapA2);
            pVar.b.f1561a.add(new WeakReference(qVar2));
            lVar = new l(jVar, str, tVar, aVarA, hVar, qVar2, eVar2, looperA);
            com.five_corp.ad.internal.http.auxcache.i iVar2 = this.g;
            iVar2.f1388a.post(new com.five_corp.ad.internal.http.auxcache.b(iVar2, lVar));
            com.five_corp.ad.internal.http.movcache.h hVar3 = this.h;
            hVar3.f1404a.post(new com.five_corp.ad.internal.http.movcache.b(hVar3, lVar));
            if (eVar2 == com.five_corp.ad.internal.beacon.e.FULL_CACHE_PLAYER) {
            }
            mVar = aVar.h;
            if (mVar != null) {
                j = 10000;
            } else {
                j = 10000;
            }
            com.five_corp.ad.internal.time.c cVar2 = new com.five_corp.ad.internal.time.c(this.d, j, new com.five_corp.ad.internal.time.b() { // from class: com.five_corp.ad.internal.context.g$$ExternalSyntheticLambda0
                @Override // com.five_corp.ad.internal.time.b
                public final void a() {
                    g.a(fVar);
                }
            });
            cVar2.c();
            ((com.five_corp.ad.internal.cache.o) Objects.requireNonNull((com.five_corp.ad.internal.cache.o) mapA2.get(aVar.k))).a(new c(cVar2, eVar, lVar, fVar));
        }
    }

    public static void a(f fVar) {
        fVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.P5, null, null, null));
    }
}
