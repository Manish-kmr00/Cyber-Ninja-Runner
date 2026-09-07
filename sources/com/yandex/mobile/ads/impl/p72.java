package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class p72 implements g32 {
    private final l72 b;
    private final long[] c;
    private final Map<String, o72> d;
    private final Map<String, m72> e;
    private final Map<String, String> f;

    public p72(l72 l72Var, HashMap map, HashMap map2, HashMap map3) {
        this.b = l72Var;
        this.e = map2;
        this.f = map3;
        this.d = Collections.unmodifiableMap(map);
        this.c = l72Var.b();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        return this.c[i];
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        return this.b.a(j, this.d, this.e, this.f);
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        return this.c.length;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        int iA = x82.a(this.c, j, false);
        if (iA < this.c.length) {
            return iA;
        }
        return -1;
    }
}
