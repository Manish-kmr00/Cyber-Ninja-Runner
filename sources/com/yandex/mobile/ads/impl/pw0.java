package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.util.Pair;

/* JADX INFO: loaded from: classes11.dex */
final class pw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b52.b f9953a = new b52.b();
    private final b52.d b = new b52.d();
    private final ed c;
    private final Handler d;
    private long e;
    private int f;
    private boolean g;
    private mw0 h;
    private mw0 i;
    private mw0 j;
    private int k;
    private Object l;
    private long m;

    public pw0(ed edVar, Handler handler) {
        this.c = edVar;
        this.d = handler;
    }

    public final boolean h() {
        mw0 mw0Var = this.j;
        return mw0Var == null || (!mw0Var.f.i && mw0Var.d && ((!mw0Var.e || mw0Var.f9674a.getBufferedPositionUs() == Long.MIN_VALUE) && this.j.f.e != -9223372036854775807L && this.k < 100));
    }

    public final mw0 d() {
        return this.j;
    }

    public final mw0 e() {
        return this.h;
    }

    public final mw0 f() {
        return this.i;
    }

    public final mw0 b() {
        mw0 mw0Var = this.i;
        if (mw0Var != null && mw0Var.b() != null) {
            this.i = this.i.b();
            g();
            return this.i;
        }
        throw new IllegalStateException();
    }

    public final mw0 a() {
        mw0 mw0Var = this.h;
        if (mw0Var == null) {
            return null;
        }
        if (mw0Var == this.i) {
            this.i = mw0Var.b();
        }
        this.h.g();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            mw0 mw0Var2 = this.h;
            this.l = mw0Var2.b;
            this.m = mw0Var2.f.f9869a.d;
        }
        this.h = this.h.b();
        g();
        return this.h;
    }

    public final void c() {
        if (this.k == 0) {
            return;
        }
        mw0 mw0VarB = this.h;
        if (mw0VarB != null) {
            this.l = mw0VarB.b;
            this.m = mw0VarB.f.f9869a.d;
            while (mw0VarB != null) {
                mw0VarB.g();
                mw0VarB = mw0VarB.b();
            }
            this.h = null;
            this.j = null;
            this.i = null;
            this.k = 0;
            g();
            return;
        }
        throw new IllegalStateException();
    }

    public final mw0 a(so1[] so1VarArr, y52 y52Var, cd cdVar, uw0 uw0Var, ow0 ow0Var, z52 z52Var) {
        mw0 mw0Var = this.j;
        mw0 mw0Var2 = new mw0(so1VarArr, mw0Var == null ? 1000000000000L : (mw0Var.c() + this.j.f.e) - ow0Var.b, y52Var, cdVar, uw0Var, ow0Var, z52Var);
        mw0 mw0Var3 = this.j;
        if (mw0Var3 != null) {
            mw0Var3.a(mw0Var2);
        } else {
            this.h = mw0Var2;
            this.i = mw0Var2;
        }
        this.l = null;
        this.j = mw0Var2;
        this.k++;
        g();
        return mw0Var2;
    }

    private void g() {
        int i = hk0.d;
        final hk0.a aVar = new hk0.a();
        for (mw0 mw0VarB = this.h; mw0VarB != null; mw0VarB = mw0VarB.b()) {
            aVar.b(mw0VarB.f.f9869a);
        }
        mw0 mw0Var = this.i;
        final rw0.b bVar = mw0Var == null ? null : mw0Var.f.f9869a;
        this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.pw0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(aVar, bVar);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e1  */
    private ow0 a(b52 b52Var, mw0 mw0Var, long j) {
        long jC;
        long jC2;
        long j2;
        long j3;
        long j4;
        boolean z;
        long j5;
        ow0 ow0Var = mw0Var.f;
        long jC3 = (mw0Var.c() + ow0Var.e) - j;
        if (ow0Var.g) {
            int iA = b52Var.a(b52Var.a(ow0Var.f9869a.f9759a), this.f9953a, this.b, this.f, this.g);
            if (iA == -1) {
                return null;
            }
            int i = b52Var.a(iA, this.f9953a, true).d;
            Object obj = this.f9953a.c;
            obj.getClass();
            long j6 = ow0Var.f9869a.d;
            long j7 = 0;
            if (b52Var.a(i, this.b, 0L).p == iA) {
                Pair<Object, Long> pairA = b52Var.a(this.b, this.f9953a, i, -9223372036854775807L, Math.max(0L, jC3));
                if (pairA == null) {
                    return null;
                }
                obj = pairA.first;
                long jLongValue = ((Long) pairA.second).longValue();
                mw0 mw0VarB = mw0Var.b();
                if (mw0VarB != null && mw0VarB.b.equals(obj)) {
                    j5 = mw0VarB.f.f9869a.d;
                } else {
                    j5 = this.e;
                    this.e = 1 + j5;
                }
                j2 = jLongValue;
                j7 = -9223372036854775807L;
                j6 = j5;
            } else {
                j2 = 0;
            }
            rw0.b bVarA = a(b52Var, obj, j2, j6, this.b, this.f9953a);
            if (j7 == -9223372036854775807L || ow0Var.c == -9223372036854775807L) {
                j3 = j7;
                j4 = j2;
            } else {
                if (b52Var.a(ow0Var.f9869a.f9759a, this.f9953a).a() > 0) {
                    b52.b bVar = this.f9953a;
                    z = bVar.f(bVar.d());
                }
                if (bVarA.a() && z) {
                    j3 = ow0Var.c;
                    j4 = j2;
                } else if (z) {
                    j4 = ow0Var.c;
                    j3 = j7;
                } else {
                    j3 = j7;
                    j4 = j2;
                }
            }
            b52Var.a(bVarA.f9759a, this.f9953a);
            if (bVarA.a()) {
                return a(b52Var, bVarA.f9759a, bVarA.b, bVarA.c, j3, bVarA.d);
            }
            return a(b52Var, bVarA.f9759a, j4, j3, bVarA.d);
        }
        rw0.b bVar2 = ow0Var.f9869a;
        b52Var.a(bVar2.f9759a, this.f9953a);
        if (bVar2.a()) {
            int i2 = bVar2.b;
            int iA2 = this.f9953a.a(i2);
            if (iA2 == -1) {
                return null;
            }
            int iC = this.f9953a.c(i2, bVar2.c);
            if (iC < iA2) {
                return a(b52Var, bVar2.f9759a, i2, iC, ow0Var.c, bVar2.d);
            }
            long jLongValue2 = ow0Var.c;
            if (jLongValue2 == -9223372036854775807L) {
                b52.d dVar = this.b;
                b52.b bVar3 = this.f9953a;
                Pair<Object, Long> pairA2 = b52Var.a(dVar, bVar3, bVar3.d, -9223372036854775807L, Math.max(0L, jC3));
                if (pairA2 == null) {
                    return null;
                }
                jLongValue2 = ((Long) pairA2.second).longValue();
            }
            Object obj2 = bVar2.f9759a;
            int i3 = bVar2.b;
            b52Var.a(obj2, this.f9953a);
            long jB = this.f9953a.b(i3);
            if (jB == Long.MIN_VALUE) {
                jC2 = this.f9953a.e;
            } else {
                jC2 = this.f9953a.c(i3) + jB;
            }
            return a(b52Var, bVar2.f9759a, Math.max(jC2, jLongValue2), ow0Var.c, bVar2.d);
        }
        int iD = this.f9953a.d(bVar2.e);
        boolean z2 = this.f9953a.f(bVar2.e) && this.f9953a.b(bVar2.e, iD) == 3;
        if (iD != this.f9953a.a(bVar2.e) && !z2) {
            return a(b52Var, bVar2.f9759a, bVar2.e, iD, ow0Var.e, bVar2.d);
        }
        Object obj3 = bVar2.f9759a;
        int i4 = bVar2.e;
        b52Var.a(obj3, this.f9953a);
        long jB2 = this.f9953a.b(i4);
        if (jB2 == Long.MIN_VALUE) {
            jC = this.f9953a.e;
        } else {
            jC = this.f9953a.c(i4) + jB2;
        }
        return a(b52Var, bVar2.f9759a, jC, ow0Var.e, bVar2.d);
    }

    private ow0 a(b52 b52Var, Object obj, int i, int i2, long j, long j2) {
        rw0.b bVar = new rw0.b(obj, i, i2, j2);
        long jA = b52Var.a(obj, this.f9953a).a(i, i2);
        long jB = i2 == this.f9953a.d(i) ? this.f9953a.b() : 0L;
        return new ow0(bVar, (jA == -9223372036854775807L || jB < jA) ? jB : Math.max(0L, jA - 1), j, -9223372036854775807L, jA, this.f9953a.f(i), false, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0080  */
    private ow0 a(b52 b52Var, Object obj, long j, long j2, long j3) {
        boolean z;
        boolean z2;
        long jB;
        long jMax;
        b52Var.a(obj, this.f9953a);
        int iA = this.f9953a.a(j);
        if (iA == -1) {
            if (this.f9953a.a() > 0) {
                b52.b bVar = this.f9953a;
                z = bVar.f(bVar.d());
            }
        } else {
            if (this.f9953a.f(iA)) {
                long jB2 = this.f9953a.b(iA);
                b52.b bVar2 = this.f9953a;
                if (jB2 == bVar2.e && bVar2.e(iA)) {
                    iA = -1;
                }
            }
        }
        rw0.b bVar3 = new rw0.b(iA, j3, obj);
        boolean z3 = !bVar3.a() && iA == -1;
        if (bVar3.a() || iA != -1) {
            z2 = false;
        } else {
            if (b52Var.a(b52Var.a(obj, this.f9953a).d, this.b, 0L).q == b52Var.a(obj)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        boolean zA = a(b52Var, bVar3, z3);
        boolean z4 = iA != -1 && this.f9953a.f(iA);
        if (iA != -1) {
            jB = this.f9953a.b(iA);
        } else {
            jB = z ? this.f9953a.e : -9223372036854775807L;
        }
        long j4 = (jB == -9223372036854775807L || jB == Long.MIN_VALUE) ? this.f9953a.e : jB;
        if (j4 == -9223372036854775807L || j < j4) {
            jMax = j;
        } else {
            jMax = Math.max(0L, j4 - ((long) ((zA || !z) ? 1 : 0)));
        }
        return new ow0(bVar3, jMax, j2, jB, j4, z4, z3, z2, zA);
    }

    public final ow0 a(long j, vh1 vh1Var) {
        mw0 mw0Var = this.j;
        if (mw0Var == null) {
            b52 b52Var = vh1Var.f10479a;
            rw0.b bVar = vh1Var.b;
            long j2 = vh1Var.c;
            long j3 = vh1Var.r;
            b52Var.a(bVar.f9759a, this.f9953a);
            if (bVar.a()) {
                return a(b52Var, bVar.f9759a, bVar.b, bVar.c, j2, bVar.d);
            }
            return a(b52Var, bVar.f9759a, j3, j2, bVar.d);
        }
        return a(vh1Var.f10479a, mw0Var, j);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    /* JADX WARN: Code duplicated, block: B:36:0x0090  */
    /* JADX WARN: Code duplicated, block: B:37:0x009b  */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    public final ow0 a(b52 b52Var, ow0 ow0Var) {
        boolean z;
        long jA;
        long j;
        int i;
        boolean zF;
        int i2;
        rw0.b bVar = ow0Var.f9869a;
        boolean z2 = !bVar.a() && bVar.e == -1;
        if (bVar.a() || bVar.e != -1) {
            z = false;
        } else {
            if (b52Var.a(b52Var.a(bVar.f9759a, this.f9953a).d, this.b, 0L).q == b52Var.a(bVar.f9759a)) {
                z = true;
            } else {
                z = false;
            }
        }
        boolean zA = a(b52Var, bVar, z2);
        b52Var.a(ow0Var.f9869a.f9759a, this.f9953a);
        long jB = (bVar.a() || (i2 = bVar.e) == -1) ? -9223372036854775807L : this.f9953a.b(i2);
        if (bVar.a()) {
            jA = this.f9953a.a(bVar.b, bVar.c);
        } else {
            if (jB == -9223372036854775807L || jB == Long.MIN_VALUE) {
                jA = this.f9953a.e;
            } else {
                j = jB;
            }
            if (bVar.a()) {
                zF = this.f9953a.f(bVar.b);
            } else {
                i = bVar.e;
                if (i == -1 && this.f9953a.f(i)) {
                    zF = true;
                } else {
                    zF = false;
                }
            }
            return new ow0(bVar, ow0Var.b, ow0Var.c, jB, j, zF, z2, z, zA);
        }
        j = jA;
        if (bVar.a()) {
            zF = this.f9953a.f(bVar.b);
        } else {
            i = bVar.e;
            if (i == -1) {
                zF = false;
            } else {
                zF = false;
            }
        }
        return new ow0(bVar, ow0Var.b, ow0Var.c, jB, j, zF, z2, z, zA);
    }

    private boolean a(b52 b52Var, rw0.b bVar, boolean z) {
        int iA = b52Var.a(bVar.f9759a);
        return !b52Var.a(b52Var.a(iA, this.f9953a, false).d, this.b, 0L).j && b52Var.a(iA, this.f9953a, this.b, this.f, this.g) == -1 && z;
    }

    public final boolean a(lw0 lw0Var) {
        mw0 mw0Var = this.j;
        return mw0Var != null && mw0Var.f9674a == lw0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(hk0.a aVar, rw0.b bVar) {
        this.c.a(aVar.a(), bVar);
    }

    public final void a(long j) {
        mw0 mw0Var = this.j;
        if (mw0Var != null) {
            mw0Var.b(j);
        }
    }

    public final boolean a(mw0 mw0Var) {
        if (mw0Var != null) {
            boolean z = false;
            if (mw0Var.equals(this.j)) {
                return false;
            }
            this.j = mw0Var;
            while (mw0Var.b() != null) {
                mw0Var = mw0Var.b();
                if (mw0Var == this.i) {
                    this.i = this.h;
                    z = true;
                }
                mw0Var.g();
                this.k--;
            }
            this.j.a((mw0) null);
            g();
            return z;
        }
        throw new IllegalStateException();
    }

    private static rw0.b a(b52 b52Var, Object obj, long j, long j2, b52.d dVar, b52.b bVar) {
        Object obj2 = obj;
        b52Var.a(obj, bVar);
        b52Var.a(bVar.d, dVar, 0L);
        int iA = b52Var.a(obj);
        while (bVar.e == 0 && bVar.a() > 0 && bVar.f(bVar.d()) && bVar.b(0L) == -1) {
            int i = iA + 1;
            if (iA >= dVar.q) {
                break;
            }
            b52Var.a(i, bVar, true);
            obj2 = bVar.c;
            obj2.getClass();
            iA = i;
        }
        b52Var.a(obj2, bVar);
        int iB = bVar.b(j);
        if (iB == -1) {
            return new rw0.b(bVar.a(j), j2, obj2);
        }
        return new rw0.b(obj2, iB, bVar.d(iB), j2);
    }

    public final rw0.b a(b52 b52Var, Object obj, long j) {
        long j2;
        int iA;
        Object obj2 = obj;
        int i = b52Var.a(obj2, this.f9953a).d;
        Object obj3 = this.l;
        if (obj3 != null && (iA = b52Var.a(obj3)) != -1 && b52Var.a(iA, this.f9953a, false).d == i) {
            j2 = this.m;
        } else {
            mw0 mw0VarB = this.h;
            while (true) {
                if (mw0VarB != null) {
                    if (mw0VarB.b.equals(obj2)) {
                        j2 = mw0VarB.f.f9869a.d;
                        break;
                    }
                    mw0VarB = mw0VarB.b();
                } else {
                    mw0 mw0VarB2 = this.h;
                    while (true) {
                        if (mw0VarB2 != null) {
                            int iA2 = b52Var.a(mw0VarB2.b);
                            if (iA2 != -1 && b52Var.a(iA2, this.f9953a, false).d == i) {
                                j2 = mw0VarB2.f.f9869a.d;
                                break;
                            }
                            mw0VarB2 = mw0VarB2.b();
                        } else {
                            j2 = this.e;
                            this.e = 1 + j2;
                            if (this.h != null) {
                                break;
                            }
                            this.l = obj2;
                            this.m = j2;
                            break;
                        }
                    }
                }
            }
        }
        long j3 = j2;
        b52Var.a(obj2, this.f9953a);
        b52Var.a(this.f9953a.d, this.b, 0L);
        boolean z = false;
        for (int iA3 = b52Var.a(obj); iA3 >= this.b.p; iA3--) {
            b52Var.a(iA3, this.f9953a, true);
            boolean z2 = this.f9953a.a() > 0;
            z |= z2;
            b52.b bVar = this.f9953a;
            if (bVar.b(bVar.e) != -1) {
                obj2 = this.f9953a.c;
                obj2.getClass();
            }
            if (z && (!z2 || this.f9953a.e != 0)) {
                break;
            }
        }
        return a(b52Var, obj2, j, j3, this.b, this.f9953a);
    }

    private boolean a(b52 b52Var) {
        mw0 mw0VarB = this.h;
        if (mw0VarB == null) {
            return true;
        }
        int iA = b52Var.a(mw0VarB.b);
        while (true) {
            iA = b52Var.a(iA, this.f9953a, this.b, this.f, this.g);
            while (mw0VarB.b() != null && !mw0VarB.f.g) {
                mw0VarB = mw0VarB.b();
            }
            mw0 mw0VarB2 = mw0VarB.b();
            if (iA == -1 || mw0VarB2 == null || b52Var.a(mw0VarB2.b) != iA) {
                break;
            }
            mw0VarB = mw0VarB2;
        }
        boolean zA = a(mw0VarB);
        mw0VarB.f = a(b52Var, mw0VarB.f);
        return !zA;
    }

    public final boolean a(b52 b52Var, long j, long j2) {
        ow0 ow0VarA;
        mw0 mw0VarB = this.h;
        mw0 mw0Var = null;
        while (mw0VarB != null) {
            ow0 ow0Var = mw0VarB.f;
            if (mw0Var == null) {
                ow0VarA = a(b52Var, ow0Var);
            } else {
                ow0 ow0VarA2 = a(b52Var, mw0Var, j);
                if (ow0VarA2 == null) {
                    return !a(mw0Var);
                }
                if (ow0Var.b != ow0VarA2.b || !ow0Var.f9869a.equals(ow0VarA2.f9869a)) {
                    return !a(mw0Var);
                }
                ow0VarA = ow0VarA2;
            }
            long j3 = ow0Var.c;
            ow0 ow0Var2 = j3 == ow0VarA.c ? ow0VarA : new ow0(ow0VarA.f9869a, ow0VarA.b, j3, ow0VarA.d, ow0VarA.e, ow0VarA.f, ow0VarA.g, ow0VarA.h, ow0VarA.i);
            mw0VarB.f = ow0Var2;
            long j4 = ow0Var.e;
            long j5 = ow0VarA.e;
            if (j4 != -9223372036854775807L && j4 != j5) {
                lw0 lw0Var = mw0VarB.f9674a;
                if (lw0Var instanceof gp) {
                    long j6 = ow0Var2.d;
                    if (j6 == -9223372036854775807L) {
                        j6 = Long.MIN_VALUE;
                    }
                    ((gp) lw0Var).a(j6);
                }
                long j7 = ow0VarA.e;
                return (a(mw0VarB) || (mw0VarB == this.i && !mw0VarB.f.f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j7 > (-9223372036854775807L) ? 1 : (j7 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : mw0VarB.d(j7)) ? 1 : (j2 == ((j7 > (-9223372036854775807L) ? 1 : (j7 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : mw0VarB.d(j7)) ? 0 : -1)) >= 0))) ? false : true;
            }
            mw0Var = mw0VarB;
            mw0VarB = mw0VarB.b();
        }
        return true;
    }

    public final boolean a(b52 b52Var, int i) {
        this.f = i;
        return a(b52Var);
    }

    public final boolean a(b52 b52Var, boolean z) {
        this.g = z;
        return a(b52Var);
    }
}
