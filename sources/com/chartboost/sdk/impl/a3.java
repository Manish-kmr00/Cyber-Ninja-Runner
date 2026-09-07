package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u0010&\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010#\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u001e\u0010!\u001a\u0004\b\u0015\u0010\"R\u0019\u0010&\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b\u0019\u0010%¨\u0006)"}, d2 = {"Lcom/chartboost/sdk/impl/a3;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "e", "location", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "adId", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "g", "to", "d", "cgn", Reporting.Key.CREATIVE, "", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/Float;", "i", "()Ljava/lang/Float;", "videoPosition", "h", "videoDuration", "Lcom/chartboost/sdk/impl/k6;", "Lcom/chartboost/sdk/impl/k6;", "()Lcom/chartboost/sdk/impl/k6;", "impressionMediaType", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "retargetReinstall", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Lcom/chartboost/sdk/impl/k6;Ljava/lang/Boolean;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String adId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String to;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String cgn;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String creative;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Float videoPosition;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Float videoDuration;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final k6 impressionMediaType;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Boolean retargetReinstall;

    public a3(String location, String adId, String to, String cgn, String creative, Float f, Float f2, k6 impressionMediaType, Boolean bool) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(cgn, "cgn");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(impressionMediaType, "impressionMediaType");
        this.location = location;
        this.adId = adId;
        this.to = to;
        this.cgn = cgn;
        this.creative = creative;
        this.videoPosition = f;
        this.videoDuration = f2;
        this.impressionMediaType = impressionMediaType;
        this.retargetReinstall = bool;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a3)) {
            return false;
        }
        a3 a3Var = (a3) other;
        return Intrinsics.areEqual(this.location, a3Var.location) && Intrinsics.areEqual(this.adId, a3Var.adId) && Intrinsics.areEqual(this.to, a3Var.to) && Intrinsics.areEqual(this.cgn, a3Var.cgn) && Intrinsics.areEqual(this.creative, a3Var.creative) && Intrinsics.areEqual((Object) this.videoPosition, (Object) a3Var.videoPosition) && Intrinsics.areEqual((Object) this.videoDuration, (Object) a3Var.videoDuration) && this.impressionMediaType == a3Var.impressionMediaType && Intrinsics.areEqual(this.retargetReinstall, a3Var.retargetReinstall);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.location.hashCode() * 31) + this.adId.hashCode()) * 31) + this.to.hashCode()) * 31) + this.cgn.hashCode()) * 31) + this.creative.hashCode()) * 31;
        Float f = this.videoPosition;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.videoDuration;
        int iHashCode3 = (((iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31) + this.impressionMediaType.hashCode()) * 31;
        Boolean bool = this.retargetReinstall;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ClickParams(location=" + this.location + ", adId=" + this.adId + ", to=" + this.to + ", cgn=" + this.cgn + ", creative=" + this.creative + ", videoPosition=" + this.videoPosition + ", videoDuration=" + this.videoDuration + ", impressionMediaType=" + this.impressionMediaType + ", retargetReinstall=" + this.retargetReinstall + ')';
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getCgn() {
        return this.cgn;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getCreative() {
        return this.creative;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Float getVideoPosition() {
        return this.videoPosition;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final Float getVideoDuration() {
        return this.videoDuration;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final k6 getImpressionMediaType() {
        return this.impressionMediaType;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Boolean getRetargetReinstall() {
        return this.retargetReinstall;
    }
}
