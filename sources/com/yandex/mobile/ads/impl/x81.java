package com.yandex.mobile.ads.impl;

import com.adjust.sdk.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f10628a;
    private final zq1 b;

    public x81(ot adAssets, zq1 responseNativeType) {
        Intrinsics.checkNotNullParameter(adAssets, "adAssets");
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        this.f10628a = adAssets;
        this.b = responseNativeType;
    }

    public static boolean a(qt image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return Intrinsics.areEqual(Constants.LARGE, image.c()) || Intrinsics.areEqual("wide", image.c());
    }

    public final boolean a() {
        return (b() || this.f10628a.e() == null || !(d() || this.f10628a.h() == null || a(this.f10628a.h()))) ? false : true;
    }

    public final boolean b() {
        return this.f10628a.g() != null && (zq1.d == this.b || !e());
    }

    public final boolean e() {
        return (d() || this.f10628a.h() == null || a(this.f10628a.h()) || zq1.d == this.b) ? false : true;
    }

    public final boolean c() {
        return (d() || this.f10628a.h() == null || !a(this.f10628a.h())) ? false : true;
    }

    public final boolean d() {
        return this.f10628a.i() != null;
    }
}
