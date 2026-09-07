package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes11.dex */
public final class la1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ta2 f9494a;
    private final ka1 b;

    public /* synthetic */ la1(Context context, va2 va2Var) {
        this(context, va2Var, va2Var.a(context), new ka1());
    }

    public la1(Context context, va2 verificationResourcesLoaderProvider, ta2 ta2Var, ka1 verificationPresenceValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(verificationResourcesLoaderProvider, "verificationResourcesLoaderProvider");
        Intrinsics.checkNotNullParameter(verificationPresenceValidator, "verificationPresenceValidator");
        this.f9494a = ta2Var;
        this.b = verificationPresenceValidator;
    }

    public static final class a implements ua2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Unit> f9495a;

        a(CancellableContinuationImpl cancellableContinuationImpl) {
            this.f9495a = cancellableContinuationImpl;
        }

        @Override // com.yandex.mobile.ads.impl.ua2
        public final void a() {
            CancellableContinuation<Unit> cancellableContinuation = this.f9495a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
        }
    }

    public final void a() {
        ta2 ta2Var = this.f9494a;
        if (ta2Var != null) {
            ta2Var.a();
        }
    }

    public final Object a(o41 o41Var, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.f9494a != null && this.b.a(o41Var)) {
            this.f9494a.a(new a(cancellableContinuationImpl));
        } else {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
