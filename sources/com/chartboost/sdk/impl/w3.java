package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\u0013\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0014\u0010\u0004R\u0017\u0010 \u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001c\u0010\u0007R\u0017\u0010!\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u0017\u0010(\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'¨\u0006+"}, d2 = {"Lcom/chartboost/sdk/impl/w3;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "deviceWidth", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "deviceHeight", "j", "width", "d", "e", "height", "", "F", "h", "()F", "scale", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/String;", "dpi", "g", "ortbDeviceType", "deviceType", "i", "packageName", "versionName", CampaignEx.JSON_KEY_AD_K, "Z", "()Z", "isPortrait", "<init>", "(IIIIFLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int deviceWidth;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int deviceHeight;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int width;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int height;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final float scale;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String dpi;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final int ortbDeviceType;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final String deviceType;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final String packageName;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final String versionName;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final boolean isPortrait;

    public w3() {
        this(0, 0, 0, 0, 0.0f, null, 0, null, null, null, false, 2047, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof w3)) {
            return false;
        }
        w3 w3Var = (w3) other;
        return this.deviceWidth == w3Var.deviceWidth && this.deviceHeight == w3Var.deviceHeight && this.width == w3Var.width && this.height == w3Var.height && Float.compare(this.scale, w3Var.scale) == 0 && Intrinsics.areEqual(this.dpi, w3Var.dpi) && this.ortbDeviceType == w3Var.ortbDeviceType && Intrinsics.areEqual(this.deviceType, w3Var.deviceType) && Intrinsics.areEqual(this.packageName, w3Var.packageName) && Intrinsics.areEqual(this.versionName, w3Var.versionName) && this.isPortrait == w3Var.isPortrait;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v24 */
    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.deviceWidth) * 31) + Integer.hashCode(this.deviceHeight)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.scale)) * 31;
        String str = this.dpi;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.ortbDeviceType)) * 31) + this.deviceType.hashCode()) * 31;
        String str2 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.versionName;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.isPortrait;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceBodyFields(deviceWidth=");
        sb.append(this.deviceWidth).append(", deviceHeight=").append(this.deviceHeight).append(", width=").append(this.width).append(", height=").append(this.height).append(", scale=").append(this.scale).append(", dpi=").append(this.dpi).append(", ortbDeviceType=").append(this.ortbDeviceType).append(", deviceType=").append(this.deviceType).append(", packageName=").append(this.packageName).append(", versionName=").append(this.versionName).append(", isPortrait=").append(this.isPortrait).append(')');
        return sb.toString();
    }

    public w3(int i, int i2, int i3, int i4, float f, String str, int i5, String deviceType, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        this.deviceWidth = i;
        this.deviceHeight = i2;
        this.width = i3;
        this.height = i4;
        this.scale = f;
        this.dpi = str;
        this.ortbDeviceType = i5;
        this.deviceType = deviceType;
        this.packageName = str2;
        this.versionName = str3;
        this.isPortrait = z;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getDeviceWidth() {
        return this.deviceWidth;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getDeviceHeight() {
        return this.deviceHeight;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getDpi() {
        return this.dpi;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getOrtbDeviceType() {
        return this.ortbDeviceType;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    public /* synthetic */ w3(int i, int i2, int i3, int i4, float f, String str, int i5, String str2, String str3, String str4, boolean z, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) == 0 ? i4 : 0, (i6 & 16) != 0 ? 0.0f : f, (i6 & 32) != 0 ? "" : str, (i6 & 64) != 0 ? a4.f965a : i5, (i6 & 128) != 0 ? "phone" : str2, (i6 & 256) != 0 ? null : str3, (i6 & 512) == 0 ? str4 : null, (i6 & 1024) != 0 ? true : z);
    }
}
