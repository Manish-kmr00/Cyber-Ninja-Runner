package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class uj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10391a;
    private final int b;
    private final String c;
    private final String d;
    private final k02 e;
    private final boolean f;
    private final String g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uj0)) {
            return false;
        }
        uj0 uj0Var = (uj0) obj;
        return this.f10391a == uj0Var.f10391a && this.b == uj0Var.b && Intrinsics.areEqual(this.c, uj0Var.c) && Intrinsics.areEqual(this.d, uj0Var.d) && Intrinsics.areEqual(this.e, uj0Var.e) && this.f == uj0Var.f && Intrinsics.areEqual(this.g, uj0Var.g);
    }

    public final int hashCode() {
        int iA = v3.a(this.c, wx1.a(this.b, Integer.hashCode(this.f10391a) * 31, 31), 31);
        String str = this.d;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        k02 k02Var = this.e;
        int iA2 = a7.a(this.f, (iHashCode + (k02Var == null ? 0 : k02Var.hashCode())) * 31, 31);
        String str2 = this.g;
        return iA2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "ImageValue(width=" + this.f10391a + ", height=" + this.b + ", url=" + this.c + ", sizeType=" + this.d + ", smartCenterSettings=" + this.e + ", preload=" + this.f + ", preview=" + this.g + ")";
    }

    public /* synthetic */ uj0(int i, int i2, String str, String str2, int i3) {
        this(i, i2, str, (i3 & 8) != 0 ? null : str2, null, true, null);
    }

    public uj0(int i, int i2, String url, String str, k02 k02Var, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f10391a = i;
        this.b = i2;
        this.c = url;
        this.d = str;
        this.e = k02Var;
        this.f = z;
        this.g = str2;
    }

    public final int g() {
        return this.f10391a;
    }

    public final int a() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final k02 e() {
        return this.e;
    }

    public final boolean b() {
        return this.f;
    }

    public final String c() {
        return this.g;
    }
}
