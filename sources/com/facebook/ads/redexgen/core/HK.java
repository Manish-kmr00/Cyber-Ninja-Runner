package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HK {
    public String A02;
    public String A03;
    public String A04;
    public final C12602a A06;
    public final C12732n A07;
    public final C2699k1 A08;
    public C12622c A01 = C12622c.A01(null);
    public int A00 = 1000;
    public boolean A05 = false;

    public HK(C2699k1 c2699k1, C12602a c12602a, C12732n c12732n) {
        this.A08 = c2699k1;
        this.A06 = c12602a;
        this.A07 = c12732n;
    }

    public final HK A09(int i) {
        this.A00 = i;
        return this;
    }

    public final HK A0A(C12622c c12622c) {
        this.A01 = c12622c;
        return this;
    }

    public final HK A0B(String str) {
        this.A04 = str;
        return this;
    }

    public final HK A0C(String str) {
        this.A02 = str;
        return this;
    }

    public final HK A0D(String str) {
        this.A03 = str;
        return this;
    }

    public final HK A0E(boolean z) {
        this.A05 = z;
        return this;
    }

    public final HM A0F() {
        return new HM(this, null);
    }
}
