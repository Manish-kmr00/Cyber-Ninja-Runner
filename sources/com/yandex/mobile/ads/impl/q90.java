package com.yandex.mobile.ads.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes9.dex */
public final class q90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Flow<j90> f9998a;
    private final aa0 b;
    private final CoroutineScope c;
    private final Mutex d;
    private final MutableStateFlow<ba0> e;
    private final StateFlow<ia0> f;

    public /* synthetic */ q90(MutableSharedFlow mutableSharedFlow, aa0 aa0Var) {
        this(mutableSharedFlow, aa0Var, CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))));
    }

    public q90(MutableSharedFlow feedInputEventFlow, aa0 repo, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(feedInputEventFlow, "feedInputEventFlow");
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f9998a = feedInputEventFlow;
        this.b = repo;
        this.c = coroutineScope;
        this.d = MutexKt.Mutex$default(false, 1, null);
        ba0.b bVar = ba0.b.f8485a;
        MutableStateFlow<ba0> MutableStateFlow = StateFlowKt.MutableStateFlow(bVar);
        this.e = MutableStateFlow;
        this.f = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow, repo.a(), new p90(null)), coroutineScope, SharingStarted.INSTANCE.getEagerly(), new ia0(bVar, CollectionsKt.emptyList()));
    }

    @DebugMetadata(c = "com.monetization.ads.feed.domain.FeedItemListUseCase$invoke$1", f = "FeedItemListUseCase.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return q90.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return q90.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = q90.this.f9998a;
                C0755a c0755a = new C0755a(q90.this);
                this.b = 1;
                if (flow.collect(c0755a, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.q90$a$a, reason: collision with other inner class name */
        static final class C0755a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ q90 f9999a;

            C0755a(q90 q90Var) {
                this.f9999a = q90Var;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) throws Throwable {
                if (((j90) obj) instanceof j90.a) {
                    Object objA = q90.a(this.f9999a, continuation);
                    return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object a(q90 q90Var, Continuation continuation) throws Throwable {
        r90 r90Var;
        q90Var.getClass();
        if (continuation instanceof r90) {
            r90Var = (r90) continuation;
            int i = r90Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                r90Var.e = i - Integer.MIN_VALUE;
            } else {
                r90Var = new r90(q90Var, continuation);
            }
        } else {
            r90Var = new r90(q90Var, continuation);
        }
        Object objB = r90Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = r90Var.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objB);
            if (Mutex.DefaultImpls.tryLock$default(q90Var.d, null, 1, null)) {
                MutableStateFlow<ba0> mutableStateFlow = q90Var.e;
                while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), ba0.d.f8487a)) {
                }
                aa0 aa0Var = q90Var.b;
                r90Var.b = q90Var;
                r90Var.e = 1;
                objB = aa0Var.b(r90Var);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q90Var = r90Var.b;
        ResultKt.throwOnFailure(objB);
        q90 q90Var2 = q90Var;
        vk1 vk1Var = (vk1) objB;
        if (vk1Var instanceof vk1.a) {
            MutableStateFlow<ba0> mutableStateFlow2 = q90Var2.e;
            while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), new ba0.a(((vk1.a) vk1Var).a()))) {
            }
        } else {
            MutableStateFlow<ba0> mutableStateFlow3 = q90Var2.e;
            while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), ba0.c.f8486a)) {
            }
        }
        Mutex.DefaultImpls.unlock$default(q90Var2.d, null, 1, null);
        return Unit.INSTANCE;
    }

    public final StateFlow<ia0> a() {
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(null), 3, null);
        return this.f;
    }
}
