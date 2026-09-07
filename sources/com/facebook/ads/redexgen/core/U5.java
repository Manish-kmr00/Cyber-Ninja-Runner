package com.facebook.ads.redexgen.core;

import com.amazon.device.ads.DtbConstants;
import com.google.android.exoplayer2.DrmInitData;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class U5 {
    public static byte[] A00;
    public static String[] A01 = {"EDbMaNnOAmY0RUAoa81bsdHC4j8WXcgq", "SWG1KqVOkRlJj5xaFJLXfgvDZGcLop9W", "NnVJgvXVZSo8y", "MZutOzUHR9f6ofw4F9B4zZrhWVwaux2f", "iJqNP9fc7gU428pJE5yolgtY1lT8LdOq", "d47YjnRvT4PZseum75lZj5V30Q4jd", "", "7qpAsdx1ZTRXxrWBJjlVhK3OYLOnnJkC"};
    public static final int[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static U4 A04(C2446fp c2446fp) {
        int iA04 = c2446fp.A04(16);
        int iA05 = c2446fp.A04(16);
        int i = 0 + 2 + 2;
        if (iA05 == 65535) {
            iA05 = c2446fp.A04(24);
            i += 3;
        }
        int i2 = iA05 + i;
        if (iA04 == 44097) {
            i2 += 2;
        }
        int iA06 = c2446fp.A04(2);
        if (iA06 == 3) {
            iA06 += A00(c2446fp, 2);
        }
        int iA07 = c2446fp.A04(10);
        if (c2446fp.A0H() && c2446fp.A04(3) > 0) {
            c2446fp.A09(2);
        }
        int i3 = c2446fp.A0H() ? 48000 : 44100;
        int iA08 = c2446fp.A04(4);
        int i4 = 0;
        if (i3 != 44100 || iA08 != 13) {
            if (i3 == 48000 && iA08 < A02.length) {
                i4 = A02[iA08];
                switch (iA07 % 5) {
                    case 1:
                    case 3:
                        if (iA08 == 3 || iA08 == 8) {
                            i4++;
                        }
                        break;
                    case 2:
                        if (iA08 == 8 || iA08 == 11) {
                            i4++;
                        }
                        break;
                    case 4:
                        if (iA08 == 3 || iA08 == 8 || iA08 == 11) {
                            i4++;
                        }
                        break;
                }
            }
        } else {
            i4 = A02[iA08];
        }
        return new U4(iA06, 2, i3, i2, i4);
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{104, 124, 109, 96, 102, 38, 104, 106, Base64.padSymbol};
    }

    static {
        A06();
        A02 = new int[]{2002, 2000, 1920, IronSourceConstants.RV_OPERATIONAL_LOAD_SUCCESS, IronSourceConstants.RV_OPERATIONAL_LOAD_AD, 1001, 1000, 960, 800, 800, DtbConstants.DEFAULT_PLAYER_HEIGHT, 400, 400, 2048};
    }

    public static int A00(C2446fp c2446fp, int i) {
        int i2 = 0;
        while (true) {
            int value = c2446fp.A04(i);
            int i3 = i2 + value;
            boolean zA0H = c2446fp.A0H();
            if (A01[2].length() == 18) {
                throw new RuntimeException();
            }
            A01[2] = "TxTKr2zZZb";
            if (!zA0H) {
                return i3;
            }
            i2 = (i3 + 1) << i;
        }
    }

    public static int A01(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return A04(new C2446fp(bArr)).A03;
    }

    public static int A02(byte[] bArr, int i) {
        if (bArr.length < 7) {
            return -1;
        }
        int headerSize = bArr[2];
        int i2 = (headerSize & 255) << 8;
        int headerSize2 = bArr[3];
        int i3 = i2 | (headerSize2 & 255);
        int i4 = 2 + 2;
        if (i3 == 65535) {
            int headerSize3 = bArr[4];
            int i5 = (headerSize3 & 255) << 16;
            int headerSize4 = bArr[5];
            int i6 = i5 | ((headerSize4 & 255) << 8);
            int headerSize5 = bArr[6];
            i3 = i6 | (headerSize5 & 255);
            i4 += 3;
        }
        if (i == 44097) {
            i4 += 2;
        }
        return i3 + i4;
    }

    public static ZM A03(C2447fq c2447fq, String str, String str2, DrmInitData drmInitData) {
        c2447fq.A0g(1);
        return new P5().A0y(str).A11(A05(0, 9, 52)).A0b(2).A0m(((c2447fq.A0I() & 32) >> 5) == 1 ? 48000 : 44100).A0u(drmInitData).A10(str2).A14();
    }

    public static void A07(int i, C2447fq c2447fq) {
        c2447fq.A0d(7);
        byte[] bArrA0l = c2447fq.A0l();
        bArrA0l[0] = -84;
        bArrA0l[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrA0l[2] = -1;
        bArrA0l[3] = -1;
        bArrA0l[4] = (byte) ((i >> 16) & 255);
        bArrA0l[5] = (byte) ((i >> 8) & 255);
        bArrA0l[6] = (byte) (i & 255);
    }
}
