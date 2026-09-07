package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dx1 f8611a;

    public ci(dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        this.f8611a = sensitiveModeChecker;
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zB = this.f8611a.b(context);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return (zB || cu1VarA == null || !cu1VarA.W()) ? false : true;
    }
}
