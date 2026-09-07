package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class ac0 implements w70 {
    private y70 f;
    private boolean h;
    private long i;
    private int j;
    private int k;
    private int l;
    private long m;
    private boolean n;
    private wh o;
    private ag2 p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f8390a = new wf1(4);
    private final wf1 b = new wf1(9);
    private final wf1 c = new wf1(11);
    private final wf1 d = new wf1();
    private final lt1 e = new lt1();
    private int g = 1;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.ac0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return ac0.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.f = y70Var;
    }

    private wf1 a(tz tzVar) throws IOException {
        if (this.l > this.d.b()) {
            wf1 wf1Var = this.d;
            wf1Var.a(0, new byte[Math.max(wf1Var.b() * 2, this.l)]);
        } else {
            this.d.e(0);
        }
        this.d.d(this.l);
        tzVar.a(this.d.c(), 0, this.l, false);
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0005 A[SYNTHETIC] */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        long j;
        boolean zA;
        boolean z;
        if (this.f == null) {
            throw new IllegalStateException();
        }
        while (true) {
            int i = this.g;
            if (i == 1) {
                if (!((tz) x70Var).a(this.b.c(), 0, 9, true)) {
                    return -1;
                }
                this.b.e(0);
                this.b.f(4);
                int iT = this.b.t();
                boolean z2 = (iT & 4) != 0;
                boolean z3 = (iT & 1) != 0;
                if (z2 && this.o == null) {
                    this.o = new wh(this.f.a(8, 1));
                }
                if (z3 && this.p == null) {
                    this.p = new ag2(this.f.a(9, 2));
                }
                this.f.a();
                this.j = this.b.h() - 5;
                this.g = 2;
            } else if (i == 2) {
                ((tz) x70Var).a(this.j);
                this.j = 0;
                this.g = 3;
            } else if (i == 3) {
                if (!((tz) x70Var).a(this.c.c(), 0, 11, true)) {
                    return -1;
                }
                this.c.e(0);
                this.k = this.c.t();
                this.l = this.c.w();
                this.m = this.c.w();
                this.m = (((long) (this.c.t() << 24)) | this.m) * 1000;
                this.c.f(3);
                this.g = 4;
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                if (this.h) {
                    j = this.i + this.m;
                } else {
                    j = this.e.a() == -9223372036854775807L ? 0L : this.m;
                }
                int i2 = this.k;
                if (i2 == 8 && this.o != null) {
                    if (!this.n) {
                        this.f.a(new xw1.b(-9223372036854775807L, 0L));
                        this.n = true;
                    }
                    wh whVar = this.o;
                    wf1 wf1VarA = a((tz) x70Var);
                    whVar.a(wf1VarA);
                    zA = whVar.a(j, wf1VarA);
                } else {
                    if (i2 == 9 && this.p != null) {
                        if (!this.n) {
                            this.f.a(new xw1.b(-9223372036854775807L, 0L));
                            this.n = true;
                        }
                        ag2 ag2Var = this.p;
                        wf1 wf1VarA2 = a((tz) x70Var);
                        if (ag2Var.a(wf1VarA2) && ag2Var.a(j, wf1VarA2)) {
                            zA = true;
                            z = zA;
                        } else {
                            zA = false;
                        }
                    } else if (i2 == 18 && !this.n) {
                        lt1 lt1Var = this.e;
                        wf1 wf1VarA3 = a((tz) x70Var);
                        lt1Var.getClass();
                        zA = lt1Var.a(j, wf1VarA3);
                        long jA = this.e.a();
                        if (jA != -9223372036854775807L) {
                            this.f.a(new wk0(jA, this.e.b(), this.e.c()));
                            this.n = true;
                        }
                    } else {
                        ((tz) x70Var).a(this.l);
                        zA = false;
                        z = zA;
                    }
                    if (!this.h && zA) {
                        this.h = true;
                        this.i = this.e.a() == -9223372036854775807L ? -this.m : 0L;
                    }
                    this.j = 4;
                    this.g = 2;
                    if (z) {
                        return 0;
                    }
                }
                z = true;
                if (!this.h) {
                    this.h = true;
                    this.i = this.e.a() == -9223372036854775807L ? -this.m : 0L;
                }
                this.j = 4;
                this.g = 2;
                if (z) {
                    return 0;
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar = (tz) x70Var;
        tzVar.b(this.f8390a.c(), 0, 3, false);
        this.f8390a.e(0);
        if (this.f8390a.w() != 4607062) {
            return false;
        }
        tzVar.b(this.f8390a.c(), 0, 2, false);
        this.f8390a.e(0);
        if ((this.f8390a.z() & 250) != 0) {
            return false;
        }
        tzVar.b(this.f8390a.c(), 0, 4, false);
        this.f8390a.e(0);
        int iH = this.f8390a.h();
        tzVar.c();
        tzVar.a(false, iH);
        tzVar.b(this.f8390a.c(), 0, 4, false);
        this.f8390a.e(0);
        return this.f8390a.h() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] a() {
        return new w70[]{new ac0()};
    }
}
