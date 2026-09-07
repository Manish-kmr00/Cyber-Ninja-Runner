package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: ApsMetricsPerfAdClickEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdClickEvent;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfEventBase;", "timestamp", "", "(J)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsPerfAdClickEvent extends ApsMetricsPerfEventBase {
    private final long timestamp;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final long getTimestamp() {
        return this.timestamp;
    }

    public static /* synthetic */ ApsMetricsPerfAdClickEvent copy$default(ApsMetricsPerfAdClickEvent apsMetricsPerfAdClickEvent, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = apsMetricsPerfAdClickEvent.timestamp;
        }
        return apsMetricsPerfAdClickEvent.copy(j);
    }

    public final ApsMetricsPerfAdClickEvent copy(long timestamp) {
        return new ApsMetricsPerfAdClickEvent(timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsPerfAdClickEvent) && this.timestamp == ((ApsMetricsPerfAdClickEvent) other).timestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "ApsMetricsPerfAdClickEvent(timestamp=" + this.timestamp + ')';
    }

    public ApsMetricsPerfAdClickEvent(long j) {
        super(null, j, 0L, 5, null);
        this.timestamp = j;
    }
}
