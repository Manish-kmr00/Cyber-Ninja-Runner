package com.yandex.mobile.ads.impl;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes4.dex */
@DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.data.repo.DebugPanelRepositoryImpl$getAllData$2", f = "DebugPanelRepositoryImpl.kt", i = {0, 1}, l = {46, 25}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class tx extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super yw>, Object> {
    Mutex b;
    ux c;
    ux d;
    boolean e;
    int f;
    final /* synthetic */ ux g;
    final /* synthetic */ boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    tx(ux uxVar, boolean z, Continuation<? super tx> continuation) {
        super(2, continuation);
        this.g = uxVar;
        this.h = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new tx(this.g, this.h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super yw> continuation) {
        return new tx(this.g, this.h, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        ux uxVar;
        boolean z;
        Mutex mutex2;
        Throwable th;
        ux uxVar2;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.g.f;
                uxVar = this.g;
                z = this.h;
                this.b = mutex;
                this.c = uxVar;
                this.e = z;
                this.f = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    uxVar2 = this.d;
                    uxVar = this.c;
                    mutex2 = this.b;
                    try {
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        if (Result.m7910isFailureimpl(value)) {
                            value = null;
                        }
                        uxVar2.e = (ox) value;
                        yw ywVarA = uxVar.c.a(uxVar.f10432a.a(), uxVar.e);
                        mutex2.unlock(null);
                        return ywVarA;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                boolean z2 = this.e;
                ux uxVar3 = this.c;
                Mutex mutex3 = this.b;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                z = z2;
                uxVar = uxVar3;
            }
            if (uxVar.e == null || z) {
                ho1 ho1Var = uxVar.b;
                this.b = mutex;
                this.c = uxVar;
                this.d = uxVar;
                this.f = 2;
                Object objA = ho1Var.a(this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uxVar2 = uxVar;
                mutex2 = mutex;
                value = objA;
                if (Result.m7910isFailureimpl(value)) {
                    value = null;
                }
                uxVar2.e = (ox) value;
            } else {
                mutex2 = mutex;
            }
            yw ywVarA2 = uxVar.c.a(uxVar.f10432a.a(), uxVar.e);
            mutex2.unlock(null);
            return ywVarA2;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
