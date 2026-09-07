package com.json;

import android.content.Context;
import android.text.TextUtils;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.logger.IronLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nf f3720a;
    private final ConcurrentHashMap<String, Object> b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3721a;

        a(Context context) {
            this.f3721a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ge.this.e(this.f3721a);
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            ge.this.c.set(false);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile ge f3722a = new ge(null);

        private b() {
        }
    }

    private ge() {
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.f3720a = mm.S().f();
        this.b = new ConcurrentHashMap<>();
    }

    /* synthetic */ ge(a aVar) {
        this();
    }

    static ge a() {
        return b.f3722a;
    }

    private void a(Context context) {
        if (this.c.get()) {
            return;
        }
        try {
            this.c.set(true);
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(context));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            this.c.set(false);
        }
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof Boolean) {
                obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            }
            this.b.put(str, obj);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean a(String str) {
        return str != null && this.b.containsKey(str);
    }

    private void d(Context context) {
        if (context == null || this.d.getAndSet(true)) {
            return;
        }
        a("auid", this.f3720a.t(context));
        a("model", this.f3720a.e());
        a("make", this.f3720a.g());
        a("os", this.f3720a.m());
        a(fe.p, this.f3720a.r(context));
        String strP = this.f3720a.p();
        if (strP != null) {
            a("osv", strP.replaceAll("[^0-9/.]", ""));
            a(fe.I, strP);
        }
        a(fe.f3694a, String.valueOf(this.f3720a.l()));
        String strJ = this.f3720a.j(context);
        if (!TextUtils.isEmpty(strJ)) {
            a("carrier", strJ);
        }
        String strE = c4.e(context);
        if (!TextUtils.isEmpty(strE)) {
            a(fe.o, strE);
        }
        String strI = this.f3720a.i(context);
        if (!TextUtils.isEmpty(strI)) {
            a("dt", strI);
        }
        a("bid", context.getPackageName());
        a(fe.v, String.valueOf(this.f3720a.h(context)));
        a(fe.Y, "2.0");
        a(fe.Z, Long.valueOf(c4.f(context)));
        a(fe.X, Long.valueOf(c4.d(context)));
        a(fe.d, c4.b(context));
        a(fe.L, Integer.valueOf(x8.f(context)));
        a(fe.V, x8.g(context));
        a("stid", dp.c(context));
        a("platform", "android");
        a(fe.z, this.f3720a.i());
        a(fe.y, this.f3720a.a(this.f3720a.z(context)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (context == null) {
            return;
        }
        try {
            String strP = this.f3720a.p(context);
            if (!TextUtils.isEmpty(strP)) {
                a(fe.Q0, strP);
            }
            String strA = this.f3720a.a(context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            a("lat", Boolean.valueOf(Boolean.parseBoolean(strA)));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void f(Context context) {
        if (context == null) {
            return;
        }
        a(context);
        String strG = this.f3720a.G(context);
        if (!TextUtils.isEmpty(strG)) {
            a(fe.G0, strG);
        } else if (a(fe.G0)) {
            b(fe.G0);
        }
        a("idfi", this.f3720a.w(context));
        String strB = this.f3720a.b(context);
        if (!TextUtils.isEmpty(strB)) {
            a(fe.q, strB.toUpperCase(Locale.getDefault()));
        }
        a(fe.r, this.f3720a.I(context));
        String strB2 = this.f3720a.b();
        if (!TextUtils.isEmpty(strB2)) {
            a("tz", strB2);
        }
        String strB3 = y8.b(context);
        if (!TextUtils.isEmpty(strB3) && !strB3.equals("none")) {
            a(fe.j, strB3);
        }
        String strD = y8.d(context);
        if (!TextUtils.isEmpty(strD)) {
            a(fe.k, strD);
        }
        a("vpn", Boolean.valueOf(y8.e(context)));
        String strN = this.f3720a.n(context);
        if (!TextUtils.isEmpty(strN)) {
            a("icc", strN);
        }
        int iB = this.f3720a.B(context);
        if (iB >= 0) {
            a(fe.f1, Integer.valueOf(iB));
        }
        a(fe.g1, this.f3720a.D(context));
        a(fe.h1, this.f3720a.K(context));
        a(fe.d0, Float.valueOf(this.f3720a.m(context)));
        a(fe.m, String.valueOf(this.f3720a.o()));
        a(fe.O, Integer.valueOf(this.f3720a.d()));
        a(fe.N, Integer.valueOf(this.f3720a.k()));
        a(fe.T0, String.valueOf(this.f3720a.j()));
        a(fe.c1, String.valueOf(this.f3720a.q()));
        a("mcc", Integer.valueOf(x8.b(context)));
        a("mnc", Integer.valueOf(x8.c(context)));
        a(fe.Q, Boolean.valueOf(this.f3720a.c()));
        a(fe.g, Boolean.valueOf(this.f3720a.J(context)));
        a(fe.h, Integer.valueOf(this.f3720a.l(context)));
        a(fe.b, Boolean.valueOf(this.f3720a.c(context)));
        a(fe.J, Boolean.valueOf(this.f3720a.d(context)));
        a("rt", Boolean.valueOf(this.f3720a.f()));
        a(fe.W, String.valueOf(this.f3720a.h()));
        a(fe.e, Integer.valueOf(this.f3720a.y(context)));
        a(fe.U0, Boolean.valueOf(this.f3720a.q(context)));
        a(fe.c, this.f3720a.f(context));
        a("ua", this.f3720a.t());
        z zVar = new z(mm.S().k());
        HashMap map = new HashMap();
        zVar.a(map);
        a(fe.z0, map);
    }

    protected void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Object obj = this.b.get(str);
            if (!(obj instanceof JSONObject)) {
                a(str, (Object) jSONObject);
                return;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
            }
            a(str, (Object) jSONObject2);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                if (map.containsKey(str)) {
                    a(str, map.get(str));
                }
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected JSONObject b(Context context) throws JSONException {
        f(context);
        return new JSONObject(ie.a(this.b));
    }

    protected void b(String str) {
        if (str == null) {
            return;
        }
        try {
            this.b.remove(str);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected void b(String str, Object obj) {
        a(str, obj);
    }

    protected void c(Context context) {
        try {
            d(context);
            f(context);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
