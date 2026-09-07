package com.monetization.ads.quality.base;

import com.monetization.ads.quality.base.model.AdQualityVerificationMode;
import com.monetization.ads.quality.base.state.AdQualityVerificationState;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/quality/base/AdQualityVerificationStateFlow;", "", "verificationMode", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationMode;", "getVerificationMode", "()Lcom/monetization/ads/quality/base/model/AdQualityVerificationMode;", "verificationResultStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/monetization/ads/quality/base/state/AdQualityVerificationState;", "getVerificationResultStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AdQualityVerificationStateFlow {
    AdQualityVerificationMode getVerificationMode();

    StateFlow<AdQualityVerificationState> getVerificationResultStateFlow();
}
