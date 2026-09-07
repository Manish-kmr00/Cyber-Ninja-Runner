package com.mbridge.msdk.foundation.same.net.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.tracker.network.toolbox.i;
import com.mbridge.msdk.tracker.p;
import com.mbridge.msdk.tracker.u;
import com.mbridge.msdk.tracker.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RequestUrlUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {
    public String A;
    private String B;
    public String C;
    public String D;
    private String E;
    public String F;
    private String G;
    public String H;
    private String I;
    public String J;
    public String K;
    private String L;
    public String M;
    private String N;
    public String O;
    private String P;
    public String Q;
    public String R;
    private String S;
    public String T;
    public String U;
    private String V;
    public String W;
    public String X;
    private String Y;
    public String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4995a;
    private String a0;
    public String b;
    public String b0;
    public String c;
    private String c0;
    public String d;
    public String d0;
    public String e;
    private boolean e0;
    public String f;
    private int f0;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public ArrayList<String> u;
    public int v;
    public int w;
    public ArrayList<String> x;
    public String y;
    private String z;

    /* JADX INFO: compiled from: RequestUrlUtil.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f4996a = new d();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private void b() {
        this.M = this.f + this.L;
    }

    private void c() {
        this.A = this.y + this.z;
        this.H = this.y + this.G;
        i.b().f(this.y);
    }

    public static d h() {
        return b.f4996a;
    }

    public void d(int i) {
        this.f0 = i;
    }

    public void e() {
        this.Q = this.i + this.P;
        this.C = this.i + this.B;
        this.T = this.i + this.S;
        this.J = this.i + this.I;
        this.W = this.i + this.V;
    }

    public void f() {
        this.R = this.m + this.P;
        this.D = this.m + this.B;
        this.U = this.m + this.S;
        this.K = this.m + this.I;
        this.X = this.m + this.V;
    }

    public boolean g() {
        try {
            if (this.s) {
                ArrayList<String> arrayList = this.x;
                if (arrayList != null && this.w <= arrayList.size() - 1) {
                    if (!a(this.x.get(this.w))) {
                        this.m = this.x.get(this.w);
                        f();
                    }
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.u;
                if (arrayList2 != null && this.v <= arrayList2.size() - 1) {
                    this.i = this.u.get(this.v);
                    e();
                    return true;
                }
            }
            if (this.r) {
                this.v = 0;
                this.w = 0;
            }
            return false;
        } catch (Throwable th) {
            o0.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    public int i() {
        return this.f0;
    }

    public void j() {
        HashMap<String, String> mapC;
        g gVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (gVarD != null) {
            com.mbridge.msdk.setting.a aVarJ = gVarD.j();
            if (aVarJ != null) {
                this.l = aVarJ.f();
                this.p = aVarJ.g();
                this.h = aVarJ.e();
                a();
            }
            com.mbridge.msdk.setting.d dVarY = gVarD.y();
            if (dVarY != null) {
                this.k = dVarY.d();
                this.o = dVarY.e();
                this.f = dVarY.c();
                b();
                a(gVarD);
            }
            this.s = gVarD.n0() == 2;
            this.t = gVarD.n0();
            a(!gVarD.b(2));
            if (gVarD.C() != null && gVarD.C().size() > 0 && (mapC = gVarD.C()) != null && mapC.size() > 0) {
                if (mapC.containsKey("v") && !TextUtils.isEmpty(mapC.get("v")) && a(mapC.get("v"))) {
                    this.e = mapC.get("v");
                    d();
                }
                if (mapC.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(mapC.get(CampaignEx.JSON_KEY_HB)) && a(mapC.get(CampaignEx.JSON_KEY_HB))) {
                    this.y = mapC.get(CampaignEx.JSON_KEY_HB);
                    c();
                }
                if (mapC.containsKey("lg") && !TextUtils.isEmpty(mapC.get("lg"))) {
                    String str = mapC.get("lg");
                    if (a(str)) {
                        this.d = str;
                    } else {
                        this.j = str;
                    }
                }
                if (mapC.containsKey("lgt") && !TextUtils.isEmpty(mapC.get("lgt"))) {
                    String str2 = mapC.get("lgt");
                    if (a(str2)) {
                        String strB = b(str2);
                        if (!TextUtils.isEmpty(strB)) {
                            this.j = strB;
                        }
                    } else {
                        this.j = str2;
                    }
                }
            }
            String strU = gVarD.u();
            if (!TextUtils.isEmpty(strU)) {
                this.i = strU;
                e();
                this.u.add(0, strU);
            }
            String strV = gVarD.v();
            if (TextUtils.isEmpty(strV)) {
                return;
            }
            this.m = strV;
            f();
            this.x.add(0, strV);
        }
    }

    private d() {
        this.f4995a = "RequestUrlUtil";
        this.b = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.c = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.d = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.e = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.f = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.g = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.h = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.i = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.j = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.l = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.m = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.n = 9377;
        this.o = 9377;
        this.p = 9988;
        this.q = 9377;
        this.r = false;
        this.s = false;
        this.t = 1;
        this.u = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.v = 0;
        this.w = 0;
        this.x = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
        this.y = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.z = "/bid";
        this.A = this.y + this.z;
        this.B = "/sdk/customid";
        this.C = this.i + this.B;
        this.D = this.m + this.B;
        this.E = "/image";
        this.F = this.e + this.E;
        this.G = "/load";
        this.H = this.y + this.G;
        this.I = "/mapping";
        this.J = this.i + this.I;
        this.K = this.m + this.I;
        this.L = "";
        this.M = this.h + this.L;
        this.N = "/batchPaidEvent";
        this.O = this.h + this.N;
        this.P = "/setting";
        this.Q = this.i + this.P;
        this.R = this.m + this.P;
        this.S = "/rewardsetting";
        this.T = this.i + this.S;
        this.U = this.m + this.S;
        this.V = "/appwall/setting";
        this.W = this.i + this.V;
        this.X = this.m + this.V;
        this.Y = "/openapi/ad/v3";
        this.Z = this.e + this.Y;
        this.a0 = "/openapi/ad/v4";
        this.b0 = this.e + this.a0;
        this.c0 = "/openapi/ad/v5";
        this.d0 = this.e + this.c0;
        this.e0 = true;
        this.f0 = 0;
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th) {
            o0.b("RequestUrlUtil", th.getMessage());
            return "";
        }
    }

    private void d() {
        this.Z = this.e + this.Y;
        this.b0 = this.e + this.a0;
        this.d0 = this.e + this.c0;
        this.F = this.e + this.E;
    }

    public void c(int i) {
        this.q = i;
    }

    public String a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("_");
                if (strArrSplit.length > 1) {
                    return a(true, strArrSplit[1]);
                }
                return a(true, "");
            }
        } catch (Exception e) {
            o0.b("RequestUrlUtil", e.getMessage());
        }
        return i % 2 == 0 ? this.d0 : this.Z;
    }

    public void b(int i) {
        this.n = i;
    }

    public String a(boolean z, String str) {
        if (z) {
            if (this.H.contains(JsonUtils.EMPTY_JSON) && !TextUtils.isEmpty(str)) {
                return this.H.replace(JsonUtils.EMPTY_JSON, str + "-");
            }
            return this.H.replace(JsonUtils.EMPTY_JSON, "");
        }
        return this.A.replace(JsonUtils.EMPTY_JSON, "");
    }

    public void a(boolean z) {
        this.e0 = z;
    }

    private void a() {
        this.O = this.h + this.N;
    }

    private void a(g gVar) {
        com.mbridge.msdk.setting.d dVarY;
        if (gVar == null || (dVarY = gVar.y()) == null || dVarY.a() == 1) {
            return;
        }
        int iB = q0.a().b("monitor", "type", q0.a().b("t_r_t", 1));
        if (iB != 0 && iB != 1) {
            iB = 0;
        }
        u.a().a(com.mbridge.msdk.foundation.controller.c.m().d(), new x.b().a(new com.mbridge.msdk.foundation.same.report.d()).a(new n()).a(iB, a(iB)).a(q0.a().b("t_m_e_t", 604800000)).b(q0.a().b("t_m_e_s", 50)).d(q0.a().b("t_m_r_c", 50)).c(q0.a().b("t_m_t", 15000)).e(q0.a().b("t_m_r_t_s", 1)).a(), dVarY.b() * 1000, com.mbridge.msdk.foundation.same.report.c.b());
    }

    private p a(int i) {
        if (i == 1) {
            return new p(new m((byte) 2), h().k, h().o);
        }
        return new p(new com.mbridge.msdk.tracker.network.toolbox.h(), h().M, 0);
    }
}
