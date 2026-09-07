package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class g {
    public static com.five_corp.ad.internal.ad.fullscreen.a a(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.a {
        com.five_corp.ad.internal.ad.fullscreen.e eVar;
        int i = jSONObject.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
        for (int i2 : com.five_corp.ad.e.b(2)) {
            int i3 = 1;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw null;
                }
                i3 = 2;
            }
            if (i3 == i) {
                if (jSONObject.has("tx")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("tx");
                    eVar = new com.five_corp.ad.internal.ad.fullscreen.e(jSONObject2.getString("bg"), jSONObject2.getString(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP), jSONObject2.getString("tc"));
                } else {
                    eVar = null;
                }
                return new com.five_corp.ad.internal.ad.fullscreen.a(i2, eVar, jSONObject.has("iu") ? i.a(jSONObject.getJSONObject("iu")) : null);
            }
        }
        throw new com.five_corp.ad.internal.exception.a(p.S0, i);
    }
}
