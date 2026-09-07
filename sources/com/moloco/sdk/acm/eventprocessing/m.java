package com.moloco.sdk.acm.eventprocessing;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.eventprocessing.c f6031a;
    public final com.moloco.sdk.acm.a b;
    public final ScheduledExecutorService c;
    public final CoroutineScope d;
    public ScheduledFuture<?> e;
    public final Mutex f;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer", f = "RequestSchedulerTimer.kt", i = {0, 0}, l = {TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER}, m = "resetScheduleAndTriggerNewScheduledUpload", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6032a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return m.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer$schedule$1$1", f = "RequestSchedulerTimer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6033a;

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
            return m.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6033a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            m.this.f6031a.a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer", f = "RequestSchedulerTimer.kt", i = {0, 0}, l = {TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER}, m = "scheduleUploadAndPurge", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6034a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return m.this.b(this);
        }
    }

    public m(com.moloco.sdk.acm.eventprocessing.c dbWorkRequest, com.moloco.sdk.acm.a opsConfig, ScheduledExecutorService scheduler, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(dbWorkRequest, "dbWorkRequest");
        Intrinsics.checkNotNullParameter(opsConfig, "opsConfig");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f6031a = dbWorkRequest;
        this.b = opsConfig;
        this.c = scheduler;
        this.d = coroutineScope;
        this.f = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.l
    public Object b(Continuation<? super Unit> continuation) throws Throwable {
        c cVar;
        m mVar;
        Mutex mutex;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.e = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.f;
            cVar.f6034a = this;
            cVar.b = mutex2;
            cVar.e = 1;
            if (mutex2.lock(null, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mVar = this;
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) cVar.b;
            mVar = (m) cVar.f6034a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            mVar.a();
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.l
    public Object a(Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        m mVar;
        Mutex mutex;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.f;
            aVar.f6032a = this;
            aVar.b = mutex2;
            aVar.e = 1;
            if (mutex2.lock(null, aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mVar = this;
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) aVar.b;
            mVar = (m) aVar.f6032a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            ScheduledFuture<?> scheduledFuture = mVar.e;
            if (scheduledFuture != null) {
                Boxing.boxBoolean(scheduledFuture.cancel(false));
            }
            mVar.a();
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ m(com.moloco.sdk.acm.eventprocessing.c cVar, com.moloco.sdk.acm.a aVar, ScheduledExecutorService scheduledExecutorService, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            Intrinsics.checkNotNullExpressionValue(scheduledExecutorService, "newSingleThreadScheduledExecutor()");
        }
        this(cVar, aVar, scheduledExecutorService, coroutineScope);
    }

    public static final void b(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(this$0.d, null, null, this$0.new b(null), 3, null);
    }

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.e;
        if (scheduledFuture == null || (scheduledFuture != null && scheduledFuture.isCancelled())) {
            this.e = this.c.scheduleWithFixedDelay(new Runnable() { // from class: com.moloco.sdk.acm.eventprocessing.m$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    m.b(this.f$0);
                }
            }, this.b.h(), this.b.h(), TimeUnit.SECONDS);
        }
    }
}
