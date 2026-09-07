package com.bytedance.sdk.openadsdk.core.omh;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class BSW {
    public static void pA(String str, int i, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.core.omh.pA(i);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_source", str);
            com.bytedance.sdk.openadsdk.core.model.yFO.pA pAVarCIG = yfo.CIG();
            if (pAVarCIG != null) {
                jSONObject.put("tpl_id", pAVarCIG.JG());
                if ("Web".equals(str)) {
                    if (pAVarCIG.Sn()) {
                        jSONObject.put("engine_version", "v3");
                    } else {
                        jSONObject.put("engine_version", "v1");
                    }
                }
            } else if (yfo.FQ() != null) {
                jSONObject.put("tpl_id", yfo.FQ().pA());
                if ("Web".equals(str)) {
                    jSONObject.put("engine_version", "v3");
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA(pA(str3)).KZx(str4).ML(yfo != null ? yfo.Ij() : "").Og(i).Og(jSONObject.toString()).JG(str2));
    }

    private static int pA(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }
}
