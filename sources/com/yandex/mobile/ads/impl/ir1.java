package com.yandex.mobile.ads.impl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
final class ir1 extends ff1<Comparable<?>> implements Serializable {
    static final ir1 b = new ir1();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return b;
    }

    @Override // com.yandex.mobile.ads.impl.ff1
    public final <S extends Comparable<?>> ff1<S> b() {
        return mc1.b;
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    private ir1() {
    }
}
