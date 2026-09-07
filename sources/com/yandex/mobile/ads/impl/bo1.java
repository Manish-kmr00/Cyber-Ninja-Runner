package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.amazon.device.ads.DtbConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i10 f8526a;
    private final Context b;

    public /* synthetic */ bo1(Context context) {
        this(context, new i10());
    }

    public bo1(Context context, i10 deviceTypeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceTypeProvider, "deviceTypeProvider");
        this.f8526a = deviceTypeProvider;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
    }

    public final bw0 a() {
        if (h10.d == this.f8526a.a(this.b)) {
            return new bw0(1920, 1080, 6800);
        }
        return new bw0(854, DtbConstants.DEFAULT_PLAYER_HEIGHT, 1000);
    }
}
