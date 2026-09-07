package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.json.mediationsdk.metadata.a;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Og {
    private static boolean pA(int i) {
        return i == 2 || i == 3 || i == 8;
    }

    public static Pair<com.bytedance.sdk.openadsdk.core.model.pA, ArrayList<Integer>> pA(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.TX tx, com.bytedance.sdk.openadsdk.core.model.Og og) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.pA pAVar = new com.bytedance.sdk.openadsdk.core.model.pA();
            pAVar.pA(jSONObject.optString("request_id"));
            pAVar.pA(jSONObject.optInt("ret"));
            int i = 0;
            pAVar.Og(jSONObject.optInt("multi_ad_style", 0));
            pAVar.Og(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("gdid_encrypted");
            if (jSONObject.has("choose_ui_data")) {
                pAVar.Og(jSONObject.optJSONObject("choose_ui_data"));
                pAVar.pA(true);
            }
            String strOptString2 = jSONObject.optString("auction_price");
            if (pAVar.KZx() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                ArrayList arrayList2 = pAVar.WV() ? new ArrayList() : null;
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    com.bytedance.sdk.openadsdk.core.model.yFO yfoPA = pA(jSONArrayOptJSONArray.optJSONObject(i2), adSlot, tx);
                    if (yfoPA != null && pAVar.WV()) {
                        if (yfoPA.aBv() == 30) {
                            yfoPA.Bzk(true);
                        } else {
                            pAVar.Og(0);
                            arrayList2 = null;
                        }
                    }
                    int iPA = pA(yfoPA);
                    if (iPA != 200) {
                        if (yfoPA != null) {
                            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfoPA, gbA.KZx(yfoPA.FHA()), iPA);
                        } else {
                            com.bytedance.sdk.openadsdk.ZZv.KZx.Og((com.bytedance.sdk.openadsdk.core.model.yFO) null, "", iPA);
                        }
                        arrayList.add(Integer.valueOf(iPA));
                        if (arrayList2 != null && yfoPA != null) {
                            arrayList2.add(new pA(yfoPA.ZQ(), iPA));
                        }
                    } else {
                        yfoPA.Bzk(strOptString2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            yfoPA.du(strOptString);
                        }
                        pAVar.pA(yfoPA);
                    }
                }
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    pA((ArrayList<pA>) arrayList2);
                }
                i = length;
            }
            pA(i, pAVar, (ArrayList<Integer>) arrayList, og);
            return new Pair<>(pAVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.AdInfoFactory", th.getMessage());
            return null;
        }
    }

    private static void pA(int i, final com.bytedance.sdk.openadsdk.core.model.pA pAVar, final ArrayList<Integer> arrayList, final com.bytedance.sdk.openadsdk.core.model.Og og) {
        if (pAVar == null || i < 2 || !pAVar.omh()) {
            return;
        }
        final int size = i - (pAVar.ZZv() != null ? pAVar.ZZv().size() : 0);
        final boolean z = pAVar.Bzk() == null;
        if (size > 0 || z) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA();
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("choose_ad_parsing_error", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.Og.1
                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", pAVar.Og());
                    jSONObject.put("material_error", size);
                    jSONObject.put("choose_ui_error", z ? 1 : 0);
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) arrayList).toString());
                    }
                    com.bytedance.sdk.openadsdk.core.model.Og og2 = og;
                    if (og2 != null) {
                        jSONObject.put("server_res_str", og2.pA());
                    }
                    return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("choose_ad_parsing_error").Og(jSONObject.toString());
                }
            });
        }
    }

    public static com.bytedance.sdk.openadsdk.core.model.yFO pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return pA(jSONObject, (AdSlot) null, (com.bytedance.sdk.openadsdk.core.model.TX) null);
    }

    /* JADX WARN: Code duplicated, block: B:140:0x05d3 A[PHI: r14
  0x05d3: PHI (r14v83 int) = (r14v82 int), (r14v131 int) binds: [B:133:0x05bf, B:138:0x05d0] A[DONT_GENERATE, DONT_INLINE]] */
    private static com.bytedance.sdk.openadsdk.core.model.yFO pA(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.TX tx) {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogPA;
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogPA2;
        int i;
        com.bytedance.sdk.openadsdk.core.WV.pA pAVarPA;
        com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA pAVar;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.yFO yfoKZx = com.bytedance.sdk.openadsdk.core.model.yFO.KZx();
        yfoKZx.yFO(jSONObject.optInt("interaction_type"));
        yfoKZx.XT(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.yFO.ZZv, 0));
        yfoKZx.vZF(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.yFO.KZx, 0));
        yfoKZx.Sd(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.yFO.ML, 0));
        yfoKZx.Wx(jSONObject.optString("target_url"));
        yfoKZx.XT(jSONObject.optString(CreativeInfo.c));
        yfoKZx.yFO(jSONObject.optString("app_log_url"));
        yfoKZx.BSW(jSONObject.optString("source"));
        yfoKZx.WV(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        yfoKZx.TV(jSONObject.optInt("dislike_control", 0));
        yfoKZx.Wx(jSONObject.optInt("play_bar_show_time", AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES));
        yfoKZx.Sd(jSONObject.optString("gecko_id"));
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("set_click_type");
            yfoKZx.Og(jSONObjectOptJSONObject2.optDouble("cta", 2.0d));
            yfoKZx.pA(jSONObjectOptJSONObject2.optDouble("other", 1.0d));
        }
        yfoKZx.ML(jSONObject.optJSONObject(ShareConstants.MEDIA_EXTENSION));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("icon");
        yfoKZx.ZZv(jSONObject.optBoolean("screenshot", false));
        yfoKZx.BSW(jSONObject.optInt("play_bar_style", 0));
        yfoKZx.TX(jSONObject.optString("market_url", ""));
        yfoKZx.Bzk(jSONObject.optInt("video_adaptation", 0));
        yfoKZx.JG(jSONObject.optInt("feed_video_opentype", 0));
        yfoKZx.KZx(jSONObject.optJSONObject("session_params"));
        yfoKZx.Bzk(jSONObject.optString("auction_price", ""));
        yfoKZx.IG(jSONObject.optInt("mrc_report", 0));
        if (jSONObject.optBoolean("isMrcReportFinish", false)) {
            yfoKZx.uhO();
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(Reporting.EventType.RENDER);
        if (jSONObjectOptJSONObject4 != null) {
            yfoKZx.SD(jSONObjectOptJSONObject4.optInt("render_sequence", 0));
            yfoKZx.omh(jSONObjectOptJSONObject4.optInt("backup_render_control", 1));
            yfoKZx.lT(jSONObjectOptJSONObject4.optInt("reserve_time", 100));
            yfoKZx.rB(jSONObjectOptJSONObject4.optInt("render_thread", 0));
        }
        yfoKZx.ZZv(jSONObject.optInt("render_control", tx != null ? tx.omh : 1));
        if (jSONObjectOptJSONObject3 != null) {
            com.bytedance.sdk.openadsdk.core.model.DX dx = new com.bytedance.sdk.openadsdk.core.model.DX();
            dx.pA(jSONObjectOptJSONObject3.optString("url"));
            dx.Og(jSONObjectOptJSONObject3.optInt("height"));
            dx.pA(jSONObjectOptJSONObject3.optInt("width"));
            yfoKZx.pA(dx);
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject5 != null) {
            yfoKZx.KZx(jSONObjectOptJSONObject5.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT, 0));
            yfoKZx.SD(jSONObjectOptJSONObject5.optString(CampaignEx.JSON_KEY_REWARD_NAME, ""));
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("cover_image");
        if (jSONObjectOptJSONObject6 != null) {
            com.bytedance.sdk.openadsdk.core.model.DX dx2 = new com.bytedance.sdk.openadsdk.core.model.DX();
            dx2.pA(jSONObjectOptJSONObject6.optString("url"));
            dx2.Og(jSONObjectOptJSONObject6.optInt("height"));
            dx2.pA(jSONObjectOptJSONObject6.optInt("width"));
            yfoKZx.Og(dx2);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                com.bytedance.sdk.openadsdk.core.model.DX dx3 = new com.bytedance.sdk.openadsdk.core.model.DX();
                JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray.optJSONObject(i2);
                dx3.pA(jSONObjectOptJSONObject7.optString("url"));
                dx3.Og(jSONObjectOptJSONObject7.optInt("height"));
                dx3.pA(jSONObjectOptJSONObject7.optInt("width"));
                dx3.pA(jSONObjectOptJSONObject7.optBoolean("image_preview"));
                dx3.Og(jSONObjectOptJSONObject7.optString("image_key"));
                yfoKZx.KZx(dx3);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                yfoKZx.PV().add(jSONArrayOptJSONArray2.optString(i3));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("click_url");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                yfoKZx.cFQ().add(jSONArrayOptJSONArray3.optString(i4));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("play_start");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                yfoKZx.lx().add(jSONArrayOptJSONArray4.optString(i5));
            }
        }
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("click_area");
        if (jSONObjectOptJSONObject8 != null) {
            com.bytedance.sdk.openadsdk.core.model.Bzk bzk = new com.bytedance.sdk.openadsdk.core.model.Bzk();
            bzk.pA = jSONObjectOptJSONObject8.optBoolean("click_upper_content_area", true);
            bzk.Og = jSONObjectOptJSONObject8.optBoolean("click_upper_non_content_area", true);
            bzk.KZx = jSONObjectOptJSONObject8.optBoolean("click_lower_content_area", true);
            bzk.ZZv = jSONObjectOptJSONObject8.optBoolean("click_lower_non_content_area", true);
            bzk.ML = jSONObjectOptJSONObject8.optBoolean("click_button_area", true);
            bzk.JG = jSONObjectOptJSONObject8.optBoolean("click_video_area", true);
            yfoKZx.pA(bzk);
        }
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject9 != null) {
            yfoKZx.pA(Og(jSONObjectOptJSONObject9));
        } else {
            yfoKZx.pA(adSlot);
        }
        if (adSlot != null) {
            Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
            if (requestExtraMap != null && requestExtraMap.containsKey("admob_watermark")) {
                yfoKZx.eG(String.valueOf(requestExtraMap.get("admob_watermark")));
            }
        } else {
            yfoKZx.eG(jSONObject.optString("identificationOverlayContent"));
        }
        yfoKZx.WV(jSONObject.optInt("intercept_flag", 0));
        yfoKZx.Sn(jSONObject.optString("phone_num"));
        yfoKZx.DX(jSONObject.optString("title"));
        yfoKZx.oX(jSONObject.optString("description"));
        yfoKZx.aBv(jSONObject.optString("button_text"));
        yfoKZx.SGo(jSONObject.optInt("ad_logo", 1));
        yfoKZx.vZF(jSONObject.optString("ext"));
        yfoKZx.oX(jSONObject.optInt("cover_click_area", 0));
        yfoKZx.TX(jSONObject.optInt("image_mode"));
        yfoKZx.WQf(jSONObject.optInt("orientation", 1));
        yfoKZx.pA((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        yfoKZx.oX(jSONObject.optInt("cover_click_area", 0));
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("app");
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL);
        yfoKZx.pA(com.bytedance.sdk.openadsdk.core.model.BF.pA(jSONObject.optJSONObject("oem")));
        yfoKZx.pA(JG(jSONObjectOptJSONObject10));
        JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject("interaction_method_params");
        yfoKZx.pA(Bzk(jSONObject.optJSONObject("arbitrage_interceptor_params")));
        yfoKZx.pA(SD(jSONObjectOptJSONObject12));
        yfoKZx.pA(omh(jSONObjectOptJSONObject12));
        yfoKZx.pA(BSW(jSONObjectOptJSONObject11));
        yfoKZx.pA(new com.bytedance.sdk.openadsdk.core.model.WQf(jSONObject));
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                FilterWord filterWordML = ML(jSONArrayOptJSONArray5.optJSONObject(i6));
                if (filterWordML != null && filterWordML.isValid()) {
                    yfoKZx.pA(filterWordML);
                }
            }
        }
        yfoKZx.BF(jSONObject.optInt("count_down"));
        yfoKZx.Og(jSONObject.optLong("expiration_time"));
        yfoKZx.gbA(jSONObject.optInt("video_encode_type", 0));
        yfoKZx.qmB(0);
        JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject13 != null) {
            ogPA = pA(jSONObjectOptJSONObject13, yfoKZx, true);
            yfoKZx.Og(ogPA);
            yfoKZx.Gx(jSONObjectOptJSONObject13.optInt("multi_played_percent", 50));
        } else {
            ogPA = null;
        }
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject14 != null) {
            ogPA2 = pA(jSONObjectOptJSONObject14, yfoKZx, false);
            yfoKZx.KZx(ogPA2);
        } else {
            ogPA2 = null;
        }
        if (Build.VERSION.SDK_INT < 26 || yfoKZx.mY() == 0) {
            yfoKZx.pA(ogPA);
            yfoKZx.gbA(0);
        } else {
            if (ogPA2 != null && ogPA != null) {
                if (TextUtils.isEmpty(ogPA2.WV())) {
                    ogPA2.ZZv(ogPA.WV());
                }
                if (TextUtils.isEmpty(ogPA2.Wx())) {
                    ogPA2.ML(ogPA.Wx());
                }
                if (ogPA2.ZZv() == -1) {
                    ogPA2.ZZv(ogPA.ZZv());
                }
            }
            if (ogPA2 != null) {
                yfoKZx.pA(ogPA2);
            } else {
                yfoKZx.pA(ogPA);
            }
        }
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject15 != null) {
            yfoKZx.pA(SGo(jSONObjectOptJSONObject15));
        }
        yfoKZx.pA(WV(jSONObject.optJSONObject("media_ext")));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject16 != null) {
            com.bytedance.sdk.openadsdk.core.model.yFO.pA pAVar2 = new com.bytedance.sdk.openadsdk.core.model.yFO.pA();
            pAVar2.KZx(jSONObjectOptJSONObject16.optString("id"));
            pAVar2.ZZv(jSONObjectOptJSONObject16.optString("md5"));
            pAVar2.ML(jSONObjectOptJSONObject16.optString("url"));
            pAVar2.JG(jSONObjectOptJSONObject16.optString("data"));
            pAVar2.SD(jSONObjectOptJSONObject16.optString("diff_data"));
            String strOptString = jSONObjectOptJSONObject16.optString("dynamic_creative");
            pAVar2.omh(strOptString);
            pAVar2.Og(jSONObjectOptJSONObject16.optString("version"));
            pAVar2.Bzk(jSONObjectOptJSONObject16.optString("media_view"));
            try {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOptString);
                JSONArray jSONArrayOptJSONArray6 = jSONObjectJsonObjectInit.optJSONArray("tag_ids");
                if (jSONArrayOptJSONArray6 != null) {
                    for (int i7 = 0; i7 < jSONArrayOptJSONArray6.length(); i7++) {
                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray6.optInt(i7)));
                    }
                }
                String strOptString2 = jSONObjectJsonObjectInit.optString("music_url");
                pAVar2.pA(arrayList);
                pAVar2.pA(strOptString2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.AdInfoFactory", e.getMessage());
            }
            pAVar2.SGo(jSONObjectOptJSONObject16.optString("engine_version"));
            pAVar2.BSW(jSONObjectOptJSONObject16.optString("ugen_url"));
            pAVar2.WV(jSONObjectOptJSONObject16.optString("ugen_md5"));
            pAVar2.Wx(jSONObjectOptJSONObject16.optString("ugen_data"));
            yfoKZx.pA(pAVar2);
        }
        JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject17 != null) {
            yfoKZx.pA(com.bytedance.sdk.openadsdk.core.model.eG.pA(jSONObjectOptJSONObject17));
        }
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject18 != null) {
            yfoKZx.Og(jSONObjectOptJSONObject18);
        }
        yfoKZx.SGo(jSONObject.optString("creative_extra"));
        yfoKZx.ML(jSONObject.optInt("if_block_lp", 0));
        yfoKZx.Sn(jSONObject.optInt("cache_sort", 1));
        yfoKZx.DX(jSONObject.optInt("if_sp_cache", 0));
        JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject19 != null) {
            yfoKZx.pA(ZZv(jSONObjectOptJSONObject19));
        }
        yfoKZx.du(jSONObject.optInt("is_package_open", 1));
        yfoKZx.omh(jSONObject.optString("ad_info", null));
        yfoKZx.aBv(jSONObject.optInt("ua_policy", 2));
        yfoKZx.eG(jSONObject.optInt("playable_duration_time", 20));
        yfoKZx.roi(jSONObject.optInt("playable_endcard_close_time", -1));
        yfoKZx.Mc(jSONObject.optInt("endcard_close_time", -1));
        yfoKZx.pA(jSONObject.optInt("interaction_method"));
        yfoKZx.BF(jSONObject.optString("dsp_html"));
        yfoKZx.Bf(jSONObject.optInt("image_stay", 0));
        int iOptInt = jSONObject.optInt("dsp_material_type", 0);
        if (iOptInt < 0 || iOptInt > 3) {
            iOptInt = 0;
        }
        if (iOptInt == 0) {
            if (jSONObject.optBoolean("is_vast", false)) {
                iOptInt = 1;
            }
            i = jSONObject.optBoolean("is_html", false) ? 2 : iOptInt;
        }
        yfoKZx.CIG(i);
        if (i == 1 || i == 3) {
            int iFHA = yfoKZx.FHA();
            if (iFHA < 0) {
                if (yfoKZx.rB() != null) {
                    iFHA = yfoKZx.rB().getDurationSlotType();
                } else {
                    iFHA = yfoKZx.PKZ();
                }
            }
            String strKZx = gbA.KZx(iFHA);
            if (jSONObject.has("vast_json")) {
                pAVarPA = com.bytedance.sdk.openadsdk.core.WV.pA.pA(jSONObject.optJSONObject("vast_json"));
            } else {
                String strOptString3 = jSONObject.optString("dsp_vast");
                if (TextUtils.isEmpty(strOptString3)) {
                    pA(yfoKZx, strKZx);
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Pair<com.bytedance.sdk.openadsdk.core.WV.pA, com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA> pairPA = pA(strOptString3, yfoKZx.rtW(), iFHA);
                if (pairPA != null) {
                    com.bytedance.sdk.openadsdk.core.WV.pA pAVar3 = (com.bytedance.sdk.openadsdk.core.WV.pA) pairPA.first;
                    pAVar = (com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA) pairPA.second;
                    pAVarPA = pAVar3;
                } else {
                    pAVarPA = null;
                    pAVar = null;
                }
                pA(yfoKZx, strKZx, pAVarPA, jCurrentTimeMillis, pAVar);
            }
            if (pAVarPA != null) {
                pAVarPA.JG(strKZx);
            }
            if (pAVarPA == null) {
                return null;
            }
            pA(pAVarPA, yfoKZx);
        }
        yfoKZx.WQf(jSONObject.optString("deep_link_appname", ""));
        yfoKZx.Vgu(jSONObject.optInt("landing_page_download_clicktype", 1));
        JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("dsp_style");
        if (jSONObjectOptJSONObject20 != null) {
            yfoKZx.pA(new com.bytedance.sdk.openadsdk.core.model.Wx(jSONObjectOptJSONObject20));
        }
        JSONObject jSONObjectOptJSONObject21 = jSONObject.optJSONObject("dsp_adchoices");
        if (jSONObjectOptJSONObject21 != null) {
            yfoKZx.ML(jSONObjectOptJSONObject21.optString("adchoices_icon", ""));
            yfoKZx.JG(jSONObjectOptJSONObject21.optString("adchoices_url", ""));
        }
        String strOptString4 = jSONObject.optString("gdid_encrypted");
        if (!TextUtils.isEmpty(strOptString4)) {
            yfoKZx.du(strOptString4);
        }
        int iOptInt2 = jSONObject.optInt("jump_probability", 0);
        if (iOptInt2 < 0 || iOptInt2 > 100) {
            iOptInt2 = 0;
        }
        yfoKZx.SzT(iOptInt2);
        yfoKZx.GL();
        JSONObject jSONObjectOptJSONObject22 = jSONObject.optJSONObject("ugen");
        if (jSONObjectOptJSONObject22 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject22.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD)) != null) {
            yfoKZx.pA(KZx(jSONObjectOptJSONObject));
            JSONObject jSONObjectOptJSONObject23 = jSONObjectOptJSONObject.optJSONObject("overlay");
            if (jSONObjectOptJSONObject23 != null) {
                yfoKZx.Og(KZx(jSONObjectOptJSONObject23));
            }
        }
        yfoKZx.FQ(jSONObject.optInt("preload_h5_type", 0));
        yfoKZx.omh(jSONObject.optBoolean("hasReportShow", false));
        yfoKZx.roi(jSONObject.optString("endcard_creative", ""));
        JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("ev");
        if (jSONObjectOptJSONObject24 != null) {
            yfoKZx.BSW(jSONObjectOptJSONObject24.optBoolean(a.j, com.bytedance.sdk.openadsdk.BF.pA.KZx.pA));
            yfoKZx.HSv(jSONObjectOptJSONObject24.optInt("wait_time", com.bytedance.sdk.openadsdk.BF.pA.KZx.Og));
            yfoKZx.Mc(jSONObjectOptJSONObject24.optString("label", com.bytedance.sdk.openadsdk.BF.pA.KZx.KZx));
            yfoKZx.pA(new com.bytedance.sdk.openadsdk.BF.pA.Og(yfoKZx));
        }
        return yfoKZx;
    }

    private static com.bytedance.sdk.openadsdk.core.BSW.JG.pA KZx(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar = new com.bytedance.sdk.openadsdk.core.BSW.JG.pA();
        pAVar.pA(jSONObject.optString("id"));
        pAVar.Og(jSONObject.optString("md5"));
        pAVar.KZx(jSONObject.optString("url"));
        return pAVar;
    }

    private static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put("error_code", -1);
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void pA(final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final String str, final com.bytedance.sdk.openadsdk.core.WV.pA pAVar, final long j, final com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA pAVar2) {
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new com.bytedance.sdk.component.omh.omh("vast_parser") { // from class: com.bytedance.sdk.openadsdk.core.Og.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    com.bytedance.sdk.openadsdk.core.WV.pA pAVar3 = pAVar;
                    String str2 = "load_vast_fail";
                    if (pAVar3 != null) {
                        if (TextUtils.isEmpty(pAVar3.Bzk()) || TextUtils.isEmpty(pAVar.JG()) || pAVar.omh() <= 0.0d) {
                            jSONObject.put("reason_code", -3);
                            jSONObject.put("error_code", -3);
                        } else {
                            jSONObject.put("duration", System.currentTimeMillis() - j);
                            com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA pAVar4 = pAVar2;
                            if (pAVar4 != null) {
                                jSONObject.put("wrapper_count", pAVar4.Og);
                                jSONObject.put("impression_links_null", pAVar2.KZx);
                            }
                            str2 = "load_vast_success";
                        }
                    } else {
                        jSONObject.put("reason_code", -2);
                        com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA pAVar5 = pAVar2;
                        if (pAVar5 != null) {
                            jSONObject.put("error_code", pAVar5.pA);
                        }
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, str, str2, jSONObject);
                    com.bytedance.sdk.openadsdk.core.WV.pA pAVar6 = pAVar;
                    if (pAVar6 == null || pAVar6.Og() == null || !TextUtils.isEmpty(pAVar.Og().JG())) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("error_code", 1000);
                        jSONObject2.put("description", "1000:Image url is null");
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, str, "load_vast_icon_fail", jSONObject2);
                    pAVar.pA((com.bytedance.sdk.openadsdk.core.WV.Og) null);
                } catch (Exception unused2) {
                }
            }
        });
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.WV.pA, com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA> pA(String str, int i, int i2) {
        int iKZx;
        int iZZv;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == 1 || i2 == 5) {
            iKZx = 0;
            iZZv = 0;
        } else {
            iKZx = Vgu.KZx(aBv.pA());
            iZZv = Vgu.ZZv(aBv.pA());
            if (i == 2) {
                iZZv = iKZx;
                iKZx = iZZv;
            }
        }
        com.bytedance.sdk.openadsdk.core.WV.pA.pA.ML ml = new com.bytedance.sdk.openadsdk.core.WV.pA.pA.ML(aBv.pA(), iKZx, iZZv);
        return new Pair<>(ml.pA(str, new ArrayList()), ml.JG);
    }

    private static void pA(com.bytedance.sdk.openadsdk.core.WV.pA pAVar, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        pAVar.pA(yfo);
        if (!pA(yfo.JBA())) {
            yfo.yFO(2);
        }
        yfo.ZZv(1);
        yfo.pA(pAVar);
        if (!TextUtils.isEmpty(pAVar.ZZv())) {
            yfo.DX(pAVar.ZZv());
        }
        if (!TextUtils.isEmpty(pAVar.ML())) {
            yfo.oX(pAVar.ML());
        }
        yfo.Wx(pAVar.JG());
        yfo.pA((com.bytedance.sdk.openadsdk.core.model.KZx) null);
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
        if (ogBf == null) {
            ogBf = new com.bykv.vk.openvk.pA.pA.pA.KZx.Og();
        }
        ogBf.KZx(pAVar.SD());
        ogBf.pA(pAVar.omh());
        ogBf.JG((String) null);
        ogBf.Og((String) null);
        ogBf.ZZv((String) null);
        yfo.pA(ogBf);
        if (pAVar.Og() != null && !TextUtils.isEmpty(pAVar.Og().ML())) {
            com.bytedance.sdk.openadsdk.core.model.DX dx = new com.bytedance.sdk.openadsdk.core.model.DX();
            dx.pA(pAVar.Og().ML());
            dx.pA(pAVar.Og().Og());
            dx.Og(pAVar.Og().KZx());
            yfo.pA(dx);
            return;
        }
        if (yfo.fJy() == null) {
            com.bytedance.sdk.openadsdk.core.model.DX dx2 = new com.bytedance.sdk.openadsdk.core.model.DX();
            dx2.pA("https://sf16-fe-tos-sg.i18n-pglstatp.com/obj/ad-pattern-sg/static/images/2023620white.jpeg");
            dx2.pA(98);
            dx2.Og(98);
            yfo.pA(dx2);
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.ZZv ZZv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("splash_clickarea", 2);
        int iOptInt2 = jSONObject.optInt("splash_layout_id", 1);
        long jOptLong = jSONObject.optLong("load_wait_time", 0L);
        long j = jOptLong >= 0 ? jOptLong : 0L;
        com.bytedance.sdk.openadsdk.core.model.ZZv zZv = new com.bytedance.sdk.openadsdk.core.model.ZZv();
        zZv.pA(iOptInt);
        zZv.Og(iOptInt2);
        zZv.pA(j);
        return zZv;
    }

    public static AdSlot Og(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("mCodeId", "");
        int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float fOptDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int iOptInt3 = jSONObject.optInt("mAdCount", 6);
        boolean zOptBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String strOptString2 = jSONObject.optString("mRewardName", "");
        int iOptInt4 = jSONObject.optInt("mRewardAmount", 0);
        String strOptString3 = jSONObject.optString("mMediaExtra", "");
        String strOptString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int iOptInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean zOptBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String strOptString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(strOptString).setImageAcceptedSize(iOptInt, iOptInt2).setExpressViewAcceptedSize(fOptDouble, fOptDouble2).setAdCount(iOptInt3).setSupportDeepLink(zOptBoolean).setRewardName(strOptString2).setRewardAmount(iOptInt4).setMediaExtra(strOptString3).setUserID(strOptString4).setNativeAdType(iOptInt5).setIsAutoPlay(zOptBoolean2).isExpressAd(zOptBoolean3).withBid(strOptString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    private static FilterWord ML(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    FilterWord filterWordML = ML(jSONArrayOptJSONArray.optJSONObject(i));
                    if (filterWordML != null && filterWordML.isValid()) {
                        filterWord.addOption(filterWordML);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.KZx JG(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.KZx kZx = new com.bytedance.sdk.openadsdk.core.model.KZx();
        kZx.Og(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        kZx.KZx(jSONObject.optString("package_name"));
        kZx.pA(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        kZx.pA(jSONObject.optDouble("score", -1.0d));
        kZx.pA(jSONObject.optInt("comment_num", -1));
        kZx.Og(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        kZx.ZZv(jSONObject.optString("app_category"));
        return kZx;
    }

    private static com.bytedance.sdk.openadsdk.core.model.XT SD(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.XT xt = new com.bytedance.sdk.openadsdk.core.model.XT();
        if (jSONObject == null) {
            xt.pA(10L);
            xt.Og(20L);
            xt.KZx(10L);
            xt.ZZv(20L);
            xt.pA("");
            return xt;
        }
        xt.pA(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        xt.Og(jSONObject.optLong("straight_lp_showtime", 20L));
        xt.KZx(jSONObject.optLong("onlyagg_loading_maxtime", 10L));
        xt.ZZv(jSONObject.optLong("straight_agg_showtime", 20L));
        xt.pA(jSONObject.optString("loading_text", ""));
        return xt;
    }

    private static com.bytedance.sdk.openadsdk.core.model.oX omh(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.oX oXVar = new com.bytedance.sdk.openadsdk.core.model.oX();
        if (jSONObject == null) {
            oXVar.pA(5);
            oXVar.Og(30);
            oXVar.KZx(70);
            oXVar.ZZv(1);
            oXVar.ML(com.bytedance.sdk.openadsdk.core.model.oX.pA);
            return oXVar;
        }
        oXVar.pA(jSONObject.optInt("ceiling_time", 5));
        oXVar.Og(jSONObject.optInt("ceiling_ratio", 30));
        oXVar.KZx(jSONObject.optInt("expand_ratio", 70));
        oXVar.ZZv(jSONObject.optInt("back_type", 1));
        oXVar.ML(jSONObject.optInt("boc_return_type", com.bytedance.sdk.openadsdk.core.model.oX.pA));
        return oXVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.ML Bzk(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.ML ml = new com.bytedance.sdk.openadsdk.core.model.ML();
        if (jSONObject == null) {
            ml.KZx(0);
            ml.ZZv(0);
            ml.Og(new ArrayList());
            ml.ML(0);
            ml.pA(new ArrayList());
            ml.Og(0);
            ml.pA(0);
            return ml;
        }
        ml.KZx(jSONObject.optInt("interceptor_x", 0));
        ml.ZZv(jSONObject.optInt("interceptor_y", 0));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("interceptor_page");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
            }
        }
        ml.Og(arrayList);
        ml.ML(jSONObject.optInt("interceptor_interval_time", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("url_regular");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
            }
        }
        ml.pA(arrayList2);
        ml.Og(jSONObject.optInt("boc_index", 0));
        ml.pA(jSONObject.optInt("is_act", 0));
        return ml;
    }

    private static com.bytedance.sdk.openadsdk.core.model.WV SGo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.WV wv = new com.bytedance.sdk.openadsdk.core.model.WV();
        wv.pA(jSONObject.optInt("if_send_click", 0));
        return wv;
    }

    private static com.bytedance.sdk.openadsdk.core.model.BSW BSW(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.BSW bsw = new com.bytedance.sdk.openadsdk.core.model.BSW();
        bsw.pA(jSONObject.optString("deeplink_url"));
        bsw.Og(jSONObject.optString("fallback_url"));
        bsw.pA(jSONObject.optInt("fallback_type"));
        return bsw;
    }

    private static com.bykv.vk.openvk.pA.pA.pA.KZx.Og pA(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.yFO yfo, boolean z) {
        int iOptInt;
        if (jSONObject == null) {
            return null;
        }
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og og = new com.bykv.vk.openvk.pA.pA.pA.KZx.Og();
        og.Og(jSONObject.optInt("cover_height"));
        og.KZx(jSONObject.optInt("cover_width"));
        og.pA(jSONObject.optString("resolution"));
        og.pA(jSONObject.optLong(ContentDisposition.Parameters.Size));
        double dOptDouble = jSONObject.optDouble("video_duration", 0.0d);
        og.pA(dOptDouble);
        int i = 1;
        int iOptInt2 = jSONObject.optInt("replay_time", 1);
        if (dOptDouble <= 15.0d && yfo.BF() != 1 && com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo)) {
            i = iOptInt2;
        }
        og.SGo(i);
        og.Og(jSONObject.optString("cover_url"));
        og.KZx(jSONObject.optString("video_url"));
        og.ZZv(jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
        og.ML(jSONObject.optString("playable_download_url"));
        og.JG(jSONObject.optString("file_hash"));
        og.omh(jSONObject.optInt("if_playable_loading_show", 0));
        og.Bzk(jSONObject.optInt("remove_loading_page_type", 0));
        og.pA(jSONObject.optInt("fallback_endcard_judge", 0));
        og.ML(jSONObject.optInt("video_preload_size", 307200));
        og.JG(jSONObject.optInt("reward_video_cached_type", 0));
        og.SD(jSONObject.optInt("execute_cached_type", 0));
        if (z) {
            iOptInt = jSONObject.optInt("endcard_render", 0);
        } else {
            iOptInt = jSONObject.optInt("endcard_render", -1);
        }
        og.ZZv(iOptInt);
        return og;
    }

    private static Map<String, Object> WV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x0097  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    private static int pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        int iPA;
        int iPA2;
        if (yfo == null) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.KZx((com.bytedance.sdk.openadsdk.core.model.yFO) null, "", 401);
            return 401;
        }
        String strKZx = gbA.KZx(yfo.FHA());
        if (TextUtils.isEmpty(yfo.nCO()) || yfo.nCO().length() <= 1) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 402);
            return 402;
        }
        if (yfo.qQU()) {
            if (yfo.FHA() < 0) {
                if (yfo.rB() != null) {
                    yfo.rB().getDurationSlotType();
                } else {
                    yfo.PKZ();
                }
            }
            if (yfo.qH()) {
                strKZx = "fullscreen_interstitial_ad";
            }
            if (TextUtils.isEmpty(yfo.Xj())) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, strKZx, "load_html_fail", (JSONObject) null);
                return 401;
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, strKZx, "load_html_success", (JSONObject) null);
        }
        if (yfo.Lf() == 0) {
            int iRS = yfo.RS();
            if (iRS == 2 || iRS == 3 || iRS == 4) {
                iPA = pA(yfo.IIF());
                if (iPA != 200) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA);
                    return iPA;
                }
            } else if (iRS == 5 || iRS == 15) {
                iPA2 = pA(yfo.Bf(), yfo.rjD());
                if (iPA2 != 200) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA2);
                    return iPA2;
                }
            } else if (iRS == 16) {
                iPA = pA(yfo.IIF());
                if (iPA != 200) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA);
                    return iPA;
                }
            } else if (iRS == 50) {
                iPA2 = pA(yfo.Bf(), yfo.rjD());
                if (iPA2 != 200) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA2);
                    return iPA2;
                }
            }
        }
        if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().mK()) {
            return KZx(yfo);
        }
        return Og(yfo);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0079  */
    private static int Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        int iPA;
        String strKZx = gbA.KZx(yfo.FHA());
        if (yfo.Lf() == 0) {
            iPA = pA(yfo.Itl());
            com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA);
        } else {
            iPA = 200;
        }
        int iJBA = yfo.JBA();
        if (iJBA == 2 || iJBA == 3) {
            if (ZZv(yfo) && TextUtils.isEmpty(yfo.dC())) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 406);
                iPA = 406;
            }
        } else if (iJBA == 4) {
            com.bytedance.sdk.openadsdk.core.model.KZx kZxWo = yfo.Wo();
            if (kZxWo == null) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 407);
                iPA = 407;
            } else if (TextUtils.isEmpty(kZxWo.KZx()) && TextUtils.isEmpty(kZxWo.pA())) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME);
                iPA = 417;
            } else if (TextUtils.isEmpty(kZxWo.KZx())) {
                iPA = 416;
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 416);
            } else if (TextUtils.isEmpty(kZxWo.pA())) {
                iPA = 408;
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 408);
            }
        } else if (iJBA == 8) {
            if (ZZv(yfo)) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 406);
                iPA = 406;
            }
        }
        if (iPA == 417 || iPA == 407 || iPA == 406) {
            return iPA;
        }
        if (iPA != 200) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, strKZx, iPA);
        }
        return 200;
    }

    private static int KZx(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        int iPA;
        String strKZx = gbA.KZx(yfo.FHA());
        if (yfo.Lf() == 0) {
            iPA = pA(yfo.Itl());
            if (iPA != 200) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA);
                return iPA;
            }
        } else {
            iPA = 200;
        }
        int iJBA = yfo.JBA();
        if (iJBA != 2 && iJBA != 3) {
            if (iJBA == 4) {
                int iPA2 = pA(yfo.Wo());
                if (iPA2 == 200) {
                    return iPA2;
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, iPA2);
                return iPA2;
            }
            if (iJBA != 8) {
                return iPA;
            }
        }
        if (!ZZv(yfo) || !TextUtils.isEmpty(yfo.dC())) {
            return iPA;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(yfo, strKZx, 406);
        return 406;
    }

    private static boolean ZZv(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        return (yfo.rjD() || yfo.qQU()) ? false : true;
    }

    private static int pA(com.bytedance.sdk.openadsdk.core.model.BSW bsw) {
        if (bsw == null) {
            return 200;
        }
        if (TextUtils.isEmpty(bsw.pA())) {
            return 403;
        }
        if (TextUtils.isEmpty(bsw.Og())) {
            return 404;
        }
        return (bsw.KZx() == 1 || bsw.KZx() == 2) ? 200 : 405;
    }

    private static int pA(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og, boolean z) {
        if (og == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(og.BSW())) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z || !TextUtils.isEmpty(og.SGo())) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static int pA(com.bytedance.sdk.openadsdk.core.model.KZx kZx) {
        if (kZx == null) {
            return 407;
        }
        if (TextUtils.isEmpty(kZx.pA())) {
            return 408;
        }
        return TextUtils.isEmpty(kZx.KZx()) ? 416 : 200;
    }

    private static int pA(List<com.bytedance.sdk.openadsdk.core.model.DX> list) {
        if (list == null) {
            return 409;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (com.bytedance.sdk.openadsdk.core.model.DX dx : list) {
            if (dx == null) {
                return 411;
            }
            if (TextUtils.isEmpty(dx.pA())) {
                return 412;
            }
        }
        return 200;
    }

    private static void pA(final ArrayList<pA> arrayList) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("multiple_ads_parsing_error", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.Og.3
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material_error", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                for (pA pAVar : arrayList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", pAVar.pA);
                    jSONObject2.put("error_msg", pAVar.Og);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("error_cid_list", jSONArray);
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("multiple_ads_parsing_error").Og(jSONObject.toString());
            }
        });
    }

    private static class pA {
        public int Og;
        public String pA;

        public pA(String str, int i) {
            this.pA = str;
            this.Og = i;
        }
    }
}
