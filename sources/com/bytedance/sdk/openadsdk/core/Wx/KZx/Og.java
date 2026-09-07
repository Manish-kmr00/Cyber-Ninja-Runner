package com.bytedance.sdk.openadsdk.core.Wx.KZx;

import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Og {
    public static void pA(yFO yfo) {
        if (WQf.Og(yfo)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, "playable_preload", "preload_start", (JSONObject) null);
        }
    }

    public static void pA(yFO yfo, long j, long j2) {
        if (yfo != null) {
            if (WQf.KZx(yfo) || WQf.Og(yfo)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loadzip_success_time", j);
                    jSONObject.put("unzip_success_time", j2);
                } catch (JSONException e) {
                    WV.pA("PlayableEvent", "onSuccess json error", e);
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, "playable_preload", "preload_success", jSONObject);
            }
        }
    }

    public static void pA(yFO yfo, int i, String str) {
        if (yfo != null) {
            if (WQf.KZx(yfo) || WQf.Og(yfo)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", i);
                    jSONObject.put("error_reason", str);
                } catch (JSONException e) {
                    WV.pA("PlayableEvent", "onFail json error", e);
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, "playable_preload", "preload_fail", jSONObject);
            }
        }
    }
}
