package sg.bigo.ads.core.d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.json.b9;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b.e;
import sg.bigo.ads.api.b.f;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.api.core.u;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.core.d.b.d;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[][] f13537a = {new String[]{"0", "1"}, new String[]{"2", "3"}};

    private static int a(i iVar) {
        i.a aVarAw = iVar.aw();
        if (aVarAw != null && aVarAw.a() && iVar.aA()) {
            return k.a(aVarAw.b()) ? 1 : 2;
        }
        return 0;
    }

    private static Map<String, String> a(Map<String, String> map, sg.bigo.ads.api.core.c cVar, String str, String str2, int i) {
        n nVarAU;
        map.put("show_proportion", str);
        map.put(Reporting.Key.AD_SIZE, str2);
        map.put("render_style", String.valueOf(i));
        if ((cVar instanceof o) && (nVarAU = ((o) cVar).aU()) != null) {
            map.put("creative_size", q.a("%1$d*%2$d", Integer.valueOf(nVarAU.f13112a), Integer.valueOf(nVarAU.b)));
        }
        return map;
    }

    private static Map<String, String> a(Map<String, String> map, h hVar) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (hVar == null) {
            return map;
        }
        map.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, hVar.c());
        map.put("gps_country", hVar.d());
        map.put("sim_country", hVar.e());
        map.put("system_country", hVar.f());
        map.put("req_status", String.valueOf(hVar.h()));
        map.put(CommonUrlParts.UUID, String.valueOf(hVar.i()));
        map.put("cfg_sta", String.valueOf(hVar.j()));
        if (hVar.l() > 0) {
            long jL = hVar.l() - hVar.k();
            if (jL >= 0) {
                map.put("cfg_cost", String.valueOf(jL));
            }
        }
        if (hVar.m() > 0) {
            long jM = hVar.m() - hVar.k();
            if (jM >= 0) {
                map.put("delay_cost", String.valueOf(jM));
            }
        }
        if (hVar.m() > 0 && hVar.l() > 0) {
            long jM2 = hVar.m() - hVar.l();
            if (jM2 >= 0) {
                map.put("req_queue_time", String.valueOf(jM2));
            }
        }
        if (hVar.n() > 0) {
            long jN = hVar.n() - hVar.k();
            if (jN >= 0) {
                map.put("net_cost", String.valueOf(jN));
            }
        }
        String strG = hVar.g();
        if (!q.a((CharSequence) strG)) {
            map.put("load_ext", strG);
        }
        return map;
    }

    private static Map<String, String> a(l lVar) {
        HashMap map = new HashMap();
        if (lVar == null) {
            return map;
        }
        map.put("slot", lVar.l());
        map.put("config_id", String.valueOf(sg.bigo.ads.api.a.i.f13093a.i()));
        map.put(Reporting.Key.PLACEMENT_ID, lVar.n());
        map.put("strategy_id", lVar.a());
        map.put("ad_type", String.valueOf(lVar.b()));
        map.put("abflags", q.a(sg.bigo.ads.api.a.i.f13093a.j(), lVar.o()));
        map.put("auc_mode", String.valueOf(lVar.v()));
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d8  */
    private static Map<String, String> a(sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.b.a aVar, boolean z) {
        String strValueOf;
        int i;
        l lVarD = cVar.d();
        Map<String, String> mapA = a(lVarD);
        mapA.put("dsp", cVar.v());
        mapA.put(CreativeInfo.c, cVar.r());
        mapA.put("creative_id", cVar.z());
        mapA.put("sid", String.valueOf(cVar.y()));
        mapA.put("series_id", cVar.A());
        mapA.put("adx_type", String.valueOf(cVar.w()));
        mapA.put("adx_country", cVar.m());
        String str = "video_type";
        if (cVar.x() == 2) {
            if (cVar instanceof i) {
                i iVar = (i) cVar;
                mapA.put("banner_type", iVar.ay() ? "1" : "0");
                strValueOf = String.valueOf(a(iVar));
                str = "banner_preload";
                mapA.put(str, strValueOf);
            } else if (cVar instanceof o) {
                o oVar = (o) cVar;
                mapA.put("banner_type", oVar.bk() ? "1" : "0");
                mapA.put("nat_ban_fill_type", String.valueOf(cVar.ao()));
                if (cVar.w() == 2) {
                    if (oVar.aA() == null || !oVar.aA().d()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    strValueOf = String.valueOf(i);
                    mapA.put(str, strValueOf);
                }
            }
        } else if (cVar instanceof o) {
            o oVar2 = (o) cVar;
            int iW = oVar2.w();
            if (iW == 1) {
                strValueOf = String.valueOf(lVarD.e());
                str = "native_filled_type";
                mapA.put(str, strValueOf);
            } else if (iW == 2) {
                if (oVar2.aA() == null || !oVar2.aA().d()) {
                    i = 0;
                } else {
                    i = 1;
                }
                strValueOf = String.valueOf(i);
                mapA.put(str, strValueOf);
            }
        }
        mapA.put("mapping_slot", cVar.M());
        mapA.put("enc_price", cVar.H());
        String strI = cVar.I();
        if (!TextUtils.isEmpty(strI)) {
            mapA.put("abflags", q.a(mapA.get("abflags"), strI));
        }
        if (sg.bigo.ads.api.core.b.c(lVarD.b())) {
            mapA.put("style_id", cVar.ab());
        }
        mapA.put("is_playable", String.valueOf(cVar.ad()));
        if (cVar.ad() == 1 || cVar.ad() == 2) {
            mapA.put("companion_type", String.valueOf(cVar.ae()));
        }
        mapA.put("style_source", String.valueOf(cVar.g()));
        mapA.put("auc_mode", String.valueOf(cVar.aj()));
        mapA.put("ad_resp_type", String.valueOf(cVar.P()));
        if (cVar.Q() != null) {
            mapA.put("session_id2", cVar.Q());
        }
        if (!z) {
            mapA.put("cache_ad", cVar.U() ? "1" : "0");
            mapA.put("cache_ad_source", String.valueOf(cVar.V()));
            mapA.put("cache_req_status", String.valueOf(cVar.R()));
            mapA.put("req_type", String.valueOf(cVar.W()));
            mapA.put("cur_req_status", String.valueOf(cVar.X()));
        }
        a(mapA, aVar, false);
        a(mapA, cVar.aa());
        return mapA;
    }

    private static Map<String, String> a(sg.bigo.ads.api.core.c cVar, f fVar) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        sg.bigo.ads.api.core.c.b bVarN = cVar.N();
        mapA.put("final_url_type", String.valueOf(fVar.h()));
        mapA.put("redirect_num", String.valueOf(fVar.i()));
        mapA.put("preload_t", String.valueOf(bVarN.f()));
        mapA.put("progress", String.valueOf(fVar.j()));
        mapA.put("click_index", String.valueOf(fVar.l()));
        mapA.put("preload_scene", String.valueOf(bVarN.k()));
        mapA.put("preload_ready", fVar.k() ? "1" : "0");
        mapA.put("land_way", String.valueOf(fVar.m()));
        mapA.put("webview_layout", String.valueOf(fVar.f()));
        mapA.put("url", fVar.g());
        Map<String, String> mapN = fVar.n();
        if (mapN != null) {
            mapA.putAll(mapN);
        }
        return mapA;
    }

    public static void a() {
        HashMap map = new HashMap();
        map.put("build", sg.bigo.ads.common.z.a.b());
        map.put("cpu_info", sg.bigo.ads.common.z.a.c());
        a("06002059", map);
    }

    public static void a(int i, int i2, long j) {
        HashMap map = new HashMap();
        map.put("action", String.valueOf(i));
        map.put("times", String.valueOf(i2));
        map.put("cost", String.valueOf(j));
        a("06002064", map);
    }

    public static void a(int i, int i2, String str) {
        a((sg.bigo.ads.api.core.c) null, i, i2, str);
    }

    public static void a(int i, long j, long j2) {
        HashMap map = new HashMap();
        map.put("start_type", String.valueOf(i));
        map.put("start_time", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        a("06002044", map);
    }

    public static void a(long j, int i, int i2, int i3, int i4) {
        HashMap map = new HashMap();
        map.put("ts", String.valueOf(j));
        map.put("load_num", String.valueOf(i));
        map.put("fill_num", String.valueOf(i2));
        map.put("imp_num", String.valueOf(i3));
        map.put("click_num", String.valueOf(i4));
        a("06002039", map);
    }

    public static void a(long j, int i, int i2, String str, int i3, boolean z, int i4, String str2) {
        d dVar = new d("06002002");
        dVar.a("rslt", "0");
        dVar.a("cost", j);
        dVar.a("e_code", i);
        dVar.a("s_code", i2);
        dVar.a("error", str);
        dVar.a("src", i3);
        dVar.a("in_fg", String.valueOf(z ? 1 : 2));
        dVar.a("times", String.valueOf(i4));
        if (!TextUtils.isEmpty(str2)) {
            dVar.a(CommonUrlParts.UUID, str2);
        }
        a(dVar);
    }

    public static void a(long j, int i, String str, String str2, Map<String, String> map) {
        d dVar = new d("06002001");
        dVar.a("states", "success");
        dVar.a("cost", j);
        dVar.a("status", i);
        dVar.a("cur_in_fg", sg.bigo.ads.common.f.b.c());
        if (!TextUtils.isEmpty(str)) {
            dVar.a(CommonUrlParts.UUID, str);
        }
        dVar.a("tc_string", str2);
        String strA = sg.bigo.ads.common.utils.l.a(map);
        if (!TextUtils.isEmpty(strA)) {
            dVar.a("cost_map", strA);
        }
        a(dVar);
    }

    public static void a(long j, long j2, boolean z, int i, boolean z2, int i2, String str) {
        d dVar = new d("06002002");
        dVar.a("rslt", "1");
        dVar.a("config_id", j);
        dVar.a("cost", j2);
        dVar.a("n_rt", z ? "0" : "1");
        dVar.a("src", i);
        dVar.a("in_fg", String.valueOf(z2 ? 1 : 2));
        dVar.a("times", String.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            dVar.a(CommonUrlParts.UUID, str);
        }
        dVar.a("cur_in_fg", sg.bigo.ads.common.f.b.c());
        a(dVar);
    }

    public static void a(long j, boolean z, String str, int i, String str2) {
        d dVar = new d("06002051");
        dVar.a("rslt", "0");
        dVar.a("cost", j);
        dVar.a("clear", z ? "1" : "0");
        dVar.a("url", str);
        dVar.a("e_code", i);
        dVar.a("error", str2);
        a(dVar);
    }

    public static void a(long j, boolean z, String str, boolean z2) {
        d dVar = new d("06002051");
        dVar.a("rslt", "1");
        dVar.a("cost", j);
        dVar.a("clear", z ? "1" : "0");
        dVar.a("update", z2 ? "1" : "0");
        dVar.a("url", str);
        a(dVar);
    }

    public static void a(Context context, sg.bigo.ads.api.b.a aVar, String str, String str2, int i, long j, long j2, long j3, int i2, int i3, int i4) {
        Map<String, String> mapA;
        sg.bigo.ads.common.b bVarH;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            mapA = a(aVar.K().h());
            a(mapA, eVar, true);
            mapA.put("icon_show_num", String.valueOf(eVar.j()));
            mapA.put("scene_page", String.valueOf(eVar.b));
        } else {
            sg.bigo.ads.api.core.c cVarF = aVar.f();
            mapA = a(cVarF, (sg.bigo.ads.api.b.a) null, false);
            boolean z = cVarF instanceof o;
            if (z) {
                o oVar = (o) cVarF;
                n nVarAU = oVar.aU();
                if (nVarAU != null) {
                    mapA.put("creative_size", q.a("%1$d*%2$d", Integer.valueOf(nVarAU.f13112a), Integer.valueOf(nVarAU.b)));
                }
                int iAB = oVar.aB();
                if (iAB != 0) {
                    mapA.put("show_method", String.valueOf(iAB));
                }
                mapA.put("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
                if (oVar.w() == 2) {
                    mapA.put("fill_strategy", String.valueOf(oVar.bc()));
                    mapA.put("dl_status", String.valueOf(oVar.bd()));
                    if (oVar.bc() == 2) {
                        mapA.put("backup_source", String.valueOf(!q.a((CharSequence) oVar.aS()) ? 1 : 0));
                        mapA.put("backup_dl_status", String.valueOf(oVar.bf()));
                    }
                    mapA.put("backup_creative", String.valueOf(oVar.be()));
                }
                mapA.put("media_type", oVar.aX());
            }
            a(mapA, cVarF);
            if (z && cVarF.x() == 2 && (cVarF.w() == 2 || cVarF.w() == 1)) {
                if (i2 != -1) {
                    mapA.put("icon_sta", String.valueOf(i2));
                }
                if (i3 != -1) {
                    mapA.put("img_sta", String.valueOf(i3));
                }
                if (i4 != -1) {
                    mapA.put("vid_sta", String.valueOf(i4));
                }
            }
        }
        mapA.put("show_proportion", str);
        mapA.put(Reporting.Key.AD_SIZE, str2);
        mapA.put("render_style", String.valueOf(i));
        mapA.put("render_cost", String.valueOf(j));
        mapA.put("attach_render_cost", String.valueOf(j2));
        mapA.put("cost", String.valueOf(j3));
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.put("out_ad", String.valueOf(aVar.J()));
        int i5 = aVar.M;
        if (i5 != 0) {
            mapA.put("show_method_source", String.valueOf(i5));
        }
        int i6 = aVar.N;
        if (i6 != 0) {
            mapA.put("show_acty_source", String.valueOf(i6));
        }
        sg.bigo.ads.api.a.h hVar = sg.bigo.ads.api.a.i.f13093a;
        if (hVar != null && hVar.n().a(15) && (bVarH = sg.bigo.ads.common.aa.b.h(context)) != null) {
            mapA.put("bat_stat", String.valueOf(bVarH.c));
            mapA.put("bat_num", String.valueOf(bVarH.f13130a));
            mapA.put("bat_scale", String.valueOf(bVarH.b));
        }
        p pVarC_ = aVar.c_();
        u uVar = pVarC_ != null ? pVarC_.f13113a : null;
        if (uVar != null) {
            mapA.put("is_vpaid", "1");
            mapA.put("vpaid_imp_type", String.valueOf(uVar.d));
            mapA.put("vpaid_start_cost", String.valueOf(uVar.e));
            mapA.put("vpaid_impression_cost", String.valueOf(uVar.f));
        }
        a("06002010", mapA);
    }

    public static void a(Context context, sg.bigo.ads.api.core.c cVar, String str, String str2, String str3, int i, int i2, int i3, int i4, long j, int i5, int i6, sg.bigo.ads.api.b.a aVar) {
        sg.bigo.ads.common.b bVarH;
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put(Reporting.Key.AD_SIZE, str);
        mapA.put("click_area", str2);
        mapA.put("down_click_area", str3);
        mapA.put("click_module", String.valueOf(i));
        mapA.put("click_source", String.valueOf(i2));
        mapA.put("open_way", String.valueOf(cVar.N().c()));
        mapA.put("url_t", String.valueOf(i3));
        mapA.put("open_way_form", String.valueOf(i4));
        mapA.put("cost", String.valueOf(j));
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            n nVarAU = oVar.aU();
            if (nVarAU != null) {
                mapA.put("creative_size", q.a("%1$d*%2$d", Integer.valueOf(nVarAU.f13112a), Integer.valueOf(nVarAU.b)));
            }
            int iAB = oVar.aB();
            if (iAB != 0) {
                mapA.put("show_method", String.valueOf(iAB));
            }
            long jAD = oVar.aD();
            if (jAD > 0) {
                mapA.put("page_cost", String.valueOf(SystemClock.elapsedRealtime() - jAD));
            }
            int iAC = oVar.aC();
            if (i2 == 11 && iAC > 0) {
                mapA.put("render_method", String.valueOf(iAC));
            }
            if (oVar.w() == 2) {
                mapA.put("backup_creative", String.valueOf(oVar.be()));
            }
        }
        sg.bigo.ads.api.a.h hVar = sg.bigo.ads.api.a.i.f13093a;
        if (hVar != null && hVar.n().a(15) && (bVarH = sg.bigo.ads.common.aa.b.h(context)) != null) {
            mapA.put("bat_stat", String.valueOf(bVarH.c));
            mapA.put("bat_num", String.valueOf(bVarH.f13130a));
            mapA.put("bat_scale", String.valueOf(bVarH.b));
        }
        mapA.put("total_num", String.valueOf(i5));
        mapA.put("current_num", String.valueOf(i6));
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.put("out_ad", String.valueOf(aVar.J()));
        int i7 = aVar.M;
        if (i7 != 0) {
            mapA.put("show_method_source", String.valueOf(i7));
        }
        mapA.put("click_acty_source", String.valueOf(aVar.O));
        a(mapA, cVar);
        a(mapA, aVar, true);
        p pVarC_ = aVar.c_();
        u uVar = pVarC_ != null ? pVarC_.f13113a : null;
        if (uVar != null) {
            mapA.put("is_vpaid", "1");
            mapA.put("vpaid_click_url", uVar.g);
            mapA.put("vpaid_click_handle", uVar.h ? "1" : "0");
            mapA.put("vpaid_click_id", uVar.i);
        }
        a("06002011", mapA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String str, String str2, boolean z, long j, int i, String str3, boolean z2, int i2, String str4, String str5, String str6, String str7, boolean z3, boolean z4, int i3, String str8) {
        HashMap map = new HashMap();
        map.put("url", str);
        map.put("domain_front", str2);
        map.put("rslt", z ? "1" : "0");
        map.put("cost", String.valueOf(j));
        map.put("res_code", String.valueOf(i));
        map.put("res_msg", String.valueOf(str3));
        map.put("in_fg", String.valueOf(z2 ? 1 : 0));
        map.put(ContentDisposition.Parameters.Size, String.valueOf(i2));
        int iL = sg.bigo.ads.common.x.a.l();
        int iM = sg.bigo.ads.common.x.a.m();
        int iN = sg.bigo.ads.common.x.a.n();
        int iO = sg.bigo.ads.common.x.a.o();
        if (iL != 0 || iM != 0 || iN != 0 || iO != 0) {
            String str9 = iL == 1 ? "GDPR" : "";
            if (iM == 1) {
                str9 = str9 + (str9.length() == 0 ? "" : b9.i.c) + "CCPA";
            }
            if (iN == 1) {
                str9 = str9 + (str9.length() == 0 ? "" : b9.i.c) + "LGPD";
            }
            if (iO == 1) {
                str9 = str9 + (str9.length() != 0 ? b9.i.c : "") + "COPPA";
            }
            map.put("privacy", str9);
            map.put("consent", "1");
        }
        map.put("gps_country", str4);
        map.put("sim_country", str5);
        map.put("system_country", str6);
        if (!TextUtils.isEmpty(str7)) {
            map.put(CommonUrlParts.UUID, str7);
        }
        map.put("encrypt", z3 ? "1" : "0");
        map.put("req_encrypt_enable", z4 ? "1" : "0");
        map.put("resp_decrypt_enable", String.valueOf(i3));
        if (!TextUtils.isEmpty(str8)) {
            map.put("enc_logid", String.valueOf(str8));
        }
        a("06002015", map);
    }

    public static void a(String str, List<String> list, String str2, int i) {
        HashMap map = new HashMap();
        map.put("rslt", str);
        if (!k.a((Collection) list)) {
            map.put("reason", list.toString());
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("browser", str2);
        }
        map.put("open_way", String.valueOf(i));
        a("06002060", map);
    }

    private static void a(String str, Map<String, String> map) {
        d dVar = new d(str);
        dVar.a(map);
        a(dVar);
    }

    public static void a(String str, sg.bigo.ads.api.core.c cVar, String str2, String str3, String str4, int i, int i2, int i3, String str5, long j, int i4, String str6, int i5, int i6, int i7, int i8, boolean z, boolean z2, int i9, String str7, p pVar) {
        Map<String, String> map;
        if (cVar == null) {
            map = new HashMap<>();
        } else {
            Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
            mapA.put("ad_resp_type", String.valueOf(cVar.w()));
            if (cVar instanceof o) {
                o oVar = (o) cVar;
                if (cVar.w() == 2) {
                    mapA.put("dl_status", String.valueOf(oVar.bd()));
                }
                if (oVar.w() == 2) {
                    mapA.put("fill_strategy", String.valueOf(oVar.bc()));
                }
                if (oVar.bc() == 2) {
                    mapA.put("backup_source", String.valueOf(!q.a((CharSequence) oVar.aS()) ? 1 : 0));
                }
                mapA.put("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
                mapA.put("backup_dl_status", String.valueOf(oVar.bf()));
            }
            map = mapA;
        }
        if (!map.containsKey("slot") && !TextUtils.isEmpty(str)) {
            map.put("slot", str);
        }
        if (!map.containsKey("ad_type") && !TextUtils.isEmpty(str2)) {
            map.put("ad_type", str2);
        }
        map.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, str3 == null ? "0" : str3);
        map.put("session_id2", str4 == null ? "0" : str4);
        map.put("rslt", String.valueOf(i));
        map.put("e_code", String.valueOf(i2));
        map.put("s_code", String.valueOf(i3));
        if (str5 != null) {
            map.put("error", String.valueOf(str5));
        }
        map.put("cost_total", String.valueOf(j));
        map.put("cache_ad_source", String.valueOf(str6));
        map.put("cache_ad", String.valueOf(i4));
        map.put("cache_req_status", String.valueOf(i5));
        map.put("req_type", String.valueOf(i6));
        map.put("cur_req_status", String.valueOf(i7));
        map.put("adx_type_req", String.valueOf(i8));
        map.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        map.put("encrypt", z ? "1" : "0");
        map.put("req_encrypt_enable", z2 ? "1" : "0");
        map.put("resp_decrypt_enable", String.valueOf(i9));
        if (!TextUtils.isEmpty(str7)) {
            map.put("enc_logid", str7);
        }
        u uVar = pVar != null ? pVar.f13113a : null;
        if (uVar != null) {
            map.put("is_vpaid", "1");
            map.put("vpaid_version", String.valueOf(uVar.f13118a));
            map.put("vpaid_version_cost", String.valueOf(uVar.b));
            map.put("vpaid_init_cost", String.valueOf(uVar.c));
        }
        a("06002057", map);
    }

    public static void a(Map<String, String> map) {
        a("06002013", map);
    }

    public static void a(Map<String, String> map, sg.bigo.ads.api.b.a aVar, boolean z) {
        sg.bigo.ads.api.b.a aVarH = aVar != null ? aVar.H() : null;
        if (aVarH instanceof e) {
            e eVar = (e) aVarH;
            a(map, eVar, false);
            if (z) {
                map.put("scene_page", String.valueOf(eVar.b));
            }
        }
    }

    private static void a(Map<String, String> map, sg.bigo.ads.api.b.b bVar) {
        sg.bigo.ads.api.core.c cVarI = bVar.i();
        if (cVarI != null) {
            map.put("host_slot", cVarI.b());
            map.put("host_placement", cVarI.c());
            map.put("host_sid", String.valueOf(cVarI.y()));
            map.put("host_ad_id", cVarI.r());
        }
        if (bVar instanceof sg.bigo.ads.api.b.c) {
            map.put("icon_req_num", String.valueOf(((sg.bigo.ads.api.b.c) bVar).j()));
        }
    }

    private static void a(Map<String, String> map, e eVar, boolean z) {
        Object objK = eVar.K();
        if (objK instanceof sg.bigo.ads.api.b.b) {
            a(map, (sg.bigo.ads.api.b.b) objK);
        }
        map.put("icon_fill_num", String.valueOf(eVar.i()));
        map.put("icon_fill_scene", String.valueOf(eVar.h()));
        sg.bigo.ads.api.core.c cVar = (sg.bigo.ads.api.core.c) k.b(eVar.a());
        if (!z || cVar == null) {
            return;
        }
        map.put("sid", String.valueOf(cVar.y()));
        map.put("dsp", cVar.v());
        map.put("adx_type", String.valueOf(cVar.w()));
    }

    private static void a(Map<String, String> map, sg.bigo.ads.api.core.c cVar) {
        if (cVar instanceof o) {
            if ((cVar.x() == 3 || cVar.x() == 4) && cVar.w() == 2) {
                o oVar = (o) cVar;
                int iAG = oVar.aG();
                map.put("ser_multi_vid", String.valueOf(iAG));
                if (iAG == 3) {
                    String strAH = oVar.aH();
                    if (TextUtils.isEmpty(strAH)) {
                        return;
                    }
                    map.put("media_reason", String.valueOf(strAH));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(l lVar, sg.bigo.ads.api.b bVar, int i, int i2, String str, int i3, int i4, int i5, boolean z, int i6, String str2) {
        Map<String, String> mapA = a(lVar);
        mapA.put("rslt", "0");
        mapA.put("e_code", String.valueOf(i));
        mapA.put("s_code", String.valueOf(i2));
        mapA.put("error", str);
        if (bVar != 0) {
            if (!mapA.containsKey("slot")) {
                mapA.put("slot", bVar.f13094a);
                mapA.put("ad_type", String.valueOf(bVar.c()));
            }
            mapA.put("banner_type", String.valueOf(bVar.c));
            String str3 = bVar.g.f13095a;
            if (!q.a((CharSequence) str3)) {
                mapA.put("load_ext", str3);
            }
            sg.bigo.ads.api.b.a aVar = bVar.g;
            a(mapA, aVar);
            mapA.put("cost", String.valueOf(Math.max(0L, aVar.n() - aVar.k())));
            if (bVar instanceof sg.bigo.ads.api.b.b) {
                a(mapA, (sg.bigo.ads.api.b.b) bVar);
            }
        }
        mapA.put("req_type", String.valueOf(i3));
        mapA.put("cur_req_status", String.valueOf(i4));
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.put("encrypt", String.valueOf(i5));
        mapA.put("req_encrypt_enable", z ? "1" : "0");
        mapA.put("resp_decrypt_enable", String.valueOf(i6));
        if (!TextUtils.isEmpty(str2)) {
            mapA.put("enc_logid", str2);
        }
        a("06002007", mapA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(sg.bigo.ads.api.b.a aVar, int i, int i2, String str) {
        Map<String, String> mapA;
        h hVar;
        if (aVar instanceof e) {
            sg.bigo.ads.api.b bVarK = aVar.K();
            mapA = a(bVarK.h());
            a(mapA, (e) aVar, true);
            if (bVarK instanceof sg.bigo.ads.api.b.c) {
                mapA.put("scene_page", String.valueOf(((sg.bigo.ads.api.b.c) bVarK).k()));
            }
            hVar = bVarK.g;
        } else {
            sg.bigo.ads.api.core.c cVarF = aVar.f();
            mapA = a(cVarF, (sg.bigo.ads.api.b.a) null, false);
            h hVarAa = cVarF.aa();
            if (cVarF instanceof o) {
                o oVar = (o) cVarF;
                mapA.put("material_type", oVar.aQ() ? "2" : "1");
                mapA.put("media_type", oVar.aX());
                mapA.put("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
                if (oVar.w() == 2) {
                    mapA.put("fill_strategy", String.valueOf(oVar.bc()));
                    mapA.put("dl_status", String.valueOf(oVar.bd()));
                    if (oVar.bc() == 2) {
                        mapA.put("backup_source", String.valueOf(1 ^ (q.a((CharSequence) oVar.aS()) ? 1 : 0)));
                    }
                    mapA.put("media_type", oVar.aX());
                }
            }
            a(mapA, cVarF);
            b(mapA, cVarF);
            hVar = hVarAa;
        }
        long jO = hVar.o() - hVar.n();
        long jO2 = hVar.o() - hVar.k();
        mapA.put("rslt", "0");
        mapA.put("cost", String.valueOf(jO));
        mapA.put("cost_total", String.valueOf(jO2));
        mapA.put("e_code", String.valueOf(i));
        mapA.put("s_code", String.valueOf(i2));
        mapA.put("error", str);
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        sg.bigo.ads.api.core.q qVarI = aVar.I();
        if (qVarI != null) {
            mapA.put("encrypt", qVarI.f13114a ? "1" : "0");
            mapA.put("req_encrypt_enable", qVarI.b ? "1" : "0");
            mapA.put("resp_decrypt_enable", String.valueOf(qVarI.c));
            String str2 = qVarI.d;
            if (!TextUtils.isEmpty(str2)) {
                mapA.put("enc_logid", str2);
            }
        }
        a("06002008", mapA);
    }

    public static void a(sg.bigo.ads.api.b.a aVar, String str, String str2, int i) {
        Map<String, String> mapA;
        int iAB;
        if (aVar instanceof e) {
            mapA = a(aVar.K().h());
            a(mapA, (e) aVar, true);
            a(mapA, (sg.bigo.ads.api.core.c) null, str, str2, i);
        } else {
            sg.bigo.ads.api.core.c cVarF = aVar.f();
            mapA = a(cVarF, (sg.bigo.ads.api.b.a) null, false);
            a(mapA, cVarF, str, str2, i);
            if ((cVarF instanceof o) && (iAB = ((o) cVarF).aB()) != 0) {
                mapA.put("show_method", String.valueOf(iAB));
            }
        }
        a("06002029", mapA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(sg.bigo.ads.api.b.a aVar, boolean z) {
        Map<String, String> mapA;
        h hVar;
        if (aVar instanceof e) {
            sg.bigo.ads.api.b bVarK = aVar.K();
            mapA = a(bVarK.h());
            a(mapA, (e) aVar, true);
            if (bVarK instanceof sg.bigo.ads.api.b.c) {
                mapA.put("scene_page", String.valueOf(((sg.bigo.ads.api.b.c) bVarK).k()));
            }
            hVar = bVarK.g;
        } else {
            sg.bigo.ads.api.core.c cVarF = aVar.f();
            mapA = a(cVarF, (sg.bigo.ads.api.b.a) null, false);
            h hVarAa = cVarF.aa();
            if (cVarF instanceof o) {
                o oVar = (o) cVarF;
                mapA.put("material_type", oVar.aQ() ? "2" : "1");
                mapA.put("media_type", oVar.aX());
                mapA.put("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
                if (oVar.w() == 2) {
                    mapA.put("fill_strategy", String.valueOf(oVar.bc()));
                    mapA.put("dl_status", String.valueOf(oVar.bd()));
                    if (oVar.bc() == 2) {
                        mapA.put("backup_source", String.valueOf(1 ^ (q.a((CharSequence) oVar.aS()) ? 1 : 0)));
                        mapA.put("backup_dl_status", String.valueOf(oVar.bf()));
                    }
                    mapA.put("media_type", oVar.aX());
                }
            }
            a(mapA, cVarF);
            b(mapA, cVarF);
            hVar = hVarAa;
        }
        long jO = hVar.o() - hVar.n();
        long jO2 = hVar.o() - hVar.k();
        mapA.put("rslt", "1");
        mapA.put("cost", String.valueOf(jO));
        mapA.put("cost_total", String.valueOf(jO2));
        mapA.put("is_cache", z ? "1" : "0");
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        sg.bigo.ads.api.core.q qVarI = aVar.I();
        if (qVarI != null) {
            mapA.put("encrypt", qVarI.f13114a ? "1" : "0");
            mapA.put("req_encrypt_enable", qVarI.b ? "1" : "0");
            mapA.put("resp_decrypt_enable", String.valueOf(qVarI.c));
            String str = qVarI.d;
            if (!TextUtils.isEmpty(str)) {
                mapA.put("enc_logid", str);
            }
        }
        p pVarC_ = aVar.c_();
        u uVar = pVarC_ != null ? pVarC_.f13113a : null;
        if (uVar != null) {
            mapA.put("is_vpaid", "1");
            mapA.put("vpaid_version", String.valueOf(uVar.f13118a));
            mapA.put("vpaid_version_cost", String.valueOf(uVar.b));
            mapA.put("vpaid_init_cost", String.valueOf(uVar.c));
        }
        a("06002008", mapA);
    }

    public static void a(f fVar, f.a aVar, long j, int i, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.b.a aVar2, String str) {
        Map<String, String> mapA = a(cVar, fVar);
        if (aVar != null) {
            mapA.put("status", String.valueOf(aVar.a()));
            mapA.put("cost", String.valueOf(aVar.b()));
        }
        mapA.put("duration", String.valueOf(j));
        mapA.put("num", String.valueOf(i));
        mapA.put("out_ad", String.valueOf(aVar2 == null ? sg.bigo.ads.common.v.a.f13307a : aVar2.J()));
        if (!TextUtils.isEmpty(str)) {
            mapA.put("task_affinity", str);
        }
        a(mapA, aVar2, false);
        a("06002062", mapA);
    }

    public static void a(f fVar, f.a aVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.b.a aVar2, String str) {
        Map<String, String> mapA = a(cVar, fVar);
        mapA.put("status", String.valueOf(aVar.a()));
        mapA.put("cost", String.valueOf(aVar.b()));
        mapA.put("out_ad", String.valueOf(aVar2 == null ? sg.bigo.ads.common.v.a.f13307a : aVar2.J()));
        if (!TextUtils.isEmpty(str)) {
            mapA.put("task_affinity", str);
        }
        a(mapA, aVar2, false);
        a("06002061", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar) {
        a("06002047", a(cVar, (sg.bigo.ads.api.b.a) null, false));
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, int i2) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("page_style", String.valueOf(i));
        mapA.put("page_source", String.valueOf(i2));
        a("06002041", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, int i2, int i3, int i4, int i5, int i6) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("multi_scene", String.valueOf(i));
        map.put("action", String.valueOf(i2));
        map.put("multi_num", String.valueOf(i3));
        map.put("multi_status_loading_num", String.valueOf(i4));
        map.put("multi_status_success_num", String.valueOf(i5));
        map.put("multi_status_failed_num", String.valueOf(i6));
        a("06002058", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, int i2, long j) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("page_type", String.valueOf(i));
        map.put("action", String.valueOf(i2));
        map.put("cost", String.valueOf(j));
        a("06002056", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, int i2, long j, long j2, int i3, int i4, int i5, int i6) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("page_type", String.valueOf(i));
        map.put("action", String.valueOf(i2));
        map.put("cost1", String.valueOf(j));
        map.put("cost2", String.valueOf(j2));
        if (i4 != -1) {
            map.put("cov1_sta", String.valueOf(i4));
        }
        if (i3 != -1) {
            map.put("cov1_type", String.valueOf(i3));
        }
        if (i6 != -1) {
            map.put("cov2_sta", String.valueOf(i6));
        }
        if (i5 != -1) {
            map.put("cov2_type", String.valueOf(i5));
        }
        a("06002055", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, int i2, String str) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("e_code", String.valueOf(i));
        map.put("s_code", String.valueOf(i2));
        map.put("error", str);
        a("06002035", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, int i2, String str, long j, boolean z, int i3, String str2) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("render_method", String.valueOf(i));
        map.put("rslt", String.valueOf(i2));
        map.put("cost", String.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            map.put("material_id", str);
        }
        if (z) {
            map.put("e_code", String.valueOf(i3));
            map.put("error", String.valueOf(str2));
        }
        a("06002050", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, long j) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("rslt", "1");
        mapA.put("wrap", String.valueOf(i));
        mapA.put("cost", String.valueOf(j));
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            mapA.put("video_duration", String.valueOf(oVar.aT()));
            mapA.put("video_type", oVar.aX());
            mapA.put("has_video", String.valueOf(oVar.ax() != null ? 1 : 0));
            mapA.put("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
        }
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        a("06002016", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, long j, long j2, sg.bigo.ads.api.b.a aVar) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("close_source", String.valueOf(i));
        mapA.put("duration", String.valueOf(j));
        mapA.put("ad_front_duration", String.valueOf(j2));
        mapA.put("close_type", "0");
        mapA.put("out_ad", String.valueOf(aVar.J()));
        a(mapA, aVar, false);
        a("06002023", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, long j, String str, int i2, String str2, String str3) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("slot", String.valueOf(cVar.b()));
        mapA.put("rslt", String.valueOf(i));
        mapA.put("cost", String.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            mapA.put("url", str);
        }
        if (i2 > 0) {
            mapA.put(com.safedk.android.analytics.brandsafety.l.R, String.valueOf(i2));
        }
        if (!TextUtils.isEmpty(str2)) {
            mapA.put("material_type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            mapA.put("error", str3);
        }
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            mapA.put("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
            if (oVar.bc() == 2) {
                mapA.put("backup_source", String.valueOf(!q.a((CharSequence) oVar.aS()) ? 1 : 0));
            }
        }
        a("06002042", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, Double d, String str) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("auc_mode", String.valueOf(i));
        mapA.put("bid_rslt", "1");
        if (d != null) {
            mapA.put("sec_price", String.valueOf(d));
        }
        if (str != null) {
            mapA.put("sec_bidder", str);
        }
        a("06002045", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, Double d, String str, int i2) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("auc_mode", String.valueOf(i));
        mapA.put("bid_rslt", "0");
        if (d != null) {
            mapA.put("first_price", String.valueOf(d));
        }
        if (str != null) {
            mapA.put("first_bidder", str);
        }
        mapA.put("loss_reason", String.valueOf(i2));
        a("06002045", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, String str, int i2) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("video_stat", String.valueOf(i));
        mapA.put("video_url", str);
        mapA.put("path_t", String.valueOf(i2));
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            mapA.put("video_duration", String.valueOf(oVar.aT()));
            n nVarAU = oVar.aU();
            if (nVarAU != null) {
                mapA.put("video_actual_duration", String.valueOf(nVarAU.c));
            }
        }
        a("06002017", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, String str, long j, int i2, String str2) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("rslt", "0");
        mapA.put("wrap", String.valueOf(i));
        mapA.put("wrap_url", str);
        mapA.put("cost", String.valueOf(j));
        mapA.put("e_code", String.valueOf(i2));
        mapA.put("error", String.valueOf(str2));
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        a("06002016", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, int i, sg.bigo.ads.api.core.e eVar, sg.bigo.ads.api.b.a aVar) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("open_way_gp", String.valueOf(i));
        mapA.put("open_rslt_gp", String.valueOf(eVar.b));
        mapA.put("deep_rslt", String.valueOf(eVar.c));
        mapA.put("webview_layout", String.valueOf(eVar.d));
        mapA.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, eVar.e);
        if (!q.a((CharSequence) eVar.f)) {
            mapA.put("pkg_name", eVar.f);
        }
        mapA.put("out_ad", String.valueOf(aVar == null ? sg.bigo.ads.common.v.a.f13307a : aVar.J()));
        a(mapA, aVar, false);
        a("06002034", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, long j) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("ad_destroy_duration", String.valueOf(j));
        a("06002065", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, int i, int i2) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("rslt", String.valueOf(str));
        map.put("render_method", String.valueOf(i));
        map.put("reason", String.valueOf(i2));
        a("06002049", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, int i, long j, int i2) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("rslt", "1");
        map.put("video_url", str);
        map.put("retry", String.valueOf(i2));
        map.put("media_player_status", String.valueOf(i));
        map.put("cost", String.valueOf(j));
        a("06002054", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, int i, long j, long j2, int i2, int i3, String str2, boolean z) {
        n nVarAU;
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("rslt", "1");
        mapA.put("url", str);
        mapA.put("source", String.valueOf(i));
        mapA.put("cost", String.valueOf(j));
        mapA.put(ContentDisposition.Parameters.Size, String.valueOf(j2));
        mapA.put("dl_opt", String.valueOf(i2));
        mapA.put("material_type", String.valueOf(i3));
        if ((cVar instanceof o) && (nVarAU = ((o) cVar).aU()) != null) {
            mapA.put("creative_size", q.a("%1$d*%2$d", Integer.valueOf(nVarAU.f13112a), Integer.valueOf(nVarAU.b)));
        }
        mapA.put("media_type", str2);
        mapA.put("from_breakpoint", z ? "1" : "0");
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        a("06002018", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, int i, String str2, int i2) {
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("rslt", "0");
        map.put("video_url", str);
        map.put("retry", String.valueOf(i2));
        map.put("media_player_status", String.valueOf(i));
        map.put("error", str2);
        a("06002054", (Map<String, String>) map);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, long j, int i, Map<String, String> map) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("action", str);
        mapA.put("cost", String.valueOf(j));
        mapA.put("rslt", String.valueOf(i));
        if (map != null) {
            mapA.putAll(map);
        }
        a("06002025", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, String str2, int i) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        a(mapA, cVar, str, str2, i);
        a("06002043", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, String str, String str2, long j, long j2, int i, String str3, boolean z) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("rslt", "0");
        mapA.put("url", str);
        mapA.put("error", str2);
        mapA.put("cost", String.valueOf(j));
        mapA.put(ContentDisposition.Parameters.Size, String.valueOf(j2));
        mapA.put("material_type", String.valueOf(i));
        mapA.put("media_type", str3);
        mapA.put("from_breakpoint", z ? "1" : "0");
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        a("06002018", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, AdError adError, boolean z) {
        if (cVar == null) {
            return;
        }
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("e_code", new StringBuilder().append(adError.getCode()).toString());
        if (adError.getCode() == 2000) {
            mapA.put("duration_expired", new StringBuilder().append(cVar.K()).toString());
        }
        mapA.put("error", adError.getMessage());
        mapA.put("ad_impl", z ? "1" : "0");
        if ((cVar instanceof o) && cVar.w() == 2) {
            mapA.put("dl_status", String.valueOf(((o) cVar).bd()));
        }
        a("06002048", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.b.a aVar) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("out_ad", String.valueOf(aVar.J()));
        a(mapA, aVar, false);
        a("06002022", mapA);
    }

    public static void a(sg.bigo.ads.api.core.c cVar, boolean z, int i, int i2, boolean z2, long j, int i3, int i4, long j2, int i5, int i6, long j3) {
        List<sg.bigo.ads.api.core.c> listAm;
        sg.bigo.ads.api.core.c cVar2;
        Map map = cVar == null ? new HashMap() : a(cVar, (sg.bigo.ads.api.b.a) null, false);
        map.put("d_video", "1");
        map.put("action", String.valueOf(i));
        map.put("video_pos", String.valueOf(i2));
        map.put("by_user", String.valueOf(z2 ? 1 : 0));
        if (j != -1) {
            map.put("click_cost", String.valueOf(j));
        }
        if (i4 != -1) {
            map.put("cov1_sta", String.valueOf(i4));
        }
        if (i3 != -1) {
            map.put("cov1_type", String.valueOf(i3));
        }
        if (j2 != -1) {
            map.put("cov1_cost", String.valueOf(j2));
        }
        if (i6 != -1) {
            map.put("cov2_sta", String.valueOf(i6));
        }
        if (i5 != -1) {
            map.put("cov2_type", String.valueOf(i5));
        }
        if (j3 != -1) {
            map.put("cov2_cost", String.valueOf(j3));
        }
        if (cVar instanceof o) {
            map.put("dl_status", String.valueOf(((o) cVar).bd()));
        }
        if (cVar != null && z && (listAm = cVar.am()) != null && listAm.size() > 0 && (cVar2 = listAm.get(0)) != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(CreativeInfo.c, String.valueOf(cVar2.r()));
                jSONObject.putOpt("creative_id", String.valueOf(cVar2.r()));
                if (cVar2 instanceof o) {
                    jSONObject.putOpt("dl_status", String.valueOf(((o) cVar2).bd()));
                }
                map.put("ad2", String.valueOf(jSONObject));
            } catch (Throwable unused) {
            }
        }
        a("06002053", (Map<String, String>) map);
    }

    public static void a(i iVar, long j, long j2, long j3, long j4, long j5) {
        Map<String, String> mapA = a((sg.bigo.ads.api.core.c) iVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("by_js", String.valueOf(j));
        mapA.put("by_js_cost", String.valueOf(j2));
        mapA.put("by_bit", String.valueOf(j3));
        mapA.put("by_bit_cost", String.valueOf(j4));
        mapA.put("by_bit_run_cost", String.valueOf(j5));
        if (j > 0 && j2 >= 0 && j3 > 0 && j4 >= 0) {
            j2 = Math.min(j2, j4);
        } else if (j <= 0 || j2 < 0) {
            j2 = (j3 <= 0 || j4 < 0) ? -1L : j4;
        }
        mapA.put("cost", String.valueOf(j2));
        a("06002040", mapA);
    }

    private static void a(d dVar) {
        Map<String, String> map = dVar.f13547a;
        if (q.a((CharSequence) map.get(SDKAnalyticsEvents.PARAMETER_SESSION_ID))) {
            map.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, UUID.randomUUID().toString());
        }
        c.a().a(dVar.b, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(sg.bigo.ads.api.core.c[] cVarArr, sg.bigo.ads.api.b bVar, boolean z, int i, int i2, int i3, boolean z2, int i4, String str) {
        Map<String, String> mapA;
        sg.bigo.ads.api.core.c cVar;
        if (bVar.e()) {
            mapA = a(bVar.h());
            sg.bigo.ads.api.core.c cVar2 = (sg.bigo.ads.api.core.c) k.b(cVarArr);
            mapA.put("dsp", cVar2.v());
            mapA.put("sid", String.valueOf(cVar2.y()));
            mapA.put("adx_type", String.valueOf(cVar2.w()));
            mapA.put("icon_fill_num", String.valueOf(cVarArr.length));
        } else {
            sg.bigo.ads.api.core.c cVar3 = (sg.bigo.ads.api.core.c) k.b(cVarArr);
            mapA = a(cVar3, (sg.bigo.ads.api.b.a) null, false);
            if ((cVar3 instanceof o) && cVar3.w() == 2) {
                o oVar = (o) cVar3;
                mapA.put("video_type", String.valueOf((oVar.aA() == null || !oVar.aA().b()) ? 0 : 1));
            }
            a(mapA, cVar3);
            List<sg.bigo.ads.api.core.c> listAm = cVar3.am();
            if (listAm != null && listAm.size() > 0 && (cVar = listAm.get(0)) != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt(CreativeInfo.c, String.valueOf(cVar.r()));
                    jSONObject.putOpt("creative_id", String.valueOf(cVar.r()));
                    mapA.put("ad2", String.valueOf(jSONObject));
                } catch (Throwable unused) {
                }
            }
        }
        if (bVar instanceof sg.bigo.ads.api.b.b) {
            a(mapA, (sg.bigo.ads.api.b.b) bVar);
        }
        mapA.put("rslt", "1");
        mapA.put("banner_type", String.valueOf(bVar.c));
        String str2 = bVar.g.f13095a;
        if (!q.a((CharSequence) str2)) {
            mapA.put("load_ext", str2);
        }
        sg.bigo.ads.api.b.a aVar = bVar.g;
        mapA.put("cost", String.valueOf(Math.max(0L, aVar.n() - aVar.k())));
        mapA.put("is_playable", z ? "1" : "0");
        mapA.put("req_type", String.valueOf(i));
        mapA.put("cur_req_status", String.valueOf(i2));
        mapA.put("cur_in_fg", String.valueOf(sg.bigo.ads.common.f.b.c()));
        mapA.remove("cache_ad");
        mapA.remove("cache_ad_source");
        mapA.remove("cache_req_status");
        mapA.remove("session_id2");
        mapA.put("encrypt", String.valueOf(i3));
        mapA.put("req_encrypt_enable", z2 ? "1" : "0");
        mapA.put("resp_decrypt_enable", String.valueOf(i4));
        if (!TextUtils.isEmpty(str)) {
            mapA.put("enc_logid", str);
        }
        a("06002007", mapA);
    }

    public static int b() {
        int iO = sg.bigo.ads.common.x.a.o();
        int iM = sg.bigo.ads.common.x.a.m();
        int iN = sg.bigo.ads.common.x.a.n();
        int iL = sg.bigo.ads.common.x.a.l();
        int i = iO == 2 ? 1 : 0;
        int i2 = iM == 2 ? 1 : 0;
        return (iO << 4) | (iM << 6) | (iN << 8) | (iL << 10) | ((iL == 2 ? 1 : 0) << 3) | ((iN == 2 ? 1 : 0) << 2) | (i2 << 1) | i;
    }

    public static void b(int i, int i2, String str) {
        HashMap map = new HashMap();
        map.put("action", String.valueOf(i));
        map.put("scene", String.valueOf(i2));
        if (!q.a((CharSequence) str)) {
            map.put("error", str);
        }
        a("06002063", map);
    }

    public static void b(Map<String, String> map) {
        a("06002014", map);
    }

    private static void b(Map<String, String> map, sg.bigo.ads.api.core.c cVar) {
        sg.bigo.ads.api.core.c cVar2;
        List<sg.bigo.ads.api.core.c> listAm = cVar.am();
        if (listAm == null || listAm.size() <= 0 || (cVar2 = listAm.get(0)) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(CreativeInfo.c, String.valueOf(cVar2.r()));
            jSONObject.putOpt("creative_id", String.valueOf(cVar2.r()));
            jSONObject.putOpt("is_playable", String.valueOf(cVar2.ad()));
            if (cVar2 instanceof o) {
                o oVar = (o) cVar2;
                jSONObject.putOpt("material_type", oVar.aQ() ? "2" : "1");
                jSONObject.putOpt("media_type", oVar.aX());
                jSONObject.putOpt("companion_type", f13537a[oVar.aF() ? 1 : 0][oVar.aE() ? 1 : 0]);
                if (oVar.w() == 2) {
                    jSONObject.putOpt("fill_strategy", String.valueOf(oVar.bc()));
                    jSONObject.putOpt("dl_status", String.valueOf(oVar.bd()));
                    if (oVar.bc() == 2) {
                        jSONObject.putOpt("backup_source", String.valueOf(!q.a((CharSequence) oVar.aS()) ? 1 : 0));
                    }
                }
            }
            map.put("ad2", String.valueOf(jSONObject));
        } catch (Throwable unused) {
        }
    }

    public static void b(sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.b.a aVar) {
        Map<String, String> mapA = a(cVar, (sg.bigo.ads.api.b.a) null, false);
        mapA.put("rew_rslt", "1");
        mapA.put("out_ad", String.valueOf(aVar.J()));
        a(mapA, aVar, false);
        a("06002019", mapA);
    }

    public static Map<String, String> c(sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.b.a aVar) {
        return a(cVar, aVar, true);
    }

    public static void c(Map<String, String> map) {
        c.a().a("06002066", map);
    }
}
