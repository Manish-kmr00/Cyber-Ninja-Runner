package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes10.dex */
public final class io1 implements ho1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9250a;
    private final aq1<ox> b;
    private final gy c;
    private final ll0 d;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.data.remote.RemoteDataSourceImpl", f = "RemoteDataSourceImpl.kt", i = {0}, l = {47}, m = "getRemoteData-IoAF18A", n = {"this"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object b;
        int d;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            Object objA = io1.this.a(this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    static final class b extends Lambda implements Function1<ox, Unit> {
        final /* synthetic */ CancellableContinuation<Result<ox>> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CancellableContinuationImpl cancellableContinuationImpl) {
            super(1);
            this.b = cancellableContinuationImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ox oxVar) {
            ox response = oxVar;
            Intrinsics.checkNotNullParameter(response, "response");
            CancellableContinuation<Result<ox>> cancellableContinuation = this.b;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(Result.m7903boximpl(Result.m7904constructorimpl(response))));
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1<ki2, Unit> {
        final /* synthetic */ CancellableContinuation<Result<ox>> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CancellableContinuationImpl cancellableContinuationImpl) {
            super(1);
            this.b = cancellableContinuationImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ki2 ki2Var) throws ki2 {
            ki2 error = ki2Var;
            Intrinsics.checkNotNullParameter(error, "error");
            if (!(error.getCause() instanceof SerializationException)) {
                CancellableContinuation<Result<ox>> cancellableContinuation = this.b;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7904constructorimpl(Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(error)))));
                return Unit.INSTANCE;
            }
            throw error;
        }
    }

    public io1(Context context, aq1<ox> requestPolicy, gy urlConfigurator, ll0 responseListenerCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(urlConfigurator, "urlConfigurator");
        Intrinsics.checkNotNullParameter(responseListenerCreator, "responseListenerCreator");
        this.f9250a = context;
        this.b = requestPolicy;
        this.c = urlConfigurator;
        this.d = responseListenerCreator;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.yandex.mobile.ads.impl.ho1
    public final Object a(Continuation<? super Result<ox>> continuation) throws Throwable {
        a aVar;
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
        Object result = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(result);
            aVar.getClass();
            aVar.d = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(aVar), 1);
            cancellableContinuationImpl.initCancellability();
            ll0 ll0Var = this.d;
            b onSuccess = new b(cancellableContinuationImpl);
            c onError = new c(cancellableContinuationImpl);
            ll0Var.getClass();
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            yo0 request = new yo0(this.f9250a, this.c.a(), this.b, MapsKt.emptyMap(), new kl0(onSuccess, onError));
            int i3 = zp1.c;
            zp1 zp1VarA = zp1.a.a();
            Context context = this.f9250a;
            synchronized (zp1VarA) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(request, "request");
                dd1.a(context).a(request);
            }
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(aVar);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((Result) result).getValue();
    }
}
