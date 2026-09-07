package com.yandex.mobile.ads.impl;

import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes12.dex */
public final class bb1 implements oe2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<Unit> f8490a;

    bb1(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f8490a = cancellableContinuationImpl;
    }

    @Override // com.yandex.mobile.ads.impl.oe2
    public final void a() {
        CancellableContinuation<Unit> cancellableContinuation = this.f8490a;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
    }
}
