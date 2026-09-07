package com.yandex.mobile.ads.impl;

import com.adjust.sdk.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f9192a;
    private final zq1 b;

    public i91(ot adAssets, zq1 responseNativeType) {
        Intrinsics.checkNotNullParameter(adAssets, "adAssets");
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        this.f9192a = adAssets;
        this.b = responseNativeType;
    }

    private final boolean b() {
        return this.f9192a.c() != null && (zq1.c == this.b || !d());
    }

    public final boolean f() {
        return this.f9192a.c() != null || d();
    }

    public final boolean h() {
        return this.f9192a.c() != null && (b() || c());
    }

    public final boolean c() {
        return this.f9192a.h() != null && (Intrinsics.areEqual(Constants.LARGE, this.f9192a.h().c()) || Intrinsics.areEqual("wide", this.f9192a.h().c()));
    }

    private final boolean d() {
        return (this.f9192a.k() == null && this.f9192a.l() == null) ? false : true;
    }

    public final boolean g() {
        return b();
    }

    public final boolean j() {
        return b() || (c() && !d());
    }

    public final boolean a() {
        return (this.f9192a.n() == null && this.f9192a.b() == null && this.f9192a.d() == null && this.f9192a.g() == null && this.f9192a.e() == null) ? false : true;
    }

    public final boolean e() {
        return (this.f9192a.a() == null && this.f9192a.m() == null && !a()) ? false : true;
    }

    public final boolean i() {
        return this.f9192a.o() != null;
    }
}
