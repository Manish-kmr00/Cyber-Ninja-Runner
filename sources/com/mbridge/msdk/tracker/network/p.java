package com.mbridge.msdk.tracker.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.unity3d.services.core.network.core.OkHttp3Client;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkMonitor.java */
/* JADX INFO: loaded from: classes6.dex */
public class p {
    private volatile long A;
    private volatile long B;
    private volatile long C;
    private volatile long D;
    private volatile long E;
    private volatile long F;
    private volatile long G;
    private volatile long H;
    private volatile List<InetAddress> I;
    private volatile InetSocketAddress J;
    private volatile Proxy K;
    private volatile com.mbridge.msdk.thrid.okhttp.o L;
    private volatile com.mbridge.msdk.thrid.okhttp.u M;
    private volatile IOException N;
    private volatile Exception P;
    private long R;
    private long S;
    private long T;
    private long U;
    private volatile String d;
    private volatile long f;
    private volatile String j;
    private volatile String k;
    private volatile long s;
    private volatile long t;
    private volatile IOException u;
    private volatile long v;
    private volatile long w;
    private volatile long y;
    private volatile long z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile String f5637a = "";
    private volatile String b = "";
    private volatile String c = "";
    private volatile String e = "";
    private volatile int g = -1;
    private volatile String h = "";
    private volatile int i = -1;
    private volatile String l = OkHttp3Client.NETWORK_CLIENT_OKHTTP;
    private volatile boolean m = false;
    private final AtomicInteger n = new AtomicInteger(0);
    private volatile String o = "";
    private volatile long p = 0;
    private volatile long q = 0;
    private volatile long r = 0;
    private volatile String x = "system";
    private volatile boolean O = false;
    private volatile boolean Q = false;

    public p(String str, String str2) {
        this.d = "";
        this.j = "un_known";
        this.k = "";
        this.j = str;
        this.k = str2;
        this.d = UUID.randomUUID().toString();
    }

    private void P() {
        try {
            JSONObject jSONObjectX = x();
            com.mbridge.msdk.tracker.e eVarA = a(jSONObjectX, "m_request_end");
            if (MBridgeConstans.DEBUG) {
                o0.a("NetworkMonitor_" + H(), "request  end  monitor = " + jSONObjectX.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().d().d(eVarA);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NetworkMonitor", "reportRequestEnd ", th);
            }
        }
    }

    private void Q() {
        try {
            JSONObject jSONObjectZ = z();
            com.mbridge.msdk.tracker.e eVarA = a(jSONObjectZ, "m_request_start");
            if (MBridgeConstans.DEBUG) {
                o0.a("NetworkMonitor_" + H(), "request start monitor = " + jSONObjectZ.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().d().d(eVarA);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NetworkMonitor", "reportRequestStart ", th);
            }
        }
    }

    private void T() {
        this.N = null;
        this.u = null;
        this.P = null;
        this.s = 0L;
        this.t = 0L;
        this.v = 0L;
        this.w = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.q = 0L;
        this.r = 0L;
        this.m = false;
        this.g = -1;
        this.i = -1;
        this.h = "";
        this.o = "";
        this.p = 0L;
        this.Q = false;
    }

    private JSONObject x() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "m_request_end");
        jSONObject.put(CommonUrlParts.UUID, M());
        jSONObject.put("request_uuid", A());
        jSONObject.put("url", L());
        jSONObject.put("timeout", I());
        jSONObject.put("timeout_connection", e());
        jSONObject.put("timeout_read", s());
        jSONObject.put("timeout_write", N());
        jSONObject.put("scene", H());
        jSONObject.put("lrid", n());
        jSONObject.put("method", o());
        jSONObject.put("adtp", b());
        jSONObject.put("http_stack", m());
        jSONObject.put("retry_count", v() - 1);
        jSONObject.put("request_wait_duration", this.f);
        jSONObject.put("duration", j());
        jSONObject.put("request_duration", w());
        jSONObject.put(com.safedk.android.analytics.brandsafety.c.g, E());
        String strH = h();
        jSONObject.put("dns_result", strH);
        jSONObject.put("dns_status", TextUtils.isEmpty(strH) ? 2 : 1);
        jSONObject.put("is_connection_acquired", O() ? 1 : 0);
        jSONObject.put("address", c());
        jSONObject.put("port", p());
        jSONObject.put("proxy", r());
        jSONObject.put("protocol", q());
        jSONObject.put("tls_version", J());
        jSONObject.put(FirebaseAnalytics.Param.CONTENT_TYPE, f());
        int iG = G();
        jSONObject.put("result", iG);
        if (iG != 1) {
            jSONObject.put("error_type", l());
            jSONObject.put("reason", k());
        }
        jSONObject.put("dns_duration", g());
        jSONObject.put("connect_duration", d());
        jSONObject.put("request_header_duration", y());
        jSONObject.put("request_body_duration", t());
        jSONObject.put("request_body_size", u());
        jSONObject.put("response_header_duration", F());
        jSONObject.put("response_body_duration", C());
        jSONObject.put("response_body_size", D());
        jSONObject.put("transmission_duration", K());
        jSONObject.put("current_response_body_size", B());
        jSONObject.put("dns_type", i());
        return jSONObject;
    }

