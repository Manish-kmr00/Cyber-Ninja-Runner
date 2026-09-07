package com.facebook.ads.redexgen.core;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OE<T> extends AbstractC2964oj<T> {
    public T A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OE != com.google.common.collect.Iterators$SingletonIterator<T> */
    public OE(T value) {
        this.A00 = value;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OE != com.google.common.collect.Iterators$SingletonIterator<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 != null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OE != com.google.common.collect.Iterators$SingletonIterator<T> */
    @Override // java.util.Iterator
    public final T next() {
        T t = this.A00;
        this.A00 = null;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException();
    }
}
