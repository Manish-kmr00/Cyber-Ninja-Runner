package com.ogury.ad.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7292a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public e8(boolean z, int i, int i2, int i3, int i4) {
        this.f7292a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static e8 a(e8 e8Var, int i, int i2, int i3) {
        boolean z = e8Var.f7292a;
        int i4 = e8Var.b;
        int i5 = e8Var.c;
        if ((i3 & 8) != 0) {
            i = e8Var.d;
        }
        int i6 = i;
        if ((i3 & 16) != 0) {
            i2 = e8Var.e;
        }
        e8Var.getClass();
        return new e8(z, i4, i5, i6, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e8)) {
            return false;
        }
        e8 e8Var = (e8) obj;
        return this.f7292a == e8Var.f7292a && this.b == e8Var.b && this.c == e8Var.c && this.d == e8Var.d && this.e == e8Var.e;
    }

    public final int hashCode() {
        return Integer.hashCode(this.e) + ((Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (Boolean.hashCode(this.f7292a) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ResizeProps(allowOffscreen=" + this.f7292a + ", width=" + this.b + ", height=" + this.c + ", offsetX=" + this.d + ", offsetY=" + this.e + ")";
    }

    public e8() {
        this(false, 0, 0, 0, 0);
    }
}
