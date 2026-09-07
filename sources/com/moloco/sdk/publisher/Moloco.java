package com.moloco.sdk.publisher;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.InitConfig;
import com.moloco.sdk.acm.UpdateConfig;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.b;
import com.moloco.sdk.internal.publisher.c;
import com.moloco.sdk.internal.publisher.v;
import com.moloco.sdk.internal.publisher.w;
import com.moloco.sdk.internal.services.bidtoken.h;
import com.moloco.sdk.internal.services.bidtoken.i;
import com.moloco.sdk.internal.services.bidtoken.n;
import com.moloco.sdk.internal.services.init.j;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.service_locator.a;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\ba\u0010LJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007J\\\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2>\u0010\u0018\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u0017H\u0007J\\\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2>\u0010\u0018\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u0017H\u0007J\\\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2>\u0010\u0018\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u0017H\u0007J\\\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2>\u0010\u0018\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\u001eH\u0007J\\\u0010#\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2>\u0010\u0018\u001a:\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`\"H\u0007J\\\u0010'\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2>\u0010\u0018\u001a:\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0010j\u0002`&H\u0007J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0002J\u0013\u0010+\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0013\u00100\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0004\b/\u0010,R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR*\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bE\u0010F\u0012\u0004\bK\u0010L\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR*\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b-\u0010M\u0012\u0004\bR\u0010L\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010T\u001a\u00020S8FX\u0087\u0004¢\u0006\f\u0012\u0004\bV\u0010L\u001a\u0004\bT\u0010UR\u001c\u0010Z\u001a\u0004\u0018\u00010\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\bY\u0010L\u001a\u0004\bW\u0010XR\u0016\u0010^\u001a\u0004\u0018\u00010[8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0016\u0010`\u001a\u0004\u0018\u00010\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b_\u0010X\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006b"}, d2 = {"Lcom/moloco/sdk/publisher/Moloco;", "", "Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "initParam", "Lcom/moloco/sdk/publisher/MolocoInitializationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", MobileAdsBridgeBase.initializeMethodName, "logMolocoInfo", "Landroid/content/Context;", "context", "Lcom/moloco/sdk/publisher/MolocoBidTokenListener;", "getBidToken", "", "adUnitId", "watermarkString", "Lkotlin/Function2;", "Lcom/moloco/sdk/publisher/Banner;", "Lkotlin/ParameterName;", "name", "banner", "Lcom/moloco/sdk/publisher/MolocoAdError$AdCreateError;", "error", "Lcom/moloco/sdk/publisher/CreateBannerCallback;", "callback", "createBanner", "createBannerTablet", "createMREC", "Lcom/moloco/sdk/publisher/NativeAd;", "nativeAd", "Lcom/moloco/sdk/publisher/CreateNativeAdCallback;", "createNativeAd", "Lcom/moloco/sdk/publisher/InterstitialAd;", "interstitialAd", "Lcom/moloco/sdk/publisher/CreateInterstitialAdCallback;", "createInterstitial", "Lcom/moloco/sdk/publisher/RewardedInterstitialAd;", "rewardedInterstitialAd", "Lcom/moloco/sdk/publisher/CreateRewardedInterstitialAdCallback;", "createRewardedInterstitial", "Lcom/moloco/sdk/Init$SDKInitResponse;", "sdkInitResponse", "processInitConfigs", "updateAndroidClientMetricsOnInitSuccess", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initParams", "initializeAndroidClientMetrics", "clearState$moloco_sdk_release", "clearState", "Lcom/moloco/sdk/internal/publisher/v;", "initializationHandler$delegate", "Lkotlin/Lazy;", "getInitializationHandler", "()Lcom/moloco/sdk/internal/publisher/v;", "initializationHandler", "Lcom/moloco/sdk/internal/services/bidtoken/h;", "bidTokenHandler$delegate", "getBidTokenHandler", "()Lcom/moloco/sdk/internal/services/bidtoken/h;", "bidTokenHandler", "Lcom/moloco/sdk/internal/publisher/b;", "adCreator$delegate", "getAdCreator", "()Lcom/moloco/sdk/internal/publisher/b;", "adCreator", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "initJob", "Lkotlinx/coroutines/Job;", "getInitJob", "()Lkotlinx/coroutines/Job;", "setInitJob", "(Lkotlinx/coroutines/Job;)V", "getInitJob$annotations", "()V", "Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "getInitParams", "()Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "setInitParams", "(Lcom/moloco/sdk/publisher/init/MolocoInitParams;)V", "getInitParams$annotations", "", "isInitialized", "()Z", "isInitialized$annotations", "getBidRequestEndpoint", "()Ljava/lang/String;", "getBidRequestEndpoint$annotations", "bidRequestEndpoint", "Lcom/moloco/sdk/publisher/MediationInfo;", "getMediationInfo$moloco_sdk_release", "()Lcom/moloco/sdk/publisher/MediationInfo;", "mediationInfo", "getAppKey$moloco_sdk_release", "appKey", "<init>", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0})
public final class Moloco {
    private static Job initJob;
    private static MolocoInitParams initParams;
    public static final Moloco INSTANCE = new Moloco();

