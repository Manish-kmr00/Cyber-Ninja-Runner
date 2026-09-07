package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pm1 implements kd0, is1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jd0 f9940a;
    private final Handler b;
    private eu c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(pm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eu euVar = this$0.c;
        if (euVar != null) {
            euVar.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(pm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eu euVar = this$0.c;
        if (euVar != null) {
            euVar.onAdDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(pm1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eu euVar = this$0.c;
        if (euVar != null) {
            euVar.onAdShown();
        }
        jd0 jd0Var = this$0.f9940a;
        if (jd0Var != null) {
            jd0Var.onAdShown();
        }
    }

    public /* synthetic */ pm1(jd0 jd0Var) {
        this(jd0Var, new Handler(Looper.getMainLooper()));
    }

    public pm1(jd0 jd0Var, Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9940a = jd0Var;
        this.b = handler;
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdDismissed() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pm1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                pm1.b(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdShown() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pm1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                pm1.c(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void onAdClicked() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pm1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                pm1.a(this.f$0);
            }
        });
    }

    public final void a(final q6 adPresentationError) {
        Intrinsics.checkNotNullParameter(adPresentationError, "adPresentationError");
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pm1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                pm1.a(adPresentationError, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(q6 adPresentationError, pm1 this$0) {
        Intrinsics.checkNotNullParameter(adPresentationError, "$adPresentationError");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dy1 dy1Var = new dy1(adPresentationError.a());
        eu euVar = this$0.c;
        if (euVar != null) {
            euVar.a(dy1Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd0
    public final void a(final t4 t4Var) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pm1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                pm1.a(this.f$0, t4Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(pm1 this$0, t4 t4Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eu euVar = this$0.c;
        if (euVar != null) {
            euVar.a(t4Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.is1
    public final void a(final hw1 reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pm1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                pm1.a(this.f$0, reward);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(pm1 this$0, or1 reward) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reward, "$reward");
        eu euVar = this$0.c;
        if (euVar != null) {
            euVar.a(reward);
        }
    }

    public final void a(um2 um2Var) {
        this.c = um2Var;
    }
}
