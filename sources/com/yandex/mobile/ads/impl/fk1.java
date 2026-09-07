package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.prefetch.MediatedAdapterPrefetchListener;
import com.monetization.ads.mediation.base.prefetch.MediatedAdapterPrefetcher;
import com.monetization.ads.mediation.base.prefetch.model.MediatedPrefetchAdapterData;
import java.util.HashMap;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes8.dex */
public final class fk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ek1 f8904a;

    public /* synthetic */ fk1() {
        this(new ek1());
    }

    public fk1(ek1 prefetchedMediationInfoFactory) {
        Intrinsics.checkNotNullParameter(prefetchedMediationInfoFactory, "prefetchedMediationInfoFactory");
        this.f8904a = prefetchedMediationInfoFactory;
    }

    public static final class a implements MediatedAdapterPrefetchListener {
        final /* synthetic */ hz0 b;
        final /* synthetic */ CancellableContinuation<dk1> c;

        a(hz0 hz0Var, CancellableContinuationImpl cancellableContinuationImpl) {
            this.b = hz0Var;
            this.c = cancellableContinuationImpl;
        }

        @Override // com.monetization.ads.mediation.base.prefetch.MediatedAdapterPrefetchListener
        public final void onPrefetched(MediatedPrefetchAdapterData adapterData) {
            Intrinsics.checkNotNullParameter(adapterData, "mediatedPrefetchAdapterData");
            ek1 ek1Var = fk1.this.f8904a;
            String adapter = this.b.e();
            ek1Var.getClass();
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(adapterData, "adapterData");
            dk1 dk1Var = new dk1(adapter, new hk1(adapterData.getNetworkWinner().getNetworkName(), adapterData.getNetworkWinner().getNetworkAdUnit()), new qk1(adapterData.getRevenue().getValue()), new ok1(pk1.c, null, null), adapterData.getNetworkAdInfo());
            if (this.c.isActive()) {
                CancellableContinuation<dk1> cancellableContinuation = this.c;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7904constructorimpl(dk1Var));
            }
        }

        @Override // com.monetization.ads.mediation.base.prefetch.MediatedAdapterPrefetchListener
        public final void onPrefetchFailed(Integer num, String str) {
            ek1 ek1Var = fk1.this.f8904a;
            String adapter = this.b.e();
            ek1Var.getClass();
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            dk1 dk1Var = new dk1(adapter, null, null, new ok1(pk1.d, str, num), null);
            if (this.c.isActive()) {
                CancellableContinuation<dk1> cancellableContinuation = this.c;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7904constructorimpl(dk1Var));
            }
        }
    }

    public final Object a(Context context, zy1 zy1Var, hz0 hz0Var, MediatedAdapterPrefetcher mediatedAdapterPrefetcher, Continuation<? super dk1> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            Context contextA = p0.a();
            if (contextA != null) {
                context = contextA;
            }
            HashMap map = new HashMap(hz0Var.i());
            if (zy1Var != null) {
                map.put("width", String.valueOf(zy1Var.getWidth()));
                map.put("height", String.valueOf(zy1Var.getHeight()));
            }
            mediatedAdapterPrefetcher.prefetchAd(context, map, new a(hz0Var, cancellableContinuationImpl));
        } catch (Exception unused) {
            if (cancellableContinuationImpl.isActive()) {
                mediatedAdapterPrefetcher.onInvalidate();
                Result.Companion companion = Result.INSTANCE;
                ek1 ek1Var = this.f8904a;
                String adapter = hz0Var.e();
                ek1Var.getClass();
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                cancellableContinuationImpl.resumeWith(Result.m7904constructorimpl(new dk1(adapter, null, null, new ok1(pk1.d, null, null), null)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
