package com.yandex.mobile.ads.impl;

import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
final class xy1<E> extends jk0<E> {
    final transient E d;

    @Override // com.yandex.mobile.ads.impl.fk0
    final boolean f() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return com.ironsource.b9.i.d + this.d.toString() + AbstractJsonLexerKt.END_LIST;
    }

    @Override // com.yandex.mobile.ads.impl.fk0
    final int a(int i, Object[] objArr) {
        objArr[i] = this.d;
        return i + 1;
    }

    xy1(E e) {
        this.d = (E) rj1.a(e);
    }

    @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.d.equals(obj);
    }

    @Override // com.yandex.mobile.ads.impl.jk0, com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final b82<E> iterator() {
        return new hq0(this.d);
    }

    @Override // com.yandex.mobile.ads.impl.jk0, com.yandex.mobile.ads.impl.fk0
    public final hk0<E> b() {
        return hk0.a(this.d);
    }

    @Override // com.yandex.mobile.ads.impl.jk0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.d.hashCode();
    }
}
