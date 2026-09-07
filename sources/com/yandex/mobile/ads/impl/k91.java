package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ug f9395a;

    public k91(ug assetValueProvider) {
        Intrinsics.checkNotNullParameter(assetValueProvider, "assetValueProvider");
        this.f9395a = assetValueProvider;
    }

    public final j91 a() {
        ec1 ec1Var;
        ax0 ax0VarA = this.f9395a.a();
        za1 za1Var = null;
        if (ax0VarA != null) {
            za1 za1Var2 = ax0VarA.c() != null ? new za1() : null;
            ec1Var = ax0VarA.b() != null ? new ec1() : null;
            za1Var = za1Var2;
        } else {
            ec1Var = null;
        }
        return new j91(za1Var, ec1Var);
    }
}
