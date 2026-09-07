package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.fe;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\r\u0010\u0004R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c¨\u0006 "}, d2 = {"Lcom/chartboost/sdk/impl/r5;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/qa;", "a", "Lcom/chartboost/sdk/impl/qa;", "e", "()Lcom/chartboost/sdk/impl/qa;", "trackingState", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "identifiers", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, InneractiveMediationDefs.GENDER_FEMALE, CommonUrlParts.UUID, "d", fe.Q0, "setId", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setIdScope", "<init>", "(Lcom/chartboost/sdk/impl/qa;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final qa trackingState;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String identifiers;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String uuid;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String gaid;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String setId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Integer setIdScope;

    public r5() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof r5)) {
            return false;
        }
        r5 r5Var = (r5) other;
        return this.trackingState == r5Var.trackingState && Intrinsics.areEqual(this.identifiers, r5Var.identifiers) && Intrinsics.areEqual(this.uuid, r5Var.uuid) && Intrinsics.areEqual(this.gaid, r5Var.gaid) && Intrinsics.areEqual(this.setId, r5Var.setId) && Intrinsics.areEqual(this.setIdScope, r5Var.setIdScope);
    }

    public int hashCode() {
        int iHashCode = this.trackingState.hashCode() * 31;
        String str = this.identifiers;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uuid;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.gaid;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.setId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.setIdScope;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "IdentityBodyFields(trackingState=" + this.trackingState + ", identifiers=" + this.identifiers + ", uuid=" + this.uuid + ", gaid=" + this.gaid + ", setId=" + this.setId + ", setIdScope=" + this.setIdScope + ')';
    }

    public r5(qa trackingState, String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(trackingState, "trackingState");
        this.trackingState = trackingState;
        this.identifiers = str;
        this.uuid = str2;
        this.gaid = str3;
        this.setId = str4;
        this.setIdScope = num;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final qa getTrackingState() {
        return this.trackingState;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getIdentifiers() {
        return this.identifiers;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getGaid() {
        return this.gaid;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getSetId() {
        return this.setId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Integer getSetIdScope() {
        return this.setIdScope;
    }

    public /* synthetic */ r5(qa qaVar, String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? qa.TRACKING_UNKNOWN : qaVar, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? num : null);
    }
}
