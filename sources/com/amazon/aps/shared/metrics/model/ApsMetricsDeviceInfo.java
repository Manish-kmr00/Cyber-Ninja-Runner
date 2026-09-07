package com.amazon.aps.shared.metrics.model;

import android.os.Build;
import com.amazon.device.ads.DtbDeviceData;
import com.json.b9;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetricsDeviceInfo.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\u0006\u0010&\u001a\u00020'J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\f¨\u0006)"}, d2 = {"Lcom/amazon/aps/shared/metrics/model/ApsMetricsDeviceInfo;", "", "platformCategory", "", DtbDeviceData.DEVICE_DATA_SCREEN_SIZE_KEY, "deviceType", b9.i.t, "platformCategoryVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConnectionType", "()Ljava/lang/String;", "setConnectionType", "(Ljava/lang/String;)V", "getDeviceType", "setDeviceType", "os", "getOs", "setOs", "platform", "getPlatform", "setPlatform", "getPlatformCategory", "setPlatformCategory", "getPlatformCategoryVersion", "setPlatformCategoryVersion", "getScreenSize", "setScreenSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJsonObject", "Lorg/json/JSONObject;", "toString", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApsMetricsDeviceInfo {
    private String connectionType;
    private String deviceType;
    private String os;
    private String platform;
    private String platformCategory;
    private String platformCategoryVersion;
    private String screenSize;

    public ApsMetricsDeviceInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ApsMetricsDeviceInfo copy$default(ApsMetricsDeviceInfo apsMetricsDeviceInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apsMetricsDeviceInfo.platformCategory;
        }
        if ((i & 2) != 0) {
            str2 = apsMetricsDeviceInfo.screenSize;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = apsMetricsDeviceInfo.deviceType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = apsMetricsDeviceInfo.connectionType;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = apsMetricsDeviceInfo.platformCategoryVersion;
        }
        return apsMetricsDeviceInfo.copy(str, str6, str7, str8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlatformCategory() {
        return this.platformCategory;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScreenSize() {
        return this.screenSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getConnectionType() {
        return this.connectionType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlatformCategoryVersion() {
        return this.platformCategoryVersion;
    }

    public final ApsMetricsDeviceInfo copy(String platformCategory, String screenSize, String deviceType, String connectionType, String platformCategoryVersion) {
        return new ApsMetricsDeviceInfo(platformCategory, screenSize, deviceType, connectionType, platformCategoryVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApsMetricsDeviceInfo)) {
            return false;
        }
        ApsMetricsDeviceInfo apsMetricsDeviceInfo = (ApsMetricsDeviceInfo) other;
        return Intrinsics.areEqual(this.platformCategory, apsMetricsDeviceInfo.platformCategory) && Intrinsics.areEqual(this.screenSize, apsMetricsDeviceInfo.screenSize) && Intrinsics.areEqual(this.deviceType, apsMetricsDeviceInfo.deviceType) && Intrinsics.areEqual(this.connectionType, apsMetricsDeviceInfo.connectionType) && Intrinsics.areEqual(this.platformCategoryVersion, apsMetricsDeviceInfo.platformCategoryVersion);
    }

    public int hashCode() {
        String str = this.platformCategory;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.screenSize;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceType;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.connectionType;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.platformCategoryVersion;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ApsMetricsDeviceInfo(platformCategory=" + ((Object) this.platformCategory) + ", screenSize=" + ((Object) this.screenSize) + ", deviceType=" + ((Object) this.deviceType) + ", connectionType=" + ((Object) this.connectionType) + ", platformCategoryVersion=" + ((Object) this.platformCategoryVersion) + ')';
    }

    public ApsMetricsDeviceInfo(String str, String str2, String str3, String str4, String str5) {
        this.platformCategory = str;
        this.screenSize = str2;
        this.deviceType = str3;
        this.connectionType = str4;
        this.platformCategoryVersion = str5;
        this.os = "android";
        this.platform = "app";
    }

    public /* synthetic */ ApsMetricsDeviceInfo(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getPlatformCategory() {
        return this.platformCategory;
    }

    public final void setPlatformCategory(String str) {
        this.platformCategory = str;
    }

    public final String getScreenSize() {
        return this.screenSize;
    }

    public final void setScreenSize(String str) {
        this.screenSize = str;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(String str) {
        this.deviceType = str;
    }

    public final String getConnectionType() {
        return this.connectionType;
    }

    public final void setConnectionType(String str) {
        this.connectionType = str;
    }

    public final String getPlatformCategoryVersion() {
        return this.platformCategoryVersion;
    }

    public final void setPlatformCategoryVersion(String str) {
        this.platformCategoryVersion = str;
    }

    public final String getOs() {
        return this.os;
    }

    public final void setOs(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.os = str;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final void setPlatform(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platform = str;
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os", getOs());
        jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORM, getPlatform());
        jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_OSVERSION, String.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_MANUFACTURER, Build.MANUFACTURER);
        jSONObject.put("md", Build.MODEL);
        String platformCategoryVersion = getPlatformCategoryVersion();
        if (platformCategoryVersion != null) {
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORYVERSION, platformCategoryVersion);
        }
        String platformCategory = getPlatformCategory();
        if (platformCategory != null) {
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORY, platformCategory);
        }
        String screenSize = getScreenSize();
        if (screenSize != null) {
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_SCREENSIZE, screenSize);
        }
        String deviceType = getDeviceType();
        if (deviceType != null) {
            jSONObject.put("dt", deviceType);
        }
        String connectionType = getConnectionType();
        if (connectionType != null) {
            jSONObject.put("ct", connectionType);
        }
        return jSONObject;
    }
}
