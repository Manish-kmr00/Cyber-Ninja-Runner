package com.bytedance.sdk.component.utils;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes13.dex */
public class omh {
    private static final byte[] JG;
    private static final byte[] KZx;
    private static final byte[] ML;
    private static final byte[] Og;
    private static final int SD;
    private static final byte[] ZZv;
    private static final byte[] pA;

    static {
        byte[] bArr = {-1, -40, -1};
        pA = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
        Og = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        KZx = bArr3;
        byte[] bArrPA = pA("BM");
        ZZv = bArrPA;
        ML = pA("GIF87a");
        JG = pA("GIF89a");
        SD = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrPA.length), 6))).intValue();
    }

    public static int pA() {
        return SD;
    }

    public static final String pA(byte[] bArr) {
        if (Og(bArr)) {
            return "jpeg";
        }
        if (KZx(bArr)) {
            return "png";
        }
        if (ZZv(bArr)) {
            return "gif";
        }
        if (ML(bArr)) {
            return "bmp";
        }
        if (JG(bArr)) {
            return "ico";
        }
        return "other";
    }

    private static boolean Og(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = pA;
        return length >= bArr2.length && pA(bArr, bArr2);
    }

    private static boolean KZx(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = Og;
        return length >= bArr2.length && pA(bArr, bArr2);
    }

    private static boolean ZZv(byte[] bArr) {
        return (bArr.length >= 6 && pA(bArr, ML)) || pA(bArr, JG);
    }

    private static boolean ML(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = ZZv;
        return length >= bArr2.length && pA(bArr, bArr2);
    }

    private static boolean JG(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = KZx;
        return length >= bArr2.length && pA(bArr, bArr2);
    }

    private static boolean pA(byte[] bArr, byte[] bArr2) {
        return pA(bArr, bArr2, 0);
    }

    private static boolean pA(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] pA(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
