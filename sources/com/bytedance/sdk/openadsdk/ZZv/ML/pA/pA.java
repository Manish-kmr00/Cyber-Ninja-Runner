package com.bytedance.sdk.openadsdk.ZZv.ML.pA;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.pA.KZx.KZx;
import com.bykv.vk.openvk.pA.pA.pA.KZx.Og;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.Bzk;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.JG;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.ML;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.SGo;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.Sn;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.Wx;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.ZZv;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.omh;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    private static final Map<com.bykv.vk.openvk.pA.pA.pA.Og.pA, DX> pA = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject pA(yFO yfo, String str, int i, KZx kZx) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (yfo != null) {
                Og ogBf = yfo.Bf();
                if (ogBf != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, ogBf.Bzk());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(ogBf.ML()));
                    jSONObject.put("video_url", ogBf.BSW());
                    jSONObject.put("player_type", kZx.DX());
                    jSONObject.put("video_encode_type", kZx.BSW() ? 1 : 0);
                }
                jSONObject.put("dp_creative_type", yfo.Lf());
            }
        } catch (JSONException e) {
            WV.pA("TTAD.VideoEventManager", "", e);
        }
        return jSONObject;
    }

    public static void pA(com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA<SGo> pAVar) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("load_video_error", pAVar);
    }

    public static void Og(com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA<Bzk> pAVar) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("load_video_cancel", pAVar);
    }

    public static void pA(yFO yfo, com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, KZx kZx) {
        if (yfo == null || pAVar == null || kZx == null) {
            return;
        }
        String strPA = WQf.pA();
        int i = CacheDirFactory.getICacheDir(yfo.FK()).pA(kZx) ? 1 : 2;
        pA.put(pAVar, new DX(SystemClock.elapsedRealtime(), strPA, i, kZx, yfo));
        JSONObject jSONObjectPA = pA(yfo, strPA, i, kZx);
        String strPA2 = gbA.pA(yfo);
        try {
            if (kZx.ZZv > 0) {
                jSONObjectPA.put("play_time", kZx.ZZv);
            }
            jSONObjectPA.put("is_mute", kZx.omh() ? 1 : 0);
        } catch (JSONException e) {
            WV.pA("TTAD.VideoEventManager", "", e);
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfo, strPA2, jSONObjectPA, null);
        pAVar2.pA(kZx.DX() == -1);
        pA(pAVar2, "play_start");
    }

    public static void pA(Context context, com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2, SD sd) {
        DX dx;
        if (context == null || pAVar == null || pAVar2 == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        if (!pAVar2.SGo()) {
            pA(yfoML, kZxZZv, pAVar2);
        }
        omh omhVar = new omh();
        omhVar.pA(pAVar2.BSW() ? 1 : 0);
        omhVar.Og(CacheDirFactory.getICacheDir(yfoML.FK()).Og(kZxZZv));
        omhVar.pA(SystemClock.elapsedRealtime() - dx.pA());
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, omhVar);
        pAVar3.pA(pAVar2.SGo());
        pA(pAVar3, "feed_play", sd);
    }

    public static void pA(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2) {
        DX dx;
        if (pAVar == null || pAVar2 == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jPA = pAVar2.pA();
        long jKZx = pAVar2.KZx();
        if (jKZx <= 0 || jPA <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.SD sd = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.SD();
        sd.pA(pAVar2.Og());
        sd.Og(jKZx);
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, sd);
        pAVar3.pA(pAVar2.SGo());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jPA);
            jSONObject.put("percent", pAVar2.JG());
            pA(pAVar3, "feed_pause", jSONObject);
        } catch (JSONException e2) {
            WV.pA("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void Og(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2) {
        DX dx;
        if (pAVar == null || pAVar2 == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jPA = pAVar2.pA();
        long jKZx = pAVar2.KZx();
        if (jKZx <= 0 || jPA <= 0) {
            return;
        }
        ML ml = new ML();
        ml.pA(pAVar2.Og());
        ml.Og(jKZx);
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, ml);
        pAVar3.pA(pAVar2.SGo());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jPA);
            jSONObject.put("percent", pAVar2.JG());
            pA(pAVar3, "feed_continue", jSONObject);
        } catch (JSONException e2) {
            WV.pA("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void KZx(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2) {
        DX dx;
        if (pAVar == null || pAVar2 == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jPA = pAVar2.pA();
        long jKZx = pAVar2.KZx();
        Sn sn = new Sn(pAVar2.WV());
        sn.pA(pAVar2.Og());
        sn.Og(jKZx);
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, sn);
        pAVar3.pA(pAVar2.SGo());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jPA);
            jSONObject.put("percent", pAVar2.JG());
            pA(pAVar3, "play_error", jSONObject);
        } catch (JSONException e2) {
            WV.pA("TTAD.VideoEventManager", "", e2);
        }
        pA.remove(pAVar);
    }

    public static void ZZv(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2) {
        DX dx;
        if (pAVar == null || pAVar2 == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jPA = pAVar2.pA();
        long jKZx = pAVar2.KZx();
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.Og og = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.Og();
        og.pA(pAVar2.Og());
        og.Og(jKZx);
        og.pA(pAVar2.ZZv());
        og.Og(pAVar2.ML());
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), pA(yfoML, dx.Og(), dx.KZx(), kZxZZv), og);
        pAVar3.pA(pAVar2.SGo());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jPA);
            jSONObject.put("percent", pAVar2.JG());
            pA(pAVar3, "endcard_skip", jSONObject);
        } catch (JSONException e) {
            WV.pA("TTAD.VideoEventManager", "", e);
        }
    }

    public static void pA(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2, SD sd) {
        DX dx;
        if (pAVar == null || pAVar2 == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jPA = pAVar2.pA();
        long jKZx = pAVar2.KZx();
        ZZv zZv = new ZZv();
        zZv.Og(pAVar2.Og());
        zZv.pA(jKZx);
        zZv.pA(pAVar2.SD());
        zZv.Og(pAVar2.omh());
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, zZv);
        pAVar3.pA(pAVar2.SGo());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jPA);
            jSONObject.put("percent", pAVar2.JG());
            pA(pAVar3, "feed_break", jSONObject, sd);
        } catch (JSONException e2) {
            WV.pA("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void Og(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2, SD sd) {
        if (pAVar == null || pAVar2 == null) {
            return;
        }
        ML(pAVar, pAVar2);
        DX dx = pA.get(pAVar);
        if (dx == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jPA = pAVar2.pA();
        long jKZx = pAVar2.KZx();
        JG jg = new JG();
        jg.Og(pAVar2.Og());
        jg.pA(jKZx);
        jg.pA(pAVar2.omh());
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, jg);
        pAVar3.pA(pAVar2.SGo());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jPA);
            jSONObject.put("percent", pAVar2.JG());
            pA(pAVar3, "feed_over", jSONObject, sd);
        } catch (JSONException e2) {
            WV.pA("TTAD.VideoEventManager", "", e2);
        }
        pA.remove(pAVar);
    }

    public static void pA(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, boolean z) {
        DX dx;
        if (pAVar == null || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        try {
            if (kZxZZv.ZZv > 0) {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            }
            jSONObjectPA.put("is_mute", z ? 1 : 0);
        } catch (JSONException e) {
            WV.pA("TTAD.VideoEventManager", "", e);
        }
        pA(new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, null), "mute_state_change");
    }

    public static void ML(com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, DX.pA pAVar2) {
        DX dx;
        if (pAVar == null || pAVar2 == null || pAVar2.Bzk() <= 0 || (dx = pA.get(pAVar)) == null) {
            return;
        }
        KZx kZxZZv = dx.ZZv();
        yFO yfoML = dx.ML();
        if (kZxZZv == null || yfoML == null) {
            return;
        }
        long jKZx = pAVar2.KZx();
        Wx wx = new Wx();
        wx.pA(pAVar2.Og());
        wx.Og(jKZx);
        wx.pA(pAVar2.Bzk());
        JSONObject jSONObjectPA = pA(yfoML, dx.Og(), dx.KZx(), kZxZZv);
        if (kZxZZv.ZZv > 0) {
            try {
                jSONObjectPA.put("play_time", kZxZZv.ZZv);
            } catch (JSONException e) {
                WV.pA("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA(yfoML, gbA.pA(yfoML), jSONObjectPA, wx);
        pAVar3.pA(pAVar2.SGo());
        pA(pAVar3, "play_buffer");
    }

    private static void pA(com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar, String str) {
        pA(pAVar, str, (JSONObject) null, (SD) null);
    }

    private static void pA(com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar, String str, JSONObject jSONObject) {
        pA(pAVar, str, jSONObject, (SD) null);
    }

    private static void pA(com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar, String str, SD sd) {
        pA(pAVar, str, (JSONObject) null, sd);
    }

    private static void pA(final com.bytedance.sdk.openadsdk.ZZv.ML.Og.pA pAVar, String str, final JSONObject jSONObject, final SD sd) {
        if (pAVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (pAVar.ML() && !TextUtils.isEmpty(pAVar.Og())) {
            String strOg = pAVar.Og();
            strOg.hashCode();
            if (strOg.equals("stream") || strOg.equals("embeded_ad")) {
                str = "customer_".concat(String.valueOf(str));
            }
        }
        final String str2 = str;
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), pAVar.pA(), pAVar.Og(), str2, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.1
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                SD sd2;
                try {
                    JSONObject jSONObjectKZx = pAVar.KZx();
                    if (pAVar.ZZv() != null) {
                        pAVar.ZZv().pA(jSONObjectKZx);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (sd2 = sd) != null) {
                        sd2.pA(jSONObjectKZx);
                    }
                    jSONObject.put("ad_extra_data", jSONObjectKZx.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    private static void pA(final yFO yfo, final KZx kZx, final DX.pA pAVar) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA();
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("pangle_video_play_state", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", pA.KZx(kZx));
                jSONObject.put("player_duration", pAVar.KZx());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", kZx.Wx());
                jSONObject.put("path", pA.ZZv(kZx));
                jSONObject.put("player_type", kZx.DX());
                com.bytedance.sdk.openadsdk.Sn.pA.ZZv zZvPA = com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("pangle_video_play_state");
                yFO yfo2 = yfo;
                return zZvPA.pA(yfo2 != null ? yfo2.PKZ() : 0).Og(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long KZx(KZx kZx) {
        if (kZx == null) {
            return 0L;
        }
        Og ogSd = kZx.BSW() ? kZx.Sd() : kZx.vZF();
        if (ogSd != null) {
            return Double.valueOf(ogSd.JG() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ZZv(KZx kZx) {
        return new File(kZx.Og(), kZx.Sn()).getAbsolutePath();
    }
}
