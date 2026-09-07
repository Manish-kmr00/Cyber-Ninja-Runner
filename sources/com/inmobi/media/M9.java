package com.inmobi.media;

/* JADX INFO: loaded from: classes6.dex */
public final class M9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3136a = 0;
    public int b = 0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M9)) {
            return false;
        }
        M9 m9 = (M9) obj;
        return this.f3136a == m9.f3136a && this.b == m9.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f3136a) * 31);
    }

    public final String toString() {
        return "PurchaseData(noOfInAppPurchases=" + this.f3136a + ", noOfSubscriptions=" + this.b + ')';
    }
}
