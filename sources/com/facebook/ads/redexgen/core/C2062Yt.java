package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2062Yt implements InterfaceC1775Nb {
    public final P3 A00;
    public static final C2062Yt A02 = new QE().A04();
    public static final String A03 = AbstractC2471gE.A0h(0);
    public static final InterfaceC1774Na<C2062Yt> A01 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Yu
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return C2062Yt.A01(bundle);
        }
    };

    public C2062Yt(P3 p3) {
        this.A00 = p3;
    }

    public static C2062Yt A01(Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(A03);
        if (integerArrayList == null) {
            return A02;
        }
        QE qe = new QE();
        for (int i = 0; i < integerArrayList.size(); i++) {
            qe.A00(integerArrayList.get(i).intValue());
        }
        return qe.A04();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2062Yt)) {
            return false;
        }
        return this.A00.equals(((C2062Yt) obj).A00);
    }

    public final int hashCode() {
        return this.A00.hashCode();
    }
}
