package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes11.dex */
public final class g0 extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r> {
    public final Context g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s i;
    public final m j;
    public final CoroutineScope k;
    public final e0 l;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h m;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a n;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastBannerView$listenToPlayerEvents$1", f = "VastBannerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6566a;
        public /* synthetic */ Object b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super Unit> continuation) {
            return ((a) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = g0.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6566a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b;
            if (Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.i.b)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r adShowListener = g0.this.getAdShowListener();
                if (adShowListener != null) {
                    adShowListener.a(true);
                }
            } else if (Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.c.b)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r adShowListener2 = g0.this.getAdShowListener();
                if (adShowListener2 != null) {
                    adShowListener2.a(false);
                }
            } else if (Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.a.b)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r adShowListener3 = g0.this.getAdShowListener();
                if (adShowListener3 != null) {
                    adShowListener3.a();
                }
            } else if (bVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.f) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r adShowListener4 = g0.this.getAdShowListener();
                if (adShowListener4 != null) {
                    adShowListener4.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.f) bVar).a());
                }
            } else if (!Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.g.b) && !Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.C0646b.b) && !Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.d.b) && !Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.h.b)) {
                Intrinsics.areEqual(bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b.e.b);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s options, m externalLinkHandler, CoroutineScope scope, e0 adLoader) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        this.g = context;
        this.h = customUserEventBuilderService;
        this.i = options;
        this.j = externalLinkHandler;
        this.k = scope;
        this.l = adLoader;
        setTag("MolocoVastBannerView");
        this.m = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        super.destroy();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.n;
        if (aVar != null) {
            aVar.destroy();
        }
        this.n = null;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.D, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h getCreativeType() {
        return this.m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w
    public void j() {
        com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> vVarA = getAdLoader().a();
        if (vVarA instanceof com.moloco.sdk.internal.v.a) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((com.moloco.sdk.internal.v.a) vVarA).a();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r adShowListener = getAdShowListener();
            if (adShowListener != null) {
                adShowListener.a(cVar);
                return;
            }
            return;
        }
        if (!(vVarA instanceof com.moloco.sdk.internal.v.b)) {
            throw new NoWhenBranchMatchedException();
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVarA).a(), this.j, this.g, this.h, this.i.g(), this.i.e(), this.i.f(), this.i.c(), this.i.d(), this.i.b(), this.i.a());
        this.n = aVarA;
        setAdView(this.i.h().invoke(this.g, aVarA));
        n();
        aVarA.d();
    }

    public final void n() {
        Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> flowA;
        Flow flowOnEach;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.n;
        if (aVar == null || (flowA = aVar.a()) == null || (flowOnEach = FlowKt.onEach(flowA, new a(null))) == null) {
            return;
        }
        FlowKt.launchIn(flowOnEach, this.k);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w
    public e0 getAdLoader() {
        return this.l;
    }
}
