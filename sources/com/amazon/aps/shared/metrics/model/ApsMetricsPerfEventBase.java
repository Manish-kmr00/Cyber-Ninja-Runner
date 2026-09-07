package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsPerfEventBase.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfEventBase;", "", "result", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "startTime", "", "endTime", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;JJ)V", "getEndTime", "()J", "setEndTime", "(J)V", "getResult", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "getStartTime", "setStartTime", "toJsonObject", "Lorg/json/JSONObject;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsMetricsPerfEventBase {
    private long endTime;
    private final ApsMetricsResult result;
    private long startTime;

    public ApsMetricsPerfEventBase() {
        this(null, 0L, 0L, 7, null);
    }

    public ApsMetricsPerfEventBase(ApsMetricsResult apsMetricsResult, long j, long j2) {
        this.result = apsMetricsResult;
        this.startTime = j;
        this.endTime = j2;
    }

    public /* synthetic */ ApsMetricsPerfEventBase(ApsMetricsResult apsMetricsResult, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : apsMetricsResult, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    public ApsMetricsResult getResult() {
        return this.result;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ApsMetricsResult result = getResult();
        if (result != null) {
            jSONObject.put("r", result == ApsMetricsResult.Success);
        }
        if (getStartTime() != 0) {
            jSONObject.put("st", getStartTime());
        }
        if (getEndTime() != 0) {
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_ENDTIME, getEndTime());
        }
        return jSONObject;
    }
}
