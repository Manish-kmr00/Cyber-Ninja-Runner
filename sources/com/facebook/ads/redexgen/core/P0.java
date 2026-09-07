package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class P0 {
    public static byte[] A00;
    public static String[] A01 = {"Q6M248UdEKsfA5cD3fbKbu90kHMotYCc", "7h88XVyRVBVdEUwD4wXRnLVeGzZsIgQy", "Go0", "ZsEAEoNH4Z9WLEs7Rqn5rSYJ9tl", "dNlhSSERgjT67RyILA4ywu82piqYUlsG", "O03wSW8sdzJZuWjGzkZWdPNOPgAxMZbA", "NEhlKnMa41TXq2iulRLPljipPyrxtohW", "kNeSg3iQiRXxI1x3I5DKinblXexk8lrR"};

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-29, Ascii.SYN, Ascii.SYN, Ascii.CAN, -77, -26, -24, -72, -61, -10, -8, -55, -57, -6, -3, Ascii.CR, Ascii.FF, -40, Ascii.VT, Ascii.ETB, Ascii.FS, -43, 8, Ascii.GS, Ascii.DLE, -31, Ascii.SYN, 32, Ascii.EM, -85, -30, -32, -80, -61, -5, 1, -10, -8, -86, -30, -24, -14, -51, 9, Ascii.SI, 4, 6, -90, -30, -24, -33, 2, 65, 6, 68, -80, -17, -74, -49, Ascii.SO, 10, 5, -56, 7, 3, -2, 3, Ascii.SO, 77, 75, -27, 36, 39, -22, 1, SignedBytes.MAX_POWER_OF_TWO, 67, 7, -46, 17, Ascii.DC4, 9, Ascii.VT, -52, Ascii.VT, Ascii.SO, 5, -96, -31, -39, -87, -22, -21, -16, -18, -76, -10, -7, -88, -19, -25, -32, -36, 34, 33, -7, 65, 63, 63, -25, 48, Ascii.SUB, 47, -24, 49, Ascii.ESC, 48, Ascii.US, -18, 55, 37, 34, 45, -45, Ascii.FS, 10, 7, Ascii.ESC, Ascii.EM, Ascii.EM, -28, Ascii.DLE, Ascii.SI, Ascii.NAK, 6, Ascii.SI, Ascii.NAK, -50, -11, Ascii.SUB, 17, 6, 37, 52, 52, 48, 45, 39, 37, 56, 45, 51, 50, -13, 49, 52, -8, 56, 71, 71, 67, SignedBytes.MAX_POWER_OF_TWO, 58, 56, 75, SignedBytes.MAX_POWER_OF_TWO, 70, 69, 6, 78, 60, 57, 68, -48, -28, -45, -40, -34, -98, -94, -42, -33, -33, Ascii.FF, 32, Ascii.SI, Ascii.DC4, Ascii.SUB, -38, Ascii.FF, Ascii.SO, -34, -48, -28, -45, -40, -34, -98, -48, -46, -93, -12, 8, -9, -4, 2, -62, -12, 0, 5, Ascii.EM, 45, Ascii.FS, 33, 39, -25, Ascii.EM, 37, 42, -27, 47, Ascii.SUB, 1, Ascii.NAK, 4, 9, Ascii.SI, -49, 5, 1, 3, -45, -45, -25, -42, -37, -31, -95, -41, -45, -43, -91, -97, -36, -31, -43, -58, -38, -55, -50, -44, -108, -53, -47, -58, -56, 37, 57, 40, 45, 51, -13, 49, 45, 40, 45, -53, -33, -50, -45, -39, -103, -41, -38, -98, 34, 54, 37, 42, 48, -16, 46, 49, 38, 40, Ascii.ETB, 43, Ascii.SUB, Ascii.US, 37, -27, 37, Ascii.GS, Ascii.GS, -48, -28, -45, -40, -34, -98, -26, -48, -27, 56, 76, 59, SignedBytes.MAX_POWER_OF_TWO, 70, 6, 78, 60, 57, 68, 9, Ascii.GS, Ascii.FF, 17, Ascii.ETB, -41, 32, -43, Ascii.NAK, 9, Ascii.FS, Ascii.SUB, Ascii.ETB, Ascii.ESC, 19, 9, -27, -23, -35, -29, -31, -85, -26, -20, -31, -29, 9, -6, Ascii.CR, 9, -60, Ascii.VT, 9, 9, 8, -5, -10, -9, 1, -63, -1, 2, -60, 2, -36, -49, -54, -53, -43, -107, -45, -42, -104, -38, 76, 63, 58, 59, 69, 5, 67, 70, 10, -13, -26, -31, -30, -20, -84, -12, -30, -33, -22, -7, -20, -25, -24, -14, -78, -5, -80, -23, -17, -7, -22, -35, -40, -39, -29, -93, -20, -95, -31, -43, -24, -26, -29, -25, -33, -43, -32, -45, -50, -49, -39, -103, -30, -105, -41, -35, -32, -45, -50, -49, -39};
    }

    static {
        A04();
    }

    public static int A00(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        String filename = A03(4, 4, 36);
        if (lastPathSegment.endsWith(filename)) {
            return 0;
        }
        String filename2 = A03(29, 4, 28);
        if (lastPathSegment.endsWith(filename2)) {
            return 0;
        }
        String filename3 = A03(8, 4, 52);
        if (lastPathSegment.endsWith(filename3)) {
            return 1;
        }
        String filename4 = A03(12, 5, 56);
        if (lastPathSegment.endsWith(filename4)) {
            return 2;
        }
        String filename5 = A03(0, 4, 84);
        if (lastPathSegment.endsWith(filename5)) {
            return 2;
        }
        String filename6 = A03(17, 4, 73);
        if (lastPathSegment.endsWith(filename6)) {
            String filename7 = A01[2];
            if (filename7.length() != 22) {
                A01[4] = "LYt9Grwanx42gjQ5czMyMDBSLII4BppM";
                return 3;
            }
        } else {
            String filename8 = A03(33, 5, 52);
            if (lastPathSegment.endsWith(filename8)) {
                return 4;
            }
            String filename9 = A03(38, 4, 27);
            if (lastPathSegment.endsWith(filename9)) {
                return 5;
            }
            String filename10 = A03(58, 4, 64);
            if (!lastPathSegment.endsWith(filename10)) {
                String strA03 = A03(62, 5, 57);
                if (A01[0].charAt(4) == '0') {
                    throw new RuntimeException();
                }
                A01[7] = "4MXCHaWrFzHMW3WLUAb4nN";
                if (lastPathSegment.endsWith(strA03)) {
                    return 15;
                }
                String filename11 = A01[2];
                if (filename11.length() == 22) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[6] = "1kPkDVCqs4vlIMsHycGs0zkePVR5OoVM";
                strArr[5] = "nlXmUhG8CeAONYDiqulZyljBPaTWZSvm";
                String filename12 = A03(98, 4, 25);
                if (lastPathSegment.endsWith(filename12)) {
                    return 15;
                }
                int length = lastPathSegment.length();
                String strA04 = A03(67, 3, 127);
                if (!lastPathSegment.startsWith(strA04, length - (strA04.length() + 1))) {
                    String filename13 = A03(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 5, 95);
                    if (lastPathSegment.endsWith(filename13)) {
                        return 6;
                    }
                    String filename14 = A03(70, 4, 86);
                    if (lastPathSegment.endsWith(filename14)) {
                        return 7;
                    }
                    String strA05 = A03(74, 4, 114);
                    if (!lastPathSegment.endsWith(strA05)) {
                        int length2 = lastPathSegment.length();
                        String strA06 = A03(55, 3, 33);
                        int length3 = strA06.length();
                        if (A01[0].charAt(4) != '0') {
                            A01[0] = "wb0PfpDpJu2baLI6Ym1KLA9HIfQPTuvc";
                            if (!lastPathSegment.startsWith(strA06, length2 - (length3 + 1)) && !lastPathSegment.startsWith(strA05, lastPathSegment.length() - (strA05.length() + 1))) {
                                int length4 = lastPathSegment.length();
                                String strA07 = A03(25, 4, 82);
                                if (lastPathSegment.startsWith(strA07, length4 - (strA07.length() + 1))) {
                                    return 8;
                                }
                                int length5 = lastPathSegment.length();
                                String strA08 = A03(87, 3, 17);
                                if (!lastPathSegment.startsWith(strA08, length5 - (strA08.length() + 1))) {
                                    String filename15 = A03(90, 5, 26);
                                    if (lastPathSegment.endsWith(filename15)) {
                                        return 9;
                                    }
                                    String filename16 = A03(95, 3, 37);
                                    if (lastPathSegment.endsWith(filename16)) {
                                        return 10;
                                    }
                                    String[] strArr2 = A01;
                                    if (strArr2[6].charAt(24) != strArr2[5].charAt(24)) {
                                        throw new RuntimeException();
                                    }
                                    A01[4] = "9bvAI1ld7chb84DrE78uia93r0dMHICi";
                                    String filename17 = A03(78, 5, 67);
                                    if (!lastPathSegment.endsWith(filename17)) {
                                        String filename18 = A03(83, 4, 61);
                                        if (!lastPathSegment.endsWith(filename18)) {
                                            String filename19 = A03(51, 4, 115);
                                            if (lastPathSegment.endsWith(filename19)) {
                                                return 10;
                                            }
                                            String strA09 = A03(102, 3, 77);
                                            if (lastPathSegment.endsWith(strA09) || lastPathSegment.startsWith(strA09, lastPathSegment.length() - (strA09.length() + 1))) {
                                                return 11;
                                            }
                                            String[] strArr3 = A01;
                                            if (strArr3[6].charAt(24) != strArr3[5].charAt(24)) {
                                                String[] strArr4 = A01;
                                                strArr4[6] = "d6XamE0lv6TG4bYguC9VovLvPvi5q1O1";
                                                strArr4[5] = "LVjoK53HU3fe1yRiBh4pWTK7PgPjaCxY";
                                                String filename20 = A03(109, 4, 88);
                                                if (lastPathSegment.endsWith(filename20)) {
                                                    return 12;
                                                }
                                            } else {
                                                A01[2] = "UJeVoww4r1wic53EaeAdeKH";
                                                String filename21 = A03(109, 4, 88);
                                                if (lastPathSegment.endsWith(filename21)) {
                                                    return 12;
                                                }
                                            }
                                            String filename22 = A03(113, 5, 89);
                                            if (lastPathSegment.endsWith(filename22)) {
                                                return 12;
                                            }
                                            String filename23 = A03(105, 4, 106);
                                            if (lastPathSegment.endsWith(filename23)) {
                                                return 13;
                                            }
                                            String filename24 = A03(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 7, 68);
                                            if (lastPathSegment.endsWith(filename24)) {
                                                return 13;
                                            }
                                            String filename25 = A03(47, 4, 23);
                                            if (lastPathSegment.endsWith(filename25)) {
                                                return 14;
                                            }
                                            String filename26 = A01[3];
                                            if (filename26.length() != 27) {
                                                throw new RuntimeException();
                                            }
                                            A01[2] = "qw4LTekO";
                                            String filename27 = A03(42, 5, 62);
                                            if (lastPathSegment.endsWith(filename27)) {
                                                return 14;
                                            }
                                            String filename28 = A03(21, 4, 70);
                                            if (!lastPathSegment.endsWith(filename28)) {
                                                return -1;
                                            }
                                            return 16;
                                        }
                                        return 10;
                                    }
                                    return 10;
                                }
                                return 9;
                            }
                            return 8;
                        }
                    } else {
                        return 8;
                    }
                } else {
                    return 6;
                }
            } else {
                return 15;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x02a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x02a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:106:0x02a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x02a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:108:0x02a4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:109:0x02a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x02a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:111:0x02a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x02a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:113:0x02a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x02aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x02ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:116:0x02ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:117:0x02ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:118:0x02ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:119:0x02af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0043  */
    /* JADX WARN: Code duplicated, block: B:13:0x0047 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:95:0x0266  */
    public static int A01(String str) {
        byte b;
        if (str == null) {
            return -1;
        }
        String strA08 = Q2.A08(str);
        int iHashCode = strA08.hashCode();
        if (A01[3].length() == 27) {
            A01[0] = "XPmg6IDQxMTCkPfitZwvQYIPtD1hV1z9";
            switch (iHashCode) {
                case -2123537834:
                    if (A01[7].length() != 25) {
                        A01[2] = "aSk0";
                        if (strA08.equals(A03(232, 14, 17))) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strA08.equals(A03(232, 14, 17))) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1662384011:
                    if (strA08.equals(A03(347, 10, 49))) {
                        b = Ascii.DC4;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1662384007:
                    if (strA08.equals(A03(357, 10, 5))) {
                        b = Ascii.NAK;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1662095187:
                    if (strA08.equals(A03(376, 10, 28))) {
                        b = Ascii.FF;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1606874997:
                    if (strA08.equals(A03(210, 12, 87))) {
                        b = 6;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1487394660:
                    if (strA08.equals(A03(329, 10, 27))) {
                        b = Ascii.CAN;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1248337486:
                    if (strA08.equals(A03(142, 15, 99))) {
                        b = Ascii.DC2;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1079884372:
                    if (strA08.equals(A03(TTAdConstant.VIDEO_INFO_CODE, 15, 9))) {
                        b = Ascii.EM;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -1004728940:
                    if (A01[3].length() != 27) {
                        A01[1] = "wzIVGVMM5D0fQb7x0gXifwmV3dmjcqg6";
                        if (strA08.equals(A03(339, 8, 33))) {
                            b = Ascii.ETB;
                        } else {
                            b = -1;
                        }
                    } else {
                        A01[1] = "9ao57tDdpuBHeLivW6Ffx5AksEazVyFN";
                        if (strA08.equals(A03(339, 8, 52))) {
                            b = Ascii.ETB;
                        } else {
                            b = -1;
                        }
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -387023398:
                    if (strA08.equals(A03(313, 16, 71))) {
                        b = Ascii.VT;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case -43467528:
                    if (strA08.equals(A03(157, 16, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE))) {
                        b = Ascii.SO;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 13915911:
                    if (strA08.equals(A03(386, 11, 34))) {
                        b = 8;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 187078296:
                    if (strA08.equals(A03(183, 9, 74))) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 187078297:
                    if (strA08.equals(A03(192, 9, 14))) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 187078669:
                    if (A01[7].length() != 25) {
                        String[] strArr = A01;
                        strArr[6] = "4BIdLKkcme6Rx2h7Bd0yiVGIPIcO7Gte";
                        strArr[5] = "Uejj6DQRYnqnt7wrlLu4j8sIPPxgERZO";
                        if (strA08.equals(A03(201, 9, 50))) {
                            b = 4;
                        } else {
                            b = -1;
                        }
                        switch (b) {
                            case 0:
                            case 1:
                            case 2:
                                return 0;
                            case 3:
                                return 1;
                            case 4:
                            case 5:
                            case 6:
                                return 3;
                            case 7:
                                return 4;
                            case 8:
                                return 5;
                            case 9:
                                return 15;
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                                return 6;
                            case 15:
                                return 7;
                            case 16:
                            case 17:
                            case 18:
                                return 8;
                            case 19:
                                return 9;
                            case 20:
                                return 10;
                            case 21:
                                return 11;
                            case 22:
                                return 12;
                            case 23:
                                return 13;
                            case 24:
                                return 14;
                            case 25:
                                return 16;
                            default:
                                return -1;
                        }
                    }
                    break;
                case 187090232:
                    if (strA08.equals(A03(266, 9, 9))) {
                        b = 17;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 187091926:
                    if (strA08.equals(A03(285, 9, 85))) {
                        b = 19;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 187099443:
                    if (strA08.equals(A03(294, 9, 14))) {
                        b = Ascii.SYN;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1331848029:
                    if (strA08.equals(A03(367, 9, 117))) {
                        b = Ascii.DLE;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1503095341:
                    if (strA08.equals(A03(173, 10, 14))) {
                        b = 5;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1504578661:
                    if (strA08.equals(A03(Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, 10, 63))) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1504619009:
                    if (strA08.equals(A03(246, 10, 4))) {
                        b = 7;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1504824762:
                    if (strA08.equals(A03(256, 10, 99))) {
                        b = 9;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1504831518:
                    if (strA08.equals(A03(275, 10, 96))) {
                        b = Ascii.SI;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 1505118770:
                    if (strA08.equals(A03(303, 10, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE))) {
                        b = Ascii.CR;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                case 2039520277:
                    if (strA08.equals(A03(397, 16, 19))) {
                        b = 10;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
                default:
                    b = -1;
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                            return 0;
                        case 3:
                            return 1;
                        case 4:
                        case 5:
                        case 6:
                            return 3;
                        case 7:
                            return 4;
                        case 8:
                            return 5;
                        case 9:
                            return 15;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return 6;
                        case 15:
                            return 7;
                        case 16:
                        case 17:
                        case 18:
                            return 8;
                        case 19:
                            return 9;
                        case 20:
                            return 10;
                        case 21:
                            return 11;
                        case 22:
                            return 12;
                        case 23:
                            return 13;
                        case 24:
                            return 14;
                        case 25:
                            return 16;
                        default:
                            return -1;
                    }
            }
        }
        throw new RuntimeException();
    }

    public static int A02(Map<String, List<String>> responseHeaders) {
        List<String> list = responseHeaders.get(A03(130, 12, 64));
        return A01((list == null || list.isEmpty()) ? null : list.get(0));
    }
}
