package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes5.dex */
public final class ka0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9397a;
    private final MutableSharedFlow<j90> b;
    private final CoroutineScope c;
    private ys d;
    private final StateFlow<ia0> e;
    private final AtomicInteger f;

    @DebugMetadata(c = "com.monetization.ads.feed.ui.FeedViewModel$onFeedItemVisible$1", f = "FeedViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ka0.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ka0.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = ka0.this.b;
                j90.a aVar = j90.a.f9295a;
                this.b = 1;
                if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.monetization.ads.feed.ui.FeedViewModel$preloadAd$1", f = "FeedViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ka0.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ka0.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = ka0.this.b;
                j90.a aVar = j90.a.f9295a;
                this.b = 1;
                if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
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

    public ka0(Context appContext, wm2 sdkEnvironmentModule, v7 adRequestData, h90 divContextProvider, i90 divViewPreloader, o3 adConfiguration, MutableSharedFlow feedInputEventFlow, t90 feedItemLoadControllerCreator, u90 feedItemLoadDataSource, y90 feedItemPreloadDataSource, f01 memoryUtils, v90 loadEnoughMemoryValidator, aa0 feedItemsRepository, q90 feedItemListUseCase, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(divContextProvider, "divContextProvider");
        Intrinsics.checkNotNullParameter(divViewPreloader, "divViewPreloader");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(feedInputEventFlow, "feedInputEventFlow");
        Intrinsics.checkNotNullParameter(feedItemLoadControllerCreator, "feedItemLoadControllerCreator");
        Intrinsics.checkNotNullParameter(feedItemLoadDataSource, "feedItemLoadDataSource");
        Intrinsics.checkNotNullParameter(feedItemPreloadDataSource, "feedItemPreloadDataSource");
        Intrinsics.checkNotNullParameter(memoryUtils, "memoryUtils");
        Intrinsics.checkNotNullParameter(loadEnoughMemoryValidator, "loadEnoughMemoryValidator");
        Intrinsics.checkNotNullParameter(feedItemsRepository, "feedItemsRepository");
        Intrinsics.checkNotNullParameter(feedItemListUseCase, "feedItemListUseCase");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f9397a = adConfiguration;
        this.b = feedInputEventFlow;
        this.c = coroutineScope;
        this.e = feedItemListUseCase.a();
        this.f = new AtomicInteger(-1);
        e();
    }

    public final ys b() {
        return this.d;
    }

    public final StateFlow<ia0> c() {
        return this.e;
    }

    public final AtomicInteger d() {
        return this.f;
    }

    public final void f() {
        if (this.e.getValue().b().isEmpty() && this.f.get() == -1 && !(this.e.getValue().c() instanceof ba0.a)) {
            this.f.getAndIncrement();
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new c(null), 3, null);
            return;
        }
        w3 w3VarS = w7.s();
        ys ysVar = this.d;
        if (ysVar != null) {
            ysVar.a(w3VarS);
        }
    }

    public final o3 a() {
        return this.f9397a;
    }

    public final void a(int i) {
        if ((this.e.getValue().c() instanceof ba0.a) || i != this.f.get()) {
            return;
        }
        this.f.getAndIncrement();
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(null), 3, null);
    }

    public final void a(a90 a90Var) {
        this.d = a90Var;
    }

    @DebugMetadata(c = "com.monetization.ads.feed.ui.FeedViewModel$observeLoadingState$1", f = "FeedViewModel.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;
        private /* synthetic */ Object c;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = ka0.this.new a(continuation);
            aVar.c = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            a aVar = ka0.this.new a(continuation);
            aVar.c = coroutineScope;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.c;
                Flow flowDistinctUntilChangedBy = FlowKt.distinctUntilChangedBy(ka0.this.c(), C0750a.b);
                b bVar = new b(ka0.this, coroutineScope);
                this.b = 1;
                if (flowDistinctUntilChangedBy.collect(bVar, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.ka0$a$a, reason: collision with other inner class name */
        static final class C0750a extends Lambda implements Function1<ia0, ba0> {
            public static final C0750a b = new C0750a();

            C0750a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ba0 invoke(ia0 ia0Var) {
                ia0 ia0Var2 = ia0Var;
                Intrinsics.checkNotNullParameter(ia0Var2, "<name for destructuring parameter 0>");
                return ia0Var2.a();
            }
        }

        static final class b<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ka0 f9398a;
            final /* synthetic */ CoroutineScope b;

            b(ka0 ka0Var, CoroutineScope coroutineScope) {
                this.f9398a = ka0Var;
                this.b = coroutineScope;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                ia0 ia0Var = (ia0) obj;
                ba0 ba0VarC = ia0Var.c();
                if (ba0VarC instanceof ba0.a) {
                    w3 w3VarA = ((ba0.a) ia0Var.c()).a();
                    ys ysVarB = this.f9398a.b();
                    if (ysVarB != null) {
                        ysVarB.a(w3VarA);
                    }
                    CoroutineScopeKt.cancel$default(this.b, w3VarA.d(), null, 2, null);
                } else if (ba0VarC instanceof ba0.c) {
                    ys ysVarB2 = this.f9398a.b();
                    if (ysVarB2 != null) {
                        ysVarB2.onAdLoaded();
                    }
                } else if (!(ba0VarC instanceof ba0.b)) {
                    boolean z = ba0VarC instanceof ba0.d;
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void e() {
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(null), 3, null);
    }
}
