package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/ironsource/t1;", "", "Lcom/ironsource/p1;", "a", "Lcom/unity3d/mediation/LevelPlayAdInfo;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "adUnit", "adInfo", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/ironsource/p1;", "d", "()Lcom/ironsource/p1;", "Lcom/unity3d/mediation/LevelPlayAdInfo;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/unity3d/mediation/LevelPlayAdInfo;", "<init>", "(Lcom/ironsource/p1;Lcom/unity3d/mediation/LevelPlayAdInfo;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final p1 adUnit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final LevelPlayAdInfo adInfo;

    public t1(p1 adUnit, LevelPlayAdInfo levelPlayAdInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.adUnit = adUnit;
        this.adInfo = levelPlayAdInfo;
    }

    public /* synthetic */ t1(p1 p1Var, LevelPlayAdInfo levelPlayAdInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(p1Var, (i & 2) != 0 ? null : levelPlayAdInfo);
    }

    public static /* synthetic */ t1 a(t1 t1Var, p1 p1Var, LevelPlayAdInfo levelPlayAdInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            p1Var = t1Var.adUnit;
        }
        if ((i & 2) != 0) {
            levelPlayAdInfo = t1Var.adInfo;
        }
        return t1Var.a(p1Var, levelPlayAdInfo);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final p1 getAdUnit() {
        return this.adUnit;
    }

    public final t1 a(p1 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return new t1(adUnit, adInfo);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final LevelPlayAdInfo getAdInfo() {
        return this.adInfo;
    }

    public final LevelPlayAdInfo c() {
        return this.adInfo;
    }

    public final p1 d() {
        return this.adUnit;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) other;
        return Intrinsics.areEqual(this.adUnit, t1Var.adUnit) && Intrinsics.areEqual(this.adInfo, t1Var.adInfo);
    }

    public int hashCode() {
        int iHashCode = this.adUnit.hashCode() * 31;
        LevelPlayAdInfo levelPlayAdInfo = this.adInfo;
        return iHashCode + (levelPlayAdInfo == null ? 0 : levelPlayAdInfo.hashCode());
    }

    public String toString() {
        return "AdUnitCallback(adUnit=" + this.adUnit + ", adInfo=" + this.adInfo + ')';
    }
}
