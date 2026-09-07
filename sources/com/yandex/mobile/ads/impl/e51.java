package com.yandex.mobile.ads.impl;

import android.content.Context;
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

/* JADX INFO: loaded from: classes3.dex */
public final class e51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8762a;
    private final g5 b;
    private final CoroutineScope c;
    private final Context d;
    private final g51 e;
    private final r91 f;

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.NativeAdCreationManager$createNativeAd$1", f = "NativeAdCreationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ o8<?> c;
        final /* synthetic */ u61 d;
        final /* synthetic */ o51 e;
        final /* synthetic */ c51 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(o8<?> o8Var, u61 u61Var, o51 o51Var, c51 c51Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = o8Var;
            this.d = u61Var;
            this.e = o51Var;
            this.f = c51Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e51.this.new b(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            new a(e51.this, this.c, this.d, this.e, this.f).run();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ e51(Context context, uu1 uu1Var, o3 o3Var, g5 g5Var, CoroutineScope coroutineScope) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ab1 ab1Var = new ab1(o3Var, context, g5Var);
        a51 a51Var = new a51(ab1Var);
        this(context, uu1Var, o3Var, g5Var, coroutineScope, applicationContext, ab1Var, a51Var, new g51(o3Var, uu1Var, a51Var), new r91(context, uu1Var, g5Var, a51Var, coroutineScope));
    }

    public e51(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, g5 adLoadingPhasesManager, CoroutineScope coroutineScope, Context appContext, ab1 nativeVideoLoadController, a51 nativeAdControllers, g51 nativeAdCreator, r91 nativeResourcesLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(nativeVideoLoadController, "nativeVideoLoadController");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(nativeAdCreator, "nativeAdCreator");
        Intrinsics.checkNotNullParameter(nativeResourcesLoader, "nativeResourcesLoader");
        this.f8762a = adConfiguration;
        this.b = adLoadingPhasesManager;
        this.c = coroutineScope;
        this.d = appContext;
        this.e = nativeAdCreator;
        this.f = nativeResourcesLoader;
    }

    public final void a(o8<?> adResponse, u61 u61Var, o51 nativeAdFactoriesProvider, c51 nativeAdCreationListener) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(adResponse, u61Var, nativeAdFactoriesProvider, nativeAdCreationListener, null), 3, null);
    }

    public final class a implements Runnable {
        private final o8<?> b;
        private final u61 c;
        private final o51 d;
        private final c51 e;
        private final bw f;
        final /* synthetic */ e51 g;

        public a(e51 e51Var, o8<?> adResponse, u61 u61Var, o51 nativeAdFactoriesProvider, c51 nativeAdCreationListener) {
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
            Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
            this.g = e51Var;
            this.b = adResponse;
            this.c = u61Var;
            this.d = nativeAdFactoriesProvider;
            this.e = nativeAdCreationListener;
            this.f = new cw(e51Var.d, e51Var.f8762a, new xq1().b(adResponse, e51Var.f8762a)).a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                u61 u61Var = this.c;
                if (u61Var == null) {
                    this.e.a(w7.k());
                } else if (u61Var.e().isEmpty()) {
                    this.e.a(w7.q());
                } else {
                    o41 o41Var = new o41(this.b, this.g.f8762a, this.c);
                    C0743a c0743a = new C0743a(this, this.e, this.g.b);
                    g5 g5Var = this.g.b;
                    f5 adLoadingPhaseType = f5.p;
                    g5Var.getClass();
                    Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
                    g5Var.a(adLoadingPhaseType, null);
                    this.g.f.a(this.g.d, this.g.f8762a, o41Var, c0743a, this.f, this.e);
                }
            } catch (Exception unused) {
                op0.c(new Object[0]);
                this.e.a(w7.k());
            }
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.e51$a$a, reason: collision with other inner class name */
        public final class C0743a implements r91.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c51 f8763a;
            private final g5 b;
            final /* synthetic */ a c;

            public C0743a(a aVar, c51 nativeAdCreationListener, g5 adLoadingPhasesManager) {
                Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
                Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
                this.c = aVar;
                this.f8763a = nativeAdCreationListener;
                this.b = adLoadingPhasesManager;
            }

            @Override // com.yandex.mobile.ads.impl.r91.a
            public final void a(uk1 imageProvider, o41 nativeAdBlock) {
                Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
                Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
                this.b.a(f5.p);
                CoroutineScope coroutineScope = this.c.g.c;
                a aVar = this.c;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new d51(aVar.g, nativeAdBlock, imageProvider, aVar, this, null), 3, null);
            }
        }
    }

    public final void a() {
        this.f.a();
    }
}
