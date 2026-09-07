package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x91 implements dk.a<u61> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e81 f10632a;

    @Override // com.yandex.mobile.ads.impl.dk.a
    public final ip1 a(qq1<o8<u61>> qq1Var, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        o8<u61> o8Var = qq1Var != null ? qq1Var.f10044a : null;
        return this.f10632a.a(o8Var, adConfiguration, o8Var != null ? o8Var.I() : null);
    }

    public /* synthetic */ x91() {
        this(new r71());
    }

    public x91(e81 nativeCommonReportDataProvider) {
        Intrinsics.checkNotNullParameter(nativeCommonReportDataProvider, "nativeCommonReportDataProvider");
        this.f10632a = nativeCommonReportDataProvider;
    }
}
