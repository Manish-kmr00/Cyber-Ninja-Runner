package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\b\b\u0002\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\f\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u001c\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u001f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0007R\u0017\u0010 \u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010!\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0007¨\u0006$"}, d2 = {"Lcom/chartboost/sdk/impl/ia;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "g", "()Z", "isEnabled", "", "Lcom/chartboost/sdk/impl/ma;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "()Ljava/util/List;", "blackList", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", com.json.cc.r, "d", "I", "eventLimit", "e", InneractiveMediationDefs.GENDER_FEMALE, "windowDuration", "persistenceEnabled", "persistenceMaxEvents", "<init>", "(ZLjava/util/List;Ljava/lang/String;IIZI)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isEnabled;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final List<ma> blackList;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String endpoint;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int eventLimit;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int windowDuration;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final boolean persistenceEnabled;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final int persistenceMaxEvents;

    public ia() {
        this(false, null, null, 0, 0, false, 0, 127, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ia)) {
            return false;
        }
        ia iaVar = (ia) other;
        return this.isEnabled == iaVar.isEnabled && Intrinsics.areEqual(this.blackList, iaVar.blackList) && Intrinsics.areEqual(this.endpoint, iaVar.endpoint) && this.eventLimit == iaVar.eventLimit && this.windowDuration == iaVar.windowDuration && this.persistenceEnabled == iaVar.persistenceEnabled && this.persistenceMaxEvents == iaVar.persistenceMaxEvents;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.isEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((((((r0 * 31) + this.blackList.hashCode()) * 31) + this.endpoint.hashCode()) * 31) + Integer.hashCode(this.eventLimit)) * 31) + Integer.hashCode(this.windowDuration)) * 31;
        boolean z2 = this.persistenceEnabled;
        return ((iHashCode + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.persistenceMaxEvents);
    }

    public String toString() {
        return "TrackingConfig(isEnabled=" + this.isEnabled + ", blackList=" + this.blackList + ", endpoint=" + this.endpoint + ", eventLimit=" + this.eventLimit + ", windowDuration=" + this.windowDuration + ", persistenceEnabled=" + this.persistenceEnabled + ", persistenceMaxEvents=" + this.persistenceMaxEvents + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ia(boolean z, List<? extends ma> blackList, String endpoint, int i, int i2, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        this.isEnabled = z;
        this.blackList = blackList;
        this.endpoint = endpoint;
        this.eventLimit = i;
        this.windowDuration = i2;
        this.persistenceEnabled = z2;
        this.persistenceMaxEvents = i3;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final List<ma> a() {
        return this.blackList;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getEventLimit() {
        return this.eventLimit;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getWindowDuration() {
        return this.windowDuration;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getPersistenceMaxEvents() {
        return this.persistenceMaxEvents;
    }

    public /* synthetic */ ia(boolean z, List list, String str, int i, int i2, boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? ja.a() : list, (i4 & 4) != 0 ? "https://ssp-events.chartboost.com/track/sdk" : str, (i4 & 8) != 0 ? 10 : i, (i4 & 16) != 0 ? 60 : i2, (i4 & 32) != 0 ? true : z2, (i4 & 64) != 0 ? 100 : i3);
    }
}
