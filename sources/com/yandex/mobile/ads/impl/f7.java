package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.model.AdQualityVerificationError;
import com.monetization.ads.quality.base.model.AdQualityVerificationMode;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import com.monetization.ads.quality.base.state.AdQualityVerificationState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f7 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8871a;

        static {
            int[] iArr = new int[AdQualityVerificationMode.values().length];
            try {
                iArr[AdQualityVerificationMode.FAST_VERIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdQualityVerificationMode.LONG_VERIFICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8871a = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    public static ip1 b(AdQualityVerificationResult verificationResult) {
        String str;
        String str2;
        AdQualityVerificationError reason;
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        ip1 ip1Var = new ip1(MapsKt.emptyMap(), 2);
        ip1Var.b(a(verificationResult), "verification_status");
        boolean z = verificationResult instanceof AdQualityVerificationResult.Verified;
        if (z) {
            int i = a.f8871a[((AdQualityVerificationResult.Verified) verificationResult).getVerifiedAd().getVerificationMode().ordinal()];
            if (i == 1) {
                str = "fastVerification";
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "longVerification";
            }
        } else {
            str = null;
        }
        ip1Var.b(str, "verification_flow");
        if (z) {
            AdQualityVerificationState value = ((AdQualityVerificationResult.Verified) verificationResult).getVerifiedAd().getVerificationResultStateFlow().getValue();
            if ((value instanceof AdQualityVerificationState.Verified) || (value instanceof AdQualityVerificationState.Blocked) || (value instanceof AdQualityVerificationState.ShouldBeBlockedOnDisplay)) {
                str2 = "success";
            } else if (verificationResult instanceof AdQualityVerificationResult.NotVerified) {
                reason = ((AdQualityVerificationResult.NotVerified) verificationResult).getReason();
                if (!(reason instanceof AdQualityVerificationError.DisabledError) || (reason instanceof AdQualityVerificationError.LowUsagePercent) || (reason instanceof AdQualityVerificationError.UnsupportedNetwork)) {
                    str2 = "verification not enabled";
                } else {
                    str2 = "error";
                }
            } else {
                str2 = "error";
            }
        } else if (verificationResult instanceof AdQualityVerificationResult.NotVerified) {
            reason = ((AdQualityVerificationResult.NotVerified) verificationResult).getReason();
            if (reason instanceof AdQualityVerificationError.DisabledError) {
            }
            str2 = "verification not enabled";
        } else {
            str2 = "error";
        }
        ip1Var.b(str2, "status");
        return ip1Var;
    }

    private static String a(AdQualityVerificationState adQualityVerificationState) {
        String str;
        if (adQualityVerificationState instanceof AdQualityVerificationState.Blocked) {
            str = "Blocked: " + ((AdQualityVerificationState.Blocked) adQualityVerificationState).getReason().getBlockReasons();
        } else if (adQualityVerificationState instanceof AdQualityVerificationState.Error) {
            str = "Error occurred during verification: " + ((AdQualityVerificationState.Error) adQualityVerificationState).getError().getDescription();
        } else if (adQualityVerificationState instanceof AdQualityVerificationState.NotStarted) {
            str = "Not verification started for the ad object";
        } else if (adQualityVerificationState instanceof AdQualityVerificationState.ShouldBeBlockedOnDisplay) {
            str = "Should be blocked on display: " + ((AdQualityVerificationState.ShouldBeBlockedOnDisplay) adQualityVerificationState).getReason().getBlockReasons();
        } else {
            if (!(adQualityVerificationState instanceof AdQualityVerificationState.Verified)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "Verified";
        }
        return "Verification Completed. With result: " + str;
    }

    private static String a(AdQualityVerificationResult adQualityVerificationResult) {
        if (adQualityVerificationResult instanceof AdQualityVerificationResult.NotImplemented) {
            return "Not implemented by design";
        }
        if (adQualityVerificationResult instanceof AdQualityVerificationResult.WaitingForVerification) {
            return "Verification not started";
        }
        if (adQualityVerificationResult instanceof AdQualityVerificationResult.NotVerified) {
            return "Not verified by reason: " + ((AdQualityVerificationResult.NotVerified) adQualityVerificationResult).getReason().getDescription();
        }
        if (adQualityVerificationResult instanceof AdQualityVerificationResult.Verified) {
            return a(((AdQualityVerificationResult.Verified) adQualityVerificationResult).getVerifiedAd().getVerificationResultStateFlow().getValue());
        }
        throw new NoWhenBranchMatchedException();
    }
}
