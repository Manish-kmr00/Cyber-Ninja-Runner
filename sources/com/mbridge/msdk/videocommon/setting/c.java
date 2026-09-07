package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.i0;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardUnitSetting.java */
/* JADX INFO: loaded from: classes13.dex */
public class c {
    private static g W;
    public static String X;
    private int E;
    private int G;
    private JSONArray U;
    private JSONObject V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5983a;
    private String b;
    private List<com.mbridge.msdk.videocommon.entity.b> c;
    private long d;
    private ArrayList<Integer> t;
    private int e = -1;
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 5;
    private int m = 1;
    private int n = 3;
    private int o = 80;
    private int p = 100;
    private int q = 0;
    private double r = 1.0d;
    private int s = -1;
    private int u = 3;
    private int v = 1;
    private int w = 100;
    private int x = 60;
    private int y = 0;
    private int z = 70;
    private int A = 0;
    private int B = -1;
    private int C = -1;
    private int D = -1;
    private int F = 20;
    private int H = 0;
    private int I = 1;
    private String J = "";
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "Virtual Item";
    private String O = "";
    private String P = "";
    private int Q = 0;
    private int R = 1;
    private int S = 60;
    private String T = "";

    public void A(int i) {
        this.y = i;
    }

    public void B(int i) {
        this.v = i;
    }

    public void C(int i) {
        this.o = i;
    }

    public int D() {
        return this.D;
    }

    public int E() {
        return this.C;
    }

    public int F() {
        return this.B;
    }

    public void G(int i) {
        this.D = i;
    }

    public void H(int i) {
        this.C = i;
    }

    public void I(int i) {
        this.B = i;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.t = arrayList;
    }

    public void b(String str) {
        this.O = str;
        com.mbridge.msdk.foundation.controller.a.r.put(this.f5983a, str);
    }

    public void c(int i) {
        if (i <= 0) {
            this.K = 1;
        } else {
            this.K = i;
        }
    }

