package com.yandex.mobile.ads.impl;

import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public final class cm1 extends ok implements am1.b {
    private final fw0 h;
    private final fw0.f i;
    private final qv.a j;
    private final zl1.a k;
    private final f40 l;
    private final zr0 m;
    private final int n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private w62 s;

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void maybeThrowSourceInfoRefreshError() {
    }

    public static final class a implements rw0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qv.a f8626a;
        private zl1.a b;
        private g40 c;
        private zr0 d;

        public a(qv.a aVar, final a80 a80Var) {
            this(aVar, new zl1.a() { // from class: com.yandex.mobile.ads.impl.cm1$a$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.zl1.a
                public final zl1 a(ii1 ii1Var) {
                    return cm1.a.a(a80Var, ii1Var);
                }
            });
        }

        public final cm1 a(fw0 fw0Var) {
            fw0Var.c.getClass();
            Object obj = fw0Var.c.g;
            return new cm1(fw0Var, this.f8626a, this.b, this.c.a(fw0Var), this.d, 1048576);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ zl1 a(a80 a80Var, ii1 ii1Var) {
            return new mm(a80Var);
        }

        public a(qv.a aVar, zl1.a aVar2) {
            this(aVar, aVar2, new qz(), new a00());
        }

        public a(qv.a aVar, zl1.a aVar2, qz qzVar, a00 a00Var) {
            this.f8626a = aVar;
            this.b = aVar2;
            this.c = qzVar;
            this.d = a00Var;
        }
    }

    private cm1(fw0 fw0Var, qv.a aVar, zl1.a aVar2, f40 f40Var, zr0 zr0Var, int i) {
        this.i = (fw0.f) hg.a(fw0Var.c);
        this.h = fw0Var;
        this.j = aVar;
        this.k = aVar2;
        this.l = f40Var;
        this.m = zr0Var;
        this.n = i;
        this.o = true;
        this.p = -9223372036854775807L;
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final fw0 getMediaItem() {
        return this.h;
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final lw0 a(rw0.b bVar, cd cdVar, long j) {
        qv qvVarA = this.j.a();
        w62 w62Var = this.s;
        if (w62Var != null) {
            qvVarA.a(w62Var);
        }
        return new am1(this.i.f8935a, qvVarA, this.k.a(c()), this.l, a(bVar), this.m, b(bVar), this, cdVar, this.i.e, this.n);
    }

    @Override // com.yandex.mobile.ads.impl.ok
    protected final void e() {
        this.l.release();
    }

    public final void a(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.p;
        }
        if (!this.o && this.p == j && this.q == z && this.r == z2) {
            return;
        }
        this.p = j;
        this.q = z;
        this.r = z2;
        this.o = false;
        long j2 = this.p;
        vy1 vy1Var = new vy1(j2, j2, this.q, this.r, this.h);
        b52 bm1Var = vy1Var;
        if (this.o) {
            bm1Var = new bm1(vy1Var);
        }
        a(bm1Var);
    }

    @Override // com.yandex.mobile.ads.impl.ok
    protected final void a(w62 w62Var) {
        this.s = w62Var;
        this.l.prepare();
        f40 f40Var = this.l;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        f40Var.a(looperMyLooper, c());
        long j = this.p;
        vy1 vy1Var = new vy1(j, j, this.q, this.r, this.h);
        b52 bm1Var = vy1Var;
        if (this.o) {
            bm1Var = new bm1(vy1Var);
        }
        a(bm1Var);
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(lw0 lw0Var) {
        ((am1) lw0Var).i();
    }
}
