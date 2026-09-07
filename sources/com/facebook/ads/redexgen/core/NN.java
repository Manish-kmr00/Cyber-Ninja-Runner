package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NN {
    public int A01 = 0;
    public int A02 = 0;
    public int A04 = 1;
    public int A00 = 1;
    public int A03 = 0;

    public final NN A00(int i) {
        this.A00 = i;
        return this;
    }

    public final NN A01(int i) {
        this.A01 = i;
        return this;
    }

    public final NN A02(int i) {
        this.A02 = i;
        return this;
    }

    public final NN A03(int i) {
        this.A03 = i;
        return this;
    }

    public final NN A04(int i) {
        this.A04 = i;
        return this;
    }

    public final C2080Zm A05() {
        return new C2080Zm(this.A01, this.A02, this.A04, this.A00, this.A03);
    }
}
