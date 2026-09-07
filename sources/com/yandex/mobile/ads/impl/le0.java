package com.yandex.mobile.ads.impl;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class le0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sx f9504a;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.domain.GetMediationNetworkDataUseCase", f = "GetMediationNetworkDataUseCase.kt", i = {0}, l = {12}, m = "invoke", n = {"network"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        String b;
        /* synthetic */ Object c;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return le0.this.a(null, false, this);
        }
    }

    public le0(sx repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.f9504a = repo;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, boolean z, Continuation<? super ow> continuation) throws Throwable {
        a aVar;
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
            sx sxVar = this.f9504a;
            aVar.b = str;
            aVar.e = 1;
            objA = sxVar.a(z, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = aVar.b;
            ResultKt.throwOnFailure(objA);
        }
        for (Object obj : ((yw) objA).b().a()) {
            if (Intrinsics.areEqual(((ow) obj).e(), str)) {
                return obj;
            }
        }
        return null;
    }
}
