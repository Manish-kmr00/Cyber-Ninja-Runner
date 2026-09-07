package com.yandex.mobile.ads.impl;

import android.content.Context;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes4.dex */
public final class hu1 {
    private static final Mutex d = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f9138a;
    private final dx1 b;
    private final gu1 c;

    public /* synthetic */ hu1(Context context, uu1 uu1Var, m50 m50Var, jc jcVar, g5 g5Var) {
        dx1 dx1Var = new dx1();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, uu1Var, m50Var, jcVar, g5Var, dx1Var, new gu1(applicationContext, uu1Var.c(), jcVar, m50Var, g5Var));
    }

    public hu1(Context context, uu1 sdkEnvironmentModule, m50 environmentController, jc advertisingConfiguration, g5 adLoadingPhasesManager, dx1 sensitiveModeChecker, gu1 sdkConfigurationLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        Intrinsics.checkNotNullParameter(sdkConfigurationLoader, "sdkConfigurationLoader");
        this.f9138a = adLoadingPhasesManager;
        this.b = sensitiveModeChecker;
        this.c = sdkConfigurationLoader;
    }

    public final Object a(dl0 dl0Var, Continuation<? super ru1> continuation) {
        return BuildersKt.withContext(nu.a(), new a(dl0Var, null), continuation);
    }

    @DebugMetadata(c = "com.monetization.ads.base.SdkConfigurationLoaderHolder$loadSdkConfiguration$2", f = "SdkConfigurationLoaderHolder.kt", i = {0, 1, 1}, l = {93, 96}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$0", "L$3"})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ru1>, Object> {
        Mutex b;
        hu1 c;
        dl0 d;
        Object e;
        int f;
        final /* synthetic */ dl0 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(dl0 dl0Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.h = dl0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return hu1.this.new a(this.h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ru1> continuation) {
            return hu1.this.new a(this.h, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            hu1 hu1Var;
            dl0 dl0Var;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    g5 g5Var = hu1.this.f9138a;
                    f5 adLoadingPhaseType = f5.l;
                    g5Var.getClass();
                    Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
                    g5Var.a(adLoadingPhaseType, null);
                    mutex = hu1.d;
                    hu1Var = hu1.this;
                    dl0Var = this.h;
                    this.b = mutex;
                    this.c = hu1Var;
                    this.d = dl0Var;
                    this.f = 1;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = this.b;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ru1 ru1Var = (ru1) obj;
                            mutex2.unlock(null);
                            return ru1Var;
                        } catch (Throwable th) {
                            th = th;
                            mutex = mutex2;
                            mutex.unlock(null);
                            throw th;
                        }
                    }
                    dl0Var = this.d;
                    hu1Var = this.c;
                    mutex = this.b;
                    ResultKt.throwOnFailure(obj);
                }
                hu1Var.f9138a.a(f5.l);
                this.b = mutex;
                this.c = hu1Var;
                this.d = dl0Var;
                this.f = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                cancellableContinuationImpl.invokeOnCancellation(new C0747a(hu1Var));
                hu1Var.c.a(hu1Var.b, dl0Var, new b(cancellableContinuationImpl));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                ru1 ru1Var2 = (ru1) obj;
                mutex2.unlock(null);
                return ru1Var2;
            } catch (Throwable th2) {
                th = th2;
                mutex.unlock(null);
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.hu1$a$a, reason: collision with other inner class name */
        static final class C0747a extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ hu1 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0747a(hu1 hu1Var) {
                super(1);
                this.b = hu1Var;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                this.b.c.a();
                return Unit.INSTANCE;
            }
        }

        public static final class b implements gu1.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<ru1> f9139a;

            b(CancellableContinuationImpl cancellableContinuationImpl) {
                this.f9139a = cancellableContinuationImpl;
            }

            @Override // com.yandex.mobile.ads.impl.gu1.a
            public final void a(ki2 error, ir configurationSource) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(configurationSource, "configurationSource");
                if (this.f9139a.isActive()) {
                    CancellableContinuation<ru1> cancellableContinuation = this.f9139a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7904constructorimpl(new ru1.a(error, configurationSource)));
                }
            }

            @Override // com.yandex.mobile.ads.impl.gu1.a
            public final void a(cu1 sdkConfiguration, ir configurationSource) {
                Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
                Intrinsics.checkNotNullParameter(configurationSource, "configurationSource");
                if (this.f9139a.isActive()) {
                    CancellableContinuation<ru1> cancellableContinuation = this.f9139a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7904constructorimpl(new ru1.b(sdkConfiguration, configurationSource)));
                }
            }
        }
    }
}