    public void d(int i) {
        this.H = i;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.N = this.J;
        } else {
            this.N = str;
        }
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.P = str;
    }

    public int h() {
        return this.g;
    }

    public void i(String str) {
        this.J = str;
    }

    public void j(int i) {
        this.g = i;
    }

    public int k() {
        return this.A;
    }

    public void l(int i) {
        this.M = i;
    }

    public void m(int i) {
        this.A = i;
    }

    public void n(int i) {
        this.m = i;
    }

    public void o(int i) {
        this.G = i;
    }

    public int p() {
        return this.w;
    }

    public int q() {
        return this.x;
    }

    public int r() {
        return this.l;
    }

    public void s(int i) {
        this.w = i;
    }

    public void t(int i) {
        this.x = i;
    }

    public int u() {
        return this.e;
    }

    public void v(int i) {
        this.f = i;
    }

    public void w(int i) {
        this.e = i;
    }

    public String x() {
        return this.P;
    }

    public int y() {
        return this.y;
    }

    public void z(int i) {
        this.s = i;
    }

    public int A() {
        return this.v;
    }

    public JSONArray B() {
        return this.U;
    }

    public int C() {
        return this.R;
    }

    public void D(int i) {
        this.n = i;
    }

    public void E(int i) {
        this.k = i;
    }

    public void F(int i) {
        this.R = i;
    }

    public String G() {
        return this.T;
    }

    public JSONObject H() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unitId", this.f5983a);
            jSONObject.put("callbackType", this.h);
            List<com.mbridge.msdk.videocommon.entity.b> list = this.c;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.entity.b bVar : this.c) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.i);
            jSONObject.put("acn", this.j);
            jSONObject.put("vcn", this.k);
            jSONObject.put("offset", this.l);
            jSONObject.put("dlnet", this.m);
            jSONObject.put("tv_start", this.n);
            jSONObject.put("tv_end", this.o);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.p);
            jSONObject.put("endscreen_type", this.G);
            jSONObject.put("daily_play_cap", this.A);
            jSONObject.put("video_skip_time", this.B);
            jSONObject.put("video_skip_result", this.C);
            jSONObject.put("video_interactive_type", this.D);
            jSONObject.put("orientation", this.y);
            jSONObject.put("close_button_delay", this.E);
            jSONObject.put("playclosebtn_tm", this.e);
            jSONObject.put("play_ctdown", this.f);
            jSONObject.put("close_alert", this.g);
            jSONObject.put("rfpv", this.s);
            jSONObject.put("vdcmp", this.r);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.t;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.t.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.u);
            jSONObject.put("tmorl", this.v);
            jSONObject.put("placementid", this.b);
            jSONObject.put("ltafemty", this.w);
            jSONObject.put("ltorwc", this.x);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.H);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.I);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.J);
            jSONObject.put("amount", this.K);
            jSONObject.put("icon", this.L);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.M);
            jSONObject.put("name", this.N);
            jSONObject.put("isDefault", this.Q);
            jSONObject.put("video_error_rule", this.R);
            jSONObject.put("loadtmo", this.S);
            jSONObject.put("vtag", this.T);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String a() {
        return this.O;
    }

    public int d() {
        return this.K;
    }

    public int f() {
        return this.u;
    }

    public void g(int i) {
        this.I = i;
    }

    public void h(int i) {
        this.h = i;
    }

    public int i() {
        return this.E;
    }

    public void j(String str) {
        this.T = str;
    }

    public void k(int i) {
        this.E = i;
    }

    public int l() {
        return this.m;
    }

    public int m() {
        return this.G;
    }

    public int n() {
        return this.z;
    }

    public int o() {
        return this.S;
    }

    public void p(int i) {
        this.z = i;
    }

    public void q(int i) {
        this.Q = i;
    }

    public void r(int i) {
        this.S = i;
    }

    public String s() {
        return this.N;
    }

    public String t() {
        return this.b;
    }

    public void u(int i) {
        this.l = i;
    }

    public int v() {
        return this.F;
    }

    public int w() {
        return this.p;
    }

    public void x(int i) {
        this.F = i;
    }

    public void y(int i) {
        this.p = i;
    }

    public Queue<Integer> z() {
        LinkedList linkedList;
        Exception e;
        try {
            List<com.mbridge.msdk.videocommon.entity.b> list = this.c;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            for (int i = 0; i < this.c.size(); i++) {
                try {
                    linkedList.add(Integer.valueOf(this.c.get(i).b()));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
            return linkedList;
        } catch (Exception e3) {
            linkedList = null;
            e = e3;
        }
        e.printStackTrace();
        return linkedList;
    }

    public void a(long j) {
        this.d = j;
    }

    public int b() {
        return this.j;
    }

    public void d(String str) {
        this.L = str;
    }

    public void f(int i) {
        this.u = i;
    }

    public int g() {
        return this.q;
    }

    public void h(String str) {
        this.f5983a = str;
    }

    public void i(int i) {
        this.q = i;
    }

    public long j() {
        return this.d;
    }

    public void a(List<com.mbridge.msdk.videocommon.entity.b> list) {
        this.c = list;
    }

    public void b(int i) {
        this.j = i;
    }

    public String c() {
        return X;
    }

    public void a(double d) {
        this.r = d;
    }

    public void b(JSONObject jSONObject) {
        this.V = jSONObject;
    }

    public void c(String str) {
        X = str;
    }

    public int e() {
        return this.i;
    }

    public boolean a(int i) {
        ArrayList<Integer> arrayList = this.t;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.t.contains(Integer.valueOf(i));
    }

    public void e(int i) {
        this.i = i;
    }

    public static c a(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (W == null) {
            W = g.a(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
                String strOptString = jSONObjectJsonObjectInit.optString("vtag", "");
                String strOptString2 = jSONObjectJsonObjectInit.optString(l.x, "");
                JSONArray jSONArrayOptJSONArray = jSONObjectJsonObjectInit.optJSONArray("unitSetting");
                if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String strOptString3 = jSONObjectOptJSONObject.optString("unitId");
                if (TextUtils.isEmpty(strOptString3)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.j(strOptString);
                    cVar2.g(strOptString2);
                    List<com.mbridge.msdk.videocommon.entity.b> listA = com.mbridge.msdk.videocommon.entity.b.a(jSONObjectOptJSONObject.optJSONArray("adSourceList"));
                    cVar2.h(strOptString3);
                    cVar2.a(listA);
                    cVar2.h(jSONObjectOptJSONObject.optInt("callbackType"));
                    int iOptInt = jSONObjectOptJSONObject.optInt("aqn", 1);
                    if (iOptInt <= 0) {
                        iOptInt = 1;
                    }
                    cVar2.e(iOptInt);
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("acn", 1);
                    if (iOptInt2 < 0) {
                        iOptInt2 = 1;
                    }
                    cVar2.b(iOptInt2);
                    cVar2.E(jSONObjectOptJSONObject.optInt("vcn", 5));
                    cVar2.u(jSONObjectOptJSONObject.optInt("offset", 5));
                    cVar2.n(jSONObjectOptJSONObject.optInt("dlnet", 1));
                    cVar2.o(jSONObjectOptJSONObject.optInt("endscreen_type", 2));
                    cVar2.D(jSONObjectOptJSONObject.optInt("tv_start", 3));
                    cVar2.C(jSONObjectOptJSONObject.optInt("tv_end", 80));
                    cVar2.y(jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
                    cVar2.i(jSONObjectOptJSONObject.optInt("cd_rate", 0));
                    cVar2.a(jSONObjectJsonObjectInit.optLong("current_time"));
                    cVar2.A(jSONObjectOptJSONObject.optInt("orientation", 0));
                    cVar2.m(jSONObjectOptJSONObject.optInt("daily_play_cap", 0));
                    cVar2.I(jSONObjectOptJSONObject.optInt("video_skip_time", -1));
                    cVar2.H(jSONObjectOptJSONObject.optInt("video_skip_result", 2));
                    cVar2.G(jSONObjectOptJSONObject.optInt("video_interactive_type", -1));
                    cVar2.k(jSONObjectOptJSONObject.optInt("close_button_delay", 1));
                    cVar2.w(jSONObjectOptJSONObject.optInt("playclosebtn_tm", -1));
                    cVar2.v(jSONObjectOptJSONObject.optInt("play_ctdown", 0));
                    cVar2.j(jSONObjectOptJSONObject.optInt("close_alert", 0));
                    cVar2.x(jSONObjectOptJSONObject.optInt("rdrct", 20));
                    cVar2.p(jSONObjectOptJSONObject.optInt("load_global_timeout", 70));
                    cVar2.z(jSONObjectOptJSONObject.optInt("rfpv", -1));
                    cVar2.a(jSONObjectOptJSONObject.optDouble("vdcmp", 1.0d));
                    cVar2.c(jSONObjectOptJSONObject.optString("atzu"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        cVar2.a(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int iOptInt3 = jSONObjectOptJSONObject.optInt("atl_dyt", 0);
                    cVar2.f(iOptInt3 > 0 ? iOptInt3 : 3);
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("tmorl", 1);
                    if (iOptInt4 > 2 || iOptInt4 <= 0) {
                        iOptInt4 = 1;
                    }
                    cVar2.B(iOptInt4);
                    cVar2.f(jSONObjectOptJSONObject.optString("placementid"));
                    cVar2.s(jSONObjectOptJSONObject.optInt("ltafemty", 10));
                    cVar2.t(jSONObjectOptJSONObject.optInt("ltorwc", 60));
                    cVar2.b(jSONObjectOptJSONObject.optString("ab_id"));
                    cVar2.d(jSONObjectOptJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0));
                    cVar2.g(jSONObjectOptJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1));
                    cVar2.i(jSONObjectOptJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, ""));
                    cVar2.c(jSONObjectOptJSONObject.optInt("amount", 1));
                    cVar2.d(jSONObjectOptJSONObject.optString("icon", ""));
                    cVar2.l(jSONObjectOptJSONObject.optInt(RewardPlus.CURRENCY_ID, 1));
                    cVar2.e(jSONObjectOptJSONObject.optString("name", "Virtual Item"));
                    cVar2.F(jSONObjectOptJSONObject.optInt("video_error_rule", 1));
                    cVar2.r(jSONObjectOptJSONObject.optInt("loadtmo", 60));
                    cVar2.a(jSONObjectOptJSONObject.optJSONArray("local_cache_info"));
                    try {
                        String strOptString4 = jSONObjectOptJSONObject.optString("retry_strategy");
                        if (!TextUtils.isEmpty(strOptString4)) {
                            String strA = i0.a(strOptString4);
                            if (!TextUtils.isEmpty(strA)) {
                                cVar2.b(MintegralNetworkBridge.jsonObjectInit(strA));
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return cVar2;
                } catch (Exception e2) {
                    e = e2;
                    cVar = cVar2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            e.printStackTrace();
        }
        return cVar;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                cVar2.a(com.mbridge.msdk.videocommon.entity.b.a(jSONObject.optJSONArray("adSourceList")));
                cVar2.h(jSONObject.optInt("callbackType"));
                int iOptInt = jSONObject.optInt("aqn", 1);
                if (iOptInt <= 0) {
                    iOptInt = 1;
                }
                cVar2.e(iOptInt);
                int iOptInt2 = jSONObject.optInt("acn", 1);
                if (iOptInt2 < 0) {
                    iOptInt2 = 1;
                }
                cVar2.b(iOptInt2);
                cVar2.E(jSONObject.optInt("vcn", 5));
                cVar2.u(jSONObject.optInt("offset", 5));
                cVar2.n(jSONObject.optInt("dlnet", 1));
                cVar2.o(jSONObject.optInt("endscreen_type", 2));
                cVar2.D(jSONObject.optInt("tv_start", 3));
                cVar2.C(jSONObject.optInt("tv_end", 80));
                cVar2.y(jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
                cVar2.a(jSONObject.optLong("current_time"));
                cVar2.A(jSONObject.optInt("orientation", 0));
                cVar2.m(jSONObject.optInt("daily_play_cap", 0));
                cVar2.I(jSONObject.optInt("video_skip_time", -1));
                cVar2.H(jSONObject.optInt("video_skip_result", 2));
                cVar2.G(jSONObject.optInt("video_interactive_type", -1));
                cVar2.k(jSONObject.optInt("close_button_delay", 1));
                cVar2.w(jSONObject.optInt("playclosebtn_tm", -1));
                cVar2.v(jSONObject.optInt("play_ctdown", 0));
                cVar2.j(jSONObject.optInt("close_alert", 0));
                cVar2.x(jSONObject.optInt("rdrct", 20));
                cVar2.z(jSONObject.optInt("rfpv", -1));
                cVar2.a(jSONObject.optDouble("vdcmp", 1.0d));
                cVar2.p(jSONObject.optInt("load_global_timeout", 70));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (jSONArrayOptJSONArray != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar2.a(arrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cVar2.f(jSONObject.optInt("atl_dyt", 3));
                int iOptInt3 = jSONObject.optInt("tmorl", 1);
                if (iOptInt3 > 2 || iOptInt3 <= 0) {
                    iOptInt3 = 1;
                }
                cVar2.B(iOptInt3);
                cVar2.f(jSONObject.optString("placementid"));
                cVar2.s(jSONObject.optInt("ltafemty", 10));
                cVar2.t(jSONObject.optInt("ltorwc", 60));
                cVar2.b(jSONObject.optString("ab_id"));
                cVar2.g(jSONObject.optString(l.x, ""));
                cVar2.d(jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0));
                cVar2.g(jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1));
                cVar2.i(jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, ""));
                cVar2.c(jSONObject.optInt("amount", 1));
                cVar2.d(jSONObject.optString("icon", ""));
                cVar2.l(jSONObject.optInt(RewardPlus.CURRENCY_ID, 1));
                cVar2.e(jSONObject.optString("name", "Virtual Item"));
                cVar2.F(jSONObject.optInt("video_error_rule", 1));
                cVar2.r(jSONObject.optInt("loadtmo", 60));
                cVar2.j(jSONObject.optString("vtag", ""));
                cVar2.a(jSONObject.optJSONArray("local_cache_info"));
                try {
                    String strOptString = jSONObject.optString("retry_strategy");
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strA = i0.a(strOptString);
                        if (!TextUtils.isEmpty(strA)) {
                            cVar2.b(MintegralNetworkBridge.jsonObjectInit(strA));
                        }
                    }
                } catch (Exception unused) {
                }
                return cVar2;
            } catch (Exception e2) {
                e = e2;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void a(JSONArray jSONArray) {
        this.U = jSONArray;
    }
}
