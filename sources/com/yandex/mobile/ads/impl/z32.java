package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private au f10787a;

    /* JADX WARN: Code duplicated, block: B:7:0x002f  */
    public final y32 a(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, o8<?> adResponse, t8 receiver) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        au auVar = this.f10787a;
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA != null) {
            z = cu1VarA.s();
        }
        if (auVar != null && z) {
            return new iv(auVar, receiver, new Handler(Looper.getMainLooper()));
        }
        t1 t1Var = new t1(sdkEnvironmentModule);
        int i2 = m50.e;
        return new wy(context, t1Var, adResponse, receiver, sdkEnvironmentModule, m50.a.a(context), adConfiguration);
    }

    public final void a(com.yandex.mobile.ads.nativeads.c cVar) {
        this.f10787a = cVar;
    }
}
