package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fm {
    private int b;

    public final void c() {
        this.b &= Integer.MAX_VALUE;
    }

    public final boolean e() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean f() {
        return c(4);
    }

    public final boolean g() {
        return c(1);
    }

    public final boolean d() {
        return c(268435456);
    }

    public final void b(int i) {
        this.b = i | this.b;
    }

    protected final boolean c(int i) {
        return (this.b & i) == i;
    }

    public void b() {
        this.b = 0;
    }

    public final void d(int i) {
        this.b = i;
    }
}
