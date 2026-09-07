package com.moloco.sdk.internal.services.init;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import com.vungle.ads.internal.protos.Sdk;
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
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.services.init.d f6410a;
    public final g b;
    public final CoroutineScope c;
    public Init.SDKInitResponse d;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", i = {0, 0, 0, 1}, l = {93, 106}, m = "fetchInitResponse", n = {"this", "appKey", "mediationInfo", "this"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6411a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return l.this.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl$fetchInitResponse$3", f = "InitService.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6412a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MediationInfo d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, MediationInfo mediationInfo, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = mediationInfo;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return l.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6412a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f6415a, "Async fetching init response", null, false, 12, null);
                l lVar = l.this;
                String str = this.c;
                MediationInfo mediationInfo = this.d;
                this.f6412a = 1;
                if (lVar.a(str, mediationInfo, true, (Continuation<? super v<Init.SDKInitResponse, j>>) this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 4}, l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 142, 144, 181, 194}, m = "fetchServerInitResponse$moloco_sdk_release", n = {"this", "appKey", "mediationInfo", "result", "asyncFetch", "attempt", "it", "cacheKey", "$this$fetchServerInitResponse_u24lambda_u244_u24lambda_u242_u24lambda_u241", "asyncFetch", "attempt", "it", "asyncFetch", "attempt", "result", "this", "appKey", "mediationInfo", "result", "asyncFetch"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$2", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "Z$0", "I$0", "L$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6413a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public boolean f;
        public int g;
        public int h;
        public int i;
        public /* synthetic */ Object j;
        public int l;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return l.this.a((String) null, (MediationInfo) null, false, (Continuation<? super v<Init.SDKInitResponse, j>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", i = {0}, l = {67}, m = "performInit", n = {"performInitEvent"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6414a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return l.this.a(null, null, this);
        }
    }

    public l(com.moloco.sdk.internal.services.init.d initApi, g initCache, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(initApi, "initApi");
        Intrinsics.checkNotNullParameter(initCache, "initCache");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f6410a = initApi;
        this.b = initCache;
        this.c = scope;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object b(String str, MediationInfo mediationInfo, Continuation<? super com.moloco.sdk.internal.services.init.c> continuation) throws Throwable {
        a aVar;
        MediationInfo mediationInfo2;
        l lVar;
        l lVar2;
        v vVar;
        String str2 = str;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f;
        if (i2 != 0) {
            if (i2 == 1) {
                MediationInfo mediationInfo3 = (MediationInfo) aVar.c;
                String str3 = (String) aVar.b;
                lVar = (l) aVar.f6411a;
                ResultKt.throwOnFailure(objA);
                mediationInfo2 = mediationInfo3;
                str2 = str3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lVar2 = (l) aVar.f6411a;
                ResultKt.throwOnFailure(objA);
            }
            vVar = (v) objA;
            if (vVar instanceof v.b) {
                lVar2.d = (Init.SDKInitResponse) ((v.b) vVar).a();
            } else if (vVar instanceof v.a) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f6415a, "Fetching init response failed", null, false, 12, null);
            }
            return new com.moloco.sdk.internal.services.init.c(vVar, "network");
        }
        ResultKt.throwOnFailure(objA);
        Init.SDKInitResponse sDKInitResponse = this.d;
        if (sDKInitResponse != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f6415a, "Returning current session init response", null, false, 12, null);
            return new com.moloco.sdk.internal.services.init.c(new v.b(sDKInitResponse), "in_memory");
        }
        g gVar = this.b;
        com.moloco.sdk.internal.services.init.a aVar2 = new com.moloco.sdk.internal.services.init.a(str2, mediationInfo.getName());
        aVar.f6411a = this;
        aVar.b = str2;
        mediationInfo2 = mediationInfo;
        aVar.c = mediationInfo2;
        aVar.f = 1;
        objA = gVar.a(aVar2, aVar);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        lVar = this;
        Init.SDKInitResponse sDKInitResponse2 = (Init.SDKInitResponse) objA;
        if (sDKInitResponse2 != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f6415a, "Returning cached init response", null, false, 12, null);
            lVar.d = sDKInitResponse2;
            BuildersKt__Builders_commonKt.launch$default(lVar.c, null, null, lVar.new b(str2, mediationInfo2, null), 3, null);
            return new com.moloco.sdk.internal.services.init.c(new v.b(sDKInitResponse2), Reporting.EventType.CACHE);
        }
        MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f6415a, "No cached response, fetching from server", null, false, 12, null);
        aVar.f6411a = lVar;
        aVar.b = null;
        aVar.c = null;
        aVar.f = 2;
        objA = lVar.a(str2, mediationInfo2, false, (Continuation<? super v<Init.SDKInitResponse, j>>) aVar);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        lVar2 = lVar;
        vVar = (v) objA;
        if (vVar instanceof v.b) {
            lVar2.d = (Init.SDKInitResponse) ((v.b) vVar).a();
        } else if (vVar instanceof v.a) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f6415a, "Fetching init response failed", null, false, 12, null);
        }
        return new com.moloco.sdk.internal.services.init.c(vVar, "network");
    }

    @Override // com.moloco.sdk.internal.services.init.k
    public Init.SDKInitResponse a() {
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.init.k
    public Object a(String str, MediationInfo mediationInfo, Continuation<? super v<Init.SDKInitResponse, j>> continuation) throws Throwable {
        d dVar;
        TimerEvent timerEvent;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.SDKPerformInitAttempt.b());
            dVar.f6414a = timerEventStartTimerEvent;
            dVar.d = 1;
            Object objB = b(str, mediationInfo, dVar);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objB;
            timerEvent = timerEventStartTimerEvent;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            timerEvent = (TimerEvent) dVar.f6414a;
            ResultKt.throwOnFailure(obj);
        }
        com.moloco.sdk.internal.services.init.c cVar = (com.moloco.sdk.internal.services.init.c) obj;
        v<Init.SDKInitResponse, j> vVarD = cVar.d();
        if (vVarD instanceof v.a) {
            AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKPerformInitAttempt.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Result;
            androidClientMetrics.recordCountEvent(countEvent.withTag(cVar2.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("state", cVar.c()));
            androidClientMetrics.recordTimerEvent(timerEvent.withTag(cVar2.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("state", cVar.c()));
        } else if (vVarD instanceof v.b) {
            AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.SDKPerformInitAttempt.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Result;
            androidClientMetrics2.recordCountEvent(countEvent2.withTag(cVar3.b(), "success").withTag("state", cVar.c()));
            androidClientMetrics2.recordTimerEvent(timerEvent.withTag(cVar3.b(), "success").withTag("state", cVar.c()));
        }
        return cVar.d();
    }

    @Override // com.moloco.sdk.internal.services.init.k
    public Object a(Continuation<? super Unit> continuation) {
        this.d = null;
        Object objA = this.b.a(continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:26:0x00f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:30:0x0107  */
    /* JADX WARN: Code duplicated, block: B:31:0x010c  */
    /* JADX WARN: Code duplicated, block: B:48:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:50:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:52:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:53:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:56:0x0203  */
    /* JADX WARN: Code duplicated, block: B:57:0x020a  */
    /* JADX WARN: Code duplicated, block: B:59:0x020e  */
    /* JADX WARN: Code duplicated, block: B:62:0x028c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0294  */
    /* JADX WARN: Code duplicated, block: B:66:0x02e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x0312  */
    /* JADX WARN: Code duplicated, block: B:76:0x0318  */
    /* JADX WARN: Code duplicated, block: B:79:0x033d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:80:0x033e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x033e -> B:81:0x034b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(java.lang.String r32, com.moloco.sdk.publisher.MediationInfo r33, boolean r34, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 907
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.l.a(java.lang.String, com.moloco.sdk.publisher.MediationInfo, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
