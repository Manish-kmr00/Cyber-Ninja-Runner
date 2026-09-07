package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m50 f10567a;

    public wi0(m50 environmentController) {
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        this.f10567a = environmentController;
    }

    public final ui0 a() {
        yi0 yi0VarD = this.f10567a.d();
        return new ui0(yi0VarD.b(), yi0VarD.a(), yi0VarD.c());
    }
}
