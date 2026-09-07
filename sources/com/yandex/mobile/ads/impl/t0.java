package com.yandex.mobile.ads.impl;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10251a;
    private final o8<?> b;

    public final c1 a(Intent resultActivityIntent) {
        Intrinsics.checkNotNullParameter(resultActivityIntent, "resultActivityIntent");
        return new c1(new c1.a(this.b, this.f10251a, new t8()).a(resultActivityIntent));
    }

    public t0(o8 adResponse, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10251a = adConfiguration;
        this.b = adResponse;
    }
}
