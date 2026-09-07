package sg.bigo.ads.core.e.a;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.k;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13569a;
    String b;
    int c;
    JSONObject d;
    private String e;
    private String f;
    private String[] g;
    private String[] h;
    private String i;
    private int j;
    private int k;
    private final Map<String, String> l;
    private sg.bigo.ads.common.g m;

    d(JSONObject jSONObject) {
        this(jSONObject, null);
    }

    public d(JSONObject jSONObject, sg.bigo.ads.common.g gVar) {
        this.m = gVar;
        this.d = jSONObject;
        this.l = new HashMap();
        this.f13569a = jSONObject.optInt("type", 0);
        this.e = jSONObject.optString("value", "");
        this.b = jSONObject.optString("name", "");
        this.f = jSONObject.optString(CommonUrlParts.UUID, "");
        this.j = jSONObject.optInt("expired");
        this.k = jSONObject.optInt("replace", 0);
        this.c = jSONObject.optInt("norepeat", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reg");
        if (jSONArrayOptJSONArray != null) {
            this.g = new String[jSONArrayOptJSONArray.length()];
            this.h = new String[jSONArrayOptJSONArray.length()];
            a(jSONArrayOptJSONArray);
        }
        this.i = jSONObject.optString("real_url");
    }

    private void a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.optJSONObject(i) != null) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                this.g[i] = jSONObjectOptJSONObject.optString("token", "");
                this.h[i] = jSONObjectOptJSONObject.optString("value", "");
            }
        }
    }

    private boolean f() {
        return this.k == 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:172:0x028e  */
    private String g() {
        byte b;
        long jA;
        int iD;
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.b)) {
            return "";
        }
        String strTrim = this.e.trim();
        if (this.g != null && this.h != null && this.m != null) {
            for (int i = 0; i < this.g.length; i++) {
                String str = this.h[i];
                switch (str) {
                    case "regist_time":
                        b = 47;
                        break;
                    case "timezone":
                        b = Ascii.NAK;
                        break;
                    case "express_id":
                        b = 33;
                        break;
                    case "resolution":
                        b = 17;
                        break;
                    case "sec_price":
                        b = 36;
                        break;
                    case "sec_bidder":
                        b = 37;
                        break;
                    case "os_lang":
                        b = Ascii.CR;
                        break;
                    case "gps_adid":
                        b = 5;
                        break;
                    case "os_ver":
                        b = Ascii.FF;
                        break;
                    case "pkg_ch":
                        b = 10;
                        break;
                    case "pkg_vc":
                        b = 9;
                        break;
                    case "region":
                        b = 46;
                        break;
                    case "sdk_vc":
                        b = Ascii.ETB;
                        break;
                    case "vendor":
                        b = Ascii.SO;
                        break;
                    case "app_key":
                        b = 6;
                        break;
                    case "click_prop":
                        b = 32;
                        break;
                    case "first_price":
                        b = 38;
                        break;
                    case "support_om":
                        b = Ascii.RS;
                        break;
                    case "pkg_ver":
                        b = 8;
                        break;
                    case "first_bidder":
                        b = 39;
                        break;
                    case "os":
                        b = Ascii.VT;
                        break;
                    case "dpi":
                        b = Ascii.DC2;
                        break;
                    case "isp":
                        b = Ascii.DLE;
                        break;
                    case "lan":
                        b = 19;
                        break;
                    case "lat":
                        b = Ascii.ESC;
                        break;
                    case "lng":
                        b = Ascii.FS;
                        break;
                    case "mac":
                        b = 44;
                        break;
                    case "net":
                        b = Ascii.DC4;
                        break;
                    case "uid":
                        b = 49;
                        break;
                    case "city":
                        b = Ascii.SUB;
                        break;
                    case "gaid":
                        b = 3;
                        break;
                    case "guid":
                        b = 2;
                        break;
                    case "hdid":
                        b = 45;
                        break;
                    case "imei":
                        b = 42;
                        break;
                    case "imsi":
                        b = 43;
                        break;
                    case "device_id":
                        b = 50;
                        break;
                    case "timestamp":
                        b = 0;
                        break;
                    case "af_id":
                        b = Ascii.GS;
                        break;
                    case "model":
                        b = Ascii.SI;
                        break;
                    case "state":
                        b = Ascii.EM;
                        break;
                    case "advertising_id":
                        b = 4;
                        break;
                    case "click_module":
                        b = 35;
                        break;
                    case "click_source":
                        b = 34;
                        break;
                    case "country":
                        b = Ascii.CAN;
                        break;
                    case "pkg_name":
                        b = 7;
                        break;
                    case "pkg_sver":
                        b = 41;
                        break;
                    case "local_timestamp_ms":
                        b = 1;
                        break;
                    case "action_type":
                        b = Ascii.US;
                        break;
                    case "loss_reason":
                        b = 40;
                        break;
                    case "new_uid":
                        b = 48;
                        break;
                    case "sdk_ver":
                        b = Ascii.SYN;
                        break;
                    default:
                        b = -1;
                        break;
                }
                String strValueOf = "0";
                switch (b) {
                    case 0:
                        jA = r.a();
                        strValueOf = String.valueOf(jA);
                        break;
                    case 1:
                        jA = System.currentTimeMillis();
                        strValueOf = String.valueOf(jA);
                        break;
                    case 2:
                        strValueOf = this.m.C();
                        break;
                    case 3:
                    case 4:
                    case 5:
                        strValueOf = this.m.A();
                        break;
                    case 6:
                        strValueOf = this.m.a();
                        break;
                    case 7:
                        strValueOf = this.m.b();
                        break;
                    case 8:
                        strValueOf = String.valueOf(this.m.c());
                        break;
                    case 9:
                        iD = this.m.d();
                        strValueOf = String.valueOf(iD);
                        break;
                    case 10:
                        strValueOf = this.m.e();
                        break;
                    case 11:
                        strValueOf = this.m.i();
                        break;
                    case 12:
                        strValueOf = this.m.j();
                        break;
                    case 13:
                    case 19:
                        strValueOf = this.m.k();
                        break;
                    case 14:
                        strValueOf = this.m.l();
                        break;
                    case 15:
                        strValueOf = this.m.m();
                        break;
                    case 16:
                        strValueOf = this.m.n();
                        break;
                    case 17:
                        strValueOf = this.m.o();
                        break;
                    case 18:
                        iD = this.m.p();
                        strValueOf = String.valueOf(iD);
                        break;
                    case 20:
                        strValueOf = this.m.r();
                        break;
                    case 21:
                        strValueOf = this.m.s();
                        break;
                    case 22:
                        strValueOf = this.m.y();
                        break;
                    case 23:
                        strValueOf = "50201";
                        break;
                    case 24:
                        strValueOf = this.m.t();
                        break;
                    case 25:
                        strValueOf = this.m.w();
                        break;
                    case 26:
                        strValueOf = this.m.x();
                        break;
                    case 27:
                    case 28:
                        break;
                    case 29:
                        strValueOf = this.m.B();
                        break;
                    case 30:
                        strValueOf = "1";
                        break;
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                        if (this.l.containsKey(str)) {
                            strValueOf = this.l.get(str);
                            break;
                        }
                    default:
                        strValueOf = "";
                        break;
                }
                String str2 = this.g[i];
                if (strValueOf == null) {
                    strValueOf = "";
                }
                strTrim = strTrim.replace(str2, strValueOf);
            }
        }
        h hVar = i.f13093a;
        if (strTrim == null || hVar == null || !hVar.n().a(8)) {
            return strTrim;
        }
        try {
            return strTrim.replace("{", "%7B").replace("}", "%7D");
        } catch (Exception unused) {
            return strTrim;
        }
    }

    public final void a(String str, String str2) {
        this.l.put(str, str2);
    }

    public final boolean a() {
        return "bigo_tracker".equals(this.f);
    }

    public final boolean b() {
        return this.j != 0 && r.a() / 1000 > ((long) this.j);
    }

    public final boolean c() {
        return this.f13569a == 0;
    }

    public final sg.bigo.ads.common.u.a d() {
        k.b aVar;
        if (TextUtils.isEmpty(this.i)) {
            e();
            sg.bigo.ads.common.t.a.a(0, 3, "ThirdTrack", "getRealUrl url = " + this.i);
        }
        if (c() && f()) {
            k kVar = c.a().d;
            if (kVar != null) {
                aVar = kVar.a(this.i);
                sg.bigo.ads.common.t.a.a(0, 3, "ThirdTrack", "replaceHost new url = " + aVar.a());
            } else {
                sg.bigo.ads.common.t.a.a(0, "ThirdTrack", "replaceHost handle is null, replace failed");
                aVar = null;
            }
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new k.a(this.i);
        }
        return new sg.bigo.ads.core.e.a(aVar);
    }

    public final void e() {
        this.i = g();
        sg.bigo.ads.common.t.a.a(0, 3, "ThirdTrack", "updateRealUrl url = " + this.i);
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("real_url", this.i);
            } catch (JSONException unused) {
            }
        }
    }

    public final String toString() {
        return "type=" + this.f13569a + ",name=" + this.b + ",url=" + this.i;
    }
}
