package com.chartboost.sdk.impl;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lorg/json/JSONObject;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/chartboost/sdk/impl/n7;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/n7;", "", "Lcom/chartboost/sdk/impl/eb;", "a", "(Lorg/json/JSONObject;)Ljava/util/List;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class o7 {
    public static final List<eb> a(JSONObject jSONObject) {
        List<JSONObject> listAsListSkipNull;
        eb ebVar;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("verification");
        if (jSONArrayOptJSONArray == null || (listAsListSkipNull = b5.asListSkipNull(jSONArrayOptJSONArray)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (JSONObject jSONObject2 : listAsListSkipNull) {
            try {
                String string = jSONObject2.getString("url");
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"url\")");
                String string2 = jSONObject2.getString("vendor");
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\"vendor\")");
                String string3 = jSONObject2.getString("params");
                Intrinsics.checkNotNullExpressionValue(string3, "it.getString(\"params\")");
                ebVar = new eb(string, string2, string3);
            } catch (Exception unused) {
                ebVar = null;
            }
            if (ebVar != null) {
                arrayList.add(ebVar);
            }
        }
        return arrayList;
    }

    public static final n7 b(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        List<eb> listA = a(config);
        JSONObject jSONObjectOptJSONObject = config.optJSONObject("viewabilitySettings");
        return jSONObjectOptJSONObject != null ? new n7(config.optBoolean("enabled", false), config.optBoolean("verificationEnabled", false), jSONObjectOptJSONObject.optInt("minVisibleDips", 1), jSONObjectOptJSONObject.optInt("minVisibleDurationMs", 0), jSONObjectOptJSONObject.optLong("visibilityCheckIntervalMs", 100L), jSONObjectOptJSONObject.optInt("traversalLimit", 25), listA) : new n7(config.optBoolean("enabled", false), config.optBoolean("verificationEnabled", false), 0, 0, 0L, 0, listA, 60, null);
    }
}
