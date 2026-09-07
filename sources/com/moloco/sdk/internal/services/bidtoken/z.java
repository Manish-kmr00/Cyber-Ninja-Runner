package com.moloco.sdk.internal.services.bidtoken;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes11.dex */
public final class z implements y {
    public final com.moloco.sdk.internal.services.bidtoken.a b;
    public final CoroutineScope c;
    public final v d;
    public final String e;
    public boolean f;
    public final Mutex g;
    public Job h;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$bidToken$2", f = "ServerBidTokenService.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function1<Continuation<? super k>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6350a;

        public a(Continuation<? super a> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super k> continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return z.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6350a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            ResultKt.throwOnFailure(obj);
            z.this.b("[Thread: " + Thread.currentThread().getName() + "] Acquired lock, fetching status of current token");
            v vVar = z.this.d;
            this.f6350a = 1;
            obj = vVar.a(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            b0 b0Var = (b0) obj;
            z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken status: " + b0Var);
            if (!b0Var.b()) {
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] bidToken needs refresh, fetching new token");
                z zVar = z.this;
                k kVarB = e.b();
                this.f6350a = 2;
                obj = zVar.a(kVarB, false, false, this);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
            AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
            CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenCached.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "true").withTag("initial_fetch", "false");
            b0 b0Var2 = b0.EXPIRING;
            androidClientMetrics.recordCountEvent(countEventWithTag.withTag("expiring", b0Var != b0Var2 ? "false" : "true"));
            k kVarA = z.this.d.a();
            if (b0Var == b0Var2) {
                z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken is expiring, returning cached, and refreshing async");
                z.this.a();
            } else {
                z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken doesn't need refresh, returning cached");
            }
            return kVarA;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl", f = "ServerBidTokenService.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {129, 173}, m = "fetchServerBidToken$moloco_sdk_release", n = {"this", "defaultTokenOnError", "bidTokenTimer", "asyncFetch", "wasExpiring", "this", "bidTokenFetchResult"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6351a;
        public Object b;
        public Object c;
        public boolean d;
        public boolean e;
        public /* synthetic */ Object f;
        public int h;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return z.this.a(null, false, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$fetchServerBidToken$bidTokenComponents$1", f = "ServerBidTokenService.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6352a;
        public final /* synthetic */ com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m> vVar, Continuation<? super c> continuation) {
            super(1, continuation);
            this.c = vVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return z.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6352a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                v vVar = z.this.d;
                k kVar = (k) ((com.moloco.sdk.internal.v.b) this.c).a();
                this.f6352a = 1;
                if (vVar.a(kVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$refreshTokenAsyncOnExpiry$1", f = "ServerBidTokenService.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6353a;

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
            return z.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6353a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] Fetching token from server");
                z zVar = z.this;
                k kVarB = e.b();
                this.f6353a = 1;
                if (zVar.a(kVarB, true, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            z.this.b("[Thread: " + Thread.currentThread().getName() + "] Finished fetching token from server");
            return Unit.INSTANCE;
        }
    }

    public z(com.moloco.sdk.internal.services.bidtoken.a bidTokenApi, CoroutineScope scope, v tokenCache) {
        Intrinsics.checkNotNullParameter(bidTokenApi, "bidTokenApi");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(tokenCache, "tokenCache");
        this.b = bidTokenApi;
        this.c = scope;
        this.d = tokenCache;
        this.e = "ServerBidTokenServiceImpl";
        this.f = true;
        this.g = MutexKt.Mutex$default(false, 1, null);
    }

    public final void b(String str) {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, null, false, 12, null);
    }

    public final void a() {
        b("[Thread: " + Thread.currentThread().getName() + "] Refreshing token async");
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenAsyncRefresh.b());
        Job job = this.h;
        androidClientMetrics.recordCountEvent(countEvent.withTag("async", String.valueOf(job != null ? job.isActive() : false)));
        Job job2 = this.h;
        if (job2 != null && job2.isActive()) {
            b("[Thread: " + Thread.currentThread().getName() + "] Async refresh already in progress. Returning");
        } else {
            b("[Thread: " + Thread.currentThread().getName() + "] Scheduling to fetch token from server");
            this.h = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new d(null), 3, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object a(k kVar, boolean z, boolean z2, Continuation<? super k> continuation) throws Throwable {
        b bVar;
        k kVar2;
        boolean z3;
        boolean z4;
        TimerEvent timerEvent;
        z zVar;
        com.moloco.sdk.internal.v vVar;
        z zVar2;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.h = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objA = bVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.h;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            TimerEvent timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.ServerBidTokenFetch.b());
            b("[Thread: " + Thread.currentThread().getName() + "] fetchServerBidToken");
            com.moloco.sdk.internal.services.bidtoken.a aVar = this.b;
            bVar.f6351a = this;
            kVar2 = kVar;
            bVar.b = kVar2;
            bVar.c = timerEventStartTimerEvent;
            bVar.d = z;
            z3 = z2;
            bVar.e = z3;
            bVar.h = 1;
            objA = aVar.a(bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            z4 = z;
            timerEvent = timerEventStartTimerEvent;
            zVar = this;
        } else {
            if (i2 == 1) {
                boolean z5 = bVar.e;
                z4 = bVar.d;
                TimerEvent timerEvent2 = (TimerEvent) bVar.c;
                k kVar3 = (k) bVar.b;
                z zVar3 = (z) bVar.f6351a;
                ResultKt.throwOnFailure(objA);
                z3 = z5;
                kVar2 = kVar3;
                timerEvent = timerEvent2;
                zVar = zVar3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                vVar = (com.moloco.sdk.internal.v) bVar.b;
                zVar2 = (z) bVar.f6351a;
                ResultKt.throwOnFailure(objA);
            }
            k kVar4 = (k) ((com.moloco.sdk.internal.v.b) vVar).a();
            zVar2.f = false;
            return kVar4;
        }
        com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) objA;
        if (vVar2 instanceof com.moloco.sdk.internal.v.a) {
            AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenFetch.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
            CountEvent countEventWithTag = countEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            com.moloco.sdk.internal.v.a aVar2 = (com.moloco.sdk.internal.v.a) vVar2;
            androidClientMetrics.recordCountEvent(countEventWithTag.withTag(cVar2.b(), String.valueOf(((com.moloco.sdk.internal.m) aVar2.a()).b())).withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
            androidClientMetrics.recordTimerEvent(timerEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar2.b(), String.valueOf(((com.moloco.sdk.internal.m) aVar2.a()).b())).withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, zVar.e, "bidtoken request failed: " + ((com.moloco.sdk.internal.m) aVar2.a()).b() + ", details: " + ((com.moloco.sdk.internal.m) aVar2.a()).a(), null, false, 12, null);
            return kVar2;
        }
        if (vVar2 instanceof com.moloco.sdk.internal.v.b) {
            AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenFetch.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Result;
            androidClientMetrics2.recordCountEvent(countEvent2.withTag(cVar3.b(), "success").withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
            androidClientMetrics2.recordTimerEvent(timerEvent.withTag(cVar3.b(), "success").withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
            androidClientMetrics2.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ServerBidTokenCached.b()).withTag(cVar3.b(), "false").withTag("initial_fetch", String.valueOf(zVar.f)).withTag("async", String.valueOf(z4)));
            zVar.b("[Thread: " + Thread.currentThread().getName() + "] bidtoken request success");
            Mutex mutex = zVar.g;
            c cVar4 = zVar.new c(vVar2, null);
            bVar.f6351a = zVar;
            bVar.b = vVar2;
            bVar.c = null;
            bVar.h = 2;
            if (com.moloco.sdk.internal.utils.a.a(mutex, cVar4, bVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            vVar = vVar2;
            zVar2 = zVar;
            k kVar5 = (k) ((com.moloco.sdk.internal.v.b) vVar).a();
            zVar2.f = false;
            return kVar5;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.y
    public Object a(Continuation<? super k> continuation) {
        b("[Thread: " + Thread.currentThread().getName() + "] Fetching bidToken(), acquiring lock");
        return com.moloco.sdk.internal.utils.a.a(this.g, new a(null), continuation);
    }

    public final void a(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.e, "[Thread: " + Thread.currentThread().getName() + "] " + str, false, 4, null);
    }
}
