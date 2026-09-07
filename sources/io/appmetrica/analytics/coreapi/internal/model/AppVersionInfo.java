package io.appmetrica.analytics.coreapi.internal.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/model/AppVersionInfo;", "", "", "component1", "component2", "appVersionName", "appBuildNumber", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getAppVersionName", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getAppBuildNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
public final /* data */ class AppVersionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String appVersionName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String appBuildNumber;

    public AppVersionInfo(String str, String str2) {
        this.appVersionName = str;
        this.appBuildNumber = str2;
    }

    public static /* synthetic */ AppVersionInfo copy$default(AppVersionInfo appVersionInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appVersionInfo.appVersionName;
        }
        if ((i & 2) != 0) {
            str2 = appVersionInfo.appBuildNumber;
        }
        return appVersionInfo.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppBuildNumber() {
        return this.appBuildNumber;
    }

    public final AppVersionInfo copy(String appVersionName, String appBuildNumber) {
        return new AppVersionInfo(appVersionName, appBuildNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionInfo)) {
            return false;
        }
        AppVersionInfo appVersionInfo = (AppVersionInfo) other;
        return Intrinsics.areEqual(this.appVersionName, appVersionInfo.appVersionName) && Intrinsics.areEqual(this.appBuildNumber, appVersionInfo.appBuildNumber);
    }

    public final String getAppBuildNumber() {
        return this.appBuildNumber;
    }

    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public int hashCode() {
        return this.appBuildNumber.hashCode() + (this.appVersionName.hashCode() * 31);
    }

    public String toString() {
        return "AppVersionInfo(appVersionName=" + this.appVersionName + ", appBuildNumber=" + this.appBuildNumber + ')';
    }
}
