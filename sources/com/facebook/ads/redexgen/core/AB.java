package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AB implements InterfaceC1935Tn {
    public static String[] A04 = {"YOTdJJtRJn1uVB3Fvz2vC3TfxD1i1SVb", "pbSCQ6EtrCvuAxXmQLOw6ZGbTposz5cx", "B2nKwY1ESUvXaarAT7BvH", "lePajvUlJikrjw8zfQ45dXGHHAfbDCLz", "ex04D5HE3oFagUGv1K1jCqh", "AJi9tCnq1NHuV7cshgeYkqUDimJzuFt7", "l5ZT4dX7b30GYzt6JPT3HnzMt0Et48nR", "xC"};
    public long A00;
    public final long A01;
    public final C2433fc A03 = new C2433fc();
    public final C2433fc A02 = new C2433fc();

    public AB(long j, long j2, long j3) {
        this.A00 = j;
        this.A01 = j3;
        this.A03.A04(0L);
        this.A02.A04(j2);
    }

    public final void A00(long j) {
        this.A00 = j;
    }

    public final void A01(long j, long j2) {
        if (A02(j)) {
            return;
        }
        C2433fc c2433fc = this.A03;
        String[] strArr = A04;
        if (strArr[6].charAt(26) == strArr[3].charAt(26)) {
            throw new RuntimeException();
        }
        A04[1] = "C3CyI0GcecYFZSLRHvokZGG0W51ywz6S";
        c2433fc.A04(j);
        this.A02.A04(j2);
    }

    public final boolean A02(long j) {
        long lastIndexedTimeUs = this.A03.A03(this.A03.A02() - 1);
        return j - lastIndexedTimeUs < 100000;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1935Tn
    public final long A7Z() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        int iA0C = AbstractC2471gE.A0C(this.A03, j, true, true);
        C1954Uk c1954Uk = new C1954Uk(this.A03.A03(iA0C), this.A02.A03(iA0C));
        if (c1954Uk.A01 != j) {
            int targetIndex = this.A03.A02();
            if (iA0C != targetIndex - 1) {
                int targetIndex2 = iA0C + 1;
                long jA03 = this.A03.A03(targetIndex2);
                int targetIndex3 = iA0C + 1;
                C1954Uk nextSeekPoint = new C1954Uk(jA03, this.A02.A03(targetIndex3));
                return new C1953Ui(c1954Uk, nextSeekPoint);
            }
        }
        return new C1953Ui(c1954Uk);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1935Tn
    public final long A97(long j) {
        return this.A03.A03(AbstractC2471gE.A0C(this.A02, j, true, true));
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return true;
    }
}
