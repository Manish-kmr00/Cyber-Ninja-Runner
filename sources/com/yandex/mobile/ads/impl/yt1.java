package com.yandex.mobile.ads.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: classes10.dex */
@DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1", f = "SdkBidderTokenLoader.kt", i = {0, 0}, l = {106, 75, 80}, m = "invokeSuspend", n = {"this_$iv", "phase$iv"}, s = {"L$0", "L$1"})
final class yt1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    f5 b;
    zt1 c;
    cl d;
    int e;
    private /* synthetic */ Object f;
    final /* synthetic */ zt1 g;
    final /* synthetic */ cl h;
    final /* synthetic */ xs i;

    @DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1$1", f = "SdkBidderTokenLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ xs b;
        final /* synthetic */ l52 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(xs xsVar, l52 l52Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = xsVar;
            this.c = l52Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.b.onBidderTokenLoaded(this.c.a());
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1$2", f = "SdkBidderTokenLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ xs b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(xs xsVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = xsVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.b.a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1$tokenResult$1$stubReason$1$1", f = "SdkBidderTokenLoader.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b = 1;
                if (DelayKt.delay(2000L, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1$tokenResult$1$stubReason$1$2", f = "SdkBidderTokenLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function1<Continuation<? super au1>, Object> {
        d(Continuation<? super d> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super au1> continuation) throws Throwable {
            new d(continuation);
            Unit unit = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(unit);
            return au1.d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return au1.d;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1$tokenResult$1$stubReason$1$3", f = "SdkBidderTokenLoader.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int b;
        final /* synthetic */ zt1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(zt1 zt1Var, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = zt1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return new e(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                pv1 pv1Var = this.c.f;
                dl0 dl0Var = dl0.c;
                this.b = 1;
                obj = pv1Var.a(this);
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

    @DebugMetadata(c = "com.monetization.ads.base.bidder.SdkBidderTokenLoader$loadBidderToken$1$tokenResult$1$stubReason$1$4", f = "SdkBidderTokenLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<Boolean, Continuation<? super au1>, Object> {
        /* synthetic */ boolean b;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(continuation);
            fVar.b = ((Boolean) obj).booleanValue();
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Boolean bool, Continuation<? super au1> continuation) {
            Boolean bool2 = bool;
            bool2.booleanValue();
            f fVar = new f(continuation);
            fVar.b = bool2.booleanValue();
            return fVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            boolean z = this.b;
            au1 au1Var = au1.c;
            if (z) {
                return null;
            }
            return au1Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    yt1(zt1 zt1Var, cl clVar, xs xsVar, Continuation<? super yt1> continuation) {
        super(2, continuation);
        this.g = zt1Var;
        this.h = clVar;
        this.i = xsVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        yt1 yt1Var = new yt1(this.g, this.h, this.i, continuation);
        yt1Var.f = obj;
        return yt1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((yt1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        g5 g5Var;
        f5 adLoadingPhaseType;
        Object objDoSelect;
        cl clVar;
        zt1 zt1Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.e;
        if (i != 0) {
            if (i == 1) {
                cl clVar2 = this.d;
                zt1Var = this.c;
                f5 f5Var = this.b;
                g5 g5Var2 = (g5) this.f;
                ResultKt.throwOnFailure(obj);
                clVar = clVar2;
                adLoadingPhaseType = f5Var;
                g5Var = g5Var2;
                objDoSelect = obj;
            } else {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.g.g.a(tq0.b, this.g);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f;
        this.g.g.b(tq0.b, this.g);
        g5Var = this.g.c;
        adLoadingPhaseType = f5.z;
        zt1 zt1Var2 = this.g;
        cl clVar3 = this.h;
        g5Var.getClass();
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        g5Var.a(adLoadingPhaseType, null);
        SelectImplementation selectImplementation = new SelectImplementation(get$context());
        selectImplementation.invoke(BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new c(null), 3, null).getOnJoin(), new d(null));
        selectImplementation.invoke(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new e(zt1Var2, null), 3, null).getOnAwait(), new f(null));
        this.f = g5Var;
        this.b = adLoadingPhaseType;
        this.c = zt1Var2;
        this.d = clVar3;
        this.e = 1;
        objDoSelect = selectImplementation.doSelect(this);
        if (objDoSelect == coroutine_suspended) {
            return coroutine_suspended;
        }
        clVar = clVar3;
        zt1Var = zt1Var2;
        au1 au1Var = (au1) objDoSelect;
        l52 l52Var = new l52(zt1Var.h.a(zt1Var.b, zt1Var.e, zt1Var.d.c(), clVar, au1Var), au1Var);
        g5Var.a(adLoadingPhaseType);
        if (l52Var.a() != null) {
            this.g.i.a(this.h, l52Var.b());
            MainCoroutineDispatcher mainCoroutineDispatcherB = nu.b();
            a aVar = new a(this.i, l52Var, null);
            this.f = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = 2;
            if (BuildersKt.withContext(mainCoroutineDispatcherB, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            this.g.i.a(this.h);
            MainCoroutineDispatcher mainCoroutineDispatcherB2 = nu.b();
            b bVar = new b(this.i, null);
            this.f = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = 3;
            if (BuildersKt.withContext(mainCoroutineDispatcherB2, bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.g.g.a(tq0.b, this.g);
        return Unit.INSTANCE;
    }
}
