package com.bytedance.sdk.openadsdk.core.settings;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class pA extends DX {
    public pA() {
        super("tt_set_apm.prop", new DX.pA() { // from class: com.bytedance.sdk.openadsdk.core.settings.pA.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.DX.pA
            public void Og() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.DX.pA
            public void pA() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ML
    public void pA(JSONObject jSONObject) {
        ML.pA pAVarPA = pA();
        if (jSONObject.has("apm_url")) {
            pAVarPA.pA("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("perf_con");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("perf_con_apm")) {
                    pAVarPA.pA("perf_con_apm", jSONObjectOptJSONObject.optInt("perf_con_apm"));
                }
            } catch (Exception unused) {
            }
        }
        pAVarPA.pA();
        ZZv();
    }
}
