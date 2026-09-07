package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes6.dex */
public final class sd2 implements wp1<List<? extends eb2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<rd2> f10199a;

    sd2(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f10199a = cancellableContinuationImpl;
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String str = "Failed to load Wrapper Video Ad: " + error;
        op0.b(new Object[0]);
        if (this.f10199a.isActive()) {
            CancellableContinuation<rd2> cancellableContinuation = this.f10199a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(new rd2.a(error)));
        }
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(List<? extends eb2> list) {
        List<? extends eb2> result = list;
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.f10199a.isActive()) {
            CancellableContinuation<rd2> cancellableContinuation = this.f10199a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(new rd2.b(result)));
        }
    }
}
