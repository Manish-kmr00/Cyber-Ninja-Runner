package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UA {
    public static final UA A03 = new UA(-3, -9223372036854775807L, -1);
    public final int A00;
    public final long A01;
    public final long A02;

    public UA(int i, long j, long j2) {
        this.A00 = i;
        this.A02 = j;
        this.A01 = j2;
    }

    public static UA A03(long j) {
        return new UA(0, -9223372036854775807L, j);
    }

    public static UA A04(long j, long j2) {
        return new UA(-1, j, j2);
    }

    public static UA A05(long j, long j2) {
        return new UA(-2, j, j2);
    }
}
