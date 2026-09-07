package com.moloco.sdk.internal.services.bidtoken;

import android.util.Base64;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.i0;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements q {
    public final i0 b;
    public final o c;
    public final com.moloco.sdk.internal.services.encryption.a d;
    public final com.moloco.sdk.internal.services.bidtoken.providers.l e;
    public final String f;
    public String g;
    public String h;
    public f i;
    public final Mutex j;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ClientBidTokenServiceImpl", f = "ClientBidTokenService.kt", i = {0, 0, 0, 0}, l = {189}, m = "bidToken-0E7RQCE", n = {"this", "publicKey", "bidTokenConfig", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6342a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            Object objA = r.this.a(null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    public r(i0 timeProviderService, o clientBidTokenBuilder, com.moloco.sdk.internal.services.encryption.a encryptionService, com.moloco.sdk.internal.services.bidtoken.providers.l signalProvider) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(clientBidTokenBuilder, "clientBidTokenBuilder");
        Intrinsics.checkNotNullParameter(encryptionService, "encryptionService");
        Intrinsics.checkNotNullParameter(signalProvider, "signalProvider");
        this.b = timeProviderService;
        this.c = clientBidTokenBuilder;
        this.d = encryptionService;
        this.e = signalProvider;
        this.f = "ClientBidTokenServiceImpl";
        this.g = "";
        this.h = "";
        this.i = e.a();
        this.j = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.q
    public Object a(String str, f fVar, Continuation<? super Result<String>> continuation) throws Throwable {
        a aVar;
        Mutex mutex;
        r rVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.g = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.j;
            aVar.f6342a = this;
            aVar.b = str;
            aVar.c = fVar;
            aVar.d = mutex;
            aVar.g = 1;
            if (mutex.lock(null, aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            rVar = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) aVar.d;
            fVar = (f) aVar.c;
            String str2 = (String) aVar.b;
            rVar = (r) aVar.f6342a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            str = str2;
        }
        try {
            if (rVar.a(str, fVar)) {
                MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, rVar.f, "Bid token needs refresh, fetching new bid token", false, 4, null);
                rVar.g = str;
                rVar.i = fVar;
                AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenCached.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "false"));
                rVar.h = rVar.a(str);
            } else {
                AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenCached.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "true"));
            }
            if (rVar.h.length() == 0) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m7904constructorimpl(ResultKt.createFailure(new Exception("Client bid token is empty")));
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(rVar.h);
        } finally {
            mutex.unlock(null);
        }
    }

    public final boolean a(f fVar) {
        f fVar2 = this.i;
        this.i = fVar;
        boolean zAreEqual = Intrinsics.areEqual(fVar2, fVar);
        boolean z = !zAreEqual;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, !zAreEqual ? "config updated" : "config didn't change", false, 4, null);
        return z;
    }

    public final boolean a(String str, f fVar) {
        if (!Intrinsics.areEqual(this.g, str)) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "rp changed, needs refresh", false, 4, null);
            return true;
        }
        if (a(fVar)) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "config changed, needs refresh", false, 4, null);
            return true;
        }
        if (this.h.length() == 0) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "cached bidToken is empty, needs refresh", false, 4, null);
            return true;
        }
        if (this.e.b()) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "signal provider updated, needs refresh", false, 4, null);
            return true;
        }
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "Bid token doesn't need refresh", false, 4, null);
        return false;
    }

    public final String a(String str) {
        Exception exc;
        String str2;
        if (str.length() == 0) {
            AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenBuild.b()).withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), "empty_public_key"));
            return "";
        }
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        TimerEvent timerEventStartTimerEvent = androidClientMetrics.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.ClientBidTokenBuild.b());
        try {
            long jA = this.b.a();
            str2 = "rsa";
            try {
                byte[] bArrA = this.d.a(str);
                String str3 = "update_signal_state";
                try {
                    this.e.a();
                    str3 = "provide_signal";
                    byte[] base64clientBidTokenComponent = Base64.encode(this.c.a(this.e.d(), this.i).toByteArray(), 0);
                    try {
                        com.moloco.sdk.internal.services.encryption.a aVar = this.d;
                        Intrinsics.checkNotNullExpressionValue(base64clientBidTokenComponent, "base64clientBidTokenComponent");
                        byte[] base64BidToken = Base64.encode(aVar.a(base64clientBidTokenComponent), 0);
                        o oVar = this.c;
                        Intrinsics.checkNotNullExpressionValue(base64BidToken, "base64BidToken");
                        String strEncodeToString = Base64.encodeToString(oVar.a(base64BidToken, bArrA), 0);
                        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
                        androidClientMetrics.recordTimerEvent(timerEventStartTimerEvent.withTag(cVar.b(), "success"));
                        androidClientMetrics.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenBuild.b()).withTag(cVar.b(), "success"));
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f, "Client bid token build time: " + (this.b.a() - jA) + " ms", null, false, 12, null);
                        return "v2:" + strEncodeToString;
                    } catch (Exception e) {
                        exc = e;
                        str2 = "aes";
                        String simpleName = exc.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "e.javaClass.simpleName");
                        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                        MolocoLogger.warn$default(molocoLogger, this.f, "Client bid token build failed: " + simpleName, exc, false, 8, null);
                        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.ClientBidTokenBuild.b());
                        com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Result;
                        CountEvent countEventWithTag = countEvent.withTag(cVar2.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
                        com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
                        CountEvent countEventWithTag2 = countEventWithTag.withTag(cVar3.b(), simpleName);
                        if (str2.length() > 0) {
                            countEventWithTag2.withTag(com.moloco.sdk.internal.client_metrics_data.c.Step.b(), str2);
                        }
                        MolocoLogger.debugBuildLog$default(molocoLogger, this.f, "Recording metric failure: " + countEventWithTag2.getName() + ", tags: " + CollectionsKt.joinToString$default(countEventWithTag2.getEventTags(), StringUtils.COMMA, null, null, 0, null, null, 62, null), false, 4, null);
                        AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
                        androidClientMetrics2.recordCountEvent(countEventWithTag2);
                        androidClientMetrics2.recordTimerEvent(timerEventStartTimerEvent.withTag(cVar2.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar3.b(), simpleName));
                        return "";
                    }
                } catch (Exception e2) {
                    exc = e2;
                    str2 = str3;
                }
            } catch (Exception e3) {
                exc = e3;
            }
        } catch (Exception e4) {
            exc = e4;
            str2 = "";
        }
    }
}
