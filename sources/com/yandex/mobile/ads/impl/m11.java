package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9588a = 0;

    static {
        new m11();
    }

    @JvmStatic
    public static final void b(boolean z) {
        int i = iw1.l;
        iw1.a.a().c(z);
    }

    private m11() {
    }

    @JvmStatic
    public static final void a(boolean z) {
        op0.a(z);
        dp0.a(z);
        if (z) {
            return;
        }
        int i = r11.d;
        r11.a.a().c();
        int i2 = j11.d;
        j11.a.a().c();
    }

    @JvmStatic
    public static final void a(Context context, uu1 sdkEnvironmentModule, at initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        if (new ji().a()) {
            return;
        }
        int i = z72.c;
        z72.a(context, sdkEnvironmentModule.c());
        de.a(context, sdkEnvironmentModule.c());
        new mj2(new hl1()).a();
        new ht0(context).a();
        int i2 = c11.h;
        c11.a.a(sdkEnvironmentModule).a(context, initializationListener);
    }
}
