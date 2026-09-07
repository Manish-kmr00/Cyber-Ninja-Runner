package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T9 implements InterfaceC2013Wv {
    public final List<C2035Xr> A00;
    public final long[] A01;
    public final long[] A02;

    public T9(List<C2035Xr> list) {
        this.A00 = Collections.unmodifiableList(new ArrayList(list));
        this.A01 = new long[list.size() * 2];
        for (int i = 0; i < cueIndex; i++) {
            C2035Xr c2035Xr = list.get(i);
            int i2 = i * 2;
            this.A01[i2] = c2035Xr.A01;
            int arrayIndex = i2 + 1;
            this.A01[arrayIndex] = c2035Xr.A00;
        }
        this.A02 = Arrays.copyOf(this.A01, this.A01.length);
        Arrays.sort(this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final List<C1853Qh> A7N(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.A00.size(); i++) {
            if (this.A01[i * 2] <= j && j < this.A01[(i * 2) + 1]) {
                C2035Xr c2035Xr = this.A00.get(i);
                if (c2035Xr.A02.A01 == -3.4028235E38f) {
                    arrayList2.add(c2035Xr);
                } else {
                    arrayList.add(c2035Xr.A02);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.facebook.ads.redexgen.X.Y1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((C2035Xr) obj).A01, ((C2035Xr) obj2).A01);
            }
        });
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            arrayList.add(((C2035Xr) arrayList2.get(i2)).A02.A02().A07((-1) - i2, 1).A0H());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final long A7t(int i) {
        boolean z = true;
        AbstractC2388es.A07(i >= 0);
        if (i >= this.A02.length) {
            z = false;
        }
        AbstractC2388es.A07(z);
        return this.A02[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A7u() {
        return this.A02.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2013Wv
    public final int A8Q(long j) {
        int iA0K = AbstractC2471gE.A0K(this.A02, j, false, false);
        int index = this.A02.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
