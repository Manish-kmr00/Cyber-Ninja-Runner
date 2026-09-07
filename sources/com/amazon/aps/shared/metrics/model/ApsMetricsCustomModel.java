package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsCustomModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsCustomModel;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsEventBase;", "event", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsCustomEventInfo;", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsCustomEventInfo;)V", "jsonKeyName", "", "getJsonKeyName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "isToSendDeviceInfo", "toJsonObject", "Lorg/json/JSONObject;", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsCustomModel extends ApsMetricsEventBase {
    private final ApsMetricsCustomEventInfo event;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ApsMetricsCustomEventInfo getEvent() {
        return this.event;
    }

    public static /* synthetic */ ApsMetricsCustomModel copy$default(ApsMetricsCustomModel apsMetricsCustomModel, ApsMetricsCustomEventInfo apsMetricsCustomEventInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            apsMetricsCustomEventInfo = apsMetricsCustomModel.event;
        }
        return apsMetricsCustomModel.copy(apsMetricsCustomEventInfo);
    }

    public final ApsMetricsCustomModel copy(ApsMetricsCustomEventInfo event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return new ApsMetricsCustomModel(event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsCustomModel) && Intrinsics.areEqual(this.event, ((ApsMetricsCustomModel) other).event);
    }

    public int hashCode() {
        return this.event.hashCode();
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsEventBase
    public boolean isToSendDeviceInfo() {
        return true;
    }

    public String toString() {
        return "ApsMetricsCustomModel(event=" + this.event + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApsMetricsCustomModel(ApsMetricsCustomEventInfo event) {
        super(0L, 1, null);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsEventBase
    public String getJsonKeyName() {
        return ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM;
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsEventBase
    public JSONObject toJsonObject() {
        return this.event.toJsonObject();
    }
}
