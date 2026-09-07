package com.yandex.mobile.ads.impl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes13.dex */
final class gk0<K, V> extends p<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K b;
    final V c;

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    gk0(K k, V v) {
        this.b = k;
        this.c = v;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.c;
    }
}
