package com.facebook.ads.redexgen.core;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.16, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass16 extends C9H {
    public static byte[] A05;
    public static String[] A06 = {"w4KX5wki0eOcHNxb6DLYHja1O4zAsp3C", "G8sK4wpUm6gDs4fpfHcn", "RmT0gVvbjZ0sIHv5unzCwSebE3y", "VnpIDpEwsBj2tcdExDnl", "qIoKZcn9m5PV3cAbAA39zUUmv0A0cSWb", "rMXFM4nDHDbbcscKiDSXlkr0QP", "ILXkhLfoXouD33ttJCp", "Crw9C7vA3esUT1Svowt"};
    public static final Pattern A07;
    public float A00;
    public float A01;
    public Map<String, XO> A02;
    public final XJ A03;
    public final boolean A04;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        byte[] bArr = {Ascii.NAK, 37, 50, 55, 37, 81, 105, 38, 36, 55, 36, 50, 37, 81, 105, 38, 36, 55, 37, 81, 105, 38, 36, 86, 55, 35, 80, 37, 81, 105, 38, 36, Ascii.SYN, 83, 44, 1, 9, 4, 7, Ascii.SI, Ascii.GS, Ascii.CR, 82, 34, Ascii.VT, Ascii.SYN, 9, 5, Ascii.DLE, 94, 3, 59, 57, 32, 32, 57, 62, 55, 112, 119, 3, 36, 41, 60, 53, 106, 119, 112, 60, 57, 62, 53, 112, 50, 53, 54, 63, 34, 53, 112, 119, Ascii.SYN, 63, 34, Base64.padSymbol, 49, 36, 106, 119, 112, 60, 57, 62, 53, 106, 112, 17, 41, 43, 50, 50, 43, 44, 37, 98, 38, 43, 35, 46, 45, 37, 55, 39, 98, 46, 43, 44, 39, 98, 32, 39, 36, 45, 48, 39, 98, 33, 45, 47, 50, 46, 39, 54, 39, 98, 36, 45, 48, 47, 35, 54, 120, 98, 7, 63, Base64.padSymbol, 36, 36, Base64.padSymbol, 58, 51, 116, 48, Base64.padSymbol, 53, 56, 59, 51, 33, 49, 116, 56, Base64.padSymbol, 58, 49, 116, 35, Base64.padSymbol, 32, 60, 116, 50, 49, 35, 49, 38, 116, 55, 59, 56, 33, 57, 58, 39, 116, 32, 60, 53, 58, 116, 50, 59, 38, 57, 53, 32, 110, 116, 37, Ascii.GS, Ascii.US, 6, 6, Ascii.US, Ascii.CAN, 17, 86, Ascii.US, Ascii.CAN, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, 86, 2, Ascii.US, Ascii.ESC, Ascii.US, Ascii.CAN, 17, 76, 86, 62, Ascii.RS, Ascii.FF, 41, 8, Ascii.SO, 2, 9, 8, Ascii.US, 127, 88, 85, SignedBytes.MAX_POWER_OF_TWO, 73, Ascii.SYN, 19, 40, 45, 40, 41, 49, 40, 102, 39, 42, 47, 33, 40, 43, 35, 40, 50, 124, 102, 95, 65, 114, 97, 106, 112, 119, 89, 100, 108, 92, 77, 86, 79, 75, Ascii.US, 118, 81, 89, 80, 98, 43, 38, 68, 80, 35, 4, 9, Ascii.FS, Ascii.NAK, 3, 45, 75, 70, 36, 48, 67, 100, 105, 124, 117, 99, 77, 48, 113, 98, 117, 48, 126, 127, 100, 48, 99, 101, 96, 96, 127, 98, 100, 117, 116, 80, 93, 63, 32, 43, 88, 127, 114, 103, 110, 120, 86, 83, 65, 43, Ascii.US, 1, 51, Ascii.DC2, Ascii.SO, 3, Ascii.ESC, Ascii.DLE, 7, 17, Ascii.SUB, Ascii.CR, 17, Ascii.FS, 4, Ascii.SI, Ascii.CAN, Ascii.SO, 4, -31, -125};
        String[] strArr = A06;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A06[5] = "PiMgTbnQ9edBvvt6lVNDxHF5QmkmMIU";
        A05 = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:35:0x0194  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0D(String str, XJ xj, List<List<C1853Qh>> list, List<Long> list2) {
        XO xo;
        String strA07 = A07(34, 9, 75);
        AbstractC2388es.A07(str.startsWith(strA07));
        String[] strArrSplit = str.substring(strA07.length()).split(A07(32, 1, 25), xj.A01);
        int length = strArrSplit.length;
        int i = xj.A01;
        String strA08 = A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78);
        if (length != i) {
            AbstractC2432fb.A07(strA08, A07(143, 55, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) + str);
            return;
        }
        long jA04 = A04(strArrSplit[xj.A02]);
        String strA09 = A07(198, 25, 85);
        String[] strArr = A06;
        if (strArr[0].charAt(15) != strArr[4].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[6] = "oDnNztEwmKtdYaVD0eA";
        strArr2[7] = "Rbh8M25EMZvU3PdSKit";
        if (jA04 == -9223372036854775807L) {
            AbstractC2432fb.A07(strA08, strA09 + str);
            return;
        }
        long jA05 = A04(strArrSplit[xj.A00]);
        if (jA05 == -9223372036854775807L) {
            AbstractC2432fb.A07(strA08, strA09 + str);
            return;
        }
        if (this.A02 != null) {
            int i2 = xj.A03;
            String[] strArr3 = A06;
            if (strArr3[1].length() != strArr3[3].length()) {
                String[] strArr4 = A06;
                strArr4[0] = "sTOy4aUjj4ncbrrbprQ5KlV2z6wXApoZ";
                strArr4[4] = "1aJ18I0T4VuxCfhbfIdwbrFYryK7suWq";
                if (i2 != -1) {
                    xo = this.A02.get(strArrSplit[xj.A03].trim());
                } else {
                    xo = null;
                }
            } else {
                A06[2] = "M1zMwHTfXY1ezRmtQHP1HUp8zuc";
                if (i2 != -1) {
                    xo = this.A02.get(strArrSplit[xj.A03].trim());
                } else {
                    xo = null;
                }
            }
        } else {
            xo = null;
        }
        String str2 = strArrSplit[xj.A04];
        XL xlA02 = XL.A02(str2);
        String strA04 = XL.A04(str2);
        String strA010 = A07(331, 2, 44);
        String strA011 = A07(0, 1, 60);
        C1853Qh c1853QhA06 = A06(strA04.replace(strA010, strA011).replace(A07(335, 2, 126), strA011).replace(A07(333, 2, 84), A07(353, 2, 0)), xo, xlA02, this.A01, this.A00);
        int iA03 = A03(jA05, list2, list);
        for (int iA04 = A03(jA04, list2, list); iA04 < iA03; iA04++) {
            List<C1853Qh> list3 = list.get(iA04);
            String[] strArr5 = A06;
            if (strArr5[1].length() != strArr5[3].length()) {
                throw new RuntimeException();
            }
            A06[5] = "hKUh7vCaTBTCwODX";
            list3.add(c1853QhA06);
        }
    }

    static {
        A09();
        A07 = Pattern.compile(A07(1, 31, 46));
    }

    public AnonymousClass16() {
        this(null);
    }

    public AnonymousClass16(List<byte[]> list) {
        super(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78));
        this.A01 = -3.4028235E38f;
        this.A00 = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.A04 = true;
            String strA0q = AbstractC2471gE.A0q(list.get(0));
            String formatLine = A07(43, 7, 71);
            AbstractC2388es.A07(strA0q.startsWith(formatLine));
            this.A03 = (XJ) AbstractC2388es.A01(XJ.A00(strA0q));
            A0A(new C2447fq(list.get(1)));
            return;
        }
        this.A04 = false;
        this.A03 = null;
    }

    public static float A00(int i) {
        switch (i) {
            case 0:
                return 0.05f;
            case 1:
                return 0.5f;
            case 2:
                return 0.95f;
            default:
                return -3.4028235E38f;
        }
    }

    public static int A01(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                AbstractC2432fb.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78), A07(239, 19, 101) + i);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                String[] strArr = A06;
                if (strArr[6].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A06;
                strArr2[6] = "meUzX1SUOdYVJpkx005";
                strArr2[7] = "dgD45xlYZVaApp0HKGN";
                return 0;
        }
    }

    public static int A02(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                AbstractC2432fb.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78), A07(239, 19, 101) + i);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    public static int A03(long j, List<Long> sortedCueTimesUs, List<List<C1853Qh>> list) {
        ArrayList arrayList;
        int i = 0;
        int insertionIndex = sortedCueTimesUs.size();
        for (int i2 = insertionIndex - 1; i2 >= 0; i2--) {
            if (sortedCueTimesUs.get(i2).longValue() == j) {
                return i2;
            }
            if (sortedCueTimesUs.get(i2).longValue() < j) {
                i = i2 + 1;
                break;
            }
        }
        sortedCueTimesUs.add(i, Long.valueOf(j));
        if (i == 0) {
            arrayList = new ArrayList();
        } else {
            int insertionIndex2 = i - 1;
            arrayList = new ArrayList(list.get(insertionIndex2));
        }
        list.add(i, arrayList);
        return i;
    }

    public static long A04(String str) {
        Matcher matcher = A07.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) AbstractC2471gE.A0f(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) AbstractC2471gE.A0f(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) AbstractC2471gE.A0f(matcher.group(3))) * 1000000) + (Long.parseLong((String) AbstractC2471gE.A0f(matcher.group(4))) * 10000);
    }

    public static Layout.Alignment A05(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                AbstractC2432fb.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78), A07(239, 19, 101) + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0073  */
    public static C1853Qh A06(String str, XO xo, XL xl, float f, float f2) {
        int i;
        SpannableString spannableString = new SpannableString(str);
        C2245cY c2245cYA0G = new C2245cY().A0G(spannableString);
        if (xo != null) {
            if (xo.A04 != null) {
                spannableString.setSpan(new ForegroundColorSpan(xo.A04.intValue()), 0, spannableString.length(), 33);
            }
            if (xo.A02 == 3) {
                Integer num = xo.A03;
                if (A06[5].length() == 30) {
                    throw new RuntimeException();
                }
                A06[2] = "dfxN111jksQ8PzePc6z7TWkqapT";
                if (num != null) {
                    spannableString.setSpan(new BackgroundColorSpan(xo.A03.intValue()), 0, spannableString.length(), 33);
                }
            }
            if (xo.A00 != -3.4028235E38f) {
                if (A06[2].length() == 27) {
                    String[] strArr = A06;
                    strArr[1] = "qp2Cs8tqYnPlBGDT77Xt";
                    strArr[3] = "td41Nrzxw1DgyYSCbKAn";
                    if (f2 != -3.4028235E38f) {
                        c2245cYA0G.A08(xo.A00 / f2, 1);
                    }
                } else if (f2 != -3.4028235E38f) {
                    c2245cYA0G.A08(xo.A00 / f2, 1);
                }
            }
            if (xo.A06 && xo.A07) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (xo.A06) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (xo.A07) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (xo.A09) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (xo.A08) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        if (xl.A00 != -1) {
            i = xl.A00;
        } else if (xo != null) {
            i = xo.A01;
        } else {
            i = -1;
        }
        C2245cY cue = c2245cYA0G.A0F(A05(i));
        cue.A0A(A02(i)).A09(A01(i));
        if (xl.A01 != null && f2 != -3.4028235E38f && f != -3.4028235E38f) {
            c2245cYA0G.A04(xl.A01.x / f);
            c2245cYA0G.A07(xl.A01.y / f2, 0);
        } else {
            c2245cYA0G.A04(A00(c2245cYA0G.A01()));
            c2245cYA0G.A07(A00(c2245cYA0G.A00()), 0);
        }
        return c2245cYA0G.A0H();
    }

    public static Map<String, XO> A08(C2447fq c2447fq) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        XK xkA00 = null;
        while (true) {
            String strA0T = c2447fq.A0T();
            if (A06[5].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[6] = "SmO4FOLXvzQajx3WVuO";
            strArr[7] = "bJ8R3IY99nhxdy3Y24A";
            if (strA0T != null && (c2447fq.A07() == 0 || c2447fq.A0B() != 91)) {
                if (strA0T.startsWith(A07(43, 7, 71))) {
                    xkA00 = XK.A00(strA0T);
                } else if (strA0T.startsWith(A07(233, 6, 15))) {
                    if (xkA00 == null) {
                        String currentLine = A07(50, 46, 115) + strA0T;
                        AbstractC2432fb.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78), currentLine);
                    } else {
                        XO xoA04 = XO.A04(strA0T, xkA00);
                        if (xoA04 != null) {
                            linkedHashMap.put(xoA04.A05, xoA04);
                        }
                    }
                }
            } else {
                return linkedHashMap;
            }
        }
    }

    private void A0A(C2447fq c2447fq) {
        while (true) {
            String strA0T = c2447fq.A0T();
            if (strA0T != null) {
                if (A07(266, 13, 28).equalsIgnoreCase(strA0T)) {
                    A0B(c2447fq);
                } else {
                    String[] strArr = A06;
                    String currentLine = strArr[0];
                    if (currentLine.charAt(15) != strArr[4].charAt(15)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A06;
                    strArr2[6] = "FmD6kSuNAfqLCiPo1vf";
                    strArr2[7] = "I4ScjdcloSmskf1ICqM";
                    if (A07(Sdk.SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 12, 40).equalsIgnoreCase(strA0T)) {
                        this.A02 = A08(c2447fq);
                    } else if (A07(279, 11, 83).equalsIgnoreCase(strA0T)) {
                        AbstractC2432fb.A06(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78), A07(290, 29, 51));
                    } else if (A07(258, 8, 39).equalsIgnoreCase(strA0T)) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 32, insns: 0 */
    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getId()" because "imPostDom" is null
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:190)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:72)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void A0B(com.facebook.ads.redexgen.core.C2447fq r8) {
        /*
            r7 = this;
        L0:
            java.lang.String r3 = r8.A0T()
            if (r3 == 0) goto L7b
            int r0 = r8.A07()
            if (r0 == 0) goto L14
            int r1 = r8.A0B()
            r0 = 91
            if (r1 == r0) goto L7b
        L14:
            r2 = 33
            r1 = 1
            r0 = 74
            java.lang.String r0 = A07(r2, r1, r0)
            java.lang.String[] r5 = r3.split(r0)
            int r1 = r5.length
            r0 = 2
            if (r1 == r0) goto L26
            goto L0
        L26:
            r6 = 0
            r0 = r5[r6]
            java.lang.String r0 = r0.trim()
            java.lang.String r4 = com.facebook.ads.redexgen.core.AbstractC2555hb.A01(r0)
            int r0 = r4.hashCode()
            r3 = 1
            switch(r0) {
                case 1879649548: goto L50;
                case 1879649549: goto L3e;
                default: goto L39;
            }
        L39:
            r6 = -1
        L3a:
            switch(r6) {
                case 0: goto L6e;
                case 1: goto L61;
                default: goto L3d;
            }
        L3d:
            goto L0
        L3e:
            r2 = 345(0x159, float:4.83E-43)
            r1 = 8
            r0 = 94
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L39
            r6 = 1
            goto L3a
        L50:
            r2 = 337(0x151, float:4.72E-43)
            r1 = 8
            r0 = 65
            java.lang.String r0 = A07(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L39
            goto L3a
        L61:
            r0 = r5[r3]     // Catch: java.lang.NumberFormatException -> L0
            java.lang.String r0 = r0.trim()     // Catch: java.lang.NumberFormatException -> L0
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L0
            r7.A00 = r0     // Catch: java.lang.NumberFormatException -> L0
            goto L0
        L6e:
            r0 = r5[r3]     // Catch: java.lang.NumberFormatException -> L0
            java.lang.String r0 = r0.trim()     // Catch: java.lang.NumberFormatException -> L0
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L0
            r7.A01 = r0     // Catch: java.lang.NumberFormatException -> L0
            goto L0
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass16.A0B(com.facebook.ads.redexgen.X.fq):void");
    }

    private void A0C(C2447fq c2447fq, List<List<C1853Qh>> list, List<Long> list2) {
        XJ xjA00 = this.A04 ? this.A03 : null;
        while (true) {
            String strA0T = c2447fq.A0T();
            if (strA0T != null) {
                if (strA0T.startsWith(A07(43, 7, 71))) {
                    xjA00 = XJ.A00(strA0T);
                } else if (strA0T.startsWith(A07(34, 9, 75))) {
                    if (xjA00 == null) {
                        AbstractC2432fb.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 78), A07(96, 47, 97) + strA0T);
                    } else {
                        A0D(strA0T, xjA00, list, list2);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.C9H
    public final InterfaceC2013Wv A0g(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C2447fq c2447fq = new C2447fq(bArr, i);
        if (!this.A04) {
            A0A(c2447fq);
        }
        A0C(c2447fq, arrayList, arrayList2);
        return new TF(arrayList, arrayList2);
    }
}
