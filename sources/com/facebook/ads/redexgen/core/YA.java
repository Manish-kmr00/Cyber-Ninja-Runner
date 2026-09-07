package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YA {
    public static byte[] A05;
    public static String[] A06 = {"fR4lZKwwyY21UaXkF2KSQybQkAryBYIv", "BBNVc7U2ctACbRP3a2E57h3fhHnztlXK", "yoJAyiBXkmMFka23Ij1T6RmbtDvrEu9e", "UZfqgXJMubWkLZB", "zNxjtHETiYywuc9jFmfu3Sfi8hfhzC2X", "CKlEoUe4kaZ336bTDZaJOQ438AXZ0DgX", "r7p9ViUR2QSLSaAdpGTCem11RQazgKRx", "lL4JGM7bOqPlXOv90D"};
    public static final byte[] A07;
    public int A00;
    public int A01;
    public byte[] A02;
    public int A03;
    public boolean A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-94, -116, -112, -115, -84, -65, -69, -66, -65, -52, 127, -104, -113, -94, -102, -113, -115, -98, -113, -114, 74, -99, -98, -117, -100, -98, 74, -115, -103, -114, -113, 74, -96, -117, -106, -97, -113};
        if (A06[7].length() == 8) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[2] = "jIfi5ik43O9e41l4y2iWLRVoKrLWuQFv";
        strArr[6] = "4cSBRirLnSorBFapUY246AKD45kfWM41";
        A05 = bArr;
    }

    static {
        A01();
        A07 = new byte[]{0, 0, 1};
    }

    public YA(int i) {
        this.A02 = new byte[i];
    }

    public final void A02() {
        this.A04 = false;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A03(byte[] bArr, int i, int i2) {
        if (!this.A04) {
            return;
        }
        int i3 = i2 - i;
        int length = this.A02.length;
        int readLength = this.A00;
        if (length < readLength + i3) {
            byte[] bArr2 = this.A02;
            int readLength2 = this.A00;
            this.A02 = Arrays.copyOf(bArr2, (readLength2 + i3) * 2);
        }
        byte[] bArr3 = this.A02;
        int readLength3 = this.A00;
        System.arraycopy(bArr, i, bArr3, readLength3, i3);
        int readLength4 = this.A00;
        this.A00 = readLength4 + i3;
    }

    public final boolean A04(int i, int i2) {
        int i3 = this.A03;
        String strA00 = A00(10, 27, 10);
        String strA01 = A00(0, 10, 58);
        switch (i3) {
            case 0:
                String[] strArr = A06;
                if (strArr[2].charAt(5) != strArr[6].charAt(5)) {
                    throw new RuntimeException();
                }
                A06[7] = "e3zaxyq8ZNS";
                if (i == 176) {
                    this.A03 = 1;
                    this.A04 = true;
                }
                break;
            case 1:
                if (i != 181) {
                    AbstractC2432fb.A07(strA01, strA00);
                    A02();
                } else {
                    this.A03 = 2;
                }
                break;
            case 2:
                if (i > 31) {
                    AbstractC2432fb.A07(strA01, strA00);
                    A02();
                } else {
                    this.A03 = 3;
                }
                break;
            case 3:
                if ((i & 240) != 32) {
                    AbstractC2432fb.A07(strA01, strA00);
                    A02();
                } else {
                    this.A01 = this.A00;
                    this.A03 = 4;
                }
                break;
            case 4:
                if (i == 179 || i == 181) {
                    this.A00 -= i2;
                    this.A04 = false;
                    return true;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        A03(A07, 0, A07.length);
        return false;
    }
}
