package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Up, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1958Up {
    public static byte[] A07;
    public static String[] A08 = {"asQIejgsTbdB2S0VyRGB9EHYv1eKLRk9", "WWVp5dGLiHAEOS6HWE0PikCefP99BXsW", "octpk2CwSd1qfe", "ns1GzOE4HOxEo3pDZ396XNF", "svmJuJ0Yw6PfGOKmqqiDuutKa6NSuCwM", "mTppDqhzT4hXINAYJSVofMwB4xwlHqos", "7Cfb50ckZ2pasQ5YCw5YgUYs", "PeMxce9luSm16o2uEtOifcxB"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public final byte[] A06 = new byte[10];

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            if (A08[1].charAt(12) != 'O') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[3] = "xjcl2VfQmHv0GuodB2wNhG9";
            strArr[2] = "qTNw9PKBtoOlMW";
            bArrCopyOfRange[i4] = (byte) (i5 - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{Ascii.CR, 43, 46, Ascii.RS, 1, -3, -39, Ascii.FS, 33, 46, 39, 36, -39, 44, Ascii.SUB, 38, 41, 37, Ascii.RS, 44, -39, 38, 46, 44, 45, -39, Ascii.ESC, Ascii.RS, -39, Ascii.FS, 40, 39, 45, 34, 32, 46, 40, 46, 44, -39, 34, 39, -39, 45, 33, Ascii.RS, -39, 44, Ascii.SUB, 38, 41, 37, Ascii.RS, -39, 42, 46, Ascii.RS, 46, Ascii.RS, -25};
    }

    static {
        A01();
    }

    public final void A02() {
        this.A05 = false;
        this.A02 = 0;
    }

    public final void A03(WJ wj) throws IOException {
        if (this.A05) {
            return;
        }
        wj.AG1(this.A06, 0, 10);
        wj.AHr();
        if (U2.A06(this.A06) == 0) {
            return;
        }
        this.A05 = true;
    }

    public final void A04(InterfaceC1957Uo interfaceC1957Uo, long j, int i, int i2, int i3, C1956Um c1956Um) {
        AbstractC2388es.A0A(this.A01 <= i2 + i3, A00(0, 60, 104));
        if (!this.A05) {
            return;
        }
        int i4 = this.A02;
        this.A02 = i4 + 1;
        if (i4 == 0) {
            this.A04 = j;
            this.A00 = i;
            this.A03 = 0;
        }
        this.A03 += i2;
        this.A01 = i3;
        if (this.A02 >= 16) {
            A05(interfaceC1957Uo, c1956Um);
        }
    }

    public final void A05(InterfaceC1957Uo interfaceC1957Uo, C1956Um c1956Um) {
        if (this.A02 > 0) {
            interfaceC1957Uo.AI0(this.A04, this.A00, this.A03, this.A01, c1956Um);
            this.A02 = 0;
        }
    }
}
