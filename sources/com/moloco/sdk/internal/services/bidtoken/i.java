package com.moloco.sdk.internal.services.bidtoken;

import com.facebook.login.LoginLogger;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.i0;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoBidTokenListener;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6319a;
    public final com.moloco.sdk.internal.publisher.v b;
    public final i0 c;
    public final AndroidClientMetrics d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenHandlerImpl", f = "BidTokenHandler.kt", i = {0, 0, 0}, l = {TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER}, m = "handleBidTokenRequest", n = {"this", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "bidTokenLoadStart"}, s = {"L$0", "L$1", "J$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6320a;
        public Object b;
        public long c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return i.this.a(null, this);
        }
    }

    public i(l bidTokenService, com.moloco.sdk.internal.publisher.v initializationHandler, i0 timeProviderService, AndroidClientMetrics acm) {
        Intrinsics.checkNotNullParameter(bidTokenService, "bidTokenService");
        Intrinsics.checkNotNullParameter(initializationHandler, "initializationHandler");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(acm, "acm");
        this.f6319a = bidTokenService;
        this.b = initializationHandler;
        this.c = timeProviderService;
        this.d = acm;
        this.e = "BidTokenHandlerImpl";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.moloco.sdk.internal.services.bidtoken.h
    public Object a(MolocoBidTokenListener molocoBidTokenListener, Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        i iVar;
        long j;
        MolocoAdError.ErrorType errorType;
        MolocoBidTokenListener molocoBidTokenListener2 = molocoBidTokenListener;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            this.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenGetRequest.b()));
            if (!this.b.c()) {
                MolocoAdError.ErrorType errorType2 = MolocoAdError.ErrorType.SDK_PERSISTENT_HTTP_REQUEST_FAILED_TO_INIT;
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, "Bid token cannot be fetched because SDK initialization cannot happen due to WM issue", null, false, 12, null);
                this.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenGetResponse.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), "sdk_cannot_initialize"));
                molocoBidTokenListener2.onBidTokenResult("", errorType2);
                return Unit.INSTANCE;
            }
            if (this.b.d().getValue() == Initialization.FAILURE) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, "Bid token cannot be fetched because SDK initialization has failed", null, false, 12, null);
                this.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenGetResponse.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), "sdk_init_failed"));
                molocoBidTokenListener2.onBidTokenResult("", MolocoAdError.ErrorType.SDK_INIT_ERROR);
                return Unit.INSTANCE;
            }
            long jA = this.c.a();
            l lVar = this.f6319a;
            aVar.f6320a = this;
            aVar.b = molocoBidTokenListener2;
            aVar.c = jA;
            aVar.f = 1;
            objA = lVar.a(aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            iVar = this;
            j = jA;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = aVar.c;
            molocoBidTokenListener2 = (MolocoBidTokenListener) aVar.b;
            iVar = (i) aVar.f6320a;
            ResultKt.throwOnFailure(objA);
        }
        String str = (String) objA;
        long jA2 = iVar.c.a() - j;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, iVar.e, "Bid token fetched in " + jA2 + " ms", null, false, 12, null);
        if (str.length() == 0) {
            AndroidClientMetrics androidClientMetrics = iVar.d;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenGetResponse.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
            CountEvent countEventWithTag = countEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            androidClientMetrics.recordCountEvent(countEventWithTag.withTag(cVar2.b(), "bid_token_fetch_failed"));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (jA2 >= timeUnit.toMillis(1L)) {
                iVar.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenDurationTimeoutOneSecond.b()).withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar2.b(), "bid_token_fetch_failed"));
            }
            if (jA2 >= timeUnit.toMillis(3L)) {
                iVar.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenDurationTimeoutThreeSecond.b()).withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar2.b(), "bid_token_fetch_failed"));
            }
            errorType = MolocoAdError.ErrorType.AD_SIGNAL_COLLECTION_FAILED;
        } else {
            AndroidClientMetrics androidClientMetrics2 = iVar.d;
            CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenGetResponse.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Result;
            androidClientMetrics2.recordCountEvent(countEvent2.withTag(cVar3.b(), "success"));
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            if (jA2 >= timeUnit2.toMillis(1L)) {
                iVar.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenDurationTimeoutOneSecond.b()).withTag(cVar3.b(), "success"));
            }
            if (jA2 >= timeUnit2.toMillis(3L)) {
                iVar.d.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenDurationTimeoutThreeSecond.b()).withTag(cVar3.b(), "success"));
            }
            errorType = null;
        }
        MolocoLogger.info$default(molocoLogger, iVar.e, "Returning bid token result, hasError: " + (errorType != null) + ", SDK init complete: " + Moloco.isInitialized(), null, false, 12, null);
        molocoBidTokenListener2.onBidTokenResult(str, errorType);
        return Unit.INSTANCE;
    }
}
