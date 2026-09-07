package com.moloco.sdk.internal.services.usertracker;

import com.moloco.sdk.internal.services.w;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f6427a;

    public c(w dataStoreService) {
        Intrinsics.checkNotNullParameter(dataStoreService, "dataStoreService");
        this.f6427a = dataStoreService;
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    public Object a(String str, Continuation<? super Unit> continuation) {
        Object objA = this.f6427a.a(d.f6428a, str, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    public Object b(Continuation<? super String> continuation) {
        return this.f6427a.d(d.f6428a, continuation);
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    public Object a(Continuation<? super Unit> continuation) {
        Object objA = this.f6427a.a(d.f6428a, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
