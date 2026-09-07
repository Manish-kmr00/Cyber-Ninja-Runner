package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XU {
    public static byte[] A03;
    public static String[] A04 = {"EFKFawmyyzDqeJuiKg", "6XZM8y5RhSRd50HBhgrMaoPdsslxtg", "wmAakdoS4x90LYfRlKy6e", "JO810ePF4RobPZPID0YD1lImespMMw1m", "19t0upKJWDWK8rDsDxKYAUOz6naMJM", "itlzYktnGg1go8iYB95NP7oH9xUVEeba", "0Tt5FWNcRMEXbQwCzq3NZciG2Q4bF8AK", "MTg8TP2YDeg6DzHxMqlqsDWUFI4ALySl"};
    public static final OG<String> A05;
    public static final OG<String> A06;
    public static final OG<String> A07;
    public static final OG<String> A08;
    public static final Pattern A09;
    public final int A00;
    public final int A01;
    public final int A02;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0061  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:49:0x010e  */
    /* JADX WARN: Code duplicated, block: B:4:0x0020  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static XU A00(OG<String> og) {
        byte b;
        int i;
        byte b2;
        int i2;
        int i3;
        int i4;
        C1789Nr c1789NrA02 = AbstractC2933nx.A02(A07, og);
        String strA02 = A02(41, 7, 75);
        String str = (String) AbstractC2834mH.A00(c1789NrA02, strA02);
        byte b3 = 2;
        byte b4 = 1;
        switch (str.hashCode()) {
            case -1392885889:
                if (!str.equals(A02(12, 6, 35))) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -1106037339:
                if (!str.equals(strA02)) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 92734940:
                if (!str.equals(A02(3, 5, 17))) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                i = 2;
                break;
            case 1:
                i = -2;
                break;
            default:
                i = 1;
                break;
        }
        C1789Nr c1789NrA03 = AbstractC2933nx.A02(A08, og);
        boolean zIsEmpty = c1789NrA03.isEmpty();
        String[] strArr = A04;
        if (strArr[5].charAt(4) == strArr[6].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "iAUgK7xlkQkR0BAUTQ";
        strArr2[2] = "MObNamDJSZhf2E2WRsbEa";
        if (!zIsEmpty) {
            String str2 = (String) c1789NrA03.iterator().next();
            switch (str2.hashCode()) {
                case 3005871:
                    if (!str2.equals(A02(8, 4, 68))) {
                        b4 = -1;
                    }
                    break;
                case 3387192:
                    if (!str2.equals(A02(33, 4, 88))) {
                        b4 = -1;
                    } else {
                        b4 = 0;
                    }
                    break;
                default:
                    b4 = -1;
                    break;
            }
            switch (b4) {
                case 0:
                    i4 = 0;
                    break;
                default:
                    i4 = -1;
                    break;
            }
            return new XU(i4, 0, i);
        }
        C1789Nr c1789NrA04 = AbstractC2933nx.A02(A05, og);
        C1789Nr c1789NrA05 = AbstractC2933nx.A02(A06, og);
        if (c1789NrA04.isEmpty() && c1789NrA05.isEmpty()) {
            return new XU(-1, 0, i);
        }
        String strA03 = A02(27, 6, 99);
        String str3 = (String) AbstractC2834mH.A00(c1789NrA04, strA03);
        switch (str3.hashCode()) {
            case -1274499742:
                if (!str3.equals(strA03)) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 3417674:
                if (!str3.equals(A02(37, 4, 94))) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                i2 = 2;
                break;
            default:
                i2 = 1;
                break;
        }
        String strA04 = A02(18, 6, 13);
        String str4 = (String) AbstractC2834mH.A00(c1789NrA05, strA04);
        switch (str4.hashCode()) {
            case -1360216880:
                if (!str4.equals(strA04)) {
                    b3 = -1;
                }
                break;
            case -905816648:
                if (!str4.equals(A02(48, 6, 21))) {
                    b3 = -1;
                } else {
                    b3 = 1;
                }
                break;
            case 99657:
                if (!str4.equals(A02(24, 3, 86))) {
                    b3 = -1;
                } else {
                    b3 = 0;
                }
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                i3 = 2;
                break;
            case 1:
                i3 = 3;
                break;
            default:
                i3 = 1;
                break;
        }
        return new XU(i3, i2, i);
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{Ascii.US, 54, -18, -39, -34, -20, -35, -22, Ascii.FF, 32, Ascii.US, Ascii.SUB, -20, -17, -16, -7, -4, -17, -41, -35, -26, -41, -32, -39, 33, 44, 49, 48, 51, 54, 54, 47, 46, 45, 46, 45, 36, 52, 53, 42, 51, 33, 39, 38, 37, Ascii.ESC, Ascii.SYN, Ascii.ETB, -17, -31, -17, -35, -23, -31};
    }

    static {
        A03();
        A09 = Pattern.compile(A02(0, 3, 92));
        A08 = OG.A05(A02(8, 4, 68), A02(33, 4, 88));
        A06 = OG.A06(A02(24, 3, 86), A02(48, 6, 21), A02(18, 6, 13));
        A05 = OG.A05(A02(27, 6, 99), A02(37, 4, 94));
        A07 = OG.A06(A02(3, 5, 17), A02(12, 6, 35), A02(41, 7, 75));
    }

    public XU(int i, int i2, int i3) {
        this.A01 = i;
        this.A00 = i2;
        this.A02 = i3;
    }

    public static XU A01(String str) {
        if (str == null) {
            return null;
        }
        String parsingValue = AbstractC2555hb.A01(str.trim());
        if (parsingValue.isEmpty()) {
            return null;
        }
        return A00(OG.A08(TextUtils.split(parsingValue, A09)));
    }
}
