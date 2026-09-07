package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Set;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes12.dex */
public final class e91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f8775a;
    private final ah b;
    private final zj0 c;
    private final hj0 d;
    private final ek0 e;
    private final Function1<pj0, oj0> f;

    public /* synthetic */ e91(Context context, g5 g5Var) {
        this(context, g5Var, new ah(), new zj0(), new hj0(context), new ek0(), b91.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e91(Context context, g5 adLoadingPhasesManager, ah assetsFilter, zj0 imageValuesFilter, hj0 imageLoadManager, ek0 imagesForPreloadingProvider, Function1<? super pj0, oj0> previewPreloadingFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(assetsFilter, "assetsFilter");
        Intrinsics.checkNotNullParameter(imageValuesFilter, "imageValuesFilter");
        Intrinsics.checkNotNullParameter(imageLoadManager, "imageLoadManager");
        Intrinsics.checkNotNullParameter(imagesForPreloadingProvider, "imagesForPreloadingProvider");
        Intrinsics.checkNotNullParameter(previewPreloadingFactory, "previewPreloadingFactory");
        this.f8775a = adLoadingPhasesManager;
        this.b = assetsFilter;
        this.c = imageValuesFilter;
        this.d = imageLoadManager;
        this.e = imagesForPreloadingProvider;
        this.f = previewPreloadingFactory;
    }

    public final Object a(o41 o41Var, pj0 pj0Var, Continuation<? super Unit> continuation) {
        oj0 oj0VarInvoke = this.f.invoke(pj0Var);
        ek0.a aVarA = this.e.a(o41Var);
        Set<uj0> setA = aVarA.a();
        Set<uj0> setB = aVarA.b();
        Set<uj0> setC = aVarA.c();
        oj0VarInvoke.a(setB);
        if (Intrinsics.areEqual(o41Var.b().E(), y81.d.a())) {
            this.d.a(setC, new d91(pj0Var));
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (setA.isEmpty()) {
            if (cancellableContinuationImpl.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
            }
        } else {
            g5 g5Var = this.f8775a;
            f5 f5Var = f5.q;
            ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
            this.d.a(setA, new c91(this, o41Var, pj0Var, cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            result = Unit.INSTANCE;
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
