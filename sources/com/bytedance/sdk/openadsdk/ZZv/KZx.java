package com.bytedance.sdk.openadsdk.ZZv;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.WQf;
import com.bytedance.sdk.openadsdk.core.model.eG;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.json.b9;
import com.json.m5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class KZx {
    public static void pA() {
        try {
            Class.forName(KZx.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void pA(yFO yfo, String str, final int i) {
        pA(System.currentTimeMillis(), yfo, str, "open_url_h5", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.1
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("preload_status", Integer.valueOf(i));
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(final yFO yfo, String str) {
        pA(System.currentTimeMillis(), yfo, str, "endcard_load_start", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.12
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (yFO.KZx(yfo)) {
                        if (yfo.Mx() != null) {
                            jSONObject2.putOpt("url", yfo.Mx().KZx());
                            jSONObject2.putOpt("id", yfo.Mx().pA());
                            jSONObject2.putOpt("md5", yfo.Mx().Og());
                        }
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", yfo.Bf().WV());
                        jSONObject2.putOpt("style_id", yfo.tpV());
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void pA(final yFO yfo, String str, final long j) {
        pA(System.currentTimeMillis(), yfo, str, "endcard_load_finish", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.22
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (yFO.KZx(yfo)) {
                        if (yfo.Mx() != null) {
                            jSONObject2.putOpt("url", yfo.Mx().KZx());
                            jSONObject2.putOpt("id", yfo.Mx().pA());
                            jSONObject2.putOpt("md5", yfo.Mx().Og());
                        }
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", yfo.Bf().WV());
                        jSONObject2.putOpt("style_id", yfo.tpV());
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void pA(final yFO yfo, String str, final long j, final int i, final String str2, final String str3) {
        pA(System.currentTimeMillis(), yfo, str, "endcard_load_fail", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.33
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (yFO.KZx(yfo)) {
                        if (yfo.Mx() != null) {
                            jSONObject2.putOpt("url", yfo.Mx().KZx());
                            jSONObject2.putOpt("id", yfo.Mx().pA());
                            jSONObject2.putOpt("md5", yfo.Mx().Og());
                        }
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", yfo.Bf().WV());
                        jSONObject2.putOpt("style_id", yfo.tpV());
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject2.putOpt("error_url", str3);
                        }
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject2.put("error_code", i);
                    jSONObject2.put("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void pA(final yFO yfo, String str, final long j, final int i, final int i2) {
        pA(System.currentTimeMillis(), yfo, str, "load", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.44
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("interaction_method", Integer.valueOf(yfo.XT()));
                    jSONObject2.put("first_page", i2);
                    jSONObject2.put("preload_h5_type", yfo.Bi());
                    int i3 = i;
                    if (i3 >= 0) {
                        jSONObject2.putOpt("preload_status", Integer.valueOf(i3));
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", Math.min(j, 600000L));
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(String str, yFO yfo, String str2, final Map<String, Object> map) {
        pA(System.currentTimeMillis(), yfo, str2, str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.47
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (map != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry entry : map.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(long j, yFO yfo, String str, String str2, final JSONObject jSONObject, SD sd, com.bytedance.sdk.openadsdk.ZZv.Og.pA pAVar) {
        pA(j, yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.48
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                return jSONObject;
            }
        });
    }

    @DungeonFlag
    public static void pA(yFO yfo, String str, JSONObject jSONObject) {
        ZZv(yfo, m5.v, str, jSONObject);
    }

    @DungeonFlag
    private static void ZZv(final yFO yfo, final String str, final String str2, final JSONObject jSONObject) {
        if (yfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (yfo.boc() && m5.v.equals(str)) {
            return;
        }
        if (m5.v.equals(str)) {
            yfo.omh(true);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pA(new com.bytedance.sdk.component.omh.omh("onShow") { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.49
            @Override // java.lang.Runnable
            public void run() {
                final String strPA;
                if (!com.bytedance.sdk.openadsdk.core.aBv.ZZv().bU()) {
                    strPA = "none";
                } else {
                    strPA = com.bytedance.sdk.openadsdk.core.Bzk.pA.pA.pA((Application) com.bytedance.sdk.openadsdk.core.aBv.pA()).pA(str2, DeviceUtils.pA(), yfo.Wf());
                }
                KZx.pA(jCurrentTimeMillis, yfo, str2, str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.49.1
                    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                    public JSONObject pA() {
                        Object obj;
                        try {
                            WQf.Og(yfo);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                if (jSONObject != null) {
                                    jSONObject.put("interaction_method", yfo.XT());
                                    jSONObject.put("real_interaction_method", yfo.aBv());
                                    jSONObject.put("video_skip_result", com.bytedance.sdk.openadsdk.core.aBv.ZZv().Wx(String.valueOf(yfo.Wf())));
                                    jSONObject.put("au_show", strPA);
                                    com.bytedance.sdk.openadsdk.yFO.pA.pA.pA(yfo, jSONObject);
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                } else {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("interaction_method", yfo.XT());
                                    jSONObject3.put("real_interaction_method", yfo.aBv());
                                    jSONObject3.put("video_skip_result", com.bytedance.sdk.openadsdk.core.aBv.ZZv().Wx(String.valueOf(yfo.Wf())));
                                    jSONObject3.put("au_show", strPA);
                                    com.bytedance.sdk.openadsdk.yFO.pA.pA.pA(yfo, jSONObject3);
                                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                                }
                                jSONObject2.putOpt("log_extra", yfo.tM());
                                float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - yfo.mM()).floatValue();
                                if (fFloatValue <= 0.0f) {
                                    fFloatValue = 0.0f;
                                }
                                jSONObject2.putOpt("show_time", Float.valueOf(fFloatValue));
                                jSONObject2.putOpt("ua_policy", Integer.valueOf(yfo.Vgu()));
                                String strRoi = yfo.roi();
                                if (!TextUtils.isEmpty(strRoi) && !TextUtils.isEmpty(strRoi)) {
                                    try {
                                        jSONObject2.put("ttdsp_price", Math.round(Float.parseFloat(strRoi) * 100000.0f));
                                    } catch (Throwable th) {
                                        jSONObject2.put("ttdsp_price", 0);
                                        com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", th.getMessage());
                                    }
                                }
                                if (yfo.tZW() == null) {
                                    return jSONObject2;
                                }
                                try {
                                    Object obj2 = yfo.tZW().get(TTAdConstant.SDK_BIDDING_TYPE);
                                    if (obj2 == null || Integer.parseInt(obj2.toString()) != 2 || (obj = yfo.tZW().get("price")) == null) {
                                        return jSONObject2;
                                    }
                                    jSONObject2.put("ttdsp_price", Math.round(Double.parseDouble(obj.toString()) * 100000.0d));
                                    return jSONObject2;
                                } catch (Throwable th2) {
                                    com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", "client bidding price error: ", th2);
                                    return jSONObject2;
                                }
                                return jSONObject2;
                            } catch (Exception unused) {
                                return jSONObject2;
                            }
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                });
                if (m5.v.equals(str)) {
                    if (!yfo.ka()) {
                        if (yfo.qH()) {
                            com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(yfo.PV(), new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("show_urls", yfo));
                        } else {
                            KZx.pA(yfo);
                        }
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        int iOptInt = jSONObject2.optInt("dynamic_show_type");
                        if (yfo.LAE() == 1 && (iOptInt == 7 || iOptInt == 10)) {
                            com.bytedance.sdk.component.utils.SD.pA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.49.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("auto_click", true);
                                        KZx.Og(yfo, str2, "click", jSONObject3);
                                    } catch (Exception unused) {
                                        com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", "ugen click exception");
                                    }
                                }
                            }, com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Ld());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA(yfo, strPA);
                }
            }
        });
    }

    public static void pA(yFO yfo) {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.WV.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()))) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.BF.pA.pA(yfo.PV(), true), 1, yfo.nCO());
    }

    @DungeonFlag
    public static void pA(final String str, final yFO yfo, final String str2, final SD sd) {
        if (yfo == null || sd == null || !sd.pA()) {
            return;
        }
        pA(System.currentTimeMillis(), yfo, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.50
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", str);
                    SD sd2 = sd;
                    if (sd2 != null && sd2.Og() != null) {
                        JSONObject jSONObjectOg = sd.Og();
                        if (str2.equals("open_ad")) {
                            jSONObjectOg.put("is_icon_only", yfo.zi() ? 1 : 0);
                        }
                        jSONObject.put("ad_extra_data", jSONObjectOg.toString());
                    }
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(final yFO yfo, final String str, final qmB qmb) {
        if (yfo == null) {
            return;
        }
        final long jZZv = qmb.ZZv();
        pA(System.currentTimeMillis(), yfo, str, "stay_duration", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.2
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("click_stay_time", jZZv);
                    jSONObject.put("click_time", qmb.pA);
                    if (str.equals("open_ad")) {
                        jSONObject.put("is_icon_only", yfo.zi() ? 1 : 0);
                    }
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void Og(yFO yfo, String str, final long j) {
        if (yfo != null && j > 0 && j < 200000) {
            pA(System.currentTimeMillis(), yfo, str, "video_click_duration", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.3
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put("video_click_duration_time", j);
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    public static void pA(yFO yfo, final String str, final int i, final String str2, final long j, final boolean z, final int i2, final long j2) {
        pA(System.currentTimeMillis(), yfo, str, Og.ZZv, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.4
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("invisible_scene", i);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("loading_visible_time", j);
                    jSONObject.put("arbi_trigger_start", z);
                    jSONObject.put("arbi_convert_count", i2);
                    jSONObject.put("loading_start_timestamp", j2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                new Object[]{"-->onArbitrageLoading", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void pA(yFO yfo, String str, final long j, final boolean z) {
        pA(System.currentTimeMillis(), yfo, str, "lp_loading", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.5
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("if_lp_loading_success", z ? 1 : 2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void KZx(yFO yfo, String str, final long j) {
        pA(System.currentTimeMillis(), yfo, str, "load_feeling_duration", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.6
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", j);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", th.getMessage());
                }
                new Object[]{"onLpFeelingDuration -->", jSONObject.toString()};
                return jSONObject;
            }
        });
    }

    public static void Og(yFO yfo, String str, final int i) {
        pA(System.currentTimeMillis(), yfo, str, "check_meta", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.7
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("error_code", i);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.oX.vkV().mK());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void KZx(yFO yfo, String str, final int i) {
        pA(System.currentTimeMillis(), yfo, str, "check_meta_more", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.8
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("error_code", i);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.oX.vkV().mK());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void pA(yFO yfo, final String str, final int i, final String str2, final int i2) {
        pA(System.currentTimeMillis(), yfo, str, Og.pA, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.9
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("index", i);
                    jSONObject.put("arbi_current_url", str2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("new_index", i2);
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                new Object[]{"-->onArbitrageLoadStart", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void pA(yFO yfo, final String str, final int i, final String str2, final float f) {
        pA(System.currentTimeMillis(), yfo, str, Og.Og, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.10
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("index", i);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("arbi_load_duration", f);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                new Object[]{"-->onArbitrageLoadFinish", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void pA(yFO yfo, final String str, final int i, final String str2, final String str3, final int i2) {
        pA(System.currentTimeMillis(), yfo, str, Og.KZx, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.11
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("index", i);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, str3);
                    jSONObject.put("url_flag", i2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                new Object[]{"-->onArbitrageLoadUrl", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void ZZv(final yFO yfo, final String str, final int i) {
        pA(System.currentTimeMillis(), yfo, str, "material_status", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.13
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("trigger_type", i);
                    jSONObject3.put("image_mode", yfo.RS());
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    new Object[]{"report onMaterialStatus, ad_extra_data is:", jSONObject.toString(), str};
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void Og(final yFO yfo, String str) {
        pA(System.currentTimeMillis(), yfo, str, "picture_click", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.14
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("ad_slot_type", yfo.rB().getNativeAdType());
                    jSONObject.put("interaction_method", yfo.XT());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                return jSONObject2;
            }
        });
    }

    @DungeonFlag
    public static void pA(final String str, final yFO yfo, final com.bytedance.sdk.openadsdk.core.model.SGo sGo, final String str2, final boolean z, final Map<String, Object> map, final int i) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pA(new com.bytedance.sdk.component.omh.omh("onClick") { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.15
            @Override // java.lang.Runnable
            public void run() {
                yFO yfo2 = yfo;
                if (yfo2 == null) {
                    return;
                }
                KZx.pA(jCurrentTimeMillis, yfo2, str2, str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.15.1
                    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                    public JSONObject pA() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (sGo != null) {
                                JSONObject jSONObjectPA = sGo.pA();
                                jSONObjectPA.put("is_valid", z);
                                if (i > 0 && i <= 2) {
                                    jSONObjectPA.put("user_behavior_type", i);
                                }
                                if (map != null) {
                                    if (map.containsKey("duration")) {
                                        jSONObject.put("duration", map.get("duration"));
                                    }
                                    for (Map.Entry entry : map.entrySet()) {
                                        if (!"duration".equals(entry.getKey())) {
                                            jSONObjectPA.put((String) entry.getKey(), entry.getValue());
                                        }
                                    }
                                }
                                jSONObjectPA.put("interaction_method", yfo.XT());
                                if (str2.equals("open_ad")) {
                                    jSONObjectPA.put("is_icon_only", yfo.zi() ? 1 : 0);
                                }
                                jSONObject.put("ad_extra_data", jSONObjectPA.toString());
                            }
                            jSONObject.putOpt("log_extra", yfo.tM());
                            float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - yfo.mM()).floatValue();
                            if (fFloatValue <= 0.0f) {
                                fFloatValue = 0.0f;
                            }
                            jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
                            jSONObject.putOpt("ua_policy", Integer.valueOf(yfo.Vgu()));
                        } catch (Exception unused) {
                        }
                        return jSONObject;
                    }
                });
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.WV.pA(com.bytedance.sdk.openadsdk.core.aBv.pA())) && "click".equals(str)) {
                    com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.BF.pA.pA(yfo.cFQ(), true), 2, yfo.nCO());
                }
                if ("click".equals(str)) {
                    WQf.KZx(yfo);
                }
            }
        });
    }

    public static void pA(yFO yfo, String str, String str2, final JSONObject jSONObject) {
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.16
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                if (jSONObject == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    if (jSONObject.has("duration")) {
                        jSONObject2.put("duration", jSONObject.get("duration"));
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", e.getMessage());
                }
                return jSONObject2;
            }
        });
        if ("click".equals(str2)) {
            WQf.KZx(yfo);
        }
    }

    public static void pA(yFO yfo, String str, final int i, final long j) {
        pA(System.currentTimeMillis(), yfo, str, "video_choose", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.17
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("video_choose", i);
                    jSONObject2.put("video_choose_duration", j);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.toString());
                }
                return jSONObject;
            }
        });
    }

    public static void pA(yFO yfo, String str, final String str2, final long j, final int i, JSONObject jSONObject, final SD sd) {
        final JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.18
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                SD sd2;
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("duration", j);
                    jSONObject3.put("percent", i);
                    if (("feed_break".equals(str2) || "feed_over".equals(str2)) && (sd2 = sd) != null) {
                        sd2.pA(jSONObject2);
                    }
                    jSONObject3.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject3;
            }
        });
    }

    public static void Og(yFO yfo, String str, String str2, final JSONObject jSONObject) {
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.19
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pA(yFO yfo, String str, String str2, final JSONObject jSONObject, final long j) {
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.20
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                    jSONObject2.put("duration", j);
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pA(final yFO yfo, String str, String str2, final Map<String, Object> map) {
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.21
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        Object obj = map.get("duration");
                        if (obj instanceof Long) {
                            jSONObject.put("duration", obj);
                        }
                    }
                    jSONObject2.put("dp_creative_type", yfo.Lf());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    @DungeonFlag
    public static void pA(long j, yFO yfo, String str, String str2) {
        pA(j, yfo, str, str2, (com.bytedance.sdk.openadsdk.Sn.KZx.pA) null);
    }

    @DungeonFlag
    public static void pA(final long j, final yFO yfo, final String str, final String str2, final com.bytedance.sdk.openadsdk.Sn.KZx.pA pAVar) {
        if (yfo == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || pA(yfo.dz(), str2)) {
            return;
        }
        pA(new com.bytedance.sdk.component.omh.omh(str2) { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.23
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                try {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA pAVar2 = pAVar;
                    if (pAVar2 != null) {
                        jSONObject = pAVar2.pA();
                        if (jSONObject == null) {
                            try {
                                jSONObject = new JSONObject();
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.putOpt("log_extra", yfo.tM());
                    jSONObject.putOpt("ua_policy", Integer.valueOf(yfo.Vgu()));
                } catch (Exception unused2) {
                    jSONObject = null;
                }
                new com.bytedance.sdk.openadsdk.ZZv.pA.C0217pA(j, yfo).Og(str).KZx(str2).ML(yfo.nCO()).omh(yfo.ZQ()).pA(yfo.bU()).pA(jSONObject).SD(yfo.Ij()).pA((com.bytedance.sdk.openadsdk.ZZv.Og.pA) null);
            }
        });
    }

    public static void pA(yFO yfo, String str, final String str2, final com.bytedance.sdk.openadsdk.Sn.KZx.pA pAVar) {
        pA(System.currentTimeMillis(), yfo, str, "playable_track", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.24
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA pAVar2 = pAVar;
                    if (pAVar2 == null || (jSONObject = pAVar2.pA()) == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("is_new_playable", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pag_json_data", jSONObject.toString());
                    jSONObject3.put("playable_event", str2);
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void Og(final long j, final yFO yfo, String str, final String str2) {
        pA(System.currentTimeMillis(), yfo, str, "endcard_feeling_duraion", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.25
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("duration", j);
                    if (yFO.KZx(yfo)) {
                        if (yfo.Mx() != null) {
                            jSONObject2.putOpt("url", yfo.Mx().KZx());
                            jSONObject2.putOpt("id", yfo.Mx().pA());
                            jSONObject2.putOpt("md5", yfo.Mx().Og());
                        }
                        jSONObject2.putOpt(TypedValues.TransitionType.S_FROM, str2);
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.put("url", yfo.Bf().WV());
                        jSONObject2.put("style_id", yfo.tpV());
                        if (yfo.Bf() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void KZx(final yFO yfo, String str) {
        if (yfo == null || !yFO.KZx(yfo) || yfo.Mx() == null) {
            return;
        }
        pA(System.currentTimeMillis(), yfo, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.26
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", yfo.Mx().KZx());
                    jSONObject2.putOpt("id", yfo.Mx().pA());
                    jSONObject2.putOpt("md5", yfo.Mx().Og());
                    if (yfo.Bf() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(yfo.Bf().ZZv()));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(yFO yfo, final com.bytedance.sdk.openadsdk.Sn.pA.pA pAVar, final String str) {
        pA(System.currentTimeMillis(), yfo, str, "web_behavior_keyword", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.27
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", pAVar.KZx());
                    jSONObject2.put("keyword", pAVar.aBv());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    TX.Og("TTAD.AdEvent", "onWebBehaviorKeyword", th.getMessage());
                }
                new Object[]{"onWebBehaviorKeyword-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void Og(yFO yfo, final com.bytedance.sdk.openadsdk.Sn.pA.pA pAVar, final String str) {
        pA(System.currentTimeMillis(), yfo, str, "web_behavior_load", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.28
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", pAVar.KZx());
                    jSONObject2.put("current_url_index", pAVar.ZZv());
                    jSONObject2.put("arbi_load_duration", pAVar.XT());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    TX.Og("TTAD.AdEvent", "onWebBehaviorLoad", th.getMessage());
                }
                new Object[]{"onWebBehaviorLoad-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void KZx(yFO yfo, final com.bytedance.sdk.openadsdk.Sn.pA.pA pAVar, final String str) {
        pA(System.currentTimeMillis(), yfo, str, "web_behavior_stay", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.29
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", pAVar.KZx());
                    jSONObject2.put("current_url_index", pAVar.ZZv());
                    jSONObject2.put("arbi_stay_duration", pAVar.Sn());
                    jSONObject2.put("browsing_percentage", pAVar.DX());
                    jSONObject2.put("out_focus_scene", pAVar.oX());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    TX.Og("TTAD.AdEvent", "onWebBehaviorStay", th.getMessage());
                }
                new Object[]{"onWebBehaviorStay-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void ZZv(yFO yfo, final com.bytedance.sdk.openadsdk.Sn.pA.pA pAVar, final String str) {
        pA(System.currentTimeMillis(), yfo, str, "web_behavior_scroll", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.30
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", pAVar.KZx());
                    jSONObject2.put("current_url_index", pAVar.ZZv());
                    jSONObject2.put("trigger_scroll_x", pAVar.Bzk());
                    jSONObject2.put("trigger_scroll_y", pAVar.SGo());
                    jSONObject2.put("arbi_offset_y", pAVar.BSW());
                    jSONObject2.put("scroll_type", pAVar.WV());
                    jSONObject2.put("scroll_duration", pAVar.Wx());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    TX.Og("TTAD.AdEvent", "onWebBehaviorScroll", th.getMessage());
                }
                new Object[]{"onWebBehaviorScroll-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void ML(yFO yfo, final com.bytedance.sdk.openadsdk.Sn.pA.pA pAVar, final String str) {
        pA(System.currentTimeMillis(), yfo, str, "web_behavior_click", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.31
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", pAVar.KZx());
                    jSONObject2.put("current_url_index", pAVar.ZZv());
                    jSONObject2.put("arbi_start_x", pAVar.ML());
                    jSONObject2.put("arbi_start_y", pAVar.JG());
                    jSONObject2.put("click_duration", pAVar.SD());
                    jSONObject2.put("is_trigger_jump", pAVar.omh());
                    jSONObject2.put("click_type", String.valueOf(pAVar.yFO()));
                    if (pAVar.pA() != -1) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("hit_type", pAVar.pA());
                        jSONObject3.put("hit_extra", pAVar.Og());
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    TX.Og("TTAD.AdEvent", "onWebBehaviorClick", th.getMessage());
                }
                new Object[]{"onWebBehaviorClick-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void pA(final long j, final yFO yfo, String str) {
        if (yfo == null || !yFO.KZx(yfo) || yfo.Mx() == null) {
            return;
        }
        pA(System.currentTimeMillis(), yfo, str, "endcard_close", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.32
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", yfo.Mx().KZx());
                    jSONObject2.putOpt("id", yfo.Mx().pA());
                    jSONObject2.putOpt("md5", yfo.Mx().Og());
                    if (yfo.Bf() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(yfo.Bf().ZZv()));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void pA(yFO yfo, String str, final String str2) {
        pA(System.currentTimeMillis(), yfo, str, "show_error", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.34
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(yFO yfo, String str, String str2, final long j, final JSONObject jSONObject) {
        if (yfo == null || jSONObject == null) {
            return;
        }
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.35
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("duration", j);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", e.getMessage());
                }
                return jSONObject2;
            }
        });
    }

    public static void Og(yFO yfo, String str, String str2, final JSONObject jSONObject, final long j) {
        if (yfo == null || jSONObject == null) {
            return;
        }
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.36
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void KZx(yFO yfo, final String str, final String str2, final JSONObject jSONObject) {
        if (yfo == null || jSONObject == null) {
            return;
        }
        pA(System.currentTimeMillis(), yfo, str, str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.37
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException unused) {
                }
                new Object[]{"extJson: ", jSONObject2, "tag: ", str, "label: ", str2};
                return jSONObject2;
            }
        });
    }

    public static void Og(yFO yfo, final String str, final JSONObject jSONObject) {
        pA(System.currentTimeMillis(), yfo, str, Og.ML, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.38
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                new Object[]{"extJson: ", jSONObject2, "tag: ", str, "label: ", Og.ML};
                return jSONObject2;
            }
        });
    }

    public static void KZx(yFO yfo, final String str, final JSONObject jSONObject) {
        pA(System.currentTimeMillis(), yfo, str, Og.JG, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.39
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                new Object[]{"extJson: ", jSONObject2, "tag: ", str, "label: ", Og.JG};
                return jSONObject2;
            }
        });
    }

    public static void pA(String str, long j) {
        com.bytedance.sdk.openadsdk.core.SD.KZx.pA(str, j);
    }

    @DungeonFlag
    public static void pA(final yFO yfo, final String str, final String str2, final String str3, final long j, final long j2, final JSONObject jSONObject, final boolean z) {
        if (yfo == null || pA(yfo.dz(), str3)) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pA(new com.bytedance.sdk.component.omh.omh("sendJsAdEvent") { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.40
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArrayOptJSONArray;
                String strBU = yfo.bU();
                if (jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        String strOptString = jSONObject.optString("ad_extra_data");
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject2 = PangleNetworkBridge.jsonObjectInit(strOptString);
                        }
                        if (!"click".equals(str3)) {
                            jSONObject2.put("device", DeviceUtils.ML(com.bytedance.sdk.openadsdk.core.aBv.pA()).toString());
                        }
                        if ("click".equals(str3)) {
                            if (z) {
                                jSONObject2.put("click_scence", 1);
                            } else if (com.bytedance.sdk.openadsdk.core.model.WQf.Og(yfo)) {
                                jSONObject2.put("click_scence", 3);
                            }
                        }
                        if (yfo.SRe()) {
                            try {
                                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("pag_json_data");
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                jSONObjectOptJSONObject.put("is_new_playable", 1);
                                if (yfo.ISu()) {
                                    jSONObjectOptJSONObject.put("is_pre_render", 1);
                                }
                                jSONObject2.put("pag_json_data", jSONObjectOptJSONObject.toString());
                            } catch (Throwable unused) {
                            }
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("tag", str2);
                        int iOptInt = jSONObject2.optInt("agg_request_type", -1);
                        if (z && iOptInt == 2) {
                            strBU = jSONObject2.optString("app_log_url");
                        }
                        int i = 0;
                        if ("click".equals(str3)) {
                            WQf.KZx(yfo);
                            float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - yFO.Og(jSONObject.optString("log_extra"))).floatValue();
                            JSONObject jSONObject3 = jSONObject;
                            if (fFloatValue <= 0.0f) {
                                fFloatValue = 0.0f;
                            }
                            jSONObject3.putOpt("show_time", Float.valueOf(fFloatValue));
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.WV.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()))) {
                                if (z && iOptInt == 2) {
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("click_tracking_url");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        ArrayList arrayList = new ArrayList();
                                        while (i < jSONArrayOptJSONArray2.length()) {
                                            arrayList.add(jSONArrayOptJSONArray2.optString(i));
                                            i++;
                                        }
                                        com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.BF.pA.pA(arrayList, true), 2, String.valueOf(j));
                                    }
                                } else {
                                    yFO yfo2 = yfo;
                                    if (yfo2 != null) {
                                        com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.BF.pA.pA(yfo2.cFQ(), true), 2, yfo.nCO());
                                    }
                                }
                            }
                        } else if (m5.v.equals(str3) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.WV.pA(com.bytedance.sdk.openadsdk.core.aBv.pA())) && z && iOptInt == 2 && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("show_tracking_url")) != null) {
                            ArrayList arrayList2 = new ArrayList();
                            while (i < jSONArrayOptJSONArray.length()) {
                                arrayList2.add(jSONArrayOptJSONArray.optString(i));
                                i++;
                            }
                            com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(com.bytedance.sdk.openadsdk.BF.pA.pA(arrayList2, true), 1, String.valueOf(j));
                        }
                    } catch (Exception unused2) {
                    }
                }
                new com.bytedance.sdk.openadsdk.ZZv.pA.C0217pA(jCurrentTimeMillis, yfo).ZZv(str).Og(str2).KZx(str3).ML(String.valueOf(j)).JG(String.valueOf(j2)).pA(strBU).pA(jSONObject).omh(yfo.ZQ()).SD(yfo.Ij()).pA((com.bytedance.sdk.openadsdk.ZZv.Og.pA) null);
            }
        });
    }

    public static void ZZv(yFO yfo, String str, JSONObject jSONObject) {
        if (yfo == null) {
            return;
        }
        pA(yfo, str, -1L, jSONObject);
    }

    public static void pA(yFO yfo, String str, final long j, final JSONObject jSONObject) {
        pA(System.currentTimeMillis(), yfo, "open_ad", str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.41
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    long j2 = j;
                    if (j2 != -1) {
                        jSONObject2.put("duration", j2);
                    }
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    } else {
                        jSONObject2.put("ad_extra_data", new JSONObject().toString());
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", e.getMessage());
                }
                return jSONObject2;
            }
        });
    }

    public static void pA(final com.bytedance.sdk.component.omh.omh omhVar) {
        if (omhVar == null) {
            return;
        }
        if (xy.ML()) {
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.42
                @Override // java.lang.Runnable
                public void run() {
                    xy.Og(omhVar, 10);
                }
            });
        } else if (!xy.JG()) {
            xy.Og(omhVar, 10);
        } else {
            omhVar.run();
        }
    }

    public static void pA(final com.bytedance.sdk.openadsdk.Sn.pA.Og og) {
        if (og == null || og.Og() == null) {
            return;
        }
        final yFO yfoOg = og.Og();
        final int iJBA = yfoOg.JBA();
        if (iJBA == 2 || iJBA == 8 || (gbA.ZZv(yfoOg) && Og.pA.ZZv.equals(og.pA()))) {
            pA(System.currentTimeMillis(), yfoOg, og.KZx(), "open_browser", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.43
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int iZZv = og.ZZv();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("count", gbA.Sn(com.bytedance.sdk.openadsdk.core.aBv.pA()));
                        jSONObject2.put("interceptor", iZZv);
                        jSONObject2.put("success", og.ML());
                        jSONObject2.put("link", og.pA());
                        jSONObject2.put("interaction_type", iJBA);
                        jSONObject2.put("real_interaction_type", og.SD());
                        if (og.ZZv() == 9) {
                            jSONObject2.put("is_act_signals_api_available", og.omh());
                            jSONObject2.put("is_act_signals_callback", og.Bzk());
                        }
                        if (!TextUtils.isEmpty(og.JG())) {
                            jSONObject2.put("exception_msg", og.JG());
                        }
                        if (iZZv == 2 || iZZv == 5) {
                            jSONObject2.put(Constants.REFERRER_API_META, yfoOg.jO().toString());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", e.getMessage());
                    }
                    return jSONObject;
                }
            });
        }
    }

    public static void ML(yFO yfo, String str, JSONObject jSONObject) {
        ZZv(yfo, "activity_recreate", str, jSONObject);
    }

    public static class pA {
        public static void pA(String str, final JSONObject jSONObject, yFO yfo) {
            String strPA = gbA.pA(yfo);
            if (strPA == null) {
                return;
            }
            KZx.pA(System.currentTimeMillis(), yfo, strPA + "_landingpage", str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.pA.1
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.loadEvent error", th);
                    }
                    return jSONObject2;
                }
            });
        }

        public static void pA(final int i, final int i2, yFO yfo) {
            String strPA = gbA.pA(yfo);
            if (strPA == null) {
                return;
            }
            KZx.pA(System.currentTimeMillis(), yfo, strPA + "_landingpage", "local_res_hit_rate", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.pA.2
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("all_times", i2);
                        jSONObject2.put("hit_times", i);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                    }
                    return jSONObject;
                }
            });
        }

        public static void pA(final long j, final yFO yfo, String str, final ILoader iLoader, final String str2) {
            if (str == null) {
                return;
            }
            KZx.pA(System.currentTimeMillis(), yfo, str, "landingpage_init", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.pA.3
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int iPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(iLoader, str2);
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(yFO.KZx, yfo.fN() ? 1 : 0);
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                        jSONObject2.put("url", yfo.dC());
                        jSONObject2.put("channel_name", yfo.Gag());
                        jSONObject2.put("interceptor_status", (TextUtils.isEmpty(yfo.Gag()) || iPA <= 0) ? 0 : 1);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("resource_count", iPA);
                        jSONObject2.put("resource_info", jSONObject4);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("duration", j);
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                    }
                    return jSONObject;
                }
            });
        }

        public static void pA(final int i, final int i2, final int i3, final int i4, final yFO yfo, String str, final int i5) {
            if (str == null || TextUtils.isEmpty(yfo.Gag())) {
                return;
            }
            KZx.pA(System.currentTimeMillis(), yfo, str, "landing_page_resource_detail", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.pA.4
                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                public JSONObject pA() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("next_url", yfo.dC());
                        jSONObject2.put("channel_name", yfo.Gag());
                        jSONObject2.put("preload_status", i <= 0 ? 0 : 2);
                        jSONObject2.put("first_page", i5);
                        jSONObject2.put("preload_h5_type", yfo.Bi());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("channel_response", i);
                        jSONObject3.put("failResourceCount", i2);
                        jSONObject3.put("successCount", i3);
                        jSONObject3.put("failCount", i4);
                        jSONObject2.put("resource_info", jSONObject3);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                    }
                    return jSONObject;
                }
            });
        }
    }

    public static void pA(yFO yfo, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        Og(yfo, str, "open_ad_land_page_links", jSONObject);
    }

    public static void Og(yFO yfo, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        Og(yfo, str, "download_app_ad_track", jSONObject);
    }

    public static void pA(yFO yfo, String str, final boolean z, final boolean z2, final boolean z3, final boolean z4, final int i, final Map<String, Object> map) {
        pA(System.currentTimeMillis(), yfo, str, "start_show_plb", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.45
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isSkip", z);
                    jSONObject2.put("force", z2);
                    jSONObject2.put("isFromLandingPage", z3);
                    jSONObject2.put("finishing", z4);
                    jSONObject2.put(TypedValues.TransitionType.S_FROM, i);
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void pA(final yFO yfo, final boolean z, String str, final String str2, final long j, final String str3, final String str4, final int i, final String str5) {
        pA(System.currentTimeMillis(), yfo, str, "load_ugen_template", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.KZx.46
            /* JADX WARN: Code duplicated, block: B:19:0x0043  */
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                byte b;
                eG eGVarFQ;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String str6 = str4;
                    int iHashCode = str6.hashCode();
                    if (iHashCode != -1606803861) {
                        if (iHashCode != 3107) {
                            if (iHashCode == 2989536 && str6.equals("adv3")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str6.equals(Reporting.Key.CLICK_SOURCE_TYPE_AD)) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (str6.equals(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD)) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b != 0) {
                        if (b == 1) {
                            yFO.pA pAVarCIG = yfo.CIG();
                            if (pAVarCIG != null) {
                                jSONObject2.putOpt("url", pAVarCIG.DX());
                                jSONObject2.putOpt("id", pAVarCIG.JG());
                                jSONObject2.putOpt("md5", pAVarCIG.oX());
                            }
                        } else if (b == 2 && (eGVarFQ = yfo.FQ()) != null) {
                            jSONObject2.putOpt("url", eGVarFQ.KZx());
                            jSONObject2.putOpt("id", eGVarFQ.pA());
                            jSONObject2.putOpt("md5", eGVarFQ.Og());
                        }
                    } else if (z) {
                        com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVarZDE = yfo.ZDE();
                        if (pAVarZDE != null) {
                            jSONObject2.putOpt("url", pAVarZDE.KZx());
                            jSONObject2.putOpt("id", pAVarZDE.pA());
                            jSONObject2.putOpt("md5", pAVarZDE.Og());
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVarMx = yfo.Mx();
                        if (pAVarMx != null) {
                            jSONObject2.putOpt("url", pAVarMx.KZx());
                            jSONObject2.putOpt("id", pAVarMx.pA());
                            jSONObject2.putOpt("md5", pAVarMx.Og());
                        }
                    }
                    jSONObject2.put("ugen_status", str2);
                    jSONObject2.put(TypedValues.TransitionType.S_FROM, str3);
                    jSONObject2.put("ugen_scene", str4);
                    if (b9.f.e.equals(str2)) {
                        jSONObject2.put("error_code", i);
                        jSONObject2.put("error_msg", str5);
                    }
                    jSONObject.put("duration", j);
                } catch (Throwable th) {
                    try {
                        jSONObject2.put("error_code", Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE);
                        jSONObject2.put("error_msg", "send template error " + th.getMessage());
                    } catch (Throwable unused) {
                    }
                }
                try {
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused2) {
                }
                return jSONObject;
            }
        });
    }

    private static boolean pA(int i, String str) {
        int iMc;
        try {
            Set<String> setDGZ = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().dGZ();
            if ((i == 1 && setDGZ != null && setDGZ.contains(str)) || (iMc = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Mc(str)) == 0) {
                return true;
            }
            return iMc != 100 && ((int) ((Math.random() * 100.0d) + 1.0d)) > iMc;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.AdEvent", th.getMessage());
            return false;
        }
    }
}
