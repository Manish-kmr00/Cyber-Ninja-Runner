package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n51 implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9699a;
    private pt b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(n51 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pt ptVar = this$0.b;
        if (ptVar != null) {
            ptVar.onAdClicked();
        }
        pt ptVar2 = this$0.b;
        if (ptVar2 != null) {
            ptVar2.onLeftApplication();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(n51 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pt ptVar = this$0.b;
        if (ptVar != null) {
            ptVar.onReturnedToApplication();
        }
    }

    public /* synthetic */ n51() {
        this(new Handler(Looper.getMainLooper()));
    }

    public n51(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9699a = handler;
    }

    public final void a() {
        this.f9699a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.n51$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                n51.a(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(n51 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pt ptVar = this$0.b;
        if (ptVar != null) {
            ptVar.closeNativeAd();
        }
    }

    @Override // com.yandex.mobile.ads.impl.n0
    public final void onLeftApplication() {
        this.f9699a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.n51$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                n51.b(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.n0
    public final void onReturnedToApplication() {
        this.f9699a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.n51$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                n51.c(this.f$0);
            }
        });
    }

    public final void a(final t4 t4Var) {
        this.f9699a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.n51$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                n51.a(this.f$0, t4Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(n51 this$0, t4 t4Var) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pt ptVar = this$0.b;
        if (ptVar != null) {
            ptVar.a(t4Var);
        }
    }

    public final void a(pt ptVar) {
        this.b = ptVar;
    }
}
