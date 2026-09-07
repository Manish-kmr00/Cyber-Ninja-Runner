package com.yandex.mobile.ads.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.videowrapper.NativeWrapperVideoLoader", f = "NativeWrapperVideoLoader.kt", i = {0}, l = {54}, m = "loadWrapperVideoAdsInfo", n = {"this"}, s = {"L$0"})
final class jc1 extends ContinuationImpl {
    lc1 b;
    /* synthetic */ Object c;
    final /* synthetic */ lc1 d;
    int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    jc1(lc1 lc1Var, Continuation<? super jc1> continuation) {
        super(continuation);
        this.d = lc1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return lc1.a(this.d, null, this);
    }
}
