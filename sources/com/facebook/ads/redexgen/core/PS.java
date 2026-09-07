package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PS {
    public static boolean A00;
    public static String A01;
    public static byte[] A02;
    public static String[] A03 = {"y8", "W69aXxwfLdDCUuvOQnWkti4CbO80710w", "wboET6kAIPIrP0kk7nrsubpVVimjkQDJ", "qLQ3E54P9QUaqYwPtcANQ", "QmBSSuLAZYEjKuQvpgPXG3BYQbrKFxf0", "uf", "wqdBxIuKersAyrdPXMiJWEDDacu7LRyA", "8ah24QQc"};
    public static final HashSet<String> A04;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A03[2].charAt(6) == 'u') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "ebeSnx53A00YUYp6cxgobwVSuLDf30R2";
            strArr[7] = "XYbVMrIk";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-106, -118, -67, -59, -59, -67, -124, -69, -50, -59, -124, -71, -59, -56, -69};
    }

    static {
        A02();
        A00 = true;
        A04 = new HashSet<>();
        A01 = A01(2, 13, 2);
    }

    public static synchronized String A00() {
        return A01;
    }

    public static synchronized void A03(String str) {
        if (A04.add(str)) {
            A01 += A01(0, 2, 22) + str;
        }
    }
}
