package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes9.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeResourcesLoader$load$1", f = "NativeResourcesLoader.kt", i = {0, 0, 1}, l = {53, 55}, m = "invokeSuspend", n = {"imageProvider", "updatedNativeAdBlockTask", "imageProvider"}, s = {"L$0", "L$1", "L$0"})
final class s91 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Deferred b;
    int c;
    private /* synthetic */ Object d;
    final /* synthetic */ Context e;
    final /* synthetic */ c51 f;
    final /* synthetic */ r91.a g;
    final /* synthetic */ r91 h;
    final /* synthetic */ o3 i;
    final /* synthetic */ o41 j;
    final /* synthetic */ aw k;

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeResourcesLoader$load$1$1", f = "NativeResourcesLoader.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;
        final /* synthetic */ r91 c;
        final /* synthetic */ o41 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(r91 r91Var, o41 o41Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = r91Var;
            this.d = o41Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                la1 la1Var = this.c.c;
                o41 o41Var = this.d;
                this.b = 1;
                if (la1Var.a(o41Var, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeResourcesLoader$load$1$updatedNativeAdBlockTask$1", f = "NativeResourcesLoader.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o41>, Object> {
        int b;
        final /* synthetic */ r91 c;
        final /* synthetic */ o3 d;
        final /* synthetic */ Context e;
        final /* synthetic */ o41 f;
        final /* synthetic */ uk1 g;
        final /* synthetic */ aw h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(r91 r91Var, o3 o3Var, Context context, o41 o41Var, uk1 uk1Var, aw awVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = r91Var;
            this.d = o3Var;
            this.e = context;
            this.f = o41Var;
            this.g = uk1Var;
            this.h = awVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, this.d, this.e, this.f, this.g, this.h, continuation);
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
                m91 m91Var = this.c.b;
                o3 o3Var = this.d;
                Context context = this.e;
                o41 o41Var = this.f;
                uk1 uk1Var = this.g;
                aw awVar = this.h;
                this.b = 1;
                m91Var.getClass();
                obj = BuildersKt.withContext(nu.a(), new l91(o3Var, m91Var, context, o41Var, awVar, uk1Var, null), this);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    s91(Context context, c51 c51Var, r91.a aVar, r91 r91Var, o3 o3Var, o41 o41Var, aw awVar, Continuation<? super s91> continuation) {
        super(2, continuation);
        this.e = context;
        this.f = c51Var;
        this.g = aVar;
        this.h = r91Var;
        this.i = o3Var;
        this.j = o41Var;
        this.k = awVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        s91 s91Var = new s91(this.e, this.f, this.g, this.h, this.i, this.j, this.k, continuation);
        s91Var.d = obj;
        return s91Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((s91) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0083  */
    /* JADX WARN: Code duplicated, block: B:20:0x008d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        uk1 uk1Var;
        Deferred deferredAsync$default;
        uk1 uk1Var2;
        o41 o41Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i != 0) {
            if (i == 1) {
                Deferred deferred = this.b;
                uk1 uk1Var3 = (uk1) this.d;
                ResultKt.throwOnFailure(obj);
                deferredAsync$default = deferred;
                uk1Var = uk1Var3;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uk1Var2 = (uk1) this.d;
                ResultKt.throwOnFailure(obj);
            }
            o41Var = (o41) obj;
            if (o41Var == null) {
                this.f.a(w7.d());
            } else {
                this.g.a(uk1Var2, o41Var);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.d;
        uk1Var = new uk1(this.e);
        deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.h, this.i, this.e, this.j, uk1Var, this.k, null), 3, null);
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new a(this.h, this.j, null), 3, null);
        this.d = uk1Var;
        this.b = deferredAsync$default;
        this.c = 1;
        if (jobLaunch$default.join(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.d = uk1Var;
        this.b = null;
        this.c = 2;
        obj = deferredAsync$default.await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        uk1Var2 = uk1Var;
        o41Var = (o41) obj;
        if (o41Var == null) {
            this.f.a(w7.d());
        } else {
            this.g.a(uk1Var2, o41Var);
        }
        return Unit.INSTANCE;
    }
}
