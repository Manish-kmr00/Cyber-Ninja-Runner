package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class R2 {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final Timeline A06;
    public final Timeline A07;
    public final R5 A08;
    public final R5 A09;

    public R2(long j, Timeline timeline, int i, R5 r5, long j2, Timeline timeline2, int i2, R5 r6, long j3, long j4) {
        this.A04 = j;
        this.A07 = timeline;
        this.A01 = i;
        this.A09 = r5;
        this.A03 = j2;
        this.A06 = timeline2;
        this.A00 = i2;
        this.A08 = r6;
        this.A02 = j3;
        this.A05 = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        R2 r2 = (R2) obj;
        if (this.A04 == r2.A04 && this.A01 == r2.A01 && this.A03 == r2.A03 && this.A00 == r2.A00 && this.A02 == r2.A02 && this.A05 == r2.A05 && AbstractC1813Or.A01(this.A07, r2.A07) && AbstractC1813Or.A01(this.A09, r2.A09) && AbstractC1813Or.A01(this.A06, r2.A06) && AbstractC1813Or.A01(this.A08, r2.A08)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1813Or.A00(Long.valueOf(this.A04), this.A07, Integer.valueOf(this.A01), this.A09, Long.valueOf(this.A03), this.A06, Integer.valueOf(this.A00), this.A08, Long.valueOf(this.A02), Long.valueOf(this.A05));
    }
}
