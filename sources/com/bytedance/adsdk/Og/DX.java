package com.bytedance.adsdk.Og;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class DX<K, V> {
    DX<K, V>.Og Og;

    protected abstract void KZx();

    protected abstract Map<K, V> Og();

    protected abstract int pA();

    protected abstract int pA(Object obj);

    protected abstract Object pA(int i, int i2);

    protected abstract void pA(int i);

    DX() {
    }

    final class pA<T> implements Iterator<T> {
        int KZx;
        int Og;
        boolean ZZv = false;
        final int pA;

        pA(int i) {
            this.pA = i;
            this.Og = DX.this.pA();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.KZx < this.Og;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) DX.this.pA(this.KZx, this.pA);
            this.KZx++;
            this.ZZv = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.ZZv) {
                throw new IllegalStateException();
            }
            int i = this.KZx - 1;
            this.KZx = i;
            this.Og--;
            this.ZZv = false;
            DX.this.pA(i);
        }
    }

    final class Og implements Set<K> {
        Og() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            DX.this.KZx();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return DX.this.pA(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return DX.pA(DX.this.Og(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return DX.this.pA() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new pA(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iPA = DX.this.pA(obj);
            if (iPA < 0) {
                return false;
            }
            DX.this.pA(iPA);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return DX.Og(DX.this.Og(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return DX.KZx(DX.this.Og(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return DX.this.pA();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return DX.this.Og(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) DX.this.pA(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return DX.pA(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iPA = DX.this.pA() - 1; iPA >= 0; iPA--) {
                Object objPA = DX.this.pA(iPA, 0);
                iHashCode += objPA == null ? 0 : objPA.hashCode();
            }
            return iHashCode;
        }
    }

    public static <K, V> boolean pA(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean Og(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean KZx(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] Og(int i) {
        int iPA = pA();
        Object[] objArr = new Object[iPA];
        for (int i2 = 0; i2 < iPA; i2++) {
            objArr[i2] = pA(i2, i);
        }
        return objArr;
    }

    public <T> T[] pA(T[] tArr, int i) {
        int iPA = pA();
        if (tArr.length < iPA) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iPA));
        }
        for (int i2 = 0; i2 < iPA; i2++) {
            tArr[i2] = pA(i2, i);
        }
        if (tArr.length > iPA) {
            tArr[iPA] = null;
        }
        return tArr;
    }

    public static <T> boolean pA(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<K> ZZv() {
        if (this.Og == null) {
            this.Og = new Og();
        }
        return this.Og;
    }
}
