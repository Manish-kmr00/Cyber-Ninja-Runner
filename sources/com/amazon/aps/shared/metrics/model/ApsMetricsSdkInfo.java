package com.amazon.aps.shared.metrics.model;

import com.amazon.aps.shared.ApsMetrics;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsSdkInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsSdkInfo;", "", "version", "", "(Ljava/lang/String;)V", MobileAdsBridge.versionMethodName, "()Ljava/lang/String;", "setVersion", "component1", "copy", "equals", "", "other", "hashCode", "", "toJsonObject", "Lorg/json/JSONObject;", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsSdkInfo {
    private String version;

    public ApsMetricsSdkInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ApsMetricsSdkInfo copy$default(ApsMetricsSdkInfo apsMetricsSdkInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apsMetricsSdkInfo.version;
        }
        return apsMetricsSdkInfo.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final ApsMetricsSdkInfo copy(String version) {
        return new ApsMetricsSdkInfo(version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ApsMetricsSdkInfo) && Intrinsics.areEqual(this.version, ((ApsMetricsSdkInfo) other).version);
    }

    public int hashCode() {
        String str = this.version;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ApsMetricsSdkInfo(version=" + ((Object) this.version) + ')';
    }

    public ApsMetricsSdkInfo(String str) {
        this.version = str;
    }

    public /* synthetic */ ApsMetricsSdkInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String version = getVersion();
        if (version != null) {
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_APSVERSION, version);
        }
        String adapterVersion = ApsMetrics.Companion.getAdapterVersion();
        if (adapterVersion != null) {
            jSONObject.put("av", adapterVersion);
        }
        return jSONObject;
    }
}
