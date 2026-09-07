package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ironsource/y3;", "", "", "a", "auctionData", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String auctionData;

    public y3() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public y3(String auctionData) {
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        this.auctionData = auctionData;
    }

    public /* synthetic */ y3(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public static /* synthetic */ y3 a(y3 y3Var, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = y3Var.auctionData;
        }
        return y3Var.a(str);
    }

    public final y3 a(String auctionData) {
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        return new y3(auctionData);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAuctionData() {
        return this.auctionData;
    }

    public final String b() {
        return this.auctionData;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof y3) && Intrinsics.areEqual(this.auctionData, ((y3) other).auctionData);
    }

    public int hashCode() {
        return this.auctionData.hashCode();
    }

    public String toString() {
        return "ApplicationAuctionSettings(auctionData=" + this.auctionData + ')';
    }
}
