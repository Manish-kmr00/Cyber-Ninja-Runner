package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class lu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fu1 f9569a;
    private final qw1 b;
    private final qr c;

    public final boolean a(cu1 sdkConfiguration) {
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        if (!this.f9569a.a(sdkConfiguration)) {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
            if (Intrinsics.areEqual("7.12.1", sdkConfiguration.J())) {
                this.c.getClass();
                Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
                int i = iw1.l;
                if (Intrinsics.areEqual(iw1.a.a().j(), sdkConfiguration.z0())) {
                    this.c.getClass();
                    Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
                    if (iw1.a.a().d() == sdkConfiguration.l0()) {
                        this.c.getClass();
                        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
                        if (Intrinsics.areEqual(iw1.a.a().f(), sdkConfiguration.T())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public /* synthetic */ lu1() {
        this(new fu1(), new qw1());
    }

    public lu1(fu1 sdkConfigurationExpiredDateValidator, qw1 sdkVersionUpdateValidator) {
        Intrinsics.checkNotNullParameter(sdkConfigurationExpiredDateValidator, "sdkConfigurationExpiredDateValidator");
        Intrinsics.checkNotNullParameter(sdkVersionUpdateValidator, "sdkVersionUpdateValidator");
        this.f9569a = sdkConfigurationExpiredDateValidator;
        this.b = sdkVersionUpdateValidator;
        this.c = new qr();
    }
}
