package com.facebook.ads.redexgen.core;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1904Sh implements Y7 {
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public InterfaceC1957Uo A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final UY A09;
    public final C2447fq A0A;
    public final String A0B;

    public C1904Sh() {
        this(null);
    }

    public C1904Sh(String str) {
        this.A02 = 0;
        this.A0A = new C2447fq(4);
        this.A0A.A0l()[0] = -1;
        this.A09 = new UY();
        this.A04 = -9223372036854775807L;
        this.A0B = str;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    private void A00(C2447fq c2447fq) {
        boolean z;
        byte[] bArrA0l = c2447fq.A0l();
        int iA0A = c2447fq.A0A();
        for (int iA09 = c2447fq.A09(); iA09 < iA0A; iA09++) {
            int startOffset = bArrA0l[iA09];
            boolean z2 = (startOffset & 255) == 255;
            if (this.A08) {
                int startOffset2 = bArrA0l[iA09];
                if ((startOffset2 & 224) == 224) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.A08 = z2;
            if (z) {
                c2447fq.A0f(iA09 + 1);
                this.A08 = false;
                this.A0A.A0l()[1] = bArrA0l[iA09];
                this.A00 = 2;
                this.A02 = 1;
                return;
            }
        }
        c2447fq.A0f(iA0A);
    }

    @RequiresNonNull({"output"})
    private void A01(C2447fq c2447fq) {
        int iMin = Math.min(c2447fq.A07(), this.A01 - this.A00);
        this.A05.AHx(c2447fq, iMin);
        int bytesToRead = this.A00;
        this.A00 = bytesToRead + iMin;
        int i = this.A00;
        int bytesToRead2 = this.A01;
        if (i < bytesToRead2) {
            return;
        }
        if (this.A04 != -9223372036854775807L) {
            this.A05.AI0(this.A04, 1, this.A01, 0, null);
            this.A04 += this.A03;
        }
        this.A00 = 0;
        this.A02 = 0;
    }

    @RequiresNonNull({"output"})
    private void A02(C2447fq c2447fq) {
        int iMin = Math.min(c2447fq.A07(), 4 - this.A00);
        byte[] bArrA0l = this.A0A.A0l();
        int bytesToRead = this.A00;
        c2447fq.A0k(bArrA0l, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        if (bytesToRead3 < 4) {
            return;
        }
        this.A0A.A0f(0);
        UY uy = this.A09;
        int bytesToRead4 = this.A0A.A0C();
        if (!uy.A00(bytesToRead4)) {
            this.A00 = 0;
            this.A02 = 1;
            return;
        }
        int bytesToRead5 = this.A09.A02;
        this.A01 = bytesToRead5;
        if (!this.A07) {
            int bytesToRead6 = this.A09.A04;
            long j = ((long) bytesToRead6) * 1000000;
            int bytesToRead7 = this.A09.A03;
            this.A03 = j / ((long) bytesToRead7);
            P5 p5A0h = new P5().A0y(this.A06).A11(this.A09.A06).A0h(4096);
            int bytesToRead8 = this.A09.A01;
            P5 p5A0b = p5A0h.A0b(bytesToRead8);
            int bytesToRead9 = this.A09.A03;
            this.A05.A6U(p5A0b.A0m(bytesToRead9).A10(this.A0B).A14());
            this.A07 = true;
        }
        this.A0A.A0f(0);
        this.A05.AHx(this.A0A, 4);
        this.A02 = 2;
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A50(C2447fq c2447fq) {
        AbstractC2388es.A02(this.A05);
        while (c2447fq.A07() > 0) {
            switch (this.A02) {
                case 0:
                    A00(c2447fq);
                    break;
                case 1:
                    A02(c2447fq);
                    break;
                case 2:
                    A01(c2447fq);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A5S(UL ul, YS ys) {
        ys.A05();
        this.A06 = ys.A04();
        this.A05 = ul.AJX(ys.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFx() {
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFy(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A04 = j;
        }
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AIB() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
    }
}
