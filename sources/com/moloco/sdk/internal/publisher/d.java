package com.moloco.sdk.internal.publisher;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdErrorKt;
import com.moloco.sdk.publisher.MolocoAdKt;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements AdLoad {
    public static final a m = new a(null);
    public static final String n = "AdLoad";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Long, Duration> f6177a;
    public final String b;
    public final Function1<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> c;
    public final com.moloco.sdk.internal.ortb.a d;
    public final p e;
    public final AdFormatType f;
    public final CoroutineScope g;
    public boolean h;
    public String i;
    public com.moloco.sdk.internal.ortb.model.e j;
    public final TimerEvent k;
    public Job l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$load$1", f = "AdLoad.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6178a;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;
        public final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, AdLoad.Listener listener, long j, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = listener;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return d.this.new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.internal.ortb.model.d dVarE;
            com.moloco.sdk.internal.ortb.model.d dVarE2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6178a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                d dVar = d.this;
                String str = this.c;
                this.f6178a = 1;
                obj = dVar.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str2 = (String) obj;
            if (str2 == null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdLoadImpl", "Could not pre-process the bid response. Failing the load() call.", null, false, 12, null);
                AdLoad.Listener listener = this.d;
                if (listener != null) {
                    listener.onAdLoadFailed(MolocoAdErrorKt.createAdErrorInfo(d.this.b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR));
                }
                AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                TimerEvent timerEventWithTag = d.this.k.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
                com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                String strB = cVar.b();
                MolocoAdError.ErrorType errorType = MolocoAdError.ErrorType.AD_BID_PARSE_ERROR;
                TimerEvent timerEventWithTag2 = timerEventWithTag.withTag(strB, String.valueOf(errorType.getErrorCode()));
                com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.AdType;
                String strB2 = cVar2.b();
                String strName = d.this.f.name();
                Locale locale = Locale.ROOT;
                String lowerCase = strName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                androidClientMetrics.recordTimerEvent(timerEventWithTag2.withTag(strB2, lowerCase));
                CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.LoadAdFailed.b()).withTag(cVar.b(), String.valueOf(errorType.getErrorCode()));
                String strB3 = cVar2.b();
                String lowerCase2 = d.this.f.name().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                androidClientMetrics.recordCountEvent(countEventWithTag.withTag(strB3, lowerCase2));
                return Unit.INSTANCE;
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdLoadImpl", "Processed the bidResponse, proceeding with the load() call.", null, false, 12, null);
            x xVarA = g.a(this.d, d.this.k, d.this.f);
            if (Intrinsics.areEqual(d.this.i, str2)) {
                if (d.this.isLoaded()) {
                    com.moloco.sdk.internal.ortb.model.q qVarG = null;
                    MolocoAd molocoAdCreateAdInfo$default = MolocoAdKt.createAdInfo$default(d.this.b, null, 2, null);
                    long j = this.e;
                    d dVar2 = d.this;
                    com.moloco.sdk.internal.ortb.model.c cVarA = dVar2.a(dVar2.j);
                    xVarA.a(molocoAdCreateAdInfo$default, j, (cVarA == null || (dVarE2 = cVarA.e()) == null) ? null : dVarE2.g());
                    d dVar3 = d.this;
                    com.moloco.sdk.internal.ortb.model.c cVarA2 = dVar3.a(dVar3.j);
                    if (cVarA2 != null && (dVarE = cVarA2.e()) != null) {
                        qVarG = dVarE.g();
                    }
                    xVarA.a(molocoAdCreateAdInfo$default, qVarG);
                    return Unit.INSTANCE;
                }
                Job job = d.this.l;
                if (job != null && job.isActive()) {
                    return Unit.INSTANCE;
                }
            }
            d.this.a(str2, this.e, xVarA);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl", f = "AdLoad.kt", i = {0}, l = {149}, m = "processBidResponse", n = {"bidResponseJson"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6179a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return d.this.a((String) null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1", f = "AdLoad.kt", i = {0}, l = {170}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C0542d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6180a;
        public /* synthetic */ Object b;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ x f;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a */
        public static final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f6181a;
            public final /* synthetic */ x b;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c c;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoad$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0543a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6182a;
                public final /* synthetic */ d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0543a(d dVar, x xVar, com.moloco.sdk.internal.ortb.model.c cVar, Continuation<? super C0543a> continuation) {
                    super(2, continuation);
                    this.b = dVar;
                    this.c = xVar;
                    this.d = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0543a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0543a(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    com.moloco.sdk.internal.ortb.model.d dVarE;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f6182a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.h = true;
                    x xVar = this.c;
                    MolocoAd molocoAdCreateAdInfo = MolocoAdKt.createAdInfo(this.b.b, Boxing.boxFloat(this.d.g()));
                    d dVar = this.b;
                    com.moloco.sdk.internal.ortb.model.c cVarA = dVar.a(dVar.j);
                    xVar.a(molocoAdCreateAdInfo, (cVarA == null || (dVarE = cVarA.e()) == null) ? null : dVarE.g());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a$b */
            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadError$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6183a;
                public final /* synthetic */ d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(d dVar, x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.b = dVar;
                    this.c = xVar;
                    this.d = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new b(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    com.moloco.sdk.internal.ortb.model.d dVarE;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f6183a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.h = false;
                    x xVar = this.c;
                    com.moloco.sdk.internal.s sVarA = com.moloco.sdk.internal.t.a(this.b.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, this.d);
                    d dVar = this.b;
                    com.moloco.sdk.internal.ortb.model.c cVarA = dVar.a(dVar.j);
                    xVar.a(sVarA, (cVarA == null || (dVarE = cVarA.e()) == null) ? null : dVarE.g());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a$c */
            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadTimeout$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6184a;
                public final /* synthetic */ d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(d dVar, x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar, Continuation<? super c> continuation) {
                    super(2, continuation);
                    this.b = dVar;
                    this.c = xVar;
                    this.d = aVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new c(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    com.moloco.sdk.internal.ortb.model.d dVarE;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f6184a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.h = false;
                    x xVar = this.c;
                    com.moloco.sdk.internal.s sVarA = com.moloco.sdk.internal.t.a(this.b.b, MolocoAdError.ErrorType.AD_LOAD_TIMEOUT_ERROR, this.d);
                    d dVar = this.b;
                    com.moloco.sdk.internal.ortb.model.c cVarA = dVar.a(dVar.j);
                    xVar.a(sVarA, (cVarA == null || (dVarE = cVarA.e()) == null) ? null : dVarE.g());
                    return Unit.INSTANCE;
                }
            }

            public a(d dVar, x xVar, com.moloco.sdk.internal.ortb.model.c cVar) {
                this.f6181a = dVar;
                this.b = xVar;
                this.c = cVar;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a() {
                BuildersKt__Builders_commonKt.launch$default(this.f6181a.g, null, null, new C0543a(this.f6181a, this.b, this.c, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                BuildersKt__Builders_commonKt.launch$default(this.f6181a.g, null, null, new c(this.f6181a, this.b, timeoutError, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                Intrinsics.checkNotNullParameter(internalError, "internalError");
                BuildersKt__Builders_commonKt.launch$default(this.f6181a.g, null, null, new b(this.f6181a, this.b, internalError, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0542d(String str, long j, x xVar, Continuation<? super C0542d> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = j;
            this.f = xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0542d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0542d c0542d = d.this.new C0542d(this.d, this.e, this.f, continuation);
            c0542d.b = obj;
            return c0542d;
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:42:0x00f6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.internal.ortb.model.e eVar;
            CoroutineScope coroutineScope;
            com.moloco.sdk.internal.ortb.model.c cVarA;
            com.moloco.sdk.internal.ortb.model.c cVarA2;
            com.moloco.sdk.internal.ortb.model.d dVarE;
            com.moloco.sdk.internal.ortb.model.d dVarE2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6180a;
            com.moloco.sdk.internal.ortb.model.q qVarG = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.b;
                d.this.h = false;
                if (!Intrinsics.areEqual(d.this.i, this.d)) {
                    d.this.i = this.d;
                    d.this.j = null;
                }
                eVar = d.this.j;
                if (eVar == null) {
                    com.moloco.sdk.internal.ortb.a aVar = d.this.d;
                    String str = this.d;
                    this.b = coroutineScope2;
                    this.f6180a = 1;
                    Object objA = aVar.a(str, this);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                    obj = objA;
                }
                if (eVar != null) {
                    cVarA = d.this.a(eVar);
                } else {
                    cVarA = null;
                }
                if (cVarA == null) {
                    ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b) d.this.c.invoke(cVarA)).a(((Duration) d.this.f6177a.invoke(Boxing.boxLong(this.e))).getRawValue(), new a(d.this, this.f, cVarA));
                    return Unit.INSTANCE;
                }
                x xVar = this.f;
                d dVar = d.this;
                com.moloco.sdk.internal.s sVarA = com.moloco.sdk.internal.t.a(dVar.b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE);
                cVarA2 = dVar.a(dVar.j);
                if (cVarA2 != null && (dVarE = cVarA2.e()) != null) {
                    qVarG = dVarE.g();
                }
                xVar.a(sVarA, qVarG);
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.b;
            ResultKt.throwOnFailure(obj);
            d dVar2 = d.this;
            x xVar2 = this.f;
            long j = this.e;
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            CoroutineScopeKt.ensureActive(coroutineScope);
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                com.moloco.sdk.internal.ortb.model.e eVar2 = (com.moloco.sdk.internal.ortb.model.e) ((com.moloco.sdk.internal.v.b) vVar).a();
                dVar2.j = eVar2;
                MolocoAd molocoAdCreateAdInfo$default = MolocoAdKt.createAdInfo$default(dVar2.b, null, 2, null);
                com.moloco.sdk.internal.ortb.model.c cVarA3 = dVar2.a(dVar2.j);
                xVar2.a(molocoAdCreateAdInfo$default, j, (cVarA3 == null || (dVarE2 = cVarA3.e()) == null) ? null : dVarE2.g());
                eVar = eVar2;
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, d.n, "startLoadJob failed to parse BID json string.", (Throwable) ((com.moloco.sdk.internal.v.a) vVar).a(), false, 8, null);
                eVar = null;
            }
            if (eVar != null) {
                cVarA = d.this.a(eVar);
            } else {
                cVarA = null;
            }
            if (cVarA == null) {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b) d.this.c.invoke(cVarA)).a(((Duration) d.this.f6177a.invoke(Boxing.boxLong(this.e))).getRawValue(), new a(d.this, this.f, cVarA));
                return Unit.INSTANCE;
            }
            x xVar3 = this.f;
            d dVar3 = d.this;
            com.moloco.sdk.internal.s sVarA2 = com.moloco.sdk.internal.t.a(dVar3.b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE);
            cVarA2 = dVar3.a(dVar3.j);
            if (cVarA2 != null) {
                qVarG = dVarE.g();
            }
            xVar3.a(sVarA2, qVarG);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CoroutineScope scope, Function1<? super Long, Duration> timeout, String adUnitId, Function1<? super com.moloco.sdk.internal.ortb.model.c, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> recreateXenossAdLoader, com.moloco.sdk.internal.ortb.a parseBidResponse, p adLoadPreprocessor, AdFormatType adFormatType) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(recreateXenossAdLoader, "recreateXenossAdLoader");
        Intrinsics.checkNotNullParameter(parseBidResponse, "parseBidResponse");
        Intrinsics.checkNotNullParameter(adLoadPreprocessor, "adLoadPreprocessor");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        this.f6177a = timeout;
        this.b = adUnitId;
        this.c = recreateXenossAdLoader;
        this.d = parseBidResponse;
        this.e = adLoadPreprocessor;
        this.f = adFormatType;
        this.g = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.k = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.LoadAd.b());
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.h;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        long jInvoke = com.moloco.sdk.service_locator.a.h.f6477a.f().invoke();
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdLoadImpl", "load() called with bidResponseJson: " + bidResponseJson, false, 4, null);
        this.k.startTimer();
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.LoadAdAttempt.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = this.f.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordCountEvent(countEvent.withTag(strB, lowerCase));
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, new b(bidResponseJson, listener, jInvoke, null), 3, null);
    }

    public final com.moloco.sdk.internal.ortb.model.c a(com.moloco.sdk.internal.ortb.model.e eVar) {
        List<com.moloco.sdk.internal.ortb.model.r> listB;
        com.moloco.sdk.internal.ortb.model.r rVar;
        List<com.moloco.sdk.internal.ortb.model.c> listB2;
        if (eVar == null || (listB = eVar.b()) == null || (rVar = listB.get(0)) == null || (listB2 = rVar.b()) == null) {
            return null;
        }
        return listB2.get(0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, Continuation<? super String> continuation) throws Throwable {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.d = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            p pVar = this.e;
            cVar.f6179a = str;
            cVar.d = 1;
            objA = pVar.a(str, cVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) cVar.f6179a;
            ResultKt.throwOnFailure(objA);
        }
        String str2 = (String) objA;
        return str2 != null ? str2 : str;
    }

    public final void a(String str, long j, x xVar) {
        Job job = this.l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.l = BuildersKt__Builders_commonKt.launch$default(this.g, null, null, new C0542d(str, j, xVar, null), 3, null);
    }
}
