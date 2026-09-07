package com.bytedance.sdk.openadsdk.core.WV;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og extends KZx {
    private long BSW;
    private long SGo;

    public Og(int i, int i2, long j, long j2, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og og, String str, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list2, String str2) {
        super(i, i2, enumC0233pA, og, str, list, list2, str2);
        this.SGo = j;
        this.BSW = j2;
        this.Bzk = "icon_click";
    }

    @Override // com.bytedance.sdk.openadsdk.core.WV.KZx
    public JSONObject pA() throws JSONException {
        JSONObject jSONObjectPA = super.pA();
        if (jSONObjectPA != null) {
            jSONObjectPA.put("offset", this.SGo);
            jSONObjectPA.put("duration", this.BSW);
        }
        return jSONObjectPA;
    }

    public static Og pA(JSONObject jSONObject) {
        KZx kZxOg = KZx.Og(jSONObject);
        if (kZxOg == null) {
            return null;
        }
        return new Og(kZxOg.pA, kZxOg.Og, jSONObject.optLong("offset", -1L), jSONObject.optLong("duration", -1L), kZxOg.KZx, kZxOg.ZZv, kZxOg.ML, kZxOg.JG, kZxOg.SD, kZxOg.omh);
    }
}
