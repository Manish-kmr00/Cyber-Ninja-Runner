package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TB implements InterfaceC2013Wv {
    public static String[] A01 = {"ppJqPrULb4LekG4I2Ppn2VYPDrgTIjDi", "Up", "YNUP1Tu4NX", "9U7WLokpsYYRGqVKMTbwh28son95n0Iv", "mYvQzbkwQcGYxfwzAk0ENPYKs", "kyOVXftTNjAKzoublqGQ7", "xFtFu0eMM6sFzzbkxb8HfkCTA63H6V", "e7eagt87GkQgQ0LPSoDZmf6JA"};
    public final List<C1853Qh> A00;

    public TB(List<C1853Qh> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final List<C1853Qh> A7N(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final long A7t(int i) {
        AbstractC2388es.A07(i == 0);
        if (A01[1].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[7] = "51ri70RHbdsVJ14y1xSYrmoVi";
        strArr[4] = "BDhYjsiO5QNz85nz8Geo8NB7K";
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A7u() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A8Q(long j) {
        return j < 0 ? 0 : -1;
    }
}
