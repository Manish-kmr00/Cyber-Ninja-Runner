package com.facebook.ads.redexgen.core;

import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1838Pq implements InterfaceC2335e1 {
    public final int A00;

    public C1838Pq() {
        this(-1);
    }

    public C1838Pq(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2335e1
    public final int A8P(int i) {
        if (this.A00 == -1) {
            if (i == 7) {
                return 6;
            }
            return 3;
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2335e1
    public final long A8k(C2334e0 c2334e0) {
        IOException iOException = c2334e0.A03;
        if ((iOException instanceof Q6) || (iOException instanceof FileNotFoundException) || (iOException instanceof C5I) || (iOException instanceof C2345eB) || C2311dc.A06(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((c2334e0.A00 - 1) * 1000, 5000);
    }
}
