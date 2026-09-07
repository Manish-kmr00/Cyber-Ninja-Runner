package com.yandex.mobile.ads.impl;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes7.dex */
public abstract class hk0<E> extends fk0<E> implements List<E>, RandomAccess {
    private static final c82<Object> c = new b(0, eo1.g);
    public static final /* synthetic */ int d = 0;

    public static final class a<E> extends fk0.a<E> {
        public final a b(List list) {
            a(list);
            return this;
        }

        public a() {
            this(0);
        }

        a(int i) {
        }

        public final hk0<E> a() {
            this.c = true;
            return hk0.b(this.b, this.f8903a);
        }
    }

    static class b<E> extends j<E> {
        private final hk0<E> d;

        b(int i, hk0 hk0Var) {
            super(hk0Var.size(), i);
            this.d = hk0Var;
        }

        @Override // com.yandex.mobile.ads.impl.j
        protected final E a(int i) {
            return this.d.get(i);
        }
    }

    class d extends hk0<E> {
        final transient int e;
        final transient int f;

        @Override // com.yandex.mobile.ads.impl.fk0
        final boolean f() {
            return true;
        }

        @Override // com.yandex.mobile.ads.impl.hk0, com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.yandex.mobile.ads.impl.hk0, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // com.yandex.mobile.ads.impl.hk0, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return listIterator(i);
        }

        d(int i, int i2) {
            this.e = i;
            this.f = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.f;
        }

        @Override // com.yandex.mobile.ads.impl.fk0
        @CheckForNull
        final Object[] c() {
            return hk0.this.c();
        }

        @Override // com.yandex.mobile.ads.impl.fk0
        final int e() {
            return hk0.this.e() + this.e;
        }

        @Override // com.yandex.mobile.ads.impl.fk0
        final int d() {
            return hk0.this.e() + this.e + this.f;
        }

        @Override // java.util.List
        public final E get(int i) {
            rj1.a(i, this.f);
            return hk0.this.get(i + this.e);
        }

        @Override // com.yandex.mobile.ads.impl.hk0, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final hk0<E> subList(int i, int i2) {
            rj1.a(i, i2, this.f);
            hk0 hk0Var = hk0.this;
            int i3 = this.e;
            return hk0Var.subList(i + i3, i2 + i3);
        }
    }

    public static <E> a<E> g() {
        return new a<>();
    }

    public static <E> hk0<E> h() {
        return (hk0<E>) eo1.g;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    @Deprecated
    public final hk0<E> b() {
        return this;
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    Object writeReplace() {
        return new c(toArray());
    }

    private static <E> hk0<E> a(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(oe.a("at index ", i));
            }
        }
        return b(objArr.length, objArr);
    }

    static hk0 b(int i, Object[] objArr) {
        return i == 0 ? eo1.g : new eo1(i, objArr);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (vd1.a(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && vd1.a(it.next(), it2.next())) {
                    }
                }
                return true ^ it2.hasNext();
            }
        }
        return false;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj != null) {
            int size = size();
            for (int i = 0; i < size; i++) {
                if (obj.equals(get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final b82<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj != null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (obj.equals(get(size))) {
                    return size;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    int a(int i, Object[] objArr) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public static <E> hk0<E> a(Collection<? extends E> collection) {
        if (collection instanceof fk0) {
            hk0<E> hk0VarB = ((fk0) collection).b();
            if (!hk0VarB.f()) {
                return hk0VarB;
            }
            Object[] array = hk0VarB.toArray();
            return b(array.length, array);
        }
        return a(collection.toArray());
    }

    public static <E> hk0<E> b(E[] eArr) {
        if (eArr.length == 0) {
            return (hk0<E>) eo1.g;
        }
        return a((Object[]) eArr.clone());
    }

    hk0() {
    }

    @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c82<E> listIterator(int i) {
        rj1.b(i, size());
        if (isEmpty()) {
            return (c82<E>) c;
        }
        return new b(i, this);
    }

    public static hk0 a(Long l, Long l2, Long l3, Long l4, Long l5) {
        return a(l, l2, l3, l4, l5);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    static class c implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] b;

        c(Object[] objArr) {
            this.b = objArr;
        }

        Object readResolve() {
            return hk0.b(this.b);
        }
    }

    public static <E> hk0<E> a(E e) {
        return a(e);
    }

    public static <E> hk0<E> a(E e, E e2) {
        return a(e, e2);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a */
    public hk0<E> subList(int i, int i2) {
        rj1.a(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return (hk0<E>) eo1.g;
        }
        return new d(i, i3);
    }
}
