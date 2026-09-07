package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class KS extends AbstractC2197bm {
    public static String[] A01 = {"A0hxmHyocA20uKbzLNrX1cuoBFAzY21E", "I9xoCKjiIf8OmMJxcwGdtcNw1YuiDvi3", "dl", "8cu3hn6v04Mabo0DRb3BoKxPmV6m17RH", "M3PfsQ0uQOYBe23ut3RBur7M821ZKE4o", "dBLXd4nh7JPFvxg4r1eMmoTDEY", "dzagYupPsp4H2uhompZ2DySoLx14PfZd", "Z1qzuvaE1jq9Ec95ZFgzh3McR3fZkyWy"};
    public final /* synthetic */ C2189be A00;

    public KS(C2189be c2189be) {
        this.A00 = c2189be;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2198bn c2198bn) {
        if (this.A00.A01 != null && !this.A00.A03 && c2198bn.A00().getAction() == 0) {
            C2189be c2189be = this.A00;
            String[] strArr = A01;
            if (strArr[5].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A01[4] = "8qKCS4QoQxaUoDKBRazWJt0HJmuP0GoR";
            c2189be.A05.removeCallbacksAndMessages(null);
            if (this.A00.A0D(EnumC1668Ip.A04)) {
                this.A00.A03();
                C2189be c2189be2 = this.A00;
                if (A01[3].charAt(1) != 'x') {
                    A01[3] = "krfS0sgwBFPIM38aK2Y5K2a50FO4BQxK";
                    c2189be2.A06(true, false);
                } else {
                    c2189be2.A06(true, false);
                }
            }
            if (this.A00.A02) {
                this.A00.A05.postDelayed(new C2190bf(this), this.A00.A00);
            }
        }
    }
}
