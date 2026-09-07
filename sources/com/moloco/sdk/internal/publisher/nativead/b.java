package com.moloco.sdk.internal.publisher.nativead;

import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.g;
import com.moloco.sdk.internal.publisher.r;
import com.moloco.sdk.internal.publisher.x;
import com.moloco.sdk.internal.services.f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements NativeAd, r {
    public static final a o = new a(null);
    public static final String p = "NativeAdImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6216a;
    public final c b;
    public final com.moloco.sdk.internal.publisher.nativead.a c;
    public final f d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a e;
    public final m f;
    public final i g;
    public final com.moloco.sdk.internal.publisher.a h;
    public NativeAd.InteractionListener i;
    public final AdFormatType j;
    public final CoroutineScope k;
    public final TimerEvent l;
    public d m;
    public Job n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdImpl$load$1", f = "NativeAdImpl.kt", i = {0}, l = {103}, m = "invokeSuspend", n = {"adLoadListenerWithTracker"}, s = {"L$0"})
    public static final class C0545b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6217a;
        public int b;
        public final /* synthetic */ AdLoad.Listener d;
        public final /* synthetic */ String e;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.b$b$a */
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
            public a(Object obj) {
                super(0, obj, b.class, "handleGeneralAdClick", "handleGeneralAdClick()V", 0);
            }

            public final void a() {
                ((b) this.receiver).handleGeneralAdClick();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0545b(AdLoad.Listener listener, String str, Continuation<? super C0545b> continuation) {
            super(2, continuation);
            this.d = listener;
            this.e = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0545b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0545b(this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            x xVar;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = b.this;
                x xVarA = bVar.a(bVar.l, this.d);
                c cVar = b.this.b;
                String str = this.e;
                TimerEvent timerEvent = b.this.l;
                this.f6217a = xVarA;
                this.b = 1;
                Object objB = cVar.b(str, timerEvent, xVarA, this);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                xVar = xVarA;
                value = objB;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                xVar = (x) this.f6217a;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(value);
            if (thM7907exceptionOrNullimpl != null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.p, "Failed to load native ad.", thM7907exceptionOrNullimpl, false, 8, null);
                return Unit.INSTANCE;
            }
            c.b bVar2 = (c.b) value;
            b bVar3 = b.this;
            bVar3.a(new d(bVar3.f6216a, bVar2.d(), bVar2.e(), bVar3.d, bVar3.e, bVar3.j, bVar3.g, bVar3.f));
            bVar3.getAssets().a(bVar2.f());
            bVar3.getAssets().a(new a(bVar3));
            xVar.a(MolocoAdKt.createAdInfo(bVar3.f6216a, Boxing.boxFloat(bVar2.d().g())), bVar2.d().e().g());
            return Unit.INSTANCE;
        }
    }

    public b(String adUnitId, c nativeAdLoader, com.moloco.sdk.internal.publisher.nativead.a assets, f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, m externalLinkHandler, i persistentHttpRequest, com.moloco.sdk.internal.publisher.a createLoadTimeoutManager) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(nativeAdLoader, "nativeAdLoader");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(createLoadTimeoutManager, "createLoadTimeoutManager");
        this.f6216a = adUnitId;
        this.b = nativeAdLoader;
        this.c = assets;
        this.d = appLifecycleTrackerService;
        this.e = customUserEventBuilderService;
        this.f = externalLinkHandler;
        this.g = persistentHttpRequest;
        this.h = createLoadTimeoutManager;
        this.j = AdFormatType.NATIVE;
        this.k = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.l = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.LoadAd.b());
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.k, null, 1, null);
        getAssets().a();
        setInteractionListener(null);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.h.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public NativeAd.InteractionListener getInteractionListener() {
        return this.i;
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void handleGeneralAdClick() {
        NativeAd.InteractionListener interactionListener = getInteractionListener();
        if (interactionListener != null) {
            interactionListener.onGeneralClickHandled();
        }
        d dVar = this.m;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void handleImpression() {
        NativeAd.InteractionListener interactionListener = getInteractionListener();
        if (interactionListener != null) {
            interactionListener.onImpressionHandled();
        }
        d dVar = this.m;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return getAssets().c() != null;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public synchronized void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        Job job = this.n;
        if (job != null && job.isActive()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, p, "load() called while another load operation is in progress. Ignoring this call.", null, false, 12, null);
        } else if (isLoaded()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, p, "load() called but ad is already loaded. Ignoring this call.", null, false, 12, null);
        } else {
            this.n = BuildersKt__Builders_commonKt.launch$default(this.k, null, null, new C0545b(listener, bidResponseJson, null), 3, null);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.h.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void setInteractionListener(NativeAd.InteractionListener interactionListener) {
        this.i = interactionListener;
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.publisher.nativead.a getAssets() {
        return this.c;
    }

    public final Job d() {
        return this.n;
    }

    public final CoroutineScope f() {
        return this.k;
    }

    public final d a() {
        return this.m;
    }

    public final void a(d dVar) {
        this.m = dVar;
    }

    public final void a(Job job) {
        this.n = job;
    }

    public final x a(TimerEvent timerEvent, AdLoad.Listener listener) {
        return g.a(listener, timerEvent, this.j);
    }
}
