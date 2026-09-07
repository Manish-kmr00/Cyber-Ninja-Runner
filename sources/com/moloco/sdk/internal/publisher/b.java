package com.moloco.sdk.internal.publisher;

import android.content.Context;
import android.view.ViewParent;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.i0;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;
import com.smaato.sdk.video.vast.model.Ad;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public static final a f = new a(null);
    public static final String g = "UNABLE_TO_CREATE_AD";
    public static final String h = "AdCreator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlow<Initialization> f6163a;
    public final i0 b;
    public final com.moloco.sdk.internal.publisher.c c;
    public final Function1<Continuation<? super com.moloco.sdk.internal.a>, Object> d;
    public final CoroutineContext e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0541b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6164a;

        static {
            int[] iArr = new int[Initialization.values().length];
            try {
                iArr[Initialization.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Initialization.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6164a = iArr;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator", f = "AdCreator.kt", i = {0, 0}, l = {391}, m = "awaitAdFactoryWithTimeoutOrNull", n = {"createAdType", "awaitTimer"}, s = {"L$0", "L$1"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6165a;
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
            return b.this.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) null, (s) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$awaitAdFactoryWithTimeoutOrNull$2", f = "AdCreator.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6166a;
        public final /* synthetic */ Function1<Continuation<? super com.moloco.sdk.internal.a>, Object> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object> function1, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.a> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6166a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super com.moloco.sdk.internal.a>, Object> function1 = this.b;
                this.f6166a = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createBanner$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {71}, m = "invokeSuspend", n = {Ad.AD_TYPE, "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6167a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, Continuation<? super e> continuation) {
            super(2, continuation);
            this.g = str;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new e(this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            TimerEvent timerEvent;
            long j;
            s sVar;
            String str;
            e eVar;
            TimerEvent timerEvent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.BANNER;
                long jInvoke = b.this.b.invoke();
                String strA = b.this.a();
                TimerEvent timerEventWithTag = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAd.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Creating " + sVar2 + " ad with adUnitId: " + this.g, null, false, 12, null);
                b bVar = b.this;
                Function1 function1 = bVar.d;
                this.f6167a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = bVar.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) function1, sVar2, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventWithTag;
                j = jInvoke;
                sVar = sVar2;
                str = strA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent3 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f6167a;
                ResultKt.throwOnFailure(obj);
                sVar = sVar3;
                str = str2;
                timerEvent = timerEvent3;
                objA = obj;
            }
            com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objA;
            if (aVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f6451a.a();
                com.moloco.sdk.internal.services.f fVarB = com.moloco.sdk.service_locator.a.b.f6453a.b();
                String str3 = this.g;
                com.moloco.sdk.service_locator.a.h hVar = com.moloco.sdk.service_locator.a.h.f6477a;
                j0 j0VarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(this.h);
                AdFormatType adFormatType = AdFormatType.BANNER;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j2 = j;
                TimerEvent timerEvent4 = timerEvent;
                ViewParent viewParentC = aVar.c(contextA, fVarB, str3, j0VarH, mVarD, uVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.b.a(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar.g(), com.moloco.sdk.internal.i.c.c);
                if (viewParentC != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name()).withTag("initial_sdk_init_state", str));
                    androidClientMetrics.recordTimerEvent(timerEvent4.withTag(cVar.b(), "success"));
                    if (viewParentC instanceof r) {
                        ((r) viewParentC).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Created " + sVar + " ad with adUnitId: " + this.g, null, false, 12, null);
                    return new com.moloco.sdk.internal.v.b(viewParentC);
                }
                eVar = this;
                timerEvent2 = timerEvent4;
            } else {
                eVar = this;
                timerEvent2 = timerEvent;
            }
            MolocoAdError.AdCreateError adCreateErrorA = b.this.a(eVar.g, str, timerEvent2, sVar);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.h, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(adCreateErrorA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createBannerTablet$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend", n = {Ad.AD_TYPE, "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6168a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, String str2, Continuation<? super f> continuation) {
            super(2, continuation);
            this.g = str;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new f(this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            TimerEvent timerEvent;
            long j;
            s sVar;
            String str;
            f fVar;
            TimerEvent timerEvent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.BANNER_TABLET;
                long jInvoke = b.this.b.invoke();
                String strA = b.this.a();
                TimerEvent timerEventWithTag = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAd.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Creating " + sVar2 + " ad with adUnitId: " + this.g, null, false, 12, null);
                b bVar = b.this;
                Function1 function1 = bVar.d;
                this.f6168a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = bVar.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) function1, sVar2, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventWithTag;
                j = jInvoke;
                sVar = sVar2;
                str = strA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent3 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f6168a;
                ResultKt.throwOnFailure(obj);
                sVar = sVar3;
                str = str2;
                timerEvent = timerEvent3;
                objA = obj;
            }
            com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objA;
            if (aVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f6451a.a();
                com.moloco.sdk.internal.services.f fVarB = com.moloco.sdk.service_locator.a.b.f6453a.b();
                String str3 = this.g;
                com.moloco.sdk.service_locator.a.h hVar = com.moloco.sdk.service_locator.a.h.f6477a;
                j0 j0VarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(this.h);
                AdFormatType adFormatType = AdFormatType.BANNER;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j2 = j;
                TimerEvent timerEvent4 = timerEvent;
                ViewParent viewParentB = aVar.b(contextA, fVarB, str3, j0VarH, mVarD, uVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.b.a(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar.g(), com.moloco.sdk.internal.i.d.c);
                if (viewParentB != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name()).withTag("initial_sdk_init_state", str));
                    androidClientMetrics.recordTimerEvent(timerEvent4.withTag(cVar.b(), "success"));
                    if (viewParentB instanceof r) {
                        ((r) viewParentB).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Created " + sVar + " ad with adUnitId: " + this.g, null, false, 12, null);
                    return new com.moloco.sdk.internal.v.b(viewParentB);
                }
                fVar = this;
                timerEvent2 = timerEvent4;
            } else {
                fVar = this;
                timerEvent2 = timerEvent;
            }
            MolocoAdError.AdCreateError adCreateErrorA = b.this.a(fVar.g, str, timerEvent2, sVar);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.h, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(adCreateErrorA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createInterstitial$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {251}, m = "invokeSuspend", n = {Ad.AD_TYPE, "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6169a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, String str2, Continuation<? super g> continuation) {
            super(2, continuation);
            this.g = str;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new g(this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            TimerEvent timerEvent;
            long j;
            s sVar;
            String str;
            g gVar;
            TimerEvent timerEvent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.INTERSTITIAL;
                long jInvoke = b.this.b.invoke();
                String strA = b.this.a();
                TimerEvent timerEventWithTag = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAd.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Creating " + sVar2 + " ad with adUnitId: " + this.g, null, false, 12, null);
                b bVar = b.this;
                Function1 function1 = bVar.d;
                this.f6169a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = bVar.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) function1, sVar2, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventWithTag;
                j = jInvoke;
                sVar = sVar2;
                str = strA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent3 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f6169a;
                ResultKt.throwOnFailure(obj);
                sVar = sVar3;
                str = str2;
                timerEvent = timerEvent3;
                objA = obj;
            }
            com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objA;
            if (aVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f6451a.a();
                com.moloco.sdk.internal.services.f fVarB = com.moloco.sdk.service_locator.a.b.f6453a.b();
                String str3 = this.g;
                com.moloco.sdk.service_locator.a.h hVar = com.moloco.sdk.service_locator.a.h.f6477a;
                j0 j0VarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = com.moloco.sdk.service_locator.a.i.f6483a.c();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(this.h);
                AdFormatType adFormatType = AdFormatType.INTERSTITIAL;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j2 = j;
                TimerEvent timerEvent4 = timerEvent;
                InterstitialAd interstitialAdA = aVar.a(contextA, fVarB, str3, j0VarH, mVarD, iVarC, uVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.b.b(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null));
                if (interstitialAdA != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name()).withTag("initial_sdk_init_state", str.toString()));
                    androidClientMetrics.recordTimerEvent(timerEvent4.withTag(cVar.b(), "success"));
                    if (interstitialAdA instanceof r) {
                        ((r) interstitialAdA).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Created " + sVar + " ad with adUnitId: " + this.g, null, false, 12, null);
                    return new com.moloco.sdk.internal.v.b(interstitialAdA);
                }
                gVar = this;
                timerEvent2 = timerEvent4;
            } else {
                gVar = this;
                timerEvent2 = timerEvent;
            }
            MolocoAdError.AdCreateError adCreateErrorA = b.this.a(gVar.g, str, timerEvent2, sVar);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.h, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(adCreateErrorA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createMREC$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {169}, m = "invokeSuspend", n = {Ad.AD_TYPE, "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6170a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, Continuation<? super h> continuation) {
            super(2, continuation);
            this.g = str;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new h(this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            TimerEvent timerEvent;
            long j;
            s sVar;
            String str;
            h hVar;
            TimerEvent timerEvent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.MREC;
                long jA = b.this.b.a();
                String strA = b.this.a();
                TimerEvent timerEventWithTag = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAd.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Creating " + sVar2 + " ad with adUnitId: " + this.g, null, false, 12, null);
                b bVar = b.this;
                Function1 function1 = bVar.d;
                this.f6170a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jA;
                this.e = 1;
                objA = bVar.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) function1, sVar2, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventWithTag;
                j = jA;
                sVar = sVar2;
                str = strA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent3 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f6170a;
                ResultKt.throwOnFailure(obj);
                sVar = sVar3;
                str = str2;
                timerEvent = timerEvent3;
                objA = obj;
            }
            com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objA;
            if (aVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f6451a.a();
                com.moloco.sdk.internal.services.f fVarB = com.moloco.sdk.service_locator.a.b.f6453a.b();
                String str3 = this.g;
                com.moloco.sdk.service_locator.a.h hVar2 = com.moloco.sdk.service_locator.a.h.f6477a;
                j0 j0VarH = hVar2.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVarD = hVar2.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(this.h);
                AdFormatType adFormatType = AdFormatType.MREC;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j2 = j;
                TimerEvent timerEvent4 = timerEvent;
                ViewParent viewParentA = aVar.a(contextA, fVarB, str3, j0VarH, mVarD, uVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.b.a(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar2.g(), com.moloco.sdk.internal.i.b.c);
                if (viewParentA != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name()).withTag("initial_sdk_init_state", str.toString()));
                    androidClientMetrics.recordTimerEvent(timerEvent4.withTag(cVar.b(), "success"));
                    if (viewParentA instanceof r) {
                        ((r) viewParentA).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Created " + sVar + " ad with adUnitId: " + this.g, null, false, 12, null);
                    return new com.moloco.sdk.internal.v.b(viewParentA);
                }
                hVar = this;
                timerEvent2 = timerEvent4;
            } else {
                hVar = this;
                timerEvent2 = timerEvent;
            }
            MolocoAdError.AdCreateError adCreateErrorA = b.this.a(hVar.g, str, timerEvent2, sVar);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.h, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(adCreateErrorA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createNativeAd$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {206}, m = "invokeSuspend", n = {Ad.AD_TYPE, "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6171a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, String str2, Continuation<? super i> continuation) {
            super(2, continuation);
            this.g = str;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new i(this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            TimerEvent timerEvent;
            long j;
            s sVar;
            String str;
            i iVar;
            TimerEvent timerEvent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.NATIVE_AD_MEDIATION;
                long jA = b.this.b.a();
                String strA = b.this.a();
                TimerEvent timerEventWithTag = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAd.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Creating " + sVar2 + " ad with adUnitId: " + this.g, null, false, 12, null);
                b bVar = b.this;
                Function1 function1 = bVar.d;
                this.f6171a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jA;
                this.e = 1;
                objA = bVar.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) function1, sVar2, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventWithTag;
                j = jA;
                sVar = sVar2;
                str = strA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent3 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f6171a;
                ResultKt.throwOnFailure(obj);
                sVar = sVar3;
                str = str2;
                timerEvent = timerEvent3;
                objA = obj;
            }
            com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objA;
            if (aVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f6451a.a();
                com.moloco.sdk.internal.services.f fVarB = com.moloco.sdk.service_locator.a.b.f6453a.b();
                com.moloco.sdk.internal.services.n nVarC = com.moloco.sdk.service_locator.a.e.f6462a.c();
                String str3 = this.g;
                com.moloco.sdk.service_locator.a.h hVar = com.moloco.sdk.service_locator.a.h.f6477a;
                j0 j0VarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = com.moloco.sdk.service_locator.a.i.f6483a.c();
                com.moloco.sdk.internal.a0 a0VarG = hVar.g();
                long j2 = j;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(this.h);
                AdFormatType adFormatType = AdFormatType.NATIVE;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                TimerEvent timerEvent4 = timerEvent;
                NativeAd nativeAdA = aVar.a(contextA, fVarB, nVarC, str3, j0VarH, mVarD, iVarC, a0VarG, uVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.b.c(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar.f());
                if (nativeAdA != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name()).withTag("initial_sdk_init_state", str.toString()));
                    androidClientMetrics.recordTimerEvent(timerEvent4.withTag(cVar.b(), "success"));
                    if (nativeAdA instanceof r) {
                        ((r) nativeAdA).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Created " + sVar + " ad with adUnitId: " + this.g, null, false, 12, null);
                    return new com.moloco.sdk.internal.v.b(nativeAdA);
                }
                iVar = this;
                timerEvent2 = timerEvent4;
            } else {
                iVar = this;
                timerEvent2 = timerEvent;
            }
            MolocoAdError.AdCreateError adCreateErrorA = b.this.a(iVar.g, str, timerEvent2, sVar);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.h, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(adCreateErrorA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createRewardedInterstitial$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {291}, m = "invokeSuspend", n = {Ad.AD_TYPE, "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6172a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, String str2, Continuation<? super j> continuation) {
            super(2, continuation);
            this.g = str;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new j(this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            TimerEvent timerEvent;
            long j;
            s sVar;
            String str;
            j jVar;
            TimerEvent timerEvent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.REWARDED;
                long jInvoke = b.this.b.invoke();
                String strA = b.this.a();
                TimerEvent timerEventWithTag = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAd.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Creating " + sVar2 + " ad with adUnitId: " + this.g, null, false, 12, null);
                b bVar = b.this;
                Function1 function1 = bVar.d;
                this.f6172a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = bVar.a((Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object>) function1, sVar2, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventWithTag;
                j = jInvoke;
                sVar = sVar2;
                str = strA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent3 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f6172a;
                ResultKt.throwOnFailure(obj);
                sVar = sVar3;
                str = str2;
                timerEvent = timerEvent3;
                objA = obj;
            }
            com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objA;
            if (aVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f6451a.a();
                com.moloco.sdk.internal.services.f fVarB = com.moloco.sdk.service_locator.a.b.f6453a.b();
                String str3 = this.g;
                com.moloco.sdk.service_locator.a.h hVar = com.moloco.sdk.service_locator.a.h.f6477a;
                j0 j0VarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = com.moloco.sdk.service_locator.a.i.f6483a.c();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u uVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(this.h);
                AdFormatType adFormatType = AdFormatType.REWARDED;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j2 = j;
                TimerEvent timerEvent4 = timerEvent;
                RewardedInterstitialAd rewardedInterstitialAdB = aVar.b(contextA, fVarB, str3, j0VarH, mVarD, iVarC, uVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.b.b(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null));
                if (rewardedInterstitialAdB != null) {
                    AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                    androidClientMetrics.recordCountEvent(countEvent.withTag(cVar.b(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name()).withTag("initial_sdk_init_state", str));
                    androidClientMetrics.recordTimerEvent(timerEvent4.withTag(cVar.b(), "success"));
                    if (rewardedInterstitialAdB instanceof r) {
                        ((r) rewardedInterstitialAdB).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.h, "Created " + sVar + " ad with adUnitId: " + this.g, null, false, 12, null);
                    return new com.moloco.sdk.internal.v.b(rewardedInterstitialAdB);
                }
                jVar = this;
                timerEvent2 = timerEvent4;
            } else {
                jVar = this;
                timerEvent2 = timerEvent;
            }
            MolocoAdError.AdCreateError adCreateErrorA = b.this.a(jVar.g, str, timerEvent2, sVar);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.h, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(adCreateErrorA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(StateFlow<? extends Initialization> initializationState, i0 timeProviderService, com.moloco.sdk.internal.publisher.c adCreatorConfiguration, Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object> awaitAdFactory) {
        Intrinsics.checkNotNullParameter(initializationState, "initializationState");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(adCreatorConfiguration, "adCreatorConfiguration");
        Intrinsics.checkNotNullParameter(awaitAdFactory, "awaitAdFactory");
        this.f6163a = initializationState;
        this.b = timeProviderService;
        this.c = adCreatorConfiguration;
        this.d = awaitAdFactory;
        this.e = com.moloco.sdk.internal.scheduling.b.a().getDefault();
    }

    public final Object d(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new h(str, str2, null), continuation);
    }

    public final Object e(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new i(str, str2, null), continuation);
    }

    public final Object f(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new j(str, str2, null), continuation);
    }

    public static /* synthetic */ Object d(b bVar, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return bVar.d(str, str2, continuation);
    }

    public static /* synthetic */ Object e(b bVar, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return bVar.e(str, str2, continuation);
    }

    public static /* synthetic */ Object f(b bVar, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return bVar.f(str, str2, continuation);
    }

    public final Object b(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new f(str, str2, null), continuation);
    }

    public final Object c(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new g(str, str2, null), continuation);
    }

    public static /* synthetic */ Object b(b bVar, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return bVar.b(str, str2, continuation);
    }

    public static /* synthetic */ Object c(b bVar, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return bVar.c(str, str2, continuation);
    }

    public final Object a(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new e(str, str2, null), continuation);
    }

    public static /* synthetic */ Object a(b bVar, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return bVar.a(str, str2, (Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>) continuation);
    }

    public final MolocoAdError.AdCreateError a(String str, String str2, TimerEvent timerEvent, s sVar) {
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.b());
        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
        CountEvent countEventWithTag = countEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("initial_sdk_init_state", str2).withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar.name());
        Initialization value = this.f6163a.getValue();
        int i2 = value == null ? -1 : C0541b.f6164a[value.ordinal()];
        if (i2 == -1) {
            com.moloco.sdk.internal.error.b bVarC = com.moloco.sdk.service_locator.a.b.f6453a.c();
            StringBuilder sb = new StringBuilder("CREATE_");
            String upperCase = sVar.name().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            com.moloco.sdk.internal.error.b.a.a(bVarC, sb.append(upperCase).append("_AD_FAILED_SDK_INIT_NOT_COMPLETED").toString(), null, 2, null);
            AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
            TimerEvent timerEventWithTag = timerEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            androidClientMetrics.recordTimerEvent(timerEventWithTag.withTag(cVar2.b(), "sdk_init_not_completed"));
            androidClientMetrics.recordCountEvent(countEventWithTag.withTag(cVar2.b(), "sdk_init_not_completed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "Cannot retrieve AdFactory as SDK init was not called or not completed", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_WAS_NOT_COMPLETED;
        }
        if (i2 == 1) {
            com.moloco.sdk.internal.error.b.a.a(com.moloco.sdk.service_locator.a.b.f6453a.c(), g, null, 2, null);
            AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
            TimerEvent timerEventWithTag2 = timerEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            androidClientMetrics2.recordTimerEvent(timerEventWithTag2.withTag(cVar3.b(), "unable_to_create_ad"));
            androidClientMetrics2.recordCountEvent(countEventWithTag.withTag(cVar3.b(), "unable_to_create_ad"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "Could not find the adUnitId that was requested for load: " + str, null, false, 12, null);
            return MolocoAdError.AdCreateError.UNABLE_TO_CREATE_AD;
        }
        if (i2 == 2) {
            com.moloco.sdk.internal.error.b bVarC2 = com.moloco.sdk.service_locator.a.b.f6453a.c();
            StringBuilder sb2 = new StringBuilder("CREATE_");
            String upperCase2 = sVar.name().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            com.moloco.sdk.internal.error.b.a.a(bVarC2, sb2.append(upperCase2).append("_AD_FAILED_SDK_INIT_FAILED").toString(), null, 2, null);
            AndroidClientMetrics androidClientMetrics3 = AndroidClientMetrics.INSTANCE;
            TimerEvent timerEventWithTag3 = timerEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            androidClientMetrics3.recordTimerEvent(timerEventWithTag3.withTag(cVar4.b(), "sdk_init_failed"));
            androidClientMetrics3.recordCountEvent(countEventWithTag.withTag(cVar4.b(), "sdk_init_failed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "Cannot create AdFactory as SDK init was failure", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(Function1<? super Continuation<? super com.moloco.sdk.internal.a>, ? extends Object> function1, s sVar, Continuation<? super com.moloco.sdk.internal.a> continuation) throws Throwable {
        c cVar;
        TimerEvent timerEventStartTimerEvent;
        Object objM9406withTimeoutOrNullKLykuaI;
        s sVar2 = sVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.e = i2 - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = cVar.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateAdAwaitAdFactory.b());
            Duration duration = this.c.c().get(sVar2);
            long rawValue = duration != null ? duration.getRawValue() : this.c.d();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "Waiting for AdFactory with timeout: " + ((Object) Duration.m9281toStringimpl(rawValue)), null, false, 12, null);
            d dVar = new d(function1, null);
            cVar.f6165a = sVar2;
            cVar.b = timerEventStartTimerEvent;
            cVar.e = 1;
            objM9406withTimeoutOrNullKLykuaI = TimeoutKt.m9406withTimeoutOrNullKLykuaI(rawValue, dVar, cVar);
            if (objM9406withTimeoutOrNullKLykuaI == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            TimerEvent timerEvent = (TimerEvent) cVar.b;
            s sVar3 = (s) cVar.f6165a;
            ResultKt.throwOnFailure(obj);
            timerEventStartTimerEvent = timerEvent;
            sVar2 = sVar3;
            objM9406withTimeoutOrNullKLykuaI = obj;
        }
        com.moloco.sdk.internal.a aVar = (com.moloco.sdk.internal.a) objM9406withTimeoutOrNullKLykuaI;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "AdFactory received: " + (aVar != null), null, false, 12, null);
        AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.AdType.b(), sVar2.name()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), aVar != null ? "success" : LoginLogger.EVENT_EXTRAS_FAILURE));
        return objM9406withTimeoutOrNullKLykuaI;
    }

    public final String a() {
        String strName;
        Initialization value = this.f6163a.getValue();
        if (value != null && (strName = value.name()) != null) {
            String lowerCase = strName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (lowerCase != null) {
                return lowerCase;
            }
        }
        return "not_invoked_or_in_progress";
    }
}
