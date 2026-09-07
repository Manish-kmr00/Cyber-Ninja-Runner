package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rp0 implements qd0<qp0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10130a;

    public rp0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10130a = context;
    }

    @Override // com.yandex.mobile.ads.impl.qd0
    public final wd0 a(o8 adResponse, o3 adConfiguration, zc0 fullScreenController) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        return new qp0(this.f10130a, adResponse, adConfiguration, new sc0(), new pg0(), fullScreenController);
    }
}
