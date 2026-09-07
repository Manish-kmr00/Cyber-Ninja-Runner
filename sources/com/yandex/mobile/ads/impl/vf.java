package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class vf implements qd0<uf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10475a;

    public vf(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10475a = context;
    }

    @Override // com.yandex.mobile.ads.impl.qd0
    public final wd0 a(o8 adResponse, o3 adConfiguration, zc0 fullScreenController) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        return new uf(this.f10475a, adResponse, adConfiguration, new sc0(), new pg0(), fullScreenController);
    }
}
