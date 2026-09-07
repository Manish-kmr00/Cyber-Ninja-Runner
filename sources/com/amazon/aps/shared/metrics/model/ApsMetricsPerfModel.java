package com.amazon.aps.shared.metrics.model;

import com.json.mediationsdk.impressionData.ImpressionData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsPerfModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010@\u001a\u0002082\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\b\u0010E\u001a\u000208H\u0016J\b\u0010F\u001a\u00020GH\u0016J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006I"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfModel;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsEventBase;", "networkName", "", "(Ljava/lang/String;)V", "adClickEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdClickEvent;", "getAdClickEvent", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdClickEvent;", "setAdClickEvent", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdClickEvent;)V", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "getAdFormat", "()Ljava/lang/String;", "setAdFormat", "adapterEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdapterEvent;", "getAdapterEvent", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdapterEvent;", "setAdapterEvent", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdapterEvent;)V", "bidEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAaxBidEvent;", "getBidEvent", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAaxBidEvent;", "setBidEvent", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAaxBidEvent;)V", "bidId", "getBidId", "setBidId", "correlationId", "getCorrelationId", "setCorrelationId", "fetchEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdFetchEvent;", "getFetchEvent", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdFetchEvent;", "setFetchEvent", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAdFetchEvent;)V", "impressionEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfImpressionFiredEvent;", "getImpressionEvent", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfImpressionFiredEvent;", "setImpressionEvent", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfImpressionFiredEvent;)V", "jsonKeyName", "getJsonKeyName", "getNetworkName", "setNetworkName", "videoCompletedEvent", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfVideoCompletedEvent;", "getVideoCompletedEvent", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfVideoCompletedEvent;", "setVideoCompletedEvent", "(Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfVideoCompletedEvent;)V", "videoFlag", "", "getVideoFlag", "()Ljava/lang/Boolean;", "setVideoFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "isToSendDeviceInfo", "toJsonObject", "Lorg/json/JSONObject;", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsPerfModel extends ApsMetricsEventBase {
    private ApsMetricsPerfAdClickEvent adClickEvent;
    private String adFormat;
    private ApsMetricsPerfAdapterEvent adapterEvent;
    private ApsMetricsPerfAaxBidEvent bidEvent;
    private String bidId;
    private String correlationId;
    private ApsMetricsPerfAdFetchEvent fetchEvent;
    private ApsMetricsPerfImpressionFiredEvent impressionEvent;
    private String networkName;
    private ApsMetricsPerfVideoCompletedEvent videoCompletedEvent;
    private Boolean videoFlag;

    public ApsMetricsPerfModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ApsMetricsPerfModel copy$default(ApsMetricsPerfModel apsMetricsPerfModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apsMetricsPerfModel.networkName;
        }
        return apsMetricsPerfModel.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNetworkName() {
        return this.networkName;
    }

    public final ApsMetricsPerfModel copy(String networkName) {
        return new ApsMetricsPerfModel(networkName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsPerfModel) && Intrinsics.areEqual(this.networkName, ((ApsMetricsPerfModel) other).networkName);
    }

    public int hashCode() {
        String str = this.networkName;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ApsMetricsPerfModel(networkName=" + ((Object) this.networkName) + ')';
    }

    public /* synthetic */ ApsMetricsPerfModel(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final void setNetworkName(String str) {
        this.networkName = str;
    }

    public ApsMetricsPerfModel(String str) {
        super(0L, 1, null);
        this.networkName = str;
    }

    public final String getBidId() {
        return this.bidId;
    }

    public final void setBidId(String str) {
        this.bidId = str;
    }

    public final Boolean getVideoFlag() {
        return this.videoFlag;
    }

    public final void setVideoFlag(Boolean bool) {
        this.videoFlag = bool;
    }

    public final String getAdFormat() {
        return this.adFormat;
    }

    public final void setAdFormat(String str) {
        this.adFormat = str;
    }

    public final String getCorrelationId() {
        return this.correlationId;
    }

    public final void setCorrelationId(String str) {
        this.correlationId = str;
    }

    public final ApsMetricsPerfAaxBidEvent getBidEvent() {
        return this.bidEvent;
    }

    public final void setBidEvent(ApsMetricsPerfAaxBidEvent apsMetricsPerfAaxBidEvent) {
        this.bidEvent = apsMetricsPerfAaxBidEvent;
    }

    public final ApsMetricsPerfAdapterEvent getAdapterEvent() {
        return this.adapterEvent;
    }

    public final void setAdapterEvent(ApsMetricsPerfAdapterEvent apsMetricsPerfAdapterEvent) {
        this.adapterEvent = apsMetricsPerfAdapterEvent;
    }

    public final ApsMetricsPerfAdFetchEvent getFetchEvent() {
        return this.fetchEvent;
    }

    public final void setFetchEvent(ApsMetricsPerfAdFetchEvent apsMetricsPerfAdFetchEvent) {
        this.fetchEvent = apsMetricsPerfAdFetchEvent;
    }

    public final ApsMetricsPerfImpressionFiredEvent getImpressionEvent() {
        return this.impressionEvent;
    }

    public final void setImpressionEvent(ApsMetricsPerfImpressionFiredEvent apsMetricsPerfImpressionFiredEvent) {
        this.impressionEvent = apsMetricsPerfImpressionFiredEvent;
    }

    public final ApsMetricsPerfAdClickEvent getAdClickEvent() {
        return this.adClickEvent;
    }

    public final void setAdClickEvent(ApsMetricsPerfAdClickEvent apsMetricsPerfAdClickEvent) {
        this.adClickEvent = apsMetricsPerfAdClickEvent;
    }

    public final ApsMetricsPerfVideoCompletedEvent getVideoCompletedEvent() {
        return this.videoCompletedEvent;
    }

    public final void setVideoCompletedEvent(ApsMetricsPerfVideoCompletedEvent apsMetricsPerfVideoCompletedEvent) {
        this.videoCompletedEvent = apsMetricsPerfVideoCompletedEvent;
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsEventBase
    public String getJsonKeyName() {
        return "p";
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsEventBase
    public boolean isToSendDeviceInfo() {
        return (this.bidEvent == null && this.adapterEvent == null) ? false : true;
    }

    @Override // com.amazon.aps.shared.metrics.model.ApsMetricsEventBase
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        String networkName = getNetworkName();
        if (networkName != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_NETWORK, networkName);
        }
        if (getBidId() != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_BIDID, getBidId());
        }
        String correlationId = getCorrelationId();
        if (correlationId != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_CORRELATIONID, correlationId);
        }
        Boolean videoFlag = getVideoFlag();
        if (videoFlag != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_VIDEOFLAG, videoFlag.booleanValue());
        }
        String adFormat = getAdFormat();
        if (adFormat != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT, adFormat);
        }
        ApsMetricsPerfAaxBidEvent bidEvent = getBidEvent();
        if (bidEvent != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_BIDEVENT, bidEvent.toJsonObject());
        }
        ApsMetricsPerfAdapterEvent adapterEvent = getAdapterEvent();
        if (adapterEvent != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADAPTEREVENT, adapterEvent.toJsonObject());
        }
        ApsMetricsPerfAdFetchEvent fetchEvent = getFetchEvent();
        if (fetchEvent != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_FETCHEVENT, fetchEvent.toJsonObject());
        }
        ApsMetricsPerfImpressionFiredEvent impressionEvent = getImpressionEvent();
        if (impressionEvent != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_IMPRESSIONEVENT, impressionEvent.toJsonObject());
        }
        ApsMetricsPerfAdClickEvent adClickEvent = getAdClickEvent();
        if (adClickEvent != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADCLICKEVENT, adClickEvent.toJsonObject());
        }
        ApsMetricsPerfVideoCompletedEvent videoCompletedEvent = getVideoCompletedEvent();
        if (videoCompletedEvent != null) {
            jsonObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_VIDEOCOMPLETEDEVENT, videoCompletedEvent.toJsonObject());
        }
        return jsonObject;
    }
}
