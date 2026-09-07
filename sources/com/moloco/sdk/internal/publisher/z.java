package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdShowListener f6289a;
    public final com.moloco.sdk.internal.services.f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final Function0<com.moloco.sdk.internal.ortb.model.q> d;
    public final Function0<j> e;
    public final com.moloco.sdk.internal.w f;
    public final com.moloco.sdk.internal.f g;
    public final AdFormatType h;

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InternalAdShowListenerImpl$onAdShowSuccess$2$1", f = "InternalAdShowListener.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6290a;
        public final /* synthetic */ long c;
        public final /* synthetic */ j d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, j jVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return z.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6290a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = z.this.c;
                long j = this.c;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.e eVar = com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.e.b;
                String strA = this.d.a();
                this.f6290a = 1;
                obj = aVar.a(j, eVar, strA, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            z.this.g.a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public z(AdShowListener adShowListener, com.moloco.sdk.internal.services.f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, Function0<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents, Function0<j> provideBUrlData, com.moloco.sdk.internal.w sdkEventUrlTracker, com.moloco.sdk.internal.f bUrlTracker, AdFormatType adType) {
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(provideBUrlData, "provideBUrlData");
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(bUrlTracker, "bUrlTracker");
        Intrinsics.checkNotNullParameter(adType, "adType");
        this.f6289a = adShowListener;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = provideSdkEvents;
        this.e = provideBUrlData;
        this.f = sdkEventUrlTracker;
        this.g = bUrlTracker;
        this.h = adType;
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdClicked(MolocoAd molocoAd) {
        String strA;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.b.b();
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.d.invoke();
        if (qVarInvoke != null && (strA = qVarInvoke.a()) != null) {
            com.moloco.sdk.internal.w.a.a(this.f, strA, System.currentTimeMillis(), null, 4, null);
        }
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.AdClicked.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordCountEvent(countEvent.withTag(strB, lowerCase));
        AdShowListener adShowListener = this.f6289a;
        if (adShowListener != null) {
            adShowListener.onAdClicked(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdHidden(MolocoAd molocoAd) {
        String strC;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.d.invoke();
        if (qVarInvoke != null && (strC = qVarInvoke.c()) != null) {
            com.moloco.sdk.internal.w.a.a(this.f, strC, System.currentTimeMillis(), null, 4, null);
        }
        AdShowListener adShowListener = this.f6289a;
        if (adShowListener != null) {
            adShowListener.onAdHidden(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdShowSuccess(MolocoAd molocoAd) {
        String strM;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.d.invoke();
        if (qVarInvoke != null && (strM = qVarInvoke.m()) != null) {
            com.moloco.sdk.internal.w.a.a(this.f, strM, System.currentTimeMillis(), null, 4, null);
        }
        j jVarInvoke = this.e.invoke();
        if (jVarInvoke != null) {
            BuildersKt__Builders_commonKt.launch$default(com.moloco.sdk.internal.scheduling.c.f6295a.b(), null, null, new a(System.currentTimeMillis(), jVarInvoke, null), 3, null);
        }
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ShowAdSuccess.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordCountEvent(countEvent.withTag(strB, lowerCase));
        AdShowListener adShowListener = this.f6289a;
        if (adShowListener != null) {
            adShowListener.onAdShowSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void a(com.moloco.sdk.internal.s internalError) {
        String strK;
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.d.invoke();
        if (qVarInvoke != null && (strK = qVarInvoke.k()) != null) {
            this.f.a(strK, System.currentTimeMillis(), internalError);
        }
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ShowAdFailed.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        androidClientMetrics.recordCountEvent(countEvent.withTag(strB, lowerCase).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), String.valueOf(internalError.c().getErrorType())));
        AdShowListener adShowListener = this.f6289a;
        if (adShowListener != null) {
            adShowListener.onAdShowFailed(internalError.c());
        }
    }
}
