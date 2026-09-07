package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SU implements YT {
    public static String[] A06 = {"84mIbTPZd6aoJp3lghwjzEV1CXlFbTxk", "W9FMxAusLZkE7ZmzGPcB96nQPb6kpYre", "IKMwo3cB1n7Mun1A38p5O86Z", "pB9MZoxa1qxCt96MdBvwWUod9JFv9LyH", "v8lH5x9fod1bUde8yPNDLhDdan8bSg8g", "Sm43zprTvE0G7HR5LxxDhvZiqT8sMVB1", "hKUClx5zg5vMvifJai9ukQPV", "NqkOJAsqQGgwscckA74t9jHmmJ4q3EmY"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final YK A04;
    public final C2447fq A05 = new C2447fq(32);

    public SU(YK yk) {
        this.A04 = yk;
    }

    @Override // com.facebook.ads.redexgen.core.YT
    public final void A51(C2447fq c2447fq, int i) {
        boolean z = (i & 1) != 0;
        int iA09 = -1;
        if (z) {
            int iA0I = c2447fq.A0I();
            if (A06[0].charAt(8) != 'd') {
                throw new RuntimeException();
            }
            A06[4] = "VzDVvJfsVhmc3MtNs7ivtdz3ntASc";
            iA09 = c2447fq.A09() + iA0I;
        }
        if (this.A03) {
            if (!z) {
                return;
            }
            this.A03 = false;
            c2447fq.A0f(iA09);
            this.A00 = 0;
        }
        while (c2447fq.A07() > 0) {
            if (this.A00 < 3) {
                if (this.A00 == 0) {
                    int iA0I2 = c2447fq.A0I();
                    c2447fq.A0f(c2447fq.A09() - 1);
                    if (iA0I2 == 255) {
                        this.A03 = true;
                        return;
                    }
                }
                int iMin = Math.min(c2447fq.A07(), 3 - this.A00);
                c2447fq.A0k(this.A05.A0l(), this.A00, iMin);
                this.A00 += iMin;
                if (this.A00 == 3) {
                    this.A05.A0f(0);
                    this.A05.A0e(3);
                    this.A05.A0g(1);
                    int iA0I3 = this.A05.A0I();
                    int iA0I4 = this.A05.A0I();
                    boolean payloadUnitStartIndicator = (iA0I3 & 128) != 0;
                    this.A02 = payloadUnitStartIndicator;
                    this.A01 = (((iA0I3 & 15) << 8) | iA0I4) + 3;
                    if (this.A05.A08() < this.A01) {
                        this.A05.A0c(Math.min(4098, Math.max(this.A01, this.A05.A08() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(c2447fq.A07(), this.A01 - this.A00);
                c2447fq.A0k(this.A05.A0l(), this.A00, iMin2);
                this.A00 += iMin2;
                if (this.A00 == this.A01) {
                    boolean payloadUnitStartIndicator2 = this.A02;
                    if (payloadUnitStartIndicator2) {
                        if (AbstractC2471gE.A0I(this.A05.A0l(), 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        }
                        this.A05.A0e(this.A01 - 4);
                    } else {
                        this.A05.A0e(this.A01);
                    }
                    this.A05.A0f(0);
                    this.A04.A50(this.A05);
                    this.A00 = 0;
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.YT
    public final void AA3(C2461g4 c2461g4, UL ul, YS ys) {
        this.A04.AA3(c2461g4, ul, ys);
        this.A03 = true;
    }

    @Override // com.facebook.ads.redexgen.core.YT
    public final void AIB() {
        this.A03 = true;
    }
}
