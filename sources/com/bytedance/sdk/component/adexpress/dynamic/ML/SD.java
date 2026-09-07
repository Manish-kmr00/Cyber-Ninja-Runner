package com.bytedance.sdk.component.adexpress.dynamic.ML;

import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SD implements omh {
    private com.bytedance.sdk.component.adexpress.dynamic.JG.Og pA;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ML.omh
    public void pA(com.bytedance.sdk.component.adexpress.dynamic.JG.Og og) {
        this.pA = og;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ML.omh
    public void pA(final Wx wx) {
        if (wx.WV() == 1) {
            Og(wx);
        } else {
            com.bytedance.sdk.component.adexpress.ZZv.ZZv.pA(new com.bytedance.sdk.component.omh.omh("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.ML.SD.1
                @Override // java.lang.Runnable
                public void run() {
                    SD.this.Og(wx);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(Wx wx) {
        try {
            JSONObject jSONObjectKZx = wx.KZx();
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(jSONObjectKZx.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectKZx.optJSONObject(Reporting.Key.CREATIVE);
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVarPA = new JG(jSONObjectJsonObjectInit, jSONObjectOptJSONObject, jSONObjectKZx.optJSONObject("AdSize"), PangleNetworkBridge.jsonObjectInit(jSONObjectKZx.optString("diff_template_Plugin"))).pA(wx.Og(), wx.SGo(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), wx);
            try {
                JSONObject jSONObjectJsonObjectInit2 = PangleNetworkBridge.jsonObjectInit(jSONObjectOptJSONObject.optString("dynamic_creative"));
                omhVarPA.pA(jSONObjectJsonObjectInit2.optString("color"));
                omhVarPA.pA(jSONObjectJsonObjectInit2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.pA.pA(omhVarPA);
        } catch (Exception unused2) {
        }
    }
}
