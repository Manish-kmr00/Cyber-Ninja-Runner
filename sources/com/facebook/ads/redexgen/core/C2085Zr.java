package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2085Zr implements InterfaceC1775Nb {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final boolean A04;
    public final int[] A05;
    public final long[] A06;
    public final Uri[] A07;
    public static String[] A08 = {"5RRO1SDze3tky6cLdb65G29slmd9TZz5", "5c0T1acjGo3ewlB56tHjiHlYYIu", "7cjhsSVYkwZKYICP", "Wp0ScOf0ThjO4lTev1rnXqXJy9GD5rsT", "vO4hUZoX", "OFqRDWv8WYZkTqb1", "eH8ipb", "sREUdleD9XqicAZFDNtccFwydYCBd"};
    public static final String A0G = AbstractC2471gE.A0h(0);
    public static final String A0B = AbstractC2471gE.A0h(1);
    public static final String A0H = AbstractC2471gE.A0h(2);
    public static final String A0F = AbstractC2471gE.A0h(3);
    public static final String A0C = AbstractC2471gE.A0h(4);
    public static final String A0A = AbstractC2471gE.A0h(5);
    public static final String A0D = AbstractC2471gE.A0h(6);
    public static final String A0E = AbstractC2471gE.A0h(7);
    public static final InterfaceC1774Na<C2085Zr> A09 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Zs
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return C2085Zr.A00(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2085Zr A00(Bundle bundle) {
        long j = bundle.getLong(A0G);
        int i = bundle.getInt(A0B);
        int i2 = bundle.getInt(A0E);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A0H);
        int[] intArray = bundle.getIntArray(A0F);
        long[] longArray = bundle.getLongArray(A0C);
        long j2 = bundle.getLong(A0A);
        boolean z = bundle.getBoolean(A0D);
        if (intArray == null) {
            intArray = new int[0];
            if (A08[6].length() != 6) {
                throw new RuntimeException();
            }
            A08[7] = "fFAYVknZwUB9kTFIqkD1N4pW4DGzn";
        }
        Uri[] uriArr = new Uri[0];
        if (parcelableArrayList != null) {
            uriArr = (Uri[]) parcelableArrayList.toArray(uriArr);
        }
        if (longArray == null) {
            longArray = new long[0];
        }
        return new C2085Zr(j, i, i2, intArray, uriArr, longArray, j2, z);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final C2085Zr A06(int i) {
        int[] iArrA02 = A02(this.A05, i);
        long[] jArrA03 = A03(this.A06, i);
        return new C2085Zr(this.A03, i, this.A01, iArrA02, (Uri[]) Arrays.copyOf(this.A07, i), jArrA03, this.A02, this.A04);
    }

    public C2085Zr(long j) {
        this(j, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
    }

    public C2085Zr(long j, int i, int i2, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
        AbstractC2388es.A07(iArr.length == uriArr.length);
        this.A03 = j;
        this.A00 = i;
        this.A01 = i2;
        this.A05 = iArr;
        this.A07 = uriArr;
        this.A06 = jArr;
        this.A02 = j2;
        this.A04 = z;
    }

    public static int[] A02(int[] iArr, int i) {
        int length = iArr.length;
        int iMax = Math.max(i, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        return iArrCopyOf;
    }

    public static long[] A03(long[] jArr, int i) {
        int length = jArr.length;
        int iMax = Math.max(i, length);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
        Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
        return jArrCopyOf;
    }

    public final int A04() {
        return A05(-1);
    }

    public final int A05(int i) {
        int i2 = i + 1;
        while (i2 < nextAdIndexToPlay && !this.A04) {
            int i3 = this.A05[i2];
            if (A08[4].length() == 1) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[5] = "oy0aabLPV2TUpAgC";
            strArr[2] = "dKPmQukuLwBHuA98";
            if (i3 == 0 || this.A05[i2] == 1) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public final boolean A07() {
        if (this.A00 == -1) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = this.A00;
            String[] strArr = A08;
            String str = strArr[5];
            String str2 = strArr[2];
            int length = str.length();
            int i3 = str2.length();
            if (length != i3) {
                throw new RuntimeException();
            }
            A08[0] = "eD8JFjczkT4NcgxULb6Tui01C9VWsN5O";
            if (i < i2) {
                int i4 = this.A05[i];
                if (i4 != 0) {
                    int i5 = this.A05[i];
                    if (i5 != 1) {
                        i++;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public final boolean A08() {
        return this.A00 == -1 || A04() < this.A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2085Zr c2085Zr = (C2085Zr) obj;
        if (this.A03 == c2085Zr.A03 && this.A00 == c2085Zr.A00 && this.A01 == c2085Zr.A01 && Arrays.equals(this.A07, c2085Zr.A07) && Arrays.equals(this.A05, c2085Zr.A05) && Arrays.equals(this.A06, c2085Zr.A06) && this.A02 == c2085Zr.A02 && this.A04 == c2085Zr.A04) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((this.A00 * 31) + this.A01) * 31) + ((int) (this.A03 ^ (this.A03 >>> 32)))) * 31) + Arrays.hashCode(this.A07)) * 31) + Arrays.hashCode(this.A05)) * 31) + Arrays.hashCode(this.A06)) * 31) + ((int) (this.A02 ^ (this.A02 >>> 32)))) * 31) + (this.A04 ? 1 : 0);
    }
}
