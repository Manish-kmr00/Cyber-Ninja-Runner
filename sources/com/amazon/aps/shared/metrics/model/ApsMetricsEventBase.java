package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsEventBase.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsEventBase;", "", "timestamp", "", "(J)V", "jsonKeyName", "", "getJsonKeyName", "()Ljava/lang/String;", "isToSendDeviceInfo", "", "toJsonObject", "Lorg/json/JSONObject;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApsMetricsEventBase {
    private final long timestamp;

    public ApsMetricsEventBase() {
        this(0L, 1, null);
    }

    public abstract String getJsonKeyName();

    public boolean isToSendDeviceInfo() {
        return false;
    }

    public ApsMetricsEventBase(long j) {
        this.timestamp = j;
    }

    public /* synthetic */ ApsMetricsEventBase(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? System.currentTimeMillis() : j);
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, this.timestamp);
        return jSONObject;
    }
}
