package sg.bigo.ads.controller.e;

import android.os.Build;
import com.json.fe;
import com.mbridge.msdk.MBridgeConstans;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import net.pubnative.lite.sdk.models.RemoteConfigFeature;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes12.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13459a;
    private String b;

    private static String b(d dVar) {
        String string;
        if (dVar == null) {
            sg.bigo.ads.common.t.a.a(0, "BigoAdSdk", "Failed to generate a token due to uninitialized provider.");
            return null;
        }
        String appKey = dVar.f13454a.getAppKey();
        String str = dVar.d;
        String str2 = dVar.e;
        int i = dVar.f;
        String channel = dVar.f13454a.getChannel();
        String str3 = Build.VERSION.RELEASE;
        String str4 = dVar.g;
        String str5 = dVar.h;
        String str6 = dVar.i;
        String str7 = dVar.j;
        String str8 = dVar.k;
        int i2 = dVar.l;
        String str9 = dVar.m;
        String strR = dVar.r();
        String strU = dVar.U();
        String strA = dVar.A();
        String strA2 = sg.bigo.ads.common.b.a.a(dVar.b);
        String strZ = dVar.c.z();
        String strD = q.d(sg.bigo.ads.common.utils.c.a());
        int iD = dVar.D();
        String strJ = dVar.c.j();
        String strG = dVar.G();
        String str10 = dVar.n;
        String str11 = dVar.o;
        int i3 = dVar.p;
        long j = dVar.q;
        long j2 = dVar.r;
        long jA = p.a(dVar.b);
        long jC = p.c();
        long jA2 = p.a();
        String strR2 = dVar.R();
        String strS = dVar.S();
        String strA3 = sg.bigo.ads.controller.g.d.a(null, dVar);
        String strQ = sg.bigo.ads.common.x.a.q();
        sg.bigo.ads.common.b bVarAc = dVar.ac();
        String strValueOf = bVarAc != null ? String.valueOf(bVarAc.c) : "";
        String strValueOf2 = bVarAc != null ? String.valueOf(bVarAc.f13130a) : "";
        String strValueOf3 = bVarAc != null ? String.valueOf(bVarAc.b) : "";
        int i4 = dVar.s;
        String strE = sg.bigo.ads.common.m.b.e();
        int iN = sg.bigo.ads.common.x.a.n();
        int iM = sg.bigo.ads.common.x.a.m();
        int iO = sg.bigo.ads.common.x.a.o();
        int iB = sg.bigo.ads.core.d.b.b();
        String strAe = dVar.ae();
        boolean z = dVar.z();
        boolean zF = dVar.F();
        boolean zAd = dVar.ad();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(MBridgeConstans.APP_KEY, appKey);
            jSONObject.putOpt("pkg_name", str);
            jSONObject.putOpt("pkg_ver", str2);
            jSONObject.putOpt("pkg_vc", Integer.valueOf(i));
            jSONObject.putOpt("pkg_ch", channel);
            jSONObject.putOpt("os", "android");
            jSONObject.putOpt("os_ver", str3);
            jSONObject.putOpt("os_lang", str4);
            jSONObject.putOpt("vendor", str5);
            jSONObject.putOpt("model", str6);
            jSONObject.putOpt("isp", str7);
            jSONObject.putOpt("resolution", str8);
            jSONObject.putOpt("dpi", Integer.valueOf(i2));
            jSONObject.putOpt("dpi_f", str9);
            jSONObject.putOpt("net", strR);
            jSONObject.putOpt("lat", 0);
            jSONObject.putOpt("lng", 0);
            jSONObject.putOpt("country", strU);
            jSONObject.putOpt("state", "");
            jSONObject.putOpt(POBConstants.KEY_CITY, "");
            jSONObject.putOpt("sdk_ver", "5.2.1");
            jSONObject.putOpt("sdk_vc", 50201);
            jSONObject.putOpt(fe.Q0, strA);
            jSONObject.putOpt("af_id", strA2);
            jSONObject.putOpt("uid", strZ);
            jSONObject.putOpt("timezone", strD);
            jSONObject.putOpt("timestamp", Integer.valueOf(iD));
            jSONObject.putOpt("abflags", strJ);
            jSONObject.putOpt("hw_id", strG);
            jSONObject.putOpt("gg_service_ver", str10);
            jSONObject.putOpt("webkit_ver", str11);
            jSONObject.putOpt("cpu_core_num", Integer.valueOf(i3));
            jSONObject.putOpt("cpu_clock_speed", Long.valueOf(j));
            jSONObject.putOpt("total_memory", Long.valueOf(j2));
            jSONObject.putOpt("free_memory", Long.valueOf(jA));
            jSONObject.putOpt("rom_free_in", Long.valueOf(jC));
            jSONObject.putOpt("rom_free_ext", Long.valueOf(jA2));
            jSONObject.putOpt("gps_country", "");
            jSONObject.putOpt("sim_country", strR2);
            jSONObject.putOpt("system_country", strS);
            jSONObject.putOpt("ad_info", strA3);
            jSONObject.putOpt(CommonUrlParts.UUID, strQ);
            jSONObject.putOpt("bat_stat", strValueOf);
            jSONObject.putOpt("bat_num", strValueOf2);
            jSONObject.putOpt("bat_scale", strValueOf3);
            jSONObject.putOpt("simulator_file", Integer.valueOf(i4));
            jSONObject.putOpt("tc_string", strE);
            jSONObject.putOpt("fire_id", strAe);
            jSONObject.putOpt("lat_enable", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("hw_lat_enable", Integer.valueOf(zF ? 1 : 0));
            jSONObject.putOpt("fire_lat_enable", Integer.valueOf(zAd ? 1 : 0));
            jSONObject.putOpt("lgdp", Integer.valueOf(iN));
            jSONObject.putOpt(RemoteConfigFeature.UserConsent.CCPA, Integer.valueOf(iM));
            jSONObject.putOpt("coppa", Integer.valueOf(iO));
            jSONObject.putOpt("consent_status", Integer.valueOf(iB));
            string = jSONObject.toString();
        } catch (Exception unused) {
            sg.bigo.ads.common.t.a.a(0, "BigoAdSdk", "Failed to generate a token due to unknown error.");
            string = null;
        }
        if (string != null) {
            return sg.bigo.ads.common.j.a.a(string, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F") + "a2";
        }
        return null;
    }

    public final String a(d dVar) {
        String str = this.b;
        if (str != null) {
            return str;
        }
        synchronized (f.class) {
            String str2 = this.b;
            if (str2 != null) {
                return str2;
            }
            String strB = b(dVar);
            this.b = strB;
            f13459a = true;
            return strB;
        }
    }
}
