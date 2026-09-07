package com.yandex.mobile.ads.impl;

import java.util.Collections;

/* JADX INFO: loaded from: classes5.dex */
public final class ar0 implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8436a;
    private final wf1 b;
    private final vf1 c;
    private t52 d;
    private String e;
    private gc0 f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    public ar0(String str) {
        this.f8436a = str;
        wf1 wf1Var = new wf1(1024);
        this.b = wf1Var;
        this.c = new vf1(wf1Var.c());
        this.k = -9223372036854775807L;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) throws ag1 {
        int i;
        boolean zF;
        if (this.d != null) {
            while (wf1Var.a() > 0) {
                int i2 = this.g;
                if (i2 != 0) {
                    if (i2 == 1) {
                        int iT = wf1Var.t();
                        if ((iT & 224) == 224) {
                            this.j = iT;
                            this.g = 2;
                        } else if (iT != 86) {
                            this.g = 0;
                        }
                    } else if (i2 == 2) {
                        int iT2 = ((this.j & (-225)) << 8) | wf1Var.t();
                        this.i = iT2;
                        if (iT2 > this.b.c().length) {
                            this.b.c(this.i);
                            vf1 vf1Var = this.c;
                            byte[] bArrC = this.b.c();
                            vf1Var.getClass();
                            vf1Var.a(bArrC.length, bArrC);
                        }
                        this.h = 0;
                        this.g = 3;
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(wf1Var.a(), this.i - this.h);
                        wf1Var.a(this.c.f10476a, this.h, iMin);
                        int i3 = this.h + iMin;
                        this.h = i3;
                        if (i3 == this.i) {
                            this.c.c(0);
                            vf1 vf1Var2 = this.c;
                            if (!vf1Var2.f()) {
                                this.l = true;
                                int iB = vf1Var2.b(1);
                                int iB2 = iB == 1 ? vf1Var2.b(1) : 0;
                                this.m = iB2;
                                if (iB2 == 0) {
                                    if (iB == 1) {
                                        vf1Var2.b((vf1Var2.b(2) + 1) * 8);
                                    }
                                    if (vf1Var2.f()) {
                                        this.n = vf1Var2.b(6);
                                        int iB3 = vf1Var2.b(4);
                                        int iB4 = vf1Var2.b(3);
                                        if (iB3 == 0 && iB4 == 0) {
                                            if (iB == 0) {
                                                int iE = vf1Var2.e();
                                                int iB5 = vf1Var2.b();
                                                e.a aVarA = e.a(vf1Var2, true);
                                                this.u = aVarA.c;
                                                this.r = aVarA.f8746a;
                                                this.t = aVarA.b;
                                                int iB6 = iB5 - vf1Var2.b();
                                                vf1Var2.c(iE);
                                                byte[] bArr = new byte[(iB6 + 7) / 8];
                                                vf1Var2.a(bArr, iB6);
                                                gc0 gc0VarA = new gc0.a().b(this.e).e("audio/mp4a-latm").a(this.u).c(this.t).l(this.r).a(Collections.singletonList(bArr)).d(this.f8436a).a();
                                                if (!gc0VarA.equals(this.f)) {
                                                    this.f = gc0VarA;
                                                    this.s = 1024000000 / ((long) gc0VarA.A);
                                                    this.d.a(gc0VarA);
                                                }
                                            } else {
                                                int iB7 = vf1Var2.b((vf1Var2.b(2) + 1) * 8);
                                                int iB8 = vf1Var2.b();
                                                e.a aVarA2 = e.a(vf1Var2, true);
                                                this.u = aVarA2.c;
                                                this.r = aVarA2.f8746a;
                                                this.t = aVarA2.b;
                                                vf1Var2.d(iB7 - (iB8 - vf1Var2.b()));
                                            }
                                            int iB9 = vf1Var2.b(3);
                                            this.o = iB9;
                                            if (iB9 == 0) {
                                                vf1Var2.d(8);
                                            } else if (iB9 == 1) {
                                                vf1Var2.d(9);
                                            } else if (iB9 == 3 || iB9 == 4 || iB9 == 5) {
                                                vf1Var2.d(6);
                                            } else {
                                                if (iB9 != 6 && iB9 != 7) {
                                                    throw new IllegalStateException();
                                                }
                                                vf1Var2.d(1);
                                            }
                                            boolean zF2 = vf1Var2.f();
                                            this.p = zF2;
                                            this.q = 0L;
                                            if (zF2) {
                                                if (iB == 1) {
                                                    this.q = vf1Var2.b((vf1Var2.b(2) + 1) * 8);
                                                } else {
                                                    do {
                                                        zF = vf1Var2.f();
                                                        this.q = (this.q << 8) + ((long) vf1Var2.b(8));
                                                    } while (zF);
                                                }
                                            }
                                            if (vf1Var2.f()) {
                                                vf1Var2.d(8);
                                            }
                                        } else {
                                            throw ag1.a((String) null, (Exception) null);
                                        }
                                    } else {
                                        throw ag1.a((String) null, (Exception) null);
                                    }
                                } else {
                                    throw ag1.a((String) null, (Exception) null);
                                }
                            } else {
                                if (this.l) {
                                }
                                this.g = 0;
                            }
                            if (this.m == 0) {
                                if (this.n == 0) {
                                    if (this.o == 0) {
                                        int i4 = 0;
                                        while (true) {
                                            int iB10 = vf1Var2.b(8);
                                            i = i4 + iB10;
                                            if (iB10 != 255) {
                                                break;
                                            } else {
                                                i4 = i;
                                            }
                                        }
                                        int iE2 = vf1Var2.e();
                                        if ((iE2 & 7) == 0) {
                                            this.b.e(iE2 >> 3);
                                        } else {
                                            vf1Var2.a(this.b.c(), i * 8);
                                            this.b.e(0);
                                        }
                                        this.d.a(i, this.b);
                                        long j = this.k;
                                        if (j != -9223372036854775807L) {
                                            this.d.a(j, 1, i, 0, null);
                                            this.k += this.s;
                                        }
                                        if (this.p) {
                                            vf1Var2.d((int) this.q);
                                        }
                                        this.g = 0;
                                    } else {
                                        throw ag1.a((String) null, (Exception) null);
                                    }
                                } else {
                                    throw ag1.a((String) null, (Exception) null);
                                }
                            } else {
                                throw ag1.a((String) null, (Exception) null);
                            }
                        } else {
                            continue;
                        }
                    }
                } else if (wf1Var.t() == 86) {
                    this.g = 1;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.d = y70Var.a(dVar.c(), 1);
        this.e = dVar.b();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }
}
