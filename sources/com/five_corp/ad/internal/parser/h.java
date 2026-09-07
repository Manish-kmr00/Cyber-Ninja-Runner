package com.five_corp.ad.internal.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.five_corp.ad.internal.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class h {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List] */
    public static com.five_corp.ad.internal.media_config.a a(JSONObject jSONObject) throws JSONException, com.five_corp.ad.internal.exception.a {
        ?? arrayList;
        int i;
        String string = jSONObject.toString();
        JSONArray jSONArray = jSONObject.getJSONArray(ApsMetricsDataMap.APSMETRICS_FIELD_SCREENSIZE);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String string2 = jSONObject2.getString("i");
            boolean zOptBoolean = jSONObject2.optBoolean("chk", true);
            boolean zOptBoolean2 = jSONObject2.optBoolean("alna", false);
            int iOptInt = jSONObject2.optInt("dss", 0);
            int[] iArrB = com.five_corp.ad.e.b(4);
            int length = iArrB.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    throw new com.five_corp.ad.internal.exception.a(p.C0, iOptInt);
                }
                i = iArrB[i3];
                if (com.five_corp.ad.e.a(i) == iOptInt) {
                    break;
                }
                i3++;
            }
            arrayList2.add(new com.five_corp.ad.internal.media_config.c(string2, zOptBoolean, zOptBoolean2, i, jSONObject2.optDouble("adcv", 0.01d), jSONObject2.optBoolean("afov", false)));
        }
        boolean z = jSONObject.getBoolean("sn");
        if (jSONObject.has("rmcl")) {
            jSONObject.getBoolean("rmcl");
        }
        int i4 = jSONObject.has("pcdb") ? jSONObject.getInt("pcdb") : 250000;
        long j = jSONObject.has("arnims") ? jSONObject.getLong("arnims") : 1800000L;
        boolean z2 = jSONObject.has("dovd") ? jSONObject.getBoolean("dovd") : false;
        boolean z3 = jSONObject.has("rdy") ? jSONObject.getBoolean("rdy") : false;
        List listEmptyList = Collections.emptyList();
        if (jSONObject.has("nsdcs")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("nsdcs");
            arrayList = new ArrayList();
            for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                arrayList.add(Integer.valueOf(jSONArray2.getInt(i5)));
            }
        } else {
            arrayList = listEmptyList;
        }
        com.five_corp.ad.internal.media_config.b bVar = new com.five_corp.ad.internal.media_config.b();
        if (jSONObject.has("sdms")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("sdms");
            bVar = new com.five_corp.ad.internal.media_config.b(jSONObject3.has("adchk") ? jSONObject3.getString("adchk") : null, jSONObject3.has("bc") ? jSONObject3.getString("bc") : null, jSONObject3.has("errbc") ? jSONObject3.getString("errbc") : null);
        }
        com.five_corp.ad.internal.media_config.b bVar2 = bVar;
        if (jSONObject.has("rloglv")) {
            int i6 = jSONObject.getInt("rloglv");
            for (int i7 : com.five_corp.ad.e.b(6)) {
                if (com.five_corp.ad.e.a(i7) != i6) {
                }
            }
            throw new com.five_corp.ad.internal.exception.a(p.H1, i6);
        }
        return new com.five_corp.ad.internal.media_config.a(string, arrayList2, z, i4, j, z2, z3, arrayList, bVar2);
    }
}
