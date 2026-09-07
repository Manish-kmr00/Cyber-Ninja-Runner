package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
final class z11 implements g32 {
    private final List<ev> b;

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        return 1;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public z11(ArrayList arrayList) {
        this.b = Collections.unmodifiableList(arrayList);
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        if (i == 0) {
            return 0L;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        return j >= 0 ? this.b : Collections.emptyList();
    }
}
