package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.google.android.exoplayer2.Format;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2046Yc implements InterfaceC1775Nb {
    public static byte[] A05;
    public static String[] A06 = {"BzNXHIhDP4jUKO3IaEzAWZitFVZ8sbhY", "GRakfFI9FPjq2LDAVZgWaiyUeUWLn0Gv", "nlteVpfez7vGHON25pY0hTgww4kyiGma", "zKzrEx5KWBit9iPheUPKDiI5ze", "yGwbXfm3TfLhut9lLNbMjTeJ8o", "cWjNDhbMfFbSmS3Qo8jRCi5nvFKlSi", "0burYmisbqSgLFjAXSh5c9ALEfQ3KnVa", "TUOdy4M5FvXGBgDzF7ZieC3GBk1tNKwJ"};
    public static final InterfaceC1774Na<C2046Yc> A07;
    public static final String A08;
    public static final String A09;
    public int A00;
    public final int A01;
    public final int A02;
    public final String A03;
    public final ZM[] A04;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{-58, 9, Ascii.NAK, 19, 8, Ascii.SI, Ascii.DC4, Ascii.VT, 10, -58, Ascii.SI, Ascii.DC4, -58, Ascii.NAK, Ascii.DC4, Ascii.VT, -58, -6, Ascii.CAN, 7, 9, 17, -19, Ascii.CAN, Ascii.NAK, Ascii.ESC, Ascii.SYN, -32, -58, -51, Ascii.SUB, 19, Ascii.ESC, 103, 101, 84, 86, 94, 19, Ascii.FS, Ascii.NAK, Ascii.GS, 105, 103, 86, 88, 96, Ascii.NAK, 37, Ascii.RS, Ascii.NAK, 86, 99, 89, Ascii.NAK, Ascii.FS, -42, 59, 96, 93, 93, 92, 105, 92, 101, 107, Ascii.ETB, -22, 8, -9, -7, 1, -35, 8, 5, Ascii.VT, 6, 67, 56, 69, 62, 76, 56, 62, 60, 74, 10, 7, 4, -3, -72, -2, 4, -7, -1, Ascii.VT, 82, 75, 65};
    }

    static {
        A05();
        A08 = AbstractC2471gE.A0h(0);
        A09 = AbstractC2471gE.A0h(1);
        A07 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Yd
            @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
            public final InterfaceC1775Nb A6V(Bundle bundle) {
                return C2046Yc.A01(bundle);
            }
        };
    }

    public C2046Yc(String str, ZM... zmArr) {
        AbstractC2388es.A07(zmArr.length > 0);
        this.A03 = str;
        this.A04 = zmArr;
        this.A01 = zmArr.length;
        int iA01 = Q2.A01(zmArr[0].A0W);
        this.A02 = iA01 == -1 ? Q2.A01(zmArr[0].A0S) : iA01;
        A04();
    }

    public C2046Yc(ZM... zmArr) {
        this(A02(0, 0, 112), zmArr);
    }

    public static int A00(int i) {
        return i | 16384;
    }

    public static /* synthetic */ C2046Yc A01(Bundle bundle) {
        List listA01;
        List<Format> formats = bundle.getParcelableArrayList(A08);
        if (formats == null) {
            listA01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            listA01 = C2394ey.A01(ZM.A0b, formats);
        }
        String id = bundle.getString(A09, A02(0, 0, 112));
        return new C2046Yc(id, (ZM[]) listA01.toArray(new ZM[0]));
    }

    public static String A03(String str) {
        return (str == null || str.equals(A02(96, 3, 100))) ? A02(0, 0, 112) : str;
    }

    private void A04() {
        String strA03 = A03(this.A04[0].A0V);
        int iA00 = A00(this.A04[0].A0E);
        for (int i = 1; i < this.A04.length; i++) {
            String language = this.A04[i].A0V;
            if (!strA03.equals(A03(language))) {
                String str = this.A04[0].A0V;
                String str2 = this.A04[i].A0V;
                String language2 = A02(77, 9, 94);
                A06(language2, str, str2, i);
                return;
            }
            if (iA00 != A00(this.A04[i].A0E)) {
                String binaryString = Integer.toBinaryString(this.A04[0].A0E);
                if (A06[7].charAt(5) == 'G') {
                    throw new RuntimeException();
                }
                A06[5] = "5G1pFatA1YKIsmcnbnabaAj6S95ZaR";
                String binaryString2 = Integer.toBinaryString(this.A04[i].A0E);
                String language3 = A02(86, 10, 31);
                A06(language3, binaryString, binaryString2, i);
                return;
            }
        }
    }

    public static void A06(String str, String str2, String str3, int i) {
        AbstractC2432fb.A08(A02(67, 10, 29), A02(0, 0, 112), new IllegalStateException(A02(57, 10, 126) + str + A02(0, 30, 45) + str2 + A02(39, 17, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + str3 + A02(30, 9, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) + i + A02(56, 1, 52)));
    }

    public final int A07(ZM zm) {
        for (int i = 0; i < i; i++) {
            if (zm == this.A04[i]) {
                return i;
            }
        }
        return -1;
    }

    public final ZM A08(int i) {
        return this.A04[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (A06[5].length() != 30) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "S7LwvMci8t59umJxu6mQLsyE2lif2xMm";
        strArr[0] = "r8RL7QOuOA3et58yw44iYOJehgQ4nbbj";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2046Yc c2046Yc = (C2046Yc) obj;
        return this.A03.equals(c2046Yc.A03) && Arrays.equals(this.A04, c2046Yc.A04);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int result = this.A03.hashCode();
            this.A00 = (((17 * 31) + result) * 31) + Arrays.hashCode(this.A04);
        }
        int result2 = this.A00;
        return result2;
    }
}
