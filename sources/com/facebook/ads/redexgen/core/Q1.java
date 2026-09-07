package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q1 {
    public final int A00;
    public final int A01;

    public Q1(int i, int i2) {
        this.A01 = i;
        this.A00 = i2;
    }

    public final int A00() {
        switch (this.A00) {
            case 2:
                return 10;
            case 5:
                return 11;
            case 22:
                return 1073741824;
            case 23:
                return 15;
            case 29:
                return 12;
            case 42:
                return 16;
            default:
                return 0;
        }
    }
}
