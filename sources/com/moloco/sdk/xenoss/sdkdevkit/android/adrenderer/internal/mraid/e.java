package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes7.dex */
public class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6629a;
    public final q b;
    public Function0<Unit> c;
    public Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m e;
    public final boolean f;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f g;
    public final String h;
    public final CoroutineScope i;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c j;
    public s k;
    public final t l;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6630a = new a();

        public a() {
            super(0);
        }

        public final void a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6631a = new b();

        public b() {
            super(1);
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
            a(dVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$loadAndReadyMraid$2", f = "MraidBaseAd.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6632a;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6632a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVarT = e.this.t();
                String str = e.this.f6629a;
                this.f6632a = 1;
                obj = fVarT.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            boolean z = vVar instanceof com.moloco.sdk.internal.v.a;
            if (z) {
                return vVar;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVarT2 = e.this.t();
            e eVar = e.this;
            fVarT2.a(false, false, false, false, true);
            fVarT2.a(eVar.b);
            fVarT2.d(eVar.l.l().getValue().booleanValue());
            fVarT2.a(eVar.l.j().getValue().a());
            eVar.b(s.Default);
            eVar.T();
            eVar.U();
            eVar.V();
            fVarT2.i();
            e eVar2 = e.this;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, eVar2.h, "Mraid Html data successfully loaded", null, false, 12, null);
                cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((com.moloco.sdk.internal.v.b) vVar).a();
            } else {
                if (!z) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar2.h, "Mraid Html data load failed.", null, false, 12, null);
                cVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c(null, 1, null);
            }
            eVar2.j = cVar;
            return vVar;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToErrors$1", f = "MraidBaseAd.kt", i = {}, l = {TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6633a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6634a;

            static {
                int[] iArr = new int[q.values().length];
                try {
                    iArr[q.Interstitial.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[q.Inline.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f6634a = iArr;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToErrors$1$error$1", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6635a;
            public /* synthetic */ Object b;

            public b(Continuation<? super b> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, Continuation<? super Boolean> continuation) {
                return ((b) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(continuation);
                bVar.b = obj;
                return bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6635a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) this.b) != null);
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6633a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> stateFlowX = e.this.t().x();
                b bVar = new b(null);
                this.f6633a = 1;
                obj = FlowKt.first(stateFlowX, bVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) obj;
            if (dVar != null) {
                e eVar = e.this;
                int i2 = a.f6634a[eVar.b.ordinal()];
                if (i2 == 1) {
                    eVar.J().invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
                } else if (i2 == 2) {
                    eVar.J().invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.a(dVar));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e$e, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToMraidJsCommands$1", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0606e extends SuspendLambda implements Function2<n, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6636a;
        public /* synthetic */ Object b;

        public C0606e(Continuation<? super C0606e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n nVar, Continuation<? super Unit> continuation) {
            return ((C0606e) create(nVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0606e c0606e = e.this.new C0606e(continuation);
            c0606e.b = obj;
            return c0606e;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6636a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            n nVar = (n) this.b;
            if (Intrinsics.areEqual(nVar, n.a.h)) {
                e.this.R();
            } else if (nVar instanceof n.d) {
                e.this.a((n.d) nVar);
            } else if (!(nVar instanceof n.f)) {
                if (nVar instanceof n.c) {
                    e.this.a((n.c) nVar);
                } else {
                    e.this.t().a(nVar, "unsupported command: " + nVar.a());
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToVisualMetricsChanges$1", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6637a;
        public /* synthetic */ boolean b;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((f) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = e.this.new f(continuation);
            fVar.b = ((Boolean) obj).booleanValue();
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6637a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e.this.t().d(this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToVisualMetricsChanges$2", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<t.a, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6638a;
        public /* synthetic */ Object b;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(t.a aVar, Continuation<? super Unit> continuation) {
            return ((g) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g gVar = e.this.new g(continuation);
            gVar.b = obj;
            return gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6638a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e.this.t().a(((t.a) this.b).a());
            return Unit.INSTANCE;
        }
    }

    public e(Context context, String adm, q mraidPlacementType, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> onError, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f mraidBridge) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(mraidPlacementType, "mraidPlacementType");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        this.f6629a = adm;
        this.b = mraidPlacementType;
        this.c = onClick;
        this.d = onError;
        this.e = externalLinkHandler;
        this.f = z;
        this.g = mraidBridge;
        this.h = "MraidBaseAd";
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.i = CoroutineScope;
        this.l = new t(mraidBridge.c(), context, CoroutineScope);
    }

    public final Function0<Unit> I() {
        return this.c;
    }

    public final Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> J() {
        return this.d;
    }

    public final void R() {
        if (this.l.l().getValue().booleanValue()) {
            l();
        } else {
            this.g.a(n.a.h, "Can't close ad when mraid container is not visible to the user");
        }
    }

    public void S() {
    }

    public final void T() {
        BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new d(null), 3, null);
    }

    public final void U() {
        FlowKt.launchIn(FlowKt.onEach(this.g.w(), new C0606e(null)), this.i);
    }

    public final void V() {
        FlowKt.launchIn(FlowKt.onEach(this.l.l(), new f(null)), this.i);
        FlowKt.launchIn(FlowKt.onEach(this.l.j(), new g(null)), this.i);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.i, null, 1, null);
        this.g.destroy();
        this.l.destroy();
    }

    public void l() {
        if (this.k == s.Expanded) {
            b(s.Default);
        }
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f t() {
        return this.g;
    }

    public final void b(s sVar) {
        this.k = sVar;
        if (sVar != null) {
            this.g.a(sVar);
        }
    }

    public final Object b(Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
        return BuildersKt__Builders_commonKt.async$default(this.i, null, null, new c(null), 3, null).await(continuation);
    }

    public final void a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.c = function0;
    }

    public final void a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.d = function1;
    }

    public final void a(n.d dVar) {
        if (this.l.l().getValue().booleanValue()) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar = this.e;
            String string = dVar.b().toString();
            Intrinsics.checkNotNullExpressionValue(string, "openCmd.uri.toString()");
            mVar.a(string);
            this.c.invoke();
            return;
        }
        this.g.a(dVar, "Can't open links when mraid container is not visible to the user");
    }

    public final void a(n.c cVar) {
        if (this.f) {
            this.g.a(cVar, "expand() is force blocked for the current ad");
            return;
        }
        if (!this.l.l().getValue().booleanValue()) {
            this.g.a(cVar, "Can't expand() when mraid container is not visible to the user");
            return;
        }
        if (this.k != s.Default) {
            this.g.a(cVar, "In order to expand() mraid ad, container must be in Default view state");
            return;
        }
        if (this.b == q.Interstitial) {
            this.g.a(cVar, "expand() is not supported for interstitials");
        } else if (cVar.b() != null) {
            this.g.a(cVar, "Two-part expand is not supported yet");
        } else {
            S();
            b(s.Expanded);
        }
    }

    public /* synthetic */ e(Context context, String str, q qVar, Function0 function0, Function1 function1, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, qVar, (i & 8) != 0 ? a.f6630a : function0, (i & 16) != 0 ? b.f6631a : function1, mVar, (i & 64) != 0 ? false : z, fVar);
    }
}
