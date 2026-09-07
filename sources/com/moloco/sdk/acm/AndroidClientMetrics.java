package com.moloco.sdk.acm;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.json.b9;
import com.moloco.sdk.acm.db.MetricsDb;
import com.moloco.sdk.acm.eventprocessing.h;
import com.moloco.sdk.acm.eventprocessing.i;
import com.moloco.sdk.acm.eventprocessing.l;
import com.moloco.sdk.acm.eventprocessing.m;
import com.moloco.sdk.acm.services.ApplicationLifecycleObserver;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
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
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u0010\u0017J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0013J\u000f\u0010\u0018\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0004\b \u0010!\u0012\u0004\b&\u0010\u0017\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00102\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u000100000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0013048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010?\u001a\u0002008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Lcom/moloco/sdk/acm/AndroidClientMetrics;", "", "Lcom/moloco/sdk/acm/UpdateConfig;", "newConfig", "", "updateConfigInternal", "(Lcom/moloco/sdk/acm/UpdateConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processQueuedEvents", "Lcom/moloco/sdk/acm/InitConfig;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/moloco/sdk/acm/AndroidClientMetricsCallback;", "callback", MobileAdsBridgeBase.initializeMethodName, "updateConfig", "Lcom/moloco/sdk/acm/CountEvent;", "event", "recordCountEvent", "", b9.h.j0, "Lcom/moloco/sdk/acm/TimerEvent;", "startTimerEvent", "recordTimerEvent", "triggerBackgroundEvent$moloco_android_client_metrics_release", "()V", "triggerBackgroundEvent", "Lcom/moloco/sdk/acm/eventprocessing/h;", "eventProcessor", "Lcom/moloco/sdk/acm/eventprocessing/h;", "Lcom/moloco/sdk/acm/services/c;", "applicationLifecycleTracker", "Lcom/moloco/sdk/acm/services/c;", "Lcom/moloco/sdk/acm/a;", "opsConfig", "Lcom/moloco/sdk/acm/a;", "getOpsConfig$moloco_android_client_metrics_release", "()Lcom/moloco/sdk/acm/a;", "setOpsConfig$moloco_android_client_metrics_release", "(Lcom/moloco/sdk/acm/a;)V", "getOpsConfig$moloco_android_client_metrics_release$annotations", "pendingConfigUpdate", "Lcom/moloco/sdk/acm/UpdateConfig;", "Lkotlinx/coroutines/sync/Mutex;", "configMutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/moloco/sdk/acm/f;", "kotlin.jvm.PlatformType", "_initializationStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "preInitTimerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "preInitCountList", "Lcom/moloco/sdk/acm/eventprocessing/l;", "requestScheduler", "Lcom/moloco/sdk/acm/eventprocessing/l;", "TAG", "Ljava/lang/String;", "getInitializationStatus$moloco_android_client_metrics_release", "()Lcom/moloco/sdk/acm/f;", "initializationStatus", "<init>", "moloco-android-client-metrics_release"}, k = 1, mv = {1, 8, 0})
public final class AndroidClientMetrics {
    private static final String TAG = "AndroidClientMetrics";
    private static com.moloco.sdk.acm.services.c applicationLifecycleTracker;
    private static h eventProcessor;
    public static com.moloco.sdk.acm.a opsConfig;
    private static UpdateConfig pendingConfigUpdate;
    private static l requestScheduler;
    public static final AndroidClientMetrics INSTANCE = new AndroidClientMetrics();
    private static final Mutex configMutex = MutexKt.Mutex$default(false, 1, null);
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private static final AtomicReference<f> _initializationStatus = new AtomicReference<>(f.UNINITIALIZED);
    private static final CopyOnWriteArrayList<TimerEvent> preInitTimerList = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<CountEvent> preInitCountList = new CopyOnWriteArrayList<>();

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$initialize$1", f = "AndroidClientMetrics.kt", i = {0, 1}, l = {258, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f5997a;
        public int b;
        public final /* synthetic */ InitConfig c;
        public final /* synthetic */ AndroidClientMetricsCallback d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InitConfig initConfig, AndroidClientMetricsCallback androidClientMetricsCallback, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = initConfig;
            this.d = androidClientMetricsCallback;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x00f0 A[Catch: Exception -> 0x00f8, IllegalStateException -> 0x0118, TryCatch #3 {IllegalStateException -> 0x0118, Exception -> 0x00f8, blocks: (B:32:0x00e4, B:34:0x00f0, B:35:0x00f4, B:36:0x00f7, B:14:0x002a, B:17:0x0032, B:19:0x0090, B:20:0x0096, B:22:0x009c, B:23:0x00a2, B:7:0x0016, B:31:0x00e2, B:26:0x00c0, B:28:0x00c6), top: B:47:0x000b, inners: #2 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            ?? r2;
            AndroidClientMetricsCallback androidClientMetricsCallback;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r3 = this.b;
            try {
                try {
                    if (r3 != 0) {
                        if (r3 == 1) {
                            Mutex mutex2 = (Mutex) this.f5997a;
                            ResultKt.throwOnFailure(obj);
                            mutex = mutex2;
                        } else {
                            if (r3 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Mutex mutex3 = (Mutex) this.f5997a;
                            ResultKt.throwOnFailure(obj);
                            r3 = mutex3;
                        }
                        r3 = mutex;
                        Unit unit = Unit.INSTANCE;
                        r2 = r3;
                        r2.unlock(null);
                        AndroidClientMetrics.INSTANCE.processQueuedEvents();
                        androidClientMetricsCallback = this.d;
                        if (androidClientMetricsCallback != null) {
                            androidClientMetricsCallback.onInitializationSuccess();
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.acm.db.d dVarB = MetricsDb.INSTANCE.b(this.c.getContext()).b();
                    com.moloco.sdk.acm.services.h hVar = new com.moloco.sdk.acm.services.h();
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    com.moloco.sdk.acm.eventprocessing.d dVar = new com.moloco.sdk.acm.eventprocessing.d(androidClientMetrics.getOpsConfig$moloco_android_client_metrics_release(), this.c.getContext());
                    AndroidClientMetrics.requestScheduler = new m(dVar, androidClientMetrics.getOpsConfig$moloco_android_client_metrics_release(), null, AndroidClientMetrics.ioScope, 4, null);
                    AndroidClientMetrics.applicationLifecycleTracker = new com.moloco.sdk.acm.services.c(ProcessLifecycleOwner.INSTANCE.get().getLifecycle(), new ApplicationLifecycleObserver(dVar, AndroidClientMetrics.ioScope));
                    l lVar = AndroidClientMetrics.requestScheduler;
                    if (lVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("requestScheduler");
                        lVar = null;
                    }
                    com.moloco.sdk.acm.services.c cVar = AndroidClientMetrics.applicationLifecycleTracker;
                    if (cVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationLifecycleTracker");
                        cVar = null;
                    }
                    AndroidClientMetrics.eventProcessor = new i(dVarB, hVar, lVar, cVar);
                    AndroidClientMetrics._initializationStatus.set(f.INITIALIZED);
                    Mutex mutex4 = AndroidClientMetrics.configMutex;
                    this.f5997a = mutex4;
                    this.b = 1;
                    Object objLock = mutex4.lock(null, this);
                    mutex = mutex4;
                    if (objLock == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    UpdateConfig updateConfig = AndroidClientMetrics.pendingConfigUpdate;
                    r2 = mutex;
                    if (updateConfig != null) {
                        AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
                        AndroidClientMetrics.pendingConfigUpdate = null;
                        com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, AndroidClientMetrics.TAG, "Updating config with pending config", false, 4, null);
                        this.f5997a = mutex;
                        this.b = 2;
                        if (androidClientMetrics2.updateConfigInternal(updateConfig, this) == coroutine_suspended) {
                            r3 = mutex;
                            return coroutine_suspended;
                        }
                        r3 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        r2 = r3;
                        r2.unlock(null);
                        AndroidClientMetrics.INSTANCE.processQueuedEvents();
                        androidClientMetricsCallback = this.d;
                        if (androidClientMetricsCallback != null) {
                            androidClientMetricsCallback.onInitializationSuccess();
                        }
                    } else {
                        r2.unlock(null);
                        AndroidClientMetrics.INSTANCE.processQueuedEvents();
                        androidClientMetricsCallback = this.d;
                        if (androidClientMetricsCallback != null) {
                            androidClientMetricsCallback.onInitializationSuccess();
                        }
                    }
                } catch (Throwable th) {
                    r3.unlock(null);
                    throw th;
                }
            } catch (IllegalStateException e) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, MetricsDb.c, "Unable to create metrics db", e, false, 8, null);
                AndroidClientMetrics._initializationStatus.set(f.UNINITIALIZED);
                AndroidClientMetricsCallback androidClientMetricsCallback2 = this.d;
                if (androidClientMetricsCallback2 != null) {
                    androidClientMetricsCallback2.onInitializationFailure(e);
                }
            } catch (Exception e2) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, AndroidClientMetrics.TAG, "Initialization error", e2, false, 8, null);
                AndroidClientMetrics._initializationStatus.set(f.UNINITIALIZED);
                AndroidClientMetricsCallback androidClientMetricsCallback3 = this.d;
                if (androidClientMetricsCallback3 != null) {
                    androidClientMetricsCallback3.onInitializationFailure(e2);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$processQueuedEvents$1", f = "AndroidClientMetrics.kt", i = {}, l = {234, 235}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f5998a;
        public int b;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0068  */
        /* JADX WARN: Code duplicated, block: B:24:0x0074  */
        /* JADX WARN: Code duplicated, block: B:31:0x0085 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:33:? A[LOOP:0: B:20:0x0062->B:33:?, LOOP_END, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Iterator it;
            Iterator it2;
            CountEvent it3;
            h hVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    it = (Iterator) this.f5998a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it2 = (Iterator) this.f5998a;
                    ResultKt.throwOnFailure(obj);
                }
                while (it2.hasNext()) {
                    it3 = (CountEvent) it2.next();
                    hVar = AndroidClientMetrics.eventProcessor;
                    if (hVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                        hVar = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(it3, "it");
                    this.f5998a = it2;
                    this.b = 2;
                    if (hVar.a(it3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                AndroidClientMetrics.preInitTimerList.clear();
                AndroidClientMetrics.preInitCountList.clear();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            it = AndroidClientMetrics.preInitTimerList.iterator();
            while (it.hasNext()) {
                TimerEvent it4 = (TimerEvent) it.next();
                h hVar2 = AndroidClientMetrics.eventProcessor;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                    hVar2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                this.f5998a = it;
                this.b = 1;
                if (hVar2.a(it4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            it2 = AndroidClientMetrics.preInitCountList.iterator();
            while (it2.hasNext()) {
                it3 = (CountEvent) it2.next();
                hVar = AndroidClientMetrics.eventProcessor;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                    hVar = null;
                }
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                this.f5998a = it2;
                this.b = 2;
                if (hVar.a(it3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            AndroidClientMetrics.preInitTimerList.clear();
            AndroidClientMetrics.preInitCountList.clear();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$recordCountEvent$1", f = "AndroidClientMetrics.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5999a;
        public final /* synthetic */ CountEvent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CountEvent countEvent, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = countEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5999a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h hVar = AndroidClientMetrics.eventProcessor;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                    hVar = null;
                }
                CountEvent countEvent = this.b;
                this.f5999a = 1;
                if (hVar.a(countEvent, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$recordTimerEvent$1", f = "AndroidClientMetrics.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6000a;
        public final /* synthetic */ TimerEvent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TimerEvent timerEvent, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = timerEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6000a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h hVar = AndroidClientMetrics.eventProcessor;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                    hVar = null;
                }
                TimerEvent timerEvent = this.b;
                this.f6000a = 1;
                if (hVar.a(timerEvent, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics", f = "AndroidClientMetrics.kt", i = {0, 0}, l = {258, 164}, m = "updateConfig", n = {"newConfig", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6001a;
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
            return AndroidClientMetrics.this.updateConfig(null, this);
        }
    }

    private AndroidClientMetrics() {
    }

    public static /* synthetic */ void getOpsConfig$moloco_android_client_metrics_release$annotations() {
    }

    public static /* synthetic */ void initialize$default(AndroidClientMetrics androidClientMetrics, InitConfig initConfig, AndroidClientMetricsCallback androidClientMetricsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            androidClientMetricsCallback = null;
        }
        androidClientMetrics.initialize(initConfig, androidClientMetricsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processQueuedEvents() {
        BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateConfigInternal(UpdateConfig updateConfig, Continuation<? super Unit> continuation) {
        String postAnalyticsUrl = updateConfig.getPostAnalyticsUrl();
        if (postAnalyticsUrl != null) {
            INSTANCE.getOpsConfig$moloco_android_client_metrics_release().a(postAnalyticsUrl);
        }
        Long requestPeriodSeconds = updateConfig.getRequestPeriodSeconds();
        if (requestPeriodSeconds != null) {
            INSTANCE.getOpsConfig$moloco_android_client_metrics_release().a(requestPeriodSeconds.longValue());
        }
        l lVar = requestScheduler;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestScheduler");
            lVar = null;
        }
        Object objA = lVar.a(continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    public final f getInitializationStatus$moloco_android_client_metrics_release() {
        f fVar = _initializationStatus.get();
        Intrinsics.checkNotNullExpressionValue(fVar, "_initializationStatus.get()");
        return fVar;
    }

    public final com.moloco.sdk.acm.a getOpsConfig$moloco_android_client_metrics_release() {
        com.moloco.sdk.acm.a aVar = opsConfig;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("opsConfig");
        return null;
    }

    public final void initialize(InitConfig config, AndroidClientMetricsCallback callback) {
        Intrinsics.checkNotNullParameter(config, "config");
        com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, TAG, "ACM initialize", false, 4, null);
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(_initializationStatus, f.UNINITIALIZED, f.INITIALIZING)) {
            setOpsConfig$moloco_android_client_metrics_release(com.moloco.sdk.acm.e.a(config));
            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new a(config, callback, null), 3, null);
        }
    }

    public final void recordCountEvent(CountEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (_initializationStatus.get() == f.INITIALIZED) {
            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new c(event, null), 3, null);
        } else {
            preInitCountList.add(event);
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, TAG, "Moloco Client Metrics not initialized", false, 4, null);
        }
    }

    public final void recordTimerEvent(TimerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.stopTimer();
        if (_initializationStatus.get() == f.INITIALIZED) {
            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new d(event, null), 3, null);
        } else {
            preInitTimerList.add(event);
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, TAG, "Moloco Client Metrics not initialized", false, 4, null);
        }
    }

    public final void setOpsConfig$moloco_android_client_metrics_release(com.moloco.sdk.acm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        opsConfig = aVar;
    }

    public final TimerEvent startTimerEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (_initializationStatus.get() != f.INITIALIZED) {
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, TAG, "Moloco Client Metrics not initialized", false, 4, null);
        }
        TimerEvent timerEventA = TimerEvent.INSTANCE.a(eventName);
        timerEventA.startTimer();
        return timerEventA;
    }

    public final void triggerBackgroundEvent$moloco_android_client_metrics_release() {
        com.moloco.sdk.acm.services.c cVar = applicationLifecycleTracker;
        if (cVar != null) {
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationLifecycleTracker");
                cVar = null;
            }
            cVar.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateConfig(UpdateConfig updateConfig, Continuation<? super Unit> continuation) throws Throwable {
        e eVar;
        Mutex mutex;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.e = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        Object obj = eVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar.e;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            Mutex mutex2 = (Mutex) eVar.b;
            UpdateConfig updateConfig2 = (UpdateConfig) eVar.f6001a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            updateConfig = updateConfig2;
            try {
                pendingConfigUpdate = updateConfig;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
        ResultKt.throwOnFailure(obj);
        if (_initializationStatus.get() == f.INITIALIZED) {
            com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, TAG, "ACM update called. ACM initialized already, proceeding with update", false, 4, null);
            eVar.e = 2;
            if (updateConfigInternal(updateConfig, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, TAG, "ACM updateConfig called when the SDK was not initialized. Initialize the SDK first.", null, false, 12, null);
        mutex = configMutex;
        eVar.f6001a = updateConfig;
        eVar.b = mutex;
        eVar.e = 1;
        if (mutex.lock(null, eVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        pendingConfigUpdate = updateConfig;
        return Unit.INSTANCE;
    }
}
