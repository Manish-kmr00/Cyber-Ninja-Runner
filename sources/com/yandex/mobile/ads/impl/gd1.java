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
import org.json.JSONArray;

/* JADX INFO: loaded from: classes13.dex */
@DebugMetadata(c = "com.monetization.ads.base.mediation.bidding.NetworksHeaderBiddingDataLoader$loadNetworksBiddingData$2", f = "NetworksHeaderBiddingDataLoader.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
final class gd1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONArray>, Object> {
    int b;
    final /* synthetic */ hd1 c;
    final /* synthetic */ Context d;
    final /* synthetic */ zy1 e;
    final /* synthetic */ List<hz0> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    gd1(hd1 hd1Var, Context context, zy1 zy1Var, List<hz0> list, Continuation<? super gd1> continuation) {
        super(2, continuation);
        this.c = hd1Var;
        this.d = context;
        this.e = zy1Var;
        this.f = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new gd1(this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JSONArray> continuation) {
        return ((gd1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            hd1 hd1Var = this.c;
            Context context = this.d;
            zy1 zy1Var = this.e;
            List<hz0> list = this.f;
            this.b = 1;
            obj = hd1Var.a(context, zy1Var, (List<hz0>) list, (Continuation<? super JSONArray>) this);
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
