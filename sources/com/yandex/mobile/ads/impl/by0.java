package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class by0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uq f8546a;
    private final e81 b;

    public final ip1 a(o8<?> o8Var, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        if ((o8Var != null ? o8Var.v() : null) != fs.c) {
            return this.f8546a.a(o8Var, adConfiguration);
        }
        Object objI = o8Var.I();
        return this.b.a(o8Var, adConfiguration, objI instanceof u61 ? (u61) objI : null);
    }

    public /* synthetic */ by0() {
        this(new uq(), new r71());
    }

    public by0(uq commonReportDataProvider, e81 nativeCommonReportDataProvider) {
        Intrinsics.checkNotNullParameter(commonReportDataProvider, "commonReportDataProvider");
        Intrinsics.checkNotNullParameter(nativeCommonReportDataProvider, "nativeCommonReportDataProvider");
        this.f8546a = commonReportDataProvider;
        this.b = nativeCommonReportDataProvider;
    }
}
