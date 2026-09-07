package com.five_corp.ad.internal.layouter;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1419a;
    public final int b;
    public final int c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public h(int i, int i2, int i3, float f, boolean z, boolean z2, boolean z3) {
        this.f1419a = i;
        this.c = i2;
        this.b = i3;
        this.d = f;
        this.e = z;
        this.f = z2;
        this.g = z3;
    }

    public static h a(int i, int i2, boolean z, boolean z2, boolean z3) {
        int iMin;
        float f;
        int i3;
        float f2;
        if (z) {
            f2 = 1.0f;
            i3 = i2;
        } else {
            if (i2 <= 0) {
                iMin = 0;
                f = 0.0f;
            } else {
                iMin = Math.min(i, i2);
                f = iMin / i2;
            }
            i3 = iMin;
            f2 = f;
        }
        return new h(i3, i2, i2 - i3, f2, z, z2, z3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1419a == hVar.f1419a && this.c == hVar.c && this.e == hVar.e && this.f == hVar.f && this.g == hVar.g;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.g) + ((Boolean.hashCode(this.f) + ((Boolean.hashCode(this.e) + (((this.f1419a * 13) + this.c) * 13)) * 13)) * 13);
    }
}
