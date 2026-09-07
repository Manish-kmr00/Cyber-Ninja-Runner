package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vd f10378a;

    public /* synthetic */ ud() {
        this(new vd());
    }

    public ud(vd androidSdkApiProvider) {
        Intrinsics.checkNotNullParameter(androidSdkApiProvider, "androidSdkApiProvider");
        this.f10378a = androidSdkApiProvider;
    }

    public final boolean a() {
        this.f10378a.getClass();
        int iA = vd.a();
        this.f10378a.getClass();
        return iA >= 21;
    }
}
