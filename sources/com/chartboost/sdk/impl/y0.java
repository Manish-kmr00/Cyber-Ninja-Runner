package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\f\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\f\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\f\u0010\u001f\"\u0004\b\f\u0010 R\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\f\u0010&R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b\u001d\u0010%\"\u0004\b\u0010\u0010&¨\u0006+"}, d2 = {"Lcom/chartboost/sdk/impl/y0;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getId", "id", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "d", "location", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)V", "bidResponse", "Lcom/chartboost/sdk/impl/w;", "Lcom/chartboost/sdk/impl/w;", "()Lcom/chartboost/sdk/impl/w;", "(Lcom/chartboost/sdk/impl/w;)V", "bannerData", "Lcom/chartboost/sdk/impl/v;", "e", "Lcom/chartboost/sdk/impl/v;", "()Lcom/chartboost/sdk/impl/v;", "(Lcom/chartboost/sdk/impl/v;)V", "adUnit", InneractiveMediationDefs.GENDER_FEMALE, "Z", "isTrackedCache", "()Z", "(Z)V", "g", "isTrackedShow", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/w;Lcom/chartboost/sdk/impl/v;ZZ)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public String bidResponse;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public w bannerData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public v adUnit;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean isTrackedCache;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean isTrackedShow;

    public y0(int i, String location, String str, w wVar, v vVar, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.id = i;
        this.location = location;
        this.bidResponse = str;
        this.bannerData = wVar;
        this.adUnit = vVar;
        this.isTrackedCache = z;
        this.isTrackedShow = z2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) other;
        return this.id == y0Var.id && Intrinsics.areEqual(this.location, y0Var.location) && Intrinsics.areEqual(this.bidResponse, y0Var.bidResponse) && Intrinsics.areEqual(this.bannerData, y0Var.bannerData) && Intrinsics.areEqual(this.adUnit, y0Var.adUnit) && this.isTrackedCache == y0Var.isTrackedCache && this.isTrackedShow == y0Var.isTrackedShow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.location.hashCode()) * 31;
        String str = this.bidResponse;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        w wVar = this.bannerData;
        int iHashCode3 = (iHashCode2 + (wVar == null ? 0 : wVar.hashCode())) * 31;
        v vVar = this.adUnit;
        int iHashCode4 = (iHashCode3 + (vVar != null ? vVar.hashCode() : 0)) * 31;
        boolean z = this.isTrackedCache;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        boolean z2 = this.isTrackedShow;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "AppRequest(id=" + this.id + ", location=" + this.location + ", bidResponse=" + this.bidResponse + ", bannerData=" + this.bannerData + ", adUnit=" + this.adUnit + ", isTrackedCache=" + this.isTrackedCache + ", isTrackedShow=" + this.isTrackedShow + ')';
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getBidResponse() {
        return this.bidResponse;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final w getBannerData() {
        return this.bannerData;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final v getAdUnit() {
        return this.adUnit;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getIsTrackedShow() {
        return this.isTrackedShow;
    }

    public /* synthetic */ y0(int i, String str, String str2, w wVar, v vVar, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i2 & 8) != 0 ? null : wVar, (i2 & 16) != 0 ? null : vVar, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? false : z2);
    }

    public final void a(v vVar) {
        this.adUnit = vVar;
    }

    public final void b(boolean z) {
        this.isTrackedShow = z;
    }

    public final void a(w wVar) {
        this.bannerData = wVar;
    }

    public final void a(String str) {
        this.bidResponse = str;
    }

    public final void a(boolean z) {
        this.isTrackedCache = z;
    }
}
