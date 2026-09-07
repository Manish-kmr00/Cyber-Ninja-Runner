package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\f\u0010\u0007\"\u0004\b\f\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0011\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/d6;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "d", "(I)V", "onVideoCompletedPlayCount", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "onRewardedVideoCompletedPlayCount", "impressionNotifyDidCompleteAdPlayCount", "impressionSendVideoCompleteRequestPlayCount", "<init>", "(IIII)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int onVideoCompletedPlayCount;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int onRewardedVideoCompletedPlayCount;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int impressionNotifyDidCompleteAdPlayCount;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int impressionSendVideoCompleteRequestPlayCount;

    public d6() {
        this(0, 0, 0, 0, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d6)) {
            return false;
        }
        d6 d6Var = (d6) other;
        return this.onVideoCompletedPlayCount == d6Var.onVideoCompletedPlayCount && this.onRewardedVideoCompletedPlayCount == d6Var.onRewardedVideoCompletedPlayCount && this.impressionNotifyDidCompleteAdPlayCount == d6Var.impressionNotifyDidCompleteAdPlayCount && this.impressionSendVideoCompleteRequestPlayCount == d6Var.impressionSendVideoCompleteRequestPlayCount;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.onVideoCompletedPlayCount) * 31) + Integer.hashCode(this.onRewardedVideoCompletedPlayCount)) * 31) + Integer.hashCode(this.impressionNotifyDidCompleteAdPlayCount)) * 31) + Integer.hashCode(this.impressionSendVideoCompleteRequestPlayCount);
    }

    public String toString() {
        return "ImpressionCounter(onVideoCompletedPlayCount=" + this.onVideoCompletedPlayCount + ", onRewardedVideoCompletedPlayCount=" + this.onRewardedVideoCompletedPlayCount + ", impressionNotifyDidCompleteAdPlayCount=" + this.impressionNotifyDidCompleteAdPlayCount + ", impressionSendVideoCompleteRequestPlayCount=" + this.impressionSendVideoCompleteRequestPlayCount + ')';
    }

    public d6(int i, int i2, int i3, int i4) {
        this.onVideoCompletedPlayCount = i;
        this.onRewardedVideoCompletedPlayCount = i2;
        this.impressionNotifyDidCompleteAdPlayCount = i3;
        this.impressionSendVideoCompleteRequestPlayCount = i4;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getOnVideoCompletedPlayCount() {
        return this.onVideoCompletedPlayCount;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getOnRewardedVideoCompletedPlayCount() {
        return this.onRewardedVideoCompletedPlayCount;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getImpressionNotifyDidCompleteAdPlayCount() {
        return this.impressionNotifyDidCompleteAdPlayCount;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getImpressionSendVideoCompleteRequestPlayCount() {
        return this.impressionSendVideoCompleteRequestPlayCount;
    }

    public final void d(int i) {
        this.onVideoCompletedPlayCount = i;
    }

    public final void c(int i) {
        this.onRewardedVideoCompletedPlayCount = i;
    }

    public /* synthetic */ d6(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 1 : i, (i5 & 2) != 0 ? 1 : i2, (i5 & 4) != 0 ? 1 : i3, (i5 & 8) != 0 ? 1 : i4);
    }

    public final void a(int i) {
        this.impressionNotifyDidCompleteAdPlayCount = i;
    }

    public final void b(int i) {
        this.impressionSendVideoCompleteRequestPlayCount = i;
    }
}
