package com.five_corp.ad;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.five_corp.ad.internal.view.D;
import com.five_corp.ad.internal.view.E;
import com.five_corp.ad.internal.view.F;
import com.five_corp.ad.internal.view.G;
import com.five_corp.ad.internal.view.J;
import com.five_corp.ad.internal.w;
import com.five_corp.ad.internal.y;
import com.five_corp.ad.internal.z;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements com.five_corp.ad.internal.system.d, com.five_corp.ad.internal.soundstate.b, com.five_corp.ad.internal.layouter.d, AdActivity.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1259a;
    public final j b;
    public final com.five_corp.ad.internal.view.l c;
    public final com.five_corp.ad.internal.http.auxcache.i e;
    public final com.five_corp.ad.internal.system.b g;
    public final G h;
    public final com.five_corp.ad.internal.viewability.a i;
    public final com.five_corp.ad.internal.context.l l;
    public final com.five_corp.ad.internal.soundstate.c n;
    public final w o;
    public final com.five_corp.ad.internal.handler.a p;
    public final com.five_corp.ad.internal.ad.k q;
    public final com.five_corp.ad.internal.beacon.i s;
    public final com.five_corp.ad.internal.layouter.j w;
    public final com.five_corp.ad.internal.logger.a x;
    public final Object y;
    public boolean j = false;
    public long k = Long.MAX_VALUE;
    public final Object m = new Object();
    public boolean r = false;
    public double t = 0.0d;
    public int u = 1;
    public com.five_corp.ad.internal.fullscreen.c v = null;
    public final com.five_corp.ad.internal.k f = new com.five_corp.ad.internal.k(this);
    public final Handler d = new Handler(Looper.getMainLooper());

    public f(Context context, j jVar, FrameLayout frameLayout, y yVar, com.five_corp.ad.internal.soundstate.c cVar, com.five_corp.ad.internal.context.l lVar, c cVar2) {
        com.five_corp.ad.internal.soundstate.a aVar;
        ArrayList arrayList;
        G e;
        this.f1259a = context;
        this.b = jVar;
        this.l = lVar;
        this.y = cVar2;
        this.x = jVar.b;
        this.e = jVar.x;
        this.g = jVar.w;
        this.n = cVar;
        com.five_corp.ad.internal.media_config.c cVar3 = lVar.d.c;
        synchronized (cVar.f1522a) {
            com.five_corp.ad.internal.soundstate.a aVar2 = cVar.b;
            aVar = new com.five_corp.ad.internal.soundstate.a(aVar2.f1521a, aVar2.b, cVar3.d, aVar2.d);
            cVar.b = aVar;
            com.five_corp.ad.internal.util.h hVar = cVar.c;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((f) ((com.five_corp.ad.internal.soundstate.b) it.next())).b(aVar);
        }
        com.five_corp.ad.internal.soundstate.a aVarA = this.n.a(this);
        com.five_corp.ad.internal.layouter.j jVar2 = new com.five_corp.ad.internal.layouter.j(com.five_corp.ad.internal.layouter.h.a(0, lVar.b.f.intValue(), false, aVarA.a(), false));
        this.w = jVar2;
        Context context2 = this.f1259a;
        com.five_corp.ad.internal.k kVar = this.f;
        com.five_corp.ad.internal.logger.a aVar3 = this.x;
        j jVar3 = this.b;
        com.five_corp.ad.internal.n nVar = jVar3.t;
        com.five_corp.ad.internal.http.movcache.h hVar2 = jVar3.y;
        int i = G.i;
        CreativeType creativeType = lVar.b.f1266a;
        int i2 = F.f1565a[creativeType.ordinal()];
        if (i2 == 1) {
            e = new E(context2, lVar, kVar, this, aVar3, nVar, hVar2);
        } else {
            if (i2 != 2) {
                throw new RuntimeException("Unknown CreativeType: " + creativeType.value);
            }
            e = new D(context2, lVar, kVar, this, aVar3);
        }
        this.h = e;
        e.a(aVarA.a());
        com.five_corp.ad.internal.viewability.a aVar4 = new com.five_corp.ad.internal.viewability.a(this.f1259a, lVar, e);
        this.i = aVar4;
        this.s = new com.five_corp.ad.internal.beacon.i(lVar.b, this.x, this);
        if (frameLayout == null || lVar.e.b == null) {
            this.c = null;
        } else {
            com.five_corp.ad.internal.view.l lVar2 = new com.five_corp.ad.internal.view.l(this.f1259a, this.x, e, this, lVar, lVar.c, aVar4, lVar.e.b, jVar2);
            this.c = lVar2;
            frameLayout.addView(lVar2);
            lVar2.b.a();
            aVar4.f = lVar2;
        }
        j jVar4 = this.b;
        w wVar = new w(yVar, jVar4.q, jVar4.c, this.n, jVar4.u, lVar, jVar4.B.get(), this.b.f1595a);
        this.o = wVar;
        Context context3 = this.f1259a;
        com.five_corp.ad.internal.ad.a aVar5 = lVar.b;
        this.p = new com.five_corp.ad.internal.handler.a(context3, wVar, aVar5.i, this.x);
        this.q = new com.five_corp.ad.internal.ad.k(context3, lVar.f, aVar5.p, aVar5.j, this.b.s, this);
        com.five_corp.ad.internal.system.b bVar = this.g;
        com.five_corp.ad.internal.k kVar2 = this.f;
        bVar.f1541a.f1561a.add(new WeakReference(kVar2));
        if (bVar.b) {
            if (kVar2.c) {
                return;
            }
            kVar2.c = true;
            if (kVar2.b) {
                kVar2.f1412a.m();
                return;
            }
            return;
        }
        boolean z = kVar2.b && kVar2.c;
        if (kVar2.c) {
            kVar2.c = false;
            if (z) {
                kVar2.f1412a.n();
            }
        }
    }

    public static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "com.five_corp.ad");
        p0.startActivity(p1);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void b() {
        int currentPositionMs = this.h.getCurrentPositionMs();
        a(currentPositionMs);
        this.o.q(currentPositionMs, this.t);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void c() {
        this.h.g();
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void d() {
        r();
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void e() {
        k();
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void f() {
        int currentPositionMs = this.h.getCurrentPositionMs();
        this.h.f();
        this.o.r(currentPositionMs, this.t);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void g() {
        this.x.a("PLAY_IN_FULLSCREEN feature is currently not supported (AdController).", 4);
        o();
    }

    public final void h() {
        com.five_corp.ad.internal.system.b bVar = this.g;
        com.five_corp.ad.internal.k kVar = this.f;
        com.five_corp.ad.internal.util.h hVar = bVar.f1541a;
        hVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : hVar.f1561a) {
            Object obj = weakReference.get();
            if (obj != null && obj != kVar) {
                arrayList.add(weakReference);
            }
        }
        hVar.f1561a = arrayList;
        this.h.e();
        com.five_corp.ad.internal.view.l lVar = this.c;
        ViewGroup viewGroup = lVar != null ? (ViewGroup) lVar.getParent() : null;
        J.a(this.c);
        if (viewGroup != null) {
            viewGroup.requestLayout();
        }
        com.five_corp.ad.internal.context.l lVar2 = this.l;
        com.five_corp.ad.internal.context.j jVar = lVar2.f1364a;
        synchronized (jVar) {
            jVar.b = false;
        }
        lVar2.g.b = false;
    }

    public final void i() {
        if (this.v == null) {
            return;
        }
        int currentPositionMs = this.h.getCurrentPositionMs();
        h();
        com.five_corp.ad.internal.fullscreen.c cVar = this.v;
        if (!cVar.m.getAndSet(true)) {
            cVar.g.removeAllViews();
            cVar.k = null;
            cVar.l = null;
            cVar.f1377a.finish();
        }
        this.v = null;
        this.o.m(currentPositionMs, this.t);
    }

    public final void j() {
        if (this.v == null) {
            return;
        }
        int currentPositionMs = this.h.getCurrentPositionMs();
        a(currentPositionMs);
        com.five_corp.ad.internal.fullscreen.c cVar = this.v;
        if (!cVar.m.getAndSet(true)) {
            cVar.g.removeAllViews();
            cVar.k = null;
            cVar.l = null;
            cVar.f1377a.finish();
        }
        this.v = null;
        long j = currentPositionMs;
        this.o.m(j, this.t);
        if (this.l.f == com.five_corp.ad.internal.context.h.VIDEO_REWARD) {
            this.o.t(j, this.t);
        }
    }

    public final void k() {
        int iA;
        w wVar = this.o;
        long currentPositionMs = this.h.getCurrentPositionMs();
        double d = this.t;
        z zVar = wVar.d;
        com.five_corp.ad.internal.beacon.a aVar = new com.five_corp.ad.internal.beacon.a(wVar.g, 20, wVar.e.a(), currentPositionMs, d);
        aVar.m = false;
        String strA = zVar.a(aVar);
        com.five_corp.ad.internal.ad.k kVar = this.q;
        com.five_corp.ad.internal.ad.j jVar = kVar.c;
        if (jVar == null || (iA = e.a(jVar.f1303a.f1288a)) == 0) {
            kVar.a(kVar.d);
        } else {
            if (iA != 1) {
                return;
            }
            kVar.b(strA);
        }
    }

    public final void l() {
        Context context = this.f1259a;
        if (com.five_corp.ad.internal.fullscreen.b.f1376a == null) {
            com.five_corp.ad.internal.fullscreen.b.f1376a = new com.five_corp.ad.internal.fullscreen.a();
        }
        com.five_corp.ad.internal.fullscreen.b.f1376a.a(context, this);
    }

    public final void m() {
        this.h.d();
        if (!this.r) {
            if (!this.j) {
                com.five_corp.ad.internal.http.auxcache.i iVar = this.e;
                iVar.f1388a.post(new com.five_corp.ad.internal.http.auxcache.c(iVar, this.l));
                this.j = true;
            }
            if (this.l.b.l != null) {
                this.k = this.l.b.l.longValue() + SystemClock.uptimeMillis();
            }
        }
        com.five_corp.ad.internal.system.l lVar = this.b.v;
        synchronized (lVar.f1549a) {
            com.five_corp.ad.internal.util.h hVar = lVar.d;
            hVar.getClass();
            ArrayList arrayList = new ArrayList();
            hVar.a(arrayList);
            if (!arrayList.contains(this)) {
                lVar.d.f1561a.add(new WeakReference(this));
                if (lVar.e == null) {
                    Timer timer = new Timer();
                    lVar.e = timer;
                    com.five_corp.ad.internal.system.j jVar = new com.five_corp.ad.internal.system.j(lVar);
                    long j = lVar.c;
                    timer.schedule(jVar, j, j);
                }
            }
        }
    }

    public final void n() {
        this.k = Long.MAX_VALUE;
        this.h.e();
        com.five_corp.ad.internal.system.l lVar = this.b.v;
        synchronized (lVar.f1549a) {
            com.five_corp.ad.internal.util.h hVar = lVar.d;
            hVar.getClass();
            ArrayList arrayList = new ArrayList();
            for (WeakReference weakReference : hVar.f1561a) {
                Object obj = weakReference.get();
                if (obj != null && obj != this) {
                    arrayList.add(weakReference);
                }
            }
            hVar.f1561a = arrayList;
            if (lVar.e != null) {
                com.five_corp.ad.internal.util.h hVar2 = lVar.d;
                hVar2.getClass();
                ArrayList arrayList2 = new ArrayList();
                hVar2.a(arrayList2);
                if (arrayList2.isEmpty()) {
                    lVar.e.cancel();
                    lVar.e = null;
                }
            }
        }
        this.d.post(new Runnable() { // from class: com.five_corp.ad.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        });
    }

    public final void o() {
        int currentPositionMs = this.h.getCurrentPositionMs();
        try {
            this.p.a(currentPositionMs, this.t);
        } catch (Exception e) {
            a(currentPositionMs, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.f4, null, e, null));
        }
    }

    @Override // com.five_corp.ad.AdActivity.Callback
    public final void onAdActivityBackPressed() {
        try {
            if (this.h.c()) {
                j();
            }
        } catch (Exception e) {
            this.x.a(e);
        }
    }

    @Override // com.five_corp.ad.AdActivity.Callback
    public final void onAdActivityDestroy() {
        try {
            if (this.v != null) {
                int currentPositionMs = this.h.getCurrentPositionMs();
                a(currentPositionMs);
                com.five_corp.ad.internal.fullscreen.c cVar = this.v;
                if (!cVar.m.getAndSet(true)) {
                    cVar.g.removeAllViews();
                    cVar.k = null;
                    cVar.l = null;
                    cVar.f1377a.finish();
                }
                this.v = null;
                this.o.l(currentPositionMs, this.t);
            }
            this.o.e();
        } catch (Exception e) {
            this.x.a(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c1 A[PHI: r15
  0x00c1: PHI (r15v1 java.util.Iterator) = (r15v0 java.util.Iterator), (r15v0 java.util.Iterator), (r15v4 java.util.Iterator), (r15v4 java.util.Iterator) binds: [B:45:0x00bf, B:42:0x00b6, B:35:0x00a2, B:32:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e3 A[PHI: r15
  0x00e3: PHI (r15v3 java.util.Iterator) = (r15v0 java.util.Iterator), (r15v0 java.util.Iterator), (r15v4 java.util.Iterator), (r15v4 java.util.Iterator) binds: [B:45:0x00bf, B:42:0x00b6, B:35:0x00a2, B:32:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ee  */
    public final void p() {
        com.five_corp.ad.internal.viewability.b bVar;
        Iterator it;
        long j;
        com.five_corp.ad.internal.ad.beacon.a aVar;
        if (!this.r) {
            if (SystemClock.uptimeMillis() > this.k) {
                a(0, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.c4, null, null, null));
                return;
            }
            return;
        }
        com.five_corp.ad.internal.viewability.a aVar2 = this.i;
        synchronized (aVar2.g) {
            if (aVar2.h) {
                com.five_corp.ad.internal.util.h hVar = aVar2.i;
                hVar.getClass();
                HashSet hashSet = new HashSet();
                hVar.a(hashSet);
                bVar = aVar2.f != null ? new com.five_corp.ad.internal.viewability.b(aVar2.a(hashSet, aVar2.e), aVar2.a(hashSet, aVar2.f)) : new com.five_corp.ad.internal.viewability.b(aVar2.a(hashSet, aVar2.e), aVar2.a(hashSet, aVar2.e));
            } else {
                bVar = new com.five_corp.ad.internal.viewability.b(0.0d, 0.0d);
            }
        }
        this.t = Math.max(this.t, bVar.f1590a);
        com.five_corp.ad.internal.beacon.i iVar = this.s;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it2 = iVar.f1326a.iterator();
        while (it2.hasNext()) {
            com.five_corp.ad.internal.beacon.d dVar = (com.five_corp.ad.internal.beacon.d) it2.next();
            if (!dVar.f) {
                com.five_corp.ad.internal.ad.beacon.a aVar3 = dVar.b;
                if (aVar3.f1268a != 2) {
                    continue;
                } else {
                    com.five_corp.ad.internal.ad.beacon.j jVar = aVar3.d;
                    int iA = e.a(jVar.f1273a);
                    if (iA == 0) {
                        it = it2;
                        double d = bVar.f1590a;
                        double d2 = jVar.b;
                        if (d2 > 0.0d ? d >= Math.min(d2, 0.99d) : d > 0.0d) {
                            if (dVar.e) {
                                dVar.d += jCurrentTimeMillis - dVar.c;
                            } else {
                                dVar.e = true;
                            }
                            j = dVar.d;
                            aVar = dVar.b;
                            if (j >= aVar.c) {
                                dVar.f = true;
                                dVar.g.a(j, aVar);
                            }
                        } else if (dVar.e) {
                            if (dVar.b.b == 2) {
                                dVar.d = 0L;
                            }
                            dVar.e = false;
                        }
                    } else {
                        if (iA != 1) {
                            throw new RuntimeException();
                        }
                        it = it2;
                        double d3 = bVar.b;
                        double d4 = jVar.b;
                        if (d4 > 0.0d ? d3 >= Math.min(d4, 0.99d) : d3 > 0.0d) {
                            if (dVar.e) {
                                dVar.d += jCurrentTimeMillis - dVar.c;
                            } else {
                                dVar.e = true;
                            }
                            j = dVar.d;
                            aVar = dVar.b;
                            if (j >= aVar.c) {
                                dVar.f = true;
                                dVar.g.a(j, aVar);
                            }
                        } else if (dVar.e) {
                            if (dVar.b.b == 2) {
                                dVar.d = 0L;
                            }
                            dVar.e = false;
                        }
                    }
                    dVar.c = jCurrentTimeMillis;
                    it2 = it;
                }
            }
        }
        this.h.a(bVar);
    }

    public final boolean q() {
        int i;
        synchronized (this.m) {
            i = this.u;
        }
        if (i != 1) {
            a(0, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.d4, null, null, null));
            return false;
        }
        this.d.post(new Runnable() { // from class: com.five_corp.ad.f$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.l();
            }
        });
        return true;
    }

    public final void r() {
        com.five_corp.ad.internal.soundstate.a aVar;
        ArrayList arrayList;
        com.five_corp.ad.internal.soundstate.c cVar = this.n;
        boolean zA = cVar.a().a();
        synchronized (cVar.f1522a) {
            com.five_corp.ad.internal.soundstate.a aVar2 = cVar.b;
            aVar = new com.five_corp.ad.internal.soundstate.a(!zA ? 2 : 3, aVar2.b, aVar2.c, aVar2.d);
            cVar.b = aVar;
            com.five_corp.ad.internal.util.h hVar = cVar.c;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((f) ((com.five_corp.ad.internal.soundstate.b) it.next())).b(aVar);
        }
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.five_corp.ad.c, java.lang.Object] */
    public final void a(int i) {
        int i2;
        synchronized (this.m) {
            i2 = this.u;
            if (i2 == 1 || i2 == 3) {
                this.u = 2;
            }
        }
        if (i2 != 1 && i2 != 3) {
            a(i, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.a4, "CurrentState: ".concat(d.a(i2)), null, null));
        } else {
            h();
            this.y.onAdControllerClose();
        }
    }

    public final void b(final com.five_corp.ad.internal.soundstate.a aVar) {
        this.d.post(new Runnable() { // from class: com.five_corp.ad.f$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(aVar);
            }
        });
    }

    public final void a(com.five_corp.ad.internal.soundstate.a aVar) {
        boolean zA = aVar.a();
        this.h.a(zA);
        com.five_corp.ad.internal.layouter.j jVar = this.w;
        com.five_corp.ad.internal.layouter.h hVar = jVar.b;
        jVar.a(com.five_corp.ad.internal.layouter.h.a(hVar.f1419a, hVar.c, hVar.e, zA, hVar.g));
    }

    public final void b(String str) {
        w wVar = this.o;
        long currentPositionMs = this.h.getCurrentPositionMs();
        double d = this.t;
        wVar.getClass();
        wVar.a(15, currentPositionMs, d, null, Collections.singletonMap("to", str));
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.f1259a, intent);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void a(String str) {
        b(str);
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void a() {
        o();
    }

    @Override // com.five_corp.ad.internal.layouter.d
    public final void a(com.five_corp.ad.internal.o oVar) {
        a(this.h.getCurrentPositionMs(), oVar);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.five_corp.ad.c, java.lang.Object] */
    public final void a(int i, com.five_corp.ad.internal.o oVar) {
        synchronized (this.m) {
            if (this.u == 3) {
                return;
            }
            this.u = 3;
            this.o.b(oVar, i);
            this.d.post(new Runnable() { // from class: com.five_corp.ad.f$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i();
                }
            });
            this.y.onAdControllerError();
        }
    }
}
