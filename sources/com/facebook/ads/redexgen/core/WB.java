package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.ColorInfo;
import com.google.android.exoplayer2.DrmInitData;
import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.extractor.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.extractor.metadata.mp4.SmtaMetadataEntry;
import com.google.common.base.Ascii;
import com.json.mediationsdk.demandOnly.e;
import com.json.mediationsdk.logger.IronSourceError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class WB {
    public static byte[] A00;
    public static String[] A01 = {"Rq8K3x9U6U1qnsB", "LPhciFlpISIohAYgfLC9bA1lF1kOL0Ev", "9Kwqffs0Fu7WvZLbN9VIaI08fq6D4cO", "IaUK2p7UOiGFLn9kVW8ZQ0f1En4DcOpn", "T7xi50LT", "hTsCLy", "XofUw9hlRhPN5LS3KR6wPxIXKAHFL8lH", "VM2F9Bf6TO1x13KEVoDanTgaEcENkxzJ"};
    public static final byte[] A02;

    @MetaExoPlayerCustomization("Needed for oculus customization")
    public static final int[] A03;

    /* JADX WARN: Code duplicated, block: B:46:0x017f  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ColorInfo A0B(C2447fq c2447fq) {
        O7 o7 = new O7();
        C2446fp c2446fp = new C2446fp(c2447fq.A0l());
        c2446fp.A08(c2447fq.A09() * 8);
        c2446fp.A0A(1);
        c2446fp.A04(3);
        c2446fp.A09(6);
        c2446fp.A0H();
        c2446fp.A0H();
        c2446fp.A09(13);
        c2446fp.A07();
        int iA04 = c2446fp.A04(4);
        String strA0M = A0M(178, 11, 31);
        if (iA04 != 1) {
            AbstractC2432fb.A06(strA0M, A0M(593, 22, 58) + iA04);
            return o7.A03();
        }
        if (c2446fp.A0H()) {
            AbstractC2432fb.A06(strA0M, A0M(563, 30, 76));
            return o7.A03();
        }
        boolean zA0H = c2446fp.A0H();
        c2446fp.A07();
        if (A01[1].charAt(20) != 'F') {
            String[] strArr = A01;
            strArr[4] = "ygmRQGJb";
            strArr[5] = "eEqpNm";
            if (zA0H && c2446fp.A04(8) > 127) {
                AbstractC2432fb.A06(strA0M, A0M(189, 18, 78));
                return o7.A03();
            }
            int iA05 = c2446fp.A04(3);
            c2446fp.A07();
            if (c2446fp.A0H()) {
                AbstractC2432fb.A06(strA0M, A0M(615, 40, 31));
                return o7.A03();
            }
            if (c2446fp.A0H()) {
                AbstractC2432fb.A06(strA0M, A0M(655, 36, 64));
                return o7.A03();
            }
            boolean zA0H2 = c2446fp.A0H();
            String[] strArr2 = A01;
            if (strArr2[4].length() != strArr2[5].length()) {
                A01[0] = "MIpXkdvQuD3oka1";
                if (zA0H2) {
                    AbstractC2432fb.A06(strA0M, A0M(494, 46, 70));
                    return o7.A03();
                }
                int iA06 = c2446fp.A04(5);
                for (int i = 0; i <= iA06; i++) {
                    c2446fp.A09(12);
                    if (c2446fp.A04(5) > 7) {
                        c2446fp.A07();
                    }
                }
                int iA07 = c2446fp.A04(4);
                int iA08 = c2446fp.A04(4);
                c2446fp.A09(iA07 + 1);
                c2446fp.A09(iA08 + 1);
                if (c2446fp.A0H()) {
                    c2446fp.A09(7);
                }
                c2446fp.A09(7);
                boolean zA0H3 = c2446fp.A0H();
                if (A01[3].charAt(8) != 'I') {
                    String[] strArr3 = A01;
                    strArr3[4] = "1s2zl1Dc";
                    strArr3[5] = "EykAS2";
                    if (zA0H3) {
                        c2446fp.A09(2);
                    }
                } else if (zA0H3) {
                    c2446fp.A09(2);
                }
                if ((c2446fp.A0H() ? 2 : c2446fp.A04(1)) > 0 && !c2446fp.A0H()) {
                    c2446fp.A09(1);
                }
                if (zA0H3) {
                    c2446fp.A09(3);
                }
                c2446fp.A09(3);
                boolean zA0H4 = c2446fp.A0H();
                if (iA05 == 2 && zA0H4) {
                    c2446fp.A07();
                }
                boolean z = iA05 != 1 && c2446fp.A0H();
                if (c2446fp.A0H()) {
                    int iA09 = c2446fp.A04(8);
                    int iA010 = c2446fp.A04(8);
                    o7.A01(ColorInfo.A00(iA09)).A00(((z || iA09 != 1 || iA010 != 13 || c2446fp.A04(8) != 0) ? c2446fp.A04(1) : 1) != 1 ? 2 : 1).A02(ColorInfo.A01(iA010));
                }
                return o7.A03();
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Metadata A0C(C1934Tm c1934Tm) {
        C1933Tl c1933TlA03 = c1934Tm.A03(1751411826);
        C1933Tl c1933TlA04 = c1934Tm.A03(1801812339);
        C1933Tl c1933TlA05 = c1934Tm.A03(1768715124);
        if (c1933TlA03 == null || c1933TlA04 == null || c1933TlA05 == null || A03(c1933TlA03.A00) != 1835299937) {
            return null;
        }
        C2447fq c2447fq = c1933TlA04.A00;
        c2447fq.A0f(12);
        int iA0C = c2447fq.A0C();
        String[] strArr = new String[iA0C];
        for (int i = 0; i < iA0C; i++) {
            int iA0C2 = c2447fq.A0C();
            c2447fq.A0g(4);
            strArr[i] = c2447fq.A0W(iA0C2 - 8);
        }
        C2447fq c2447fq2 = c1933TlA05.A00;
        c2447fq2.A0f(8);
        ArrayList arrayList = new ArrayList();
        while (c2447fq2.A07() > 8) {
            int iA09 = c2447fq2.A09();
            int iA0C3 = c2447fq2.A0C();
            int iA0C4 = c2447fq2.A0C() - 1;
            if (iA0C4 < 0 || iA0C4 >= strArr.length) {
                AbstractC2432fb.A07(A0M(178, 11, 31), A0M(359, 41, 109) + iA0C4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryA09 = WM.A09(c2447fq2, iA09 + iA0C3, strArr[iA0C4]);
                if (mdtaMetadataEntryA09 != null) {
                    arrayList.add(mdtaMetadataEntryA09);
                }
            }
            c2447fq2.A0f(iA09 + iA0C3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0089  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:38:0x0100  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static W7 A0G(C2447fq c2447fq, int i) {
        long jA0Q;
        long jA0Q2;
        byte[] bArr;
        String[] strArr;
        c2447fq.A0f(i + 8 + 4);
        c2447fq.A0g(1);
        A02(c2447fq);
        c2447fq.A0g(2);
        int iA0I = c2447fq.A0I();
        if ((iA0I & 128) != 0) {
            c2447fq.A0g(2);
        }
        if ((iA0I & 64) != 0) {
            int iA0I2 = c2447fq.A0I();
            if (A01[0].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "a0ifAnW3";
            strArr2[5] = "xIt804";
            c2447fq.A0g(iA0I2);
        }
        if ((iA0I & 32) != 0) {
            c2447fq.A0g(2);
        }
        c2447fq.A0g(1);
        A02(c2447fq);
        String strA05 = Q2.A05(c2447fq.A0I());
        if (!A0M(947, 10, 74).equals(strA05)) {
            if (A01[0].length() == 15) {
                A01[1] = "MBz6eoQ4a4Y5v7bMJrTvOD7zMLXLAF45";
                if (!A0M(989, 13, 85).equals(strA05)) {
                    if (!A0M(1002, 16, 49).equals(strA05)) {
                        c2447fq.A0g(4);
                        jA0Q = c2447fq.A0Q();
                        jA0Q2 = c2447fq.A0Q();
                        c2447fq.A0g(1);
                        int iA02 = A02(c2447fq);
                        bArr = new byte[iA02];
                        c2447fq.A0k(bArr, 0, iA02);
                        if (jA0Q2 <= 0) {
                            jA0Q2 = -1;
                        }
                        if (jA0Q <= 0) {
                            jA0Q = -1;
                        }
                        strArr = A01;
                        if (strArr[7].charAt(7) != strArr[6].charAt(7)) {
                            A01[2] = "I3o6H82Kvv0jVLLV1Q0zKrUjQbe4GJG";
                            return new W7(strA05, bArr, jA0Q2, jA0Q);
                        }
                        A01[1] = "PfTSBEnqsXODLHGQCFE6C5fFllaC2Ds3";
                        return new W7(strA05, bArr, jA0Q2, jA0Q);
                    }
                }
            } else if (!A0M(989, 13, 85).equals(strA05)) {
                if (!A0M(1002, 16, 49).equals(strA05)) {
                    c2447fq.A0g(4);
                    jA0Q = c2447fq.A0Q();
                    jA0Q2 = c2447fq.A0Q();
                    c2447fq.A0g(1);
                    int iA03 = A02(c2447fq);
                    bArr = new byte[iA03];
                    c2447fq.A0k(bArr, 0, iA03);
                    if (jA0Q2 <= 0) {
                        jA0Q2 = -1;
                    }
                    if (jA0Q <= 0) {
                        jA0Q = -1;
                    }
                    strArr = A01;
                    if (strArr[7].charAt(7) != strArr[6].charAt(7)) {
                        A01[2] = "I3o6H82Kvv0jVLLV1Q0zKrUjQbe4GJG";
                        return new W7(strA05, bArr, jA0Q2, jA0Q);
                    }
                    A01[1] = "PfTSBEnqsXODLHGQCFE6C5fFllaC2Ds3";
                    return new W7(strA05, bArr, jA0Q2, jA0Q);
                }
            }
        }
        return new W7(strA05, null, -1L, -1L);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static WA A0I(C2447fq c2447fq) {
        long jA0Q;
        int i;
        c2447fq.A0f(8);
        int iA03 = W5.A03(c2447fq.A0C());
        c2447fq.A0g(iA03 == 0 ? 8 : 16);
        int iA0C = c2447fq.A0C();
        c2447fq.A0g(4);
        boolean z = true;
        int iA09 = c2447fq.A09();
        int i2 = iA03 == 0 ? 4 : 8;
        for (int i3 = 0; i3 < i2; i3++) {
            if (c2447fq.A0l()[iA09 + i3] != -1) {
                z = false;
                break;
            }
        }
        if (z) {
            c2447fq.A0g(i2);
            jA0Q = -9223372036854775807L;
        } else {
            jA0Q = iA03 == 0 ? c2447fq.A0Q() : c2447fq.A0R();
            if (jA0Q == 0) {
                jA0Q = -9223372036854775807L;
            }
        }
        c2447fq.A0g(16);
        int iA0C2 = c2447fq.A0C();
        int iA0C3 = c2447fq.A0C();
        c2447fq.A0g(4);
        int iA0C4 = c2447fq.A0C();
        int iA0C5 = c2447fq.A0C();
        if (iA0C2 == 0 && iA0C3 == 65536 && iA0C4 == (-65536) && iA0C5 == 0) {
            i = 90;
        } else if (iA0C2 == 0 && iA0C3 == (-65536) && iA0C4 == 65536 && iA0C5 == 0) {
            i = 270;
        } else {
            i = (iA0C2 == (-65536) && iA0C3 == 0 && iA0C4 == 0 && iA0C5 == (-65536)) ? 180 : 0;
        }
        return new WA(iA0C, jA0Q, i);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static WZ A0J(C1934Tm c1934Tm, C1933Tl c1933Tl, long j, DrmInitData drmInitData, boolean z, boolean z2) throws Q6 {
        C1934Tm c1934TmA02;
        Pair<long[], long[]> pairA06;
        long j2 = j;
        C1934Tm c1934Tm2 = (C1934Tm) AbstractC2388es.A01(c1934Tm.A02(1835297121));
        int iA01 = A01(A03(((C1933Tl) AbstractC2388es.A01(c1934Tm2.A03(1751411826))).A00));
        if (iA01 == -1) {
            return null;
        }
        WA waA0I = A0I(((C1933Tl) AbstractC2388es.A01(c1934Tm.A03(1953196132))).A00);
        if (j2 == -9223372036854775807L) {
            j2 = waA0I.A02;
        }
        long jA05 = A05(c1933Tl.A00);
        long jA0U = j2 == -9223372036854775807L ? -9223372036854775807L : AbstractC2471gE.A0U(j2, 1000000L, jA05);
        C1934Tm c1934Tm3 = (C1934Tm) AbstractC2388es.A01(((C1934Tm) AbstractC2388es.A01(c1934Tm2.A02(1835626086))).A02(1937007212));
        Pair<Long, String> pairA08 = A08(((C1933Tl) AbstractC2388es.A01(c1934Tm2.A03(1835296868))).A00);
        C1933Tl c1933TlA03 = c1934Tm3.A03(1937011556);
        if (c1933TlA03 == null) {
            throw Q6.A01(A0M(288, 63, 18), null);
        }
        C2447fq c2447fq = c1933TlA03.A00;
        int i = waA0I.A00;
        int i2 = waA0I.A01;
        if (A01[0].length() != 15) {
            throw new RuntimeException();
        }
        A01[2] = "a6ThQLXS6v4ushcCg6g8wxrktGFbglX";
        W9 w9A0H = A0H(c2447fq, i, i2, (String) pairA08.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z && (c1934TmA02 = c1934Tm.A02(1701082227)) != null && (pairA06 = A06(c1934TmA02)) != null) {
            jArr = (long[]) pairA06.first;
            jArr2 = (long[]) pairA06.second;
        }
        if (w9A0H.A02 == null) {
            return null;
        }
        return new WZ(waA0I.A00, iA01, ((Long) pairA08.first).longValue(), jA05, jA0U, w9A0H.A02, w9A0H.A01, w9A0H.A03, w9A0H.A00, jArr, jArr2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1993Wa A0K(C2447fq c2447fq, int i, int i2, String str) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c2447fq.A0f(i3);
            int iA0C = c2447fq.A0C();
            String[] strArr = A01;
            if (strArr[4].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "8GqC4jKazID6TYn9yHMRqPRobgfBBppl";
            strArr2[6] = "EzboqIVZPLANqj38Rkusn15qKaQ0PsH6";
            if (c2447fq.A0C() == 1952804451) {
                int iA03 = W5.A03(c2447fq.A0C());
                c2447fq.A0g(1);
                int i4 = 0;
                int i5 = 0;
                if (iA03 == 0) {
                    c2447fq.A0g(1);
                } else {
                    int iA0I = c2447fq.A0I();
                    i4 = (iA0I & 240) >> 4;
                    i5 = iA0I & 15;
                }
                boolean z = c2447fq.A0I() == 1;
                int iA0I2 = c2447fq.A0I();
                byte[] bArr = new byte[16];
                c2447fq.A0k(bArr, 0, bArr.length);
                byte[] bArr2 = null;
                if (z && iA0I2 == 0) {
                    int iA0I3 = c2447fq.A0I();
                    bArr2 = new byte[iA0I3];
                    c2447fq.A0k(bArr2, 0, iA0I3);
                }
                return new C1993Wa(z, str, iA0I2, bArr, i4, i5, bArr2);
            }
            i3 += iA0C;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0307  */
    /* JADX WARN: Code duplicated, block: B:146:0x04ba A[PHI: r5 r7
  0x04ba: PHI (r5v52 long) = (r5v48 long), (r5v55 long) binds: [B:155:0x0519, B:145:0x04b8] A[DONT_GENERATE, DONT_INLINE]
  0x04ba: PHI (r7v18 long) = (r7v15 long), (r7v20 long) binds: [B:155:0x0519, B:145:0x04b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:161:0x053c  */
    /* JADX WARN: Code duplicated, block: B:163:0x0545  */
    /* JADX WARN: Code duplicated, block: B:166:0x0566  */
    /* JADX WARN: Code duplicated, block: B:168:0x0574 A[LOOP:1: B:164:0x0550->B:168:0x0574, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:252:0x05a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x0589 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:268:0x0256 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x0254 A[EDGE_INSN: B:274:0x0254->B:73:0x0254 BREAK  A[LOOP:7: B:69:0x0247->B:72:0x024f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0246 A[PHI: r3
  0x0246: PHI (r3v26 java.lang.String) = (r3v23 java.lang.String), (r3v51 java.lang.String) binds: [B:103:0x031d, B:67:0x0244] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x0249  */
    /* JADX WARN: Code duplicated, block: B:72:0x024f A[LOOP:7: B:69:0x0247->B:72:0x024f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x027d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x027f A[ADDED_TO_REGION, LOOP:8: B:76:0x027f->B:78:0x0283, LOOP_START, PHI: r11 r25 r26
  0x027f: PHI (r11v3 int) = (r11v1 int), (r11v5 int) binds: [B:75:0x027d, B:78:0x0283] A[DONT_GENERATE, DONT_INLINE]
  0x027f: PHI (r25v3 int) = (r25v1 int), (r25v4 int) binds: [B:75:0x027d, B:78:0x0283] A[DONT_GENERATE, DONT_INLINE]
  0x027f: PHI (r26v6 int) = (r26v2 int), (r26v7 int) binds: [B:75:0x027d, B:78:0x0283] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x029e  */
    /* JADX WARN: Code duplicated, block: B:85:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:90:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:92:0x02cf A[PHI: r10
  0x02cf: PHI (r10v5 int) = (r10v4 int), (r10v6 int) binds: [B:99:0x0304, B:91:0x02cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x02f9  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static C1995Wc A0L(WZ wz, C1934Tm c1934Tm, UV uv) throws Q6 {
        W8 c1931Tj;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        String strA0M;
        long j;
        WZ wz2;
        boolean zA02;
        int i;
        long j2;
        int i2;
        int length;
        String[] strArr;
        long jA0U;
        long jA0U2;
        C1933Tl c1933TlA03 = c1934Tm.A03(1937011578);
        if (c1933TlA03 != null) {
            c1931Tj = new C1932Tk(c1933TlA03, wz.A07);
        } else {
            C1933Tl c1933TlA04 = c1934Tm.A03(1937013298);
            if (c1933TlA04 == null) {
                throw Q6.A01(A0M(400, 42, 35), null);
            }
            c1931Tj = new C1931Tj(c1933TlA04);
        }
        int iA8l = c1931Tj.A8l();
        if (iA8l == 0) {
            return new C1995Wc(wz, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        boolean z = false;
        C1933Tl c1933TlA05 = c1934Tm.A03(1937007471);
        if (c1933TlA05 == null) {
            z = true;
            c1933TlA05 = (C1933Tl) AbstractC2388es.A01(c1934Tm.A03(1668232756));
        }
        C2447fq c2447fq = c1933TlA05.A00;
        C2447fq c2447fq2 = ((C1933Tl) AbstractC2388es.A01(c1934Tm.A03(1937011555))).A00;
        C2447fq c2447fq3 = ((C1933Tl) AbstractC2388es.A01(c1934Tm.A03(1937011827))).A00;
        C1933Tl c1933TlA06 = c1934Tm.A03(1937011571);
        C2447fq c2447fq4 = c1933TlA06 != null ? c1933TlA06.A00 : null;
        C1933Tl c1933TlA07 = c1934Tm.A03(1668576371);
        C2447fq c2447fq5 = c1933TlA07 != null ? c1933TlA07.A00 : null;
        W6 w6 = new W6(c2447fq2, c2447fq, z);
        c2447fq3.A0f(12);
        int iA0L = c2447fq3.A0L() - 1;
        int iA0L2 = c2447fq3.A0L();
        int iA0L3 = c2447fq3.A0L();
        int iA0L4 = 0;
        int iA0L5 = 0;
        int iA0C = 0;
        if (c2447fq5 != null) {
            c2447fq5.A0f(12);
            iA0L5 = c2447fq5.A0L();
        }
        int iA0L6 = -1;
        int iA0L7 = 0;
        String[] strArr2 = A01;
        if (strArr2[7].charAt(7) == strArr2[6].charAt(7)) {
            throw new RuntimeException();
        }
        A01[3] = "n84p3BFScy65QeswTU14uZAbcqY9dIBh";
        if (c2447fq4 != null) {
            c2447fq4.A0f(12);
            iA0L7 = c2447fq4.A0L();
            if (iA0L7 > 0) {
                int iA0L8 = c2447fq4.A0L();
                if (A01[0].length() != 15) {
                    String[] strArr3 = A01;
                    strArr3[7] = "mwFVRBtg2CflQNx79cAorrLajYqYCeZF";
                    strArr3[6] = "vfP6wrhbVhDuls6NAiHVABO5ngbAhvh3";
                    iA0L6 = iA0L8 - 1;
                } else {
                    String[] strArr4 = A01;
                    strArr4[4] = "J34WUGvQ";
                    strArr4[5] = "TGqCCK";
                    iA0L6 = iA0L8 - 1;
                }
            } else {
                c2447fq4 = null;
                if (A01[3].charAt(8) != 'I') {
                    String[] strArr5 = A01;
                    strArr5[7] = "0FnBbKHszUZy9g4zgUs5WK4evRmlYsM9";
                    strArr5[6] = "3jnsqwWtwP3I1JtDCSpd9QnUq8A6rZMf";
                } else {
                    String[] strArr6 = A01;
                    strArr6[7] = "yZ9sBgVcXTLRnsNIedZeojIZ7ozihN0n";
                    strArr6[6] = "zDeznKRF6Oqi6Oydt52slRqXydsUizvX";
                }
            }
        }
        int iA80 = c1931Tj.A80();
        String str = wz.A07.A0W;
        boolean z2 = iA80 != -1 && (A0M(967, 9, 80).equals(str) || A0M(897, 15, 2).equals(str) || A0M(882, 15, 20).equals(str)) && iA0L == 0 && iA0L5 == 0 && iA0L7 == 0;
        int i3 = 0;
        if (A01[0].length() != 15) {
            throw new RuntimeException();
        }
        String[] strArr7 = A01;
        strArr7[4] = "w1gJGKoP";
        strArr7[5] = "msidfk";
        long j3 = 0;
        if (z2) {
            long[] jArr = new long[w6.A05];
            int[] iArr = new int[w6.A05];
            while (w6.A02()) {
                jArr[w6.A00] = w6.A02;
                iArr[w6.A00] = w6.A01;
            }
            WE weA00 = WF.A00(iA80, jArr, iArr, iA0L3);
            jArrCopyOf = weA00.A04;
            iArrCopyOf = weA00.A03;
            i3 = weA00.A00;
            jArrCopyOf2 = weA00.A05;
            iArrCopyOf2 = weA00.A02;
            j = weA00.A01;
            wz2 = wz;
        } else {
            jArrCopyOf = new long[iA8l];
            iArrCopyOf = new int[iA8l];
            jArrCopyOf2 = new long[iA8l];
            iArrCopyOf2 = new int[iA8l];
            long j4 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr8 = A01;
                if (strArr8[7].charAt(7) == strArr8[6].charAt(7)) {
                    A01[1] = "woG0xf8pKU9bfiIlzAO3Ee8ZdT3xthKg";
                    strA0M = A0M(178, 11, 19);
                    if (i5 >= iA8l) {
                        i5 = iA8l;
                        break;
                    }
                    zA02 = true;
                    while (i4 == 0) {
                        zA02 = w6.A02();
                        if (zA02) {
                            break;
                            break;
                        }
                        j4 = w6.A02;
                        i4 = w6.A01;
                    }
                    if (!zA02) {
                        AbstractC2432fb.A07(strA0M, A0M(442, 28, 104));
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i5);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i5);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i5);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i5);
                        break;
                    }
                    if (c2447fq5 != null) {
                        while (iA0L4 == 0) {
                            iA0L4 = c2447fq5.A0L();
                            iA0C = c2447fq5.A0C();
                            iA0L5--;
                        }
                        iA0L4--;
                    }
                    jArrCopyOf[i5] = j4;
                    iArrCopyOf[i5] = c1931Tj.AGa();
                    if (iArrCopyOf[i5] > i3) {
                        i3 = iArrCopyOf[i5];
                    }
                    jArrCopyOf2[i5] = j3 + ((long) iA0C);
                    if (c2447fq4 == null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    iArrCopyOf2[i5] = i;
                    if (i5 == iA0L6) {
                        if (A01[2].length() != 31) {
                            String[] strArr9 = A01;
                            strArr9[4] = "kHdgTiWI";
                            strArr9[5] = "43eV68";
                            iArrCopyOf2[i5] = 1;
                            iA0L7--;
                            if (iA0L7 > 0) {
                                iA0L6 = ((C2447fq) AbstractC2388es.A01(c2447fq4)).A0L() - 1;
                            }
                        } else {
                            A01[1] = "GYztx4F1PmQamlTYVUv7I5GdfeTR94OU";
                            iArrCopyOf2[i5] = 1;
                            iA0L7--;
                            if (iA0L7 > 0) {
                                iA0L6 = ((C2447fq) AbstractC2388es.A01(c2447fq4)).A0L() - 1;
                            }
                        }
                    }
                    j3 += (long) iA0L3;
                    iA0L2--;
                    if (iA0L2 != 0) {
                    }
                    j4 += (long) iArrCopyOf[i5];
                    i4--;
                    i5++;
                } else {
                    String[] strArr10 = A01;
                    strArr10[4] = "WhMFqSWB";
                    strArr10[5] = "dBzfU7";
                    strA0M = A0M(178, 11, 31);
                    if (i5 >= iA8l) {
                        i5 = iA8l;
                        break;
                    }
                    zA02 = true;
                    while (i4 == 0) {
                        zA02 = w6.A02();
                        if (zA02) {
                            break;
                        }
                        j4 = w6.A02;
                        i4 = w6.A01;
                    }
                    if (!zA02) {
                        AbstractC2432fb.A07(strA0M, A0M(442, 28, 104));
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i5);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i5);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i5);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i5);
                        break;
                    }
                    if (c2447fq5 != null) {
                        while (iA0L4 == 0 && iA0L5 > 0) {
                            iA0L4 = c2447fq5.A0L();
                            iA0C = c2447fq5.A0C();
                            iA0L5--;
                        }
                        iA0L4--;
                    }
                    jArrCopyOf[i5] = j4;
                    iArrCopyOf[i5] = c1931Tj.AGa();
                    if (iArrCopyOf[i5] > i3) {
                        i3 = iArrCopyOf[i5];
                    }
                    jArrCopyOf2[i5] = j3 + ((long) iA0C);
                    if (c2447fq4 == null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    iArrCopyOf2[i5] = i;
                    if (i5 == iA0L6) {
                        if (A01[2].length() != 31) {
                            String[] strArr11 = A01;
                            strArr11[4] = "kHdgTiWI";
                            strArr11[5] = "43eV68";
                            iArrCopyOf2[i5] = 1;
                            iA0L7--;
                            if (iA0L7 > 0) {
                                iA0L6 = ((C2447fq) AbstractC2388es.A01(c2447fq4)).A0L() - 1;
                            }
                        } else {
                            A01[1] = "GYztx4F1PmQamlTYVUv7I5GdfeTR94OU";
                            iArrCopyOf2[i5] = 1;
                            iA0L7--;
                            if (iA0L7 > 0) {
                                iA0L6 = ((C2447fq) AbstractC2388es.A01(c2447fq4)).A0L() - 1;
                            }
                        }
                    }
                    j3 += (long) iA0L3;
                    iA0L2--;
                    if (iA0L2 != 0 && iA0L > 0) {
                        iA0L2 = c2447fq3.A0L();
                        iA0L3 = c2447fq3.A0C();
                        iA0L--;
                    }
                    j4 += (long) iArrCopyOf[i5];
                    i4--;
                    i5++;
                }
            }
            j = j3 + ((long) iA0C);
            boolean z3 = true;
            if (c2447fq5 != null) {
                while (iA0L5 > 0) {
                    if (c2447fq5.A0L() != 0) {
                        z3 = false;
                        break;
                    }
                    c2447fq5.A0C();
                    String[] strArr12 = A01;
                    if (strArr12[4].length() == strArr12[5].length()) {
                        throw new RuntimeException();
                    }
                    A01[1] = "muGpbzLIBhnJV6zV2e3zV2P7TD4t6ePZ";
                    iA0L5--;
                }
            }
            if (iA0L7 == 0 && iA0L2 == 0 && i4 == 0 && iA0L == 0 && iA0L4 == 0 && z3) {
                wz2 = wz;
            } else {
                wz2 = wz;
                String str2 = A0M(207, 32, 51) + wz2.A00 + A0M(144, 34, 16) + iA0L7 + A0M(14, 35, 29) + iA0L2 + A0M(85, 26, 83) + i4 + A0M(111, 33, 11) + iA0L + A0M(49, 36, 37) + iA0L4 + (!z3 ? A0M(0, 14, 101) : A0M(0, 0, 111));
                if (A01[3].charAt(8) == 'I') {
                    throw new RuntimeException();
                }
                String[] strArr13 = A01;
                strArr13[4] = "AbG4IrkW";
                strArr13[5] = "zdvkAm";
                AbstractC2432fb.A07(strA0M, str2);
            }
            iA8l = i5;
        }
        long jA0U3 = AbstractC2471gE.A0U(j, 1000000L, wz2.A06);
        if (wz2.A08 == null) {
            AbstractC2471gE.A13(jArrCopyOf2, 1000000L, wz2.A06);
            return new C1995Wc(wz, jArrCopyOf, iArrCopyOf, i3, jArrCopyOf2, iArrCopyOf2, jA0U3);
        }
        if (wz2.A08.length == 1 && wz2.A03 == 1 && jArrCopyOf2.length >= 2) {
            long j5 = ((long[]) AbstractC2388es.A01(wz2.A09))[0];
            long jA0U4 = j5 + AbstractC2471gE.A0U(wz2.A08[0], wz2.A06, wz2.A05);
            if (A0V(jArrCopyOf2, j, j5, jA0U4)) {
                long j6 = j - jA0U4;
                long j7 = j5 - jArrCopyOf2[0];
                int i6 = wz2.A07.A0G;
                String[] strArr14 = A01;
                if (strArr14[7].charAt(7) != strArr14[6].charAt(7)) {
                    A01[1] = "gfV9lA6G9deXf3NDol70pesA0euVL3sM";
                    jA0U = AbstractC2471gE.A0U(j7, i6, wz2.A06);
                    jA0U2 = AbstractC2471gE.A0U(j6, wz2.A07.A0G, wz2.A06);
                    if (jA0U == 0) {
                        if (jA0U2 != 0) {
                        }
                    }
                } else {
                    jA0U = AbstractC2471gE.A0U(j7, i6, wz2.A06);
                    jA0U2 = AbstractC2471gE.A0U(j6, wz2.A07.A0G, wz2.A06);
                    if (jA0U == 0) {
                        if (jA0U2 != 0) {
                        }
                    }
                }
                if (jA0U <= 2147483647L && jA0U2 <= 2147483647L) {
                    uv.A00 = (int) jA0U;
                    uv.A01 = (int) jA0U2;
                    AbstractC2471gE.A13(jArrCopyOf2, 1000000L, wz2.A06);
                    return new C1995Wc(wz, jArrCopyOf, iArrCopyOf, i3, jArrCopyOf2, iArrCopyOf2, AbstractC2471gE.A0U(wz2.A08[0], 1000000L, wz2.A05));
                }
            }
        }
        int length2 = wz2.A08.length;
        String[] strArr15 = A01;
        if (strArr15[7].charAt(7) != strArr15[6].charAt(7)) {
            A01[0] = "nK9zld4OsXR6JWK";
            if (length2 == 1) {
                if (wz2.A08[0] == 0) {
                    j2 = ((long[]) AbstractC2388es.A01(wz2.A09))[0];
                    i2 = 0;
                    while (true) {
                        length = jArrCopyOf2.length;
                        strArr = A01;
                        if (strArr[7].charAt(7) != strArr[6].charAt(7)) {
                            throw new RuntimeException();
                        }
                        String[] strArr16 = A01;
                        strArr16[4] = "3ceZQQ2j";
                        strArr16[5] = "cAGxyE";
                        if (i2 < length) {
                            return new C1995Wc(wz, jArrCopyOf, iArrCopyOf, i3, jArrCopyOf2, iArrCopyOf2, AbstractC2471gE.A0U(j - j2, 1000000L, wz2.A06));
                        }
                        jArrCopyOf2[i2] = AbstractC2471gE.A0U(jArrCopyOf2[i2] - j2, 1000000L, wz2.A06);
                        i2++;
                    }
                }
            }
        } else if (length2 == 1) {
            if (wz2.A08[0] == 0) {
                j2 = ((long[]) AbstractC2388es.A01(wz2.A09))[0];
                i2 = 0;
                while (true) {
                    length = jArrCopyOf2.length;
                    strArr = A01;
                    if (strArr[7].charAt(7) != strArr[6].charAt(7)) {
                        throw new RuntimeException();
                    }
                    String[] strArr17 = A01;
                    strArr17[4] = "3ceZQQ2j";
                    strArr17[5] = "cAGxyE";
                    if (i2 < length) {
                        return new C1995Wc(wz, jArrCopyOf, iArrCopyOf, i3, jArrCopyOf2, iArrCopyOf2, AbstractC2471gE.A0U(j - j2, 1000000L, wz2.A06));
                    }
                    jArrCopyOf2[i2] = AbstractC2471gE.A0U(jArrCopyOf2[i2] - j2, 1000000L, wz2.A06);
                    i2++;
                }
            }
        }
        boolean z4 = wz2.A03 == 1;
        int i7 = 0;
        int i8 = 0;
        boolean z5 = false;
        int[] iArr2 = new int[wz2.A08.length];
        int[] iArr3 = new int[wz2.A08.length];
        long[] jArr2 = (long[]) AbstractC2388es.A01(wz2.A09);
        for (int i9 = 0; i9 < wz2.A08.length; i9++) {
            long j8 = jArr2[i9];
            if (j8 != -1) {
                long jA0U5 = AbstractC2471gE.A0U(wz2.A08[i9], wz2.A06, wz2.A05);
                iArr2[i9] = AbstractC2471gE.A0L(jArrCopyOf2, j8, true, true);
                iArr3[i9] = AbstractC2471gE.A0K(jArrCopyOf2, j8 + jA0U5, z4, false);
                while (iArr2[i9] < iArr3[i9] && (iArrCopyOf2[iArr2[i9]] & 1) == 0) {
                    iArr2[i9] = iArr2[i9] + 1;
                }
                i7 += iArr3[i9] - iArr2[i9];
                if (A01[3].charAt(8) == 'I') {
                    throw new RuntimeException();
                }
                A01[3] = "ag0VbhsjBjhb7qbbAQI7jnL3blXQkDv0";
                z5 |= i8 != iArr2[i9];
                i8 = iArr3[i9];
            }
        }
        boolean z6 = z5 | (i7 != iA8l);
        long[] jArr3 = z6 ? new long[i7] : jArrCopyOf;
        int[] iArr4 = z6 ? new int[i7] : iArrCopyOf;
        if (z6) {
            i3 = 0;
        }
        if (A01[2].length() != 31) {
            throw new RuntimeException();
        }
        A01[2] = "ZlivBdEMf0j9ZLDKkPFxIr20ydJ8DyI";
        int[] iArr5 = z6 ? new int[i7] : iArrCopyOf2;
        long[] jArr4 = new long[i7];
        long j9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < wz2.A08.length; i11++) {
            long j10 = wz2.A09[i11];
            int i12 = iArr2[i11];
            int i13 = iArr3[i11];
            if (z6) {
                int i14 = i13 - i12;
                System.arraycopy(jArrCopyOf, i12, jArr3, i10, i14);
                System.arraycopy(iArrCopyOf, i12, iArr4, i10, i14);
                System.arraycopy(iArrCopyOf2, i12, iArr5, i10, i14);
            }
            if (A01[1].charAt(20) != 'F') {
                String[] strArr18 = A01;
                strArr18[4] = "UboglDvl";
                strArr18[5] = "m9AqPS";
            } else {
                A01[1] = "fPiPAArhWW0UdBcri1KNtVR34INmYDz0";
            }
            while (i12 < i13) {
                jArr4[i10] = AbstractC2471gE.A0U(j9, 1000000L, wz2.A05) + AbstractC2471gE.A0U(Math.max(0L, jArrCopyOf2[i12] - j10), 1000000L, wz2.A06);
                if (z6 && iArr4[i10] > i3) {
                    i3 = iArrCopyOf[i12];
                }
                i10++;
                i12++;
                if (A01[1].charAt(20) != 'F') {
                    A01[3] = "5pcuokRzPt0wlrvXjrH9zzvccU1vwTAT";
                }
            }
            j9 += wz2.A08[i11];
        }
        return new C1995Wc(wz, jArr3, iArr4, i3, jArr4, iArr5, AbstractC2471gE.A0U(j9, 1000000L, wz2.A05));
    }

    public static String A0M(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A00 = new byte[]{-69, -81, -14, 3, 3, 2, -81, -8, -3, 5, -16, -5, -8, -13, 115, 103, -71, -84, -76, -88, -80, -75, -80, -75, -82, -102, -88, -76, -73, -77, -84, -70, -120, -69, -101, -80, -76, -84, -70, -69, -88, -76, -73, -117, -84, -77, -69, -88, 103, 123, 111, -63, -76, -68, -80, -72, -67, -72, -67, -74, -94, -80, -68, -65, -69, -76, -62, -112, -61, -93, -72, -68, -76, -62, -61, -80, -68, -65, -98, -75, -75, -62, -76, -61, 111, -87, -99, -17, -30, -22, -34, -26, -21, -26, -21, -28, -48, -34, -22, -19, -23, -30, -16, -58, -21, -64, -27, -14, -21, -24, -99, 97, 85, -89, -102, -94, -106, -98, -93, -98, -93, -100, -119, -98, -94, -102, -88, -87, -106, -94, -91, 121, -102, -95, -87, -106, 120, -99, -106, -93, -100, -102, -88, 85, 116, 90, -84, -97, -89, -101, -93, -88, -93, -88, -95, -115, -77, -88, -99, -94, -84, -87, -88, -93, -76, -101, -82, -93, -87, -88, -115, -101, -89, -86, -90, -97, -83, 90, -118, -67, -72, -74, -103, -86, -69, -68, -82, -69, -68, -67, -16, -37, -35, -21, -21, -31, -18, -35, -104, -25, -38, -19, -41, -21, -31, -14, -35, -90, -53, -64, -52, -53, -48, -58, -48, -47, -62, -53, -47, 125, -48, -47, -65, -55, 125, -65, -52, -43, 125, -61, -52, -49, 125, -47, -49, -66, -64, -56, 125, -37, 0, 8, -13, -2, -5, -10, -78, 5, -13, -1, 2, -2, -9, -78, 4, -13, 6, -9, -78, -8, 1, 4, -78, -42, 1, -2, -12, Ascii.VT, -78, -26, 4, 7, -9, -38, -42, -78, -33, -34, -30, -78, 5, 6, 4, -9, -13, -1, -52, -78, -119, -99, -88, -94, -85, -82, -87, -95, -96, 92, -81, -99, -87, -84, -88, -95, 92, -80, -99, -98, -88, -95, 92, 100, -81, -80, -98, -88, 101, 92, -87, -91, -81, -81, -91, -86, -93, 92, -81, -99, -87, -84, -88, -95, 92, -96, -95, -81, -97, -82, -91, -84, -80, -91, -85, -86, 92, 100, -81, -80, -81, -96, 101, -110, -77, -72, -74, -117, -88, -92, -89, -22, 2, 0, 7, 7, -4, -5, -73, 4, -4, Ascii.VT, -8, -5, -8, Ascii.VT, -8, -73, Ascii.SO, 0, Ascii.VT, -1, -73, Ascii.FF, 5, 2, 5, 6, Ascii.SO, 5, -73, 2, -4, Ascii.DLE, -73, 0, 5, -5, -4, Ascii.SI, -47, -73, -95, -65, -82, -80, -72, 109, -75, -82, -64, 109, -69, -68, 109, -64, -82, -70, -67, -71, -78, 109, -63, -82, -81, -71, -78, 109, -64, -74, -57, -78, 109, -74, -69, -77, -68, -65, -70, -82, -63, -74, -68, -69, -25, 0, -9, 10, 2, -9, -11, 6, -9, -10, -78, -9, 0, -10, -78, 1, -8, -78, -11, -6, 7, 0, -3, -78, -10, -13, 6, -13, -57, -32, -27, -25, -30, -30, -31, -28, -26, -41, -42, -110, -43, -31, -34, -31, -28, -110, -26, -21, -30, -41, -84, -110, -59, -34, -29, -27, -32, -32, -33, -30, -28, -43, -44, -112, -39, -34, -39, -28, -39, -47, -36, -49, -44, -39, -29, -32, -36, -47, -23, -49, -44, -43, -36, -47, -23, -49, -32, -30, -43, -29, -43, -34, -28, -49, -42, -36, -47, -41, -19, 6, Ascii.VT, Ascii.CR, 8, 8, 7, 10, Ascii.FF, -3, -4, -72, 5, -3, -4, 1, -7, -72, 10, -7, Ascii.FF, -3, -58, -53, -28, -23, -21, -26, -26, -27, -24, -22, -37, -38, -106, -27, -40, -21, -43, -37, -18, -22, -37, -28, -23, -33, -27, -28, -43, -36, -30, -41, -35, -71, -46, -41, -39, -44, -44, -45, -42, -40, -55, -56, -124, -45, -58, -39, -61, -40, -35, -44, -55, -98, -124, -98, -73, -68, -66, -71, -71, -72, -69, -67, -82, -83, 105, -69, -82, -83, -66, -84, -82, -83, -88, -68, -67, -78, -75, -75, -88, -71, -78, -84, -67, -66, -69, -82, -88, -79, -82, -86, -83, -82, -69, -65, -40, -35, -33, -38, -38, -39, -36, -34, -49, -50, -118, -34, -45, -41, -45, -40, -47, -55, -45, -40, -48, -39, -55, -38, -36, -49, -35, -49, -40, -34, -55, -48, -42, -53, -47, -53, -38, -38, -42, -45, -51, -53, -34, -45, -39, -40, -103, -34, -34, -41, -42, -107, -30, -41, -42, -38, -23, -23, -27, -30, -36, -38, -19, -30, -24, -25, -88, -15, -90, -36, -38, -26, -34, -21, -38, -90, -26, -24, -19, -30, -24, -25, -22, -7, -7, -11, -14, -20, -22, -3, -14, -8, -9, -72, 1, -74, -10, -7, -67, -74, -20, -18, -22, -74, -65, -71, -63, -54, -39, -39, -43, -46, -52, -54, -35, -46, -40, -41, -104, -31, -106, -42, -39, -99, -106, -33, -35, -35, -14, 1, 1, -3, -6, -12, -14, 5, -6, 0, -1, -64, 9, -66, 2, 6, -6, -12, -4, 5, -6, -2, -10, -66, 5, 9, -60, -8, -26, -6, -23, -18, -12, -76, -72, -20, -11, -11, -33, -13, -30, -25, -19, -83, -33, -31, -79, 9, Ascii.GS, Ascii.FF, 17, Ascii.ETB, -41, 9, Ascii.VT, -36, -102, -82, -99, -94, -88, 104, -102, -91, -102, -100, -35, -15, -32, -27, -21, -85, -35, -23, -18, -87, -13, -34, -81, -61, -78, -73, -67, 125, -77, -81, -79, -127, -23, -3, -20, -15, -9, -73, -18, -12, -23, -21, -97, -77, -94, -89, -83, 109, -91, 117, 111, 111, 107, -97, -86, -97, -75, -115, -95, -112, -107, -101, 91, -109, 99, 93, 93, 89, -103, -104, -115, -93, -2, Ascii.DC2, 1, 6, Ascii.FF, -52, 10, 5, -2, -50, -110, -90, -107, -102, -96, 96, -98, -103, -98, 98, -87, -67, -84, -79, -73, 119, -75, -72, 124, -87, 117, -76, -87, -68, -75, -43, -23, -40, -35, -29, -93, -31, -28, -39, -37, -73, -53, -70, -65, -59, -123, -59, -58, -53, -55, -37, -17, -34, -29, -23, -87, -20, -37, -15, -38, -18, -35, -30, -24, -88, -19, -21, -18, -34, -90, -31, -35, -32, -12, -29, -24, -18, -82, -11, -19, -29, -83, -29, 
        -13, -14, -68, -48, -65, -60, -54, -118, -47, -55, -65, -119, -65, -49, -50, -119, -61, -65, -44, -24, -41, -36, -30, -94, -23, -31, -41, -95, -41, -25, -26, -95, -37, -41, -82, -29, -27, -30, -39, -36, -33, -40, -80, -33, -43, -27, -7, Ascii.CR, -4, 1, 7, -57, Ascii.SO, 6, -4, -58, -4, Ascii.FF, Ascii.VT, -58, Ascii.CR, 0, -4, -45, 8, 10, 7, -2, 1, 4, -3, -43, 8, -54, -20, -21, -20, -70, -19, -20, -19, -3, -43, -41, -32, -43, -80, -78, -69, -64, -89, -84, -83, -80, -88, -123, -72, -77, -79, -105, -83, -66, -87, 100, -79, -71, -73, -72, 100, -90, -87, 100, -76, -77, -73, -83, -72, -83, -70, -87, -48, -36, -41, -53, -118, -53, -34, -39, -41, -118, -45, -35, -118, -41, -53, -40, -50, -53, -34, -39, -36, -29, 6, -10, -5, -4, -77, -12, 7, 2, 0, -77, -4, 6, -77, 0, -12, 1, -9, -12, 7, 2, 5, Ascii.FF, -33, -48, -39, -50, -117, -52, -33, -38, -40, -117, -44, -34, -117, -40, -52, -39, -49, -52, -33, -38, -35, -28, -82, -95, -100, -99, -89, 103, 107, -97, -88, -88, 17, 4, -1, 0, 10, -54, -4, 17, -53, -52, -28, -41, -46, -45, -35, -99, -49, -28, -47, -19, -32, -37, -36, -26, -90, -37, -26, -29, -39, -16, -92, -19, -32, -22, -32, -26, -27, -58, -71, -76, -75, -65, 127, -72, -75, -58, -77, -72, -85, -90, -89, -79, 113, -81, -78, -89, -87, 19, 6, 1, 2, Ascii.FF, -52, Ascii.NAK, -54, 19, Ascii.VT, 1, -53, Ascii.FF, Ascii.VT, -49, -53, 19, Ascii.CR, -43, -47, -60, -65, -64, -54, -118, -45, -120, -47, -55, -65, -119, -54, -55, -115, -119, -47, -53, -108};
    }

    /* JADX WARN: Code duplicated, block: B:139:0x034c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0361  */
    /* JADX WARN: Code duplicated, block: B:147:0x0393 A[PHI: r6
  0x0393: PHI (r6v7 int) = (r6v2 int), (r6v8 int) binds: [B:157:0x03c9, B:146:0x0391] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:149:0x039b  */
    /* JADX WARN: Code duplicated, block: B:152:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:155:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:163:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:164:0x03de  */
    /* JADX WARN: Code duplicated, block: B:197:0x04c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x013c  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Adding Colorspace support for AV1")
    public static void A0R(C2447fq c2447fq, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, W9 w9, int i6) throws Q6 {
        UH uhA00;
        boolean z;
        String[] strArr;
        DrmInitData drmInitDataA01 = drmInitData;
        int iIntValue = i;
        c2447fq.A0f(i2 + 8 + 8);
        c2447fq.A0g(16);
        int iA0M = c2447fq.A0M();
        int iA0M2 = c2447fq.A0M();
        boolean z2 = false;
        float fA00 = 1.0f;
        c2447fq.A0g(50);
        int iA09 = c2447fq.A09();
        if (iIntValue == 1701733238) {
            Pair<Integer, C1993Wa> pairA0A = A0A(c2447fq, i2, i3);
            if (pairA0A != null) {
                iIntValue = ((Integer) pairA0A.first).intValue();
                drmInitDataA01 = drmInitDataA01 == null ? null : drmInitDataA01.A01(((C1993Wa) pairA0A.second).A02);
                w9.A03[i6] = (C1993Wa) pairA0A.second;
            }
            c2447fq.A0f(iA09);
        }
        String strA0M = null;
        if (iIntValue == 1831958048) {
            strA0M = A0M(1243, 10, 24);
        } else if (iIntValue == 1211250227) {
            strA0M = A0M(1186, 10, 14);
        }
        List<byte[]> listA04 = null;
        String str = null;
        byte[] bArrA0W = null;
        int i7 = -1;
        W7 w7A0G = null;
        int iA00 = -1;
        int i8 = -1;
        int iA01 = -1;
        ByteBuffer byteBufferA0N = null;
        while (true) {
            if (iA09 - i2 < i3) {
                c2447fq.A0f(iA09);
                int iA010 = c2447fq.A09();
                int iA0C = c2447fq.A0C();
                if (iA0C != 0 || c2447fq.A09() - i2 != i3) {
                    UM.A01(iA0C > 0, A0M(1090, 30, 26));
                    int iA0C2 = c2447fq.A0C();
                    if (iA0C2 == 1635148611) {
                        UM.A01(strA0M == null, null);
                        strA0M = A0M(1206, 9, 68);
                        c2447fq.A0f(iA010 + 8);
                        U6 u6A00 = U6.A00(c2447fq);
                        listA04 = u6A00.A05;
                        w9.A00 = u6A00.A02;
                        if (!z2) {
                            fA00 = u6A00.A00;
                        }
                        str = u6A00.A04;
                    } else if (iA0C2 == 1752589123) {
                        UM.A01(strA0M == null, null);
                        strA0M = A0M(1233, 10, 38);
                        c2447fq.A0f(iA010 + 8);
                        UW uwA00 = UW.A00(c2447fq);
                        listA04 = uwA00.A08;
                        w9.A00 = uwA00.A05;
                        if (!z2) {
                            fA00 = uwA00.A00;
                        }
                        str = uwA00.A07;
                        iA00 = uwA00.A02;
                        i8 = uwA00.A01;
                        iA01 = uwA00.A03;
                        if (A01[3].charAt(8) == 'I') {
                            throw new RuntimeException();
                        }
                        A01[3] = "zF8cT2HzrfxyOEW0T97I26iktjisJF4U";
                    } else if (iA0C2 != 1685480259) {
                        if (iA0C2 == 1685485123) {
                            uhA00 = UH.A00(c2447fq);
                            if (uhA00 != null) {
                                str = uhA00.A02;
                                strA0M = A0M(1215, 18, 77);
                            }
                        } else if (iA0C2 == 1987076931) {
                            UM.A01(strA0M == null, null);
                            strA0M = iIntValue == 1987063864 ? A0M(1253, 19, 115) : A0M(1272, 19, 49);
                            c2447fq.A0f(iA010 + 12);
                            c2447fq.A0g(2);
                            boolean z3 = (c2447fq.A0I() & 1) != 0;
                            int iA0I = c2447fq.A0I();
                            int iA0I2 = c2447fq.A0I();
                            iA00 = ColorInfo.A00(iA0I);
                            i8 = z3 ? 1 : 2;
                            iA01 = ColorInfo.A01(iA0I2);
                        } else if (iA0C2 == 1635135811) {
                            UM.A01(strA0M == null, null);
                            strA0M = A0M(1196, 10, 113);
                            c2447fq.A0f(iA010 + 8);
                            ColorInfo colorInfoA0B = A0B(c2447fq);
                            iA00 = colorInfoA0B.A02;
                            i8 = colorInfoA0B.A01;
                            iA01 = colorInfoA0B.A03;
                        } else if (iA0C2 == 1668050025) {
                            if (byteBufferA0N == null) {
                                byteBufferA0N = A0N();
                            }
                            byteBufferA0N.position(21);
                            byteBufferA0N.putShort(c2447fq.A0b());
                            byteBufferA0N.putShort(c2447fq.A0b());
                        } else if (iA0C2 == 1835295606) {
                            if (byteBufferA0N == null) {
                                byteBufferA0N = A0N();
                            }
                            short sA0b = c2447fq.A0b();
                            short sA0b2 = c2447fq.A0b();
                            short sA0b3 = c2447fq.A0b();
                            short sA0b4 = c2447fq.A0b();
                            short sA0b5 = c2447fq.A0b();
                            short sA0b6 = c2447fq.A0b();
                            short sA0b7 = c2447fq.A0b();
                            short sA0b8 = c2447fq.A0b();
                            long jA0Q = c2447fq.A0Q();
                            long jA0Q2 = c2447fq.A0Q();
                            byteBufferA0N.position(1);
                            byteBufferA0N.putShort(sA0b5);
                            byteBufferA0N.putShort(sA0b6);
                            byteBufferA0N.putShort(sA0b);
                            byteBufferA0N.putShort(sA0b2);
                            byteBufferA0N.putShort(sA0b3);
                            byteBufferA0N.putShort(sA0b4);
                            byteBufferA0N.putShort(sA0b7);
                            byteBufferA0N.putShort(sA0b8);
                            byteBufferA0N.putShort((short) (jA0Q / 10000));
                            byteBufferA0N.putShort((short) (jA0Q2 / 10000));
                        } else if (iA0C2 == 1681012275) {
                            UM.A01(strA0M == null, null);
                            strA0M = A0M(1186, 10, 14);
                        } else {
                            if (iA0C2 != 1702061171) {
                                if (A01[2].length() == 31) {
                                    A01[3] = "cHzO6QiixiVRGnaC9ik2CpEfGkyAXuqW";
                                    if (iA0C2 == 1885434736) {
                                        fA00 = A00(c2447fq, iA010);
                                        z2 = true;
                                    } else if (iA0C2 == 1937126244) {
                                        bArrA0W = A0W(c2447fq, iA010, iA0C);
                                    } else if (iA0C2 == 1936995172) {
                                        int iA0I3 = c2447fq.A0I();
                                        c2447fq.A0g(3);
                                        if (iA0I3 == 0) {
                                            switch (c2447fq.A0I()) {
                                                case 0:
                                                    i7 = 0;
                                                    break;
                                                case 1:
                                                    i7 = 1;
                                                    break;
                                                case 2:
                                                    i7 = 2;
                                                    break;
                                                case 3:
                                                    i7 = 3;
                                                    break;
                                            }
                                        }
                                    } else if (A01[2].length() == 31) {
                                        A01[0] = "1zlHFcYe3vTZuWH";
                                        if (iA0C2 == 1668246642 && iA00 == -1 && i8 == -1 && iA01 == -1) {
                                            int iA0C3 = c2447fq.A0C();
                                            String[] strArr2 = A01;
                                            if (strArr2[7].charAt(7) != strArr2[6].charAt(7)) {
                                                String[] strArr3 = A01;
                                                strArr3[4] = "RcRwVpGd";
                                                strArr3[5] = "F4LtOj";
                                                if (iA0C3 != 1852009592) {
                                                    strArr = A01;
                                                    if (strArr[4].length() != strArr[5].length()) {
                                                        throw new RuntimeException();
                                                    }
                                                    A01[1] = "dErATOYwL8wjSH3fOqcGQjIZkRPmAvVX";
                                                    if (iA0C3 == 1852009571) {
                                                        AbstractC2432fb.A07(A0M(178, 11, 31), A0M(470, 24, 72) + W5.A04(iA0C3));
                                                    }
                                                }
                                            } else if (iA0C3 != 1852009592) {
                                                strArr = A01;
                                                if (strArr[4].length() != strArr[5].length()) {
                                                    throw new RuntimeException();
                                                }
                                                A01[1] = "dErATOYwL8wjSH3fOqcGQjIZkRPmAvVX";
                                                if (iA0C3 == 1852009571) {
                                                    AbstractC2432fb.A07(A0M(178, 11, 31), A0M(470, 24, 72) + W5.A04(iA0C3));
                                                }
                                            }
                                            int iA0M3 = c2447fq.A0M();
                                            int iA0M4 = c2447fq.A0M();
                                            String[] strArr4 = A01;
                                            if (strArr4[4].length() != strArr4[5].length()) {
                                                A01[0] = "6G0zxMtyMJKNeFZ";
                                                i8 = 2;
                                                c2447fq.A0g(2);
                                                if (iA0C == 19) {
                                                    z = (c2447fq.A0I() & 128) != 0;
                                                }
                                                iA00 = ColorInfo.A00(iA0M3);
                                                if (z) {
                                                    i8 = 1;
                                                }
                                                iA01 = ColorInfo.A01(iA0M4);
                                                if (A01[0].length() != 15) {
                                                    A01[1] = "EkxUPJXqVuSDxZmuWkydSNu67wAtZSbE";
                                                } else {
                                                    A01[2] = "WGQVJtFwR2t23CIObCRPwqutTYMxzMF";
                                                }
                                            } else {
                                                A01[3] = "aM6sizBemUKXMNVlVUfiwXayyoT8isY9";
                                                i8 = 0;
                                                c2447fq.A0g(0);
                                                if (iA0C == 5) {
                                                    if ((c2447fq.A0I() & 128) != 0) {
                                                    }
                                                }
                                                iA00 = ColorInfo.A00(iA0M3);
                                                if (z) {
                                                    i8 = 1;
                                                }
                                                iA01 = ColorInfo.A01(iA0M4);
                                                if (A01[0].length() != 15) {
                                                    A01[1] = "EkxUPJXqVuSDxZmuWkydSNu67wAtZSbE";
                                                } else {
                                                    A01[2] = "WGQVJtFwR2t23CIObCRPwqutTYMxzMF";
                                                }
                                            }
                                            iA00 = ColorInfo.A00(iA0M3);
                                            if (z) {
                                                i8 = 1;
                                            }
                                            iA01 = ColorInfo.A01(iA0M4);
                                            if (A01[0].length() != 15) {
                                                A01[1] = "EkxUPJXqVuSDxZmuWkydSNu67wAtZSbE";
                                            } else {
                                                A01[2] = "WGQVJtFwR2t23CIObCRPwqutTYMxzMF";
                                            }
                                        }
                                    }
                                }
                                throw new RuntimeException();
                            }
                            UM.A01(strA0M == null, null);
                            w7A0G = A0G(c2447fq, iA010);
                            strA0M = w7A0G.A02;
                            byte[] bArr = w7A0G.A03;
                            if (bArr != null) {
                                listA04 = OI.A04(bArr);
                            }
                        }
                    } else {
                        if (A01[0].length() != 15) {
                            throw new RuntimeException();
                        }
                        A01[0] = "DrZf8b8du6Cfro5";
                        uhA00 = UH.A00(c2447fq);
                        if (uhA00 != null) {
                            str = uhA00.A02;
                            strA0M = A0M(1215, 18, 77);
                        }
                    }
                    iA09 += iA0C;
                }
            } else {
                if (A01[1].charAt(20) == 'F') {
                    throw new RuntimeException();
                }
                A01[1] = "1c0cYq6aA3LPKW8bYNpy8XSK9nZNTbPH";
            }
        }
        if (strA0M == null) {
            return;
        }
        P5 p5A0u = new P5().A0g(i4).A11(strA0M).A0w(str).A0r(iA0M).A0f(iA0M2).A0Y(fA00).A0l(i5).A13(bArrA0W).A0o(i7).A12(listA04).A0u(drmInitDataA01);
        if (iA00 != -1 || i8 != -1 || iA01 != -1 || byteBufferA0N != null) {
            p5A0u.A0t(new ColorInfo(iA00, i8, iA01, byteBufferA0N != null ? byteBufferA0N.array() : null));
        }
        if (w7A0G != null) {
            p5A0u.A0a(AbstractC1785Nn.A04(w7A0G.A00)).A0j(AbstractC1785Nn.A04(w7A0G.A01));
        }
        w9.A02 = p5A0u.A14();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:104:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:117:0x0331  */
    /* JADX WARN: Code duplicated, block: B:121:0x034c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0356  */
    /* JADX WARN: Code duplicated, block: B:192:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0126  */
    /* JADX WARN: Code duplicated, block: B:48:0x012a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0138  */
    /* JADX WARN: Code duplicated, block: B:52:0x0148  */
    /* JADX WARN: Code duplicated, block: B:54:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c7  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0T(C2447fq c2447fq, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, W9 w9, int i5) throws Q6 {
        int iA0M;
        int iA0J;
        int iA04;
        byte[] bArr;
        DrmInitData drmInitDataA01 = drmInitData;
        int iIntValue = i;
        c2447fq.A0f(i2 + 8 + 8);
        int iA0M2 = 0;
        if (z) {
            iA0M2 = c2447fq.A0M();
            String[] strArr = A01;
            if (strArr[4].length() != strArr[5].length()) {
                String[] strArr2 = A01;
                strArr2[4] = "4DaGOlPB";
                strArr2[5] = "qjR8Nj";
                c2447fq.A0g(6);
            }
            throw new RuntimeException();
        }
        c2447fq.A0g(8);
        int iA0C = 0;
        int i6 = -1;
        String str2 = null;
        W7 w7A0G = null;
        if (iA0M2 == 0 || iA0M2 == 1) {
            iA0M = c2447fq.A0M();
            c2447fq.A0g(6);
            iA0J = c2447fq.A0J();
            c2447fq.A0f(c2447fq.A09() - 4);
            iA0C = c2447fq.A0C();
            if (iA0M2 == 1) {
                c2447fq.A0g(16);
            }
        } else {
            if (iA0M2 != 2) {
                return;
            }
            c2447fq.A0g(16);
            iA0J = (int) Math.round(c2447fq.A06());
            iA0M = c2447fq.A0L();
            c2447fq.A0g(20);
        }
        int iA09 = c2447fq.A09();
        if (iIntValue == 1701733217) {
            Pair<Integer, C1993Wa> pairA0A = A0A(c2447fq, i2, i3);
            if (pairA0A != null) {
                iIntValue = ((Integer) pairA0A.first).intValue();
                if (drmInitDataA01 != null) {
                    drmInitDataA01 = drmInitDataA01.A01(((C1993Wa) pairA0A.second).A02);
                } else if (A01[1].charAt(20) != 'F') {
                    A01[2] = "OvxqKisruPENNJLRZltTVxmf9Aec8wk";
                    drmInitDataA01 = null;
                } else {
                    drmInitDataA01 = null;
                }
                w9.A03[i5] = (C1993Wa) pairA0A.second;
            }
            c2447fq.A0f(iA09);
        }
        String strA0M = null;
        if (iIntValue == 1633889587) {
            strA0M = A0M(822, 9, 84);
        } else {
            if (A01[3].charAt(8) == 'I') {
                throw new RuntimeException();
            }
            A01[0] = "sfGSkS9pqXv1SeL";
            if (iIntValue == 1700998451) {
                strA0M = A0M(862, 10, 36);
            } else if (iIntValue == 1633889588) {
                strA0M = A0M(831, 9, 126);
            } else {
                String[] strArr3 = A01;
                if (strArr3[7].charAt(7) != strArr3[6].charAt(7)) {
                    A01[2] = "LJcGJ6RxCMCon2ylgt0HZCib2eOdiCr";
                    if (iIntValue == 1685353315) {
                        strA0M = A0M(989, 13, 85);
                    } else if (iIntValue != 1685353320 || iIntValue == 1685353324) {
                        strA0M = A0M(1002, 16, 49);
                    } else if (iIntValue == 1685353317) {
                        strA0M = A0M(1018, 28, 73);
                    } else if (iIntValue == 1685353336) {
                        strA0M = A0M(1046, 28, 110);
                    } else if (iIntValue == 1935764850) {
                        strA0M = A0M(812, 10, 91);
                    } else if (A01[2].length() == 31) {
                        String[] strArr4 = A01;
                        strArr4[7] = "ES9ZdpTgbLuLyGJmGtXMVyJAzck5Oys2";
                        strArr4[6] = "j2uPTiulWFCit84ESBRBaYNc1YfmW3z6";
                        if (iIntValue == 1935767394) {
                            strA0M = A0M(850, 12, 82);
                        } else if (iIntValue != 1819304813) {
                            strA0M = A0M(967, 9, 80);
                            i6 = 2;
                        } else {
                            strA0M = A0M(967, 9, 80);
                            i6 = 2;
                        }
                    } else if (iIntValue == 1935767394) {
                        strA0M = A0M(850, 12, 82);
                    } else if (iIntValue != 1819304813 || iIntValue == 1936684916) {
                        strA0M = A0M(967, 9, 80);
                        i6 = 2;
                    } else {
                        String[] strArr5 = A01;
                        if (strArr5[7].charAt(7) == strArr5[6].charAt(7)) {
                            throw new RuntimeException();
                        }
                        A01[2] = "jbAlsGVCBCVWbsHllgD6wxSyI790xgB";
                        if (iIntValue == 1953984371) {
                            strA0M = A0M(967, 9, 80);
                            i6 = 268435456;
                        } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                            strA0M = A0M(947, 10, 74);
                        } else if (iIntValue == 1835557169) {
                            strA0M = A0M(912, 10, 115);
                        } else if (iIntValue == 1835560241) {
                            strA0M = A0M(922, 10, 7);
                        } else if (iIntValue == 1634492771) {
                            strA0M = A0M(840, 10, 15);
                        } else {
                            if (A01[3].charAt(8) == 'I') {
                                throw new RuntimeException();
                            }
                            String[] strArr6 = A01;
                            strArr6[7] = "nFWPIFy0PHgBPrQb41it31CojXgzY5zq";
                            strArr6[6] = "avHzpsCj0JVsrcVeStWJh72jkpOeo1zk";
                            if (iIntValue == 1634492791) {
                                strA0M = A0M(882, 15, 20);
                            } else if (iIntValue == 1970037111) {
                                strA0M = A0M(897, 15, 2);
                            } else if (iIntValue == 1332770163) {
                                strA0M = A0M(957, 10, 44);
                            } else if (iIntValue == 1716281667) {
                                strA0M = A0M(872, 10, 94);
                            } else if (iIntValue == 1835823201) {
                                strA0M = A0M(976, 13, 79);
                            }
                        }
                    }
                } else if (iIntValue == 1685353315) {
                    strA0M = A0M(989, 13, 85);
                } else if (iIntValue != 1685353320) {
                    strA0M = A0M(1002, 16, 49);
                } else {
                    strA0M = A0M(1002, 16, 49);
                }
            }
        }
        List<byte[]> listA04 = null;
        while (iA09 - i2 < i3) {
            c2447fq.A0f(iA09);
            int iA0C2 = c2447fq.A0C();
            UM.A01(iA0C2 > 0, A0M(1090, 30, 26));
            int iA0C3 = c2447fq.A0C();
            if (iA0C3 == 1835557187) {
                int i7 = iA0C2 - 13;
                byte[] bArr2 = new byte[i7];
                c2447fq.A0f(13 + iA09);
                c2447fq.A0k(bArr2, 0, i7);
                listA04 = OI.A04(bArr2);
            } else if (iA0C3 == 1702061171) {
                if (iA0C3 == 1702061171) {
                    iA04 = iA09;
                } else {
                    iA04 = A04(c2447fq, 1702061171, iA09, iA0C2);
                }
                if (iA04 != -1) {
                    w7A0G = A0G(c2447fq, iA04);
                    strA0M = w7A0G.A02;
                    bArr = w7A0G.A03;
                    if (bArr == null) {
                        if (A0M(932, 15, 30).equals(strA0M)) {
                            C1944Tx c1944TxA03 = AbstractC1945Ty.A03(bArr);
                            iA0J = c1944TxA03.A01;
                            iA0M = c1944TxA03.A00;
                            str2 = c1944TxA03.A02;
                        }
                        listA04 = OI.A04(bArr);
                    }
                }
            } else {
                if (z) {
                    if (A01[1].charAt(20) == 'F') {
                        throw new RuntimeException();
                    }
                    String[] strArr7 = A01;
                    strArr7[4] = "EAN3L09q";
                    strArr7[5] = "NBhbtm";
                    if (iA0C3 == 2002876005) {
                        if (iA0C3 == 1702061171) {
                            iA04 = iA09;
                        } else {
                            iA04 = A04(c2447fq, 1702061171, iA09, iA0C2);
                        }
                        if (iA04 != -1) {
                            w7A0G = A0G(c2447fq, iA04);
                            strA0M = w7A0G.A02;
                            bArr = w7A0G.A03;
                            if (bArr == null) {
                                if (A0M(932, 15, 30).equals(strA0M)) {
                                    C1944Tx c1944TxA04 = AbstractC1945Ty.A03(bArr);
                                    iA0J = c1944TxA04.A01;
                                    iA0M = c1944TxA04.A00;
                                    str2 = c1944TxA04.A02;
                                }
                                listA04 = OI.A04(bArr);
                            }
                        }
                    }
                }
                if (iA0C3 == 1684103987) {
                    c2447fq.A0f(iA09 + 8);
                    w9.A02 = U2.A07(c2447fq, Integer.toString(i4), str, drmInitDataA01);
                } else if (iA0C3 == 1684366131) {
                    c2447fq.A0f(iA09 + 8);
                    w9.A02 = U2.A08(c2447fq, Integer.toString(i4), str, drmInitDataA01);
                } else if (iA0C3 == 1684103988) {
                    c2447fq.A0f(iA09 + 8);
                    w9.A02 = U5.A03(c2447fq, Integer.toString(i4), str, drmInitDataA01);
                } else if (iA0C3 == 1684892784) {
                    if (iA0C <= 0) {
                        throw Q6.A01(A0M(239, 49, 104) + iA0C, null);
                    }
                    iA0M = 2;
                    iA0J = iA0C;
                } else {
                    if (A01[3].charAt(8) == 'I') {
                        throw new RuntimeException();
                    }
                    A01[0] = "qYMuNdZPqxvKhxE";
                    if (iA0C3 == 1684305011 || iA0C3 == 1969517683) {
                        w9.A02 = new P5().A0g(i4).A11(strA0M).A0b(iA0M).A0m(iA0J).A0u(drmInitDataA01).A10(str).A14();
                    } else if (iA0C3 == 1682927731) {
                        int i8 = iA0C2 - 8;
                        byte[] bArrCopyOf = Arrays.copyOf(A02, A02.length + i8);
                        c2447fq.A0f(iA09 + 8);
                        c2447fq.A0k(bArrCopyOf, A02.length, i8);
                        listA04 = AbstractC1950Ue.A06(bArrCopyOf);
                    } else if (iA0C3 == 1684425825) {
                        int i9 = iA0C2 - 12;
                        byte[] bArr3 = new byte[i9 + 4];
                        bArr3[0] = 102;
                        bArr3[1] = 76;
                        bArr3[2] = 97;
                        bArr3[3] = 67;
                        c2447fq.A0f(iA09 + 12);
                        c2447fq.A0k(bArr3, 4, i9);
                        listA04 = OI.A04(bArr3);
                    } else if (iA0C3 == 1634492771) {
                        int i10 = iA0C2 - 12;
                        byte[] bArr4 = new byte[i10];
                        c2447fq.A0f(iA09 + 12);
                        c2447fq.A0k(bArr4, 0, i10);
                        Pair<Integer, Integer> pairA00 = AbstractC2396f0.A00(bArr4);
                        iA0J = ((Integer) pairA00.first).intValue();
                        iA0M = ((Integer) pairA00.second).intValue();
                        listA04 = OI.A04(bArr4);
                    }
                }
            }
            iA09 += iA0C2;
        }
        if (w9.A02 != null || strA0M == null) {
            return;
        }
        P5 p5A10 = new P5().A0g(i4).A11(strA0M).A0w(str2).A0b(iA0M).A0m(iA0J).A0i(i6).A12(listA04).A0u(drmInitDataA01).A10(str);
        if (w7A0G != null) {
            p5A10.A0a(AbstractC1785Nn.A04(w7A0G.A00)).A0j(AbstractC1785Nn.A04(w7A0G.A01));
        }
        w9.A02 = p5A10.A14();
    }

    static {
        A0P();
        A03 = new int[]{-3374493, -128628077, -2011932550, 38936541};
        A02 = AbstractC2471gE.A1G(A0M(351, 8, 25));
    }

    public static float A00(C2447fq c2447fq, int i) {
        c2447fq.A0f(i + 8);
        int vSpacing = c2447fq.A0L();
        int hSpacing = c2447fq.A0L();
        return vSpacing / hSpacing;
    }

    public static int A01(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        if (i == 1835365473) {
            return 5;
        }
        return -1;
    }

    public static int A02(C2447fq c2447fq) {
        int iA0I = c2447fq.A0I();
        int size = iA0I & 127;
        while ((iA0I & 128) == 128) {
            iA0I = c2447fq.A0I();
            int currentByte = iA0I & 127;
            size = (size << 7) | currentByte;
        }
        return size;
    }

    public static int A03(C2447fq c2447fq) {
        c2447fq.A0f(16);
        return c2447fq.A0C();
    }

    public static int A04(C2447fq c2447fq, int i, int i2, int i3) throws Q6 {
        int iA09 = c2447fq.A09();
        UM.A01(iA09 >= i2, null);
        while (childAtomPosition < i3) {
            c2447fq.A0f(iA09);
            int childType = c2447fq.A0C();
            UM.A01(childType > 0, A0M(1090, 30, 26));
            int childAtomPosition = c2447fq.A0C();
            if (childAtomPosition == i) {
                return iA09;
            }
            iA09 += childType;
        }
        return -1;
    }

    public static long A05(C2447fq c2447fq) {
        int fullAtom = 8;
        c2447fq.A0f(8);
        if (W5.A03(c2447fq.A0C()) != 0) {
            fullAtom = 16;
        }
        c2447fq.A0g(fullAtom);
        return c2447fq.A0Q();
    }

    public static Pair<long[], long[]> A06(C1934Tm c1934Tm) {
        long jA0P;
        C1933Tl elstAtom = c1934Tm.A03(1701606260);
        if (elstAtom == null) {
            return null;
        }
        C2447fq c2447fq = elstAtom.A00;
        c2447fq.A0f(8);
        int iA03 = W5.A03(c2447fq.A0C());
        int i = c2447fq.A0L();
        long[] editListMediaTimes = new long[i];
        long[] editListDurations = new long[i];
        for (int entryCount = 0; entryCount < i; entryCount++) {
            editListMediaTimes[entryCount] = iA03 == 1 ? c2447fq.A0R() : c2447fq.A0Q();
            if (iA03 == 1) {
                jA0P = c2447fq.A0P();
            } else {
                int iA0C = c2447fq.A0C();
                String[] strArr = A01;
                if (strArr[4].length() == strArr[5].length()) {
                    throw new RuntimeException();
                }
                A01[0] = "faaT8XmIxVXIEBg";
                jA0P = iA0C;
            }
            editListDurations[entryCount] = jA0P;
            if (c2447fq.A0b() == 1) {
                c2447fq.A0g(2);
            } else {
                throw new IllegalArgumentException(A0M(540, 23, 110));
            }
        }
        return Pair.create(editListMediaTimes, editListDurations);
    }

    public static Pair<Metadata, Metadata> A07(C1933Tl c1933Tl) {
        C2447fq c2447fq = c1933Tl.A00;
        c2447fq.A0f(8);
        Metadata metadataA0F = null;
        Metadata metaMetadata = null;
        while (c2447fq.A07() >= 8) {
            int atomPosition = c2447fq.A09();
            int iA0C = c2447fq.A0C();
            int iA0C2 = c2447fq.A0C();
            if (iA0C2 == 1835365473) {
                c2447fq.A0f(atomPosition);
                metadataA0F = A0F(c2447fq, atomPosition + iA0C);
            } else if (iA0C2 == 1936553057) {
                c2447fq.A0f(atomPosition);
                int i = atomPosition + iA0C;
                if (A01[2].length() != 31) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[4] = "5U9F0HbL";
                strArr[5] = "IMFBio";
                metaMetadata = A0E(c2447fq, i);
            } else {
                continue;
            }
            c2447fq.A0f(atomPosition + iA0C);
        }
        return Pair.create(metadataA0F, metaMetadata);
    }

    public static Pair<Long, String> A08(C2447fq c2447fq) {
        c2447fq.A0f(8);
        int fullAtom = W5.A03(c2447fq.A0C());
        int languageCode = fullAtom == 0 ? 8 : 16;
        c2447fq.A0g(languageCode);
        long jA0Q = c2447fq.A0Q();
        int version = fullAtom == 0 ? 4 : 8;
        c2447fq.A0g(version);
        int iA0M = c2447fq.A0M();
        int languageCode2 = iA0M >> 10;
        StringBuilder sbAppend = new StringBuilder().append(A0M(0, 0, 111)).append((char) ((languageCode2 & 31) + 96));
        int languageCode3 = iA0M >> 5;
        StringBuilder sbAppend2 = sbAppend.append((char) ((languageCode3 & 31) + 96));
        int languageCode4 = iA0M & 31;
        return Pair.create(Long.valueOf(jA0Q), sbAppend2.append((char) (languageCode4 + 96)).toString());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fa  */
    public static Pair<Integer, C1993Wa> A09(C2447fq c2447fq, int i, int i2) throws Q6 {
        boolean z;
        int i3 = i + 8;
        int childAtomType = -1;
        int childAtomSize = 0;
        String strA0W = null;
        Integer numValueOf = null;
        while (true) {
            int i4 = i3 - i;
            int schemeInformationBoxPosition = A01[3].charAt(8);
            if (schemeInformationBoxPosition == 73) {
                break;
            }
            A01[1] = "aHKd4Pv105I3cJq0udnKJH8ovzYWdxGq";
            if (i4 < i2) {
                c2447fq.A0f(i3);
                int schemeInformationBoxSize = c2447fq.A0C();
                int schemeInformationBoxPosition2 = c2447fq.A0C();
                if (schemeInformationBoxPosition2 == 1718775137) {
                    int childPosition = c2447fq.A0C();
                    numValueOf = Integer.valueOf(childPosition);
                } else if (schemeInformationBoxPosition2 == 1935894637) {
                    c2447fq.A0g(4);
                    strA0W = c2447fq.A0W(4);
                } else if (schemeInformationBoxPosition2 == 1935894633) {
                    childAtomType = i3;
                    childAtomSize = schemeInformationBoxSize;
                }
                i3 += schemeInformationBoxSize;
            } else {
                if (!A0M(1082, 4, 72).equals(strA0W) && !A0M(1074, 4, 95).equals(strA0W) && !A0M(1086, 4, 35).equals(strA0W) && !A0M(1078, 4, 96).equals(strA0W)) {
                    int schemeInformationBoxPosition3 = A01[0].length();
                    if (schemeInformationBoxPosition3 != 15) {
                        break;
                    }
                    A01[2] = "KLO7JIFRePEmswnD7qaXUzVgVYpthWL";
                    return null;
                }
                boolean z2 = true;
                int schemeInformationBoxPosition4 = A01[1].charAt(20);
                if (schemeInformationBoxPosition4 != 70) {
                    String[] strArr = A01;
                    strArr[7] = "9Fir84CaUSzyr7xkZJb5n00PRWCBSAcs";
                    strArr[6] = "yhidmvbtSS6gb2exyuUKcsGFgqc2Ssv8";
                    if (numValueOf != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    String[] strArr2 = A01;
                    strArr2[7] = "4oF7G0YmVgMeUqGt2sf6YH8OTsCdPYlz";
                    strArr2[6] = "JbrXwkWXYq0KHKgn296W7MRRg294Y9Yv";
                    if (numValueOf != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                UM.A01(z, A0M(1120, 22, 64));
                UM.A01(childAtomType != -1, A0M(1142, 22, 105));
                C1993Wa c1993WaA0K = A0K(c2447fq, childAtomType, childAtomSize, strA0W);
                if (c1993WaA0K == null) {
                    z2 = false;
                }
                UM.A01(z2, A0M(e.a.ERROR_INSTANCE_LOAD_AUCTION_FAILED, 22, 65));
                return Pair.create(numValueOf, (C1993Wa) AbstractC2471gE.A0f(c1993WaA0K));
            }
        }
        throw new RuntimeException();
    }

    public static Pair<Integer, C1993Wa> A0A(C2447fq c2447fq, int i, int i2) throws Q6 {
        Pair<Integer, C1993Wa> pairA09;
        int iA09 = c2447fq.A09();
        while (childPosition < i2) {
            c2447fq.A0f(iA09);
            int iA0C = c2447fq.A0C();
            UM.A01(iA0C > 0, A0M(1090, 30, 26));
            int childAtomSize = c2447fq.A0C();
            if (childAtomSize == 1936289382 && (pairA09 = A09(c2447fq, iA09, iA0C)) != null) {
                return pairA09;
            }
            iA09 += iA0C;
        }
        return null;
    }

    public static Metadata A0D(C2447fq c2447fq, int i) {
        c2447fq.A0g(8);
        ArrayList arrayList = new ArrayList();
        while (c2447fq.A09() < i) {
            Id3Frame id3FrameA04 = WM.A04(c2447fq);
            if (id3FrameA04 != null) {
                arrayList.add(id3FrameA04);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Metadata A0E(C2447fq c2447fq, int i) {
        c2447fq.A0g(12);
        while (c2447fq.A09() < i) {
            int atomSize = c2447fq.A09();
            int iA0C = c2447fq.A0C();
            int atomPosition = c2447fq.A0C();
            if (atomPosition == 1935766900) {
                if (iA0C < 14) {
                    return null;
                }
                c2447fq.A0g(5);
                int iA0I = c2447fq.A0I();
                if (iA0I != 12 && iA0I != 13) {
                    return null;
                }
                float f = iA0I == 12 ? 240.0f : 120.0f;
                c2447fq.A0g(1);
                return new Metadata(new SmtaMetadataEntry(f, c2447fq.A0I()));
            }
            c2447fq.A0f(atomSize + iA0C);
        }
        return null;
    }

    public static Metadata A0F(C2447fq c2447fq, int i) {
        c2447fq.A0g(8);
        A0Q(c2447fq);
        while (c2447fq.A09() < i) {
            int iA09 = c2447fq.A09();
            int atomType = c2447fq.A0C();
            int atomSize = c2447fq.A0C();
            if (atomSize == 1768715124) {
                c2447fq.A0f(iA09);
                return A0D(c2447fq, iA09 + atomType);
            }
            c2447fq.A0f(iA09 + atomType);
        }
        if (A01[2].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "OXAgsAj1";
        strArr[5] = "fvqrgv";
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:109:0x0214  */
    /* JADX WARN: Code duplicated, block: B:111:0x0219  */
    /* JADX WARN: Code duplicated, block: B:123:0x0245  */
    /* JADX WARN: Code duplicated, block: B:133:0x025e  */
    /* JADX WARN: Code duplicated, block: B:138:0x0288  */
    /* JADX WARN: Code duplicated, block: B:142:0x0297  */
    /* JADX WARN: Code duplicated, block: B:144:0x029c  */
    /* JADX WARN: Code duplicated, block: B:160:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00db  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:74:0x0176  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:91:0x01b8  */
    public static W9 A0H(C2447fq c2447fq, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws Q6 {
        c2447fq.A0f(12);
        int iA0C = c2447fq.A0C();
        W9 w9 = new W9(iA0C);
        for (int childStartPosition = 0; childStartPosition < iA0C; childStartPosition++) {
            int iA09 = c2447fq.A09();
            int iA0C2 = c2447fq.A0C();
            UM.A01(iA0C2 > 0, A0M(1090, 30, 26));
            int iA0C3 = c2447fq.A0C();
            if (iA0C3 != 1635148593 && iA0C3 != 1635148595 && iA0C3 != 1701733238) {
                String[] strArr = A01;
                if (strArr[4].length() != strArr[5].length()) {
                    A01[0] = "zuY3hL9Gl19s6xq";
                    if (iA0C3 != 1831958048) {
                        if (A01[2].length() != 31) {
                            A01[1] = "8BUhVLNhf9K5JoJ3Ks3VVSGKUg3nERub";
                            if (iA0C3 != 1836070006) {
                                if (iA0C3 == 1752589105 && iA0C3 != 1751479857) {
                                    if (A01[3].charAt(8) != 'I') {
                                        A01[0] = "J9NFQWcBpP5bRoL";
                                        if (iA0C3 != 1932670515 && iA0C3 != 1211250227 && iA0C3 != 1987063864 && iA0C3 != 1987063865 && iA0C3 != 1635135537 && iA0C3 != 1685479798 && iA0C3 != 1685479729 && iA0C3 != 1685481573 && iA0C3 != 1685481521) {
                                            if (iA0C3 == 1836069985 || iA0C3 == 1701733217 || iA0C3 == 1633889587) {
                                                A0T(c2447fq, iA0C3, iA09, iA0C2, i, str, z, drmInitData, w9, childStartPosition);
                                            } else {
                                                if (A01[3].charAt(8) == 'I') {
                                                    throw new RuntimeException();
                                                }
                                                String[] strArr2 = A01;
                                                strArr2[7] = "sIqgdg7Ir0gzrBx0QUcruw0RK0xaXW7w";
                                                strArr2[6] = "SsbgrgexWAa1UrrkUoBYj3jKgvPwcUou";
                                                if (iA0C3 == 1700998451 || iA0C3 == 1633889588 || iA0C3 == 1835823201 || iA0C3 == 1685353315 || iA0C3 == 1685353317 || iA0C3 == 1685353320) {
                                                    A0T(c2447fq, iA0C3, iA09, iA0C2, i, str, z, drmInitData, w9, childStartPosition);
                                                } else {
                                                    String[] strArr3 = A01;
                                                    if (strArr3[4].length() != strArr3[5].length()) {
                                                        String[] strArr4 = A01;
                                                        strArr4[4] = "hfk9wb39";
                                                        strArr4[5] = "0FrQFq";
                                                        if (iA0C3 != 1685353324) {
                                                            if (iA0C3 == 1685353336 && iA0C3 != 1935764850 && iA0C3 != 1935767394 && iA0C3 != 1819304813 && iA0C3 != 1936684916 && iA0C3 != 1953984371) {
                                                                if (A01[2].length() == 31) {
                                                                    A01[1] = "Mu9UGxRsyv1fNCIYPqwI6UO8dJksap8b";
                                                                    if (iA0C3 != 778924082) {
                                                                        if (A01[3].charAt(8) != 'I') {
                                                                            throw new RuntimeException();
                                                                        }
                                                                        A01[1] = "rbsI3Efq0Hmlb8MFftDygTmwcUN3A1ex";
                                                                        if (iA0C3 == 778924083) {
                                                                        }
                                                                    }
                                                                } else if (iA0C3 != 778924082) {
                                                                    if (A01[3].charAt(8) != 'I') {
                                                                        throw new RuntimeException();
                                                                    }
                                                                    A01[1] = "rbsI3Efq0Hmlb8MFftDygTmwcUN3A1ex";
                                                                    if (iA0C3 == 778924083 && iA0C3 != 1835557169 && iA0C3 != 1835560241) {
                                                                        String[] strArr5 = A01;
                                                                        if (strArr5[7].charAt(7) != strArr5[6].charAt(7)) {
                                                                            A01[0] = "rKi8N418EB7jigj";
                                                                            if (iA0C3 != 1634492771) {
                                                                                if (iA0C3 == 1634492791 && iA0C3 != 1970037111) {
                                                                                    if (A01[3].charAt(8) != 'I') {
                                                                                        String[] strArr6 = A01;
                                                                                        strArr6[7] = "qg64UJQAzpTmHyLPXL7O7aEkmk2KAivH";
                                                                                        strArr6[6] = "ht8kCeX7uuHYC3cI0Du1HtKt4zLlzwFz";
                                                                                        if (iA0C3 != 1332770163) {
                                                                                            if (iA0C3 == 1716281667) {
                                                                                                if (iA0C3 != 1414810956 || iA0C3 == 1954034535 || iA0C3 == 2004251764 || iA0C3 == 1937010800 || iA0C3 == 1664495672) {
                                                                                                    iA09 = iA09;
                                                                                                    iA0C2 = iA0C2;
                                                                                                    A0S(c2447fq, iA0C3, iA09, iA0C2, i, str, w9);
                                                                                                } else {
                                                                                                    String[] strArr7 = A01;
                                                                                                    if (strArr7[4].length() != strArr7[5].length()) {
                                                                                                        A01[2] = "gxiE9NKmmL9uchOhalvHl02jDDEZfTq";
                                                                                                        if (iA0C3 == 1835365492) {
                                                                                                            A0U(c2447fq, iA0C3, iA09, i, w9);
                                                                                                        } else if (iA0C3 == 1667329389) {
                                                                                                            w9.A02 = new P5().A0g(i).A11(A0M(IronSourceError.ERROR_NT_INSTANCE_LOAD_EMPTY_ADAPTER, 27, 79)).A14();
                                                                                                        }
                                                                                                    } else {
                                                                                                        A01[3] = "ToxFSyeFlA38mkuLvo1Mu6lU6LxYgixd";
                                                                                                        if (iA0C3 == 1835365492) {
                                                                                                            A0U(c2447fq, iA0C3, iA09, i, w9);
                                                                                                        } else if (iA0C3 == 1667329389) {
                                                                                                            w9.A02 = new P5().A0g(i).A11(A0M(IronSourceError.ERROR_NT_INSTANCE_LOAD_EMPTY_ADAPTER, 27, 79)).A14();
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        A01[0] = "Y9VHYanCPsI2e2J";
                                                                                        if (iA0C3 != 1332770163) {
                                                                                            if (iA0C3 == 1716281667) {
                                                                                                if (iA0C3 != 1414810956) {
                                                                                                    iA09 = iA09;
                                                                                                    iA0C2 = iA0C2;
                                                                                                    A0S(c2447fq, iA0C3, iA09, iA0C2, i, str, w9);
                                                                                                } else {
                                                                                                    iA09 = iA09;
                                                                                                    iA0C2 = iA0C2;
                                                                                                    A0S(c2447fq, iA0C3, iA09, iA0C2, i, str, w9);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (iA0C3 != 1634492771) {
                                                                            if (iA0C3 == 1634492791) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        A01[2] = "Tdv19gpgah7kG8KLNSbiU3FJY2XFBa5";
                                                        if (iA0C3 != 1685353324) {
                                                            if (iA0C3 == 1685353336) {
                                                            }
                                                        }
                                                    }
                                                    A0T(c2447fq, iA0C3, iA09, iA0C2, i, str, z, drmInitData, w9, childStartPosition);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            A01[1] = "I2tzS4ozYZhJ1vQL0WXmt8OcsnHuZPow";
                            if (iA0C3 != 1836070006) {
                                if (iA0C3 == 1752589105) {
                                }
                            }
                        }
                        if (A01[3].charAt(8) != 'I') {
                            A01[0] = "Q0mwKXPd20cqjGE";
                            A0R(c2447fq, iA0C3, iA09, iA0C2, i, i2, drmInitData, w9, childStartPosition);
                        } else {
                            A0R(c2447fq, iA0C3, iA09, iA0C2, i, i2, drmInitData, w9, childStartPosition);
                        }
                    } else if (A01[3].charAt(8) != 'I') {
                        A01[0] = "Q0mwKXPd20cqjGE";
                        A0R(c2447fq, iA0C3, iA09, iA0C2, i, i2, drmInitData, w9, childStartPosition);
                    } else {
                        A0R(c2447fq, iA0C3, iA09, iA0C2, i, i2, drmInitData, w9, childStartPosition);
                    }
                }
                throw new RuntimeException();
            }
            if (A01[3].charAt(8) != 'I') {
                A01[0] = "Q0mwKXPd20cqjGE";
                A0R(c2447fq, iA0C3, iA09, iA0C2, i, i2, drmInitData, w9, childStartPosition);
            } else {
                A0R(c2447fq, iA0C3, iA09, iA0C2, i, i2, drmInitData, w9, childStartPosition);
            }
            c2447fq.A0f(iA09 + iA0C2);
        }
        return w9;
    }

    public static ByteBuffer A0N() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.hs != com.google.common.base.Function<com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Track> */
    public static List<C1995Wc> A0O(C1934Tm c1934Tm, UV uv, long j, DrmInitData drmInitData, boolean z, boolean z2, InterfaceC2570hs<WZ, WZ> interfaceC2570hs) throws Q6 {
        WZ track;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c1934Tm.A01.size(); i++) {
            C1934Tm c1934Tm2 = c1934Tm.A01.get(i);
            if (((W5) c1934Tm2).A00 == 1953653099 && (track = interfaceC2570hs.A41(A0J(c1934Tm2, (C1933Tl) AbstractC2388es.A01(c1934Tm.A03(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(A0L(track, (C1934Tm) AbstractC2388es.A01(((C1934Tm) AbstractC2388es.A01(((C1934Tm) AbstractC2388es.A01(c1934Tm2.A02(1835297121))).A02(1835626086))).A02(1937007212)), uv));
            }
        }
        return arrayList;
    }

    public static void A0Q(C2447fq c2447fq) {
        int iA09 = c2447fq.A09();
        c2447fq.A0g(4);
        if (c2447fq.A0C() != 1751411826) {
            iA09 += 4;
        }
        c2447fq.A0f(iA09);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OI != com.google.common.collect.ImmutableList<byte[]> */
    public static void A0S(C2447fq c2447fq, int i, int i2, int i3, int i4, String str, W9 w9) {
        String strA0M;
        c2447fq.A0f(i2 + 8 + 8);
        OI oiA04 = null;
        long j = Long.MAX_VALUE;
        if (i == 1414810956) {
            if (A01[2].length() != 31) {
                throw new RuntimeException();
            }
            A01[2] = "JRt87GZMgD5fEMVBfoNrIXDL19zMo7T";
            strA0M = A0M(691, 20, 64);
        } else if (i == 1954034535) {
            strA0M = A0M(784, 28, 103);
            int sampleDescriptionLength = (i3 - 8) - 8;
            byte[] bArr = new byte[sampleDescriptionLength];
            c2447fq.A0k(bArr, 0, sampleDescriptionLength);
            oiA04 = OI.A04(bArr);
        } else if (i == 2004251764) {
            String[] strArr = A01;
            if (strArr[4].length() != strArr[5].length()) {
                A01[0] = "VAPQbMGZr6CMzJb";
                strA0M = A0M(763, 21, 63);
            } else {
                strA0M = A0M(763, 21, 63);
            }
        } else if (i == 1937010800) {
            strA0M = A0M(691, 20, 64);
            j = 0;
        } else if (i == 1664495672) {
            strA0M = A0M(738, 25, 95);
            w9.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        w9.A02 = new P5().A0g(i4).A11(strA0M).A10(str).A0s(j).A12(oiA04).A14();
    }

    public static void A0U(C2447fq c2447fq, int i, int i2, int i3, W9 w9) {
        c2447fq.A0f(i2 + 8 + 8);
        if (i == 1835365492) {
            c2447fq.A0U();
            String[] strArr = A01;
            if (strArr[7].charAt(7) == strArr[6].charAt(7)) {
                throw new RuntimeException();
            }
            A01[3] = "QORzH089JWGgbMxxBNIu32wCfbh73vL5";
            String mimeType = c2447fq.A0U();
            if (mimeType != null) {
                w9.A02 = new P5().A0g(i3).A11(mimeType).A14();
            }
        }
    }

    public static boolean A0V(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int latestDelayIndex = AbstractC2471gE.A07(4, 0, length);
        int lastIndex = jArr.length;
        int iA07 = AbstractC2471gE.A07(lastIndex - 4, 0, length);
        if (jArr[0] <= j2 && j2 < jArr[latestDelayIndex]) {
            long j4 = jArr[iA07];
            if (A01[0].length() != 15) {
                throw new RuntimeException();
            }
            A01[3] = "UIj7yINuON8HzSPRJ6uGXDpOHCOuQ4pj";
            if (j4 < j3) {
                if (A01[2].length() != 31) {
                    throw new RuntimeException();
                }
                A01[2] = "OLbz9oQsF5dhTYI0k8UVb3p9eiHzyiO";
                if (j3 <= j) {
                    return true;
                }
            }
        }
        return false;
    }

    public static byte[] A0W(C2447fq c2447fq, int i, int i2) {
        int i3 = i + 8;
        while (childPosition < i2) {
            c2447fq.A0f(i3);
            int iA0C = c2447fq.A0C();
            int childAtomSize = c2447fq.A0C();
            if (childAtomSize == 1886547818) {
                byte[] bArrA0l = c2447fq.A0l();
                String[] strArr = A01;
                String str = strArr[4];
                String str2 = strArr[5];
                int childAtomSize2 = str.length();
                int childPosition = str2.length();
                if (childAtomSize2 == childPosition) {
                    throw new RuntimeException();
                }
                A01[1] = "mWVII78rWKXPWoThB17UwcFw6Ep5dNZ6";
                int childPosition2 = i3 + iA0C;
                return Arrays.copyOfRange(bArrA0l, i3, childPosition2);
            }
            i3 += iA0C;
        }
        return null;
    }
}
