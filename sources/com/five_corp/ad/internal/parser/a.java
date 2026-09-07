package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.p;
import com.safedk.android.analytics.brandsafety.l;
import java.util.ArrayList;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {
    public static com.five_corp.ad.internal.ad_check.a a(String str) throws JSONException, com.five_corp.ad.internal.exception.a {
        int i;
        String str2;
        JSONObject jSONObject = new JSONObject(str);
        int i2 = jSONObject.getInt(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
        int[] iArrB = com.five_corp.ad.e.b(3);
        int length = iArrB.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArrB[i3];
            if (i4 == 1) {
                i = 3;
            } else if (i4 == 2) {
                i = 4;
            } else {
                if (i4 != 3) {
                    throw null;
                }
                i = 5;
            }
            if (i == i2) {
                int iA = com.five_corp.ad.e.a(i4);
                if (iA == 0) {
                    return new com.five_corp.ad.internal.ad_check.a(1, null);
                }
                if (iA == 1) {
                    return new com.five_corp.ad.internal.ad_check.a(2, null);
                }
                if (iA == 2) {
                    JSONArray jSONArray = jSONObject.getJSONArray(l.r);
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        arrayList.add(new com.five_corp.ad.internal.ad_check.e(b.a(jSONArray.getJSONObject(i5).getJSONObject(Reporting.Key.CLICK_SOURCE_TYPE_AD))));
                    }
                    return new com.five_corp.ad.internal.ad_check.a(3, arrayList);
                }
                if (i4 == 1) {
                    str2 = "NOT_SHOW";
                } else if (i4 != 2) {
                    str2 = i4 != 3 ? "null" : "SHOW_ONE_OF_AD";
                } else {
                    str2 = "SUPPRESSED";
                }
                throw new RuntimeException("Unexpected AdCheckResponseType enum: ".concat(str2));
            }
        }
        throw new com.five_corp.ad.internal.exception.a(p.k1, i2);
    }
}
