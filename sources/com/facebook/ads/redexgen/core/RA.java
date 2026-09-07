package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RA implements InterfaceC2180bV {
    public static String[] A03 = {"42m2DpMe8IoAz0rTI464MD0517gWX8y9", "QPrcgglPxuYzdHE4UTwwPFhyOLxBO4Nm", "bnUVmnYAiMDpjPKG02CtRsRq3Be9rl1s", "8", "u57ATUEcIElDtXS5M9spyajicequP9Y6", "G7vXdmUqiPV42TEkEHsKT2AdNVkXF2DU", "mfdeCB", "NSGpNmFtxO56L2rCnxl08rNKgIfWfBB1"};
    public boolean A00;
    public final InterfaceC2180bV A01;
    public final /* synthetic */ C14248m A02;

    public RA(C14248m c14248m, InterfaceC2180bV interfaceC2180bV) {
        this.A02 = c14248m;
        this.A01 = interfaceC2180bV;
    }

    public final void A00() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2180bV
    public final boolean AAT() {
        return !this.A02.A03() && this.A01.AAT();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2180bV
    public final void ABm() throws IOException {
        this.A01.ABm();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x0043, please report this as an issue */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2180bV
    public final int AGX(P6 p6, C2014Ww c2014Ww, int i) {
        int i2;
        if (this.A02.A03()) {
            return -3;
        }
        if (this.A00) {
            c2014Ww.A02(4);
            return -4;
        }
        int iAGX = this.A01.AGX(p6, c2014Ww, i);
        if (iAGX != -5) {
            if (this.A02.A00 != Long.MIN_VALUE && ((iAGX == -4 && c2014Ww.A01 >= this.A02.A00) || (iAGX == -3 && this.A02.A6y() == Long.MIN_VALUE && !c2014Ww.A04))) {
                c2014Ww.A0A();
                c2014Ww.A02(4);
                this.A00 = true;
                return -4;
            }
            return iAGX;
        }
        ZM zm = (ZM) AbstractC2388es.A01(p6.A00);
        int result = zm.A08;
        if (result == 0) {
            int i3 = zm.A09;
            if (A03[3].length() == 9) {
                throw new RuntimeException();
            }
            A03[6] = "Y0fq0g";
            if (i3 != 0) {
                if (this.A02.A01 != 0) {
                    i2 = 0;
                } else {
                    i2 = zm.A08;
                }
                p6.A00 = zm.A07().A0d(i2).A0e(this.A02.A00 == Long.MIN_VALUE ? zm.A09 : 0).A14();
            }
        } else {
            if (this.A02.A01 != 0) {
                i2 = 0;
            } else {
                i2 = zm.A08;
            }
            p6.A00 = zm.A07().A0d(i2).A0e(this.A02.A00 == Long.MIN_VALUE ? zm.A09 : 0).A14();
        }
        return -5;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2180bV
    public final int AJ8(long j) {
        if (!this.A02.A03()) {
            return this.A01.AJ8(j);
        }
        if (A03[3].length() == 9) {
            throw new RuntimeException();
        }
        A03[7] = "7SVSbkIroC59AU65c36VsMa3iQLpFfkN";
        return -3;
    }
}
