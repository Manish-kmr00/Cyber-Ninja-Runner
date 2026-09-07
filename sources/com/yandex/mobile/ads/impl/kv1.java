package com.yandex.mobile.ads.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes13.dex */
@DebugMetadata(c = "com.monetization.ads.core.initializer.SdkInitializer", f = "SdkInitializer.kt", i = {0, 0, 0}, l = {189}, m = "requestAdvertisingInfo", n = {"this", "this_$iv", "phase$iv"}, s = {"L$0", "L$1", "L$2"})
final class kv1 extends ContinuationImpl {
    hv1 b;
    g5 c;
    f5 d;
    /* synthetic */ Object e;
    final /* synthetic */ hv1 f;
    int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    kv1(hv1 hv1Var, Continuation<? super kv1> continuation) {
        super(continuation);
        this.f = hv1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return hv1.b(this.f, this);
    }
}
