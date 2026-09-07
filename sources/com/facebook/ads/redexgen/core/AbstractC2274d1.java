package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.AbstractC2274d1;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2274d1<T extends AbstractC2274d1<T>> {
    public final int A00;
    public final int A01;
    public final ZM A02;
    public final C2046Yc A03;

    public abstract int A08();

    public abstract boolean A09(T t);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.d1 != com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TrackInfo<T extends com.facebook.ads.redexgen.X.d1<T>> */
    public AbstractC2274d1(int i, C2046Yc c2046Yc, int i2) {
        this.A00 = i;
        this.A03 = c2046Yc;
        this.A01 = i2;
        this.A02 = c2046Yc.A08(i2);
    }
}
