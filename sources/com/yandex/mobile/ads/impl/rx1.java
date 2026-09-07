package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10151a;
    private final Long b;
    private final boolean c;
    private final boolean d;
    private final yy1 e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rx1)) {
            return false;
        }
        rx1 rx1Var = (rx1) obj;
        return Intrinsics.areEqual(this.f10151a, rx1Var.f10151a) && Intrinsics.areEqual(this.b, rx1Var.b) && this.c == rx1Var.c && this.d == rx1Var.d && Intrinsics.areEqual(this.e, rx1Var.e);
    }

    public final int hashCode() {
        String str = this.f10151a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.b;
        int iA = a7.a(this.d, a7.a(this.c, (iHashCode + (l == null ? 0 : l.hashCode())) * 31, 31), 31);
        yy1 yy1Var = this.e;
        return iA + (yy1Var != null ? yy1Var.hashCode() : 0);
    }

    public final String toString() {
        return "Settings(templateType=" + this.f10151a + ", multiBannerAutoScrollInterval=" + this.b + ", isHighlightingEnabled=" + this.c + ", isLoopingVideo=" + this.d + ", mediaAssetImageFallbackSize=" + this.e + ")";
    }

    public rx1(String str, Long l, boolean z, boolean z2, yy1 yy1Var) {
        this.f10151a = str;
        this.b = l;
        this.c = z;
        this.d = z2;
        this.e = yy1Var;
    }

    public final Long b() {
        return this.b;
    }

    public final boolean c() {
        return this.d;
    }

    public final yy1 a() {
        return this.e;
    }
}
