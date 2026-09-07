package com.amazon.aps.shared.metrics;

import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataModel;
import com.amazon.aps.shared.metrics.model.ApsMetricsEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfAaxBidEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfAdClickEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfAdFetchEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfAdapterEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfEventBase;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfImpressionFiredEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfModel;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfVideoCompletedEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsResult;
import com.amazon.aps.shared.metrics.model.ApsMetricsTahoeDataModel;
import com.amazon.device.ads.DtbConstants;
import com.json.mediationsdk.impressionData.ImpressionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsPerfEventModelBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u0010\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/amazon/aps/shared/metrics/ApsMetricsPerfEventModelBuilder;", "", "()V", "perfModel", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfModel;", "build", "Lorg/json/JSONObject;", "getFunnelEventName", "", "withAdClickEvent", "timestamp", "", "withAdFetchEndTime", "result", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsResult;", "endTime", "withAdFetchStartTime", "startTime", "withAdFormat", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "withAdImpressionEndTime", "withAdapterEndTime", "withAdapterStartTime", "withBidId", "bidId", "withCorrelationId", "correlationId", "withEvent", "event", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfEventBase;", "withMediationName", DtbConstants.MEDIATION_NAME, "withVideoCompletedEvent", "withVideoFlag", "videoFlag", "", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsMetricsPerfEventModelBuilder {
    private final ApsMetricsPerfModel perfModel = new ApsMetricsPerfModel(null, 1, 0 == true ? 1 : 0);

    public final ApsMetricsPerfEventModelBuilder withMediationName(String mediationName) {
        this.perfModel.setNetworkName(mediationName);
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withCorrelationId(String correlationId) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.perfModel.setCorrelationId(correlationId);
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withAdFormat(String adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.perfModel.setAdFormat(adFormat);
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withVideoFlag(boolean videoFlag) {
        this.perfModel.setVideoFlag(Boolean.valueOf(videoFlag));
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withAdImpressionEndTime(ApsMetricsResult result, long endTime) {
        Intrinsics.checkNotNullParameter(result, "result");
        ApsMetricsPerfModel apsMetricsPerfModel = this.perfModel;
        ApsMetricsPerfImpressionFiredEvent apsMetricsPerfImpressionFiredEvent = new ApsMetricsPerfImpressionFiredEvent(result);
        apsMetricsPerfImpressionFiredEvent.setEndTime(endTime);
        apsMetricsPerfModel.setImpressionEvent(apsMetricsPerfImpressionFiredEvent);
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withBidId(String bidId) {
        if (bidId != null) {
            this.perfModel.setBidId(bidId);
        }
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withAdFetchStartTime(long startTime) {
        ApsMetricsPerfModel apsMetricsPerfModel = this.perfModel;
        ApsMetricsPerfAdFetchEvent fetchEvent = apsMetricsPerfModel.getFetchEvent();
        if (fetchEvent == null) {
            fetchEvent = new ApsMetricsPerfAdFetchEvent(null, 1, null);
        }
        apsMetricsPerfModel.setFetchEvent(fetchEvent);
        ApsMetricsPerfAdFetchEvent fetchEvent2 = this.perfModel.getFetchEvent();
        if (fetchEvent2 != null) {
            fetchEvent2.setStartTime(startTime);
        }
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withAdFetchEndTime(ApsMetricsResult result, long endTime) {
        Intrinsics.checkNotNullParameter(result, "result");
        ApsMetricsPerfModel apsMetricsPerfModel = this.perfModel;
        ApsMetricsPerfAdFetchEvent fetchEvent = apsMetricsPerfModel.getFetchEvent();
        if (fetchEvent == null) {
            fetchEvent = new ApsMetricsPerfAdFetchEvent(result);
        }
        apsMetricsPerfModel.setFetchEvent(fetchEvent);
        ApsMetricsPerfAdFetchEvent fetchEvent2 = this.perfModel.getFetchEvent();
        if (fetchEvent2 != null) {
            fetchEvent2.setResult(result);
        }
        ApsMetricsPerfAdFetchEvent fetchEvent3 = this.perfModel.getFetchEvent();
        if (fetchEvent3 != null) {
            fetchEvent3.setEndTime(endTime);
        }
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withAdapterStartTime(long startTime) {
        ApsMetricsPerfModel apsMetricsPerfModel = this.perfModel;
        ApsMetricsPerfAdapterEvent adapterEvent = apsMetricsPerfModel.getAdapterEvent();
        if (adapterEvent == null) {
            adapterEvent = new ApsMetricsPerfAdapterEvent(null, 1, null);
        }
        apsMetricsPerfModel.setAdapterEvent(adapterEvent);
        ApsMetricsPerfAdapterEvent adapterEvent2 = this.perfModel.getAdapterEvent();
        if (adapterEvent2 != null) {
            adapterEvent2.setStartTime(startTime);
        }
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withAdapterEndTime(ApsMetricsResult result, long endTime) {
        Intrinsics.checkNotNullParameter(result, "result");
        ApsMetricsPerfModel apsMetricsPerfModel = this.perfModel;
        ApsMetricsPerfAdapterEvent adapterEvent = apsMetricsPerfModel.getAdapterEvent();
        if (adapterEvent == null) {
            adapterEvent = new ApsMetricsPerfAdapterEvent(null, 1, null);
        }
        apsMetricsPerfModel.setAdapterEvent(adapterEvent);
        ApsMetricsPerfAdapterEvent adapterEvent2 = this.perfModel.getAdapterEvent();
        if (adapterEvent2 != null) {
            adapterEvent2.setResult(result);
        }
        ApsMetricsPerfAdapterEvent adapterEvent3 = this.perfModel.getAdapterEvent();
        if (adapterEvent3 != null) {
            adapterEvent3.setEndTime(endTime);
        }
        return this;
    }

    public static /* synthetic */ ApsMetricsPerfEventModelBuilder withAdClickEvent$default(ApsMetricsPerfEventModelBuilder apsMetricsPerfEventModelBuilder, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withAdClickEvent");
        }
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return apsMetricsPerfEventModelBuilder.withAdClickEvent(j);
    }

    public final ApsMetricsPerfEventModelBuilder withAdClickEvent(long timestamp) {
        this.perfModel.setAdClickEvent(new ApsMetricsPerfAdClickEvent(timestamp));
        return this;
    }

    public static /* synthetic */ ApsMetricsPerfEventModelBuilder withVideoCompletedEvent$default(ApsMetricsPerfEventModelBuilder apsMetricsPerfEventModelBuilder, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withVideoCompletedEvent");
        }
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return apsMetricsPerfEventModelBuilder.withVideoCompletedEvent(j);
    }

    public final ApsMetricsPerfEventModelBuilder withVideoCompletedEvent(long timestamp) {
        this.perfModel.setVideoCompletedEvent(new ApsMetricsPerfVideoCompletedEvent(timestamp));
        return this;
    }

    public final ApsMetricsPerfEventModelBuilder withEvent(ApsMetricsPerfEventBase event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ApsMetricsPerfAaxBidEvent) {
            this.perfModel.setBidEvent((ApsMetricsPerfAaxBidEvent) event);
        } else if (event instanceof ApsMetricsPerfImpressionFiredEvent) {
            this.perfModel.setImpressionEvent((ApsMetricsPerfImpressionFiredEvent) event);
        } else if (event instanceof ApsMetricsPerfAdFetchEvent) {
            this.perfModel.setFetchEvent((ApsMetricsPerfAdFetchEvent) event);
        } else if (event instanceof ApsMetricsPerfAdapterEvent) {
            this.perfModel.setAdapterEvent((ApsMetricsPerfAdapterEvent) event);
        }
        return this;
    }

    public final JSONObject build() {
        try {
            return new ApsMetricsTahoeDataModel(ApsMetricsTahoeDataModel.TAHOE_EVENT_CATEGORY_FUNNEL, getFunnelEventName(), new ApsMetricsDataModel(new ApsMetricsEvent(this.perfModel)).toJsonObject()).toJsonObject();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error building the perf metrics object from builder", e);
            return null;
        }
    }

    private final String getFunnelEventName() {
        if (this.perfModel.getFetchEvent() != null) {
            return ApsMetricsDataMap.APSMETRICS_FIELD_FETCHEVENT;
        }
        if (this.perfModel.getAdapterEvent() != null) {
            return ApsMetricsDataMap.APSMETRICS_FIELD_ADAPTEREVENT;
        }
        if (this.perfModel.getAdClickEvent() != null) {
            return ApsMetricsDataMap.APSMETRICS_FIELD_ADCLICKEVENT;
        }
        if (this.perfModel.getBidEvent() != null) {
            return ApsMetricsDataMap.APSMETRICS_FIELD_BIDEVENT;
        }
        if (this.perfModel.getImpressionEvent() != null) {
            return ApsMetricsDataMap.APSMETRICS_FIELD_IMPRESSIONEVENT;
        }
        if (this.perfModel.getVideoCompletedEvent() != null) {
            return ApsMetricsDataMap.APSMETRICS_FIELD_VIDEOCOMPLETEDEVENT;
        }
        return "";
    }
}
