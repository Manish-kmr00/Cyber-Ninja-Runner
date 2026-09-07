package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10686a;
    private final String b;
    private final int c;
    private final yx1 d;

    public xx1() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xx1)) {
            return false;
        }
        xx1 xx1Var = (xx1) obj;
        return this.f10686a == xx1Var.f10686a && Intrinsics.areEqual(this.b, xx1Var.b) && this.c == xx1Var.c && this.d == xx1Var.d;
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.f10686a) * 31;
        String str = this.b;
        return this.d.hashCode() + wx1.a(this.c, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    public final String toString() {
        return "ShowNotice(delay=" + this.f10686a + ", url=" + this.b + ", visibilityPercent=" + this.c + ", type=" + this.d + ")";
    }

    public /* synthetic */ xx1(int i) {
        this(0, 0L, yx1.d, null);
    }

    public final long a() {
        return this.f10686a;
    }

    public xx1(int i, long j, yx1 type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f10686a = j;
        this.b = str;
        this.c = i;
        this.d = type;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final yx1 b() {
        return this.d;
    }
}
