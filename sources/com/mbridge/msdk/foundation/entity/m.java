package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.json.b9;
import com.json.cc;
import com.mbridge.msdk.foundation.tools.k0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: VideoReportData.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public static int N = 1;
    public static int O;
    private String A;
    private String B;
    private int C;
    private String D;
    private String E;
    private String G;
    private String H;
    private String I;
    private int J;
    private long K;
    private String L;
    private int M;
    private String b;
    private int c;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private int p;
    private String q;
    private String r;
    private String s;
    private int u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f4943a = null;
    private int d = 0;
    private int t = 0;
    private int F = 0;

    public m(String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, int i6, String str5) {
        this.q = str;
        this.u = i;
        this.v = str5;
        this.p = i2;
        this.M = i3;
        this.J = i4;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.w = URLEncoder.encode(str2, cc.N);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.x = str3;
        this.C = i5;
        this.i = str4;
        this.K = i6;
    }

    public String A() {
        return this.H;
    }

    public String B() {
        return this.I;
    }

    public int C() {
        return this.J;
    }

    public long D() {
        return this.K;
    }

    public String E() {
        return this.L;
    }

    public int F() {
        return this.M;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.f = str;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g = URLEncoder.encode(str);
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.k;
    }

    public void j(String str) {
        this.q = str;
    }

    public String k() {
        return this.m;
    }

    public void l(String str) {
        this.v = str;
    }

    public void m(String str) {
        this.x = str;
    }

    public String n() {
        return this.q;
    }

    public void o(String str) {
        this.z = str;
    }

    public void p(String str) {
        this.A = str;
    }

    public int q() {
        return this.u;
    }

    public String r() {
        return this.v;
    }

    public String s() {
        return this.w;
    }

    public String t() {
        return TextUtils.isEmpty(this.x) ? "" : this.x;
    }

    public String toString() {
        return "RewardReportData [key=" + this.q + ", networkType=" + this.u + ", isCompleteView=" + this.p + ", watchedMillis=" + this.M + ", videoLength=" + this.J + ", offerUrl=" + this.w + ", reason=" + this.x + ", result=" + this.C + ", duration=" + this.i + ", videoSize=" + this.K + b9.i.e;
    }

    public void u(String str) {
        this.I = str;
    }

    public String v() {
        return this.z;
    }

    public String w() {
        return this.A;
    }

    public int x() {
        return this.C;
    }

    public int y() {
        return this.F;
    }

    public String z() {
        return this.G;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.c;
    }

    public void d(String str) {
        this.h = str;
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.k = URLEncoder.encode(str, cc.N);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h(String str) {
        this.l = str;
    }

    public void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.o = URLEncoder.encode(str, cc.N);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String j() {
        return this.l;
    }

    public void k(String str) {
        this.s = str;
    }

    public String l() {
        return this.o;
    }

    public int m() {
        return this.p;
    }

    public void n(String str) {
        this.y = str;
    }

    public String o() {
        return this.r;
    }

    public int p() {
        return this.t;
    }

    public void q(String str) {
        this.B = str;
    }

    public void r(String str) {
        this.D = str;
    }

    public void s(String str) {
        this.E = str;
    }

    public void t(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.G = URLEncoder.encode(str, cc.N);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String u() {
        return this.y;
    }

    public void v(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.L = URLEncoder.encode(str, cc.N);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.t = i;
    }

    public void c(int i) {
        this.u = i;
    }

    public void d(int i) {
        this.C = i;
    }

    public void e(int i) {
        this.F = i;
    }

    public String a(String str, String str2) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f4943a) == null) {
            return str2;
        }
        try {
            String str3 = map.get(str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Exception unused) {
            return str2;
        }
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f4943a == null) {
            this.f4943a = new HashMap();
        }
        try {
            this.f4943a.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public int c() {
        return this.e;
    }

    public m() {
    }

    public m(String str, int i, String str2, String str3, String str4) {
        this.q = str;
        this.v = str4;
        this.u = i;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.w = URLEncoder.encode(str2, cc.N);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.x = str3;
    }

    public m(String str, int i, int i2, String str2, int i3, String str3, int i4, String str4) {
        this.q = str;
        this.u = i;
        this.v = str4;
        this.J = i2;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.w = URLEncoder.encode(str2, cc.N);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.C = i3;
        this.i = str3;
        this.K = i4;
    }

    public m(Context context, CampaignEx campaignEx, int i, String str, long j, int i2) {
        if (i2 == 1 || i2 == 287 || i2 == 94) {
            this.q = "m_download_end";
        } else if (i2 == 95) {
            this.q = "2000025";
        }
        int iS = k0.s(context);
        this.u = iS;
        this.v = k0.a(context, iS);
        this.J = campaignEx.getVideoLength();
        this.y = campaignEx.getRequestId();
        this.z = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.w)) {
            try {
                this.w = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), cc.N);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.C = i;
        this.i = str;
        this.K = j == 0 ? campaignEx.getVideoSize() : j;
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        this.q = str;
        this.m = str2;
        this.H = str3;
        this.r = str4;
        this.I = str5;
        this.f = str6;
        this.u = i;
        this.v = str7;
    }

    public m(String str) {
        this.n = str;
    }

    public m(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.q = str;
        this.C = i;
        this.i = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.k = URLEncoder.encode(str3, cc.N);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.f = str4;
        this.I = str5;
        this.x = str6;
        this.j = str7;
        if (Integer.valueOf(str2).intValue() > com.mbridge.msdk.foundation.same.a.L) {
            this.C = 2;
        }
    }

    public m(String str, String str2, String str3, String str4, String str5, int i) {
        this.q = str;
        this.f = str2;
        this.y = str3;
        this.z = str4;
        this.I = str5;
        this.u = i;
    }

    public m(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6) {
        this.q = str;
        this.f = str2;
        this.y = str3;
        this.z = str4;
        this.I = str5;
        this.u = i;
        this.x = str6;
        this.e = i2;
    }
}
