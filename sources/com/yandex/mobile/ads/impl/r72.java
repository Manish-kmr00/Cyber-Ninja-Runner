package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
final class r72 implements g32 {
    public static final r72 c = new r72();
    private final List<ev> b;

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        return 1;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        if (i == 0) {
            return 0L;
        }
        throw new IllegalArgumentException();
    }

    private r72() {
        this.b = Collections.emptyList();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        return j >= 0 ? this.b : Collections.emptyList();
    }

    public r72(ev evVar) {
        this.b = Collections.singletonList(evVar);
    }
}
