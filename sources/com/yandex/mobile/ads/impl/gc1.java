package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes13.dex */
public final class gc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f8990a;
    private final qw0 b;
    private final y21 c;

    public interface a {
        void a();
    }

    public gc1(g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        this.f8990a = adLoadingPhasesManager;
        this.b = new qw0();
        this.c = new y21();
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Unit> f8992a;

        c(CancellableContinuationImpl cancellableContinuationImpl) {
            this.f8992a = cancellableContinuationImpl;
        }

        @Override // com.yandex.mobile.ads.impl.gc1.a
        public final void a() {
            CancellableContinuation<Unit> cancellableContinuation = this.f8992a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
        }
    }

    private static final class b implements y21.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g5 f8991a;
        private final a b;
        private final AtomicInteger c;

        public b(g5 adLoadingPhasesManager, int i, c listener) {
            Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f8991a = adLoadingPhasesManager;
            this.b = listener;
            this.c = new AtomicInteger(i);
        }

        @Override // com.yandex.mobile.ads.impl.y21.a
        public final void a() {
            if (this.c.decrementAndGet() == 0) {
                this.f8991a.a(f5.s);
                this.b.a();
            }
        }
    }

    public final Object a(Context context, o41 o41Var, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Set<su0> setA = this.b.a(o41Var);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        int iD = cu1VarA != null ? cu1VarA.D() : 0;
        if (oa.a(context) && iD != 0 && !setA.isEmpty()) {
            b bVar = new b(this.f8990a, setA.size(), new c(cancellableContinuationImpl));
            g5 g5Var = this.f8990a;
            f5 f5Var = f5.s;
            ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
            Iterator<su0> it = setA.iterator();
            while (it.hasNext()) {
                this.c.a(context, it.next(), bVar);
            }
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
