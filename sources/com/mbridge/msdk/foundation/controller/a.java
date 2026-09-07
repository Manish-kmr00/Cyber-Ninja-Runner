package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseMBSDKContext.java */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a {
    public static final String q = ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM;
    public static HashMap<String, String> r = new HashMap<>();
    protected String b;
    protected Context c;
    protected String d;
    private WeakReference<Activity> e;
    private String f;
    private int g;
    private String j;
    private String k;
    private int l;
    private WeakReference<Context> n;
    private JSONObject o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f4892a = new q();
    private JSONObject h = new JSONObject();
    private boolean i = false;
    private ConcurrentHashMap<String, String> m = new ConcurrentHashMap<>();
    private int p = 0;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.controller.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseMBSDKContext.java */
    class RunnableC0429a implements Runnable {
        RunnableC0429a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.report.crashreport.e.a(a.this.c).a();
        }
    }

    /* JADX INFO: compiled from: BaseMBSDKContext.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.report.crashreport.d.c();
        }
    }

    /* JADX INFO: compiled from: BaseMBSDKContext.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.b = (String) w0.a(aVar.c, "sp_appId", "");
            } catch (Throwable th) {
                o0.b(a.q, th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: BaseMBSDKContext.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.j = (String) w0.a(aVar.c, "sp_appKey", "");
            } catch (Throwable th) {
                o0.b(a.q, th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: BaseMBSDKContext.java */
    public interface e {
    }

    private void l() {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.i() && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                Object objA = w0.a(this.c, MBridgeConstans.SP_GA_ID, "");
                Object objA2 = w0.a(this.c, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                if (objA instanceof String) {
                    String str = (String) objA;
                    if (TextUtils.isEmpty(str)) {
                        f.d();
                    } else {
                        f.a(str);
                    }
                    if (objA2 instanceof Integer) {
                        f.a(((Integer) objA2).intValue());
                    }
                }
            }
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
        }
    }

    protected abstract void a(e eVar);

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.p = i;
    }

    public Context d() {
        return this.c;
    }

    public q e() {
        return this.f4892a;
    }

    public Context f() {
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int g() {
        return this.g;
    }

    public String h() {
        try {
            if (!TextUtils.isEmpty(this.d)) {
                return this.d;
            }
            Context context = this.c;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.d = packageName;
            return packageName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String i() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        Context context = this.c;
        if (context != null) {
            return (String) w0.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public JSONObject j() {
        return this.o;
    }

    public int k() {
        return this.p;
    }

    public WeakReference<Activity> a() {
        return this.e;
    }

    public void b(e eVar) {
        try {
            k0.C(this.c);
            a(eVar);
            h.a(this.c, this.b);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                try {
                    try {
                        k0.d(this.c.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (PackageManager.NameNotFoundException unused) {
                        k0.d(0);
                    }
                } catch (Throwable th) {
                    o0.b(q, th.getMessage());
                }
            }
            try {
                g gVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (gVarD == null) {
                    gVarD = h.b().a();
                }
                q qVarE = com.mbridge.msdk.foundation.controller.c.m().e();
                if (qVarE != null && qVarE.b() && gVarD != null && gVarD.E() == 1) {
                    com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0429a());
                }
                if (qVarE == null || !qVarE.a()) {
                    return;
                }
                com.mbridge.msdk.foundation.same.threadpool.a.c().post(new b());
            } catch (Throwable th2) {
                o0.b(q, th2.getMessage());
            }
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
        }
    }

    public void c(e eVar) {
        if (this.i) {
            return;
        }
        l();
        try {
            JSONObject jSONObject = new JSONObject();
            this.o = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e2) {
            o0.b(q, e2.getMessage());
        }
        b(eVar);
    }

    public void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.k = str;
            Context context = this.c;
            if (context != null) {
                w0.b(context, "sp_wx_appKey", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str) {
        Context context;
        try {
            this.b = str;
            if (TextUtils.isEmpty(str) || (context = this.c) == null) {
                return;
            }
            w0.b(context, "sp_appId", str);
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
        }
    }

    public void f(String str) {
        Context context;
        try {
            this.j = str;
            if (TextUtils.isEmpty(str) || (context = this.c) == null) {
                return;
            }
            w0.b(context, "sp_appKey", str);
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
        }
    }

    public void a(WeakReference<Activity> weakReference) {
        this.e = weakReference;
    }

    public void a(Context context) {
        if (context instanceof Activity) {
            this.n = new WeakReference<>(context);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public BitmapDrawable a(String str, int i) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        String str2;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.m) == null || !concurrentHashMap.containsKey(str) || !q0.a().a("w_m_r_l", true)) {
            return null;
        }
        String str3 = this.m.get(str);
        BitmapDrawable bitmapDrawableN = t0.n(str3);
        int i2 = TextUtils.isEmpty(str3) ? 2 : 1;
        if (TextUtils.isEmpty(str3)) {
            str2 = "get watermark failed";
        } else {
            str2 = bitmapDrawableN != null ? "" : "str to bitmap failed";
        }
        j.a(str, i, i2, str2, bitmapDrawableN == null ? 2 : 1, str3);
        return bitmapDrawableN;
    }

    public void a(JSONObject jSONObject) {
        this.o = jSONObject;
    }

    public void a(String str) {
        try {
            if (this.m != null && !TextUtils.isEmpty(str) && this.m.containsKey(str)) {
                this.m.remove(str);
            }
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
        }
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.j)) {
                return this.j;
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new d());
            return "";
        } catch (Throwable th) {
            o0.b(q, th.getMessage());
            return "";
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (q0.a().a("w_m_r_l", true)) {
            try {
                if (this.h == null) {
                    this.h = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.h.put(next, jSONObject.get(next));
                    }
                }
                if (this.h.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.m == null) {
                        this.m = new ConcurrentHashMap<>();
                    }
                    this.m.put(str, this.h.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e2) {
                o0.b(q, e2.getMessage());
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }

    public String b() {
        try {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new c());
            return "";
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
            return "";
        }
    }

    public void b(String str) {
        Context context;
        try {
            this.f = str;
            if (TextUtils.isEmpty(str) || (context = this.c) == null) {
                return;
            }
            w0.b(context, "applicationIds", str);
        } catch (Exception e2) {
            o0.b(q, e2.getMessage());
        }
    }

    public void b(Context context) {
        this.c = context;
    }
}
