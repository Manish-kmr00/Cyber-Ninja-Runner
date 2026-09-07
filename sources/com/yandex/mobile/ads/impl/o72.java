package com.yandex.mobile.ads.impl;

import android.text.Layout;

/* JADX INFO: loaded from: classes9.dex */
final class o72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9788a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private float k;
    private String l;
    private Layout.Alignment o;
    private Layout.Alignment p;
    private k42 r;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int m = -1;
    private int n = -1;
    private int q = -1;
    private float s = Float.MAX_VALUE;

    public final o72 a(o72 o72Var) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (o72Var != null) {
            if (!this.c && o72Var.c) {
                this.b = o72Var.b;
                this.c = true;
            }
            if (this.h == -1) {
                this.h = o72Var.h;
            }
            if (this.i == -1) {
                this.i = o72Var.i;
            }
            if (this.f9788a == null && (str = o72Var.f9788a) != null) {
                this.f9788a = str;
            }
            if (this.f == -1) {
                this.f = o72Var.f;
            }
            if (this.g == -1) {
                this.g = o72Var.g;
            }
            if (this.n == -1) {
                this.n = o72Var.n;
            }
            if (this.o == null && (alignment2 = o72Var.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = o72Var.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = o72Var.q;
            }
            if (this.j == -1) {
                this.j = o72Var.j;
                this.k = o72Var.k;
            }
            if (this.r == null) {
                this.r = o72Var.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = o72Var.s;
            }
            if (!this.e && o72Var.e) {
                this.d = o72Var.d;
                this.e = true;
            }
            if (this.m == -1 && (i = o72Var.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public final int k() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    public final boolean q() {
        return this.f == 1;
    }

    public final boolean r() {
        return this.g == 1;
    }

    public final String c() {
        return this.f9788a;
    }

    public final void c(int i) {
        this.j = i;
    }

    public final int b() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final void b(int i) {
        this.b = i;
        this.c = true;
    }

    public final boolean p() {
        return this.c;
    }

    public final boolean o() {
        return this.e;
    }

    public final float j() {
        return this.s;
    }

    public final int a() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final void a(int i) {
        this.d = i;
        this.e = true;
    }

    public final String f() {
        return this.l;
    }

    public final o72 c(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }

    public final int i() {
        return this.m;
    }

    public final int h() {
        return this.n;
    }

    public final Layout.Alignment l() {
        return this.o;
    }

    public final Layout.Alignment g() {
        return this.p;
    }

    public final boolean m() {
        return this.q == 1;
    }

    public final k42 n() {
        return this.r;
    }

    public final int e() {
        return this.j;
    }

    public final float d() {
        return this.k;
    }

    public final o72 a(boolean z) {
        this.h = z ? 1 : 0;
        return this;
    }

    public final o72 b(String str) {
        this.l = str;
        return this;
    }

    public final o72 a(String str) {
        this.f9788a = str;
        return this;
    }

    public final void a(float f) {
        this.k = f;
    }

    public final o72 b(boolean z) {
        this.i = z ? 1 : 0;
        return this;
    }

    public final o72 e(int i) {
        this.m = i;
        return this;
    }

    public final o72 d(int i) {
        this.n = i;
        return this;
    }

    public final o72 e(boolean z) {
        this.g = z ? 1 : 0;
        return this;
    }

    public final o72 b(float f) {
        this.s = f;
        return this;
    }

    public final o72 a(Layout.Alignment alignment) {
        this.p = alignment;
        return this;
    }

    public final o72 d(boolean z) {
        this.q = z ? 1 : 0;
        return this;
    }

    public final o72 b(Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    public final o72 a(k42 k42Var) {
        this.r = k42Var;
        return this;
    }
}
