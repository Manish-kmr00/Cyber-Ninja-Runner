package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public class C4151gn implements InterfaceC4544wi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11574a;
    public final int b;
    public int c = 0;

    public C4151gn(int i, int i2) {
        this.f11574a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.f11574a;
    }

    public final void c() {
        this.c = 0;
    }
}
