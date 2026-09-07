package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes7.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeMediaLoader$loadMedia$2", f = "NativeMediaLoader.kt", i = {0, 0, 1}, l = {39, 40, 41, 43}, m = "invokeSuspend", n = {"webViewLoadJob", "loadVideoTask", "loadVideoTask"}, s = {"L$0", "L$1", "L$0"})
final class l91 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o41>, Object> {
    Deferred b;
    int c;
    private /* synthetic */ Object d;
    final /* synthetic */ o3 e;
    final /* synthetic */ m91 f;
    final /* synthetic */ Context g;
    final /* synthetic */ o41 h;
    final /* synthetic */ aw i;
    final /* synthetic */ pj0 j;

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeMediaLoader$loadMedia$2$imagesLoadJob$1", f = "NativeMediaLoader.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;
        final /* synthetic */ m91 c;
        final /* synthetic */ o41 d;
        final /* synthetic */ pj0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m91 m91Var, o41 o41Var, pj0 pj0Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = m91Var;
            this.d = o41Var;
            this.e = pj0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e91 e91Var = this.c.f9613a;
                o41 o41Var = this.d;
                pj0 pj0Var = this.e;
                this.b = 1;
                if (e91Var.a(o41Var, pj0Var, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeMediaLoader$loadMedia$2$loadVideoTask$1", f = "NativeMediaLoader.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o41>, Object> {
        int b;
        final /* synthetic */ m91 c;
        final /* synthetic */ Context d;
        final /* synthetic */ o41 e;
        final /* synthetic */ aw f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(m91 m91Var, Context context, o41 o41Var, aw awVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = m91Var;
            this.d = context;
            this.e = o41Var;
            this.f = awVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super o41> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ab1 ab1Var = this.c.c;
                Context context = this.d;
                o41 o41Var = this.e;
                aw awVar = this.f;
                this.b = 1;
                obj = ab1Var.a(true, context, o41Var, awVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeMediaLoader$loadMedia$2$webViewLoadJob$1", f = "NativeMediaLoader.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;
        final /* synthetic */ m91 c;
        final /* synthetic */ Context d;
        final /* synthetic */ o41 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(m91 m91Var, Context context, o41 o41Var, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = m91Var;
            this.d = context;
            this.e = o41Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                gc1 gc1Var = this.c.b;
                Context context = this.d;
                o41 o41Var = this.e;
                this.b = 1;
                if (gc1Var.a(context, o41Var, this) == coroutine_suspended) {
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
    l91(o3 o3Var, m91 m91Var, Context context, o41 o41Var, aw awVar, pj0 pj0Var, Continuation<? super l91> continuation) {
        super(2, continuation);
        this.e = o3Var;
        this.f = m91Var;
        this.g = context;
        this.h = o41Var;
        this.i = awVar;
        this.j = pj0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        l91 l91Var = new l91(this.e, this.f, this.g, this.h, this.i, this.j, continuation);
        l91Var.d = obj;
        return l91Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super o41> continuation) {
        return ((l91) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x009f A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Job jobLaunch$default;
        Deferred deferred;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i != 0) {
            if (i == 1) {
                deferred = this.b;
                jobLaunch$default = (Job) this.d;
                ResultKt.throwOnFailure(obj);
                this.d = deferred;
                this.b = null;
                this.c = 2;
                if (jobLaunch$default.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 2) {
                deferred = (Deferred) this.d;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 3) {
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.d;
        if (!this.e.u()) {
            ab1 ab1Var = this.f.c;
            Context context = this.g;
            o41 o41Var = this.h;
            aw awVar = this.i;
            this.c = 4;
            obj = ab1Var.a(false, context, o41Var, awVar, this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        }
        Job jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new a(this.f, this.h, this.j, null), 3, null);
        jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new c(this.f, this.g, this.h, null), 3, null);
        Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.f, this.g, this.h, this.i, null), 3, null);
        this.d = jobLaunch$default;
        this.b = deferredAsync$default;
        this.c = 1;
        if (jobLaunch$default2.join(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        deferred = deferredAsync$default;
        this.d = deferred;
        this.b = null;
        this.c = 2;
        if (jobLaunch$default.join(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.d = null;
        this.c = 3;
        obj = deferred.await(this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
