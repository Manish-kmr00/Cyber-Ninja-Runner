package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2040Xw implements Comparable<C2040Xw> {
    public final int A00;
    public final C2031Xn A01;

    public C2040Xw(int i, C2031Xn c2031Xn) {
        this.A00 = i;
        this.A01 = c2031Xn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C2040Xw c2040Xw) {
        return Integer.compare(this.A00, c2040Xw.A00);
    }
}
