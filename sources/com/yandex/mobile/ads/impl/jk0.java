package com.yandex.mobile.ads.impl;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class jk0<E> extends fk0<E> implements Set<E> {

    @CheckForNull
    @LazyInit
    private transient hk0<E> c;

    @Override // com.yandex.mobile.ads.impl.fk0
    Object writeReplace() {
        return new a(toArray());
    }

    @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static int a(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static jk0 a(Set set) {
        if ((set instanceof jk0) && !(set instanceof SortedSet)) {
            jk0 jk0Var = (jk0) set;
            if (!jk0Var.f()) {
                return jk0Var;
            }
        }
        Object[] array = set.toArray();
        return b(array.length, array);
    }

    jk0() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof jk0) && (this instanceof go1)) {
            jk0 jk0Var = (jk0) obj;
            jk0Var.getClass();
            if ((jk0Var instanceof go1) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        return px1.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return px1.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    public hk0<E> b() {
        hk0<E> hk0Var = this.c;
        if (hk0Var != null) {
            return hk0Var;
        }
        hk0<E> hk0VarG = g();
        this.c = hk0VarG;
        return hk0VarG;
    }

    hk0<E> g() {
        Object[] array = toArray();
        int i = hk0.d;
        return hk0.b(array.length, array);
    }

    private static class a implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] b;

        a(Object[] objArr) {
            this.b = objArr;
        }

        Object readResolve() {
            return jk0.a(this.b);
        }
    }

    private static <E> jk0<E> b(int i, Object... objArr) {
        if (i == 0) {
            return go1.j;
        }
        if (i != 1) {
            int iA = a(i);
            Object[] objArr2 = new Object[iA];
            int i2 = iA - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                if (obj != null) {
                    int iHashCode = obj.hashCode();
                    int iA2 = gf0.a(iHashCode);
                    while (true) {
                        int i6 = iA2 & i2;
                        Object obj2 = objArr2[i6];
                        if (obj2 == null) {
                            objArr[i4] = obj;
                            objArr2[i6] = obj;
                            i3 += iHashCode;
                            i4++;
                            break;
                        }
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iA2++;
                    }
                } else {
                    throw new NullPointerException(oe.a("at index ", i5));
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new xy1(Objects.requireNonNull(objArr[0]));
            }
            if (a(i4) < iA / 2) {
                return b(i4, objArr);
            }
            int length = objArr.length;
            if (i4 < (length >> 1) + (length >> 2)) {
                objArr = Arrays.copyOf(objArr, i4);
            }
            return new go1(objArr, i3, objArr2, i2, i4);
        }
        return new xy1(Objects.requireNonNull(objArr[0]));
    }

    public static <E> jk0<E> a(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return go1.j;
        }
        if (length != 1) {
            return b(eArr.length, (Object[]) eArr.clone());
        }
        return new xy1(eArr[0]);
    }

    public static jk0 a(String str, String str2) {
        return b(2, str, str2);
    }

    public static jk0 a(String str, String str2, String str3) {
        return b(3, str, str2, str3);
    }
}
