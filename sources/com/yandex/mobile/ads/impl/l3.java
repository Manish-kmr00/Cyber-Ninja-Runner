package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j1 f9473a;

    public l3(v1 adActivityListener) {
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        this.f9473a = adActivityListener;
    }

    public final y1 a(o8<?> adResponse, ds1 closeVerificationController) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        if (adResponse.n() != qs.f) {
            return new pp0();
        }
        j1 j1Var = this.f9473a;
        return new lr1(j1Var, closeVerificationController, new mr1(j1Var));
    }
}
