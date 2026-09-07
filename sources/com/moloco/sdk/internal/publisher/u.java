package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import java.util.Locale;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
public final class u<T extends AdShowListener> implements FullscreenAd<T>, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6273a;
    public final com.moloco.sdk.internal.services.f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final String d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i e;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m f;
    public final Function1<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> g;
    public final t<T> h;
    public final AdFormatType i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t j;
    public final com.moloco.sdk.internal.publisher.a k;
    public final CoroutineScope l;
    public final TimerEvent m;
    public TimerEvent n;
    public final AdLoad o;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g p;
    public com.moloco.sdk.internal.ortb.model.a q;
    public Function1<? super Boolean, Unit> r;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Long, Duration> {
        public a(Object obj) {
            super(1, obj, com.moloco.sdk.internal.publisher.a.class, "calculateTimeout", "calculateTimeout-5sfh64U(J)J", 0);
        }

        public final long a(long j) {
            return ((com.moloco.sdk.internal.publisher.a) this.receiver).a(j);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Duration invoke(Long l) {
            return Duration.m9230boximpl(a(l.longValue()));
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> {
        public b(Object obj) {
            super(1, obj, u.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b invoke(com.moloco.sdk.internal.ortb.model.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((u) this.receiver).a(p0);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1", f = "FullscreenAdImpl.kt", i = {}, l = {230, 232}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6274a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a b;
        public final /* synthetic */ y c;
        public final /* synthetic */ u<T> d;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$1", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6275a;
            public /* synthetic */ boolean b;

            public a(Continuation<? super a> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(continuation);
                aVar.b = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6275a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.b);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$2", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6276a;
            public /* synthetic */ boolean b;

            public b(Continuation<? super b> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(continuation);
                bVar.b = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6276a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(!this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a aVar, y yVar, u<? super T> uVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = aVar;
            this.c = yVar;
            this.d = uVar;
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

        /* JADX WARN: Code duplicated, block: B:21:0x005f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            y yVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6274a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                yVar = this.c;
                if (yVar != null) {
                    yVar.onAdHidden(MolocoAdKt.createAdInfo$default(this.d.d, null, 2, null));
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            StateFlow<Boolean> stateFlowL = this.b.l();
            a aVar = new a(null);
            this.f6274a = 1;
            if (FlowKt.first(stateFlowL, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            y yVar2 = this.c;
            if (yVar2 != null) {
                yVar2.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.d.d, null, 2, null));
            }
            StateFlow<Boolean> stateFlowL2 = this.b.l();
            b bVar = new b(null);
            this.f6274a = 2;
            if (FlowKt.first(stateFlowL2, bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            yVar = this.c;
            if (yVar != null) {
                yVar.onAdHidden(MolocoAdKt.createAdInfo$default(this.d.d, null, 2, null));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$load$1", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6277a;
        public final /* synthetic */ u<T> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(u<? super T> uVar, String str, AdLoad.Listener listener, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = uVar;
            this.c = str;
            this.d = listener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6277a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.o.load(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$show$2", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6279a;
        public final /* synthetic */ T b;
        public final /* synthetic */ u<T> c;

        public static final class a extends Lambda implements Function0<com.moloco.sdk.internal.ortb.model.q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u<T> f6280a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(u<? super T> uVar) {
                super(0);
                this.f6280a = uVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.ortb.model.q invoke() {
                return this.f6280a.c();
            }
        }

        public static final class b extends Lambda implements Function0<j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u<T> f6281a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(u<? super T> uVar) {
                super(0);
                this.f6281a = uVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final j invoke() {
                return this.f6281a.a();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(T t, u<? super T> uVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = t;
            this.c = uVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6279a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b != null) {
                this.c.h.a(new c0(this.b, this.c.b, this.c.c, new a(this.c), new b(this.c), this.c.i));
            } else {
                this.c.h.a((y) null);
            }
            y yVarD = this.c.h.d();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVarA = this.c.h.a();
            if (kVarA == null || !this.c.isLoaded()) {
                if (yVarD != null) {
                    yVarD.a(com.moloco.sdk.internal.t.a(this.c.d, MolocoAdError.ErrorType.AD_SHOW_ERROR_NOT_LOADED, com.moloco.sdk.internal.o.AD_SHOW_ERROR_NOT_LOADED));
                }
                return Unit.INSTANCE;
            }
            if (kVarA.l().getValue().booleanValue()) {
                if (yVarD != null) {
                    yVarD.a(com.moloco.sdk.internal.t.a(this.c.d, MolocoAdError.ErrorType.AD_SHOW_ERROR_ALREADY_DISPLAYING, com.moloco.sdk.internal.o.AD_SHOW_ERROR_ALREADY_DISPLAYING));
                }
                return Unit.INSTANCE;
            }
            this.c.a(kVarA, yVarD);
            kVarA.a(this.c.p, this.c.a(yVarD));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Context context, com.moloco.sdk.internal.services.f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, Function1<? super com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> generateAggregatedOptions, t<T> adDataHolder, AdFormatType adFormatType, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(generateAggregatedOptions, "generateAggregatedOptions");
        Intrinsics.checkNotNullParameter(adDataHolder, "adDataHolder");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        this.f6273a = context;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = adUnitId;
        this.e = persistentHttpRequest;
        this.f = externalLinkHandler;
        this.g = generateAggregatedOptions;
        this.h = adDataHolder;
        this.i = adFormatType;
        this.j = watermark;
        this.k = adCreateLoadTimeoutManager;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.l = CoroutineScope;
        TimerEvent timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateToLoad.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.m = timerEventStartTimerEvent.withTag(strB, lowerCase);
        this.o = com.moloco.sdk.internal.publisher.e.a(CoroutineScope, new a(adCreateLoadTimeoutManager), adUnitId, new b(this), adFormatType);
        this.p = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g) generateAggregatedOptions.invoke(null);
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.l, null, 1, null);
        a(this, null, 1, null);
        this.r = null;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.k.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.o.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        androidClientMetrics.recordTimerEvent(this.m);
        this.n = androidClientMetrics.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.LoadToShow.b());
        BuildersKt__Builders_commonKt.launch$default(this.l, null, null, new d(this, bidResponseJson, listener, null), 3, null);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.k.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(T t) {
        TimerEvent timerEvent = this.n;
        if (timerEvent != null) {
            AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
            String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
            String lowerCase = this.i.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics.recordTimerEvent(timerEvent.withTag(strB, lowerCase));
        }
        AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ShowAdAttempt.b());
        String strB2 = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase2 = this.i.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics2.recordCountEvent(countEvent.withTag(strB2, lowerCase2));
        BuildersKt__Builders_commonKt.launch$default(this.l, null, null, new f(t, this, null), 3, null);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h b() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVarA = this.h.a();
        if (kVarA != null) {
            return kVarA.getCreativeType();
        }
        return null;
    }

    public final com.moloco.sdk.internal.ortb.model.q c() {
        return this.h.e();
    }

    public final Function1<Boolean, Unit> d() {
        return this.r;
    }

    public final Boolean e() {
        StateFlow<Boolean> stateFlowJ;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVarA = this.h.a();
        if (kVarA == null || (stateFlowJ = kVarA.j()) == null) {
            return null;
        }
        return stateFlowJ.getValue();
    }

    public final j a() {
        return this.h.c();
    }

    public static /* synthetic */ void a(u uVar, com.moloco.sdk.internal.s sVar, int i, Object obj) {
        if ((i & 1) != 0) {
            sVar = null;
        }
        uVar.a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.moloco.sdk.internal.s sVar) {
        StateFlow<Boolean> stateFlowL;
        t<T> tVar = this.h;
        Job jobB = tVar.b();
        if (jobB != null) {
            Job.DefaultImpls.cancel$default(jobB, (CancellationException) null, 1, (Object) null);
        }
        tVar.a((Job) null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVarA = this.h.a();
        boolean z = (kVarA == null || (stateFlowL = kVarA.l()) == null || !stateFlowL.getValue().booleanValue()) ? false : true;
        t<T> tVar2 = this.h;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVarA2 = tVar2.a();
        if (kVarA2 != null) {
            kVarA2.destroy();
        }
        tVar2.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g>) null);
        t<T> tVar3 = this.h;
        y yVarD = tVar3.d();
        tVar3.a((y) null);
        if (sVar != null && yVarD != null) {
            yVarD.a(sVar);
        }
        if (z && yVarD != null) {
            yVarD.onAdHidden(MolocoAdKt.createAdInfo$default(this.d, null, 2, null));
        }
        this.h.a((com.moloco.sdk.internal.ortb.model.q) null);
        this.h.a((j) null);
    }

    public static final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u<T> f6278a;
        public final /* synthetic */ y b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(u<? super T> uVar, y yVar) {
            this.f6278a = uVar;
            this.b = yVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r
        public void a(boolean z) {
            String strC;
            com.moloco.sdk.internal.ortb.model.a aVar = this.f6278a.q;
            if (aVar != null) {
                u<T> uVar = this.f6278a;
                if (aVar.a() && ((!z || aVar.e()) && (strC = aVar.c()) != null)) {
                    uVar.e.a(strC);
                }
            }
            Function1<Boolean, Unit> function1D = this.f6278a.d();
            if (function1D != null) {
                function1D.invoke(Boolean.valueOf(z));
            }
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            u<T> uVar = this.f6278a;
            uVar.a(com.moloco.sdk.internal.t.a(uVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d
        public void a() {
            y yVar = this.b;
            if (yVar != null) {
                yVar.onAdClicked(MolocoAdKt.createAdInfo$default(this.f6278a.d, null, 2, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b a(com.moloco.sdk.internal.ortb.model.c cVar) {
        com.moloco.sdk.internal.ortb.model.o oVarE;
        a(this, null, 1, null);
        Function1<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> function1 = this.g;
        com.moloco.sdk.internal.ortb.model.d dVarE = cVar.e();
        this.p = function1.invoke(dVarE != null ? dVarE.e() : null);
        com.moloco.sdk.internal.ortb.model.d dVarE2 = cVar.e();
        this.q = (dVarE2 == null || (oVarE = dVarE2.e()) == null) ? null : oVarE.a();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> kVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m.a(this.f6273a, this.c, null, cVar, this.f, this.j, 4, null);
        t<T> tVar = this.h;
        tVar.a(kVarA);
        com.moloco.sdk.internal.ortb.model.d dVarE3 = cVar.e();
        tVar.a(dVarE3 != null ? dVarE3.g() : null);
        tVar.a(cVar.c() != null ? new j(cVar.c(), Float.valueOf(cVar.g())) : null);
        return kVarA;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a aVar, y yVar) {
        t<T> tVar = this.h;
        Job jobB = tVar.b();
        if (jobB != null) {
            Job.DefaultImpls.cancel$default(jobB, (CancellationException) null, 1, (Object) null);
        }
        tVar.a(BuildersKt__Builders_commonKt.launch$default(this.l, null, null, new c(aVar, yVar, this, null), 3, null));
    }

    public final void a(Function1<? super Boolean, Unit> function1) {
        this.r = function1;
    }

    public final e a(y yVar) {
        return new e(this, yVar);
    }

    public /* synthetic */ u(Context context, com.moloco.sdk.internal.services.f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, Function1 function1, t tVar, AdFormatType adFormatType, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar2, com.moloco.sdk.internal.publisher.a aVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fVar, aVar, str, iVar, mVar, function1, (i & 128) != 0 ? new t(null, null, null, null, null, 31, null) : tVar, adFormatType, tVar2, aVar2);
    }
}
