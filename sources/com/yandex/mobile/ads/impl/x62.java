package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
abstract class x62<F, T> implements Iterator<T> {
    final Iterator<? extends F> b;

    x62(Iterator<? extends F> it) {
        this.b = (Iterator) rj1.a(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return (T) ((Map.Entry) this.b.next()).getValue();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.b.remove();
    }
}
