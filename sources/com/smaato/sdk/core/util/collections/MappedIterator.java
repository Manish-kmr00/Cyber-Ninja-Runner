package com.smaato.sdk.core.util.collections;

import com.smaato.sdk.core.util.Objects;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
abstract class MappedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> backingIterator;

    abstract T map(F f);

    MappedIterator(Iterator<? extends F> it) {
        this.backingIterator = (Iterator) Objects.requireNonNull(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return map(this.backingIterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.backingIterator.remove();
    }
}
