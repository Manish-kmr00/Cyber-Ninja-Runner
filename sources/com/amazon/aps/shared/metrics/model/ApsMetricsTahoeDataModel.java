package com.amazon.aps.shared.metrics.model;

import com.json.b9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsTahoeDataModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÂ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0006J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsTahoeDataModel;", "", "eventCategory", "", b9.h.j0, "eventProperties", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "eventSource", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJsonObject", "toString", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsTahoeDataModel {
    public static final String TAHOE_EVENT_CATEGORY_CRASH = "crash";
    public static final String TAHOE_EVENT_CATEGORY_CUSTOM = "custom";
    public static final String TAHOE_EVENT_CATEGORY_FUNNEL = "funnel";
    private String eventCategory;
    private String eventName;
    private JSONObject eventProperties;
    private final String eventSource;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getEventCategory() {
        return this.eventCategory;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getEventName() {
        return this.eventName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final JSONObject getEventProperties() {
        return this.eventProperties;
    }

    public static /* synthetic */ ApsMetricsTahoeDataModel copy$default(ApsMetricsTahoeDataModel apsMetricsTahoeDataModel, String str, String str2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apsMetricsTahoeDataModel.eventCategory;
        }
        if ((i & 2) != 0) {
            str2 = apsMetricsTahoeDataModel.eventName;
        }
        if ((i & 4) != 0) {
            jSONObject = apsMetricsTahoeDataModel.eventProperties;
        }
        return apsMetricsTahoeDataModel.copy(str, str2, jSONObject);
    }

    public final ApsMetricsTahoeDataModel copy(String eventCategory, String eventName, JSONObject eventProperties) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        return new ApsMetricsTahoeDataModel(eventCategory, eventName, eventProperties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApsMetricsTahoeDataModel)) {
            return false;
        }
        ApsMetricsTahoeDataModel apsMetricsTahoeDataModel = (ApsMetricsTahoeDataModel) other;
        return Intrinsics.areEqual(this.eventCategory, apsMetricsTahoeDataModel.eventCategory) && Intrinsics.areEqual(this.eventName, apsMetricsTahoeDataModel.eventName) && Intrinsics.areEqual(this.eventProperties, apsMetricsTahoeDataModel.eventProperties);
    }

    public int hashCode() {
        return (((this.eventCategory.hashCode() * 31) + this.eventName.hashCode()) * 31) + this.eventProperties.hashCode();
    }

    public String toString() {
        return "ApsMetricsTahoeDataModel(eventCategory=" + this.eventCategory + ", eventName=" + this.eventName + ", eventProperties=" + this.eventProperties + ')';
    }

    public ApsMetricsTahoeDataModel(String eventCategory, String eventName, JSONObject eventProperties) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        this.eventCategory = eventCategory;
        this.eventName = eventName;
        this.eventProperties = eventProperties;
        this.eventSource = "aps_android_sdk";
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("eventSource", this.eventSource);
        jSONObject2.put("eventTime", System.currentTimeMillis());
        jSONObject2.put(b9.h.j0, this.eventName);
        jSONObject2.put("eventCategory", this.eventCategory);
        jSONObject2.put("eventProperties", this.eventProperties);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("Data", jSONObject2);
        jSONObject.put("PartitionKey", System.currentTimeMillis());
        return jSONObject;
    }
}
