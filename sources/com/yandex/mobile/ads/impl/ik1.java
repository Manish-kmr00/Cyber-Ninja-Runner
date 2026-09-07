package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.prefetch.MediatedAdapterPrefetcher;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes10.dex */
@DebugMetadata(c = "com.monetization.ads.base.mediation.prefetch.PrefetchedMediationNetworksDataLoader$loadNetworkMediationDataAsync$1", f = "PrefetchedMediationNetworksDataLoader.kt", i = {0}, l = {76}, m = "invokeSuspend", n = {"mediatedAdapter"}, s = {"L$0"})
final class ik1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dk1>, Object> {
    MediatedAdapterPrefetcher b;
    int c;
    final /* synthetic */ nk1 d;
    final /* synthetic */ c01 e;
    final /* synthetic */ Context f;
    final /* synthetic */ long g;
    final /* synthetic */ zy1 h;

    @DebugMetadata(c = "com.monetization.ads.base.mediation.prefetch.PrefetchedMediationNetworksDataLoader$loadNetworkMediationDataAsync$1$1", f = "PrefetchedMediationNetworksDataLoader.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dk1>, Object> {
        int b;
        final /* synthetic */ nk1 c;
        final /* synthetic */ Context d;
        final /* synthetic */ zy1 e;
        final /* synthetic */ hz0 f;
        final /* synthetic */ MediatedAdapterPrefetcher g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(nk1 nk1Var, Context context, zy1 zy1Var, hz0 hz0Var, MediatedAdapterPrefetcher mediatedAdapterPrefetcher, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = nk1Var;
            this.d = context;
            this.e = zy1Var;
            this.f = hz0Var;
            this.g = mediatedAdapterPrefetcher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super dk1> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                fk1 fk1Var = this.c.b;
                Context context = this.d;
                zy1 zy1Var = this.e;
                hz0 hz0Var = this.f;
                MediatedAdapterPrefetcher mediatedAdapterPrefetcher = this.g;
                this.b = 1;
                obj = fk1Var.a(context, zy1Var, hz0Var, mediatedAdapterPrefetcher, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ik1(nk1 nk1Var, c01 c01Var, Context context, long j, zy1 zy1Var, Continuation<? super ik1> continuation) {
        super(2, continuation);
        this.d = nk1Var;
        this.e = c01Var;
        this.f = context;
        this.g = j;
        this.h = zy1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ik1(this.d, this.e, this.f, this.g, this.h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super dk1> continuation) {
        return ((ik1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MediatedAdapterPrefetcher mediatedAdapterPrefetcher;
        MediatedAdapterPrefetcher mediatedAdapterPrefetcher2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            gk1 gk1Var = this.d.c;
            c01 mediationPrefetchNetwork = this.e;
            gk1Var.getClass();
            Intrinsics.checkNotNullParameter(mediationPrefetchNetwork, "mediationPrefetchNetwork");
            hz0 hz0Var = new hz0(mediationPrefetchNetwork.d(), mediationPrefetchNetwork.e(), null, null, null, null, null);
            Object objA = this.d.f9737a.a(this.f, hz0Var, (Class<Object>) com.monetization.ads.mediation.base.a.class);
            mediatedAdapterPrefetcher = objA instanceof MediatedAdapterPrefetcher ? (MediatedAdapterPrefetcher) objA : null;
            if (mediatedAdapterPrefetcher == null) {
                return null;
            }
            try {
                long j = this.g;
                a aVar = new a(this.d, this.f, this.h, hz0Var, mediatedAdapterPrefetcher, null);
                this.b = mediatedAdapterPrefetcher;
                this.c = 1;
                obj = TimeoutKt.withTimeout(j, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mediatedAdapterPrefetcher2 = mediatedAdapterPrefetcher;
            } catch (Exception unused) {
                mediatedAdapterPrefetcher.onInvalidate();
                return null;
            } catch (Throwable th) {
                th = th;
                mediatedAdapterPrefetcher.onInvalidate();
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mediatedAdapterPrefetcher2 = this.b;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused2) {
                mediatedAdapterPrefetcher = mediatedAdapterPrefetcher2;
                mediatedAdapterPrefetcher.onInvalidate();
                return null;
            } catch (Throwable th2) {
                th = th2;
                mediatedAdapterPrefetcher = mediatedAdapterPrefetcher2;
                mediatedAdapterPrefetcher.onInvalidate();
                throw th;
            }
        }
        dk1 dk1Var = (dk1) obj;
        mediatedAdapterPrefetcher2.onInvalidate();
        return dk1Var;
    }
}
