package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class hr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kf1 f9127a;

    public final ip1 a(o3 adConfiguration) {
        String str;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        kf1 kf1Var = this.f9127a;
        int iO = adConfiguration.o();
        kf1Var.getClass();
        if (iO != 1) {
            str = iO != 2 ? "undefined" : "landscape";
        } else {
            str = "portrait";
        }
        ip1Var.b(str, "orientation");
        return ip1Var;
    }

    public /* synthetic */ hr() {
        this(new kf1());
    }

    public hr(kf1 orientationNameProvider) {
        Intrinsics.checkNotNullParameter(orientationNameProvider, "orientationNameProvider");
        this.f9127a = orientationNameProvider;
    }
}
