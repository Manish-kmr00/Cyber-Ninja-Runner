package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes13.dex */
final class q31 extends r31.c<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Comparator f9978a;

    @Override // com.yandex.mobile.ads.impl.r31.c
    final <K, V> Map<K, Collection<V>> b() {
        return new TreeMap(this.f9978a);
    }

    q31(Comparator comparator) {
        this.f9978a = comparator;
    }
}
