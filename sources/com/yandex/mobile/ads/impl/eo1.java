package com.yandex.mobile.ads.impl;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class eo1<E> extends hk0<E> {
    static final hk0<Object> g = new eo1(0, new Object[0]);
    final transient Object[] e;
    private final transient int f;

    @Override // com.yandex.mobile.ads.impl.fk0
    final int e() {
        return 0;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final boolean f() {
        return false;
    }

    eo1(int i, Object[] objArr) {
        this.e = objArr;
        this.f = i;
    }

    @Override // com.yandex.mobile.ads.impl.hk0, com.yandex.mobile.ads.impl.fk0
    final int a(int i, Object[] objArr) {
        System.arraycopy(this.e, 0, objArr, i, this.f);
        return i + this.f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final Object[] c() {
        return this.e;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final int d() {
        return this.f;
    }

    @Override // java.util.List
    public final E get(int i) {
        rj1.a(i, this.f);
        return (E) Objects.requireNonNull(this.e[i]);
    }
}
