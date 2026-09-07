package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\f\u0010\u0007\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u001c\u0010\u001aR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b&\u0010\u001aR*\u0010.\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010*\u001a\u0004\b\u001f\u0010+\"\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/chartboost/sdk/impl/n7;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "g", "()Z", "setEnabled", "(Z)V", "isEnabled", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", "setVerificationEnabled", "verificationEnabled", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "I", "setMinVisibleDips", "(I)V", "minVisibleDips", "setMinVisibleDurationMs", "minVisibleDurationMs", "", "e", "J", InneractiveMediationDefs.GENDER_FEMALE, "()J", "setVisibilityCheckIntervalMs", "(J)V", "visibilityCheckIntervalMs", "setTraversalLimit", "traversalLimit", "", "Lcom/chartboost/sdk/impl/eb;", "Ljava/util/List;", "()Ljava/util/List;", "setVerificationList", "(Ljava/util/List;)V", "verificationList", "<init>", "(ZZIIJILjava/util/List;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class n7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean isEnabled;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public boolean verificationEnabled;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int minVisibleDips;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int minVisibleDurationMs;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public long visibilityCheckIntervalMs;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int traversalLimit;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public List<eb> verificationList;

    public n7() {
        this(false, false, 0, 0, 0L, 0, null, 127, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof n7)) {
            return false;
        }
        n7 n7Var = (n7) other;
        return this.isEnabled == n7Var.isEnabled && this.verificationEnabled == n7Var.verificationEnabled && this.minVisibleDips == n7Var.minVisibleDips && this.minVisibleDurationMs == n7Var.minVisibleDurationMs && this.visibilityCheckIntervalMs == n7Var.visibilityCheckIntervalMs && this.traversalLimit == n7Var.traversalLimit && Intrinsics.areEqual(this.verificationList, n7Var.verificationList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    public int hashCode() {
        boolean z = this.isEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.verificationEnabled;
        int iHashCode = (((((((((i + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.minVisibleDips)) * 31) + Integer.hashCode(this.minVisibleDurationMs)) * 31) + Long.hashCode(this.visibilityCheckIntervalMs)) * 31) + Integer.hashCode(this.traversalLimit)) * 31;
        List<eb> list = this.verificationList;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "OmSdkModel(isEnabled=" + this.isEnabled + ", verificationEnabled=" + this.verificationEnabled + ", minVisibleDips=" + this.minVisibleDips + ", minVisibleDurationMs=" + this.minVisibleDurationMs + ", visibilityCheckIntervalMs=" + this.visibilityCheckIntervalMs + ", traversalLimit=" + this.traversalLimit + ", verificationList=" + this.verificationList + ')';
    }

    public n7(boolean z, boolean z2, int i, int i2, long j, int i3, List<eb> list) {
        this.isEnabled = z;
        this.verificationEnabled = z2;
        this.minVisibleDips = i;
        this.minVisibleDurationMs = i2;
        this.visibilityCheckIntervalMs = j;
        this.traversalLimit = i3;
        this.verificationList = list;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getVerificationEnabled() {
        return this.verificationEnabled;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getMinVisibleDips() {
        return this.minVisibleDips;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getMinVisibleDurationMs() {
        return this.minVisibleDurationMs;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getVisibilityCheckIntervalMs() {
        return this.visibilityCheckIntervalMs;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getTraversalLimit() {
        return this.traversalLimit;
    }

    public final List<eb> e() {
        return this.verificationList;
    }

    public /* synthetic */ n7(boolean z, boolean z2, int i, int i2, long j, int i3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? false : z2, (i4 & 4) != 0 ? 1 : i, (i4 & 8) == 0 ? i2 : 0, (i4 & 16) != 0 ? 100L : j, (i4 & 32) != 0 ? 25 : i3, (i4 & 64) != 0 ? null : list);
    }
}
