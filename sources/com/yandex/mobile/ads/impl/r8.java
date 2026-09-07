package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r8 implements dk.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uq f10081a;

    @Override // com.yandex.mobile.ads.impl.dk.a
    public final ip1 a(qq1<o8<String>> qq1Var, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        return this.f10081a.a(qq1Var != null ? qq1Var.f10044a : null, adConfiguration);
    }

    public /* synthetic */ r8() {
        this(new uq());
    }

    public r8(uq commonReportDataProvider) {
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        this.f10081a = commonReportDataProvider;
    }
}
