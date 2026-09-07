package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsEvent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsEvent;", "", "metricsEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsEventBase;", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsEventBase;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "isToSendDeviceInfo", "toJsonObject", "Lorg/json/JSONObject;", "toString", "", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsEvent {
    private final ApsMetricsEventBase metricsEvent;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ApsMetricsEventBase getMetricsEvent() {
        return this.metricsEvent;
    }

    public static /* synthetic */ ApsMetricsEvent copy$default(ApsMetricsEvent apsMetricsEvent, ApsMetricsEventBase apsMetricsEventBase, int i, Object obj) {
        if ((i & 1) != 0) {
            apsMetricsEventBase = apsMetricsEvent.metricsEvent;
        }
        return apsMetricsEvent.copy(apsMetricsEventBase);
    }

    public final ApsMetricsEvent copy(ApsMetricsEventBase metricsEvent) {
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        return new ApsMetricsEvent(metricsEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsEvent) && Intrinsics.areEqual(this.metricsEvent, ((ApsMetricsEvent) other).metricsEvent);
    }

    public int hashCode() {
        return this.metricsEvent.hashCode();
    }

    public String toString() {
        return "ApsMetricsEvent(metricsEvent=" + this.metricsEvent + ')';
    }

    public ApsMetricsEvent(ApsMetricsEventBase metricsEvent) {
        Intrinsics.checkNotNullParameter(metricsEvent, "metricsEvent");
        this.metricsEvent = metricsEvent;
    }

    public final boolean isToSendDeviceInfo() {
        return this.metricsEvent.isToSendDeviceInfo();
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ApsMetricsEventBase apsMetricsEventBase = this.metricsEvent;
        jSONObject.put(apsMetricsEventBase.getJsonKeyName(), apsMetricsEventBase.toJsonObject());
        return jSONObject;
    }
}
