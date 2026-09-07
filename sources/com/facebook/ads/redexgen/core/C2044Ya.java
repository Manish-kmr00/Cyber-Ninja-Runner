package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2044Ya {
    public final int A00;
    public final long A01;

    public C2044Ya(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static C2044Ya A00(WJ wj, C2447fq c2447fq) throws IOException {
        wj.AG1(c2447fq.A0l(), 0, 8);
        c2447fq.A0f(0);
        int iA0C = c2447fq.A0C();
        long size = c2447fq.A0O();
        return new C2044Ya(iA0C, size);
    }
}
