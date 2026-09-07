package com.facebook.ads.redexgen.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XD {
    public X7 A00;
    public X9 A01;
    public final int A02;
    public final int A03;
    public final SparseArray<XB> A08 = new SparseArray<>();
    public final SparseArray<X6> A06 = new SparseArray<>();
    public final SparseArray<X8> A07 = new SparseArray<>();
    public final SparseArray<X6> A04 = new SparseArray<>();
    public final SparseArray<X8> A05 = new SparseArray<>();

    public XD(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    public final void A00() {
        this.A08.clear();
        this.A06.clear();
        this.A07.clear();
        this.A04.clear();
        this.A05.clear();
        this.A00 = null;
        this.A01 = null;
    }
}
