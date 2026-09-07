package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f10222a;

    private static final class a implements n0 {
        @Override // com.yandex.mobile.ads.impl.n0
        public final void onReturnedToApplication() {
        }
    }

    public sn0(Context context, uu1 sdkEnvironmentModule, ru creative, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        a aVar = new a();
        uu uuVarC = creative.c();
        this.f10222a = new l0(context, adConfiguration, null, aVar, uuVarC != null ? uuVarC.a() : null);
    }

    public final void a() {
        this.f10222a.e();
    }
}
