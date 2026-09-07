package com.bytedance.sdk.openadsdk.ZZv.Og;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class KZx implements Og {
    Og pA;

    @Override // com.bytedance.sdk.openadsdk.ZZv.Og.Og
    public void pA(JSONObject jSONObject, long j) throws JSONException {
        Og og = this.pA;
        if (og != null) {
            og.pA(jSONObject, j);
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        jSONObject.put("event_ts", j);
    }
}
