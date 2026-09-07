package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T5 implements Y7 {
    public static byte[] A0C;
    public static String[] A0D = {"c7td4l6FhBQAK", "DTHfzoMJ0AzZypdM6Gm8SFo2H6uPkgyC", "acXXVZBnBbPogRNCgSi7WwOlt2A6rEqU", "KWcTzk", "yQkgcEXCXTe994X1gET7oDSOs3PQrGWW", "OzWHzMcOaKXzhhI1lFkYNj", "9ngkgdBg0bHMabGOjTK6ZQB43lTpVAVA", "E5Uig"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public ZM A05;
    public InterfaceC1957Uo A06;
    public String A07;
    public boolean A08;
    public final C2446fp A09;
    public final C2447fq A0A;
    public final String A0B;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{32, 52, 37, 40, 46, 110, 32, 34, 114};
    }

    static {
        A02();
    }

    public T5() {
        this(null);
    }

    public T5(String str) {
        this.A09 = new C2446fp(new byte[128]);
        this.A0A = new C2447fq(this.A09.A00);
        this.A02 = 0;
        this.A04 = -9223372036854775807L;
        this.A0B = str;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0045  */
    /* JADX WARN: Code duplicated, block: B:14:0x007f  */
    @RequiresNonNull({"output"})
    private void A01() {
        P5 p5A0j;
        this.A09.A08(0);
        U1 u1A09 = U2.A09(this.A09);
        if (this.A05 != null) {
            int i = u1A09.A01;
            ZM zm = this.A05;
            if (A0D[7].length() == 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "hZiseNxsIbSCoqloHp2d8N6o9NjurTOT";
            strArr[2] = "HrrIsFtX2yN9qnKXbxq00UFvnInSr7rO";
            if (i != zm.A06 || u1A09.A04 != this.A05.A0G || !AbstractC2471gE.A1E(u1A09.A06, this.A05.A0W)) {
                p5A0j = new P5().A0y(this.A07).A11(u1A09.A06).A0b(u1A09.A01).A0m(u1A09.A04).A10(this.A0B).A0j(u1A09.A00);
                if (A00(0, 9, 81).equals(u1A09.A06)) {
                    p5A0j.A0a(u1A09.A00);
                }
                this.A05 = p5A0j.A14();
                this.A06.A6U(this.A05);
            }
        } else {
            p5A0j = new P5().A0y(this.A07).A11(u1A09.A06).A0b(u1A09.A01).A0m(u1A09.A04).A10(this.A0B).A0j(u1A09.A00);
            if (A00(0, 9, 81).equals(u1A09.A06)) {
                p5A0j.A0a(u1A09.A00);
            }
            this.A05 = p5A0j.A14();
            this.A06.A6U(this.A05);
        }
        this.A01 = u1A09.A02;
        this.A03 = (((long) u1A09.A03) * 1000000) / ((long) this.A05.A0G);
    }

    private boolean A03(C2447fq c2447fq) {
        while (true) {
            if (c2447fq.A07() <= 0) {
                return false;
            }
            if (!this.A08) {
                this.A08 = c2447fq.A0I() == 11;
            } else {
                int iA0I = c2447fq.A0I();
                if (iA0I == 119) {
                    this.A08 = false;
                    String[] strArr = A0D;
                    String str = strArr[3];
                    String str2 = strArr[5];
                    int length = str.length();
                    int secondByte = str2.length();
                    if (length == secondByte) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0D;
                    strArr2[4] = "pkPVjmqCIyAzdCmFBjs3PoIqXLVcrUPH";
                    strArr2[2] = "tJTrq5h2LVUSplF3MulfB87twvagryml";
                    return true;
                }
                this.A08 = iA0I == 11;
            }
        }
    }

    private boolean A04(C2447fq c2447fq, byte[] bArr, int i) {
        int iMin = Math.min(c2447fq.A07(), i - this.A00);
        int bytesToRead = this.A00;
        c2447fq.A0k(bArr, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        return bytesToRead3 == i;
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A50(C2447fq c2447fq) {
        AbstractC2388es.A02(this.A06);
        while (c2447fq.A07() > 0) {
            int i = this.A02;
            String[] strArr = A0D;
            if (strArr[6].charAt(3) != strArr[1].charAt(3)) {
                A0D[0] = "kVkZkVO2q3SJ4";
                switch (i) {
                    case 0:
                        if (A03(c2447fq)) {
                            this.A02 = 1;
                            this.A0A.A0l()[0] = Ascii.VT;
                            this.A0A.A0l()[1] = 119;
                            this.A00 = 2;
                        }
                        break;
                    case 1:
                        if (A04(c2447fq, this.A0A.A0l(), 128)) {
                            A01();
                            this.A0A.A0f(0);
                            this.A06.AHx(this.A0A, 128);
                            this.A02 = 2;
                        }
                        break;
                    case 2:
                        int iMin = Math.min(c2447fq.A07(), this.A01 - this.A00);
                        this.A06.AHx(c2447fq, iMin);
                        this.A00 += iMin;
                        if (this.A00 == this.A01) {
                            if (this.A04 != -9223372036854775807L) {
                                this.A06.AI0(this.A04, 1, this.A01, 0, null);
                                this.A04 += this.A03;
                            }
                            this.A02 = 0;
                        }
                        break;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void A5S(UL ul, YS ys) {
        ys.A05();
        this.A07 = ys.A04();
        this.A06 = ul.AJX(ys.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFx() {
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AFy(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A04 = j;
        }
    }

    @Override // com.facebook.ads.redexgen.core.Y7
    public final void AIB() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
    }
}
