package com.moloco.sdk.acm.eventprocessing;

import io.ktor.http.HeadersBuilder;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.http.e f6029a;
    public final com.moloco.sdk.acm.db.d b;
    public final f c;
    public final Function1<HeadersBuilder, Unit> d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestAndPurgeDBImpl", f = "RequestAndPurgeDB.kt", i = {0, 1}, l = {38, 48}, m = "invoke-IoAF18A", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6030a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            Object objA = k.this.a(this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(com.moloco.sdk.acm.http.e metricsRequest, com.moloco.sdk.acm.db.d metricsDAO, f dataAgeChecker, Function1<? super HeadersBuilder, Unit> headers) {
        Intrinsics.checkNotNullParameter(metricsRequest, "metricsRequest");
        Intrinsics.checkNotNullParameter(metricsDAO, "metricsDAO");
        Intrinsics.checkNotNullParameter(dataAgeChecker, "dataAgeChecker");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f6029a = metricsRequest;
        this.b = metricsDAO;
        this.c = dataAgeChecker;
        this.d = headers;
        this.e = "RequestAndPurgeDB";
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.j
    public Object a(Continuation<? super Result<String>> continuation) throws Throwable {
        a aVar;
        k kVar;
        Object objA;
        k kVar2;
        Throwable thM7907exceptionOrNullimpl;
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
        Object objA2 = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        if (i2 != 0) {
            if (i2 == 1) {
                kVar = (k) aVar.f6030a;
                ResultKt.throwOnFailure(objA2);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVar2 = (k) aVar.f6030a;
                ResultKt.throwOnFailure(objA2);
                objA = ((Result) objA2).getValue();
            }
            if (Result.m7911isSuccessimpl(objA)) {
                com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, kVar2.e, "Request Success", false, 4, null);
            }
            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
            if (thM7907exceptionOrNullimpl != null) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, kVar2.e, "Request failure: " + thM7907exceptionOrNullimpl.getMessage(), null, false, 12, null);
            }
            return objA;
        }
        ResultKt.throwOnFailure(objA2);
        com.moloco.sdk.acm.db.d dVar = this.b;
        aVar.f6030a = this;
        aVar.d = 1;
        objA2 = dVar.a(aVar);
        if (objA2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        kVar = this;
        List<com.moloco.sdk.acm.db.b> list = (List) objA2;
        com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, kVar.e, list.size() + " events processed.", false, 4, null);
        com.moloco.sdk.acm.http.d dVarA = new b(kVar.c).a(list);
        if (dVarA.a().isEmpty() && dVarA.b().isEmpty()) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl("No metrics to process");
        }
        com.moloco.sdk.acm.http.e eVar = kVar.f6029a;
        Function1<HeadersBuilder, Unit> function1 = kVar.d;
        aVar.f6030a = kVar;
        aVar.d = 2;
        objA = eVar.a(dVarA, function1, aVar);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        kVar2 = kVar;
        if (Result.m7911isSuccessimpl(objA)) {
            com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, kVar2.e, "Request Success", false, 4, null);
        }
        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
        if (thM7907exceptionOrNullimpl != null) {
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, kVar2.e, "Request failure: " + thM7907exceptionOrNullimpl.getMessage(), null, false, 12, null);
        }
        return objA;
    }
}
