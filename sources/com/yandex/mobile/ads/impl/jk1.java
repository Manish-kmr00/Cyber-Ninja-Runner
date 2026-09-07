package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@DebugMetadata(c = "com.monetization.ads.base.mediation.prefetch.PrefetchedMediationNetworksDataLoader$loadNetworksMediationData$2", f = "PrefetchedMediationNetworksDataLoader.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
final class jk1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super bk1>, Object> {
    int b;
    final /* synthetic */ nk1 c;
    final /* synthetic */ Context d;
    final /* synthetic */ zy1 e;
    final /* synthetic */ List<c01> f;
    final /* synthetic */ long g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        nk1 nk1Var = this.c;
        return new jk1(this.g, this.d, this.e, nk1Var, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super bk1> continuation) {
        return ((jk1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            nk1 nk1Var = this.c;
            Context context = this.d;
            zy1 zy1Var = this.e;
            List<c01> list = this.f;
            long j = this.g;
            this.b = 1;
            obj = nk1.a(j, context, zy1Var, nk1Var, list, this);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    jk1(long j, Context context, zy1 zy1Var, nk1 nk1Var, List list, Continuation continuation) {
        super(2, continuation);
        this.c = nk1Var;
        this.d = context;
        this.e = zy1Var;
        this.f = list;
        this.g = j;
    }
}
