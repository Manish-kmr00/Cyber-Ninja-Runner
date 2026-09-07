package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class P8 extends IllegalStateException {
    public final int A00;
    public final long A01;
    public final Timeline A02;

    public P8(Timeline timeline, int i, long j) {
        this.A02 = timeline;
        this.A00 = i;
        this.A01 = j;
    }
}
