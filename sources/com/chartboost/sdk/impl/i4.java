package com.chartboost.sdk.impl;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b;\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0005\u0012\b\b\u0002\u0010?\u001a\u00020\t\u0012\b\b\u0002\u0010A\u001a\u00020\u0005\u0012\b\b\u0002\u0010C\u001a\u00020\t\u0012\b\b\u0002\u0010D\u001a\u00020\u0005\u0012\b\b\u0002\u0010H\u001a\u00020E\u0012\b\b\u0002\u0010J\u001a\u00020E\u0012\b\b\u0002\u0010L\u001a\u00020\u0005\u0012\b\b\u0002\u0010O\u001a\u00020\u0005\u0012\b\b\u0002\u0010P\u001a\u00020\u0005\u0012\b\b\u0002\u0010Q\u001a\u00020E\u0012\b\b\u0002\u0010S\u001a\u00020E¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\u001b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\u001f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u0017\u0010$\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b\u0016\u0010\u0004R\u0017\u0010&\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b\u001c\u0010\u0004R\u0017\u0010)\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u0004R\u0017\u0010,\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u0004R\u0017\u0010.\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b-\u0010\u0004R\u0017\u00101\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b0\u0010\u0004R\u0017\u00104\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u0004R\u0017\u00105\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b*\u0010\u0004R\u0017\u00106\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b/\u0010\u0004R\u0017\u00109\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b7\u0010\r\u001a\u0004\b8\u0010\u0004R\u0017\u0010;\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b'\u0010\u0004R\u0017\u0010<\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b0\u0010\r\u001a\u0004\b:\u0010\u0004R\u0017\u0010=\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b#\u0010\u0007R\u0017\u0010?\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b>\u0010\u001d\u001a\u0004\b%\u0010\u001eR\u0017\u0010A\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b@\u0010\u0007R\u0017\u0010C\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\bB\u0010\u001d\u001a\u0004\b7\u0010\u001eR\u0017\u0010D\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\b!\u0010\u0007R\u0017\u0010H\u001a\u00020E8\u0006¢\u0006\f\n\u0004\b\u0012\u0010F\u001a\u0004\b>\u0010GR\u0017\u0010J\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bI\u0010F\u001a\u0004\b2\u0010GR\u0017\u0010L\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\bK\u0010\u0007R\u0017\u0010O\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bM\u0010\u0011\u001a\u0004\bN\u0010\u0007R\u0017\u0010P\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bK\u0010\u0011\u001a\u0004\bM\u0010\u0007R\u0017\u0010Q\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bN\u0010F\u001a\u0004\bI\u0010GR\u0017\u0010S\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bR\u0010F\u001a\u0004\bB\u0010G¨\u0006V"}, d2 = {"Lcom/chartboost/sdk/impl/i4;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "B", JsonStorageKeyNames.SESSION_ID_KEY, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "z", "sessionCount", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, RemoteConfigConstants.RequestFieldKey.APP_ID, "d", "getAppVersion", "appVersion", "e", "g", "chartboostSdkVersion", InneractiveMediationDefs.GENDER_FEMALE, "Z", "()Z", "chartboostSdkAutocacheEnabled", "chartboostSdkGdpr", "h", "chartboostSdkCcpa", "i", "chartboostSdkCoppa", "j", "chartboostSdkLgpd", CampaignEx.JSON_KEY_AD_K, "m", "deviceId", "l", "p", "deviceMake", CampaignEx.JSON_KEY_AD_Q, com.ironsource.b9.i.l, "n", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "deviceOsVersion", "o", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "devicePlatform", "deviceCountry", com.ironsource.b9.i.x, "r", "w", "deviceTimezone", "s", "deviceConnectionType", com.ironsource.b9.i.A, "deviceBatteryLevel", "v", "deviceChargingStatus", VastAttributes.VERTICAL_POSITION, com.ironsource.b9.i.P, VastAttributes.HORIZONTAL_POSITION, "deviceMute", "deviceAudioOutput", "", "J", "()J", "deviceStorage", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "deviceLowMemoryWarning", "D", "sessionImpressionInterstitialCount", "C", ExifInterface.LONGITUDE_EAST, "sessionImpressionRewardedCount", "sessionImpressionBannerCount", "sessionDuration", "F", "deviceUpTime", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIZIJJIIIJJ)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class i4 {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final long deviceLowMemoryWarning;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final int sessionImpressionInterstitialCount;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final int sessionImpressionRewardedCount;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public final int sessionImpressionBannerCount;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public final long sessionDuration;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public final long deviceUpTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String sessionId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int sessionCount;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String appId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String appVersion;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String chartboostSdkVersion;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final boolean chartboostSdkAutocacheEnabled;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final String chartboostSdkGdpr;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final String chartboostSdkCcpa;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final String chartboostSdkCoppa;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final String chartboostSdkLgpd;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String deviceId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String deviceMake;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final String deviceModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final String deviceOsVersion;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final String devicePlatform;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final String deviceCountry;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final String deviceLanguage;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final String deviceTimezone;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final String deviceConnectionType;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final String deviceOrientation;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final int deviceBatteryLevel;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final boolean deviceChargingStatus;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final int deviceVolume;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public final boolean deviceMute;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public final int deviceAudioOutput;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final long deviceStorage;

    public i4() {
        this(null, 0, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 0, false, 0, 0L, 0L, 0, 0, 0, 0L, 0L, -1, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof i4)) {
            return false;
        }
        i4 i4Var = (i4) other;
        return Intrinsics.areEqual(this.sessionId, i4Var.sessionId) && this.sessionCount == i4Var.sessionCount && Intrinsics.areEqual(this.appId, i4Var.appId) && Intrinsics.areEqual(this.appVersion, i4Var.appVersion) && Intrinsics.areEqual(this.chartboostSdkVersion, i4Var.chartboostSdkVersion) && this.chartboostSdkAutocacheEnabled == i4Var.chartboostSdkAutocacheEnabled && Intrinsics.areEqual(this.chartboostSdkGdpr, i4Var.chartboostSdkGdpr) && Intrinsics.areEqual(this.chartboostSdkCcpa, i4Var.chartboostSdkCcpa) && Intrinsics.areEqual(this.chartboostSdkCoppa, i4Var.chartboostSdkCoppa) && Intrinsics.areEqual(this.chartboostSdkLgpd, i4Var.chartboostSdkLgpd) && Intrinsics.areEqual(this.deviceId, i4Var.deviceId) && Intrinsics.areEqual(this.deviceMake, i4Var.deviceMake) && Intrinsics.areEqual(this.deviceModel, i4Var.deviceModel) && Intrinsics.areEqual(this.deviceOsVersion, i4Var.deviceOsVersion) && Intrinsics.areEqual(this.devicePlatform, i4Var.devicePlatform) && Intrinsics.areEqual(this.deviceCountry, i4Var.deviceCountry) && Intrinsics.areEqual(this.deviceLanguage, i4Var.deviceLanguage) && Intrinsics.areEqual(this.deviceTimezone, i4Var.deviceTimezone) && Intrinsics.areEqual(this.deviceConnectionType, i4Var.deviceConnectionType) && Intrinsics.areEqual(this.deviceOrientation, i4Var.deviceOrientation) && this.deviceBatteryLevel == i4Var.deviceBatteryLevel && this.deviceChargingStatus == i4Var.deviceChargingStatus && this.deviceVolume == i4Var.deviceVolume && this.deviceMute == i4Var.deviceMute && this.deviceAudioOutput == i4Var.deviceAudioOutput && this.deviceStorage == i4Var.deviceStorage && this.deviceLowMemoryWarning == i4Var.deviceLowMemoryWarning && this.sessionImpressionInterstitialCount == i4Var.sessionImpressionInterstitialCount && this.sessionImpressionRewardedCount == i4Var.sessionImpressionRewardedCount && this.sessionImpressionBannerCount == i4Var.sessionImpressionBannerCount && this.sessionDuration == i4Var.sessionDuration && this.deviceUpTime == i4Var.deviceUpTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v43, types: [int] */
    /* JADX WARN: Type inference failed for: r0v47, types: [int] */
    /* JADX WARN: Type inference failed for: r1v41, types: [int] */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.sessionId.hashCode() * 31) + Integer.hashCode(this.sessionCount)) * 31) + this.appId.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.chartboostSdkVersion.hashCode()) * 31;
        boolean z = this.chartboostSdkAutocacheEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((((((((((((((((((((((iHashCode + r1) * 31) + this.chartboostSdkGdpr.hashCode()) * 31) + this.chartboostSdkCcpa.hashCode()) * 31) + this.chartboostSdkCoppa.hashCode()) * 31) + this.chartboostSdkLgpd.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.deviceMake.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.deviceOsVersion.hashCode()) * 31) + this.devicePlatform.hashCode()) * 31) + this.deviceCountry.hashCode()) * 31) + this.deviceLanguage.hashCode()) * 31) + this.deviceTimezone.hashCode()) * 31) + this.deviceConnectionType.hashCode()) * 31) + this.deviceOrientation.hashCode()) * 31) + Integer.hashCode(this.deviceBatteryLevel)) * 31;
        boolean z2 = this.deviceChargingStatus;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r2) * 31) + Integer.hashCode(this.deviceVolume)) * 31;
        boolean z3 = this.deviceMute;
        return ((((((((((((((((iHashCode3 + (z3 ? 1 : z3)) * 31) + Integer.hashCode(this.deviceAudioOutput)) * 31) + Long.hashCode(this.deviceStorage)) * 31) + Long.hashCode(this.deviceLowMemoryWarning)) * 31) + Integer.hashCode(this.sessionImpressionInterstitialCount)) * 31) + Integer.hashCode(this.sessionImpressionRewardedCount)) * 31) + Integer.hashCode(this.sessionImpressionBannerCount)) * 31) + Long.hashCode(this.sessionDuration)) * 31) + Long.hashCode(this.deviceUpTime);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EnvironmentData(sessionId=");
        sb.append(this.sessionId).append(", sessionCount=").append(this.sessionCount).append(", appId=").append(this.appId).append(", appVersion=").append(this.appVersion).append(", chartboostSdkVersion=").append(this.chartboostSdkVersion).append(", chartboostSdkAutocacheEnabled=").append(this.chartboostSdkAutocacheEnabled).append(", chartboostSdkGdpr=").append(this.chartboostSdkGdpr).append(", chartboostSdkCcpa=").append(this.chartboostSdkCcpa).append(", chartboostSdkCoppa=").append(this.chartboostSdkCoppa).append(", chartboostSdkLgpd=").append(this.chartboostSdkLgpd).append(", deviceId=").append(this.deviceId).append(", deviceMake=");
        sb.append(this.deviceMake).append(", deviceModel=").append(this.deviceModel).append(", deviceOsVersion=").append(this.deviceOsVersion).append(", devicePlatform=").append(this.devicePlatform).append(", deviceCountry=").append(this.deviceCountry).append(", deviceLanguage=").append(this.deviceLanguage).append(", deviceTimezone=").append(this.deviceTimezone).append(", deviceConnectionType=").append(this.deviceConnectionType).append(", deviceOrientation=").append(this.deviceOrientation).append(", deviceBatteryLevel=").append(this.deviceBatteryLevel).append(", deviceChargingStatus=").append(this.deviceChargingStatus).append(", deviceVolume=").append(this.deviceVolume);
        sb.append(", deviceMute=").append(this.deviceMute).append(", deviceAudioOutput=").append(this.deviceAudioOutput).append(", deviceStorage=").append(this.deviceStorage).append(", deviceLowMemoryWarning=").append(this.deviceLowMemoryWarning).append(", sessionImpressionInterstitialCount=").append(this.sessionImpressionInterstitialCount).append(", sessionImpressionRewardedCount=").append(this.sessionImpressionRewardedCount).append(", sessionImpressionBannerCount=").append(this.sessionImpressionBannerCount).append(", sessionDuration=").append(this.sessionDuration).append(", deviceUpTime=").append(this.deviceUpTime).append(')');
        return sb.toString();
    }

    public i4(String sessionId, int i, String appId, String appVersion, String chartboostSdkVersion, boolean z, String chartboostSdkGdpr, String chartboostSdkCcpa, String chartboostSdkCoppa, String chartboostSdkLgpd, String deviceId, String deviceMake, String deviceModel, String deviceOsVersion, String devicePlatform, String deviceCountry, String deviceLanguage, String deviceTimezone, String deviceConnectionType, String deviceOrientation, int i2, boolean z2, int i3, boolean z3, int i4, long j, long j2, int i5, int i6, int i7, long j3, long j4) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(chartboostSdkVersion, "chartboostSdkVersion");
        Intrinsics.checkNotNullParameter(chartboostSdkGdpr, "chartboostSdkGdpr");
        Intrinsics.checkNotNullParameter(chartboostSdkCcpa, "chartboostSdkCcpa");
        Intrinsics.checkNotNullParameter(chartboostSdkCoppa, "chartboostSdkCoppa");
        Intrinsics.checkNotNullParameter(chartboostSdkLgpd, "chartboostSdkLgpd");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceMake, "deviceMake");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceOsVersion, "deviceOsVersion");
        Intrinsics.checkNotNullParameter(devicePlatform, "devicePlatform");
        Intrinsics.checkNotNullParameter(deviceCountry, "deviceCountry");
        Intrinsics.checkNotNullParameter(deviceLanguage, "deviceLanguage");
        Intrinsics.checkNotNullParameter(deviceTimezone, "deviceTimezone");
        Intrinsics.checkNotNullParameter(deviceConnectionType, "deviceConnectionType");
        Intrinsics.checkNotNullParameter(deviceOrientation, "deviceOrientation");
        this.sessionId = sessionId;
        this.sessionCount = i;
        this.appId = appId;
        this.appVersion = appVersion;
        this.chartboostSdkVersion = chartboostSdkVersion;
        this.chartboostSdkAutocacheEnabled = z;
        this.chartboostSdkGdpr = chartboostSdkGdpr;
        this.chartboostSdkCcpa = chartboostSdkCcpa;
        this.chartboostSdkCoppa = chartboostSdkCoppa;
        this.chartboostSdkLgpd = chartboostSdkLgpd;
        this.deviceId = deviceId;
        this.deviceMake = deviceMake;
        this.deviceModel = deviceModel;
        this.deviceOsVersion = deviceOsVersion;
        this.devicePlatform = devicePlatform;
        this.deviceCountry = deviceCountry;
        this.deviceLanguage = deviceLanguage;
        this.deviceTimezone = deviceTimezone;
        this.deviceConnectionType = deviceConnectionType;
        this.deviceOrientation = deviceOrientation;
        this.deviceBatteryLevel = i2;
        this.deviceChargingStatus = z2;
        this.deviceVolume = i3;
        this.deviceMute = z3;
        this.deviceAudioOutput = i4;
        this.deviceStorage = j;
        this.deviceLowMemoryWarning = j2;
        this.sessionImpressionInterstitialCount = i5;
        this.sessionImpressionRewardedCount = i6;
        this.sessionImpressionBannerCount = i7;
        this.sessionDuration = j3;
        this.deviceUpTime = j4;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final int getSessionCount() {
        return this.sessionCount;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getChartboostSdkVersion() {
        return this.chartboostSdkVersion;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getChartboostSdkAutocacheEnabled() {
        return this.chartboostSdkAutocacheEnabled;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getChartboostSdkGdpr() {
        return this.chartboostSdkGdpr;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getChartboostSdkCcpa() {
        return this.chartboostSdkCcpa;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getChartboostSdkCoppa() {
        return this.chartboostSdkCoppa;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getChartboostSdkLgpd() {
        return this.chartboostSdkLgpd;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getDeviceMake() {
        return this.deviceMake;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getDeviceCountry() {
        return this.deviceCountry;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final String getDeviceTimezone() {
        return this.deviceTimezone;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getDeviceConnectionType() {
        return this.deviceConnectionType;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final String getDeviceOrientation() {
        return this.deviceOrientation;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getDeviceBatteryLevel() {
        return this.deviceBatteryLevel;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getDeviceChargingStatus() {
        return this.deviceChargingStatus;
    }

    /* JADX INFO: renamed from: y, reason: from getter */
    public final int getDeviceVolume() {
        return this.deviceVolume;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final boolean getDeviceMute() {
        return this.deviceMute;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final int getDeviceAudioOutput() {
        return this.deviceAudioOutput;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final long getDeviceStorage() {
        return this.deviceStorage;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final long getDeviceLowMemoryWarning() {
        return this.deviceLowMemoryWarning;
    }

    /* JADX INFO: renamed from: D, reason: from getter */
    public final int getSessionImpressionInterstitialCount() {
        return this.sessionImpressionInterstitialCount;
    }

    /* JADX INFO: renamed from: E, reason: from getter */
    public final int getSessionImpressionRewardedCount() {
        return this.sessionImpressionRewardedCount;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final int getSessionImpressionBannerCount() {
        return this.sessionImpressionBannerCount;
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final long getDeviceUpTime() {
        return this.deviceUpTime;
    }

    public /* synthetic */ i4(String str, int i, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i2, boolean z2, int i3, boolean z3, int i4, long j, long j2, int i5, int i6, int i7, long j3, long j4, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "not available" : str, (i8 & 2) != 0 ? 0 : i, (i8 & 4) != 0 ? "not available" : str2, (i8 & 8) != 0 ? "not available" : str3, (i8 & 16) != 0 ? "not available" : str4, (i8 & 32) != 0 ? false : z, (i8 & 64) != 0 ? "not available" : str5, (i8 & 128) != 0 ? "not available" : str6, (i8 & 256) != 0 ? "not available" : str7, (i8 & 512) != 0 ? "not available" : str8, (i8 & 1024) != 0 ? "not available" : str9, (i8 & 2048) != 0 ? "not available" : str10, (i8 & 4096) != 0 ? "not available" : str11, (i8 & 8192) != 0 ? "not available" : str12, (i8 & 16384) != 0 ? "not available" : str13, (i8 & 32768) != 0 ? "not available" : str14, (i8 & 65536) != 0 ? "not available" : str15, (i8 & 131072) != 0 ? "not available" : str16, (i8 & 262144) != 0 ? "not available" : str17, (i8 & 524288) != 0 ? "not available" : str18, (i8 & 1048576) != 0 ? 0 : i2, (i8 & 2097152) != 0 ? false : z2, (i8 & 4194304) != 0 ? 0 : i3, (i8 & 8388608) != 0 ? false : z3, (i8 & 16777216) != 0 ? 0 : i4, (i8 & 33554432) != 0 ? 0L : j, (i8 & 67108864) != 0 ? 0L : j2, (i8 & 134217728) != 0 ? 0 : i5, (i8 & 268435456) != 0 ? 0 : i6, (i8 & 536870912) != 0 ? 0 : i7, (i8 & 1073741824) == 0 ? j3 : 0L, (i8 & Integer.MIN_VALUE) != 0 ? SystemClock.uptimeMillis() : j4);
    }
}
