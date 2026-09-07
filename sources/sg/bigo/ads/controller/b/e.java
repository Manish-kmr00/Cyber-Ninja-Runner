package sg.bigo.ads.controller.b;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.events.CrashEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.n;
import sg.bigo.ads.api.a.o;
import sg.bigo.ads.api.core.l;
import sg.bigo.ads.api.core.m;
import sg.bigo.ads.api.core.s;
import sg.bigo.ads.api.core.t;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends sg.bigo.ads.common.e implements sg.bigo.ads.api.a.h {
    protected int A;
    protected boolean B;
    protected String C;
    protected String D;
    protected m E;
    protected sg.bigo.ads.api.a.g F;
    protected n G;
    protected o H;

    @Deprecated
    protected String I;
    protected Map<String, sg.bigo.ads.api.a.c> J;

    @Deprecated
    protected String K;
    protected String L;
    protected c M;
    protected int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sg.bigo.ads.api.a.b f13405a;
    private int e;
    private int f;
    protected sg.bigo.ads.common.a h;
    protected sg.bigo.ads.common.a i;
    protected sg.bigo.ads.common.s.a j;
    protected sg.bigo.ads.common.a k;
    protected long l;
    protected boolean m;
    protected long n;
    protected int o;
    protected String p;
    protected String q;
    protected int r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;

    @Deprecated
    protected String y;
    protected String z;

    public e(Context context) {
        super(context);
        this.r = 1;
        this.E = new m();
        this.F = new l();
        this.G = new s();
        this.H = new t();
        this.J = new HashMap();
        this.M = new c();
        this.f13405a = new b();
    }

    public static long y() {
        return r.f13300a.a(30);
    }

    public final String A() {
        return this.L;
    }

    public final boolean B() {
        return this.m;
    }

    public final String C() {
        return this.C;
    }

    public final n D() {
        return this.G;
    }

    public final sg.bigo.ads.common.a E() {
        if (this.h == null) {
            this.h = sg.bigo.ads.common.a.f13122a;
        }
        if (this.h.a()) {
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.controller.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = e.this;
                    eVar.h = sg.bigo.ads.common.o.c.a(eVar.b);
                    e.this.a(0L);
                }
            });
        }
        return this.h;
    }

    public final sg.bigo.ads.common.a F() {
        if (this.i == null) {
            this.i = sg.bigo.ads.common.a.f13122a;
        }
        if (this.i.a()) {
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.controller.b.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = e.this;
                    eVar.i = sg.bigo.ads.common.l.b.a(eVar.b);
                    e.this.a(0L);
                }
            });
        }
        return this.i;
    }

    public final sg.bigo.ads.common.a G() {
        if (this.k == null) {
            this.k = sg.bigo.ads.common.a.f13122a;
        }
        if (this.k.a()) {
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.controller.b.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = e.this;
                    eVar.k = sg.bigo.ads.common.k.a.a(eVar.b);
                    e.this.a(0L);
                }
            });
        }
        return this.k;
    }

    public final boolean H() {
        return this.l != 0;
    }

    @Override // sg.bigo.ads.common.e
    public final String a() {
        return "bigoad_config.dat";
    }

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        if (this.h == null) {
            this.h = sg.bigo.ads.common.a.f13122a;
        }
        this.h.a(parcel);
        if (this.i == null) {
            this.i = sg.bigo.ads.common.a.f13122a;
        }
        this.i.a(parcel);
        if (this.j == null) {
            this.j = new sg.bigo.ads.common.s.a(this.b);
        }
        this.j.a(parcel);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeLong(this.n);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeString(this.C);
        parcel.writeLong(this.l);
        this.E.a(parcel);
        parcel.writeString(this.D);
        this.F.a(parcel);
        parcel.writeString(this.I);
        Map<String, sg.bigo.ads.api.a.c> map = this.J;
        int size = map == null ? 0 : map.size();
        parcel.writeInt(size);
        if (size != 0) {
            for (Map.Entry<String, sg.bigo.ads.api.a.c> entry : map.entrySet()) {
                String key = entry.getKey();
                sg.bigo.ads.api.a.c value = entry.getValue();
                if (key == null || value == null) {
                    parcel.writeInt(0);
                } else {
                    sg.bigo.ads.common.n.a(parcel, value);
                    parcel.writeString(key);
                }
            }
        }
        parcel.writeString(this.K);
        this.G.a(parcel);
        this.H.a(parcel);
        parcel.writeString(this.L);
        sg.bigo.ads.common.n.a(parcel, this.M);
        parcel.writeInt(this.N);
        sg.bigo.ads.common.n.a(parcel, this.f13405a);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        if (this.k == null) {
            this.k = sg.bigo.ads.common.a.f13122a;
        }
        this.k.a(parcel);
    }

    protected abstract void a(JSONObject jSONObject);

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.h = new sg.bigo.ads.common.a(parcel);
        this.i = new sg.bigo.ads.common.a(parcel);
        this.j = new sg.bigo.ads.common.s.a(this.b, parcel);
        this.m = parcel.readInt() != 0;
        this.n = parcel.readLong();
        this.o = parcel.readInt();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readInt();
        this.B = parcel.readInt() != 0;
        this.C = parcel.readString();
        this.l = parcel.readLong();
        if (parcel.dataAvail() > 0) {
            this.E.b(parcel);
        }
        if (parcel.dataAvail() > 0) {
            this.D = parcel.readString();
        }
        if (parcel.dataAvail() > 0) {
            this.F.b(parcel);
        }
        this.I = sg.bigo.ads.common.n.a(parcel, "");
        this.J = sg.bigo.ads.common.n.a(parcel, sg.bigo.ads.api.a.c.b, new HashMap());
        this.K = sg.bigo.ads.common.n.a(parcel, "");
        if (parcel.dataAvail() > 0) {
            this.G.b(parcel);
        }
        if (parcel.dataAvail() > 0) {
            this.H.b(parcel);
        }
        this.L = sg.bigo.ads.common.n.a(parcel, "");
        sg.bigo.ads.common.n.b(parcel, this.M);
        this.N = sg.bigo.ads.common.n.a(parcel, 0);
        sg.bigo.ads.common.n.b(parcel, this.f13405a);
        this.e = sg.bigo.ads.common.n.a(parcel, 0);
        this.f = sg.bigo.ads.common.n.a(parcel, 0);
        this.k = new sg.bigo.ads.common.a(parcel);
    }

    protected abstract void b(JSONObject jSONObject);

    protected abstract void c(JSONObject jSONObject);

    @Override // sg.bigo.ads.api.a.h
    public final boolean c() {
        return this.E.a(6);
    }

    protected abstract void d(JSONObject jSONObject);

    @Override // sg.bigo.ads.api.a.h
    public final boolean d() {
        return this.E.a(7);
    }

    public final void e(JSONObject jSONObject) {
        this.m = jSONObject.optInt("state", 1) == 1;
        this.n = jSONObject.optLong("config_id", 0L);
        this.o = jSONObject.optInt("conf_interval", 3600);
        this.p = jSONObject.optString("token", "");
        this.q = jSONObject.optString("anti_ban", "");
        this.r = jSONObject.optInt("config_strategy", 1);
        this.s = jSONObject.optString("abflags", "");
        this.t = jSONObject.optString("country", "");
        this.L = jSONObject.optString("req_country", "");
        this.N = jSONObject.optInt("app_flag", 0);
        this.e = jSONObject.optInt("ad_net", 0);
        this.f = jSONObject.optInt("orientation", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("creatives");
        if (jSONObjectOptJSONObject != null) {
            this.u = jSONObjectOptJSONObject.toString();
        } else {
            this.u = "";
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("track");
        if (jSONObjectOptJSONObject2 != null) {
            this.v = jSONObjectOptJSONObject2.toString();
        } else {
            this.v = "";
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("cb");
        if (jSONObjectOptJSONObject3 != null) {
            this.w = jSONObjectOptJSONObject3.toString();
        } else {
            this.w = "";
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(CrashEvent.e);
        if (jSONObjectOptJSONObject4 != null) {
            this.x = jSONObjectOptJSONObject4.toString();
        } else {
            this.x = "";
        }
        this.y = "";
        this.K = "";
        String strOptString = jSONObject.optString("uid", "");
        if (!TextUtils.isEmpty(strOptString)) {
            this.z = strOptString;
        }
        int iOptInt = jSONObject.optInt("concurrent_req_num", 3);
        this.A = iOptInt;
        if (iOptInt <= 0) {
            this.A = Integer.MAX_VALUE;
        }
        this.B = jSONObject.optInt("neg_feedback", 1) == 1;
        this.C = jSONObject.optString("om_js_url", "");
        this.D = jSONObject.optString("banner_js_url", "");
        this.F.a(jSONObject.optJSONObject("free_material"));
        this.G.a(jSONObject.optJSONObject("u_running_conf"));
        this.H.a(jSONObject.optJSONObject("u_running_inf"));
        this.E.f13111a = jSONObject.optLong("global_switch", 0L);
        this.I = "";
        c cVar = this.M;
        String strOptString2 = jSONObject.optString("ad_fill_strategy");
        if (!TextUtils.isEmpty(strOptString2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString2);
                cVar.f13402a = jSONObject2.optInt(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, 0);
                cVar.b = jSONObject2.optString("white_dsp", "");
                cVar.c = jSONObject2.optString("black_dsp", "");
                cVar.d = jSONObject2.optInt("int_time", 0);
                cVar.e = jSONObject2.optInt("rew_time", 0);
                cVar.f = jSONObject2.optInt("spl_time", 0);
                cVar.g = jSONObject2.optInt("nat_time", 0);
                cVar.h = jSONObject2.optInt("pop_time", 0);
                cVar.i.a(jSONObject2);
                cVar.j.a(jSONObject2);
                cVar.k.a(jSONObject2);
                cVar.l.a(jSONObject2);
                cVar.m.a(jSONObject2);
            } catch (JSONException unused) {
            }
        }
        this.f13405a.a(jSONObject.optString("ad_fill_cost_optimize_strategy"));
        String strOptString3 = jSONObject.optString("global_conf");
        JSONArray jSONArray = null;
        try {
            if (!q.a((CharSequence) strOptString3)) {
                jSONArray = new JSONArray(strOptString3);
            }
        } catch (JSONException unused2) {
        }
        HashMap map = new HashMap();
        for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject5 != null) {
                String strOptString4 = jSONObjectOptJSONObject5.optString("key");
                if (!q.a((CharSequence) strOptString4)) {
                    map.put(strOptString4, new sg.bigo.ads.api.a.c(jSONObjectOptJSONObject5.optString("value", "")));
                }
            }
        }
        this.J = map;
        a(jSONObjectOptJSONObject2);
        b(jSONObjectOptJSONObject);
        c(jSONObjectOptJSONObject4);
        d(jSONObjectOptJSONObject3);
        this.l = r.b() / 1000;
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean e() {
        return d();
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean f() {
        return this.E.a(5);
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean g() {
        return this.E.a(4);
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean h() {
        return this.E.a(22);
    }

    @Override // sg.bigo.ads.api.a.h
    public final long i() {
        return this.n;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String j() {
        return this.s;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String k() {
        return this.t;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String l() {
        return this.p;
    }

    @Override // sg.bigo.ads.api.a.h
    public final sg.bigo.ads.api.a.j n() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String o() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.a.h
    public final sg.bigo.ads.api.a.g p() {
        return this.F;
    }

    @Override // sg.bigo.ads.api.a.h
    public final sg.bigo.ads.api.a.b q() {
        return this.f13405a;
    }

    @Override // sg.bigo.ads.api.a.h
    public final sg.bigo.ads.api.a.d r() {
        return this.M;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int s() {
        return this.N;
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean t() {
        return this.e == 1;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int u() {
        return this.f;
    }

    public final void v() {
        F();
        E();
        G();
    }

    public final int w() {
        boolean z = Math.abs((r.b() / 1000) - this.l) > ((long) this.o);
        if (this.r == 0) {
            return z ? 4 : 5;
        }
        return z ? 3 : 2;
    }

    public final int x() {
        return this.A;
    }

    public final String z() {
        return this.z;
    }
}
