package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApsMetricsPerfImpressionFiredEvent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfImpressionFiredEvent;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfEventBase;", "result", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;)V", "getResult", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsPerfImpressionFiredEvent extends ApsMetricsPerfEventBase {
    private final ApsMetricsResult result;

    public static /* synthetic */ ApsMetricsPerfImpressionFiredEvent copy$default(ApsMetricsPerfImpressionFiredEvent apsMetricsPerfImpressionFiredEvent, ApsMetricsResult apsMetricsResult, int i, Object obj) {
        if ((i & 1) != 0) {
            apsMetricsResult = apsMetricsPerfImpressionFiredEvent.getResult();
        }
        return apsMetricsPerfImpressionFiredEvent.copy(apsMetricsResult);
    }

    public final ApsMetricsResult component1() {
        return getResult();
    }

    public final ApsMetricsPerfImpressionFiredEvent copy(ApsMetricsResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new ApsMetricsPerfImpressionFiredEvent(result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsPerfImpressionFiredEvent) && getResult() == ((ApsMetricsPerfImpressionFiredEvent) other).getResult();
    }

    public int hashCode() {
        return getResult().hashCode();
    }

    public String toString() {
        return "ApsMetricsPerfImpressionFiredEvent(result=" + getResult() + ')';
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsPerfEventBase
    public ApsMetricsResult getResult() {
        return this.result;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApsMetricsPerfImpressionFiredEvent(ApsMetricsResult result) {
        super(result, 0L, 0L, 6, null);
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
    }
}
