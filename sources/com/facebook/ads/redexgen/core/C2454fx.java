package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2454fx {
    public static byte[] A02;
    public static String[] A03 = {"6LSk8vmCybkn5q9EMQmazCjUkkyprp6m", "u13GSQLWnZfIvMiC8CngCOg", "IPAOVoqPVWjFC8rdgkz5jJxhQnAZUKZy", "gKMJdAPVEH8XQs9epIgJONAR6NtJLXJp", "XOVw4mOAcLc616KwRRFBarzNgS", "WO1mCvac6Q8jQd73Zg6ibi7EIhv6USk4", "Okq", "ro2svsnYT1XkXSpZ2WcZu3Lxz4eZRw63"};
    public static final C2454fx A04;
    public static final C2454fx A05;
    public final int A00;
    public final int A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {40};
        if (A03[5].charAt(12) == 'i') {
            throw new RuntimeException();
        }
        A03[5] = "hcNk43lt01C8AkUazfuDIRzHm94TOv7o";
        A02 = bArr;
    }

    static {
        A01();
        A04 = new C2454fx(-1, -1);
        A05 = new C2454fx(0, 0);
    }

    public C2454fx(int i, int i2) {
        AbstractC2388es.A07((i == -1 || i >= 0) && (i2 == -1 || i2 >= 0));
        this.A01 = i;
        this.A00 = i2;
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A01;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2454fx)) {
            return false;
        }
        C2454fx c2454fx = (C2454fx) obj;
        return this.A01 == c2454fx.A01 && this.A00 == c2454fx.A00;
    }

    public final int hashCode() {
        return this.A00 ^ ((this.A01 << 16) | (this.A01 >>> 16));
    }

    public final String toString() {
        return this.A01 + A00(0, 1, 109) + this.A00;
    }
}
