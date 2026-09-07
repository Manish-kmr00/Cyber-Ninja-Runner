package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public final class e22 implements bv0 {
    private final hp b;
    private boolean c;
    private long d;
    private long e;
    private xh1 f = xh1.e;

    public e22(r32 r32Var) {
        this.b = r32Var;
    }

    public final void b() {
        if (this.c) {
            a(o());
            this.c = false;
        }
    }

    public final void a(long j) {
        this.d = j;
        if (this.c) {
            this.e = this.b.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final long o() {
        long jA;
        long j = this.d;
        if (!this.c) {
            return j;
        }
        long jB = this.b.b() - this.e;
        xh1 xh1Var = this.f;
        if (xh1Var.b == 1.0f) {
            jA = x82.a(jB);
        } else {
            jA = xh1Var.a(jB);
        }
        return j + jA;
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final xh1 getPlaybackParameters() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final void a(xh1 xh1Var) {
        if (this.c) {
            a(o());
        }
        this.f = xh1Var;
    }

    public final void a() {
        if (this.c) {
            return;
        }
        this.e = this.b.b();
        this.c = true;
    }
}
