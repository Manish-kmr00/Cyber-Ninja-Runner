package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import com.yandex.mobile.ads.impl.wd0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class yu1<T extends wd0<T>> implements zc0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd0<T> f10770a;
    private final qt1 b;
    private final cv1<zu1> c;
    private zu1 d;

    public /* synthetic */ yu1(gd0 gd0Var, uu1 uu1Var) {
        o3 o3VarF = gd0Var.f();
        rd0 rd0Var = new rd0();
        av1 av1Var = new av1(gd0Var.l(), uu1Var, o3VarF);
        this(gd0Var, uu1Var, o3VarF, rd0Var, av1Var, new qt1(o3VarF), new cv1(o3VarF, rd0Var, av1Var));
    }

    public yu1(gd0<T> loadController, uu1 sdkEnvironmentModule, o3 adConfiguration, rd0 fullscreenAdSizeValidator, av1 fullscreenHtmlAdCreateController, qt1 sdkAdapterReporter, cv1<zu1> htmlAdCreationHandler) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullscreenAdSizeValidator, "fullscreenAdSizeValidator");
        Intrinsics.checkNotNullParameter(fullscreenHtmlAdCreateController, "fullscreenHtmlAdCreateController");
        Intrinsics.checkNotNullParameter(sdkAdapterReporter, "sdkAdapterReporter");
        Intrinsics.checkNotNullParameter(htmlAdCreationHandler, "htmlAdCreationHandler");
        this.f10770a = loadController;
        this.b = sdkAdapterReporter;
        this.c = htmlAdCreationHandler;
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final String getAdInfo() {
        zu1 zu1Var = this.d;
        if (zu1Var != null) {
            return zu1Var.e();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        op0.d(new Object[0]);
        this.c.a();
        zu1 zu1Var = this.d;
        if (zu1Var != null) {
            zu1Var.d();
        }
        this.d = null;
    }

    public final class a implements dv1<zu1> {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.dv1
        public final void a(zu1 zu1Var) {
            zu1 ad = zu1Var;
            Intrinsics.checkNotNullParameter(ad, "ad");
            ((yu1) yu1.this).d = ad;
            ((yu1) yu1.this).f10770a.u();
        }

        @Override // com.yandex.mobile.ads.impl.dv1
        public final void a(w3 adFetchRequestError) {
            Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
            ((yu1) yu1.this).f10770a.b(adFetchRequestError);
        }
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        g5 g5VarI = this.f10770a.i();
        f5 f5Var = f5.c;
        ak.a(g5VarI, f5Var, "adLoadingPhaseType", f5Var, null);
        this.b.a(context, adResponse, (p71) null);
        this.b.a(context, adResponse);
        this.c.a(context, adResponse, new a());
    }

    @Override // com.yandex.mobile.ads.impl.zc0
    public final Object a(T contentController, Activity activity) {
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Result.Companion companion = Result.INSTANCE;
        Object objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(r6.a()));
        zu1 zu1Var = this.d;
        if (zu1Var == null) {
            return objM7904constructorimpl;
        }
        Object objA = zu1Var.a(activity, contentController.i());
        this.d = null;
        return objA;
    }
}
