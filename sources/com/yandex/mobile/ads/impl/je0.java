package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class je0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sx f9309a;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.domain.GetDebugPanelFeedDataUseCase", f = "GetDebugPanelFeedDataUseCase.kt", i = {0}, l = {15}, m = "invoke", n = {"this"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        je0 b;
        /* synthetic */ Object c;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return je0.this.a(false, this);
        }
    }

    public je0(sx repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.f9309a = repo;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(boolean z, Continuation<? super fx> continuation) throws Throwable {
        a aVar;
        je0 je0Var;
        xx.a aVar2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            sx sxVar = this.f9309a;
            aVar.b = this;
            aVar.e = 1;
            objA = sxVar.a(z, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            je0Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            je0Var = aVar.b;
            ResultKt.throwOnFailure(objA);
        }
        yw ywVar = (yw) objA;
        List<sw> listC = ywVar.c();
        uw uwVarD = ywVar.d();
        vx vxVarH = ywVar.h();
        je0Var.getClass();
        if (vxVarH.d()) {
            aVar2 = vxVarH.b().isEmpty() ? xx.a.b : xx.a.c;
        } else {
            aVar2 = xx.a.d;
        }
        return new fx(listC, uwVarD, new wx(vxVarH.c(), new xx(aVar2, vxVarH.b())), ywVar.g(), ywVar.b(), ywVar.e(), ywVar.f());
    }
}
