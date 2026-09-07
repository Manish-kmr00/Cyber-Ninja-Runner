package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes12.dex */
final class df1 extends r22 {
    private static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean n;

    df1() {
    }

    public static boolean b(wf1 wf1Var) {
        byte[] bArr = o;
        if (wf1Var.a() < 8) {
            return false;
        }
        int iD = wf1Var.d();
        byte[] bArr2 = new byte[8];
        wf1Var.a(bArr2, 0, 8);
        wf1Var.e(iD);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final long a(wf1 wf1Var) {
        int i;
        int i2;
        byte[] bArrC = wf1Var.c();
        byte b = bArrC[0];
        int i3 = b & 255;
        int i4 = b & 3;
        if (i4 != 0) {
            i = 2;
            if (i4 != 1 && i4 != 2) {
                i = bArrC[1] & 63;
            }
        } else {
            i = 1;
        }
        int i5 = i3 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i2 = 2500 << i6;
        } else if (i5 >= 12) {
            i2 = 10000 << (i5 & 1);
        } else {
            i2 = i6 == 3 ? 60000 : 10000 << i6;
        }
        return b(((long) i) * ((long) i2));
    }

    @Override // com.yandex.mobile.ads.impl.r22
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean a(wf1 wf1Var, long j, r22.a aVar) throws ag1 {
        byte[] bArr = o;
        if (wf1Var.a() >= 8) {
            int iD = wf1Var.d();
            byte[] bArr2 = new byte[8];
            wf1Var.a(bArr2, 0, 8);
            wf1Var.e(iD);
            if (Arrays.equals(bArr2, bArr)) {
                byte[] bArrCopyOf = Arrays.copyOf(wf1Var.c(), wf1Var.e());
                int i = bArrCopyOf[9] & 255;
                ArrayList arrayListA = ef1.a(bArrCopyOf);
                if (aVar.f10069a != null) {
                    return true;
                }
                aVar.f10069a = new gc0.a().e("audio/opus").c(i).l(48000).a(arrayListA).a();
                return true;
            }
        }
        byte[] bArr3 = p;
        if (wf1Var.a() >= 8) {
            int iD2 = wf1Var.d();
            byte[] bArr4 = new byte[8];
            wf1Var.a(bArr4, 0, 8);
            wf1Var.e(iD2);
            if (Arrays.equals(bArr4, bArr3)) {
                if (aVar.f10069a != null) {
                    if (this.n) {
                        return true;
                    }
                    this.n = true;
                    wf1Var.f(8);
                    g01 g01VarA = yi2.a(hk0.b(yi2.a(wf1Var, false, false).f10740a));
                    if (g01VarA == null) {
                        return true;
                    }
                    aVar.f10069a = aVar.f10069a.a().a(g01VarA.a(aVar.f10069a.k)).a();
                    return true;
                }
                throw new IllegalStateException();
            }
        }
        if (aVar.f10069a != null) {
            return false;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = false;
        }
    }
}
