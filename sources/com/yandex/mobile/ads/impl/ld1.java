package com.yandex.mobile.ads.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ld1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tk0 f9503a;

    public final kd1 a(qk0 impressionReporter, s9 adStructureType) {
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        int iOrdinal = adStructureType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1 && iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.f9503a.getClass();
            return new l62(impressionReporter, tk0.a(adStructureType));
        }
        tk0 tk0Var = this.f9503a;
        s9 s9Var = s9.d;
        tk0Var.getClass();
        sk0 sk0VarA = tk0.a(s9Var);
        tk0 tk0Var2 = this.f9503a;
        s9 s9Var2 = s9.c;
        tk0Var2.getClass();
        return new qy1(new l62(impressionReporter, sk0VarA), new l62(impressionReporter, tk0.a(s9Var2)));
    }

    public /* synthetic */ ld1() {
        this(new tk0());
    }

    public ld1(tk0 impressionTrackingReportTypesProvider) {
        Intrinsics.checkNotNullParameter(impressionTrackingReportTypesProvider, "impressionTrackingReportTypesProvider");
        this.f9503a = impressionTrackingReportTypesProvider;
    }
}
