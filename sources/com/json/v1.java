package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.model.NetworkSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J/\u0010\u0003\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/ironsource/v1;", "", "", "a", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/qk;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "userId", "providerList", "publisherDataHolder", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "Ljava/util/List;", "d", "()Ljava/util/List;", "Lcom/ironsource/qk;", "e", "()Lcom/ironsource/qk;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/ironsource/qk;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<NetworkSettings> providerList;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final qk publisherDataHolder;

    /* JADX WARN: Multi-variable type inference failed */
    public v1(String str, List<? extends NetworkSettings> providerList, qk publisherDataHolder) {
        Intrinsics.checkNotNullParameter(providerList, "providerList");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        this.userId = str;
        this.providerList = providerList;
        this.publisherDataHolder = publisherDataHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ v1 a(v1 v1Var, String str, List list, qk qkVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = v1Var.userId;
        }
        if ((i & 2) != 0) {
            list = v1Var.providerList;
        }
        if ((i & 4) != 0) {
            qkVar = v1Var.publisherDataHolder;
        }
        return v1Var.a(str, list, qkVar);
    }

    public final v1 a(String userId, List<? extends NetworkSettings> providerList, qk publisherDataHolder) {
        Intrinsics.checkNotNullParameter(providerList, "providerList");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        return new v1(userId, providerList, publisherDataHolder);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final List<NetworkSettings> b() {
        return this.providerList;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final qk getPublisherDataHolder() {
        return this.publisherDataHolder;
    }

    public final List<NetworkSettings> d() {
        return this.providerList;
    }

    public final qk e() {
        return this.publisherDataHolder;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) other;
        return Intrinsics.areEqual(this.userId, v1Var.userId) && Intrinsics.areEqual(this.providerList, v1Var.providerList) && Intrinsics.areEqual(this.publisherDataHolder, v1Var.publisherDataHolder);
    }

    public final String f() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.providerList.hashCode()) * 31) + this.publisherDataHolder.hashCode();
    }

    public String toString() {
        return "AdUnitCommonData(userId=" + this.userId + ", providerList=" + this.providerList + ", publisherDataHolder=" + this.publisherDataHolder + ')';
    }
}
