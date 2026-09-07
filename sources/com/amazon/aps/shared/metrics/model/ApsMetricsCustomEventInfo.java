package com.amazon.aps.shared.metrics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsCustomEventInfo.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0006HÂ\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0006J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsCustomEventInfo;", "", "name", "", "value", "extraAttrs", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJsonObject", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsCustomEventInfo {
    private final JSONObject extraAttrs;
    private final String name;
    private final String value;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final JSONObject getExtraAttrs() {
        return this.extraAttrs;
    }

    public static /* synthetic */ ApsMetricsCustomEventInfo copy$default(ApsMetricsCustomEventInfo apsMetricsCustomEventInfo, String str, String str2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apsMetricsCustomEventInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = apsMetricsCustomEventInfo.value;
        }
        if ((i & 4) != 0) {
            jSONObject = apsMetricsCustomEventInfo.extraAttrs;
        }
        return apsMetricsCustomEventInfo.copy(str, str2, jSONObject);
    }

    public final ApsMetricsCustomEventInfo copy(String name, String value, JSONObject extraAttrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ApsMetricsCustomEventInfo(name, value, extraAttrs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApsMetricsCustomEventInfo)) {
            return false;
        }
        ApsMetricsCustomEventInfo apsMetricsCustomEventInfo = (ApsMetricsCustomEventInfo) other;
        return Intrinsics.areEqual(this.name, apsMetricsCustomEventInfo.name) && Intrinsics.areEqual(this.value, apsMetricsCustomEventInfo.value) && Intrinsics.areEqual(this.extraAttrs, apsMetricsCustomEventInfo.extraAttrs);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.value;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        JSONObject jSONObject = this.extraAttrs;
        return iHashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ApsMetricsCustomEventInfo(name=" + this.name + ", value=" + ((Object) this.value) + ", extraAttrs=" + this.extraAttrs + ')';
    }

    public ApsMetricsCustomEventInfo(String name, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.value = str;
        this.extraAttrs = jSONObject;
    }

    public /* synthetic */ ApsMetricsCustomEventInfo(String str, String str2, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jSONObject);
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("n", this.name);
        jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, System.currentTimeMillis());
        String str = this.value;
        if (str != null) {
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_VALUE, str);
        }
        JSONObject jSONObject2 = this.extraAttrs;
        if (jSONObject2 != null) {
            jSONObject.put("ext", jSONObject2);
        }
        return jSONObject;
    }
}
