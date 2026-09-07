package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: InitializeStateLoadCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache", f = "InitializeStateLoadCache.kt", i = {}, l = {32}, m = "doWork-gIAlu-s", n = {}, s = {})
final class InitializeStateLoadCache$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$1(InitializeStateLoadCache initializeStateLoadCache, Continuation<? super InitializeStateLoadCache$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateLoadCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5939doWorkgIAlus = this.this$0.m5939doWorkgIAlus((InitializeStateLoadCache.Params) null, (Continuation<? super Result<InitializeStateLoadCache.LoadCacheResult>>) this);
        return objM5939doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5939doWorkgIAlus : Result.m7903boximpl(objM5939doWorkgIAlus);
    }
}
