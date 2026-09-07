package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class JG extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private final WeakReference<IG> pA;

    public static void pA(aBv abv, IG ig) {
        abv.pA("interactiveFinish", new JG(ig));
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<IG> weakReference = this.pA;
        if (weakReference != null && weakReference.get() != null) {
            IG ig = this.pA.get();
            yFO yfoKZx = ig.KZx();
            try {
                boolean z = true;
                int i = 0;
                if (jSONObject.optInt("finish", 1) != 1) {
                    z = false;
                }
                int iOptInt = jSONObject.optInt("reduce_duration", -1);
                int iVkV = yfoKZx != null ? yfoKZx.vkV() : 0;
                if (iOptInt >= 0 && iVkV >= 0) {
                    iOptInt = Math.min(iOptInt, iVkV);
                } else if (iOptInt < 0) {
                    iOptInt = iVkV >= 0 ? iVkV : 0;
                }
                if (z) {
                    ig.KZx(iOptInt);
                } else {
                    i = -1;
                }
                jSONObject2.put("code", i);
                jSONObject2.put("reduce_duration", iOptInt);
            } catch (JSONException e) {
                WV.pA("InteractiveFinishMethod", e.getMessage());
            }
        }
        return jSONObject2;
    }

    public JG(IG ig) {
        this.pA = new WeakReference<>(ig);
    }
}
