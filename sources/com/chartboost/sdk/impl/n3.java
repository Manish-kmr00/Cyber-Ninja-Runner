package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/n3;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "configVariant", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", "webViewEnabled", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getWebViewVersion", "webViewVersion", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String configVariant;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean webViewEnabled;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String webViewVersion;

    public n3(String str, boolean z, String webViewVersion) {
        Intrinsics.checkNotNullParameter(webViewVersion, "webViewVersion");
        this.configVariant = str;
        this.webViewEnabled = z;
        this.webViewVersion = webViewVersion;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) other;
        return Intrinsics.areEqual(this.configVariant, n3Var.configVariant) && this.webViewEnabled == n3Var.webViewEnabled && Intrinsics.areEqual(this.webViewVersion, n3Var.webViewVersion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        String str = this.configVariant;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.webViewEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.webViewVersion.hashCode();
    }

    public String toString() {
        return "ConfigurationBodyFields(configVariant=" + this.configVariant + ", webViewEnabled=" + this.webViewEnabled + ", webViewVersion=" + this.webViewVersion + ')';
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getConfigVariant() {
        return this.configVariant;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getWebViewEnabled() {
        return this.webViewEnabled;
    }
}
