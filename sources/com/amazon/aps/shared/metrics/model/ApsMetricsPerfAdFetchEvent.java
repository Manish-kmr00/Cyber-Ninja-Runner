package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsPerfAdFetchEvent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdFetchEvent;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfEventBase;", "result", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;)V", "getResult", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "setResult", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toJsonObject", "Lorg/json/JSONObject;", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsPerfAdFetchEvent extends ApsMetricsPerfEventBase {
    private ApsMetricsResult result;
    private String url;

    public ApsMetricsPerfAdFetchEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ApsMetricsPerfAdFetchEvent copy$default(ApsMetricsPerfAdFetchEvent apsMetricsPerfAdFetchEvent, ApsMetricsResult apsMetricsResult, int i, Object obj) {
        if ((i & 1) != 0) {
            apsMetricsResult = apsMetricsPerfAdFetchEvent.getResult();
        }
        return apsMetricsPerfAdFetchEvent.copy(apsMetricsResult);
    }

    public final ApsMetricsResult component1() {
        return getResult();
    }

    public final ApsMetricsPerfAdFetchEvent copy(ApsMetricsResult result) {
        return new ApsMetricsPerfAdFetchEvent(result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsPerfAdFetchEvent) && getResult() == ((ApsMetricsPerfAdFetchEvent) other).getResult();
    }

    public int hashCode() {
        if (getResult() == null) {
            return 0;
        }
        return getResult().hashCode();
    }

    public String toString() {
        return "ApsMetricsPerfAdFetchEvent(result=" + getResult() + ')';
    }

    public /* synthetic */ ApsMetricsPerfAdFetchEvent(ApsMetricsResult apsMetricsResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : apsMetricsResult);
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsPerfEventBase
    public ApsMetricsResult getResult() {
        return this.result;
    }

    public void setResult(ApsMetricsResult apsMetricsResult) {
        this.result = apsMetricsResult;
    }

    public ApsMetricsPerfAdFetchEvent(ApsMetricsResult apsMetricsResult) {
        super(apsMetricsResult, 0L, 0L, 6, null);
        this.result = apsMetricsResult;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsPerfEventBase
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        String url = getUrl();
        if (url != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_URL, url);
        }
        return jsonObject;
    }
}
