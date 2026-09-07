package com.facebook.ads.redexgen.core;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.DrmInitData;
import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class U2 {
    public static byte[] A00;
    public static String[] A01 = {"amtfipPJXqbID3qciNhCcWM0z9C7zGoD", "d1gDYDxAXfWbX", "t0EiutZTdECLVorbnwf6N4L3pftY", "pSeWGxIua7WPL", "mNg3t075ZsYRB0CFmmB8fYa9Y1wi7PXR", "BSRaK4CY9XBnXUn8Uw0BU1", "fW", "UklDjf4ac9mxv3mWCitICuMuBFHjQK1f"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[5].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "yPHC1Z2aanSlHOcPKgR4GK";
            strArr2[2] = "DDC5UVOzRYKGdAmtnCQ0C757duVd";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 77);
            i4++;
        }
    }

    public static void A0B() {
        if (A01[4].charAt(20) == 'z') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "hh4Nh9y0LLUASInEpTHprO";
        strArr[2] = "Fibu6iPU4dNIs1JtLXKzgxrTgci1";
        A00 = new byte[]{33, 53, 36, 41, 47, 111, 33, 35, 115, Ascii.NAK, 1, Ascii.DLE, Ascii.GS, Ascii.ESC, 91, 17, Ascii.NAK, Ascii.ETB, 71, 63, 43, 58, 55, 49, 113, 59, 63, Base64.padSymbol, 109, 115, 52, 49, Base64.padSymbol};
    }

    static {
        A0B();
        A03 = new int[]{1, 2, 3, 6};
        A05 = new int[]{48000, 44100, 32000};
        A06 = new int[]{24000, 22050, 16000};
        A04 = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        A02 = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
        A07 = new int[]{69, 87, 104, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 139, 174, 208, 243, POBNativeConstants.POB_NATIVE_MAIN_IMG_W, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, IronSourceConstants.RV_CALLBACK_AD_CLICKED, 1253, 1393};
    }

    public static int A00(int i, int i2) {
        int sampleRate = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int halfFrmsizecod = A05.length;
        if (i >= halfFrmsizecod || i2 < 0) {
            return -1;
        }
        int halfFrmsizecod2 = A07.length;
        if (sampleRate >= halfFrmsizecod2) {
            return -1;
        }
        int bitrate = A05[i];
        if (bitrate == 44100) {
            int halfFrmsizecod3 = i2 % 2;
            return (A07[sampleRate] + halfFrmsizecod3) * 2;
        }
        int sampleRate2 = A02[sampleRate];
        if (bitrate == 32000) {
            int halfFrmsizecod4 = sampleRate2 * 6;
            return halfFrmsizecod4;
        }
        int halfFrmsizecod5 = sampleRate2 * 4;
        return halfFrmsizecod5;
    }

    public static int A01(int i, int i2, int i3) {
        return (i * i2) / (i3 * 32);
    }

    public static int A02(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int startIndex = byteBuffer.limit();
        int i = startIndex - 10;
        for (int i2 = iPosition; i2 <= i; i2++) {
            int startIndex2 = i2 + 4;
            int endIndex = AbstractC2471gE.A0F(byteBuffer, startIndex2) & (-2);
            if (endIndex == -126718022) {
                return i2 - iPosition;
            }
        }
        return -1;
    }

    public static int A03(ByteBuffer byteBuffer) {
        int numblkscod = 3;
        boolean isEac3 = ((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10;
        if (isEac3) {
            if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
                int iPosition = byteBuffer.position();
                String[] strArr = A01;
                String str = strArr[1];
                String str2 = strArr[3];
                int numblkscod2 = str.length();
                if (numblkscod2 != str2.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[1] = "mg940SBvSwrjl";
                strArr2[3] = "BxEODy628ZWYr";
                numblkscod = (byteBuffer.get(iPosition + 4) & 48) >> 4;
            }
            return A03[numblkscod] * 256;
        }
        return 1536;
    }

    public static int A04(ByteBuffer byteBuffer, int i) {
        boolean z = (byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187;
        int iPosition = byteBuffer.position();
        String[] strArr = A01;
        if (strArr[5].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A01[4] = "P5Sx2xa5kfdEzRWOhniQLifJ0MOZOLfb";
        return 40 << ((byteBuffer.get((iPosition + i) + (z ? 9 : 8)) >> 4) & 7);
    }

    public static int A05(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        boolean isEac3 = ((bArr[5] & 248) >> 3) > 10;
        if (isEac3) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        int i = (bArr[4] & 192) >> 6;
        int i2 = bArr[4] & 63;
        String[] strArr = A01;
        String str = strArr[1];
        String str2 = strArr[3];
        int fscod = str.length();
        if (fscod != str2.length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "RPnRKnRsxiZSI3TxYT9wwSOvnBJ7yBMT";
        strArr2[0] = "bf7cYHxPsGw5m3JFcbTQL9k7BLimjlTN";
        return A00(i, i2);
    }

    public static int A06(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114) {
            byte b = bArr[6];
            if (A01[6].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "9J4etDzoH8863";
            strArr[3] = "cVZ7q6a3PMeEI";
            if (b == 111 && (bArr[7] & 254) == 186) {
                return 40 << ((bArr[(bArr[7] & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }

    public static ZM A07(C2447fq c2447fq, String str, String str2, DrmInitData drmInitData) {
        C2446fp c2446fp = new C2446fp();
        c2446fp.A0C(c2447fq);
        int fscod = c2446fp.A04(2);
        int constantBitrate = A05[fscod];
        c2446fp.A09(8);
        int i = A04[c2446fp.A04(3)];
        if (c2446fp.A04(1) != 0) {
            i++;
        }
        int fscod2 = c2446fp.A04(5);
        int halfFrmsizecod = A02[fscod2] * 1000;
        c2446fp.A06();
        c2447fq.A0f(c2446fp.A02());
        return new P5().A0y(str).A11(A0A(0, 9, 13)).A0b(i).A0m(constantBitrate).A0u(drmInitData).A10(str2).A0a(halfFrmsizecod).A0j(halfFrmsizecod).A14();
    }

    public static ZM A08(C2447fq c2447fq, String str, String str2, DrmInitData drmInitData) {
        C2446fp c2446fp = new C2446fp();
        c2446fp.A0C(c2447fq);
        int fscod = c2446fp.A04(13) * 1000;
        c2446fp.A09(3);
        int peakBitrate = c2446fp.A04(2);
        int sampleRate = A05[peakBitrate];
        c2446fp.A09(10);
        int channelCount = A04[c2446fp.A04(3)];
        if (c2446fp.A04(1) != 0) {
            channelCount++;
        }
        c2446fp.A09(3);
        int iA04 = c2446fp.A04(4);
        c2446fp.A09(1);
        if (iA04 > 0) {
            c2446fp.A0A(6);
            if (c2446fp.A04(1) != 0) {
                channelCount += 2;
            }
            c2446fp.A09(1);
        }
        String strA0A = A0A(9, 10, 57);
        int peakBitrate2 = c2446fp.A01();
        if (peakBitrate2 > 7) {
            c2446fp.A09(7);
            if (c2446fp.A04(1) != 0) {
                strA0A = A0A(19, 14, 19);
            }
        }
        c2446fp.A06();
        c2447fq.A0f(c2446fp.A02());
        return new P5().A0y(str).A11(strA0A).A0b(channelCount).A0m(sampleRate).A0u(drmInitData).A10(str2).A0j(fscod).A14();
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0207  */
    public static U1 A09(C2446fp c2446fp) {
        String strA0A;
        int iA01;
        int iA00;
        int i;
        int i2;
        int i3;
        int i4;
        int iA04;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iA03 = c2446fp.A03();
        c2446fp.A09(40);
        boolean z = c2446fp.A04(5) > 10;
        c2446fp.A08(iA03);
        int i12 = -1;
        if (z) {
            c2446fp.A09(16);
            switch (c2446fp.A04(2)) {
                case 0:
                    i12 = 0;
                    break;
                case 1:
                    i12 = 1;
                    break;
                case 2:
                    i12 = 2;
                    break;
                default:
                    i12 = -1;
                    break;
            }
            c2446fp.A09(3);
            iA00 = (c2446fp.A04(11) + 1) * 2;
            int iA05 = c2446fp.A04(2);
            if (iA05 == 3) {
                iA04 = 3;
                i2 = A06[c2446fp.A04(2)];
                i5 = 6;
            } else {
                iA04 = c2446fp.A04(2);
                i5 = A03[iA04];
                i2 = A05[iA05];
            }
            i3 = i5 * 256;
            iA01 = A01(iA00, i2, i5);
            int iA06 = c2446fp.A04(3);
            boolean zA0H = c2446fp.A0H();
            i4 = A04[iA06] + (zA0H ? 1 : 0);
            c2446fp.A09(10);
            if (c2446fp.A0H()) {
                c2446fp.A09(8);
            }
            if (iA06 == 0) {
                c2446fp.A09(5);
                if (c2446fp.A0H()) {
                    c2446fp.A09(8);
                }
            }
            if (i12 == 1 && c2446fp.A0H()) {
                c2446fp.A09(16);
            }
            if (c2446fp.A0H()) {
                if (iA06 > 2) {
                    c2446fp.A09(2);
                }
                if ((iA06 & 1) != 0 && iA06 > 2) {
                    i9 = 6;
                    c2446fp.A09(6);
                } else {
                    i9 = 6;
                }
                if ((iA06 & 4) != 0) {
                    c2446fp.A09(i9);
                }
                if (zA0H && c2446fp.A0H()) {
                    c2446fp.A09(5);
                }
                if (i12 == 0) {
                    if (c2446fp.A0H()) {
                        i10 = 6;
                        c2446fp.A09(6);
                    } else {
                        i10 = 6;
                    }
                    if (iA06 == 0 && c2446fp.A0H()) {
                        c2446fp.A09(i10);
                    }
                    if (c2446fp.A0H()) {
                        c2446fp.A09(i10);
                    }
                    int iA07 = c2446fp.A04(2);
                    if (iA07 == 1) {
                        c2446fp.A09(5);
                    } else if (iA07 == 2) {
                        c2446fp.A09(12);
                    } else if (iA07 == 3) {
                        int iA08 = c2446fp.A04(5);
                        if (c2446fp.A0H()) {
                            c2446fp.A09(5);
                            if (c2446fp.A0H()) {
                                i11 = 4;
                                c2446fp.A09(4);
                            } else {
                                i11 = 4;
                            }
                            if (c2446fp.A0H()) {
                                c2446fp.A09(i11);
                            }
                            if (c2446fp.A0H()) {
                                c2446fp.A09(i11);
                            }
                            if (c2446fp.A0H()) {
                                c2446fp.A09(i11);
                            }
                            boolean zA0H2 = c2446fp.A0H();
                            String[] strArr = A01;
                            if (strArr[1].length() != strArr[3].length()) {
                                String[] strArr2 = A01;
                                strArr2[7] = "fsNMM195oQON93OVr14Cnc2ZJ8fGRI5e";
                                strArr2[0] = "t54xCfAEACV2q3QvTMvZ9or3rlrfBhKR";
                                if (zA0H2) {
                                    c2446fp.A09(i11);
                                }
                            } else {
                                String[] strArr3 = A01;
                                strArr3[7] = "Pm1fALVYPFHSe33b6PS1DLyERz5FIDFH";
                                strArr3[0] = "p52PbTK8PKsim3NR3cOS7iMhlZY0G4LT";
                                if (zA0H2) {
                                    c2446fp.A09(i11);
                                }
                            }
                            if (c2446fp.A0H()) {
                                c2446fp.A09(i11);
                            }
                            if (c2446fp.A0H()) {
                                c2446fp.A09(i11);
                            }
                            if (c2446fp.A0H()) {
                                if (c2446fp.A0H()) {
                                    c2446fp.A09(i11);
                                }
                                if (c2446fp.A0H()) {
                                    c2446fp.A09(i11);
                                }
                            }
                        }
                        if (c2446fp.A0H()) {
                            c2446fp.A09(5);
                            if (c2446fp.A0H()) {
                                c2446fp.A09(7);
                                if (c2446fp.A0H()) {
                                    c2446fp.A09(8);
                                }
                            }
                        }
                        c2446fp.A09((iA08 + 2) * 8);
                        c2446fp.A06();
                    }
                    if (iA06 < 2) {
                        if (c2446fp.A0H()) {
                            c2446fp.A09(14);
                        }
                        if (iA06 == 0 && c2446fp.A0H()) {
                            c2446fp.A09(14);
                        }
                    }
                    if (c2446fp.A0H()) {
                        if (iA04 == 0) {
                            c2446fp.A09(5);
                        } else {
                            for (int i13 = 0; i13 < i5; i13++) {
                                if (c2446fp.A0H()) {
                                    c2446fp.A09(5);
                                }
                            }
                        }
                    }
                }
            }
            if (c2446fp.A0H()) {
                c2446fp.A09(5);
                if (iA06 == 2) {
                    c2446fp.A09(4);
                }
                if (iA06 >= 6) {
                    c2446fp.A09(2);
                }
                if (c2446fp.A0H()) {
                    i8 = 8;
                    c2446fp.A09(8);
                } else {
                    i8 = 8;
                }
                if (iA06 == 0 && c2446fp.A0H()) {
                    c2446fp.A09(i8);
                }
                i6 = 3;
                if (iA05 < 3) {
                    c2446fp.A07();
                }
            } else {
                i6 = 3;
            }
            if (i12 == 0 && iA04 != i6) {
                c2446fp.A07();
            }
            if (i12 == 2) {
                if (iA04 == i6 || c2446fp.A0H()) {
                    i7 = 6;
                    c2446fp.A09(6);
                } else {
                    i7 = 6;
                }
            } else {
                i7 = 6;
            }
            strA0A = A0A(9, 10, 57);
            if (c2446fp.A0H() && c2446fp.A04(i7) == 1 && c2446fp.A04(8) == 1) {
                String[] strArr4 = A01;
                if (strArr4[7].charAt(13) == strArr4[0].charAt(13)) {
                    A01[6] = "5q";
                    strA0A = A0A(19, 14, 19);
                }
                throw new RuntimeException();
            }
            return new U1(strA0A, i12, i4, i2, iA00, i3, iA01);
        }
        strA0A = A0A(0, 9, 13);
        c2446fp.A09(32);
        int iA09 = c2446fp.A04(2);
        if (iA09 == 3) {
            strA0A = null;
        }
        int iA010 = c2446fp.A04(6);
        iA01 = A02[iA010 / 2] * 1000;
        iA00 = A00(iA09, iA010);
        c2446fp.A09(8);
        int iA011 = c2446fp.A04(3);
        if ((iA011 & 1) != 0 && iA011 != 1) {
            i = 2;
            c2446fp.A09(2);
        } else {
            i = 2;
        }
        int i14 = iA011 & 4;
        if (A01[4].charAt(20) != 'z') {
            String[] strArr5 = A01;
            strArr5[5] = "YwiU2s82gR4Z7rduBIEp63";
            strArr5[2] = "7doCTMTK8dMyooIgwACEtaXMsvOE";
            if (i14 != 0) {
                c2446fp.A09(i);
            }
            if (iA011 == i) {
                c2446fp.A09(i);
            }
            i2 = iA09 < A05.length ? A05[iA09] : -1;
            i3 = 1536;
            i4 = A04[iA011] + (c2446fp.A0H() ? 1 : 0);
            return new U1(strA0A, i12, i4, i2, iA00, i3, iA01);
        }
        throw new RuntimeException();
    }
}
