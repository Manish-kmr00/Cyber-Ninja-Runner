package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes11.dex */
@DebugMetadata(c = "com.monetization.ads.base.mediation.prefetch.PrefetchedMediationNetworksDataLoader$loadNetworksMediationDataInternal$asyncAdaptersResults$1", f = "PrefetchedMediationNetworksDataLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class lk1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Deferred<? extends dk1>>>, Object> {
    private /* synthetic */ Object b;
    final /* synthetic */ List<c01> c;
    final /* synthetic */ nk1 d;
    final /* synthetic */ Context e;
    final /* synthetic */ zy1 f;
    final /* synthetic */ long g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        List<c01> list = this.c;
        nk1 nk1Var = this.d;
        lk1 lk1Var = new lk1(this.g, this.e, this.f, nk1Var, list, continuation);
        lk1Var.b = obj;
        return lk1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Deferred<? extends dk1>>> continuation) {
        return ((lk1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.b;
        List<c01> list = this.c;
        nk1 nk1Var = this.d;
        Context context = this.e;
        zy1 zy1Var = this.f;
        long j = this.g;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (c01 c01Var : list) {
            nk1Var.getClass();
            ArrayList arrayList2 = arrayList;
            arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ik1(nk1Var, c01Var, context, j, zy1Var, null), 3, null));
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    lk1(long j, Context context, zy1 zy1Var, nk1 nk1Var, List list, Continuation continuation) {
        super(2, continuation);
        this.c = list;
        this.d = nk1Var;
        this.e = context;
        this.f = zy1Var;
        this.g = j;
    }
}
