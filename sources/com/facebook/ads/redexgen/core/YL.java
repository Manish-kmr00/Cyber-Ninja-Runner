package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YL {
    public static byte[] A02;
    public static String[] A03 = {"JlEYoAA8KgvOQUm2MMy2NkrV6IHMpdEr", "vEeZLfDDsSpHjn06v6onAv2BEpaO66DH", "ybu", "MVNpRLwxQ8sxX26fFrLso0nseb", "YWJIPG3EBq507sxW8lGiIThbpiW6u3v5", "5OPrt7W8XBtRjGkwsYco61VGMLlOA5jg", "OeB5KC5fq6NVtrw0T5", "yXwtBAUtxGkfcBNCM"};
    public final List<ZM> A00;
    public final InterfaceC1957Uo[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 105);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{36, 3, Ascii.ESC, Ascii.FF, 1, 4, 9, 77, Ascii.SO, 1, 2, Ascii.RS, 8, 9, 77, Ascii.SO, Ascii.FF, Ascii.GS, Ascii.EM, 4, 2, 3, 77, 0, 4, 0, 8, 77, Ascii.EM, Ascii.DC4, Ascii.GS, 8, 77, Ascii.GS, Ascii.US, 2, Ascii.ESC, 4, 9, 8, 9, 87, 77, 67, 82, 82, 78, 75, 65, 67, 86, 75, 77, 76, Ascii.CR, 65, 71, 67, Ascii.SI, Ascii.DC4, Ascii.DC2, Ascii.SUB, 105, 120, 120, 100, 97, 107, 105, 124, 97, 103, 102, 39, 107, 109, 105, 37, 63, 56, 48};
    }

    static {
        A01();
    }

    public YL(List<ZM> list) {
        this.A00 = list;
        this.A01 = new InterfaceC1957Uo[list.size()];
    }

    public final void A02(long j, C2447fq c2447fq) {
        UE.A03(j, c2447fq, this.A01);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0079  */
    public final void A03(UL ul, YS ys) {
        boolean z;
        for (int i = 0; i < i; i++) {
            ys.A05();
            InterfaceC1957Uo interfaceC1957UoAJX = ul.AJX(ys.A03(), 3);
            if (A03[0].charAt(30) == 'E') {
                String[] strArr = A03;
                strArr[1] = "JKWBklwblVRraMoCYjaE2bcb5w0OzlyP";
                strArr[5] = "WjpMKKqN3dPyhBhYJ28c6ngOX8wOCY2o";
                ZM zm = this.A00.get(i);
                String channelMimeType = zm.A0W;
                if (A00(43, 19, 75).equals(channelMimeType)) {
                    z = true;
                } else {
                    String strA00 = A00(62, 19, 97);
                    if (A03[4].charAt(20) == 'I') {
                        String[] strArr2 = A03;
                        strArr2[7] = "g4WocGmnhB0qyaYra";
                        strArr2[3] = "yfBKp03tJhh9tk3SjRC2d07hyz";
                        if (strA00.equals(channelMimeType)) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
                AbstractC2388es.A09(z, A00(0, 43, 4) + channelMimeType);
                P5 p5A11 = new P5().A0y(zm.A0T != null ? zm.A0T : ys.A04()).A11(channelMimeType);
                int i2 = zm.A0H;
                P5 p5A10 = p5A11.A0n(i2).A10(zm.A0V);
                int i3 = zm.A03;
                interfaceC1957UoAJX.A6U(p5A10.A0Z(i3).A12(zm.A0X).A14());
                this.A01[i] = interfaceC1957UoAJX;
            }
            throw new RuntimeException();
        }
    }
}
