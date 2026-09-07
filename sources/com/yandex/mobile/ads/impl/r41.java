package com.yandex.mobile.ads.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes11.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.videowrapper.NativeAdBlockVideoWrapperLoader", f = "NativeAdBlockVideoWrapperLoader.kt", i = {0}, l = {56}, m = "loadVideoWrapperAsset", n = {"castedAsset"}, s = {"L$0"})
final class r41 extends ContinuationImpl {
    ig b;
    /* synthetic */ Object c;
    final /* synthetic */ s41 d;
    int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r41(s41 s41Var, Continuation<? super r41> continuation) {
        super(continuation);
        this.d = s41Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return s41.a(this.d, (ig) null, this);
    }
}
