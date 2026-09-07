package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nm1 implements kd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jd0 f9743a;
    private final Handler b;
    private lt c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(nm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lt ltVar = this$0.c;
        if (ltVar != null) {
            ltVar.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(nm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lt ltVar = this$0.c;
        if (ltVar != null) {
            ltVar.onAdDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(nm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lt ltVar = this$0.c;
        if (ltVar != null) {
            ltVar.onAdShown();
        }
        jd0 jd0Var = this$0.f9743a;
        if (jd0Var != null) {
            jd0Var.onAdShown();
        }
    }

    public /* synthetic */ nm1(jd0 jd0Var) {
        this(jd0Var, new Handler(Looper.getMainLooper()));
    }

    public nm1(jd0 jd0Var, Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9743a = jd0Var;
        this.b = handler;
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdDismissed() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nm1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                nm1.b(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdShown() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nm1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                nm1.c(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdClicked() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nm1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                nm1.a(this.f$0);
            }
        });
    }

    public final void a(final q6 adPresentationError) {
        Intrinsics.checkNotNullParameter(adPresentationError, "adPresentationError");
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nm1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                nm1.a(adPresentationError, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(q6 adPresentationError, nm1 this$0) {
        Intrinsics.checkNotNullParameter(adPresentationError, "$adPresentationError");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dy1 dy1Var = new dy1(adPresentationError.a());
        lt ltVar = this$0.c;
        if (ltVar != null) {
            ltVar.a(dy1Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void a(final t4 t4Var) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nm1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                nm1.a(this.f$0, t4Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(nm1 this$0, t4 t4Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lt ltVar = this$0.c;
        if (ltVar != null) {
            ltVar.a(t4Var);
        }
    }

    public final void a(fm2 fm2Var) {
        this.c = fm2Var;
    }
}
