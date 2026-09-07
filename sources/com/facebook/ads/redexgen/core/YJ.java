package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YJ {
    public int A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final Y7 A05;
    public final C2446fp A06 = new C2446fp(new byte[64]);
    public final C2461g4 A07;

    public YJ(Y7 y7, C2461g4 c2461g4) {
        this.A05 = y7;
        this.A07 = c2461g4;
    }

    private void A00() {
        this.A06.A09(8);
        this.A03 = this.A06.A0H();
        this.A02 = this.A06.A0H();
        this.A06.A09(6);
        this.A00 = this.A06.A04(8);
    }

    private void A01() {
        this.A01 = 0L;
        if (this.A03) {
            this.A06.A09(4);
            long jA04 = ((long) this.A06.A04(3)) << 30;
            this.A06.A09(1);
            long pts = this.A06.A04(15) << 15;
            long j = jA04 | pts;
            this.A06.A09(1);
            long pts2 = this.A06.A04(15);
            long j2 = j | pts2;
            this.A06.A09(1);
            if (!this.A04 && this.A02) {
                this.A06.A09(4);
                long pts3 = this.A06.A04(3);
                this.A06.A09(1);
                long pts4 = (pts3 << 30) | ((long) (this.A06.A04(15) << 15));
                this.A06.A09(1);
                long pts5 = pts4 | ((long) this.A06.A04(15));
                this.A06.A09(1);
                this.A07.A06(pts5);
                this.A04 = true;
            }
            this.A01 = this.A07.A06(j2);
        }
    }

    public final void A02() {
        this.A04 = false;
        this.A05.AIB();
    }

    public final void A03(C2447fq c2447fq) throws Q6 {
        c2447fq.A0k(this.A06.A00, 0, 3);
        this.A06.A08(0);
        A00();
        c2447fq.A0k(this.A06.A00, 0, this.A00);
        this.A06.A08(0);
        A01();
        this.A05.AFy(this.A01, 4);
        this.A05.A50(c2447fq);
        this.A05.AFx();
    }
}
