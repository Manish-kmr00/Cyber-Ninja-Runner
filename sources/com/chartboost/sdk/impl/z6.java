package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e¨\u0006\""}, d2 = {"Lcom/chartboost/sdk/impl/z6;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/y0;", "a", "Lcom/chartboost/sdk/impl/y0;", "()Lcom/chartboost/sdk/impl/y0;", "appRequest", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "e", "()Z", "isCacheRequest", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "bannerHeight", "d", "bannerWidth", "Lcom/chartboost/sdk/impl/b0;", "Lcom/chartboost/sdk/impl/b0;", "()Lcom/chartboost/sdk/impl/b0;", "interceptor", "<init>", "(Lcom/chartboost/sdk/impl/y0;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y0 appRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean isCacheRequest;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Integer bannerHeight;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer bannerWidth;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final b0 interceptor;

    public z6(y0 appRequest, boolean z, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        this.appRequest = appRequest;
        this.isCacheRequest = z;
        this.bannerHeight = num;
        this.bannerWidth = num2;
        this.interceptor = new b0();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof z6)) {
            return false;
        }
        z6 z6Var = (z6) other;
        return Intrinsics.areEqual(this.appRequest, z6Var.appRequest) && this.isCacheRequest == z6Var.isCacheRequest && Intrinsics.areEqual(this.bannerHeight, z6Var.bannerHeight) && Intrinsics.areEqual(this.bannerWidth, z6Var.bannerWidth);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int iHashCode = this.appRequest.hashCode() * 31;
        boolean z = this.isCacheRequest;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        Integer num = this.bannerHeight;
        int iHashCode2 = (i + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.bannerWidth;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "LoadParams(appRequest=" + this.appRequest + ", isCacheRequest=" + this.isCacheRequest + ", bannerHeight=" + this.bannerHeight + ", bannerWidth=" + this.bannerWidth + ')';
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final y0 getAppRequest() {
        return this.appRequest;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getIsCacheRequest() {
        return this.isCacheRequest;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getBannerHeight() {
        return this.bannerHeight;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Integer getBannerWidth() {
        return this.bannerWidth;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final b0 getInterceptor() {
        return this.interceptor;
    }
}
