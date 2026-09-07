package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dn2 implements va2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final re1 f8716a;

    public dn2(re1 omSdkUsageValidator) {
        Intrinsics.checkNotNullParameter(omSdkUsageValidator, "omSdkUsageValidator");
        this.f8716a = omSdkUsageValidator;
    }

    @Override // com.yandex.mobile.ads.impl.va2
    public final cn2 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f8716a.a(context)) {
            return new cn2(context);
        }
        return null;
    }
}
