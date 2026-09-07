package com.yandex.mobile.ads.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeAdCreationManager$NativeAdCreationRunnable$ResourcesLoaderListener$onLoaded$1", f = "NativeAdCreationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class d51 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e51 b;
    final /* synthetic */ o41 c;
    final /* synthetic */ pj0 d;
    final /* synthetic */ e51.a e;
    final /* synthetic */ e51.a.C0743a f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d51(e51 e51Var, o41 o41Var, pj0 pj0Var, e51.a aVar, e51.a.C0743a c0743a, Continuation<? super d51> continuation) {
        super(2, continuation);
        this.b = e51Var;
        this.c = o41Var;
        this.d = pj0Var;
        this.e = aVar;
        this.f = c0743a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d51(this.b, this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((d51) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.b.e.a(this.b.d, this.c, this.d, this.e.d, this.f.f8763a);
        return Unit.INSTANCE;
    }
}
