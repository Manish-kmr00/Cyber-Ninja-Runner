package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TX implements InterfaceC2002Wj {
    public static String[] A04 = {"8eDNQuVhj6HhE0aXOUxIPi6SWJ", "rSsBc0D01Jkzjs7E75L56SoyTTKcbK0y", "eJAQfKLxAbIZZahT5Ip5jMMWACAMto3", "U4euxyWP6XLLFTCzy7P0sh3Ga7", "shmfGF", "CPSxyeX2nRXyHVWsMNxXAHkfikUPgKRS", "qP2Iyl3YHFMHKPVMw5hT0TrGiQ1t3VCc", "D9PGb9ZnQLUSUdTPk"};
    public long A00 = -1;
    public long A01 = -1;
    public UT A02;
    public UU A03;

    public TX(UU uu, UT ut) {
        this.A03 = uu;
        this.A02 = ut;
    }

    public final void A00(long j) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2002Wj
    public final Uj A5P() {
        AbstractC2388es.A08(this.A00 != -1);
        return new W3(this.A03, this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2002Wj
    public final long AGV(WJ wj) {
        if (this.A01 < 0) {
            return -1L;
        }
        long j = -(this.A01 + 2);
        this.A01 = -1L;
        String[] strArr = A04;
        if (strArr[3].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "U6EOfu";
        strArr2[0] = "zri4cOopvrlPFS0GFsI4EmN1ji";
        return j;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2002Wj
    public final void AJH(long j) {
        long[] jArr = this.A02.A01;
        this.A01 = jArr[AbstractC2471gE.A0L(jArr, j, true, true)];
    }
}
