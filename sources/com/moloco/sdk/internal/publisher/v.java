package com.moloco.sdk.internal.publisher;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.i0;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes10.dex */
public final class v {
    public static final a f = new a(null);
    public static final MolocoInitStatus g;
    public static final MolocoInitStatus h;
    public static final String i = "InitializationHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f6282a;
    public final MutableStateFlow<Initialization> b;
    public final StateFlow<Initialization> c;
    public Init.SDKInitResponse d;
    public final MutableStateFlow<com.moloco.sdk.internal.a> e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MolocoInitStatus a() {
            return v.g;
        }

        public final MolocoInitStatus b() {
            return v.h;
        }

        public a() {
        }

        public final MolocoInitStatus a(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new MolocoInitStatus(Initialization.FAILURE, errorMessage);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", i = {}, l = {85}, m = "awaitAdFactory", n = {}, s = {})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6283a;
        public int c;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6283a = obj;
            this.c |= Integer.MIN_VALUE;
            return v.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler$awaitAdFactory$adFactory$1", f = "InitializationHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<com.moloco.sdk.internal.a, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6284a;
        public /* synthetic */ Object b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.internal.a aVar, Continuation<? super Boolean> continuation) {
            return ((c) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6284a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((com.moloco.sdk.internal.a) this.b) != null);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", i = {0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3}, l = {144, 147, 173, 177, 185}, m = "handleInitializationResult", n = {"result", "trackingApi", "initTimerEvent", "latency", "result", "initTimerEvent", "this", "result", "trackingApi", "initTimerEvent", "latency", "this", "initTimerEvent", "$this$handleInitializationResult_u24lambda_u240"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6285a;
        public Object b;
        public Object c;
        public Object d;
        public long e;
        public /* synthetic */ Object f;
        public int h;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return v.this.a((com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>) null, 0L, (com.moloco.sdk.internal.services.init.n) null, (TimerEvent) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", i = {0, 0, 1}, l = {111, 115, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE}, m = MobileAdsBridgeBase.initializeMethodName, n = {"this", "clientFailureType", "clientFailureType"}, s = {"L$0", "L$1", "L$0"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6286a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return v.this.a(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler$startInitialization$2", f = "InitializationHandler.kt", i = {0, 0, 1}, l = {Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 136}, m = "invokeSuspend", n = {"acmInitTimer", "startTime", "result"}, s = {"L$0", "J$0", "L$0"})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6287a;
        public long b;
        public int c;
        public final /* synthetic */ String e;
        public final /* synthetic */ MediationInfo f;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.n g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.n nVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.e = str;
            this.f = mediationInfo;
            this.g = nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return v.this.new f(this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, v.i, "startInitialization switch to Dispatchers.IO", null, false, 12, null);
                TimerEvent timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.SDKInit.b());
                long jA = v.this.f().a();
                com.moloco.sdk.internal.services.init.k kVarB = com.moloco.sdk.service_locator.a.f.f6470a.b();
                String str = this.e;
                MediationInfo mediationInfo = this.f;
                this.f6287a = timerEventStartTimerEvent;
                this.b = jA;
                this.c = 1;
                obj = kVarB.a(str, mediationInfo, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventStartTimerEvent;
                j = jA;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) this.f6287a;
                    ResultKt.throwOnFailure(obj);
                    return vVar;
                }
                j = this.b;
                TimerEvent timerEvent2 = (TimerEvent) this.f6287a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
            }
            com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) obj;
            long jA2 = v.this.f().a() - j;
            v vVar3 = v.this;
            com.moloco.sdk.internal.services.init.n nVar = this.g;
            this.f6287a = vVar2;
            this.c = 2;
            return vVar3.a((com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>) vVar2, jA2, nVar, timerEvent, this) == coroutine_suspended ? coroutine_suspended : vVar2;
        }
    }

    static {
        Initialization initialization = Initialization.SUCCESS;
        g = new MolocoInitStatus(initialization, "Already Initialized");
        h = new MolocoInitStatus(initialization, "Initialized");
    }

    public v(i0 timeProviderService) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f6282a = timeProviderService;
        MutableStateFlow<Initialization> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.b = MutableStateFlow;
        this.c = FlowKt.asStateFlow(MutableStateFlow);
        this.e = StateFlowKt.MutableStateFlow(null);
    }

    public final boolean c() {
        return g();
    }

    public final StateFlow<Initialization> d() {
        return this.c;
    }

    public final Init.SDKInitResponse e() {
        return this.d;
    }

    public final i0 f() {
        return this.f6282a;
    }

    public final boolean g() {
        try {
            com.moloco.sdk.service_locator.a.i.f6483a.c();
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final Object b(String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.n nVar, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new f(str, mediationInfo, nVar, null), continuation);
    }

    public final Object b(Continuation<? super Unit> continuation) {
        this.d = null;
        this.e.setValue(null);
        this.b.setValue(null);
        Object objA = com.moloco.sdk.service_locator.a.f.f6470a.b().a(continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation<? super com.moloco.sdk.internal.a> continuation) throws Throwable {
        b bVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.c = i2 - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objFirst = bVar.f6283a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = bVar.c;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objFirst);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "Moloco SDK awaiting init to receive AdFactory", null, false, 12, null);
            MutableStateFlow<com.moloco.sdk.internal.a> mutableStateFlow = this.e;
            c cVar = new c(null);
            bVar.c = 1;
            objFirst = FlowKt.first(mutableStateFlow, cVar, bVar);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirst);
        }
        Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type com.moloco.sdk.internal.AdFactory");
        com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objFirst;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "Moloco SDK init completed, AdFactory received", null, false, 12, null);
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.n nVar, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> continuation) {
        e eVar;
        v vVar;
        com.moloco.sdk.internal.services.init.j.a aVar;
        MutableStateFlow<Initialization> mutableStateFlow;
        Initialization initialization;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.e = i2 - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        Object objB = eVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = eVar.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objB);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.info$default(molocoLogger, i, "initialize()", null, false, 12, null);
            AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitAttempt.b()));
            if (!c()) {
                MolocoLogger.error$default(molocoLogger, i, "PersistentHttpRequest is not available, failing to initialize", null, false, 12, null);
                com.moloco.sdk.internal.services.init.j.a aVar2 = new com.moloco.sdk.internal.services.init.j.a(com.moloco.sdk.internal.services.init.b.PersistentHttpUnavailableError);
                eVar.f6286a = this;
                eVar.b = aVar2;
                eVar.e = 1;
                if (nVar.a(aVar2, 0L, eVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                vVar = this;
                aVar = aVar2;
                AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), aVar.a().name()));
                mutableStateFlow = vVar.b;
                initialization = Initialization.FAILURE;
                eVar.f6286a = aVar;
                eVar.b = null;
                eVar.e = 2;
                if (mutableStateFlow.emit(initialization, eVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                eVar.e = 3;
                objB = b(str, mediationInfo, nVar, eVar);
                return objB == coroutine_suspended ? coroutine_suspended : objB;
            }
        } else if (i3 == 1) {
            aVar = (com.moloco.sdk.internal.services.init.j.a) eVar.b;
            vVar = (v) eVar.f6286a;
            ResultKt.throwOnFailure(objB);
            AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), aVar.a().name()));
            mutableStateFlow = vVar.b;
            initialization = Initialization.FAILURE;
            eVar.f6286a = aVar;
            eVar.b = null;
            eVar.e = 2;
            if (mutableStateFlow.emit(initialization, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 2) {
                if (i3 == 3) {
                    ResultKt.throwOnFailure(objB);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (com.moloco.sdk.internal.services.init.j.a) eVar.f6286a;
            ResultKt.throwOnFailure(objB);
        }
        return new com.moloco.sdk.internal.v.a(aVar);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:34:0x0135  */
    /* JADX WARN: Code duplicated, block: B:36:0x0139  */
    /* JADX WARN: Code duplicated, block: B:37:0x017c  */
    /* JADX WARN: Code duplicated, block: B:47:0x01c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:51:0x0223 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    public final Object a(com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j> vVar, long j, com.moloco.sdk.internal.services.init.n nVar, TimerEvent timerEvent, Continuation<? super Unit> continuation) throws Throwable {
        d dVar;
        v vVar2;
        com.moloco.sdk.internal.services.init.j jVar;
        com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j> vVar3;
        TimerEvent timerEvent2;
        com.moloco.sdk.internal.services.init.j jVar2;
        Init.SDKInitResponse sDKInitResponse;
        TimerEvent timerEvent3;
        v vVar4;
        MutableStateFlow<com.moloco.sdk.internal.a> mutableStateFlow;
        com.moloco.sdk.internal.a aVarA;
        com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j> vVar5 = vVar;
        long j2 = j;
        com.moloco.sdk.internal.services.init.n nVar2 = nVar;
        TimerEvent timerEvent4 = timerEvent;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.h = i2 - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dVar.h;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (vVar5 instanceof com.moloco.sdk.internal.v.a) {
                MutableStateFlow<Initialization> mutableStateFlow2 = this.b;
                Initialization initialization = Initialization.FAILURE;
                dVar.f6285a = vVar5;
                dVar.b = nVar2;
                dVar.c = timerEvent4;
                dVar.e = j2;
                dVar.h = 1;
                if (mutableStateFlow2.emit(initialization, dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "sdk init failed", null, false, 12, null);
                jVar = (com.moloco.sdk.internal.services.init.j) ((com.moloco.sdk.internal.v.a) vVar5).a();
                dVar.f6285a = vVar5;
                dVar.b = timerEvent4;
                dVar.c = null;
                dVar.h = 2;
                if (nVar2.a(jVar, j2, dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                vVar3 = vVar5;
                timerEvent2 = timerEvent4;
                jVar2 = (com.moloco.sdk.internal.services.init.j) ((com.moloco.sdk.internal.v.a) vVar3).a();
                if (jVar2 instanceof com.moloco.sdk.internal.services.init.j.a) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                    com.moloco.sdk.internal.services.init.j.a aVar = (com.moloco.sdk.internal.services.init.j.a) jVar2;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), aVar.a().name()));
                    androidClientMetrics.recordTimerEvent(timerEvent2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar.b(), aVar.a().name()));
                } else {
                    if (!(jVar2 instanceof com.moloco.sdk.internal.services.init.j.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                    com.moloco.sdk.internal.services.init.j.b bVar = (com.moloco.sdk.internal.services.init.j.b) jVar2;
                    androidClientMetrics2.recordCountEvent(countEvent2.withTag(cVar2.b(), String.valueOf(bVar.a())));
                    androidClientMetrics2.recordTimerEvent(timerEvent2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar2.b(), String.valueOf(bVar.a())));
                }
            } else if (vVar5 instanceof com.moloco.sdk.internal.v.b) {
                MutableStateFlow<Initialization> mutableStateFlow3 = this.b;
                Initialization initialization2 = Initialization.SUCCESS;
                dVar.f6285a = this;
                dVar.b = vVar5;
                dVar.c = nVar2;
                dVar.d = timerEvent4;
                dVar.e = j2;
                dVar.h = 3;
                if (mutableStateFlow3.emit(initialization2, dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                vVar2 = this;
                MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "sdk init success", null, false, 12, null);
                sDKInitResponse = (Init.SDKInitResponse) ((com.moloco.sdk.internal.v.b) vVar5).a();
                vVar2.d = sDKInitResponse;
                dVar.f6285a = vVar2;
                dVar.b = timerEvent4;
                dVar.c = sDKInitResponse;
                dVar.d = null;
                dVar.h = 4;
                if (nVar2.a(j2, dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent3 = timerEvent4;
                vVar4 = vVar2;
                AndroidClientMetrics androidClientMetrics3 = AndroidClientMetrics.INSTANCE;
                CountEvent countEvent3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitSuccess.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Country;
                String strB = cVar3.b();
                String countryIso2Code = sDKInitResponse.getCountryIso2Code();
                Intrinsics.checkNotNullExpressionValue(countryIso2Code, "countryIso2Code");
                androidClientMetrics3.recordCountEvent(countEvent3.withTag(strB, countryIso2Code));
                TimerEvent timerEventWithTag = timerEvent3.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "success");
                String strB2 = cVar3.b();
                String countryIso2Code2 = sDKInitResponse.getCountryIso2Code();
                Intrinsics.checkNotNullExpressionValue(countryIso2Code2, "countryIso2Code");
                androidClientMetrics3.recordTimerEvent(timerEventWithTag.withTag(strB2, countryIso2Code2));
                mutableStateFlow = vVar4.e;
                aVarA = com.moloco.sdk.service_locator.a.f.f6470a.a(sDKInitResponse);
                dVar.f6285a = null;
                dVar.b = null;
                dVar.c = null;
                dVar.h = 5;
                if (mutableStateFlow.emit(aVarA, dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (i3 == 1) {
            long j3 = dVar.e;
            TimerEvent timerEvent5 = (TimerEvent) dVar.c;
            nVar2 = (com.moloco.sdk.internal.services.init.n) dVar.b;
            com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j> vVar6 = (com.moloco.sdk.internal.v) dVar.f6285a;
            ResultKt.throwOnFailure(obj);
            timerEvent4 = timerEvent5;
            j2 = j3;
            vVar5 = vVar6;
            MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "sdk init failed", null, false, 12, null);
            jVar = (com.moloco.sdk.internal.services.init.j) ((com.moloco.sdk.internal.v.a) vVar5).a();
            dVar.f6285a = vVar5;
            dVar.b = timerEvent4;
            dVar.c = null;
            dVar.h = 2;
            if (nVar2.a(jVar, j2, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            vVar3 = vVar5;
            timerEvent2 = timerEvent4;
            jVar2 = (com.moloco.sdk.internal.services.init.j) ((com.moloco.sdk.internal.v.a) vVar3).a();
            if (jVar2 instanceof com.moloco.sdk.internal.services.init.j.a) {
                AndroidClientMetrics androidClientMetrics4 = AndroidClientMetrics.INSTANCE;
                CountEvent countEvent4 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                com.moloco.sdk.internal.services.init.j.a aVar2 = (com.moloco.sdk.internal.services.init.j.a) jVar2;
                androidClientMetrics4.recordCountEvent(countEvent4.withTag(cVar4.b(), aVar2.a().name()));
                androidClientMetrics4.recordTimerEvent(timerEvent2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar4.b(), aVar2.a().name()));
            } else {
                if (!(jVar2 instanceof com.moloco.sdk.internal.services.init.j.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                AndroidClientMetrics androidClientMetrics5 = AndroidClientMetrics.INSTANCE;
                CountEvent countEvent5 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar5 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                com.moloco.sdk.internal.services.init.j.b bVar2 = (com.moloco.sdk.internal.services.init.j.b) jVar2;
                androidClientMetrics5.recordCountEvent(countEvent5.withTag(cVar5.b(), String.valueOf(bVar2.a())));
                androidClientMetrics5.recordTimerEvent(timerEvent2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar5.b(), String.valueOf(bVar2.a())));
            }
        } else if (i3 == 2) {
            timerEvent2 = (TimerEvent) dVar.b;
            vVar3 = (com.moloco.sdk.internal.v) dVar.f6285a;
            ResultKt.throwOnFailure(obj);
            jVar2 = (com.moloco.sdk.internal.services.init.j) ((com.moloco.sdk.internal.v.a) vVar3).a();
            if (jVar2 instanceof com.moloco.sdk.internal.services.init.j.a) {
                AndroidClientMetrics androidClientMetrics6 = AndroidClientMetrics.INSTANCE;
                CountEvent countEvent6 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar6 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                com.moloco.sdk.internal.services.init.j.a aVar3 = (com.moloco.sdk.internal.services.init.j.a) jVar2;
                androidClientMetrics6.recordCountEvent(countEvent6.withTag(cVar6.b(), aVar3.a().name()));
                androidClientMetrics6.recordTimerEvent(timerEvent2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar6.b(), aVar3.a().name()));
            } else {
                if (!(jVar2 instanceof com.moloco.sdk.internal.services.init.j.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                AndroidClientMetrics androidClientMetrics7 = AndroidClientMetrics.INSTANCE;
                CountEvent countEvent7 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitFailure.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar7 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                com.moloco.sdk.internal.services.init.j.b bVar3 = (com.moloco.sdk.internal.services.init.j.b) jVar2;
                androidClientMetrics7.recordCountEvent(countEvent7.withTag(cVar7.b(), String.valueOf(bVar3.a())));
                androidClientMetrics7.recordTimerEvent(timerEvent2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar7.b(), String.valueOf(bVar3.a())));
            }
        } else if (i3 == 3) {
            long j4 = dVar.e;
            TimerEvent timerEvent6 = (TimerEvent) dVar.d;
            nVar2 = (com.moloco.sdk.internal.services.init.n) dVar.c;
            com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j> vVar7 = (com.moloco.sdk.internal.v) dVar.b;
            vVar2 = (v) dVar.f6285a;
            ResultKt.throwOnFailure(obj);
            timerEvent4 = timerEvent6;
            j2 = j4;
            vVar5 = vVar7;
            MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "sdk init success", null, false, 12, null);
            sDKInitResponse = (Init.SDKInitResponse) ((com.moloco.sdk.internal.v.b) vVar5).a();
            vVar2.d = sDKInitResponse;
            dVar.f6285a = vVar2;
            dVar.b = timerEvent4;
            dVar.c = sDKInitResponse;
            dVar.d = null;
            dVar.h = 4;
            if (nVar2.a(j2, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            timerEvent3 = timerEvent4;
            vVar4 = vVar2;
            AndroidClientMetrics androidClientMetrics8 = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent8 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitSuccess.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar8 = com.moloco.sdk.internal.client_metrics_data.c.Country;
            String strB3 = cVar8.b();
            String countryIso2Code3 = sDKInitResponse.getCountryIso2Code();
            Intrinsics.checkNotNullExpressionValue(countryIso2Code3, "countryIso2Code");
            androidClientMetrics8.recordCountEvent(countEvent8.withTag(strB3, countryIso2Code3));
            TimerEvent timerEventWithTag2 = timerEvent3.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "success");
            String strB4 = cVar8.b();
            String countryIso2Code4 = sDKInitResponse.getCountryIso2Code();
            Intrinsics.checkNotNullExpressionValue(countryIso2Code4, "countryIso2Code");
            androidClientMetrics8.recordTimerEvent(timerEventWithTag2.withTag(strB4, countryIso2Code4));
            mutableStateFlow = vVar4.e;
            aVarA = com.moloco.sdk.service_locator.a.f.f6470a.a(sDKInitResponse);
            dVar.f6285a = null;
            dVar.b = null;
            dVar.c = null;
            dVar.h = 5;
            if (mutableStateFlow.emit(aVarA, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 4) {
            sDKInitResponse = (Init.SDKInitResponse) dVar.c;
            timerEvent3 = (TimerEvent) dVar.b;
            vVar4 = (v) dVar.f6285a;
            ResultKt.throwOnFailure(obj);
            AndroidClientMetrics androidClientMetrics9 = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent9 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKInitSuccess.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar9 = com.moloco.sdk.internal.client_metrics_data.c.Country;
            String strB5 = cVar9.b();
            String countryIso2Code5 = sDKInitResponse.getCountryIso2Code();
            Intrinsics.checkNotNullExpressionValue(countryIso2Code5, "countryIso2Code");
            androidClientMetrics9.recordCountEvent(countEvent9.withTag(strB5, countryIso2Code5));
            TimerEvent timerEventWithTag3 = timerEvent3.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "success");
            String strB6 = cVar9.b();
            String countryIso2Code6 = sDKInitResponse.getCountryIso2Code();
            Intrinsics.checkNotNullExpressionValue(countryIso2Code6, "countryIso2Code");
            androidClientMetrics9.recordTimerEvent(timerEventWithTag3.withTag(strB6, countryIso2Code6));
            mutableStateFlow = vVar4.e;
            aVarA = com.moloco.sdk.service_locator.a.f.f6470a.a(sDKInitResponse);
            dVar.f6285a = null;
            dVar.b = null;
            dVar.c = null;
            dVar.h = 5;
            if (mutableStateFlow.emit(aVarA, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
