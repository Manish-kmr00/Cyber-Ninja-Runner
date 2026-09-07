package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W3 implements Uj {
    public static String[] A02 = {"VNssWCDGJNuPiPW5pxEIhDnP4uUO9dlp", "b658OCw3MChpQVxn7641meas2Ke4aC8R", "5Ugl", "DbhkVU5ro4dRMxdJyKQLBiZGrZaV3A4t", "5zlshhsefEO4CV0muXMQPVsFvSZa", "rO74d0xzdKllKXq43FUGKSzAg", "cyf8Fw3S0JBJmK2TeC1PY", "xbwipv3QNbRzSALR5JTcL7pz3w1Wu"};
    public final long A00;
    public final UU A01;

    public W3(UU uu, long j) {
        this.A01 = uu;
        this.A00 = j;
    }

    private C1954Uk A00(long j, long j2) {
        return new C1954Uk((1000000 * j) / ((long) this.A01.A07), this.A00 + j2);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A01.A06();
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        long j2;
        AbstractC2388es.A02(this.A01.A0A);
        long[] jArr = this.A01.A0A.A01;
        long[] jArr2 = this.A01.A0A.A00;
        int iA0L = AbstractC2471gE.A0L(jArr, this.A01.A07(j), true, false);
        long j3 = 0;
        if (iA0L == -1) {
            j2 = 0;
        } else {
            j2 = jArr[iA0L];
        }
        if (iA0L != -1) {
            j3 = jArr2[iA0L];
        }
        C1954Uk c1954UkA00 = A00(j2, j3);
        long j4 = c1954UkA00.A01;
        String[] strArr = A02;
        if (strArr[7].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[7] = "kqbaKwkaNrSq59fxHMssI8SSMeJ9X";
        strArr2[2] = "7jBi";
        if (j4 == j || iA0L == jArr.length - 1) {
            return new C1953Ui(c1954UkA00);
        }
        C1954Uk secondSeekPoint = A00(jArr[iA0L + 1], jArr2[iA0L + 1]);
        return new C1953Ui(c1954UkA00, secondSeekPoint);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return true;
    }
}
