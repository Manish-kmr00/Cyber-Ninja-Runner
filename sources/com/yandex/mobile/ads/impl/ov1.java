package com.yandex.mobile.ads.impl;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes13.dex */
public final class ov1 implements hv1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<Boolean> f9864a;

    ov1(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f9864a = cancellableContinuationImpl;
    }

    @Override // com.yandex.mobile.ads.impl.hv1.a
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.f9864a.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.f9864a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(Boolean.FALSE));
        }
    }

    @Override // com.yandex.mobile.ads.impl.hv1.a
    public final void a(jc advertisingConfiguration, l50 environmentConfiguration) {
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        if (this.f9864a.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.f9864a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(Boolean.TRUE));
        }
    }
}