    /* JADX INFO: renamed from: initializationHandler$delegate, reason: from kotlin metadata */
    private static final Lazy initializationHandler = LazyKt.lazy(new Function0<v>() { // from class: com.moloco.sdk.publisher.Moloco$initializationHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v invoke() {
            return new v(a.h.f6477a.f());
        }
    });

    /* JADX INFO: renamed from: bidTokenHandler$delegate, reason: from kotlin metadata */
    private static final Lazy bidTokenHandler = LazyKt.lazy(new Function0<i>() { // from class: com.moloco.sdk.publisher.Moloco$bidTokenHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i invoke() {
            return new i(n.a(), Moloco.INSTANCE.getInitializationHandler(), a.h.f6477a.f(), AndroidClientMetrics.INSTANCE);
        }
    });

    /* JADX INFO: renamed from: adCreator$delegate, reason: from kotlin metadata */
    private static final Lazy adCreator = LazyKt.lazy(new Function0<b>() { // from class: com.moloco.sdk.publisher.Moloco$adCreator$2

        /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$adCreator$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/moloco/sdk/internal/a;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$adCreator$2$1", f = "Moloco.kt", i = {}, l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super com.moloco.sdk.internal.a>, Object> {
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    v initializationHandler = Moloco.INSTANCE.getInitializationHandler();
                    this.label = 1;
                    obj = initializationHandler.a(this);
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

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super com.moloco.sdk.internal.a> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(Moloco.INSTANCE.getInitializationHandler().d(), a.h.f6477a.f(), new c(null, 0L, 3, null), new AnonymousClass1(null));
        }
    });
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createBanner$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createBanner$1", f = "Moloco.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<Banner, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String str, String str2, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.a(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                pair = TuplesKt.to(((com.moloco.sdk.internal.v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            Banner banner = (Banner) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Banner for adUnitId: " + this.$adUnitId + " has error: " + (banner == null), null, false, 12, null);
            this.$callback.invoke(banner, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createBannerTablet$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createBannerTablet$1", f = "Moloco.kt", i = {}, l = {Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<Banner, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C36611(String str, String str2, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C36611> continuation) {
            super(2, continuation);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36611(this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.b(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                pair = TuplesKt.to(((com.moloco.sdk.internal.v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            Banner banner = (Banner) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Banner for adUnitId: " + this.$adUnitId + " has error: " + (banner == null), null, false, 12, null);
            this.$callback.invoke(banner, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createInterstitial$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createInterstitial$1", f = "Moloco.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<InterstitialAd, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C36621(String str, String str2, Function2<? super InterstitialAd, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C36621> continuation) {
            super(2, continuation);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36621(this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.c(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                pair = TuplesKt.to(((com.moloco.sdk.internal.v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            InterstitialAd interstitialAd = (InterstitialAd) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Interstitial for adUnitId: " + this.$adUnitId + " has error: " + (interstitialAd == null), null, false, 12, null);
            this.$callback.invoke(interstitialAd, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createMREC$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createMREC$1", f = "Moloco.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<Banner, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C36631(String str, String str2, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C36631> continuation) {
            super(2, continuation);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36631(this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.d(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                pair = TuplesKt.to(((com.moloco.sdk.internal.v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            Banner banner = (Banner) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "MREC for adUnitId: " + this.$adUnitId + " has error: " + (banner == null), null, false, 12, null);
            this.$callback.invoke(banner, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createNativeAd$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createNativeAd$1", f = "Moloco.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<NativeAd, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C36641(String str, String str2, Function2<? super NativeAd, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C36641> continuation) {
            super(2, continuation);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36641(this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.e(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                pair = TuplesKt.to(((com.moloco.sdk.internal.v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            NativeAd nativeAd = (NativeAd) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Native Ad for adUnitId: " + this.$adUnitId + " has error: " + (nativeAd == null), null, false, 12, null);
            this.$callback.invoke(nativeAd, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createRewardedInterstitial$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createRewardedInterstitial$1", f = "Moloco.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<RewardedInterstitialAd, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C36651(String str, String str2, Function2<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C36651> continuation) {
            super(2, continuation);
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36651(this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b adCreator = Moloco.INSTANCE.getAdCreator();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.f(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                pair = TuplesKt.to(((com.moloco.sdk.internal.v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof com.moloco.sdk.internal.v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Rewarded for adUnitId: " + this.$adUnitId + " has error: " + (rewardedInterstitialAd == null), null, false, 12, null);
            this.$callback.invoke(rewardedInterstitialAd, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$getBidToken$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$getBidToken$1", f = "Moloco.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MolocoBidTokenListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C36661(MolocoBidTokenListener molocoBidTokenListener, Continuation<? super C36661> continuation) {
            super(2, continuation);
            this.$listener = molocoBidTokenListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36661(this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Handling bid token request", null, false, 12, null);
                h bidTokenHandler = Moloco.INSTANCE.getBidTokenHandler();
                MolocoBidTokenListener molocoBidTokenListener = this.$listener;
                this.label = 1;
                if (bidTokenHandler.a(molocoBidTokenListener, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$initialize$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$initialize$1", f = "Moloco.kt", i = {}, l = {109, 111, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C36671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MolocoInitParams $initParam;
        final /* synthetic */ MolocoInitializationListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C36671(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, Continuation<? super C36671> continuation) {
            super(2, continuation);
            this.$initParam = molocoInitParams;
            this.$listener = molocoInitializationListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C36671(this.$initParam, this.$listener, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x008d  */
        /* JADX WARN: Code duplicated, block: B:22:0x009f  */
        /* JADX WARN: Code duplicated, block: B:23:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:25:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:27:0x00ce A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x00e1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.internal.v vVar;
            Moloco moloco;
            MolocoInitializationListener molocoInitializationListener;
            MolocoInitializationListener molocoInitializationListener2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        vVar = (com.moloco.sdk.internal.v) obj;
                        if (vVar instanceof com.moloco.sdk.internal.v.a) {
                            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Moloco SDK initialization failed", null, false, 12, null);
                            molocoInitializationListener = this.$listener;
                            if (molocoInitializationListener != null) {
                                w.a(molocoInitializationListener, v.f.a(((j) ((com.moloco.sdk.internal.v.a) vVar).a()).toString()));
                            }
                        } else if (vVar instanceof com.moloco.sdk.internal.v.b) {
                            moloco = Moloco.INSTANCE;
                            moloco.processInitConfigs((Init.SDKInitResponse) ((com.moloco.sdk.internal.v.b) vVar).a());
                            this.label = 3;
                            if (moloco.updateAndroidClientMetricsOnInitSuccess(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Moloco SDK initialization success", null, false, 12, null);
                molocoInitializationListener2 = this.$listener;
                if (molocoInitializationListener2 != null) {
                    w.a(molocoInitializationListener2, v.f.b());
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "launched the scope to initialize sdk with thread name: " + Thread.currentThread().getName() + " and dispatcher DispatcherProvider().IO", null, false, 12, null);
            com.moloco.sdk.internal.error.crash.a aVarA = a.d.f6460a.a();
            this.label = 1;
            if (aVarA.a(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Moloco moloco2 = Moloco.INSTANCE;
            moloco2.initializeAndroidClientMetrics(this.$initParam);
            v initializationHandler = moloco2.getInitializationHandler();
            String appKey = this.$initParam.getAppKey();
            MediationInfo mediationInfo = this.$initParam.getMediationInfo();
            com.moloco.sdk.internal.services.init.n nVarC = a.f.f6470a.c();
            this.label = 2;
            obj = initializationHandler.a(appKey, mediationInfo, nVarC, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.a) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Moloco SDK initialization failed", null, false, 12, null);
                molocoInitializationListener = this.$listener;
                if (molocoInitializationListener != null) {
                    w.a(molocoInitializationListener, v.f.a(((j) ((com.moloco.sdk.internal.v.a) vVar).a()).toString()));
                }
            } else if (vVar instanceof com.moloco.sdk.internal.v.b) {
                moloco = Moloco.INSTANCE;
                moloco.processInitConfigs((Init.SDKInitResponse) ((com.moloco.sdk.internal.v.b) vVar).a());
                this.label = 3;
                if (moloco.updateAndroidClientMetricsOnInitSuccess(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Moloco SDK initialization success", null, false, 12, null);
                molocoInitializationListener2 = this.$listener;
                if (molocoInitializationListener2 != null) {
                    w.a(molocoInitializationListener2, v.f.b());
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C36671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private Moloco() {
    }

    @JvmStatic
    public static final void createBanner(String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createBanner$default(String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        createBanner(str, str2, function2);
    }

    @JvmStatic
    public static final void createBannerTablet(String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner tablet async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C36611(adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createBannerTablet$default(String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        createBannerTablet(str, str2, function2);
    }

    @JvmStatic
    public static final void createInterstitial(String adUnitId, String watermarkString, Function2<? super InterstitialAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating interstitial ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C36621(adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createInterstitial$default(String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        createInterstitial(str, str2, function2);
    }

    @JvmStatic
    public static final void createMREC(String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner MREC async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C36631(adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createMREC$default(String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        createMREC(str, str2, function2);
    }

    @JvmStatic
    public static final void createNativeAd(String adUnitId, String watermarkString, Function2<? super NativeAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating native ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C36641(adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createNativeAd$default(String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        createNativeAd(str, str2, function2);
    }

    @JvmStatic
    public static final void createRewardedInterstitial(String adUnitId, String watermarkString, Function2<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating rewarded ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C36651(adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createRewardedInterstitial$default(String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        createRewardedInterstitial(str, str2, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b getAdCreator() {
        return (b) adCreator.getValue();
    }

    public static final String getBidRequestEndpoint() {
        String adServerUrl;
        Init.SDKInitResponse sDKInitResponseE = INSTANCE.getInitializationHandler().e();
        if (sDKInitResponseE == null || (adServerUrl = sDKInitResponseE.getAdServerUrl()) == null) {
            return null;
        }
        return (StringsKt.startsWith$default(adServerUrl, d.v, false, 2, (Object) null) || StringsKt.startsWith$default(adServerUrl, "https://", false, 2, (Object) null)) ? adServerUrl : "https://" + adServerUrl;
    }

    @JvmStatic
    public static /* synthetic */ void getBidRequestEndpoint$annotations() {
    }

    @JvmStatic
    public static final void getBidToken(Context context, MolocoBidTokenListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.moloco.sdk.internal.android_context.b.a(context);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Fetching bid token", null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(com.moloco.sdk.internal.scheduling.c.f6295a.b(), null, null, new C36661(listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h getBidTokenHandler() {
        return (h) bidTokenHandler.getValue();
    }

    public static /* synthetic */ void getInitJob$annotations() {
    }

    public static /* synthetic */ void getInitParams$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final v getInitializationHandler() {
        return (v) initializationHandler.getValue();
    }

    @JvmStatic
    public static final void initialize(MolocoInitParams initParam) {
        Intrinsics.checkNotNullParameter(initParam, "initParam");
        initialize$default(initParam, null, 2, null);
    }

    public static /* synthetic */ void initialize$default(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            molocoInitializationListener = null;
        }
        initialize(molocoInitParams, molocoInitializationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeAndroidClientMetrics(MolocoInitParams initParams2) {
        String name;
        if (!getInitializationHandler().c()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "Moloco", "ACM cannot be initialized as Moloco SDK cannot be initialized", null, false, 12, null);
            return;
        }
        com.moloco.sdk.internal.configs.a aVarC = com.moloco.sdk.internal.configs.b.c();
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        String appKey = initParams2.getAppKey();
        String strD = aVarC.d();
        Context appContext = initParams2.getAppContext();
        long jC = aVarC.c();
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to(com.moloco.sdk.acm.b.e, initParams2.getAppKey());
        a.e eVar = a.e.f6462a;
        pairArr[1] = TuplesKt.to(com.moloco.sdk.acm.b.f, eVar.b().invoke().b());
        pairArr[2] = TuplesKt.to(com.moloco.sdk.acm.b.g, eVar.b().invoke().c());
        pairArr[3] = TuplesKt.to(com.moloco.sdk.acm.b.h, BuildConfig.SDK_VERSION_NAME);
        pairArr[4] = TuplesKt.to(com.moloco.sdk.acm.b.d, eVar.f().invoke().s());
        pairArr[5] = TuplesKt.to("osv", eVar.f().invoke().t());
        MediationInfo mediationInfo$moloco_sdk_release = getMediationInfo$moloco_sdk_release();
        if (mediationInfo$moloco_sdk_release == null || (name = mediationInfo$moloco_sdk_release.getName()) == null) {
            name = "";
        }
        pairArr[6] = TuplesKt.to(com.moloco.sdk.acm.b.b, name);
        AndroidClientMetrics.initialize$default(androidClientMetrics, new InitConfig(appKey, strD, appContext, jC, MapsKt.mapOf(pairArr)), null, 2, null);
    }

    public static final boolean isInitialized() {
        return INSTANCE.getInitializationHandler().d().getValue() == Initialization.SUCCESS;
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    private final void logMolocoInfo(MolocoInitParams initParam) {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, "Moloco", "=====================================", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "Moloco SDK initializing", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "SDK Version: 3.8.0", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "Mediation: " + initParam.getMediationInfo().getName(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "isInitialized: " + isInitialized(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, "Moloco", "=====================================", null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processInitConfigs(Init.SDKInitResponse sdkInitResponse) {
        if (sdkInitResponse.hasEventCollectionConfig()) {
            Init.SDKInitResponse.EventCollectionConfig eventCollectionConfig = sdkInitResponse.getEventCollectionConfig();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, "Moloco", "Init response has eventCollectionConfig", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "eventCollectionConfig:", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "eventCollectionEnabled: " + eventCollectionConfig.getEventCollectionEnabled(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "mrefCollectionEnabled: " + eventCollectionConfig.getMrefCollectionEnabled(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "appFgUrl: " + eventCollectionConfig.getAppForegroundTrackingUrl(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, "Moloco", "appBgUrl: " + eventCollectionConfig.getAppBackgroundTrackingUrl(), false, 4, null);
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c cVarB = a.k.f6490a.b();
            boolean eventCollectionEnabled = eventCollectionConfig.getEventCollectionEnabled();
            boolean mrefCollectionEnabled = eventCollectionConfig.getMrefCollectionEnabled();
            String appForegroundTrackingUrl = eventCollectionConfig.getAppForegroundTrackingUrl();
            Intrinsics.checkNotNullExpressionValue(appForegroundTrackingUrl, "appForegroundTrackingUrl");
            String appBackgroundTrackingUrl = eventCollectionConfig.getAppBackgroundTrackingUrl();
            Intrinsics.checkNotNullExpressionValue(appBackgroundTrackingUrl, "appBackgroundTrackingUrl");
            cVarB.a(eventCollectionEnabled, mrefCollectionEnabled, appForegroundTrackingUrl, appBackgroundTrackingUrl);
            if (eventCollectionConfig.getEventCollectionEnabled()) {
                a.b.f6453a.b().a();
            }
        } else {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, "Moloco", "Init response does not have eventCollectionConfig", false, 4, null);
        }
        a.c.f6458a.a().a(sdkInitResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateAndroidClientMetricsOnInitSuccess(Continuation<? super Unit> continuation) throws Throwable {
        com.moloco.sdk.internal.configs.a aVar = (com.moloco.sdk.internal.configs.a) a.c.f6458a.a().a(com.moloco.sdk.internal.configs.a.class, com.moloco.sdk.internal.configs.b.c());
        Object objUpdateConfig = AndroidClientMetrics.INSTANCE.updateConfig(new UpdateConfig(aVar.d(), Boxing.boxLong(aVar.c())), continuation);
        return objUpdateConfig == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfig : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object clearState$moloco_sdk_release(Continuation<? super Unit> continuation) throws Throwable {
        Moloco$clearState$1 moloco$clearState$1;
        Moloco moloco;
        if (continuation instanceof Moloco$clearState$1) {
            moloco$clearState$1 = (Moloco$clearState$1) continuation;
            int i = moloco$clearState$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                moloco$clearState$1.label = i - Integer.MIN_VALUE;
            } else {
                moloco$clearState$1 = new Moloco$clearState$1(this, continuation);
            }
        } else {
            moloco$clearState$1 = new Moloco$clearState$1(this, continuation);
        }
        Object obj = moloco$clearState$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = moloco$clearState$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                moloco = (Moloco) moloco$clearState$1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "Moloco", "clearState() unit testing function called", false, 4, null);
        initParams = null;
        Job job = initJob;
        if (job != null) {
            moloco$clearState$1.L$0 = this;
            moloco$clearState$1.label = 1;
            if (JobKt.cancelAndJoin(job, moloco$clearState$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        moloco = this;
        initJob = null;
        v initializationHandler2 = moloco.getInitializationHandler();
        moloco$clearState$1.L$0 = null;
        moloco$clearState$1.label = 2;
        if (initializationHandler2.b(moloco$clearState$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    public final String getAppKey$moloco_sdk_release() {
        MolocoInitParams molocoInitParams = initParams;
        if (molocoInitParams != null) {
            return molocoInitParams.getAppKey();
        }
        return null;
    }

    public final Job getInitJob() {
        return initJob;
    }

    public final MolocoInitParams getInitParams() {
        return initParams;
    }

    public final MediationInfo getMediationInfo$moloco_sdk_release() {
        MolocoInitParams molocoInitParams = initParams;
        if (molocoInitParams != null) {
            return molocoInitParams.getMediationInfo();
        }
        return null;
    }

    public final void setInitJob(Job job) {
        initJob = job;
    }

    public final void setInitParams(MolocoInitParams molocoInitParams) {
        initParams = molocoInitParams;
    }

    @JvmStatic
    public static final synchronized void initialize(MolocoInitParams initParam, MolocoInitializationListener listener) {
        Intrinsics.checkNotNullParameter(initParam, "initParam");
        INSTANCE.logMolocoInfo(initParam);
        if (isInitialized()) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Already initialized. Returning and notifying listener", null, false, 12, null);
            if (listener != null) {
                w.a(listener, v.f.a());
            }
            return;
        }
        Job job = initJob;
        if (job != null && job.isActive()) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Job active. Returning", null, false, 12, null);
        } else {
            if (initParam.getAppKey().length() == 0) {
                throw new IllegalArgumentException("Moloco SDK initialized with empty appKey");
            }
            initParams = initParam;
            com.moloco.sdk.internal.android_context.b.a(initParam.getAppContext());
            initJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo()), null, null, new C36671(initParam, listener, null), 3, null);
        }
    }
}
