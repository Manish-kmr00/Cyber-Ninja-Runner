package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class jf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9313a;

    @DebugMetadata(c = "com.monetization.ads.base.mediation.bidding.HeaderBiddingDataLoader", f = "HeaderBiddingDataLoader.kt", i = {}, l = {18}, m = "loadHeaderBiddingData", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object b;
        int d;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return jf0.this.a(null, null, this);
        }
    }

    public jf0(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f9313a = adConfiguration;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, el elVar, Continuation<? super String> continuation) {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            o3 o3Var = this.f9313a;
            tj tjVar = new tj();
            da daVar = new da(elVar);
            cy0 cy0Var = new cy0(o3Var, null);
            f50 f50Var = new f50(o3Var, elVar, tjVar, daVar, cy0Var, new hd1(cy0Var));
            aVar.d = 1;
            objA = f50Var.a(context, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        return (String) objA;
    }
}
