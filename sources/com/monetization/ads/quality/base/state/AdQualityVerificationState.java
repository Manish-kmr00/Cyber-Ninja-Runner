package com.monetization.ads.quality.base.state;

import com.monetization.ads.quality.base.model.AdQualityVerificationBlockingReasons;
import com.monetization.ads.quality.base.model.AdQualityVerificationError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "", "Blocked", "Error", "NotStarted", "ShouldBeBlockedOnDisplay", "Verified", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$Blocked;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$Error;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$NotStarted;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$ShouldBeBlockedOnDisplay;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$Verified;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AdQualityVerificationState {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$Blocked;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "reason", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;", "(Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;)V", "getReason", "()Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Blocked implements AdQualityVerificationState {
        private final AdQualityVerificationBlockingReasons reason;

        public Blocked(AdQualityVerificationBlockingReasons reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public static /* synthetic */ Blocked copy$default(Blocked blocked, AdQualityVerificationBlockingReasons adQualityVerificationBlockingReasons, int i, Object obj) {
            if ((i & 1) != 0) {
                adQualityVerificationBlockingReasons = blocked.reason;
            }
            return blocked.copy(adQualityVerificationBlockingReasons);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AdQualityVerificationBlockingReasons getReason() {
            return this.reason;
        }

        public final Blocked copy(AdQualityVerificationBlockingReasons reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Blocked(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Blocked) && Intrinsics.areEqual(this.reason, ((Blocked) other).reason);
        }

        public final AdQualityVerificationBlockingReasons getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Blocked(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$Error;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "error", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "(Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;)V", "getError", "()Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Error implements AdQualityVerificationState {
        private final AdQualityVerificationError error;

        public Error(AdQualityVerificationError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, AdQualityVerificationError adQualityVerificationError, int i, Object obj) {
            if ((i & 1) != 0) {
                adQualityVerificationError = error.error;
            }
            return error.copy(adQualityVerificationError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AdQualityVerificationError getError() {
            return this.error;
        }

        public final Error copy(AdQualityVerificationError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public final AdQualityVerificationError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$NotStarted;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NotStarted implements AdQualityVerificationState {
        public static final NotStarted INSTANCE = new NotStarted();

        private NotStarted() {
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotStarted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1691080461;
        }

        public String toString() {
            return "NotStarted";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$ShouldBeBlockedOnDisplay;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "reason", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;", "(Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;)V", "getReason", "()Lcom/monetization/ads/quality/base/model/AdQualityVerificationBlockingReasons;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShouldBeBlockedOnDisplay implements AdQualityVerificationState {
        private final AdQualityVerificationBlockingReasons reason;

        public ShouldBeBlockedOnDisplay(AdQualityVerificationBlockingReasons reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public static /* synthetic */ ShouldBeBlockedOnDisplay copy$default(ShouldBeBlockedOnDisplay shouldBeBlockedOnDisplay, AdQualityVerificationBlockingReasons adQualityVerificationBlockingReasons, int i, Object obj) {
            if ((i & 1) != 0) {
                adQualityVerificationBlockingReasons = shouldBeBlockedOnDisplay.reason;
            }
            return shouldBeBlockedOnDisplay.copy(adQualityVerificationBlockingReasons);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AdQualityVerificationBlockingReasons getReason() {
            return this.reason;
        }

        public final ShouldBeBlockedOnDisplay copy(AdQualityVerificationBlockingReasons reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new ShouldBeBlockedOnDisplay(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShouldBeBlockedOnDisplay) && Intrinsics.areEqual(this.reason, ((ShouldBeBlockedOnDisplay) other).reason);
        }

        public final AdQualityVerificationBlockingReasons getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "ShouldBeBlockedOnDisplay(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/quality/base/state/AdQualityVerificationState$Verified;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Verified implements AdQualityVerificationState {
        public static final Verified INSTANCE = new Verified();

        private Verified() {
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Verified)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -800540825;
        }

        public String toString() {
            return "Verified";
        }
    }
}
