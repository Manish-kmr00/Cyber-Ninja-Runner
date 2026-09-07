package com.facebook.ads.redexgen.core;

import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2038Xu {
    public static final Comparator<C2038Xu> A02 = new Comparator() { // from class: com.facebook.ads.redexgen.X.Xt
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((C2038Xu) obj).A01.A00, ((C2038Xu) obj2).A01.A00);
        }
    };
    public final int A00;
    public final C2039Xv A01;

    public C2038Xu(C2039Xv c2039Xv, int i) {
        this.A01 = c2039Xv;
        this.A00 = i;
    }
}
