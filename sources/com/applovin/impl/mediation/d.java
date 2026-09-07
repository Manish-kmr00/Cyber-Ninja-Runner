package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.b6;
import com.applovin.impl.g5;
import com.applovin.impl.i;
import com.applovin.impl.k7;
import com.applovin.impl.n5;
import com.applovin.impl.o3;
import com.applovin.impl.p3;
import com.applovin.impl.q2;
import com.applovin.impl.q3;
import com.applovin.impl.r3;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t5;
import com.applovin.impl.v2;
import com.applovin.impl.v4;
import com.applovin.impl.x2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes11.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f536a;
    private final Map b = new HashMap(4);
    private final Object c = new Object();
    private final Map d = new HashMap(4);
    private final Object e = new Object();
    private final Map f = new HashMap();
    private final Object g = new Object();

    class a implements n5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f537a;
        final /* synthetic */ Map b;
        final /* synthetic */ String c;
        final /* synthetic */ x2 d;
        final /* synthetic */ Context e;
        final /* synthetic */ com.applovin.impl.mediation.ads.a.InterfaceC0135a f;

        a(long j, Map map, String str, x2 x2Var, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
            this.f537a = j;
            this.b = map;
            this.c = str;
            this.d = x2Var;
            this.e = context;
            this.f = interfaceC0135a;
        }

        @Override // com.applovin.impl.n5.b
        public void a(JSONArray jSONArray) {
            this.b.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f537a));
            this.b.put("calfc", Integer.valueOf(d.this.b(this.c)));
            t5 t5Var = new t5(this.d, jSONArray, this.e, d.this.f536a, this.f);
            if (((Boolean) d.this.f536a.a(o3.e8)).booleanValue()) {
                d.this.f536a.r0().a((g5) t5Var, b6.b.MEDIATION);
            } else {
                d.this.f536a.r0().a(t5Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements com.applovin.impl.mediation.ads.a.InterfaceC0135a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f538a;
        private final WeakReference b;
        private final d c;
        private final c d;
        private final MaxAdFormat e;
        private final Map f;
        private final Map g;
        private final Map h;
        private final int i;
        private long j;
        private long k;

        /* synthetic */ b(Map map, Map map2, Map map3, c cVar, MaxAdFormat maxAdFormat, long j, long j2, d dVar, k kVar, Context context, a aVar) {
            this(map, map2, map3, cVar, maxAdFormat, j, j2, dVar, kVar, context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, String str) {
            this.g.put("retry_delay_sec", Integer.valueOf(i));
            this.g.put("retry_attempt", Integer.valueOf(this.d.c));
            Context contextO = (Context) this.b.get();
            if (contextO == null) {
                contextO = k.o();
            }
            this.h.put("art", i.EXPONENTIAL_RETRY.b());
            this.h.put("era", Integer.valueOf(this.d.c));
            this.k = System.currentTimeMillis();
            this.c.a(str, this.e, this.f, this.g, this.h, contextO, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            this.c.c(str);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.j;
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) maxError.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f538a.X().processWaterfallInfoPostback(maxAdWaterfallInfoImpl, maxError, this.k, jElapsedRealtime);
            }
            boolean z = maxError.getCode() == -5603 && k7.c(this.f538a) && ((Boolean) this.f538a.a(v4.o6)).booleanValue();
            if (this.f538a.a(o3.Y7, this.e) && this.d.c < this.i && !z) {
                c.e(this.d);
                final int iPow = (int) Math.pow(2.0d, this.d.c);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.d$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(iPow, str);
                    }
                }, TimeUnit.SECONDS.toMillis(iPow));
                return;
            }
            this.d.c = 0;
            this.d.b.set(false);
            if (this.d.d != null) {
                MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError;
                maxErrorImpl.setLoadTag(this.d.f539a);
                maxErrorImpl.setRequestLatencyMillis(jElapsedRealtime);
                q2.a(this.d.d, str, maxError);
                this.d.d = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            v2 v2Var = (v2) maxAd;
            v2Var.i(this.d.f539a);
            v2Var.a(SystemClock.elapsedRealtime() - this.j);
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) v2Var.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f538a.X().processWaterfallInfoPostback(maxAdWaterfallInfoImpl, null, this.k, v2Var.getRequestLatencyMillis());
            }
            this.c.a(maxAd.getAdUnitId());
            this.d.c = 0;
            if (this.d.d == null) {
                this.c.a(v2Var);
                this.d.b.set(false);
                return;
            }
            v2Var.A().c().a(this.d.d);
            this.d.d.onAdLoaded(v2Var);
            if (v2Var.N().endsWith("load")) {
                this.d.d.onAdRevenuePaid(v2Var);
            }
            this.d.d = null;
            if ((!this.f538a.c(o3.U7).contains(maxAd.getAdUnitId()) && !this.f538a.a(o3.T7, maxAd.getFormat())) || this.f538a.t0().c() || this.f538a.t0().d()) {
                this.d.b.set(false);
                return;
            }
            Context contextO = (Context) this.b.get();
            if (contextO == null) {
                contextO = k.o();
            }
            this.j = SystemClock.elapsedRealtime();
            this.k = System.currentTimeMillis();
            this.h.put("art", i.SEQUENTIAL_OR_PRECACHE.b());
            this.c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f, this.g, this.h, contextO, this);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        private b(Map map, Map map2, Map map3, c cVar, MaxAdFormat maxAdFormat, long j, long j2, d dVar, k kVar, Context context) {
            this.f538a = kVar;
            this.b = new WeakReference(context);
            this.c = dVar;
            this.d = cVar;
            this.e = maxAdFormat;
            this.g = map2;
            this.f = map;
            this.h = map3;
            this.j = j;
            this.k = j2;
            if (CollectionUtils.getBoolean(map2, "disable_auto_retries")) {
                this.i = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.i = Math.min(2, ((Integer) kVar.a(o3.X7)).intValue());
            } else {
                this.i = ((Integer) kVar.a(o3.X7)).intValue();
            }
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f539a;
        private final AtomicBoolean b;
        private int c;
        private volatile com.applovin.impl.mediation.ads.a.InterfaceC0135a d;

        /* synthetic */ c(String str, a aVar) {
            this(str);
        }

        static /* synthetic */ int e(c cVar) {
            int i = cVar.c;
            cVar.c = i + 1;
            return i;
        }

        private c(String str) {
            this.b = new AtomicBoolean();
            this.f539a = str;
        }
    }

    public d(k kVar) {
        this.f536a = kVar;
    }

    private v2 e(String str) {
        v2 v2Var;
        synchronized (this.e) {
            v2Var = (v2) this.d.get(str);
            this.d.remove(str);
        }
        return v2Var;
    }

    public void c(String str, String str2) {
        synchronized (this.c) {
            this.b.remove(b(str, str2));
        }
    }

    public boolean d(String str) {
        boolean z;
        synchronized (this.e) {
            z = this.d.get(str) != null;
        }
        return z;
    }

    private String b(String str, String str2) {
        return str + (str2 != null ? "-" + str2 : "");
    }

    public int b(String str) {
        int iIntValue;
        synchronized (this.g) {
            Integer num = (Integer) this.f.get(str);
            iIntValue = num != null ? num.intValue() : 0;
        }
        return iIntValue;
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, i iVar, Map map, Map map2, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        v2 v2VarE = (this.f536a.t0().d() || k7.h(k.o())) ? null : e(str);
        if (v2VarE != null) {
            v2VarE.i(str2);
            v2VarE.A().c().a(interfaceC0135a);
            interfaceC0135a.onAdLoaded(v2VarE);
            if (v2VarE.N().endsWith("load")) {
                interfaceC0135a.onAdRevenuePaid(v2VarE);
            }
        }
        c cVarA = a(str, str2);
        if (!cVarA.b.compareAndSet(false, true)) {
            if (cVarA.d != null && cVarA.d != interfaceC0135a) {
                o.j("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
            }
            cVarA.d = interfaceC0135a;
            return;
        }
        if (v2VarE == null) {
            cVarA.d = interfaceC0135a;
        }
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        mapSynchronizedMap.put("art", iVar.b());
        if (StringUtils.isValidString(str2)) {
            mapSynchronizedMap.put("alt", str2);
        }
        a(str, maxAdFormat, map, map2, mapSynchronizedMap, context, new b(map, map2, mapSynchronizedMap, cVarA, maxAdFormat, SystemClock.elapsedRealtime(), System.currentTimeMillis(), this, this.f536a, context, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        synchronized (this.g) {
            this.f536a.O();
            if (o.a()) {
                this.f536a.O().a("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
            }
            Integer num = (Integer) this.f.get(str);
            if (num == null) {
                num = 0;
            }
            this.f.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        x2 x2Var = new x2(str, maxAdFormat, map, map2, map3, a(str, maxAdFormat));
        this.f536a.r0().a((g5) new n5(x2Var, context, this.f536a, new a(jElapsedRealtime, map3, str, x2Var, context, interfaceC0135a)), b6.b.MEDIATION);
    }

    private com.applovin.impl.h a(String str, MaxAdFormat maxAdFormat) {
        if (((Boolean) this.f536a.a(v4.C4)).booleanValue()) {
            r3 r3VarY = this.f536a.Y();
            p3 p3Var = p3.e;
            Map mapA = r3VarY.a(p3Var, q3.a(str));
            p3.a aVar = p3.a.SESSION;
            int iA = a(mapA, aVar);
            p3.a aVar2 = p3.a.INSTALL;
            int iA2 = a(mapA, aVar2);
            Map mapA2 = this.f536a.Y().a(p3Var, q3.a(maxAdFormat));
            return new com.applovin.impl.h(iA, iA2, a(mapA2, aVar), a(mapA2, aVar2));
        }
        return new com.applovin.impl.h(-1, -1, -1, -1);
    }

    private int a(Map map, p3.a aVar) {
        Long l;
        if (map == null || (l = (Long) map.get(aVar.b())) == null) {
            return -1;
        }
        return l.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var) {
        synchronized (this.e) {
            if (this.d.containsKey(v2Var.getAdUnitId())) {
                o.h("AppLovinSdk", "Ad in cache already: " + v2Var.getAdUnitId());
            }
            this.d.put(v2Var.getAdUnitId(), v2Var);
        }
    }

    private c a(String str, String str2) {
        c cVar;
        synchronized (this.c) {
            String strB = b(str, str2);
            cVar = (c) this.b.get(strB);
            if (cVar == null) {
                cVar = new c(str2, null);
                this.b.put(strB, cVar);
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.g) {
            this.f536a.O();
            if (o.a()) {
                this.f536a.O().a("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
            }
            this.f.remove(str);
        }
    }
}
