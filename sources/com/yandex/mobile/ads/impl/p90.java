package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@DebugMetadata(c = "com.monetization.ads.feed.domain.FeedItemListUseCase$feedStateStateFlow$1", f = "FeedItemListUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class p90 extends SuspendLambda implements Function3<ba0, List<? extends k90>, Continuation<? super ia0>, Object> {
    /* synthetic */ ba0 b;
    /* synthetic */ List c;

    p90(Continuation<? super p90> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ba0 ba0Var, List<? extends k90> list, Continuation<? super ia0> continuation) {
        p90 p90Var = new p90(continuation);
        p90Var.b = ba0Var;
        p90Var.c = list;
        return p90Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return new ia0(this.b, this.c);
    }
}
