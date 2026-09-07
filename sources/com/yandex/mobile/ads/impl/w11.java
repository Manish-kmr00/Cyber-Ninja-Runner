package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public final class w11 implements w70 {
    private static final pi0.a u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10525a;
    private final long b;
    private final wf1 c;
    private final b21.a d;
    private final fe0 e;
    private final ri0 f;
    private final o40 g;
    private y70 h;
    private t52 i;
    private t52 j;
    private int k;
    private g01 l;
    private long m;
    private long n;
    private long o;
    private int p;
    private ax1 q;
    private boolean r;
    private boolean s;
    private long t;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.w11$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return w11.b();
            }
        };
        u = new pi0.a() { // from class: com.yandex.mobile.ads.impl.w11$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.pi0.a
            public final boolean a(int i, int i2, int i3, int i4, int i5) {
                return w11.a(i, i2, i3, i4, i5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] b() {
        return new w70[]{new w11()};
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    public w11() {
        this(0);
    }

    public w11(int i) {
        this((Object) null);
    }

    public w11(Object obj) {
        this.f10525a = 0;
        this.b = -9223372036854775807L;
        this.c = new wf1(10);
        this.d = new b21.a();
        this.e = new fe0();
        this.m = -9223372036854775807L;
        this.f = new ri0();
        o40 o40Var = new o40();
        this.g = o40Var;
        this.j = o40Var;
    }

    public final void a() {
        this.r = true;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.h = y70Var;
        t52 t52VarA = y70Var.a(0, 1);
        this.i = t52VarA;
        this.j = t52VarA;
        this.h.a();
    }

    private boolean a(tz tzVar) throws IOException {
        ax1 ax1Var = this.q;
        if (ax1Var != null) {
            long jA = ax1Var.a();
            if (jA != -1 && tzVar.d() > jA - 4) {
                return true;
            }
        }
        try {
            return !tzVar.b(this.c.c(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:106:0x020d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0213  */
    /* JADX WARN: Code duplicated, block: B:109:0x0216  */
    /* JADX WARN: Code duplicated, block: B:113:0x0286  */
    /* JADX WARN: Code duplicated, block: B:114:0x0289  */
    /* JADX WARN: Code duplicated, block: B:116:0x029d  */
    /* JADX WARN: Code duplicated, block: B:118:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:11:0x003b  */
    /* JADX WARN: Code duplicated, block: B:120:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:123:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:126:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:13:0x003f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0363  */
    /* JADX WARN: Code duplicated, block: B:146:0x036e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0371  */
    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    /* JADX WARN: Code duplicated, block: B:150:0x0379  */
    /* JADX WARN: Code duplicated, block: B:164:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:170:0x01e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0078  */
    /* JADX WARN: Code duplicated, block: B:29:0x007a  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:50:0x0107  */
    /* JADX WARN: Code duplicated, block: B:56:0x0147  */
    /* JADX WARN: Code duplicated, block: B:58:0x014e  */
    /* JADX WARN: Code duplicated, block: B:62:0x015f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0167  */
    /* JADX WARN: Code duplicated, block: B:70:0x018a A[LOOP:0: B:57:0x014c->B:70:0x018a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x018e A[EDGE_INSN: B:71:0x018e->B:72:0x0190 BREAK  A[LOOP:0: B:57:0x014c->B:70:0x018a]] */
    /* JADX WARN: Code duplicated, block: B:74:0x0194  */
    /* JADX WARN: Code duplicated, block: B:75:0x019b  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x01af  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:86:0x01be  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:90:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e5 A[EDGE_INSN: B:94:0x01e5->B:80:0x01a8 BREAK  A[LOOP:2: B:87:0x01c3->B:93:0x01e2]] */
    /* JADX WARN: Code duplicated, block: B:96:0x01f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:98:0x01fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        int i;
        tz tzVar;
        long jA;
        long j;
        int iB;
        int i2;
        tz tzVar2;
        int iH;
        wf1 wf1Var;
        tz tzVar3;
        b21.a aVar;
        int i3;
        int iH2;
        tz tzVar4;
        int i4;
        int i5;
        ax1 ax1VarA;
        fe0 fe0Var;
        fe0 fe0Var2;
        int i6;
        int i7;
        g01 g01Var;
        long jA2;
        v01 v01VarA;
        boolean z;
        long jA3;
        g01 g01Var2;
        long jA4;
        int iC;
        int i8;
        g01.b bVarA;
        m42 m42Var;
        long j2;
        g01 g01Var3;
        int iC2;
        int i9;
        g01.b bVarA2;
        int iC3;
        int i10;
        long jA5;
        g01.b bVarA3;
        m42 m42Var2;
        if (this.i != null) {
            int i11 = x82.f10629a;
            int i12 = 0;
            if (this.k == 0) {
                try {
                    a((tz) x70Var, false);
                    if (this.q == null) {
                        wf1Var = new wf1(this.d.c);
                        tzVar3 = (tz) x70Var;
                        tzVar3.b(wf1Var.c(), 0, this.d.c, false);
                        aVar = this.d;
                        if ((aVar.f8470a & 1) != 0) {
                            if (aVar.e != 1) {
                                i3 = 36;
                            } else {
                                i3 = 21;
                            }
                        } else if (aVar.e != 1) {
                            i3 = 21;
                        } else {
                            i3 = 13;
                        }
                        if (wf1Var.e() >= i3 + 4) {
                            wf1Var.e(i3);
                            iH2 = wf1Var.h();
                            if (iH2 != 1483304551 && iH2 != 1231971951) {
                                if (wf1Var.e() >= 40) {
                                    wf1Var.e(36);
                                    if (wf1Var.h() == 1447187017) {
                                        iH2 = 1447187017;
                                    } else {
                                        iH2 = 0;
                                    }
                                } else {
                                    iH2 = 0;
                                }
                            }
                        } else if (wf1Var.e() >= 40) {
                            wf1Var.e(36);
                            if (wf1Var.h() == 1447187017) {
                                iH2 = 1447187017;
                            } else {
                                iH2 = 0;
                            }
                        } else {
                            iH2 = 0;
                        }
                        if (iH2 != 1483304551 || iH2 == 1231971951) {
                            tzVar4 = tzVar3;
                            i4 = 4;
                            i5 = i3;
                            ax1VarA = tk2.a(tzVar4.b(), tzVar4.a(), this.d, wf1Var);
                            if (ax1VarA != null) {
                                fe0Var = this.e;
                                if (fe0Var.f8887a != -1 || fe0Var.b == -1) {
                                    tzVar4.c();
                                    tzVar4.a(false, i5 + 141);
                                    tzVar4.b(this.c.c(), 0, 3, false);
                                    this.c.e(0);
                                    fe0Var2 = this.e;
                                    int iW = this.c.w();
                                    fe0Var2.getClass();
                                    i6 = iW >> 12;
                                    i7 = iW & 4095;
                                    if (i6 <= 0 || i7 > 0) {
                                        fe0Var2.f8887a = i6;
                                        fe0Var2.b = i7;
                                    }
                                }
                            }
                            tzVar4.a(this.d.c);
                            if (ax1VarA != null && !ax1VarA.b() && iH2 == 1231971951) {
                                tzVar4.b(this.c.c(), 0, 4, false);
                                this.c.e(0);
                                this.d.a(this.c.h());
                                ax1VarA = new ur(tzVar4.b(), tzVar4.a(), this.d, false);
                            }
                        } else if (iH2 == 1447187017) {
                            tzVar4 = tzVar3;
                            i4 = 4;
                            ax1VarA = na2.a(tzVar3.b(), tzVar3.a(), this.d, wf1Var);
                            tzVar4.a(this.d.c);
                        } else {
                            tzVar4 = tzVar3;
                            i4 = 4;
                            tzVar4.c();
                            ax1VarA = null;
                        }
                        g01Var = this.l;
                        jA2 = tzVar4.a();
                        if (g01Var != null) {
                            v01VarA = null;
                            break;
                        }
                        iC2 = g01Var.c();
                        i9 = 0;
                        while (true) {
                            if (i9 < iC2) {
                                v01VarA = null;
                                break;
                            }
                            bVarA2 = g01Var.a(i9);
                            if (bVarA2 instanceof u01) {
                                u01 u01Var = (u01) bVarA2;
                                iC3 = g01Var.c();
                                i10 = 0;
                                while (true) {
                                    if (i10 < iC3) {
                                        jA5 = -9223372036854775807L;
                                        break;
                                    }
                                    bVarA3 = g01Var.a(i10);
                                    if (bVarA3 instanceof m42) {
                                        m42Var2 = (m42) bVarA3;
                                        if (m42Var2.b.equals("TLEN")) {
                                            jA5 = x82.a(Long.parseLong(m42Var2.d));
                                            break;
                                        }
                                    }
                                    i10++;
                                }
                                v01VarA = v01.a(jA2, u01Var, jA5);
                                break;
                            }
                            i9++;
                        }
                        if (this.r) {
                            ax1VarA = new ax1.a();
                        } else {
                            if ((this.f10525a & i4) != 0) {
                                jA3 = -1;
                                if (v01VarA != null) {
                                    jA4 = v01VarA.c();
                                } else {
                                    if (ax1VarA != null) {
                                        long jC = ax1VarA.c();
                                        jA3 = ax1VarA.a();
                                        j2 = jC;
                                    } else {
                                        g01Var2 = this.l;
                                        if (g01Var2 != null) {
                                            jA4 = -9223372036854775807L;
                                            break;
                                        }
                                        iC = g01Var2.c();
                                        i8 = 0;
                                        while (true) {
                                            if (i8 < iC) {
                                                jA4 = -9223372036854775807L;
                                                break;
                                            }
                                            bVarA = g01Var2.a(i8);
                                            if (bVarA instanceof m42) {
                                                m42Var = (m42) bVarA;
                                                if (m42Var.b.equals("TLEN")) {
                                                    jA4 = x82.a(Long.parseLong(m42Var.d));
                                                    break;
                                                }
                                            }
                                            i8++;
                                        }
                                    }
                                    ax1VarA = new xk0(j2, tzVar4.a(), jA3);
                                }
                                j2 = jA4;
                                ax1VarA = new xk0(j2, tzVar4.a(), jA3);
                            } else if (v01VarA != null) {
                                ax1VarA = v01VarA;
                            } else if (ax1VarA == null) {
                                ax1VarA = null;
                            }
                            if (ax1VarA != null || (!ax1VarA.b() && (this.f10525a & 1) != 0)) {
                                if ((this.f10525a & 2) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                tzVar4.b(this.c.c(), 0, i4, false);
                                this.c.e(0);
                                this.d.a(this.c.h());
                                ax1VarA = new ur(tzVar4.b(), tzVar4.a(), this.d, z);
                            }
                        }
                        this.q = ax1VarA;
                        this.h.a(ax1VarA);
                        t52 t52Var = this.j;
                        gc0.a aVarE = new gc0.a().e(this.d.b).h(4096).c(this.d.e).l(this.d.d).d(this.e.f8887a).e(this.e.b);
                        if ((this.f10525a & 8) != 0) {
                            g01Var3 = null;
                        } else {
                            g01Var3 = this.l;
                        }
                        t52Var.a(aVarE.a(g01Var3).a());
                        this.o = tzVar4.a();
                    } else if (this.o != 0) {
                        tzVar = (tz) x70Var;
                        jA = tzVar.a();
                        j = this.o;
                        if (jA < j) {
                            tzVar.a((int) (j - jA));
                        }
                    }
                    if (this.p == 0) {
                        tzVar2 = (tz) x70Var;
                        tzVar2.c();
                        if (a(tzVar2)) {
                            i = -1;
                            i12 = -1;
                        } else {
                            this.c.e(0);
                            iH = this.c.h();
                            if (((-128000) & iH) != (((long) this.k) & (-128000)) && b21.a(iH) != -1) {
                                this.d.a(iH);
                                if (this.m == -9223372036854775807L) {
                                    this.m = this.q.a(tzVar2.a());
                                    if (this.b != -9223372036854775807L) {
                                        this.m = (this.b - this.q.a(0L)) + this.m;
                                    }
                                }
                                b21.a aVar2 = this.d;
                                this.p = aVar2.c;
                                ax1 ax1Var = this.q;
                                if (ax1Var instanceof xk0) {
                                    xk0 xk0Var = (xk0) ax1Var;
                                    xk0Var.a((((this.n + ((long) aVar2.g)) * 1000000) / ((long) aVar2.d)) + this.m, tzVar2.a() + ((long) this.d.c));
                                    if (this.s && xk0Var.c(this.t)) {
                                        this.s = false;
                                        this.j = this.i;
                                    }
                                }
                                iB = this.j.b(x70Var, this.p, true);
                                if (iB == -1) {
                                    i = -1;
                                    i12 = -1;
                                } else {
                                    i2 = this.p - iB;
                                    this.p = i2;
                                    if (i2 <= 0) {
                                        t52 t52Var2 = this.j;
                                        long j3 = this.n;
                                        long j4 = this.m;
                                        b21.a aVar3 = this.d;
                                        t52Var2.a(((j3 * 1000000) / ((long) aVar3.d)) + j4, 1, aVar3.c, 0, null);
                                        this.n += (long) this.d.g;
                                        this.p = 0;
                                    }
                                }
                            } else {
                                tzVar2.a(1);
                                this.k = 0;
                            }
                            i = -1;
                        }
                    } else {
                        iB = this.j.b(x70Var, this.p, true);
                        if (iB == -1) {
                            i = -1;
                            i12 = -1;
                        } else {
                            i2 = this.p - iB;
                            this.p = i2;
                            if (i2 <= 0) {
                                t52 t52Var3 = this.j;
                                long j5 = this.n;
                                long j6 = this.m;
                                b21.a aVar4 = this.d;
                                t52Var3.a(((j5 * 1000000) / ((long) aVar4.d)) + j6, 1, aVar4.c, 0, null);
                                this.n += (long) this.d.g;
                                this.p = 0;
                            }
                            i = -1;
                        }
                    }
                } catch (EOFException unused) {
                }
            } else {
                if (this.q == null) {
                    wf1Var = new wf1(this.d.c);
                    tzVar3 = (tz) x70Var;
                    tzVar3.b(wf1Var.c(), 0, this.d.c, false);
                    aVar = this.d;
                    if ((aVar.f8470a & 1) != 0) {
                        if (aVar.e != 1) {
                            i3 = 36;
                        } else {
                            i3 = 21;
                        }
                    } else if (aVar.e != 1) {
                        i3 = 21;
                    } else {
                        i3 = 13;
                    }
                    if (wf1Var.e() >= i3 + 4) {
                        wf1Var.e(i3);
                        iH2 = wf1Var.h();
                        if (iH2 != 1483304551) {
                            if (wf1Var.e() >= 40) {
                                wf1Var.e(36);
                                if (wf1Var.h() == 1447187017) {
                                    iH2 = 1447187017;
                                } else {
                                    iH2 = 0;
                                }
                            } else {
                                iH2 = 0;
                            }
                        }
                    } else if (wf1Var.e() >= 40) {
                        wf1Var.e(36);
                        if (wf1Var.h() == 1447187017) {
                            iH2 = 1447187017;
                        } else {
                            iH2 = 0;
                        }
                    } else {
                        iH2 = 0;
                    }
                    if (iH2 != 1483304551) {
                        tzVar4 = tzVar3;
                        i4 = 4;
                        i5 = i3;
                        ax1VarA = tk2.a(tzVar4.b(), tzVar4.a(), this.d, wf1Var);
                        if (ax1VarA != null) {
                            fe0Var = this.e;
                            if (fe0Var.f8887a != -1) {
                                tzVar4.c();
                                tzVar4.a(false, i5 + 141);
                                tzVar4.b(this.c.c(), 0, 3, false);
                                this.c.e(0);
                                fe0Var2 = this.e;
                                int iW2 = this.c.w();
                                fe0Var2.getClass();
                                i6 = iW2 >> 12;
                                i7 = iW2 & 4095;
                                if (i6 <= 0) {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                } else {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                }
                            } else {
                                tzVar4.c();
                                tzVar4.a(false, i5 + 141);
                                tzVar4.b(this.c.c(), 0, 3, false);
                                this.c.e(0);
                                fe0Var2 = this.e;
                                int iW3 = this.c.w();
                                fe0Var2.getClass();
                                i6 = iW3 >> 12;
                                i7 = iW3 & 4095;
                                if (i6 <= 0) {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                } else {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                }
                            }
                        }
                        tzVar4.a(this.d.c);
                        if (ax1VarA != null) {
                            tzVar4.b(this.c.c(), 0, 4, false);
                            this.c.e(0);
                            this.d.a(this.c.h());
                            ax1VarA = new ur(tzVar4.b(), tzVar4.a(), this.d, false);
                        }
                    } else {
                        tzVar4 = tzVar3;
                        i4 = 4;
                        i5 = i3;
                        ax1VarA = tk2.a(tzVar4.b(), tzVar4.a(), this.d, wf1Var);
                        if (ax1VarA != null) {
                            fe0Var = this.e;
                            if (fe0Var.f8887a != -1) {
                                tzVar4.c();
                                tzVar4.a(false, i5 + 141);
                                tzVar4.b(this.c.c(), 0, 3, false);
                                this.c.e(0);
                                fe0Var2 = this.e;
                                int iW4 = this.c.w();
                                fe0Var2.getClass();
                                i6 = iW4 >> 12;
                                i7 = iW4 & 4095;
                                if (i6 <= 0) {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                } else {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                }
                            } else {
                                tzVar4.c();
                                tzVar4.a(false, i5 + 141);
                                tzVar4.b(this.c.c(), 0, 3, false);
                                this.c.e(0);
                                fe0Var2 = this.e;
                                int iW5 = this.c.w();
                                fe0Var2.getClass();
                                i6 = iW5 >> 12;
                                i7 = iW5 & 4095;
                                if (i6 <= 0) {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                } else {
                                    fe0Var2.f8887a = i6;
                                    fe0Var2.b = i7;
                                }
                            }
                        }
                        tzVar4.a(this.d.c);
                        if (ax1VarA != null) {
                            tzVar4.b(this.c.c(), 0, 4, false);
                            this.c.e(0);
                            this.d.a(this.c.h());
                            ax1VarA = new ur(tzVar4.b(), tzVar4.a(), this.d, false);
                        }
                    }
                    g01Var = this.l;
                    jA2 = tzVar4.a();
                    if (g01Var != null) {
                        v01VarA = null;
                        break;
                    }
                    iC2 = g01Var.c();
                    i9 = 0;
                    while (true) {
                        if (i9 < iC2) {
                            v01VarA = null;
                            break;
                        }
                        bVarA2 = g01Var.a(i9);
                        if (bVarA2 instanceof u01) {
                            u01 u01Var2 = (u01) bVarA2;
                            iC3 = g01Var.c();
                            i10 = 0;
                            while (true) {
                                if (i10 < iC3) {
                                    jA5 = -9223372036854775807L;
                                    break;
                                }
                                bVarA3 = g01Var.a(i10);
                                if (bVarA3 instanceof m42) {
                                    m42Var2 = (m42) bVarA3;
                                    if (m42Var2.b.equals("TLEN")) {
                                        jA5 = x82.a(Long.parseLong(m42Var2.d));
                                        break;
                                    }
                                }
                                i10++;
                            }
                            v01VarA = v01.a(jA2, u01Var2, jA5);
                            break;
                        }
                        i9++;
                    }
                    if (this.r) {
                        ax1VarA = new ax1.a();
                    } else {
                        if ((this.f10525a & i4) != 0) {
                            jA3 = -1;
                            if (v01VarA != null) {
                                jA4 = v01VarA.c();
                            } else {
                                if (ax1VarA != null) {
                                    long jC2 = ax1VarA.c();
                                    jA3 = ax1VarA.a();
                                    j2 = jC2;
                                } else {
                                    g01Var2 = this.l;
                                    if (g01Var2 != null) {
                                        jA4 = -9223372036854775807L;
                                        break;
                                    }
                                    iC = g01Var2.c();
                                    i8 = 0;
                                    while (true) {
                                        if (i8 < iC) {
                                            jA4 = -9223372036854775807L;
                                            break;
                                        }
                                        bVarA = g01Var2.a(i8);
                                        if (bVarA instanceof m42) {
                                            m42Var = (m42) bVarA;
                                            if (m42Var.b.equals("TLEN")) {
                                                jA4 = x82.a(Long.parseLong(m42Var.d));
                                                break;
                                            }
                                        }
                                        i8++;
                                    }
                                }
                                ax1VarA = new xk0(j2, tzVar4.a(), jA3);
                            }
                            j2 = jA4;
                            ax1VarA = new xk0(j2, tzVar4.a(), jA3);
                        } else if (v01VarA != null) {
                            ax1VarA = v01VarA;
                        } else if (ax1VarA == null) {
                            ax1VarA = null;
                        }
                        if (ax1VarA != null) {
                            if ((this.f10525a & 2) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            tzVar4.b(this.c.c(), 0, i4, false);
                            this.c.e(0);
                            this.d.a(this.c.h());
                            ax1VarA = new ur(tzVar4.b(), tzVar4.a(), this.d, z);
                        } else {
                            if ((this.f10525a & 2) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            tzVar4.b(this.c.c(), 0, i4, false);
                            this.c.e(0);
                            this.d.a(this.c.h());
                            ax1VarA = new ur(tzVar4.b(), tzVar4.a(), this.d, z);
                        }
                    }
                    this.q = ax1VarA;
                    this.h.a(ax1VarA);
                    t52 t52Var4 = this.j;
                    gc0.a aVarE2 = new gc0.a().e(this.d.b).h(4096).c(this.d.e).l(this.d.d).d(this.e.f8887a).e(this.e.b);
                    if ((this.f10525a & 8) != 0) {
                        g01Var3 = null;
                    } else {
                        g01Var3 = this.l;
                    }
                    t52Var4.a(aVarE2.a(g01Var3).a());
                    this.o = tzVar4.a();
                } else if (this.o != 0) {
                    tzVar = (tz) x70Var;
                    jA = tzVar.a();
                    j = this.o;
                    if (jA < j) {
                        tzVar.a((int) (j - jA));
                    }
                }
                if (this.p == 0) {
                    tzVar2 = (tz) x70Var;
                    tzVar2.c();
                    if (a(tzVar2)) {
                        i = -1;
                        i12 = -1;
                    } else {
                        this.c.e(0);
                        iH = this.c.h();
                        if (((-128000) & iH) != (((long) this.k) & (-128000))) {
                        }
                        tzVar2.a(1);
                        this.k = 0;
                        i = -1;
                    }
                } else {
                    iB = this.j.b(x70Var, this.p, true);
                    if (iB == -1) {
                        i = -1;
                        i12 = -1;
                    } else {
                        i2 = this.p - iB;
                        this.p = i2;
                        if (i2 <= 0) {
                            t52 t52Var5 = this.j;
                            long j7 = this.n;
                            long j8 = this.m;
                            b21.a aVar5 = this.d;
                            t52Var5.a(((j7 * 1000000) / ((long) aVar5.d)) + j8, 1, aVar5.c, 0, null);
                            this.n += (long) this.d.g;
                            this.p = 0;
                        }
                        i = -1;
                    }
                }
            }
            if (i12 == i) {
                ax1 ax1Var2 = this.q;
                if (ax1Var2 instanceof xk0) {
                    long j9 = ((this.n * 1000000) / ((long) this.d.d)) + this.m;
                    if (ax1Var2.c() != j9) {
                        ((xk0) this.q).d(j9);
                        this.h.a(this.q);
                    }
                }
            }
            return i12;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = j2;
        ax1 ax1Var = this.q;
        if (!(ax1Var instanceof xk0) || ((xk0) ax1Var).c(j2)) {
            return;
        }
        this.s = true;
        this.j = this.g;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        return a((tz) x70Var, true);
    }

    private boolean a(tz tzVar, boolean z) throws IOException {
        int iD;
        int i;
        int iA;
        int i2 = z ? 32768 : 131072;
        tzVar.c();
        if (tzVar.a() == 0) {
            g01 g01VarA = this.f.a(tzVar, (this.f10525a & 8) == 0 ? null : u);
            this.l = g01VarA;
            if (g01VarA != null) {
                this.e.a(g01VarA);
            }
            iD = (int) tzVar.d();
            if (!z) {
                tzVar.a(iD);
            }
            i = 0;
        } else {
            iD = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (a(tzVar)) {
                if (i3 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.c.e(0);
            int iH = this.c.h();
            if ((i == 0 || ((-128000) & iH) == (((long) i) & (-128000))) && (iA = b21.a(iH)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    this.d.a(iH);
                    i = iH;
                }
                tzVar.a(false, iA - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z) {
                        return false;
                    }
                    throw ag1.a("Searched too many bytes.", (Exception) null);
                }
                if (z) {
                    tzVar.c();
                    tzVar.a(false, iD + i5);
                } else {
                    tzVar.a(1);
                }
                i3 = 0;
                i4 = i5;
                i = 0;
            }
        }
        if (z) {
            tzVar.a(iD + i4);
        } else {
            tzVar.c();
        }
        this.k = i;
        return true;
    }
}
