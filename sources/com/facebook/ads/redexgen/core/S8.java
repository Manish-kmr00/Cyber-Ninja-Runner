package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class S8 implements YK {
    public final C2446fp A00 = new C2446fp(new byte[4]);
    public final /* synthetic */ S6 A01;

    public S8(S6 s6) {
        this.A01 = s6;
    }

    @Override // com.facebook.ads.redexgen.core.YK
    public final void A50(C2447fq c2447fq) {
        int tableId = c2447fq.A0I();
        if (tableId != 0) {
            return;
        }
        int tableId2 = c2447fq.A0I();
        if ((tableId2 & 128) == 0) {
            return;
        }
        c2447fq.A0g(6);
        int iA07 = c2447fq.A07() / 4;
        for (int i = 0; i < iA07; i++) {
            c2447fq.A0h(this.A00, 4);
            int programCount = this.A00.A04(16);
            this.A00.A09(3);
            if (programCount == 0) {
                this.A00.A09(13);
            } else {
                int iA04 = this.A00.A04(13);
                if (this.A01.A0B.get(iA04) == null) {
                    this.A01.A0B.put(iA04, new SU(new S7(this.A01, iA04)));
                    S6.A02(this.A01);
                }
            }
        }
        int secondHeaderByte = this.A01.A09;
        if (secondHeaderByte != 2) {
            this.A01.A0B.remove(0);
        }
    }

    @Override // com.facebook.ads.redexgen.core.YK
    public final void AA3(C2461g4 c2461g4, UL ul, YS ys) {
    }
}
