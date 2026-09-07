package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
public final class v implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vf1 f10438a;
    private final wf1 b;
    private final String c;
    private String d;
    private t52 e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private gc0 k;
    private int l;
    private long m;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    public v() {
        this(null);
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        if (this.e != null) {
            while (wf1Var.a() > 0) {
                int i = this.f;
                if (i == 0) {
                    while (wf1Var.a() > 0) {
                        if (!this.h) {
                            this.h = wf1Var.t() == 172;
                        } else {
                            int iT = wf1Var.t();
                            this.h = iT == 172;
                            if (iT == 64 || iT == 65) {
                                this.i = iT == 65;
                                this.f = 1;
                                this.b.c()[0] = -84;
                                this.b.c()[1] = (byte) (this.i ? 65 : 64);
                                this.g = 2;
                                break;
                            }
                        }
                    }
                } else if (i == 1) {
                    byte[] bArrC = this.b.c();
                    int iMin = Math.min(wf1Var.a(), 16 - this.g);
                    wf1Var.a(bArrC, this.g, iMin);
                    int i2 = this.g + iMin;
                    this.g = i2;
                    if (i2 == 16) {
                        this.f10438a.c(0);
                        w.a aVarA = w.a(this.f10438a);
                        gc0 gc0Var = this.k;
                        if (gc0Var == null || 2 != gc0Var.z || aVarA.f10522a != gc0Var.A || !"audio/ac4".equals(gc0Var.m)) {
                            gc0 gc0VarA = new gc0.a().b(this.d).e("audio/ac4").c(2).l(aVarA.f10522a).d(this.c).a();
                            this.k = gc0VarA;
                            this.e.a(gc0VarA);
                        }
                        this.l = aVarA.b;
                        this.j = (((long) aVarA.c) * 1000000) / ((long) this.k.A);
                        this.b.e(0);
                        this.e.a(16, this.b);
                        this.f = 2;
                    }
                } else if (i == 2) {
                    int iMin2 = Math.min(wf1Var.a(), this.l - this.g);
                    this.e.a(iMin2, wf1Var);
                    int i3 = this.g + iMin2;
                    this.g = i3;
                    int i4 = this.l;
                    if (i3 == i4) {
                        long j = this.m;
                        if (j != -9223372036854775807L) {
                            this.e.a(j, 1, i4, 0, null);
                            this.m += this.j;
                        }
                        this.f = 0;
                    }
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    public v(String str) {
        byte[] bArr = new byte[16];
        this.f10438a = new vf1(bArr);
        this.b = new wf1(bArr);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
        this.c = str;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = y70Var.a(dVar.c(), 1);
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
    }
}
