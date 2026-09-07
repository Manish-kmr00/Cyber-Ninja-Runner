package com.yandex.mobile.ads.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes13.dex */
@DebugMetadata(c = "com.monetization.ads.base.mediation.prefetch.PrefetchedMediationNetworksDataLoader", f = "PrefetchedMediationNetworksDataLoader.kt", i = {}, l = {53, 57}, m = "loadNetworksMediationDataInternal", n = {}, s = {})
final class kk1 extends ContinuationImpl {
    /* synthetic */ Object b;
    final /* synthetic */ nk1 c;
    int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    kk1(nk1 nk1Var, Continuation<? super kk1> continuation) {
        super(continuation);
        this.c = nk1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return nk1.a(0L, null, null, this.c, null, this);
    }
}
