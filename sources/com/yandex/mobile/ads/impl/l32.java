package com.yandex.mobile.ads.impl;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class l32 extends py implements g32 {
    private g32 d;
    private long e;

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        g32 g32Var = this.d;
        g32Var.getClass();
        return g32Var.a(i) + this.e;
    }

    @Override // com.yandex.mobile.ads.impl.fm
    public final void b() {
        super.b();
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        g32 g32Var = this.d;
        g32Var.getClass();
        return g32Var.a();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        g32 g32Var = this.d;
        g32Var.getClass();
        return g32Var.b(j - this.e);
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        g32 g32Var = this.d;
        g32Var.getClass();
        return g32Var.a(j - this.e);
    }

    public final void a(long j, g32 g32Var, long j2) {
        this.c = j;
        this.d = g32Var;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.e = j;
    }
}
