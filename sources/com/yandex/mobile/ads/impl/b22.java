package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
final class b22 implements g32 {
    private final List<List<ev>> b;
    private final List<Long> c;

    public b22(ArrayList arrayList, ArrayList arrayList2) {
        this.b = arrayList;
        this.c = arrayList2;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        if (i >= 0) {
            if (i < this.c.size()) {
                return this.c.get(i).longValue();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        int iA = x82.a((List) this.c, Long.valueOf(j), false);
        if (iA == -1) {
            return Collections.emptyList();
        }
        return this.b.get(iA);
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        return this.c.size();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        int i;
        List<Long> list = this.c;
        Long lValueOf = Long.valueOf(j);
        int i2 = x82.f10629a;
        int iBinarySearch = Collections.binarySearch(list, lValueOf);
        if (iBinarySearch < 0) {
            i = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(lValueOf) == 0);
            i = iBinarySearch;
        }
        if (i < this.c.size()) {
            return i;
        }
        return -1;
    }
}
