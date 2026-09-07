package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class yy1 implements Comparable<yy1> {
    private final int b;
    private final int c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yy1)) {
            return false;
        }
        yy1 yy1Var = (yy1) obj;
        return this.b == yy1Var.b && this.c == yy1Var.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + (Integer.hashCode(this.b) * 31);
    }

    public final String toString() {
        return "Size(width=" + this.b + ", height=" + this.c + ")";
    }

    public yy1(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(yy1 yy1Var) {
        yy1 other = yy1Var;
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.b * this.c, other.b * other.c);
    }

    public final int b() {
        return this.b;
    }

    public final int a() {
        return this.c;
    }
}
