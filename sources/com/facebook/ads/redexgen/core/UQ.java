package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class UQ {
    public static String[] A00 = {"qqSjYRVL0R4fOMN6eq6tSyIMmtx", "KP4nRrv428Hi8uh0HjHwFhMttEs5a1Ws", "LVI3yirONzj2Zw0xw1SQSP5O1xd", "DFzc4cRZ57hsSJTWwhddxQOyPP6jqw5w", "BpLMl61cVYQ3dcIR9aLdYxvi", "8aNAk6KmhJc4kEDFNE0kOxFy9v4j7Ks9", "JjWuqH3aS1ZUDRahEI0", "1oeql7WXepFii08NbpOX9aWyub"};

    public static int A00(C2447fq c2447fq, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return c2447fq.A0I() + 1;
            case 7:
                int iA0M = c2447fq.A0M() + 1;
                String[] strArr = A00;
                if (strArr[1].charAt(0) == strArr[3].charAt(0)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[2] = "8XRXBGdvMB3isTuVSVPqRVOV7sB";
                strArr2[0] = "UQ4CEnA7MEA7Yi4zsJCWCd1PAkZ";
                return iA0M;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long A01(WJ wj, UU uu) throws IOException {
        wj.AHr();
        boolean z = true;
        wj.A3x(1);
        byte[] bArr = new byte[1];
        wj.AG1(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        wj.A3x(2);
        int i = z ? 7 : 6;
        C2447fq c2447fq = new C2447fq(i);
        c2447fq.A0e(UM.A00(wj, c2447fq.A0l(), 0, i));
        wj.AHr();
        UP up = new UP();
        boolean isBlockSizeVariable = A09(c2447fq, uu, z, up);
        if (isBlockSizeVariable) {
            return up.A00;
        }
        throw Q6.A01(null, null);
    }

    public static boolean A02(int i, UU uu) {
        return i == 0 || i == uu.A01;
    }

    public static boolean A03(int i, UU uu) {
        if (i <= 7) {
            return i == uu.A02 - 1;
        }
        if (A00[5].charAt(14) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[2] = "HwXvlN3qEirPFregv5DZoqvrW2m";
        strArr[0] = "hQTSzMKv3DY9CnNfAtnvRRSs3ar";
        if (i > 10) {
            return false;
        }
        int i2 = uu.A02;
        if (A00[5].charAt(14) != 'D') {
            throw new RuntimeException();
        }
        A00[5] = "zl64vn1JzbjvqODNTESJMNSzKvPMpryG";
        return i2 == 2;
    }

    public static boolean A04(WJ wj, UU uu, int i, UP up) throws IOException {
        long jA8Y = wj.A8Y();
        byte[] bArr = new byte[2];
        wj.AG1(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            wj.AHr();
            wj.A3x((int) (jA8Y - wj.A8d()));
            return false;
        }
        C2447fq c2447fq = new C2447fq(16);
        System.arraycopy(bArr, 0, c2447fq.A0l(), 0, 2);
        byte[] frameStartBytes = c2447fq.A0l();
        c2447fq.A0e(UM.A00(wj, frameStartBytes, 2, 14));
        wj.AHr();
        wj.A3x((int) (jA8Y - wj.A8d()));
        return A08(c2447fq, uu, i, up);
    }

    public static boolean A05(C2447fq c2447fq, int i) {
        int iA0I = c2447fq.A0I();
        int crc = c2447fq.A09();
        return iA0I == AbstractC2471gE.A0J(c2447fq.A0l(), i, crc + (-1), 0);
    }

    public static boolean A06(C2447fq c2447fq, UU uu, int i) {
        int iA00 = A00(c2447fq, i);
        if (iA00 != -1) {
            int blockSizeSamples = uu.A03;
            if (iA00 <= blockSizeSamples) {
                return true;
            }
        }
        return false;
    }

    public static boolean A07(C2447fq c2447fq, UU uu, int i) {
        int i2 = uu.A07;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == uu.A08;
        }
        if (A00[5].charAt(14) == 'D') {
            String[] strArr = A00;
            strArr[2] = "a51rRKuZV2cXItaFxpZ6X9EnWsR";
            strArr[0] = "AKkBhzIZAxOSYRj7iMxGlmVkBg0";
            if (i == 12) {
                return c2447fq.A0I() * 1000 == i2;
            }
            String[] strArr2 = A00;
            if (strArr2[2].length() == strArr2[0].length()) {
                A00[7] = "KY5QUBl3";
                if (i > 14) {
                    return false;
                }
                int expectedSampleRate = c2447fq.A0M();
                if (i == 14) {
                    expectedSampleRate *= 10;
                }
                return expectedSampleRate == i2;
            }
        }
        throw new RuntimeException();
    }

    public static boolean A08(C2447fq c2447fq, UU uu, int i, UP up) {
        int iA09 = c2447fq.A09();
        long jA0Q = c2447fq.A0Q();
        long frameHeaderBytes = jA0Q >>> 16;
        if (frameHeaderBytes != i) {
            return false;
        }
        int blockSizeKey = (int) ((jA0Q >> 8) & 15);
        long frameHeaderBytes2 = jA0Q >> 1;
        int frameStartPosition = (int) (frameHeaderBytes2 & 7);
        return A03((int) ((jA0Q >> 4) & 15), uu) && A02(frameStartPosition, uu) && !(((jA0Q & 1) > 1L ? 1 : ((jA0Q & 1) == 1L ? 0 : -1)) == 0) && A09(c2447fq, uu, (((jA0Q >>> 16) & 1) > 1L ? 1 : (((jA0Q >>> 16) & 1) == 1L ? 0 : -1)) == 0, up) && A06(c2447fq, uu, (int) ((jA0Q >> 12) & 15)) && A07(c2447fq, uu, blockSizeKey) && A05(c2447fq, iA09);
    }

    public static boolean A09(C2447fq c2447fq, UU uu, boolean z, UP up) {
        long utf8Value;
        try {
            long jA0S = c2447fq.A0S();
            if (z) {
                utf8Value = jA0S;
            } else {
                long utf8Value2 = uu.A03;
                utf8Value = utf8Value2 * jA0S;
            }
            up.A00 = utf8Value;
            if (A00[5].charAt(14) != 'D') {
                throw new RuntimeException();
            }
            A00[7] = "mwGlELxCLBAXeWiE";
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
