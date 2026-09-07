package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final va f10361a;
    private final sa b;

    public u7(va adVisibilityValidator, sa adViewRenderingValidator) {
        Intrinsics.checkNotNullParameter(adVisibilityValidator, "adVisibilityValidator");
        Intrinsics.checkNotNullParameter(adViewRenderingValidator, "adViewRenderingValidator");
        this.f10361a = adVisibilityValidator;
        this.b = adViewRenderingValidator;
    }

    public final boolean a() {
        return this.f10361a.a() && this.b.a();
    }
}
