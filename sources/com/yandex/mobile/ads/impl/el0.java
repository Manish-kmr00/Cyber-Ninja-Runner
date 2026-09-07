package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class el0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x01 f8810a;
    private final at b;

    public el0(x01 mobileAdsExecutor, at initializationListener) {
        Intrinsics.checkNotNullParameter(mobileAdsExecutor, "mobileAdsExecutor");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        this.f8810a = mobileAdsExecutor;
        this.b = initializationListener;
    }

    public final void a() {
        this.f8810a.b(new Runnable() { // from class: com.yandex.mobile.ads.impl.el0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                el0.a(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(el0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b.onInitializationCompleted();
    }
}
