package com.facebook.ads.redexgen.core;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1920Sx implements Y7 {
    public static String[] A0B = {"KFIK5LmrcOE5iMyup4rlzZH91ZXf1ETh", "x1f5OWbaeLmEPQ8x74DwnsoOFTBaGqPf", "9IGerzoQzvIPDQ4DicN1iWsoliu23txy", "0TlW88YfUdpMSL8uKiv1u985EETvDdPo", "jEhrjjTiufJlRpitpYp", "49O2oLT5iKWRA7n0NDwH9xhS5fKAXQnl", "wY3tGXu4nX3Ng3bcHf1n4S9C4BGcKWg5", "0YfWv2Tum3n2k7lfc5AM7AxOy6smXpif"};
    public int A00;
    public int A01;
    public int A03;
    public long A04;
    public ZM A06;
    public InterfaceC1957Uo A07;
    public String A08;
    public final String A0A;
    public final C2447fq A09 = new C2447fq(new byte[18]);
    public int A02 = 0;
    public long A05 = -9223372036854775807L;

    public C1920Sx(String str) {
        this.A0A = str;
    }

    @RequiresNonNull({"output"})
    private void A00() {
        byte[] bArrA0l = this.A09.A0l();
        if (this.A06 == null) {
            this.A06 = UI.A03(bArrA0l, this.A08, this.A0A, null);
            this.A07.A6U(this.A06);
        }
        this.A01 = UI.A01(bArrA0l);
        long jA02 = ((long) UI.A02(bArrA0l)) * 1000000;
        int i = this.A06.A0G;
        if (A0B[5].charAt(26) == 'c') {
            throw new RuntimeException();
        }
        A0B[4] = "rTT7LF1yaeqEBPqNna0";
        this.A04 = (int) (jA02 / ((long) i));
    }

    private boolean A01(C2447fq c2447fq) {
        while (c2447fq.A07() > 0) {
            this.A03 <<= 8;
            this.A03 |= c2447fq.A0I();
            if (UI.A07(this.A03)) {
                byte[] bArrA0l = this.A09.A0l();
                bArrA0l[0] = (byte) ((this.A03 >> 24) & 255);
                bArrA0l[1] = (byte) ((this.A03 >> 16) & 255);
                bArrA0l[2] = (byte) ((this.A03 >> 8) & 255);
                bArrA0l[3] = (byte) (this.A03 & 255);
                this.A00 = 4;
                this.A03 = 0;
                return true;
            }
        }
        return false;
    }

    private boolean A02(C2447fq c2447fq, byte[] bArr, int i) {
        int iMin = Math.min(c2447fq.A07(), i - this.A00);
        int bytesToRead = this.A00;
        c2447fq.A0k(bArr, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        return bytesToRead3 == i;
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A50(C2447fq c2447fq) {
        AbstractC2388es.A02(this.A07);
        while (c2447fq.A07() > 0) {
            switch (this.A02) {
                case 0:
                    if (A01(c2447fq)) {
                        this.A02 = 1;
                    }
                    break;
                case 1:
                    if (A02(c2447fq, this.A09.A0l(), 18)) {
                        A00();
                        this.A09.A0f(0);
                        this.A07.AHx(this.A09, 18);
                        this.A02 = 2;
                    }
                    break;
                case 2:
                    int iMin = Math.min(c2447fq.A07(), this.A01 - this.A00);
                    this.A07.AHx(c2447fq, iMin);
                    int bytesToRead = this.A00;
                    this.A00 = bytesToRead + iMin;
                    int i = this.A00;
                    int bytesToRead2 = this.A01;
                    if (i != bytesToRead2) {
                        continue;
                    } else {
                        long j = this.A05;
                        if (A0B[2].charAt(1) != 'I') {
                            throw new RuntimeException();
                        }
                        A0B[1] = "TaGzoiXMEDvJ7PcVuQjXhRH8TlPpyqYe";
                        if (j != -9223372036854775807L) {
                            this.A07.AI0(this.A05, 1, this.A01, 0, null);
                            this.A05 += this.A04;
                        }
                        this.A02 = 0;
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A5S(UL ul, YS ys) {
        ys.A05();
        this.A08 = ys.A04();
        this.A07 = ul.AJX(ys.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFx() {
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFy(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A05 = j;
        }
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AIB() {
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
        this.A05 = -9223372036854775807L;
    }
}
