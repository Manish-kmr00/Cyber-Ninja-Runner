package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.monetization.ads.mediation.base.model.MediatedAdObjectInfo;
import com.monetization.ads.quality.base.AdQualityVerifierAdapter;
import com.monetization.ads.quality.base.model.AdQualityVerificationError;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerificationAdConfiguration;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerifierAdType;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerifierAdapterConfiguration;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes6.dex */
public final class y6 implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdQualityVerifierAdapter f10704a;
    private final AdQualityVerifierAdapterConfiguration b;
    private final long c;
    private final n7 d;
    private final h7 e;
    private final i7 f;

    @DebugMetadata(c = "com.monetization.ads.base.quality.policy.AdQualitySdkVerifierWithPolicy", f = "AdQualitySdkVerifierWithPolicy.kt", i = {}, l = {IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT}, m = "verifyAdWithPolicy", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object b;
        int d;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return y6.a(y6.this, this);
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.quality.policy.AdQualitySdkVerifierWithPolicy", f = "AdQualitySdkVerifierWithPolicy.kt", i = {0}, l = {97}, m = "verifyAdWithTimeout", n = {"this"}, s = {"L$0"})
    static final class b extends ContinuationImpl {
        y6 b;
        /* synthetic */ Object c;
        int e;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return y6.b(y6.this, this);
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.quality.policy.AdQualitySdkVerifierWithPolicy$verifyAdWithTimeout$2", f = "AdQualitySdkVerifierWithPolicy.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdQualityVerificationResult>, Object> {
        h7 b;
        int c;
        final /* synthetic */ Context e;
        final /* synthetic */ AdQualityVerificationAdConfiguration f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, AdQualityVerificationAdConfiguration adQualityVerificationAdConfiguration, Continuation<? super c> continuation) {
            super(2, continuation);
            this.e = context;
            this.f = adQualityVerificationAdConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return y6.this.new c(this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdQualityVerificationResult> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            h7 h7Var;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h7 h7Var2 = y6.this.e;
                AdQualityVerifierAdapter adQualityVerifierAdapter = y6.this.f10704a;
                Context context = this.e;
                AdQualityVerifierAdapterConfiguration adQualityVerifierAdapterConfiguration = y6.this.b;
                AdQualityVerificationAdConfiguration adQualityVerificationAdConfiguration = this.f;
                this.b = h7Var2;
                this.c = 1;
                Object objVerifyAd = adQualityVerifierAdapter.verifyAd(context, adQualityVerifierAdapterConfiguration, adQualityVerificationAdConfiguration, this);
                if (objVerifyAd == coroutine_suspended) {
                    return coroutine_suspended;
                }
                h7Var = h7Var2;
                obj = objVerifyAd;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h7Var = this.b;
                ResultKt.throwOnFailure(obj);
            }
            return h7Var.a((AdQualityVerificationResult) obj);
        }
    }

    public /* synthetic */ y6(AdQualityVerifierAdapter adQualityVerifierAdapter, AdQualityVerifierAdapterConfiguration adQualityVerifierAdapterConfiguration, long j, n7 n7Var, h7 h7Var) {
        this(adQualityVerifierAdapter, adQualityVerifierAdapterConfiguration, j, n7Var, h7Var, new i7());
    }

    public y6(AdQualityVerifierAdapter verifierAdapter, AdQualityVerifierAdapterConfiguration verifierAdapterConfiguration, long j, n7 policyAcceptor, h7 statusHandler, i7 verifierAdConfigurationCreator) {
        Intrinsics.checkNotNullParameter(verifierAdapter, "verifierAdapter");
        Intrinsics.checkNotNullParameter(verifierAdapterConfiguration, "verifierAdapterConfiguration");
        Intrinsics.checkNotNullParameter(policyAcceptor, "policyAcceptor");
        Intrinsics.checkNotNullParameter(statusHandler, "statusHandler");
        Intrinsics.checkNotNullParameter(verifierAdConfigurationCreator, "verifierAdConfigurationCreator");
        this.f10704a = verifierAdapter;
        this.b = verifierAdapterConfiguration;
        this.c = j;
        this.d = policyAcceptor;
        this.e = statusHandler;
        this.f = verifierAdConfigurationCreator;
    }

    public static final /* synthetic */ Object a(y6 y6Var, Continuation continuation) {
        return y6Var.a(null, null, continuation);
    }

    public static final /* synthetic */ Object b(y6 y6Var, Continuation continuation) {
        return y6Var.b(null, null, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0060  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private final Object a(Context context, AdQualityVerificationAdConfiguration adQualityVerificationAdConfiguration, Continuation<? super AdQualityVerificationResult> continuation) throws Throwable {
        a aVar;
        Object objM7904constructorimpl;
        Throwable thM7907exceptionOrNullimpl;
        String message;
        Object objA;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objB = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objB);
                Result.Companion companion = Result.INSTANCE;
                objA = this.d.a(adQualityVerificationAdConfiguration);
                if (objA == null) {
                    aVar.d = 1;
                    objB = b(context, adQualityVerificationAdConfiguration, aVar);
                    if (objB == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                objM7904constructorimpl = Result.m7904constructorimpl(objA);
                thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                if (thM7907exceptionOrNullimpl != null) {
                    message = thM7907exceptionOrNullimpl.getMessage();
                    if (message == null) {
                        message = "Unknown error with empty description";
                    }
                    objM7904constructorimpl = new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.UnknownError(message));
                }
                return objM7904constructorimpl;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objB);
            objA = (AdQualityVerificationResult) objB;
            objM7904constructorimpl = Result.m7904constructorimpl(objA);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            message = thM7907exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Unknown error with empty description";
            }
            objM7904constructorimpl = new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.UnknownError(message));
        }
        return objM7904constructorimpl;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private final Object b(Context context, AdQualityVerificationAdConfiguration adQualityVerificationAdConfiguration, Continuation<? super AdQualityVerificationResult> continuation) throws Throwable {
        b bVar;
        y6 y6Var;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objWithTimeout = bVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithTimeout);
            try {
                long millis = TimeUnit.SECONDS.toMillis(this.c);
                c cVar = new c(context, adQualityVerificationAdConfiguration, null);
                bVar.b = this;
                bVar.e = 1;
                objWithTimeout = TimeoutKt.withTimeout(millis, cVar, bVar);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                y6Var = this;
            } catch (TimeoutCancellationException unused) {
                y6Var = this;
                return new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.TimeoutError(y6Var.c));
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            y6Var = bVar.b;
            try {
                ResultKt.throwOnFailure(objWithTimeout);
            } catch (TimeoutCancellationException unused2) {
                return new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.TimeoutError(y6Var.c));
            }
        }
        return (AdQualityVerificationResult) objWithTimeout;
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onAdWillDisplay() {
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f10704a.onAdWillDisplay();
            Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onAdClicked() {
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f10704a.onAdClicked();
            Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onAdClosed() {
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f10704a.onAdClosed();
            Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onInvalidated() {
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f10704a.onInvalidated();
            Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0014, B:17:0x0037, B:20:0x0044, B:21:0x0057, B:23:0x005d, B:27:0x0070, B:31:0x007c, B:33:0x0080, B:36:0x0089, B:39:0x0092, B:42:0x009b, B:45:0x00a4, B:47:0x00ab, B:12:0x002b, B:13:0x002e, B:14:0x0031, B:15:0x0034), top: B:60:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0080 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0014, B:17:0x0037, B:20:0x0044, B:21:0x0057, B:23:0x005d, B:27:0x0070, B:31:0x007c, B:33:0x0080, B:36:0x0089, B:39:0x0092, B:42:0x009b, B:45:0x00a4, B:47:0x00ab, B:12:0x002b, B:13:0x002e, B:14:0x0031, B:15:0x0034), top: B:60:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0014, B:17:0x0037, B:20:0x0044, B:21:0x0057, B:23:0x005d, B:27:0x0070, B:31:0x007c, B:33:0x0080, B:36:0x0089, B:39:0x0092, B:42:0x009b, B:45:0x00a4, B:47:0x00ab, B:12:0x002b, B:13:0x002e, B:14:0x0031, B:15:0x0034), top: B:60:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0092 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0014, B:17:0x0037, B:20:0x0044, B:21:0x0057, B:23:0x005d, B:27:0x0070, B:31:0x007c, B:33:0x0080, B:36:0x0089, B:39:0x0092, B:42:0x009b, B:45:0x00a4, B:47:0x00ab, B:12:0x002b, B:13:0x002e, B:14:0x0031, B:15:0x0034), top: B:60:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0098  */
    /* JADX WARN: Code duplicated, block: B:42:0x009b A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0014, B:17:0x0037, B:20:0x0044, B:21:0x0057, B:23:0x005d, B:27:0x0070, B:31:0x007c, B:33:0x0080, B:36:0x0089, B:39:0x0092, B:42:0x009b, B:45:0x00a4, B:47:0x00ab, B:12:0x002b, B:13:0x002e, B:14:0x0031, B:15:0x0034), top: B:60:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a4 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0014, B:17:0x0037, B:20:0x0044, B:21:0x0057, B:23:0x005d, B:27:0x0070, B:31:0x007c, B:33:0x0080, B:36:0x0089, B:39:0x0092, B:42:0x009b, B:45:0x00a4, B:47:0x00ab, B:12:0x002b, B:13:0x002e, B:14:0x0031, B:15:0x0034), top: B:60:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:62:0x006f A[SYNTHETIC] */
    @Override // com.yandex.mobile.ads.impl.p7
    public final Object a(Context context, Object adObject, o8<?> o8Var, o3 adConfiguration, MediatedAdObjectInfo mediatedAdObjectInfo, Continuation<? super AdQualityVerificationResult> continuation) {
        AdQualityVerifierAdType adQualityVerifierAdType;
        AdQualityVerifierAdType adQualityVerifierAdType2;
        String strC;
        String value;
        Iterator<z6> it;
        z6 next;
        AdQualityVerifiableNetwork adQualityVerifiableNetworkA;
        String adContent;
        String adUnitId;
        String strD;
        String adId;
        Map<String, Object> extraData;
        this.f.getClass();
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        adQualityVerificationAdConfiguration = null;
        adQualityVerificationAdConfiguration = null;
        AdQualityVerificationAdConfiguration adQualityVerificationAdConfiguration = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            int iOrdinal = adConfiguration.b().ordinal();
            if (iOrdinal == 0) {
                adQualityVerifierAdType = AdQualityVerifierAdType.BANNER;
            } else if (iOrdinal == 1) {
                adQualityVerifierAdType = AdQualityVerifierAdType.INTERSTITIAL;
            } else if (iOrdinal == 2) {
                adQualityVerifierAdType = AdQualityVerifierAdType.REWARDED;
            } else {
                if (iOrdinal != 3) {
                    adQualityVerifierAdType2 = null;
                } else {
                    adQualityVerifierAdType = AdQualityVerifierAdType.NATIVE;
                }
                strC = adConfiguration.c();
                value = adConfiguration.j();
                if (value == null) {
                    value = "yandex";
                }
                z6.c.getClass();
                Intrinsics.checkNotNullParameter(value, "value");
                it = z6.a().iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.b(), value));
                adQualityVerifiableNetworkA = z6.a.a(next);
                if (adQualityVerifierAdType2 != null && strC != null && adQualityVerifiableNetworkA != null) {
                    if (mediatedAdObjectInfo != null) {
                        adContent = mediatedAdObjectInfo.getAdContent();
                    } else {
                        adContent = null;
                    }
                    if (mediatedAdObjectInfo != null) {
                        adUnitId = mediatedAdObjectInfo.getAdUnitId();
                    } else {
                        adUnitId = null;
                    }
                    if (o8Var != null) {
                        strD = o8Var.d();
                    } else {
                        strD = null;
                    }
                    if (mediatedAdObjectInfo != null) {
                        adId = mediatedAdObjectInfo.getAdId();
                    } else {
                        adId = null;
                    }
                    if (mediatedAdObjectInfo != null) {
                        extraData = mediatedAdObjectInfo.getExtraData();
                    } else {
                        extraData = null;
                    }
                    adQualityVerificationAdConfiguration = new AdQualityVerificationAdConfiguration(adQualityVerifiableNetworkA, strC, adObject, adQualityVerifierAdType2, adContent, adUnitId, strD, adId, extraData);
                }
                if (adQualityVerificationAdConfiguration != null) {
                    return a(context, adQualityVerificationAdConfiguration, continuation);
                }
                return new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.InternalError("Failed to create ad configuration for verification"));
            }
            adQualityVerifierAdType2 = adQualityVerifierAdType;
            strC = adConfiguration.c();
            value = adConfiguration.j();
            if (value == null) {
                value = "yandex";
            }
            z6.c.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            it = z6.a().iterator();
            do {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.b(), value));
            adQualityVerifiableNetworkA = z6.a.a(next);
            if (adQualityVerifierAdType2 != null) {
                if (mediatedAdObjectInfo != null) {
                    adContent = mediatedAdObjectInfo.getAdContent();
                } else {
                    adContent = null;
                }
                if (mediatedAdObjectInfo != null) {
                    adUnitId = mediatedAdObjectInfo.getAdUnitId();
                } else {
                    adUnitId = null;
                }
                if (o8Var != null) {
                    strD = o8Var.d();
                } else {
                    strD = null;
                }
                if (mediatedAdObjectInfo != null) {
                    adId = mediatedAdObjectInfo.getAdId();
                } else {
                    adId = null;
                }
                if (mediatedAdObjectInfo != null) {
                    extraData = mediatedAdObjectInfo.getExtraData();
                } else {
                    extraData = null;
                }
                adQualityVerificationAdConfiguration = new AdQualityVerificationAdConfiguration(adQualityVerifiableNetworkA, strC, adObject, adQualityVerifierAdType2, adContent, adUnitId, strD, adId, extraData);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Object objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            adQualityVerificationAdConfiguration = (AdQualityVerificationAdConfiguration) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
        }
        if (adQualityVerificationAdConfiguration != null) {
            return a(context, adQualityVerificationAdConfiguration, continuation);
        }
        return new AdQualityVerificationResult.NotVerified(new AdQualityVerificationError.InternalError("Failed to create ad configuration for verification"));
    }
}
