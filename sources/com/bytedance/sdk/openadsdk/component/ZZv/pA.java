package com.bytedance.sdk.openadsdk.component.ZZv;

import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.Sn.KZx;
import com.bytedance.sdk.openadsdk.Sn.Og;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.model.du;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.json.m5;
import io.ktor.http.ContentDisposition;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class pA {
    public static void pA(final int i, final int i2) {
        KZx.pA("openad_load_ad_timeout", false, new Og() { // from class: com.bytedance.sdk.openadsdk.component.ZZv.pA.1
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout_type", i);
                jSONObject.put("user_timeout_time", i2);
                return ZZv.Og().pA("openad_load_ad_timeout").Og(jSONObject.toString());
            }
        });
    }

    public static void pA(yFO yfo, int i, int i2, float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            pA(jSONObject, yfo);
            jSONObject.put("openad_creative_type", yFO.ML(yfo) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("skip_time", i);
            jSONObject.put("skip_show_time", i2);
            jSONObject.put("total_time", f);
        } catch (JSONException e) {
            WV.pA("TTAppOpenAdReport", "reportSkip json error", e);
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, EventConstants.SKIP, i, jSONObject);
    }

    public static void pA(yFO yfo, long j, float f, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            pA(jSONObject, yfo);
            jSONObject.put("openad_creative_type", yFO.ML(yfo) ? "video_normal_ad" : "image_normal_ad");
            if (z) {
                double d = f;
                jSONObject.put("video_duration", d);
                jSONObject.put("video_percent", (int) (((j * 1.0d) / 10.0d) / d));
            } else {
                jSONObject.put("image_duration", f);
            }
        } catch (JSONException e) {
            WV.pA("TTAppOpenAdReport", "reportDestroy json error", e);
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.ZZv(yfo, "destroy", jSONObject);
    }

    public static void pA(yFO yfo) {
        com.bytedance.sdk.openadsdk.ZZv.KZx.ZZv(yfo, "cache_expire", (JSONObject) null);
    }

    public static void Og(yFO yfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", yFO.ML(yfo) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException e) {
            WV.pA("TTAppOpenAdReport", "reportCacheLoss json error", e);
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.ZZv(yfo, "cache_loss", jSONObject);
    }

    public static void pA(yFO yfo, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(m5.u, z ? 1 : 2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, "download_image_duration", j, jSONObject);
    }

    public static void Og(yFO yfo, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentDisposition.Parameters.Size, yfo.Bf().ML());
            jSONObject.put("video_duration", yfo.Bf().JG());
            jSONObject.put(m5.u, z ? 1 : 2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, "download_video_duration", j, jSONObject);
    }

    public static void pA(yFO yfo, int i, du duVar) {
        JSONObject jSONObject = new JSONObject();
        long jJG = 0;
        try {
            jSONObject.put("openad_creative_type", yFO.ML(yfo) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("open_ad_cache_type", i);
            if (duVar != null) {
                duVar.Og(qmB.Og());
                pA(jSONObject, yfo);
                jSONObject.put("client_start_time", duVar.Og());
                jSONObject.put("sever_time", duVar.ZZv());
                jSONObject.put("network_time", duVar.KZx());
                jSONObject.put("client_end_time", duVar.ML());
                jSONObject.put("download_resource_duration", duVar.SD());
                jSONObject.put("resource_source", duVar.omh());
                jSONObject.put("is_bidding", duVar.pA ? 1 : 0);
                if (duVar.pA) {
                    jSONObject.put("load_wait_time", duVar.Og);
                }
                jJG = duVar.JG();
            }
        } catch (JSONException e) {
            WV.pA("TTAppOpenAdReport", "reportLoadNetDuration json error", e);
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, "load_net_duration", jJG, jSONObject);
    }

    public static void pA(yFO yfo, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            pA(jSONObject, yfo);
            jSONObject.put("openad_creative_type", yFO.ML(yfo) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException unused) {
            WV.pA("TTAppOpenAdReport", "reportLoadCacheDuration json error");
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, "load_cache_duration", j, jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    private static void pA(JSONObject jSONObject, yFO yfo) {
        int i;
        if (yfo != null) {
            try {
                if (yfo.zi()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } catch (JSONException e) {
                WV.pA("TTAppOpenAdReport", e.getMessage());
                return;
            }
        } else {
            i = 0;
        }
        jSONObject.put("is_icon_only", i);
    }
}
