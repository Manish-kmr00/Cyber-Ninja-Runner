package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yi implements t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10738a;
    private final i5 b;
    private vs c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(yi this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vs vsVar = this$0.c;
        if (vsVar != null) {
            vsVar.onAdLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(yi this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vs vsVar = this$0.c;
        if (vsVar != null) {
            vsVar.onAdClicked();
            vsVar.onLeftApplication();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(yi this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vs vsVar = this$0.c;
        if (vsVar != null) {
            vsVar.onReturnedToApplication();
        }
    }

    public /* synthetic */ yi(Context context, o3 o3Var, g5 g5Var) {
        this(context, o3Var, g5Var, new Handler(Looper.getMainLooper()), new i5(context, o3Var, g5Var));
    }

    public yi(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, Handler handler, i5 adLoadingResultReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adLoadingResultReporter, "adLoadingResultReporter");
        this.f10738a = handler;
        this.b = adLoadingResultReporter;
    }

    @Override // com.yandex.mobile.ads.impl.t3
    public final void onAdLoaded() {
        this.b.a();
        this.f10738a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.yi$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                yi.b(this.f$0);
            }
        });
    }

    public final void a() {
        this.f10738a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.yi$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                yi.a(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(yi this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vs vsVar = this$0.c;
        if (vsVar != null) {
            vsVar.closeBannerAd();
        }
    }

    public final void c() {
        this.f10738a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.yi$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                yi.d(this.f$0);
            }
        });
    }

    public final void b() {
        this.f10738a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.yi$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                yi.c(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.t3
    public final void a(final w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.a(error.c());
        this.f10738a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.yi$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                yi.a(this.f$0, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(yi this$0, w3 error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        vs vsVar = this$0.c;
        if (vsVar != null) {
            vsVar.a(error);
        }
    }

    public final void a(final t4 t4Var) {
        this.f10738a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.yi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                yi.a(this.f$0, t4Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(yi this$0, t4 t4Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vs vsVar = this$0.c;
        if (vsVar != null) {
            vsVar.a(t4Var);
        }
    }

    public final void a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.b.a(new y7(adConfiguration));
    }

    public final void a(vs vsVar) {
        this.c = vsVar;
        this.b.a(vsVar);
    }

    public final void a(pg0 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }
}
