package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.DrmInitData;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class UI {
    public static byte[] A00;
    public static String[] A01 = {"PbWJcmgEqcJQjjwB6VLPd", "tkTYOWKHragR9UPT1W1nuf", "QVMhx2tT3xErvCLPidA6CjERltcQzimg", "Z2IOdsKIeItRWRPGlNoB9IJnEl", "xLx2nXLuxI6bZJYzHF4Ge", "nA63UMb6dkdF2udehO", "XriuJJGqYAIIEn7GC0jIz65RNx9SnM7V", "55ZVIjHA259pYpYa2UAGgYPDCX4zj5rH"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 27);
            if (A01[1].length() != 22) {
                throw new RuntimeException();
            }
            A01[3] = "kfBlyCDQRkNI";
            bArrCopyOfRange[i4] = b;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        byte[] bArr = {42, 62, 47, 34, 36, 100, Base64.padSymbol, 37, 47, 101, 47, 63, 56};
        String[] strArr = A01;
        if (strArr[6].charAt(3) == strArr[7].charAt(3)) {
            throw new RuntimeException();
        }
        A01[1] = "vxIvww3gX5SaH4cngqUXEl";
        A00 = bArr;
    }

    static {
        A06();
        A02 = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        A03 = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        A04 = new int[]{64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, IronSourceConstants.IS_AD_UNIT_CAPPED, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    }

    public static int A00(ByteBuffer byteBuffer) {
        int nblks;
        int iPosition = byteBuffer.position();
        int position = byteBuffer.get(iPosition);
        switch (position) {
            case -2:
                int position2 = iPosition + 5;
                int i = (byteBuffer.get(position2) & 1) << 6;
                int position3 = iPosition + 4;
                nblks = i | ((byteBuffer.get(position3) & 252) >> 2);
                break;
            case -1:
                int position4 = iPosition + 4;
                int i2 = (byteBuffer.get(position4) & 7) << 4;
                int position5 = iPosition + 7;
                nblks = i2 | ((byteBuffer.get(position5) & 60) >> 2);
                break;
            case 31:
                int position6 = iPosition + 5;
                int i3 = (byteBuffer.get(position6) & 7) << 4;
                int position7 = iPosition + 6;
                nblks = i3 | ((byteBuffer.get(position7) & 60) >> 2);
                break;
            default:
                int position8 = iPosition + 4;
                int i4 = (byteBuffer.get(position8) & 1) << 6;
                int position9 = iPosition + 5;
                nblks = i4 | ((byteBuffer.get(position9) & 252) >> 2);
                break;
        }
        int position10 = nblks + 1;
        return position10 * 32;
    }

    public static int A01(byte[] bArr) {
        int i;
        boolean z = false;
        switch (bArr[0]) {
            case -2:
                i = (((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4) | ((bArr[6] & 240) >> 4)) + 1;
                break;
            case -1:
                i = (((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4) | ((bArr[9] & 60) >> 2)) + 1;
                z = true;
                break;
            case 31:
                i = (((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4) | ((bArr[8] & 60) >> 2)) + 1;
                z = true;
                break;
            default:
                i = (((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4) | ((bArr[7] & 240) >> 4)) + 1;
                break;
        }
        return z ? (i * 16) / 14 : i;
    }

    public static int A02(byte[] bArr) {
        int i;
        switch (bArr[0]) {
            case -2:
                int nblks = bArr[5];
                i = ((nblks & 1) << 6) | ((bArr[4] & 252) >> 2);
                break;
            case -1:
                i = ((bArr[4] & 7) << 4) | ((bArr[7] & 60) >> 2);
                break;
            case 31:
                i = ((bArr[5] & 7) << 4) | ((bArr[6] & 60) >> 2);
                break;
            default:
                i = ((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2);
                break;
        }
        int nblks2 = i + 1;
        return nblks2 * 32;
    }

    public static ZM A03(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int sfreq;
        C2446fp c2446fpA04 = A04(bArr);
        c2446fpA04.A09(60);
        int amode = c2446fpA04.A04(6);
        int rate = A02[amode];
        int amode2 = c2446fpA04.A04(4);
        int sampleRate = A03[amode2];
        int amode3 = c2446fpA04.A04(5);
        if (amode3 >= A04.length) {
            sfreq = -1;
        } else {
            int sfreq2 = A04[amode3] * 1000;
            sfreq = sfreq2 / 2;
        }
        c2446fpA04.A09(10);
        int amode4 = A01[2].charAt(28);
        if (amode4 == 114) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "5t2oPEoC53D4eOMTP8AgHfWh8GQd1j84";
        strArr[7] = "osJtV6zrfIAFnpZO5kwdHchVUF9KsfN4";
        return new P5().A0y(str).A11(A05(0, 13, 80)).A0a(sfreq).A0b(rate + (c2446fpA04.A04(2) > 0 ? 1 : 0)).A0m(sampleRate).A0u(drmInitData).A10(str2).A14();
    }

    public static C2446fp A04(byte[] bArr) {
        if (bArr[0] == 127) {
            return new C2446fp(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (A08(bArrCopyOf)) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b = bArrCopyOf[i];
                bArrCopyOf[i] = bArrCopyOf[i + 1];
                bArrCopyOf[i + 1] = b;
            }
        }
        C2446fp c2446fp = new C2446fp(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            C2446fp c2446fp2 = new C2446fp(bArrCopyOf);
            while (c2446fp2.A01() >= 16) {
                c2446fp2.A09(2);
                c2446fp.A0B(c2446fp2.A04(14), 14);
            }
        }
        c2446fp.A0D(bArrCopyOf);
        if (A01[3].length() == 27) {
            throw new RuntimeException();
        }
        A01[5] = "X6d7Dq6RdGkC6amMRe";
        return c2446fp;
    }

    public static boolean A07(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static boolean A08(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
