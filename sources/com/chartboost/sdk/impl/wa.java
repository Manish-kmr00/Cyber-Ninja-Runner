package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/chartboost/sdk/impl/wa;", "", "Lorg/json/JSONObject;", "json", "Lcom/chartboost/sdk/impl/m2;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/m2;", "", "a", "(Lorg/json/JSONObject;)Ljava/lang/String;", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class wa {
    public final String a(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString("url", "") : null;
        return strOptString == null ? "" : strOptString;
    }

    public final m2 b(JSONObject json) {
        return new m2(a(json), c(json));
    }

    public final Boolean c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return a2.a(jSONObject, "shouldDismiss");
        }
        return null;
    }
}
