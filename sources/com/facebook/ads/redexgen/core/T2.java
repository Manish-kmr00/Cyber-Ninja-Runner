package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T2 implements Y7 {
    public static byte[] A0D;
    public static String[] A0E = {"IKIOwGzI", "PdvnIlE1FRpoGrRRSS8vm7daIUygEoqq", "ophPL1zH", "bU", "bToXL0LBRe6rOfu16aDAZ4WralkjQGIv", "9d4JsDXogUBR1ixzN80yiZiJrMLi4C3I", "mL1I", "sm"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public ZM A05;
    public InterfaceC1957Uo A06;
    public String A07;
    public boolean A08;
    public boolean A09;
    public final C2446fp A0A;
    public final C2447fq A0B;
    public final String A0C;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0D = new byte[]{-58, -38, -55, -50, -44, -108, -58, -56, -103};
    }

    static {
        A02();
    }

    public T2() {
        this(null);
    }

    public T2(String str) {
        this.A0A = new C2446fp(new byte[16]);
        this.A0B = new C2447fq(this.A0A.A00);
        this.A02 = 0;
        this.A00 = 0;
        this.A09 = false;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
        this.A0C = str;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0052  */
    @RequiresNonNull({"output"})
    private void A01() {
        this.A0A.A08(0);
        U4 u4A04 = U5.A04(this.A0A);
        ZM zm = this.A05;
        String strA00 = A00(0, 9, 59);
        if (zm == null || u4A04.A01 != this.A05.A06) {
            this.A05 = new P5().A0y(this.A07).A11(strA00).A0b(u4A04.A01).A0m(u4A04.A04).A10(this.A0C).A14();
            this.A06.A6U(this.A05);
        } else {
            int i = u4A04.A04;
            ZM zm2 = this.A05;
            String[] strArr = A0E;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A0E[6] = "XkloENK3mD6tCjMFQ2y0JVLf2I";
            if (i != zm2.A0G || !strA00.equals(this.A05.A0W)) {
                this.A05 = new P5().A0y(this.A07).A11(strA00).A0b(u4A04.A01).A0m(u4A04.A04).A10(this.A0C).A14();
                this.A06.A6U(this.A05);
            }
        }
        this.A01 = u4A04.A02;
        this.A03 = (((long) u4A04.A03) * 1000000) / ((long) this.A05.A0G);
    }

    private boolean A03(C2447fq c2447fq) {
        while (true) {
            if (c2447fq.A07() <= 0) {
                return false;
            }
            if (!this.A09) {
                this.A09 = c2447fq.A0I() == 172;
            } else {
                int iA0I = c2447fq.A0I();
                this.A09 = iA0I == 172;
                if (iA0I == 64 || iA0I == 65) {
                    this.A08 = iA0I == 65;
                    return true;
                }
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
            switch (this.A02) {
                case 0:
                    if (A03(c2447fq)) {
                        this.A02 = 1;
                        this.A0B.A0l()[0] = -84;
                        this.A0B.A0l()[1] = (byte) (this.A08 ? 65 : 64);
                        this.A00 = 2;
                    }
                    break;
                case 1:
                    if (A04(c2447fq, this.A0B.A0l(), 16)) {
                        A01();
                        this.A0B.A0f(0);
                        this.A06.AHx(this.A0B, 16);
                        this.A02 = 2;
                    }
                    break;
                case 2:
                    int iMin = Math.min(c2447fq.A07(), this.A01 - this.A00);
                    if (A0E[1].charAt(10) != 'p') {
                        throw new RuntimeException();
                    }
                    A0E[5] = "qQf7sxLWMATWj9eNdS7CPqpQmxboQMYu";
                    this.A06.AHx(c2447fq, iMin);
                    int bytesToRead = this.A00;
                    this.A00 = bytesToRead + iMin;
                    int i = this.A00;
                    int bytesToRead2 = this.A01;
                    if (i == bytesToRead2) {
                        if (this.A04 != -9223372036854775807L) {
                            this.A06.AI0(this.A04, 1, this.A01, 0, null);
                            this.A04 += this.A03;
                        }
                        this.A02 = 0;
                    }
                    break;
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
        this.A09 = false;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
    }
}
