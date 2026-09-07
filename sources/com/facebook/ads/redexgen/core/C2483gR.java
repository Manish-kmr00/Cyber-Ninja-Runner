package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2483gR {
    public static String[] A06 = {"1LIDpEnZLWsjOXoqyMd9HjcDPNQuRjTA", "IgfhnL7ccGWQBHBIf7Q4D", "4UdfE9tj3s9G9lgsg9jjmuKMTC", "EfdJhxTuo7rdeotVcaob7Tl3BmcAs4", "MUCemDi6aAguJzmd9ouPrUNUG0KNmn12", "j", "yRsK1QnhfN6SMqYjSSjBWeOpYQcUzNRp", "9d6o6yu5GmzqC2FAEfJAM4gmri"};
    public int A00;
    public boolean A04;
    public boolean A05;
    public C2482gQ A03 = new C2482gQ();
    public C2482gQ A02 = new C2482gQ();
    public long A01 = -9223372036854775807L;

    public final float A00() {
        if (A06()) {
            return (float) (1.0E9d / this.A03.A01());
        }
        return -1.0f;
    }

    public final int A01() {
        return this.A00;
    }

    public final long A02() {
        if (A06()) {
            return this.A03.A01();
        }
        return -9223372036854775807L;
    }

    public final long A03() {
        if (A06()) {
            return this.A03.A02();
        }
        return -9223372036854775807L;
    }

    public final void A04() {
        this.A03.A03();
        this.A02.A03();
        this.A04 = false;
        this.A01 = -9223372036854775807L;
        this.A00 = 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0082  */
    public final void A05(long j) {
        this.A03.A04(j);
        if (this.A03.A06() && !this.A05) {
            this.A04 = false;
        } else if (this.A01 != -9223372036854775807L) {
            if (this.A04) {
                C2482gQ c2482gQ = this.A02;
                if (A06[1].length() != 21) {
                    String[] strArr = A06;
                    strArr[2] = "6xRh5NtLUlWR6pt8V3JWU1sJi9";
                    strArr[7] = "vMVt274myWZ9WJkTun5Vgmrmrm";
                    if (c2482gQ.A05()) {
                        this.A02.A03();
                        this.A02.A04(this.A01);
                    }
                } else {
                    String[] strArr2 = A06;
                    strArr2[2] = "eZbPWvrkL0xZL0guLrmmSZIXhw";
                    strArr2[7] = "65LgPJpcrlT8CPBzfdIkwj2OrC";
                    if (c2482gQ.A05()) {
                        this.A02.A03();
                        this.A02.A04(this.A01);
                    }
                }
            } else {
                this.A02.A03();
                this.A02.A04(this.A01);
            }
            this.A04 = true;
            this.A02.A04(j);
        }
        if (this.A04 && this.A02.A06()) {
            C2482gQ c2482gQ2 = this.A03;
            C2482gQ previousMatcher = this.A02;
            this.A03 = previousMatcher;
            this.A02 = c2482gQ2;
            if (A06[3].length() == 1) {
                throw new RuntimeException();
            }
            A06[0] = "6uvXVENZyinRVC6bdJaN8PoH4GzZT6Sj";
            this.A04 = false;
            this.A05 = false;
        }
        this.A01 = j;
        this.A00 = this.A03.A06() ? 0 : this.A00 + 1;
    }

    public final boolean A06() {
        return this.A03.A06();
    }
}
