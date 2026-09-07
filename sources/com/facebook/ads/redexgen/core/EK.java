package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EK extends Z1 {
    public static byte[] A07;
    public static String[] A08 = {"OeYhwvq00bMNYRlp8BxeqxzBkkxb", "nkAG9tudEnhHC7mgCykA73xzeSMA", "dPMLzny", "89sU", "GOWZnpp", "xskk6Zi7ChFZ13", "OtgkT7DbFI27r6Tfpevt", "UWT5bAyAVTX0VJWiYNGzQ1fG72nxKTm3"};
    public static final InterfaceC1774Na<EK> A09;
    public static final String A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public static final String A0F;
    public final boolean A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final ZM A04;
    public final AbstractC1823Pb A05;
    public final String A06;

    public static /* synthetic */ EK A00(Bundle bundle) {
        return new EK(bundle);
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A08;
            if (strArr[1].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A08[7] = "U38F0gdMiMxij0PALtiSuZMWxKwUMHry";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
            i4++;
        }
    }

    public static void A07() {
        A07 = new byte[]{Ascii.FS, 89, 78, 78, 83, 78, Ascii.DLE, Ascii.FS, 85, 82, 88, 89, 68, 1, 69, 73, Ascii.SI, 6, Ascii.ESC, 4, 8, Ascii.GS, 84, 71, 75, Ascii.CR, 4, Ascii.EM, 6, 10, Ascii.US, 52, Ascii.CAN, Ascii.RS, Ascii.ESC, Ascii.ESC, 4, Ascii.EM, Ascii.US, Ascii.SO, Ascii.SI, 86, 88, 66, 115, 68, 76, 78, 85, 68, 1, 68, 83, 83, 78, 83, 100, 88, 66, 69, 84, 82, Ascii.ETB, 82, 69, 69, 88, 69, 48, Ascii.VT, 0, Ascii.GS, Ascii.NAK, 0, 6, 17, 0, 1, 69, Ascii.ETB, Ascii.DLE, Ascii.VT, 17, Ascii.FF, 8, 0, 69, 0, Ascii.ETB, Ascii.ETB, 10, Ascii.ETB};
    }

    static {
        A07();
        A09 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZR
            @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
            public final InterfaceC1775Nb A6V(Bundle bundle) {
                return EK.A00(bundle);
            }
        };
        A0F = AbstractC2471gE.A0h(1001);
        A0E = AbstractC2471gE.A0h(1002);
        A0D = AbstractC2471gE.A0h(1003);
        A0B = AbstractC2471gE.A0h(1004);
        A0C = AbstractC2471gE.A0h(1005);
        A0A = AbstractC2471gE.A0h(1006);
    }

    public EK(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    public EK(int i, Throwable th, String str, int i2, String str2, int i3, ZM zm, int i4, boolean z) {
        this(A06(i, th, str, str2, i3, zm, i4), th, i2, i, str2, i3, zm, i4, null, SystemClock.elapsedRealtime(), z);
    }

    public EK(Bundle bundle) {
        ZM zm;
        super(bundle);
        this.A03 = bundle.getInt(A0F, 2);
        this.A06 = bundle.getString(A0E);
        this.A02 = bundle.getInt(A0D, -1);
        Bundle bundle2 = bundle.getBundle(A0B);
        if (bundle2 == null) {
            zm = null;
        } else {
            zm = (ZM) ZM.A0b.A6V(bundle2);
        }
        this.A04 = zm;
        this.A01 = bundle.getInt(A0C, 4);
        this.A00 = bundle.getBoolean(A0A, false);
        this.A05 = null;
    }

    public EK(String str, Throwable th, int i, int i2, String str2, int i3, ZM zm, int i4, AbstractC1823Pb abstractC1823Pb, long j, boolean z) {
        super(str, th, i, j);
        AbstractC2388es.A07(!z || i2 == 1);
        AbstractC2388es.A07(th != null || i2 == 3);
        this.A03 = i2;
        this.A06 = str2;
        this.A02 = i3;
        this.A04 = zm;
        this.A01 = i4;
        this.A05 = abstractC1823Pb;
        this.A00 = z;
    }

    public static EK A01(IOException iOException, int i) {
        return new EK(0, iOException, i);
    }

    @Deprecated
    public static EK A02(RuntimeException runtimeException) {
        return A03(runtimeException, 1000);
    }

    public static EK A03(RuntimeException runtimeException, int i) {
        return new EK(2, runtimeException, i);
    }

    public static EK A04(Throwable th, String str, int i, ZM zm, int i2, boolean z, int i3) {
        int i4 = i2;
        if (zm == null) {
            i4 = 4;
        }
        return new EK(1, th, null, i3, str, i, zm, i4, z);
    }

    public static String A06(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}, value = "Throwable cause - linked with Error reporting") int i, Throwable th, String str, String str2, int i2, ZM zm, int i3) {
        String message;
        String strA05;
        if (str == null) {
            message = th == null ? null : th.getMessage();
        } else {
            message = str;
        }
        if (message != null) {
            return message;
        }
        switch (i) {
            case 0:
                strA05 = A05(56, 12, 15);
                break;
            case 1:
                StringBuilder sbAppend = new StringBuilder().append(str2);
                String message2 = A05(0, 14, 4);
                StringBuilder sbAppend2 = sbAppend.append(message2).append(i2);
                String message3 = A05(14, 9, 81);
                StringBuilder sbAppend3 = sbAppend2.append(message3).append(zm);
                String message4 = A05(23, 19, 83);
                StringBuilder sbAppend4 = sbAppend3.append(message4);
                String message5 = AbstractC2471gE.A0g(i3);
                strA05 = sbAppend4.append(message5).toString();
                break;
            case 2:
            default:
                strA05 = A05(68, 24, 93);
                break;
            case 3:
                strA05 = A05(44, 12, 25);
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbAppend5 = new StringBuilder().append(strA05);
            String message6 = A05(42, 2, 90);
            return sbAppend5.append(message6).append(str).toString();
        }
        return strA05;
    }
}
