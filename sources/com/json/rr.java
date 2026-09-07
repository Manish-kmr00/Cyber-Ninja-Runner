package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.IronSource;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0006\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J/\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/ironsource/rr;", "", "", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adFormats", "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "appKey", "userId", "legacyAdFormats", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class rr {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String appKey;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<IronSource.AD_UNIT> legacyAdFormats;

    public rr(String appKey, String str, List<IronSource.AD_UNIT> legacyAdFormats) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(legacyAdFormats, "legacyAdFormats");
        this.appKey = appKey;
        this.userId = str;
        this.legacyAdFormats = legacyAdFormats;
    }

    public /* synthetic */ rr(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ rr a(rr rrVar, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rrVar.appKey;
        }
        if ((i & 2) != 0) {
            str2 = rrVar.userId;
        }
        if ((i & 4) != 0) {
            list = rrVar.legacyAdFormats;
        }
        return rrVar.a(str, str2, list);
    }

    public final rr a(String appKey, String userId, List<IronSource.AD_UNIT> legacyAdFormats) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(legacyAdFormats, "legacyAdFormats");
        return new rr(appKey, userId, legacyAdFormats);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    public final void a(List<? extends IronSource.AD_UNIT> adFormats) {
        Intrinsics.checkNotNullParameter(adFormats, "adFormats");
        this.legacyAdFormats.clear();
        this.legacyAdFormats.addAll(adFormats);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final List<IronSource.AD_UNIT> c() {
        return this.legacyAdFormats;
    }

    public final String d() {
        return this.appKey;
    }

    public final List<IronSource.AD_UNIT> e() {
        return this.legacyAdFormats;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof rr)) {
            return false;
        }
        rr rrVar = (rr) other;
        return Intrinsics.areEqual(this.appKey, rrVar.appKey) && Intrinsics.areEqual(this.userId, rrVar.userId) && Intrinsics.areEqual(this.legacyAdFormats, rrVar.legacyAdFormats);
    }

    public final String f() {
        return this.userId;
    }

    public int hashCode() {
        int iHashCode = this.appKey.hashCode() * 31;
        String str = this.userId;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.legacyAdFormats.hashCode();
    }

    public String toString() {
        return "SdkInitRequest(appKey=" + this.appKey + ", userId=" + this.userId + ", legacyAdFormats=" + this.legacyAdFormats + ')';
    }
}
