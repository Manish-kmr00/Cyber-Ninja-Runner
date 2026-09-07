package com.yandex.mobile.ads.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes11.dex */
@DebugMetadata(c = "com.monetization.ads.feed.domain.FeedItemListUseCase", f = "FeedItemListUseCase.kt", i = {0}, l = {54}, m = "loadMore", n = {"this"}, s = {"L$0"})
final class r90 extends ContinuationImpl {
    q90 b;
    /* synthetic */ Object c;
    final /* synthetic */ q90 d;
    int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r90(q90 q90Var, Continuation<? super r90> continuation) {
        super(continuation);
        this.d = q90Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return q90.a(this.d, this);
    }
}
