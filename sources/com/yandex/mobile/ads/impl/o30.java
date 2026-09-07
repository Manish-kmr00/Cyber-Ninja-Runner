package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.ktor.http.LinkHeader;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes9.dex */
public final class o30 {
    private static final AtomicBoolean e = new AtomicBoolean(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f9776a;
    private final Context b;
    private final n4 c;
    private final fg0 d;

    @DebugMetadata(c = "com.monetization.ads.base.dns.DnsPrefetcher", f = "DnsPrefetcher.kt", i = {0, 0}, l = {28}, m = LinkHeader.Rel.Prefetch, n = {"this_$iv", "phase$iv"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {
        g5 b;
        f5 c;
        /* synthetic */ Object d;
        int f;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return o30.this.a(this);
        }
    }

    @DebugMetadata(c = "com.monetization.ads.base.dns.DnsPrefetcher$prefetch$2$1", f = "DnsPrefetcher.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o30.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return o30.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List listA = o30.a(o30.this);
                if (listA.isEmpty()) {
                    op0.a(new Object[0]);
                    return Unit.INSTANCE;
                }
                o30 o30Var = o30.this;
                this.b = 1;
                o30Var.getClass();
                Object objWithTimeout = TimeoutKt.withTimeout(2500L, new p30(o30Var, listA, null), this);
                if (objWithTimeout != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objWithTimeout = Unit.INSTANCE;
                }
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ o30(Context context, g5 g5Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, g5Var, applicationContext, new n4(), new fg0());
    }

    public o30(Context context, g5 adLoadingPhasesManager, Context appContext, n4 adHostConfigurator, fg0 hostReachabilityRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(adHostConfigurator, "adHostConfigurator");
        Intrinsics.checkNotNullParameter(hostReachabilityRepository, "hostReachabilityRepository");
        this.f9776a = adLoadingPhasesManager;
        this.b = appContext;
        this.c = adHostConfigurator;
        this.d = hostReachabilityRepository;
    }

    public static final List a(o30 o30Var) {
        o30Var.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        o82.a aVar = o82.f9793a;
        String strA = o30Var.c.a(o30Var.b);
        aVar.getClass();
        String strA2 = o82.a.a(strA);
        if (strA2 != null) {
            listCreateListBuilder.add(strA2);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        f5 f5Var;
        g5 g5Var;
        Throwable th;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (e.getAndSet(false)) {
                g5 g5Var2 = this.f9776a;
                f5 f5Var2 = f5.B;
                g5Var2.b(f5Var2);
                try {
                    CoroutineDispatcher coroutineDispatcherA = nu.a();
                    b bVar = new b(null);
                    aVar.b = g5Var2;
                    aVar.c = f5Var2;
                    aVar.f = 1;
                    if (BuildersKt.withContext(coroutineDispatcherA, bVar, aVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    g5Var = g5Var2;
                    f5Var = f5Var2;
                    Unit unit = Unit.INSTANCE;
                    g5Var.a(f5Var);
                } catch (Throwable th2) {
                    f5Var = f5Var2;
                    g5Var = g5Var2;
                    th = th2;
                    String str = "Something went wrong while prefetching DNS: " + th.getMessage();
                    op0.a(new Object[0]);
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f5Var = aVar.c;
            g5Var = aVar.b;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                String str2 = "Something went wrong while prefetching DNS: " + th.getMessage();
                op0.a(new Object[0]);
            }
            Unit unit2 = Unit.INSTANCE;
            g5Var.a(f5Var);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        if (this.d.a(2000, str)) {
            String str2 = "Prefetch DNS for url " + str;
            op0.a(new Object[0]);
        } else {
            String str3 = "Url " + str + " for DNS prefetching is inaccessible";
            op0.a(new Object[0]);
        }
    }
}
