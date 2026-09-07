package com.mbridge.msdk.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.yandex.div.core.timer.TimerController;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseSetting.java */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    public static int c1 = 1500;
    private boolean D0;
    private long F;
    private JSONArray F0;
    private JSONObject G0;
    private ArrayList<Integer> H;
    private d I;
    private long I0;
    private C0485b J;
    private long N0;
    private HashMap<String, String> O;
    private boolean O0;
    private String P;
    private int U;
    private String U0;
    private String X;
    private Map<String, String> Y;
    private int a1;
    private String b1;
    private int h0;
    private String k0;
    private int l;
    private String l0;
    private List<com.mbridge.msdk.foundation.entity.a> n;
    private int o0;
    private long p;
    private int p0;
    private com.mbridge.msdk.setting.a q;
    private int q0;
    private String r;
    private int r0;
    private Map<String, a> s;
    private boolean t;
    private int u;
    private long u0;
    private long v0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5389a = false;
    private JSONArray b = new JSONArray();
    private JSONArray c = new JSONArray();
    private String d = "";
    private int e = 0;
    private int f = 0;
    private int g = 2;
    private int h = 0;
    private String i = "";
    private String j = "";
    private String k = "";
    private int m = 0;
    private int o = 0;
    private int v = 1;
    private boolean w = false;
    private String x = "";
    private String y = "";
    private String z = "";
    private String A = "";
    private String B = "";
    private int C = 120;
    private String D = com.mbridge.msdk.foundation.same.net.utils.d.h().i;
    private String E = com.mbridge.msdk.foundation.same.net.utils.d.h().m;
    private int G = c1;
    private int K = 0;
    private long L = 86400;
    private int M = 0;
    private int N = 3;
    private boolean Q = true;
    private int R = 0;
    private boolean S = false;
    private boolean T = false;
    private int V = 0;
    private int W = 0;
    private String Z = "1.0";
    private int a0 = 30;
    private int b0 = 9377;
    private int c0 = 0;
    private int d0 = 5;
    private int e0 = 1;
    private int f0 = 8000;
    private String g0 = "";
    private int i0 = 10;
    private int j0 = 120;
    private String m0 = "";
    private String n0 = "";
    private String s0 = "";
    private String t0 = "";
    private List<Integer> w0 = new ArrayList();
    private int x0 = 3;
    private int y0 = 0;
    private int z0 = 3;
    private int A0 = 0;
    private int B0 = 10;
    private int C0 = 600;
    private int E0 = 0;
    private String H0 = "";
    private int J0 = 8000;
    private int K0 = 1;
    private long L0 = 10;
    private int M0 = 3;
    private int P0 = 1;
    private int Q0 = 1;
    private int R0 = 1;
    private int S0 = 1;
    private String T0 = "";
    private int V0 = IronSourceConstants.RV_AUCTION_REQUEST;
    private int W0 = 0;
    private int X0 = 0;
    private long Y0 = 3600;
    private String Z0 = "";

    /* JADX INFO: compiled from: BaseSetting.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f5390a;
        private List<String> b;
        private List<String> c;
        private List<String> d;

        public List<String> a() {
            return this.f5390a;
        }

        public List<String> b() {
            return this.b;
        }

        public List<String> c() {
            return this.c;
        }

        public List<String> d() {
            return this.d;
        }

        public void a(JSONObject jSONObject) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(VastAttributes.HORIZONTAL_POSITION);
                if (jSONArrayOptJSONArray != null) {
                    this.c = b0.a(jSONArrayOptJSONArray);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(VastAttributes.VERTICAL_POSITION);
                if (jSONArrayOptJSONArray2 != null) {
                    this.d = b0.a(jSONArrayOptJSONArray2);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("width");
                if (jSONArrayOptJSONArray3 != null) {
                    this.b = b0.a(jSONArrayOptJSONArray3);
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("height");
                if (jSONArrayOptJSONArray4 != null) {
                    this.f5390a = b0.a(jSONArrayOptJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String a(Context context, String str) {
        try {
            g gVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (gVarD != null && gVarD.G() != null) {
                String host = Uri.parse(str).getHost();
                Iterator<Map.Entry<String, String>> it = gVarD.G().entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(host) && host.contains(key)) {
                        String str2 = gVarD.G().get(key);
                        return TextUtils.isEmpty(str2) ? "" : str2.replace("{gaid}", com.mbridge.msdk.foundation.tools.f.d());
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public long A() {
        return this.L;
    }

    public boolean A0() {
        return this.Q;
    }

    public int B() {
        return this.N;
    }

    public boolean B0() {
        return this.t;
    }

    public HashMap<String, String> C() {
        return this.O;
    }

    public boolean C0() {
        return this.w;
    }

    public void D(int i) {
        this.a1 = i;
    }

    public boolean D0() {
        return this.S;
    }

    public int E() {
        return this.U;
    }

    public boolean E0() {
        return this.f5389a;
    }

    public int F() {
        return this.V;
    }

    public boolean F0() {
        return (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.x)) ? false : true;
    }

    public Map<String, String> G() {
        return this.Y;
    }

    public boolean G0() {
        return (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.y)) ? false : true;
    }

    public JSONArray H() {
        return this.b;
    }

    public boolean H0() {
        return this.T;
    }

    public JSONArray I() {
        return this.c;
    }

    public boolean I0() {
        return this.D0;
    }

    public String J() {
        return this.Z;
    }

    public boolean J0() {
        return this.O0;
    }

    public int K() {
        return this.e0;
    }

    public void K0() {
        String language = Locale.getDefault().getLanguage();
        if (!G0()) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.B = "Confirm to close? ";
                this.z = "You will not be rewarded after closing the window";
                this.A = "Close it";
                this.y = "Continue";
            } else {
                this.B = "确认关闭？";
                this.z = "关闭后您将不会获得任何奖励噢~ ";
                this.A = "确认关闭";
                this.y = "继续观看";
            }
        }
        if (F0()) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.B = "Confirm to close? ";
            this.z = "You will not be rewarded after closing the window";
            this.A = "Close it";
            this.x = "Continue";
            return;
        }
        this.B = "确认关闭？";
        this.z = "关闭后您将不会获得任何奖励噢~ ";
        this.A = "确认关闭";
        this.x = "继续试玩";
    }

    public int L() {
        return this.f0;
    }

    public int M() {
        return this.h0;
    }

    public int N() {
        return this.j0;
    }

    public String O() {
        return this.k0;
    }

    public String P() {
        return this.l0;
    }

    public String Q() {
        return this.Z0;
    }

    public long R() {
        return this.Y0;
    }

    public int S() {
        return this.a1;
    }

    public String T() {
        return this.m0;
    }

    public String U() {
        return this.n0;
    }

    public int V() {
        return this.o0;
    }

    public int W() {
        return this.p0;
    }

    public int X() {
        return this.q0;
    }

    public int Y() {
        return this.r0;
    }

    public long Z() {
        return this.u0;
    }

    public long a0() {
        if (this.v0 <= 0) {
            this.v0 = 7200L;
        }
        return this.v0;
    }

    public void b(Map<String, String> map) {
        this.Y = map;
    }

    public int b0() {
        return this.x0;
    }

    public void c(int i) {
        this.e = i;
    }

    public int c0() {
        return this.y0;
    }

    public void d(long j) {
        this.Y0 = j;
    }

    public int d0() {
        return this.z0;
    }

    public void e(int i) {
        this.g = i;
    }

    public int e0() {
        return this.A0;
    }

    public void f(int i) {
        this.h = i;
    }

    public int f0() {
        return this.B0;
    }

    public void g(int i) {
        this.l = i;
    }

    public int g0() {
        return this.C0;
    }

    public void h(int i) {
        this.m = i;
    }

    public int h0() {
        return this.E0;
    }

    public void i(int i) {
        this.o = i;
    }

    public JSONArray i0() {
        return this.F0;
    }

    public com.mbridge.msdk.setting.a j() {
        return this.q;
    }

    public JSONObject j0() {
        return this.G0;
    }

    public String k() {
        return this.r;
    }

    public String k0() {
        return this.H0;
    }

    public Map<String, a> l() {
        return this.s;
    }

    public long l0() {
        return this.I0;
    }

    public int m() {
        return this.u;
    }

    public int m0() {
        return this.J0;
    }

    public int n() {
        return this.v;
    }

    public int n0() {
        return this.K0;
    }

    public String o() {
        return this.x;
    }

    public long o0() {
        return this.L0 * 1000;
    }

    public String p() {
        return this.y;
    }

    public int p0() {
        return this.M0;
    }

    public String q() {
        return this.z;
    }

    public long q0() {
        return this.N0;
    }

    public String r() {
        return this.A;
    }

    public int r0() {
        return this.P0;
    }

    public String s() {
        return this.B;
    }

    public int s0() {
        return this.Q0;
    }

    public void t(String str) {
        this.Z0 = str;
    }

    public int t0() {
        return this.R0;
    }

    public String toString() {
        return " cfc=" + this.u + " getpf=" + this.L + " rurl=" + this.D0;
    }

    public String u() {
        return this.D;
    }

    public int u0() {
        return this.S0;
    }

    public String v() {
        return this.E;
    }

    public String v0() {
        return this.T0;
    }

    public long w() {
        return this.F;
    }

    public String w0() {
        return this.U0;
    }

    public ArrayList<Integer> x() {
        return this.H;
    }

    public int x0() {
        return this.V0;
    }

    public d y() {
        return this.I;
    }

    public int y0() {
        return this.W0;
    }

    public C0485b z() {
        return this.J;
    }

    public int z0() {
        return this.X0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static g b(JSONObject jSONObject) {
        g gVar = null;
        arrayList = null;
        ArrayList arrayList = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            g gVar2 = new g();
            try {
                gVar2.c(jSONObject);
                gVar2.f(jSONObject.optString("cc"));
                gVar2.s(jSONObject.optString("mv_wildcard", "<mvpackage>mbridge</mvpackage>"));
                gVar2.j(jSONObject.optInt("cfc"));
                gVar2.c(jSONObject.optLong("getpf"));
                gVar2.b(jSONObject.optLong("current_time"));
                gVar2.b(jSONObject.optBoolean("cfb"));
                gVar2.a(jSONObject.optLong("awct"));
                gVar2.e(jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT));
                gVar2.g(jSONObject.optBoolean("rurl"));
                gVar2.i(jSONObject.optLong("uct"));
                gVar2.h(jSONObject.optBoolean("ujds"));
                gVar2.G(jSONObject.optInt("n2"));
                gVar2.H(jSONObject.optInt("n3"));
                gVar2.r(jSONObject.optInt("is_startup_crashsystem", 1));
                gVar2.F(jSONObject.optInt("pcrn"));
                gVar2.f(jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB));
                gVar2.F(jSONObject.optInt("pcrn", 100));
                gVar2.E(jSONObject.optInt("opent", 1));
                gVar2.g(jSONObject.optLong("sfct", 1800L));
                gVar2.U(jSONObject.optInt("upgd", 1));
                gVar2.V(jSONObject.optInt("upsrl", 1));
                gVar2.T(jSONObject.optInt("updevid", 1));
                gVar2.O(jSONObject.optInt("sc", 0));
                gVar2.S(jSONObject.optInt("up_tips", 1));
                gVar2.s(jSONObject.optInt("iseu", -1));
                gVar2.p(jSONObject.optString("jm_unit"));
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atf");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            String strOptString = jSONArrayOptJSONArray.optString(i);
                            if (y0.b(strOptString)) {
                                JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(strOptString);
                                arrayList.add(new com.mbridge.msdk.foundation.entity.a(jSONObjectJsonObjectInit.optInt("adtype"), jSONObjectJsonObjectInit.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList != null) {
                        gVar2.a((List<com.mbridge.msdk.foundation.entity.a>) arrayList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gVar2.g(jSONObject.optInt("adct", 259200));
                gVar2.k(jSONObject.optString("confirm_title", ""));
                gVar2.i(jSONObject.optString("confirm_description", ""));
                gVar2.j(jSONObject.optString("confirm_t", ""));
                gVar2.h(jSONObject.optString("confirm_c_rv", ""));
                gVar2.g(jSONObject.optString("confirm_c_play", ""));
                gVar2.c(jSONObject.optString("adchoice_icon", ""));
                gVar2.d(jSONObject.optString("adchoice_link", ""));
                gVar2.e(jSONObject.optString("adchoice_size", ""));
                gVar2.w(jSONObject.optString("platform_logo", ""));
                gVar2.x(jSONObject.optString("platform_name", ""));
                gVar2.a(a(jSONObject.optString("cdnate_cfg", "")));
                gVar2.i(jSONObject.optInt("atrqt", 0));
                gVar2.t(jSONObject.optInt("iupdid", 0));
                gVar2.C(jSONObject.optInt("mcs", 120));
                gVar2.b(jSONObject.optString("ab_id", ""));
                gVar2.y(jSONObject.optString(com.safedk.android.analytics.brandsafety.l.x, ""));
                gVar2.q(jSONObject.optString("log_rate", "-1"));
                gVar2.v(jSONObject.optString("omsdkjs_url", ""));
                gVar2.u(jSONObject.optString("omsdkjs_h5_url", ""));
                gVar2.J(jSONObject.optInt("rty_tk_clk", 0));
                gVar2.L(jSONObject.optInt("rty_tk_imp", 0));
                gVar2.K(jSONObject.optInt("rty_cnt", 3));
                gVar2.N(jSONObject.optInt("rty_to", 600));
                gVar2.M(jSONObject.optInt("rty_inr", 10));
                gVar2.n(jSONObject.optString("dns"));
                gVar2.v(jSONObject.optString("omsdkjs_url", ""));
                gVar2.u(jSONObject.optString("omsdkjs_h5_url", ""));
                long jOptLong = jSONObject.optLong("tcto");
                if (jOptLong == 0) {
                    gVar2.h(10L);
                } else {
                    gVar2.h(jOptLong);
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("jt");
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        HashMap map = new HashMap();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                            map.put(jSONObjectOptJSONObject.optString("domain"), jSONObjectOptJSONObject.optString("format"));
                        }
                        gVar2.b(map);
                    }
                }
                gVar2.r(jSONObject.optString("mraid_js"));
                gVar2.B(jSONObject.optString("web_env_url"));
                int iOptInt = jSONObject.optInt("alrbs", 0);
                if (iOptInt > 2 || iOptInt < 0) {
                    iOptInt = 0;
                }
                gVar2.h(iOptInt);
                gVar2.e(jSONObject.optBoolean("GDPR_area", false));
                gVar2.l(jSONObject.optInt("ct", 120));
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("ercd");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        int iOptInt2 = jSONArrayOptJSONArray3.optInt(i3);
                        if (iOptInt2 != 0) {
                            arrayList2.add(Integer.valueOf(iOptInt2));
                        }
                    }
                    if (arrayList2.size() > 0) {
                        arrayList2.add(-1);
                        gVar2.a(arrayList2);
                    }
                }
                String strOptString2 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(strOptString2)) {
                    try {
                        JSONObject jSONObjectJsonObjectInit2 = MintegralNetworkBridge.jsonObjectInit(i0.a(strOptString2));
                        Iterator<String> itKeys = jSONObjectJsonObjectInit2.keys();
                        HashMap<String, String> map2 = new HashMap<>();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObjectJsonObjectInit2.optString(next)) && !TextUtils.isEmpty(i0.a(jSONObjectJsonObjectInit2.optString(next)))) {
                                map2.put(next, jSONObjectJsonObjectInit2.optString(next));
                            }
                        }
                        if (map2.size() > 0) {
                            gVar2.a(map2);
                        }
                    } catch (Exception e2) {
                        o0.b("SETTING", e2.getMessage());
                    }
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("refactor_switch");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray4.getJSONObject(i4);
                        Iterator<String> itKeys2 = jSONObject2.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject2.getBoolean(next2)) {
                                gVar2.a(Integer.parseInt(next2));
                            }
                        }
                    }
                }
                try {
                    int iOptInt3 = jSONObject.optInt("lqcnt", 30);
                    int iOptInt4 = jSONObject.optInt("lqto", 5);
                    int iOptInt5 = jSONObject.optInt("lqswt", 0);
                    int iOptInt6 = jSONObject.optInt("lqtype", 1);
                    gVar2.x(iOptInt4);
                    gVar2.u(iOptInt3);
                    gVar2.w(iOptInt5);
                    gVar2.y(iOptInt6);
                    gVar2.a(jSONObject.optJSONArray("lg_bl"));
                    gVar2.b(jSONObject.optJSONArray("lg_wl"));
                    gVar2.X(jSONObject.optInt("lg_wl_rt"));
                    gVar2.P(jSONObject.optInt("srml", 8000));
                    gVar2.z(jSONObject.optInt("lrml", 8000));
                    gVar2.W(jSONObject.optInt("wgl_d_ms", IronSourceConstants.RV_AUCTION_REQUEST));
                    gVar2.m(jSONObject.optInt("dp_ct", c1));
                    int i5 = Integer.parseInt(i0.a(jSONObject.optString("lqpt")));
                    if (i5 > 0 && i5 < 65535) {
                        gVar2.v(i5);
                    }
                } catch (Exception unused) {
                }
                gVar2.Y(jSONObject.optInt("wvddt", 0));
                gVar2.l(jSONObject.optString("hst_st", ""));
                gVar2.m(jSONObject.optString("hst_st_t", ""));
                try {
                    int iOptInt7 = jSONObject.optInt("l", 3);
                    boolean z = jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) == 1;
                    boolean z2 = jSONObject.optInt("m", 1) == 1;
                    gVar2.I(iOptInt7);
                    gVar2.f(z);
                    gVar2.a(z2);
                } catch (Exception e3) {
                    o0.b("Setting", e3.getMessage());
                }
                gVar2.n(jSONObject.optInt("fbk_swt", 0));
                gVar2.a(C0485b.a(jSONObject.optJSONObject("fbk")));
                try {
                    int iOptInt8 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.o);
                    int iOptInt9 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.q);
                    int iOptInt10 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.s);
                    int iOptInt11 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.r);
                    if (iOptInt8 <= 0) {
                        iOptInt8 = com.mbridge.msdk.foundation.same.a.o;
                    }
                    gVar2.c(iOptInt8);
                    if (iOptInt9 <= 0) {
                        iOptInt9 = com.mbridge.msdk.foundation.same.a.q;
                    }
                    gVar2.d(iOptInt9);
                    if (iOptInt10 <= 0) {
                        iOptInt10 = com.mbridge.msdk.foundation.same.a.s;
                    }
                    gVar2.f(iOptInt10);
                    if (iOptInt11 < 0) {
                        iOptInt11 = com.mbridge.msdk.foundation.same.a.r;
                    }
                    gVar2.e(iOptInt11);
                    int iOptInt12 = jSONObject.optInt("max_download_task_size", 10);
                    if (iOptInt12 <= 0) {
                        iOptInt12 = 10;
                    }
                    gVar2.B(iOptInt12);
                    gVar2.A(jSONObject.optInt("max_bitmap_cache_size", 10));
                    gVar2.R(jSONObject.optInt("t_t", 3));
                    gVar2.p(jSONObject.optInt("h_t", 3));
                    gVar2.o(jSONObject.optInt("gtp"));
                    gVar2.d(jSONObject.optLong("i_i_t", 3600L));
                    gVar2.t(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, ""));
                    gVar2.D(jSONObject.optInt("n_c_u_p", 0));
                } catch (Exception unused2) {
                }
                try {
                    gVar2.o(jSONObject.optString("http_track_url", ""));
                } catch (Exception unused3) {
                }
                gVar2.Q(jSONObject.optInt("st_net", 1));
                gVar2.A(jSONObject.optString("vtag", ""));
                try {
                    gVar2.c(jSONObject.optInt("check_webview", 0) != 0);
                } catch (Exception unused4) {
                    gVar2.c(false);
                }
                gVar2.z(jSONObject.optString("swxid"));
                gVar2.c(jSONObject.optJSONArray("sdk_filters"));
                try {
                    gVar2.k(jSONObject.optInt("ch_nv_im_cb", 1));
                } catch (Exception unused5) {
                    gVar2.k(1);
                }
                try {
                    gVar2.d(jSONObject.optInt("do_us_fi_re", 1) != 0);
                } catch (Exception unused6) {
                    gVar2.d(true);
                }
                try {
                    a(jSONObject);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                String strOptString3 = jSONObject.optString("bcp");
                if (!TextUtils.isEmpty(strOptString3)) {
                    gVar2.a(com.mbridge.msdk.setting.a.a(i0.a(strOptString3)));
                }
                String strOptString4 = jSONObject.optString("monitor");
                if (!TextUtils.isEmpty(strOptString4)) {
                    gVar2.a(d.a(i0.a(strOptString4)));
                }
                return gVar2;
            } catch (Exception e5) {
                e = e5;
                gVar = gVar2;
                e.printStackTrace();
                return gVar;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public void A(int i) {
        if (i > 0) {
            this.i0 = i;
        }
    }

    public void B(int i) {
        this.h0 = i;
    }

    public void C(int i) {
        this.j0 = i;
    }

    public int D() {
        return this.R;
    }

    public void E(int i) {
        this.o0 = i;
    }

    public void F(int i) {
        this.p0 = i;
    }

    public void G(int i) {
        this.q0 = i;
    }

    public void H(int i) {
        this.r0 = i;
    }

    public void I(int i) {
        this.x0 = i;
    }

    public void J(int i) {
        this.y0 = i;
    }

    public void K(int i) {
        this.z0 = i;
    }

    public void L(int i) {
        this.A0 = i;
    }

    public void M(int i) {
        this.B0 = i;
    }

    public void N(int i) {
        this.C0 = i;
    }

    public void O(int i) {
        this.E0 = i;
    }

    public void P(int i) {
        this.J0 = i;
    }

    public void Q(int i) {
        this.K0 = i;
    }

    public void R(int i) {
        this.M0 = i;
    }

    public void S(int i) {
        this.P0 = i;
    }

    public void T(int i) {
        this.Q0 = i;
    }

    public void U(int i) {
        this.R0 = i;
    }

    public void V(int i) {
        this.S0 = i;
    }

    public void W(int i) {
        this.V0 = i;
    }

    public void X(int i) {
        this.W0 = i;
    }

    public void Y(int i) {
        this.X0 = i;
    }

    public void c(String str) {
        this.i = str;
    }

    public void d(int i) {
        this.f = i;
    }

    public void e(String str) {
        this.k = str;
    }

    public int f() {
        return this.m;
    }

    public List<com.mbridge.msdk.foundation.entity.a> g() {
        return this.n;
    }

    public int h() {
        return this.o;
    }

    public long i() {
        return this.p;
    }

    public void j(int i) {
        this.u = i;
    }

    public void k(int i) {
        this.v = i;
    }

    public void l(int i) {
        this.C = i;
    }

    public void m(String str) {
        this.E = str;
    }

    public void n(int i) {
        this.K = i;
    }

    public void o(int i) {
        this.M = i;
        com.mbridge.msdk.foundation.same.net.utils.d.h().d(i);
    }

    public void p(int i) {
        this.N = i;
    }

    public void q(int i) {
        this.R = i;
    }

    public void r(int i) {
        this.U = i;
    }

    public void s(int i) {
        this.V = i;
    }

    public int t() {
        return this.C;
    }

    public void u(int i) {
        this.a0 = i;
    }

    public void v(int i) {
        this.b0 = i;
        com.mbridge.msdk.foundation.same.net.utils.d.h().b(i);
        com.mbridge.msdk.foundation.same.net.utils.d.h().c(i);
    }

    public void w(int i) {
        this.c0 = i;
    }

    public void x(int i) {
        this.d0 = i;
    }

    public void y(int i) {
        this.e0 = i;
    }

    public void z(int i) {
        this.f0 = i;
    }

    public void A(String str) {
        this.T0 = str;
    }

    public void B(String str) {
        this.U0 = str;
    }

    public String c() {
        return this.j;
    }

    public void d(String str) {
        this.j = str;
    }

    public int e() {
        return this.l;
    }

    public void f(String str) {
        this.r = str;
    }

    public void g(String str) {
        this.x = str;
    }

    public void h(String str) {
        this.y = str;
    }

    public void i(String str) {
        this.z = str;
    }

    public void j(String str) {
        this.A = str;
    }

    public void k(String str) {
        this.B = str;
    }

    public void l(String str) {
        this.D = str;
    }

    public void m(int i) {
        this.G = i;
        com.mbridge.msdk.click.utils.a.c = i;
    }

    public void n(String str) {
        this.b1 = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e.a().b(i0.a(str));
    }

    public void p(String str) {
        this.X = str;
    }

    public void q(String str) {
        this.Z = str;
    }

    public void r(String str) {
        this.k0 = str;
    }

    public void s(String str) {
        this.l0 = str;
    }

    public void t(int i) {
        this.W = i;
    }

    public void u(String str) {
        this.m0 = str;
    }

    public void w(String str) {
        this.s0 = str;
    }

    public void x(String str) {
        this.t0 = str;
    }

    public void y(String str) {
        this.H0 = str;
    }

    public void z(String str) {
        if (TextUtils.isEmpty(this.g0)) {
            return;
        }
        this.g0 = str;
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().i())) {
            com.mbridge.msdk.foundation.controller.c.m().d(this.g0);
        }
    }

    public void c(long j) {
        this.L = j;
    }

    public String d() {
        return this.k;
    }

    public void e(long j) {
        this.u0 = j;
    }

    public void f(long j) {
        this.v0 = j;
    }

    public void g(long j) {
        this.I0 = j;
    }

    public void h(long j) {
        this.L0 = j;
    }

    public void i(long j) {
        this.N0 = j;
    }

    public void o(String str) {
        this.P = str;
    }

    public void c(JSONArray jSONArray) {
        this.F0 = jSONArray;
    }

    public void d(boolean z) {
        this.S = z;
    }

    public void e(boolean z) {
        this.f5389a = z;
    }

    public void f(boolean z) {
        this.T = z;
    }

    public void g(boolean z) {
        this.D0 = z;
    }

    public void h(boolean z) {
        this.O0 = z;
    }

    public void v(String str) {
        this.n0 = str;
    }

    public void c(JSONObject jSONObject) {
        this.G0 = jSONObject;
    }

    public void c(boolean z) {
        this.w = z;
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.setting.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseSetting.java */
    public static class C0485b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5391a;
        private JSONArray b;
        private String c;
        private String d;
        private String e;
        private String f;

        public static C0485b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0485b c0485b = new C0485b();
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            c0485b.f = jSONObject.optString("title", contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_title", "string")));
            c0485b.f5391a = jSONObject.optString(TimerController.CANCEL_COMMAND, contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_close_close", "string")));
            c0485b.d = jSONObject.optString("submit", contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_close_submit", "string")));
            c0485b.e = jSONObject.optString("submit_notice", contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_submit_notice", "string")));
            c0485b.c = jSONObject.optString("privacy", contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_privacy_des", "string")));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content");
            c0485b.b = jSONArrayOptJSONArray;
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                c0485b.b = jSONArray;
                jSONArray.put(contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_content_not_play", "string")));
                c0485b.b.put(contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_content_sound_problems", "string")));
                c0485b.b.put(contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_content_misleading", "string")));
                c0485b.b.put(contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_content_fraud", "string")));
                c0485b.b.put(contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_content_por_violence", "string")));
                c0485b.b.put(contextD.getString(g0.a(contextD, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return c0485b;
        }

        public JSONArray b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public String a() {
            return this.f5391a;
        }
    }

    public static Map<String, a> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap map = new HashMap();
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            Iterator<String> itKeys = jSONObjectJsonObjectInit.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a aVar = new a();
                JSONObject jSONObjectOptJSONObject = jSONObjectJsonObjectInit.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    aVar.a(jSONObjectOptJSONObject);
                }
                map.put(next, aVar);
            }
            return map;
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public void a(int i) {
        this.w0.add(Integer.valueOf(i));
    }

    private static void a(JSONObject jSONObject) {
        FastKV fastKVBuild = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            try {
                fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), i0.a("H+tU+FeXHM==")).build();
            } catch (Exception unused) {
            }
        }
        if (fastKVBuild != null) {
            try {
                Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
                if (jSONObject == null || contextD == null) {
                    return;
                }
                String strOptString = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, strOptString)) {
                    com.mbridge.msdk.foundation.same.a.V = strOptString;
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                    try {
                        fastKVBuild.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    } catch (Exception unused2) {
                    }
                }
                String strOptString2 = jSONObject.optString(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
                if (TextUtils.isEmpty(strOptString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, strOptString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.g = strOptString2;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, com.mbridge.msdk.foundation.same.a.g);
                try {
                    fastKVBuild.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Context contextD2 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (jSONObject == null || contextD2 == null) {
                return;
            }
            String strOptString3 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, strOptString3)) {
                com.mbridge.msdk.foundation.same.a.V = strOptString3;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                SharedPreferences sharedPreferences = contextD2.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    editorEdit.apply();
                }
            }
            String strOptString4 = jSONObject.optString(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
            if (TextUtils.isEmpty(strOptString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, strOptString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.g = strOptString4;
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, com.mbridge.msdk.foundation.same.a.g);
            SharedPreferences sharedPreferences2 = contextD2.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                editorEdit2.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                editorEdit2.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String a() {
        return this.d;
    }

    public void a(List<com.mbridge.msdk.foundation.entity.a> list) {
        this.n = list;
    }

    public void a(long j) {
        this.p = j;
    }

    public void a(com.mbridge.msdk.setting.a aVar) {
        this.q = aVar;
    }

    public void a(Map<String, a> map) {
        this.s = map;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.H = arrayList;
    }

    public void a(d dVar) {
        this.I = dVar;
    }

    public void a(C0485b c0485b) {
        this.J = c0485b;
    }

    public void a(HashMap<String, String> map) {
        this.O = map;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.put("2000088");
        }
        this.b = jSONArray;
    }

    public void a(boolean z) {
        this.Q = z;
    }

    public void b(String str) {
        this.d = str;
    }

    public String b() {
        return this.i;
    }

    public void b(long j) {
        this.F = j;
    }

    public void b(JSONArray jSONArray) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.put("2000041");
            jSONArray.put("2000042");
            jSONArray.put("2000032");
            jSONArray.put("2000079");
        }
        this.c = jSONArray;
    }

    public void b(boolean z) {
        this.t = z;
    }

    public boolean b(int i) {
        return this.w0.contains(Integer.valueOf(i));
    }
}
