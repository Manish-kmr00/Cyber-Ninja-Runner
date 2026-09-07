package com.yandex.mobile.ads.impl;

import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes13.dex */
class bu0<K, V> extends px1.c<K> {
    final Map<K, V> b;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.b.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b.size();
    }

    bu0(Map<K, V> map) {
        this.b = (Map) rj1.a(map);
    }
}
