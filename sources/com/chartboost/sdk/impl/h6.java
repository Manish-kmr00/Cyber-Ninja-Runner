package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\r\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/h6;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/y1;", "a", "Lcom/chartboost/sdk/impl/y1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/y1;", "impression", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "()Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", "<init>", "(Lcom/chartboost/sdk/impl/y1;Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class h6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y1 impression;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final CBError.b error;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof h6)) {
            return false;
        }
        h6 h6Var = (h6) other;
        return Intrinsics.areEqual(this.impression, h6Var.impression) && this.error == h6Var.error;
    }

    public int hashCode() {
        y1 y1Var = this.impression;
        int iHashCode = (y1Var == null ? 0 : y1Var.hashCode()) * 31;
        CBError.b bVar = this.error;
        return iHashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ImpressionHolder(impression=" + this.impression + ", error=" + this.error + ')';
    }

    public h6(y1 y1Var, CBError.b bVar) {
        this.impression = y1Var;
        this.error = bVar;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final y1 getImpression() {
        return this.impression;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final CBError.b getError() {
        return this.error;
    }
}
