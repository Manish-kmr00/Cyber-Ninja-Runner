package com.monetization.ads.quality.base.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;", "", "blockReasons", "", "", "reportReasons", "(Ljava/util/List;Ljava/util/List;)V", "getBlockReasons", "()Ljava/util/List;", "getReportReasons", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class AdQualityVerificationBlockingReasons {
    private final List<String> blockReasons;
    private final List<String> reportReasons;

    public AdQualityVerificationBlockingReasons(List<String> blockReasons, List<String> reportReasons) {
        Intrinsics.checkNotNullParameter(blockReasons, "blockReasons");
        Intrinsics.checkNotNullParameter(reportReasons, "reportReasons");
        this.blockReasons = blockReasons;
        this.reportReasons = reportReasons;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdQualityVerificationBlockingReasons copy$default(AdQualityVerificationBlockingReasons adQualityVerificationBlockingReasons, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = adQualityVerificationBlockingReasons.blockReasons;
        }
        if ((i & 2) != 0) {
            list2 = adQualityVerificationBlockingReasons.reportReasons;
        }
        return adQualityVerificationBlockingReasons.copy(list, list2);
    }

    public final List<String> component1() {
        return this.blockReasons;
    }

    public final List<String> component2() {
        return this.reportReasons;
    }

    public final AdQualityVerificationBlockingReasons copy(List<String> blockReasons, List<String> reportReasons) {
        Intrinsics.checkNotNullParameter(blockReasons, "blockReasons");
        Intrinsics.checkNotNullParameter(reportReasons, "reportReasons");
        return new AdQualityVerificationBlockingReasons(blockReasons, reportReasons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdQualityVerificationBlockingReasons)) {
            return false;
        }
        AdQualityVerificationBlockingReasons adQualityVerificationBlockingReasons = (AdQualityVerificationBlockingReasons) other;
        return Intrinsics.areEqual(this.blockReasons, adQualityVerificationBlockingReasons.blockReasons) && Intrinsics.areEqual(this.reportReasons, adQualityVerificationBlockingReasons.reportReasons);
    }

    public final List<String> getBlockReasons() {
        return this.blockReasons;
    }

    public final List<String> getReportReasons() {
        return this.reportReasons;
    }

    public int hashCode() {
        return this.reportReasons.hashCode() + (this.blockReasons.hashCode() * 31);
    }

    public String toString() {
        return "AdQualityVerificationBlockingReasons(blockReasons=" + this.blockReasons + ", reportReasons=" + this.reportReasons + ")";
    }
}
