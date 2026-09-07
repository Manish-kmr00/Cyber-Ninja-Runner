package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ie0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sx f9206a;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.domain.GetAdUnitsDataUseCase", f = "GetAdUnitsDataUseCase.kt", i = {}, l = {12}, m = "invoke", n = {}, s = {})
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
            return ie0.this.a(false, this);
        }
    }

    public ie0(sx repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.f9206a = repo;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(boolean z, Continuation<? super mw> continuation) throws Throwable {
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
            sx sxVar = this.f9206a;
            aVar.d = 1;
            objA = sxVar.a(z, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        List<ew> listA = ((yw) objA).a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        for (ew ewVar : listA) {
            arrayList.add(new gw(ewVar.d(), ewVar.b(), ewVar.a()));
        }
        return new mw(arrayList);
    }
}
