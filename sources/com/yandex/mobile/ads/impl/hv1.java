package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: loaded from: classes8.dex */
public final class hv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9140a;
    private final CoroutineScope b;
    private final g5 c;
    private final m50 d;
    private final jc e;
    private final iw1 f;
    private final Context g;
    private final a2 h;
    private final wi0 i;
    private final pc j;
    private final hu1 k;
    private final dg l;
    private final s3 m;
    private final rw1 n;
    private final mv1 o;
    private final ud p;
    private final lu1 q;
    private final o30 r;
    private final gd s;
    private final vi0 t;

    public interface a {
        void a(jc jcVar, l50 l50Var);

        void a(w3 w3Var);
    }

    @DebugMetadata(c = "com.monetization.ads.core.initializer.SdkInitializer$initialize$1", f = "SdkInitializer.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3}, l = {104, 106, 108, 109}, m = "invokeSuspend", n = {"this_$iv", "phase$iv", "prefetchDnsJob", "this_$iv", "phase$iv", "prefetchDnsJob", "this_$iv", "phase$iv", "this_$iv", "phase$iv"}, s = {"L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "L$0", "L$1", "L$0", "L$1"})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        f5 b;
        hv1 c;
        dl0 d;
        Job e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ dl0 i;
        final /* synthetic */ a j;

        @DebugMetadata(c = "com.monetization.ads.core.initializer.SdkInitializer$initialize$1$sdkConfigurationResult$1$prefetchDnsJob$1", f = "SdkInitializer.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int b;
            final /* synthetic */ boolean c;
            final /* synthetic */ hv1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z, hv1 hv1Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = z;
                this.d = hv1Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.c) {
                        o30 o30Var = this.d.r;
                        this.b = 1;
                        if (o30Var.a(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(dl0 dl0Var, a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.i = dl0Var;
            this.j = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = hv1.this.new b(this.i, this.j, continuation);
            bVar.g = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00f2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:32:0x0108 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0109  */
        /* JADX WARN: Code duplicated, block: B:36:0x0113  */
        /* JADX WARN: Code duplicated, block: B:37:0x014a  */
        /* JADX WARN: Code duplicated, block: B:39:0x014e  */
        /* JADX WARN: Code duplicated, block: B:41:0x0166  */
        /* JADX WARN: Code duplicated, block: B:42:0x0171  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            f5 f5Var;
            dl0 dl0Var;
            g5 g5Var;
            hv1 hv1Var;
            Job job;
            dl0 dl0Var2;
            hv1 hv1Var2;
            f5 f5Var2;
            dl0 dl0Var3;
            hv1 hv1Var3;
            f5 f5Var3;
            g5 g5Var2;
            Object objA;
            f5 f5Var4;
            ru1 ru1Var;
            ki2 error;
            w3 w3VarM;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i != 0) {
                if (i == 1) {
                    job = this.e;
                    dl0Var = this.d;
                    hv1Var = this.c;
                    f5 f5Var5 = this.b;
                    g5 g5Var3 = (g5) this.g;
                    ResultKt.throwOnFailure(obj);
                    f5Var = f5Var5;
                    g5Var = g5Var3;
                } else if (i == 2) {
                    job = this.e;
                    dl0Var2 = this.d;
                    hv1Var2 = this.c;
                    f5Var2 = this.b;
                    g5Var = (g5) this.g;
                    ResultKt.throwOnFailure(obj);
                    this.g = g5Var;
                    this.b = f5Var2;
                    this.c = hv1Var2;
                    this.d = dl0Var2;
                    this.e = null;
                    this.f = 3;
                    if (job.join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dl0Var3 = dl0Var2;
                    hv1Var3 = hv1Var2;
                    f5Var3 = f5Var2;
                    g5Var2 = g5Var;
                    this.g = g5Var2;
                    this.b = f5Var3;
                    this.c = null;
                    this.d = null;
                    this.f = 4;
                    objA = hv1.a(hv1Var3, dl0Var3, this);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f5Var4 = f5Var3;
                } else if (i == 3) {
                    dl0 dl0Var4 = this.d;
                    hv1Var3 = this.c;
                    f5Var3 = this.b;
                    g5 g5Var4 = (g5) this.g;
                    ResultKt.throwOnFailure(obj);
                    dl0Var3 = dl0Var4;
                    g5Var2 = g5Var4;
                    this.g = g5Var2;
                    this.b = f5Var3;
                    this.c = null;
                    this.d = null;
                    this.f = 4;
                    objA = hv1.a(hv1Var3, dl0Var3, this);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f5Var4 = f5Var3;
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f5Var4 = this.b;
                    g5Var2 = (g5) this.g;
                    ResultKt.throwOnFailure(obj);
                    objA = obj;
                }
                ru1Var = (ru1) objA;
                g5Var2.a(f5Var4);
                if (ru1Var instanceof ru1.b) {
                    ru1.b bVar = (ru1.b) ru1Var;
                    hv1.this.o.a(bVar.b(), this.i, bVar.a());
                    hv1.this.n.a();
                    p11.a();
                    this.j.a(hv1.this.e, hv1.this.d.c());
                } else if (ru1Var instanceof ru1.a) {
                    s3 s3Var = hv1.this.m;
                    ru1.a aVar = (ru1.a) ru1Var;
                    error = aVar.b();
                    s3Var.getClass();
                    Intrinsics.checkNotNullParameter(error, "error");
                    if (error instanceof r3) {
                        w3VarM = y3.a.a(null, ((r3) error).a());
                    } else {
                        w3VarM = w7.m();
                    }
                    hv1.this.o.a(w3VarM, this.i, aVar.a());
                    this.j.a(w3VarM);
                }
                hv1.this.l.a();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.g;
            cu1 cu1VarA = hv1.this.f.a(hv1.this.g);
            boolean zK = cu1VarA != null ? cu1VarA.K() : false;
            g5 g5Var5 = hv1.this.c;
            f5Var = f5.j;
            hv1 hv1Var4 = hv1.this;
            dl0 dl0Var5 = this.i;
            ak.a(g5Var5, f5Var, "adLoadingPhaseType", f5Var, null);
            hv1.l(hv1Var4);
            hv1.m(hv1Var4);
            hv1.k(hv1Var4);
            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new a(zK, hv1Var4, null), 3, null);
            this.g = g5Var5;
            this.b = f5Var;
            this.c = hv1Var4;
            this.d = dl0Var5;
            this.e = jobLaunch$default;
            this.f = 1;
            if (hv1.a(hv1Var4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dl0Var = dl0Var5;
            g5Var = g5Var5;
            hv1Var = hv1Var4;
            job = jobLaunch$default;
            hv1.n(hv1Var);
            this.g = g5Var;
            this.b = f5Var;
            this.c = hv1Var;
            this.d = dl0Var;
            this.e = job;
            this.f = 2;
            if (hv1.b(hv1Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dl0Var2 = dl0Var;
            hv1Var2 = hv1Var;
            f5Var2 = f5Var;
            this.g = g5Var;
            this.b = f5Var2;
            this.c = hv1Var2;
            this.d = dl0Var2;
            this.e = null;
            this.f = 3;
            if (job.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dl0Var3 = dl0Var2;
            hv1Var3 = hv1Var2;
            f5Var3 = f5Var2;
            g5Var2 = g5Var;
            this.g = g5Var2;
            this.b = f5Var3;
            this.c = null;
            this.d = null;
            this.f = 4;
            objA = hv1.a(hv1Var3, dl0Var3, this);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            f5Var4 = f5Var3;
            ru1Var = (ru1) objA;
            g5Var2.a(f5Var4);
            if (ru1Var instanceof ru1.b) {
                ru1.b bVar2 = (ru1.b) ru1Var;
                hv1.this.o.a(bVar2.b(), this.i, bVar2.a());
                hv1.this.n.a();
                p11.a();
                this.j.a(hv1.this.e, hv1.this.d.c());
            } else if (ru1Var instanceof ru1.a) {
                s3 s3Var2 = hv1.this.m;
                ru1.a aVar2 = (ru1.a) ru1Var;
                error = aVar2.b();
                s3Var2.getClass();
                Intrinsics.checkNotNullParameter(error, "error");
                if (error instanceof r3) {
                    w3VarM = y3.a.a(null, ((r3) error).a());
                } else {
                    w3VarM = w7.m();
                }
                hv1.this.o.a(w3VarM, this.i, aVar2.a());
                this.j.a(w3VarM);
            }
            hv1.this.l.a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ hv1(Context context, uu1 uu1Var, CoroutineScope coroutineScope, g5 g5Var, m50 m50Var, jc jcVar, int i) {
        m50 m50VarA;
        if ((i & 16) != 0) {
            int i2 = m50.e;
            m50VarA = m50.a.a(context);
        } else {
            m50VarA = m50Var;
        }
        jc jcVar2 = (i & 32) != 0 ? new jc() : jcVar;
        int i3 = iw1.l;
        iw1 iw1VarA = iw1.a.a();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, uu1Var, coroutineScope, g5Var, m50VarA, jcVar2, iw1VarA, applicationContext, d.a(applicationContext), new wi0(m50VarA), new pc(), new hu1(applicationContext, uu1Var, m50VarA, jcVar2, g5Var), new dg(applicationContext, uu1Var), new s3(), new rw1(applicationContext), new it0(), new mv1(uu1Var.c(), it0.g(context), g5Var), new ud(), new lu1(), new o30(context, g5Var), new gd());
    }

    public static final void k(hv1 hv1Var) {
        de.a(hv1Var.g, hv1Var.f9140a.c());
    }

    public static final void l(hv1 hv1Var) {
        hv1Var.s.a(hv1Var.g);
    }

    public static final void m(hv1 hv1Var) {
        int i = z72.c;
        z72.a(hv1Var.g, hv1Var.f9140a.c());
    }

    public static final void n(hv1 hv1Var) {
        g5 g5Var = hv1Var.c;
        f5 f5Var = f5.i;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        hv1Var.t.a(hv1Var.g, hv1Var.i.a());
        Unit unit = Unit.INSTANCE;
        g5Var.a(f5Var);
    }

    public hv1(Context context, uu1 sdkEnvironmentModule, CoroutineScope coroutineScope, g5 adLoadingPhasesManager, m50 environmentController, jc advertisingConfiguration, iw1 sdkSettings, Context applicationContext, a2 adBlockerController, wi0 identifiersLoader, pc advertisingInfoLoader, hu1 sdkConfigurationLoaderHolder, dg appStartFalseClickTracker, s3 adFetchErrorProvider, rw1 sdkVersionValidator, it0 manifestAnalyzer, mv1 sdkInitializerReporter, ud androidSdkApiChecker, lu1 sdkConfigurationRefreshChecker, o30 dnsPrefetcher, gd analyticsEasyIntegrationInitializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(adBlockerController, "adBlockerController");
        Intrinsics.checkNotNullParameter(identifiersLoader, "identifiersLoader");
        Intrinsics.checkNotNullParameter(advertisingInfoLoader, "advertisingInfoLoader");
        Intrinsics.checkNotNullParameter(sdkConfigurationLoaderHolder, "sdkConfigurationLoaderHolder");
        Intrinsics.checkNotNullParameter(appStartFalseClickTracker, "appStartFalseClickTracker");
        Intrinsics.checkNotNullParameter(adFetchErrorProvider, "adFetchErrorProvider");
        Intrinsics.checkNotNullParameter(sdkVersionValidator, "sdkVersionValidator");
        Intrinsics.checkNotNullParameter(manifestAnalyzer, "manifestAnalyzer");
        Intrinsics.checkNotNullParameter(sdkInitializerReporter, "sdkInitializerReporter");
        Intrinsics.checkNotNullParameter(androidSdkApiChecker, "androidSdkApiChecker");
        Intrinsics.checkNotNullParameter(sdkConfigurationRefreshChecker, "sdkConfigurationRefreshChecker");
        Intrinsics.checkNotNullParameter(dnsPrefetcher, "dnsPrefetcher");
        Intrinsics.checkNotNullParameter(analyticsEasyIntegrationInitializer, "analyticsEasyIntegrationInitializer");
        this.f9140a = sdkEnvironmentModule;
        this.b = coroutineScope;
        this.c = adLoadingPhasesManager;
        this.d = environmentController;
        this.e = advertisingConfiguration;
        this.f = sdkSettings;
        this.g = applicationContext;
        this.h = adBlockerController;
        this.i = identifiersLoader;
        this.j = advertisingInfoLoader;
        this.k = sdkConfigurationLoaderHolder;
        this.l = appStartFalseClickTracker;
        this.m = adFetchErrorProvider;
        this.n = sdkVersionValidator;
        this.o = sdkInitializerReporter;
        this.p = androidSdkApiChecker;
        this.q = sdkConfigurationRefreshChecker;
        this.r = dnsPrefetcher;
        this.s = analyticsEasyIntegrationInitializer;
        this.t = new vi0(environmentController.c(), new n4());
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (r2 != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(com.yandex.mobile.ads.impl.hv1 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6.getClass()
            boolean r0 = r7 instanceof com.yandex.mobile.ads.impl.iv1
            if (r0 == 0) goto L16
            r0 = r7
            com.yandex.mobile.ads.impl.iv1 r0 = (com.yandex.mobile.ads.impl.iv1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f = r1
            goto L1b
        L16:
            com.yandex.mobile.ads.impl.iv1 r0 = new com.yandex.mobile.ads.impl.iv1
            r0.<init>(r6, r7)
        L1b:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            com.yandex.mobile.ads.impl.f5 r6 = r0.c
            com.yandex.mobile.ads.impl.g5 r0 = r0.b
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7b
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            com.yandex.mobile.ads.impl.iw1 r7 = r6.f
            android.content.Context r2 = r6.g
            com.yandex.mobile.ads.impl.cu1 r7 = r7.a(r2)
            if (r7 == 0) goto L60
            java.lang.String r2 = r7.d()
            if (r2 == 0) goto L4d
            r2 = r3
            goto L4e
        L4d:
            r2 = 0
        L4e:
            com.yandex.mobile.ads.impl.lu1 r4 = r6.q
            boolean r4 = r4.a(r7)
            boolean r7 = r7.U()
            if (r7 == 0) goto L5d
            if (r4 != 0) goto L5d
            goto L80
        L5d:
            if (r2 == 0) goto L60
            goto L80
        L60:
            com.yandex.mobile.ads.impl.g5 r7 = r6.c
            com.yandex.mobile.ads.impl.f5 r2 = com.yandex.mobile.ads.impl.f5.k
            java.lang.String r4 = "adLoadingPhaseType"
            r5 = 0
            com.yandex.mobile.ads.impl.ak.a(r7, r2, r4, r2, r5)
            com.yandex.mobile.ads.impl.a2 r6 = r6.h
            r0.b = r7
            r0.c = r2
            r0.f = r3
            java.lang.Object r6 = r6.a(r0)
            if (r6 != r1) goto L79
            goto L82
        L79:
            r0 = r7
            r6 = r2
        L7b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            r0.a(r6)
        L80:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.hv1.a(com.yandex.mobile.ads.impl.hv1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object b(hv1 hv1Var, Continuation continuation) throws Throwable {
        kv1 kv1Var;
        f5 f5Var;
        g5 g5Var;
        hv1Var.getClass();
        if (continuation instanceof kv1) {
            kv1Var = (kv1) continuation;
            int i = kv1Var.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                kv1Var.g = i - Integer.MIN_VALUE;
            } else {
                kv1Var = new kv1(hv1Var, continuation);
            }
        } else {
            kv1Var = new kv1(hv1Var, continuation);
        }
        Object obj = kv1Var.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = kv1Var.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            g5 g5Var2 = hv1Var.c;
            f5Var = f5.d;
            ak.a(g5Var2, f5Var, "adLoadingPhaseType", f5Var, null);
            pc pcVar = hv1Var.j;
            Context context = hv1Var.g;
            kv1Var.b = hv1Var;
            kv1Var.c = g5Var2;
            kv1Var.d = f5Var;
            kv1Var.g = 1;
            Object objA = pcVar.a(context, kv1Var);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            g5Var = g5Var2;
            obj = objA;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f5 f5Var2 = kv1Var.d;
            g5Var = kv1Var.c;
            hv1 hv1Var2 = kv1Var.b;
            ResultKt.throwOnFailure(obj);
            f5Var = f5Var2;
            hv1Var = hv1Var2;
        }
        nc ncVar = (nc) obj;
        if (ncVar != null) {
            hv1Var.e.a(ncVar.a());
            hv1Var.e.b(ncVar.c());
            hv1Var.e.a(ncVar.b());
            if (ncVar.a() != null) {
                hv1Var.d.c().h();
            }
        }
        Unit unit = Unit.INSTANCE;
        g5Var.a(f5Var);
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object a(hv1 hv1Var, dl0 dl0Var, Continuation continuation) throws Throwable {
        jv1 jv1Var;
        g5 g5Var;
        f5 f5Var;
        hv1Var.getClass();
        if (continuation instanceof jv1) {
            jv1Var = (jv1) continuation;
            int i = jv1Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                jv1Var.f = i - Integer.MIN_VALUE;
            } else {
                jv1Var = new jv1(hv1Var, continuation);
            }
        } else {
            jv1Var = new jv1(hv1Var, continuation);
        }
        Object obj = jv1Var.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = jv1Var.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            g5 g5Var2 = hv1Var.c;
            f5 f5Var2 = f5.m;
            ak.a(g5Var2, f5Var2, "adLoadingPhaseType", f5Var2, null);
            hu1 hu1Var = hv1Var.k;
            jv1Var.b = g5Var2;
            jv1Var.c = f5Var2;
            jv1Var.f = 1;
            Object objA = hu1Var.a(dl0Var, jv1Var);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            g5Var = g5Var2;
            obj = objA;
            f5Var = f5Var2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f5Var = jv1Var.c;
            g5Var = jv1Var.b;
            ResultKt.throwOnFailure(obj);
        }
        ru1 ru1Var = (ru1) obj;
        g5Var.a(f5Var);
        return ru1Var;
    }

    public final void a() {
        JobKt__JobKt.cancelChildren$default(this.b.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public final void a(dl0 initializationCallSource, a initializationListener) {
        Intrinsics.checkNotNullParameter(initializationCallSource, "initializationCallSource");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        if (this.p.a()) {
            BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new b(initializationCallSource, initializationListener, null), 3, null);
            return;
        }
        r3 error = new r3(x3.i, null);
        this.m.getClass();
        Intrinsics.checkNotNullParameter(error, "error");
        initializationListener.a(y3.a.a(null, error.a()));
    }
}
