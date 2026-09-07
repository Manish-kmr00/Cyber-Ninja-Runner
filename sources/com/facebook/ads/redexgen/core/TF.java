package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TF implements InterfaceC2013Wv {
    public final List<Long> A00;
    public final List<List<C1853Qh>> A01;

    public TF(List<List<C1853Qh>> list, List<Long> cueTimesUs) {
        this.A01 = list;
        this.A00 = cueTimesUs;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final List<C1853Qh> A7N(long j) {
        int iA0H = AbstractC2471gE.A0H(this.A00, Long.valueOf(j), true, false);
        if (iA0H == -1) {
            return Collections.emptyList();
        }
        return this.A01.get(iA0H);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final long A7t(int i) {
        boolean z = true;
        AbstractC2388es.A07(i >= 0);
        if (i >= this.A00.size()) {
            z = false;
        }
        AbstractC2388es.A07(z);
        return this.A00.get(i).longValue();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A7u() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A8Q(long j) {
        int iA0G = AbstractC2471gE.A0G(this.A00, Long.valueOf(j), false, false);
        int index = this.A00.size();
        if (iA0G < index) {
            return iA0G;
        }
        return -1;
    }
}
