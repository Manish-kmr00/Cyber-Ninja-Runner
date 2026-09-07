package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x7 f8772a = new x7();

    static {
        TimeUnit.SECONDS.toMillis(10L);
    }

    public final j00 a(Context context, int i) {
        Integer numG;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8772a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return new j00(1.0f, i, (cu1VarA == null || (numG = cu1VarA.g()) == null) ? 0 : numG.intValue());
    }
}
