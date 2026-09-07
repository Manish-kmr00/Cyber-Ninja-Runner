package com.moloco.sdk.internal.services.bidtoken;

import com.facebook.login.LoginLogger;
import com.json.hm;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f6323a;
    public final q b;
    public final String c;
    public final Mutex d;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenServiceImpl", f = "BidTokenService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 54, 61}, m = "bidToken", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "bidTokenTimer", "this", "$this$withLock_u24default$iv", "bidTokenTimer", "serverBidToken"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6324a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return m.this.a(this);
        }
    }

    public m(y serverBidTokenService, q clientBidTokenService) {
        Intrinsics.checkNotNullParameter(serverBidTokenService, "serverBidTokenService");
        Intrinsics.checkNotNullParameter(clientBidTokenService, "clientBidTokenService");
        this.f6323a = serverBidTokenService;
        this.b = clientBidTokenService;
        this.c = "BidTokenServiceImpl";
        this.d = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ba A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #1 {all -> 0x0068, blocks: (B:21:0x0064, B:34:0x00ae, B:36:0x00ba), top: B:61:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00de  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e7 A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:14:0x0042, B:40:0x00d8, B:43:0x00df, B:45:0x00e7, B:51:0x0117, B:46:0x00f9), top: B:63:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #2 {all -> 0x004d, blocks: (B:14:0x0042, B:40:0x00d8, B:43:0x00df, B:45:0x00e7, B:51:0x0117, B:46:0x00f9), top: B:63:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0114  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.bidtoken.l
    public Object a(Continuation<? super String> continuation) throws Throwable {
        a aVar;
        Mutex mutex;
        m mVar;
        Mutex mutex2;
        TimerEvent timerEvent;
        k kVar;
        String strD;
        String str;
        Mutex mutex3;
        Object objA;
        m mVar2;
        String str2;
        String str3;
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
        String str4 = "";
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex4 = this.d;
                aVar.f6324a = this;
                aVar.b = mutex4;
                aVar.g = 1;
                if (mutex4.lock(null, aVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex4;
                mVar = this;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str2 = (String) aVar.d;
                        timerEvent = (TimerEvent) aVar.c;
                        mutex3 = (Mutex) aVar.b;
                        mVar2 = (m) aVar.f6324a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            objA = ((Result) obj).getValue();
                            if (Result.m7910isFailureimpl(objA)) {
                                objA = "";
                            }
                            str3 = (String) objA;
                            if (str3.length() == 0) {
                                MolocoLogger.error$default(MolocoLogger.INSTANCE, mVar2.c, "CBT has error", null, false, 12, null);
                                str = "client";
                            } else {
                                str4 = str2 + AbstractJsonLexerKt.COLON + str3;
                                str = null;
                            }
                            mVar = mVar2;
                            mVar.a(timerEvent, str);
                            mutex3.unlock(null);
                            return str4;
                        } catch (Throwable th) {
                            th = th;
                            mutex2 = mutex3;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    timerEvent = (TimerEvent) aVar.c;
                    mutex2 = (Mutex) aVar.b;
                    mVar = (m) aVar.f6324a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        kVar = (k) obj;
                        strD = kVar.d();
                        if (strD.length() > 0) {
                            String strF = kVar.f();
                            f fVarE = kVar.e();
                            q qVar = mVar.b;
                            aVar.f6324a = mVar;
                            aVar.b = mutex2;
                            aVar.c = timerEvent;
                            aVar.d = strD;
                            aVar.g = 3;
                            objA = qVar.a(strF, fVarE, aVar);
                            if (objA == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mutex3 = mutex2;
                            mVar2 = mVar;
                            str2 = strD;
                            if (Result.m7910isFailureimpl(objA)) {
                                objA = "";
                            }
                            str3 = (String) objA;
                            if (str3.length() == 0) {
                                MolocoLogger.error$default(MolocoLogger.INSTANCE, mVar2.c, "CBT has error", null, false, 12, null);
                                str = "client";
                            } else {
                                str4 = str2 + AbstractJsonLexerKt.COLON + str3;
                                str = null;
                            }
                            mVar = mVar2;
                        } else {
                            str = hm.f3752a;
                            mutex3 = mutex2;
                        }
                        mVar.a(timerEvent, str);
                        mutex3.unlock(null);
                        return str4;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                mutex = (Mutex) aVar.b;
                mVar = (m) aVar.f6324a;
                ResultKt.throwOnFailure(obj);
            }
            TimerEvent timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.BidTokenFetch.b());
            y yVar = mVar.f6323a;
            aVar.f6324a = mVar;
            aVar.b = mutex;
            aVar.c = timerEventStartTimerEvent;
            aVar.g = 2;
            Object objA2 = yVar.a(aVar);
            if (objA2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Mutex mutex5 = mutex;
            timerEvent = timerEventStartTimerEvent;
            obj = objA2;
            mutex2 = mutex5;
            kVar = (k) obj;
            strD = kVar.d();
            if (strD.length() > 0) {
                String strF2 = kVar.f();
                f fVarE2 = kVar.e();
                q qVar2 = mVar.b;
                aVar.f6324a = mVar;
                aVar.b = mutex2;
                aVar.c = timerEvent;
                aVar.d = strD;
                aVar.g = 3;
                objA = qVar2.a(strF2, fVarE2, aVar);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex3 = mutex2;
                mVar2 = mVar;
                str2 = strD;
                if (Result.m7910isFailureimpl(objA)) {
                    objA = "";
                }
                str3 = (String) objA;
                if (str3.length() == 0) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, mVar2.c, "CBT has error", null, false, 12, null);
                    str = "client";
                } else {
                    str4 = str2 + AbstractJsonLexerKt.COLON + str3;
                    str = null;
                }
                mVar = mVar2;
            } else {
                str = hm.f3752a;
                mutex3 = mutex2;
            }
            mVar.a(timerEvent, str);
            mutex3.unlock(null);
            return str4;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    public final void a(TimerEvent timerEvent, String str) {
        if (str != null) {
            AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenFetch.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.Result;
            CountEvent countEventWithTag = countEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            androidClientMetrics.recordCountEvent(countEventWithTag.withTag(cVar2.b(), str));
            androidClientMetrics.recordTimerEvent(timerEvent.withTag(cVar.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(cVar2.b(), str));
            return;
        }
        AndroidClientMetrics androidClientMetrics2 = AndroidClientMetrics.INSTANCE;
        CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.BidTokenFetch.b());
        com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.Result;
        androidClientMetrics2.recordCountEvent(countEvent2.withTag(cVar3.b(), "success"));
        androidClientMetrics2.recordTimerEvent(timerEvent.withTag(cVar3.b(), "success"));
    }
}
