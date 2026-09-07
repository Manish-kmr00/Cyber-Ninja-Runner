package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VI extends V5 {
    public static byte[] A03;
    public static String[] A04 = {"ExoqCKEP1YYviZfAjm", "meuuKYwZcdYDH1lhBMBz5KcUf", "YGJSDyvFfeAJ8IqF7ZlgQJka1yMfPR1L", "nMZkWl0GeAYhYumqQ8XNefyFCUrMv1cc", "iEPn60LDZetFmYuHDvpebwpFmktphkxg", "G5Hkl5LIxXcCoztxz2GRrLLNVyYf90LO", "Y0bjKK7Pp8u", "ivW"};
    public static final int[] A05;
    public int A00;
    public boolean A01;
    public boolean A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            String[] strArr = A04;
            if (strArr[7].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A04[2] = "3VP0iCFs4h7VFs3WNzW0tovH7TcGs6m4";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{58, Ascii.SO, Ascii.US, Ascii.DC2, Ascii.DC4, 91, Ascii.GS, Ascii.DC4, 9, Ascii.SYN, Ascii.SUB, Ascii.SI, 91, Ascii.NAK, Ascii.DC4, Ascii.SI, 91, 8, Ascii.SO, Ascii.VT, Ascii.VT, Ascii.DC4, 9, Ascii.SI, Ascii.RS, Ascii.US, 65, 91, 80, 68, 85, 88, 94, Ascii.RS, 86, 6, 0, 0, Ascii.FS, 80, 93, 80, 70, 88, 76, 93, 80, 86, Ascii.SYN, 94, Ascii.SO, 8, 8, Ascii.DC4, 84, 85, 88, 78, 19, 7, Ascii.SYN, Ascii.ESC, Ascii.GS, 93, Ascii.US, 2, 70, 19, 95, Ascii.RS, 19, 6, Ascii.US, 71, 83, 66, 79, 73, 9, 75, 86, 67, 65};
        if (A04[1].length() != 25) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[7] = "Civ";
        strArr[6] = "fArBYp1JGa0";
    }

    static {
        A01();
        A05 = new int[]{5512, 11025, 22050, 44100};
    }

    public VI(InterfaceC1957Uo interfaceC1957Uo) {
        super(interfaceC1957Uo);
    }

    @Override // com.facebook.ads.redexgen.core.V5
    public final boolean A0B(C2447fq c2447fq) throws V8 {
        if (!this.A02) {
            int iA0I = c2447fq.A0I();
            int header = iA0I >> 4;
            this.A00 = header & 15;
            if (this.A00 == 2) {
                int header2 = iA0I >> 2;
                super.A00.A6U(new P5().A11(A00(73, 10, 29)).A0b(1).A0m(A05[header2 & 3]).A14());
                this.A01 = true;
            } else if (this.A00 == 7 || this.A00 == 8) {
                super.A00.A6U(new P5().A11(this.A00 == 7 ? A00(28, 15, 10) : A00(43, 15, 2)).A0b(1).A0m(8000).A14());
                this.A01 = true;
            } else if (this.A00 != 10) {
                throw new V8(A00(0, 28, 64) + this.A00);
            }
            this.A02 = true;
        } else {
            c2447fq.A0g(1);
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.V5
    public final boolean A0C(C2447fq c2447fq, long j) throws Q6 {
        if (this.A00 == 2) {
            int iA07 = c2447fq.A07();
            super.A00.AHx(c2447fq, iA07);
            InterfaceC1957Uo interfaceC1957Uo = super.A00;
            if (A04[0].length() != 18) {
                throw new RuntimeException();
            }
            A04[0] = "o26vNw9sI8tHWje8kU";
            interfaceC1957Uo.AI0(j, 1, iA07, 0, null);
            return true;
        }
        int iA0I = c2447fq.A0I();
        if (iA0I == 0 && !this.A01) {
            int packetType = c2447fq.A07();
            byte[] bArr = new byte[packetType];
            int packetType2 = bArr.length;
            c2447fq.A0k(bArr, 0, packetType2);
            C1944Tx c1944TxA03 = AbstractC1945Ty.A03(bArr);
            P5 p5A0w = new P5().A11(A00(58, 15, 73)).A0w(c1944TxA03.A02);
            int packetType3 = c1944TxA03.A00;
            P5 p5A0b = p5A0w.A0b(packetType3);
            int packetType4 = c1944TxA03.A01;
            super.A00.A6U(p5A0b.A0m(packetType4).A12(Collections.singletonList(bArr)).A14());
            this.A01 = true;
            return false;
        }
        if (this.A00 == 10 && iA0I != 1) {
            return false;
        }
        int iA08 = c2447fq.A07();
        super.A00.AHx(c2447fq, iA08);
        super.A00.AI0(j, 1, iA08, 0, null);
        return true;
    }
}