    private JSONObject z() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "m_request_start");
        jSONObject.put(CommonUrlParts.UUID, M());
        jSONObject.put("request_uuid", A());
        jSONObject.put("lrid", n());
        jSONObject.put("url", L());
        jSONObject.put("timeout", I());
        jSONObject.put("timeout_connection", e());
        jSONObject.put("timeout_read", s());
        jSONObject.put("timeout_write", N());
        jSONObject.put("scene", H());
        jSONObject.put("method", o());
        jSONObject.put("adtp", b());
        jSONObject.put("http_stack", m());
        jSONObject.put("retry_count", v() - 1);
        jSONObject.put("request_wait_duration", this.f);
        return jSONObject;
    }

    public String A() {
        return TextUtils.isEmpty(this.e) ? "" : this.e;
    }

    public long B() {
        return this.r;
    }

    public long C() {
        return this.H - this.G;
    }

    public long D() {
        return this.q;
    }

    public int E() {
        return this.i;
    }

    public long F() {
        return this.F - this.E;
    }

    public int G() {
        return this.g;
    }

    public String H() {
        return TextUtils.isEmpty(this.j) ? "un_known" : this.j;
    }

    public long I() {
        return this.R;
    }

    public String J() {
        if (this.L != null) {
            try {
                com.mbridge.msdk.thrid.okhttp.b0 b0VarC = this.L.c();
                return b0VarC == null ? "" : b0VarC.a();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "getTlsVersion ", e);
                }
            }
        }
        return "";
    }

    public long K() {
        return this.E - this.A;
    }

    public String L() {
        return TextUtils.isEmpty(this.f5637a) ? "" : this.f5637a;
    }

    public String M() {
        return TextUtils.isEmpty(this.d) ? "" : this.d;
    }

    public long N() {
        return this.U;
    }

    public boolean O() {
        return this.m;
    }

    public void R() {
        this.C = SystemClock.elapsedRealtime();
    }

    public void S() {
        this.A = SystemClock.elapsedRealtime();
    }

    public void U() {
        this.G = SystemClock.elapsedRealtime();
    }

    public void V() {
        this.E = SystemClock.elapsedRealtime();
    }

    public void W() {
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return TextUtils.isEmpty(this.c) ? "" : this.c;
    }

    public void b(com.mbridge.msdk.thrid.okhttp.g gVar) {
    }

    public void c(String str) {
        this.x = str;
    }

    public void d(String str) {
        this.h = str;
    }

    public void e(long j) {
        this.S = j;
    }

    public void f(String str) {
        this.f5637a = str;
    }

    public long g() {
        return this.w - this.v;
    }

    public String h() {
        if (this.I == null || this.I.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.I.size(); i++) {
            try {
                InetAddress inetAddress = this.I.get(i);
                if (inetAddress != null) {
                    sb.append(inetAddress.getHostAddress());
                    if (i != this.I.size() - 1) {
                        sb.append(StringUtils.COMMA);
                    } else {
                        continue;
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "getDnsResult ", e);
                }
            }
        }
        return sb.toString();
    }

    public void i(long j) {
        this.R = j;
    }

    public void j(long j) {
        this.U = j;
    }

    public String k() {
        try {
            if (this.N != null) {
                String name = this.N.getClass().getName();
                String message = this.N.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    return a("connection: %s ", name, message);
                }
            }
            if (this.u != null) {
                String name2 = this.u.getClass().getName();
                String message2 = this.u.getMessage();
                if (!TextUtils.isEmpty(message2)) {
                    return a("call: %s ", name2, message2);
                }
            }
            if (this.P == null) {
                return "un_known";
            }
            String name3 = this.P.getClass().getName();
            String message3 = this.P.getMessage();
            return !TextUtils.isEmpty(message3) ? a("error: %s ", name3, message3) : "un_known";
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return "un_known";
            }
            o0.b("NetworkMonitor", "getError ", e);
            return "un_known";
        }
    }

    public String l() {
        return this.h;
    }

    public String m() {
        return this.l;
    }

    public String n() {
        return TextUtils.isEmpty(this.b) ? "" : this.b;
    }

    public String o() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    public int p() {
        if (this.J != null) {
            return this.J.getPort();
        }
        return -1;
    }

    public String q() {
        return this.M != null ? this.M.toString() : "";
    }

    public String r() {
        Proxy.Type type;
        return (this.K == null || (type = this.K.type()) == null) ? "" : type.toString();
    }

    public long s() {
        return this.T;
    }

    public long t() {
        return this.D - this.C;
    }

    public long u() {
        return this.p;
    }

    public int v() {
        return this.n.getAndAdd(0);
    }

    public long w() {
        return this.t - this.s;
    }

    public long y() {
        return this.B - this.A;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.d dVar) {
        this.s = SystemClock.elapsedRealtime();
    }

    public void b(int i) {
        this.i = i;
    }

    public String c() {
        if (this.J != null) {
            try {
                InetAddress address = this.J.getAddress();
                if (address == null) {
                    return "";
                }
                String hostAddress = address.getHostAddress();
                return TextUtils.isEmpty(hostAddress) ? "" : hostAddress;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "getAddress ", e);
                }
            }
        }
        return "";
    }

    public long d() {
        return this.z - this.y;
    }

    public long e() {
        return this.S;
    }

    public void f(long j) {
        this.T = j;
    }

    public void g(long j) {
        this.p = j;
    }

    public String i() {
        return TextUtils.isEmpty(this.x) ? "system" : this.x;
    }

    public long j() {
        return (this.t - this.s) + this.f;
    }

    public void a() {
        this.v = SystemClock.elapsedRealtime();
    }

    public void b(long j) {
        this.D = SystemClock.elapsedRealtime();
    }

    public void d(long j) {
        this.H = SystemClock.elapsedRealtime();
    }

    public void e(String str) {
        this.b = str;
    }

    public String f() {
        return com.mbridge.msdk.foundation.same.d.a(this.o);
    }

    public void a(List<InetAddress> list) {
        this.w = SystemClock.elapsedRealtime();
        this.I = list;
    }

    public void b(String str) {
        this.o = str;
    }

    public void a(InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.y = SystemClock.elapsedRealtime();
        this.J = inetSocketAddress;
        this.K = proxy;
        this.O = true;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.o oVar) {
        this.L = oVar;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.u uVar, IOException iOException) {
        this.z = SystemClock.elapsedRealtime();
        this.M = uVar;
        this.N = iOException;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.g gVar) {
        this.m = !this.O;
        if (!this.m || gVar == null) {
            return;
        }
        try {
            this.M = gVar.a();
            com.mbridge.msdk.thrid.okhttp.a0 a0VarC = gVar.c();
            if (a0VarC != null) {
                this.J = a0VarC.d();
                this.K = a0VarC.b();
            }
            this.L = gVar.b();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NetworkMonitor", "connectionAcquired ", e);
            }
        }
    }

    public void c(long j) {
        this.r = j;
    }

    public void h(long j) {
        this.q = j;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.w wVar) {
        this.B = SystemClock.elapsedRealtime();
    }

    public void a(com.mbridge.msdk.thrid.okhttp.y yVar) {
        this.F = SystemClock.elapsedRealtime();
        if (yVar != null) {
            try {
                com.mbridge.msdk.thrid.okhttp.p pVarM = yVar.m();
                if (pVarM != null) {
                    String strB = pVarM.b("Content-Type");
                    if (TextUtils.isEmpty(strB)) {
                        strB = "";
                    }
                    b(strB);
                }
            } catch (Exception e) {
                b("unknown");
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "responseHeadersEnd ", e);
                }
            }
        }
    }

    public void a(IOException iOException) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.t = jElapsedRealtime;
        this.u = iOException;
        a(iOException, jElapsedRealtime);
    }

    private void a(IOException iOException, long j) {
        if (iOException != null) {
            if (this.v == 0) {
                this.v = j;
            }
            if (this.w == 0) {
                this.w = j;
            }
            if (this.y == 0) {
                this.y = j;
            }
            if (this.z == 0) {
                this.z = j;
            }
            if (this.A == 0) {
                this.A = j;
            }
            if (this.B == 0) {
                this.B = j;
            }
            if (this.C == 0) {
                this.C = j;
            }
            if (this.D == 0) {
                this.D = j;
            }
            if (this.E == 0) {
                this.E = j;
            }
            if (this.F == 0) {
                this.F = j;
            }
            if (this.G == 0) {
                this.G = j;
            }
            if (this.H == 0) {
                this.H = j;
            }
        }
    }

    private static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str2)) {
            str2 = "IOException";
        }
        return sb.append(String.format(str, str2)).append(TextUtils.isEmpty(str3) ? "" : str3.replaceAll("[\\n\\r]", " ")).toString();
    }

    public void a(long j) {
        this.e = UUID.randomUUID().toString();
        this.f = j;
        this.n.addAndGet(1);
        T();
        this.Q = true;
        Q();
    }

    public void a(Exception exc) {
        this.P = exc;
    }

    public void a(int i) {
        this.g = i;
        if (this.Q) {
            this.Q = false;
            P();
        }
    }

    private static com.mbridge.msdk.tracker.e a(JSONObject jSONObject, String str) {
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        eVar.a(0);
        eVar.b(0);
        eVar.a(com.mbridge.msdk.foundation.same.report.c.d());
        eVar.a(jSONObject);
        return eVar;
    }
}
