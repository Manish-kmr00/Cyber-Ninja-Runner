package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsPerfAaxBidEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAaxBidEvent;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfEventBase;", "result", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "hostname", "", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;Ljava/lang/String;)V", "getHostname", "()Ljava/lang/String;", "refreshFlag", "", "getRefreshFlag", "()Ljava/lang/Boolean;", "setRefreshFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getResult", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toJsonObject", "Lorg/json/JSONObject;", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsPerfAaxBidEvent extends ApsMetricsPerfEventBase {
    private final String hostname;
    private Boolean refreshFlag;
    private final ApsMetricsResult result;

    public static /* synthetic */ ApsMetricsPerfAaxBidEvent copy$default(ApsMetricsPerfAaxBidEvent apsMetricsPerfAaxBidEvent, ApsMetricsResult apsMetricsResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            apsMetricsResult = apsMetricsPerfAaxBidEvent.getResult();
        }
        if ((i & 2) != 0) {
            str = apsMetricsPerfAaxBidEvent.hostname;
        }
        return apsMetricsPerfAaxBidEvent.copy(apsMetricsResult, str);
    }

    public final ApsMetricsResult component1() {
        return getResult();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHostname() {
        return this.hostname;
    }

    public final ApsMetricsPerfAaxBidEvent copy(ApsMetricsResult result, String hostname) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return new ApsMetricsPerfAaxBidEvent(result, hostname);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApsMetricsPerfAaxBidEvent)) {
            return false;
        }
        ApsMetricsPerfAaxBidEvent apsMetricsPerfAaxBidEvent = (ApsMetricsPerfAaxBidEvent) other;
        return getResult() == apsMetricsPerfAaxBidEvent.getResult() && Intrinsics.areEqual(this.hostname, apsMetricsPerfAaxBidEvent.hostname);
    }

    public int hashCode() {
        return (getResult().hashCode() * 31) + this.hostname.hashCode();
    }

    public String toString() {
        return "ApsMetricsPerfAaxBidEvent(result=" + getResult() + ", hostname=" + this.hostname + ')';
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsPerfEventBase
    public ApsMetricsResult getResult() {
        return this.result;
    }

    public final String getHostname() {
        return this.hostname;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApsMetricsPerfAaxBidEvent(ApsMetricsResult result, String hostname) {
        super(result, 0L, 0L, 6, null);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        this.result = result;
        this.hostname = hostname;
    }

    public final Boolean getRefreshFlag() {
        return this.refreshFlag;
    }

    public final void setRefreshFlag(Boolean bool) {
        this.refreshFlag = bool;
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsPerfEventBase
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        jsonObject.put("h", getHostname());
        Boolean refreshFlag = getRefreshFlag();
        if (refreshFlag != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_REFRESHFLAG, refreshFlag.booleanValue());
        }
        return jsonObject;
    }
}
