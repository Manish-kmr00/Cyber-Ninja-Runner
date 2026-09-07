package com.yandex.mobile.ads.impl;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes13.dex */
final class go1<E> extends jk0<E> {
    private static final Object[] i = null;
    static final go1<Object> j;
    final transient Object[] d;
    private final transient int e;
    final transient Object[] f;
    private final transient int g;
    private final transient int h;

    @Override // com.yandex.mobile.ads.impl.fk0
    final int e() {
        return 0;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final boolean f() {
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final int a(int i2, Object[] objArr) {
        System.arraycopy(this.d, 0, objArr, i2, this.h);
        return i2 + this.h;
    }

    static {
        Object[] objArr = new Object[0];
        j = new go1<>(objArr, 0, objArr, 0, 0);
    }

    go1(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.d = objArr;
        this.e = i2;
        this.f = objArr2;
        this.g = i3;
        this.h = i4;
    }

    @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.f;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iA = gf0.a(obj.hashCode());
        while (true) {
            int i2 = iA & this.g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iA = i2 + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.h;
    }

    @Override // com.yandex.mobile.ads.impl.jk0, com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final b82<E> iterator() {
        return b().listIterator(0);
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final Object[] c() {
        return this.d;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final int d() {
        return this.h;
    }

    @Override // com.yandex.mobile.ads.impl.jk0
    final hk0<E> g() {
        return hk0.b(this.h, this.d);
    }

    @Override // com.yandex.mobile.ads.impl.jk0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }
}
