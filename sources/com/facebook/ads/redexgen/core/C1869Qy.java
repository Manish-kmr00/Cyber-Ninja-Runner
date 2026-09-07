package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1869Qy implements InterfaceC2294dL {
    public static String[] A04 = {"HJiG08VABV4bgPvBuIHmB0QgcQcpsXWu", "rPSLKKx", "s30Qb", "", "jZ8LcPBJeju31135gHiS3ruOtpsz6ca1", "Wk6RdB9", "nl0Ip", "e6TFxM3GpawCuoBue5hU0ga7A8aqYwlk"};
    public long A00;
    public long A01;
    public C1869Qy A02;
    public C2293dK A03;

    public C1869Qy(long j, int i) {
        A02(j, i);
    }

    public final int A00(long j) {
        return ((int) (j - this.A01)) + this.A03.A00;
    }

    public final C1869Qy A01() {
        this.A03 = null;
        C1869Qy c1869Qy = this.A02;
        this.A02 = null;
        return c1869Qy;
    }

    public final void A02(long j, int i) {
        AbstractC2388es.A08(this.A03 == null);
        this.A01 = j;
        this.A00 = ((long) i) + j;
    }

    public final void A03(C2293dK c2293dK, C1869Qy c1869Qy) {
        this.A03 = c2293dK;
        this.A02 = c1869Qy;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2294dL
    public final C2293dK A6k() {
        return (C2293dK) AbstractC2388es.A01(this.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2294dL
    public final C1869Qy ABx() {
        if (this.A02 == null) {
            return null;
        }
        C1869Qy c1869Qy = this.A02;
        String[] strArr = A04;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A04[0] = "s3hOhS6JRVZGOWqbEiZVryq1r0alsn39";
        if (c1869Qy.A03 == null) {
            return null;
        }
        return this.A02;
    }
}
