package com.yandex.mobile.ads.impl;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8510a;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ bh1(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, applicationContext);
    }

    public final zg1 a() {
        Object systemService = this.f8510a.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        Boolean boolValueOf = powerManager != null ? Boolean.valueOf(powerManager.isInteractive()) : null;
        if (boolValueOf != null && !boolValueOf.booleanValue()) {
            return zg1.c;
        }
        Object systemService2 = this.f8510a.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService2 instanceof KeyguardManager ? (KeyguardManager) systemService2 : null;
        return (keyguardManager == null || !keyguardManager.isKeyguardLocked()) ? zg1.d : zg1.b;
    }

    public bh1(Context context, Context appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.f8510a = appContext;
    }
}
