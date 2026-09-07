package com.yandex.mobile.ads.impl;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes2.dex */
@DoNotMock("Use ImmutableList.of or another implementation")
public abstract class fk0<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] b = new Object[0];

    static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f8903a;
        int b;
        boolean c;

        a() {
            nq.a(4, "initialCapacity");
            this.f8903a = new Object[4];
            this.b = 0;
        }

        public final void a(Object obj) {
            obj.getClass();
            int i = this.b;
            int i2 = i + 1;
            Object[] objArr = this.f8903a;
            if (objArr.length < i2) {
                int length = objArr.length;
                if (i2 < 0) {
                    throw new AssertionError("cannot store more than MAX_VALUE elements");
                }
                int iHighestOneBit = length + (length >> 1) + 1;
                if (iHighestOneBit < i2) {
                    iHighestOneBit = Integer.highestOneBit(i) << 1;
                }
                if (iHighestOneBit < 0) {
                    iHighestOneBit = Integer.MAX_VALUE;
                }
                this.f8903a = Arrays.copyOf(objArr, iHighestOneBit);
                this.c = false;
            } else if (this.c) {
                this.f8903a = (Object[]) objArr.clone();
                this.c = false;
            }
            Object[] objArr2 = this.f8903a;
            int i3 = this.b;
            this.b = i3 + 1;
            objArr2[i3] = obj;
        }

        public void b(Object obj) {
            a(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b a(List list) {
            if (list instanceof Collection) {
                int size = list.size() + this.b;
                Object[] objArr = this.f8903a;
                if (objArr.length < size) {
                    int length = objArr.length;
                    if (size >= 0) {
                        int iHighestOneBit = length + (length >> 1) + 1;
                        if (iHighestOneBit < size) {
                            iHighestOneBit = Integer.highestOneBit(size - 1) << 1;
                        }
                        if (iHighestOneBit < 0) {
                            iHighestOneBit = Integer.MAX_VALUE;
                        }
                        this.f8903a = Arrays.copyOf(objArr, iHighestOneBit);
                        this.c = false;
                    } else {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                } else if (this.c) {
                    this.f8903a = (Object[]) objArr.clone();
                    this.c = false;
                }
                if (list instanceof fk0) {
                    this.b = ((fk0) list).a(this.b, this.f8903a);
                    return this;
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((hk0.a) this).a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    Object[] c() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(@CheckForNull Object obj);

    int d() {
        throw new UnsupportedOperationException();
    }

    int e() {
        throw new UnsupportedOperationException();
    }

    abstract boolean f();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract b82<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new hk0.c(toArray(b));
    }

    int a(int i, Object[] objArr) {
        b82<E> it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    fk0() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        tArr.getClass();
        int size = size();
        if (tArr.length < size) {
            Object[] objArrC = c();
            if (objArrC != null) {
                return (T[]) mh1.a(objArrC, e(), d(), tArr);
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(0, tArr);
        return tArr;
    }

    public hk0<E> b() {
        if (isEmpty()) {
            int i = hk0.d;
            return (hk0<E>) eo1.g;
        }
        Object[] array = toArray(b);
        int i2 = hk0.d;
        return hk0.b(array.length, array);
    }

    @DoNotMock
    public static abstract class b<E> {
        b() {
        }
    }
}
