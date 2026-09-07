package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vr1 implements qd0<ur1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10503a;

    public vr1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10503a = context;
    }

    @Override // com.yandex.mobile.ads.impl.qd0
    public final wd0 a(o8 adResponse, o3 adConfiguration, zc0 fullScreenController) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        Context context = this.f10503a;
        qm1 qm1Var = new qm1();
        return new ur1(context, adResponse, adConfiguration, fullScreenController, qm1Var, new hs1(qm1Var), new pg0(), new sc0(), new qt1(adConfiguration));
    }
}
