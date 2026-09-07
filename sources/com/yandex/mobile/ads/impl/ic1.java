package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes9.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.videowrapper.NativeWrapperVideoLoader$loadWrapperInVideo$2", f = "NativeWrapperVideoLoader.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
final class ic1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super db2>, Object> {
    db2 b;
    int c;
    final /* synthetic */ db2 d;
    final /* synthetic */ lc1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ic1(db2 db2Var, lc1 lc1Var, Continuation<? super ic1> continuation) {
        super(2, continuation);
        this.d = db2Var;
        this.e = lc1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ic1(this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super db2> continuation) {
        return new ic1(this.d, this.e, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        db2 db2Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            db2 db2Var2 = this.d;
            if (db2Var2 == null) {
                return null;
            }
            lc1 lc1Var = this.e;
            List<rb2<gb1>> listC = db2Var2.c();
            this.b = db2Var2;
            this.c = 1;
            lc1Var.getClass();
            Object objWithContext = BuildersKt.withContext(nu.a(), new kc1(lc1Var, listC, null), this);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            db2Var = db2Var2;
            obj = objWithContext;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            db2Var = this.b;
            ResultKt.throwOnFailure(obj);
        }
        return db2.a(db2Var, (List) obj);
    }
}
