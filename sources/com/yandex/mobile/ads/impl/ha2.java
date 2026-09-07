package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ha2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn1 f9078a;
    private final fq b;
    private final dx1 c;

    public /* synthetic */ ha2() {
        cn1 cn1Var = new cn1();
        up1 up1Var = new up1();
        this(cn1Var, up1Var, new fq(up1Var), new dx1());
    }

    public ha2(cn1 randomGenerator, up1 requestHelper, fq cmpRequestConfigurator, dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        Intrinsics.checkNotNullParameter(requestHelper, "requestHelper");
        Intrinsics.checkNotNullParameter(cmpRequestConfigurator, "cmpRequestConfigurator");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        this.f9078a = randomGenerator;
        this.b = cmpRequestConfigurator;
        this.c = sensitiveModeChecker;
    }
}
