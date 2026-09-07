package com.yandex.mobile.ads.impl;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes11.dex */
public final class bp0 extends ah2 {
    private final ke0 b;
    private final o32 c;
    private final je0 d;
    private final ie0 e;
    private final he0 f;
    private final le0 g;
    private final hx h;
    private final la i;
    private final ia j;
    private final fa k;
    private final tz0 l;
    private final MutableStateFlow<dy> m;
    private final StateFlow<dy> n;
    private final Channel<ay> o;
    private final Flow<ay> p;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.ui.viewmodel.IntegrationInspectorViewModel$sendEvent$1", f = "IntegrationInspectorViewModel.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;
        final /* synthetic */ ay d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ay ayVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = ayVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return bp0.this.new a(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return bp0.this.new a(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel channel = bp0.this.o;
                ay ayVar = this.d;
                this.b = 1;
                if (channel.send(ayVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.ui.viewmodel.IntegrationInspectorViewModel$shareReport$1", f = "IntegrationInspectorViewModel.kt", i = {}, l = {Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return bp0.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return bp0.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ay cVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ke0 ke0Var = bp0.this.b;
                this.b = 1;
                obj = ke0Var.a(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            il0 il0Var = (il0) obj;
            if (il0Var instanceof il0.c) {
                cVar = new ay.d(((il0.c) il0Var).a());
            } else if (il0Var instanceof il0.a) {
                cVar = new ay.c(((il0.a) il0Var).a());
            } else {
                if (!(il0Var instanceof il0.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                cVar = ay.b.f8453a;
            }
            bp0.this.a(cVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.ui.viewmodel.IntegrationInspectorViewModel$showMessage$1", f = "IntegrationInspectorViewModel.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return bp0.this.new c(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return bp0.this.new c(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel channel = bp0.this.o;
                ay.e eVar = new ay.e(this.d);
                this.b = 1;
                if (channel.send(eVar, this) == coroutine_suspended) {
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

    public bp0(ke0 getInspectorReportUseCase, o32 switchDebugErrorIndicatorVisibilityUseCase, je0 getDebugPanelFeedDataUseCase, ie0 getAdUnitsDataUseCase, he0 getAdUnitDataUseCase, le0 getMediationNetworkDataUseCase, hx debugPanelFeedUiMapper, la adUnitsUiMapper, ia adUnitUiMapper, fa adUnitMediationAdapterUiMapper, tz0 mediationNetworkUiMapper) {
        Intrinsics.checkNotNullParameter(getInspectorReportUseCase, "getInspectorReportUseCase");
        Intrinsics.checkNotNullParameter(switchDebugErrorIndicatorVisibilityUseCase, "switchDebugErrorIndicatorVisibilityUseCase");
        Intrinsics.checkNotNullParameter(getDebugPanelFeedDataUseCase, "getDebugPanelFeedDataUseCase");
        Intrinsics.checkNotNullParameter(getAdUnitsDataUseCase, "getAdUnitsDataUseCase");
        Intrinsics.checkNotNullParameter(getAdUnitDataUseCase, "getAdUnitDataUseCase");
        Intrinsics.checkNotNullParameter(getMediationNetworkDataUseCase, "getMediationNetworkDataUseCase");
        Intrinsics.checkNotNullParameter(debugPanelFeedUiMapper, "debugPanelFeedUiMapper");
        Intrinsics.checkNotNullParameter(adUnitsUiMapper, "adUnitsUiMapper");
        Intrinsics.checkNotNullParameter(adUnitUiMapper, "adUnitUiMapper");
        Intrinsics.checkNotNullParameter(adUnitMediationAdapterUiMapper, "adUnitMediationAdapterUiMapper");
        Intrinsics.checkNotNullParameter(mediationNetworkUiMapper, "mediationNetworkUiMapper");
        this.b = getInspectorReportUseCase;
        this.c = switchDebugErrorIndicatorVisibilityUseCase;
        this.d = getDebugPanelFeedDataUseCase;
        this.e = getAdUnitsDataUseCase;
        this.f = getAdUnitDataUseCase;
        this.g = getMediationNetworkDataUseCase;
        this.h = debugPanelFeedUiMapper;
        this.i = adUnitsUiMapper;
        this.j = adUnitUiMapper;
        this.k = adUnitMediationAdapterUiMapper;
        this.l = mediationNetworkUiMapper;
        MutableStateFlow<dy> MutableStateFlow = StateFlowKt.MutableStateFlow(new dy(null, cx.d.b, false, CollectionsKt.emptyList()));
        this.m = MutableStateFlow;
        this.n = FlowKt.asStateFlow(MutableStateFlow);
        Channel<ay> channelChannel$default = ChannelKt.Channel$default(0, null, null, 7, null);
        this.o = channelChannel$default;
        this.p = FlowKt.receiveAsFlow(channelChannel$default);
    }

    public static final void m(bp0 bp0Var) {
        dy dyVarB = bp0Var.m.getValue().b();
        if (dyVarB == null) {
            bp0Var.a(ay.a.f8452a);
            return;
        }
        dy dyVarA = dy.a(dyVarB, null, null, false, null, 11);
        MutableStateFlow<dy> mutableStateFlow = bp0Var.m;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), dyVarA)) {
        }
    }

    private final void f() {
        BuildersKt__Builders_commonKt.launch$default(b(), null, null, new cp0(this, false, null), 3, null);
    }

    public static final void a(bp0 bp0Var, dy dyVar) {
        MutableStateFlow<dy> mutableStateFlow = bp0Var.m;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), dyVar)) {
        }
    }

    public final void a(zx action) {
        cx eVar;
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof zx.a) {
            f();
            return;
        }
        if (action instanceof zx.g) {
            e();
            return;
        }
        if (action instanceof zx.e) {
            this.c.a();
            f();
            return;
        }
        if (action instanceof zx.d) {
            dy dyVarB = this.m.getValue().b();
            if (dyVarB == null) {
                a(ay.a.f8452a);
                return;
            }
            dy dyVarA = dy.a(dyVarB, null, null, false, null, 11);
            MutableStateFlow<dy> mutableStateFlow = this.m;
            while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), dyVarA)) {
            }
            return;
        }
        if (action instanceof zx.c) {
            cx.c cVar = cx.c.b;
            dy value = this.m.getValue();
            dy dyVarA2 = dy.a(value, value, cVar, false, null, 12);
            MutableStateFlow<dy> mutableStateFlow2 = this.m;
            while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), dyVarA2)) {
            }
            f();
            return;
        }
        if (action instanceof zx.b) {
            cx.a aVar = new cx.a(((zx.b) action).a());
            dy value2 = this.m.getValue();
            dy dyVarA3 = dy.a(value2, value2, aVar, false, null, 12);
            MutableStateFlow<dy> mutableStateFlow3 = this.m;
            while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), dyVarA3)) {
            }
            f();
            return;
        }
        if (action instanceof zx.f) {
            cx cxVarA = this.m.getValue().a();
            fy.g gVarA = ((zx.f) action).a();
            if (cxVarA instanceof cx.a) {
                eVar = new cx.b(gVarA);
            } else {
                eVar = new cx.e(gVarA.f());
            }
            dy value3 = this.m.getValue();
            dy dyVarA4 = dy.a(value3, value3, eVar, false, null, 12);
            MutableStateFlow<dy> mutableStateFlow4 = this.m;
            while (!mutableStateFlow4.compareAndSet(mutableStateFlow4.getValue(), dyVarA4)) {
            }
            f();
            return;
        }
        if (action instanceof zx.h) {
            a(((zx.h) action).a());
        }
    }

    public final StateFlow<dy> d() {
        return this.n;
    }

    public final Flow<ay> c() {
        return this.p;
    }

    private final void e() {
        BuildersKt__Builders_commonKt.launch$default(b(), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job a(ay ayVar) {
        return BuildersKt__Builders_commonKt.launch$default(b(), null, null, new a(ayVar, null), 3, null);
    }

    private final void a(String str) {
        BuildersKt__Builders_commonKt.launch$default(b(), null, null, new c(str, null), 3, null);
    }
}
