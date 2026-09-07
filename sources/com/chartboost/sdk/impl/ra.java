package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ra implements cc.a {
    public static ra i = new ra();
    public static Handler j = new Handler(Looper.getMainLooper());
    public static Handler k = null;
    public static final Runnable l = new d();
    public static final Runnable m = new e();
    public int b;
    public long h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f1127a = new ArrayList();
    public boolean c = false;
    public final List<hc> d = new ArrayList();
    public fc f = new fc();
    public mc e = new mc();
    public oc g = new oc(new xc());

    public interface a extends b {
        void b(int i, long j);
    }

    public interface b {
        void a(int i, long j);
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ra.this.g.b();
        }
    }

    public class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ra.h().m();
        }
    }

    public class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (ra.k != null) {
                ra.k.post(ra.l);
                ra.k.postDelayed(ra.m, 200L);
            }
        }
    }

    public static ra h() {
        return i;
    }

    public final void d() {
        a(id.b() - this.h);
    }

    public final void e() {
        this.b = 0;
        this.d.clear();
        this.c = false;
        Iterator<zb> it = tc.c().a().iterator();
        while (it.hasNext()) {
            if (it.next().i()) {
                this.c = true;
                break;
            }
        }
        this.h = id.b();
    }

    public void f() {
        this.f.e();
        long jB = id.b();
        cc ccVarA = this.e.a();
        if (this.f.b().size() > 0) {
            for (String str : this.f.b()) {
                JSONObject jSONObjectA = ccVarA.a(null);
                a(str, this.f.a(str), jSONObjectA);
                vc.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f.c().size() > 0) {
            JSONObject jSONObjectA2 = ccVarA.a(null);
            a(null, ccVarA, jSONObjectA2, wc.PARENT_VIEW, false);
            vc.b(jSONObjectA2);
            this.g.b(jSONObjectA2, this.f.c(), jB);
            if (this.c) {
                Iterator<zb> it = tc.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.d);
                }
            }
        } else {
            this.g.b();
        }
        this.f.a();
    }

    public void g() {
        l();
    }

    public void i() {
        j();
    }

    public final void j() {
        if (k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            k = handler;
            handler.post(l);
            k.postDelayed(m, 200L);
        }
    }

    public void k() {
        g();
        this.f1127a.clear();
        j.post(new c());
    }

    public final void l() {
        Handler handler = k;
        if (handler != null) {
            handler.removeCallbacks(m);
            k = null;
        }
    }

    public final void m() {
        e();
        f();
        d();
        qd.b().a();
    }

    public final void a(long j2) {
        if (this.f1127a.size() > 0) {
            for (b bVar : this.f1127a) {
                bVar.a(this.b, TimeUnit.NANOSECONDS.toMillis(j2));
                if (bVar instanceof a) {
                    ((a) bVar).b(this.b, j2);
                }
            }
        }
    }

    public final boolean b(View view, JSONObject jSONObject) {
        String strC = this.f.c(view);
        if (strC == null) {
            return false;
        }
        vc.a(jSONObject, strC);
        vc.a(jSONObject, Boolean.valueOf(this.f.e(view)));
        vc.b(jSONObject, Boolean.valueOf(this.f.c(strC)));
        this.f.d();
        return true;
    }

    public final void a(View view, cc ccVar, JSONObject jSONObject, wc wcVar, boolean z) {
        ccVar.a(view, jSONObject, this, wcVar == wc.PARENT_VIEW, z);
    }

    @Override // com.chartboost.sdk.impl.cc.a
    public void a(View view, cc ccVar, JSONObject jSONObject, boolean z) {
        wc wcVarD;
        if (od.f(view) && (wcVarD = this.f.d(view)) != wc.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = ccVar.a(view);
            vc.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z2 = z || a(view, jSONObjectA);
                if (this.c && wcVarD == wc.OBSTRUCTION_VIEW && !z2) {
                    this.d.add(new hc(view));
                }
                a(view, ccVar, jSONObjectA, wcVarD, z2);
            }
            this.b++;
        }
    }

    public final void a(String str, View view, JSONObject jSONObject) {
        cc ccVarB = this.e.b();
        String strB = this.f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = ccVarB.a(view);
            vc.a(jSONObjectA, str);
            vc.b(jSONObjectA, strB);
            vc.a(jSONObject, jSONObjectA);
        }
    }

    public final boolean a(View view, JSONObject jSONObject) {
        fc.a aVarB = this.f.b(view);
        if (aVarB == null) {
            return false;
        }
        vc.a(jSONObject, aVarB);
        return true;
    }
}
