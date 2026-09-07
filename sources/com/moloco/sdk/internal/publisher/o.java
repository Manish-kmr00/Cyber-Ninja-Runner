package com.moloco.sdk.internal.publisher;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o {
    public static final a c = new a(null);
    public static final String d = "BidLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.a f6266a;
    public final p b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0, 0}, l = {33, 46}, m = "parse", n = {"this", "adUnitId"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6267a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return o.this.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0}, l = {71}, m = "parseBidResponse", n = {"adUnitId"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6268a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o.this.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0}, l = {TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER}, m = "processBidResponse$moloco_sdk_release", n = {"bidResponseJson"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6269a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o.this.a(null, this);
        }
    }

    public o(com.moloco.sdk.internal.ortb.a bidResponseParser, p bidProcessor) {
        Intrinsics.checkNotNullParameter(bidResponseParser, "bidResponseParser");
        Intrinsics.checkNotNullParameter(bidProcessor, "bidProcessor");
        this.f6266a = bidResponseParser;
        this.b = bidProcessor;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.s>> continuation) throws Throwable {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.d = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            com.moloco.sdk.internal.ortb.a aVar = this.f6266a;
            cVar.f6268a = str2;
            cVar.d = 1;
            objA = aVar.a(str, cVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) cVar.f6268a;
            ResultKt.throwOnFailure(objA);
        }
        com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) objA;
        if (vVar instanceof com.moloco.sdk.internal.v.a) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, d, "parseBidResponse failed to parse BID json string.", (Throwable) ((com.moloco.sdk.internal.v.a) vVar).a(), false, 8, null);
            return new com.moloco.sdk.internal.v.a(com.moloco.sdk.internal.t.a(str2, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE));
        }
        if (vVar instanceof com.moloco.sdk.internal.v.b) {
            return new com.moloco.sdk.internal.v.b(((com.moloco.sdk.internal.ortb.model.e) ((com.moloco.sdk.internal.v.b) vVar).a()).b().get(0).b().get(0));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.s>> continuation) throws Throwable {
        b bVar;
        o oVar;
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
        Object objA = bVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        if (i2 != 0) {
            if (i2 == 1) {
                str = (String) bVar.b;
                oVar = (o) bVar.f6267a;
                ResultKt.throwOnFailure(objA);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
        }
        ResultKt.throwOnFailure(objA);
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, d, "parse() called with bidResponseJson: " + str2, false, 4, null);
        bVar.f6267a = this;
        bVar.b = str;
        bVar.e = 1;
        objA = a(str2, bVar);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        oVar = this;
        String str3 = (String) objA;
        if (str3 == null) {
            return new com.moloco.sdk.internal.v.a(com.moloco.sdk.internal.t.a(str, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.BID_LOAD_ERROR_CANNOT_PROCESS_BID_RESPONSE));
        }
        MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Processed the bidResponse, proceeding with parsing it.", null, false, 12, null);
        bVar.f6267a = null;
        bVar.b = null;
        bVar.e = 2;
        objA = oVar.b(str3, str, bVar);
        return objA == coroutine_suspended ? coroutine_suspended : objA;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, Continuation<? super String> continuation) throws Throwable {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object objA = dVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            p pVar = this.b;
            dVar.f6269a = str;
            dVar.d = 1;
            objA = pVar.a(str, dVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) dVar.f6269a;
            ResultKt.throwOnFailure(objA);
        }
        String str2 = (String) objA;
        if (str2 == null) {
            return str;
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, d, "Found no pre-preprocessor for the current mediation. Returning the original bid response.", null, false, 12, null);
        return str2;
    }
}
