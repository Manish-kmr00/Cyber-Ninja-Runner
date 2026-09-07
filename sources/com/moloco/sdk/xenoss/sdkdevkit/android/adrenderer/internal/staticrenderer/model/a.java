package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6684a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f6684a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public final int a() {
        return this.f6684a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6684a == aVar.f6684a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f6684a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public final int i() {
        return this.f6684a;
    }

    public final int j() {
        return this.b;
    }

    public final int k() {
        return this.c;
    }

    public final int l() {
        return this.d;
    }

    public String toString() {
        return "BannerAdTouch(viewPositionX=" + this.f6684a + ", viewPositionY=" + this.b + ", viewSizeHeight=" + this.c + ", viewSizeWidth=" + this.d + ", touchX=" + this.e + ", touchY=" + this.f + ')';
    }

    public final a a(int i, int i2, int i3, int i4, int i5, int i6) {
        return new a(i, i2, i3, i4, i5, i6);
    }

    public static /* synthetic */ a a(a aVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = aVar.f6684a;
        }
        if ((i7 & 2) != 0) {
            i2 = aVar.b;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = aVar.c;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = aVar.d;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = aVar.e;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = aVar.f;
        }
        return aVar.a(i, i8, i9, i10, i11, i6);
    }
}
