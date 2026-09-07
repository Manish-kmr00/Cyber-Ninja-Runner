package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J)\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/ironsource/vi;", "", "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "instanceId", "instanceType", "dynamicDemandSourceId", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "I", InneractiveMediationDefs.GENDER_FEMALE, "()I", "d", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class vi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String instanceId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int instanceType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String dynamicDemandSourceId;

    public vi() {
        this(null, 0, null, 7, null);
    }

    public vi(String instanceId, int i, String str) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        this.instanceId = instanceId;
        this.instanceType = i;
        this.dynamicDemandSourceId = str;
    }

    public /* synthetic */ vi(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2);
    }

    public static /* synthetic */ vi a(vi viVar, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = viVar.instanceId;
        }
        if ((i2 & 2) != 0) {
            i = viVar.instanceType;
        }
        if ((i2 & 4) != 0) {
            str2 = viVar.dynamicDemandSourceId;
        }
        return viVar.a(str, i, str2);
    }

    public final vi a(String instanceId, int instanceType, String dynamicDemandSourceId) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        return new vi(instanceId, instanceType, dynamicDemandSourceId);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getInstanceType() {
        return this.instanceType;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDynamicDemandSourceId() {
        return this.dynamicDemandSourceId;
    }

    public final String d() {
        return this.dynamicDemandSourceId;
    }

    public final String e() {
        return this.instanceId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof vi)) {
            return false;
        }
        vi viVar = (vi) other;
        return Intrinsics.areEqual(this.instanceId, viVar.instanceId) && this.instanceType == viVar.instanceType && Intrinsics.areEqual(this.dynamicDemandSourceId, viVar.dynamicDemandSourceId);
    }

    public final int f() {
        return this.instanceType;
    }

    public int hashCode() {
        int iHashCode = ((this.instanceId.hashCode() * 31) + Integer.hashCode(this.instanceType)) * 31;
        String str = this.dynamicDemandSourceId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InstanceInformation(instanceId=" + this.instanceId + ", instanceType=" + this.instanceType + ", dynamicDemandSourceId=" + this.dynamicDemandSourceId + ')';
    }
}
