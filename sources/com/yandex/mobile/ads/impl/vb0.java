package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes8.dex */
final class vb0 extends r22 {
    private xb0 n;
    private a o;

    vb0() {
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final long a(wf1 wf1Var) {
        int i;
        int i2;
        int iT;
        int i3 = -1;
        if (wf1Var.c()[0] != -1) {
            return -1L;
        }
        int i4 = (wf1Var.c()[2] & 255) >> 4;
        if (i4 == 6 || i4 == 7) {
            wf1Var.f(4);
            wf1Var.A();
        }
        switch (i4) {
            case 1:
                i3 = 192;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                i = i4 - 2;
                i2 = 576;
                i3 = i2 << i;
                break;
            case 6:
                iT = wf1Var.t();
                i3 = iT + 1;
                break;
            case 7:
                iT = wf1Var.z();
                i3 = iT + 1;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i = i4 - 8;
                i2 = 256;
                i3 = i2 << i;
                break;
        }
        wf1Var.e(0);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements zd1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private xb0 f10469a;
        private xb0.a b;
        private long c = -1;
        private long d = -1;

        public a(xb0 xb0Var, xb0.a aVar) {
            this.f10469a = xb0Var;
            this.b = aVar;
        }

        @Override // com.yandex.mobile.ads.impl.zd1
        public final xw1 a() {
            long j = this.c;
            if (j != -1) {
                return new wb0(this.f10469a, j);
            }
            throw new IllegalStateException();
        }

        @Override // com.yandex.mobile.ads.impl.zd1
        public final long a(tz tzVar) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        @Override // com.yandex.mobile.ads.impl.zd1
        public final void a(long j) {
            long[] jArr = this.b.f10637a;
            this.d = jArr[x82.b(jArr, j, true)];
        }
    }

    @Override // com.yandex.mobile.ads.impl.r22
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean a(wf1 wf1Var, long j, r22.a aVar) {
        byte[] bArrC = wf1Var.c();
        xb0 xb0Var = this.n;
        if (xb0Var == null) {
            xb0 xb0Var2 = new xb0(17, bArrC);
            this.n = xb0Var2;
            aVar.f10069a = xb0Var2.a(Arrays.copyOfRange(bArrC, 9, wf1Var.e()), null);
            return true;
        }
        byte b = bArrC[0];
        if ((b & 127) == 3) {
            xb0.a aVarA = ub0.a(wf1Var);
            xb0 xb0VarA = xb0Var.a(aVarA);
            this.n = xb0VarA;
            this.o = new a(xb0VarA, aVarA);
            return true;
        }
        if (b != -1) {
            return true;
        }
        a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.c = j;
            aVar.b = aVar2;
        }
        aVar.f10069a.getClass();
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}
