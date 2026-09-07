package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.google.android.exoplayer2.Metadata;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VW implements UK {
    public static String[] A0E = {"b8zxPGVc77C8YlQoWjcqZfexAySqCipq", "Tz2LgWHh4TaGmnCQJEaHYkVmZtglWZja", "vv0qg0JwaSkQghtdVwzniTtFCK6rd5XH", "rI4ufMStmvmyFX1azsqmhFT6sTspnCji", "s4vEvmA0YlUFhGtbykT1SgV6Rmnd4dfN", "", "ZeP2jCuoxXRjkLxyeTqY5NWBkRSt0GUO", "BeUfobZaXEgk1vHHg5qegAWWhLyO"};
    public static final UO A0F = new UO() { // from class: com.facebook.ads.redexgen.X.Ve
        @Override // com.facebook.ads.redexgen.core.UO
        public final UK[] A5D() {
            return VW.A09();
        }

        @Override // com.facebook.ads.redexgen.core.UO
        public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
            return UN.A01(this, uri, map);
        }
    };
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public Metadata A05;
    public UL A06;
    public UU A07;
    public InterfaceC1957Uo A08;
    public C1972Vf A09;
    public final UP A0A;
    public final C2447fq A0B;
    public final boolean A0C;
    public final byte[] A0D;

    public VW() {
        this(0);
    }

    public VW(int i) {
        this.A0D = new byte[42];
        this.A0B = new C2447fq(new byte[32768], 0);
        this.A0C = (i & 1) != 0;
        this.A0A = new UP();
        this.A03 = 0;
    }

    private int A00(WJ wj, C1952Ug c1952Ug) throws IOException {
        AbstractC2388es.A01(this.A08);
        AbstractC2388es.A01(this.A07);
        if (this.A09 != null && this.A09.A0B()) {
            C1972Vf c1972Vf = this.A09;
            String[] strArr = A0E;
            if (strArr[0].charAt(16) == strArr[2].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[0] = "Wrn8iwZbvFTMzyULGJq4KlCaMJjw9X7M";
            strArr2[2] = "geT2vOINuTMF3b7pTvnt8dOx6Eb23e1Q";
            return c1972Vf.A08(wj, c1952Ug);
        }
        if (this.A04 == -1) {
            this.A04 = UQ.A01(wj, this.A07);
            return 0;
        }
        int iA0A = this.A0B.A0A();
        boolean z = false;
        if (iA0A < 32768) {
            int i = wj.read(this.A0B.A0l(), iA0A, 32768 - iA0A);
            z = i == -1;
            if (!z) {
                this.A0B.A0e(iA0A + i);
            } else {
                int currentLimit = this.A0B.A07();
                if (currentLimit == 0) {
                    A03();
                    String[] strArr3 = A0E;
                    String str = strArr3[0];
                    String str2 = strArr3[2];
                    int iCharAt = str.charAt(16);
                    int currentLimit2 = str2.charAt(16);
                    if (iCharAt == currentLimit2) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A0E;
                    strArr4[6] = "waaSqI27CqSUXyly1wq2DbYpw5UE8TCS";
                    strArr4[3] = "vEOMs2OACLPHrHhDHCqWJ1G1Spw17Rot";
                    return -1;
                }
            }
        }
        int iA09 = this.A0B.A09();
        int i2 = this.A00;
        int currentLimit3 = this.A02;
        if (i2 < currentLimit3) {
            C2447fq c2447fq = this.A0B;
            int i3 = this.A02;
            int currentLimit4 = this.A00;
            int i4 = i3 - currentLimit4;
            int currentLimit5 = this.A0B.A07();
            c2447fq.A0g(Math.min(i4, currentLimit5));
        }
        long jA01 = A01(this.A0B, z);
        int iA010 = this.A0B.A09() - iA09;
        this.A0B.A0f(iA09);
        this.A08.AHx(this.A0B, iA010);
        int currentLimit6 = this.A00;
        this.A00 = currentLimit6 + iA010;
        if (A0E[5].length() == 29) {
            throw new RuntimeException();
        }
        String[] strArr5 = A0E;
        strArr5[0] = "Ya2fOcoOng8GUYfY6HqKCD0S72LcOgrK";
        strArr5[2] = "fIQIBkjf3eJORY2jPBmA7XcSdHqMqleE";
        if (jA01 != -1) {
            A03();
            this.A00 = 0;
            this.A04 = jA01;
        }
        if (this.A0B.A07() < 16) {
            int iA07 = this.A0B.A07();
            System.arraycopy(this.A0B.A0l(), this.A0B.A09(), this.A0B.A0l(), 0, iA07);
            this.A0B.A0f(0);
            this.A0B.A0e(iA07);
        }
        return 0;
    }

    private long A01(C2447fq c2447fq, boolean z) {
        boolean zA08;
        AbstractC2388es.A01(this.A07);
        int iA09 = c2447fq.A09();
        while (iA09 <= frameOffset - 16) {
            c2447fq.A0f(iA09);
            if (UQ.A08(c2447fq, this.A07, this.A01, this.A0A)) {
                c2447fq.A0f(iA09);
                return this.A0A.A00;
            }
            iA09++;
        }
        if (z) {
            while (iA09 <= iA0A - frameOffset) {
                c2447fq.A0f(iA09);
                try {
                    zA08 = UQ.A08(c2447fq, this.A07, this.A01, this.A0A);
                } catch (IndexOutOfBoundsException unused) {
                    zA08 = false;
                }
                int iA010 = c2447fq.A09();
                int frameOffset = c2447fq.A0A();
                if (iA010 > frameOffset) {
                    zA08 = false;
                }
                if (zA08) {
                    c2447fq.A0f(iA09);
                    return this.A0A.A00;
                }
                iA09++;
            }
            int frameOffset2 = c2447fq.A0A();
            c2447fq.A0f(frameOffset2);
            return -1L;
        }
        c2447fq.A0f(iA09);
        return -1L;
    }

    private Uj A02(long j, long j2) {
        AbstractC2388es.A01(this.A07);
        if (this.A07.A0A != null) {
            return new W3(this.A07, j);
        }
        if (j2 != -1 && this.A07.A09 > 0) {
            this.A09 = new C1972Vf(this.A07, this.A01, j, j2);
            return this.A09.A09();
        }
        return new C1991Vy(this.A07.A06());
    }

    private void A03() {
        ((InterfaceC1957Uo) AbstractC2471gE.A0f(this.A08)).AI0((this.A04 * 1000000) / ((long) ((UU) AbstractC2471gE.A0f(this.A07)).A07), 1, this.A00, 0, null);
    }

    private void A04(WJ wj) throws IOException {
        this.A01 = US.A00(wj);
        ((UL) AbstractC2471gE.A0f(this.A06)).AID(A02(wj.A8d(), wj.A8E()));
        this.A03 = 5;
    }

    private void A05(WJ wj) throws IOException {
        wj.AG1(this.A0D, 0, this.A0D.length);
        wj.AHr();
        this.A03 = 2;
    }

    private void A06(WJ wj) throws IOException {
        this.A05 = US.A02(wj, !this.A0C);
        this.A03 = 1;
    }

    private void A07(WJ wj) throws IOException {
        boolean zA0B = false;
        UR metadataHolder = new UR(this.A07);
        while (!zA0B) {
            zA0B = US.A0B(wj, metadataHolder);
            this.A07 = (UU) AbstractC2471gE.A0f(metadataHolder.A00);
        }
        AbstractC2388es.A01(this.A07);
        this.A02 = Math.max(this.A07.A06, 6);
        ((InterfaceC1957Uo) AbstractC2471gE.A0f(this.A08)).A6U(this.A07.A08(this.A0D, this.A05));
        this.A03 = 4;
    }

    private void A08(WJ wj) throws IOException {
        US.A09(wj);
        this.A03 = 3;
    }

    public static /* synthetic */ UK[] A09() {
        return new UK[]{new VW()};
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AA0(UL ul) {
        this.A06 = ul;
        this.A08 = ul.AJX(0, 1);
        ul.A6E();
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final int AGT(WJ wj, C1952Ug c1952Ug) throws IOException {
        switch (this.A03) {
            case 0:
                A06(wj);
                return 0;
            case 1:
                A05(wj);
                return 0;
            case 2:
                A08(wj);
                if (A0E[7].length() != 28) {
                    throw new RuntimeException();
                }
                A0E[7] = "zJCdOrVJVUlJhvvR3L8JmhucXOLV";
                return 0;
            case 3:
                A07(wj);
                return 0;
            case 4:
                A04(wj);
                return 0;
            case 5:
                return A00(wj, c1952Ug);
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AGj() {
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AIC(long j, long j2) {
        if (j == 0) {
            this.A03 = 0;
        } else if (this.A09 != null) {
            this.A09.A0A(j2);
        }
        this.A04 = j2 != 0 ? -1L : 0L;
        this.A00 = 0;
        this.A0B.A0d(0);
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final boolean AJB(WJ wj) throws IOException {
        US.A01(wj, false);
        return US.A0A(wj);
    }
}
