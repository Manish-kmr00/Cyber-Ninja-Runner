package com.moloco.sdk.internal.services;

/* JADX INFO: loaded from: classes10.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6368a;
    public final float b;
    public final int c;
    public final float d;
    public final float e;
    public final int f;
    public final float g;
    public final float h;

    public e0(int i, float f, int i2, float f2, float f3, int i3, float f4, float f5) {
        this.f6368a = i;
        this.b = f;
        this.c = i2;
        this.d = f2;
        this.e = f3;
        this.f = i3;
        this.g = f4;
        this.h = f5;
    }

    public final int a() {
        return this.f6368a;
    }

    public final float b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f6368a == e0Var.f6368a && Float.compare(this.b, e0Var.b) == 0 && this.c == e0Var.c && Float.compare(this.d, e0Var.d) == 0 && Float.compare(this.e, e0Var.e) == 0 && this.f == e0Var.f && Float.compare(this.g, e0Var.g) == 0 && Float.compare(this.h, e0Var.h) == 0;
    }

    public final int f() {
        return this.f;
    }

    public final float g() {
        return this.g;
    }

    public final float h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.f6368a) * 31) + Float.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h);
    }

    public final float i() {
        return this.e;
    }

    public final int j() {
        return this.f;
    }

    public final float k() {
        return this.d;
    }

    public final int l() {
        return this.c;
    }

    public final float m() {
        return this.b;
    }

    public final int n() {
        return this.f6368a;
    }

    public final float o() {
        return this.g;
    }

    public final float p() {
        return this.h;
    }

    public String toString() {
        return "ScreenInfo(screenWidthPx=" + this.f6368a + ", screenWidthDp=" + this.b + ", screenHeightPx=" + this.c + ", screenHeightDp=" + this.d + ", density=" + this.e + ", dpi=" + this.f + ", xdpi=" + this.g + ", ydpi=" + this.h + ')';
    }

    public final e0 a(int i, float f, int i2, float f2, float f3, int i3, float f4, float f5) {
        return new e0(i, f, i2, f2, f3, i3, f4, f5);
    }
}
