package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes12.dex */
public final class b2 implements a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c2 f8467a;
    private final ArrayList b;
    private final Object c;

    public b2(Context context, c2 adBlockerDetector) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBlockerDetector, "adBlockerDetector");
        this.f8467a = adBlockerDetector;
        this.b = new ArrayList();
        this.c = new Object();
    }

    public static final void a(b2 b2Var) {
        List list;
        synchronized (b2Var.c) {
            list = CollectionsKt.toList(b2Var.b);
            b2Var.b.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b2Var.f8467a.a((e2) it.next());
        }
    }

    public static final void a(b2 b2Var, e2 e2Var) {
        synchronized (b2Var.c) {
            b2Var.b.add(e2Var);
            b2Var.f8467a.b(e2Var);
            Unit unit = Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.aab.AdBlockerControllerImpl$detectAdBlocker$2", f = "AdBlockerControllerImpl.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        static final class b implements e2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<Unit> f8468a;

            b(CancellableContinuationImpl cancellableContinuationImpl) {
                this.f8468a = cancellableContinuationImpl;
            }

            @Override // com.yandex.mobile.ads.impl.e2
            public final void a() {
                if (this.f8468a.isActive()) {
                    CancellableContinuation<Unit> cancellableContinuation = this.f8468a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
                }
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b2.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return b2.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b2 b2Var = b2.this;
                this.b = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                cancellableContinuationImpl.invokeOnCancellation(new C0737a(b2Var));
                b2.a(b2Var, new b(cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.b2$a$a, reason: collision with other inner class name */
        static final class C0737a extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ b2 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0737a(b2 b2Var) {
                super(1);
                this.b = b2Var;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                b2.a(this.b);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.a2
    public final Object a(Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(nu.a(), new a(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
