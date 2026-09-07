package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YV {
    public static byte[] A02;
    public static String[] A03 = {"B9wMF4XSFLHx4dj7A5ZPM69ILd9j9lcg", "wwXHnb3Fjvux5W5pkJCA6m", "agGpxyJ0GYsuFMEszfVSztkhG1on51fu", "D7Ik6bzJdz6B8Kytxd3yFi9adSctvYSV", "kOEPiuizev0taTk33gskBi", "P9nlF5ApjAD6", "cmwu7tsYN1NUaJ19Z2tq2Mal", "9G"};
    public final List<ZM> A00;
    public final InterfaceC1957Uo[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[5].length() == 23) {
                throw new RuntimeException();
            }
            A03[3] = "Tg6F6tjYNmG1p51KcJo6jSbqwvACKxuG";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 123);
            i4++;
        }
    }

    public static void A01() {
        byte[] bArr = {-50, -13, -5, -26, -15, -18, -23, -91, -24, -15, -12, -8, -22, -23, -91, -24, -26, -11, -7, -18, -12, -13, -91, -14, -18, -14, -22, -91, -7, -2, -11, -22, -91, -11, -9, -12, -5, -18, -23, -22, -23, -65, -91, 7, Ascii.SYN, Ascii.SYN, Ascii.DC2, Ascii.SI, 9, 7, Ascii.SUB, Ascii.SI, Ascii.NAK, Ascii.DC4, -43, 9, Ascii.VT, 7, -45, -36, -42, -34, 34, 49, 49, 45, 42, 36, 34, 53, 42, 48, 47, -16, 36, 38, 34, -18, -8, -15, -7};
        if (A03[5].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "DIrcd5pYPSrL6sHLCpqJUBMq";
        strArr[7] = "SA";
        A02 = bArr;
    }

    static {
        A01();
    }

    public YV(List<ZM> list) {
        this.A00 = list;
        this.A01 = new InterfaceC1957Uo[list.size()];
    }

    public final void A02(long j, C2447fq c2447fq) {
        if (c2447fq.A07() < 9) {
            return;
        }
        int iA0C = c2447fq.A0C();
        int userDataTypeCode = c2447fq.A0C();
        int userDataIdentifier = c2447fq.A0I();
        if (iA0C == 434 && userDataTypeCode == 1195456820 && userDataIdentifier == 3) {
            UE.A04(j, c2447fq, this.A01);
        }
    }

    public final void A03(UL ul, YS ys) {
        for (int i = 0; i < i; i++) {
            ys.A05();
            InterfaceC1957Uo interfaceC1957UoAJX = ul.AJX(ys.A03(), 3);
            ZM zm = this.A00.get(i);
            String str = zm.A0W;
            AbstractC2388es.A09(A00(43, 19, 43).equals(str) || A00(62, 19, 70).equals(str), A00(0, 43, 10) + str);
            P5 p5A11 = new P5().A0y(ys.A04()).A11(str);
            int i2 = zm.A0H;
            P5 p5A10 = p5A11.A0n(i2).A10(zm.A0V);
            int i3 = zm.A03;
            interfaceC1957UoAJX.A6U(p5A10.A0Z(i3).A12(zm.A0X).A14());
            this.A01[i] = interfaceC1957UoAJX;
        }
    }
}
