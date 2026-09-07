package com.yandex.mobile.ads.impl;

import android.os.Handler;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f8396a;
    private final Handler b;

    public ae(CoroutineContext coroutineContext, Handler mainHandler) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        this.f8396a = coroutineContext;
        this.b = mainHandler;
    }

    @DebugMetadata(c = "com.monetization.ads.core.anr.AnrChecker$isAlive$2", f = "AnrChecker.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int b;
        final /* synthetic */ long d;

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.ae$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.monetization.ads.core.anr.AnrChecker$isAlive$2$2", f = "AnrChecker.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
        static final class C0736a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int b;
            final /* synthetic */ CompletableDeferred<Unit> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0736a(CompletableDeferred<Unit> completableDeferred, Continuation<? super C0736a> continuation) {
                super(2, continuation);
                this.c = completableDeferred;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0736a(this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new C0736a(this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred<Unit> completableDeferred = this.c;
                    this.b = 1;
                    if (completableDeferred.await(this) == coroutine_suspended) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ae.this.new a(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ae.this.new a(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                ae.this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ae$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ae.a.a(completableDeferredCompletableDeferred$default);
                    }
                });
                long j = this.d;
                C0736a c0736a = new C0736a(completableDeferredCompletableDeferred$default, null);
                this.b = 1;
                obj = TimeoutKt.withTimeoutOrNull(j, c0736a, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(obj != null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(CompletableDeferred completableDeferred) {
            completableDeferred.complete(Unit.INSTANCE);
        }
    }

    public final Object a(long j, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.f8396a, new a(j, null), continuation);
    }
}
