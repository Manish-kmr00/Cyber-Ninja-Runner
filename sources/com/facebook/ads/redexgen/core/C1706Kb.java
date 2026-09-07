package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1706Kb extends C2219c8 {
    public static String[] A0F = {"r3hDWnB1R9y4pEiKAURNp99h2b", "kj3t6dP2tWSOfb61zMSBvgjhGLqlygll", "", "sX8uIgx32JWe8q5WuLHBMtkPG7d", "ZlH8xHdCAMZsgB23qoj", "6lejLSjHGD", "XsRzuVWfX96s5Dei3zwO9zjz9s6FXTfu", "pCK0u"};
    public int A00;
    public ID A01;
    public boolean A02;
    public final C9K<C1705Ka> A03;
    public final C9K<KY> A04;
    public final C9K<C2207bw> A05;
    public final C9K<KX> A06;
    public final C9K<C2202br> A07;
    public final C9K<C2200bp> A08;
    public final C9K<C2199bo> A09;
    public final C9K<C2194bj> A0A;
    public final C9K<C2193bi> A0B;
    public final C2232cL A0C;
    public final AbstractC2204bt A0D;
    public final AbstractC2195bk A0E;

    public C1706Kb(C2699k1 c2699k1, A7 a7, C2232cL c2232cL, String str) {
        this(c2699k1, a7, c2232cL, str, 0, 0, false, null, null);
    }

    public C1706Kb(C2699k1 c2699k1, A7 a7, C2232cL c2232cL, String str, int i, int i2, boolean z, Bundle bundle, Map<String, String> map) {
        super(c2699k1, a7, c2232cL, str, !c2232cL.A0o(), i, i2, z, bundle, map, new C2218c7(c2699k1, c2232cL));
        this.A0E = new C1707Kc(this);
        this.A08 = new C2229cI(this);
        this.A04 = new C2228cH(this);
        this.A05 = new C2227cG(this);
        this.A06 = new C2226cF(this);
        this.A03 = new C2225cE(this);
        this.A07 = new C2224cD(this);
        this.A0A = new C2223cC(this);
        this.A0B = new C2222cB(this);
        this.A09 = new C2231cK(this);
        this.A0D = new C1708Kd(this);
        this.A02 = false;
        this.A0C = c2232cL;
        this.A0C.getEventBus().A03(this.A0E, this.A06, this.A08, this.A05, this.A04, this.A03, this.A07, this.A0A, this.A0B, this.A0D, this.A09);
        if (C14499m.A2k(c2699k1)) {
            this.A01 = new ID(c2232cL, str, null);
        }
    }

    public C1706Kb(C2699k1 c2699k1, A7 a7, C2232cL c2232cL, String str, Bundle bundle, Map<String, String> extraParams) {
        this(c2699k1, a7, c2232cL, str, 0, 0, false, bundle, extraParams);
    }

    @Override // com.facebook.ads.redexgen.core.C2219c8
    public final void A0n(IH ih, Map<String, String> map) {
        super.A0n(ih, map);
        if (this.A01 != null && ih == IH.A09) {
            Map<String, String> params = this.A01.A05();
            String[] strArr = A0F;
            if (strArr[0].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0F[2] = "tc9";
            map.putAll(params);
        }
    }

    public final void A0p() {
        C2230cJ c2230cJ = new C2230cJ(this);
        if (this.A0C.A0s()) {
            ExecutorC1520Cx.A00(c2230cJ);
            return;
        }
        C2232cL c2232cL = this.A0C;
        String[] strArr = A0F;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A0F[1] = "nFCp2DExxe9bklz52WjNRol8ULAuMoj6";
        c2232cL.getStateHandler().post(c2230cJ);
    }
}
