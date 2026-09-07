package sg.bigo.ads.controller.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class b implements sg.bigo.ads.api.core.c {
    int A;
    public final Map<String, String> B;
    int C;
    private JSONObject D;
    private final long E;
    private final long G;
    private final sg.bigo.ads.api.core.h H;
    private long I;
    private int J;
    private int K;
    private boolean M;
    private long N;
    private final String O;
    private String P;
    private boolean Q;
    private boolean R;
    private String S;
    private final double U;
    private String V;
    private final boolean W;
    private String X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<sg.bigo.ads.api.core.c> f13416a;
    private sg.bigo.ads.api.core.c.d aa;
    private String ab;
    private int ac;
    private int ad;
    private boolean ae;
    private int af;
    private boolean ag;
    private int ai;
    private int aj;
    private sg.bigo.ads.api.core.q ak;
    private String al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    protected final sg.bigo.ads.api.a.l b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected final String g;
    protected int h;
    protected int i;
    protected long j;
    protected String k;
    protected String l;
    protected sg.bigo.ads.api.core.c.e m;
    protected sg.bigo.ads.api.core.c.f[] n;
    protected sg.bigo.ads.api.core.c.f[] o;
    protected sg.bigo.ads.api.core.c.f[] p;
    protected sg.bigo.ads.api.core.c.f[] q;
    protected List<sg.bigo.ads.api.core.c.InterfaceC0857c> r;
    protected String s;
    protected long t;
    protected String u;
    protected String v;
    protected sg.bigo.ads.api.core.c.b w;
    protected sg.bigo.ads.api.core.c.a x;
    sg.bigo.ads.api.a.m y;
    public String z;
    private int L = 0;
    private int T = 2;
    private int ah = 1;
    private sg.bigo.ads.api.core.j aq = new sg.bigo.ads.api.core.j();
    private final long F = SystemClock.elapsedRealtime();

    protected b(long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar, JSONObject jSONObject) {
        this.am = 1;
        this.an = 0;
        this.ao = 1;
        this.C = 0;
        this.G = j;
        this.H = hVar;
        this.b = lVar;
        this.c = jSONObject.optString(CreativeInfo.c, "");
        this.d = jSONObject.optString("title", "");
        this.e = jSONObject.optString("description", "");
        this.f = jSONObject.optString("cta", "");
        String strOptString = jSONObject.optString("dsp_name", "");
        this.g = strOptString;
        this.W = "BigoDsp".equalsIgnoreCase(strOptString);
        this.h = jSONObject.optInt("adx_type", 0);
        this.i = jSONObject.optInt("ad_type", -1);
        this.j = jSONObject.optLong("sid");
        this.k = jSONObject.optString("creative_id", "");
        this.l = jSONObject.optString("series_id", "");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("privacy");
        if (jSONObjectOptJSONObject != null) {
            this.m = new o(jSONObjectOptJSONObject);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("track_clicks_third");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    arrayList.add(new p(jSONObjectOptJSONObject2));
                }
            }
            sg.bigo.ads.api.core.c.f[] fVarArr = new sg.bigo.ads.api.core.c.f[arrayList.size()];
            this.o = fVarArr;
            this.o = (sg.bigo.ads.api.core.c.f[]) arrayList.toArray(fVarArr);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("track_impls_third");
        if (jSONArrayOptJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject3 != null) {
                    arrayList2.add(new p(jSONObjectOptJSONObject3));
                }
            }
            sg.bigo.ads.api.core.c.f[] fVarArr2 = new sg.bigo.ads.api.core.c.f[arrayList2.size()];
            this.n = fVarArr2;
            this.n = (sg.bigo.ads.api.core.c.f[]) arrayList2.toArray(fVarArr2);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("ad_nurls");
        if (jSONArrayOptJSONArray3 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray3.optJSONObject(i3);
                if (jSONObjectOptJSONObject4 != null) {
                    arrayList3.add(new p(jSONObjectOptJSONObject4));
                }
            }
            sg.bigo.ads.api.core.c.f[] fVarArr3 = new sg.bigo.ads.api.core.c.f[arrayList3.size()];
            this.p = fVarArr3;
            this.p = (sg.bigo.ads.api.core.c.f[]) arrayList3.toArray(fVarArr3);
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("ad_lurls");
        if (jSONArrayOptJSONArray4 != null) {
            ArrayList arrayList4 = new ArrayList();
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(i4);
                if (jSONObjectOptJSONObject5 != null) {
                    arrayList4.add(new p(jSONObjectOptJSONObject5));
                }
            }
            sg.bigo.ads.api.core.c.f[] fVarArr4 = new sg.bigo.ads.api.core.c.f[arrayList4.size()];
            this.q = fVarArr4;
            this.q = (sg.bigo.ads.api.core.c.f[]) arrayList4.toArray(fVarArr4);
        }
        this.r = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("om_data");
        if (jSONArrayOptJSONArray5 != null) {
            this.r = new ArrayList();
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                this.r.add(new m(jSONArrayOptJSONArray5.optJSONObject(i5)));
            }
        }
        this.s = jSONObject.optString("enc_price", "");
        this.w = new k(jSONObject);
        this.x = new f(jSONObject);
        this.t = jSONObject.optLong("switch_bit_map", 0L);
        this.u = jSONObject.optString("abflags", "");
        this.E = jSONObject.optLong("expired_interval", 0L);
        this.v = jSONObject.optString("mapping_slot", "");
        this.I = jSONObject.optLong("probe_interval");
        this.J = jSONObject.optInt("playable_ad_switch", 0);
        this.z = jSONObject.optString("req_slot");
        String strOptString2 = jSONObject.optString("interstitial_style_getad_config");
        if (!TextUtils.isEmpty(strOptString2)) {
            try {
                this.y = new sg.bigo.ads.controller.b.j(new JSONObject(strOptString2));
            } catch (JSONException unused) {
            }
        }
        this.aq.a(jSONObject.optString("ad_form"));
        this.P = jSONObject.optString(b9.h.F0);
        this.O = jSONObject.optString("sdk_style_id");
        this.Q = jSONObject.optInt("banner_show_ad", 0) == 1;
        this.R = jSONObject.optInt("banner_show_domain", 0) == 1;
        this.S = jSONObject.optString("ru_ad_marker");
        this.U = (jSONObject.optLong(Reporting.Key.BID_PRICE, 0L) * 1.0d) / 1.0E8d;
        this.V = jSONObject.optString("adx_country");
        this.aj = jSONObject.optInt("orientation", 0);
        if (sg.bigo.ads.api.core.b.d(this.i)) {
            this.D = jSONObject;
        }
        this.X = jSONObject.optString("ad_bundle_id", "");
        this.Y = jSONObject.optString("pop_h5");
        this.Z = jSONObject.optString("pop_img");
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("pop_page");
        if (jSONObjectOptJSONObject6 != null) {
            this.aa = new n(jSONObjectOptJSONObject6);
        }
        int iOptInt = jSONObject.optInt("ad_resp_type");
        this.A = iOptInt;
        if (iOptInt == 1) {
            a(jSONObject, j, hVar, lVar);
        }
        this.B = sg.bigo.ads.common.utils.l.a(jSONObject.optString("pub_extra_info"));
        this.al = jSONObject.optString("dsp_extra");
        this.am = jSONObject.optInt("native_banner_fill_strategy", 1);
        this.an = jSONObject.optInt("guide_type", 0);
        this.ao = jSONObject.optInt("native_banner_click_type", 0);
        this.ap = jSONObject.optInt("is_interactive", 0);
        this.C = jSONObject.optInt("vpaid_imp_method", 0);
    }

    public static b a(long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar, String str) {
        try {
            return a(j, hVar, lVar, new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static b a(long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("adx_type", 0);
        if (iOptInt != 1 && iOptInt != 2) {
            if (iOptInt == 3) {
                return new d(j, hVar, lVar, jSONObject);
            }
            if (iOptInt != 5) {
                return null;
            }
        }
        return new l(j, hVar, lVar, jSONObject);
    }

    private void a(JSONObject jSONObject, long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ads");
        ArrayList arrayList = null;
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    b bVarA = a(j, hVar, lVar, jSONObjectOptJSONObject);
                    if (bVarA != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        bVarA.A = this.A;
                        arrayList.add(bVarA);
                    } else {
                        sg.bigo.ads.core.d.b.a(1005, 10205, "Error ad in ads");
                    }
                }
            }
        }
        this.f13416a = arrayList;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String A() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.e B() {
        return this.m;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.f[] C() {
        return this.n;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.f[] D() {
        return this.o;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.f[] E() {
        return this.p;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.f[] F() {
        return this.q;
    }

    @Override // sg.bigo.ads.api.core.c
    public final List<sg.bigo.ads.api.core.c.InterfaceC0857c> G() {
        return this.r;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String H() {
        return this.s;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String I() {
        return this.u;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean J() {
        if (!this.M || this.N <= 0) {
            return SystemClock.elapsedRealtime() - this.F >= this.E * 1000;
        }
        return System.currentTimeMillis() > this.N;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    @Override // sg.bigo.ads.api.core.c
    public final long K() {
        long jElapsedRealtime;
        if (this.M) {
            long j = this.N;
            if (j > 0) {
                long j2 = j - (this.E * 1000);
                jElapsedRealtime = j2 > 0 ? System.currentTimeMillis() - j2 : 0L;
            } else {
                jElapsedRealtime = SystemClock.elapsedRealtime() - this.F;
            }
        } else {
            jElapsedRealtime = SystemClock.elapsedRealtime() - this.F;
        }
        if (jElapsedRealtime > 0) {
            return jElapsedRealtime;
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.core.c
    public final long L() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String M() {
        return this.v;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.b N() {
        return this.w;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.a O() {
        return this.x;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int P() {
        return this.A;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String Q() {
        return this.ab;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int R() {
        return this.ac;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void S() {
        this.ac = this.ad;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void T() {
        this.ae = true;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean U() {
        return this.ae;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int V() {
        return this.af;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int W() {
        return this.ah;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int X() {
        return this.ai;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.q Y() {
        return this.ak;
    }

    @Override // sg.bigo.ads.api.core.c
    public final long Z() {
        return this.G;
    }

    @Override // sg.bigo.ads.api.core.c
    public final long a() {
        return sg.bigo.ads.api.a.i.f13093a.i();
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(int i, int i2, boolean z) {
        if (!this.ag || z) {
            this.ag = true;
            this.ah = i;
            this.ai = i2;
        }
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(long j) {
        this.N = j;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(String str) {
        this.ab = str;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(sg.bigo.ads.api.core.q qVar) {
        this.ak = qVar;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(boolean z) {
        this.T = z ? 1 : 2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean a(int i) {
        return (this.t & ((long) i)) > 0;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.h aa() {
        return this.H;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String ab() {
        int i = this.i;
        if (i == 3 && this.h == 3) {
            return "1999999";
        }
        if (i == 4 && this.h == 3) {
            return "2999999";
        }
        return !sg.bigo.ads.common.utils.q.a((CharSequence) this.O) ? this.O : this.b.p();
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ac() {
        return this.J == 1;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ad() {
        return this.K;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ae() {
        return this.L;
    }

    @Override // sg.bigo.ads.api.core.c
    public final JSONObject af() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void ag() {
        this.M = true;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ah() {
        return this.M;
    }

    @Override // sg.bigo.ads.api.core.c
    public final double ai() {
        return this.U;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int aj() {
        return this.b.v();
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ak() {
        return this.b.v() == 2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean al() {
        return this.W;
    }

    @Override // sg.bigo.ads.api.core.c
    public final List<sg.bigo.ads.api.core.c> am() {
        return this.f13416a;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String an() {
        return this.al;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ao() {
        return this.am;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ap() {
        return this.an;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int aq() {
        return this.ao;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ar() {
        return this.aj == 1;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int as() {
        return this.ap;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int at() {
        return this.C;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String b() {
        return this.b.l();
    }

    @Override // sg.bigo.ads.api.core.c
    public final String b(String str) {
        if (str == null) {
            return "";
        }
        Map<String, String> map = this.B;
        String str2 = map != null ? map.get(str) : "";
        return str2 == null ? "" : str2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void b(int i) {
        this.ad = i;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String c() {
        return this.b.n();
    }

    @Override // sg.bigo.ads.api.core.c
    public final void c(int i) {
        this.af = i;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.a.l d() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void d(int i) {
        this.K = i;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.a.m e() {
        return this.y;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void e(int i) {
        this.L = i;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.a.e f() {
        return this.aq;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int g() {
        return this.T;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean h() {
        sg.bigo.ads.api.a.m mVar = this.y;
        return mVar != null && mVar.a("endpage.ad_component_layout") == 5;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String i() {
        return this.P;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean j() {
        return this.Q;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean k() {
        return this.R;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String l() {
        return this.S;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String m() {
        return this.V;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String n() {
        return this.X;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String o() {
        return this.Y;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String p() {
        return this.Z;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.c.d q() {
        return this.aa;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String r() {
        return this.c;
    }

    @Override // sg.bigo.ads.api.core.c
    public String s() {
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.d)) {
            return this.d;
        }
        sg.bigo.ads.api.core.c.d dVar = this.aa;
        return (dVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) dVar.b())) ? this.d : this.aa.b();
    }

    @Override // sg.bigo.ads.api.core.c
    public String t() {
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.e)) {
            return this.e;
        }
        sg.bigo.ads.api.core.c.d dVar = this.aa;
        return (dVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) dVar.c())) ? this.e : this.aa.c();
    }

    @Override // sg.bigo.ads.api.core.c
    public final String u() {
        return this.f;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String v() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int w() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int x() {
        return this.i;
    }

    @Override // sg.bigo.ads.api.core.c
    public final long y() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String z() {
        return this.k;
    }
}
