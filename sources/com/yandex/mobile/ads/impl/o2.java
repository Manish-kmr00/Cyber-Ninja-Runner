package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o2 {
    private static final long c = TimeUnit.HOURS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f9772a;
    private final Context b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o2(Context context) {
        this(context, iw1.a.a());
        int i = iw1.l;
    }

    public final long a() {
        cu1 cu1VarA = this.f9772a.a(this.b);
        Long lC = cu1VarA != null ? cu1VarA.c() : null;
        return lC != null ? lC.longValue() : c;
    }

    public o2(Context context, iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f9772a = sdkSettings;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
    }
}
