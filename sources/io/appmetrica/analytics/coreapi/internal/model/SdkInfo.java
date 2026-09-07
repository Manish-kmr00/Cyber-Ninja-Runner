package io.appmetrica.analytics.coreapi.internal.model;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/model/SdkInfo;", "", "", "component1", "component2", "component3", "sdkVersionName", "sdkBuildNumber", "sdkBuildType", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSdkVersionName", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getSdkBuildNumber", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getSdkBuildType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
public final /* data */ class SdkInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sdkVersionName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String sdkBuildNumber;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String sdkBuildType;

    public SdkInfo(String str, String str2, String str3) {
        this.sdkVersionName = str;
        this.sdkBuildNumber = str2;
        this.sdkBuildType = str3;
    }

    public static /* synthetic */ SdkInfo copy$default(SdkInfo sdkInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sdkInfo.sdkVersionName;
        }
        if ((i & 2) != 0) {
            str2 = sdkInfo.sdkBuildNumber;
        }
        if ((i & 4) != 0) {
            str3 = sdkInfo.sdkBuildType;
        }
        return sdkInfo.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSdkVersionName() {
        return this.sdkVersionName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSdkBuildNumber() {
        return this.sdkBuildNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSdkBuildType() {
        return this.sdkBuildType;
    }

    public final SdkInfo copy(String sdkVersionName, String sdkBuildNumber, String sdkBuildType) {
        return new SdkInfo(sdkVersionName, sdkBuildNumber, sdkBuildType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkInfo)) {
            return false;
        }
        SdkInfo sdkInfo = (SdkInfo) other;
        return Intrinsics.areEqual(this.sdkVersionName, sdkInfo.sdkVersionName) && Intrinsics.areEqual(this.sdkBuildNumber, sdkInfo.sdkBuildNumber) && Intrinsics.areEqual(this.sdkBuildType, sdkInfo.sdkBuildType);
    }

    public final String getSdkBuildNumber() {
        return this.sdkBuildNumber;
    }

    public final String getSdkBuildType() {
        return this.sdkBuildType;
    }

    public final String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public int hashCode() {
        return this.sdkBuildType.hashCode() + ((this.sdkBuildNumber.hashCode() + (this.sdkVersionName.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "SdkInfo(sdkVersionName=" + this.sdkVersionName + ", sdkBuildNumber=" + this.sdkBuildNumber + ", sdkBuildType=" + this.sdkBuildType + ')';
    }
}
