package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2269cw implements Comparable<C2269cw> {
    public final boolean A00;
    public final boolean A01;

    public C2269cw(ZM zm, int i) {
        this.A00 = (zm.A0H & 1) != 0;
        this.A01 = C13555u.A0S(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C2269cw c2269cw) {
        return AbstractC2766l7.A01().A09(this.A01, c2269cw.A01).A09(this.A00, c2269cw.A00).A05();
    }
}
