package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class q10 {
    private static final q10 e = new q10(0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9972a;
    private final float b;
    private final float c;
    private final float d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q10)) {
            return false;
        }
        q10 q10Var = (q10) obj;
        return Float.compare(this.f9972a, q10Var.f9972a) == 0 && Float.compare(this.b, q10Var.b) == 0 && Float.compare(this.c, q10Var.c) == 0 && Float.compare(this.d, q10Var.d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + ((Float.hashCode(this.c) + ((Float.hashCode(this.b) + (Float.hashCode(this.f9972a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DisplayInsetsF(left=" + this.f9972a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ")";
    }

    public q10(float f, float f2, float f3, float f4) {
        this.f9972a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final float c() {
        return this.f9972a;
    }

    public final float e() {
        return this.b;
    }

    public final float d() {
        return this.c;
    }

    public final float b() {
        return this.d;
    }
}
