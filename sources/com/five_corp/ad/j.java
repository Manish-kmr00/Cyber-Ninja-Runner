package com.five_corp.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.preference.PreferenceManager;
import com.five_corp.ad.internal.B;
import com.five_corp.ad.internal.C;
import com.five_corp.ad.internal.C2974a;
import com.five_corp.ad.internal.C2975b;
import com.five_corp.ad.internal.E;
import com.five_corp.ad.internal.cache.s;
import com.five_corp.ad.internal.cache.w;
import com.five_corp.ad.internal.cache.x;
import com.five_corp.ad.internal.q;
import com.five_corp.ad.internal.r;
import com.five_corp.ad.internal.v;
import com.five_corp.ad.internal.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements com.five_corp.ad.internal.hub.d {
    public final com.five_corp.ad.internal.system.h A;
    public final AtomicBoolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.hub.a f1595a;
    public final com.five_corp.ad.internal.logger.a b;
    public final z c;
    public final com.five_corp.ad.internal.l d;
    public final com.five_corp.ad.internal.context.k e;
    public final r f;
    public final com.five_corp.ad.internal.storage.d g;
    public final FiveAdConfig h;
    public final s i;
    public final w j;
    public final com.five_corp.ad.internal.context.g k;
    public final com.five_corp.ad.internal.adselector.a l;
    public final String m;
    public final com.five_corp.ad.internal.bgtask.b n;
    public final com.five_corp.ad.internal.bgtask.b o;
    public final com.five_corp.ad.internal.soundstate.e p;
    public final B q;
    public final com.five_corp.ad.internal.j r;
    public final E s;
    public final com.five_corp.ad.internal.n t;
    public final com.five_corp.ad.internal.time.a u;
    public final com.five_corp.ad.internal.system.l v;
    public final com.five_corp.ad.internal.system.b w;
    public final com.five_corp.ad.internal.http.auxcache.i x;
    public final com.five_corp.ad.internal.http.movcache.h y;
    public final com.five_corp.ad.internal.context.s z;

    public j(Context context, FiveAdConfig fiveAdConfig, com.five_corp.ad.internal.hub.a aVar) {
        com.five_corp.ad.internal.time.a aVar2 = new com.five_corp.ad.internal.time.a();
        com.five_corp.ad.internal.logger.a aVar3 = new com.five_corp.ad.internal.logger.a(aVar);
        com.five_corp.ad.internal.http.connection.b bVar = new com.five_corp.ad.internal.http.connection.b();
        com.five_corp.ad.internal.storage.j jVar = new com.five_corp.ad.internal.storage.j(context.getApplicationContext().getFilesDir(), aVar3);
        Context applicationContext = context.getApplicationContext();
        this.f1595a = aVar;
        FiveAdConfig fiveAdConfigDeepCopy = fiveAdConfig.deepCopy();
        this.h = fiveAdConfigDeepCopy;
        C cA = C.a(applicationContext);
        this.b = aVar3;
        com.five_corp.ad.internal.l lVar = new com.five_corp.ad.internal.l();
        this.d = lVar;
        Random random = new Random();
        com.five_corp.ad.internal.system.c cVar = new com.five_corp.ad.internal.system.c("player");
        com.five_corp.ad.internal.system.c cVar2 = new com.five_corp.ad.internal.system.c("io");
        com.five_corp.ad.internal.soundstate.e eVar = new com.five_corp.ad.internal.soundstate.e(fiveAdConfigDeepCopy.f1245a, aVar);
        this.p = eVar;
        E e = new E(applicationContext);
        this.s = e;
        com.five_corp.ad.internal.http.d dVar = new com.five_corp.ad.internal.http.d(bVar);
        this.u = aVar2;
        com.five_corp.ad.internal.bgtask.b bVar2 = new com.five_corp.ad.internal.bgtask.b(1, aVar2, aVar3);
        this.n = bVar2;
        com.five_corp.ad.internal.bgtask.b bVar3 = new com.five_corp.ad.internal.bgtask.b(3, aVar2, aVar3);
        this.o = bVar3;
        com.five_corp.ad.internal.storage.d dVar2 = new com.five_corp.ad.internal.storage.d(jVar, new com.five_corp.ad.internal.storage.p(random), cVar2, aVar3);
        this.g = dVar2;
        this.m = "20250110:" + fiveAdConfigDeepCopy.appId + ":" + fiveAdConfigDeepCopy.isTest;
        com.five_corp.ad.internal.context.k kVar = new com.five_corp.ad.internal.context.k();
        this.e = kVar;
        r rVar = new r(applicationContext.getFilesDir());
        this.f = rVar;
        com.five_corp.ad.internal.base_url.a aVar4 = new com.five_corp.ad.internal.base_url.a(aVar);
        com.five_corp.ad.internal.tracking_data.b bVar4 = new com.five_corp.ad.internal.tracking_data.b(applicationContext);
        com.five_corp.ad.internal.system.e eVar2 = new com.five_corp.ad.internal.system.e(applicationContext);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        if (defaultSharedPreferences.contains("IABTCF_TCString")) {
            defaultSharedPreferences.getString("IABTCF_TCString", "");
        }
        if (defaultSharedPreferences.contains("IABTCF_gdprApplies")) {
            defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
        }
        com.five_corp.ad.internal.tracking_data.e eVar3 = new com.five_corp.ad.internal.tracking_data.e(applicationContext, new com.five_corp.ad.internal.tracking_data.d());
        PreferenceManager.getDefaultSharedPreferences(applicationContext).registerOnSharedPreferenceChangeListener(eVar3);
        z zVar = new z(aVar4, cA, fiveAdConfigDeepCopy, e, aVar2, new com.five_corp.ad.internal.context.n(eVar2, eVar3), bVar4);
        this.c = zVar;
        com.five_corp.ad.internal.http.auxcache.i iVar = new com.five_corp.ad.internal.http.auxcache.i(aVar3, dVar2, bVar);
        this.x = iVar;
        com.five_corp.ad.internal.http.movcache.h hVar = new com.five_corp.ad.internal.http.movcache.h(dVar2, bVar, aVar);
        this.y = hVar;
        x xVar = new x(new C2974a(new ArrayList()), null, 0L);
        s sVar = new s(xVar, aVar);
        this.i = sVar;
        com.five_corp.ad.internal.cache.p pVar = new com.five_corp.ad.internal.cache.p(dVar2);
        w wVar = new w(sVar, rVar, pVar, aVar2);
        this.j = wVar;
        B b = new B(zVar, dVar, bVar2, bVar3, aVar);
        this.q = b;
        com.five_corp.ad.internal.context.g gVar = new com.five_corp.ad.internal.context.g(fiveAdConfigDeepCopy, sVar, pVar, aVar2, eVar, cVar, iVar, hVar);
        this.k = gVar;
        this.t = new com.five_corp.ad.internal.n(wVar);
        com.five_corp.ad.internal.j jVar2 = new com.five_corp.ad.internal.j(gVar, zVar, wVar, bVar2, dVar, lVar, xVar, aVar);
        this.r = jVar2;
        com.five_corp.ad.internal.context.s sVar2 = new com.five_corp.ad.internal.context.s(aVar2, bVar4, aVar);
        this.z = sVar2;
        this.l = new com.five_corp.ad.internal.adselector.a(gVar, kVar, b, jVar2, sVar2);
        this.v = new com.five_corp.ad.internal.system.l();
        com.five_corp.ad.internal.system.b bVar5 = new com.five_corp.ad.internal.system.b();
        new Handler(Looper.getMainLooper()).post(new com.five_corp.ad.internal.system.a(bVar5));
        this.w = bVar5;
        this.A = new com.five_corp.ad.internal.system.h(applicationContext, aVar3, aVar);
        this.B = new AtomicBoolean(false);
        HandlerThread handlerThread = new HandlerThread("FetchAdIdHandlerThread");
        handlerThread.start();
        new Handler(handlerThread.getLooper());
        hVar.e.f1409a.a(hVar);
        aVar.f1409a.a(eVar);
        b.e.f1409a.a(b);
        b.e.b.a(b);
        aVar.f1409a.a(aVar4);
        aVar.f1409a.a(jVar2);
        sVar2.c.f1409a.a(sVar2);
    }

    public final com.five_corp.ad.internal.util.g a() {
        try {
            com.five_corp.ad.internal.util.g gVarB = this.g.b(this.m);
            if (!gVarB.f1560a) {
                return gVarB;
            }
            com.five_corp.ad.internal.util.g gVarB2 = b();
            if (!gVarB2.f1560a) {
                return gVarB2;
            }
            this.f1595a.c.a(this);
            this.A.b();
            com.five_corp.ad.internal.util.f fVarA = this.s.a();
            if (!fVarA.f1560a) {
                return new com.five_corp.ad.internal.util.g(false, fVarA.b);
            }
            int iIntValue = ((Integer) fVarA.c).intValue();
            return (4300000 > iIntValue || iIntValue >= 4400000) ? new com.five_corp.ad.internal.util.g(true, null) : new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.I, "Google Play Services version " + iIntValue + " has a bug.", null, null));
        } catch (Throwable th) {
            return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.j, null, th, null));
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00af A[EDGE_INSN: B:34:0x00af->B:36:0x00b9 BREAK  A[LOOP:4: B:24:0x007c->B:28:0x008d], PHI: r4
  0x00af: PHI (r4v9 com.five_corp.ad.internal.util.g) = (r4v8 com.five_corp.ad.internal.util.g), (r4v11 com.five_corp.ad.internal.util.g) binds: [B:30:0x00a0, B:33:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    public final com.five_corp.ad.internal.util.g b() throws Throwable {
        com.five_corp.ad.internal.util.g gVar;
        com.five_corp.ad.internal.util.f fVar;
        com.five_corp.ad.internal.util.f fVar2;
        com.five_corp.ad.internal.util.f fVar3;
        com.five_corp.ad.internal.util.f fVar4;
        com.five_corp.ad.internal.util.f fVar5;
        this.u.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = this.f.f1519a;
        com.five_corp.ad.internal.util.g gVar2 = (file.exists() || (file.mkdirs() && file.setReadable(true, false) && file.setWritable(true, false) && file.setExecutable(true, false))) ? new com.five_corp.ad.internal.util.g(true, null) : com.five_corp.ad.internal.util.g.a(com.five_corp.ad.internal.p.w);
        if (!gVar2.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, gVar2.b);
        }
        r rVar = this.f;
        com.five_corp.ad.internal.util.f fVarD = rVar.d("sdk.version");
        if (fVarD.f1560a && new String((byte[]) fVarD.c).trim().equals(String.valueOf(BuildConfig.SEMVER_PATCH))) {
            gVar = new com.five_corp.ad.internal.util.g(true, null);
        } else {
            File[] fileArrListFiles = rVar.f1519a.listFiles();
            int length = fileArrListFiles.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    com.five_corp.ad.internal.util.g gVarA = rVar.a("sdk.version", String.valueOf(BuildConfig.SEMVER_PATCH).getBytes());
                    if (!gVarA.f1560a) {
                        rVar.a("sdk.version");
                        gVar = gVarA;
                        break;
                    }
                    gVarA = rVar.a("sdk.version_SUCCESS", new byte[0]);
                    if (!gVarA.f1560a) {
                        rVar.a("sdk.version");
                        gVar = gVarA;
                        break;
                    }
                    gVar = new com.five_corp.ad.internal.util.g(true, null);
                    break;
                }
                if (!fileArrListFiles[i].delete()) {
                    gVar = com.five_corp.ad.internal.util.g.a(com.five_corp.ad.internal.p.w);
                    break;
                }
                i++;
            }
        }
        if (!gVar.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, gVar.b);
        }
        r rVar2 = this.f;
        rVar2.getClass();
        ArrayList<com.five_corp.ad.internal.ad.a> arrayList = new ArrayList();
        for (File file2 : rVar2.f1519a.listFiles()) {
            String name = file2.getName();
            if (name.endsWith("response.json")) {
                com.five_corp.ad.internal.util.f fVarD2 = rVar2.d(name);
                if (fVarD2.f1560a) {
                    try {
                        arrayList.add(com.five_corp.ad.internal.parser.b.a(new JSONObject(new String((byte[]) fVarD2.c))));
                    } catch (com.five_corp.ad.internal.exception.b | JSONException e) {
                        Log.getStackTraceString(e);
                        rVar2.a(name);
                    }
                } else {
                    Objects.toString(fVarD2.b.f1517a);
                    rVar2.a(name);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (com.five_corp.ad.internal.ad.a aVar : arrayList) {
            if (v.a(aVar, jCurrentTimeMillis)) {
                arrayList2.add(aVar);
            } else {
                r rVar3 = this.f;
                rVar3.getClass();
                rVar3.a(aVar.b + ".response.json");
            }
        }
        r rVar4 = this.f;
        rVar4.getClass();
        C2975b c2975b = new C2975b(new com.five_corp.ad.internal.media_config.a("{\"ds\":[],\"sn\":false,\"rmcl\":false}", new ArrayList(), false, 250000, 1800000L, false, false, Collections.emptyList(), new com.five_corp.ad.internal.media_config.b()));
        String[] list = rVar4.f1519a.list(new q());
        ArrayList arrayList3 = new ArrayList();
        int length2 = list.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                fVar = new com.five_corp.ad.internal.util.f(true, null, arrayList3);
                break;
            }
            try {
                fVar5 = new com.five_corp.ad.internal.util.f(true, null, Long.valueOf(Long.parseLong(list[i2].replace("adcfg-", "").replace(".json", ""))));
            } catch (NumberFormatException e2) {
                fVar5 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.z3, "failed to parse timestamp in filename", e2, null), null);
            }
            if (!fVar5.f1560a) {
                fVar = new com.five_corp.ad.internal.util.f(false, fVar5.b, null);
                break;
            }
            arrayList3.add((Long) fVar5.c);
            i2++;
        }
        if (fVar.f1560a) {
            Iterator it = ((List) fVar.c).iterator();
            long jLongValue = 0;
            while (true) {
                if (!it.hasNext()) {
                    fVar2 = new com.five_corp.ad.internal.util.f(true, null, new com.five_corp.ad.internal.util.d(Long.valueOf(jLongValue), c2975b));
                    break;
                }
                Long l = (Long) it.next();
                if (l.longValue() <= jLongValue) {
                    rVar4.a(r.a(l.longValue()));
                }
                long jLongValue2 = l.longValue();
                com.five_corp.ad.internal.util.f fVarD3 = rVar4.d(r.a(jLongValue2));
                if (fVarD3.f1560a) {
                    try {
                        fVar3 = new com.five_corp.ad.internal.util.f(true, null, new C2975b(com.five_corp.ad.internal.parser.h.a(new JSONObject(new String((byte[]) fVarD3.c)).getJSONObject("mcfg"))));
                    } catch (com.five_corp.ad.internal.exception.b e3) {
                        fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(e3.f1373a, null, e3, null), null);
                    } catch (JSONException e4) {
                        fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.y3, "failed to deserialize AdConfig", e4, null), null);
                    }
                    fVar4 = fVar3;
                } else {
                    rVar4.a(r.a(jLongValue2));
                    fVar4 = new com.five_corp.ad.internal.util.f(false, fVarD3.b, null);
                }
                if (!fVar4.f1560a) {
                    fVar2 = new com.five_corp.ad.internal.util.f(false, fVar4.b, null);
                    break;
                }
                C2975b c2975b2 = (C2975b) fVar4.c;
                rVar4.a(r.a(jLongValue));
                jLongValue = l.longValue();
                c2975b = c2975b2;
            }
        } else {
            fVar2 = new com.five_corp.ad.internal.util.f(false, fVar.b, null);
        }
        if (!fVar2.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, fVar2.b);
        }
        com.five_corp.ad.internal.util.d dVar = (com.five_corp.ad.internal.util.d) fVar2.c;
        Long l2 = dVar.f1558a;
        x xVar = new x(new C2974a(arrayList2), dVar.b.f1317a, l2.longValue());
        w wVar = this.j;
        long jLongValue3 = l2.longValue();
        synchronized (wVar.e) {
            wVar.f = jLongValue3;
        }
        wVar.f1354a.a(new com.five_corp.ad.internal.cache.v(xVar));
        com.five_corp.ad.internal.http.auxcache.i iVar = this.x;
        iVar.f1388a.post(new com.five_corp.ad.internal.http.auxcache.a(iVar, arrayList2));
        com.five_corp.ad.internal.http.movcache.h hVar = this.y;
        hVar.f1404a.post(new com.five_corp.ad.internal.http.movcache.a(hVar, arrayList2));
        return new com.five_corp.ad.internal.util.g(true, null);
    }
}
