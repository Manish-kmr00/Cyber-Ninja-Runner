package com.yandex.mobile.ads.impl;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vf1 f10157a;
    private final wf1 b;
    private final String c;
    private String d;
    private t52 e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private gc0 j;
    private int k;
    private long l;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    public s() {
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
                            this.h = wf1Var.t() == 11;
                        } else {
                            int iT = wf1Var.t();
                            if (iT == 119) {
                                this.h = false;
                                this.f = 1;
                                this.b.c()[0] = Ascii.VT;
                                this.b.c()[1] = 119;
                                this.g = 2;
                                break;
                            }
                            this.h = iT == 11;
                        }
                    }
                } else if (i == 1) {
                    byte[] bArrC = this.b.c();
                    int iMin = Math.min(wf1Var.a(), 128 - this.g);
                    wf1Var.a(bArrC, this.g, iMin);
                    int i2 = this.g + iMin;
                    this.g = i2;
                    if (i2 == 128) {
                        this.f10157a.c(0);
                        t.a aVarA = t.a(this.f10157a);
                        gc0 gc0Var = this.j;
                        if (gc0Var == null || aVarA.c != gc0Var.z || aVarA.b != gc0Var.A || !x82.a(aVarA.f10250a, gc0Var.m)) {
                            gc0 gc0VarA = new gc0.a().b(this.d).e(aVarA.f10250a).c(aVarA.c).l(aVarA.b).d(this.c).a();
                            this.j = gc0VarA;
                            this.e.a(gc0VarA);
                        }
                        this.k = aVarA.d;
                        this.i = (((long) aVarA.e) * 1000000) / ((long) this.j.A);
                        this.b.e(0);
                        this.e.a(128, this.b);
                        this.f = 2;
                    }
                } else if (i == 2) {
                    int iMin2 = Math.min(wf1Var.a(), this.k - this.g);
                    this.e.a(iMin2, wf1Var);
                    int i3 = this.g + iMin2;
                    this.g = i3;
                    int i4 = this.k;
                    if (i3 == i4) {
                        long j = this.l;
                        if (j != -9223372036854775807L) {
                            this.e.a(j, 1, i4, 0, null);
                            this.l += this.i;
                        }
                        this.f = 0;
                    }
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    public s(String str) {
        byte[] bArr = new byte[128];
        this.f10157a = new vf1(bArr);
        this.b = new wf1(bArr);
        this.f = 0;
        this.l = -9223372036854775807L;
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
            this.l = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }
}
