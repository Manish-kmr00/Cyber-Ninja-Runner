package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fe implements ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f8886a;
    private final fu1 b;
    private final k2 c;
    private final Context d;

    public fe(Context context, iw1 sdkSettings, fu1 sdkConfigurationExpiredDateValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(sdkConfigurationExpiredDateValidator, "sdkConfigurationExpiredDateValidator");
        this.f8886a = sdkSettings;
        this.b = sdkConfigurationExpiredDateValidator;
        this.c = new k2(context);
        this.d = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.ee
    public final boolean a() {
        if (!this.c.a().d()) {
            return false;
        }
        iw1 iw1Var = this.f8886a;
        Context context = this.d;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cu1 cu1VarA = iw1Var.a(context);
        if (cu1VarA != null) {
            boolean z = cu1VarA.d() != null;
            boolean zA = this.b.a(cu1VarA);
            if ((cu1VarA.U() && !zA) || z) {
                return false;
            }
        }
        return true;
    }
}
