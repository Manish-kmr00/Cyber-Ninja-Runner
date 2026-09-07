package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.l;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Q2 {
    public static byte[] A00;
    public static String[] A01 = {"7StDzEVzZaGlrktQpy4icwf3", "I", "3cp2JV3NqqqI0", "YEXeyEpn3xDQanHXL", "Flp3Qh2JQVd85Qikv3pTxWi5jwEwB1Pa", "u33", "Z9xurGdUnVzS9yB8saF1J325BeaWcoYF", "YWnblh4AgHhjZ1mUFm4d9FR9l3asrr0"};
    public static final ArrayList<Q0> A02;
    public static final Pattern A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Q1 A04(String str) {
        Matcher matcher = A03.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) AbstractC2388es.A01(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new Q1(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 4;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "xDZ8xdyRoY86j";
            strArr2[3] = "PThezbP1LCy0nQkZm";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{51, 0, Ascii.GS, 89, Ascii.FF, 49, 67, 69, 54, Ascii.FF, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, 44, SignedBytes.MAX_POWER_OF_TWO, 55, 93, SignedBytes.MAX_POWER_OF_TWO, 84, 48, Ascii.SYN, 95, Ascii.DLE, 68, 69, 82, 87, 49, 67, 69, 54, 93, SignedBytes.MAX_POWER_OF_TWO, 84, 48, Ascii.SYN, 92, 65, 95, Ascii.DLE, 68, 68, 82, 73, 56, 58, 116, 106, 56, 58, 116, 109, 98, 115, 115, 111, 106, 96, 98, 119, 106, 108, 109, 44, 96, 102, 98, 46, 53, 51, 59, 114, 99, 99, 127, 122, 112, 114, 103, 122, 124, 125, 60, 112, 118, 114, 62, 36, 35, 43, 71, 86, 86, 74, 79, 69, 71, 82, 79, 73, 72, 9, 66, 80, 68, 85, 83, 68, 85, 97, 112, 112, 108, 105, 99, 97, 116, 105, 111, 110, 47, 105, 100, 51, 80, 65, 65, 93, 88, 82, 80, 69, 88, 94, 95, Ascii.RS, 65, 86, 66, 111, 126, 126, 98, 103, 109, 111, 122, 103, 97, 96, 33, 122, 122, 99, 98, 37, 118, 99, 98, 98, 115, 115, 111, 106, 96, 98, 119, 106, 108, 109, 44, 117, 108, 97, 112, 118, 97, 76, 93, 93, 65, 68, 78, 76, 89, 68, 66, 67, 2, 85, 0, 78, 76, SignedBytes.MAX_POWER_OF_TWO, 72, 95, 76, 0, SignedBytes.MAX_POWER_OF_TWO, 66, 89, 68, 66, 67, 36, 53, 53, 41, 44, 38, 36, 49, 44, 42, 43, 106, Base64.padSymbol, 104, 32, 40, 54, 34, 125, 108, 108, 112, 117, 127, 125, 104, 117, 115, 114, 51, 100, 49, 113, 108, 40, 49, 127, 121, 125, 49, 42, 44, 36, 36, 53, 53, 41, 44, 38, 36, 49, 44, 42, 43, 106, Base64.padSymbol, 104, 40, 53, 113, 104, 51, 49, 49, 39, 54, 54, 42, 47, 37, 39, 50, 47, 41, 40, 105, 62, 107, 55, 51, 47, 37, 45, 50, 47, 43, 35, 107, 50, 62, 117, 33, 50, 35, 35, 63, 58, 48, 50, 39, 58, 60, Base64.padSymbol, 124, 43, 126, 33, 50, 36, 48, 48, 32, 49, 49, 45, 40, 34, 32, 53, 40, 46, 47, 110, 57, 108, 50, 34, 53, 36, 114, 116, Base64.padSymbol, 44, 44, 48, 53, 63, Base64.padSymbol, 40, 53, 51, 50, 115, 36, 113, 47, 41, 62, 46, 53, 44, Ascii.EM, Ascii.CR, Ascii.FS, 17, Ascii.ETB, 38, 50, 35, 46, 40, 104, 38, 36, 116, 107, 127, 110, 99, 101, 37, 107, 105, 62, 112, 100, 117, 120, 126, 62, 116, 112, 114, 34, 67, 87, 70, 75, 77, Ascii.CR, 71, 67, 65, 17, Ascii.SI, 72, 77, 65, 106, 126, 111, 98, 100, 36, 109, 103, 106, 104, 88, 76, 93, 80, 86, Ascii.SYN, 94, Ascii.SO, 8, 8, Ascii.DC4, 88, 85, 88, 78, Ascii.FF, Ascii.CAN, 9, 4, 2, 66, 10, 90, 92, 92, SignedBytes.MAX_POWER_OF_TWO, 0, 1, Ascii.FF, Ascii.SUB, 6, Ascii.DC2, 3, Ascii.SO, 8, 72, 10, Ascii.SI, 6, 86, 40, 60, 45, 32, 38, 102, 36, 33, 36, 120, 52, 32, 49, 60, 58, 122, 56, 37, 102, 119, 99, 114, 127, 121, 57, 123, 102, 34, 119, 59, 122, 119, 98, 123, 34, 54, 39, 42, 44, 108, 46, 51, 38, 36, 57, 45, 60, 49, 55, 119, 53, 40, Base64.padSymbol, 63, 117, Ascii.DC4, 105, Ascii.DC2, 6, Ascii.ETB, Ascii.SUB, Ascii.FS, 92, Ascii.RS, 3, Ascii.SYN, Ascii.DC4, 94, 63, 65, 40, 60, 45, 32, 38, 102, 38, 57, 60, 58, 88, 76, 93, 80, 86, Ascii.SYN, 75, 88, 78, 107, 127, 110, 99, 101, 37, 126, 120, 127, 111, 39, 98, 110, 58, 46, 63, 50, 52, 116, 45, 53, 63, 117, 63, 47, 40, Ascii.CAN, Ascii.FF, Ascii.GS, Ascii.DLE, Ascii.SYN, 86, Ascii.SI, Ascii.ETB, Ascii.GS, 87, Ascii.GS, Ascii.CR, 10, 87, 17, Ascii.GS, 6, Ascii.DC2, 3, Ascii.SO, 8, 72, 17, 9, 3, 73, 3, 19, Ascii.DC4, 73, Ascii.SI, 3, 92, Ascii.ETB, Ascii.NAK, 8, 1, Ascii.SO, Ascii.VT, 2, 90, Ascii.VT, 5, Ascii.NAK, 1, Ascii.NAK, 4, 9, Ascii.SI, 79, Ascii.SYN, Ascii.SO, 4, 78, 4, Ascii.DC4, 19, 78, Ascii.NAK, 8, 4, 91, Ascii.DLE, Ascii.DC2, Ascii.SI, 6, 9, Ascii.FF, 5, 93, Ascii.DLE, 82, 53, 33, 48, Base64.padSymbol, 59, 123, 34, 59, 38, 54, Base64.padSymbol, 39, 10, Ascii.RS, Ascii.SI, 2, 4, 68, Ascii.FS, 10, Ascii.GS, Ascii.DLE, 4, Ascii.NAK, Ascii.CAN, Ascii.RS, 94, 9, 92, Ascii.ETB, Ascii.GS, Ascii.DLE, Ascii.DC2, Ascii.VT, Ascii.US, Ascii.SO, 3, 5, 69, Ascii.DC2, 71, Ascii.GS, Ascii.VT, Ascii.FS, Ascii.DC2, 5, 67, 66, 63, 40, Base64.padSymbol, 111, Ascii.SYN, 1, Ascii.DC4, 68, Ascii.ESC, Ascii.GS, Ascii.EM, 78, 72, SignedBytes.MAX_POWER_OF_TWO, 35, 37, 33, 119, 112, 120, 75, 71, 76, 77, 75, 120, 90, 77, 78, 65, 80, 6, 3, 1, 81, 90, 95, 93, 10, 73, 72, 78, Ascii.RS, 99, 115, 116, 100, 3, 19, Ascii.DC4, 2, 41, 57, 62, 37, 91, 75, 76, 83, Ascii.CAN, 8, Ascii.SI, 4, Ascii.NAK, 7, Ascii.DLE, SignedBytes.MAX_POWER_OF_TWO, 112, 98, 117, 98, 95, 77, 83, 10, 71, 85, 75, 70, 127, 121, 49, 41, 80, 86, Ascii.CAN, 6, 126, 114, 122, 45, 43, 35, Ascii.US, Ascii.NAK, Ascii.CAN, Ascii.SUB, 48, Base64.padSymbol, 46, 105, 101, 123, 110, 60, 17, Ascii.NAK, Ascii.EM, Ascii.US, Ascii.GS, 102, 98, 110, 104, 106, 32, 101, 127, 106, 104, 97, 100, 109, Base64.padSymbol, 95, 90, 95, 3, 77, 73, 77, 69, 116, 89, 80, 69, 38, 59, 127, 42, 104, 117, 49, 100, 43, 56, 39, 34, 36, 52, 51, 55, 55, 114, 99, 126, 114, Ascii.EM, 8, Ascii.NAK, Ascii.EM, 66, Ascii.ESC, Ascii.EM, Ascii.EM, 121, 102, 107, 106, 96, Ascii.SUB, 5, 8, 9, 3, 67, Ascii.CR, Ascii.SUB, 92, 93, 86, 73, 68, 69, 79, Ascii.SI, 65, 86, 67, 82, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 75, Ascii.VT, SignedBytes.MAX_POWER_OF_TWO, 75, 72, 70, 93, 9, 82, 77, 87, 77, 75, 74, 84, 75, 70, 71, 77, Ascii.CR, 74, 71, 84, 65, SignedBytes.MAX_POWER_OF_TWO, 95, 82, 83, 89, Ascii.EM, 91, 70, 2, SignedBytes.MAX_POWER_OF_TWO, Ascii.ESC, 83, 69, 80, 79, 66, 67, 73, 9, 75, 86, 67, 65, 125, 98, 111, 110, 100, 36, 102, 123, 110, 108, 57, 125, 98, 111, 110, 100, 36, 124, 125, 104, 58, Ascii.GS, 2, Ascii.SI, Ascii.SO, 4, 68, 19, 70, Ascii.GS, 5, Ascii.SI, 69, 4, 5, 89, 69, Ascii.GS, Ascii.ESC, 83, 65, 94, 83, 82, 88, Ascii.CAN, 79, Ascii.SUB, 65, 89, 83, Ascii.EM, 88, 89, 5, Ascii.EM, 65, 71, Ascii.SO, 49, 40, 53, 37, 46, 52, 104, 110, 46, 38, 89, 95, Ascii.US, Ascii.SYN, 48, 
        54, 126, 33, 39, 110, 105, 104, 106, 106};
    }

    static {
        A0B();
        A02 = new ArrayList<>();
        A03 = Pattern.compile(A06(0, 43, 105));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    public static int A00(String str) {
        byte b;
        switch (str.hashCode()) {
            case -2123537834:
                if (!str.equals(A06(387, 14, 38))) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -1095064472:
                if (!str.equals(A06(553, 13, 95))) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 187078296:
                if (!str.equals(A06(359, 9, 67))) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 187078297:
                if (!str.equals(A06(368, 9, 14))) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 1504578661:
                if (!str.equals(A06(377, 10, 21))) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 1505942594:
                if (!str.equals(A06(566, 16, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE))) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case 1556697186:
                if (!str.equals(A06(540, 13, 14))) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 18;
            case 3:
                return 17;
            case 4:
                return 7;
            case 5:
                return 8;
            case 6:
                if (A01[5].length() != 3) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "hKYQTACTdOogv";
                strArr[3] = "jW42kNuSo4nZgs64O";
                return 14;
            default:
                return 0;
        }
    }

    public static int A01(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        boolean zA0C = A0C(str);
        String[] strArr = A01;
        if (strArr[1].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "k6b8HgxG1eJSt";
        strArr2[3] = "sHODvi2HKJy0fWhhW";
        if (zA0C) {
            return 1;
        }
        if (A0F(str)) {
            return 2;
        }
        if (A0E(str)) {
            return 3;
        }
        if (A0D(str)) {
            return 4;
        }
        if (A06(108, 15, 4).equals(str) || A06(203, 18, 65).equals(str) || A06(314, 20, 69).equals(str)) {
            return 5;
        }
        if (A06(176, 27, 41).equals(str)) {
            return 6;
        }
        return A02(str);
    }

    public static int A02(String str) {
        int customMimeTypeCount = A02.size();
        if (0 < customMimeTypeCount) {
            A02.get(0);
            throw new NullPointerException(A06(814, 8, 36));
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x00df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e6 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:6:0x0011 A[RETURN] */
    public static int A03(String str, String str2) {
        byte b;
        Q1 objectType;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(A06(387, 14, 38))) {
                    b = 4;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null && (objectType = A04(str2)) != null) {
                            return objectType.A00();
                        }
                        return 0;
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case -1095064472:
                if (str.equals(A06(553, 13, 95))) {
                    b = 6;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case -53558318:
                if (str.equals(A06(470, 15, 18))) {
                    b = 1;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case 187078296:
                if (str.equals(A06(359, 9, 67))) {
                    b = 2;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case 187078297:
                if (str.equals(A06(368, 9, 14))) {
                    b = 5;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case 1504578661:
                if (A01[5].length() != 3) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[6] = "mvCXLdLyKX5RTXKHhOAWYyz5QFNIz3Ad";
                strArr[4] = "8O0ro2uCyXGiQ5NOyO7ahlW5NyfS566D";
                if (str.equals(A06(377, 10, 21))) {
                    b = 3;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case 1504831518:
                if (str.equals(A06(485, 10, 71))) {
                    b = 0;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case 1505942594:
                if (str.equals(A06(566, 16, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE))) {
                    b = 7;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
            case 1556697186:
                if (str.equals(A06(540, 13, 14))) {
                    b = 8;
                }
                switch (b) {
                    case 0:
                        return 9;
                    case 1:
                        if (str2 == null) {
                            return 0;
                        }
                        return objectType.A00();
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                    case 4:
                        return 18;
                    case 5:
                        return 17;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 14;
                    default:
                        return 0;
                }
        }
        b = -1;
        switch (b) {
            case 0:
                return 9;
            case 1:
                if (str2 == null) {
                    return 0;
                }
                return objectType.A00();
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 18;
            case 5:
                return 17;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 14;
            default:
                return 0;
        }
    }

    public static String A05(int i) {
        switch (i) {
            case 32:
                return A06(903, 13, 50);
            case 33:
                return A06(866, 9, 36);
            case 35:
                return A06(893, 10, 38);
            case 64:
            case 102:
            case 103:
            case 104:
                return A06(470, 15, 18);
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return A06(926, 11, 15);
            case 105:
            case 107:
                return A06(485, 10, 71);
            case 106:
                return A06(916, 10, 34);
            case 108:
                return A06(796, 10, 11);
            case 163:
                String[] strArr = A01;
                if (strArr[2].length() == strArr[3].length()) {
                    throw new RuntimeException();
                }
                A01[5] = "b4B";
                return A06(937, 10, 15);
            case 165:
                return A06(359, 9, 67);
            case 166:
                return A06(377, 10, 21);
            case 169:
            case 172:
                return A06(553, 13, 95);
            case 170:
            case 171:
                return A06(566, 16, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
            case 173:
                return A06(521, 10, 77);
            case 174:
                return A06(368, 9, 14);
            case 177:
                return A06(966, 19, 51);
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:38:0x010d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0118  */
    public static String A07(String str) {
        Q1 q1A04;
        if (str != null) {
            String strA01 = AbstractC2555hb.A01(str.trim());
            if (!strA01.startsWith(A06(686, 4, 90))) {
                String strA06 = A06(690, 4, 115);
                if (A01[7].length() == 15) {
                    throw new RuntimeException();
                }
                A01[7] = "uY";
                if (!strA01.startsWith(strA06)) {
                    if (strA01.startsWith(A06(783, 4, 92)) || strA01.startsWith(A06(787, 4, 9))) {
                        return A06(893, 10, 38);
                    }
                    if (!strA01.startsWith(A06(753, 4, 16))) {
                        String strA07 = A06(749, 4, 117);
                        String[] strArr = A01;
                        if (strArr[2].length() != strArr[3].length()) {
                            A01[7] = "VdcYlAQ3vue";
                            if (!strA01.startsWith(strA07)) {
                                if (!strA01.startsWith(A06(761, 4, 39)) && !strA01.startsWith(A06(757, 4, 63))) {
                                    if (strA01.startsWith(A06(682, 4, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                                        return A06(856, 10, 104);
                                    }
                                    if (!strA01.startsWith(A06(1002, 3, 83)) || strA01.startsWith(A06(995, 4, 43))) {
                                        return A06(966, 19, 51);
                                    }
                                    if (strA01.startsWith(A06(999, 3, 66)) || strA01.startsWith(A06(991, 4, 26))) {
                                        String strA08 = A06(947, 19, 111);
                                        if (A01[5].length() != 3) {
                                            return strA08;
                                        }
                                        String[] strArr2 = A01;
                                        strArr2[1] = "X";
                                        strArr2[0] = "yf2k9PeUUEF7EnsRFEpAzt41";
                                        return strA08;
                                    }
                                    if (strA01.startsWith(A06(822, 4, 79))) {
                                        String strA05 = null;
                                        String mimeType = A06(826, 5, 1);
                                        if (strA01.startsWith(mimeType) && (q1A04 = A04(strA01)) != null) {
                                            strA05 = A05(q1A04.A01);
                                        }
                                        return strA05 == null ? A06(470, 15, 18) : strA05;
                                    }
                                    if (strA01.startsWith(A06(EventTypeExtended.EVENT_TYPE_EXTENDED_CUSTOM_WIN_VALUE, 4, 8))) {
                                        return A06(441, 10, 99);
                                    }
                                    if (strA01.startsWith(A06(810, 4, 54))) {
                                        return A06(451, 10, 77);
                                    }
                                    if (strA01.startsWith(A06(43, 4, 93)) || strA01.startsWith(A06(717, 4, 102))) {
                                        return A06(359, 9, 67);
                                    }
                                    if (strA01.startsWith(A06(769, 4, 49)) || strA01.startsWith(A06(725, 4, 41))) {
                                        return A06(377, 10, 21);
                                    }
                                    if (strA01.startsWith(A06(765, 4, 30))) {
                                        return A06(387, 14, 38);
                                    }
                                    if (strA01.startsWith(A06(47, 4, 93)) || strA01.startsWith(A06(721, 4, 58))) {
                                        return A06(368, 9, 14);
                                    }
                                    if (strA01.startsWith(A06(729, 4, 3))) {
                                        return A06(553, 13, 95);
                                    }
                                    if (strA01.startsWith(A06(733, 4, 99))) {
                                        return A06(582, 28, 99);
                                    }
                                    if (strA01.startsWith(A06(737, 4, 73)) || strA01.startsWith(A06(741, 4, 59))) {
                                        return A06(566, 16, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
                                    }
                                    if (strA01.startsWith(A06(745, 4, 120))) {
                                        return A06(610, 28, 100);
                                    }
                                    if (strA01.startsWith(A06(831, 4, 83))) {
                                        return A06(521, 10, 77);
                                    }
                                    if (strA01.startsWith(A06(985, 6, 67))) {
                                        return A06(638, 12, 80);
                                    }
                                    if (strA01.startsWith(A06(779, 4, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE))) {
                                        return A06(401, 10, 15);
                                    }
                                    if (strA01.startsWith(A06(835, 4, 67))) {
                                        return A06(138, 20, 10);
                                    }
                                    if (strA01.startsWith(A06(1005, 4, 26))) {
                                        return A06(843, 8, 105);
                                    }
                                    if (strA01.contains(A06(700, 6, 68))) {
                                        return A06(70, 19, 23);
                                    }
                                    if (!strA01.contains(A06(773, 6, 31)) && !strA01.contains(A06(694, 6, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE))) {
                                        return A09(strA01);
                                    }
                                    String[] strArr3 = A01;
                                    if (strArr3[6].charAt(23) == strArr3[4].charAt(23)) {
                                        String[] strArr4 = A01;
                                        strArr4[1] = ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM;
                                        strArr4[0] = "tteHNcQnKuQyCPrqfUdz6Vqy";
                                        return A06(51, 19, 7);
                                    }
                                }
                            }
                        } else {
                            String[] strArr5 = A01;
                            strArr5[1] = "M";
                            strArr5[0] = "GbxAwnDi0CTPYfjzDfkncVNj";
                            if (!strA01.startsWith(strA07)) {
                                if (!strA01.startsWith(A06(761, 4, 39))) {
                                    if (strA01.startsWith(A06(682, 4, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                                        return A06(856, 10, 104);
                                    }
                                    if (!strA01.startsWith(A06(1002, 3, 83))) {
                                    }
                                    return A06(966, 19, 51);
                                }
                            }
                        }
                    }
                    return A06(875, 18, 32);
                }
            }
            return A06(866, 9, 36);
        }
        String[] strArr6 = A01;
        if (strArr6[1].length() != strArr6[0].length()) {
            A01[7] = "M7E0EBXUeIOo9SwOuJ1NdOYQNJyWbT9R";
            return null;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public static String A08(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1007807498:
                if (!str.equals(A06(659, 12, 117))) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case -586683234:
                if (!str.equals(A06(671, 11, 110))) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 187090231:
                if (!str.equals(A06(461, 9, 81))) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return A06(401, 10, 15);
            case 1:
                if (A01[7].length() == 15) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[6] = "6sFwrjulZT4VlZzO9Uzh6my59kprzUza";
                strArr[4] = "N4TBYujlx0iv1PS4aPSOtkF54qrUOs3Z";
                return A06(485, 10, 71);
            case 2:
                return A06(650, 9, 111);
            default:
                return str;
        }
    }

    public static String A09(String str) {
        int customMimeTypeCount = A02.size();
        if (0 < customMimeTypeCount) {
            A02.get(0);
            throw new NullPointerException(A06(706, 11, 44));
        }
        return null;
    }

    public static String A0A(String str) {
        int indexOfSlash;
        if (str == null || (indexOfSlash = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOfSlash);
    }

    public static boolean A0C(String str) {
        return A06(354, 5, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE).equals(A0A(str));
    }

    public static boolean A0D(String str) {
        return A06(791, 5, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE).equals(A0A(str));
    }

    public static boolean A0E(String str) {
        return A06(839, 4, 2).equals(A0A(str)) || A06(51, 19, 7).equals(str) || A06(70, 19, 23).equals(str) || A06(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 25, 24).equals(str) || A06(334, 20, 88).equals(str) || A06(138, 20, 10).equals(str) || A06(267, 28, 66).equals(str) || A06(246, 21, 65).equals(str) || A06(l.h, 19, 87).equals(str) || A06(158, 18, 7).equals(str) || A06(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 15, 53).equals(str) || A06(89, 19, 34).equals(str);
    }

    public static boolean A0F(String str) {
        return A06(851, 5, 11).equals(A0A(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:45:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fb A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:52:0x0114  */
    /* JADX WARN: Code duplicated, block: B:54:0x011d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0123  */
    /* JADX WARN: Code duplicated, block: B:60:0x0129 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0010 A[RETURN] */
    public static boolean A0G(String str, String str2) {
        byte b;
        Q1 q1A04;
        int encoding;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(A06(387, 14, 38))) {
                    b = 9;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null || (q1A04 = A04(str2)) == null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        return (encoding == 0 || encoding == 16) ? false : true;
                    default:
                        return false;
                }
            case -432837260:
                if (str.equals(A06(495, 13, 92))) {
                    b = 1;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case -432837259:
                if (str.equals(A06(508, 13, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                    b = 2;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case -53558318:
                if (str.equals(A06(470, 15, 18))) {
                    b = 10;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case 187078296:
                if (str.equals(A06(359, 9, 67))) {
                    b = 7;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case 187094639:
                boolean zEquals = str.equals(A06(531, 9, 61));
                String[] strArr = A01;
                if (strArr[2].length() != strArr[3].length()) {
                    A01[5] = "tGu";
                    if (zEquals) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    switch (b) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            return true;
                        case 10:
                            if (str2 != null) {
                                return false;
                            }
                            encoding = q1A04.A00();
                            if (A01[7].length() != 15) {
                                throw new RuntimeException();
                            }
                            A01[7] = "CjNSp7sLzll5zBXj0CWS";
                            if (encoding == 0) {
                                return false;
                            }
                        default:
                            return false;
                    }
                }
                throw new RuntimeException();
            case 1504578661:
                if (str.equals(A06(377, 10, 21))) {
                    b = 8;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case 1504619009:
                if (str.equals(A06(401, 10, 15))) {
                    b = 6;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case 1504831518:
                if (str.equals(A06(485, 10, 71))) {
                    b = 0;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case 1903231877:
                if (str.equals(A06(411, 15, 61))) {
                    b = 4;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            case 1903589369:
                if (str.equals(A06(426, 15, 105))) {
                    b = 5;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
            default:
                b = -1;
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                    case 10:
                        if (str2 != null) {
                            return false;
                        }
                        encoding = q1A04.A00();
                        if (A01[7].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[7] = "CjNSp7sLzll5zBXj0CWS";
                        if (encoding == 0) {
                            return false;
                        }
                    default:
                        return false;
                }
        }
    }
}
