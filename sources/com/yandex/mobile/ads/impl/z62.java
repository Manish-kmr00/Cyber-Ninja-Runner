package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class z62 implements on2.a {
    private static z62 h = new z62();
    private static Handler i = new Handler(Looper.getMainLooper());
    private static Handler j = null;
    private static final Runnable k = new b();
    private static final Runnable l = new c();
    private int b;
    private long g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f10795a = new ArrayList();
    private final ArrayList c = new ArrayList();
    private sn2 e = new sn2();
    private yn2 d = new yn2();
    private bo2 f = new bo2(new go2());

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            z62.this.f.a();
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            z62.b(z62.g());
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (z62.j != null) {
                z62.j.post(z62.k);
                z62.j.postDelayed(z62.l, 200L);
            }
        }
    }

    public interface d extends e {
        void a();
    }

    public interface e {
        void b();
    }

    z62() {
    }

    public static void c() {
        Handler handler = j;
        if (handler != null) {
            handler.removeCallbacks(l);
            j = null;
        }
    }

    public static z62 g() {
        return h;
    }

    public final void b() {
        c();
        this.f10795a.clear();
        i.post(new a());
    }

    public static void a() {
        if (j == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            j = handler;
            handler.post(k);
            j.postDelayed(l, 200L);
        }
    }

    static void b(z62 z62Var) {
        z62Var.b = 0;
        z62Var.c.clear();
        Iterator<mn2> it = nn2.a().c().iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        z62Var.g = System.nanoTime();
        z62Var.e.c();
        long jNanoTime = System.nanoTime();
        fo2 fo2VarA = z62Var.d.a();
        if (z62Var.e.b().size() > 0) {
            for (String str : z62Var.e.b()) {
                JSONObject jSONObjectA = fo2VarA.a(null);
                View viewB = z62Var.e.b(str);
                jo2 jo2VarB = z62Var.d.b();
                String strA = z62Var.e.a(str);
                if (strA != null) {
                    JSONObject jSONObjectA2 = jo2VarB.a(viewB);
                    try {
                        jSONObjectA2.put("adSessionId", str);
                    } catch (JSONException e2) {
                        Log.e("OMIDLIB", "Error with setting ad session id", e2);
                    }
                    try {
                        jSONObjectA2.put("notVisibleReason", strA);
                    } catch (JSONException e3) {
                        Log.e("OMIDLIB", "Error with setting not visible reason", e3);
                    }
                    zn2.a(jSONObjectA, jSONObjectA2);
                }
                zn2.a(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                z62Var.f.b(jSONObjectA, hashSet, jNanoTime);
            }
        }
        if (z62Var.e.a().size() > 0) {
            JSONObject jSONObjectA3 = fo2VarA.a(null);
            fo2VarA.a(null, jSONObjectA3, z62Var, true, false);
            zn2.a(jSONObjectA3);
            z62Var.f.a(jSONObjectA3, z62Var.e.a(), jNanoTime);
        } else {
            z62Var.f.a();
        }
        z62Var.e.d();
        long jNanoTime2 = System.nanoTime() - z62Var.g;
        if (z62Var.f10795a.size() > 0) {
            for (e eVar : z62Var.f10795a) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                eVar.b();
                if (eVar instanceof d) {
                    ((d) eVar).a();
                }
            }
        }
    }

    public final void a(View view, on2 on2Var, JSONObject jSONObject, boolean z) {
        int iC;
        boolean z2;
        if (ro2.c(view) != null || (iC = this.e.c(view)) == 3) {
            return;
        }
        JSONObject jSONObjectA = on2Var.a(view);
        zn2.a(jSONObject, jSONObjectA);
        Object objA = this.e.a(view);
        if (objA != null) {
            try {
                jSONObjectA.put("adSessionId", objA);
            } catch (JSONException e2) {
                Log.e("OMIDLIB", "Error with setting ad session id", e2);
            }
            try {
                jSONObjectA.put("hasWindowFocus", Boolean.valueOf(this.e.d(view)));
            } catch (JSONException e3) {
                Log.e("OMIDLIB", "Error with setting not visible reason", e3);
            }
            this.e.e();
        } else {
            sn2.a aVarB = this.e.b(view);
            if (aVarB != null) {
                eo2 eo2VarA = aVarB.a();
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = aVarB.b().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                try {
                    jSONObjectA.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectA.put("friendlyObstructionClass", eo2VarA.b());
                    jSONObjectA.put("friendlyObstructionPurpose", eo2VarA.c());
                    jSONObjectA.put("friendlyObstructionReason", eo2VarA.d());
                } catch (JSONException e4) {
                    Log.e("OMIDLIB", "Error with setting friendly obstruction", e4);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            on2Var.a(view, jSONObjectA, this, iC == 1, z || z2);
        }
        this.b++;
    }
}
