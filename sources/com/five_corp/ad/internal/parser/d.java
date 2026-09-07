package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.ad.beacon.j;
import com.five_corp.ad.internal.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class d {
    public static com.five_corp.ad.internal.ad.beacon.a a(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.a {
        int i = jSONObject.getInt("clkt");
        int i2 = 0;
        for (int i3 : com.five_corp.ad.e.b(2)) {
            if (com.five_corp.ad.internal.ad.beacon.c.a(i3) == i) {
                int i4 = jSONObject.getInt("str");
                for (int i5 : com.five_corp.ad.e.b(3)) {
                    if (com.five_corp.ad.internal.ad.beacon.h.a(i5) == i4) {
                        long j = jSONObject.getLong("tms");
                        j jVar = j.d;
                        int i6 = jVar.f1273a;
                        if (jSONObject.has("vct")) {
                            int i7 = jSONObject.getInt("vct");
                            int[] iArrB = com.five_corp.ad.e.b(2);
                            int length = iArrB.length;
                            while (true) {
                                if (i2 >= length) {
                                    throw new com.five_corp.ad.internal.exception.a(p.D1, i7);
                                }
                                int i8 = iArrB[i2];
                                if (com.five_corp.ad.internal.ad.beacon.i.a(i8) == i7) {
                                    i6 = i8;
                                    break;
                                }
                                i2++;
                            }
                        }
                        double d = jVar.b;
                        if (jSONObject.has("ar")) {
                            d = jSONObject.getDouble("ar");
                        }
                        return new com.five_corp.ad.internal.ad.beacon.a(i3, i5, j, new j(i6, d));
                    }
                }
                throw new com.five_corp.ad.internal.exception.a(p.a1, i4);
            }
        }
        throw new com.five_corp.ad.internal.exception.a(p.p1, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    public static com.five_corp.ad.internal.ad.beacon.f b(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.a {
        int i = jSONObject.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
        for (int i2 : com.five_corp.ad.e.b(21)) {
            if (com.five_corp.ad.internal.ad.beacon.b.a(i2) == i) {
                com.five_corp.ad.internal.ad.beacon.a aVarA = jSONObject.has(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) ? a(jSONObject.getJSONObject(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM)) : null;
                ?? EmptyList = Collections.emptyList();
                if (jSONObject.has("p")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("p");
                    EmptyList = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        EmptyList.add(new com.five_corp.ad.internal.ad.beacon.g(jSONObject2.getString(CampaignEx.JSON_KEY_AD_K), jSONObject2.getString("v")));
                    }
                }
                return new com.five_corp.ad.internal.ad.beacon.f(i2, aVarA, EmptyList);
            }
        }
        throw new com.five_corp.ad.internal.exception.a(p.l1, i);
    }
}
