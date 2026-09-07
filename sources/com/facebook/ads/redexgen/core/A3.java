package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class A3 {
    public double A00;
    public A9 A01;
    public AA A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final A3 A00(double d) {
        this.A00 = d;
        return this;
    }

    public final A3 A01(A9 a9) {
        this.A01 = a9;
        return this;
    }

    public final A3 A02(AA aa) {
        this.A02 = aa;
        return this;
    }

    public final A3 A03(String str) {
        this.A03 = str;
        return this;
    }

    public final A3 A04(String str) {
        this.A04 = str;
        return this;
    }

    public final A3 A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final A3 A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final A4 A07(AnonymousClass85 anonymousClass85) {
        return new A4(anonymousClass85, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
