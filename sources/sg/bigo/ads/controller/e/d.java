package sg.bigo.ads.controller.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.json.x8;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements sg.bigo.ads.common.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdConfig f13454a;
    final Context b;
    final sg.bigo.ads.controller.b.d c;
    String d;
    String e;
    int f;
    String g;
    String h;
    String i;
    String j;
    String k;
    public int l;
    public String m;
    String n;
    String o;
    int p;
    long q;
    long r;
    int s;
    String t;
    private long u = 0;
    private long v = 0;

    d(Context context, AdConfig adConfig, sg.bigo.ads.controller.b.d dVar) {
        this.b = context;
        this.f13454a = adConfig;
        this.c = dVar;
    }

    @Override // sg.bigo.ads.common.g
    public final String A() {
        sg.bigo.ads.common.a aVarF = this.c.F();
        return aVarF != null ? aVarF.b : "";
    }

    @Override // sg.bigo.ads.common.g
    public final String B() {
        return sg.bigo.ads.common.b.a.a(this.b);
    }

    @Override // sg.bigo.ads.common.g
    public final String C() {
        return this.c.z();
    }

    @Override // sg.bigo.ads.common.g
    public final int D() {
        return (int) (r.b() / 1000);
    }

    @Override // sg.bigo.ads.common.g
    public final String E() {
        return this.c.j();
    }

    @Override // sg.bigo.ads.common.g
    public final boolean F() {
        sg.bigo.ads.common.a aVarE = this.c.E();
        if (aVarE != null) {
            return aVarE.c;
        }
        return true;
    }

    @Override // sg.bigo.ads.common.g
    public final String G() {
        sg.bigo.ads.common.a aVarE = this.c.E();
        return aVarE != null ? aVarE.b : "";
    }

    @Override // sg.bigo.ads.common.g
    public final String H() {
        return this.n;
    }

    @Override // sg.bigo.ads.common.g
    public final String I() {
        return this.o;
    }

    @Override // sg.bigo.ads.common.g
    public final int J() {
        return this.p;
    }

    @Override // sg.bigo.ads.common.g
    public final long K() {
        return this.q;
    }

    @Override // sg.bigo.ads.common.g
    public final long L() {
        return this.r;
    }

    @Override // sg.bigo.ads.common.g
    public final long M() {
        return p.a(this.b);
    }

    @Override // sg.bigo.ads.common.g
    public final long N() {
        return p.c();
    }

    @Override // sg.bigo.ads.common.g
    public final long O() {
        return p.a();
    }

    @Override // sg.bigo.ads.common.g
    public final String P() {
        return this.c.l();
    }

    @Override // sg.bigo.ads.common.g
    public final String Q() {
        return "";
    }

    @Override // sg.bigo.ads.common.g
    public final String R() {
        return q.d(sg.bigo.ads.common.aa.b.e(this.b));
    }

    @Override // sg.bigo.ads.common.g
    public final String S() {
        return q.d(sg.bigo.ads.common.aa.b.c(this.b));
    }

    @Override // sg.bigo.ads.common.g
    public final String T() {
        return this.t;
    }

    @Override // sg.bigo.ads.common.g
    public final String U() {
        sg.bigo.ads.controller.b.d dVar = this.c;
        return dVar != null ? dVar.A() : "";
    }

    @Override // sg.bigo.ads.common.g
    public final long V() {
        return h.a().e.f13463a;
    }

    @Override // sg.bigo.ads.common.g
    public final long W() {
        return h.a().e.b;
    }

    @Override // sg.bigo.ads.common.g
    public final String X() {
        return sg.bigo.ads.common.x.a.q();
    }

    @Override // sg.bigo.ads.common.g
    public final long Y() {
        if (this.u == 0) {
            try {
                Context context = this.b;
                this.u = sg.bigo.ads.common.utils.c.c(context, context.getPackageName());
            } catch (Exception unused) {
                this.u = -1L;
            }
        }
        return this.u;
    }

    @Override // sg.bigo.ads.common.g
    public final long Z() {
        if (this.v == 0) {
            try {
                Context context = this.b;
                this.v = sg.bigo.ads.common.utils.c.d(context, context.getPackageName());
            } catch (Exception unused) {
                this.v = -1L;
            }
        }
        return this.v;
    }

    @Override // sg.bigo.ads.common.g
    public final String a() {
        return this.f13454a.getAppKey();
    }

    @Override // sg.bigo.ads.common.g
    public final String aa() {
        return "official";
    }

    @Override // sg.bigo.ads.common.g
    public final int ab() {
        return this.s;
    }

    @Override // sg.bigo.ads.common.g
    public final sg.bigo.ads.common.b ac() {
        if (this.c.n().a(15)) {
            return sg.bigo.ads.common.aa.b.h(this.b);
        }
        return null;
    }

    @Override // sg.bigo.ads.common.g
    public final boolean ad() {
        sg.bigo.ads.common.a aVarG = this.c.G();
        if (aVarG != null) {
            return aVarG.c;
        }
        return true;
    }

    @Override // sg.bigo.ads.common.g
    public final String ae() {
        sg.bigo.ads.common.a aVarG = this.c.G();
        return aVarG != null ? aVarG.b : "";
    }

    @Override // sg.bigo.ads.common.g
    public final Context af() {
        return this.b;
    }

    @Override // sg.bigo.ads.common.g
    public final String b() {
        return this.d;
    }

    @Override // sg.bigo.ads.common.g
    public final String c() {
        return this.e;
    }

    @Override // sg.bigo.ads.common.g
    public final int d() {
        return this.f;
    }

    @Override // sg.bigo.ads.common.g
    public final String e() {
        return this.f13454a.getChannel();
    }

    @Override // sg.bigo.ads.common.g
    public final int f() {
        return this.f13454a.getAge();
    }

    @Override // sg.bigo.ads.common.g
    public final int g() {
        return this.f13454a.getGender();
    }

    @Override // sg.bigo.ads.common.g
    public final long h() {
        return this.f13454a.getActivatedTime();
    }

    @Override // sg.bigo.ads.common.g
    public final String i() {
        return "android";
    }

    @Override // sg.bigo.ads.common.g
    public final String j() {
        return Build.VERSION.RELEASE;
    }

    @Override // sg.bigo.ads.common.g
    public final String k() {
        return this.g;
    }

    @Override // sg.bigo.ads.common.g
    public final String l() {
        return this.h;
    }

    @Override // sg.bigo.ads.common.g
    public final String m() {
        return this.i;
    }

    @Override // sg.bigo.ads.common.g
    public final String n() {
        return this.j;
    }

    @Override // sg.bigo.ads.common.g
    public final String o() {
        return this.k;
    }

    @Override // sg.bigo.ads.common.g
    public final int p() {
        return this.l;
    }

    @Override // sg.bigo.ads.common.g
    public final String q() {
        return this.m;
    }

    @Override // sg.bigo.ads.common.g
    public final String r() {
        String str;
        int iA = sg.bigo.ads.common.aa.c.a(this.b);
        if (iA == 1) {
            str = "2g";
        } else if (iA == 2) {
            str = x8.f4583a;
        } else if (iA == 3) {
            str = x8.b;
        } else if (iA != 4) {
            str = iA != 5 ? "unknown" : "5g";
        } else {
            str = "4g";
        }
        return String.valueOf(str);
    }

    @Override // sg.bigo.ads.common.g
    public final String s() {
        return q.d(sg.bigo.ads.common.utils.c.a());
    }

    @Override // sg.bigo.ads.common.g
    public final String t() {
        String strK = this.c.k();
        return !TextUtils.isEmpty(strK) ? strK : v();
    }

    @Override // sg.bigo.ads.common.g
    public final String u() {
        return this.c.k();
    }

    @Override // sg.bigo.ads.common.g
    public final String v() {
        if (!TextUtils.isEmpty("")) {
            return "";
        }
        String strR = R();
        return !TextUtils.isEmpty(strR) ? strR : S();
    }

    @Override // sg.bigo.ads.common.g
    public final String w() {
        return "";
    }

    @Override // sg.bigo.ads.common.g
    public final String x() {
        return "";
    }

    @Override // sg.bigo.ads.common.g
    public final String y() {
        return "5.2.1";
    }

    @Override // sg.bigo.ads.common.g
    public final boolean z() {
        sg.bigo.ads.common.a aVarF = this.c.F();
        if (aVarF != null) {
            return aVarF.c;
        }
        return true;
    }
}
