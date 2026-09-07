package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.f3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4106f3 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProductInfo f11542a;
    public final /* synthetic */ C4131g3 b;

    public C4106f3(C4131g3 c4131g3, ProductInfo productInfo) {
        this.b = c4131g3;
        this.f11542a = productInfo;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C4131g3 c4131g3 = this.b;
        Wa wa = c4131g3.f11561a;
        ProductInfo productInfo = this.f11542a;
        c4131g3.getClass();
        ((C4282m5) wa).a(C3984a6.a(new C4466tf(productInfo)));
    }
}
