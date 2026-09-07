package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2170bL {
    public final int A00;
    public final boolean A01;

    public C2170bL(int i, boolean z) {
        this.A00 = i;
        this.A01 = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2170bL c2170bL = (C2170bL) obj;
        return this.A00 == c2170bL.A00 && this.A01 == c2170bL.A01;
    }

    public final int hashCode() {
        return (this.A00 * 31) + (this.A01 ? 1 : 0);
    }
}
