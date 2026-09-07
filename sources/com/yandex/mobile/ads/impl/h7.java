package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.AdQualityVerificationStateFlow;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import com.monetization.ads.quality.base.state.AdQualityVerificationState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d7 f9066a;

    public h7(d7 verificationPolicy) {
        Intrinsics.checkNotNullParameter(verificationPolicy, "verificationPolicy");
        this.f9066a = verificationPolicy;
    }

    public final AdQualityVerificationResult a(AdQualityVerificationResult status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (!(status instanceof AdQualityVerificationResult.Verified)) {
            return status;
        }
        AdQualityVerificationResult.Verified verified = (AdQualityVerificationResult.Verified) status;
        if (!(verified.getVerifiedAd().getVerificationResultStateFlow().getValue() instanceof AdQualityVerificationState.Error) || !this.f9066a.b()) {
            return status;
        }
        AdQualityVerificationStateFlow verifiedAd = verified.getVerifiedAd();
        AdQualityVerificationState value = verified.getVerifiedAd().getVerificationResultStateFlow().getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.monetization.ads.quality.base.state.AdQualityVerificationState.Error");
        return new AdQualityVerificationResult.Verified(new g7(verifiedAd, ((AdQualityVerificationState.Error) value).getError().getDescription()));
    }
}
