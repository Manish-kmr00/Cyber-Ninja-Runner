package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D9 extends Timeline {
    public final OI<C2050Yh> A00;
    public final OI<C2048Yf> A01;
    public final int[] A02;
    public final int[] A03;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OI != com.google.common.collect.ImmutableList<com.google.android.exoplayer2.Timeline$Period> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OI != com.google.common.collect.ImmutableList<com.google.android.exoplayer2.Timeline$Window> */
    public D9(OI<C2048Yf> oi, OI<C2050Yh> oi2, int[] iArr) {
        AbstractC2388es.A07(oi.size() == iArr.length);
        this.A01 = oi;
        this.A00 = oi2;
        this.A02 = iArr;
        this.A03 = new int[iArr.length];
        for (int i = 0; i < i; i++) {
            int[] iArr2 = this.A03;
            int i2 = iArr[i];
            iArr2[i2] = i;
        }
    }

    public final int A06() {
        return this.A00.size();
    }

    public final int A07() {
        return this.A01.size();
    }

    public final int A08(int i, int i2, boolean z) {
        if (i2 == 1) {
            return i;
        }
        if (i == A0C(z)) {
            if (i2 == 2) {
                return A0B(z);
            }
            return -1;
        }
        if (z) {
            return this.A02[this.A03[i] + 1];
        }
        return i + 1;
    }

    public final int A0A(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final int A0B(boolean z) {
        if (A0N()) {
            return -1;
        }
        if (z) {
            return this.A02[0];
        }
        return 0;
    }

    public final int A0C(boolean z) {
        if (A0N()) {
            return -1;
        }
        if (z) {
            return this.A02[A07() - 1];
        }
        return A07() - 1;
    }

    public final C2050Yh A0I(int i, C2050Yh p, boolean z) {
        C2050Yh p2 = this.A00.get(i);
        p.A0G(p2.A03, p2.A04, p2.A00, p2.A01, p2.A02, p2.A06, p2.A05);
        return p;
    }

    public final C2048Yf A0L(int i, C2048Yf c2048Yf, long j) {
        C2048Yf c2048Yf2 = this.A01.get(i);
        c2048Yf.A07(c2048Yf2.A0C, c2048Yf2.A09, c2048Yf2.A0A, c2048Yf2.A06, c2048Yf2.A07, c2048Yf2.A04, c2048Yf2.A0G, c2048Yf2.A0D, c2048Yf2.A08, c2048Yf2.A02, c2048Yf2.A03, c2048Yf2.A00, c2048Yf2.A01, c2048Yf2.A05);
        c2048Yf.A0F = c2048Yf2.A0F;
        return c2048Yf;
    }

    public final Object A0M(int i) {
        throw new UnsupportedOperationException();
    }
}
