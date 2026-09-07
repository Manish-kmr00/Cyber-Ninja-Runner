package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\r\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/w;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Landroid/view/ViewGroup;", "bannerView", "I", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "bannerWidth", "bannerHeight", "<init>", "(Landroid/view/ViewGroup;II)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ViewGroup bannerView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int bannerWidth;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int bannerHeight;

    public w(ViewGroup bannerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        this.bannerView = bannerView;
        this.bannerWidth = i;
        this.bannerHeight = i2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof w)) {
            return false;
        }
        w wVar = (w) other;
        return Intrinsics.areEqual(this.bannerView, wVar.bannerView) && this.bannerWidth == wVar.bannerWidth && this.bannerHeight == wVar.bannerHeight;
    }

    public int hashCode() {
        return (((this.bannerView.hashCode() * 31) + Integer.hashCode(this.bannerWidth)) * 31) + Integer.hashCode(this.bannerHeight);
    }

    public String toString() {
        return "AdUnitBannerData(bannerView=" + this.bannerView + ", bannerWidth=" + this.bannerWidth + ", bannerHeight=" + this.bannerHeight + ')';
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ViewGroup getBannerView() {
        return this.bannerView;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getBannerWidth() {
        return this.bannerWidth;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBannerHeight() {
        return this.bannerHeight;
    }
}
