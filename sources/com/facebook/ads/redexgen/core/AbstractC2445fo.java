package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2445fo extends AbstractC1594Ft {
    public static byte[] A00;

    static {
        A0B();
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{106, 111, 111, 110, 127, 106, 98, 103, 120};
    }

    public abstract void A1B();

    public abstract void A1C();

    public abstract void A1D();

    public abstract boolean A1E();

    public abstract boolean A1F();

    public AbstractC2445fo(C1598Fx c1598Fx, boolean z) {
        super(c1598Fx, z);
        if (C14499m.A16(c1598Fx.A05())) {
            if (c1598Fx.A0B() != null) {
                c1598Fx.A0B().setCTAClickListener(getCtaButton());
            }
            getTitleDescContainer().setCTAClickListener(getCtaButton());
        }
    }

    public final void A1A() {
        if (C14499m.A16(this.A06.A05()) && this.A06.A0B() != null) {
            this.A06.A0B().setCTAClickListener(getCtaButton());
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public ViewOnClickListenerC2488gW getCtaButton() {
        return super.getCtaButton();
    }

    public void setAdDetailsClickListener(FH fh) {
        if (C14499m.A16(this.A06.A05()) && fh != null) {
            fh.setOnClickListener(AbstractC1591Fq.A03(getCtaButton(), A0A(0, 9, 29)));
        }
    }

    public void setupNativeCtaExtension(C1629Hc c1629Hc) {
    }
}
