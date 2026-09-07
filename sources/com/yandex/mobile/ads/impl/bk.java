package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.monetization.ads.mediation.base.model.MediatedAdObjectInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public abstract class bk<T> implements ch1.b, qo, pk.a<o8<T>>, xp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8515a;
    private final g5 b;
    private final o3 c;
    private final CoroutineScope d;
    private final l7 e;
    private final Handler f;
    private final i82 g;
    private final dx1 h;
    private final di i;
    private final bs0 j;
    private final hv1 k;
    private final jf0 l;
    private final ck1 m;
    private final c32 n;
    private final nq1 o;
    private final ch1 p;
    private final y3 q;
    private j5 r;
    private boolean s;
    private long t;
    private t3 u;
    private o8<T> v;

    @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$fetchRequest$1", f = "BaseAdLoadController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object b;
        final /* synthetic */ bk<T> c;
        final /* synthetic */ i82 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(bk<T> bkVar, i82 i82Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = bkVar;
            this.d = i82Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            if (!this.c.a()) {
                String strA = this.d.a(this.c.f());
                if (strA == null || strA.length() == 0) {
                    this.c.b(w7.u());
                } else {
                    g5 g5VarI = this.c.i();
                    f5 f5Var = f5.t;
                    ak.a(g5VarI, f5Var, "adLoadingPhaseType", f5Var, null);
                    this.c.f().a(this.d.a());
                    o3 o3VarF = this.c.f();
                    nq1 nq1Var = ((bk) this.c).o;
                    Context context = this.c.l();
                    nq1Var.getClass();
                    Intrinsics.checkNotNullParameter(context, "context");
                    o3VarF.a(context.getResources().getConfiguration().orientation);
                    zj<T> zjVarA = this.c.a(strA, this.d.a(this.c.l(), this.c.f(), ((bk) this.c).h));
                    zjVarA.b((Object) oa.a(coroutineScope));
                    this.c.g().a(zjVarA);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$loadBiddingData$1", f = "BaseAdLoadController.kt", i = {0}, l = {191, 192}, m = "invokeSuspend", n = {"prefetchedMediationData"}, s = {"L$0"})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        o3 b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ bk<T> e;
        final /* synthetic */ i82 f;
        final /* synthetic */ el g;

        @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$loadBiddingData$1$headerBiddingData$1", f = "BaseAdLoadController.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            int b;
            final /* synthetic */ bk<T> c;
            final /* synthetic */ el d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(bk<T> bkVar, el elVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = bkVar;
                this.d = elVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                return new a(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    jf0 jf0Var = ((bk) this.c).l;
                    Context contextL = this.c.l();
                    el elVar = this.d;
                    this.b = 1;
                    obj = jf0Var.a(contextL, elVar, this);
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

        @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$loadBiddingData$1$prefetchedMediationData$1", f = "BaseAdLoadController.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            int b;
            final /* synthetic */ bk<T> c;
            final /* synthetic */ el d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(bk<T> bkVar, el elVar, Continuation<? super b> continuation) {
                super(2, continuation);
                this.c = bkVar;
                this.d = elVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                return new b(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ck1 ck1Var = ((bk) this.c).m;
                    Context contextL = this.c.l();
                    el elVar = this.d;
                    this.b = 1;
                    obj = ck1Var.a(contextL, elVar, this);
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
        c(bk<T> bkVar, i82 i82Var, el elVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.e = bkVar;
            this.f = i82Var;
            this.g = elVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.e, this.f, this.g, continuation);
            cVar.d = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Deferred deferred;
            o3 o3Var;
            o3 o3Var2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i != 0) {
                if (i == 1) {
                    o3Var = this.b;
                    deferred = (Deferred) this.d;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o3Var2 = (o3) this.d;
                    ResultKt.throwOnFailure(obj);
                }
                o3Var2.e((String) obj);
                this.e.i().a(f5.h);
                this.e.a(this.f);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.d;
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.e, this.g, null), 3, null);
            Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a(this.e, this.g, null), 3, null);
            o3 o3VarF = this.e.f();
            this.d = deferredAsync$default;
            this.b = o3VarF;
            this.c = 1;
            obj = deferredAsync$default2.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = deferredAsync$default;
            o3Var = o3VarF;
            o3Var.d((String) obj);
            o3 o3VarF2 = this.e.f();
            this.d = o3VarF2;
            this.b = null;
            this.c = 2;
            Object objAwait = deferred.await(this);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            o3Var2 = o3VarF2;
            obj = objAwait;
            o3Var2.e((String) obj);
            this.e.i().a(f5.h);
            this.e.a(this.f);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$onUnverifiedMediatedAdLoaded$1", f = "BaseAdLoadController.kt", i = {}, l = {266, 268, 272}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object b;
        int c;
        final /* synthetic */ bk<T> d;
        final /* synthetic */ Object e;
        final /* synthetic */ MediatedAdObjectInfo f;
        final /* synthetic */ Function0<Unit> g;
        final /* synthetic */ Function1<String, Unit> h;

        @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$onUnverifiedMediatedAdLoaded$1$1$1", f = "BaseAdLoadController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function0<Unit> function0, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.b.invoke();
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$onUnverifiedMediatedAdLoaded$1$2$1", f = "BaseAdLoadController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<String, Unit> b;
            final /* synthetic */ Throwable c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(Function1<? super String, Unit> function1, Throwable th, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = function1;
                this.c = th;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.b.invoke(String.valueOf(this.c.getMessage()));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(bk<T> bkVar, Object obj, MediatedAdObjectInfo mediatedAdObjectInfo, Function0<Unit> function0, Function1<? super String, Unit> function1, Continuation<? super d> continuation) {
            super(2, continuation);
            this.d = bkVar;
            this.e = obj;
            this.f = mediatedAdObjectInfo;
            this.g = function0;
            this.h = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.d, this.e, this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0072  */
        /* JADX WARN: Code duplicated, block: B:24:0x0085 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            Object obj2;
            Function1<String, Unit> function1;
            Throwable thM7907exceptionOrNullimpl;
            MainCoroutineDispatcher main;
            b bVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objA = ((Result) obj).getValue();
                } else if (i == 2) {
                    obj2 = this.b;
                    ResultKt.throwOnFailure(obj);
                    function1 = this.h;
                    thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(obj2);
                    if (thM7907exceptionOrNullimpl != null) {
                        main = Dispatchers.getMain();
                        bVar = new b(function1, thM7907exceptionOrNullimpl, null);
                        this.b = obj2;
                        this.c = 3;
                        if (BuildersKt.withContext(main, bVar, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            l7 l7VarJ = this.d.j();
            Object obj3 = this.e;
            o8<?> o8VarK = this.d.k();
            MediatedAdObjectInfo mediatedAdObjectInfo = this.f;
            this.c = 1;
            objA = l7VarJ.a(obj3, o8VarK, mediatedAdObjectInfo, this);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = objA;
            Function0<Unit> function0 = this.g;
            if (Result.m7911isSuccessimpl(obj2)) {
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                a aVar = new a(function0, null);
                this.b = obj2;
                this.c = 2;
                if (BuildersKt.withContext(main2, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            function1 = this.h;
            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(obj2);
            if (thM7907exceptionOrNullimpl != null) {
                main = Dispatchers.getMain();
                bVar = new b(function1, thM7907exceptionOrNullimpl, null);
                this.b = obj2;
                this.c = 3;
                if (BuildersKt.withContext(main, bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    protected abstract zj<T> a(String str, String str2);

    public /* synthetic */ bk(Context context, g5 g5Var, o3 o3Var, CoroutineScope coroutineScope) {
        l7 l7Var = new l7(o3Var, context);
        Handler handler = new Handler(Looper.getMainLooper());
        na naVar = new na();
        dx1 dx1Var = new dx1();
        fi fiVarA = ei.a();
        bs0 bs0Var = new bs0(context, o3Var);
        hv1 hv1Var = new hv1(context, o3Var.q(), coroutineScope, g5Var, null, null, 2097136);
        jf0 jf0Var = new jf0(o3Var);
        ck1 ck1Var = new ck1(o3Var);
        int i = c32.d;
        this(context, g5Var, o3Var, coroutineScope, l7Var, handler, naVar, dx1Var, fiVarA, bs0Var, hv1Var, jf0Var, ck1Var, c32.a.a(), new nq1(), ch1.h.a(context), new z3());
    }

    protected bk(Context context, g5 adLoadingPhasesManager, o3 adConfiguration, CoroutineScope coroutineScope, l7 adQualityVerifierController, Handler handler, i82 adUrlConfigurator, dx1 sensitiveModeChecker, di autograbLoader, bs0 loadStateValidator, hv1 sdkInitializer, jf0 headerBiddingDataLoader, ck1 prefetchedMediationDataLoader, c32 strongReferenceKeepingManager, nq1 resourceUtils, ch1 phoneStateTracker, z3 adFetcherFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(adQualityVerifierController, "adQualityVerifierController");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adUrlConfigurator, "adUrlConfigurator");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        Intrinsics.checkNotNullParameter(autograbLoader, "autograbLoader");
        Intrinsics.checkNotNullParameter(loadStateValidator, "loadStateValidator");
        Intrinsics.checkNotNullParameter(sdkInitializer, "sdkInitializer");
        Intrinsics.checkNotNullParameter(headerBiddingDataLoader, "headerBiddingDataLoader");
        Intrinsics.checkNotNullParameter(prefetchedMediationDataLoader, "prefetchedMediationDataLoader");
        Intrinsics.checkNotNullParameter(strongReferenceKeepingManager, "strongReferenceKeepingManager");
        Intrinsics.checkNotNullParameter(resourceUtils, "resourceUtils");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        Intrinsics.checkNotNullParameter(adFetcherFactory, "adFetcherFactory");
        this.f8515a = context;
        this.b = adLoadingPhasesManager;
        this.c = adConfiguration;
        this.d = coroutineScope;
        this.e = adQualityVerifierController;
        this.f = handler;
        this.g = adUrlConfigurator;
        this.h = sensitiveModeChecker;
        this.i = autograbLoader;
        this.j = loadStateValidator;
        this.k = sdkInitializer;
        this.l = headerBiddingDataLoader;
        this.m = prefetchedMediationDataLoader;
        this.n = strongReferenceKeepingManager;
        this.o = resourceUtils;
        this.p = phoneStateTracker;
        adFetcherFactory.getClass();
        this.q = z3.a(this);
        this.r = j5.c;
    }

    protected final synchronized void a(j5 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        String str = "assignLoadingState, state = " + state;
        op0.a(new Object[0]);
        this.r = state;
    }

    public final Context l() {
        return this.f8515a;
    }

    public final g5 i() {
        return this.b;
    }

    public final o3 f() {
        return this.c;
    }

    public final l7 j() {
        return this.e;
    }

    protected final Handler m() {
        return this.f;
    }

    protected final bs0 n() {
        return this.j;
    }

    protected final hv1 p() {
        return this.k;
    }

    protected final y3 g() {
        return this.q;
    }

    public final o8<T> k() {
        return this.v;
    }

    public final zy1 q() {
        return this.c.r();
    }

    public final boolean h() {
        return this.r == j5.b;
    }

    protected final boolean o() {
        return !this.p.b();
    }

    public synchronized void b(v7 v7Var) {
        String str = "loadAd, state = " + this.r;
        op0.a(new Object[0]);
        if (this.r != j5.d) {
            if (a(v7Var)) {
                this.b.a();
                this.b.b(f5.e);
                this.n.b(tq0.b, this);
                c(v7Var);
            } else {
                r();
            }
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.BaseAdLoadController$loadAutograb$1", f = "BaseAdLoadController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ bk<T> b;
        final /* synthetic */ i82 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(bk<T> bkVar, i82 i82Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = bkVar;
            this.c = i82Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            di diVar = ((bk) this.b).i;
            Context contextL = this.b.l();
            final bk<T> bkVar = this.b;
            final i82 i82Var = this.c;
            diVar.a(contextL, new hi() { // from class: com.yandex.mobile.ads.impl.bk$b$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.hi
                public final void a(String str) {
                    bk.b.a(bkVar, i82Var, str);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(bk bkVar, i82 i82Var, String str) {
            bkVar.i().a(f5.g);
            bkVar.f().b(str);
            bkVar.c(i82Var);
        }
    }

    public final void b(i82 urlConfigurator) {
        Intrinsics.checkNotNullParameter(urlConfigurator, "urlConfigurator");
        g5 g5Var = this.b;
        f5 f5Var = f5.g;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new b(this, urlConfigurator, null), 3, null);
    }

    protected w3 x() {
        return this.j.b();
    }

    public void u() {
        a4.a(this.c.b().a());
        t();
        s();
    }

    public final synchronized void a(i82 urlConfigurator) {
        Intrinsics.checkNotNullParameter(urlConfigurator, "urlConfigurator");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(this, urlConfigurator, null), 3, null);
    }

    public final void t() {
        String strE;
        hp1.c cVar = hp1.c.c;
        hz0 hz0VarI = this.c.i();
        if (hz0VarI == null || (strE = hz0VarI.e()) == null) {
            strE = hp1.a.f9125a;
        }
        xa parametersProvider = new xa(cVar, strE);
        g5 g5Var = this.b;
        f5 adLoadingPhaseType = f5.c;
        g5Var.getClass();
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        Intrinsics.checkNotNullParameter(parametersProvider, "parametersProvider");
        g5Var.a(adLoadingPhaseType, parametersProvider, null);
        this.b.a(f5.e);
        this.n.a(tq0.b, this);
        a(j5.e);
        this.t = SystemClock.elapsedRealtime();
    }

    protected void r() {
        s();
    }

    protected synchronized void s() {
        op0.d(new Object[0]);
        t3 t3Var = this.u;
        if (t3Var != null) {
            t3Var.onAdLoaded();
        }
    }

    public final void v() {
        String str = "registerPhoneStateTracker(), clazz = " + getClass();
        op0.d(new Object[0]);
        this.p.a(this);
    }

    public final void w() {
        String str = "unregisterPhoneStateTracker(), clazz = " + getClass();
        op0.d(new Object[0]);
        this.p.b(this);
    }

    public synchronized void d() {
        if (!a()) {
            this.s = true;
            w();
            this.k.a();
            this.i.a();
            this.q.b();
            this.f.removeCallbacksAndMessages(null);
            this.n.a(tq0.b, this);
            this.v = null;
            CoroutineScopeKt.cancel$default(this.d, null, 1, null);
            op0.f(getClass().toString());
        }
    }

    public void e() {
        d();
        String str = "onDestroy(), clazz = " + getClass();
        op0.d(new Object[0]);
    }

    protected final void c() {
        this.i.a();
    }

    public final void c(i82 urlConfigurator) {
        Intrinsics.checkNotNullParameter(urlConfigurator, "urlConfigurator");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(this.f8515a);
        el elVarN = cu1VarA != null ? cu1VarA.n() : null;
        if (elVarN != null) {
            g5 g5Var = this.b;
            f5 f5Var = f5.h;
            ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
            BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new c(this, urlConfigurator, elVarN, null), 3, null);
            return;
        }
        a(urlConfigurator);
    }

    public void b(final w3 error) {
        String strE;
        Intrinsics.checkNotNullParameter(error, "error");
        dp0.c(error.d(), new Object[0]);
        a(j5.f);
        hp1.c cVar = hp1.c.d;
        hz0 hz0VarI = this.c.i();
        if (hz0VarI == null || (strE = hz0VarI.e()) == null) {
            strE = hp1.a.f9125a;
        }
        xa parametersProvider = new xa(cVar, strE);
        g5 g5Var = this.b;
        f5 adLoadingPhaseType = f5.c;
        g5Var.getClass();
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        Intrinsics.checkNotNullParameter(parametersProvider, "parametersProvider");
        g5Var.a(adLoadingPhaseType, parametersProvider, null);
        this.b.a(f5.e);
        this.n.a(tq0.b, this);
        this.f.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.bk$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                bk.a(this.f$0, error);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.qo
    public final synchronized boolean a() {
        return this.s;
    }

    protected final synchronized void c(v7 v7Var) {
        a(v7Var, this.g);
    }

    protected synchronized boolean a(v7 v7Var) {
        o8<T> o8Var;
        o8Var = this.v;
        return this.r == j5.f || o8Var == null || this.t <= 0 || SystemClock.elapsedRealtime() - this.t > ((long) o8Var.i()) || !((v7Var == null || Intrinsics.areEqual(v7Var, this.c.a())) && hs.a(this.f8515a).a() == this.c.o());
    }

    public final void a(fg1 urlConfigurator) {
        Intrinsics.checkNotNullParameter(urlConfigurator, "urlConfigurator");
        a(j5.d);
        a((i82) urlConfigurator);
    }

    protected synchronized void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        t3 t3Var = this.u;
        if (t3Var != null) {
            t3Var.a(error);
        }
    }

    @Override // com.yandex.mobile.ads.impl.xp1
    public final void b() {
        this.b.a(f5.t);
        g5 g5Var = this.b;
        f5 f5Var = f5.u;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bk this$0, w3 error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.a(error);
    }

    @Override // com.yandex.mobile.ads.impl.qq1.a
    public final void a(ki2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof r3) {
            b(y3.a.a(this.c, ((r3) error).a()));
        }
    }

    @Override // com.yandex.mobile.ads.impl.ch1.b
    public void a(zg1 phoneState) {
        Intrinsics.checkNotNullParameter(phoneState, "phoneState");
        String str = "phoneState = " + phoneState;
        op0.d(new Object[0]);
    }

    @Override // com.yandex.mobile.ads.impl.qq1.b
    public synchronized void a(o8<T> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.b.a(f5.u);
        this.v = adResponse;
    }

    public final void a(Object ad, MediatedAdObjectInfo mediatedAdObjectInfo, Function0<Unit> adAccepted, Function1<? super String, Unit> adBlocked) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adAccepted, "adAccepted");
        Intrinsics.checkNotNullParameter(adBlocked, "adBlocked");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new d(this, ad, mediatedAdObjectInfo, adAccepted, adBlocked, null), 3, null);
    }

    public final void a(yi yiVar) {
        this.u = yiVar;
    }

    public void a(String str) {
        this.c.a(str);
    }

    public final void a(zy1 zy1Var) {
        this.c.a(zy1Var);
    }

    protected final synchronized void a(final v7 v7Var, final i82 urlConfigurator) {
        Intrinsics.checkNotNullParameter(urlConfigurator, "urlConfigurator");
        a(j5.d);
        this.f.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.bk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                bk.a(this.f$0, v7Var, urlConfigurator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bk this$0, v7 v7Var, i82 urlConfigurator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(urlConfigurator, "$urlConfigurator");
        this$0.c.a(v7Var);
        w3 w3VarX = this$0.x();
        if (w3VarX == null) {
            this$0.k.a(dl0.d, new ck(this$0, urlConfigurator));
        } else {
            this$0.b(w3VarX);
        }
    }
}
