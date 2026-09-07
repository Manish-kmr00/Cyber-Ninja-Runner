package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.p;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f f7088a;
    public final boolean b;
    public final boolean c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a d;
    public final m e;
    public final CoroutineScope f;
    public final MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> g;
    public final Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> h;
    public final String i;
    public final MutableStateFlow<Boolean> j;
    public final StateFlow<Boolean> k;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>> l;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>> m;
    public final boolean n;
    public final String o;
    public final boolean p;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.b q;
    public final n r;
    public final MutableStateFlow<Boolean> s;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> t;
    public final MutableStateFlow<Boolean> u;
    public final StateFlow<Boolean> v;
    public final j w;
    public final g x;
    public boolean y;
    public int z;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$1", f = "LinearControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7089a;
        public /* synthetic */ boolean b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = e.this.new a(continuation);
            aVar.b = ((Boolean) obj).booleanValue();
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7089a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b) {
                e.this.w.d(Boxing.boxInt(e.this.Q()), e.this.i);
            } else {
                e.this.w.c(Boxing.boxInt(e.this.Q()), e.this.i);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$onEvent$1", f = "LinearControllerImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7090a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7090a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = e.this.g;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar = this.c;
                this.f7090a = 1;
                if (mutableSharedFlow.emit(dVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$vastPrivacyIcon$1", f = "LinearControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function3<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7091a;
        public /* synthetic */ boolean b;
        public /* synthetic */ Object c;

        public c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> continuation) {
            c cVar = new c(continuation);
            cVar.b = z;
            cVar.c = jVar;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> continuation) {
            return a(bool.booleanValue(), jVar, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7091a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = this.b;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j) this.c;
            if (z) {
                return jVar;
            }
            return null;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public d() {
            super(0);
        }

        public final void a() {
            e.this.q.a(Integer.valueOf(e.this.Q()), e.this.i);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e$e, reason: collision with other inner class name */
    public static final class C0684e extends Lambda implements Function0<Unit> {
        public C0684e() {
            super(0);
        }

        public final void a() {
            e.this.q.b(Integer.valueOf(e.this.Q()), e.this.i);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f linear, int i, boolean z, Boolean bool, int i2, boolean z2, boolean z3, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, m externalLinkHandler) {
        String absolutePath;
        Intrinsics.checkNotNullParameter(linear, "linear");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        this.f7088a = linear;
        this.b = z2;
        this.c = z3;
        this.d = customUserEventBuilderService;
        this.e = externalLinkHandler;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.f = CoroutineScope;
        MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.g = mutableSharedFlowMutableSharedFlow$default;
        this.h = mutableSharedFlowMutableSharedFlow$default;
        this.i = linear.l();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(z));
        this.j = MutableStateFlow;
        this.k = MutableStateFlow;
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m(Long.valueOf(i)));
        this.l = MutableStateFlow2;
        this.m = FlowKt.asStateFlow(MutableStateFlow2);
        this.n = com.moloco.sdk.service_locator.a.g.f6474a.b().h();
        if (L()) {
            absolutePath = linear.l();
        } else {
            absolutePath = linear.j().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "linear.localMediaResource.absolutePath");
        }
        this.o = absolutePath;
        this.p = linear.h() != null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI = linear.i();
        List<String> listB = eVarI != null ? eVarI.b() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI2 = linear.i();
        this.q = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.b(listB, eVarI2 != null ? eVarI2.g() : null, null, 4, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI3 = linear.i();
        y yVarF = eVarI3 != null ? eVarI3.f() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI4 = linear.i();
        Integer numValueOf = eVarI4 != null ? Integer.valueOf(eVarI4.h()) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI5 = linear.i();
        Integer numValueOf2 = eVarI5 != null ? Integer.valueOf(eVarI5.d()) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI6 = linear.i();
        n nVarA = p.a(yVarF, numValueOf, numValueOf2, eVarI6 != null ? eVarI6.a() : null, CoroutineScope, context, customUserEventBuilderService, externalLinkHandler, new d(), new C0684e());
        this.r = nVarA;
        Boolean bool2 = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(bool2);
        this.s = MutableStateFlow3;
        this.t = FlowKt.stateIn(FlowKt.combine(MutableStateFlow3, nVarA.N(), new c(null)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(bool2);
        this.u = MutableStateFlow4;
        this.v = MutableStateFlow4;
        this.w = j.p.a(linear.n(), customUserEventBuilderService);
        FlowKt.launchIn(FlowKt.onEach(isPlaying(), new a(null)), CoroutineScope);
        this.x = i.a(bool, i2, linear.m());
    }

    public static Object e(e eVar) {
        return Reflection.property0(new PropertyReference0Impl(eVar.x, g.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void E() {
        this.x.t();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void F() {
        this.x.pause();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public String G() {
        return this.o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean J() {
        return this.p;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public boolean L() {
        return this.n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> N() {
        return this.t;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>> P() {
        return this.m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public int Q() {
        return this.z;
    }

    public final void R() {
        this.s.setValue(Boolean.FALSE);
    }

    public final void S() {
        if (this.c) {
            a(false, f.a());
        }
    }

    public final void T() {
        if (this.b) {
            a(false, f.a());
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.f, null, 1, null);
        this.r.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void g() {
        this.y = true;
        this.w.f(Integer.valueOf(Q()), this.i);
        a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d.e.b);
        T();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void h() {
        this.r.h();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public StateFlow<Boolean> isPlaying() {
        return this.v;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d.a> l() {
        return this.x.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public StateFlow<Boolean> q() {
        return this.k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public void r() {
        if (!isPlaying().getValue().booleanValue() && this.l.getValue().a().longValue() == 0 && Q() == 0) {
            return;
        }
        this.l.setValue(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<>(0L));
        this.w.e(Integer.valueOf(Q()), this.i);
        this.y = false;
        this.z = 0;
        this.x.I();
        R();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void v() {
        this.r.v();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> a() {
        return this.h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void b(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
        j jVar = this.w;
        if (z) {
            jVar.b(Integer.valueOf(Q()), this.i);
        } else {
            jVar.g(Integer.valueOf(Q()), this.i);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void c(boolean z) {
        this.u.setValue(Boolean.valueOf(z));
    }

    public final Job a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar) {
        return BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new b(dVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.w.a(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.w.a(buttonType);
    }

    public final void a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar) {
        String strH = this.f7088a.h();
        if (strH != null) {
            if (z) {
                this.w.a(fVar, Integer.valueOf(Q()), this.i);
            }
            this.e.a(strH);
            a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d.a.b);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void b(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        a(true, position);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void b() {
        a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d.c.b);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    public final void b(int i, int i2) {
        int iA;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI = this.f7088a.i();
        if (eVarI == null) {
            return;
        }
        r rVarE = eVarI.e();
        Long lC = eVarI.c();
        boolean z = false;
        if (rVarE instanceof r.a) {
            iA = (i2 / 100) * ((r.a) rVarE).a();
        } else {
            iA = rVarE instanceof r.b ? (int) ((r.b) rVarE).a() : 0;
        }
        int iCoerceIn = RangesKt.coerceIn(iA, (ClosedRange<Integer>) new IntRange(0, i2));
        MutableStateFlow<Boolean> mutableStateFlow = this.s;
        if (lC != null) {
            long j = iCoerceIn;
            long jLongValue = lC.longValue() + j;
            long j2 = i;
            if (j <= j2 && j2 <= jLongValue) {
                z = true;
            }
        } else if (i >= iCoerceIn) {
            z = true;
        }
        mutableStateFlow.setValue(Boolean.valueOf(z));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d.C0683d(error));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress) {
        Pair pair;
        Intrinsics.checkNotNullParameter(progress, "progress");
        boolean z = progress instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a;
        if (z) {
            int iA = (int) ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a) progress).a();
            pair = TuplesKt.to(Integer.valueOf(iA), Integer.valueOf(iA));
        } else if (progress instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.c) progress;
            pair = TuplesKt.to(Integer.valueOf((int) cVar.c()), Integer.valueOf((int) cVar.d()));
        } else if (progress instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d) {
            pair = TuplesKt.to(0, Integer.valueOf((int) ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d) progress).b()));
        } else {
            if (!Intrinsics.areEqual(progress, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.b.b)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        this.z = iIntValue;
        if (!this.y && !(progress instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.d)) {
            this.w.a(this.i, iIntValue, iIntValue2);
        }
        if (z) {
            if (!this.y) {
                a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d.b.b);
                S();
            }
            this.y = false;
        }
        this.x.a(iIntValue, iIntValue2);
        b(iIntValue, iIntValue2);
    }
}
