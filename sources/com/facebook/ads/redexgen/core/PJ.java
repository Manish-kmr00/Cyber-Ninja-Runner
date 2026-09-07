package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"NON_FINAL"}, value = "D54147219: For usage in Hero Simple Cache")
public final class PJ extends C2371eb {
    public static byte[] A00;
    public static String[] A01 = {"R3hmPZUoMtJP52", "", "zZiFs09O165YqQXgCnYVEnrnDvX2Hpo0", "Ol2gbmdCVjJAm6", "qDjkwV1etHpuqtk5LYkW32qD1I5kDL2x", "U7CSpTCvJ0Oai8F3vdZlMUb6kyEKxKOG", "lWFxDFVRkJ7MF5N1EHbhoWgKi43siLHj", "ntw79Ox0of6l374enqawZvp2FBVdRRHt"};
    public static final Pattern A02;
    public static final Pattern A03;
    public static final Pattern A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static PJ A00(File file, long j, long j2, C2380ek c2380ek) {
        String strA0F;
        long j3 = j2;
        long length = j;
        String name = file.getName();
        if (!name.endsWith(A06(1, 7, 51))) {
            file = A05(file, c2380ek);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        Matcher matcher = A04.matcher(name);
        if (!matcher.matches() || (strA0F = c2380ek.A0F(Integer.parseInt((String) AbstractC2388es.A01(matcher.group(1))))) == null) {
            return null;
        }
        if (length == -1) {
            length = file.length();
        }
        if (length == 0) {
            return null;
        }
        String strGroup = matcher.group(2);
        String[] strArr = A01;
        if (strArr[6].charAt(30) != strArr[7].charAt(30)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "giBcknk3opjFiUIxt3uPRhSexCeveQHl";
        strArr2[7] = "usB2KncODoA8GLthqkHuiPwzQqHHLjHz";
        long j4 = Long.parseLong((String) AbstractC2388es.A01(strGroup));
        if (j3 == -9223372036854775807L) {
            j3 = Long.parseLong((String) AbstractC2388es.A01(matcher.group(3)));
        }
        return new PJ(strA0F, j4, length, j3, file);
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-36, -52, Ascii.DC4, -47, -52, 3, Ascii.SYN, Ascii.CR, 54, 0, 6, 3, 1, 52, 6, 0, 52, 60, 3, 1, 52, 6, 0, 52, 60, 3, 1, 52, 6, 78, 9, 52, 6, Base64.padSymbol, 80, 71, -4, Ascii.CAN, -30, -24, -27, -29, Ascii.SYN, -24, -30, Ascii.SYN, Ascii.RS, -27, -29, Ascii.SYN, -24, -30, Ascii.SYN, Ascii.RS, -27, -29, Ascii.SYN, -24, 48, -20, Ascii.SYN, -24, Ascii.US, 50, 41, -34, -35, -89, -37, -29, -86, -88, -37, -83, -89, -37, -29, -86, -88, -37, -83, -89, -37, -29, -86, -88, -37, -83, -11, -78, -37, -83, -28, -9, -18, -93};
    }

    static {
        A07();
        A02 = Pattern.compile(A06(8, 29, 109), 32);
        A03 = Pattern.compile(A06(37, 29, 79), 32);
        A04 = Pattern.compile(A06(66, 30, 20), 32);
    }

    public PJ(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    public static PJ A01(File file, long j, C2380ek c2380ek) {
        return A00(file, j, -9223372036854775807L, c2380ek);
    }

    public static PJ A02(String str, long j) {
        return new PJ(str, j, -1L, -9223372036854775807L, null);
    }

    public static PJ A03(String str, long j, long j2) {
        return new PJ(str, j, j2, -9223372036854775807L, null);
    }

    public static File A04(File file, int i, long j, long j2) {
        StringBuilder sbAppend = new StringBuilder().append(i);
        String strA06 = A06(0, 1, 67);
        return new File(file, sbAppend.append(strA06).append(j).append(strA06).append(j2).append(A06(1, 7, 51)).toString());
    }

    public static File A05(File file, C2380ek c2380ek) {
        String strA0l = null;
        String name = file.getName();
        Matcher matcher = A03.matcher(name);
        if (matcher.matches()) {
            String key = matcher.group(1);
            strA0l = AbstractC2471gE.A0l((String) AbstractC2388es.A01(key));
        } else {
            matcher = A02.matcher(name);
            if (matcher.matches()) {
                String key2 = matcher.group(1);
                Object objA01 = AbstractC2388es.A01(key2);
                String filename = A01[2];
                if (filename.charAt(11) == 'C') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[3] = "N2k2FNfTM24V7Z";
                strArr[0] = "i3drU1GVFdsq2h";
                strA0l = (String) objA01;
            }
        }
        if (strA0l == null) {
            return null;
        }
        File file2 = (File) AbstractC2388es.A02(file.getParentFile());
        int iA0B = c2380ek.A0B(strA0l);
        String key3 = matcher.group(2);
        long j = Long.parseLong((String) AbstractC2388es.A01(key3));
        String key4 = matcher.group(3);
        File fileA04 = A04(file2, iA0B, j, Long.parseLong((String) AbstractC2388es.A01(key4)));
        if (!file.renameTo(fileA04)) {
            return null;
        }
        return fileA04;
    }

    public final PJ A0D(File file, long j) {
        AbstractC2388es.A08(this.A05);
        return new PJ(this.A04, this.A02, this.A01, j, file);
    }
}
