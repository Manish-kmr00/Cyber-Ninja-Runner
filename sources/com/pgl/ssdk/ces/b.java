package com.pgl.ssdk.ces;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.pgl.ssdk.a0;
import com.pgl.ssdk.b0;
import com.pgl.ssdk.b1;
import com.pgl.ssdk.c0;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.d0;
import com.pgl.ssdk.e0;
import com.pgl.ssdk.f0;
import com.pgl.ssdk.g0;
import com.pgl.ssdk.h0;
import com.pgl.ssdk.i0;
import com.pgl.ssdk.j0;
import com.pgl.ssdk.l0;
import com.pgl.ssdk.n0;
import com.pgl.ssdk.o0;
import com.pgl.ssdk.s;
import com.pgl.ssdk.t;
import com.pgl.ssdk.t0;
import com.pgl.ssdk.u;
import com.pgl.ssdk.u0;
import com.pgl.ssdk.v;
import com.pgl.ssdk.v0;
import com.pgl.ssdk.w;
import com.pgl.ssdk.x;
import com.pgl.ssdk.y;
import com.pgl.ssdk.z;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.h;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7505a = false;
    private static volatile b b = null;
    private static boolean c = false;
    private static Map<String, Object> d = null;
    private static int e = 1;
    private static t0.a f;
    public Context h;
    private String i;
    private int j;
    private String k;
    private String p;
    public boolean g = false;
    private String l = null;
    private String m = null;
    private String n = null;
    private String o = null;
    private boolean q = false;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.b(x.b());
        }
    }

    /* JADX INFO: renamed from: com.pgl.ssdk.ces.b$b, reason: collision with other inner class name */
    class RunnableC0710b implements Runnable {
        RunnableC0710b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.a(b.this.h).a();
            i0.a(b.this.h).a();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(b.this.h);
        }
    }

    private b(Context context, String str) {
        this.h = context;
        this.i = str;
    }

    public static b a(Context context, String str, int i, int i2, String str2) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    if (context == null) {
                        context = z.a().getApplicationContext();
                    }
                    if (context == null) {
                        e = 4;
                        return null;
                    }
                    a(i);
                    t0.a aVarB = t0.b(context, "nms");
                    if (aVarB != null) {
                        e = aVarB.f7532a;
                        f = aVarB;
                        return null;
                    }
                    b bVar = new b(context, str);
                    b = bVar;
                    bVar.j = i2;
                    b.k = str2;
                    b.b(context);
                    b.c(a(context));
                    x.c(context);
                    e = 0;
                    o0.b(new a());
                }
            }
        }
        return b;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.p = str;
        com.pgl.ssdk.ces.a.meta(104, null, str);
    }

    public static String d() {
        if (h() != null) {
            return h().i;
        }
        return null;
    }

    public static String e() {
        if (h() != null) {
            return h().l;
        }
        return null;
    }

    public static int g() {
        return e;
    }

    public static b h() {
        return b;
    }

    public static t0.a i() {
        return f;
    }

    private void l() {
        b1.a(this.h, this.i);
    }

    public void b() {
        Map<String, Object> map = d;
        if (map != null) {
            Object obj = map.get(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ);
            if (obj instanceof String) {
                String strA = g0.a((String) obj);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.pgl.ssdk.ces.a.meta(159, null, strA);
            }
        }
    }

    public long f() {
        return x.a(this.h);
    }

    public String j() {
        return x.c();
    }

    public String k() {
        return b1.b();
    }

    public void m() {
        this.q = true;
        n0.b();
        l();
        a("CZL-L1st", (Map<String, Object>) null);
    }

    public synchronized void d(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.n)) {
            com.pgl.ssdk.ces.a.meta(112, null, str);
            this.n = str;
            b1.c();
        }
    }

    public void c() {
        o0.b(new c());
    }

    private void b(Context context) {
        if (context == null || c) {
            return;
        }
        try {
            com.pgl.ssdk.ces.a.meta(101, null, "1");
            com.pgl.ssdk.ces.a.meta(102, null, this.i);
            com.pgl.ssdk.ces.a.meta(114, null, Integer.valueOf(this.j));
            com.pgl.ssdk.ces.a.meta(105, null, new StringBuilder().append(z.g(context)).toString());
            com.pgl.ssdk.ces.a.meta(106, null, z.e(context));
            com.pgl.ssdk.ces.a.meta(107, null, z.d(context));
            com.pgl.ssdk.ces.a.meta(108, null, z.c(context));
            com.pgl.ssdk.ces.a.meta(109, null, z.c());
            com.pgl.ssdk.ces.a.meta(110, null, z.b());
            com.pgl.ssdk.ces.a.meta(115, null, this.k);
            c = true;
        } catch (Throwable unused) {
        }
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.o)) {
            com.pgl.ssdk.ces.a.meta(111, null, str);
            this.o = str;
            b1.c();
        }
    }

    private static String a(Context context) {
        String strA = u0.a(context, h.f);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String string = UUID.randomUUID().toString();
        u0.b(context, h.f, string);
        return string;
    }

    public static void a(int i) {
        l0.a(i);
    }

    public synchronized void a(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.l)) {
            com.pgl.ssdk.ces.a.meta(103, null, str);
            b1.c();
            this.l = str;
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        this.l = str2;
        this.n = str3;
        this.m = str;
        com.pgl.ssdk.ces.a.meta(113, null, str);
        com.pgl.ssdk.ces.a.meta(112, null, str3);
        com.pgl.ssdk.ces.a.meta(103, null, str2);
        com.pgl.ssdk.ces.a.meta(111, null, str4);
        try {
            m();
        } catch (Throwable unused) {
        }
    }

    public Map<String, String> a(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String str2 = (String) com.pgl.ssdk.ces.a.meta(224, this.h, new Object[]{str, bArr});
        if (!TextUtils.isEmpty(str2)) {
            map.put("X-Armors", str2);
        }
        return map;
    }

    public void a(String str, Map<String, Object> map) {
        try {
            long j = "CZL-L1st".equals(str) ? 10000L : 0L;
            Handler handlerB = o0.b();
            if (handlerB != null) {
                handlerB.postDelayed(new com.pgl.ssdk.ces.c(this.h, str, map), j);
            }
            a();
            x.a();
        } catch (Throwable unused) {
        }
    }

    public Object a(int i, Object obj) {
        if (i == 123) {
            return d0.a(this.h);
        }
        if (i == 121) {
            return b0.a();
        }
        if (i == 122) {
            return b0.b();
        }
        if (i == 126) {
            return b0.b(this.h);
        }
        if (i == 128) {
            return b0.c(this.h);
        }
        if (i == 120) {
            return a0.c();
        }
        if (i == 124) {
            return e0.c(this.h);
        }
        if (i == 130) {
            return e0.a(this.h);
        }
        if (i == 145) {
            return f0.b(this.h);
        }
        if (i == 125) {
            return e0.b(this.h);
        }
        if (i == 129) {
            return c0.e(this.h);
        }
        if (i == 141) {
            return c0.d(this.h);
        }
        if (i == 131) {
            return b1.a();
        }
        if (i == 134) {
            return j0.a(this.h).b();
        }
        if (i == 140) {
            return i0.a(this.h).e();
        }
        if (i == 144) {
            return i0.a(this.h).d();
        }
        String string = null;
        if (i == 133) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Object> entry : d.entrySet()) {
                    if (entry.getValue() == null) {
                        jSONObject.put(entry.getKey(), "");
                    } else {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                string = jSONObject.toString();
            } catch (Throwable unused) {
            }
            return string == null ? JsonUtils.EMPTY_JSON : string.trim();
        }
        if (i == 135) {
            return t.f();
        }
        if (i == 201) {
            return b0.a(this.h);
        }
        if (i == 202) {
            return b0.c();
        }
        if (i == 236) {
            return v0.a((String) obj);
        }
        if (i == 142) {
            return z.f(this.h);
        }
        if (i == 143) {
            return f0.a(this.h);
        }
        if (i == 146) {
            try {
                return t.b();
            } catch (Throwable unused2) {
                return null;
            }
        }
        if (i == 147) {
            return Boolean.valueOf(z.h(this.h));
        }
        if (i == 148) {
            return s.b(this.h);
        }
        if (i == 149) {
            return u.a(this.h);
        }
        if (i == 150) {
            return Integer.valueOf(v.a());
        }
        if (i == 151) {
            return u.c();
        }
        if (i == 161) {
            return Boolean.valueOf(t.g());
        }
        if (i == 163) {
            return h0.a();
        }
        if (i == 164) {
            return Boolean.valueOf(y.b(this.h));
        }
        if (i == 165) {
            return Integer.valueOf(w.b((String) obj));
        }
        return null;
    }

    public void a(MotionEvent motionEvent) {
        w.a(motionEvent, this.h);
    }

    public void a(Map<String, Object> map) {
        if (map != null) {
            d = map;
        }
    }

    public void a() {
        o0.b(new RunnableC0710b());
    }
}
