package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EF {
    public int A00;
    public DB A01;
    public EJ A02;
    public String A03;
    public String A04;
    public String A05;
    public String A06;
    public final C2699k1 A0C;
    public boolean A0A = true;
    public boolean A0B = true;
    public boolean A09 = true;
    public boolean A07 = true;
    public boolean A08 = true;

    public EF(C2699k1 c2699k1, EJ ej) {
        this.A0C = c2699k1;
        this.A02 = ej;
    }

    public final EF A0D(int i) {
        this.A00 = i;
        return this;
    }

    public final EF A0E(DB db) {
        this.A01 = db;
        return this;
    }

    public final EF A0F(String str) {
        this.A03 = str;
        return this;
    }

    public final EF A0G(String str) {
        this.A04 = str;
        return this;
    }

    public final EF A0H(String str) {
        this.A05 = str;
        return this;
    }

    public final EF A0I(String str) {
        this.A06 = str;
        return this;
    }

    public final EF A0J(boolean z) {
        this.A09 = z;
        return this;
    }

    public final EF A0K(boolean z) {
        this.A0A = z;
        return this;
    }

    public final EF A0L(boolean z) {
        this.A0B = z;
        return this;
    }

    public final EG A0M() {
        return new EG(this, null);
    }
}
