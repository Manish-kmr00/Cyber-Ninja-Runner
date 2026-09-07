package com.facebook.ads.redexgen.core;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1978Vl {
    public final int A00;
    public final long A01;

    public C1978Vl(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public /* synthetic */ C1978Vl(int i, long j, C1977Vk c1977Vk) {
        this(i, j);
    }

    public static C1978Vl A00(Parcel parcel) {
        return new C1978Vl(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
