package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.AdQualityVerificationStateFlow;
import com.monetization.ads.quality.base.model.AdQualityVerificationBlockingReasons;
import com.monetization.ads.quality.base.model.AdQualityVerificationMode;
import com.monetization.ads.quality.base.state.AdQualityVerificationState;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g7 implements AdQualityVerificationStateFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdQualityVerificationStateFlow f8971a;
    private final String b;
    private final AdQualityVerificationMode c;
    private final StateFlow<AdQualityVerificationState> d;

    public g7(AdQualityVerificationStateFlow verificationStateFlow, String errorDescription) {
        Intrinsics.checkNotNullParameter(verificationStateFlow, "verificationStateFlow");
        Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
        this.f8971a = verificationStateFlow;
        this.b = errorDescription;
        this.c = verificationStateFlow.getVerificationMode();
        this.d = FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(new AdQualityVerificationState.Blocked(new AdQualityVerificationBlockingReasons(CollectionsKt.listOf((Object[]) new String[]{"Ad is blocked by validation policy", errorDescription}), CollectionsKt.listOf((Object[]) new String[]{"Ad is blocked by validation policy", errorDescription})))));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g7)) {
            return false;
        }
        g7 g7Var = (g7) obj;
        return Intrinsics.areEqual(this.f8971a, g7Var.f8971a) && Intrinsics.areEqual(this.b, g7Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f8971a.hashCode() * 31);
    }

    public final String toString() {
        return "AdQualityVerificationStateFlowByPolicy(verificationStateFlow=" + this.f8971a + ", errorDescription=" + this.b + ")";
    }

    @Override // com.monetization.ads.quality.base.AdQualityVerificationStateFlow
    public final AdQualityVerificationMode getVerificationMode() {
        return this.c;
    }

    @Override // com.monetization.ads.quality.base.AdQualityVerificationStateFlow
    public final StateFlow<AdQualityVerificationState> getVerificationResultStateFlow() {
        return this.d;
    }
}
