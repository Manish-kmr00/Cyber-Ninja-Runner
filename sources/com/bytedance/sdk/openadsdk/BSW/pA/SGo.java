package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class SGo extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.component.Bzk.ZZv> pA;

    public static void pA(aBv abv, com.bytedance.sdk.component.Bzk.ZZv zZv) {
        abv.pA("preventTouchEvent", new SGo(zZv));
    }

    public SGo(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        this.pA = new WeakReference<>(zZv);
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA.get();
            if (zZv != null) {
                zZv.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
