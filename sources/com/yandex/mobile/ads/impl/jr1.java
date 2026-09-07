package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes7.dex */
final class jr1<T> extends ff1<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ff1<? super T> b;

    public final String toString() {
        return this.b + ".reverse()";
    }

    jr1(ff1<? super T> ff1Var) {
        this.b = (ff1) rj1.a(ff1Var);
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return this.b.compare(t2, t);
    }

    @Override // com.yandex.mobile.ads.impl.ff1
    public final <S extends T> ff1<S> b() {
        return this.b;
    }

    public final int hashCode() {
        return -this.b.hashCode();
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jr1) {
            return this.b.equals(((jr1) obj).b);
        }
        return false;
    }
}
