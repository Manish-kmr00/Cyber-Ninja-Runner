package com.amazon.aps.shared.metrics;

import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.metrics.model.ApsMetricsCustomEventInfo;
import com.amazon.aps.shared.metrics.model.ApsMetricsCustomModel;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataModel;
import com.amazon.aps.shared.metrics.model.ApsMetricsEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsTahoeDataModel;
import com.json.b9;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsCustomEventModelBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/amazon/aps/shared/metrics/ApsMetricsCustomEventModelBuilder;", "", "()V", "eventCategory", "", b9.h.j0, "eventValue", "extraAttrs", "Lorg/json/JSONObject;", "build", "withEventCategory", "withEventDetail", "extraAttributes", "withEventName", "withEventValue", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsMetricsCustomEventModelBuilder {
    private String eventCategory = "custom";
    private String eventName;
    private String eventValue;
    private JSONObject extraAttrs;

    public final ApsMetricsCustomEventModelBuilder withEventName(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        return this;
    }

    public final ApsMetricsCustomEventModelBuilder withEventValue(String eventValue) {
        Intrinsics.checkNotNullParameter(eventValue, "eventValue");
        this.eventValue = eventValue;
        return this;
    }

    public final ApsMetricsCustomEventModelBuilder withEventDetail(JSONObject extraAttributes) {
        Intrinsics.checkNotNullParameter(extraAttributes, "extraAttributes");
        this.extraAttrs = extraAttributes;
        return this;
    }

    public final ApsMetricsCustomEventModelBuilder withEventCategory(String eventCategory) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        this.eventCategory = eventCategory;
        return this;
    }

    public final JSONObject build() {
        try {
            String str = this.eventName;
            if (str == null) {
                return null;
            }
            return new ApsMetricsTahoeDataModel(this.eventCategory, str, new ApsMetricsDataModel(new ApsMetricsEvent(new ApsMetricsCustomModel(new ApsMetricsCustomEventInfo(str, this.eventValue, this.extraAttrs)))).toJsonObject()).toJsonObject();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error builing the custom metrics object from builder", e);
            return null;
        }
    }
}
