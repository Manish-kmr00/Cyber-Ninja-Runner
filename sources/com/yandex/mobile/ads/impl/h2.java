package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d2 f9052a;
    private final k2 b;
    private final j2 c;

    public /* synthetic */ h2(Context context) {
        this(context, new d2(context), new k2(context), new j2(context));
    }

    public h2(Context context, d2 adBlockerDetectorHttpUsageChecker, k2 adBlockerStateProvider, j2 adBlockerStateExpiredValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBlockerDetectorHttpUsageChecker, "adBlockerDetectorHttpUsageChecker");
        Intrinsics.checkNotNullParameter(adBlockerStateProvider, "adBlockerStateProvider");
        Intrinsics.checkNotNullParameter(adBlockerStateExpiredValidator, "adBlockerStateExpiredValidator");
        this.f9052a = adBlockerDetectorHttpUsageChecker;
        this.b = adBlockerStateProvider;
        this.c = adBlockerStateExpiredValidator;
    }

    public final g2 a() {
        i2 i2VarA = this.b.a();
        if (!this.c.a(i2VarA)) {
            return null;
        }
        if (this.f9052a.a(i2VarA)) {
            return g2.c;
        }
        return g2.b;
    }
}
