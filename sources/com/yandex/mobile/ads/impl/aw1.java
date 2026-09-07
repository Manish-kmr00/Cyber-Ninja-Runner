package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class aw1 implements dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zi f8446a;
    private final v91 b;
    private final mj c;
    private final p71 d;
    private final qt1 e;
    private final x71 f;
    private final Handler g;
    private final iw1 h;
    private final bj i;
    private final z51 j;
    private final ViewTreeObserver.OnPreDrawListener k;
    private o8<String> l;
    private m61 m;
    private boolean n;
    private lj o;

    public aw1(zi loadController, uu1 sdkEnvironmentModule, v91 nativeResponseCreator, mj contentControllerCreator, p71 requestParameterManager, qt1 sdkAdapterReporter, x71 adEventListener, Handler handler, iw1 sdkSettings, bj sizeValidator, z51 infoProvider) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeResponseCreator, "nativeResponseCreator");
        Intrinsics.checkNotNullParameter(contentControllerCreator, "contentControllerCreator");
        Intrinsics.checkNotNullParameter(requestParameterManager, "requestParameterManager");
        Intrinsics.checkNotNullParameter(sdkAdapterReporter, "sdkAdapterReporter");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(sizeValidator, "sizeValidator");
        Intrinsics.checkNotNullParameter(infoProvider, "infoProvider");
        this.f8446a = loadController;
        this.b = nativeResponseCreator;
        this.c = contentControllerCreator;
        this.d = requestParameterManager;
        this.e = sdkAdapterReporter;
        this.f = adEventListener;
        this.g = handler;
        this.h = sdkSettings;
        this.i = sizeValidator;
        this.j = infoProvider;
        this.k = new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.mobile.ads.impl.aw1$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return aw1.g(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(final aw1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.aw1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                aw1.h(this.f$0);
            }
        }, 50L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(aw1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rg2.a(this$0.f8446a.C(), false);
    }

    public static final void f(aw1 aw1Var) {
        aw1Var.l = null;
        aw1Var.m = null;
    }

    public final class a implements wq1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f8447a;
        private final o8<?> b;
        final /* synthetic */ aw1 c;

        public a(aw1 aw1Var, Context context, o8<?> adResponse) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            this.c = aw1Var;
            this.f8447a = context;
            this.b = adResponse;
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            this.c.e.a(this.f8447a, this.b, this.c.d);
            this.c.e.a(this.f8447a, this.b, (q71) null);
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(u61 nativeAdResponse) {
            Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
            q71 q71Var = new q71(this.b, nativeAdResponse, this.c.f8446a.f());
            this.c.e.a(this.f8447a, this.b, this.c.d);
            this.c.e.a(this.f8447a, this.b, q71Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        lj ljVar = this.o;
        if (ljVar != null) {
            ljVar.a();
        }
        this.b.a();
        this.l = null;
        this.m = null;
        this.n = true;
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final String getAdInfo() {
        return this.j.a(this.m);
    }

    public static final class c implements cj {
        c() {
        }

        @Override // com.yandex.mobile.ads.impl.cj
        public final void a() {
            aw1.this.f8446a.u();
        }

        @Override // com.yandex.mobile.ads.impl.cj
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            aw1.this.f8446a.b(error);
        }
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final void a(Context context, o8<String> response) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(response, "response");
        g5 g5VarI = this.f8446a.i();
        f5 f5Var = f5.c;
        ak.a(g5VarI, f5Var, "adLoadingPhaseType", f5Var, null);
        cu1 cu1VarA = this.h.a(context);
        if (cu1VarA != null && cu1VarA.p0()) {
            if (this.n) {
                return;
            }
            zy1 zy1VarQ = this.f8446a.q();
            zy1 zy1VarM = response.M();
            this.l = response;
            if (zy1VarQ != null && bz1.a(context, response, zy1VarM, this.i, zy1VarQ)) {
                this.b.a(response, new b(), new a(this, context, response));
                return;
            }
            w3 w3VarA = w7.a(zy1VarQ != null ? zy1VarQ.c(context) : 0, zy1VarQ != null ? zy1VarQ.a(context) : 0, zy1VarM.getWidth(), zy1VarM.getHeight(), oh2.c(context), oh2.b(context));
            dp0.a(w3VarA.d(), new Object[0]);
            this.f8446a.b(w3VarA);
            return;
        }
        this.f8446a.b(w7.x());
    }

    public final class b implements v91.b {
        @Override // com.yandex.mobile.ads.impl.v91.b
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            if (aw1.this.n) {
                return;
            }
            aw1.f(aw1.this);
            aw1.this.f8446a.b(adRequestError);
        }

        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.v91.b
        public final void a(m61 createdNativeAd) {
            Intrinsics.checkNotNullParameter(createdNativeAd, "createdNativeAd");
            if (aw1.this.n) {
                return;
            }
            aw1.this.m = createdNativeAd;
            Handler handler = aw1.this.g;
            final aw1 aw1Var = aw1.this;
            handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.aw1$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    aw1.b.a(aw1Var);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(aw1 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.a();
        }
    }

    public final void a() {
        m61 m61Var;
        if (!this.n) {
            o8<String> o8Var = this.l;
            jp0 jp0VarC = this.f8446a.C();
            if (o8Var == null || (m61Var = this.m) == null) {
                return;
            }
            Intrinsics.checkNotNull(m61Var, "null cannot be cast to non-null type com.monetization.ads.nativeads.NativeAdPrivate");
            lj ljVarA = this.c.a(this.f8446a.l(), o8Var, m61Var, jp0VarC, this.f, this.k, this.f8446a.D());
            this.o = ljVarA;
            ljVarA.a(o8Var.M(), new c());
            return;
        }
        this.f8446a.b(w7.i());
    }
}
