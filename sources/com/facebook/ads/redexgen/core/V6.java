package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V6 extends V5 {
    public static byte[] A06;
    public static String[] A07 = {"H0Qz7gfJSpJVYHFxpCHJV", "K4TCSu2fCuCSqeRIfo8vEBK0wWFC5IFT", "YqfZWV2dEVEBA9EaePHtw0z0RGyvosrY", "DQI7UjVUHmwMZUN6WWsOW2E32G4jDaoy", "", "2Nyc9i8MjSf6u", "s1XhJ2IWPCV3EMQKIJRNa", "fAuG4zoTNDPPwUIrgIEyuXm0UbUBtaTu"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final C2447fq A04;
    public final C2447fq A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{71, 120, 117, 116, 126, 49, 119, 126, 99, 124, 112, 101, 49, 127, 126, 101, 49, 98, 100, 97, 97, 126, 99, 101, 116, 117, 43, 49, 82, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 75, Ascii.VT, 69, 82, 71};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.V5
    public final boolean A0C(C2447fq c2447fq, long j) throws Q6 {
        int iA0I = c2447fq.A0I();
        long jA0D = j + (((long) c2447fq.A0D()) * 1000);
        if (iA0I == 0 && !this.A02) {
            C2447fq c2447fq2 = new C2447fq(new byte[c2447fq.A07()]);
            c2447fq.A0k(c2447fq2.A0l(), 0, c2447fq.A07());
            U6 u6A00 = U6.A00(c2447fq2);
            this.A01 = u6A00.A02;
            super.A00.A6U(new P5().A11(A00(28, 9, 65)).A0w(u6A00.A04).A0r(u6A00.A03).A0f(u6A00.A01).A0Y(u6A00.A00).A12(u6A00.A05).A14());
            this.A02 = true;
            return false;
        }
        if (iA0I == 1) {
            boolean z = this.A02;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[2] = "LVH3tdmABMKqLcjNfzvqD4c0IKcuubTX";
            strArr2[1] = "bvb2EcEElrOq3mbh1IqZTqS0iNZtjcSY";
            if (z) {
                boolean z2 = this.A00 == 1;
                if (!this.A03 && !z2) {
                    return false;
                }
                byte[] bArrA0l = this.A04.A0l();
                bArrA0l[0] = 0;
                bArrA0l[1] = 0;
                bArrA0l[2] = 0;
                int i = 4 - this.A01;
                int i2 = 0;
                while (c2447fq.A07() > 0) {
                    c2447fq.A0k(this.A04.A0l(), i, this.A01);
                    this.A04.A0f(0);
                    int iA0L = this.A04.A0L();
                    this.A05.A0f(0);
                    super.A00.AHx(this.A05, 4);
                    super.A00.AHx(c2447fq, iA0L);
                    i2 = i2 + 4 + iA0L;
                }
                InterfaceC1957Uo interfaceC1957Uo = super.A00;
                int i3 = z2 ? 1 : 0;
                String[] strArr3 = A07;
                if (strArr3[6].length() != strArr3[0].length()) {
                    String[] strArr4 = A07;
                    strArr4[5] = "rjQO5snSi8a51";
                    strArr4[4] = "";
                    interfaceC1957Uo.AI0(jA0D, i3, i2, 0, null);
                    this.A03 = true;
                    return true;
                }
                String[] strArr5 = A07;
                strArr5[5] = "nKdHyKCJIeWOj";
                strArr5[4] = "";
                interfaceC1957Uo.AI0(jA0D, i3, i2, 0, null);
                this.A03 = true;
                return true;
            }
        }
        return false;
    }

    static {
        A01();
    }

    public V6(InterfaceC1957Uo interfaceC1957Uo) {
        super(interfaceC1957Uo);
        this.A05 = new C2447fq(AbstractC1949Ud.A03);
        this.A04 = new C2447fq(4);
    }

    @Override // com.facebook.ads.redexgen.core.V5
    public final boolean A0B(C2447fq c2447fq) throws V8 {
        int iA0I = c2447fq.A0I();
        int header = iA0I >> 4;
        int frameType = header & 15;
        int i = iA0I & 15;
        if (i == 7) {
            this.A00 = frameType;
            return frameType != 5;
        }
        throw new V8(A00(0, 28, 116) + i);
    }
}
