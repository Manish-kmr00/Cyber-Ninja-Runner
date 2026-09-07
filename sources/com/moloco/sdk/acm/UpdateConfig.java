package com.moloco.sdk.acm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/moloco/sdk/acm/UpdateConfig;", "", "postAnalyticsUrl", "", "requestPeriodSeconds", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getPostAnalyticsUrl", "()Ljava/lang/String;", "getRequestPeriodSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/moloco/sdk/acm/UpdateConfig;", "equals", "", "other", "hashCode", "", "toString", "moloco-android-client-metrics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UpdateConfig {
    private final String postAnalyticsUrl;
    private final Long requestPeriodSeconds;

    public UpdateConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UpdateConfig copy$default(UpdateConfig updateConfig, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateConfig.postAnalyticsUrl;
        }
        if ((i & 2) != 0) {
            l = updateConfig.requestPeriodSeconds;
        }
        return updateConfig.copy(str, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPostAnalyticsUrl() {
        return this.postAnalyticsUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getRequestPeriodSeconds() {
        return this.requestPeriodSeconds;
    }

    public final UpdateConfig copy(String postAnalyticsUrl, Long requestPeriodSeconds) {
        return new UpdateConfig(postAnalyticsUrl, requestPeriodSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateConfig)) {
            return false;
        }
        UpdateConfig updateConfig = (UpdateConfig) other;
        return Intrinsics.areEqual(this.postAnalyticsUrl, updateConfig.postAnalyticsUrl) && Intrinsics.areEqual(this.requestPeriodSeconds, updateConfig.requestPeriodSeconds);
    }

    public final String getPostAnalyticsUrl() {
        return this.postAnalyticsUrl;
    }

    public final Long getRequestPeriodSeconds() {
        return this.requestPeriodSeconds;
    }

    public int hashCode() {
        String str = this.postAnalyticsUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.requestPeriodSeconds;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "UpdateConfig(postAnalyticsUrl=" + this.postAnalyticsUrl + ", requestPeriodSeconds=" + this.requestPeriodSeconds + ')';
    }

    public UpdateConfig(String str, Long l) {
        this.postAnalyticsUrl = str;
        this.requestPeriodSeconds = l;
    }

    public /* synthetic */ UpdateConfig(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
    }
}
