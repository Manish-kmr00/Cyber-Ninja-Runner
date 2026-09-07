package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6529a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;
    public final com.moloco.sdk.internal.ortb.model.c c;
    public final m d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t e;
    public final String f;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h g;
    public final CoroutineScope h;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s> i;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> j;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> k;
    public final q l;
    public final MutableStateFlow<Boolean> m;
    public final StateFlow<Boolean> n;
    public final MutableStateFlow<Boolean> o;
    public final StateFlow<Boolean> p;
    public final MutableStateFlow<Boolean> q;
    public final StateFlow<Boolean> r;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6530a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.MRAID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.STATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6530a = iArr;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$load$1", f = "AggregatedFullscreenAd.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6531a;
        public final /* synthetic */ long c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a d;

        public static final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a f6532a;
            public final /* synthetic */ c b;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0589a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f6533a;

                static {
                    int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.values().length];
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.MRAID.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.STATIC.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f6533a = iArr;
                }
            }

            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, c cVar) {
                this.f6532a = aVar;
                this.b = cVar;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a() {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar = this.f6532a;
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar;
                Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h creativeType = this.b.getCreativeType();
                int i = creativeType == null ? -1 : C0589a.f6533a[creativeType.ordinal()];
                if (i == -1) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, this.b.f, "creativeType is null", null, false, 12, null);
                    return;
                }
                if (i == 1) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar2 = this.f6532a;
                    if (aVar2 != null) {
                        aVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i == 3 && (aVar = this.f6532a) != null) {
                        aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.STATIC_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                        return;
                    }
                    return;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar3 = this.f6532a;
                if (aVar3 != null) {
                    aVar3.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.MRAID_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                }
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                Intrinsics.checkNotNullParameter(internalError, "internalError");
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar = this.f6532a;
                if (aVar != null) {
                    aVar.a(internalError);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6531a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c cVar = c.this;
                this.f6531a = 1;
                if (cVar.b(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k kVarN = c.this.n();
            if (kVarN != null) {
                kVarN.a(this.c, new a(this.d, c.this));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$c, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd", f = "AggregatedFullscreenAd.kt", i = {0}, l = {66}, m = "prepareAd", n = {"this"}, s = {"L$0"})
    public static final class C0590c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6534a;
        public /* synthetic */ Object b;
        public int d;

        public C0590c(Continuation<? super C0590c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return c.this.b(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$2", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6535a;
        public /* synthetic */ boolean b;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = c.this.new d(continuation);
            dVar.b = ((Boolean) obj).booleanValue();
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6535a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c.this.m.setValue(Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$3", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6536a;
        public /* synthetic */ boolean b;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((e) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = c.this.new e(continuation);
            eVar.b = ((Boolean) obj).booleanValue();
            return eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6536a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c.this.o.setValue(Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$4", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6537a;
        public /* synthetic */ boolean b;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((f) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = c.this.new f(continuation);
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
            if (this.f6537a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c.this.q.setValue(Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$crType$1", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6538a;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6538a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h hVarC = h.f6567a.c(c.this.c.a());
            c.this.g = hVarC;
            return hVarC;
        }
    }

    public c(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h hVar, com.moloco.sdk.internal.ortb.model.c bid, m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        this.f6529a = context;
        this.b = customUserEventBuilderService;
        this.c = bid;
        this.d = externalLinkHandler;
        this.e = watermark;
        this.f = "AggregatedFullscreenAd";
        this.g = hVar;
        this.h = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.l = new q();
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.m = MutableStateFlow;
        this.n = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.o = MutableStateFlow2;
        this.p = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(bool);
        this.q = MutableStateFlow3;
        this.r = MutableStateFlow3;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<?, ?> kVarN = n();
        if (kVarN != null) {
            kVarN.destroy();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h getCreativeType() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public StateFlow<Boolean> isLoaded() {
        return this.n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public StateFlow<Boolean> j() {
        return this.r;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    public StateFlow<Boolean> l() {
        return this.p;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<?, ?> n() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s> kVar = this.i;
        if (kVar != null) {
            return kVar;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> kVar2 = this.j;
        return kVar2 == null ? this.k : kVar2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    /* JADX WARN: Code duplicated, block: B:29:0x006d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    /* JADX WARN: Code duplicated, block: B:31:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Continuation<? super Unit> continuation) throws Throwable {
        C0590c c0590c;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h creativeType;
        c cVar;
        int i;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<?, ?> kVarN;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<?, ?> kVarN2;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<?, ?> kVarN3;
        StateFlow<Boolean> stateFlowJ;
        Flow flowOnEach;
        StateFlow<Boolean> stateFlowL;
        Flow flowOnEach2;
        StateFlow<Boolean> stateFlowIsLoaded;
        Flow flowOnEach3;
        if (continuation instanceof C0590c) {
            c0590c = (C0590c) continuation;
            int i2 = c0590c.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0590c.d = i2 - Integer.MIN_VALUE;
            } else {
                c0590c = new C0590c(continuation);
            }
        } else {
            c0590c = new C0590c(continuation);
        }
        Object objWithContext = c0590c.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c0590c.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            creativeType = getCreativeType();
            if (creativeType == null) {
                CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
                g gVar = new g(null);
                c0590c.f6534a = this;
                c0590c.d = 1;
                objWithContext = BuildersKt.withContext(coroutineContext, gVar, c0590c);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cVar = this;
            } else {
                cVar = this;
            }
            i = a.f6530a[creativeType.ordinal()];
            if (i != 1) {
                cVar.i = cVar.l.a(cVar.f6529a, cVar.c, com.moloco.sdk.service_locator.a.g.f6474a.b().h(), cVar.e);
            } else if (i != 2) {
                cVar.j = cVar.l.a(cVar.f6529a, cVar.h, cVar.c, cVar.d, cVar.e, cVar.o);
            } else if (i == 3) {
                cVar.k = cVar.l.a(cVar.f6529a, cVar.b, cVar.c.a(), cVar.d, cVar.e);
            }
            kVarN = cVar.n();
            if (kVarN != null && (stateFlowIsLoaded = kVarN.isLoaded()) != null && (flowOnEach3 = FlowKt.onEach(stateFlowIsLoaded, cVar.new d(null))) != null) {
                FlowKt.launchIn(flowOnEach3, cVar.h);
            }
            kVarN2 = cVar.n();
            if (kVarN2 != null && (stateFlowL = kVarN2.l()) != null && (flowOnEach2 = FlowKt.onEach(stateFlowL, cVar.new e(null))) != null) {
                FlowKt.launchIn(flowOnEach2, cVar.h);
            }
            kVarN3 = cVar.n();
            if (kVarN3 != null && (stateFlowJ = kVarN3.j()) != null && (flowOnEach = FlowKt.onEach(stateFlowJ, cVar.new f(null))) != null) {
                FlowKt.launchIn(flowOnEach, cVar.h);
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        cVar = (c) c0590c.f6534a;
        ResultKt.throwOnFailure(objWithContext);
        creativeType = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h) objWithContext;
        i = a.f6530a[creativeType.ordinal()];
        if (i != 1) {
            cVar.i = cVar.l.a(cVar.f6529a, cVar.c, com.moloco.sdk.service_locator.a.g.f6474a.b().h(), cVar.e);
        } else if (i != 2) {
            cVar.j = cVar.l.a(cVar.f6529a, cVar.h, cVar.c, cVar.d, cVar.e, cVar.o);
        } else if (i == 3) {
            cVar.k = cVar.l.a(cVar.f6529a, cVar.b, cVar.c.a(), cVar.d, cVar.e);
        }
        kVarN = cVar.n();
        if (kVarN != null) {
            FlowKt.launchIn(flowOnEach3, cVar.h);
        }
        kVarN2 = cVar.n();
        if (kVarN2 != null) {
            FlowKt.launchIn(flowOnEach2, cVar.h);
        }
        kVarN3 = cVar.n();
        if (kVarN3 != null) {
            FlowKt.launchIn(flowOnEach, cVar.h);
        }
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
        BuildersKt__Builders_commonKt.launch$default(this.h, null, null, new b(j, aVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(options, "options");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s> kVar = this.i;
        if (kVar != null) {
            kVar.a(options.c(), fVar);
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> kVar2 = this.j;
        if (kVar2 != null) {
            kVar2.a(options.a(), fVar);
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> kVar3 = this.k;
        if (kVar3 != null) {
            kVar3.a(options.b(), fVar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null || fVar == null) {
            return;
        }
        fVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.b.FULLSCREEN_AD_SHOW_FAILED_NO_SUPPORTED_TYPE);
        Unit unit4 = Unit.INSTANCE;
    }
}
