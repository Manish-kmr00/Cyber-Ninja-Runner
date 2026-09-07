package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YD {
    public static String[] A0G = {"oReQJMYo2yqA0D6a8", "LfraKVf73akDf3wHdeEtrWdpsrMW", "zy8EPw", "zPPf4jRPwAUfISJpjTlT", "1d0wAt4ch5A0fQM2dD6rBrPdMZejduvY", "cGtVKnG7L7HY3k9er60UaVenuQYsd", "agFhZy", "S862KrizRInoRwZskDQJ"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public C1948Uc A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;

    public YD() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A00(YD yd) {
        if (!this.A0F) {
            return false;
        }
        if (!yd.A0F) {
            return true;
        }
        C1948Uc c1948Uc = (C1948Uc) AbstractC2388es.A02(this.A09);
        C1948Uc spsData = yd.A09;
        C1948Uc otherSpsData = (C1948Uc) AbstractC2388es.A02(spsData);
        if (this.A03 == yd.A03 && this.A07 == yd.A07 && this.A0C == yd.A0C && ((!this.A0B || !yd.A0B || this.A0A == yd.A0A) && ((this.A05 == yd.A05 || (this.A05 != 0 && yd.A05 != 0)) && ((c1948Uc.A07 != 0 || otherSpsData.A07 != 0 || (this.A06 == yd.A06 && this.A02 == yd.A02)) && (c1948Uc.A07 != 1 || otherSpsData.A07 != 1 || (this.A00 == yd.A00 && this.A01 == yd.A01)))))) {
            boolean z = this.A0E;
            boolean z2 = yd.A0E;
            if (A0G[1].length() != 28) {
                throw new RuntimeException();
            }
            A0G[1] = "xcllOHpY5wD0Xe4YdoBQ1VksF4Lm";
            if (z == z2 && (!this.A0E || this.A04 == yd.A04)) {
                return false;
            }
        }
        return true;
    }

    public final void A02() {
        this.A0D = false;
        this.A0F = false;
    }

    public final void A03(int i) {
        this.A08 = i;
        this.A0D = true;
    }

    public final void A04(C1948Uc c1948Uc, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
        this.A09 = c1948Uc;
        this.A05 = i;
        this.A08 = i2;
        this.A03 = i3;
        this.A07 = i4;
        this.A0C = z;
        this.A0B = z2;
        this.A0A = z3;
        this.A0E = z4;
        this.A04 = i5;
        this.A06 = i6;
        this.A02 = i7;
        this.A00 = i8;
        this.A01 = i9;
        this.A0F = true;
        this.A0D = true;
    }

    public final boolean A05() {
        return this.A0D && (this.A08 == 7 || this.A08 == 2);
    }
}
