package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.ColorInfo;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O7 {
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public O7() {
        this.A01 = -1;
        this.A00 = -1;
        this.A02 = -1;
    }

    public O7(ColorInfo colorInfo) {
        this.A01 = colorInfo.A02;
        this.A00 = colorInfo.A01;
        this.A02 = colorInfo.A03;
        this.A03 = colorInfo.A04;
    }

    public /* synthetic */ O7(ColorInfo colorInfo, O6 o6) {
        this(colorInfo);
    }

    public final O7 A00(int i) {
        this.A00 = i;
        return this;
    }

    public final O7 A01(int i) {
        this.A01 = i;
        return this;
    }

    public final O7 A02(int i) {
        this.A02 = i;
        return this;
    }

    public final ColorInfo A03() {
        return new ColorInfo(this.A01, this.A00, this.A02, this.A03);
    }
}
