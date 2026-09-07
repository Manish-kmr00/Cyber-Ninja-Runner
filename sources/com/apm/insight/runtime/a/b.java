package com.apm.insight.runtime.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.json.b9;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivityDataManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f271a = true;
    private static boolean b = false;
    private static boolean c = false;
    private static int d = 1;
    private static boolean e = false;
    private static long f = -1;
    private static volatile b z;
    private int B;
    private Application g;
    private Context h;
    private String n;
    private long o;
    private String p;
    private long q;
    private String r;
    private long s;
    private String t;
    private long u;
    private String v;
    private long w;
    private List<String> i = new ArrayList();
    private List<Long> j = new ArrayList();
    private List<String> k = new ArrayList();
    private List<Long> l = new ArrayList();
    private LinkedList<a> m = new LinkedList<>();
    private boolean x = false;
    private long y = -1;
    private int A = 50;

    static /* synthetic */ int g(b bVar) {
        int i = bVar.B;
        bVar.B = i + 1;
        return i;
    }

    static /* synthetic */ boolean k() {
        f271a = false;
        return false;
    }

    static /* synthetic */ int l(b bVar) {
        int i = bVar.B;
        bVar.B = i - 1;
        return i;
    }

    static /* synthetic */ int n(b bVar) {
        bVar.B = 0;
        return 0;
    }

    private b(Application application) {
        this.h = application;
        this.g = application;
        try {
            if (this.g != null) {
                this.g.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.apm.insight.runtime.a.b.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityCreated(Activity activity, Bundle bundle) {
                        b.this.n = activity.getClass().getName();
                        b.this.o = System.currentTimeMillis();
                        boolean unused = b.b = bundle != null;
                        boolean unused2 = b.c = true;
                        b.this.i.add(b.this.n);
                        b.this.j.add(Long.valueOf(b.this.o));
                        b bVar = b.this;
                        b.a(bVar, bVar.n, b.this.o, "onCreate");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStarted(Activity activity) {
                        b.this.p = activity.getClass().getName();
                        b.this.q = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.p, b.this.q, "onStart");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityResumed(Activity activity) {
                        b.this.r = activity.getClass().getName();
                        b.this.s = System.currentTimeMillis();
                        b.g(b.this);
                        if (!b.this.x) {
                            if (b.f271a) {
                                b.k();
                                int unused = b.d = 1;
                                long unused2 = b.f = b.this.s;
                            }
                            if (!b.this.r.equals(b.this.t)) {
                                return;
                            }
                            if (!b.c || b.b) {
                                if (!b.c) {
                                    int unused3 = b.d = 3;
                                    long unused4 = b.f = b.this.s;
                                    return;
                                }
                            } else {
                                int unused5 = b.d = 4;
                                long unused6 = b.f = b.this.s;
                                return;
                            }
                        }
                        b.this.x = true;
                        b bVar = b.this;
                        b.a(bVar, bVar.r, b.this.s, b9.h.u0);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityPaused(Activity activity) {
                        b.this.t = activity.getClass().getName();
                        b.this.u = System.currentTimeMillis();
                        b.l(b.this);
                        if (b.this.B == 0) {
                            b.this.x = false;
                            boolean unused = b.c = false;
                            b.this.y = SystemClock.uptimeMillis();
                        } else if (b.this.B < 0) {
                            b.n(b.this);
                            b.this.x = false;
                            boolean unused2 = b.c = false;
                            b.this.y = SystemClock.uptimeMillis();
                        }
                        b bVar = b.this;
                        b.a(bVar, bVar.t, b.this.u, b9.h.t0);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityStopped(Activity activity) {
                        b.this.v = activity.getClass().getName();
                        b.this.w = System.currentTimeMillis();
                        b bVar = b.this;
                        b.a(bVar, bVar.v, b.this.w, "onStop");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public final void onActivityDestroyed(Activity activity) {
                        String name = activity.getClass().getName();
                        int iIndexOf = b.this.i.indexOf(name);
                        if (iIndexOf >= 0 && iIndexOf < b.this.i.size()) {
                            b.this.i.remove(iIndexOf);
                            b.this.j.remove(iIndexOf);
                        }
                        b.this.k.add(name);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        b.this.l.add(Long.valueOf(jCurrentTimeMillis));
                        b.a(b.this, name, jCurrentTimeMillis, "onDestroy");
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        e = true;
    }

    public static int b() {
        int i = d;
        if (i == 1) {
            return e ? 2 : 1;
        }
        return i;
    }

    public static long c() {
        return f;
    }

    public static b d() {
        if (z == null) {
            synchronized (b.class) {
                if (z == null) {
                    z = new b(com.apm.insight.e.h());
                }
            }
        }
        return z;
    }

    public final long e() {
        return SystemClock.uptimeMillis() - this.y;
    }

    public final boolean f() {
        return this.x;
    }

    private JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.i;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.i.size(); i++) {
                try {
                    jSONArray.put(a(this.i.get(i), this.j.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray o() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.k;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.k.size(); i++) {
                try {
                    jSONArray.put(a(this.k.get(i), this.l.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.n, this.o));
            jSONObject.put("last_start_activity", a(this.p, this.q));
            jSONObject.put("last_resume_activity", a(this.r, this.s));
            jSONObject.put("last_pause_activity", a(this.t, this.u));
            jSONObject.put("last_stop_activity", a(this.v, this.w));
            jSONObject.put("alive_activities", n());
            jSONObject.put("finish_activities", o());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String h() {
        return String.valueOf(this.r);
    }

    public final JSONArray i() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(this.m).iterator();
        while (it.hasNext()) {
            jSONArray.put(((a) it.next()).toString());
        }
        return jSONArray;
    }

    /* JADX INFO: compiled from: ActivityDataManager.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f273a;
        String b;
        long c;

        a(String str, String str2, long j) {
            this.b = str2;
            this.c = j;
            this.f273a = str;
        }

        public final String toString() {
            return com.apm.insight.l.b.a().format(new Date(this.c)) + " : " + this.f273a + ' ' + this.b;
        }
    }

    static /* synthetic */ void a(b bVar, String str, long j, String str2) {
        a aVar;
        try {
            if (bVar.m.size() >= bVar.A) {
                aVar = bVar.m.poll();
                if (aVar != null) {
                    bVar.m.add(aVar);
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new a(str, str2, j);
                bVar.m.add(aVar);
            }
            aVar.b = str2;
            aVar.f273a = str;
            aVar.c = j;
        } catch (Throwable unused) {
        }
    }
}
