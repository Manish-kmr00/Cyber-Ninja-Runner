package com.bytedance.sdk.openadsdk.core.settings;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class SGo extends DX {
    public SGo() {
        super("tt_set_mediation.prop", null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ML
    public void pA(JSONObject jSONObject) {
        if (jSONObject.has("mediation_init_conf")) {
            ML.pA pAVarPA = pA();
            pAVarPA.pA("mediation_init_conf", jSONObject.optString("mediation_init_conf"));
            pAVarPA.pA();
            ZZv();
        }
    }
}
