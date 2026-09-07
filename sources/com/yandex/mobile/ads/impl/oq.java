package com.yandex.mobile.ads.impl;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
class oq<E> extends AbstractCollection<E> {
    final Collection<E> b;
    final sj1<? super E> c;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    oq(Collection<E> collection, sj1<? super E> sj1Var) {
        this.b = collection;
        this.c = sj1Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(E e) {
        if (this.c.apply(e)) {
            return this.b.add(e);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            if (!this.c.apply(it.next())) {
                throw new IllegalArgumentException();
            }
        }
        return this.b.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        fq0.a(this.b, this.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        Collection<E> collection = this.b;
        collection.getClass();
        try {
            if (collection.contains(obj)) {
                return this.c.apply(obj);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        Collection<E> collection = this.b;
        sj1<? super E> sj1Var = this.c;
        Iterator<T> it = collection.iterator();
        if (sj1Var != null) {
            boolean z = false;
            int i = 0;
            while (it.hasNext()) {
                if (sj1Var.apply((Object) it.next())) {
                    if (i == -1) {
                        break;
                    }
                    z = true;
                    break;
                }
                i++;
            }
            return !z;
        }
        throw new NullPointerException("predicate");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        Iterator<E> it = this.b.iterator();
        sj1<? super E> sj1Var = this.c;
        it.getClass();
        sj1Var.getClass();
        return new gq0(it, sj1Var);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        return contains(obj) && this.b.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        Iterator<E> it = this.b.iterator();
        boolean z = false;
        while (it.hasNext()) {
            E next = it.next();
            if (this.c.apply(next) && collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        Iterator<E> it = this.b.iterator();
        boolean z = false;
        while (it.hasNext()) {
            E next = it.next();
            if (this.c.apply(next) && !collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        Iterator<E> it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.c.apply(it.next())) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        Iterator<E> it = iterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            k kVar = (k) it;
            if (kVar.hasNext()) {
                arrayList.add(kVar.next());
            } else {
                return arrayList.toArray();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Iterator<E> it = iterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            k kVar = (k) it;
            if (kVar.hasNext()) {
                arrayList.add(kVar.next());
            } else {
                return (T[]) arrayList.toArray(tArr);
            }
        }
    }
}
