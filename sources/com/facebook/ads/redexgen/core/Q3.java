package com.facebook.ads.redexgen.core;

import java.util.Random;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Q3 {
    public int A00;
    public int A01;
    public int A02;
    public final /* synthetic */ Q4 A03;

    public Q3(Q4 q4, int i, int i2, int i3) {
        this.A03 = q4;
        this.A00 = i;
        this.A01 = i2;
        this.A02 = i3;
    }

    public final int A00() {
        Random random = new Random();
        if (random.nextInt(this.A02) == 0) {
            if (this.A01 <= 0) {
                return this.A00;
            }
            int variation = random.nextInt() % this.A01;
            return this.A00 + variation;
        }
        return 0;
    }
}
