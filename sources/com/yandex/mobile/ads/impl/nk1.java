package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes4.dex */
public final class nk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yx0<com.monetization.ads.mediation.base.a> f9737a;
    private final fk1 b;
    private final gk1 c;

    public /* synthetic */ nk1(cy0 cy0Var) {
        this(cy0Var, new yx0(cy0Var), new fk1(), new gk1());
    }

    public nk1(cy0 mediatedAdapterReporter, yx0<com.monetization.ads.mediation.base.a> mediatedAdapterCreator, fk1 prefetchedMediationNetworkDataLoader, gk1 prefetchedMediationNetworkMapper) {
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediatedAdapterCreator, "mediatedAdapterCreator");
        Intrinsics.checkNotNullParameter(prefetchedMediationNetworkDataLoader, "prefetchedMediationNetworkDataLoader");
        Intrinsics.checkNotNullParameter(prefetchedMediationNetworkMapper, "prefetchedMediationNetworkMapper");
        this.f9737a = mediatedAdapterCreator;
        this.b = prefetchedMediationNetworkDataLoader;
        this.c = prefetchedMediationNetworkMapper;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public static final Object a(long j, Context context, zy1 zy1Var, nk1 nk1Var, List list, Continuation continuation) throws Throwable {
        kk1 kk1Var;
        nk1Var.getClass();
        if (continuation instanceof kk1) {
            kk1Var = (kk1) continuation;
            int i = kk1Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                kk1Var.d = i - Integer.MIN_VALUE;
            } else {
                kk1Var = new kk1(nk1Var, continuation);
            }
        } else {
            kk1Var = new kk1(nk1Var, continuation);
        }
        Object objCoroutineScope = kk1Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = kk1Var.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            lk1 lk1Var = new lk1(j, context, zy1Var, nk1Var, list, null);
            kk1Var.d = 1;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(lk1Var, kk1Var);
            if (objCoroutineScope == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objCoroutineScope);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCoroutineScope);
            }
            return new bk1((List) objCoroutineScope);
        }
        CoroutineDispatcher coroutineDispatcherA = nu.a();
        mk1 mk1Var = new mk1((List) objCoroutineScope, null);
        kk1Var.d = 2;
        objCoroutineScope = BuildersKt.withContext(coroutineDispatcherA, mk1Var, kk1Var);
        if (objCoroutineScope == coroutine_suspended) {
            return coroutine_suspended;
        }
        return new bk1((List) objCoroutineScope);
    }
}
