package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Y0 {
    public static byte[] A00;
    public static String[] A01 = {"OyM0sm", "9LkwZMEZqZ1wUZeQDWg", "kzkBngDDwGN4g4F4WnIJLXmD5Xx23rBe", "1S", "TtSy8Bl73Or", "3eaX9kQyKWS", "6e4GC9", "nlD7DE22s1TlKm8CeE"};
    public static final Pattern A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{60, 38, 81, 108, 100, 113, 119, 96, 113, 112, 52, 67, 81, 86, 66, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 58, 52, 83, 123, 96, 52, 35, Ascii.SYN, 1, Ascii.DLE, Ascii.SYN, Ascii.GS, 7, Ascii.DC2, Ascii.DC4, Ascii.SYN, 0, 83, Ascii.RS, 6, 0, 7, 83, Ascii.SYN, Ascii.GS, Ascii.ETB, 83, 4, Ascii.SUB, 7, Ascii.ESC, 83, 86, Ascii.ETB, 5, 2, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.DC2, 96, 34, 50, 51, 40, 57, 84, 39, 92, 117, 33, 82, 86, 85, 67, 88};
    }

    static {
        A03();
        A02 = Pattern.compile(A02(58, 15, 105));
    }

    public static float A00(String str) throws NumberFormatException {
        if (str.endsWith(A02(0, 1, 12))) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException(A02(23, 27, 102));
    }

    public static long A01(String str) throws NumberFormatException {
        long j = 0;
        String[] subparts = AbstractC2471gE.A1P(str, A02(56, 2, 91));
        for (String str2 : AbstractC2471gE.A1O(subparts[0], A02(1, 1, 9))) {
            long value = Long.parseLong(str2);
            j = (60 * j) + value;
        }
        long j2 = j * 1000;
        int length = subparts.length;
        String[] parts = A01;
        if (parts[1].length() == parts[7].length()) {
            throw new RuntimeException();
        }
        String[] parts2 = A01;
        parts2[1] = "5nSMsfcQTIWvKN7i8rP";
        parts2[7] = "57J361HlMkztxWpQdR";
        if (length == 2) {
            long value2 = Long.parseLong(subparts[1]);
            j2 += value2;
        }
        return 1000 * j2;
    }

    public static void A04(C2447fq c2447fq) throws Q6 {
        int iA09 = c2447fq.A09();
        if (A05(c2447fq)) {
            return;
        }
        c2447fq.A0f(iA09);
        throw Q6.A01(A02(2, 21, 1) + c2447fq.A0T(), null);
    }

    public static boolean A05(C2447fq c2447fq) {
        String strA0T = c2447fq.A0T();
        if (strA0T != null) {
            String line = A02(50, 6, 85);
            if (strA0T.startsWith(line)) {
                return true;
            }
        }
        return false;
    }
}
