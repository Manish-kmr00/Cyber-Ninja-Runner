package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.ad.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class i {
    public static s a(JSONObject jSONObject) {
        return new s(jSONObject.getString(ApsMetricsDataMap.APSMETRICS_FIELD_URL), jSONObject.has("i") ? jSONObject.getString("i") : null, jSONObject.has("rw") ? jSONObject.getInt("rw") : 0, jSONObject.has("rh") ? jSONObject.getInt("rh") : 0);
    }
}
