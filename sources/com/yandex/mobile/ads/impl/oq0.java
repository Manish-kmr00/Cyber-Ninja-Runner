package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public final class oq0 implements w70 {
    private y70 b;
    private int c;
    private int d;
    private int e;
    private v11 g;
    private x70 h;
    private i22 i;
    private x11 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f9848a = new wf1(6);
    private long f = -1;

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
        x11 x11Var = this.j;
        if (x11Var != null) {
            x11Var.getClass();
        }
    }

    private void a() {
        y70 y70Var = this.b;
        y70Var.getClass();
        y70Var.a(1024, 4).a(new gc0.a().b().a(new g01(new g01.b[0])).a());
        y70 y70Var2 = this.b;
        y70Var2.getClass();
        y70Var2.a();
        this.b.a(new xw1.b(-9223372036854775807L, 0L));
        this.c = 6;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.b = y70Var;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x017c  */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        int i;
        String strQ;
        v11 v11Var;
        u11 u11VarA;
        long j;
        int i2 = this.c;
        if (i2 == 0) {
            this.f9848a.c(2);
            ((tz) x70Var).a(this.f9848a.c(), 0, 2, false);
            int iZ = this.f9848a.z();
            this.d = iZ;
            if (iZ == 65498) {
                if (this.f != -1) {
                    this.c = 4;
                    return 0;
                }
                a();
                return 0;
            }
            if ((iZ >= 65488 && iZ <= 65497) || iZ == 65281) {
                return 0;
            }
            this.c = 1;
            return 0;
        }
        if (i2 == 1) {
            this.f9848a.c(2);
            ((tz) x70Var).a(this.f9848a.c(), 0, 2, false);
            this.e = this.f9848a.z() - 2;
            this.c = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.i == null || x70Var != this.h) {
                    this.h = x70Var;
                    this.i = new i22((tz) x70Var, this.f);
                }
                x11 x11Var = this.j;
                x11Var.getClass();
                int iA = x11Var.a(this.i, lj1Var);
                if (iA == 1) {
                    lj1Var.f9531a += this.f;
                }
                return iA;
            }
            tz tzVar = (tz) x70Var;
            long jA = tzVar.a();
            long j2 = this.f;
            if (jA != j2) {
                lj1Var.f9531a = j2;
                return 1;
            }
            if (!tzVar.b(this.f9848a.c(), 0, 1, true)) {
                a();
            } else {
                tzVar.c();
                if (this.j == null) {
                    this.j = new x11();
                }
                i22 i22Var = new i22(tzVar, this.f);
                this.i = i22Var;
                if (this.j.a(i22Var)) {
                    x11 x11Var2 = this.j;
                    long j3 = this.f;
                    y70 y70Var = this.b;
                    y70Var.getClass();
                    x11Var2.a(new j22(j3, y70Var));
                    v11 v11Var2 = this.g;
                    v11Var2.getClass();
                    g01.b[] bVarArr = {v11Var2};
                    y70 y70Var2 = this.b;
                    y70Var2.getClass();
                    y70Var2.a(1024, 4).a(new gc0.a().b().a(new g01(bVarArr)).a());
                    this.c = 5;
                } else {
                    a();
                }
            }
            return 0;
        }
        if (this.d == 65505) {
            wf1 wf1Var = new wf1(this.e);
            tz tzVar2 = (tz) x70Var;
            tzVar2.a(wf1Var.c(), 0, this.e, false);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(wf1Var.q()) && (strQ = wf1Var.q()) != null) {
                long jB = tzVar2.b();
                if (jB == -1 || (u11VarA = yk2.a(strQ)) == null || u11VarA.b.size() < 2) {
                    v11Var = null;
                } else {
                    long j4 = -1;
                    long j5 = -1;
                    long j6 = -1;
                    long j7 = -1;
                    boolean zEquals = false;
                    for (int size = u11VarA.b.size() - 1; size >= 0; size--) {
                        u11.a aVar = u11VarA.b.get(size);
                        zEquals |= "video/mp4".equals(aVar.f10349a);
                        if (size == 0) {
                            jB -= aVar.c;
                            j = 0;
                        } else {
                            j = jB - aVar.b;
                        }
                        long j8 = jB;
                        jB = j;
                        if (zEquals && jB != j8) {
                            j7 = j8 - jB;
                            j6 = jB;
                            zEquals = false;
                        }
                        if (size == 0) {
                            j4 = jB;
                            j5 = j8;
                        }
                    }
                    if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
                        v11Var = null;
                    } else {
                        v11Var = new v11(j4, j5, u11VarA.f10348a, j6, j7);
                    }
                }
                this.g = v11Var;
                if (v11Var != null) {
                    this.f = v11Var.e;
                }
            } else {
                i = 0;
            }
            this.c = i;
            return i;
        }
        ((tz) x70Var).a(this.e);
        i = 0;
        this.c = i;
        return i;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            x11 x11Var = this.j;
            x11Var.getClass();
            x11Var.a(j, j2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar = (tz) x70Var;
        this.f9848a.c(2);
        tzVar.b(this.f9848a.c(), 0, 2, false);
        if (this.f9848a.z() != 65496) {
            return false;
        }
        this.f9848a.c(2);
        tzVar.b(this.f9848a.c(), 0, 2, false);
        int iZ = this.f9848a.z();
        this.d = iZ;
        if (iZ == 65504) {
            this.f9848a.c(2);
            tzVar.b(this.f9848a.c(), 0, 2, false);
            tzVar.a(false, this.f9848a.z() - 2);
            this.f9848a.c(2);
            tzVar.b(this.f9848a.c(), 0, 2, false);
            this.d = this.f9848a.z();
        }
        if (this.d != 65505) {
            return false;
        }
        tzVar.a(false, 2);
        this.f9848a.c(6);
        tzVar.b(this.f9848a.c(), 0, 6, false);
        return this.f9848a.v() == 1165519206 && this.f9848a.z() == 0;
    }
}
