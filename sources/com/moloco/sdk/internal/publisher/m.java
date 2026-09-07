package com.moloco.sdk.internal.publisher;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
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
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes10.dex */
public final class m<L extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r> extends Banner implements r {
    public static final a v = new a(null);
    public static final int w = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6202a;
    public final com.moloco.sdk.internal.services.f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final String d;
    public final boolean e;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m f;
    public final Function8<Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t, com.moloco.sdk.internal.a0, com.moloco.sdk.internal.services.s, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L>> g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t h;
    public final com.moloco.sdk.internal.publisher.a i;
    public final com.moloco.sdk.internal.a0 j;
    public final com.moloco.sdk.internal.i k;
    public final com.moloco.sdk.internal.services.s l;
    public final TimerEvent m;
    public TimerEvent n;
    public final CoroutineScope o;
    public final com.moloco.sdk.internal.publisher.k<L> p;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h q;
    public b0 r;
    public BannerAdShowListener s;
    public final AdLoad t;
    public final L u;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Long, Duration> {
        public b(Object obj) {
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

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> {
        public c(Object obj) {
            super(1, obj, m.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b invoke(com.moloco.sdk.internal.ortb.model.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((m) this.receiver).a(p0);
        }
    }

    public static final class d extends Lambda implements Function0<com.moloco.sdk.internal.ortb.model.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<L> f6203a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(m<L> mVar) {
            super(0);
            this.f6203a = mVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.ortb.model.q invoke() {
            return this.f6203a.p.e();
        }
    }

    public static final class e extends Lambda implements Function0<com.moloco.sdk.internal.publisher.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<L> f6204a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m<L> mVar) {
            super(0);
            this.f6204a = mVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.publisher.j invoke() {
            return this.f6204a.p.b();
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$listenToAdDisplayState$1$1", f = "Banner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6205a;
        public /* synthetic */ boolean b;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Boolean> continuation) {
            return ((f) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(continuation);
            fVar.b = ((Boolean) obj).booleanValue();
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6205a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(!this.b);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$listenToAdDisplayState$1$2", f = "Banner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6206a;
        public /* synthetic */ boolean b;
        public final /* synthetic */ m<L> c;
        public final /* synthetic */ com.moloco.sdk.internal.publisher.k<L> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(m<L> mVar, com.moloco.sdk.internal.publisher.k<L> kVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = mVar;
            this.d = kVar;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((g) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(this.c, this.d, continuation);
            gVar.b = ((Boolean) obj).booleanValue();
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6206a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b) {
                TimerEvent timerEvent = this.c.n;
                if (timerEvent != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
                    String lowerCase = "BANNER".toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    androidClientMetrics.recordTimerEvent(timerEvent.withTag(strB, lowerCase));
                }
                b0 b0Var = this.c.r;
                if (b0Var != null) {
                    b0Var.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.c.d, null, 2, null));
                }
            } else {
                b0 b0Var2 = this.c.r;
                if (b0Var2 != null) {
                    b0Var2.onAdHidden(MolocoAdKt.createAdInfo$default(this.c.d, null, 2, null));
                }
                Job jobA = this.d.a();
                if (jobA != null) {
                    Job.DefaultImpls.cancel$default(jobA, (CancellationException) null, 1, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$load$1", f = "Banner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6207a;
        public final /* synthetic */ m<L> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(m<L> mVar, String str, AdLoad.Listener listener, Continuation<? super h> continuation) {
            super(2, continuation);
            this.b = mVar;
            this.c = str;
            this.d = listener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6207a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.t.load(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<L> f6208a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(m<L> mVar) {
            super(1);
            this.f6208a = mVar;
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c button) {
            Intrinsics.checkNotNullParameter(button, "button");
            this.f6208a.q.a(button);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$recreateXenossAd$touchInterceptor$1$1", f = "Banner.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6209a;
        public final /* synthetic */ SharedFlow<Unit> b;
        public final /* synthetic */ m<L> c;

        public static final class a implements FlowCollector<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m<L> f6210a;

            public a(m<L> mVar) {
                this.f6210a = mVar;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                this.f6210a.u.a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SharedFlow<Unit> sharedFlow, m<L> mVar, Continuation<? super j> continuation) {
            super(2, continuation);
            this.b = sharedFlow;
            this.c = mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6209a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Unit> sharedFlow = this.b;
                a aVar = new a(this.c);
                this.f6209a = 1;
                if (sharedFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$recreateXenossAd$touchInterceptor$1$2$1", f = "Banner.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6211a;
        public final /* synthetic */ MotionEvent b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.u c;
        public final /* synthetic */ m<L> d;
        public final /* synthetic */ MutableSharedFlow<Unit> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(MotionEvent motionEvent, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.u uVar, m<L> mVar, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super k> continuation) {
            super(2, continuation);
            this.b = motionEvent;
            this.c = uVar;
            this.d = mVar;
            this.e = mutableSharedFlow;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6211a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MotionEvent event = this.b;
                if (event != null) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.u uVar = this.c;
                    m<L> mVar = this.d;
                    MutableSharedFlow<Unit> mutableSharedFlow = this.e;
                    Intrinsics.checkNotNullExpressionValue(event, "event");
                    com.moloco.sdk.internal.services.s sVar = mVar.l;
                    String strC = mVar.p.c();
                    String strD = mVar.p.d();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar = mVar.q;
                    this.f6211a = 1;
                    if (uVar.a(event, sVar, strC, strD, hVar, mutableSharedFlow, (64 & 64) != 0 ? com.moloco.sdk.internal.y.a() : null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public static final class l implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<L> f6212a;

        public l(m<L> mVar) {
            this.f6212a = mVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r
        public void a(boolean z) {
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            m<L> mVar = this.f6212a;
            mVar.a(com.moloco.sdk.internal.t.a(mVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d
        public void a() {
            b0 b0Var = this.f6212a.r;
            if (b0Var != null) {
                b0Var.onAdClicked(MolocoAdKt.createAdInfo$default(this.f6212a.d, null, 2, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public m(Context context, com.moloco.sdk.internal.services.f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, Function8<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, ? super com.moloco.sdk.internal.ortb.model.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t, ? super com.moloco.sdk.internal.a0, ? super com.moloco.sdk.internal.services.s, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L>> createXenossBannerView, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, ? extends L> createXenossBannerAdShowListener, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, com.moloco.sdk.internal.a0 viewLifecycleOwner, com.moloco.sdk.internal.i bannerSize, com.moloco.sdk.internal.services.s clickthroughService) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(createXenossBannerView, "createXenossBannerView");
        Intrinsics.checkNotNullParameter(createXenossBannerAdShowListener, "createXenossBannerAdShowListener");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        this.f6202a = context;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = adUnitId;
        this.e = z;
        this.f = externalLinkHandler;
        this.g = createXenossBannerView;
        this.h = watermark;
        this.i = adCreateLoadTimeoutManager;
        this.j = viewLifecycleOwner;
        this.k = bannerSize;
        this.l = clickthroughService;
        TimerEvent timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateToLoad.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = "BANNER".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.m = timerEventStartTimerEvent.withTag(strB, lowerCase);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.o = CoroutineScope;
        this.p = new com.moloco.sdk.internal.publisher.k<>(null, null, null, null, null, null, false, 127, null);
        this.q = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a();
        this.t = com.moloco.sdk.internal.publisher.e.a(CoroutineScope, new b(adCreateLoadTimeoutManager), adUnitId, new c(this), AdFormatType.BANNER);
        this.u = createXenossBannerAdShowListener.invoke(new l(this));
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.o, null, 1, null);
        a(this, null, 1, null);
        setAdShowListener(null);
        this.r = null;
    }

    @Override // com.moloco.sdk.publisher.Banner, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.D, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.moloco.sdk.publisher.Banner
    public BannerAdShowListener getAdShowListener() {
        return this.s;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.i.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.t.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        androidClientMetrics.recordTimerEvent(this.m);
        this.n = androidClientMetrics.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.LoadToShow.b());
        BuildersKt__Builders_commonKt.launch$default(this.o, null, null, new h(this, bidResponseJson, listener, null), 3, null);
    }

    @Override // com.moloco.sdk.publisher.Banner, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.moloco.sdk.publisher.Banner
    public void setAdShowListener(BannerAdShowListener bannerAdShowListener) {
        b0 b0VarA = a(bannerAdShowListener);
        this.r = b0VarA;
        this.s = b0VarA.a();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j2) {
        this.i.setCreateAdObjectStartTime(j2);
    }

    public final b0 a(BannerAdShowListener bannerAdShowListener) {
        return new b0(bannerAdShowListener, this.b, this.c, new d(this), new e(this), AdFormatType.BANNER);
    }

    public static /* synthetic */ void a(m mVar, com.moloco.sdk.internal.s sVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sVar = null;
        }
        mVar.a(sVar);
    }

    public final void a(com.moloco.sdk.internal.s sVar) {
        b0 b0Var;
        b0 b0Var2;
        com.moloco.sdk.internal.publisher.k<L> kVar = this.p;
        Job jobA = kVar.a();
        if (jobA != null) {
            Job.DefaultImpls.cancel$default(jobA, (CancellationException) null, 1, (Object) null);
        }
        kVar.a((Job) null);
        boolean zBooleanValue = a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) this.p.f()).getValue().booleanValue();
        com.moloco.sdk.internal.publisher.k<L> kVar2 = this.p;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> wVarF = kVar2.f();
        if (wVarF != null) {
            wVarF.destroy();
        }
        kVar2.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) null);
        if (sVar != null && (b0Var2 = this.r) != null) {
            b0Var2.a(sVar);
        }
        if (zBooleanValue && (b0Var = this.r) != null) {
            b0Var.onAdHidden(MolocoAdKt.createAdInfo$default(this.d, null, 2, null));
        }
        this.p.a((com.moloco.sdk.internal.ortb.model.q) null);
        this.p.a((com.moloco.sdk.internal.publisher.j) null);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b a(com.moloco.sdk.internal.ortb.model.c cVar) {
        com.moloco.sdk.internal.ortb.model.b bVarA;
        com.moloco.sdk.internal.ortb.model.b bVarA2;
        a(this, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> wVarInvoke = this.g.invoke(this.f6202a, this.c, cVar, this.f, this.h, this.j, this.l, this.q);
        com.moloco.sdk.internal.publisher.k<L> kVar = this.p;
        kVar.a(wVarInvoke);
        kVar.a(cVar.e().g());
        kVar.a(cVar.c() != null ? new com.moloco.sdk.internal.publisher.j(cVar.c(), Float.valueOf(cVar.g())) : null);
        com.moloco.sdk.internal.ortb.model.m mVarA = cVar.e().a();
        kVar.b((mVarA == null || (bVarA2 = mVarA.a()) == null) ? null : bVarA2.a());
        com.moloco.sdk.internal.ortb.model.m mVarA2 = cVar.e().a();
        kVar.a((mVarA2 == null || (bVarA = mVarA2.a()) == null) ? null : bVarA.c());
        com.moloco.sdk.internal.ortb.model.m mVarA3 = cVar.e().a();
        kVar.a((mVarA3 != null ? mVarA3.a() : null) != null);
        wVarInvoke.setAdShowListener(this.u);
        a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a) wVarInvoke);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.moloco.sdk.internal.j.a(this.k.b()), com.moloco.sdk.internal.j.a(this.k.a()));
        layoutParams.gravity = 17;
        addView(wVarInvoke, layoutParams);
        if (this.p.g()) {
            final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.u(this.f6202a);
            final MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
            BuildersKt__Builders_commonKt.launch$default(this.o, null, null, new j(mutableSharedFlowMutableSharedFlow$default, this, null), 3, null);
            uVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.moloco.sdk.internal.publisher.m$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return m.a(this.f$0, uVar, mutableSharedFlowMutableSharedFlow$default, view, motionEvent);
                }
            });
            addView(uVar);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b(this.f, this.f6202a, null, 0, 12, null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388691;
        bVar.setPadding(12, 0, 0, 12);
        bVar.setPrivacyUrl(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.f6689a);
        bVar.setOnButtonRenderedListener(new i(this));
        bVar.setLayoutParams(layoutParams2);
        addView(bVar);
        return wVarInvoke;
    }

    public static final boolean a(m this$0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.u this_apply, MutableSharedFlow clickthroughFlow, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(clickthroughFlow, "$clickthroughFlow");
        BuildersKt__Builders_commonKt.launch$default(this$0.o, null, null, new k(motionEvent, this_apply, this$0, clickthroughFlow, null), 3, null);
        return false;
    }

    public final StateFlow<Boolean> a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<L> wVar) {
        if (!this.e && wVar != null) {
            return wVar.l();
        }
        return isViewShown();
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a aVar) {
        com.moloco.sdk.internal.publisher.k<L> kVar = this.p;
        Job jobA = kVar.a();
        if (jobA != null) {
            Job.DefaultImpls.cancel$default(jobA, (CancellationException) null, 1, (Object) null);
        }
        kVar.a(FlowKt.launchIn(FlowKt.onEach(FlowKt.dropWhile(a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) this.p.f()), new f(null)), new g(this, kVar, null)), this.o));
    }
}
