package com.yandex.mobile.ads.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes10.dex */
@DebugMetadata(c = "com.monetization.ads.core.initializer.SdkInitializer", f = "SdkInitializer.kt", i = {0, 0}, l = {175}, m = "detectAdBlocker", n = {"this_$iv", "phase$iv"}, s = {"L$0", "L$1"})
final class iv1 extends ContinuationImpl {
    g5 b;
    f5 c;
    /* synthetic */ Object d;
    final /* synthetic */ hv1 e;
    int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    iv1(hv1 hv1Var, Continuation<? super iv1> continuation) {
        super(continuation);
        this.e = hv1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return hv1.a(this.e, this);
    }
}
