package com.smaato.sdk.core.util.collections;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes13.dex */
abstract class MappedListIterator<F, T> extends MappedIterator<F, T> implements ListIterator<T> {
    MappedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return backingIterator().hasPrevious();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    public final T previous() {
        return (T) map(backingIterator().previous());
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return backingIterator().nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return backingIterator().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
