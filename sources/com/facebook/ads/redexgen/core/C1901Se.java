package com.facebook.ads.redexgen.core;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Se, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1901Se implements YK {
    public ZM A00;
    public InterfaceC1957Uo A01;
    public C2461g4 A02;

    public C1901Se(String str) {
        this.A00 = new P5().A11(str).A14();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void A00() {
        AbstractC2388es.A02(this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.YK
    public final void A50(C2447fq c2447fq) {
        A00();
        long jA03 = this.A02.A03();
        long jA04 = this.A02.A04();
        if (jA03 == -9223372036854775807L || jA04 == -9223372036854775807L) {
            return;
        }
        if (jA04 != this.A00.A0M) {
            this.A00 = this.A00.A07().A0s(jA04).A14();
            this.A01.A6U(this.A00);
        }
        int iA07 = c2447fq.A07();
        this.A01.AHx(c2447fq, iA07);
        this.A01.AI0(jA03, 1, iA07, 0, null);
    }

    @Override // com.facebook.ads.redexgen.core.YK
    public final void AA3(C2461g4 c2461g4, UL ul, YS ys) {
        this.A02 = c2461g4;
        ys.A05();
        this.A01 = ul.AJX(ys.A03(), 5);
        this.A01.A6U(this.A00);
    }
}
