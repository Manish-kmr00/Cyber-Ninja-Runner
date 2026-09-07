package com.yandex.mobile.ads.impl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
final class mc1 extends ff1<Comparable<?>> implements Serializable {
    static final mc1 b = new mc1();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return b;
    }

    @Override // com.yandex.mobile.ads.impl.ff1
    public final <S extends Comparable<?>> ff1<S> b() {
        return ir1.b;
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    private mc1() {
    }
}
