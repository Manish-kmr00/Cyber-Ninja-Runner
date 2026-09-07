package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
public final class pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9912a = new Object();
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    public static final void a(pc pcVar, Context context) {
        ArrayList arrayList;
        synchronized (pcVar.f9912a) {
            arrayList = new ArrayList(pcVar.b);
            pcVar.b.clear();
            Unit unit = Unit.INSTANCE;
        }
        int i = oc.h;
        oc ocVarA = oc.a.a(context);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ocVarA.a((vc) it.next());
        }
    }

    @DebugMetadata(c = "com.monetization.ads.core.identifiers.ad.AdvertisingInfoLoader$requestAdvertisingInfo$2", f = "AdvertisingInfoLoader.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super nc>, Object> {
        int b;
        final /* synthetic */ Context d;

        static final class b implements vc {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<nc> f9913a;

            b(CancellableContinuationImpl cancellableContinuationImpl) {
                this.f9913a = cancellableContinuationImpl;
            }

            @Override // com.yandex.mobile.ads.impl.vc
            public final void a(nc ncVar) {
                if (this.f9913a.isActive()) {
                    CancellableContinuation<nc> cancellableContinuation = this.f9913a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7904constructorimpl(ncVar));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return pc.this.new a(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super nc> continuation) {
            return pc.this.new a(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                pc pcVar = pc.this;
                Context context = this.d;
                this.b = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                cancellableContinuationImpl.invokeOnCancellation(new C0754a(pcVar, context));
                pc.a(pcVar, context, new b(cancellableContinuationImpl));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
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

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.pc$a$a, reason: collision with other inner class name */
        static final class C0754a extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ pc b;
            final /* synthetic */ Context c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0754a(pc pcVar, Context context) {
                super(1);
                this.b = pcVar;
                this.c = context;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                pc.a(this.b, this.c);
                return Unit.INSTANCE;
            }
        }
    }

    public static final void a(pc pcVar, Context context, vc vcVar) {
        synchronized (pcVar.f9912a) {
            pcVar.b.add(vcVar);
            int i = oc.h;
            oc.a.a(context).b(vcVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Object a(Context context, Continuation<? super nc> continuation) {
        return BuildersKt.withContext(nu.a(), new a(context, null), continuation);
    }
}
