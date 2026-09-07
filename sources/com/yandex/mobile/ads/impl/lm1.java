package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class lm1 implements kd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jd0 f9539a;
    private final Handler b;
    private ss c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ss ssVar = this$0.c;
        if (ssVar != null) {
            ssVar.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ss ssVar = this$0.c;
        if (ssVar != null) {
            ssVar.onAdDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(lm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ss ssVar = this$0.c;
        if (ssVar != null) {
            ssVar.onAdShown();
        }
        jd0 jd0Var = this$0.f9539a;
        if (jd0Var != null) {
            jd0Var.onAdShown();
        }
    }

    public /* synthetic */ lm1(jd0 jd0Var) {
        this(jd0Var, new Handler(Looper.getMainLooper()));
    }

    public lm1(jd0 jd0Var, Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9539a = jd0Var;
        this.b = handler;
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdDismissed() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lm1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                lm1.b(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdShown() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lm1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                lm1.c(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdClicked() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lm1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                lm1.a(this.f$0);
            }
        });
    }

    public final void a(final q6 adPresentationError) {
        Intrinsics.checkNotNullParameter(adPresentationError, "adPresentationError");
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lm1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                lm1.a(adPresentationError, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(q6 adPresentationError, lm1 this$0) {
        Intrinsics.checkNotNullParameter(adPresentationError, "$adPresentationError");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dy1 dy1Var = new dy1(adPresentationError.a());
        ss ssVar = this$0.c;
        if (ssVar != null) {
            ssVar.a(dy1Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void a(final t4 t4Var) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lm1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                lm1.a(this.f$0, t4Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lm1 this$0, t4 t4Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ss ssVar = this$0.c;
        if (ssVar != null) {
            ssVar.a(t4Var);
        }
    }

    public final void a(il2 il2Var) {
        this.c = il2Var;
    }
}
