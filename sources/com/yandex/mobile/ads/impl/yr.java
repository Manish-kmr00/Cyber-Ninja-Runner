package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10765a;
    private k3 b;
    private j91 c;
    private y42 d;
    private final y20 e;
    private final ul1 f;

    public yr(o8 adResponse, k3 adCompleteListener, j91 nativeMediaContent, y42 timeProviderContainer, y20 y20Var, qr0 progressListener) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.f10765a = adResponse;
        this.b = adCompleteListener;
        this.c = nativeMediaContent;
        this.d = timeProviderContainer;
        this.e = y20Var;
        this.f = progressListener;
    }

    public final vc0 a() {
        za1 za1VarA = this.c.a();
        ec1 ec1VarB = this.c.b();
        y20 y20Var = this.e;
        if (Intrinsics.areEqual(y20Var != null ? y20Var.e() : null, e10.d.a())) {
            return new m81(this.b, this.d, this.f);
        }
        if (za1VarA != null) {
            o8<?> o8Var = this.f10765a;
            return new ya1(o8Var, za1VarA, this.b, this.f, o8Var.K());
        }
        if (ec1VarB != null) {
            return new dc1(ec1VarB, this.b);
        }
        return new m81(this.b, this.d, this.f);
    }
}
