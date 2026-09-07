package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import com.yandex.mobile.ads.impl.wd0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class fw1<T extends wd0<T>> implements zc0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd0<T> f8939a;
    private final z51 b;
    private final qt1 c;
    private final v91 d;
    private final o3 e;
    private final p71 f;
    private final pd0 g;
    private o8<String> h;
    private m61 i;
    private boolean j;

    public /* synthetic */ fw1(gd0 gd0Var, uu1 uu1Var) {
        this(gd0Var, uu1Var, new z51());
    }

    private final class a implements wq1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o8<String> f8940a;
        private final Context b;
        final /* synthetic */ fw1<T> c;

        public a(fw1 fw1Var, Context context, o8<String> adResponse) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            this.c = fw1Var;
            this.f8940a = adResponse;
            this.b = context.getApplicationContext();
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            qt1 qt1Var = ((fw1) this.c).c;
            Context context = this.b;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qt1Var.a(context, this.f8940a, ((fw1) this.c).f);
            qt1 qt1Var2 = ((fw1) this.c).c;
            Context context2 = this.b;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            qt1Var2.a(context2, this.f8940a, (q71) null);
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(u61 nativeAdResponse) {
            Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
            q71 q71Var = new q71(this.f8940a, nativeAdResponse, ((fw1) this.c).e);
            qt1 qt1Var = ((fw1) this.c).c;
            Context context = this.b;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qt1Var.a(context, this.f8940a, ((fw1) this.c).f);
            qt1 qt1Var2 = ((fw1) this.c).c;
            Context context2 = this.b;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            qt1Var2.a(context2, this.f8940a, q71Var);
        }
    }

    public fw1(gd0<T> screenLoadController, uu1 sdkEnvironmentModule, z51 infoProvider) {
        Intrinsics.checkNotNullParameter(screenLoadController, "screenLoadController");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(infoProvider, "infoProvider");
        this.f8939a = screenLoadController;
        this.b = infoProvider;
        Context contextL = screenLoadController.l();
        o3 o3VarF = screenLoadController.f();
        this.e = o3VarF;
        this.f = new p71(o3VarF);
        g5 g5VarI = screenLoadController.i();
        this.c = new qt1(o3VarF);
        this.d = new v91(contextL, sdkEnvironmentModule, o3VarF, g5VarI);
        this.g = new pd0(sdkEnvironmentModule);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final String getAdInfo() {
        return this.b.a(this.i);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.j = true;
        this.h = null;
        this.i = null;
        this.d.a();
        op0.d(new Object[0]);
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        if (this.j) {
            return;
        }
        this.h = adResponse;
        g5 g5VarI = this.f8939a.i();
        f5 adLoadingPhaseType = f5.c;
        g5VarI.getClass();
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        g5VarI.a(adLoadingPhaseType, null);
        this.d.a(adResponse, new b(), new a(this, context, adResponse));
    }

    private final class b implements v91.b {
        @Override // com.yandex.mobile.ads.impl.v91.b
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            if (((fw1) fw1.this).j) {
                return;
            }
            ((fw1) fw1.this).i = null;
            ((fw1) fw1.this).f8939a.b(adRequestError);
        }

        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.v91.b
        public final void a(m61 nativeAdPrivate) {
            Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
            if (((fw1) fw1.this).j) {
                return;
            }
            ((fw1) fw1.this).i = nativeAdPrivate;
            ((fw1) fw1.this).f8939a.u();
        }
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final Object a(T contentController, Activity activity) {
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Result.Companion companion = Result.INSTANCE;
        Object objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(r6.a()));
        o8<String> o8Var = this.h;
        m61 m61Var = this.i;
        if (o8Var == null || m61Var == null) {
            return objM7904constructorimpl;
        }
        Object objA = this.g.a(activity, new c1(new c1.a(o8Var, this.e, contentController.i()).a(this.e.o()).a(m61Var)));
        this.h = null;
        this.i = null;
        return objA;
    }
}
