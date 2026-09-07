package sg.bigo.ads.core.b;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b.e;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, Object> a(String str, l lVar, sg.bigo.ads.api.b bVar, c cVar, Integer num) {
        c cVarI;
        HashMap map = new HashMap();
        map.put("action", str);
        map.put("slot", lVar.l());
        map.put("config_id", Long.valueOf(i.f13093a.i()));
        map.put(Reporting.Key.PLACEMENT_ID, lVar.n());
        map.put("strategy_id", lVar.a());
        map.put("ad_type", Integer.valueOf(lVar.b()));
        map.put("abflags", q.a(i.f13093a.j(), lVar.o()));
        map.put("ts", Long.valueOf(System.currentTimeMillis()));
        map.put("begin_ts", Long.valueOf(bVar.g.f));
        map.put("banner_type", Integer.valueOf(bVar.c));
        map.put("adn_name", "bigoad");
        JSONObject jSONObject = new JSONObject();
        sg.bigo.ads.api.b.a aVar = bVar.g;
        j.a(jSONObject, SDKAnalyticsEvents.PARAMETER_SESSION_ID, aVar.c());
        j.a(jSONObject, "gps_country", aVar.d());
        j.a(jSONObject, "sim_country", aVar.e());
        j.a(jSONObject, "system_country", aVar.f());
        j.a(jSONObject, "req_status", Integer.valueOf(aVar.h()));
        if (cVar != null) {
            j.a(jSONObject, "adx_country", cVar.m());
        }
        if (lVar.w()) {
            j.a(jSONObject, "config_country", i.f13093a.k());
        }
        String strG = aVar.g();
        if (!q.a((CharSequence) strG)) {
            j.a(jSONObject, "load_ext", strG);
        }
        if (num != null) {
            j.a(jSONObject, "auc_mode", num);
        }
        if ((bVar instanceof sg.bigo.ads.api.b.b) && (cVarI = ((sg.bigo.ads.api.b.b) bVar).i()) != null) {
            j.a(jSONObject, "host_slot", cVarI.b());
            j.a(jSONObject, "host_placement", cVarI.c());
            j.a(jSONObject, "host_sid", Long.valueOf(cVarI.y()));
            j.a(jSONObject, "host_ad_id", cVarI.r());
        }
        if (bVar instanceof sg.bigo.ads.api.b.c) {
            j.a(jSONObject, "icon_req_num", Integer.valueOf(((sg.bigo.ads.api.b.c) bVar).j()));
        }
        map.put("extra_json", jSONObject.toString());
        return map;
    }

    public static Map<String, Object> a(String str, l lVar, sg.bigo.ads.api.b bVar, c cVar, Integer num, String str2, String str3, sg.bigo.ads.api.b.a aVar) {
        JSONObject jSONObject;
        Map<String, Object> mapA = a(str, lVar, bVar, cVar, num);
        Object obj = mapA.get("extra_json");
        if (obj == null || !(obj instanceof String)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject((String) obj);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                new JSONObject();
                throw th;
            }
        }
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            c cVar2 = (c) k.b(eVar.a());
            if (cVar2 != null) {
                mapA.put("adx_type", Integer.valueOf(cVar2.w()));
                mapA.put("sid", Long.valueOf(cVar2.y()));
                mapA.put("dsp", cVar2.v());
                mapA.put("logid", Long.valueOf(cVar2.Z()));
            }
            str.hashCode();
            switch (str) {
                case "filled":
                    j.a(jSONObject, "icon_fill_num", Integer.valueOf(eVar.i()));
                    break;
                case "impression":
                case "clicked":
                    j.a(jSONObject, "icon_fill_num", Integer.valueOf(eVar.i()));
                    j.a(jSONObject, "icon_show_num", Integer.valueOf(eVar.j()));
                    break;
            }
        } else if (cVar != null) {
            sg.bigo.ads.api.b.a aVarH = aVar != null ? aVar.H() : null;
            if (aVarH instanceof e) {
                e eVar2 = (e) aVarH;
                j.a(jSONObject, "icon_fill_num", Integer.valueOf(eVar2.i()));
                j.a(jSONObject, "icon_show_num", Integer.valueOf(eVar2.j()));
            }
            mapA.put(CreativeInfo.c, cVar.r());
            mapA.put("creative_id", cVar.z());
            mapA.put("sid", Long.valueOf(cVar.y()));
            mapA.put("series_id", cVar.A());
            mapA.put("adx_type", Integer.valueOf(cVar.w()));
            mapA.put("mapping_slot", cVar.M());
            mapA.put("enc_price", cVar.H());
            String strI = cVar.I();
            if (!TextUtils.isEmpty(strI)) {
                mapA.put("abflags", q.a((String) mapA.get("abflags"), strI));
            }
            j.a(jSONObject, "dsp", cVar.v());
            j.a(jSONObject, "logid", Long.valueOf(cVar.Z()));
            if (sg.bigo.ads.api.core.b.c(lVar.b())) {
                j.a(jSONObject, "style_id", cVar.ab());
            }
        }
        j.a(jSONObject, SDKAnalyticsEvents.PARAMETER_SESSION_ID, bVar.g.b);
        if (str2 != null) {
            j.a(jSONObject, "sec_price", str2);
        }
        if (str3 != null) {
            j.a(jSONObject, "sec_bidder", str3);
        }
        p pVarC_ = aVar != null ? aVar.c_() : null;
        if (pVarC_ != null && pVarC_.f13113a != null) {
            j.a(jSONObject, "is_vpaid", 1);
        }
        mapA.put("extra_json", jSONObject.toString());
        return mapA;
    }
}
